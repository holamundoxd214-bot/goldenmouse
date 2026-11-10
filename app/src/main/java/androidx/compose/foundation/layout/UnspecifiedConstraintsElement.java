package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001B\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001A\u00020\u0002H\u0016J\u0010\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0002H\u0016J\f\u0010\u0010\u001A\u00020\u000E*\u00020\u0011H\u0016J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001A\u00020\u0017H\u0016R\u0013\u0010\u0003\u001A\u00020\u0004¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001A\u00020\u0004¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\u000B\u0010\t¨\u0006\u0018"}, d2={"Landroidx/compose/foundation/layout/UnspecifiedConstraintsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/UnspecifiedConstraintsNode;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "<init>", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMinWidth-D9Ej5fM", "()F", "F", "getMinHeight-D9Ej5fM", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "", "hashCode", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class UnspecifiedConstraintsElement extends ModifierNodeElement {
    private final float minHeight;
    private final float minWidth;

    public UnspecifiedConstraintsElement(float arg1, float arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    private UnspecifiedConstraintsElement(float arg1, float arg2) {
        super();
        this.minWidth = arg1;
        this.minHeight = arg2;
    }

    public UnspecifiedConstraintsElement(float arg1, float arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 1) != 0) {
            arg1 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        if((arg3 & 2) != 0) {
            arg2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        this(arg1, arg2, null);
    }

    public UnspecifiedConstraintsNode create() {
        return new UnspecifiedConstraintsNode(this.minWidth, this.minHeight, null);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg4) {
        if(!(arg4 instanceof UnspecifiedConstraintsElement)) {
            return 0;
        }

        if((Dp.equals-impl0(this.minWidth, ((UnspecifiedConstraintsElement)arg4).minWidth)) && (Dp.equals-impl0(this.minHeight, ((UnspecifiedConstraintsElement)arg4).minHeight))) {
            return 1;
        }

        return 0;
    }

    public final float getMinHeight-D9Ej5fM() {
        return this.minHeight;
    }

    public final float getMinWidth-D9Ej5fM() {
        return this.minWidth;
    }

    public int hashCode() {
        return Dp.hashCode-impl(this.minWidth) * 0x1F + Dp.hashCode-impl(this.minHeight);
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("defaultMinSize");
        arg4.getProperties().set("minWidth", Dp.box-impl(this.minWidth));
        arg4.getProperties().set("minHeight", Dp.box-impl(this.minHeight));
    }

    public void update(UnspecifiedConstraintsNode arg2) {
        arg2.setMinWidth-0680j_4(this.minWidth);
        arg2.setMinHeight-0680j_4(this.minHeight);
    }

    public void update(Node arg1) {
        this.update(((UnspecifiedConstraintsNode)arg1));
    }
}

