package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MotionUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class HideBottomViewOnScrollBehavior extends Behavior {
    public interface OnScrollStateChangedListener {
        void onStateChanged(View arg1, int arg2);
    }

    @public interface ScrollState {
    }

    private static final int DEFAULT_ENTER_ANIMATION_DURATION_MS = 0xE1;
    private static final int DEFAULT_EXIT_ANIMATION_DURATION_MS = 0xAF;
    private static final int ENTER_ANIM_DURATION_ATTR = 0;
    private static final int ENTER_EXIT_ANIM_EASING_ATTR = 0;
    private static final int EXIT_ANIM_DURATION_ATTR = 0;
    public static final int STATE_SCROLLED_DOWN = 1;
    public static final int STATE_SCROLLED_UP = 2;
    private int additionalHiddenOffsetY;
    private ViewPropertyAnimator currentAnimator;
    private int currentState;
    private int enterAnimDuration;
    private TimeInterpolator enterAnimInterpolator;
    private int exitAnimDuration;
    private TimeInterpolator exitAnimInterpolator;
    private int height;
    private final LinkedHashSet onScrollStateChangedListeners;

    static {
        HideBottomViewOnScrollBehavior.ENTER_ANIM_DURATION_ATTR = attr.motionDurationLong2;
        HideBottomViewOnScrollBehavior.EXIT_ANIM_DURATION_ATTR = attr.motionDurationMedium4;
        HideBottomViewOnScrollBehavior.ENTER_EXIT_ANIM_EASING_ATTR = attr.motionEasingEmphasizedInterpolator;
    }

    public HideBottomViewOnScrollBehavior() {
        super();
        this.onScrollStateChangedListeners = new LinkedHashSet();
        this.height = 0;
        this.currentState = 2;
        this.additionalHiddenOffsetY = 0;
    }

    public HideBottomViewOnScrollBehavior(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
        this.onScrollStateChangedListeners = new LinkedHashSet();
        this.height = 0;
        this.currentState = 2;
        this.additionalHiddenOffsetY = 0;
    }

    static ViewPropertyAnimator access$002(HideBottomViewOnScrollBehavior arg0, ViewPropertyAnimator arg1) {
        arg0.currentAnimator = arg1;
        return arg1;
    }

    public void addOnScrollStateChangedListener(OnScrollStateChangedListener arg1) {
        this.onScrollStateChangedListeners.add(arg1);
    }

    private void animateChildTo(View arg1, int arg2, long arg3, TimeInterpolator arg5) {
        this.currentAnimator = arg1.animate().translationY(((float)arg2)).setInterpolator(arg5).setDuration(arg3).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator arg1) {
                HideBottomViewOnScrollBehavior.this.currentAnimator = null;
            }
        });
    }

    public void clearOnScrollStateChangedListeners() {
        this.onScrollStateChangedListeners.clear();
    }

    public boolean isScrolledDown() {
        if(this.currentState == 1) {
            return 1;
        }

        return 0;
    }

    public boolean isScrolledUp() {
        if(this.currentState == 2) {
            return 1;
        }

        return 0;
    }

    public boolean onLayoutChild(CoordinatorLayout arg4, View arg5, int arg6) {
        this.height = arg5.getMeasuredHeight() + arg5.getLayoutParams().bottomMargin;
        this.enterAnimDuration = MotionUtils.resolveThemeDuration(arg5.getContext(), HideBottomViewOnScrollBehavior.ENTER_ANIM_DURATION_ATTR, 0xE1);
        this.exitAnimDuration = MotionUtils.resolveThemeDuration(arg5.getContext(), HideBottomViewOnScrollBehavior.EXIT_ANIM_DURATION_ATTR, 0xAF);
        Context v0 = arg5.getContext();
        int v1 = HideBottomViewOnScrollBehavior.ENTER_EXIT_ANIM_EASING_ATTR;
        this.enterAnimInterpolator = MotionUtils.resolveThemeInterpolator(v0, v1, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        this.exitAnimInterpolator = MotionUtils.resolveThemeInterpolator(arg5.getContext(), v1, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        return super.onLayoutChild(arg4, arg5, arg6);
    }

    public void onNestedScroll(CoordinatorLayout arg1, View arg2, View arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int[] arg9) {
        if(arg5 > 0) {
            this.slideDown(arg2);
            return;
        }

        if(arg5 < 0) {
            this.slideUp(arg2);
        }
    }

    public boolean onStartNestedScroll(CoordinatorLayout arg1, View arg2, View arg3, View arg4, int arg5, int arg6) {
        if(arg5 == 2) {
            return 1;
        }

        return 0;
    }

    public void removeOnScrollStateChangedListener(OnScrollStateChangedListener arg1) {
        this.onScrollStateChangedListeners.remove(arg1);
    }

    public void setAdditionalHiddenOffsetY(View arg3, int arg4) {
        this.additionalHiddenOffsetY = arg4;
        if(this.currentState == 1) {
            arg3.setTranslationY(((float)(this.height + arg4)));
        }
    }

    public void slideDown(View arg2) {
        this.slideDown(arg2, true);
    }

    public void slideDown(View arg9, boolean arg10) {
        if(this.isScrolledDown()) {
            return;
        }

        ViewPropertyAnimator v0 = this.currentAnimator;
        if(v0 != null) {
            v0.cancel();
            arg9.clearAnimation();
        }

        this.updateCurrentState(arg9, 1);
        int v4 = this.height + this.additionalHiddenOffsetY;
        if(arg10) {
            this.animateChildTo(arg9, v4, ((long)this.exitAnimDuration), this.exitAnimInterpolator);
            return;
        }

        arg9.setTranslationY(((float)v4));
    }

    public void slideUp(View arg2) {
        this.slideUp(arg2, true);
    }

    public void slideUp(View arg7, boolean arg8) {
        if(this.isScrolledUp()) {
            return;
        }

        ViewPropertyAnimator v0 = this.currentAnimator;
        if(v0 != null) {
            v0.cancel();
            arg7.clearAnimation();
        }

        this.updateCurrentState(arg7, 2);
        if(arg8) {
            this.animateChildTo(arg7, 0, ((long)this.enterAnimDuration), this.enterAnimInterpolator);
            return;
        }

        arg7.setTranslationY(0f);
    }

    private void updateCurrentState(View arg3, int arg4) {
        this.currentState = arg4;
        Iterator v4 = this.onScrollStateChangedListeners.iterator();
        while(v4.hasNext()) {
            v4.next().onStateChanged(arg3, this.currentState);
        }
    }
}

