package androidx.compose.runtime.snapshots;

import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function1;

public final class SnapshotStateSet$$ExternalSyntheticLambda0 implements Function1 {
    public SnapshotStateSet$$ExternalSyntheticLambda0(Collection arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Boolean.valueOf(SnapshotStateSet.retainAll$lambda$0(this.f$0, ((Set)arg1)));
    }
}

