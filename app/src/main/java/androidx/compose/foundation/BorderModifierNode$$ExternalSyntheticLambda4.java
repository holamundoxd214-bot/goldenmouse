package androidx.compose.foundation;

import androidx.compose.ui.draw.CacheDrawScope;
import kotlin.jvm.functions.Function1;

public final class BorderModifierNode$$ExternalSyntheticLambda4 implements Function1 {
    public BorderModifierNode$$ExternalSyntheticLambda4(BorderModifierNode arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return BorderModifierNode.drawWithCacheModifierNode$lambda$0(this.f$0, ((CacheDrawScope)arg1));
    }
}

