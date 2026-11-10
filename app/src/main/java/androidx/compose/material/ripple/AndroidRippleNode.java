package androidx.compose.material.ripple;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000E\u0010\u000FJ\f\u0010\u0017\u001A\u00020\u0018*\u00020\u0019H\u0016J\'\u0010\u001A\u001A\u00020\u00182\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001A\u00020\u00182\u0006\u0010\u001B\u001A\u00020\u001CH\u0016J\b\u0010$\u001A\u00020\u0018H\u0016J\b\u0010%\u001A\u00020\u0018H\u0016J\b\u0010&\u001A\u00020\u0011H\u0002R\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001A\u0004\u0018\u00010\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013@BX\u0082\u000E¢\u0006\b\n\u0000\"\u0004\b\u0015\u0010\u0016¨\u0006\'"}, d2={"Landroidx/compose/material/ripple/AndroidRippleNode;", "Landroidx/compose/material/ripple/RippleNode;", "Landroidx/compose/material/ripple/RippleHostKey;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "rippleAlpha", "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "<init>", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "rippleContainer", "Landroidx/compose/material/ripple/RippleContainer;", "value", "Landroidx/compose/material/ripple/RippleHostView;", "rippleHostView", "setRippleHostView", "(Landroidx/compose/material/ripple/RippleHostView;)V", "drawRipples", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "addRipple", "interaction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "size", "Landroidx/compose/ui/geometry/Size;", "targetRadius", "", "addRipple-12SF9DM", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;JF)V", "removeRipple", "onDetach", "onResetRippleHostView", "getOrCreateRippleContainer", "material-ripple"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidRippleNode extends RippleNode implements RippleHostKey {
    public static final int $stable = 8;
    private RippleContainer rippleContainer;
    private RippleHostView rippleHostView;

    public static Unit $r8$lambda$yl_wVRZ2KUOLRsFppMb1ckL7508(AndroidRippleNode arg0) {
        return AndroidRippleNode.addRipple_12SF9DM$lambda$0$0$0(arg0);
    }

    static {
    }

    private AndroidRippleNode(InteractionSource arg8, boolean arg9, float arg10, ColorProducer arg11, Function0 arg12) {
        super(arg8, arg9, arg10, arg11, arg12, null);
    }

    public AndroidRippleNode(InteractionSource arg1, boolean arg2, float arg3, ColorProducer arg4, Function0 arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg4, arg5);
    }

    public void addRipple-12SF9DM(Press arg13, long arg14, float arg16) {
        RippleHostView v2 = this.getOrCreateRippleContainer().getRippleHostView(this);
        v2.addRipple-KOepWvA(arg13, this.getBounded(), arg14, MathKt.roundToInt(arg16), this.getRippleColor-0d7_KjU(), this.getRippleAlpha().invoke().getPressedAlpha(), new AndroidRippleNode$$ExternalSyntheticLambda0(this));
        this.setRippleHostView(v2);
    }

    private static final Unit addRipple_12SF9DM$lambda$0$0$0(AndroidRippleNode arg0) {
        DrawModifierNodeKt.invalidateDraw(((DrawModifierNode)arg0));
        return Unit.INSTANCE;
    }

    public void drawRipples(DrawScope arg8) {
        Canvas v8 = arg8.getDrawContext().getCanvas();
        RippleHostView v0 = this.rippleHostView;
        if(v0 != null) {
            v0.setRippleProperties-biQXAtU(this.getRippleSize-NH-jbRc(), MathKt.roundToInt(this.getTargetRadius()), this.getRippleColor-0d7_KjU(), this.getRippleAlpha().invoke().getPressedAlpha());
            v0.draw(AndroidCanvas_androidKt.getNativeCanvas(v8));
        }
    }

    private final RippleContainer getOrCreateRippleContainer() {
        RippleContainer v0 = this.rippleContainer;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        v0 = Ripple_androidKt.access$createAndAttachRippleContainerIfNeeded(Ripple_androidKt.access$findNearestViewGroup(CompositionLocalConsumerModifierNodeKt.currentValueOf(this, AndroidCompositionLocals_androidKt.getLocalView())));
        this.rippleContainer = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    public void onDetach() {
        RippleContainer v0 = this.rippleContainer;
        if(v0 != null) {
            v0.disposeRippleIfNeeded(((RippleHostKey)this));
        }
    }

    public void onResetRippleHostView() {
        this.setRippleHostView(null);
    }

    public void removeRipple(Press arg1) {
        RippleHostView v0 = this.rippleHostView;
        if(v0 != null) {
            v0.removeRipple();
        }
    }

    private final void setRippleHostView(RippleHostView arg1) {
        this.rippleHostView = arg1;
        DrawModifierNodeKt.invalidateDraw(((DrawModifierNode)this));
    }
}

