package androidx.compose.material3;

import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.ClosedFloatingPointRange;

public final class SliderKt$$ExternalSyntheticLambda19 implements Function1 {
    public SliderKt$$ExternalSyntheticLambda19(boolean arg1, RangeSliderState arg2, ClosedFloatingPointRange arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return SliderKt.rangeSliderStartThumbSemantics$lambda$55(this.f$0, this.f$1, this.f$2, ((SemanticsPropertyReceiver)arg3));
    }
}

