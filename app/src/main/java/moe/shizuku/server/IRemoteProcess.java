package moe.shizuku.server;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

public interface IRemoteProcess extends IInterface {
    public class Default implements IRemoteProcess {
        public Default() {
            super();
        }

        public boolean alive() throws RemoteException {
            return 0;
        }

        public IBinder asBinder() {
            return null;
        }

        public void destroy() throws RemoteException {
        }

        public int exitValue() throws RemoteException {
            return 0;
        }

        public ParcelFileDescriptor getErrorStream() throws RemoteException {
            return null;
        }

        public ParcelFileDescriptor getInputStream() throws RemoteException {
            return null;
        }

        public ParcelFileDescriptor getOutputStream() throws RemoteException {
            return null;
        }

        public int waitFor() throws RemoteException {
            return 0;
        }

        public boolean waitForTimeout(long arg1, String arg3) throws RemoteException {
            return 0;
        }
    }

    public abstract class Stub extends Binder implements IRemoteProcess {
        class Proxy implements IRemoteProcess {
            private IBinder mRemote;
            public static IRemoteProcess sDefaultImpl;

            Proxy(IBinder arg1) {
                super();
                this.mRemote = arg1;
            }

            public boolean alive() throws RemoteException {
                boolean v4_1;
                boolean v3;
                Parcel v0 = Parcel.obtain();
                Parcel v1 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IRemoteProcess");
                    v3 = false;
                    if(!this.mRemote.transact(7, v0, v1, 0) && Stub.getDefaultImpl() != null) {
                        v4_1 = Stub.getDefaultImpl().alive();
                        goto label_13;
                    }

                    goto label_16;
                }
                catch(Throwable v4) {
                    goto label_24;
                }

            label_13:
                v1.recycle();
                v0.recycle();
                return v4_1;
                try {
                label_16:
                    v1.readException();
                    if(v1.readInt() == 0) {
                        goto label_20;
                    }
                }
                catch(Throwable v4) {
                label_24:
                    v1.recycle();
                    v0.recycle();
                    throw v4;
                }

                v3 = true;
            label_20:
                v1.recycle();
                v0.recycle();
                return v3;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void destroy() throws RemoteException {
                Parcel v0 = Parcel.obtain();
                Parcel v1 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IRemoteProcess");
                    if((this.mRemote.transact(6, v0, v1, 0)) || Stub.getDefaultImpl() == null) {
                        v1.readException();
                    }
                    else {
                        Stub.getDefaultImpl().destroy();
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

            public int exitValue() throws RemoteException {
                int v4_1;
                Parcel v0 = Parcel.obtain();
                Parcel v1 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IRemoteProcess");
                    if((this.mRemote.transact(5, v0, v1, 0)) || Stub.getDefaultImpl() == null) {
                        v1.readException();
                        v4_1 = v1.readInt();
                    }
                    else {
                        v4_1 = Stub.getDefaultImpl().exitValue();
                    }
                }
                catch(Throwable v4) {
                    v1.recycle();
                    v0.recycle();
                    throw v4;
                }

                v1.recycle();
                v0.recycle();
                return v4_1;
            }

            public ParcelFileDescriptor getErrorStream() throws RemoteException {
                ParcelFileDescriptor v4_1;
                Parcel v0 = Parcel.obtain();
                Parcel v1 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IRemoteProcess");
                    if((this.mRemote.transact(3, v0, v1, 0)) || Stub.getDefaultImpl() == null) {
                        v1.readException();
                        if(v1.readInt() != 0) {
                            Object v4_2 = ParcelFileDescriptor.CREATOR.createFromParcel(v1);
                        }
                        else {
                            goto label_22;
                        }
                    }
                    else {
                        v4_1 = Stub.getDefaultImpl().getErrorStream();
                    }

                    goto label_13;
                }
                catch(Throwable v4) {
                    v1.recycle();
                    v0.recycle();
                    throw v4;
                }

            label_22:
                v4_1 = null;
            label_13:
                v1.recycle();
                v0.recycle();
                return v4_1;
            }

            public ParcelFileDescriptor getInputStream() throws RemoteException {
                ParcelFileDescriptor v4_1;
                Object v4_2;
                Parcel v0 = Parcel.obtain();
                Parcel v1 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IRemoteProcess");
                    if((this.mRemote.transact(2, v0, v1, 0)) || Stub.getDefaultImpl() == null) {
                        v1.readException();
                        if(v1.readInt() != 0) {
                            v4_2 = ParcelFileDescriptor.CREATOR.createFromParcel(v1);
                        }
                        else {
                            goto label_22;
                        }
                    }
                    else {
                        v4_1 = Stub.getDefaultImpl().getInputStream();
                    }

                    goto label_13;
                }
                catch(Throwable v4) {
                    v1.recycle();
                    v0.recycle();
                    throw v4;
                }

            label_22:
                v4_1 = null;
            label_13:
                v1.recycle();
                v0.recycle();
                return ((ParcelFileDescriptor)v4_2);
            }

            public String getInterfaceDescriptor() {
                return "moe.shizuku.server.IRemoteProcess";
            }

            public ParcelFileDescriptor getOutputStream() throws RemoteException {
                ParcelFileDescriptor v4_1;
                Parcel v0 = Parcel.obtain();
                Parcel v1 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IRemoteProcess");
                    if((this.mRemote.transact(1, v0, v1, 0)) || Stub.getDefaultImpl() == null) {
                        v1.readException();
                        if(v1.readInt() != 0) {
                            Object v4_2 = ParcelFileDescriptor.CREATOR.createFromParcel(v1);
                        }
                        else {
                            goto label_22;
                        }
                    }
                    else {
                        v4_1 = Stub.getDefaultImpl().getOutputStream();
                    }

                    goto label_13;
                }
                catch(Throwable v4) {
                    v1.recycle();
                    v0.recycle();
                    throw v4;
                }

            label_22:
                v4_1 = null;
            label_13:
                v1.recycle();
                v0.recycle();
                return v4_1;
            }

            public int waitFor() throws RemoteException {
                int v4_1;
                Parcel v0 = Parcel.obtain();
                Parcel v1 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IRemoteProcess");
                    if((this.mRemote.transact(4, v0, v1, 0)) || Stub.getDefaultImpl() == null) {
                        v1.readException();
                        v4_1 = v1.readInt();
                    }
                    else {
                        v4_1 = Stub.getDefaultImpl().waitFor();
                    }
                }
                catch(Throwable v4) {
                    v1.recycle();
                    v0.recycle();
                    throw v4;
                }

                v1.recycle();
                v0.recycle();
                return v4_1;
            }

            public boolean waitForTimeout(long arg5, String arg7) throws RemoteException {
                boolean v4_1;
                boolean v3;
                Parcel v0 = Parcel.obtain();
                Parcel v1 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IRemoteProcess");
                    v0.writeLong(arg5);
                    v0.writeString(arg7);
                    v3 = false;
                    if(!this.mRemote.transact(8, v0, v1, 0) && Stub.getDefaultImpl() != null) {
                        v4_1 = Stub.getDefaultImpl().waitForTimeout(arg5, arg7);
                        goto label_15;
                    }

                    goto label_18;
                }
                catch(Throwable v4) {
                    goto label_26;
                }

            label_15:
                v1.recycle();
                v0.recycle();
                return v4_1;
                try {
                label_18:
                    v1.readException();
                    if(v1.readInt() == 0) {
                        goto label_22;
                    }
                }
                catch(Throwable v4) {
                label_26:
                    v1.recycle();
                    v0.recycle();
                    throw v4;
                }

                v3 = true;
            label_22:
                v1.recycle();
                v0.recycle();
                return v3;
            }
        }

        private static final String DESCRIPTOR = "moe.shizuku.server.IRemoteProcess";
        static final int TRANSACTION_alive = 7;
        static final int TRANSACTION_destroy = 6;
        static final int TRANSACTION_exitValue = 5;
        static final int TRANSACTION_getErrorStream = 3;
        static final int TRANSACTION_getInputStream = 2;
        static final int TRANSACTION_getOutputStream = 1;
        static final int TRANSACTION_waitFor = 4;
        static final int TRANSACTION_waitForTimeout = 8;

        public Stub() {
            super();
            this.attachInterface(((IInterface)this), "moe.shizuku.server.IRemoteProcess");
        }

        public IBinder asBinder() {
            return this;
        }

        public static IRemoteProcess asInterface(IBinder arg2) {
            if(arg2 == null) {
                return null;
            }

            IInterface v0 = arg2.queryLocalInterface("moe.shizuku.server.IRemoteProcess");
            if(v0 != null && ((v0 instanceof IRemoteProcess))) {
                return ((IRemoteProcess)v0);
            }

            return new Proxy(arg2);
        }

        public static IRemoteProcess getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public boolean onTransact(int arg5, Parcel arg6, Parcel arg7, int arg8) throws RemoteException {
            String v2 = "moe.shizuku.server.IRemoteProcess";
            if(arg5 == 0x5F4E5446) {
                goto label_61;
            }

            switch(arg5) {
                case 1: {
                    goto label_52;
                }
                case 2: {
                    goto label_43;
                }
                case 3: {
                    goto label_34;
                }
                case 4: {
                    goto label_29;
                }
                case 5: {
                    goto label_24;
                }
                case 6: {
                    goto label_20;
                }
                case 7: {
                    goto label_15;
                }
                case 8: {
                    goto label_8;
                }
            }

            return super.onTransact(arg5, arg6, arg7, arg8);
        label_34:
            arg6.enforceInterface(v2);
            ParcelFileDescriptor v4 = this.getErrorStream();
            arg7.writeNoException();
            if(v4 != null) {
                arg7.writeInt(1);
                v4.writeToParcel(arg7, 1);
            }
            else {
                arg7.writeInt(0);
            }

            return 1;
        label_52:
            arg6.enforceInterface(v2);
            v4 = this.getOutputStream();
            arg7.writeNoException();
            if(v4 != null) {
                arg7.writeInt(1);
                v4.writeToParcel(arg7, 1);
            }
            else {
                arg7.writeInt(0);
            }

            return 1;
        label_20:
            arg6.enforceInterface(v2);
            this.destroy();
            arg7.writeNoException();
            return 1;
        label_24:
            arg6.enforceInterface(v2);
            int v4_1 = this.exitValue();
            arg7.writeNoException();
            arg7.writeInt(v4_1);
            return 1;
        label_8:
            arg6.enforceInterface(v2);
            boolean v4_2 = this.waitForTimeout(arg6.readLong(), arg6.readString());
            arg7.writeNoException();
            arg7.writeInt(((int)v4_2));
            return 1;
        label_43:
            arg6.enforceInterface(v2);
            v4 = this.getInputStream();
            arg7.writeNoException();
            if(v4 != null) {
                arg7.writeInt(1);
                v4.writeToParcel(arg7, 1);
            }
            else {
                arg7.writeInt(0);
            }

            return 1;
        label_29:
            arg6.enforceInterface(v2);
            v4_1 = this.waitFor();
            arg7.writeNoException();
            arg7.writeInt(v4_1);
            return 1;
        label_15:
            arg6.enforceInterface(v2);
            v4_2 = this.alive();
            arg7.writeNoException();
            arg7.writeInt(((int)v4_2));
            return 1;
        label_61:
            arg7.writeString(v2);
            return 1;
        }

        public static boolean setDefaultImpl(IRemoteProcess arg1) {
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

    boolean alive() throws RemoteException;

    void destroy() throws RemoteException;

    int exitValue() throws RemoteException;

    ParcelFileDescriptor getErrorStream() throws RemoteException;

    ParcelFileDescriptor getInputStream() throws RemoteException;

    ParcelFileDescriptor getOutputStream() throws RemoteException;

    int waitFor() throws RemoteException;

    boolean waitForTimeout(long arg1, String arg2) throws RemoteException;
}

