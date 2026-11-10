package androidx.compose.runtime;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u0000 \u000E2\u00020\u00012\u00020\u0002:\u0001\u000EB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0016J\b\u0010\r\u001A\u00020\fH\u0016¨\u0006\u000F"}, d2={"Landroidx/compose/runtime/ParcelableSnapshotMutableFloatState;", "Landroidx/compose/runtime/SnapshotMutableFloatStateImpl;", "Landroid/os/Parcelable;", "value", "", "<init>", "(F)V", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "describeContents", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class ParcelableSnapshotMutableFloatState extends SnapshotMutableFloatStateImpl implements Parcelable {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001C\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003¨\u0006\b"}, d2={"Landroidx/compose/runtime/ParcelableSnapshotMutableFloatState$Companion;", "", "<init>", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Landroidx/compose/runtime/ParcelableSnapshotMutableFloatState;", "getCREATOR$annotations", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
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
        ParcelableSnapshotMutableFloatState.Companion = new Companion(null);
        ParcelableSnapshotMutableFloatState.CREATOR = new ParcelableSnapshotMutableFloatState$Companion$CREATOR$1();
    }

    public ParcelableSnapshotMutableFloatState(float arg1) {
        super(arg1);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg1, int arg2) {
        arg1.writeFloat(this.getFloatValue());
    }
}

