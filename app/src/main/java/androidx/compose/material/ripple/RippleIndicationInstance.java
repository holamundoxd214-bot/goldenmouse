package androidx.compose.material.ripple;

import androidx.compose.foundation.IndicationInstance;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

@Deprecated(message="Replaced by the new RippleNode implementation") @Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b!\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H&J\u0010\u0010\u0011\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH&J\u001D\u0010\u0012\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u00132\u0006\u0010\u000F\u001A\u00020\u0010H\u0000¢\u0006\u0002\b\u0014J!\u0010\u0015\u001A\u00020\f*\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001A¢\u0006\u0004\b\u001B\u0010\u001CR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Landroidx/compose/material/ripple/RippleIndicationInstance;", "Landroidx/compose/foundation/IndicationInstance;", "bounded", "", "rippleAlpha", "Landroidx/compose/runtime/State;", "Landroidx/compose/material/ripple/RippleAlpha;", "<init>", "(ZLandroidx/compose/runtime/State;)V", "stateLayer", "Landroidx/compose/material/ripple/StateLayer;", "addRipple", "", "interaction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "removeRipple", "updateStateLayer", "Landroidx/compose/foundation/interaction/Interaction;", "updateStateLayer$material_ripple", "drawStateLayer", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "drawStateLayer-H2RKhps", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJ)V", "material-ripple"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class RippleIndicationInstance implements IndicationInstance {
    public static final int $stable = 8;
    private final boolean bounded;
    private final StateLayer stateLayer;

    static {
    }

    public RippleIndicationInstance(boolean arg3, State arg4) {
        super();
        this.bounded = arg3;
        this.stateLayer = new StateLayer(arg3, new RippleIndicationInstance$$ExternalSyntheticLambda0(arg4));
    }

    public abstract void addRipple(Press arg1, CoroutineScope arg2);

    public final void drawStateLayer-H2RKhps(DrawScope arg4, float arg5, long arg6) {
        StateLayer v0 = this.stateLayer;
        float v3 = Float.isNaN(arg5) ? RippleAnimationKt.getRippleEndRadius-cSwnlzA(arg4, this.bounded, arg4.getSize-NH-jbRc()) : arg4.toPx-0680j_4(arg5);
        v0.drawStateLayer-mxwnekA(arg4, v3, arg6);
    }

    public abstract void removeRipple(Press arg1);

    static final RippleAlpha stateLayer$lambda$0(State arg0) {
        return arg0.getValue();
    }

    public final void updateStateLayer$material_ripple(Interaction arg1, CoroutineScope arg2) {
        this.stateLayer.handleInteraction$material_ripple(arg1, arg2);
    }
}

