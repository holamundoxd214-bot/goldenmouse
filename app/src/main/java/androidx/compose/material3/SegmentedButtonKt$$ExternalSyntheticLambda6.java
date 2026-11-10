package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import kotlin.jvm.functions.Function3;

public final class SegmentedButtonKt$$ExternalSyntheticLambda6 implements Function3 {
    public SegmentedButtonKt$$ExternalSyntheticLambda6(State arg1, boolean arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3, Object arg4) {
        return SegmentedButtonKt.interactionZIndex$lambda$19(this.f$0, this.f$1, ((MeasureScope)arg2), ((Measurable)arg3), ((Constraints)arg4));
    }
}

