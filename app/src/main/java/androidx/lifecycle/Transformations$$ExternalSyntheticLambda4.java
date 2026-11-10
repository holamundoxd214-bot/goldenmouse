package androidx.lifecycle;

import androidx.arch.core.util.Function;
import kotlin.jvm.functions.Function1;

public final class Transformations$$ExternalSyntheticLambda4 implements Function1 {
    public Transformations$$ExternalSyntheticLambda4(MediatorLiveData arg1, Function arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return Transformations.map$lambda$1(this.f$0, this.f$1, arg2);
    }
}

