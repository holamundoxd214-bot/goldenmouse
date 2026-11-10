package androidx.compose.runtime;

import kotlin.jvm.functions.Function1;

public final class Recomposer$$ExternalSyntheticLambda1 implements Function1 {
    public Recomposer$$ExternalSyntheticLambda1(ControlledComposition arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Recomposer.readObserverOf$lambda$0(this.f$0, arg1);
    }
}

