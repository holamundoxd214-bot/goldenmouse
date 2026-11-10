package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext$Element;
import kotlin.jvm.functions.Function2;

public final class SafeCollector_commonKt$$ExternalSyntheticLambda0 implements Function2 {
    public SafeCollector_commonKt$$ExternalSyntheticLambda0(SafeCollector arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2) {
        return Integer.valueOf(SafeCollector_commonKt.checkContext$lambda$0(this.f$0, ((Integer)arg1).intValue(), ((Element)arg2)));
    }
}

