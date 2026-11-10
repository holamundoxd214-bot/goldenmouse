package androidx.core.content;

import android.os.RemoteException;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;

public class UnusedAppRestrictionsBackportCallback {
    private IUnusedAppRestrictionsBackportCallback mCallback;

    public UnusedAppRestrictionsBackportCallback(IUnusedAppRestrictionsBackportCallback arg1) {
        super();
        this.mCallback = arg1;
    }

    public void onResult(boolean arg1, boolean arg2) throws RemoteException {
        this.mCallback.onIsPermissionRevocationEnabledForAppResult(arg1, arg2);
    }
}

