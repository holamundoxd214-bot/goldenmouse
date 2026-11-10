package androidx.compose.runtime.snapshots;

import kotlin.jvm.functions.Function2;

public final class Snapshot$Companion$$ExternalSyntheticLambda0 implements ObserverHandle {
    public Snapshot$Companion$$ExternalSyntheticLambda0(Function2 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void dispose() {
        Companion.registerApplyObserver$lambda$1(this.f$0);
    }
}

