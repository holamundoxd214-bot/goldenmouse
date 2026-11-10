package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode$Callback;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;

public class AppCompatAutoCompleteTextView extends AutoCompleteTextView implements EmojiCompatConfigurationView, TintableBackgroundView, TintableCompoundDrawablesView {
    private static final int[] TINT_ATTRS;
    private final AppCompatEmojiEditTextHelper mAppCompatEmojiEditTextHelper;
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatTextHelper mTextHelper;

    static {
        AppCompatAutoCompleteTextView.TINT_ATTRS = new int[]{0x1010176};
    }

    public AppCompatAutoCompleteTextView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.autoCompleteTextViewStyle);
    }

    public AppCompatAutoCompleteTextView(Context arg2) {
        this(arg2, null);
    }

    public AppCompatAutoCompleteTextView(Context arg3, AttributeSet arg4, int arg5) {
        super(TintContextWrapper.wrap(arg3), arg4, arg5);
        ThemeUtils.checkAppCompatTheme(((View)this), this.getContext());
        TintTypedArray v3 = TintTypedArray.obtainStyledAttributes(this.getContext(), arg4, AppCompatAutoCompleteTextView.TINT_ATTRS, arg5, 0);
        if(v3.hasValue(0)) {
            this.setDropDownBackgroundDrawable(v3.getDrawable(0));
        }

        v3.recycle();
        AppCompatBackgroundHelper v3_1 = new AppCompatBackgroundHelper(((View)this));
        this.mBackgroundTintHelper = v3_1;
        v3_1.loadFromAttributes(arg4, arg5);
        AppCompatTextHelper v3_2 = new AppCompatTextHelper(((TextView)this));
        this.mTextHelper = v3_2;
        v3_2.loadFromAttributes(arg4, arg5);
        v3_2.applyCompoundDrawablesTints();
        AppCompatEmojiEditTextHelper v3_3 = new AppCompatEmojiEditTextHelper(((EditText)this));
        this.mAppCompatEmojiEditTextHelper = v3_3;
        v3_3.loadFromAttributes(arg4, arg5);
        this.initEmojiKeyListener(v3_3);
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

    public ActionMode$Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.unwrapCustomSelectionActionModeCallback(super.getCustomSelectionActionModeCallback());
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

    void initEmojiKeyListener(AppCompatEmojiEditTextHelper arg6) {
        KeyListener v0 = this.getKeyListener();
        if(arg6.isEmojiCapableKeyListener(v0)) {
            boolean v1 = super.isFocusable();
            boolean v2 = super.isClickable();
            boolean v3 = super.isLongClickable();
            int v4 = super.getInputType();
            KeyListener v6 = arg6.getKeyListener(v0);
            if(v6 == v0) {
            }
            else {
                super.setKeyListener(v6);
                super.setRawInputType(v4);
                super.setFocusable(v1);
                super.setClickable(v2);
                super.setLongClickable(v3);
            }
        }
    }

    public boolean isEmojiCompatEnabled() {
        return this.mAppCompatEmojiEditTextHelper.isEnabled();
    }

    public InputConnection onCreateInputConnection(EditorInfo arg2) {
        return this.mAppCompatEmojiEditTextHelper.onCreateInputConnection(AppCompatHintHelper.onCreateInputConnection(super.onCreateInputConnection(arg2), arg2, ((View)this)), arg2);
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

    public void setCustomSelectionActionModeCallback(ActionMode$Callback arg1) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(((TextView)this), arg1));
    }

    public void setDropDownBackgroundResource(int arg2) {
        this.setDropDownBackgroundDrawable(AppCompatResources.getDrawable(this.getContext(), arg2));
    }

    public void setEmojiCompatEnabled(boolean arg1) {
        this.mAppCompatEmojiEditTextHelper.setEnabled(arg1);
    }

    public void setKeyListener(KeyListener arg2) {
        super.setKeyListener(this.mAppCompatEmojiEditTextHelper.getKeyListener(arg2));
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
}

