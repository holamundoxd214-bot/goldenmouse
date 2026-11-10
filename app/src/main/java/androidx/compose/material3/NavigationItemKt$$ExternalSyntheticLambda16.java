package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Shape;
import kotlin.jvm.functions.Function2;

public final class NavigationItemKt$$ExternalSyntheticLambda16 implements Function2 {
    public NavigationItemKt$$ExternalSyntheticLambda16(InteractionSource arg1, Shape arg2, int arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3, Object arg4) {
        return NavigationItemKt.IndicatorRipple$lambda$42(this.f$0, this.f$1, this.f$2, ((Composer)arg3), ((Integer)arg4).intValue());
    }
}

