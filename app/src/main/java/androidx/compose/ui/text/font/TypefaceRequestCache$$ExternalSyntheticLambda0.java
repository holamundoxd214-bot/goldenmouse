package androidx.compose.ui.text.font;

import kotlin.jvm.functions.Function1;

public final class TypefaceRequestCache$$ExternalSyntheticLambda0 implements Function1 {
    public TypefaceRequestCache$$ExternalSyntheticLambda0(TypefaceRequestCache arg1, TypefaceRequest arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return TypefaceRequestCache.runCached$lambda$1(this.f$0, this.f$1, ((TypefaceResult)arg2));
    }
}

