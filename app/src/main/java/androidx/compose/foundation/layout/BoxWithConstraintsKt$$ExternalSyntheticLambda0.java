package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

public final class BoxWithConstraintsKt$$ExternalSyntheticLambda0 implements Function2 {
    public BoxWithConstraintsKt$$ExternalSyntheticLambda0(MeasurePolicy arg1, Function3 arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return BoxWithConstraintsKt.$r8$lambda$p9yh-8kbO_kwrsRP1ZyRK8puGy8(this.f$0, this.f$1, ((SubcomposeMeasureScope)arg2), ((Constraints)arg3));
    }
}

