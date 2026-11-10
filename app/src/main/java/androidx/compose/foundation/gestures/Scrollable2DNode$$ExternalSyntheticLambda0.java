package androidx.compose.foundation.gestures;

import kotlin.jvm.functions.Function2;

public final class Scrollable2DNode$$ExternalSyntheticLambda0 implements Function2 {
    public Scrollable2DNode$$ExternalSyntheticLambda0(Scrollable2DNode arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2) {
        return Boolean.valueOf(Scrollable2DNode.setScrollSemanticsActions$lambda$0(this.f$0, ((Float)arg1).floatValue(), ((Float)arg2).floatValue()));
    }
}

