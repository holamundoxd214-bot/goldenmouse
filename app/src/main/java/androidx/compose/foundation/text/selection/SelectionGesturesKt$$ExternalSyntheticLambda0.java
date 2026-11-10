package androidx.compose.foundation.text.selection;

import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.jvm.functions.Function1;

public final class SelectionGesturesKt$$ExternalSyntheticLambda0 implements Function1 {
    public SelectionGesturesKt$$ExternalSyntheticLambda0(MouseSelectionObserver arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return SelectionGesturesKt.mouseSelection$lambda$0(this.f$0, ((PointerInputChange)arg1));
    }
}

