package androidx.compose.runtime;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u0000 \u0010*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001\u0010B\u001D\u0012\u0006\u0010\u0004\u001A\u00028\u0000\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0016J\b\u0010\u000F\u001A\u00020\u000EH\u0016¨\u0006\u0011"}, d2={"Landroidx/compose/runtime/ParcelableSnapshotMutableState;", "T", "Landroidx/compose/runtime/SnapshotMutableStateImpl;", "Landroid/os/Parcelable;", "value", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "<init>", "(Ljava/lang/Object;Landroidx/compose/runtime/SnapshotMutationPolicy;)V", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "describeContents", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class ParcelableSnapshotMutableState extends SnapshotMutableStateImpl implements Parcelable {
    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R$\u0010\b\u001A\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n0\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000B\u0010\u0003¨\u0006\f"}, d2={"Landroidx/compose/runtime/ParcelableSnapshotMutableState$Companion;", "", "<init>", "()V", "PolicyNeverEquals", "", "PolicyStructuralEquality", "PolicyReferentialEquality", "CREATOR", "Landroid/os/Parcelable$Creator;", "Landroidx/compose/runtime/ParcelableSnapshotMutableState;", "getCREATOR$annotations", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static void getCREATOR$annotations() {
        }
    }

    public static final Parcelable$Creator CREATOR = null;
    public static final Companion Companion = null;
    private static final int PolicyNeverEquals = 0;
    private static final int PolicyReferentialEquality = 2;
    private static final int PolicyStructuralEquality = 1;

    static {
        ParcelableSnapshotMutableState.Companion = new Companion(null);
        ParcelableSnapshotMutableState.CREATOR = new ParcelableSnapshotMutableState$Companion$CREATOR$1();
    }

    public ParcelableSnapshotMutableState(Object arg1, SnapshotMutationPolicy arg2) {
        super(arg1, arg2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel arg1, int arg2) {
        int v0_1;
        arg1.writeValue(this.getValue());
        SnapshotMutationPolicy v0 = this.getPolicy();
        if(Intrinsics.areEqual(v0, SnapshotStateKt.neverEqualPolicy())) {
            v0_1 = 0;
        }
        else if(Intrinsics.areEqual(v0, SnapshotStateKt.structuralEqualityPolicy())) {
            v0_1 = 1;
        }
        else if(Intrinsics.areEqual(v0, SnapshotStateKt.referentialEqualityPolicy())) {
            v0_1 = 2;
        }
        else {
            goto label_19;
        }

        arg1.writeInt(v0_1);
        return;
    label_19:
        throw new IllegalStateException("Only known types of MutableState\'s SnapshotMutationPolicy are supported");
    }
}

