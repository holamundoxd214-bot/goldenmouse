package androidx.compose.runtime.tooling;

import kotlin.jvm.functions.Function0;

public final class CompositionErrorContextImpl$$ExternalSyntheticLambda0 implements Function0 {
    public CompositionErrorContextImpl$$ExternalSyntheticLambda0(CompositionErrorContextImpl arg1, Object arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke() {
        return CompositionErrorContextImpl.attachComposeStackTrace$lambda$0(this.f$0, this.f$1);
    }
}

