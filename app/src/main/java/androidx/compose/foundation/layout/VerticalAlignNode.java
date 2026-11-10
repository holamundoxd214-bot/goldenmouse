package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\n\u001A\u00020\u000B*\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0016R\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u000F"}, d2={"Landroidx/compose/foundation/layout/VerticalAlignNode;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "vertical", "Landroidx/compose/ui/Alignment$Vertical;", "<init>", "(Landroidx/compose/ui/Alignment$Vertical;)V", "getVertical", "()Landroidx/compose/ui/Alignment$Vertical;", "setVertical", "modifyParentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "Landroidx/compose/ui/unit/Density;", "parentData", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class VerticalAlignNode extends Node implements ParentDataModifierNode {
    public static final int $stable = 8;
    private Vertical vertical;

    static {
    }

    public VerticalAlignNode(Vertical arg1) {
        super();
        this.vertical = arg1;
    }

    public final Vertical getVertical() {
        return this.vertical;
    }

    public RowColumnParentData modifyParentData(Density arg8, Object arg9) {
        RowColumnParentData v9;
        if((arg9 instanceof RowColumnParentData)) {
        }
        else {
            v9 = null;
        }

        if(0 == 0) {
            v9 = new RowColumnParentData(0f, false, null, null, 15, null);
        }

        v9.setCrossAxisAlignment(CrossAxisAlignment.Companion.vertical$foundation_layout(this.vertical));
        return v9;
    }

    public Object modifyParentData(Density arg1, Object arg2) {
        return this.modifyParentData(arg1, arg2);
    }

    public final void setVertical(Vertical arg1) {
        this.vertical = arg1;
    }
}

