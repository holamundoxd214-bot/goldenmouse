package androidx.compose.runtime.snapshots;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;

public final class SnapshotStateList$$ExternalSyntheticLambda1 implements Function1 {
    public SnapshotStateList$$ExternalSyntheticLambda1(int arg1, Collection arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return Boolean.valueOf(SnapshotStateList.addAll$lambda$0(this.f$0, this.f$1, ((List)arg2)));
    }
}

