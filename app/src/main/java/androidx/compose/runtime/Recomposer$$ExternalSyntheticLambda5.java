package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import kotlin.jvm.functions.Function1;

public final class Recomposer$$ExternalSyntheticLambda5 implements Function1 {
    public Recomposer$$ExternalSyntheticLambda5(ControlledComposition arg1, MutableScatterSet arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return Recomposer.writeObserverOf$lambda$0(this.f$0, this.f$1, arg2);
    }
}

