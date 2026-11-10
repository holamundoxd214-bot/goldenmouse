package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0011\u001A\u00020\u0012*\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0016R\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\u001A\u0010\u0005\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010¨\u0006\u0016"}, d2={"Landroidx/compose/foundation/layout/LayoutWeightNode;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "weight", "", "fill", "", "<init>", "(FZ)V", "getWeight", "()F", "setWeight", "(F)V", "getFill", "()Z", "setFill", "(Z)V", "modifyParentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "Landroidx/compose/ui/unit/Density;", "parentData", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LayoutWeightNode extends Node implements ParentDataModifierNode {
    public static final int $stable = 8;
    private boolean fill;
    private float weight;

    static {
    }

    public LayoutWeightNode(float arg1, boolean arg2) {
        super();
        this.weight = arg1;
        this.fill = arg2;
    }

    public final boolean getFill() {
        return this.fill;
    }

    public final float getWeight() {
        return this.weight;
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

        v9.setWeight(this.weight);
        v9.setFill(this.fill);
        return v9;
    }

    public Object modifyParentData(Density arg1, Object arg2) {
        return this.modifyParentData(arg1, arg2);
    }

    public final void setFill(boolean arg1) {
        this.fill = arg1;
    }

    public final void setWeight(float arg1) {
        this.weight = arg1;
    }
}

