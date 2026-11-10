package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$LongRef;

public final class Scrollable2DKt$semanticsScrollBy$2$$ExternalSyntheticLambda0 implements Function2 {
    public Scrollable2DKt$semanticsScrollBy$2$$ExternalSyntheticLambda0(LongRef arg1, NestedScrollScope arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return Scrollable2DKt$semanticsScrollBy$2.invokeSuspend$lambda$0(this.f$0, this.f$1, ((Offset)arg2), ((Offset)arg3));
    }
}

