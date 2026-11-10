package androidx.compose.ui;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\b\u001A\u00020\u0002H\u0016J\u0010\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0002H\u0016J\f\u0010\f\u001A\u00020\n*\u00020\rH\u0016J\t\u0010\u000E\u001A\u00020\u0004HÆ\u0003J\u0013\u0010\u000F\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001A\u00020\u00042\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0007¨\u0006\u0017"}, d2={"Landroidx/compose/ui/SensitiveNodeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/SensitiveContentNode;", "isContentSensitive", "", "<init>", "(Z)V", "()Z", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class SensitiveNodeElement extends ModifierNodeElement {
    private final boolean isContentSensitive;

    public SensitiveNodeElement(boolean arg1) {
        super();
        this.isContentSensitive = arg1;
    }

    public final boolean component1() {
        return this.isContentSensitive;
    }

    public final SensitiveNodeElement copy(boolean arg1) {
        return new SensitiveNodeElement(arg1);
    }

    public static SensitiveNodeElement copy$default(SensitiveNodeElement arg0, boolean arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.isContentSensitive;
        }

        return arg0.copy(arg1);
    }

    public Node create() {
        return this.create();
    }

    public SensitiveContentNode create() {
        return new SensitiveContentNode(this.isContentSensitive);
    }

    public boolean equals(Object arg4) {
        if(this == (((SensitiveNodeElement)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof SensitiveNodeElement)) {
            return 0;
        }

        if(this.isContentSensitive != ((SensitiveNodeElement)arg4).isContentSensitive) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isContentSensitive);
    }

    public void inspectableProperties(InspectorInfo arg2) {
        arg2.setName("sensitiveContent");
        arg2.getProperties().set("isContentSensitive", Boolean.valueOf(this.isContentSensitive));
    }

    public final boolean isContentSensitive() {
        return this.isContentSensitive;
    }

    public String toString() {
        return "SensitiveNodeElement(isContentSensitive=" + this.isContentSensitive + ')';
    }

    public void update(Node arg1) {
        this.update(((SensitiveContentNode)arg1));
    }

    public void update(SensitiveContentNode arg1) {
        arg1.setContentSensitive(this.isContentSensitive);
    }
}

