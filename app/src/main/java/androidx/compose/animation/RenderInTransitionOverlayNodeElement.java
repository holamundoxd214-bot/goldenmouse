package androidx.compose.animation;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000E\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\b\u0010\u0016\u001A\u00020\u0002H\u0016J\u0010\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u0002H\u0016J\b\u0010\u001A\u001A\u00020\u001BH\u0016J\u0013\u0010\u001C\u001A\u00020\u00072\b\u0010\u001D\u001A\u0004\u0018\u00010\u001EH\u0096\u0002J\f\u0010\u001F\u001A\u00020\u0018*\u00020 H\u0016R\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR \u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2={"Landroidx/compose/animation/RenderInTransitionOverlayNodeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/RenderInTransitionOverlayNode;", "sharedTransitionScope", "Landroidx/compose/animation/SharedTransitionScopeImpl;", "renderInOverlay", "Lkotlin/Function0;", "", "zIndexInOverlay", "", "<init>", "(Landroidx/compose/animation/SharedTransitionScopeImpl;Lkotlin/jvm/functions/Function0;F)V", "getSharedTransitionScope", "()Landroidx/compose/animation/SharedTransitionScopeImpl;", "setSharedTransitionScope", "(Landroidx/compose/animation/SharedTransitionScopeImpl;)V", "getRenderInOverlay", "()Lkotlin/jvm/functions/Function0;", "setRenderInOverlay", "(Lkotlin/jvm/functions/Function0;)V", "getZIndexInOverlay", "()F", "create", "update", "", "node", "hashCode", "", "equals", "other", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RenderInTransitionOverlayNodeElement extends ModifierNodeElement {
    public static final int $stable;
    private Function0 renderInOverlay;
    private SharedTransitionScopeImpl sharedTransitionScope;
    private final float zIndexInOverlay;

    static {
    }

    public RenderInTransitionOverlayNodeElement(SharedTransitionScopeImpl arg1, Function0 arg2, float arg3) {
        super();
        this.sharedTransitionScope = arg1;
        this.renderInOverlay = arg2;
        this.zIndexInOverlay = arg3;
    }

    public RenderInTransitionOverlayNode create() {
        return new RenderInTransitionOverlayNode(this.sharedTransitionScope, this.renderInOverlay, this.zIndexInOverlay);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg4) {
        if(((arg4 instanceof RenderInTransitionOverlayNodeElement)) && (Intrinsics.areEqual(this.sharedTransitionScope, ((RenderInTransitionOverlayNodeElement)arg4).sharedTransitionScope)) && this.renderInOverlay == ((RenderInTransitionOverlayNodeElement)arg4).renderInOverlay && this.zIndexInOverlay == ((RenderInTransitionOverlayNodeElement)arg4).zIndexInOverlay) {
            return 1;
        }

        return 0;
    }

    public final Function0 getRenderInOverlay() {
        return this.renderInOverlay;
    }

    public final SharedTransitionScopeImpl getSharedTransitionScope() {
        return this.sharedTransitionScope;
    }

    public final float getZIndexInOverlay() {
        return this.zIndexInOverlay;
    }

    public int hashCode() {
        return (this.sharedTransitionScope.hashCode() * 0x1F + this.renderInOverlay.hashCode()) * 0x1F + Float.hashCode(this.zIndexInOverlay);
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("renderInSharedTransitionOverlay");
        arg4.getProperties().set("sharedTransitionScope", this.sharedTransitionScope);
        arg4.getProperties().set("renderInOverlay", this.renderInOverlay);
        arg4.getProperties().set("zIndexInOverlay", Float.valueOf(this.zIndexInOverlay));
    }

    public final void setRenderInOverlay(Function0 arg1) {
        this.renderInOverlay = arg1;
    }

    public final void setSharedTransitionScope(SharedTransitionScopeImpl arg1) {
        this.sharedTransitionScope = arg1;
    }

    public void update(RenderInTransitionOverlayNode arg2) {
        arg2.setSharedScope(this.sharedTransitionScope);
        arg2.setRenderInOverlay(this.renderInOverlay);
        arg2.setZIndexInOverlay(this.zIndexInOverlay);
    }

    public void update(Node arg1) {
        this.update(((RenderInTransitionOverlayNode)arg1));
    }
}

