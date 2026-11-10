package androidx.compose.animation;

import androidx.compose.animation.core.Transition$DeferredAnimation;
import androidx.compose.animation.core.Transition;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001D\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u009B\u0001\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u001E\u0010\u0006\u001A\u001A\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u001E\u0010\n\u001A\u001A\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u001E\u0010\f\u001A\u001A\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\r\u001A\u00020\u000E\u0012\u0006\u0010\u000F\u001A\u00020\u0010\u0012\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0010\u0014\u001A\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\b\u00101\u001A\u00020\u0002H\u0016J\u0010\u00102\u001A\u0002032\u0006\u00104\u001A\u00020\u0002H\u0016J\f\u00105\u001A\u000203*\u000206H\u0016J\b\u00107\u001A\u000208H\u0016J\u0013\u00109\u001A\u00020\u00132\b\u0010:\u001A\u0004\u0018\u00010;H\u0096\u0002R\u0017\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R2\u0010\u0006\u001A\u001A\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR2\u0010\n\u001A\u001A\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001E\u0010\u001B\"\u0004\b\u001F\u0010\u001DR2\u0010\f\u001A\u001A\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b \u0010\u001B\"\u0004\b!\u0010\u001DR\u001A\u0010\r\u001A\u00020\u000EX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001A\u0010\u000F\u001A\u00020\u0010X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\'\"\u0004\b(\u0010)R \u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010*\"\u0004\b+\u0010,R\u001A\u0010\u0014\u001A\u00020\u0015X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006<"}, d2={"Landroidx/compose/animation/EnterExitTransitionElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/EnterExitTransitionModifierNode;", "transition", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "sizeAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "offsetAnimation", "Landroidx/compose/ui/unit/IntOffset;", "slideAnimation", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "isEnabled", "Lkotlin/Function0;", "", "graphicsLayerBlock", "Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "<init>", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;)V", "getTransition", "()Landroidx/compose/animation/core/Transition;", "getSizeAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "setSizeAnimation", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;)V", "getOffsetAnimation", "setOffsetAnimation", "getSlideAnimation", "setSlideAnimation", "getEnter", "()Landroidx/compose/animation/EnterTransition;", "setEnter", "(Landroidx/compose/animation/EnterTransition;)V", "getExit", "()Landroidx/compose/animation/ExitTransition;", "setExit", "(Landroidx/compose/animation/ExitTransition;)V", "()Lkotlin/jvm/functions/Function0;", "setEnabled", "(Lkotlin/jvm/functions/Function0;)V", "getGraphicsLayerBlock", "()Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "setGraphicsLayerBlock", "(Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;)V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "hashCode", "", "equals", "other", "", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) final class EnterExitTransitionElement extends ModifierNodeElement {
    private EnterTransition enter;
    private ExitTransition exit;
    private GraphicsLayerBlockForEnterExit graphicsLayerBlock;
    private Function0 isEnabled;
    private DeferredAnimation offsetAnimation;
    private DeferredAnimation sizeAnimation;
    private DeferredAnimation slideAnimation;
    private final Transition transition;

    public EnterExitTransitionElement(Transition arg1, DeferredAnimation arg2, DeferredAnimation arg3, DeferredAnimation arg4, EnterTransition arg5, ExitTransition arg6, Function0 arg7, GraphicsLayerBlockForEnterExit arg8) {
        super();
        this.transition = arg1;
        this.sizeAnimation = arg2;
        this.offsetAnimation = arg3;
        this.slideAnimation = arg4;
        this.enter = arg5;
        this.exit = arg6;
        this.isEnabled = arg7;
        this.graphicsLayerBlock = arg8;
    }

    public EnterExitTransitionModifierNode create() {
        return new EnterExitTransitionModifierNode(this.transition, this.sizeAnimation, this.offsetAnimation, this.slideAnimation, this.enter, this.exit, this.isEnabled, this.graphicsLayerBlock);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg3) {
        if(((arg3 instanceof EnterExitTransitionElement)) && (Intrinsics.areEqual(((EnterExitTransitionElement)arg3).transition, this.transition)) && (Intrinsics.areEqual(((EnterExitTransitionElement)arg3).sizeAnimation, this.sizeAnimation)) && (Intrinsics.areEqual(((EnterExitTransitionElement)arg3).offsetAnimation, this.offsetAnimation)) && (Intrinsics.areEqual(((EnterExitTransitionElement)arg3).slideAnimation, this.slideAnimation)) && (Intrinsics.areEqual(((EnterExitTransitionElement)arg3).enter, this.enter)) && (Intrinsics.areEqual(((EnterExitTransitionElement)arg3).exit, this.exit)) && ((EnterExitTransitionElement)arg3).isEnabled == this.isEnabled && (Intrinsics.areEqual(((EnterExitTransitionElement)arg3).graphicsLayerBlock, this.graphicsLayerBlock))) {
            return 1;
        }

        return 0;
    }

    public final EnterTransition getEnter() {
        return this.enter;
    }

    public final ExitTransition getExit() {
        return this.exit;
    }

    public final GraphicsLayerBlockForEnterExit getGraphicsLayerBlock() {
        return this.graphicsLayerBlock;
    }

    public final DeferredAnimation getOffsetAnimation() {
        return this.offsetAnimation;
    }

    public final DeferredAnimation getSizeAnimation() {
        return this.sizeAnimation;
    }

    public final DeferredAnimation getSlideAnimation() {
        return this.slideAnimation;
    }

    public final Transition getTransition() {
        return this.transition;
    }

    public int hashCode() {
        int v0 = this.transition.hashCode() * 0x1F;
        DeferredAnimation v1 = this.sizeAnimation;
        int v2 = 0;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        v1 = this.offsetAnimation;
        v1_1 = v1 != null ? v1.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        v1 = this.slideAnimation;
        if(v1 != null) {
            v2 = v1.hashCode();
        }

        return ((((v0 + v2) * 0x1F + this.enter.hashCode()) * 0x1F + this.exit.hashCode()) * 0x1F + this.isEnabled.hashCode()) * 0x1F + this.graphicsLayerBlock.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("enterExitTransition");
        arg4.getProperties().set("transition", this.transition);
        arg4.getProperties().set("sizeAnimation", this.sizeAnimation);
        arg4.getProperties().set("offsetAnimation", this.offsetAnimation);
        arg4.getProperties().set("slideAnimation", this.slideAnimation);
        arg4.getProperties().set("enter", this.enter);
        arg4.getProperties().set("exit", this.exit);
        arg4.getProperties().set("graphicsLayerBlock", this.graphicsLayerBlock);
    }

    public final Function0 isEnabled() {
        return this.isEnabled;
    }

    public final void setEnabled(Function0 arg1) {
        this.isEnabled = arg1;
    }

    public final void setEnter(EnterTransition arg1) {
        this.enter = arg1;
    }

    public final void setExit(ExitTransition arg1) {
        this.exit = arg1;
    }

    public final void setGraphicsLayerBlock(GraphicsLayerBlockForEnterExit arg1) {
        this.graphicsLayerBlock = arg1;
    }

    public final void setOffsetAnimation(DeferredAnimation arg1) {
        this.offsetAnimation = arg1;
    }

    public final void setSizeAnimation(DeferredAnimation arg1) {
        this.sizeAnimation = arg1;
    }

    public final void setSlideAnimation(DeferredAnimation arg1) {
        this.slideAnimation = arg1;
    }

    public void update(EnterExitTransitionModifierNode arg2) {
        arg2.setTransition(this.transition);
        arg2.setSizeAnimation(this.sizeAnimation);
        arg2.setOffsetAnimation(this.offsetAnimation);
        arg2.setSlideAnimation(this.slideAnimation);
        arg2.setEnter(this.enter);
        arg2.setExit(this.exit);
        arg2.setEnabled(this.isEnabled);
        arg2.setGraphicsLayerBlock(this.graphicsLayerBlock);
    }

    public void update(Node arg1) {
        this.update(((EnterExitTransitionModifierNode)arg1));
    }
}

