package androidx.compose.animation;

import androidx.compose.animation.core.Transition$DeferredAnimation;
import androidx.compose.animation.core.Transition;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BC\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u001C\u0010\u0006\u001A\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r¢\u0006\u0004\b\u000E\u0010\u000FJ\b\u0010\u0018\u001A\u00020\u0002H\u0016J\u0010\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u0002H\u0016J\f\u0010\u001C\u001A\u00020\u001A*\u00020\u001DH\u0016J\u000F\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\u001F\u0010\u001F\u001A\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\t\u0010 \u001A\u00020\u000BHÆ\u0003J\t\u0010!\u001A\u00020\rHÆ\u0003JM\u0010\"\u001A\u00020\u00002\u000E\b\u0002\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\u001E\b\u0002\u0010\u0006\u001A\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007R\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\rHÆ\u0001J\u0013\u0010#\u001A\u00020$2\b\u0010%\u001A\u0004\u0018\u00010&HÖ\u0003J\t\u0010\'\u001A\u00020(HÖ\u0001J\t\u0010)\u001A\u00020*HÖ\u0001R\u0017\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\'\u0010\u0006\u001A\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0011\u0010\f\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017¨\u0006+"}, d2={"Landroidx/compose/animation/VeilModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/VeilModifierNode;", "transition", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "veilAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/animation/core/AnimationVector4D;", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "<init>", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;)V", "getTransition", "()Landroidx/compose/animation/core/Transition;", "getVeilAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "getEnter", "()Landroidx/compose/animation/EnterTransition;", "getExit", "()Landroidx/compose/animation/ExitTransition;", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) final class VeilModifierElement extends ModifierNodeElement {
    private final EnterTransition enter;
    private final ExitTransition exit;
    private final Transition transition;
    private final DeferredAnimation veilAnimation;

    public VeilModifierElement(Transition arg1, DeferredAnimation arg2, EnterTransition arg3, ExitTransition arg4) {
        super();
        this.transition = arg1;
        this.veilAnimation = arg2;
        this.enter = arg3;
        this.exit = arg4;
    }

    public final Transition component1() {
        return this.transition;
    }

    public final DeferredAnimation component2() {
        return this.veilAnimation;
    }

    public final EnterTransition component3() {
        return this.enter;
    }

    public final ExitTransition component4() {
        return this.exit;
    }

    public final VeilModifierElement copy(Transition arg1, DeferredAnimation arg2, EnterTransition arg3, ExitTransition arg4) {
        return new VeilModifierElement(arg1, arg2, arg3, arg4);
    }

    public static VeilModifierElement copy$default(VeilModifierElement arg0, Transition arg1, DeferredAnimation arg2, EnterTransition arg3, ExitTransition arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.transition;
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.veilAnimation;
        }

        if((arg5 & 4) != 0) {
            arg3 = arg0.enter;
        }

        if((arg5 & 8) != 0) {
            arg4 = arg0.exit;
        }

        return arg0.copy(arg1, arg2, arg3, arg4);
    }

    public VeilModifierNode create() {
        return new VeilModifierNode(this.transition, this.veilAnimation, this.enter, this.exit);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((VeilModifierElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof VeilModifierElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.transition, ((VeilModifierElement)arg5).transition)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.veilAnimation, ((VeilModifierElement)arg5).veilAnimation)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.enter, ((VeilModifierElement)arg5).enter)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.exit, ((VeilModifierElement)arg5).exit)) {
            return 0;
        }

        return 1;
    }

    public final EnterTransition getEnter() {
        return this.enter;
    }

    public final ExitTransition getExit() {
        return this.exit;
    }

    public final Transition getTransition() {
        return this.transition;
    }

    public final DeferredAnimation getVeilAnimation() {
        return this.veilAnimation;
    }

    public int hashCode() {
        return ((this.transition.hashCode() * 0x1F + this.veilAnimation.hashCode()) * 0x1F + this.enter.hashCode()) * 0x1F + this.exit.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("veil");
        arg4.getProperties().set("transition", this.transition);
        arg4.getProperties().set("veilAnimation", this.veilAnimation);
        arg4.getProperties().set("enter", this.enter);
        arg4.getProperties().set("exit", this.exit);
    }

    public String toString() {
        return "VeilModifierElement(transition=" + this.transition + ", veilAnimation=" + this.veilAnimation + ", enter=" + this.enter + ", exit=" + this.exit + ')';
    }

    public void update(VeilModifierNode arg2) {
        arg2.setTransition(this.transition);
        arg2.setVeilAnimation(this.veilAnimation);
        arg2.setEnter(this.enter);
        arg2.setExit(this.exit);
    }

    public void update(Node arg1) {
        this.update(((VeilModifierNode)arg1));
    }
}

