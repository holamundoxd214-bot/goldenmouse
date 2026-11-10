package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001A\u0004\u0018\u00010\u0005*\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0005H\u0016R$\u0010\u0004\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u0005@PX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\u0007¨\u0006\u000F"}, d2={"Landroidx/compose/ui/layout/LayoutIdModifier;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "Landroidx/compose/ui/layout/LayoutIdParentData;", "Landroidx/compose/ui/Modifier$Node;", "layoutId", "", "<init>", "(Ljava/lang/Object;)V", "value", "getLayoutId", "()Ljava/lang/Object;", "setLayoutId$ui", "modifyParentData", "Landroidx/compose/ui/unit/Density;", "parentData", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LayoutIdModifier extends Node implements LayoutIdParentData, ParentDataModifierNode {
    public static final int $stable = 8;
    private Object layoutId;

    static {
    }

    public LayoutIdModifier(Object arg1) {
        super();
        this.layoutId = arg1;
    }

    public Object getLayoutId() {
        return this.layoutId;
    }

    public Object modifyParentData(Density arg1, Object arg2) {
        return this;
    }

    public void setLayoutId$ui(Object arg1) {
        this.layoutId = arg1;
    }
}

