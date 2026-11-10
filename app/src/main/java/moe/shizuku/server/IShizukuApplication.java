package moe.shizuku.server;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IShizukuApplication extends IInterface {
    public class Default implements IShizukuApplication {
        public Default() {
            super();
        }

        public IBinder asBinder() {
            return null;
        }

        public void bindApplication(Bundle arg1) throws RemoteException {
        }

        public void dispatchRequestPermissionResult(int arg1, Bundle arg2) throws RemoteException {
        }

        public void showPermissionConfirmation(int arg1, int arg2, String arg3, int arg4) throws RemoteException {
        }
    }

    public abstract class Stub extends Binder implements IShizukuApplication {
        class Proxy implements IShizukuApplication {
            private IBinder mRemote;
            public static IShizukuApplication sDefaultImpl;

            Proxy(IBinder arg1) {
                super();
                this.mRemote = arg1;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void bindApplication(Bundle arg5) throws RemoteException {
                Parcel v0 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IShizukuApplication");
                    if(arg5 != null) {
                        v0.writeInt(1);
                        arg5.writeToParcel(v0, 0);
                    }
                    else {
                        v0.writeInt(0);
                    }

                    if(!this.mRemote.transact(2, v0, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().bindApplication(arg5);
                        goto label_19;
                    }

                    goto label_21;
                }
                catch(Throwable v4) {
                    v0.recycle();
                    throw v4;
                }

            label_19:
                v0.recycle();
                return;
            label_21:
                v0.recycle();
            }

            public void dispatchRequestPermissionResult(int arg5, Bundle arg6) throws RemoteException {
                Parcel v0 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IShizukuApplication");
                    v0.writeInt(arg5);
                    if(arg6 != null) {
                        v0.writeInt(1);
                        arg6.writeToParcel(v0, 0);
                    }
                    else {
                        v0.writeInt(0);
                    }

                    if(!this.mRemote.transact(3, v0, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().dispatchRequestPermissionResult(arg5, arg6);
                        goto label_20;
                    }

                    goto label_22;
                }
                catch(Throwable v4) {
                    v0.recycle();
                    throw v4;
                }

            label_20:
                v0.recycle();
                return;
            label_22:
                v0.recycle();
            }

            public String getInterfaceDescriptor() {
                return "moe.shizuku.server.IShizukuApplication";
            }

            public void showPermissionConfirmation(int arg5, int arg6, String arg7, int arg8) throws RemoteException {
                Parcel v0 = Parcel.obtain();
                Parcel v1 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IShizukuApplication");
                    v0.writeInt(arg5);
                    v0.writeInt(arg6);
                    v0.writeString(arg7);
                    v0.writeInt(arg8);
                    if((this.mRemote.transact(10001, v0, v1, 0)) || Stub.getDefaultImpl() == null) {
                        v1.readException();
                    }
                    else {
                        Stub.getDefaultImpl().showPermissionConfirmation(arg5, arg6, arg7, arg8);
                    }
                }
                catch(Throwable v4) {
                    v1.recycle();
                    v0.recycle();
                    throw v4;
                }

                v1.recycle();
                v0.recycle();
            }
        }

        private static final String DESCRIPTOR = "moe.shizuku.server.IShizukuApplication";
        static final int TRANSACTION_bindApplication = 2;
        static final int TRANSACTION_dispatchRequestPermissionResult = 3;
        static final int TRANSACTION_showPermissionConfirmation = 10001;

        public Stub() {
            super();
            this.attachInterface(((IInterface)this), "moe.shizuku.server.IShizukuApplication");
        }

        public IBinder asBinder() {
            return this;
        }

        public static IShizukuApplication asInterface(IBinder arg2) {
            if(arg2 == null) {
                return null;
            }

            IInterface v0 = arg2.queryLocalInterface("moe.shizuku.server.IShizukuApplication");
            if(v0 != null && ((v0 instanceof IShizukuApplication))) {
                return ((IShizukuApplication)v0);
            }

            return new Proxy(arg2);
        }

        public static IShizukuApplication getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public boolean onTransact(int arg5, Parcel arg6, Parcel arg7, int arg8) throws RemoteException {
            Object v1_1;
            Bundle v1 = null;
            String v3 = "moe.shizuku.server.IShizukuApplication";
            if(arg5 != 2) {
                if(arg5 != 3) {
                    if(arg5 != 10001) {
                        if(arg5 != 0x5F4E5446) {
                            return super.onTransact(arg5, arg6, arg7, arg8);
                        }

                        arg7.writeString(v3);
                        return 1;
                    }

                    arg6.enforceInterface(v3);
                    this.showPermissionConfirmation(arg6.readInt(), arg6.readInt(), arg6.readString(), arg6.readInt());
                    arg7.writeNoException();
                    return 1;
                }

                arg6.enforceInterface(v3);
                arg5 = arg6.readInt();
                if(arg6.readInt() != 0) {
                    v1_1 = Bundle.CREATOR.createFromParcel(arg6);
                }

                this.dispatchRequestPermissionResult(arg5, ((Bundle)v1_1));
                return 1;
            }

            arg6.enforceInterface(v3);
            if(arg6.readInt() != 0) {
                v1_1 = Bundle.CREATOR.createFromParcel(arg6);
            }

            this.bindApplication(((Bundle)v1_1));
            return 1;
        }

        public static boolean setDefaultImpl(IShizukuApplication arg1) {
            if(Proxy.sDefaultImpl == null) {
                if(arg1 != null) {
                    Proxy.sDefaultImpl = arg1;
                    return 1;
                }

                return 0;
            }

            throw new IllegalStateException("setDefaultImpl() called twice");
        }
    }

    void bindApplication(Bundle arg1) throws RemoteException;

    void dispatchRequestPermissionResult(int arg1, Bundle arg2) throws RemoteException;

    void showPermissionConfirmation(int arg1, int arg2, String arg3, int arg4) throws RemoteException;
}

