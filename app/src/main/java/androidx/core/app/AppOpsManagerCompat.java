package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build$VERSION;

public final class AppOpsManagerCompat {
    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static int checkOpNoThrow(AppOpsManager arg0, String arg1, int arg2, String arg3) {
            if(arg0 == null) {
                return 1;
            }

            return arg0.checkOpNoThrow(arg1, arg2, arg3);
        }

        static String getOpPackageName(Context arg0) {
            return arg0.getOpPackageName();
        }

        static AppOpsManager getSystemService(Context arg1) {
            return arg1.getSystemService(AppOpsManager.class);
        }
    }

    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_ERRORED = 2;
    public static final int MODE_IGNORED = 1;

    private AppOpsManagerCompat() {
        super();
    }

    public static int checkOrNoteProxyOp(Context arg2, int arg3, String arg4, String arg5) {
        if(Build$VERSION.SDK_INT >= 29) {
            AppOpsManager v0 = Api29Impl.getSystemService(arg2);
            int v5 = Api29Impl.checkOpNoThrow(v0, arg4, Binder.getCallingUid(), arg5);
            if(v5 != 0) {
                return v5;
            }

            return Api29Impl.checkOpNoThrow(v0, arg4, arg3, Api29Impl.getOpPackageName(arg2));
        }

        return AppOpsManagerCompat.noteProxyOpNoThrow(arg2, arg4, arg5);
    }

    public static int noteOp(Context arg1, String arg2, int arg3, String arg4) {
        return arg1.getSystemService("appops").noteOp(arg2, arg3, arg4);
    }

    public static int noteOpNoThrow(Context arg1, String arg2, int arg3, String arg4) {
        return arg1.getSystemService("appops").noteOpNoThrow(arg2, arg3, arg4);
    }

    public static int noteProxyOp(Context arg1, String arg2, String arg3) {
        return arg1.getSystemService(AppOpsManager.class).noteProxyOp(arg2, arg3);
    }

    public static int noteProxyOpNoThrow(Context arg1, String arg2, String arg3) {
        return arg1.getSystemService(AppOpsManager.class).noteProxyOpNoThrow(arg2, arg3);
    }

    public static String permissionToOp(String arg0) {
        return AppOpsManager.permissionToOp(arg0);
    }
}

