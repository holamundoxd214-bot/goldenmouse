package androidx.compose.animation;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001A\u00020\u0002H\u0016J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0002H\u0016J\f\u0010\r\u001A\u00020\u000B*\u00020\u000EH\u0016J\t\u0010\u000F\u001A\u00020\u0004HÆ\u0003J\u0013\u0010\u0010\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0004HÆ\u0001J\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2={"Landroidx/compose/animation/SharedTransitionScopeRootModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/SharedTransitionScopeRootModifierNode;", "sharedTransitionScope", "Landroidx/compose/animation/SharedTransitionScopeImpl;", "<init>", "(Landroidx/compose/animation/SharedTransitionScopeImpl;)V", "getSharedTransitionScope", "()Landroidx/compose/animation/SharedTransitionScopeImpl;", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) final class SharedTransitionScopeRootModifierElement extends ModifierNodeElement {
    private final SharedTransitionScopeImpl sharedTransitionScope;

    public SharedTransitionScopeRootModifierElement(SharedTransitionScopeImpl arg1) {
        super();
        this.sharedTransitionScope = arg1;
    }

    public final SharedTransitionScopeImpl component1() {
        return this.sharedTransitionScope;
    }

    public final SharedTransitionScopeRootModifierElement copy(SharedTransitionScopeImpl arg1) {
        return new SharedTransitionScopeRootModifierElement(arg1);
    }

    public static SharedTransitionScopeRootModifierElement copy$default(SharedTransitionScopeRootModifierElement arg0, SharedTransitionScopeImpl arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.sharedTransitionScope;
        }

        return arg0.copy(arg1);
    }

    public SharedTransitionScopeRootModifierNode create() {
        return new SharedTransitionScopeRootModifierNode(this.sharedTransitionScope);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg4) {
        if(this == (((SharedTransitionScopeRootModifierElement)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof SharedTransitionScopeRootModifierElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.sharedTransitionScope, ((SharedTransitionScopeRootModifierElement)arg4).sharedTransitionScope)) {
            return 0;
        }

        return 1;
    }

    public final SharedTransitionScopeImpl getSharedTransitionScope() {
        return this.sharedTransitionScope;
    }

    public int hashCode() {
        return this.sharedTransitionScope.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg2) {
        arg2.setName("SharedTransitionScopeRootModifier");
        arg2.getProperties().set("sharedTransitionScope", this.sharedTransitionScope);
    }

    public String toString() {
        return "SharedTransitionScopeRootModifierElement(sharedTransitionScope=" + this.sharedTransitionScope + ')';
    }

    public void update(SharedTransitionScopeRootModifierNode arg1) {
        arg1.setSharedScope(this.sharedTransitionScope);
    }

    public void update(Node arg1) {
        this.update(((SharedTransitionScopeRootModifierNode)arg1));
    }
}

