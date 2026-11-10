package androidx.compose.foundation.gestures;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;

public final class ScrollExtensionsKt$animateScrollBy$2$$ExternalSyntheticLambda0 implements Function2 {
    public ScrollExtensionsKt$animateScrollBy$2$$ExternalSyntheticLambda0(FloatRef arg1, ScrollScope arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return ScrollExtensionsKt$animateScrollBy$2.invokeSuspend$lambda$0(this.f$0, this.f$1, ((Float)arg2).floatValue(), ((Float)arg3).floatValue());
    }
}

