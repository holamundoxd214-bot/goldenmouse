package androidx.compose.foundation.layout;

import androidx.compose.ui.node.TraversableNode;
import kotlin.jvm.functions.Function1;

public final class InsetsConsumingModifierNode$$ExternalSyntheticLambda0 implements Function1 {
    public InsetsConsumingModifierNode$$ExternalSyntheticLambda0(InsetsConsumingModifierNode arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return InsetsConsumingModifierNode.invalidateChildConsumedInsets$lambda$0(this.f$0, ((TraversableNode)arg1));
    }
}

