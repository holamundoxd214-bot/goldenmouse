package androidx.compose.runtime.snapshots;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;

public final class SnapshotStateList$$ExternalSyntheticLambda0 implements Function1 {
    public SnapshotStateList$$ExternalSyntheticLambda0(Collection arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Boolean.valueOf(SnapshotStateList.retainAll$lambda$0(this.f$0, ((List)arg1)));
    }
}

