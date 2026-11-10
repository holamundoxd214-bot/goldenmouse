package androidx.core.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback$Stub;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;

class UnusedAppRestrictionsBackportServiceConnection implements ServiceConnection {
    private final Context mContext;
    private boolean mHasBoundService;
    ResolvableFuture mResultFuture;
    IUnusedAppRestrictionsBackportService mUnusedAppRestrictionsService;

    UnusedAppRestrictionsBackportServiceConnection(Context arg2) {
        super();
        this.mUnusedAppRestrictionsService = null;
        this.mHasBoundService = false;
        this.mContext = arg2;
    }

    public void connectAndFetchResult(ResolvableFuture arg3) {
        if(!this.mHasBoundService) {
            this.mHasBoundService = true;
            this.mResultFuture = arg3;
            this.mContext.bindService(new Intent("android.support.unusedapprestrictions.action.CustomUnusedAppRestrictionsBackportService").setPackage(PackageManagerCompat.getPermissionRevocationVerifierApp(this.mContext.getPackageManager())), ((ServiceConnection)this), 1);
            return;
        }

        throw new IllegalStateException("Each UnusedAppRestrictionsBackportServiceConnection can only be bound once.");
    }

    public void disconnectFromService() {
        if(this.mHasBoundService) {
            this.mHasBoundService = false;
            this.mContext.unbindService(((ServiceConnection)this));
            return;
        }

        throw new IllegalStateException("bindService must be called before unbind");
    }

    private IUnusedAppRestrictionsBackportCallback getBackportCallback() {
        return new Stub() {
            public int getInterfaceVersion() {
                return 1;
            }

            public void onIsPermissionRevocationEnabledForAppResult(boolean arg1, boolean arg2) throws RemoteException {
                if(arg1) {
                    UnusedAppRestrictionsBackportServiceConnection v0 = UnusedAppRestrictionsBackportServiceConnection.this;
                    if(arg2) {
                        v0.mResultFuture.set(Integer.valueOf(3));
                        return;
                    }

                    v0.mResultFuture.set(Integer.valueOf(2));
                    return;
                }

                UnusedAppRestrictionsBackportServiceConnection.this.mResultFuture.set(Integer.valueOf(0));
                Log.e("PackageManagerCompat", "Unable to retrieve the permission revocation setting from the backport");
            }
        };
    }

    public void onServiceConnected(ComponentName arg1, IBinder arg2) {
        IUnusedAppRestrictionsBackportService v1 = androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService$Stub.asInterface(arg2);
        this.mUnusedAppRestrictionsService = v1;
        try {
            v1.isPermissionRevocationEnabledForApp(this.getBackportCallback());
            return;
        }
        catch(RemoteException ) {
            this.mResultFuture.set(Integer.valueOf(0));
            return;
        }
    }

    public void onServiceDisconnected(ComponentName arg1) {
        this.mUnusedAppRestrictionsService = null;
    }
}

