package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IUnusedAppRestrictionsBackportCallback extends IInterface {
    public class Default implements IUnusedAppRestrictionsBackportCallback {
        public Default() {
            super();
        }

        public IBinder asBinder() {
            return null;
        }

        public int getInterfaceVersion() {
            return 0;
        }

        public void onIsPermissionRevocationEnabledForAppResult(boolean arg1, boolean arg2) throws RemoteException {
        }
    }

    public abstract class Stub extends Binder implements IUnusedAppRestrictionsBackportCallback {
        class Proxy implements IUnusedAppRestrictionsBackportCallback {
            private int mCachedVersion;
            private IBinder mRemote;

            Proxy(IBinder arg2) {
                super();
                this.mCachedVersion = -1;
                this.mRemote = arg2;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Proxy.DESCRIPTOR;
            }

            public int getInterfaceVersion() throws RemoteException {
                if(this.mCachedVersion == -1) {
                    Parcel v0 = Parcel.obtain();
                    Parcel v1 = Parcel.obtain();
                    try {
                        v0.writeInterfaceToken(Proxy.DESCRIPTOR);
                        this.mRemote.transact(0xFFFFFF, v0, v1, 0);
                        v1.readException();
                        this.mCachedVersion = v1.readInt();
                    }
                    catch(Throwable v5) {
                        v1.recycle();
                        v0.recycle();
                        throw v5;
                    }

                    v1.recycle();
                    v0.recycle();
                }

                return this.mCachedVersion;
            }

            public void onIsPermissionRevocationEnabledForAppResult(boolean arg3, boolean arg4) throws RemoteException {
                Parcel v0 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken(Proxy.DESCRIPTOR);
                    v0.writeInt(((int)arg3));
                    v0.writeInt(((int)arg4));
                    if(!this.mRemote.transact(1, v0, null, 1)) {
                        goto label_12;
                    }
                }
                catch(Throwable v2) {
                    goto label_17;
                }

                v0.recycle();
                return;
                try {
                label_12:
                    throw new RemoteException("Method onIsPermissionRevocationEnabledForAppResult is unimplemented.");
                }
                catch(Throwable v2) {
                label_17:
                    v0.recycle();
                    throw v2;
                }
            }
        }

        static final int TRANSACTION_getInterfaceVersion = 0xFFFFFF;
        static final int TRANSACTION_onIsPermissionRevocationEnabledForAppResult = 1;

        public Stub() {
            super();
            this.attachInterface(((IInterface)this), Stub.DESCRIPTOR);
        }

        public IBinder asBinder() {
            return this;
        }

        public static IUnusedAppRestrictionsBackportCallback asInterface(IBinder arg2) {
            if(arg2 == null) {
                return null;
            }

            IInterface v0 = arg2.queryLocalInterface(Stub.DESCRIPTOR);
            if(v0 != null && ((v0 instanceof IUnusedAppRestrictionsBackportCallback))) {
                return ((IUnusedAppRestrictionsBackportCallback)v0);
            }

            return new Proxy(arg2);
        }

        public boolean onTransact(int arg5, Parcel arg6, Parcel arg7, int arg8) throws RemoteException {
            String v0 = Stub.DESCRIPTOR;
            int v1 = 0xFFFFFF;
            if(arg5 >= 1 && arg5 <= v1) {
                arg6.enforceInterface(v0);
            }

            if(arg5 == 0x5F4E5446) {
                arg7.writeString(v0);
                return 1;
            }

            if(arg5 == v1) {
                arg7.writeNoException();
                arg7.writeInt(this.getInterfaceVersion());
                return 1;
            }

            if(arg5 != 1) {
                return super.onTransact(arg5, arg6, arg7, arg8);
            }

            boolean v7 = false;
            boolean v5 = arg6.readInt() != 0 ? true : false;
            if(arg6.readInt() != 0) {
                v7 = true;
            }

            this.onIsPermissionRevocationEnabledForAppResult(v5, v7);
            return 1;
        }
    }

    public static final String DESCRIPTOR = null;
    public static final int VERSION = 1;

    static {
        IUnusedAppRestrictionsBackportCallback.DESCRIPTOR = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportCallback".replace('$', '.');
    }

    int getInterfaceVersion() throws RemoteException;

    void onIsPermissionRevocationEnabledForAppResult(boolean arg1, boolean arg2) throws RemoteException;
}

