package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.os.RemoteException;

public class ResultReceiver implements Parcelable {
    class android.support.v4.os.ResultReceiver$1 implements Parcelable$Creator {
        android.support.v4.os.ResultReceiver$1() {
            super();
        }

        public ResultReceiver createFromParcel(Parcel arg1) {
            return new ResultReceiver(arg1);
        }

        public Object createFromParcel(Parcel arg1) {
            return this.createFromParcel(arg1);
        }

        public ResultReceiver[] newArray(int arg1) {
            return new ResultReceiver[arg1];
        }

        public Object[] newArray(int arg1) {
            return this.newArray(arg1);
        }
    }

    class MyResultReceiver extends Stub {
        MyResultReceiver(ResultReceiver arg1) {
            ResultReceiver.this = arg1;
            super();
        }

        public int getInterfaceVersion() {
            return 1;
        }

        public void send(int arg3, Bundle arg4) {
            Handler v0 = ResultReceiver.this.mHandler;
            ResultReceiver v1 = ResultReceiver.this;
            if(v0 != null) {
                v1.mHandler.post(new MyRunnable(ResultReceiver.this, arg3, arg4));
                return;
            }

            v1.onReceiveResult(arg3, arg4);
        }
    }

    class MyRunnable implements Runnable {
        final int mResultCode;
        final Bundle mResultData;

        MyRunnable(ResultReceiver arg1, int arg2, Bundle arg3) {
            ResultReceiver.this = arg1;
            super();
            this.mResultCode = arg2;
            this.mResultData = arg3;
        }

        public void run() {
            ResultReceiver.this.onReceiveResult(this.mResultCode, this.mResultData);
        }
    }

    public static final Parcelable$Creator CREATOR;
    final Handler mHandler;
    final boolean mLocal;
    IResultReceiver mReceiver;

    static {
        ResultReceiver.CREATOR = new android.support.v4.os.ResultReceiver$1();
    }

    public ResultReceiver(Handler arg2) {
        super();
        this.mLocal = true;
        this.mHandler = arg2;
    }

    ResultReceiver(Parcel arg2) {
        super();
        this.mLocal = false;
        this.mHandler = null;
        this.mReceiver = Stub.asInterface(arg2.readStrongBinder());
    }

    public int describeContents() {
        return 0;
    }

    protected void onReceiveResult(int arg1, Bundle arg2) {
    }

    public void send(int arg3, Bundle arg4) {
        if(this.mLocal) {
            Handler v0 = this.mHandler;
            if(v0 != null) {
                v0.post(new MyRunnable(this, arg3, arg4));
                return;
            }

            this.onReceiveResult(arg3, arg4);
            return;
        }

        IResultReceiver v2 = this.mReceiver;
        if(v2 != null) {
            try {
                v2.send(arg3, arg4);
                return;
            }
            catch(RemoteException ) {
                return;
            }
        }
    }

    public void writeToParcel(Parcel arg1, int arg2) {
        __monitor_enter(this);
        try {
            if(this.mReceiver == null) {
                this.mReceiver = new MyResultReceiver(this);
            }

            arg1.writeStrongBinder(this.mReceiver.asBinder());
            __monitor_exit(this);
            return;
        label_12:
            __monitor_exit(this);
        }
        catch(Throwable v1) {
            goto label_12;
        }

        throw v1;
    }
}

