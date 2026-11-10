package rikka.sui;

import android.os.IBinder;
import android.os.Parcel;
import rikka.shizuku.Shizuku;
import rikka.shizuku.SystemServiceHelper;

public class Sui {
    private static final int BRIDGE_ACTION_GET_BINDER = 2;
    private static final String BRIDGE_SERVICE_DESCRIPTOR = "android.app.IActivityManager";
    private static final String BRIDGE_SERVICE_NAME = "activity";
    private static final int BRIDGE_TRANSACTION_CODE = 0x5F535549;
    private static boolean isSui;

    public Sui() {
        super();
    }

    public static boolean init(String arg1) {
        IBinder v0 = Sui.requestBinder();
        if(v0 != null) {
            Shizuku.onBinderReceived(v0, arg1);
            Sui.isSui = true;
            return 1;
        }

        Sui.isSui = false;
        return 0;
    }

    public static boolean isSui() {
        return Sui.isSui;
    }

    private static IBinder requestBinder() {
        IBinder v0 = SystemServiceHelper.getSystemService("activity");
        IBinder v1 = null;
        if(v0 == null) {
            return v1;
        }

        Parcel v2 = Parcel.obtain();
        Parcel v3 = Parcel.obtain();
        try {
            v2.writeInterfaceToken("android.app.IActivityManager");
            v2.writeInt(2);
            v0.transact(0x5F535549, v2, v3, 0);
            v3.readException();
            v0 = v3.readStrongBinder();
            if(v0 == null) {
                goto label_22;
            }
        }
        catch(Throwable v0_1) {
            try {
                v0_1.printStackTrace();
                goto label_22;
            }
            catch(Throwable v0_1) {
                v2.recycle();
                v3.recycle();
                throw v0_1;
            }
        }

        v2.recycle();
        v3.recycle();
        return v0;
    label_22:
        v2.recycle();
        v3.recycle();
        return v1;
    }
}

