package androidx.compose.material3.internal;

import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.jvm.functions.Function1;

public final class ChildSemanticsNode$$ExternalSyntheticLambda0 implements Function1 {
    public ChildSemanticsNode$$ExternalSyntheticLambda0(SemanticsPropertyReceiver arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Boolean.valueOf(ChildSemanticsNode.applySemantics$lambda$1(this.f$0, ((TraversableNode)arg1)));
    }
}

