package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import kotlin.jvm.functions.Function2;

public final class FlowMeasureLazyPolicy$$ExternalSyntheticLambda1 implements Function2 {
    public FlowMeasureLazyPolicy$$ExternalSyntheticLambda1(FlowMeasureLazyPolicy arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2) {
        return FlowMeasureLazyPolicy.getMeasurePolicy$lambda$0(this.f$0, ((SubcomposeMeasureScope)arg1), ((Constraints)arg2));
    }
}

