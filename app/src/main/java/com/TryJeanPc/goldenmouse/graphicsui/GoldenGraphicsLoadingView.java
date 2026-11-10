package com.TryJeanPc.goldenmouse.graphicsui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint$Cap;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\f\b\u0001\u0018\u0000 )2\u00020\u0001:\u0002()B\u001D\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tH\u0002J\u0010\u0010\u001B\u001A\u00020\u001C2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001EJ\u0018\u0010\u001F\u001A\u00020\u001C2\u0006\u0010 \u001A\u00020\t2\u0006\u0010!\u001A\u00020\tH\u0014J\b\u0010\"\u001A\u00020\u001CH\u0014J\b\u0010#\u001A\u00020\u001CH\u0014J\u0010\u0010$\u001A\u00020\u001C2\u0006\u0010%\u001A\u00020\tH\u0014J\b\u0010&\u001A\u00020\u001CH\u0002J\b\u0010\'\u001A\u00020\u001CH\u0002R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001A\u0004\u0018\u00010\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001A\u0004\u0018\u00010\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001A\u00020\u00148F¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001A¨\u0006*"}, d2={"Lcom/TryJeanPc/goldenmouse/graphicsui/GoldenGraphicsLoadingView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dp", "", "value", "ring", "Lcom/TryJeanPc/goldenmouse/graphicsui/GoldenGraphicsLoadingView$Ring;", "caption", "Landroid/widget/TextView;", "panel", "Landroid/widget/LinearLayout;", "animator", "Landroid/animation/ValueAnimator;", "hostStarted", "", "previousFocus", "Landroid/view/View;", "accessibility", "", "isAnimating", "()Z", "render", "", "label", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onAttachedToWindow", "onDetachedFromWindow", "onWindowVisibilityChanged", "visibility", "updateAnimation", "stopAnimation", "Ring", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenGraphicsLoadingView extends FrameLayout {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/graphicsui/GoldenGraphicsLoadingView$Companion;", "", "<init>", "()V", "attach", "Lcom/TryJeanPc/goldenmouse/graphicsui/GoldenGraphicsLoadingView;", "activity", "Landroidx/activity/ComponentActivity;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final GoldenGraphicsLoadingView attach(ComponentActivity arg5) {
            Intrinsics.checkNotNullParameter(arg5, "activity");
            GoldenGraphicsLoadingView v4 = new GoldenGraphicsLoadingView(arg5, null, 2, null);
            arg5.findViewById(0x1020002).addView(v4, new ViewGroup$LayoutParams(-1, -1));
            arg5.getLifecycle().addObserver(new GoldenGraphicsLoadingView$Companion$attach$1(v4));
            return v4;
        }
    }

    @Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014H\u0014R\u001A\u0010\u0006\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Lcom/TryJeanPc/goldenmouse/graphicsui/GoldenGraphicsLoadingView$Ring;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "phase", "", "getPhase", "()F", "setPhase", "(F)V", "paint", "Landroid/graphics/Paint;", "outer", "Landroid/graphics/RectF;", "inner", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Ring extends View {
        private final RectF inner;
        private final RectF outer;
        private final Paint paint;
        private float phase;

        public Ring(Context arg2) {
            Intrinsics.checkNotNullParameter(arg2, "context");
            super(arg2);
            this.phase = 30f;
            Paint v2 = new Paint(1);
            v2.setStyle(Paint$Style.STROKE);
            v2.setStrokeCap(Paint$Cap.ROUND);
            this.paint = v2;
            this.outer = new RectF();
            this.inner = new RectF();
        }

        public final float getPhase() {
            return this.phase;
        }

        protected void onDraw(Canvas arg12) {
            float v4;
            Intrinsics.checkNotNullParameter(arg12, "canvas");
            super.onDraw(arg12);
            float v7 = (((float)Math.min(this.getWidth(), this.getHeight()))) / 76f;
            float v8 = 2f;
            float v2 = (((float)this.getWidth())) / v8;
            float v9 = (((float)this.getHeight())) / v8;
            this.paint.setStrokeWidth(1.2f * v7);
            this.paint.setColor(-14400934);
            arg12.drawCircle(v2, v9, 35f * v7, this.paint);
            int v10;
            for(v10 = 0; true; ++v10) {
                v4 = 90f;
                if(v10 >= 4) {
                    break;
                }

                arg12.save();
                arg12.rotate((((float)v10)) * v4, v2, v9);
                this.paint.setColor(-10583652);
                arg12.drawLine(v2, v9 - 38f * v7, v2, v9 - 33f * v7, this.paint);
                arg12.restore();
            }

            float v3 = 29f * v7;
            this.outer.set(v2 - v3, v9 - v3, v2 + v3, v3 + v9);
            v3 = 22f * v7;
            this.inner.set(v2 - v3, v9 - v3, v2 + v3, v9 + v3);
            this.paint.setStrokeWidth(4f * v7);
            this.paint.setColor(0xFF63C7FF);
            arg12.drawArc(this.outer, this.phase - v4, 235f, false, this.paint);
            this.paint.setStrokeWidth(v7 * v8);
            this.paint.setColor(0xFF2B7FC0);
            arg12.drawArc(this.inner, -this.phase + 70f, 105f, false, this.paint);
        }

        public final void setPhase(float arg1) {
            this.phase = arg1;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final Map accessibility;
    private ValueAnimator animator;
    private final TextView caption;
    private boolean hostStarted;
    private final LinearLayout panel;
    private View previousFocus;
    private final Ring ring;

    static {
        GoldenGraphicsLoadingView.Companion = new Companion(null);
        GoldenGraphicsLoadingView.$stable = 8;
    }

    public GoldenGraphicsLoadingView(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        this(arg3, null, 2, null);
    }

    public GoldenGraphicsLoadingView(Context arg1, AttributeSet arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    public GoldenGraphicsLoadingView(Context arg8, AttributeSet arg9) {
        Intrinsics.checkNotNullParameter(arg8, "context");
        super(arg8, arg9);
        Ring v9 = new Ring(arg8);
        this.ring = v9;
        TextView v0 = new TextView(arg8);
        v0.setTextSize(14f);
        v0.setTextColor(0xFFD9EFFF);
        v0.setGravity(17);
        v0.setTypeface(Typeface.create("sans-serif-medium", 0));
        v0.setImportantForAccessibility(2);
        this.caption = v0;
        LinearLayout v2 = new LinearLayout(arg8);
        v2.setOrientation(1);
        v2.setGravity(17);
        v2.setPadding(this.dp(24), this.dp(24), this.dp(24), this.dp(20));
        GradientDrawable v3 = new GradientDrawable();
        v3.setColor(-300868568);
        v3.setCornerRadius(((float)this.dp(12)));
        v3.setStroke(this.dp(1), 0xFF284B66);
        v2.setBackground(((Drawable)v3));
        v2.addView(((View)v9), new LinearLayout$LayoutParams(this.dp(76), this.dp(76)));
        LinearLayout$LayoutParams v9_1 = new LinearLayout$LayoutParams(-1, -2);
        v9_1.topMargin = this.dp(16);
        v2.addView(((View)v0), ((ViewGroup$LayoutParams)v9_1));
        v2.setImportantForAccessibility(4);
        this.panel = v2;
        this.accessibility = new LinkedHashMap();
        this.setBackgroundColor(0xAA050810);
        this.setClickable(true);
        this.setFocusableInTouchMode(true);
        this.setImportantForAccessibility(1);
        this.setAccessibilityLiveRegion(1);
        this.addView(((View)v2), new FrameLayout$LayoutParams(this.dp(280), -2, 17));
        this.setVisibility(8);
    }

    public static final void access$setHostStarted$p(GoldenGraphicsLoadingView arg0, boolean arg1) {
        arg0.hostStarted = arg1;
    }

    public static final void access$stopAnimation(GoldenGraphicsLoadingView arg0) {
        arg0.stopAnimation();
    }

    public static final void access$updateAnimation(GoldenGraphicsLoadingView arg0) {
        arg0.updateAnimation();
    }

    private final int dp(int arg1) {
        return ((int)((((float)arg1)) * this.getResources().getDisplayMetrics().density));
    }

    public final boolean isAnimating() {
        ValueAnimator v2 = this.animator;
        if(v2 != null && (v2.isRunning())) {
            return 1;
        }

        return 0;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.updateAnimation();
    }

    protected void onDetachedFromWindow() {
        this.stopAnimation();
        super.onDetachedFromWindow();
    }

    protected void onMeasure(int arg5, int arg6) {
        this.panel.getLayoutParams().width = Math.min(this.dp(280), RangesKt.coerceAtLeast(View$MeasureSpec.getSize(arg5) - this.dp(0x20), 0));
        super.onMeasure(arg5, arg6);
    }

    protected void onWindowVisibilityChanged(int arg1) {
        super.onWindowVisibilityChanged(arg1);
        this.updateAnimation();
    }

    public final void render(String arg7) {
        ViewParent v0_1;
        View v0 = null;
        if(arg7 == null) {
            this.setVisibility(8);
            this.stopAnimation();
            Iterator v7 = this.accessibility.entrySet().iterator();
            while(v7.hasNext()) {
                Object v1 = v7.next();
                ((Map$Entry)v1).getKey().setImportantForAccessibility(((Map$Entry)v1).getValue().intValue());
            }

            this.accessibility.clear();
            View v7_1 = this.previousFocus;
            if(v7_1 != null) {
                v7_1.requestFocus();
            }

            this.previousFocus = v0;
            return;
        }

        this.caption.setText(((CharSequence)arg7));
        this.setContentDescription(((CharSequence)arg7));
        if(this.getVisibility() != 0) {
            this.previousFocus = this.getRootView().findFocus();
            ViewParent v7_2 = this.getParent();
            if((v7_2 instanceof ViewGroup)) {
                v0_1 = v7_2;
            }

            if(v0_1 != null) {
                int v1_1 = ((ViewGroup)v0_1).getChildCount();
                int v2;
                for(v2 = 0; v2 < v1_1; ++v2) {
                    View v3 = ((ViewGroup)v0_1).getChildAt(v2);
                    if((((GoldenGraphicsLoadingView)v3)) != this) {
                        this.accessibility.put(v3, Integer.valueOf(v3.getImportantForAccessibility()));
                        v3.setImportantForAccessibility(4);
                    }
                }
            }

            this.setVisibility(0);
            this.bringToFront();
            this.requestFocus();
        }

        this.updateAnimation();
    }

    private final void stopAnimation() {
        ValueAnimator v0 = this.animator;
        if(v0 != null) {
            v0.cancel();
        }

        v0 = this.animator;
        if(v0 != null) {
            v0.removeAllUpdateListeners();
        }

        this.animator = null;
    }

    private final void updateAnimation() {
        if((this.hostStarted) && (this.isAttachedToWindow()) && this.getWindowVisibility() == 0 && this.getVisibility() == 0 && !this.isInEditMode()) {
            if(!ValueAnimator.areAnimatorsEnabled()) {
            }
            else if(this.animator != null) {
                return;
            }
            else {
                ValueAnimator v0 = ValueAnimator.ofFloat(new float[]{0f, 360f});
                v0.setDuration(1100);
                v0.setRepeatCount(-1);
                v0.setInterpolator(new LinearInterpolator());
                v0.addUpdateListener(new GoldenGraphicsLoadingView$$ExternalSyntheticLambda0(this));
                v0.start();
                this.animator = v0;
                return;
            }
        }

        this.stopAnimation();
    }

    static final void updateAnimation$lambda$8$lambda$7(GoldenGraphicsLoadingView arg2, ValueAnimator arg3) {
        Intrinsics.checkNotNullParameter(arg3, "it");
        Ring v0 = arg2.ring;
        Object v3 = arg3.getAnimatedValue();
        Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Float");
        v0.setPhase(((Float)v3).floatValue());
        arg2.ring.invalidate();
    }
}

