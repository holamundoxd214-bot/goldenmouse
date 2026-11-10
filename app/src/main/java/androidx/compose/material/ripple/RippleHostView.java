package androidx.compose.material.ripple;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1={"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000B\b\u0001\u0018\u0000 82\u00020\u0001:\u00018B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tH\u0014J0\u0010\u000B\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\t2\u0006\u0010\u0011\u001A\u00020\tH\u0014J\u0010\u0010\u0012\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00020\u0014H\u0016J\b\u0010\u0015\u001A\u00020\u0007H\u0016J\u0010\u0010\u001F\u001A\u00020\u00072\u0006\u0010\u0018\u001A\u00020\rH\u0002J\u0010\u0010\"\u001A\u00020\u00072\u0006\u0010#\u001A\u00020$H\u0016JK\u0010%\u001A\u00020\u00072\u0006\u0010&\u001A\u00020\'2\u0006\u0010\u0018\u001A\u00020\r2\u0006\u0010(\u001A\u00020)2\u0006\u0010*\u001A\u00020\t2\u0006\u0010+\u001A\u00020,2\u0006\u0010-\u001A\u00020.2\f\u0010 \u001A\b\u0012\u0004\u0012\u00020\u00070!¢\u0006\u0004\b/\u00100J\u0006\u00101\u001A\u00020\u0007J-\u00102\u001A\u00020\u00072\u0006\u0010(\u001A\u00020)2\u0006\u0010*\u001A\u00020\t2\u0006\u0010+\u001A\u00020,2\u0006\u0010-\u001A\u00020.¢\u0006\u0004\b3\u00104J\u0006\u00105\u001A\u00020\u0007J\u0010\u00106\u001A\u00020\u00072\u0006\u00107\u001A\u00020\rH\u0002R\u0010\u0010\u0016\u001A\u0004\u0018\u00010\u0017X\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0019R\u0012\u0010\u001A\u001A\u0004\u0018\u00010\u001BX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u001CR\u0010\u0010\u001D\u001A\u0004\u0018\u00010\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010 \u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010!X\u0082\u000E¢\u0006\u0002\n\u0000¨\u00069"}, d2={"Landroidx/compose/material/ripple/RippleHostView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "onLayout", "changed", "", "l", "t", "r", "b", "draw", "canvas", "Landroid/graphics/Canvas;", "refreshDrawableState", "ripple", "Landroidx/compose/material/ripple/UnprojectedRipple;", "bounded", "Ljava/lang/Boolean;", "lastRippleStateChangeTimeMillis", "", "Ljava/lang/Long;", "resetRippleRunnable", "Ljava/lang/Runnable;", "createRipple", "onInvalidateRipple", "Lkotlin/Function0;", "invalidateDrawable", "who", "Landroid/graphics/drawable/Drawable;", "addRipple", "interaction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "size", "Landroidx/compose/ui/geometry/Size;", "radius", "color", "Landroidx/compose/ui/graphics/Color;", "alpha", "", "addRipple-KOepWvA", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;ZJIJFLkotlin/jvm/functions/Function0;)V", "removeRipple", "setRippleProperties", "setRippleProperties-biQXAtU", "(JIJF)V", "disposeRipple", "setRippleState", "pressed", "Companion", "material-ripple"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RippleHostView extends View {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"Landroidx/compose/material/ripple/RippleHostView$Companion;", "", "<init>", "()V", "MinimumRippleStateChangeTime", "", "ResetRippleDelayDuration", "PressedState", "", "RestingState", "material-ripple"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final long MinimumRippleStateChangeTime = 5;
    private static final int[] PressedState = null;
    private static final long ResetRippleDelayDuration = 50;
    private static final int[] RestingState;
    private Boolean bounded;
    private Long lastRippleStateChangeTimeMillis;
    private Function0 onInvalidateRipple;
    private Runnable resetRippleRunnable;
    private UnprojectedRipple ripple;

    static {
        RippleHostView.Companion = new Companion(null);
        RippleHostView.$stable = 8;
        RippleHostView.PressedState = new int[]{0x10100A7, 0x101009E};
        RippleHostView.RestingState = new int[0];
    }

    public RippleHostView(Context arg1) {
        super(arg1);
    }

    public final void addRipple-KOepWvA(Press arg3, boolean arg4, long arg5, int arg7, long arg8, float arg10, Function0 arg11) {
        if(this.ripple == null || !Intrinsics.areEqual(Boolean.valueOf(arg4), this.bounded)) {
            this.createRipple(arg4);
            this.bounded = Boolean.valueOf(arg4);
        }

        UnprojectedRipple v0 = this.ripple;
        Intrinsics.checkNotNull(v0);
        this.onInvalidateRipple = arg11;
        float v11 = arg10;
        long v9 = arg8;
        int v8 = arg7;
        long v6 = arg5;
        RippleHostView v5 = this;
        v5.setRippleProperties-biQXAtU(v6, v8, v9, v11);
        if(arg4) {
            v0.setHotspot(Offset.getX-impl(arg3.getPressPosition-F1C5BW0()), Offset.getY-impl(arg3.getPressPosition-F1C5BW0()));
        }
        else {
            v0.setHotspot(((float)v0.getBounds().centerX()), ((float)v0.getBounds().centerY()));
        }

        v5.setRippleState(true);
    }

    private final void createRipple(boolean arg2) {
        UnprojectedRipple v0 = new UnprojectedRipple(arg2);
        this.setBackground(v0);
        this.ripple = v0;
    }

    public final void disposeRipple() {
        UnprojectedRipple v0_1;
        this.onInvalidateRipple = null;
        Runnable v0 = this.resetRippleRunnable;
        if(v0 != null) {
            this.removeCallbacks(v0);
            v0 = this.resetRippleRunnable;
            Intrinsics.checkNotNull(v0);
            v0.run();
        }
        else {
            v0_1 = this.ripple;
            if(v0_1 != null) {
                v0_1.setState(RippleHostView.RestingState);
            }
        }

        v0_1 = this.ripple;
        if(v0_1 == null) {
            return;
        }

        v0_1.setVisible(false, false);
        this.unscheduleDrawable(((Drawable)v0_1));
    }

    public void draw(Canvas arg2) {
        if(!this.isAttachedToWindow()) {
            this.disposeRipple();
            return;
        }

        super.draw(arg2);
    }

    public void invalidateDrawable(Drawable arg1) {
        Function0 v0 = this.onInvalidateRipple;
        if(v0 != null) {
            v0.invoke();
        }
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
    }

    protected void onMeasure(int arg1, int arg2) {
        this.setMeasuredDimension(0, 0);
    }

    public void refreshDrawableState() {
    }

    public final void removeRipple() {
        this.setRippleState(false);
    }

    public final void setRippleProperties-biQXAtU(long arg2, int arg4, long arg5, float arg7) {
        UnprojectedRipple v0 = this.ripple;
        if(v0 == null) {
            return;
        }

        v0.trySetRadius(arg4);
        v0.setColor-DxMtmZc(arg5, arg7);
        Rect v4 = new Rect(0, 0, MathKt.roundToInt(Size.getWidth-impl(arg2)), MathKt.roundToInt(Size.getHeight-impl(arg2)));
        this.setLeft(v4.left);
        this.setTop(v4.top);
        this.setRight(v4.right);
        this.setBottom(v4.bottom);
        v0.setBounds(v4);
    }

    private final void setRippleState(boolean arg7) {
        long v0 = AnimationUtils.currentAnimationTimeMillis();
        Runnable v2 = this.resetRippleRunnable;
        if(v2 != null) {
            this.removeCallbacks(v2);
            v2.run();
        }

        Long v2_1 = this.lastRippleStateChangeTimeMillis;
        long v2_2 = v2_1 != null ? v2_1.longValue() : 0;
        v2_2 = v0 - v2_2;
        if((arg7) || v2_2 >= 5) {
            int[] v7_1 = arg7 ? RippleHostView.PressedState : RippleHostView.RestingState;
            UnprojectedRipple v2_3 = this.ripple;
            if(v2_3 == null) {
                goto label_27;
            }

            v2_3.setState(v7_1);
        }
        else {
            RippleHostView$$ExternalSyntheticLambda0 v7 = new RippleHostView$$ExternalSyntheticLambda0(this);
            this.resetRippleRunnable = ((Runnable)v7);
            this.postDelayed(((Runnable)v7), 50);
        }

    label_27:
        this.lastRippleStateChangeTimeMillis = Long.valueOf(v0);
    }

    static final void setRippleState$lambda$1(RippleHostView arg2) {
        UnprojectedRipple v0 = arg2.ripple;
        if(v0 != null) {
            v0.setState(RippleHostView.RestingState);
        }

        arg2.resetRippleRunnable = null;
    }
}

