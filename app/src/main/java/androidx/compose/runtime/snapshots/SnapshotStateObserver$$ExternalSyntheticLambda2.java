package androidx.compose.runtime.snapshots;

import kotlin.jvm.functions.Function1;

public final class SnapshotStateObserver$$ExternalSyntheticLambda2 implements Function1 {
    public SnapshotStateObserver$$ExternalSyntheticLambda2(SnapshotStateObserver arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return SnapshotStateObserver.readObserver$lambda$0(this.f$0, arg1);
    }
}

