package androidx.compose.foundation.lazy.layout;

import kotlin.jvm.functions.Function1;

public final class LazyLayoutSemanticsModifierNode$$ExternalSyntheticLambda3 implements Function1 {
    public LazyLayoutSemanticsModifierNode$$ExternalSyntheticLambda3(LazyLayoutSemanticsModifierNode arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Boolean.valueOf(LazyLayoutSemanticsModifierNode.updateCachedSemanticsValues$lambda$2(this.f$0, ((Integer)arg1).intValue()));
    }
}

