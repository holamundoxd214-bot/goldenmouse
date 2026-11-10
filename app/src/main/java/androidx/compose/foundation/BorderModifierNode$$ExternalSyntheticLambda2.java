package androidx.compose.foundation;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.jvm.functions.Function1;

public final class BorderModifierNode$$ExternalSyntheticLambda2 implements Function1 {
    public BorderModifierNode$$ExternalSyntheticLambda2(Generic arg1, Brush arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return BorderModifierNode.drawGenericBorder$lambda$0(this.f$0, this.f$1, ((ContentDrawScope)arg2));
    }
}

