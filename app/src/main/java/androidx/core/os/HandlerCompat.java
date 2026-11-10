package androidx.core.os;

import android.os.Build$VERSION;
import android.os.Handler$Callback;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;

public final class HandlerCompat {
    class Api28Impl {
        private Api28Impl() {
            super();
        }

        public static Handler createAsync(Looper arg0) {
            return Handler.createAsync(arg0);
        }

        public static Handler createAsync(Looper arg0, Handler$Callback arg1) {
            return Handler.createAsync(arg0, arg1);
        }

        public static boolean postDelayed(Handler arg0, Runnable arg1, Object arg2, long arg3) {
            return arg0.postDelayed(arg1, arg2, arg3);
        }
    }

    class Api29Impl {
        private Api29Impl() {
            super();
        }

        public static boolean hasCallbacks(Handler arg0, Runnable arg1) {
            return arg0.hasCallbacks(arg1);
        }
    }

    private static final String TAG = "HandlerCompat";

    private HandlerCompat() {
        super();
    }

    public static Handler createAsync(Looper arg5) {
        if(Build$VERSION.SDK_INT >= 28) {
            return Api28Impl.createAsync(arg5);
        }

        try {
            return Handler.class.getDeclaredConstructor(Looper.class, Handler$Callback.class, Boolean.TYPE).newInstance(arg5, null, Boolean.valueOf(true));
        }
        catch(InvocationTargetException v5) {
            Throwable v5_1 = v5.getCause();
            if(!(v5_1 instanceof RuntimeException)) {
                if((v5_1 instanceof Error)) {
                    throw v5_1;
                }

                throw new RuntimeException(v5_1);
            }

            throw v5_1;
        }
        catch(NoSuchMethodException v0) {
        label_39:
            Log.w("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", ((Throwable)v0));
            return new Handler(arg5);
        }
        catch(InstantiationException v0_1) {
            goto label_39;
        }
        catch(IllegalAccessException v0_2) {
            goto label_39;
        }
    }

    public static Handler createAsync(Looper arg5, Handler$Callback arg6) {
        if(Build$VERSION.SDK_INT >= 28) {
            return Api28Impl.createAsync(arg5, arg6);
        }

        try {
            return Handler.class.getDeclaredConstructor(Looper.class, Handler$Callback.class, Boolean.TYPE).newInstance(arg5, arg6, Boolean.valueOf(true));
        }
        catch(InvocationTargetException v5) {
            Throwable v5_1 = v5.getCause();
            if(!(v5_1 instanceof RuntimeException)) {
                if((v5_1 instanceof Error)) {
                    throw v5_1;
                }

                throw new RuntimeException(v5_1);
            }

            throw v5_1;
        }
        catch(NoSuchMethodException v0) {
        label_38:
            Log.w("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", ((Throwable)v0_1));
            return new Handler(arg5, arg6);
        }
        catch(InstantiationException v0_1) {
            goto label_38;
        }
        catch(IllegalAccessException v0_2) {
            goto label_38;
        }
    }

    public static boolean hasCallbacks(Handler arg5, Runnable arg6) {
        if(Build$VERSION.SDK_INT >= 29) {
            return Api29Impl.hasCallbacks(arg5, arg6);
        }

        try {
            return Handler.class.getMethod("hasCallbacks", Runnable.class).invoke(arg5, arg6).booleanValue();
        }
        catch(NullPointerException v5) {
        }
        catch(NoSuchMethodException v5_1) {
        }
        catch(IllegalAccessException v5_2) {
        }
        catch(InvocationTargetException v5_3) {
            Throwable v5_4 = v5_3.getCause();
            if(!(v5_4 instanceof RuntimeException)) {
                if((v5_4 instanceof Error)) {
                    throw v5_4;
                }

                throw new RuntimeException(v5_4);
            }

            throw v5_4;
        }

        throw new UnsupportedOperationException("Failed to call Handler.hasCallbacks(), but there is no safe failure mode for this method. Raising exception.", ((Throwable)v5));
    }

    public static boolean postDelayed(Handler arg2, Runnable arg3, Object arg4, long arg5) {
        if(Build$VERSION.SDK_INT >= 28) {
            return Api28Impl.postDelayed(arg2, arg3, arg4, arg5);
        }

        Message v3 = Message.obtain(arg2, arg3);
        v3.obj = arg4;
        return arg2.sendMessageDelayed(v3, arg5);
    }
}

