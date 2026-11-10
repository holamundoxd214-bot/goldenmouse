package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001A\u00020\u0002H\u0016J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0002H\u0016J\f\u0010\r\u001A\u00020\u000B*\u00020\u000EH\u0016J\b\u0010\u000F\u001A\u00020\u0010H\u0016J\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014H\u0096\u0002R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2={"Landroidx/compose/foundation/layout/WithAlignmentLineElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/SiblingsAlignedNode$WithAlignmentLineNode;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "<init>", "(Landroidx/compose/ui/layout/AlignmentLine;)V", "getAlignmentLine", "()Landroidx/compose/ui/layout/AlignmentLine;", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "hashCode", "", "equals", "", "other", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WithAlignmentLineElement extends ModifierNodeElement {
    public static final int $stable;
    private final AlignmentLine alignmentLine;

    static {
    }

    public WithAlignmentLineElement(AlignmentLine arg1) {
        super();
        this.alignmentLine = arg1;
    }

    public WithAlignmentLineNode create() {
        return new WithAlignmentLineNode(this.alignmentLine);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg2) {
        WithAlignmentLineElement v2;
        if(this == (((WithAlignmentLineElement)arg2))) {
            return 1;
        }

        if((arg2 instanceof WithAlignmentLineElement)) {
        }
        else {
            v2 = null;
        }

        if(0 == 0) {
            return 0;
        }

        return Intrinsics.areEqual(this.alignmentLine, v2.alignmentLine);
    }

    public final AlignmentLine getAlignmentLine() {
        return this.alignmentLine;
    }

    public int hashCode() {
        return this.alignmentLine.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg2) {
        arg2.setName("alignBy");
        arg2.setValue(this.alignmentLine);
    }

    public void update(WithAlignmentLineNode arg1) {
        arg1.setAlignmentLine(this.alignmentLine);
    }

    public void update(Node arg1) {
        this.update(((WithAlignmentLineNode)arg1));
    }
}

