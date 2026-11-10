package androidx.compose.runtime;

import kotlin.jvm.functions.Function0;

public final class Recomposer$$ExternalSyntheticLambda3 implements Function0 {
    public Recomposer$$ExternalSyntheticLambda3(Recomposer arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke() {
        return Recomposer.nextFrameEndCallbackQueue$lambda$0(this.f$0);
    }
}

