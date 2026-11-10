package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode$Callback;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;

public class AppCompatButton extends Button implements EmojiCompatConfigurationView, TintableBackgroundView, AutoSizeableTextView, TintableCompoundDrawablesView {
    private AppCompatEmojiTextHelper mAppCompatEmojiTextHelper;
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatTextHelper mTextHelper;

    public AppCompatButton(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.buttonStyle);
    }

    public AppCompatButton(Context arg2) {
        this(arg2, null);
    }

    public AppCompatButton(Context arg1, AttributeSet arg2, int arg3) {
        super(TintContextWrapper.wrap(arg1), arg2, arg3);
        ThemeUtils.checkAppCompatTheme(((View)this), this.getContext());
        AppCompatBackgroundHelper v1 = new AppCompatBackgroundHelper(((View)this));
        this.mBackgroundTintHelper = v1;
        v1.loadFromAttributes(arg2, arg3);
        AppCompatTextHelper v1_1 = new AppCompatTextHelper(((TextView)this));
        this.mTextHelper = v1_1;
        v1_1.loadFromAttributes(arg2, arg3);
        v1_1.applyCompoundDrawablesTints();
        this.getEmojiTextViewHelper().loadFromAttributes(arg2, arg3);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper v0 = this.mBackgroundTintHelper;
        if(v0 != null) {
            v0.applySupportBackgroundTint();
        }

        AppCompatTextHelper v1 = this.mTextHelper;
        if(v1 != null) {
            v1.applyCompoundDrawablesTints();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if(ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeMaxTextSize();
        }

        AppCompatTextHelper v1 = this.mTextHelper;
        if(v1 != null) {
            return v1.getAutoSizeMaxTextSize();
        }

        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if(ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeMinTextSize();
        }

        AppCompatTextHelper v1 = this.mTextHelper;
        if(v1 != null) {
            return v1.getAutoSizeMinTextSize();
        }

        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if(ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeStepGranularity();
        }

        AppCompatTextHelper v1 = this.mTextHelper;
        if(v1 != null) {
            return v1.getAutoSizeStepGranularity();
        }

        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if(ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeTextAvailableSizes();
        }

        AppCompatTextHelper v1 = this.mTextHelper;
        if(v1 != null) {
            return v1.getAutoSizeTextAvailableSizes();
        }

        return new int[0];
    }

    public int getAutoSizeTextType() {
        if(ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            if(super.getAutoSizeTextType() == 1) {
                return 1;
            }

            return 0;
        }

        AppCompatTextHelper v2 = this.mTextHelper;
        if(v2 != null) {
            return v2.getAutoSizeTextType();
        }

        return 0;
    }

    public ActionMode$Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.unwrapCustomSelectionActionModeCallback(super.getCustomSelectionActionModeCallback());
    }

    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        AppCompatEmojiTextHelper v0 = this.mAppCompatEmojiTextHelper;
        if(v0 == null) {
            v0 = new AppCompatEmojiTextHelper(((TextView)this));
            this.mAppCompatEmojiTextHelper = v0;
        }

        return v0;
    }

    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper v0 = this.mBackgroundTintHelper;
        if(v0 != null) {
            return v0.getSupportBackgroundTintList();
        }

        return null;
    }

    public PorterDuff$Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper v0 = this.mBackgroundTintHelper;
        if(v0 != null) {
            return v0.getSupportBackgroundTintMode();
        }

        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.getCompoundDrawableTintList();
    }

    public PorterDuff$Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.getCompoundDrawableTintMode();
    }

    public boolean isEmojiCompatEnabled() {
        return this.getEmojiTextViewHelper().isEnabled();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent arg1) {
        super.onInitializeAccessibilityEvent(arg1);
        arg1.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo arg1) {
        super.onInitializeAccessibilityNodeInfo(arg1);
        arg1.setClassName(Button.class.getName());
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
        super.onLayout(arg1, arg2, arg3, arg4, arg5);
        AppCompatTextHelper v0 = this.mTextHelper;
        if(v0 != null) {
            v0.onLayout(arg1, arg2, arg3, arg4, arg5);
        }
    }

    protected void onTextChanged(CharSequence arg1, int arg2, int arg3, int arg4) {
        super.onTextChanged(arg1, arg2, arg3, arg4);
        if(this.mTextHelper != null && !ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE && (this.mTextHelper.isAutoSizeEnabled())) {
            this.mTextHelper.autoSizeText();
        }
    }

    public void setAllCaps(boolean arg1) {
        super.setAllCaps(arg1);
        this.getEmojiTextViewHelper().setAllCaps(arg1);
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int arg2, int arg3, int arg4, int arg5) throws IllegalArgumentException {
        if(ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            super.setAutoSizeTextTypeUniformWithConfiguration(arg2, arg3, arg4, arg5);
            return;
        }

        AppCompatTextHelper v1 = this.mTextHelper;
        if(v1 != null) {
            v1.setAutoSizeTextTypeUniformWithConfiguration(arg2, arg3, arg4, arg5);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] arg2, int arg3) throws IllegalArgumentException {
        if(ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(arg2, arg3);
            return;
        }

        AppCompatTextHelper v1 = this.mTextHelper;
        if(v1 != null) {
            v1.setAutoSizeTextTypeUniformWithPresetSizes(arg2, arg3);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int arg2) {
        if(ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            super.setAutoSizeTextTypeWithDefaults(arg2);
            return;
        }

        AppCompatTextHelper v1 = this.mTextHelper;
        if(v1 != null) {
            v1.setAutoSizeTextTypeWithDefaults(arg2);
        }
    }

    public void setBackgroundDrawable(Drawable arg1) {
        super.setBackgroundDrawable(arg1);
        AppCompatBackgroundHelper v0 = this.mBackgroundTintHelper;
        if(v0 != null) {
            v0.onSetBackgroundDrawable(arg1);
        }
    }

    public void setBackgroundResource(int arg1) {
        super.setBackgroundResource(arg1);
        AppCompatBackgroundHelper v0 = this.mBackgroundTintHelper;
        if(v0 != null) {
            v0.onSetBackgroundResource(arg1);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode$Callback arg1) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(((TextView)this), arg1));
    }

    public void setEmojiCompatEnabled(boolean arg1) {
        this.getEmojiTextViewHelper().setEnabled(arg1);
    }

    public void setFilters(InputFilter[] arg2) {
        super.setFilters(this.getEmojiTextViewHelper().getFilters(arg2));
    }

    public void setSupportAllCaps(boolean arg1) {
        AppCompatTextHelper v0 = this.mTextHelper;
        if(v0 != null) {
            v0.setAllCaps(arg1);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList arg1) {
        AppCompatBackgroundHelper v0 = this.mBackgroundTintHelper;
        if(v0 != null) {
            v0.setSupportBackgroundTintList(arg1);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff$Mode arg1) {
        AppCompatBackgroundHelper v0 = this.mBackgroundTintHelper;
        if(v0 != null) {
            v0.setSupportBackgroundTintMode(arg1);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList arg2) {
        this.mTextHelper.setCompoundDrawableTintList(arg2);
        this.mTextHelper.applyCompoundDrawablesTints();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff$Mode arg2) {
        this.mTextHelper.setCompoundDrawableTintMode(arg2);
        this.mTextHelper.applyCompoundDrawablesTints();
    }

    public void setTextAppearance(Context arg1, int arg2) {
        super.setTextAppearance(arg1, arg2);
        AppCompatTextHelper v0 = this.mTextHelper;
        if(v0 != null) {
            v0.onSetTextAppearance(arg1, arg2);
        }
    }

    public void setTextSize(int arg2, float arg3) {
        if(ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            super.setTextSize(arg2, arg3);
            return;
        }

        AppCompatTextHelper v1 = this.mTextHelper;
        if(v1 != null) {
            v1.setTextSize(arg2, arg3);
        }
    }
}

