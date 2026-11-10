package androidx.core.content;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService$Stub;

public abstract class UnusedAppRestrictionsBackportService extends Service {
    class androidx.core.content.UnusedAppRestrictionsBackportService$1 extends Stub {
        androidx.core.content.UnusedAppRestrictionsBackportService$1(UnusedAppRestrictionsBackportService arg1) {
            UnusedAppRestrictionsBackportService.this = arg1;
            super();
        }

        public int getInterfaceVersion() {
            return 1;
        }

        public void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback arg2) throws RemoteException {
            if(arg2 == null) {
                return;
            }

            UnusedAppRestrictionsBackportService.this.isPermissionRevocationEnabled(new UnusedAppRestrictionsBackportCallback(arg2));
        }
    }

    public static final String ACTION_UNUSED_APP_RESTRICTIONS_BACKPORT_CONNECTION = "android.support.unusedapprestrictions.action.CustomUnusedAppRestrictionsBackportService";
    private Stub mBinder;

    public UnusedAppRestrictionsBackportService() {
        super();
        this.mBinder = new androidx.core.content.UnusedAppRestrictionsBackportService$1(this);
    }

    protected abstract void isPermissionRevocationEnabled(UnusedAppRestrictionsBackportCallback arg1);

    public IBinder onBind(Intent arg1) {
        return this.mBinder;
    }
}

