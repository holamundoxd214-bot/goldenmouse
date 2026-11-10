package androidx.lifecycle;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class Transformations$$ExternalSyntheticLambda0 implements Function1 {
    public Transformations$$ExternalSyntheticLambda0(Function1 arg1, ObjectRef arg2, MediatorLiveData arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return Transformations.switchMap$lambda$0(this.f$0, this.f$1, this.f$2, arg3);
    }
}

