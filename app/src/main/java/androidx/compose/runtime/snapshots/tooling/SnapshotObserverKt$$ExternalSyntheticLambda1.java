package androidx.compose.runtime.snapshots.tooling;

import androidx.compose.runtime.snapshots.ObserverHandle;

public final class SnapshotObserverKt$$ExternalSyntheticLambda1 implements ObserverHandle {
    public SnapshotObserverKt$$ExternalSyntheticLambda1(SnapshotObserver arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void dispose() {
        SnapshotObserverKt.observeSnapshots$lambda$1(this.f$0);
    }
}

