package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.node.TraversableNode;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class PrefetchHandleProvider$HandleAndRequestImpl$$ExternalSyntheticLambda0 implements Function1 {
    public PrefetchHandleProvider$HandleAndRequestImpl$$ExternalSyntheticLambda0(ObjectRef arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return HandleAndRequestImpl.resolveNestedPrefetchStates$lambda$1(this.f$0, ((TraversableNode)arg1));
    }
}

