package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.Snapshot;
import java.util.Set;
import kotlin.jvm.functions.Function2;

public final class MultiSubscriptionSnapshotFlowManager$$ExternalSyntheticLambda2 implements Function2 {
    public MultiSubscriptionSnapshotFlowManager$$ExternalSyntheticLambda2(MultiSubscriptionSnapshotFlowManager arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2) {
        return MultiSubscriptionSnapshotFlowManager.unregisterApplyObserver$lambda$0(this.f$0, ((Set)arg1), ((Snapshot)arg2));
    }
}

