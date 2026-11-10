package androidx.lifecycle;

import kotlin.jvm.functions.Function1;

public final class Transformations$switchMap$2$$ExternalSyntheticLambda0 implements Function1 {
    public Transformations$switchMap$2$$ExternalSyntheticLambda0(MediatorLiveData arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Transformations$switchMap$2.onChanged$lambda$0(this.f$0, arg1);
    }
}

