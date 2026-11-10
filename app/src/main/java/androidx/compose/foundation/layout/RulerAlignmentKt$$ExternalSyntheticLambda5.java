package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.RectRulers;
import androidx.compose.ui.unit.Constraints;
import kotlin.jvm.functions.Function3;

public final class RulerAlignmentKt$$ExternalSyntheticLambda5 implements Function3 {
    public RulerAlignmentKt$$ExternalSyntheticLambda5(RectRulers arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2, Object arg3) {
        return RulerAlignmentKt.fitOutside$lambda$0(this.f$0, ((MeasureScope)arg1), ((Measurable)arg2), ((Constraints)arg3));
    }
}

