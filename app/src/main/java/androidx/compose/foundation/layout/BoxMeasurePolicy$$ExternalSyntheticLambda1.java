package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.jvm.functions.Function1;

public final class BoxMeasurePolicy$$ExternalSyntheticLambda1 implements Function1 {
    public BoxMeasurePolicy$$ExternalSyntheticLambda1(Placeable arg1, Measurable arg2, MeasureScope arg3, int arg4, int arg5, BoxMeasurePolicy arg6) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
    }

    public final Object invoke(Object arg8) {
        return BoxMeasurePolicy.measure_3p2s80s$lambda$1(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, arg8);
    }
}

