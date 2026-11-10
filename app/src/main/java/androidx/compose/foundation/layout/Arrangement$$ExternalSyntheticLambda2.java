package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.functions.Function2;

public final class Arrangement$$ExternalSyntheticLambda2 implements Function2 {
    public Arrangement$$ExternalSyntheticLambda2(Horizontal arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2) {
        return Integer.valueOf(Arrangement.aligned$lambda$0(this.f$0, ((Integer)arg1).intValue(), ((LayoutDirection)arg2)));
    }
}

