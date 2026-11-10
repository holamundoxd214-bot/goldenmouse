package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View$AccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import java.util.ArrayList;
import java.util.List;

final class IndicatorViewController {
    private static final int CAPTION_STATE_ERROR = 1;
    private static final int CAPTION_STATE_HELPER_TEXT = 2;
    private static final int CAPTION_STATE_NONE = 0;
    static final int COUNTER_INDEX = 2;
    private static final int DEFAULT_CAPTION_FADE_ANIMATION_DURATION = 0xA7;
    private static final int DEFAULT_CAPTION_TRANSLATION_Y_ANIMATION_DURATION = 0xD9;
    static final int ERROR_INDEX = 0;
    static final int HELPER_INDEX = 1;
    private Animator captionAnimator;
    private FrameLayout captionArea;
    private int captionDisplayed;
    private final int captionFadeInAnimationDuration;
    private final TimeInterpolator captionFadeInAnimationInterpolator;
    private final int captionFadeOutAnimationDuration;
    private final TimeInterpolator captionFadeOutAnimationInterpolator;
    private int captionToShow;
    private final int captionTranslationYAnimationDuration;
    private final TimeInterpolator captionTranslationYAnimationInterpolator;
    private final float captionTranslationYPx;
    private final Context context;
    private boolean errorEnabled;
    private CharSequence errorText;
    private int errorTextAppearance;
    private TextView errorView;
    private int errorViewAccessibilityLiveRegion;
    private CharSequence errorViewContentDescription;
    private ColorStateList errorViewTextColor;
    private CharSequence helperText;
    private boolean helperTextEnabled;
    private int helperTextTextAppearance;
    private TextView helperTextView;
    private ColorStateList helperTextViewTextColor;
    private LinearLayout indicatorArea;
    private int indicatorsAdded;
    private final TextInputLayout textInputView;
    private Typeface typeface;

    public IndicatorViewController(TextInputLayout arg3) {
        super();
        Context v0 = arg3.getContext();
        this.context = v0;
        this.textInputView = arg3;
        this.captionTranslationYPx = ((float)v0.getResources().getDimensionPixelSize(dimen.design_textinput_caption_translate_y));
        this.captionTranslationYAnimationDuration = MotionUtils.resolveThemeDuration(v0, attr.motionDurationShort4, 0xD9);
        this.captionFadeInAnimationDuration = MotionUtils.resolveThemeDuration(v0, attr.motionDurationMedium4, 0xA7);
        this.captionFadeOutAnimationDuration = MotionUtils.resolveThemeDuration(v0, attr.motionDurationShort4, 0xA7);
        this.captionTranslationYAnimationInterpolator = MotionUtils.resolveThemeInterpolator(v0, attr.motionEasingEmphasizedDecelerateInterpolator, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        this.captionFadeInAnimationInterpolator = MotionUtils.resolveThemeInterpolator(v0, attr.motionEasingEmphasizedDecelerateInterpolator, AnimationUtils.LINEAR_INTERPOLATOR);
        this.captionFadeOutAnimationInterpolator = MotionUtils.resolveThemeInterpolator(v0, attr.motionEasingLinearInterpolator, AnimationUtils.LINEAR_INTERPOLATOR);
    }

    static int access$002(IndicatorViewController arg0, int arg1) {
        arg0.captionDisplayed = arg1;
        return arg1;
    }

    static Animator access$102(IndicatorViewController arg0, Animator arg1) {
        arg0.captionAnimator = arg1;
        return arg1;
    }

    static TextView access$200(IndicatorViewController arg0) {
        return arg0.errorView;
    }

    static TextInputLayout access$300(IndicatorViewController arg0) {
        return arg0.textInputView;
    }

    void addIndicator(TextView arg6, int arg7) {
        int v2 = -2;
        if(this.indicatorArea == null && this.captionArea == null) {
            LinearLayout v0 = new LinearLayout(this.context);
            this.indicatorArea = v0;
            v0.setOrientation(0);
            this.textInputView.addView(this.indicatorArea, -1, v2);
            this.captionArea = new FrameLayout(this.context);
            this.indicatorArea.addView(this.captionArea, new LinearLayout$LayoutParams(0, v2, 1f));
            if(this.textInputView.getEditText() != null) {
                this.adjustIndicatorPadding();
            }
        }

        if(this.isCaptionView(arg7)) {
            this.captionArea.setVisibility(0);
            this.captionArea.addView(((View)arg6));
        }
        else {
            this.indicatorArea.addView(((View)arg6), new LinearLayout$LayoutParams(v2, v2));
        }

        this.indicatorArea.setVisibility(0);
        ++this.indicatorsAdded;
    }

    void adjustIndicatorPadding() {
        if(this.canAdjustIndicatorPadding()) {
            EditText v0 = this.textInputView.getEditText();
            boolean v1 = MaterialResources.isFontScaleAtLeast1_3(this.context);
            ViewCompat.setPaddingRelative(this.indicatorArea, this.getIndicatorPadding(v1, dimen.material_helper_text_font_1_3_padding_horizontal, ViewCompat.getPaddingStart(((View)v0))), this.getIndicatorPadding(v1, dimen.material_helper_text_font_1_3_padding_top, this.context.getResources().getDimensionPixelSize(dimen.material_helper_text_default_padding_top)), this.getIndicatorPadding(v1, dimen.material_helper_text_font_1_3_padding_horizontal, ViewCompat.getPaddingEnd(((View)v0))), 0);
        }
    }

    private boolean canAdjustIndicatorPadding() {
        if(this.indicatorArea != null && this.textInputView.getEditText() != null) {
            return 1;
        }

        return 0;
    }

    void cancelCaptionAnimator() {
        Animator v0 = this.captionAnimator;
        if(v0 != null) {
            v0.cancel();
        }
    }

    private void createCaptionAnimators(List arg3, boolean arg4, TextView arg5, int arg6, int arg7, int arg8) {
        if(arg5 != null) {
            if(!arg4) {
            }
            else {
                if(arg6 != arg8) {
                    if(arg6 == arg7) {
                    }
                    else {
                        return;
                    }
                }

                arg4 = arg8 == arg6 ? true : false;
                ObjectAnimator v4 = this.createCaptionOpacityAnimator(arg5, arg4);
                if(arg6 == arg8 && arg7 != 0) {
                    ((Animator)v4).setStartDelay(((long)this.captionFadeOutAnimationDuration));
                }

                arg3.add(v4);
                if(arg8 != arg6) {
                    return;
                }

                if(arg7 == 0) {
                    return;
                }

                v4 = this.createCaptionTranslationYAnimator(arg5);
                ((Animator)v4).setStartDelay(((long)this.captionFadeOutAnimationDuration));
                arg3.add(v4);
            }
        }
    }

    private ObjectAnimator createCaptionOpacityAnimator(TextView arg5, boolean arg6) {
        float v0 = arg6 ? 1f : 0f;
        ObjectAnimator v5 = ObjectAnimator.ofFloat(arg5, View.ALPHA, new float[]{v0});
        int v0_1 = arg6 ? this.captionFadeInAnimationDuration : this.captionFadeOutAnimationDuration;
        v5.setDuration(((long)v0_1));
        TimeInterpolator v4 = arg6 ? this.captionFadeInAnimationInterpolator : this.captionFadeOutAnimationInterpolator;
        v5.setInterpolator(v4);
        return v5;
    }

    private ObjectAnimator createCaptionTranslationYAnimator(TextView arg5) {
        ObjectAnimator v5 = ObjectAnimator.ofFloat(arg5, View.TRANSLATION_Y, new float[]{-this.captionTranslationYPx, 0f});
        v5.setDuration(((long)this.captionTranslationYAnimationDuration));
        v5.setInterpolator(this.captionTranslationYAnimationInterpolator);
        return v5;
    }

    boolean errorIsDisplayed() {
        return this.isCaptionStateError(this.captionDisplayed);
    }

    boolean errorShouldBeShown() {
        return this.isCaptionStateError(this.captionToShow);
    }

    private TextView getCaptionViewFromDisplayState(int arg2) {
        if(arg2 != 1) {
            if(arg2 != 2) {
                return null;
            }

            return this.helperTextView;
        }

        return this.errorView;
    }

    int getErrorAccessibilityLiveRegion() {
        return this.errorViewAccessibilityLiveRegion;
    }

    CharSequence getErrorContentDescription() {
        return this.errorViewContentDescription;
    }

    CharSequence getErrorText() {
        return this.errorText;
    }

    int getErrorViewCurrentTextColor() {
        TextView v0 = this.errorView;
        if(v0 != null) {
            return v0.getCurrentTextColor();
        }

        return -1;
    }

    ColorStateList getErrorViewTextColors() {
        TextView v0 = this.errorView;
        if(v0 != null) {
            return v0.getTextColors();
        }

        return null;
    }

    CharSequence getHelperText() {
        return this.helperText;
    }

    View getHelperTextView() {
        return this.helperTextView;
    }

    ColorStateList getHelperTextViewColors() {
        TextView v0 = this.helperTextView;
        if(v0 != null) {
            return v0.getTextColors();
        }

        return null;
    }

    int getHelperTextViewCurrentTextColor() {
        TextView v0 = this.helperTextView;
        if(v0 != null) {
            return v0.getCurrentTextColor();
        }

        return -1;
    }

    private int getIndicatorPadding(boolean arg1, int arg2, int arg3) {
        if(arg1) {
            return this.context.getResources().getDimensionPixelSize(arg2);
        }

        return arg3;
    }

    boolean helperTextIsDisplayed() {
        return this.isCaptionStateHelperText(this.captionDisplayed);
    }

    boolean helperTextShouldBeShown() {
        return this.isCaptionStateHelperText(this.captionToShow);
    }

    void hideError() {
        this.errorText = null;
        this.cancelCaptionAnimator();
        if(this.captionDisplayed == 1) {
            if((this.helperTextEnabled) && !TextUtils.isEmpty(this.helperText)) {
                this.captionToShow = 2;
                goto label_16;
            }

            this.captionToShow = 0;
        }

    label_16:
        this.updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, this.shouldAnimateCaptionView(this.errorView, ""));
    }

    void hideHelperText() {
        this.cancelCaptionAnimator();
        int v0 = this.captionDisplayed;
        if(v0 == 2) {
            this.captionToShow = 0;
        }

        this.updateCaptionViewsVisibility(v0, this.captionToShow, this.shouldAnimateCaptionView(this.helperTextView, ""));
    }

    private boolean isCaptionStateError(int arg2) {
        if(arg2 == 1 && this.errorView != null && !TextUtils.isEmpty(this.errorText)) {
            return 1;
        }

        return 0;
    }

    private boolean isCaptionStateHelperText(int arg2) {
        if(arg2 == 2 && this.helperTextView != null && !TextUtils.isEmpty(this.helperText)) {
            return 1;
        }

        return 0;
    }

    boolean isCaptionView(int arg1) {
        boolean v0 = true;
        if(arg1 != 0) {
            if(arg1 == 1) {
            }
            else {
                v0 = false;
            }
        }

        return v0;
    }

    boolean isErrorEnabled() {
        return this.errorEnabled;
    }

    boolean isHelperTextEnabled() {
        return this.helperTextEnabled;
    }

    void removeIndicator(TextView arg2, int arg3) {
        if(this.indicatorArea == null) {
            return;
        }

        if(this.isCaptionView(arg3)) {
            FrameLayout v3 = this.captionArea;
            if(v3 != null) {
                v3.removeView(((View)arg2));
            }
            else {
                goto label_9;
            }
        }
        else {
        label_9:
            this.indicatorArea.removeView(((View)arg2));
        }

        int v2 = this.indicatorsAdded - 1;
        this.indicatorsAdded = v2;
        this.setViewGroupGoneIfEmpty(this.indicatorArea, v2);
    }

    private void setCaptionViewVisibilities(int arg3, int arg4) {
        TextView v0;
        if(arg3 == arg4) {
            return;
        }

        if(arg4 != 0) {
            v0 = this.getCaptionViewFromDisplayState(arg4);
            if(v0 != null) {
                v0.setVisibility(0);
                v0.setAlpha(1f);
            }
        }

        if(arg3 != 0) {
            v0 = this.getCaptionViewFromDisplayState(arg3);
            if(v0 != null) {
                v0.setVisibility(4);
                if(arg3 == 1) {
                    v0.setText(null);
                }
            }
        }

        this.captionDisplayed = arg4;
    }

    void setErrorAccessibilityLiveRegion(int arg1) {
        this.errorViewAccessibilityLiveRegion = arg1;
        TextView v0 = this.errorView;
        if(v0 != null) {
            ViewCompat.setAccessibilityLiveRegion(((View)v0), arg1);
        }
    }

    void setErrorContentDescription(CharSequence arg1) {
        this.errorViewContentDescription = arg1;
        TextView v0 = this.errorView;
        if(v0 != null) {
            v0.setContentDescription(arg1);
        }
    }

    void setErrorEnabled(boolean arg4) {
        if(this.errorEnabled == arg4) {
            return;
        }

        this.cancelCaptionAnimator();
        if(arg4) {
            AppCompatTextView v1 = new AppCompatTextView(this.context);
            this.errorView = ((TextView)v1);
            ((TextView)v1).setId(id.textinput_error);
            this.errorView.setTextAlignment(5);
            Typeface v1_1 = this.typeface;
            if(v1_1 != null) {
                this.errorView.setTypeface(v1_1);
            }

            this.setErrorTextAppearance(this.errorTextAppearance);
            this.setErrorViewTextColor(this.errorViewTextColor);
            this.setErrorContentDescription(this.errorViewContentDescription);
            this.setErrorAccessibilityLiveRegion(this.errorViewAccessibilityLiveRegion);
            this.errorView.setVisibility(4);
            this.addIndicator(this.errorView, 0);
        }
        else {
            this.hideError();
            this.removeIndicator(this.errorView, 0);
            this.errorView = null;
            this.textInputView.updateEditTextBackground();
            this.textInputView.updateTextInputBoxState();
        }

        this.errorEnabled = arg4;
    }

    void setErrorTextAppearance(int arg2) {
        this.errorTextAppearance = arg2;
        TextView v0 = this.errorView;
        if(v0 != null) {
            this.textInputView.setTextAppearanceCompatWithErrorFallback(v0, arg2);
        }
    }

    void setErrorViewTextColor(ColorStateList arg1) {
        this.errorViewTextColor = arg1;
        TextView v0 = this.errorView;
        if(v0 != null && arg1 != null) {
            v0.setTextColor(arg1);
        }
    }

    void setHelperTextAppearance(int arg1) {
        this.helperTextTextAppearance = arg1;
        TextView v0 = this.helperTextView;
        if(v0 != null) {
            TextViewCompat.setTextAppearance(v0, arg1);
        }
    }

    void setHelperTextEnabled(boolean arg4) {
        if(this.helperTextEnabled == arg4) {
            return;
        }

        this.cancelCaptionAnimator();
        if(arg4) {
            AppCompatTextView v1 = new AppCompatTextView(this.context);
            this.helperTextView = ((TextView)v1);
            ((TextView)v1).setId(id.textinput_helper_text);
            this.helperTextView.setTextAlignment(5);
            Typeface v1_1 = this.typeface;
            if(v1_1 != null) {
                this.helperTextView.setTypeface(v1_1);
            }

            this.helperTextView.setVisibility(4);
            ViewCompat.setAccessibilityLiveRegion(this.helperTextView, 1);
            this.setHelperTextAppearance(this.helperTextTextAppearance);
            this.setHelperTextViewTextColor(this.helperTextViewTextColor);
            this.addIndicator(this.helperTextView, 1);
            this.helperTextView.setAccessibilityDelegate(new View$AccessibilityDelegate() {
                public void onInitializeAccessibilityNodeInfo(View arg1, AccessibilityNodeInfo arg2) {
                    super.onInitializeAccessibilityNodeInfo(arg1, arg2);
                    EditText v0 = IndicatorViewController.this.textInputView.getEditText();
                    if(v0 != null) {
                        arg2.setLabeledBy(((View)v0));
                    }
                }
            });
        }
        else {
            this.hideHelperText();
            this.removeIndicator(this.helperTextView, 1);
            this.helperTextView = null;
            this.textInputView.updateEditTextBackground();
            this.textInputView.updateTextInputBoxState();
        }

        this.helperTextEnabled = arg4;
    }

    void setHelperTextViewTextColor(ColorStateList arg1) {
        this.helperTextViewTextColor = arg1;
        TextView v0 = this.helperTextView;
        if(v0 != null && arg1 != null) {
            v0.setTextColor(arg1);
        }
    }

    private void setTextViewTypeface(TextView arg1, Typeface arg2) {
        if(arg1 != null) {
            arg1.setTypeface(arg2);
        }
    }

    void setTypefaces(Typeface arg2) {
        if(arg2 != this.typeface) {
            this.typeface = arg2;
            this.setTextViewTypeface(this.errorView, arg2);
            this.setTextViewTypeface(this.helperTextView, arg2);
        }
    }

    private void setViewGroupGoneIfEmpty(ViewGroup arg1, int arg2) {
        if(arg2 == 0) {
            arg1.setVisibility(8);
        }
    }

    private boolean shouldAnimateCaptionView(TextView arg2, CharSequence arg3) {
        if((ViewCompat.isLaidOut(this.textInputView)) && (this.textInputView.isEnabled()) && (this.captionToShow != this.captionDisplayed || arg2 == null || !TextUtils.equals(arg2.getText(), arg3))) {
            return 1;
        }

        return 0;
    }

    void showError(CharSequence arg4) {
        this.cancelCaptionAnimator();
        this.errorText = arg4;
        this.errorView.setText(arg4);
        int v0 = this.captionDisplayed;
        if(v0 != 1) {
            this.captionToShow = 1;
        }

        this.updateCaptionViewsVisibility(v0, this.captionToShow, this.shouldAnimateCaptionView(this.errorView, arg4));
    }

    void showHelper(CharSequence arg4) {
        this.cancelCaptionAnimator();
        this.helperText = arg4;
        this.helperTextView.setText(arg4);
        int v0 = this.captionDisplayed;
        int v1 = 2;
        if(v0 != v1) {
            this.captionToShow = v1;
        }

        this.updateCaptionViewsVisibility(v0, this.captionToShow, this.shouldAnimateCaptionView(this.helperTextView, arg4));
    }

    private void updateCaptionViewsVisibility(int arg13, int arg14, boolean arg15) {
        IndicatorViewController v1;
        if(arg13 == arg14) {
            return;
        }

        if(arg15) {
            AnimatorSet v0 = new AnimatorSet();
            this.captionAnimator = ((Animator)v0);
            ArrayList v2 = new ArrayList();
            v1 = this;
            v1.createCaptionAnimators(((List)v2), this.helperTextEnabled, this.helperTextView, 2, arg13, arg14);
            v1.createCaptionAnimators(((List)v2), v1.errorEnabled, v1.errorView, 1, arg13, arg14);
            AnimatorSetCompat.playTogether(v0, ((List)v2));
            v0.addListener(new AnimatorListenerAdapter(arg14, v1.getCaptionViewFromDisplayState(arg13), arg13, v1.getCaptionViewFromDisplayState(arg14)) {
                public void onAnimationEnd(Animator arg3) {
                    IndicatorViewController.this.captionDisplayed = this.val$captionToShow;
                    Animator v0 = null;
                    IndicatorViewController.this.captionAnimator = v0;
                    TextView v3 = this.val$captionViewToHide;
                    if(v3 != null) {
                        v3.setVisibility(4);
                        if(this.val$captionToHide == 1 && IndicatorViewController.this.errorView != null) {
                            IndicatorViewController.this.errorView.setText(((CharSequence)v0));
                        }
                    }

                    v3 = this.val$captionViewToShow;
                    if(v3 != null) {
                        v3.setTranslationY(0f);
                        this.val$captionViewToShow.setAlpha(1f);
                    }
                }

                public void onAnimationStart(Animator arg2) {
                    TextView v2 = this.val$captionViewToShow;
                    if(v2 != null) {
                        v2.setVisibility(0);
                        this.val$captionViewToShow.setAlpha(0f);
                    }
                }
            });
            v0.start();
        }
        else {
            v1 = this;
            v1.setCaptionViewVisibilities(arg13, arg14);
        }

        v1.textInputView.updateEditTextBackground();
        v1.textInputView.updateLabelState(arg15);
        v1.textInputView.updateTextInputBoxState();
    }
}

