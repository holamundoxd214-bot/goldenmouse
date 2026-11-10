package androidx.compose.material3.internal;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;

public final class AnchoredDraggableKt$animateTo$2$$ExternalSyntheticLambda0 implements Function2 {
    public AnchoredDraggableKt$animateTo$2$$ExternalSyntheticLambda0(AnchoredDragScope arg1, FloatRef arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return AnchoredDraggableKt$animateTo$2.invokeSuspend$lambda$0(this.f$0, this.f$1, ((Float)arg2).floatValue(), ((Float)arg3).floatValue());
    }
}

