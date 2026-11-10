package androidx.compose.foundation.text.selection;

import kotlin.jvm.functions.Function0;

public final class SelectionAdjustmentKt$$ExternalSyntheticLambda0 implements Function0 {
    public SelectionAdjustmentKt$$ExternalSyntheticLambda0(SelectableInfo arg1, int arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke() {
        return Integer.valueOf(SelectionAdjustmentKt.updateSelectionBoundary$lambda$0(this.f$0, this.f$1));
    }
}

