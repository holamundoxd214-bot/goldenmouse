package androidx.compose.foundation.text.selection;

import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$BooleanRef;

public final class SelectionGesturesKt$$ExternalSyntheticLambda1 implements Function1 {
    public SelectionGesturesKt$$ExternalSyntheticLambda1(MouseSelectionObserver arg1, SelectionAdjustment arg2, BooleanRef arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return SelectionGesturesKt.mouseSelection$lambda$2(this.f$0, this.f$1, this.f$2, ((PointerInputChange)arg3));
    }
}

