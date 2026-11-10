package androidx.compose.runtime.snapshots.tooling;

import androidx.compose.runtime.snapshots.Snapshot;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0000\bg\u0018\u00002\u00020\u0001J\u001C\u0010\u0002\u001A\u0004\u0018\u00010\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J$\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u00052\b\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\u0010\u000B\u001A\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\f\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0005H\u0016J\u001E\u0010\r\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u00052\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00010\u000FH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2={"Landroidx/compose/runtime/snapshots/tooling/SnapshotObserver;", "", "onPreCreate", "Landroidx/compose/runtime/snapshots/tooling/SnapshotInstanceObservers;", "parent", "Landroidx/compose/runtime/snapshots/Snapshot;", "readonly", "", "onCreated", "", "snapshot", "observers", "onPreDispose", "onApplied", "changed", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public interface SnapshotObserver {
    default void onApplied(Snapshot arg1, Set arg2) {
    }

    default void onCreated(Snapshot arg1, Snapshot arg2, SnapshotInstanceObservers arg3) {
    }

    default SnapshotInstanceObservers onPreCreate(Snapshot arg1, boolean arg2) {
        return null;
    }

    default void onPreDispose(Snapshot arg1) {
    }
}

