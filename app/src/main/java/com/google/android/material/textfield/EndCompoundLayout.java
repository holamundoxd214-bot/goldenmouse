package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View$OnAttachStateChangeListener;
import android.view.View$OnClickListener;
import android.view.View$OnLongClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView$ScaleType;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat$TouchExplorationStateChangeListener;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import java.util.Iterator;
import java.util.LinkedHashSet;

class EndCompoundLayout extends LinearLayout {
    class com.google.android.material.textfield.EndCompoundLayout$1 extends TextWatcherAdapter {
        com.google.android.material.textfield.EndCompoundLayout$1(EndCompoundLayout arg1) {
            EndCompoundLayout.this = arg1;
            super();
        }

        public void afterTextChanged(Editable arg1) {
            EndCompoundLayout.this.getEndIconDelegate().afterEditTextChanged(arg1);
        }

        public void beforeTextChanged(CharSequence arg1, int arg2, int arg3, int arg4) {
            EndCompoundLayout.this.getEndIconDelegate().beforeEditTextChanged(arg1, arg2, arg3, arg4);
        }
    }

    class com.google.android.material.textfield.EndCompoundLayout$2 implements OnEditTextAttachedListener {
        com.google.android.material.textfield.EndCompoundLayout$2(EndCompoundLayout arg1) {
            EndCompoundLayout.this = arg1;
            super();
        }

        public void onEditTextAttached(TextInputLayout arg3) {
            if(EndCompoundLayout.this.editText == arg3.getEditText()) {
                return;
            }

            if(EndCompoundLayout.this.editText != null) {
                EndCompoundLayout.this.editText.removeTextChangedListener(EndCompoundLayout.this.editTextWatcher);
                if(EndCompoundLayout.this.editText.getOnFocusChangeListener() == EndCompoundLayout.this.getEndIconDelegate().getOnEditTextFocusChangeListener()) {
                    EndCompoundLayout.this.editText.setOnFocusChangeListener(null);
                }
            }

            EndCompoundLayout.this.editText = arg3.getEditText();
            if(EndCompoundLayout.this.editText != null) {
                EndCompoundLayout.this.editText.addTextChangedListener(EndCompoundLayout.this.editTextWatcher);
            }

            EndCompoundLayout.this.getEndIconDelegate().onEditTextAttached(EndCompoundLayout.this.editText);
            EndCompoundLayout.this.setOnFocusChangeListenersIfNeeded(EndCompoundLayout.this.getEndIconDelegate());
        }
    }

    class EndIconDelegates {
        private final int customEndIconDrawableId;
        private final SparseArray delegates;
        private final EndCompoundLayout endLayout;
        private final int passwordIconDrawableId;

        EndIconDelegates(EndCompoundLayout arg2, TintTypedArray arg3) {
            super();
            this.delegates = new SparseArray();
            this.endLayout = arg2;
            this.customEndIconDrawableId = arg3.getResourceId(styleable.TextInputLayout_endIconDrawable, 0);
            this.passwordIconDrawableId = arg3.getResourceId(styleable.TextInputLayout_passwordToggleDrawable, 0);
        }

        static int access$500(EndIconDelegates arg0) {
            return arg0.customEndIconDrawableId;
        }

        private EndIconDelegate create(int arg3) {
            if(arg3 != -1) {
                if(arg3 != 0) {
                    if(arg3 != 1) {
                        if(arg3 != 2) {
                            if(arg3 == 3) {
                                return new DropdownMenuEndIconDelegate(this.endLayout);
                            }

                            throw new IllegalArgumentException("Invalid end icon mode: " + arg3);
                        }

                        return new ClearTextEndIconDelegate(this.endLayout);
                    }

                    return new PasswordToggleEndIconDelegate(this.endLayout, this.passwordIconDrawableId);
                }

                return new NoEndIconDelegate(this.endLayout);
            }

            return new CustomEndIconDelegate(this.endLayout);
        }

        EndIconDelegate get(int arg2) {
            Object v0 = this.delegates.get(arg2);
            if(v0 == null) {
                EndIconDelegate v0_1 = this.create(arg2);
                this.delegates.append(arg2, v0_1);
            }

            return ((EndIconDelegate)v0);
        }
    }

    private final AccessibilityManager accessibilityManager;
    private EditText editText;
    private final TextWatcher editTextWatcher;
    private final LinkedHashSet endIconChangedListeners;
    private final EndIconDelegates endIconDelegates;
    private final FrameLayout endIconFrame;
    private int endIconMinSize;
    private int endIconMode;
    private View$OnLongClickListener endIconOnLongClickListener;
    private ImageView$ScaleType endIconScaleType;
    private ColorStateList endIconTintList;
    private PorterDuff$Mode endIconTintMode;
    private final CheckableImageButton endIconView;
    private View$OnLongClickListener errorIconOnLongClickListener;
    private ColorStateList errorIconTintList;
    private PorterDuff$Mode errorIconTintMode;
    private final CheckableImageButton errorIconView;
    private boolean hintExpanded;
    private final OnEditTextAttachedListener onEditTextAttachedListener;
    private CharSequence suffixText;
    private final TextView suffixTextView;
    final TextInputLayout textInputLayout;
    private TouchExplorationStateChangeListener touchExplorationStateChangeListener;

    EndCompoundLayout(TextInputLayout arg7, TintTypedArray arg8) {
        super(arg7.getContext());
        this.endIconMode = 0;
        this.endIconChangedListeners = new LinkedHashSet();
        this.editTextWatcher = new com.google.android.material.textfield.EndCompoundLayout$1(this);
        com.google.android.material.textfield.EndCompoundLayout$2 v1 = new com.google.android.material.textfield.EndCompoundLayout$2(this);
        this.onEditTextAttachedListener = ((OnEditTextAttachedListener)v1);
        this.accessibilityManager = this.getContext().getSystemService("accessibility");
        this.textInputLayout = arg7;
        this.setVisibility(8);
        this.setOrientation(0);
        this.setLayoutParams(new FrameLayout$LayoutParams(-2, -1, 0x800005));
        FrameLayout v0 = new FrameLayout(this.getContext());
        this.endIconFrame = v0;
        v0.setVisibility(8);
        v0.setLayoutParams(new LinearLayout$LayoutParams(-2, -1));
        LayoutInflater v2 = LayoutInflater.from(this.getContext());
        CheckableImageButton v3 = this.createIconView(((ViewGroup)this), v2, id.text_input_error_icon);
        this.errorIconView = v3;
        CheckableImageButton v2_1 = this.createIconView(((ViewGroup)v0), v2, id.text_input_end_icon);
        this.endIconView = v2_1;
        this.endIconDelegates = new EndIconDelegates(this, arg8);
        AppCompatTextView v4 = new AppCompatTextView(this.getContext());
        this.suffixTextView = ((TextView)v4);
        this.initErrorIconView(arg8);
        this.initEndIconView(arg8);
        this.initSuffixTextView(arg8);
        v0.addView(((View)v2_1));
        this.addView(((View)v4));
        this.addView(((View)v0));
        this.addView(((View)v3));
        arg7.addOnEditTextAttachedListener(((OnEditTextAttachedListener)v1));
        this.addOnAttachStateChangeListener(new View$OnAttachStateChangeListener() {
            public void onViewAttachedToWindow(View arg1) {
                EndCompoundLayout.access$300(EndCompoundLayout.this);
            }

            public void onViewDetachedFromWindow(View arg1) {
                EndCompoundLayout.access$400(EndCompoundLayout.this);
            }
        });
    }

    static EditText access$000(EndCompoundLayout arg0) {
        return arg0.editText;
    }

    static EditText access$002(EndCompoundLayout arg0, EditText arg1) {
        arg0.editText = arg1;
        return arg1;
    }

    static TextWatcher access$100(EndCompoundLayout arg0) {
        return arg0.editTextWatcher;
    }

    static void access$200(EndCompoundLayout arg0, EndIconDelegate arg1) {
        arg0.setOnFocusChangeListenersIfNeeded(arg1);
    }

    static void access$300(EndCompoundLayout arg0) {
        arg0.addTouchExplorationStateChangeListenerIfNeeded();
    }

    static void access$400(EndCompoundLayout arg0) {
        arg0.removeTouchExplorationStateChangeListenerIfNeeded();
    }

    void addOnEndIconChangedListener(OnEndIconChangedListener arg1) {
        this.endIconChangedListeners.add(arg1);
    }

    private void addTouchExplorationStateChangeListenerIfNeeded() {
        if(this.touchExplorationStateChangeListener != null && this.accessibilityManager != null && (ViewCompat.isAttachedToWindow(((View)this)))) {
            AccessibilityManagerCompat.addTouchExplorationStateChangeListener(this.accessibilityManager, this.touchExplorationStateChangeListener);
        }
    }

    void checkEndIcon() {
        this.endIconView.performClick();
        this.endIconView.jumpDrawablesToCurrentState();
    }

    void clearOnEndIconChangedListeners() {
        this.endIconChangedListeners.clear();
    }

    private CheckableImageButton createIconView(ViewGroup arg3, LayoutInflater arg4, int arg5) {
        View v3 = arg4.inflate(layout.design_text_input_end_icon, arg3, false);
        ((CheckableImageButton)v3).setId(arg5);
        IconHelper.setCompatRippleBackgroundIfNeeded(((CheckableImageButton)v3));
        if(MaterialResources.isFontScaleAtLeast1_3(this.getContext())) {
            MarginLayoutParamsCompat.setMarginStart(((CheckableImageButton)v3).getLayoutParams(), 0);
        }

        return ((CheckableImageButton)v3);
    }

    private void dispatchOnEndIconChanged(int arg4) {
        Iterator v0 = this.endIconChangedListeners.iterator();
        while(v0.hasNext()) {
            v0.next().onEndIconChanged(this.textInputLayout, arg4);
        }
    }

    CheckableImageButton getCurrentEndIconView() {
        if(this.isErrorIconVisible()) {
            return this.errorIconView;
        }

        if((this.hasEndIcon()) && (this.isEndIconVisible())) {
            return this.endIconView;
        }

        return null;
    }

    CharSequence getEndIconContentDescription() {
        return this.endIconView.getContentDescription();
    }

    EndIconDelegate getEndIconDelegate() {
        return this.endIconDelegates.get(this.endIconMode);
    }

    Drawable getEndIconDrawable() {
        return this.endIconView.getDrawable();
    }

    int getEndIconMinSize() {
        return this.endIconMinSize;
    }

    int getEndIconMode() {
        return this.endIconMode;
    }

    ImageView$ScaleType getEndIconScaleType() {
        return this.endIconScaleType;
    }

    CheckableImageButton getEndIconView() {
        return this.endIconView;
    }

    Drawable getErrorIconDrawable() {
        return this.errorIconView.getDrawable();
    }

    private int getIconResId(EndIconDelegate arg1) {
        int v0 = EndIconDelegates.access$500(this.endIconDelegates);
        if(v0 == 0) {
            v0 = arg1.getIconDrawableResId();
        }

        return v0;
    }

    CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.endIconView.getContentDescription();
    }

    Drawable getPasswordVisibilityToggleDrawable() {
        return this.endIconView.getDrawable();
    }

    CharSequence getSuffixText() {
        return this.suffixText;
    }

    ColorStateList getSuffixTextColor() {
        return this.suffixTextView.getTextColors();
    }

    int getSuffixTextEndOffset() {
        int v0 = (this.isEndIconVisible()) || (this.isErrorIconVisible()) ? this.endIconView.getMeasuredWidth() + MarginLayoutParamsCompat.getMarginStart(this.endIconView.getLayoutParams()) : 0;
        return ViewCompat.getPaddingEnd(((View)this)) + ViewCompat.getPaddingEnd(this.suffixTextView) + v0;
    }

    TextView getSuffixTextView() {
        return this.suffixTextView;
    }

    boolean hasEndIcon() {
        if(this.endIconMode != 0) {
            return 1;
        }

        return 0;
    }

    private void initEndIconView(TintTypedArray arg6) {
        PorterDuff$Mode v1 = null;
        int v2 = -1;
        if(!arg6.hasValue(styleable.TextInputLayout_passwordToggleEnabled)) {
            if(arg6.hasValue(styleable.TextInputLayout_endIconTint)) {
                this.endIconTintList = MaterialResources.getColorStateList(this.getContext(), arg6, styleable.TextInputLayout_endIconTint);
            }

            if(!arg6.hasValue(styleable.TextInputLayout_endIconTintMode)) {
                goto label_19;
            }

            this.endIconTintMode = ViewUtils.parseTintMode(arg6.getInt(styleable.TextInputLayout_endIconTintMode, v2), v1);
        }

    label_19:
        if(arg6.hasValue(styleable.TextInputLayout_endIconMode)) {
            this.setEndIconMode(arg6.getInt(styleable.TextInputLayout_endIconMode, 0));
            if(arg6.hasValue(styleable.TextInputLayout_endIconContentDescription)) {
                this.setEndIconContentDescription(arg6.getText(styleable.TextInputLayout_endIconContentDescription));
            }

            this.setEndIconCheckable(arg6.getBoolean(styleable.TextInputLayout_endIconCheckable, true));
        }
        else {
            if(!arg6.hasValue(styleable.TextInputLayout_passwordToggleEnabled)) {
                goto label_60;
            }

            if(arg6.hasValue(styleable.TextInputLayout_passwordToggleTint)) {
                this.endIconTintList = MaterialResources.getColorStateList(this.getContext(), arg6, styleable.TextInputLayout_passwordToggleTint);
            }

            if(arg6.hasValue(styleable.TextInputLayout_passwordToggleTintMode)) {
                this.endIconTintMode = ViewUtils.parseTintMode(arg6.getInt(styleable.TextInputLayout_passwordToggleTintMode, v2), v1);
            }

            this.setEndIconMode(arg6.getBoolean(styleable.TextInputLayout_passwordToggleEnabled, false));
            this.setEndIconContentDescription(arg6.getText(styleable.TextInputLayout_passwordToggleContentDescription));
        }

    label_60:
        this.setEndIconMinSize(arg6.getDimensionPixelSize(styleable.TextInputLayout_endIconMinSize, this.getResources().getDimensionPixelSize(dimen.mtrl_min_touch_target_size)));
        if(arg6.hasValue(styleable.TextInputLayout_endIconScaleType)) {
            this.setEndIconScaleType(IconHelper.convertScaleType(arg6.getInt(styleable.TextInputLayout_endIconScaleType, v2)));
        }
    }

    private void initErrorIconView(TintTypedArray arg3) {
        if(arg3.hasValue(styleable.TextInputLayout_errorIconTint)) {
            this.errorIconTintList = MaterialResources.getColorStateList(this.getContext(), arg3, styleable.TextInputLayout_errorIconTint);
        }

        if(arg3.hasValue(styleable.TextInputLayout_errorIconTintMode)) {
            this.errorIconTintMode = ViewUtils.parseTintMode(arg3.getInt(styleable.TextInputLayout_errorIconTintMode, -1), null);
        }

        if(arg3.hasValue(styleable.TextInputLayout_errorIconDrawable)) {
            this.setErrorIconDrawable(arg3.getDrawable(styleable.TextInputLayout_errorIconDrawable));
        }

        this.errorIconView.setContentDescription(this.getResources().getText(string.error_icon_content_description));
        ViewCompat.setImportantForAccessibility(this.errorIconView, 2);
        this.errorIconView.setClickable(false);
        this.errorIconView.setPressable(false);
        this.errorIconView.setFocusable(false);
    }

    private void initSuffixTextView(TintTypedArray arg5) {
        this.suffixTextView.setVisibility(8);
        this.suffixTextView.setId(id.textinput_suffix_text);
        this.suffixTextView.setLayoutParams(new LinearLayout$LayoutParams(-2, -2, 80f));
        ViewCompat.setAccessibilityLiveRegion(this.suffixTextView, 1);
        this.setSuffixTextAppearance(arg5.getResourceId(styleable.TextInputLayout_suffixTextAppearance, 0));
        if(arg5.hasValue(styleable.TextInputLayout_suffixTextColor)) {
            this.setSuffixTextColor(arg5.getColorStateList(styleable.TextInputLayout_suffixTextColor));
        }

        this.setSuffixText(arg5.getText(styleable.TextInputLayout_suffixText));
    }

    boolean isEndIconCheckable() {
        return this.endIconView.isCheckable();
    }

    boolean isEndIconChecked() {
        if((this.hasEndIcon()) && (this.endIconView.isChecked())) {
            return 1;
        }

        return 0;
    }

    boolean isEndIconVisible() {
        if(this.endIconFrame.getVisibility() == 0 && this.endIconView.getVisibility() == 0) {
            return 1;
        }

        return 0;
    }

    boolean isErrorIconVisible() {
        if(this.errorIconView.getVisibility() == 0) {
            return 1;
        }

        return 0;
    }

    boolean isPasswordVisibilityToggleEnabled() {
        if(this.endIconMode == 1) {
            return 1;
        }

        return 0;
    }

    void onHintStateChanged(boolean arg1) {
        this.hintExpanded = arg1;
        this.updateSuffixTextVisibility();
    }

    void onTextInputBoxStateUpdated() {
        this.updateErrorIconVisibility();
        this.refreshErrorIconDrawableState();
        this.refreshEndIconDrawableState();
        if(this.getEndIconDelegate().shouldTintIconOnError()) {
            this.tintEndIconOnError(this.textInputLayout.shouldShowError());
        }
    }

    void refreshEndIconDrawableState() {
        IconHelper.refreshIconDrawableState(this.textInputLayout, this.endIconView, this.endIconTintList);
    }

    void refreshErrorIconDrawableState() {
        IconHelper.refreshIconDrawableState(this.textInputLayout, this.errorIconView, this.errorIconTintList);
    }

    void refreshIconState(boolean arg5) {
        int v1_1;
        EndIconDelegate v0 = this.getEndIconDelegate();
        int v2 = 1;
        if(v0.isIconCheckable()) {
            boolean v1 = this.endIconView.isChecked();
            if(v1 != v0.isIconChecked()) {
                this.endIconView.setChecked((((int)v1)) ^ 1);
                v1_1 = 1;
            }
            else {
                goto label_13;
            }
        }
        else {
        label_13:
            v1_1 = 0;
        }

        if(v0.isIconActivable()) {
            boolean v3 = this.endIconView.isActivated();
            if(v3 != v0.isIconActivated()) {
                this.setEndIconActivated((((int)v3)) ^ 1);
            }
            else {
                goto label_23;
            }
        }
        else {
        label_23:
            v2 = v1_1;
        }

        if(!arg5) {
            if(v2 != 0) {
            }
            else {
                return;
            }
        }

        this.refreshEndIconDrawableState();
    }

    void removeOnEndIconChangedListener(OnEndIconChangedListener arg1) {
        this.endIconChangedListeners.remove(arg1);
    }

    private void removeTouchExplorationStateChangeListenerIfNeeded() {
        TouchExplorationStateChangeListener v0 = this.touchExplorationStateChangeListener;
        if(v0 != null) {
            AccessibilityManager v1 = this.accessibilityManager;
            if(v1 != null) {
                AccessibilityManagerCompat.removeTouchExplorationStateChangeListener(v1, v0);
            }
        }
    }

    void setEndIconActivated(boolean arg1) {
        this.endIconView.setActivated(arg1);
    }

    void setEndIconCheckable(boolean arg1) {
        this.endIconView.setCheckable(arg1);
    }

    void setEndIconContentDescription(CharSequence arg2) {
        if(this.getEndIconContentDescription() != arg2) {
            this.endIconView.setContentDescription(arg2);
        }
    }

    void setEndIconContentDescription(int arg2) {
        CharSequence v2 = arg2 != 0 ? this.getResources().getText(arg2) : null;
        this.setEndIconContentDescription(v2);
    }

    void setEndIconDrawable(int arg2) {
        Drawable v2 = arg2 != 0 ? AppCompatResources.getDrawable(this.getContext(), arg2) : null;
        this.setEndIconDrawable(v2);
    }

    void setEndIconDrawable(Drawable arg4) {
        this.endIconView.setImageDrawable(arg4);
        if(arg4 != null) {
            IconHelper.applyIconTint(this.textInputLayout, this.endIconView, this.endIconTintList, this.endIconTintMode);
            this.refreshEndIconDrawableState();
        }
    }

    void setEndIconMinSize(int arg2) {
        if(arg2 >= 0) {
            if(arg2 != this.endIconMinSize) {
                this.endIconMinSize = arg2;
                IconHelper.setIconMinSize(this.endIconView, arg2);
                IconHelper.setIconMinSize(this.errorIconView, arg2);
            }

            return;
        }

        throw new IllegalArgumentException("endIconSize cannot be less than 0");
    }

    void setEndIconMode(int arg5) {
        if(this.endIconMode == arg5) {
            return;
        }

        this.tearDownDelegate(this.getEndIconDelegate());
        int v0 = this.endIconMode;
        this.endIconMode = arg5;
        this.dispatchOnEndIconChanged(v0);
        boolean v1 = arg5 != 0 ? true : false;
        this.setEndIconVisible(v1);
        EndIconDelegate v1_1 = this.getEndIconDelegate();
        this.setEndIconDrawable(this.getIconResId(v1_1));
        this.setEndIconContentDescription(v1_1.getIconContentDescriptionResId());
        this.setEndIconCheckable(v1_1.isIconCheckable());
        if(v1_1.isBoxBackgroundModeSupported(this.textInputLayout.getBoxBackgroundMode())) {
            this.setUpDelegate(v1_1);
            this.setEndIconOnClickListener(v1_1.getOnIconClickListener());
            EditText v5 = this.editText;
            if(v5 != null) {
                v1_1.onEditTextAttached(v5);
                this.setOnFocusChangeListenersIfNeeded(v1_1);
            }

            IconHelper.applyIconTint(this.textInputLayout, this.endIconView, this.endIconTintList, this.endIconTintMode);
            this.refreshIconState(true);
            return;
        }

        throw new IllegalStateException("The current box background mode " + this.textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + arg5);
    }

    void setEndIconOnClickListener(View$OnClickListener arg2) {
        IconHelper.setIconOnClickListener(this.endIconView, arg2, this.endIconOnLongClickListener);
    }

    void setEndIconOnLongClickListener(View$OnLongClickListener arg1) {
        this.endIconOnLongClickListener = arg1;
        IconHelper.setIconOnLongClickListener(this.endIconView, arg1);
    }

    void setEndIconScaleType(ImageView$ScaleType arg2) {
        this.endIconScaleType = arg2;
        IconHelper.setIconScaleType(this.endIconView, arg2);
        IconHelper.setIconScaleType(this.errorIconView, arg2);
    }

    void setEndIconTintList(ColorStateList arg3) {
        if(this.endIconTintList != arg3) {
            this.endIconTintList = arg3;
            IconHelper.applyIconTint(this.textInputLayout, this.endIconView, arg3, this.endIconTintMode);
        }
    }

    void setEndIconTintMode(PorterDuff$Mode arg3) {
        if(this.endIconTintMode != arg3) {
            this.endIconTintMode = arg3;
            IconHelper.applyIconTint(this.textInputLayout, this.endIconView, this.endIconTintList, arg3);
        }
    }

    void setEndIconVisible(boolean arg2) {
        if(this.isEndIconVisible() != arg2) {
            CheckableImageButton v0 = this.endIconView;
            int v2 = arg2 ? 0 : 8;
            v0.setVisibility(v2);
            this.updateEndLayoutVisibility();
            this.updateSuffixTextViewPadding();
            this.textInputLayout.updateDummyDrawables();
        }
    }

    void setErrorIconDrawable(Drawable arg3) {
        this.errorIconView.setImageDrawable(arg3);
        this.updateErrorIconVisibility();
        IconHelper.applyIconTint(this.textInputLayout, this.errorIconView, this.errorIconTintList, this.errorIconTintMode);
    }

    void setErrorIconDrawable(int arg2) {
        Drawable v2 = arg2 != 0 ? AppCompatResources.getDrawable(this.getContext(), arg2) : null;
        this.setErrorIconDrawable(v2);
        this.refreshErrorIconDrawableState();
    }

    void setErrorIconOnClickListener(View$OnClickListener arg2) {
        IconHelper.setIconOnClickListener(this.errorIconView, arg2, this.errorIconOnLongClickListener);
    }

    void setErrorIconOnLongClickListener(View$OnLongClickListener arg1) {
        this.errorIconOnLongClickListener = arg1;
        IconHelper.setIconOnLongClickListener(this.errorIconView, arg1);
    }

    void setErrorIconTintList(ColorStateList arg3) {
        if(this.errorIconTintList != arg3) {
            this.errorIconTintList = arg3;
            IconHelper.applyIconTint(this.textInputLayout, this.errorIconView, arg3, this.errorIconTintMode);
        }
    }

    void setErrorIconTintMode(PorterDuff$Mode arg3) {
        if(this.errorIconTintMode != arg3) {
            this.errorIconTintMode = arg3;
            IconHelper.applyIconTint(this.textInputLayout, this.errorIconView, this.errorIconTintList, arg3);
        }
    }

    private void setOnFocusChangeListenersIfNeeded(EndIconDelegate arg3) {
        if(this.editText == null) {
        }
        else {
            if(arg3.getOnEditTextFocusChangeListener() != null) {
                this.editText.setOnFocusChangeListener(arg3.getOnEditTextFocusChangeListener());
            }

            if(arg3.getOnIconViewFocusChangeListener() == null) {
                return;
            }

            this.endIconView.setOnFocusChangeListener(arg3.getOnIconViewFocusChangeListener());
        }
    }

    void setPasswordVisibilityToggleContentDescription(int arg2) {
        CharSequence v2 = arg2 != 0 ? this.getResources().getText(arg2) : null;
        this.setPasswordVisibilityToggleContentDescription(v2);
    }

    void setPasswordVisibilityToggleContentDescription(CharSequence arg1) {
        this.endIconView.setContentDescription(arg1);
    }

    void setPasswordVisibilityToggleDrawable(int arg2) {
        Drawable v2 = arg2 != 0 ? AppCompatResources.getDrawable(this.getContext(), arg2) : null;
        this.setPasswordVisibilityToggleDrawable(v2);
    }

    void setPasswordVisibilityToggleDrawable(Drawable arg1) {
        this.endIconView.setImageDrawable(arg1);
    }

    void setPasswordVisibilityToggleEnabled(boolean arg3) {
        if((arg3) && this.endIconMode != 1) {
            this.setEndIconMode(1);
            return;
        }

        if(!arg3) {
            this.setEndIconMode(0);
        }
    }

    void setPasswordVisibilityToggleTintList(ColorStateList arg3) {
        this.endIconTintList = arg3;
        IconHelper.applyIconTint(this.textInputLayout, this.endIconView, arg3, this.endIconTintMode);
    }

    void setPasswordVisibilityToggleTintMode(PorterDuff$Mode arg3) {
        this.endIconTintMode = arg3;
        IconHelper.applyIconTint(this.textInputLayout, this.endIconView, this.endIconTintList, arg3);
    }

    void setSuffixText(CharSequence arg2) {
        CharSequence v0 = TextUtils.isEmpty(arg2) ? null : arg2;
        this.suffixText = v0;
        this.suffixTextView.setText(arg2);
        this.updateSuffixTextVisibility();
    }

    void setSuffixTextAppearance(int arg1) {
        TextViewCompat.setTextAppearance(this.suffixTextView, arg1);
    }

    void setSuffixTextColor(ColorStateList arg1) {
        this.suffixTextView.setTextColor(arg1);
    }

    private void setUpDelegate(EndIconDelegate arg1) {
        arg1.setUp();
        this.touchExplorationStateChangeListener = arg1.getTouchExplorationStateChangeListener();
        this.addTouchExplorationStateChangeListenerIfNeeded();
    }

    private void tearDownDelegate(EndIconDelegate arg2) {
        this.removeTouchExplorationStateChangeListenerIfNeeded();
        this.touchExplorationStateChangeListener = null;
        arg2.tearDown();
    }

    private void tintEndIconOnError(boolean arg3) {
        if((arg3) && this.getEndIconDrawable() != null) {
            Drawable v3 = DrawableCompat.wrap(this.getEndIconDrawable()).mutate();
            DrawableCompat.setTint(v3, this.textInputLayout.getErrorCurrentTextColors());
            this.endIconView.setImageDrawable(v3);
            return;
        }

        IconHelper.applyIconTint(this.textInputLayout, this.endIconView, this.endIconTintList, this.endIconTintMode);
    }

    void togglePasswordVisibilityToggle(boolean arg3) {
        if(this.endIconMode == 1) {
            this.endIconView.performClick();
            if(arg3) {
                this.endIconView.jumpDrawablesToCurrentState();
            }
        }
    }

    private void updateEndLayoutVisibility() {
        FrameLayout v0 = this.endIconFrame;
        int v2 = 0;
        int v3 = 8;
        int v1 = this.endIconView.getVisibility() != 0 || (this.isErrorIconVisible()) ? v3 : 0;
        v0.setVisibility(v1);
        int v0_1 = this.suffixText == null || (this.hintExpanded) ? v3 : 0;
        if(!this.isEndIconVisible() && !this.isErrorIconVisible()) {
            if(v0_1 == 0) {
            }
            else {
                v2 = v3;
            }
        }

        this.setVisibility(v2);
    }

    private void updateErrorIconVisibility() {
        int v1 = 0;
        int v0 = this.getErrorIconDrawable() == null || !this.textInputLayout.isErrorEnabled() || !this.textInputLayout.shouldShowError() ? 0 : 1;
        CheckableImageButton v2 = this.errorIconView;
        if(v0 != 0) {
        }
        else {
            v1 = 8;
        }

        v2.setVisibility(v1);
        this.updateEndLayoutVisibility();
        this.updateSuffixTextViewPadding();
        if(!this.hasEndIcon()) {
            this.textInputLayout.updateDummyDrawables();
        }
    }

    void updateSuffixTextViewPadding() {
        if(this.textInputLayout.editText == null) {
            return;
        }

        int v0 = (this.isEndIconVisible()) || (this.isErrorIconVisible()) ? 0 : ViewCompat.getPaddingEnd(this.textInputLayout.editText);
        ViewCompat.setPaddingRelative(this.suffixTextView, this.getContext().getResources().getDimensionPixelSize(dimen.material_input_text_to_prefix_suffix_padding), this.textInputLayout.editText.getPaddingTop(), v0, this.textInputLayout.editText.getPaddingBottom());
    }

    private void updateSuffixTextVisibility() {
        int v0 = this.suffixTextView.getVisibility();
        boolean v2 = false;
        int v1 = this.suffixText == null || (this.hintExpanded) ? 8 : 0;
        if(v0 != v1) {
            EndIconDelegate v0_1 = this.getEndIconDelegate();
            if(v1 == 0) {
                v2 = true;
            }

            v0_1.onSuffixVisibilityChanged(v2);
        }

        this.updateEndLayoutVisibility();
        this.suffixTextView.setVisibility(v1);
        this.textInputLayout.updateDummyDrawables();
    }
}

