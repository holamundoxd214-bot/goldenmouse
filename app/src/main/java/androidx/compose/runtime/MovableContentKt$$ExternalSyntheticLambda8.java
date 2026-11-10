package androidx.compose.runtime;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;

public final class MovableContentKt$$ExternalSyntheticLambda8 implements Function3 {
    public MovableContentKt$$ExternalSyntheticLambda8(Function6 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2, Object arg3) {
        return MovableContentKt.movableContentOf$lambda$6(this.f$0, ((Object[])arg1), ((Composer)arg2), ((Integer)arg3).intValue());
    }
}

