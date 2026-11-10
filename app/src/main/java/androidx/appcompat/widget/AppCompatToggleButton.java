package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableCompoundDrawablesView;

public class AppCompatToggleButton extends ToggleButton implements EmojiCompatConfigurationView, TintableBackgroundView, TintableCompoundDrawablesView {
    private AppCompatEmojiTextHelper mAppCompatEmojiTextHelper;
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatTextHelper mTextHelper;

    public AppCompatToggleButton(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0x101004B);
    }

    public AppCompatToggleButton(Context arg2) {
        this(arg2, null);
    }

    public AppCompatToggleButton(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        ThemeUtils.checkAppCompatTheme(((View)this), this.getContext());
        AppCompatBackgroundHelper v1 = new AppCompatBackgroundHelper(((View)this));
        this.mBackgroundTintHelper = v1;
        v1.loadFromAttributes(arg2, arg3);
        AppCompatTextHelper v1_1 = new AppCompatTextHelper(((TextView)this));
        this.mTextHelper = v1_1;
        v1_1.loadFromAttributes(arg2, arg3);
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

    public void setAllCaps(boolean arg1) {
        super.setAllCaps(arg1);
        this.getEmojiTextViewHelper().setAllCaps(arg1);
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

    public void setCompoundDrawables(Drawable arg1, Drawable arg2, Drawable arg3, Drawable arg4) {
        super.setCompoundDrawables(arg1, arg2, arg3, arg4);
        AppCompatTextHelper v0 = this.mTextHelper;
        if(v0 != null) {
            v0.onSetCompoundDrawables();
        }
    }

    public void setCompoundDrawablesRelative(Drawable arg1, Drawable arg2, Drawable arg3, Drawable arg4) {
        super.setCompoundDrawablesRelative(arg1, arg2, arg3, arg4);
        AppCompatTextHelper v0 = this.mTextHelper;
        if(v0 != null) {
            v0.onSetCompoundDrawables();
        }
    }

    public void setEmojiCompatEnabled(boolean arg1) {
        this.getEmojiTextViewHelper().setEnabled(arg1);
    }

    public void setFilters(InputFilter[] arg2) {
        super.setFilters(this.getEmojiTextViewHelper().getFilters(arg2));
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
}

