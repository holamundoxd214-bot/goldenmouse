package androidx.compose.ui.viewinterop;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B5\u0012,\u0010\u0003\u001A(\u0012\u001A\u0012\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u0004\u0018\u0001`\u0007\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\r\u001A\u00020\u0002H\u0016J\u0010\u0010\u000E\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u0002H\u0016J\b\u0010\u0010\u001A\u00020\u0011H\u0016J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0096\u0002J\f\u0010\u0016\u001A\u00020\u0006*\u00020\u0017H\u0016R7\u0010\u0003\u001A(\u0012\u001A\u0012\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u0004\u0018\u0001`\u0007\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\b¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u0018"}, d2={"Landroidx/compose/ui/viewinterop/BringIntoViewElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/viewinterop/BringIntoViewNode;", "onRequesterReady", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Rect;", "", "Landroidx/compose/ui/viewinterop/BringIntoViewRequester;", "Landroidx/compose/ui/viewinterop/OnRequesterReady;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnRequesterReady", "()Lkotlin/jvm/functions/Function1;", "create", "update", "node", "hashCode", "", "equals", "", "other", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class BringIntoViewElement extends ModifierNodeElement {
    private final Function1 onRequesterReady;

    public BringIntoViewElement(Function1 arg1) {
        super();
        this.onRequesterReady = arg1;
    }

    public Node create() {
        return this.create();
    }

    public BringIntoViewNode create() {
        return new BringIntoViewNode(this.onRequesterReady);
    }

    public boolean equals(Object arg2) {
        if(this != (((BringIntoViewElement)arg2)) && (!(arg2 instanceof BringIntoViewElement) || this.onRequesterReady != ((BringIntoViewElement)arg2).onRequesterReady)) {
            return 0;
        }

        return 1;
    }

    public final Function1 getOnRequesterReady() {
        return this.onRequesterReady;
    }

    public int hashCode() {
        return this.onRequesterReady.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg1) {
        arg1.setName("requestRectangleBringIntoViewBridge");
    }

    public void update(Node arg1) {
        this.update(((BringIntoViewNode)arg1));
    }

    public void update(BringIntoViewNode arg1) {
        arg1.update(this.onRequesterReady);
    }
}

