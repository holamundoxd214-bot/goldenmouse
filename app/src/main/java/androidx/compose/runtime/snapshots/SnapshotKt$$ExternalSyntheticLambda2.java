package androidx.compose.runtime.snapshots;

import kotlin.jvm.functions.Function1;

public final class SnapshotKt$$ExternalSyntheticLambda2 implements Function1 {
    public SnapshotKt$$ExternalSyntheticLambda2(Function1 arg1, Function1 arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return SnapshotKt.mergedWriteObserver$lambda$0(this.f$0, this.f$1, arg2);
    }
}

