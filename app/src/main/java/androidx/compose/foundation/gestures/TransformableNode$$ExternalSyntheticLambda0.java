package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import kotlin.jvm.functions.Function1;

public final class TransformableNode$$ExternalSyntheticLambda0 implements Function1 {
    public TransformableNode$$ExternalSyntheticLambda0(TransformableNode arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Boolean.valueOf(TransformableNode.updatedCanPan$lambda$0(this.f$0, ((Offset)arg1)));
    }
}

