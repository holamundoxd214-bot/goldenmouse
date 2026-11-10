package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface INotificationSideChannel extends IInterface {
    public class Default implements INotificationSideChannel {
        public Default() {
            super();
        }

        public IBinder asBinder() {
            return null;
        }

        public void cancel(String arg1, int arg2, String arg3) throws RemoteException {
        }

        public void cancelAll(String arg1) throws RemoteException {
        }

        public int getInterfaceVersion() {
            return 0;
        }

        public void notify(String arg1, int arg2, String arg3, Notification arg4) throws RemoteException {
        }
    }

    public abstract class Stub extends Binder implements INotificationSideChannel {
        class Proxy implements INotificationSideChannel {
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

            public void cancel(String arg3, int arg4, String arg5) throws RemoteException {
                Parcel v0 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken(Proxy.DESCRIPTOR);
                    v0.writeString(arg3);
                    v0.writeInt(arg4);
                    v0.writeString(arg5);
                    if(!this.mRemote.transact(2, v0, null, 1)) {
                        goto label_14;
                    }
                }
                catch(Throwable v2) {
                    goto label_19;
                }

                v0.recycle();
                return;
                try {
                label_14:
                    throw new RemoteException("Method cancel is unimplemented.");
                }
                catch(Throwable v2) {
                label_19:
                    v0.recycle();
                    throw v2;
                }
            }

            public void cancelAll(String arg4) throws RemoteException {
                Parcel v0 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken(Proxy.DESCRIPTOR);
                    v0.writeString(arg4);
                    if(!this.mRemote.transact(3, v0, null, 1)) {
                        goto label_12;
                    }
                }
                catch(Throwable v3) {
                    goto label_17;
                }

                v0.recycle();
                return;
                try {
                label_12:
                    throw new RemoteException("Method cancelAll is unimplemented.");
                }
                catch(Throwable v3) {
                label_17:
                    v0.recycle();
                    throw v3;
                }
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

            public void notify(String arg3, int arg4, String arg5, Notification arg6) throws RemoteException {
                Parcel v0 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken(Proxy.DESCRIPTOR);
                    v0.writeString(arg3);
                    v0.writeInt(arg4);
                    v0.writeString(arg5);
                    v0.writeTypedObject(((Parcelable)arg6), 0);
                    if(!this.mRemote.transact(1, v0, null, 1)) {
                        goto label_15;
                    }
                }
                catch(Throwable v2) {
                    goto label_20;
                }

                v0.recycle();
                return;
                try {
                label_15:
                    throw new RemoteException("Method notify is unimplemented.");
                }
                catch(Throwable v2) {
                label_20:
                    v0.recycle();
                    throw v2;
                }
            }
        }

        static final int TRANSACTION_cancel = 2;
        static final int TRANSACTION_cancelAll = 3;
        static final int TRANSACTION_getInterfaceVersion = 0xFFFFFF;
        static final int TRANSACTION_notify = 1;

        public Stub() {
            super();
            this.attachInterface(((IInterface)this), Stub.DESCRIPTOR);
        }

        public IBinder asBinder() {
            return this;
        }

        public static INotificationSideChannel asInterface(IBinder arg2) {
            if(arg2 == null) {
                return null;
            }

            IInterface v0 = arg2.queryLocalInterface(Stub.DESCRIPTOR);
            if(v0 != null && ((v0 instanceof INotificationSideChannel))) {
                return ((INotificationSideChannel)v0);
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

            if(arg5 == 1) {
                this.notify(arg6.readString(), arg6.readInt(), arg6.readString(), arg6.readTypedObject(Notification.CREATOR));
            }
            else if(arg5 == 2) {
                this.cancel(arg6.readString(), arg6.readInt(), arg6.readString());
            }
            else if(arg5 != 3) {
                return super.onTransact(arg5, arg6, arg7, arg8);
            }
            else {
                this.cancelAll(arg6.readString());
            }

            return 1;
        }
    }

    public static final String DESCRIPTOR = null;
    public static final int VERSION = 1;

    static {
        INotificationSideChannel.DESCRIPTOR = "android$support$v4$app$INotificationSideChannel".replace('$', '.');
    }

    void cancel(String arg1, int arg2, String arg3) throws RemoteException;

    void cancelAll(String arg1) throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    void notify(String arg1, int arg2, String arg3, Notification arg4) throws RemoteException;
}

