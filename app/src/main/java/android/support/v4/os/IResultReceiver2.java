package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface IResultReceiver2 extends IInterface {
    public class Default implements IResultReceiver2 {
        public Default() {
            super();
        }

        public IBinder asBinder() {
            return null;
        }

        public int getInterfaceVersion() {
            return 0;
        }

        public void send(int arg1, Bundle arg2) throws RemoteException {
        }
    }

    public abstract class Stub extends Binder implements IResultReceiver2 {
        class Proxy implements IResultReceiver2 {
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

            public void send(int arg3, Bundle arg4) throws RemoteException {
                Parcel v0 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken(Proxy.DESCRIPTOR);
                    v0.writeInt(arg3);
                    v0.writeTypedObject(((Parcelable)arg4), 0);
                    if(!this.mRemote.transact(1, v0, null, 1)) {
                        goto label_13;
                    }
                }
                catch(Throwable v2) {
                    goto label_18;
                }

                v0.recycle();
                return;
                try {
                label_13:
                    throw new RemoteException("Method send is unimplemented.");
                }
                catch(Throwable v2) {
                label_18:
                    v0.recycle();
                    throw v2;
                }
            }
        }

        static final int TRANSACTION_getInterfaceVersion = 0xFFFFFF;
        static final int TRANSACTION_send = 1;

        public Stub() {
            super();
            this.attachInterface(((IInterface)this), Stub.DESCRIPTOR);
        }

        public IBinder asBinder() {
            return this;
        }

        public static IResultReceiver2 asInterface(IBinder arg2) {
            if(arg2 == null) {
                return null;
            }

            IInterface v0 = arg2.queryLocalInterface(Stub.DESCRIPTOR);
            if(v0 != null && ((v0 instanceof IResultReceiver2))) {
                return ((IResultReceiver2)v0);
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

            this.send(arg6.readInt(), arg6.readTypedObject(Bundle.CREATOR));
            return 1;
        }
    }

    public static final String DESCRIPTOR = null;
    public static final int VERSION = 1;

    static {
        IResultReceiver2.DESCRIPTOR = "android$support$v4$os$IResultReceiver2".replace('$', '.');
    }

    int getInterfaceVersion() throws RemoteException;

    void send(int arg1, Bundle arg2) throws RemoteException;
}

