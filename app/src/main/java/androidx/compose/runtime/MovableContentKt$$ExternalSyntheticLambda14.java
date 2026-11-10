package androidx.compose.runtime;

import kotlin.Triple;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;

public final class MovableContentKt$$ExternalSyntheticLambda14 implements Function3 {
    public MovableContentKt$$ExternalSyntheticLambda14(Function5 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2, Object arg3) {
        return MovableContentKt.movableContentWithReceiverOf$lambda$4(this.f$0, ((Triple)arg1), ((Composer)arg2), ((Integer)arg3).intValue());
    }
}

