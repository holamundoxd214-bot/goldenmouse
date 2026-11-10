package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001B\u0012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\u0004H\u0016J\u001A\u0010\n\u001A\u00020\u00052\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003R\u001A\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Landroidx/compose/foundation/layout/ConsumedInsetsModifierNode;", "Landroidx/compose/foundation/layout/InsetsConsumingModifierNode;", "block", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/WindowInsets;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "calculateInsets", "ancestorConsumedInsets", "update", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class ConsumedInsetsModifierNode extends InsetsConsumingModifierNode {
    private Function1 block;

    public ConsumedInsetsModifierNode(Function1 arg1) {
        super();
        this.block = arg1;
    }

    public WindowInsets calculateInsets(WindowInsets arg1) {
        this.block.invoke(arg1);
        return arg1;
    }

    public final void update(Function1 arg2) {
        if(arg2 != this.block) {
            this.block = arg2;
        }
    }
}

