package moe.shizuku.server;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IShizukuServiceConnection extends IInterface {
    public class Default implements IShizukuServiceConnection {
        public Default() {
            super();
        }

        public IBinder asBinder() {
            return null;
        }

        public void connected(IBinder arg1) throws RemoteException {
        }

        public void died() throws RemoteException {
        }
    }

    public abstract class Stub extends Binder implements IShizukuServiceConnection {
        class Proxy implements IShizukuServiceConnection {
            private IBinder mRemote;
            public static IShizukuServiceConnection sDefaultImpl;

            Proxy(IBinder arg1) {
                super();
                this.mRemote = arg1;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void connected(IBinder arg4) throws RemoteException {
                Parcel v0 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IShizukuServiceConnection");
                    v0.writeStrongBinder(arg4);
                    if(!this.mRemote.transact(1, v0, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().connected(arg4);
                        goto label_13;
                    }

                    goto label_15;
                }
                catch(Throwable v3) {
                    v0.recycle();
                    throw v3;
                }

            label_13:
                v0.recycle();
                return;
            label_15:
                v0.recycle();
            }

            public void died() throws RemoteException {
                Parcel v0 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IShizukuServiceConnection");
                    if(!this.mRemote.transact(2, v0, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().died();
                        goto label_13;
                    }

                    goto label_15;
                }
                catch(Throwable v4) {
                    v0.recycle();
                    throw v4;
                }

            label_13:
                v0.recycle();
                return;
            label_15:
                v0.recycle();
            }

            public String getInterfaceDescriptor() {
                return "moe.shizuku.server.IShizukuServiceConnection";
            }
        }

        private static final String DESCRIPTOR = "moe.shizuku.server.IShizukuServiceConnection";
        static final int TRANSACTION_connected = 1;
        static final int TRANSACTION_died = 2;

        public Stub() {
            super();
            this.attachInterface(((IInterface)this), "moe.shizuku.server.IShizukuServiceConnection");
        }

        public IBinder asBinder() {
            return this;
        }

        public static IShizukuServiceConnection asInterface(IBinder arg2) {
            if(arg2 == null) {
                return null;
            }

            IInterface v0 = arg2.queryLocalInterface("moe.shizuku.server.IShizukuServiceConnection");
            if(v0 != null && ((v0 instanceof IShizukuServiceConnection))) {
                return ((IShizukuServiceConnection)v0);
            }

            return new Proxy(arg2);
        }

        public static IShizukuServiceConnection getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public boolean onTransact(int arg4, Parcel arg5, Parcel arg6, int arg7) throws RemoteException {
            String v0 = "moe.shizuku.server.IShizukuServiceConnection";
            if(arg4 != 1) {
                if(arg4 != 2) {
                    if(arg4 != 0x5F4E5446) {
                        return super.onTransact(arg4, arg5, arg6, arg7);
                    }

                    arg6.writeString(v0);
                    return 1;
                }

                arg5.enforceInterface(v0);
                this.died();
                return 1;
            }

            arg5.enforceInterface(v0);
            this.connected(arg5.readStrongBinder());
            return 1;
        }

        public static boolean setDefaultImpl(IShizukuServiceConnection arg1) {
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

    void connected(IBinder arg1) throws RemoteException;

    void died() throws RemoteException;
}

