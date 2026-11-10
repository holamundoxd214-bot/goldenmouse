package androidx.lifecycle;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$BooleanRef;

public final class Transformations$$ExternalSyntheticLambda3 implements Function1 {
    public Transformations$$ExternalSyntheticLambda3(MediatorLiveData arg1, BooleanRef arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return Transformations.distinctUntilChanged$lambda$0(this.f$0, this.f$1, arg2);
    }
}

