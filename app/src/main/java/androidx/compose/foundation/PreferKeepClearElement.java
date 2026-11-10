package androidx.compose.foundation;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001D\u0012\u0014\u0010\u0003\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000B\u001A\u00020\u0002H\u0016J\u0010\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0002H\u0016J\b\u0010\u000F\u001A\u00020\u0010H\u0016J\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014H\u0096\u0002J\f\u0010\u0015\u001A\u00020\r*\u00020\u0016H\u0016R\u001F\u0010\u0003\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0017"}, d2={"Landroidx/compose/foundation/PreferKeepClearElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/PreferKeepClearNode;", "clearRect", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getClearRect", "()Lkotlin/jvm/functions/Function1;", "create", "update", "", "node", "hashCode", "", "equals", "", "other", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class PreferKeepClearElement extends ModifierNodeElement {
    private final Function1 clearRect;

    public PreferKeepClearElement(Function1 arg1) {
        super();
        this.clearRect = arg1;
    }

    public PreferKeepClearNode create() {
        return new PreferKeepClearNode(this.clearRect);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg3) {
        if(!(arg3 instanceof PreferKeepClearNode)) {
            return 0;
        }

        if(this.clearRect == ((PreferKeepClearNode)arg3).getRect()) {
            return 1;
        }

        return 0;
    }

    public final Function1 getClearRect() {
        return this.clearRect;
    }

    public int hashCode() {
        Function1 v0 = this.clearRect;
        if(v0 != null) {
            return v0.hashCode();
        }

        return 0;
    }

    public void inspectableProperties(InspectorInfo arg2) {
        arg2.setName("preferKeepClearBounds");
        if(this.clearRect != null) {
            arg2.getProperties().set("clearRect", this.clearRect);
        }
    }

    public void update(PreferKeepClearNode arg1) {
        arg1.setRect(this.clearRect);
    }

    public void update(Node arg1) {
        this.update(((PreferKeepClearNode)arg1));
    }
}

