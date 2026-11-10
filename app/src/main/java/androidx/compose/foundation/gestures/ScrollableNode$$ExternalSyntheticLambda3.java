package androidx.compose.foundation.gestures;

import kotlin.jvm.functions.Function2;

public final class ScrollableNode$$ExternalSyntheticLambda3 implements Function2 {
    public ScrollableNode$$ExternalSyntheticLambda3(ScrollableNode arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2) {
        return Boolean.valueOf(ScrollableNode.setScrollSemanticsActions$lambda$0(this.f$0, ((Float)arg1).floatValue(), ((Float)arg2).floatValue()));
    }
}

