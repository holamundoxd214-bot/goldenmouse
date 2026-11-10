package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public class ParcelImpl implements Parcelable {
    final class androidx.versionedparcelable.ParcelImpl$1 implements Parcelable$Creator {
        androidx.versionedparcelable.ParcelImpl$1() {
            super();
        }

        public ParcelImpl createFromParcel(Parcel arg1) {
            return new ParcelImpl(arg1);
        }

        public Object createFromParcel(Parcel arg1) {
            return this.createFromParcel(arg1);
        }

        public ParcelImpl[] newArray(int arg1) {
            return new ParcelImpl[arg1];
        }

        public Object[] newArray(int arg1) {
            return this.newArray(arg1);
        }
    }

    public static final Parcelable$Creator CREATOR;
    private final VersionedParcelable mParcel;

    static {
        ParcelImpl.CREATOR = new androidx.versionedparcelable.ParcelImpl$1();
    }

    protected ParcelImpl(Parcel arg2) {
        super();
        this.mParcel = new VersionedParcelParcel(arg2).readVersionedParcelable();
    }

    public ParcelImpl(VersionedParcelable arg1) {
        super();
        this.mParcel = arg1;
    }

    public int describeContents() {
        return 0;
    }

    public VersionedParcelable getVersionedParcel() {
        return this.mParcel;
    }

    public void writeToParcel(Parcel arg1, int arg2) {
        new VersionedParcelParcel(arg1).writeVersionedParcelable(this.mParcel);
    }
}

