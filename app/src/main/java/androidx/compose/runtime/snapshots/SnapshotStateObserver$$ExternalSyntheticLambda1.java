package androidx.compose.runtime.snapshots;

import java.util.Set;
import kotlin.jvm.functions.Function2;

public final class SnapshotStateObserver$$ExternalSyntheticLambda1 implements Function2 {
    public SnapshotStateObserver$$ExternalSyntheticLambda1(SnapshotStateObserver arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2) {
        return SnapshotStateObserver.applyObserver$lambda$0(this.f$0, ((Set)arg1), ((Snapshot)arg2));
    }
}

