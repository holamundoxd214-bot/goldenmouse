package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View$OnClickListener;
import android.view.View$OnLongClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout$LayoutParams;
import android.widget.ImageView$ScaleType;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;

class StartCompoundLayout extends LinearLayout {
    private boolean hintExpanded;
    private CharSequence prefixText;
    private final TextView prefixTextView;
    private int startIconMinSize;
    private View$OnLongClickListener startIconOnLongClickListener;
    private ImageView$ScaleType startIconScaleType;
    private ColorStateList startIconTintList;
    private PorterDuff$Mode startIconTintMode;
    private final CheckableImageButton startIconView;
    private final TextInputLayout textInputLayout;

    StartCompoundLayout(TextInputLayout arg5, TintTypedArray arg6) {
        super(arg5.getContext());
        this.textInputLayout = arg5;
        this.setVisibility(8);
        this.setOrientation(0);
        this.setLayoutParams(new FrameLayout$LayoutParams(-2, -1, 0x800003));
        View v5 = LayoutInflater.from(this.getContext()).inflate(layout.design_text_input_start_icon, ((ViewGroup)this), false);
        this.startIconView = ((CheckableImageButton)v5);
        IconHelper.setCompatRippleBackgroundIfNeeded(((CheckableImageButton)v5));
        AppCompatTextView v0 = new AppCompatTextView(this.getContext());
        this.prefixTextView = ((TextView)v0);
        this.initStartIconView(arg6);
        this.initPrefixTextView(arg6);
        this.addView(v5);
        this.addView(((View)v0));
    }

    CharSequence getPrefixText() {
        return this.prefixText;
    }

    ColorStateList getPrefixTextColor() {
        return this.prefixTextView.getTextColors();
    }

    int getPrefixTextStartOffset() {
        int v0 = this.isStartIconVisible() ? this.startIconView.getMeasuredWidth() + MarginLayoutParamsCompat.getMarginEnd(this.startIconView.getLayoutParams()) : 0;
        return ViewCompat.getPaddingStart(((View)this)) + ViewCompat.getPaddingStart(this.prefixTextView) + v0;
    }

    TextView getPrefixTextView() {
        return this.prefixTextView;
    }

    CharSequence getStartIconContentDescription() {
        return this.startIconView.getContentDescription();
    }

    Drawable getStartIconDrawable() {
        return this.startIconView.getDrawable();
    }

    int getStartIconMinSize() {
        return this.startIconMinSize;
    }

    ImageView$ScaleType getStartIconScaleType() {
        return this.startIconScaleType;
    }

    private void initPrefixTextView(TintTypedArray arg4) {
        this.prefixTextView.setVisibility(8);
        this.prefixTextView.setId(id.textinput_prefix_text);
        this.prefixTextView.setLayoutParams(new LinearLayout$LayoutParams(-2, -2));
        ViewCompat.setAccessibilityLiveRegion(this.prefixTextView, 1);
        this.setPrefixTextAppearance(arg4.getResourceId(styleable.TextInputLayout_prefixTextAppearance, 0));
        if(arg4.hasValue(styleable.TextInputLayout_prefixTextColor)) {
            this.setPrefixTextColor(arg4.getColorStateList(styleable.TextInputLayout_prefixTextColor));
        }

        this.setPrefixText(arg4.getText(styleable.TextInputLayout_prefixText));
    }

    private void initStartIconView(TintTypedArray arg5) {
        if(MaterialResources.isFontScaleAtLeast1_3(this.getContext())) {
            MarginLayoutParamsCompat.setMarginEnd(this.startIconView.getLayoutParams(), 0);
        }

        View$OnClickListener v0 = null;
        this.setStartIconOnClickListener(v0);
        this.setStartIconOnLongClickListener(((View$OnLongClickListener)v0));
        if(arg5.hasValue(styleable.TextInputLayout_startIconTint)) {
            this.startIconTintList = MaterialResources.getColorStateList(this.getContext(), arg5, styleable.TextInputLayout_startIconTint);
        }

        int v2 = -1;
        if(arg5.hasValue(styleable.TextInputLayout_startIconTintMode)) {
            this.startIconTintMode = ViewUtils.parseTintMode(arg5.getInt(styleable.TextInputLayout_startIconTintMode, v2), ((PorterDuff$Mode)v0));
        }

        if(arg5.hasValue(styleable.TextInputLayout_startIconDrawable)) {
            this.setStartIconDrawable(arg5.getDrawable(styleable.TextInputLayout_startIconDrawable));
            if(arg5.hasValue(styleable.TextInputLayout_startIconContentDescription)) {
                this.setStartIconContentDescription(arg5.getText(styleable.TextInputLayout_startIconContentDescription));
            }

            this.setStartIconCheckable(arg5.getBoolean(styleable.TextInputLayout_startIconCheckable, true));
        }

        this.setStartIconMinSize(arg5.getDimensionPixelSize(styleable.TextInputLayout_startIconMinSize, this.getResources().getDimensionPixelSize(dimen.mtrl_min_touch_target_size)));
        if(arg5.hasValue(styleable.TextInputLayout_startIconScaleType)) {
            this.setStartIconScaleType(IconHelper.convertScaleType(arg5.getInt(styleable.TextInputLayout_startIconScaleType, v2)));
        }
    }

    boolean isStartIconCheckable() {
        return this.startIconView.isCheckable();
    }

    boolean isStartIconVisible() {
        if(this.startIconView.getVisibility() == 0) {
            return 1;
        }

        return 0;
    }

    void onHintStateChanged(boolean arg1) {
        this.hintExpanded = arg1;
        this.updateVisibility();
    }

    protected void onMeasure(int arg1, int arg2) {
        super.onMeasure(arg1, arg2);
        this.updatePrefixTextViewPadding();
    }

    void refreshStartIconDrawableState() {
        IconHelper.refreshIconDrawableState(this.textInputLayout, this.startIconView, this.startIconTintList);
    }

    void setPrefixText(CharSequence arg2) {
        CharSequence v0 = TextUtils.isEmpty(arg2) ? null : arg2;
        this.prefixText = v0;
        this.prefixTextView.setText(arg2);
        this.updateVisibility();
    }

    void setPrefixTextAppearance(int arg1) {
        TextViewCompat.setTextAppearance(this.prefixTextView, arg1);
    }

    void setPrefixTextColor(ColorStateList arg1) {
        this.prefixTextView.setTextColor(arg1);
    }

    void setStartIconCheckable(boolean arg1) {
        this.startIconView.setCheckable(arg1);
    }

    void setStartIconContentDescription(CharSequence arg2) {
        if(this.getStartIconContentDescription() != arg2) {
            this.startIconView.setContentDescription(arg2);
        }
    }

    void setStartIconDrawable(Drawable arg4) {
        this.startIconView.setImageDrawable(arg4);
        if(arg4 != null) {
            IconHelper.applyIconTint(this.textInputLayout, this.startIconView, this.startIconTintList, this.startIconTintMode);
            this.setStartIconVisible(true);
            this.refreshStartIconDrawableState();
            return;
        }

        this.setStartIconVisible(false);
        this.setStartIconOnClickListener(null);
        this.setStartIconOnLongClickListener(null);
        this.setStartIconContentDescription(null);
    }

    void setStartIconMinSize(int arg2) {
        if(arg2 >= 0) {
            if(arg2 != this.startIconMinSize) {
                this.startIconMinSize = arg2;
                IconHelper.setIconMinSize(this.startIconView, arg2);
            }

            return;
        }

        throw new IllegalArgumentException("startIconSize cannot be less than 0");
    }

    void setStartIconOnClickListener(View$OnClickListener arg2) {
        IconHelper.setIconOnClickListener(this.startIconView, arg2, this.startIconOnLongClickListener);
    }

    void setStartIconOnLongClickListener(View$OnLongClickListener arg1) {
        this.startIconOnLongClickListener = arg1;
        IconHelper.setIconOnLongClickListener(this.startIconView, arg1);
    }

    void setStartIconScaleType(ImageView$ScaleType arg1) {
        this.startIconScaleType = arg1;
        IconHelper.setIconScaleType(this.startIconView, arg1);
    }

    void setStartIconTintList(ColorStateList arg3) {
        if(this.startIconTintList != arg3) {
            this.startIconTintList = arg3;
            IconHelper.applyIconTint(this.textInputLayout, this.startIconView, arg3, this.startIconTintMode);
        }
    }

    void setStartIconTintMode(PorterDuff$Mode arg3) {
        if(this.startIconTintMode != arg3) {
            this.startIconTintMode = arg3;
            IconHelper.applyIconTint(this.textInputLayout, this.startIconView, this.startIconTintList, arg3);
        }
    }

    void setStartIconVisible(boolean arg2) {
        if(this.isStartIconVisible() != arg2) {
            CheckableImageButton v0 = this.startIconView;
            int v2 = arg2 ? 0 : 8;
            v0.setVisibility(v2);
            this.updatePrefixTextViewPadding();
            this.updateVisibility();
        }
    }

    void setupAccessibilityNodeInfo(AccessibilityNodeInfoCompat arg2) {
        if(this.prefixTextView.getVisibility() == 0) {
            arg2.setLabelFor(this.prefixTextView);
            arg2.setTraversalAfter(this.prefixTextView);
            return;
        }

        arg2.setTraversalAfter(this.startIconView);
    }

    void updatePrefixTextViewPadding() {
        EditText v0 = this.textInputLayout.editText;
        if(v0 == null) {
            return;
        }

        int v1 = this.isStartIconVisible() ? 0 : ViewCompat.getPaddingStart(((View)v0));
        ViewCompat.setPaddingRelative(this.prefixTextView, v1, v0.getCompoundPaddingTop(), this.getContext().getResources().getDimensionPixelSize(dimen.material_input_text_to_prefix_suffix_padding), v0.getCompoundPaddingBottom());
    }

    private void updateVisibility() {
        int v1 = 0;
        int v2 = 8;
        int v0 = this.prefixText == null || (this.hintExpanded) ? v2 : 0;
        if(this.startIconView.getVisibility() != 0) {
            if(v0 == 0) {
            }
            else {
                v1 = v2;
            }
        }

        this.setVisibility(v1);
        this.prefixTextView.setVisibility(v0);
        this.textInputLayout.updateDummyDrawables();
    }
}

