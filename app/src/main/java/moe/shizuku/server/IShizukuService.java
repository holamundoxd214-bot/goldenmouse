package moe.shizuku.server;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IShizukuService extends IInterface {
    public class Default implements IShizukuService {
        public Default() {
            super();
        }

        public int addUserService(IShizukuServiceConnection arg1, Bundle arg2) throws RemoteException {
            return 0;
        }

        public IBinder asBinder() {
            return null;
        }

        public void attachApplication(IShizukuApplication arg1, Bundle arg2) throws RemoteException {
        }

        public void attachUserService(IBinder arg1, Bundle arg2) throws RemoteException {
        }

        public int checkPermission(String arg1) throws RemoteException {
            return 0;
        }

        public boolean checkSelfPermission() throws RemoteException {
            return 0;
        }

        public void dispatchPackageChanged(Intent arg1) throws RemoteException {
        }

        public void dispatchPermissionConfirmationResult(int arg1, int arg2, int arg3, Bundle arg4) throws RemoteException {
        }

        public void exit() throws RemoteException {
        }

        public int getFlagsForUid(int arg1, int arg2) throws RemoteException {
            return 0;
        }

        public String getSELinuxContext() throws RemoteException {
            return null;
        }

        public String getSystemProperty(String arg1, String arg2) throws RemoteException {
            return null;
        }

        public int getUid() throws RemoteException {
            return 0;
        }

        public int getVersion() throws RemoteException {
            return 0;
        }

        public boolean isHidden(int arg1) throws RemoteException {
            return 0;
        }

        public IRemoteProcess newProcess(String[] arg1, String[] arg2, String arg3) throws RemoteException {
            return null;
        }

        public int removeUserService(IShizukuServiceConnection arg1, Bundle arg2) throws RemoteException {
            return 0;
        }

        public void requestPermission(int arg1) throws RemoteException {
        }

        public void setSystemProperty(String arg1, String arg2) throws RemoteException {
        }

        public boolean shouldShowRequestPermissionRationale() throws RemoteException {
            return 0;
        }

        public void updateFlagsForUid(int arg1, int arg2, int arg3) throws RemoteException {
        }
    }

    public abstract class Stub extends Binder implements IShizukuService {
        class Proxy implements IShizukuService {
            private IBinder mRemote;
            public static IShizukuService sDefaultImpl;

            Proxy(IBinder arg1) {
                super();
                this.mRemote = arg1;
            }

            public int addUserService(IShizukuServiceConnection arg5, Bundle arg6) throws RemoteException {
                int v4_1;
                Parcel v0 = Parcel.obtain();
                Parcel v1 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    IBinder v2 = arg5 != null ? arg5.asBinder() : null;
                    v0.writeStrongBinder(v2);
                    if(arg6 != null) {
                        v0.writeInt(1);
                        arg6.writeToParcel(v0, 0);
                    }
                    else {
                        v0.writeInt(0);
                    }

                    if((this.mRemote.transact(12, v0, v1, 0)) || Stub.getDefaultImpl() == null) {
                        v1.readException();
                        v4_1 = v1.readInt();
                    }
                    else {
                        v4_1 = Stub.getDefaultImpl().addUserService(arg5, arg6);
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

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void attachApplication(IShizukuApplication arg5, Bundle arg6) throws RemoteException {
                Parcel v0 = Parcel.obtain();
                Parcel v1 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    IBinder v2 = arg5 != null ? arg5.asBinder() : null;
                    v0.writeStrongBinder(v2);
                    if(arg6 != null) {
                        v0.writeInt(1);
                        arg6.writeToParcel(v0, 0);
                    }
                    else {
                        v0.writeInt(0);
                    }

                    if((this.mRemote.transact(18, v0, v1, 0)) || Stub.getDefaultImpl() == null) {
                        v1.readException();
                    }
                    else {
                        Stub.getDefaultImpl().attachApplication(arg5, arg6);
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

            public void attachUserService(IBinder arg5, Bundle arg6) throws RemoteException {
                Parcel v0 = Parcel.obtain();
                Parcel v1 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    v0.writeStrongBinder(arg5);
                    if(arg6 != null) {
                        v0.writeInt(1);
                        arg6.writeToParcel(v0, 0);
                    }
                    else {
                        v0.writeInt(0);
                    }

                    if((this.mRemote.transact(102, v0, v1, 0)) || Stub.getDefaultImpl() == null) {
                        v1.readException();
                    }
                    else {
                        Stub.getDefaultImpl().attachUserService(arg5, arg6);
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

            public int checkPermission(String arg5) throws RemoteException {
                int v4_1;
                Parcel v0 = Parcel.obtain();
                Parcel v1 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    v0.writeString(arg5);
                    if((this.mRemote.transact(5, v0, v1, 0)) || Stub.getDefaultImpl() == null) {
                        v1.readException();
                        v4_1 = v1.readInt();
                    }
                    else {
                        v4_1 = Stub.getDefaultImpl().checkPermission(arg5);
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

            public boolean checkSelfPermission() throws RemoteException {
                boolean v4_1;
                boolean v3;
                Parcel v0 = Parcel.obtain();
                Parcel v1 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    v3 = false;
                    if(!this.mRemote.transact(16, v0, v1, 0) && Stub.getDefaultImpl() != null) {
                        v4_1 = Stub.getDefaultImpl().checkSelfPermission();
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

            public void dispatchPackageChanged(Intent arg5) throws RemoteException {
                Parcel v0 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    if(arg5 != null) {
                        v0.writeInt(1);
                        arg5.writeToParcel(v0, 0);
                    }
                    else {
                        v0.writeInt(0);
                    }

                    if(!this.mRemote.transact(103, v0, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().dispatchPackageChanged(arg5);
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

            public void dispatchPermissionConfirmationResult(int arg5, int arg6, int arg7, Bundle arg8) throws RemoteException {
                Parcel v0 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    v0.writeInt(arg5);
                    v0.writeInt(arg6);
                    v0.writeInt(arg7);
                    if(arg8 != null) {
                        v0.writeInt(1);
                        arg8.writeToParcel(v0, 0);
                    }
                    else {
                        v0.writeInt(0);
                    }

                    if(!this.mRemote.transact(105, v0, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().dispatchPermissionConfirmationResult(arg5, arg6, arg7, arg8);
                        goto label_22;
                    }

                    goto label_24;
                }
                catch(Throwable v4) {
                    v0.recycle();
                    throw v4;
                }

            label_22:
                v0.recycle();
                return;
            label_24:
                v0.recycle();
            }

            public void exit() throws RemoteException {
                Parcel v0 = Parcel.obtain();
                Parcel v1 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    if((this.mRemote.transact(101, v0, v1, 0)) || Stub.getDefaultImpl() == null) {
                        v1.readException();
                    }
                    else {
                        Stub.getDefaultImpl().exit();
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

            public int getFlagsForUid(int arg5, int arg6) throws RemoteException {
                int v4_1;
                Parcel v0 = Parcel.obtain();
                Parcel v1 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    v0.writeInt(arg5);
                    v0.writeInt(arg6);
                    if((this.mRemote.transact(106, v0, v1, 0)) || Stub.getDefaultImpl() == null) {
                        v1.readException();
                        v4_1 = v1.readInt();
                    }
                    else {
                        v4_1 = Stub.getDefaultImpl().getFlagsForUid(arg5, arg6);
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

            public String getInterfaceDescriptor() {
                return "moe.shizuku.server.IShizukuService";
            }

            public String getSELinuxContext() throws RemoteException {
                String v4_1;
                Parcel v0 = Parcel.obtain();
                Parcel v1 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    if((this.mRemote.transact(9, v0, v1, 0)) || Stub.getDefaultImpl() == null) {
                        v1.readException();
                        v4_1 = v1.readString();
                    }
                    else {
                        v4_1 = Stub.getDefaultImpl().getSELinuxContext();
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

            public String getSystemProperty(String arg5, String arg6) throws RemoteException {
                String v4_1;
                Parcel v0 = Parcel.obtain();
                Parcel v1 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    v0.writeString(arg5);
                    v0.writeString(arg6);
                    if((this.mRemote.transact(10, v0, v1, 0)) || Stub.getDefaultImpl() == null) {
                        v1.readException();
                        v4_1 = v1.readString();
                    }
                    else {
                        v4_1 = Stub.getDefaultImpl().getSystemProperty(arg5, arg6);
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

            public int getUid() throws RemoteException {
                int v4_1;
                Parcel v0 = Parcel.obtain();
                Parcel v1 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    if((this.mRemote.transact(4, v0, v1, 0)) || Stub.getDefaultImpl() == null) {
                        v1.readException();
                        v4_1 = v1.readInt();
                    }
                    else {
                        v4_1 = Stub.getDefaultImpl().getUid();
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

            public int getVersion() throws RemoteException {
                int v4_1;
                Parcel v0 = Parcel.obtain();
                Parcel v1 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    if((this.mRemote.transact(3, v0, v1, 0)) || Stub.getDefaultImpl() == null) {
                        v1.readException();
                        v4_1 = v1.readInt();
                    }
                    else {
                        v4_1 = Stub.getDefaultImpl().getVersion();
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

            public boolean isHidden(int arg5) throws RemoteException {
                boolean v4_1;
                boolean v3;
                Parcel v0 = Parcel.obtain();
                Parcel v1 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    v0.writeInt(arg5);
                    v3 = false;
                    if(!this.mRemote.transact(104, v0, v1, 0) && Stub.getDefaultImpl() != null) {
                        v4_1 = Stub.getDefaultImpl().isHidden(arg5);
                        goto label_14;
                    }

                    goto label_17;
                }
                catch(Throwable v4) {
                    goto label_25;
                }

            label_14:
                v1.recycle();
                v0.recycle();
                return v4_1;
                try {
                label_17:
                    v1.readException();
                    if(v1.readInt() == 0) {
                        goto label_21;
                    }
                }
                catch(Throwable v4) {
                label_25:
                    v1.recycle();
                    v0.recycle();
                    throw v4;
                }

                v3 = true;
            label_21:
                v1.recycle();
                v0.recycle();
                return v3;
            }

            public IRemoteProcess newProcess(String[] arg5, String[] arg6, String arg7) throws RemoteException {
                IRemoteProcess v4_1;
                Parcel v0 = Parcel.obtain();
                Parcel v1 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    v0.writeStringArray(arg5);
                    v0.writeStringArray(arg6);
                    v0.writeString(arg7);
                    if((this.mRemote.transact(8, v0, v1, 0)) || Stub.getDefaultImpl() == null) {
                        v1.readException();
                        v4_1 = moe.shizuku.server.IRemoteProcess$Stub.asInterface(v1.readStrongBinder());
                    }
                    else {
                        v4_1 = Stub.getDefaultImpl().newProcess(arg5, arg6, arg7);
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

            public int removeUserService(IShizukuServiceConnection arg5, Bundle arg6) throws RemoteException {
                int v4_1;
                Parcel v0 = Parcel.obtain();
                Parcel v1 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    IBinder v2 = arg5 != null ? arg5.asBinder() : null;
                    v0.writeStrongBinder(v2);
                    if(arg6 != null) {
                        v0.writeInt(1);
                        arg6.writeToParcel(v0, 0);
                    }
                    else {
                        v0.writeInt(0);
                    }

                    if((this.mRemote.transact(13, v0, v1, 0)) || Stub.getDefaultImpl() == null) {
                        v1.readException();
                        v4_1 = v1.readInt();
                    }
                    else {
                        v4_1 = Stub.getDefaultImpl().removeUserService(arg5, arg6);
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

            public void requestPermission(int arg5) throws RemoteException {
                Parcel v0 = Parcel.obtain();
                Parcel v1 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    v0.writeInt(arg5);
                    if((this.mRemote.transact(15, v0, v1, 0)) || Stub.getDefaultImpl() == null) {
                        v1.readException();
                    }
                    else {
                        Stub.getDefaultImpl().requestPermission(arg5);
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

            public void setSystemProperty(String arg5, String arg6) throws RemoteException {
                Parcel v0 = Parcel.obtain();
                Parcel v1 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    v0.writeString(arg5);
                    v0.writeString(arg6);
                    if((this.mRemote.transact(11, v0, v1, 0)) || Stub.getDefaultImpl() == null) {
                        v1.readException();
                    }
                    else {
                        Stub.getDefaultImpl().setSystemProperty(arg5, arg6);
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

            public boolean shouldShowRequestPermissionRationale() throws RemoteException {
                boolean v4_1;
                boolean v3;
                Parcel v0 = Parcel.obtain();
                Parcel v1 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    v3 = false;
                    if(!this.mRemote.transact(17, v0, v1, 0) && Stub.getDefaultImpl() != null) {
                        v4_1 = Stub.getDefaultImpl().shouldShowRequestPermissionRationale();
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

            public void updateFlagsForUid(int arg5, int arg6, int arg7) throws RemoteException {
                Parcel v0 = Parcel.obtain();
                Parcel v1 = Parcel.obtain();
                try {
                    v0.writeInterfaceToken("moe.shizuku.server.IShizukuService");
                    v0.writeInt(arg5);
                    v0.writeInt(arg6);
                    v0.writeInt(arg7);
                    if((this.mRemote.transact(107, v0, v1, 0)) || Stub.getDefaultImpl() == null) {
                        v1.readException();
                    }
                    else {
                        Stub.getDefaultImpl().updateFlagsForUid(arg5, arg6, arg7);
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

        private static final String DESCRIPTOR = "moe.shizuku.server.IShizukuService";
        static final int TRANSACTION_addUserService = 12;
        static final int TRANSACTION_attachApplication = 18;
        static final int TRANSACTION_attachUserService = 102;
        static final int TRANSACTION_checkPermission = 5;
        static final int TRANSACTION_checkSelfPermission = 16;
        static final int TRANSACTION_dispatchPackageChanged = 103;
        static final int TRANSACTION_dispatchPermissionConfirmationResult = 105;
        static final int TRANSACTION_exit = 101;
        static final int TRANSACTION_getFlagsForUid = 106;
        static final int TRANSACTION_getSELinuxContext = 9;
        static final int TRANSACTION_getSystemProperty = 10;
        static final int TRANSACTION_getUid = 4;
        static final int TRANSACTION_getVersion = 3;
        static final int TRANSACTION_isHidden = 104;
        static final int TRANSACTION_newProcess = 8;
        static final int TRANSACTION_removeUserService = 13;
        static final int TRANSACTION_requestPermission = 15;
        static final int TRANSACTION_setSystemProperty = 11;
        static final int TRANSACTION_shouldShowRequestPermissionRationale = 17;
        static final int TRANSACTION_updateFlagsForUid = 107;

        public Stub() {
            super();
            this.attachInterface(((IInterface)this), "moe.shizuku.server.IShizukuService");
        }

        public IBinder asBinder() {
            return this;
        }

        public static IShizukuService asInterface(IBinder arg2) {
            if(arg2 == null) {
                return null;
            }

            IInterface v0 = arg2.queryLocalInterface("moe.shizuku.server.IShizukuService");
            if(v0 != null && ((v0 instanceof IShizukuService))) {
                return ((IShizukuService)v0);
            }

            return new Proxy(arg2);
        }

        public static IShizukuService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public boolean onTransact(int arg4, Parcel arg5, Parcel arg6, int arg7) throws RemoteException {
            IBinder v0_2;
            Object v0_1;
            String v2 = "moe.shizuku.server.IShizukuService";
            if(arg4 == 3) {
                goto label_160;
            }

            if(arg4 == 4) {
                goto label_155;
            }

            if(arg4 == 5) {
                goto label_149;
            }

            if(arg4 == 0x5F4E5446) {
                goto label_147;
            }

            Bundle v0 = null;
            switch(arg4) {
                case 8: {
                    goto label_137;
                }
                case 9: {
                    goto label_132;
                }
                case 10: {
                    goto label_125;
                }
                case 11: {
                    goto label_119;
                }
                case 12: {
                    goto label_107;
                }
                case 13: {
                    goto label_95;
                }
            }

            switch(arg4) {
                case 15: {
                    goto label_90;
                }
                case 16: {
                    goto label_85;
                }
                case 17: {
                    goto label_80;
                }
                case 18: {
                    goto label_69;
                }
            }

            switch(arg4) {
                case 101: {
                    goto label_65;
                }
                case 102: {
                    goto label_55;
                }
                case 103: {
                    goto label_47;
                }
                case 104: {
                    goto label_41;
                }
                case 105: {
                    goto label_30;
                }
                case 106: {
                    goto label_23;
                }
                case 107: {
                    goto label_16;
                }
            }

            return super.onTransact(arg4, arg5, arg6, arg7);
        label_65:
            arg5.enforceInterface(v2);
            this.exit();
            arg6.writeNoException();
            return 1;
        label_55:
            arg5.enforceInterface(v2);
            IBinder v4 = arg5.readStrongBinder();
            if(arg5.readInt() != 0) {
                v0_1 = Bundle.CREATOR.createFromParcel(arg5);
            }

            this.attachUserService(v4, ((Bundle)v0_1));
            arg6.writeNoException();
            return 1;
        label_23:
            arg5.enforceInterface(v2);
            int v3 = this.getFlagsForUid(arg5.readInt(), arg5.readInt());
            arg6.writeNoException();
            arg6.writeInt(v3);
            return 1;
        label_41:
            arg5.enforceInterface(v2);
            boolean v3_1 = this.isHidden(arg5.readInt());
            arg6.writeNoException();
            arg6.writeInt(((int)v3_1));
            return 1;
        label_30:
            arg5.enforceInterface(v2);
            arg4 = arg5.readInt();
            int v6 = arg5.readInt();
            arg7 = arg5.readInt();
            if(arg5.readInt() != 0) {
                v0_1 = Bundle.CREATOR.createFromParcel(arg5);
            }

            this.dispatchPermissionConfirmationResult(arg4, v6, arg7, ((Bundle)v0_1));
            return 1;
        label_47:
            arg5.enforceInterface(v2);
            if(arg5.readInt() != 0) {
                v0_1 = Intent.CREATOR.createFromParcel(arg5);
            }

            this.dispatchPackageChanged(((Intent)v0_1));
            return 1;
        label_16:
            arg5.enforceInterface(v2);
            this.updateFlagsForUid(arg5.readInt(), arg5.readInt(), arg5.readInt());
            arg6.writeNoException();
            return 1;
        label_85:
            arg5.enforceInterface(v2);
            v3_1 = this.checkSelfPermission();
            arg6.writeNoException();
            arg6.writeInt(((int)v3_1));
            return 1;
        label_69:
            arg5.enforceInterface(v2);
            IShizukuApplication v4_1 = moe.shizuku.server.IShizukuApplication$Stub.asInterface(arg5.readStrongBinder());
            if(arg5.readInt() != 0) {
                v0_1 = Bundle.CREATOR.createFromParcel(arg5);
            }

            this.attachApplication(v4_1, ((Bundle)v0_1));
            arg6.writeNoException();
            return 1;
        label_90:
            arg5.enforceInterface(v2);
            this.requestPermission(arg5.readInt());
            arg6.writeNoException();
            return 1;
        label_80:
            arg5.enforceInterface(v2);
            v3_1 = this.shouldShowRequestPermissionRationale();
            arg6.writeNoException();
            arg6.writeInt(((int)v3_1));
            return 1;
        label_132:
            arg5.enforceInterface(v2);
            String v3_2 = this.getSELinuxContext();
            arg6.writeNoException();
            arg6.writeString(v3_2);
            return 1;
        label_119:
            arg5.enforceInterface(v2);
            this.setSystemProperty(arg5.readString(), arg5.readString());
            arg6.writeNoException();
            return 1;
        label_137:
            arg5.enforceInterface(v2);
            IRemoteProcess v3_3 = this.newProcess(arg5.createStringArray(), arg5.createStringArray(), arg5.readString());
            arg6.writeNoException();
            if(v3_3 != null) {
                v0_2 = v3_3.asBinder();
            }

            arg6.writeStrongBinder(v0_2);
            return 1;
        label_107:
            arg5.enforceInterface(v2);
            IShizukuServiceConnection v4_2 = moe.shizuku.server.IShizukuServiceConnection$Stub.asInterface(arg5.readStrongBinder());
            if(arg5.readInt() != 0) {
                v0_1 = Bundle.CREATOR.createFromParcel(arg5);
            }

            v3 = this.addUserService(v4_2, ((Bundle)v0_1));
            arg6.writeNoException();
            arg6.writeInt(v3);
            return 1;
        label_125:
            arg5.enforceInterface(v2);
            v3_2 = this.getSystemProperty(arg5.readString(), arg5.readString());
            arg6.writeNoException();
            arg6.writeString(v3_2);
            return 1;
        label_95:
            arg5.enforceInterface(v2);
            v4_2 = moe.shizuku.server.IShizukuServiceConnection$Stub.asInterface(arg5.readStrongBinder());
            if(arg5.readInt() != 0) {
                v0_1 = Bundle.CREATOR.createFromParcel(arg5);
            }

            v3 = this.removeUserService(v4_2, ((Bundle)v0_1));
            arg6.writeNoException();
            arg6.writeInt(v3);
            return 1;
        label_147:
            arg6.writeString(v2);
            return 1;
        label_149:
            arg5.enforceInterface(v2);
            v3 = this.checkPermission(arg5.readString());
            arg6.writeNoException();
            arg6.writeInt(v3);
            return 1;
        label_155:
            arg5.enforceInterface(v2);
            v3 = this.getUid();
            arg6.writeNoException();
            arg6.writeInt(v3);
            return 1;
        label_160:
            arg5.enforceInterface(v2);
            v3 = this.getVersion();
            arg6.writeNoException();
            arg6.writeInt(v3);
            return 1;
        }

        public static boolean setDefaultImpl(IShizukuService arg1) {
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

    int addUserService(IShizukuServiceConnection arg1, Bundle arg2) throws RemoteException;

    void attachApplication(IShizukuApplication arg1, Bundle arg2) throws RemoteException;

    void attachUserService(IBinder arg1, Bundle arg2) throws RemoteException;

    int checkPermission(String arg1) throws RemoteException;

    boolean checkSelfPermission() throws RemoteException;

    void dispatchPackageChanged(Intent arg1) throws RemoteException;

    void dispatchPermissionConfirmationResult(int arg1, int arg2, int arg3, Bundle arg4) throws RemoteException;

    void exit() throws RemoteException;

    int getFlagsForUid(int arg1, int arg2) throws RemoteException;

    String getSELinuxContext() throws RemoteException;

    String getSystemProperty(String arg1, String arg2) throws RemoteException;

    int getUid() throws RemoteException;

    int getVersion() throws RemoteException;

    boolean isHidden(int arg1) throws RemoteException;

    IRemoteProcess newProcess(String[] arg1, String[] arg2, String arg3) throws RemoteException;

    int removeUserService(IShizukuServiceConnection arg1, Bundle arg2) throws RemoteException;

    void requestPermission(int arg1) throws RemoteException;

    void setSystemProperty(String arg1, String arg2) throws RemoteException;

    boolean shouldShowRequestPermissionRationale() throws RemoteException;

    void updateFlagsForUid(int arg1, int arg2, int arg3) throws RemoteException;
}

