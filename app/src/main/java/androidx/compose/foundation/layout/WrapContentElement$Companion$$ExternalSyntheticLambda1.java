package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.functions.Function2;

public final class WrapContentElement$Companion$$ExternalSyntheticLambda1 implements Function2 {
    public WrapContentElement$Companion$$ExternalSyntheticLambda1(Vertical arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2) {
        return Companion.height$lambda$0(this.f$0, ((IntSize)arg1), ((LayoutDirection)arg2));
    }
}

