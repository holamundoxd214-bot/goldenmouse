package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001A\u00020\u0002H\u0016J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0002H\u0016J\f\u0010\r\u001A\u00020\u000B*\u00020\u000EH\u0016J\b\u0010\u000F\u001A\u00020\u0010H\u0016J\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014H\u0096\u0002R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2={"Landroidx/compose/foundation/layout/FillCrossAxisSizeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/FillCrossAxisSizeNode;", "fraction", "", "<init>", "(F)V", "getFraction", "()F", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "hashCode", "", "equals", "", "other", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FillCrossAxisSizeElement extends ModifierNodeElement {
    public static final int $stable;
    private final float fraction;

    static {
    }

    public FillCrossAxisSizeElement(float arg1) {
        super();
        this.fraction = arg1;
    }

    public FillCrossAxisSizeNode create() {
        return new FillCrossAxisSizeNode(this.fraction);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg3) {
        if(this == (((FillCrossAxisSizeElement)arg3))) {
            return 1;
        }

        if((arg3 instanceof FillCrossAxisSizeNode)) {
        }
        else {
            FillCrossAxisSizeNode v3 = null;
        }

        if(0 == 0) {
            return 0;
        }

        if(this.fraction == v3.getFraction()) {
            return 1;
        }

        return 0;
    }

    public final float getFraction() {
        return this.fraction;
    }

    public int hashCode() {
        return Float.hashCode(this.fraction) * 0x1F;
    }

    public void inspectableProperties(InspectorInfo arg3) {
        arg3.setName("fraction");
        arg3.setValue(Float.valueOf(this.fraction));
        arg3.getProperties().set("fraction", Float.valueOf(this.fraction));
    }

    public void update(FillCrossAxisSizeNode arg1) {
        arg1.setFraction(this.fraction);
    }

    public void update(Node arg1) {
        this.update(((FillCrossAxisSizeNode)arg1));
    }
}

