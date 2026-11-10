package androidx.lifecycle;

import kotlin.jvm.functions.Function1;

public final class Transformations$$ExternalSyntheticLambda1 implements Function1 {
    public Transformations$$ExternalSyntheticLambda1(MediatorLiveData arg1, Function1 arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return Transformations.map$lambda$0(this.f$0, this.f$1, arg2);
    }
}

