package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.SnapshotMutableState;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A/\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001A\u0002H\u00022\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0000¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2={"createSnapshotMutableState", "Landroidx/compose/runtime/snapshots/SnapshotMutableState;", "T", "value", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "(Ljava/lang/Object;Landroidx/compose/runtime/SnapshotMutationPolicy;)Landroidx/compose/runtime/snapshots/SnapshotMutableState;", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SnapshotState_androidKt {
    public static final SnapshotMutableState createSnapshotMutableState(Object arg1, SnapshotMutationPolicy arg2) {
        return new ParcelableSnapshotMutableState(arg1, arg2);
    }
}

