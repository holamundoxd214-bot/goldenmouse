package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.functions.Function2;

public final class Arrangement$$ExternalSyntheticLambda3 implements Function2 {
    public Arrangement$$ExternalSyntheticLambda3(Vertical arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2) {
        return Integer.valueOf(Arrangement.aligned$lambda$1(this.f$0, ((Integer)arg1).intValue(), ((LayoutDirection)arg2)));
    }
}

