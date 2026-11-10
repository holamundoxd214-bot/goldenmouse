package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.jvm.functions.Function1;

public final class TextFieldCoreModifierNode$$ExternalSyntheticLambda0 implements Function1 {
    public TextFieldCoreModifierNode$$ExternalSyntheticLambda0(TextFieldCoreModifierNode arg1, int arg2, Placeable arg3, MeasureScope arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg4) {
        return TextFieldCoreModifierNode.measureHorizontalScroll_3p2s80s$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, ((PlacementScope)arg4));
    }
}

