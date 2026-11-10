package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback$OnSharedElementsReadyListener;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender$SendIntentException;
import android.content.IntentSender;
import android.content.LocusId;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Display;
import android.view.DragEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.view.DragAndDropPermissionsCompat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class ActivityCompat extends ContextCompat {
    class Api28Impl {
        private Api28Impl() {
            super();
        }

        static Object requireViewById(Activity arg0, int arg1) {
            return arg0.requireViewById(arg1);
        }
    }

    class Api30Impl {
        private Api30Impl() {
            super();
        }

        static Display getDisplay(ContextWrapper arg0) {
            return arg0.getDisplay();
        }

        static void setLocusContext(Activity arg0, LocusIdCompat arg1, Bundle arg2) {
            LocusId v1 = arg1 == null ? null : arg1.toLocusId();
            arg0.setLocusContext(v1, arg2);
        }
    }

    class Api31Impl {
        private Api31Impl() {
            super();
        }

        static boolean isLaunchedFromBubble(Activity arg0) {
            return arg0.isLaunchedFromBubble();
        }

        static boolean shouldShowRequestPermissionRationale(Activity arg6, String arg7) {
            boolean v6;
            try {
                v6 = PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(arg6.getApplication().getPackageManager(), arg7).booleanValue();
                return v6;
            }
            catch(IllegalAccessException ) {
                return ((Activity)v6).shouldShowRequestPermissionRationale(arg7);
            }
        }
    }

    class Api32Impl {
        private Api32Impl() {
            super();
        }

        static boolean shouldShowRequestPermissionRationale(Activity arg0, String arg1) {
            return arg0.shouldShowRequestPermissionRationale(arg1);
        }
    }

    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int arg1, String[] arg2, int[] arg3);
    }

    public interface PermissionCompatDelegate {
        @Deprecated boolean onActivityResult(Activity arg1, int arg2, int arg3, Intent arg4);

        boolean requestPermissions(Activity arg1, String[] arg2, int arg3);
    }

    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int arg1);
    }

    class SharedElementCallback21Impl extends SharedElementCallback {
        private final androidx.core.app.SharedElementCallback mCallback;

        SharedElementCallback21Impl(androidx.core.app.SharedElementCallback arg1) {
            super();
            this.mCallback = arg1;
        }

        public Parcelable onCaptureSharedElementSnapshot(View arg1, Matrix arg2, RectF arg3) {
            return this.mCallback.onCaptureSharedElementSnapshot(arg1, arg2, arg3);
        }

        public View onCreateSnapshotView(Context arg1, Parcelable arg2) {
            return this.mCallback.onCreateSnapshotView(arg1, arg2);
        }

        public void onMapSharedElements(List arg1, Map arg2) {
            this.mCallback.onMapSharedElements(arg1, arg2);
        }

        public void onRejectSharedElements(List arg1) {
            this.mCallback.onRejectSharedElements(arg1);
        }

        public void onSharedElementEnd(List arg1, List arg2, List arg3) {
            this.mCallback.onSharedElementEnd(arg1, arg2, arg3);
        }

        public void onSharedElementStart(List arg1, List arg2, List arg3) {
            this.mCallback.onSharedElementStart(arg1, arg2, arg3);
        }

        public void onSharedElementsArrived(List arg2, List arg3, SharedElementCallback$OnSharedElementsReadyListener arg4) {
            androidx.core.app.SharedElementCallback v1 = this.mCallback;
            Objects.requireNonNull(arg4);
            v1.onSharedElementsArrived(arg2, arg3, new ActivityCompat$SharedElementCallback21Impl$$ExternalSyntheticLambda0(arg4));
        }
    }

    private static PermissionCompatDelegate sDelegate;

    protected ActivityCompat() {
        super();
    }

    public static void finishAffinity(Activity arg0) {
        arg0.finishAffinity();
    }

    public static void finishAfterTransition(Activity arg0) {
        arg0.finishAfterTransition();
    }

    public static PermissionCompatDelegate getPermissionCompatDelegate() {
        return ActivityCompat.sDelegate;
    }

    public static Uri getReferrer(Activity arg0) {
        return arg0.getReferrer();
    }

    @Deprecated public static boolean invalidateOptionsMenu(Activity arg0) {
        arg0.invalidateOptionsMenu();
        return 1;
    }

    public static boolean isLaunchedFromBubble(Activity arg4) {
        if(Build$VERSION.SDK_INT >= 0x1F) {
            return Api31Impl.isLaunchedFromBubble(arg4);
        }

        if(Build$VERSION.SDK_INT == 30) {
            if(Api30Impl.getDisplay(((ContextWrapper)arg4)) != null && Api30Impl.getDisplay(((ContextWrapper)arg4)).getDisplayId() != 0) {
                return 1;
            }

            return 0;
        }

        if(Build$VERSION.SDK_INT == 29 && arg4.getWindowManager().getDefaultDisplay() != null && arg4.getWindowManager().getDefaultDisplay().getDisplayId() != 0) {
            return 1;
        }

        return 0;
    }

    static void lambda$recreate$0(Activity arg1) {
        if(!arg1.isFinishing() && !ActivityRecreator.recreate(arg1)) {
            arg1.recreate();
        }
    }

    public static void postponeEnterTransition(Activity arg0) {
        arg0.postponeEnterTransition();
    }

    public static void recreate(Activity arg2) {
        if(Build$VERSION.SDK_INT >= 28) {
            arg2.recreate();
            return;
        }

        new Handler(arg2.getMainLooper()).post(new ActivityCompat$$ExternalSyntheticLambda0(arg2));
    }

    public static DragAndDropPermissionsCompat requestDragAndDropPermissions(Activity arg0, DragEvent arg1) {
        return DragAndDropPermissionsCompat.request(arg0, arg1);
    }

    public static void requestPermissions(Activity arg6, String[] arg7, int arg8) {
        PermissionCompatDelegate v0 = ActivityCompat.sDelegate;
        if(v0 == null || !v0.requestPermissions(arg6, arg7, arg8)) {
            HashSet v0_1 = new HashSet();
            int v1 = 0;
            int v2 = 0;
            while(true) {
                if(v2 >= arg7.length) {
                    goto label_36;
                }
                else if(!TextUtils.isEmpty(arg7[v2])) {
                    if(Build$VERSION.SDK_INT < 33 && (TextUtils.equals(arg7[v2], "android.permission.POST_NOTIFICATIONS"))) {
                        ((Set)v0_1).add(Integer.valueOf(v2));
                    }

                    ++v2;
                    continue;
                }
                else {
                    break;
                }
            }

            throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(((Object[])arg7)) + " must not contain null or empty values");
        label_36:
            v2 = ((Set)v0_1).size();
            String[] v3 = v2 > 0 ? new String[arg7.length - v2] : arg7;
            if(v2 > 0) {
                if(v2 != arg7.length) {
                    v2 = 0;
                    while(true) {
                        if(v1 < arg7.length) {
                            if(!((Set)v0_1).contains(Integer.valueOf(v1))) {
                                v3[v2] = arg7[v1];
                                ++v2;
                            }

                            ++v1;
                            continue;
                        }

                        goto label_59;
                    }
                }
                else {
                    return;
                }
            }

            goto label_59;
        }
        else {
        }

        return;
    label_59:
        if((arg6 instanceof RequestPermissionsRequestCodeValidator)) {
            arg6.validateRequestPermissionsRequestCode(arg8);
        }

        arg6.requestPermissions(arg7, arg8);
    }

    public static View requireViewById(Activity arg2, int arg3) {
        if(Build$VERSION.SDK_INT >= 28) {
            return Api28Impl.requireViewById(arg2, arg3);
        }

        View v2 = arg2.findViewById(arg3);
        if(v2 != null) {
            return v2;
        }

        throw new IllegalArgumentException("ID does not reference a View inside this Activity");
    }

    public static void setEnterSharedElementCallback(Activity arg1, androidx.core.app.SharedElementCallback arg2) {
        SharedElementCallback21Impl v0;
        if(arg2 != null) {
            v0 = new SharedElementCallback21Impl(arg2);
        }
        else {
            SharedElementCallback v0_1 = null;
        }

        arg1.setEnterSharedElementCallback(((SharedElementCallback)v0));
    }

    public static void setExitSharedElementCallback(Activity arg1, androidx.core.app.SharedElementCallback arg2) {
        SharedElementCallback21Impl v0;
        if(arg2 != null) {
            v0 = new SharedElementCallback21Impl(arg2);
        }
        else {
            SharedElementCallback v0_1 = null;
        }

        arg1.setExitSharedElementCallback(((SharedElementCallback)v0));
    }

    public static void setLocusContext(Activity arg2, LocusIdCompat arg3, Bundle arg4) {
        if(Build$VERSION.SDK_INT >= 30) {
            Api30Impl.setLocusContext(arg2, arg3, arg4);
        }
    }

    public static void setPermissionCompatDelegate(PermissionCompatDelegate arg0) {
        ActivityCompat.sDelegate = arg0;
    }

    public static boolean shouldShowRequestPermissionRationale(Activity arg2, String arg3) {
        if(Build$VERSION.SDK_INT < 33 && (TextUtils.equals("android.permission.POST_NOTIFICATIONS", ((CharSequence)arg3)))) {
            return 0;
        }

        if(Build$VERSION.SDK_INT >= 0x20) {
            return Api32Impl.shouldShowRequestPermissionRationale(arg2, arg3);
        }

        if(Build$VERSION.SDK_INT == 0x1F) {
            return Api31Impl.shouldShowRequestPermissionRationale(arg2, arg3);
        }

        return arg2.shouldShowRequestPermissionRationale(arg3);
    }

    public static void startActivityForResult(Activity arg0, Intent arg1, int arg2, Bundle arg3) {
        arg0.startActivityForResult(arg1, arg2, arg3);
    }

    public static void startIntentSenderForResult(Activity arg0, IntentSender arg1, int arg2, Intent arg3, int arg4, int arg5, int arg6, Bundle arg7) throws IntentSender$SendIntentException {
        arg0.startIntentSenderForResult(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static void startPostponedEnterTransition(Activity arg0) {
        arg0.startPostponedEnterTransition();
    }
}

