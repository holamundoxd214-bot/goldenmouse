package kotlin.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;

public final class CombinedContext$$ExternalSyntheticLambda0 implements Function2 {
    public CombinedContext$$ExternalSyntheticLambda0(CoroutineContext[] arg1, IntRef arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return CombinedContext.writeReplace$lambda$0(this.f$0, this.f$1, ((Unit)arg2), ((Element)arg3));
    }
}

