package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0002\u001A\u00020\u0003J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Landroidx/compose/foundation/layout/PaddingValuesConsumingModifierNode;", "Landroidx/compose/foundation/layout/InsetsConsumingModifierNode;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "<init>", "(Landroidx/compose/foundation/layout/PaddingValues;)V", "update", "", "calculateInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "ancestorConsumedInsets", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class PaddingValuesConsumingModifierNode extends InsetsConsumingModifierNode {
    private PaddingValues paddingValues;

    public PaddingValuesConsumingModifierNode(PaddingValues arg1) {
        super();
        this.paddingValues = arg1;
    }

    public WindowInsets calculateInsets(WindowInsets arg1) {
        return WindowInsetsKt.add(arg1, WindowInsetsKt.asInsets(this.paddingValues));
    }

    public final void update(PaddingValues arg2) {
        if(!Intrinsics.areEqual(arg2, this.paddingValues)) {
            this.paddingValues = arg2;
            this.insetsInvalidated();
        }
    }
}

