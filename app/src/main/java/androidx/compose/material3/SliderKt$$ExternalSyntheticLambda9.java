package androidx.compose.material3;

import kotlin.jvm.functions.Function1;
import kotlin.ranges.ClosedFloatingPointRange;

public final class SliderKt$$ExternalSyntheticLambda9 implements Function1 {
    public SliderKt$$ExternalSyntheticLambda9(ClosedFloatingPointRange arg1, RangeSliderState arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return Boolean.valueOf(SliderKt.rangeSliderEndThumbSemantics$lambda$58$lambda$57(this.f$0, this.f$1, ((Float)arg2).floatValue()));
    }
}

