package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import kotlin.jvm.functions.Function1;

public final class RecalculateWindowInsetsModifierNode$$ExternalSyntheticLambda1 implements Function1 {
    public RecalculateWindowInsetsModifierNode$$ExternalSyntheticLambda1(RecalculateWindowInsetsModifierNode arg1, Measurable arg2, int arg3, int arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg4) {
        return RecalculateWindowInsetsModifierNode.measure_3p2s80s$lambda$1(this.f$0, this.f$1, this.f$2, this.f$3, ((PlacementScope)arg4));
    }
}

