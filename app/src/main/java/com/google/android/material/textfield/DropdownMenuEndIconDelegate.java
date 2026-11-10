package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View$OnClickListener;
import android.view.View$OnFocusChangeListener;
import android.view.View$OnTouchListener;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView$OnDismissListener;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat$TouchExplorationStateChangeListener;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.motion.MotionUtils;

class DropdownMenuEndIconDelegate extends EndIconDelegate {
    private static final int DEFAULT_ANIMATION_FADE_IN_DURATION = 67;
    private static final int DEFAULT_ANIMATION_FADE_OUT_DURATION = 50;
    private static final boolean IS_LOLLIPOP;
    private AccessibilityManager accessibilityManager;
    private final int animationFadeInDuration;
    private final TimeInterpolator animationFadeInterpolator;
    private final int animationFadeOutDuration;
    private AutoCompleteTextView autoCompleteTextView;
    private long dropdownPopupActivatedAt;
    private boolean dropdownPopupDirty;
    private boolean editTextHasFocus;
    private ValueAnimator fadeInAnim;
    private ValueAnimator fadeOutAnim;
    private boolean isEndIconChecked;
    private final View$OnFocusChangeListener onEditTextFocusChangeListener;
    private final View$OnClickListener onIconClickListener;
    private final TouchExplorationStateChangeListener touchExplorationStateChangeListener;

    static {
        DropdownMenuEndIconDelegate.IS_LOLLIPOP = true;
    }

    DropdownMenuEndIconDelegate(EndCompoundLayout arg4) {
        super(arg4);
        this.onIconClickListener = new DropdownMenuEndIconDelegate$$ExternalSyntheticLambda3(this);
        this.onEditTextFocusChangeListener = new DropdownMenuEndIconDelegate$$ExternalSyntheticLambda4(this);
        this.touchExplorationStateChangeListener = new DropdownMenuEndIconDelegate$$ExternalSyntheticLambda5(this);
        this.dropdownPopupActivatedAt = 0x7FFFFFFFFFFFFFFFL;
        this.animationFadeInDuration = MotionUtils.resolveThemeDuration(arg4.getContext(), attr.motionDurationShort3, 67);
        this.animationFadeOutDuration = MotionUtils.resolveThemeDuration(arg4.getContext(), attr.motionDurationShort3, 50);
        this.animationFadeInterpolator = MotionUtils.resolveThemeInterpolator(arg4.getContext(), attr.motionEasingLinearInterpolator, AnimationUtils.LINEAR_INTERPOLATOR);
    }

    static ValueAnimator access$000(DropdownMenuEndIconDelegate arg0) {
        return arg0.fadeInAnim;
    }

    public void afterEditTextChanged(Editable arg2) {
        if((this.accessibilityManager.isTouchExplorationEnabled()) && (EditTextUtils.isEditable(this.autoCompleteTextView)) && !this.endIconView.hasFocus()) {
            this.autoCompleteTextView.dismissDropDown();
        }

        this.autoCompleteTextView.post(new DropdownMenuEndIconDelegate$$ExternalSyntheticLambda6(this));
    }

    private static AutoCompleteTextView castAutoCompleteTextViewOrThrow(EditText arg1) {
        if((arg1 instanceof AutoCompleteTextView)) {
            return arg1;
        }

        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator getAlphaAnimator(int arg3, float[] arg4) {
        ValueAnimator v4 = ValueAnimator.ofFloat(arg4);
        v4.setInterpolator(this.animationFadeInterpolator);
        v4.setDuration(((long)arg3));
        v4.addUpdateListener(new DropdownMenuEndIconDelegate$$ExternalSyntheticLambda0(this));
        return v4;
    }

    int getIconContentDescriptionResId() {
        return string.exposed_dropdown_menu_content_description;
    }

    int getIconDrawableResId() {
        if(DropdownMenuEndIconDelegate.IS_LOLLIPOP) {
            return drawable.mtrl_dropdown_arrow;
        }

        return drawable.mtrl_ic_arrow_drop_down;
    }

    View$OnFocusChangeListener getOnEditTextFocusChangeListener() {
        return this.onEditTextFocusChangeListener;
    }

    View$OnClickListener getOnIconClickListener() {
        return this.onIconClickListener;
    }

    public TouchExplorationStateChangeListener getTouchExplorationStateChangeListener() {
        return this.touchExplorationStateChangeListener;
    }

    private void initAnimators() {
        this.fadeInAnim = this.getAlphaAnimator(this.animationFadeInDuration, new float[]{0f, 1f});
        ValueAnimator v0 = this.getAlphaAnimator(this.animationFadeOutDuration, new float[]{1f, 0f});
        this.fadeOutAnim = v0;
        v0.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator arg1) {
                DropdownMenuEndIconDelegate.this.refreshIconState();
                DropdownMenuEndIconDelegate.this.fadeInAnim.start();
            }
        });
    }

    boolean isBoxBackgroundModeSupported(int arg1) {
        if(arg1 != 0) {
            return 1;
        }

        return 0;
    }

    private boolean isDropdownPopupActive() {
        long v0 = System.currentTimeMillis() - this.dropdownPopupActivatedAt;
        if(v0 >= 0) {
            if(v0 > 300) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    boolean isIconActivable() {
        return 1;
    }

    boolean isIconActivated() {
        return this.editTextHasFocus;
    }

    boolean isIconCheckable() {
        return 1;
    }

    boolean isIconChecked() {
        return this.isEndIconChecked;
    }

    void lambda$afterEditTextChanged$3$com-google-android-material-textfield-DropdownMenuEndIconDelegate() {
        boolean v0 = this.autoCompleteTextView.isPopupShowing();
        this.setEndIconChecked(v0);
        this.dropdownPopupDirty = v0;
    }

    void lambda$getAlphaAnimator$6$com-google-android-material-textfield-DropdownMenuEndIconDelegate(ValueAnimator arg1) {
        this.endIconView.setAlpha(arg1.getAnimatedValue().floatValue());
    }

    void lambda$new$0$com-google-android-material-textfield-DropdownMenuEndIconDelegate(View arg1) {
        this.showHideDropdown();
    }

    void lambda$new$1$com-google-android-material-textfield-DropdownMenuEndIconDelegate(View arg1, boolean arg2) {
        this.editTextHasFocus = arg2;
        this.refreshIconState();
        if(!arg2) {
            this.setEndIconChecked(false);
            this.dropdownPopupDirty = false;
        }
    }

    void lambda$new$2$com-google-android-material-textfield-DropdownMenuEndIconDelegate(boolean arg2) {
        AutoCompleteTextView v0 = this.autoCompleteTextView;
        if(v0 != null && !EditTextUtils.isEditable(((EditText)v0))) {
            CheckableImageButton v1 = this.endIconView;
            int v2 = arg2 ? 2 : 1;
            ViewCompat.setImportantForAccessibility(((View)v1), v2);
        }
    }

    boolean lambda$setUpDropdownShowHideBehavior$4$com-google-android-material-textfield-DropdownMenuEndIconDelegate(View arg2, MotionEvent arg3) {
        if(arg3.getAction() == 1) {
            if(this.isDropdownPopupActive()) {
                this.dropdownPopupDirty = false;
            }

            this.showHideDropdown();
            this.updateDropdownPopupDirty();
        }

        return 0;
    }

    void lambda$setUpDropdownShowHideBehavior$5$com-google-android-material-textfield-DropdownMenuEndIconDelegate() {
        this.updateDropdownPopupDirty();
        this.setEndIconChecked(false);
    }

    public void onEditTextAttached(EditText arg3) {
        this.autoCompleteTextView = DropdownMenuEndIconDelegate.castAutoCompleteTextViewOrThrow(arg3);
        this.setUpDropdownShowHideBehavior();
        this.textInputLayout.setErrorIconDrawable(null);
        if(!EditTextUtils.isEditable(arg3) && (this.accessibilityManager.isTouchExplorationEnabled())) {
            ViewCompat.setImportantForAccessibility(this.endIconView, 2);
        }

        this.textInputLayout.setEndIconVisible(true);
    }

    public void onInitializeAccessibilityNodeInfo(View arg1, AccessibilityNodeInfoCompat arg2) {
        if(!EditTextUtils.isEditable(this.autoCompleteTextView)) {
            arg2.setClassName(Spinner.class.getName());
        }

        if(arg2.isShowingHintText()) {
            arg2.setHintText(null);
        }
    }

    public void onPopulateAccessibilityEvent(View arg3, AccessibilityEvent arg4) {
        if(this.accessibilityManager.isEnabled()) {
            if(EditTextUtils.isEditable(this.autoCompleteTextView)) {
            }
            else {
                int v3 = arg4.getEventType() != 0x8000 || !this.isEndIconChecked || (this.autoCompleteTextView.isPopupShowing()) ? 0 : 1;
                if(arg4.getEventType() != 1 && v3 == 0) {
                    return;
                }

                this.showHideDropdown();
                this.updateDropdownPopupDirty();
            }
        }
    }

    private void setEndIconChecked(boolean arg2) {
        if(this.isEndIconChecked != arg2) {
            this.isEndIconChecked = arg2;
            this.fadeInAnim.cancel();
            this.fadeOutAnim.start();
        }
    }

    void setUp() {
        this.initAnimators();
        this.accessibilityManager = this.context.getSystemService("accessibility");
    }

    private void setUpDropdownShowHideBehavior() {
        this.autoCompleteTextView.setOnTouchListener(new DropdownMenuEndIconDelegate$$ExternalSyntheticLambda1(this));
        if(DropdownMenuEndIconDelegate.IS_LOLLIPOP) {
            this.autoCompleteTextView.setOnDismissListener(new DropdownMenuEndIconDelegate$$ExternalSyntheticLambda2(this));
        }

        this.autoCompleteTextView.setThreshold(0);
    }

    boolean shouldTintIconOnError() {
        return 1;
    }

    private void showHideDropdown() {
        if(this.autoCompleteTextView == null) {
            return;
        }

        if(this.isDropdownPopupActive()) {
            this.dropdownPopupDirty = false;
        }

        if(!this.dropdownPopupDirty) {
            boolean v0 = DropdownMenuEndIconDelegate.IS_LOLLIPOP;
            boolean v1 = this.isEndIconChecked;
            if(v0) {
                this.setEndIconChecked((((int)v1)) ^ 1);
            }
            else {
                this.isEndIconChecked = (((int)v1)) ^ 1;
                this.refreshIconState();
            }

            v0 = this.isEndIconChecked;
            AutoCompleteTextView v1_1 = this.autoCompleteTextView;
            if(v0) {
                v1_1.requestFocus();
                this.autoCompleteTextView.showDropDown();
                return;
            }

            v1_1.dismissDropDown();
            return;
        }

        this.dropdownPopupDirty = false;
    }

    void tearDown() {
        AutoCompleteTextView v0 = this.autoCompleteTextView;
        if(v0 != null) {
            View$OnTouchListener v1 = null;
            v0.setOnTouchListener(v1);
            if(DropdownMenuEndIconDelegate.IS_LOLLIPOP) {
                this.autoCompleteTextView.setOnDismissListener(((AutoCompleteTextView$OnDismissListener)v1));
            }
        }
    }

    private void updateDropdownPopupDirty() {
        this.dropdownPopupDirty = true;
        this.dropdownPopupActivatedAt = System.currentTimeMillis();
    }
}

