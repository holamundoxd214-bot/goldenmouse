package androidx.compose.animation;

import androidx.compose.animation.core.Transition$DeferredAnimation;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import kotlin.Metadata;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BC\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u001C\u0010\u0006\u001A\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r¢\u0006\u0004\b\u000E\u0010\u000FJ\f\u0010 \u001A\u00020!*\u00020\"H\u0016R \u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R0\u0010\u0006\u001A\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001A\u0010\n\u001A\u00020\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR\u001A\u0010\f\u001A\u00020\rX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001F¨\u0006#"}, d2={"Landroidx/compose/animation/VeilModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "transition", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "veilAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/animation/core/AnimationVector4D;", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "<init>", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;)V", "getTransition", "()Landroidx/compose/animation/core/Transition;", "setTransition", "(Landroidx/compose/animation/core/Transition;)V", "getVeilAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "setVeilAnimation", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;)V", "getEnter", "()Landroidx/compose/animation/EnterTransition;", "setEnter", "(Landroidx/compose/animation/EnterTransition;)V", "getExit", "()Landroidx/compose/animation/ExitTransition;", "setExit", "(Landroidx/compose/animation/ExitTransition;)V", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) final class VeilModifierNode extends Node implements DrawModifierNode {
    private EnterTransition enter;
    private ExitTransition exit;
    private Transition transition;
    private DeferredAnimation veilAnimation;

    public VeilModifierNode(Transition arg1, DeferredAnimation arg2, EnterTransition arg3, ExitTransition arg4) {
        super();
        this.transition = arg1;
        this.veilAnimation = arg2;
        this.enter = arg3;
        this.exit = arg4;
    }

    public void draw(ContentDrawScope arg31) {
        long v2_2;
        VeilModifierNode v0 = this;
        arg31.drawContent();
        State v1 = v0.veilAnimation.animate(new VeilModifierNode$draw$veilColor$1(v0), new VeilModifierNode$draw$veilColor$2(v0));
        if(Color.getAlpha-impl(v1.getValue().unbox-impl()) == 0f) {
            return;
        }

        Veil v2 = v0.enter.getData$animation().getVeil();
        if(v2 == null) {
            v2 = v0.exit.getData$animation().getVeil();
        }

        if(v2 != null && (v2.getMatchParentSize())) {
            LayoutCoordinates v0_1 = DelegatableNodeKt.requireLayoutCoordinates(((DelegatableNode)v0));
            LayoutCoordinates v2_1 = v0_1.getParentLayoutCoordinates();
            if(v2_1 != null) {
                v2_2 = v2_1.getSize-YbymL2g();
                v2_2 = Size.constructor-impl((((long)Float.floatToRawIntBits(((float)(((int)(v2_2 & 0xFFFFFFFFL))))))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(((float)(((int)(v2_2 >> 0x20))))))) << 0x20);
            }
            else {
                v2_2 = Size.Companion.getZero-NH-jbRc();
            }

            DrawScope.drawRect-n-J9OG0$default(arg31, v1.getValue().unbox-impl(), Offset.constructor-impl(-9223372034707292160L ^ LayoutCoordinatesKt.positionInParent(v0_1)), v2_2, 0f, null, null, 0, 120, null);
            return;
        }

        DrawScope.drawRect-n-J9OG0$default(arg31, v1.getValue().unbox-impl(), 0, 0, 0f, null, null, 0, 0x7E, null);
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

    public final void setEnter(EnterTransition arg1) {
        this.enter = arg1;
    }

    public final void setExit(ExitTransition arg1) {
        this.exit = arg1;
    }

    public final void setTransition(Transition arg1) {
        this.transition = arg1;
    }

    public final void setVeilAnimation(DeferredAnimation arg1) {
        this.veilAnimation = arg1;
    }
}

