package androidx.compose.runtime.snapshots.tooling;

import kotlin.jvm.functions.Function1;

public final class SnapshotObserverKt$$ExternalSyntheticLambda0 implements Function1 {
    public SnapshotObserverKt$$ExternalSyntheticLambda0(Function1 arg1, Function1 arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return SnapshotObserverKt.mergeObservers$lambda$1(this.f$0, this.f$1, arg2);
    }
}

