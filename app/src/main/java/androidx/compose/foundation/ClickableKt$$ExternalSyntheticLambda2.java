package androidx.compose.foundation;

import androidx.compose.ui.node.TraversableNode;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$BooleanRef;

public final class ClickableKt$$ExternalSyntheticLambda2 implements Function1 {
    public ClickableKt$$ExternalSyntheticLambda2(BooleanRef arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Boolean.valueOf(ClickableKt.hasScrollableContainer$lambda$0(this.f$0, ((TraversableNode)arg1)));
    }
}

