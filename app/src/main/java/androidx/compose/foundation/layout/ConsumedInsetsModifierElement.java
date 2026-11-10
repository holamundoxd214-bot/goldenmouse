package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B4\u0012\u0012\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0017\u0010\u0007\u001A\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\t¢\u0006\u0004\b\n\u0010\u000BJ\b\u0010\f\u001A\u00020\u0002H\u0016J\u0010\u0010\r\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u0002H\u0016J\f\u0010\u000F\u001A\u00020\u0006*\u00020\bH\u0016J\b\u0010\u0010\u001A\u00020\u0011H\u0016J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0096\u0002R\u001A\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001F\u0010\u0007\u001A\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Landroidx/compose/foundation/layout/ConsumedInsetsModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/ConsumedInsetsModifierNode;", "block", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/WindowInsets;", "", "inspectorInfo", "Landroidx/compose/ui/platform/InspectorInfo;", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "create", "update", "node", "inspectableProperties", "hashCode", "", "equals", "", "other", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class ConsumedInsetsModifierElement extends ModifierNodeElement {
    private final Function1 block;
    private final Function1 inspectorInfo;

    public ConsumedInsetsModifierElement(Function1 arg1, Function1 arg2) {
        super();
        this.block = arg1;
        this.inspectorInfo = arg2;
    }

    public ConsumedInsetsModifierNode create() {
        return new ConsumedInsetsModifierNode(this.block);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg4) {
        if(this == (((ConsumedInsetsModifierElement)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof ConsumedInsetsModifierElement)) {
            return 0;
        }

        if(((ConsumedInsetsModifierElement)arg4).block == this.block) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return this.block.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg1) {
        this.inspectorInfo.invoke(arg1);
    }

    public void update(ConsumedInsetsModifierNode arg1) {
        arg1.update(this.block);
    }

    public void update(Node arg1) {
        this.update(((ConsumedInsetsModifierNode)arg1));
    }
}

