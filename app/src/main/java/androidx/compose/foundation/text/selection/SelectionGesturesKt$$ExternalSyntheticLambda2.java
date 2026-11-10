package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.jvm.functions.Function1;

public final class SelectionGesturesKt$$ExternalSyntheticLambda2 implements Function1 {
    public SelectionGesturesKt$$ExternalSyntheticLambda2(TextDragObserver arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return SelectionGesturesKt.touchSelectionFirstPress$lambda$0(this.f$0, ((PointerInputChange)arg1));
    }
}

