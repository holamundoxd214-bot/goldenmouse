package androidx.compose.runtime;

import kotlin.Pair;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

public final class MovableContentKt$$ExternalSyntheticLambda12 implements Function3 {
    public MovableContentKt$$ExternalSyntheticLambda12(Function4 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2, Object arg3) {
        return MovableContentKt.movableContentWithReceiverOf$lambda$2(this.f$0, ((Pair)arg1), ((Composer)arg2), ((Integer)arg3).intValue());
    }
}

