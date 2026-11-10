package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$LongRef;

public final class SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1$$ExternalSyntheticLambda0 implements Function2 {
    public SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1$$ExternalSyntheticLambda0(LongRef arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2) {
        return SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1.invokeSuspend$lambda$0(this.f$0, ((PointerInputChange)arg1), ((Offset)arg2));
    }
}

