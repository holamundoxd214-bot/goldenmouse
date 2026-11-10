package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import kotlin.jvm.functions.Function1;

public final class LongPressTextDragObserverKt$$ExternalSyntheticLambda0 implements Function1 {
    public LongPressTextDragObserverKt$$ExternalSyntheticLambda0(TextDragObserver arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return LongPressTextDragObserverKt.detectDragGesturesWithObserver$lambda$0(this.f$0, ((Offset)arg1));
    }
}

