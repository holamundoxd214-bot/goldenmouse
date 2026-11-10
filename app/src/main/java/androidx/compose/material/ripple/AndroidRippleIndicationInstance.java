package androidx.compose.material.ripple;

import android.view.ViewGroup;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

@Deprecated(message="Replaced by the new RippleNode implementation") @Metadata(d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B;\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\f0\t\u0012\u0006\u0010\r\u001A\u00020\u000E¢\u0006\u0004\b\u000F\u0010\u0010J\f\u0010+\u001A\u00020**\u00020,H\u0016J\u0018\u0010-\u001A\u00020*2\u0006\u0010.\u001A\u00020/2\u0006\u00100\u001A\u000201H\u0016J\u0010\u00102\u001A\u00020*2\u0006\u0010.\u001A\u00020/H\u0016J\b\u00103\u001A\u00020*H\u0016J\b\u00104\u001A\u00020*H\u0016J\b\u00105\u001A\u00020*H\u0016J\b\u00106\u001A\u00020*H\u0002J\b\u00107\u001A\u00020*H\u0016J\b\u00108\u001A\u00020\u0013H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R/\u0010\u0016\u001A\u0004\u0018\u00010\u00152\b\u0010\u0014\u001A\u0004\u0018\u00010\u00158B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001AR+\u0010\u001D\u001A\u00020\u00052\u0006\u0010\u0014\u001A\u00020\u00058B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u001C\u001A\u0004\b\u001E\u0010\u001F\"\u0004\b \u0010!R\u0010\u0010#\u001A\u00020$X\u0082\u000E¢\u0006\u0004\n\u0002\u0010%R\u000E\u0010&\u001A\u00020\'X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010(\u001A\b\u0012\u0004\u0012\u00020*0)X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2={"Landroidx/compose/material/ripple/AndroidRippleIndicationInstance;", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "Landroidx/compose/runtime/RememberObserver;", "Landroidx/compose/material/ripple/RippleHostKey;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "view", "Landroid/view/ViewGroup;", "<init>", "(ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroid/view/ViewGroup;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "rippleContainer", "Landroidx/compose/material/ripple/RippleContainer;", "<set-?>", "Landroidx/compose/material/ripple/RippleHostView;", "rippleHostView", "getRippleHostView", "()Landroidx/compose/material/ripple/RippleHostView;", "setRippleHostView", "(Landroidx/compose/material/ripple/RippleHostView;)V", "rippleHostView$delegate", "Landroidx/compose/runtime/MutableState;", "invalidateTick", "getInvalidateTick", "()Z", "setInvalidateTick", "(Z)V", "invalidateTick$delegate", "rippleSize", "Landroidx/compose/ui/geometry/Size;", "J", "rippleRadius", "", "onInvalidateRipple", "Lkotlin/Function0;", "", "drawIndication", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "addRipple", "interaction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "removeRipple", "onRemembered", "onForgotten", "onAbandoned", "dispose", "onResetRippleHostView", "getOrCreateRippleContainer", "material-ripple"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidRippleIndicationInstance extends RippleIndicationInstance implements RippleHostKey, RememberObserver {
    public static final int $stable = 8;
    private final boolean bounded;
    private final State color;
    private final MutableState invalidateTick$delegate;
    private final Function0 onInvalidateRipple;
    private final float radius;
    private final State rippleAlpha;
    private RippleContainer rippleContainer;
    private final MutableState rippleHostView$delegate;
    private int rippleRadius;
    private long rippleSize;
    private final ViewGroup view;

    static {
    }

    private AndroidRippleIndicationInstance(boolean arg1, float arg2, State arg3, State arg4, ViewGroup arg5) {
        super(arg1, arg4);
        this.bounded = arg1;
        this.radius = arg2;
        this.color = arg3;
        this.rippleAlpha = arg4;
        this.view = arg5;
        this.rippleHostView$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.invalidateTick$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(true), null, 2, null);
        this.rippleSize = Size.Companion.getZero-NH-jbRc();
        this.rippleRadius = -1;
        this.onInvalidateRipple = new AndroidRippleIndicationInstance$$ExternalSyntheticLambda0(this);
    }

    public AndroidRippleIndicationInstance(boolean arg1, float arg2, State arg3, State arg4, ViewGroup arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg4, arg5);
    }

    public void addRipple(Press arg12, CoroutineScope arg13) {
        RippleHostView v1 = this.getOrCreateRippleContainer().getRippleHostView(this);
        v1.addRipple-KOepWvA(arg12, this.bounded, this.rippleSize, this.rippleRadius, this.color.getValue().unbox-impl(), this.rippleAlpha.getValue().getPressedAlpha(), this.onInvalidateRipple);
        this.setRippleHostView(v1);
    }

    private final void dispose() {
        RippleContainer v0 = this.rippleContainer;
        if(v0 != null) {
            v0.disposeRippleIfNeeded(((RippleHostKey)this));
        }
    }

    public void drawIndication(ContentDrawScope arg9) {
        this.rippleSize = arg9.getSize-NH-jbRc();
        int v0 = Float.isNaN(this.radius) ? MathKt.roundToInt(RippleAnimationKt.getRippleEndRadius-cSwnlzA(arg9, this.bounded, arg9.getSize-NH-jbRc())) : arg9.roundToPx-0680j_4(this.radius);
        this.rippleRadius = v0;
        long v5 = this.color.getValue().unbox-impl();
        float v7 = this.rippleAlpha.getValue().getPressedAlpha();
        arg9.drawContent();
        this.drawStateLayer-H2RKhps(arg9, this.radius, v5);
        Canvas v0_1 = arg9.getDrawContext().getCanvas();
        this.getInvalidateTick();
        RippleHostView v1 = this.getRippleHostView();
        if(v1 != null) {
            v1.setRippleProperties-biQXAtU(arg9.getSize-NH-jbRc(), this.rippleRadius, v5, v7);
            v1.draw(AndroidCanvas_androidKt.getNativeCanvas(v0_1));
        }
    }

    private final boolean getInvalidateTick() {
        return this.invalidateTick$delegate.getValue().booleanValue();
    }

    private final RippleContainer getOrCreateRippleContainer() {
        RippleContainer v0 = this.rippleContainer;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        v0 = Ripple_androidKt.access$createAndAttachRippleContainerIfNeeded(this.view);
        this.rippleContainer = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    private final RippleHostView getRippleHostView() {
        return this.rippleHostView$delegate.getValue();
    }

    public void onAbandoned() {
        this.dispose();
    }

    public void onForgotten() {
        this.dispose();
    }

    static final Unit onInvalidateRipple$lambda$0(AndroidRippleIndicationInstance arg1) {
        arg1.setInvalidateTick(arg1.getInvalidateTick() ^ 1);
        return Unit.INSTANCE;
    }

    public void onRemembered() {
    }

    public void onResetRippleHostView() {
        this.setRippleHostView(null);
    }

    public void removeRipple(Press arg1) {
        RippleHostView v0 = this.getRippleHostView();
        if(v0 != null) {
            v0.removeRipple();
        }
    }

    private final void setInvalidateTick(boolean arg1) {
        this.invalidateTick$delegate.setValue(Boolean.valueOf(arg1));
    }

    private final void setRippleHostView(RippleHostView arg1) {
        this.rippleHostView$delegate.setValue(arg1);
    }
}

