package androidx.compose.foundation.text.selection;

import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

public final class SelectionAdjustmentKt$$ExternalSyntheticLambda1 implements Function0 {
    public SelectionAdjustmentKt$$ExternalSyntheticLambda1(SelectableInfo arg1, int arg2, int arg3, SelectionLayout arg4, Lazy arg5) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
    }

    public final Object invoke() {
        return SelectionAdjustmentKt.updateSelectionBoundary$lambda$2(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}

