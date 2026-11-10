package androidx.compose.foundation;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000E\u001A\u00020\u0002H\u0016J\u0010\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0002H\u0016J\b\u0010\u0012\u001A\u00020\u0013H\u0016J\u0013\u0010\u0014\u001A\u00020\u00062\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\u0096\u0002J\f\u0010\u0017\u001A\u00020\u0010*\u00020\u0018H\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\r¨\u0006\u0019"}, d2={"Landroidx/compose/foundation/ScrollingLayoutElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/ScrollNode;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "reverseScrolling", "", "isVertical", "<init>", "(Landroidx/compose/foundation/ScrollState;ZZ)V", "getScrollState", "()Landroidx/compose/foundation/ScrollState;", "getReverseScrolling", "()Z", "create", "update", "", "node", "hashCode", "", "equals", "other", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ScrollingLayoutElement extends ModifierNodeElement {
    public static final int $stable;
    private final boolean isVertical;
    private final boolean reverseScrolling;
    private final ScrollState scrollState;

    static {
    }

    public ScrollingLayoutElement(ScrollState arg1, boolean arg2, boolean arg3) {
        super();
        this.scrollState = arg1;
        this.reverseScrolling = arg2;
        this.isVertical = arg3;
    }

    public ScrollNode create() {
        return new ScrollNode(this.scrollState, this.reverseScrolling, this.isVertical);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg4) {
        if(!(arg4 instanceof ScrollingLayoutElement)) {
            return 0;
        }

        if((Intrinsics.areEqual(this.scrollState, ((ScrollingLayoutElement)arg4).scrollState)) && this.reverseScrolling == ((ScrollingLayoutElement)arg4).reverseScrolling && this.isVertical == ((ScrollingLayoutElement)arg4).isVertical) {
            return 1;
        }

        return 0;
    }

    public final boolean getReverseScrolling() {
        return this.reverseScrolling;
    }

    public final ScrollState getScrollState() {
        return this.scrollState;
    }

    public int hashCode() {
        return (this.scrollState.hashCode() * 0x1F + Boolean.hashCode(this.reverseScrolling)) * 0x1F + Boolean.hashCode(this.isVertical);
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("scroll");
        arg4.getProperties().set("state", this.scrollState);
        arg4.getProperties().set("reverseScrolling", Boolean.valueOf(this.reverseScrolling));
        arg4.getProperties().set("isVertical", Boolean.valueOf(this.isVertical));
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public void update(ScrollNode arg2) {
        arg2.setState(this.scrollState);
        arg2.setReverseScrolling(this.reverseScrolling);
        arg2.setVertical(this.isVertical);
    }

    public void update(Node arg1) {
        this.update(((ScrollNode)arg1));
    }
}

