package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001A\u00020\u0002H\u0016J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0002H\u0016J\f\u0010\r\u001A\u00020\u000B*\u00020\u000EH\u0016J\b\u0010\u000F\u001A\u00020\u0010H\u0016J\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014H\u0096\u0002R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2={"Landroidx/compose/foundation/layout/HorizontalAlignElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/HorizontalAlignNode;", "horizontal", "Landroidx/compose/ui/Alignment$Horizontal;", "<init>", "(Landroidx/compose/ui/Alignment$Horizontal;)V", "getHorizontal", "()Landroidx/compose/ui/Alignment$Horizontal;", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "hashCode", "", "equals", "", "other", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class HorizontalAlignElement extends ModifierNodeElement {
    public static final int $stable;
    private final Horizontal horizontal;

    static {
    }

    public HorizontalAlignElement(Horizontal arg1) {
        super();
        this.horizontal = arg1;
    }

    public HorizontalAlignNode create() {
        return new HorizontalAlignNode(this.horizontal);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg2) {
        HorizontalAlignElement v2;
        if(this == (((HorizontalAlignElement)arg2))) {
            return 1;
        }

        if((arg2 instanceof HorizontalAlignElement)) {
        }
        else {
            v2 = null;
        }

        if(0 == 0) {
            return 0;
        }

        return Intrinsics.areEqual(this.horizontal, v2.horizontal);
    }

    public final Horizontal getHorizontal() {
        return this.horizontal;
    }

    public int hashCode() {
        return this.horizontal.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg2) {
        arg2.setName("align");
        arg2.setValue(this.horizontal);
    }

    public void update(HorizontalAlignNode arg1) {
        arg1.setHorizontal(this.horizontal);
    }

    public void update(Node arg1) {
        this.update(((HorizontalAlignNode)arg1));
    }
}

