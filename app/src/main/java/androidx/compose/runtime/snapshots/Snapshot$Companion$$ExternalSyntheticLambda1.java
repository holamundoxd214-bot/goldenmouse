package androidx.compose.runtime.snapshots;

import kotlin.jvm.functions.Function1;

public final class Snapshot$Companion$$ExternalSyntheticLambda1 implements ObserverHandle {
    public Snapshot$Companion$$ExternalSyntheticLambda1(Function1 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void dispose() {
        Companion.registerGlobalWriteObserver$lambda$1(this.f$0);
    }
}

