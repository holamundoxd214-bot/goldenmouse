package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.ProgressBar;
import androidx.core.view.ViewCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public abstract class BaseProgressIndicator extends ProgressBar {
    class com.google.android.material.progressindicator.BaseProgressIndicator$1 implements Runnable {
        com.google.android.material.progressindicator.BaseProgressIndicator$1(BaseProgressIndicator arg1) {
            BaseProgressIndicator.this = arg1;
            super();
        }

        public void run() {
            BaseProgressIndicator.this.internalShow();
        }
    }

    class com.google.android.material.progressindicator.BaseProgressIndicator$2 implements Runnable {
        com.google.android.material.progressindicator.BaseProgressIndicator$2(BaseProgressIndicator arg1) {
            BaseProgressIndicator.this = arg1;
            super();
        }

        public void run() {
            BaseProgressIndicator.this.internalHide();
            BaseProgressIndicator.this.lastShowStartTime = -1;
        }
    }

    class com.google.android.material.progressindicator.BaseProgressIndicator$3 extends AnimationCallback {
        com.google.android.material.progressindicator.BaseProgressIndicator$3(BaseProgressIndicator arg1) {
            BaseProgressIndicator.this = arg1;
            super();
        }

        public void onAnimationEnd(Drawable arg2) {
            BaseProgressIndicator.this.setIndeterminate(false);
            BaseProgressIndicator.this.setProgressCompat(BaseProgressIndicator.this.storedProgress, BaseProgressIndicator.this.storedProgressAnimated);
        }
    }

    class com.google.android.material.progressindicator.BaseProgressIndicator$4 extends AnimationCallback {
        com.google.android.material.progressindicator.BaseProgressIndicator$4(BaseProgressIndicator arg1) {
            BaseProgressIndicator.this = arg1;
            super();
        }

        public void onAnimationEnd(Drawable arg1) {
            super.onAnimationEnd(arg1);
            if(!BaseProgressIndicator.this.isIndeterminateModeChangeRequested) {
                BaseProgressIndicator.this.setVisibility(BaseProgressIndicator.this.visibilityAfterHide);
            }
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface HideAnimationBehavior {
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface ShowAnimationBehavior {
    }

    static final float DEFAULT_OPACITY = 0.2f;
    static final int DEF_STYLE_RES = 0;
    public static final int HIDE_INWARD = 2;
    public static final int HIDE_NONE = 0;
    public static final int HIDE_OUTWARD = 1;
    static final int MAX_ALPHA = 0xFF;
    static final int MAX_HIDE_DELAY = 1000;
    public static final int SHOW_INWARD = 2;
    public static final int SHOW_NONE = 0;
    public static final int SHOW_OUTWARD = 1;
    AnimatorDurationScaleProvider animatorDurationScaleProvider;
    private final Runnable delayedHide;
    private final Runnable delayedShow;
    private final AnimationCallback hideAnimationCallback;
    private boolean isIndeterminateModeChangeRequested;
    private boolean isParentDoneInitializing;
    private long lastShowStartTime;
    private final int minHideDelay;
    private final int showDelay;
    BaseProgressIndicatorSpec spec;
    private int storedProgress;
    private boolean storedProgressAnimated;
    private final AnimationCallback switchIndeterminateModeCallback;
    private int visibilityAfterHide;

    static {
        BaseProgressIndicator.DEF_STYLE_RES = style.Widget_MaterialComponents_ProgressIndicator;
    }

    protected BaseProgressIndicator(Context arg8, AttributeSet arg9, int arg10, int arg11) {
        super(MaterialThemeOverlay.wrap(arg8, arg9, arg10, BaseProgressIndicator.DEF_STYLE_RES), arg9, arg10);
        this.lastShowStartTime = -1;
        this.isIndeterminateModeChangeRequested = false;
        this.visibilityAfterHide = 4;
        this.delayedShow = new com.google.android.material.progressindicator.BaseProgressIndicator$1(this);
        this.delayedHide = new com.google.android.material.progressindicator.BaseProgressIndicator$2(this);
        this.switchIndeterminateModeCallback = new com.google.android.material.progressindicator.BaseProgressIndicator$3(this);
        this.hideAnimationCallback = new com.google.android.material.progressindicator.BaseProgressIndicator$4(this);
        Context v1 = this.getContext();
        this.spec = this.createSpec(v1, arg9);
        TypedArray v8 = ThemeEnforcement.obtainStyledAttributes(v1, arg9, styleable.BaseProgressIndicator, arg10, arg11, new int[0]);
        this.showDelay = v8.getInt(styleable.BaseProgressIndicator_showDelay, -1);
        this.minHideDelay = Math.min(v8.getInt(styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
        v8.recycle();
        this.animatorDurationScaleProvider = new AnimatorDurationScaleProvider();
        this.isParentDoneInitializing = true;
    }

    static void access$000(BaseProgressIndicator arg0) {
        arg0.internalShow();
    }

    static void access$100(BaseProgressIndicator arg0) {
        arg0.internalHide();
    }

    static long access$202(BaseProgressIndicator arg0, long arg1) {
        arg0.lastShowStartTime = arg1;
        return arg1;
    }

    static int access$300(BaseProgressIndicator arg0) {
        return arg0.storedProgress;
    }

    static boolean access$400(BaseProgressIndicator arg0) {
        return arg0.storedProgressAnimated;
    }

    static boolean access$500(BaseProgressIndicator arg0) {
        return arg0.isIndeterminateModeChangeRequested;
    }

    static int access$600(BaseProgressIndicator arg0) {
        return arg0.visibilityAfterHide;
    }

    protected void applyNewVisibility(boolean arg3) {
        if(!this.isParentDoneInitializing) {
            return;
        }

        this.getCurrentDrawable().setVisible(this.visibleToUser(), false, arg3);
    }

    abstract BaseProgressIndicatorSpec createSpec(Context arg1, AttributeSet arg2);

    public Drawable getCurrentDrawable() {
        if(this.isIndeterminate()) {
            return this.getIndeterminateDrawable();
        }

        return this.getProgressDrawable();
    }

    private DrawingDelegate getCurrentDrawingDelegate() {
        DrawingDelegate v1 = null;
        if(this.isIndeterminate()) {
            if(this.getIndeterminateDrawable() == null) {
                return v1;
            }

            return this.getIndeterminateDrawable().getDrawingDelegate();
        }

        if(this.getProgressDrawable() == null) {
            return v1;
        }

        return this.getProgressDrawable().getDrawingDelegate();
    }

    public int getHideAnimationBehavior() {
        return this.spec.hideAnimationBehavior;
    }

    public IndeterminateDrawable getIndeterminateDrawable() {
        return super.getIndeterminateDrawable();
    }

    public Drawable getIndeterminateDrawable() {
        return this.getIndeterminateDrawable();
    }

    public int[] getIndicatorColor() {
        return this.spec.indicatorColors;
    }

    public DeterminateDrawable getProgressDrawable() {
        return super.getProgressDrawable();
    }

    public Drawable getProgressDrawable() {
        return this.getProgressDrawable();
    }

    public int getShowAnimationBehavior() {
        return this.spec.showAnimationBehavior;
    }

    public int getTrackColor() {
        return this.spec.trackColor;
    }

    public int getTrackCornerRadius() {
        return this.spec.trackCornerRadius;
    }

    public int getTrackThickness() {
        return this.spec.trackThickness;
    }

    public void hide() {
        if(this.getVisibility() != 0) {
            this.removeCallbacks(this.delayedShow);
            return;
        }

        this.removeCallbacks(this.delayedHide);
        long v0 = SystemClock.uptimeMillis() - this.lastShowStartTime;
        int v2 = this.minHideDelay;
        int v3 = Long.compare(v0, ((long)v2));
        Runnable v4 = this.delayedHide;
        if(v3 >= 0) {
            v4.run();
            return;
        }

        this.postDelayed(v4, (((long)v2)) - v0);
    }

    private void internalHide() {
        this.getCurrentDrawable().setVisible(false, false, true);
        if(this.isNoLongerNeedToBeVisible()) {
            this.setVisibility(4);
        }
    }

    private void internalShow() {
        if(this.minHideDelay > 0) {
            this.lastShowStartTime = SystemClock.uptimeMillis();
        }

        this.setVisibility(0);
    }

    public void invalidate() {
        super.invalidate();
        if(this.getCurrentDrawable() != null) {
            this.getCurrentDrawable().invalidateSelf();
        }
    }

    boolean isEffectivelyVisible() {
        BaseProgressIndicator v0 = this;
        do {
            if(((View)v0).getVisibility() != 0) {
                return 0;
            }

            ViewParent v0_1 = ((View)v0_1).getParent();
            if(v0_1 == null) {
                if(this.getWindowVisibility() == 0) {
                    return 1;
                }

                return 0;
            }
        }
        while((v0_1 instanceof View));

        return 1;
    }

    private boolean isNoLongerNeedToBeVisible() {
        if(this.getProgressDrawable() != null && (this.getProgressDrawable().isVisible())) {
            return 0;
        }
        else if(this.getIndeterminateDrawable() != null) {
            if(!this.getIndeterminateDrawable().isVisible()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.registerAnimationCallbacks();
        if(this.visibleToUser()) {
            this.internalShow();
        }
    }

    protected void onDetachedFromWindow() {
        this.removeCallbacks(this.delayedHide);
        this.removeCallbacks(this.delayedShow);
        this.getCurrentDrawable().hideNow();
        this.unregisterAnimationCallbacks();
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas arg6) {
        __monitor_enter(this);
        try {
            int v0 = arg6.save();
            if(this.getPaddingLeft() != 0 || this.getPaddingTop() != 0) {
                arg6.translate(((float)this.getPaddingLeft()), ((float)this.getPaddingTop()));
            }

            if(this.getPaddingRight() != 0 || this.getPaddingBottom() != 0) {
                arg6.clipRect(0, 0, this.getWidth() - (this.getPaddingLeft() + this.getPaddingRight()), this.getHeight() - (this.getPaddingTop() + this.getPaddingBottom()));
            }

            this.getCurrentDrawable().draw(arg6);
            arg6.restoreToCount(v0);
        }
        catch(Throwable v6) {
            try {
            label_33:
                __monitor_exit(this);
            }
            catch(Throwable v6) {
                goto label_33;
            }

            throw v6;
        }

        __monitor_exit(this);
    }

    protected void onMeasure(int arg3, int arg4) {
        DrawingDelegate v0;
        __monitor_enter(this);
        try {
            v0 = this.getCurrentDrawingDelegate();
            if(v0 != null) {
                goto label_5;
            }
        }
        catch(Throwable v3) {
            goto label_29;
        }

        __monitor_exit(this);
        return;
        try {
        label_5:
            arg3 = v0.getPreferredWidth() < 0 ? BaseProgressIndicator.getDefaultSize(this.getSuggestedMinimumWidth(), arg3) : v0.getPreferredWidth() + this.getPaddingLeft() + this.getPaddingRight();
            arg4 = v0.getPreferredHeight() < 0 ? BaseProgressIndicator.getDefaultSize(this.getSuggestedMinimumHeight(), arg4) : v0.getPreferredHeight() + this.getPaddingTop() + this.getPaddingBottom();
            this.setMeasuredDimension(arg3, arg4);
        }
        catch(Throwable v3) {
            try {
            label_29:
                __monitor_exit(this);
            }
            catch(Throwable v3) {
                goto label_29;
            }

            throw v3;
        }

        __monitor_exit(this);
    }

    protected void onVisibilityChanged(View arg1, int arg2) {
        super.onVisibilityChanged(arg1, arg2);
        boolean v1 = arg2 == 0 ? true : false;
        this.applyNewVisibility(v1);
    }

    protected void onWindowVisibilityChanged(int arg1) {
        super.onWindowVisibilityChanged(arg1);
        this.applyNewVisibility(false);
    }

    private void registerAnimationCallbacks() {
        if(this.getProgressDrawable() != null && this.getIndeterminateDrawable() != null) {
            this.getIndeterminateDrawable().getAnimatorDelegate().registerAnimatorsCompleteCallback(this.switchIndeterminateModeCallback);
        }

        if(this.getProgressDrawable() != null) {
            this.getProgressDrawable().registerAnimationCallback(this.hideAnimationCallback);
        }

        if(this.getIndeterminateDrawable() != null) {
            this.getIndeterminateDrawable().registerAnimationCallback(this.hideAnimationCallback);
        }
    }

    public void setAnimatorDurationScaleProvider(AnimatorDurationScaleProvider arg2) {
        this.animatorDurationScaleProvider = arg2;
        if(this.getProgressDrawable() != null) {
            this.getProgressDrawable().animatorDurationScaleProvider = arg2;
        }

        if(this.getIndeterminateDrawable() != null) {
            this.getIndeterminateDrawable().animatorDurationScaleProvider = arg2;
        }
    }

    public void setHideAnimationBehavior(int arg2) {
        this.spec.hideAnimationBehavior = arg2;
        this.invalidate();
    }

    public void setIndeterminate(boolean arg3) {
        __monitor_enter(this);
        try {
            if(arg3 != this.isIndeterminate()) {
                goto label_5;
            }
        }
        catch(Throwable v3) {
            goto label_24;
        }

        __monitor_exit(this);
        return;
        try {
        label_5:
            Drawable v0 = this.getCurrentDrawable();
            if(v0 != null) {
                ((DrawableWithAnimatedVisibilityChange)v0).hideNow();
            }

            super.setIndeterminate(arg3);
            Drawable v3_1 = this.getCurrentDrawable();
            if(v3_1 != null) {
                ((DrawableWithAnimatedVisibilityChange)v3_1).setVisible(this.visibleToUser(), false, false);
            }

            if(((v3_1 instanceof IndeterminateDrawable)) && (this.visibleToUser())) {
                ((IndeterminateDrawable)v3_1).getAnimatorDelegate().startAnimator();
            }

            this.isIndeterminateModeChangeRequested = false;
        }
        catch(Throwable v3) {
            try {
            label_24:
                __monitor_exit(this);
            }
            catch(Throwable v3) {
                goto label_24;
            }

            throw v3;
        }

        __monitor_exit(this);
    }

    public void setIndeterminateDrawable(Drawable arg2) {
        if(arg2 == null) {
            super.setIndeterminateDrawable(null);
            return;
        }

        if((arg2 instanceof IndeterminateDrawable)) {
            arg2.hideNow();
            super.setIndeterminateDrawable(arg2);
            return;
        }

        throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
    }

    public void setIndicatorColor(int[] arg4) {
        if(arg4.length == 0) {
            arg4 = new int[]{MaterialColors.getColor(this.getContext(), attr.colorPrimary, -1)};
        }

        if(!Arrays.equals(this.getIndicatorColor(), arg4)) {
            this.spec.indicatorColors = arg4;
            this.getIndeterminateDrawable().getAnimatorDelegate().invalidateSpecValues();
            this.invalidate();
        }
    }

    public void setProgress(int arg2) {
        __monitor_enter(this);
        try {
            if(!this.isIndeterminate()) {
                goto label_6;
            }
        }
        catch(Throwable v2) {
            goto label_10;
        }

        __monitor_exit(this);
        return;
        try {
        label_6:
            this.setProgressCompat(arg2, false);
        }
        catch(Throwable v2) {
            try {
            label_10:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_10;
            }

            throw v2;
        }

        __monitor_exit(this);
    }

    public void setProgressCompat(int arg2, boolean arg3) {
        if(!this.isIndeterminate()) {
            super.setProgress(arg2);
            if(this.getProgressDrawable() == null) {
                return;
            }

            if(arg3) {
                return;
            }

            this.getProgressDrawable().jumpToCurrentState();
        }
        else if(this.getProgressDrawable() != null) {
            this.storedProgress = arg2;
            this.storedProgressAnimated = arg3;
            this.isIndeterminateModeChangeRequested = true;
            if(this.getIndeterminateDrawable().isVisible()) {
                if(this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.getContext().getContentResolver()) == 0f) {
                }
                else {
                    this.getIndeterminateDrawable().getAnimatorDelegate().requestCancelAnimatorAfterCurrentCycle();
                    return;
                }
            }

            this.switchIndeterminateModeCallback.onAnimationEnd(this.getIndeterminateDrawable());
            return;
        }
    }

    public void setProgressDrawable(Drawable arg2) {
        if(arg2 == null) {
            super.setProgressDrawable(null);
            return;
        }

        if((arg2 instanceof DeterminateDrawable)) {
            ((DeterminateDrawable)arg2).hideNow();
            super.setProgressDrawable(arg2);
            ((DeterminateDrawable)arg2).setLevelByFraction((((float)this.getProgress())) / (((float)this.getMax())));
            return;
        }

        throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
    }

    public void setShowAnimationBehavior(int arg2) {
        this.spec.showAnimationBehavior = arg2;
        this.invalidate();
    }

    public void setTrackColor(int arg2) {
        if(this.spec.trackColor != arg2) {
            this.spec.trackColor = arg2;
            this.invalidate();
        }
    }

    public void setTrackCornerRadius(int arg2) {
        if(this.spec.trackCornerRadius != arg2) {
            this.spec.trackCornerRadius = Math.min(arg2, this.spec.trackThickness / 2);
        }
    }

    public void setTrackThickness(int arg2) {
        if(this.spec.trackThickness != arg2) {
            this.spec.trackThickness = arg2;
            this.requestLayout();
        }
    }

    public void setVisibilityAfterHide(int arg2) {
        if(arg2 != 0 && arg2 != 4) {
            if(arg2 == 8) {
            }
            else {
                throw new IllegalArgumentException("The component\'s visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
            }
        }

        this.visibilityAfterHide = arg2;
    }

    public void show() {
        int v0 = this.showDelay;
        Runnable v1 = this.delayedShow;
        if(v0 > 0) {
            this.removeCallbacks(v1);
            this.postDelayed(this.delayedShow, ((long)this.showDelay));
            return;
        }

        v1.run();
    }

    private void unregisterAnimationCallbacks() {
        if(this.getIndeterminateDrawable() != null) {
            this.getIndeterminateDrawable().unregisterAnimationCallback(this.hideAnimationCallback);
            this.getIndeterminateDrawable().getAnimatorDelegate().unregisterAnimatorsCompleteCallback();
        }

        if(this.getProgressDrawable() != null) {
            this.getProgressDrawable().unregisterAnimationCallback(this.hideAnimationCallback);
        }
    }

    boolean visibleToUser() {
        if((ViewCompat.isAttachedToWindow(((View)this))) && this.getWindowVisibility() == 0 && (this.isEffectivelyVisible())) {
            return 1;
        }

        return 0;
    }
}

