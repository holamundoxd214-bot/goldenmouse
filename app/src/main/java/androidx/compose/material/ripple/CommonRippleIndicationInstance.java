package androidx.compose.material.ripple;

import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Deprecated(message="Replaced by the new RippleNode implementation") @Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u000B0\b¢\u0006\u0004\b\f\u0010\rJ\f\u0010\u0015\u001A\u00020\u0016*\u00020\u0017H\u0016J\u0018\u0010\u0018\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u00112\u0006\u0010\u001A\u001A\u00020\u001BH\u0016J\u0010\u0010\u001C\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u0011H\u0016J\u001B\u0010\u001D\u001A\u00020\u0016*\u00020\u001E2\u0006\u0010\u0007\u001A\u00020\tH\u0002¢\u0006\u0004\b\u001F\u0010 J\b\u0010!\u001A\u00020\u0016H\u0016J\b\u0010\"\u001A\u00020\u0016H\u0016J\b\u0010#\u001A\u00020\u0016H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000ER\u0014\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u000B0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006$"}, d2={"Landroidx/compose/material/ripple/CommonRippleIndicationInstance;", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "Landroidx/compose/runtime/RememberObserver;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "<init>", "(ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "ripples", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "Landroidx/compose/material/ripple/RippleAnimation;", "targetRadius", "", "drawIndication", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "addRipple", "interaction", "scope", "Lkotlinx/coroutines/CoroutineScope;", "removeRipple", "drawRipples", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawRipples-4WTKRHQ", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;J)V", "onRemembered", "onForgotten", "onAbandoned", "material-ripple"}, k=1, mv={2, 0, 0}, xi=0x30) final class CommonRippleIndicationInstance extends RippleIndicationInstance implements RememberObserver {
    private final boolean bounded;
    private final State color;
    private final float radius;
    private final State rippleAlpha;
    private final SnapshotStateMap ripples;
    private float targetRadius;

    public CommonRippleIndicationInstance(boolean arg1, float arg2, State arg3, State arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    private CommonRippleIndicationInstance(boolean arg1, float arg2, State arg3, State arg4) {
        super(arg1, arg4);
        this.bounded = arg1;
        this.radius = arg2;
        this.color = arg3;
        this.rippleAlpha = arg4;
        this.ripples = SnapshotStateKt.mutableStateMapOf();
        this.targetRadius = NaNf;
    }

    public static final SnapshotStateMap access$getRipples$p(CommonRippleIndicationInstance arg0) {
        return arg0.ripples;
    }

    public void addRipple(Press arg10, CoroutineScope arg11) {
        Iterator v0 = this.ripples.entrySet().iterator();
        while(v0.hasNext()) {
            v0.next().getValue().finish();
        }

        DefaultConstructorMarker v1 = null;
        Offset v0_1 = this.bounded ? Offset.box-impl(arg10.getPressPosition-F1C5BW0()) : ((Offset)v1);
        RippleAnimation v2 = new RippleAnimation(v0_1, this.targetRadius, this.bounded, v1);
        this.ripples.put(arg10, v2);
        BuildersKt.launch$default(arg11, null, null, new CommonRippleIndicationInstance$addRipple$2(v2, this, arg10, ((Continuation)v1)), 3, null);
    }

    public void drawIndication(ContentDrawScope arg5) {
        float v0 = Float.isNaN(this.radius) ? RippleAnimationKt.getRippleEndRadius-cSwnlzA(arg5, this.bounded, arg5.getSize-NH-jbRc()) : arg5.toPx-0680j_4(this.radius);
        this.targetRadius = v0;
        long v0_1 = this.color.getValue().unbox-impl();
        arg5.drawContent();
        this.drawStateLayer-H2RKhps(((DrawScope)arg5), this.radius, v0_1);
        this.drawRipples-4WTKRHQ(((DrawScope)arg5), v0_1);
    }

    private final void drawRipples-4WTKRHQ(DrawScope arg12, long arg13) {
        long v3;
        Iterator v0 = this.ripples.entrySet().iterator();
        while(v0.hasNext()) {
            Object v1 = v0.next().getValue();
            float v5 = this.rippleAlpha.getValue().getPressedAlpha();
            if(v5 == 0f) {
                v3 = arg13;
            }
            else {
                v3 = arg13;
                ((RippleAnimation)v1).draw-4WTKRHQ(arg12, Color.copy-wmQWz5c$default(v3, v5, 0f, 0f, 0f, 14, null));
            }

            arg13 = v3;
        }
    }

    public void onAbandoned() {
        this.ripples.clear();
    }

    public void onForgotten() {
        this.ripples.clear();
    }

    public void onRemembered() {
    }

    public void removeRipple(Press arg1) {
        Object v0 = this.ripples.get(arg1);
        if(v0 != null) {
            ((RippleAnimation)v0).finish();
        }
    }
}

