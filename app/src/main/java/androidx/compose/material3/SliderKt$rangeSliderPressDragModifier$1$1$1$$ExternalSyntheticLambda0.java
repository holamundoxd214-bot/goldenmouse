package androidx.compose.material3;

import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$BooleanRef;

public final class SliderKt$rangeSliderPressDragModifier$1$1$1$$ExternalSyntheticLambda0 implements Function1 {
    public SliderKt$rangeSliderPressDragModifier$1$1$1$$ExternalSyntheticLambda0(RangeSliderState arg1, BooleanRef arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1.invokeSuspend$lambda$1(this.f$0, this.f$1, ((PointerInputChange)arg2));
    }
}

