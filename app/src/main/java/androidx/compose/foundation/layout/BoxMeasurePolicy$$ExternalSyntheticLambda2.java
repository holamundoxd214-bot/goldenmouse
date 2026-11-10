package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$IntRef;

public final class BoxMeasurePolicy$$ExternalSyntheticLambda2 implements Function1 {
    public BoxMeasurePolicy$$ExternalSyntheticLambda2(Placeable[] arg1, List arg2, MeasureScope arg3, IntRef arg4, IntRef arg5, BoxMeasurePolicy arg6) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
    }

    public final Object invoke(Object arg8) {
        return BoxMeasurePolicy.measure_3p2s80s$lambda$4(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, arg8);
    }
}

