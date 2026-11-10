package com.TryJeanPc.goldenmouse.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.TryJeanPc.goldenmouse.R$id;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001D\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001A\u00020\u0014H\u0014J\b\u0010\u0015\u001A\u00020\rH\u0016J\u0015\u0010\u0016\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u0018H\u0000¢\u0006\u0002\b\u0019J\r\u0010\u001A\u001A\u00020\u0014H\u0000¢\u0006\u0002\b\u001BJ\b\u0010\u001C\u001A\u00020\u0014H\u0002J\b\u0010\u001D\u001A\u00020\u0014H\u0014J\u0018\u0010\u001E\u001A\u00020\u00142\u0006\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020\u0018H\u0014J\u0010\u0010\"\u001A\u00020\u00142\u0006\u0010!\u001A\u00020\u0018H\u0014R\u000E\u0010\b\u001A\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\r@@X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006#"}, d2={"Lcom/TryJeanPc/goldenmouse/ui/GoldenNotificationModeButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "skin", "Lcom/TryJeanPc/goldenmouse/ui/GoldenModeSelectorView;", "feedback", "Landroid/animation/ValueAnimator;", "value", "", "feedbackAnimationEnabled", "getFeedbackAnimationEnabled$app", "()Z", "setFeedbackAnimationEnabled$app", "(Z)V", "onFinishInflate", "", "performClick", "applyAccentColor", "color", "", "applyAccentColor$app", "cancelVisualAnimation", "cancelVisualAnimation$app", "restoreSkin", "onDetachedFromWindow", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "onWindowVisibilityChanged", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenNotificationModeButton extends FrameLayout {
    public static final int $stable = 8;
    private ValueAnimator feedback;
    private boolean feedbackAnimationEnabled;
    private GoldenModeSelectorView skin;

    static {
    }

    public GoldenNotificationModeButton(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        this(arg3, null, 2, null);
    }

    public GoldenNotificationModeButton(Context arg1, AttributeSet arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    public GoldenNotificationModeButton(Context arg2, AttributeSet arg3) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        super(arg2, arg3);
        this.feedbackAnimationEnabled = true;
    }

    public static final ValueAnimator access$getFeedback$p(GoldenNotificationModeButton arg0) {
        return arg0.feedback;
    }

    public static final void access$restoreSkin(GoldenNotificationModeButton arg0) {
        arg0.restoreSkin();
    }

    public static final void access$setFeedback$p(GoldenNotificationModeButton arg0, ValueAnimator arg1) {
        arg0.feedback = arg1;
    }

    public final void applyAccentColor$app(int arg1) {
        GoldenModeSelectorView v0 = this.skin;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skin");
            v0 = null;
        }

        v0.setAccentColor$app(arg1);
    }

    public final void cancelVisualAnimation$app() {
        ValueAnimator v0 = this.feedback;
        this.feedback = null;
        if(v0 != null) {
            v0.cancel();
        }

        if(this.skin != null) {
            this.restoreSkin();
        }
    }

    public final boolean getFeedbackAnimationEnabled$app() {
        return this.feedbackAnimationEnabled;
    }

    protected void onDetachedFromWindow() {
        this.cancelVisualAnimation$app();
        super.onDetachedFromWindow();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        View v0 = this.findViewById(id.bgModeShapeRight);
        Intrinsics.checkNotNullExpressionValue(v0, "findViewById(...)");
        this.skin = ((GoldenModeSelectorView)v0);
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skin");
            GoldenModeSelectorView v0_1 = null;
        }

        ((GoldenModeSelectorView)v0).setSelectedMode$app(-1);
        this.setContentDescription(this.findViewById(id.txtNotificationMode).getText());
    }

    protected void onVisibilityChanged(View arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "changedView");
        super.onVisibilityChanged(arg2, arg3);
        if(arg3 != 0) {
            this.cancelVisualAnimation$app();
        }
    }

    protected void onWindowVisibilityChanged(int arg1) {
        super.onWindowVisibilityChanged(arg1);
        if(arg1 != 0) {
            this.cancelVisualAnimation$app();
        }
    }

    public boolean performClick() {
        boolean v0 = this.isEnabled();
        if((v0) && (this.feedbackAnimationEnabled) && this.feedback == null) {
            ValueAnimator v2 = ValueAnimator.ofInt(new int[]{0, 900});
            v2.setDuration(900);
            v2.setInterpolator(new LinearInterpolator());
            v2.addUpdateListener(new GoldenNotificationModeButton$$ExternalSyntheticLambda0(this));
            v2.addListener(new GoldenNotificationModeButton$performClick$animation$1$2(this));
            this.feedback = v2;
            v2.start();
        }

        if(!super.performClick()) {
            if(v0) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    static final void performClick$lambda$1$lambda$0(GoldenNotificationModeButton arg3, ValueAnimator arg4) {
        Intrinsics.checkNotNullParameter(arg4, "it");
        GoldenModeSelectorView v3 = arg3.skin;
        if(v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skin");
            v3 = null;
        }

        BlueMagicModeAnimation v0 = BlueMagicModeAnimation.INSTANCE;
        Object v4 = arg4.getAnimatedValue();
        Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type kotlin.Int");
        v3.setFrame$app(v0.frameAt(((long)((Integer)v4).intValue())));
    }

    private final void restoreSkin() {
        GoldenModeSelectorView v3 = this.skin;
        if(v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skin");
            v3 = null;
        }

        v3.setFrame$app(BlueMagicModeAnimation.INSTANCE.frameAt(900));
    }

    public final void setFeedbackAnimationEnabled$app(boolean arg2) {
        if(this.feedbackAnimationEnabled == arg2) {
        }
        else {
            this.feedbackAnimationEnabled = arg2;
            if(!arg2) {
                this.cancelVisualAnimation$app();
            }
        }
    }
}

