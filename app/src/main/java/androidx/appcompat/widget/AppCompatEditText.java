package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode$Callback;
import android.view.DragEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentViewBehavior;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TextViewOnReceiveContentListener;
import androidx.core.widget.TintableCompoundDrawablesView;

public class AppCompatEditText extends EditText implements EmojiCompatConfigurationView, OnReceiveContentViewBehavior, TintableBackgroundView, TintableCompoundDrawablesView {
    class SuperCaller {
        SuperCaller(AppCompatEditText arg1) {
            AppCompatEditText.this = arg1;
            super();
        }

        public TextClassifier getTextClassifier() {
            return AppCompatEditText.access$001(AppCompatEditText.this);
        }

        public void setTextClassifier(TextClassifier arg1) {
            AppCompatEditText.access$101(AppCompatEditText.this, arg1);
        }
    }

    private final AppCompatEmojiEditTextHelper mAppCompatEmojiEditTextHelper;
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final TextViewOnReceiveContentListener mDefaultOnReceiveContentListener;
    private SuperCaller mSuperCaller;
    private final AppCompatTextClassifierHelper mTextClassifierHelper;
    private final AppCompatTextHelper mTextHelper;

    public AppCompatEditText(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.editTextStyle);
    }

    public AppCompatEditText(Context arg2) {
        this(arg2, null);
    }

    public AppCompatEditText(Context arg1, AttributeSet arg2, int arg3) {
        super(TintContextWrapper.wrap(arg1), arg2, arg3);
        ThemeUtils.checkAppCompatTheme(((View)this), this.getContext());
        AppCompatBackgroundHelper v1 = new AppCompatBackgroundHelper(((View)this));
        this.mBackgroundTintHelper = v1;
        v1.loadFromAttributes(arg2, arg3);
        AppCompatTextHelper v1_1 = new AppCompatTextHelper(((TextView)this));
        this.mTextHelper = v1_1;
        v1_1.loadFromAttributes(arg2, arg3);
        v1_1.applyCompoundDrawablesTints();
        this.mTextClassifierHelper = new AppCompatTextClassifierHelper(((TextView)this));
        this.mDefaultOnReceiveContentListener = new TextViewOnReceiveContentListener();
        AppCompatEmojiEditTextHelper v1_2 = new AppCompatEmojiEditTextHelper(((EditText)this));
        this.mAppCompatEmojiEditTextHelper = v1_2;
        v1_2.loadFromAttributes(arg2, arg3);
        this.initEmojiKeyListener(v1_2);
    }

    static TextClassifier access$001(AppCompatEditText arg0) {
        return super.getTextClassifier();
    }

    static void access$101(AppCompatEditText arg0, TextClassifier arg1) {
        super.setTextClassifier(arg1);
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

    private SuperCaller getSuperCaller() {
        SuperCaller v0 = this.mSuperCaller;
        if(v0 == null) {
            v0 = new SuperCaller(this);
            this.mSuperCaller = v0;
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

    public Editable getText() {
        if(Build$VERSION.SDK_INT >= 28) {
            return super.getText();
        }

        return super.getEditableText();
    }

    public CharSequence getText() {
        return this.getText();
    }

    public TextClassifier getTextClassifier() {
        if(Build$VERSION.SDK_INT < 28) {
            AppCompatTextClassifierHelper v0 = this.mTextClassifierHelper;
            if(v0 == null) {
            }
            else {
                return v0.getTextClassifier();
            }
        }

        return this.getSuperCaller().getTextClassifier();
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

    public InputConnection onCreateInputConnection(EditorInfo arg4) {
        InputConnection v0 = super.onCreateInputConnection(arg4);
        this.mTextHelper.populateSurroundingTextIfNeeded(((TextView)this), v0, arg4);
        v0 = AppCompatHintHelper.onCreateInputConnection(v0, arg4, ((View)this));
        if(v0 != null && Build$VERSION.SDK_INT <= 30) {
            String[] v1 = ViewCompat.getOnReceiveContentMimeTypes(((View)this));
            if(v1 != null) {
                EditorInfoCompat.setContentMimeTypes(arg4, v1);
                v0 = InputConnectionCompat.createWrapper(((View)this), v0, arg4);
            }
        }

        return this.mAppCompatEmojiEditTextHelper.onCreateInputConnection(v0, arg4);
    }

    public boolean onDragEvent(DragEvent arg2) {
        if(AppCompatReceiveContentHelper.maybeHandleDragEventViaPerformReceiveContent(((View)this), arg2)) {
            return 1;
        }

        return super.onDragEvent(arg2);
    }

    public ContentInfoCompat onReceiveContent(ContentInfoCompat arg2) {
        return this.mDefaultOnReceiveContentListener.onReceiveContent(((View)this), arg2);
    }

    public boolean onTextContextMenuItem(int arg2) {
        if(AppCompatReceiveContentHelper.maybeHandleMenuActionViaPerformReceiveContent(((TextView)this), arg2)) {
            return 1;
        }

        return super.onTextContextMenuItem(arg2);
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

    public void setTextClassifier(TextClassifier arg3) {
        if(Build$VERSION.SDK_INT < 28) {
            AppCompatTextClassifierHelper v0 = this.mTextClassifierHelper;
            if(v0 == null) {
            }
            else {
                v0.setTextClassifier(arg3);
                return;
            }
        }

        this.getSuperCaller().setTextClassifier(arg3);
    }
}

