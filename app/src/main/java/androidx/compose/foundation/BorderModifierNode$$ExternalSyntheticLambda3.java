package androidx.compose.foundation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorFilter;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class BorderModifierNode$$ExternalSyntheticLambda3 implements Function1 {
    public BorderModifierNode$$ExternalSyntheticLambda3(Rect arg1, ObjectRef arg2, long arg3, ColorFilter arg5) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg5;
    }

    public final Object invoke(Object arg7) {
        return BorderModifierNode.drawGenericBorder$lambda$3(this.f$0, this.f$1, this.f$2, this.f$3, arg7);
    }
}

