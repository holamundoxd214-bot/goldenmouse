package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001B\u0012\u0012\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000B\u001A\u00020\u0002H\u0016J\u0010\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0002H\u0016J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001A\u00020\u0006H\u0016J\f\u0010\u0014\u001A\u00020\r*\u00020\u0015H\u0016R\u001D\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0016"}, d2={"Landroidx/compose/foundation/layout/WithAlignmentLineBlockElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/SiblingsAlignedNode$WithAlignmentLineBlockNode;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getBlock", "()Lkotlin/jvm/functions/Function1;", "create", "update", "", "node", "equals", "", "other", "", "hashCode", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WithAlignmentLineBlockElement extends ModifierNodeElement {
    public static final int $stable;
    private final Function1 block;

    static {
    }

    public WithAlignmentLineBlockElement(Function1 arg1) {
        super();
        this.block = arg1;
    }

    public WithAlignmentLineBlockNode create() {
        return new WithAlignmentLineBlockNode(this.block);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg3) {
        if(this == (((WithAlignmentLineBlockElement)arg3))) {
            return 1;
        }

        if((arg3 instanceof WithAlignmentLineBlockElement)) {
        }
        else {
            WithAlignmentLineBlockElement v3 = null;
        }

        if(0 == 0) {
            return 0;
        }

        if(this.block == v3.block) {
            return 1;
        }

        return 0;
    }

    public final Function1 getBlock() {
        return this.block;
    }

    public int hashCode() {
        return this.block.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg2) {
        arg2.setName("alignBy");
        arg2.setValue(this.block);
    }

    public void update(WithAlignmentLineBlockNode arg1) {
        arg1.setBlock(this.block);
    }

    public void update(Node arg1) {
        this.update(((WithAlignmentLineBlockNode)arg1));
    }
}

