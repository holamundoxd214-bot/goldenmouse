package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0003H\u0016J\u000E\u0010\b\u001A\u00020\t2\u0006\u0010\u0002\u001A\u00020\u0003R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"Landroidx/compose/foundation/layout/UnionInsetsConsumingModifierNode;", "Landroidx/compose/foundation/layout/InsetsConsumingModifierNode;", "insets", "Landroidx/compose/foundation/layout/WindowInsets;", "<init>", "(Landroidx/compose/foundation/layout/WindowInsets;)V", "calculateInsets", "ancestorConsumedInsets", "update", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class UnionInsetsConsumingModifierNode extends InsetsConsumingModifierNode {
    private WindowInsets insets;

    public UnionInsetsConsumingModifierNode(WindowInsets arg1) {
        super();
        this.insets = arg1;
    }

    public WindowInsets calculateInsets(WindowInsets arg1) {
        return WindowInsetsKt.union(arg1, this.insets);
    }

    public final void update(WindowInsets arg2) {
        if(!Intrinsics.areEqual(arg2, this.insets)) {
            this.insets = arg2;
            this.insetsInvalidated();
        }
    }
}

