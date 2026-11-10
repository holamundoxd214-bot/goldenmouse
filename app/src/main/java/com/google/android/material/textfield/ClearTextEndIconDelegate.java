package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.view.View$OnClickListener;
import android.view.View$OnFocusChangeListener;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R$attr;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MotionUtils;

class ClearTextEndIconDelegate extends EndIconDelegate {
    private static final float ANIMATION_SCALE_FROM_VALUE = 0.8f;
    private static final int DEFAULT_ANIMATION_FADE_DURATION = 100;
    private static final int DEFAULT_ANIMATION_SCALE_DURATION = 150;
    private final int animationFadeDuration;
    private final TimeInterpolator animationFadeInterpolator;
    private final int animationScaleDuration;
    private final TimeInterpolator animationScaleInterpolator;
    private EditText editText;
    private AnimatorSet iconInAnim;
    private ValueAnimator iconOutAnim;
    private final View$OnFocusChangeListener onFocusChangeListener;
    private final View$OnClickListener onIconClickListener;

    ClearTextEndIconDelegate(EndCompoundLayout arg4) {
        super(arg4);
        this.onIconClickListener = new ClearTextEndIconDelegate$$ExternalSyntheticLambda0(this);
        this.onFocusChangeListener = new ClearTextEndIconDelegate$$ExternalSyntheticLambda1(this);
        this.animationFadeDuration = MotionUtils.resolveThemeDuration(arg4.getContext(), attr.motionDurationShort3, 100);
        this.animationScaleDuration = MotionUtils.resolveThemeDuration(arg4.getContext(), attr.motionDurationShort3, 150);
        this.animationFadeInterpolator = MotionUtils.resolveThemeInterpolator(arg4.getContext(), attr.motionEasingLinearInterpolator, AnimationUtils.LINEAR_INTERPOLATOR);
        this.animationScaleInterpolator = MotionUtils.resolveThemeInterpolator(arg4.getContext(), attr.motionEasingEmphasizedInterpolator, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
    }

    void afterEditTextChanged(Editable arg1) {
        if(this.endLayout.getSuffixText() != null) {
            return;
        }

        this.animateIcon(this.shouldBeVisible());
    }

    private void animateIcon(boolean arg3) {
        int v0 = this.endLayout.isEndIconVisible() == arg3 ? 1 : 0;
        if((arg3) && !this.iconInAnim.isRunning()) {
            this.iconOutAnim.cancel();
            this.iconInAnim.start();
            if(v0 != 0) {
                this.iconInAnim.end();
                return;
            }
        }
        else if(!arg3) {
            this.iconInAnim.cancel();
            this.iconOutAnim.start();
            if(v0 != 0) {
                this.iconOutAnim.end();
            }
        }
    }

    private ValueAnimator getAlphaAnimator(float[] arg3) {
        ValueAnimator v3 = ValueAnimator.ofFloat(arg3);
        v3.setInterpolator(this.animationFadeInterpolator);
        v3.setDuration(((long)this.animationFadeDuration));
        v3.addUpdateListener(new ClearTextEndIconDelegate$$ExternalSyntheticLambda2(this));
        return v3;
    }

    int getIconContentDescriptionResId() {
        return string.clear_text_end_icon_content_description;
    }

    int getIconDrawableResId() {
        return drawable.mtrl_ic_cancel;
    }

    View$OnFocusChangeListener getOnEditTextFocusChangeListener() {
        return this.onFocusChangeListener;
    }

    View$OnClickListener getOnIconClickListener() {
        return this.onIconClickListener;
    }

    View$OnFocusChangeListener getOnIconViewFocusChangeListener() {
        return this.onFocusChangeListener;
    }

    private ValueAnimator getScaleAnimator() {
        ValueAnimator v0 = ValueAnimator.ofFloat(new float[]{0.8f, 1f});
        v0.setInterpolator(this.animationScaleInterpolator);
        v0.setDuration(((long)this.animationScaleDuration));
        v0.addUpdateListener(new ClearTextEndIconDelegate$$ExternalSyntheticLambda4(this));
        return v0;
    }

    private void initAnimators() {
        ValueAnimator v0 = this.getScaleAnimator();
        ValueAnimator v2 = this.getAlphaAnimator(new float[]{0f, 1f});
        AnimatorSet v3 = new AnimatorSet();
        this.iconInAnim = v3;
        v3.playTogether(new Animator[]{v0, v2});
        this.iconInAnim.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator arg1) {
                ClearTextEndIconDelegate.this.endLayout.setEndIconVisible(true);
            }
        });
        v0 = this.getAlphaAnimator(new float[]{1f, 0f});
        this.iconOutAnim = v0;
        v0.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator arg1) {
                ClearTextEndIconDelegate.this.endLayout.setEndIconVisible(false);
            }
        });
    }

    void lambda$getAlphaAnimator$3$com-google-android-material-textfield-ClearTextEndIconDelegate(ValueAnimator arg1) {
        this.endIconView.setAlpha(arg1.getAnimatedValue().floatValue());
    }

    void lambda$getScaleAnimator$4$com-google-android-material-textfield-ClearTextEndIconDelegate(ValueAnimator arg2) {
        float v2 = arg2.getAnimatedValue().floatValue();
        this.endIconView.setScaleX(v2);
        this.endIconView.setScaleY(v2);
    }

    void lambda$new$0$com-google-android-material-textfield-ClearTextEndIconDelegate(View arg1) {
        EditText v1 = this.editText;
        if(v1 == null) {
            return;
        }

        Editable v1_1 = v1.getText();
        if(v1_1 != null) {
            v1_1.clear();
        }

        this.refreshIconState();
    }

    void lambda$new$1$com-google-android-material-textfield-ClearTextEndIconDelegate(View arg1, boolean arg2) {
        this.animateIcon(this.shouldBeVisible());
    }

    void lambda$tearDown$2$com-google-android-material-textfield-ClearTextEndIconDelegate() {
        this.animateIcon(true);
    }

    public void onEditTextAttached(EditText arg1) {
        this.editText = arg1;
        this.textInputLayout.setEndIconVisible(this.shouldBeVisible());
    }

    void onSuffixVisibilityChanged(boolean arg2) {
        if(this.endLayout.getSuffixText() == null) {
            return;
        }

        this.animateIcon(arg2);
    }

    void setUp() {
        this.initAnimators();
    }

    private boolean shouldBeVisible() {
        EditText v0 = this.editText;
        if(v0 != null && ((v0.hasFocus()) || (this.endIconView.hasFocus())) && this.editText.getText().length() > 0) {
            return 1;
        }

        return 0;
    }

    void tearDown() {
        EditText v0 = this.editText;
        if(v0 != null) {
            v0.post(new ClearTextEndIconDelegate$$ExternalSyntheticLambda3(this));
        }
    }
}

