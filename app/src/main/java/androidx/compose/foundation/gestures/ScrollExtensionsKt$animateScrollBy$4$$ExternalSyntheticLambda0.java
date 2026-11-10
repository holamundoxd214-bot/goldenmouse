package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$LongRef;

public final class ScrollExtensionsKt$animateScrollBy$4$$ExternalSyntheticLambda0 implements Function2 {
    public ScrollExtensionsKt$animateScrollBy$4$$ExternalSyntheticLambda0(LongRef arg1, Scroll2DScope arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return ScrollExtensionsKt$animateScrollBy$4.invokeSuspend$lambda$0(this.f$0, this.f$1, ((Offset)arg2), ((Offset)arg3));
    }
}

