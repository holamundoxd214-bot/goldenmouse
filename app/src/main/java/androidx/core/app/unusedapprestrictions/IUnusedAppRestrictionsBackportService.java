package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IUnusedAppRestrictionsBackportService extends IInterface {
    public class Default implements IUnusedAppRestrictionsBackportService {
        public Default() {
            super();
        }

        public IBinder asBinder() {
            return null;
        }

        public int getInterfaceVersion() {
            return 0;
        }

        public void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback arg1) throws RemoteException {
        }
    }

    public abstract class Stub extends Binder implements IUnusedAppRestrictionsBackportService {
        class Proxy implements IUnusedAppRestrictionsBackportService {
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

            public void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback arg3) throws RemoteException {
                Parcel v0 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken(Proxy.DESCRIPTOR);
                    v0.writeStrongInterface(((IInterface)arg3));
                    if(!this.mRemote.transact(1, v0, null, 1)) {
                        goto label_11;
                    }
                }
                catch(Throwable v2) {
                    goto label_16;
                }

                v0.recycle();
                return;
                try {
                label_11:
                    throw new RemoteException("Method isPermissionRevocationEnabledForApp is unimplemented.");
                }
                catch(Throwable v2) {
                label_16:
                    v0.recycle();
                    throw v2;
                }
            }
        }

        static final int TRANSACTION_getInterfaceVersion = 0xFFFFFF;
        static final int TRANSACTION_isPermissionRevocationEnabledForApp = 1;

        public Stub() {
            super();
            this.attachInterface(((IInterface)this), Stub.DESCRIPTOR);
        }

        public IBinder asBinder() {
            return this;
        }

        public static IUnusedAppRestrictionsBackportService asInterface(IBinder arg2) {
            if(arg2 == null) {
                return null;
            }

            IInterface v0 = arg2.queryLocalInterface(Stub.DESCRIPTOR);
            if(v0 != null && ((v0 instanceof IUnusedAppRestrictionsBackportService))) {
                return ((IUnusedAppRestrictionsBackportService)v0);
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

            this.isPermissionRevocationEnabledForApp(androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback$Stub.asInterface(arg6.readStrongBinder()));
            return 1;
        }
    }

    public static final String DESCRIPTOR = null;
    public static final int VERSION = 1;

    static {
        IUnusedAppRestrictionsBackportService.DESCRIPTOR = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportService".replace('$', '.');
    }

    int getInterfaceVersion() throws RemoteException;

    void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback arg1) throws RemoteException;
}

