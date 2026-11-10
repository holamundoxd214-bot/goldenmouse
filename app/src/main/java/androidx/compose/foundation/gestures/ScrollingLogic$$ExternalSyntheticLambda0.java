package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import kotlin.jvm.functions.Function1;

public final class ScrollingLogic$$ExternalSyntheticLambda0 implements Function1 {
    public ScrollingLogic$$ExternalSyntheticLambda0(ScrollingLogic arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return ScrollingLogic.performScrollForOverscroll$lambda$0(this.f$0, ((Offset)arg1));
    }
}

