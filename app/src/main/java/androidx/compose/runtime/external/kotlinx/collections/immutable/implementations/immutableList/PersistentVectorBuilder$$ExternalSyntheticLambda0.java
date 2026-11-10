package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.Collection;
import kotlin.jvm.functions.Function1;

public final class PersistentVectorBuilder$$ExternalSyntheticLambda0 implements Function1 {
    public PersistentVectorBuilder$$ExternalSyntheticLambda0(Collection arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Boolean.valueOf(PersistentVectorBuilder.removeAll$lambda$0(this.f$0, arg1));
    }
}

