package androidx.compose.runtime.snapshots;

import kotlin.jvm.functions.Function1;

public final class SnapshotKt$$ExternalSyntheticLambda3 implements Function1 {
    public SnapshotKt$$ExternalSyntheticLambda3(Function1 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return SnapshotKt.takeNewSnapshot$lambda$0(this.f$0, ((SnapshotIdSet)arg1));
    }
}

