package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001A\u00020\u0002H\u0016J\u0010\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0002H\u0016J\f\u0010\u0011\u001A\u00020\u000F*\u00020\u0012H\u0016J\b\u0010\u0013\u001A\u00020\u0014H\u0016J\u0013\u0010\u0015\u001A\u00020\u00062\b\u0010\u0016\u001A\u0004\u0018\u00010\u0017H\u0096\u0002R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u0018"}, d2={"Landroidx/compose/foundation/layout/LayoutWeightElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/LayoutWeightNode;", "weight", "", "fill", "", "<init>", "(FZ)V", "getWeight", "()F", "getFill", "()Z", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "hashCode", "", "equals", "other", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LayoutWeightElement extends ModifierNodeElement {
    public static final int $stable;
    private final boolean fill;
    private final float weight;

    static {
    }

    public LayoutWeightElement(float arg1, boolean arg2) {
        super();
        this.weight = arg1;
        this.fill = arg2;
    }

    public LayoutWeightNode create() {
        return new LayoutWeightNode(this.weight, this.fill);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((LayoutWeightElement)arg5))) {
            return 1;
        }

        if((arg5 instanceof LayoutWeightElement)) {
        }
        else {
            LayoutWeightElement v5 = null;
        }

        if(0 == 0) {
            return 0;
        }

        if(this.weight == v5.weight && this.fill == v5.fill) {
            return 1;
        }

        return 0;
    }

    public final boolean getFill() {
        return this.fill;
    }

    public final float getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return Float.hashCode(this.weight) * 0x1F + Boolean.hashCode(this.fill);
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("weight");
        arg4.setValue(Float.valueOf(this.weight));
        arg4.getProperties().set("weight", Float.valueOf(this.weight));
        arg4.getProperties().set("fill", Boolean.valueOf(this.fill));
    }

    public void update(LayoutWeightNode arg2) {
        arg2.setWeight(this.weight);
        arg2.setFill(this.fill);
    }

    public void update(Node arg1) {
        this.update(((LayoutWeightNode)arg1));
    }
}

