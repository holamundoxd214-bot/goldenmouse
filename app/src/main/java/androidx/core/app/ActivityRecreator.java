package androidx.core.app;

import android.app.Activity;
import android.app.Application$ActivityLifecycleCallbacks;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

final class ActivityRecreator {
    final class LifecycleCheckCallbacks implements Application$ActivityLifecycleCallbacks {
        Object currentlyRecreatingToken;
        private Activity mActivity;
        private boolean mDestroyed;
        private final int mRecreatingHashCode;
        private boolean mStarted;
        private boolean mStopQueued;

        LifecycleCheckCallbacks(Activity arg2) {
            super();
            this.mStarted = false;
            this.mDestroyed = false;
            this.mStopQueued = false;
            this.mActivity = arg2;
            this.mRecreatingHashCode = arg2.hashCode();
        }

        public void onActivityCreated(Activity arg1, Bundle arg2) {
        }

        public void onActivityDestroyed(Activity arg2) {
            if(this.mActivity == arg2) {
                this.mActivity = null;
                this.mDestroyed = true;
            }
        }

        public void onActivityPaused(Activity arg3) {
            if((this.mDestroyed) && !this.mStopQueued && !this.mStarted && (ActivityRecreator.queueOnStopIfNecessary(this.currentlyRecreatingToken, this.mRecreatingHashCode, arg3))) {
                this.mStopQueued = true;
                this.currentlyRecreatingToken = null;
            }
        }

        public void onActivityResumed(Activity arg1) {
        }

        public void onActivitySaveInstanceState(Activity arg1, Bundle arg2) {
        }

        public void onActivityStarted(Activity arg2) {
            if(this.mActivity == arg2) {
                this.mStarted = true;
            }
        }

        public void onActivityStopped(Activity arg1) {
        }
    }

    private static final String LOG_TAG = "ActivityRecreator";
    protected static final Class activityThreadClass;
    private static final Handler mainHandler;
    protected static final Field mainThreadField;
    protected static final Method performStopActivity2ParamsMethod;
    protected static final Method performStopActivity3ParamsMethod;
    protected static final Method requestRelaunchActivityMethod;
    protected static final Field tokenField;

    static {
        ActivityRecreator.mainHandler = new Handler(Looper.getMainLooper());
        Class v0 = ActivityRecreator.getActivityThreadClass();
        ActivityRecreator.activityThreadClass = v0;
        ActivityRecreator.mainThreadField = ActivityRecreator.getMainThreadField();
        ActivityRecreator.tokenField = ActivityRecreator.getTokenField();
        ActivityRecreator.performStopActivity3ParamsMethod = ActivityRecreator.getPerformStopActivity3Params(v0);
        ActivityRecreator.performStopActivity2ParamsMethod = ActivityRecreator.getPerformStopActivity2Params(v0);
        ActivityRecreator.requestRelaunchActivityMethod = ActivityRecreator.getRequestRelaunchActivityMethod(v0);
    }

    private ActivityRecreator() {
        super();
    }

    private static Class getActivityThreadClass() {
        try {
            return Class.forName("android.app.ActivityThread");
        }
        catch(Throwable ) {
            return null;
        }
    }

    private static Field getMainThreadField() {
        try {
            Field v0 = Activity.class.getDeclaredField("mMainThread");
            v0.setAccessible(true);
            return v0;
        }
        catch(Throwable ) {
            return null;
        }
    }

    private static Method getPerformStopActivity2Params(Class arg5) {
        Method v0 = null;
        if(arg5 == null) {
            return v0;
        }

        try {
            Method v5 = arg5.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            v5.setAccessible(true);
            return v5;
        }
        catch(Throwable ) {
            return v0;
        }
    }

    private static Method getPerformStopActivity3Params(Class arg6) {
        Method v0 = null;
        if(arg6 == null) {
            return v0;
        }

        try {
            Method v6 = arg6.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            v6.setAccessible(true);
            return v6;
        }
        catch(Throwable ) {
            return v0;
        }
    }

    private static Method getRequestRelaunchActivityMethod(Class arg6) {
        Method v1 = null;
        if(ActivityRecreator.needsRelaunchCall()) {
            if(arg6 == null) {
            }
            else {
                try {
                    Class[] v2 = new Class[9];
                    v2[0] = IBinder.class;
                    Class v3 = List.class;
                    v2[1] = v3;
                    v2[2] = v3;
                    v2[3] = Integer.TYPE;
                    v2[4] = Boolean.TYPE;
                    v3 = Configuration.class;
                    v2[5] = v3;
                    v2[6] = v3;
                    v2[7] = Boolean.TYPE;
                    v2[8] = Boolean.TYPE;
                    Method v6 = arg6.getDeclaredMethod("requestRelaunchActivity", v2);
                    v6.setAccessible(true);
                    return v6;
                }
                catch(Throwable ) {
                    return v1;
                }
            }
        }

        return v1;
    }

    private static Field getTokenField() {
        try {
            Field v0 = Activity.class.getDeclaredField("mToken");
            v0.setAccessible(true);
            return v0;
        }
        catch(Throwable ) {
            return null;
        }
    }

    private static boolean needsRelaunchCall() {
        if(Build$VERSION.SDK_INT != 26) {
            if(Build$VERSION.SDK_INT == 27) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    protected static boolean queueOnStopIfNecessary(Object arg2, int arg3, Activity arg4) {
        try {
            Object v1 = ActivityRecreator.tokenField.get(arg4);
            if(v1 == arg2) {
                if(arg4.hashCode() != arg3) {
                }
                else {
                    ActivityRecreator.mainHandler.postAtFrontOfQueue(new Runnable(ActivityRecreator.mainThreadField.get(arg4), v1) {
                        public void run() {
                            try {
                                if(ActivityRecreator.performStopActivity3ParamsMethod != null) {
                                    ActivityRecreator.performStopActivity3ParamsMethod.invoke(this.val$activityThread, this.val$token, Boolean.valueOf(false), "AppCompat recreation");
                                    return;
                                }

                                ActivityRecreator.performStopActivity2ParamsMethod.invoke(this.val$activityThread, this.val$token, Boolean.valueOf(false));
                                return;
                            }
                            catch(Throwable v4) {
                                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", v4);
                            }
                            catch(RuntimeException v4_1) {
                                if(v4_1.getClass() != RuntimeException.class) {
                                    return;
                                }

                                if(v4_1.getMessage() == null) {
                                    return;
                                }

                                if(!v4_1.getMessage().startsWith("Unable to stop")) {
                                    return;
                                }

                                throw v4_1;
                            }
                        }
                    });
                    return 1;
                }
            }
        }
        catch(Throwable v2) {
            Log.e("ActivityRecreator", "Exception while fetching field values", v2);
            return 0;
        }

        return 0;
    }

    static boolean recreate(Activity arg15) {
        Handler v14;
        LifecycleCheckCallbacks v13;
        Application v12;
        Object v0;
        Object v3;
        if(Build$VERSION.SDK_INT >= 28) {
            arg15.recreate();
            return 1;
        }

        if((ActivityRecreator.needsRelaunchCall()) && ActivityRecreator.requestRelaunchActivityMethod == null) {
            return 0;
        }

        if(ActivityRecreator.performStopActivity2ParamsMethod == null && ActivityRecreator.performStopActivity3ParamsMethod == null) {
            return 0;
        }

        try {
            v3 = ActivityRecreator.tokenField.get(arg15);
            if(v3 == null) {
                return 0;
            }

            v0 = ActivityRecreator.mainThreadField.get(arg15);
            if(v0 == null) {
                return 0;
            }

            v12 = arg15.getApplication();
            v13 = new LifecycleCheckCallbacks(arg15);
            v12.registerActivityLifecycleCallbacks(((Application$ActivityLifecycleCallbacks)v13));
            v14 = ActivityRecreator.mainHandler;
            v14.post(new Runnable(v13, v3) {
                public void run() {
                    this.val$callbacks.currentlyRecreatingToken = this.val$token;
                }
            });
        }
        catch(Throwable ) {
            return 0;
        }

        try {
            if(ActivityRecreator.needsRelaunchCall()) {
                ActivityRecreator.requestRelaunchActivityMethod.invoke(v0, v3, null, null, Integer.valueOf(0), Boolean.valueOf(false), null, null, Boolean.valueOf(false), Boolean.valueOf(false));
            }
            else {
                arg15.recreate();
            }

            goto label_48;
        }
        catch(Throwable v0_1) {
            try {
                ActivityRecreator.mainHandler.post(new Runnable(v12, v13) {
                    public void run() {
                        this.val$application.unregisterActivityLifecycleCallbacks(this.val$callbacks);
                    }
                });
                throw v0_1;
            label_48:
                v14.post(new Runnable(v12, v13) {
                    public void run() {
                        this.val$application.unregisterActivityLifecycleCallbacks(this.val$callbacks);
                    }
                });
                return 1;
            }
            catch(Throwable ) {
                return 0;
            }
        }
    }
}

