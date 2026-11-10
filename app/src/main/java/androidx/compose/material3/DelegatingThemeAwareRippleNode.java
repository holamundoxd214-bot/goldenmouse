package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\'\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0011\u001A\u00020\u0012H\u0016J\b\u0010\u0013\u001A\u00020\u0012H\u0016J\b\u0010\u0014\u001A\u00020\u0012H\u0002J\b\u0010\u0015\u001A\u00020\u0012H\u0002J\b\u0010\u0016\u001A\u00020\u0012H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000ER\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000F\u001A\u0004\u0018\u00010\u0010X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Landroidx/compose/material3/DelegatingThemeAwareRippleNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "<init>", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "rippleNode", "Landroidx/compose/ui/node/DelegatableNode;", "onAttach", "", "onObservedReadsChanged", "updateConfiguration", "attachNewRipple", "removeRipple", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class DelegatingThemeAwareRippleNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, ObserverModifierNode {
    private final boolean bounded;
    private final ColorProducer color;
    private final InteractionSource interactionSource;
    private final float radius;
    private DelegatableNode rippleNode;

    private DelegatingThemeAwareRippleNode(InteractionSource arg1, boolean arg2, float arg3, ColorProducer arg4) {
        super();
        this.interactionSource = arg1;
        this.bounded = arg2;
        this.radius = arg3;
        this.color = arg4;
    }

    public DelegatingThemeAwareRippleNode(InteractionSource arg1, boolean arg2, float arg3, ColorProducer arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    public static final ColorProducer access$getColor$p(DelegatingThemeAwareRippleNode arg0) {
        return arg0.color;
    }

    private final void attachNewRipple() {
        this.rippleNode = this.delegate(RippleKt.createRippleModifierNode-TDGSqEk(this.interactionSource, this.bounded, this.radius, new DelegatingThemeAwareRippleNode$attachNewRipple$calculateColor$1(this), new DelegatingThemeAwareRippleNode$$ExternalSyntheticLambda1(this)));
    }

    static final RippleAlpha attachNewRipple$lambda$1(DelegatingThemeAwareRippleNode arg1) {
        Object v1 = CompositionLocalConsumerModifierNodeKt.currentValueOf(((CompositionLocalConsumerModifierNode)arg1), androidx.compose.material3.RippleKt.getLocalRippleConfiguration());
        if(v1 != null) {
            RippleAlpha v1_1 = ((RippleConfiguration)v1).getRippleAlpha();
            if(v1_1 == null) {
            }
            else {
                return v1_1;
            }
        }

        return RippleDefaults.INSTANCE.getRippleAlpha();
    }

    public void onAttach() {
        this.updateConfiguration();
    }

    public void onObservedReadsChanged() {
        this.updateConfiguration();
    }

    private final void removeRipple() {
        DelegatableNode v0 = this.rippleNode;
        if(v0 != null) {
            this.undelegate(v0);
        }

        this.rippleNode = null;
    }

    private final void updateConfiguration() {
        ObserverModifierNodeKt.observeReads(this, new DelegatingThemeAwareRippleNode$$ExternalSyntheticLambda0(this));
    }

    static final Unit updateConfiguration$lambda$0(DelegatingThemeAwareRippleNode arg2) {
        if(CompositionLocalConsumerModifierNodeKt.currentValueOf(arg2, androidx.compose.material3.RippleKt.getLocalRippleConfiguration()) == null) {
            arg2.removeRipple();
        }
        else if(arg2.rippleNode == null) {
            arg2.attachNewRipple();
        }

        return Unit.INSTANCE;
    }
}

