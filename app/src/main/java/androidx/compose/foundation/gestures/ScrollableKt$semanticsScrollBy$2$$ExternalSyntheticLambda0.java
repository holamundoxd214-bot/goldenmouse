package androidx.compose.foundation.gestures;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;

public final class ScrollableKt$semanticsScrollBy$2$$ExternalSyntheticLambda0 implements Function2 {
    public ScrollableKt$semanticsScrollBy$2$$ExternalSyntheticLambda0(FloatRef arg1, ScrollingLogic arg2, NestedScrollScope arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3, Object arg4) {
        return ScrollableKt$semanticsScrollBy$2.invokeSuspend$lambda$0(this.f$0, this.f$1, this.f$2, ((Float)arg3).floatValue(), ((Float)arg4).floatValue());
    }
}

