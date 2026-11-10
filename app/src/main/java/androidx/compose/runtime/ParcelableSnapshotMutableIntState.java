package androidx.compose.runtime;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u0000 \r2\u00020\u00012\u00020\u0002:\u0001\rB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0004H\u0016J\b\u0010\f\u001A\u00020\u0004H\u0016¨\u0006\u000E"}, d2={"Landroidx/compose/runtime/ParcelableSnapshotMutableIntState;", "Landroidx/compose/runtime/SnapshotMutableIntStateImpl;", "Landroid/os/Parcelable;", "value", "", "<init>", "(I)V", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "describeContents", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class ParcelableSnapshotMutableIntState extends SnapshotMutableIntStateImpl implements Parcelable {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001C\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003¨\u0006\b"}, d2={"Landroidx/compose/runtime/ParcelableSnapshotMutableIntState$Companion;", "", "<init>", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Landroidx/compose/runtime/ParcelableSnapshotMutableIntState;", "getCREATOR$annotations", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static void getCREATOR$annotations() {
        }
    }

    public static final Parcelable$Creator CREATOR;
    public static final Companion Companion;

    static {
        ParcelableSnapshotMutableIntState.Companion = new Companion(null);
        ParcelableSnapshotMutableIntState.CREATOR = new ParcelableSnapshotMutableIntState$Companion$CREATOR$1();
    }

    public ParcelableSnapshotMutableIntState(int arg1) {
        super(arg1);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg1, int arg2) {
        arg1.writeInt(this.getIntValue());
    }
}

