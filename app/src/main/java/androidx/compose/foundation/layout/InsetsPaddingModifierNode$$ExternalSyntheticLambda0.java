package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.jvm.functions.Function1;

public final class InsetsPaddingModifierNode$$ExternalSyntheticLambda0 implements Function1 {
    public InsetsPaddingModifierNode$$ExternalSyntheticLambda0(Placeable arg1, int arg2, int arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return InsetsPaddingModifierNode.measure_3p2s80s$lambda$0(this.f$0, this.f$1, this.f$2, ((PlacementScope)arg3));
    }
}

