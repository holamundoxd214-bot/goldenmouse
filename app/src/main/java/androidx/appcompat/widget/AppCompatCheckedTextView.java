package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode$Callback;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCheckedTextView;
import androidx.core.widget.TintableCompoundDrawablesView;

public class AppCompatCheckedTextView extends CheckedTextView implements EmojiCompatConfigurationView, TintableBackgroundView, TintableCheckedTextView, TintableCompoundDrawablesView {
    private AppCompatEmojiTextHelper mAppCompatEmojiTextHelper;
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatCheckedTextViewHelper mCheckedHelper;
    private final AppCompatTextHelper mTextHelper;

    public AppCompatCheckedTextView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.checkedTextViewStyle);
    }

    public AppCompatCheckedTextView(Context arg2) {
        this(arg2, null);
    }

    public AppCompatCheckedTextView(Context arg1, AttributeSet arg2, int arg3) {
        super(TintContextWrapper.wrap(arg1), arg2, arg3);
        ThemeUtils.checkAppCompatTheme(((View)this), this.getContext());
        AppCompatTextHelper v1 = new AppCompatTextHelper(((TextView)this));
        this.mTextHelper = v1;
        v1.loadFromAttributes(arg2, arg3);
        v1.applyCompoundDrawablesTints();
        AppCompatBackgroundHelper v1_1 = new AppCompatBackgroundHelper(((View)this));
        this.mBackgroundTintHelper = v1_1;
        v1_1.loadFromAttributes(arg2, arg3);
        AppCompatCheckedTextViewHelper v1_2 = new AppCompatCheckedTextViewHelper(((CheckedTextView)this));
        this.mCheckedHelper = v1_2;
        v1_2.loadFromAttributes(arg2, arg3);
        this.getEmojiTextViewHelper().loadFromAttributes(arg2, arg3);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatTextHelper v0 = this.mTextHelper;
        if(v0 != null) {
            v0.applyCompoundDrawablesTints();
        }

        AppCompatBackgroundHelper v0_1 = this.mBackgroundTintHelper;
        if(v0_1 != null) {
            v0_1.applySupportBackgroundTint();
        }

        AppCompatCheckedTextViewHelper v1 = this.mCheckedHelper;
        if(v1 != null) {
            v1.applyCheckMarkTint();
        }
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

    public ColorStateList getSupportCheckMarkTintList() {
        AppCompatCheckedTextViewHelper v0 = this.mCheckedHelper;
        if(v0 != null) {
            return v0.getSupportCheckMarkTintList();
        }

        return null;
    }

    public PorterDuff$Mode getSupportCheckMarkTintMode() {
        AppCompatCheckedTextViewHelper v0 = this.mCheckedHelper;
        if(v0 != null) {
            return v0.getSupportCheckMarkTintMode();
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

    public InputConnection onCreateInputConnection(EditorInfo arg2) {
        return AppCompatHintHelper.onCreateInputConnection(super.onCreateInputConnection(arg2), arg2, ((View)this));
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

    public void setCheckMarkDrawable(int arg2) {
        this.setCheckMarkDrawable(AppCompatResources.getDrawable(this.getContext(), arg2));
    }

    public void setCheckMarkDrawable(Drawable arg1) {
        super.setCheckMarkDrawable(arg1);
        AppCompatCheckedTextViewHelper v0 = this.mCheckedHelper;
        if(v0 != null) {
            v0.onSetCheckMarkDrawable();
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

    public void setCustomSelectionActionModeCallback(ActionMode$Callback arg1) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(((TextView)this), arg1));
    }

    public void setEmojiCompatEnabled(boolean arg1) {
        this.getEmojiTextViewHelper().setEnabled(arg1);
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

    public void setSupportCheckMarkTintList(ColorStateList arg1) {
        AppCompatCheckedTextViewHelper v0 = this.mCheckedHelper;
        if(v0 != null) {
            v0.setSupportCheckMarkTintList(arg1);
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff$Mode arg1) {
        AppCompatCheckedTextViewHelper v0 = this.mCheckedHelper;
        if(v0 != null) {
            v0.setSupportCheckMarkTintMode(arg1);
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
}

