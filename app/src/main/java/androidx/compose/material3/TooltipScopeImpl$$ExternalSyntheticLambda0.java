package androidx.compose.material3;

import androidx.compose.ui.draw.CacheDrawScope;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public final class TooltipScopeImpl$$ExternalSyntheticLambda0 implements Function1 {
    public TooltipScopeImpl$$ExternalSyntheticLambda0(Function2 arg1, TooltipScopeImpl arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return TooltipScopeImpl.drawCaret$lambda$0(this.f$0, this.f$1, ((CacheDrawScope)arg2));
    }
}

