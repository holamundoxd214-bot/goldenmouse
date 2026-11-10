package moe.shizuku.api;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public class BinderContainer implements Parcelable {
    class moe.shizuku.api.BinderContainer$1 implements Parcelable$Creator {
        moe.shizuku.api.BinderContainer$1() {
            super();
        }

        public Object createFromParcel(Parcel arg1) {
            return this.createFromParcel(arg1);
        }

        public BinderContainer createFromParcel(Parcel arg1) {
            return new BinderContainer(arg1);
        }

        public Object[] newArray(int arg1) {
            return this.newArray(arg1);
        }

        public BinderContainer[] newArray(int arg1) {
            return new BinderContainer[arg1];
        }
    }

    public static final Parcelable$Creator CREATOR;
    public IBinder binder;

    static {
        BinderContainer.CREATOR = new moe.shizuku.api.BinderContainer$1();
    }

    public BinderContainer(IBinder arg1) {
        super();
        this.binder = arg1;
    }

    protected BinderContainer(Parcel arg1) {
        super();
        this.binder = arg1.readStrongBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg1, int arg2) {
        arg1.writeStrongBinder(this.binder);
    }
}

