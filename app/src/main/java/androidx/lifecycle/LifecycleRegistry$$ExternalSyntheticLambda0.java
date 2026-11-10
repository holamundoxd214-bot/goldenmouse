package androidx.lifecycle;

import java.util.Map$Entry;
import kotlin.jvm.functions.Function1;

public final class LifecycleRegistry$$ExternalSyntheticLambda0 implements Function1 {
    public LifecycleRegistry$$ExternalSyntheticLambda0(LifecycleRegistry arg1, LifecycleOwner arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return LifecycleRegistry.backwardPass$lambda$0(this.f$0, this.f$1, ((Map$Entry)arg2));
    }
}

