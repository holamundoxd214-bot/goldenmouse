package androidx.core.content;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import androidx.core.app.AppOpsManagerCompat;
import androidx.core.util.ObjectsCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class PermissionChecker {
    @Retention(value=RetentionPolicy.SOURCE) @public interface PermissionResult {
    }

    public static final int PERMISSION_DENIED = -1;
    public static final int PERMISSION_DENIED_APP_OP = -2;
    public static final int PERMISSION_GRANTED;

    private PermissionChecker() {
        super();
    }

    public static int checkCallingOrSelfPermission(Context arg3, String arg4) {
        String v0 = Binder.getCallingPid() == Process.myPid() ? arg3.getPackageName() : null;
        return PermissionChecker.checkPermission(arg3, arg4, Binder.getCallingPid(), Binder.getCallingUid(), v0);
    }

    public static int checkCallingPermission(Context arg2, String arg3, String arg4) {
        if(Binder.getCallingPid() == Process.myPid()) {
            return -1;
        }

        return PermissionChecker.checkPermission(arg2, arg3, Binder.getCallingPid(), Binder.getCallingUid(), arg4);
    }

    public static int checkPermission(Context arg2, String arg3, int arg4, int arg5, String arg6) {
        int v0 = -1;
        if(arg2.checkPermission(arg3, arg4, arg5) == v0) {
            return v0;
        }

        arg3 = AppOpsManagerCompat.permissionToOp(arg3);
        if(arg3 == null) {
            return 0;
        }

        if(arg6 == null) {
            String[] v6 = arg2.getPackageManager().getPackagesForUid(arg5);
            if(v6 != null) {
                if(v6.length <= 0) {
                }
                else {
                    arg6 = v6[0];
                    goto label_18;
                }
            }

            return v0;
        }

    label_18:
        v0 = Process.myUid();
        String v1 = arg2.getPackageName();
        int v2 = v0 != arg5 || !ObjectsCompat.equals(v1, arg6) ? AppOpsManagerCompat.noteProxyOpNoThrow(arg2, arg3, arg6) : AppOpsManagerCompat.checkOrNoteProxyOp(arg2, arg5, arg3, arg6);
        if(v2 == 0) {
            return 0;
        }

        return -2;
    }

    public static int checkSelfPermission(Context arg3, String arg4) {
        return PermissionChecker.checkPermission(arg3, arg4, Process.myPid(), Process.myUid(), arg3.getPackageName());
    }
}

