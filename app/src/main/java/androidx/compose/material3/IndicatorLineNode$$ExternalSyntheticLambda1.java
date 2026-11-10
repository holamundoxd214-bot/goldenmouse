package androidx.compose.material3;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.jvm.functions.Function1;

public final class IndicatorLineNode$$ExternalSyntheticLambda1 implements Function1 {
    public IndicatorLineNode$$ExternalSyntheticLambda1(Path arg1, IndicatorLineNode arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return IndicatorLineNode.drawWithCacheModifierNode$lambda$3$lambda$2(this.f$0, this.f$1, ((ContentDrawScope)arg2));
    }
}

