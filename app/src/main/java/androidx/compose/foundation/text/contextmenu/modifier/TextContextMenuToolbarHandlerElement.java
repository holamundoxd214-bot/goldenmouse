package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Be\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u001E\u0010\u0005\u001A\u001A\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0006\u0012\u001E\u0010\n\u001A\u001A\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0006\u0012\u0014\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0006¢\u0006\u0004\b\u000E\u0010\u000FJ\b\u0010\u0011\u001A\u00020\u0002H\u0016J\u0010\u0010\u0012\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\u0002H\u0016J\f\u0010\u0014\u001A\u00020\b*\u00020\u0015H\u0016J\u0013\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\u0019\u001A\u00020\u001AH\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0005\u001A\u001A\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R(\u0010\n\u001A\u001A\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u001C\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2={"Landroidx/compose/foundation/text/contextmenu/modifier/TextContextMenuToolbarHandlerElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/contextmenu/modifier/TextContextMenuToolbarHandlerNode;", "requester", "Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "onShow", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "onHide", "computeContentBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "<init>", "(Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "hashCode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class TextContextMenuToolbarHandlerElement extends ModifierNodeElement {
    private final Function1 computeContentBounds;
    private final Function1 onHide;
    private final Function1 onShow;
    private final ToolbarRequester requester;

    public TextContextMenuToolbarHandlerElement(ToolbarRequester arg1, Function1 arg2, Function1 arg3, Function1 arg4) {
        super();
        this.requester = arg1;
        this.onShow = arg2;
        this.onHide = arg3;
        this.computeContentBounds = arg4;
    }

    public TextContextMenuToolbarHandlerNode create() {
        return new TextContextMenuToolbarHandlerNode(this.requester, this.onShow, this.onHide, this.computeContentBounds);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((TextContextMenuToolbarHandlerElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof TextContextMenuToolbarHandlerElement)) {
            return 0;
        }

        if(this.requester != ((TextContextMenuToolbarHandlerElement)arg5).requester) {
            return 0;
        }

        if(this.onShow != ((TextContextMenuToolbarHandlerElement)arg5).onShow) {
            return 0;
        }

        if(this.onHide != ((TextContextMenuToolbarHandlerElement)arg5).onHide) {
            return 0;
        }

        if(this.computeContentBounds != ((TextContextMenuToolbarHandlerElement)arg5).computeContentBounds) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        int v0 = this.requester.hashCode() * 0x1F;
        Function1 v1 = this.onShow;
        int v2 = 0;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        v1 = this.onHide;
        if(v1 != null) {
            v2 = v1.hashCode();
        }

        return (v0 + v2) * 0x1F + this.computeContentBounds.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg1) {
    }

    public void update(TextContextMenuToolbarHandlerNode arg2) {
        arg2.update(this.requester);
        arg2.setOnShow(this.onShow);
        arg2.setOnHide(this.onHide);
        arg2.setComputeContentBounds(this.computeContentBounds);
    }

    public void update(Node arg1) {
        this.update(((TextContextMenuToolbarHandlerNode)arg1));
    }
}

