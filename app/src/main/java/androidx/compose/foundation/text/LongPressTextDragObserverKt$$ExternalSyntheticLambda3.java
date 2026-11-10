package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.jvm.functions.Function2;

public final class LongPressTextDragObserverKt$$ExternalSyntheticLambda3 implements Function2 {
    public LongPressTextDragObserverKt$$ExternalSyntheticLambda3(TextDragObserver arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2) {
        return LongPressTextDragObserverKt.detectDragGesturesWithObserver$lambda$3(this.f$0, ((PointerInputChange)arg1), ((Offset)arg2));
    }
}

