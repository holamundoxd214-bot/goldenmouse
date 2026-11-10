package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode$Callback;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.text.PrecomputedTextCompat$Params;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AppCompatTextView extends TextView implements EmojiCompatConfigurationView, TintableBackgroundView, AutoSizeableTextView, TintableCompoundDrawablesView {
    interface SuperCaller {
        int getAutoSizeMaxTextSize();

        int getAutoSizeMinTextSize();

        int getAutoSizeStepGranularity();

        int[] getAutoSizeTextAvailableSizes();

        int getAutoSizeTextType();

        TextClassifier getTextClassifier();

        void setAutoSizeTextTypeUniformWithConfiguration(int arg1, int arg2, int arg3, int arg4);

        void setAutoSizeTextTypeUniformWithPresetSizes(int[] arg1, int arg2);

        void setAutoSizeTextTypeWithDefaults(int arg1);

        void setFirstBaselineToTopHeight(int arg1);

        void setLastBaselineToBottomHeight(int arg1);

        void setTextClassifier(TextClassifier arg1);
    }

    class SuperCallerApi26 implements SuperCaller {
        SuperCallerApi26(AppCompatTextView arg1) {
            AppCompatTextView.this = arg1;
            super();
        }

        public int getAutoSizeMaxTextSize() {
            return AppCompatTextView.access$001(AppCompatTextView.this);
        }

        public int getAutoSizeMinTextSize() {
            return AppCompatTextView.access$101(AppCompatTextView.this);
        }

        public int getAutoSizeStepGranularity() {
            return AppCompatTextView.access$201(AppCompatTextView.this);
        }

        public int[] getAutoSizeTextAvailableSizes() {
            return AppCompatTextView.access$301(AppCompatTextView.this);
        }

        public int getAutoSizeTextType() {
            return AppCompatTextView.access$401(AppCompatTextView.this);
        }

        public TextClassifier getTextClassifier() {
            return AppCompatTextView.access$501(AppCompatTextView.this);
        }

        public void setAutoSizeTextTypeUniformWithConfiguration(int arg1, int arg2, int arg3, int arg4) {
            AppCompatTextView.access$601(AppCompatTextView.this, arg1, arg2, arg3, arg4);
        }

        public void setAutoSizeTextTypeUniformWithPresetSizes(int[] arg1, int arg2) {
            AppCompatTextView.access$701(AppCompatTextView.this, arg1, arg2);
        }

        public void setAutoSizeTextTypeWithDefaults(int arg1) {
            AppCompatTextView.access$801(AppCompatTextView.this, arg1);
        }

        public void setFirstBaselineToTopHeight(int arg1) {
        }

        public void setLastBaselineToBottomHeight(int arg1) {
        }

        public void setTextClassifier(TextClassifier arg1) {
            AppCompatTextView.access$901(AppCompatTextView.this, arg1);
        }
    }

    class SuperCallerApi28 extends SuperCallerApi26 {
        SuperCallerApi28(AppCompatTextView arg1) {
            AppCompatTextView.this = arg1;
            super(arg1);
        }

        public void setFirstBaselineToTopHeight(int arg1) {
            AppCompatTextView.access$1001(AppCompatTextView.this, arg1);
        }

        public void setLastBaselineToBottomHeight(int arg1) {
            AppCompatTextView.access$1101(AppCompatTextView.this, arg1);
        }
    }

    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private AppCompatEmojiTextHelper mEmojiTextViewHelper;
    private boolean mIsSetTypefaceProcessing;
    private Future mPrecomputedTextFuture;
    private SuperCaller mSuperCaller;
    private final AppCompatTextClassifierHelper mTextClassifierHelper;
    private final AppCompatTextHelper mTextHelper;

    public AppCompatTextView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0x1010084);
    }

    public AppCompatTextView(Context arg2) {
        this(arg2, null);
    }

    public AppCompatTextView(Context arg1, AttributeSet arg2, int arg3) {
        super(TintContextWrapper.wrap(arg1), arg2, arg3);
        this.mIsSetTypefaceProcessing = false;
        this.mSuperCaller = null;
        ThemeUtils.checkAppCompatTheme(((View)this), this.getContext());
        AppCompatBackgroundHelper v1 = new AppCompatBackgroundHelper(((View)this));
        this.mBackgroundTintHelper = v1;
        v1.loadFromAttributes(arg2, arg3);
        AppCompatTextHelper v1_1 = new AppCompatTextHelper(((TextView)this));
        this.mTextHelper = v1_1;
        v1_1.loadFromAttributes(arg2, arg3);
        v1_1.applyCompoundDrawablesTints();
        this.mTextClassifierHelper = new AppCompatTextClassifierHelper(((TextView)this));
        this.getEmojiTextViewHelper().loadFromAttributes(arg2, arg3);
    }

    static int access$001(AppCompatTextView arg0) {
        return super.getAutoSizeMaxTextSize();
    }

    static void access$1001(AppCompatTextView arg0, int arg1) {
        super.setFirstBaselineToTopHeight(arg1);
    }

    static int access$101(AppCompatTextView arg0) {
        return super.getAutoSizeMinTextSize();
    }

    static void access$1101(AppCompatTextView arg0, int arg1) {
        super.setLastBaselineToBottomHeight(arg1);
    }

    static int access$201(AppCompatTextView arg0) {
        return super.getAutoSizeStepGranularity();
    }

    static int[] access$301(AppCompatTextView arg0) {
        return super.getAutoSizeTextAvailableSizes();
    }

    static int access$401(AppCompatTextView arg0) {
        return super.getAutoSizeTextType();
    }

    static TextClassifier access$501(AppCompatTextView arg0) {
        return super.getTextClassifier();
    }

    static void access$601(AppCompatTextView arg0, int arg1, int arg2, int arg3, int arg4) {
        super.setAutoSizeTextTypeUniformWithConfiguration(arg1, arg2, arg3, arg4);
    }

    static void access$701(AppCompatTextView arg0, int[] arg1, int arg2) {
        super.setAutoSizeTextTypeUniformWithPresetSizes(arg1, arg2);
    }

    static void access$801(AppCompatTextView arg0, int arg1) {
        super.setAutoSizeTextTypeWithDefaults(arg1);
    }

    static void access$901(AppCompatTextView arg0, TextClassifier arg1) {
        super.setTextClassifier(arg1);
    }

    private void consumeTextFutureAndSetBlocking() {
        Future v0 = this.mPrecomputedTextFuture;
        if(v0 != null) {
            Future v1 = null;
            try {
                this.mPrecomputedTextFuture = v1;
                TextViewCompat.setPrecomputedText(((TextView)this), v0.get());
                return;
            }
            catch(ExecutionException ) {
                return;
            }
        }
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
            return this.getSuperCaller().getAutoSizeMaxTextSize();
        }

        AppCompatTextHelper v1 = this.mTextHelper;
        if(v1 != null) {
            return v1.getAutoSizeMaxTextSize();
        }

        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if(ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            return this.getSuperCaller().getAutoSizeMinTextSize();
        }

        AppCompatTextHelper v1 = this.mTextHelper;
        if(v1 != null) {
            return v1.getAutoSizeMinTextSize();
        }

        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if(ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            return this.getSuperCaller().getAutoSizeStepGranularity();
        }

        AppCompatTextHelper v1 = this.mTextHelper;
        if(v1 != null) {
            return v1.getAutoSizeStepGranularity();
        }

        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if(ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            return this.getSuperCaller().getAutoSizeTextAvailableSizes();
        }

        AppCompatTextHelper v1 = this.mTextHelper;
        if(v1 != null) {
            return v1.getAutoSizeTextAvailableSizes();
        }

        return new int[0];
    }

    public int getAutoSizeTextType() {
        if(ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            if(this.getSuperCaller().getAutoSizeTextType() == 1) {
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
        AppCompatEmojiTextHelper v0 = this.mEmojiTextViewHelper;
        if(v0 == null) {
            v0 = new AppCompatEmojiTextHelper(((TextView)this));
            this.mEmojiTextViewHelper = v0;
        }

        return v0;
    }

    public int getFirstBaselineToTopHeight() {
        return TextViewCompat.getFirstBaselineToTopHeight(((TextView)this));
    }

    public int getLastBaselineToBottomHeight() {
        return TextViewCompat.getLastBaselineToBottomHeight(((TextView)this));
    }

    SuperCaller getSuperCaller() {
        if(this.mSuperCaller == null) {
            this.mSuperCaller = Build$VERSION.SDK_INT >= 28 ? new SuperCallerApi28(this) : new SuperCallerApi26(this);
        }

        return this.mSuperCaller;
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

    public CharSequence getText() {
        this.consumeTextFutureAndSetBlocking();
        return super.getText();
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

    public Params getTextMetricsParamsCompat() {
        return TextViewCompat.getTextMetricsParams(((TextView)this));
    }

    public boolean isEmojiCompatEnabled() {
        return this.getEmojiTextViewHelper().isEnabled();
    }

    public InputConnection onCreateInputConnection(EditorInfo arg3) {
        InputConnection v0 = super.onCreateInputConnection(arg3);
        this.mTextHelper.populateSurroundingTextIfNeeded(((TextView)this), v0, arg3);
        return AppCompatHintHelper.onCreateInputConnection(v0, arg3, ((View)this));
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
        super.onLayout(arg1, arg2, arg3, arg4, arg5);
        AppCompatTextHelper v0 = this.mTextHelper;
        if(v0 != null) {
            v0.onLayout(arg1, arg2, arg3, arg4, arg5);
        }
    }

    protected void onMeasure(int arg1, int arg2) {
        this.consumeTextFutureAndSetBlocking();
        super.onMeasure(arg1, arg2);
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
            this.getSuperCaller().setAutoSizeTextTypeUniformWithConfiguration(arg2, arg3, arg4, arg5);
            return;
        }

        AppCompatTextHelper v1 = this.mTextHelper;
        if(v1 != null) {
            v1.setAutoSizeTextTypeUniformWithConfiguration(arg2, arg3, arg4, arg5);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] arg2, int arg3) throws IllegalArgumentException {
        if(ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            this.getSuperCaller().setAutoSizeTextTypeUniformWithPresetSizes(arg2, arg3);
            return;
        }

        AppCompatTextHelper v1 = this.mTextHelper;
        if(v1 != null) {
            v1.setAutoSizeTextTypeUniformWithPresetSizes(arg2, arg3);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int arg2) {
        if(ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            this.getSuperCaller().setAutoSizeTextTypeWithDefaults(arg2);
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

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int arg3, int arg4, int arg5, int arg6) {
        Context v0 = this.getContext();
        Drawable v1 = null;
        Drawable v3 = arg3 != 0 ? AppCompatResources.getDrawable(v0, arg3) : v1;
        Drawable v4 = arg4 != 0 ? AppCompatResources.getDrawable(v0, arg4) : v1;
        Drawable v5 = arg5 != 0 ? AppCompatResources.getDrawable(v0, arg5) : v1;
        if(arg6 != 0) {
            v1 = AppCompatResources.getDrawable(v0, arg6);
        }

        this.setCompoundDrawablesRelativeWithIntrinsicBounds(v3, v4, v5, v1);
        AppCompatTextHelper v2 = this.mTextHelper;
        if(v2 != null) {
            v2.onSetCompoundDrawables();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable arg1, Drawable arg2, Drawable arg3, Drawable arg4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(arg1, arg2, arg3, arg4);
        AppCompatTextHelper v0 = this.mTextHelper;
        if(v0 != null) {
            v0.onSetCompoundDrawables();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int arg3, int arg4, int arg5, int arg6) {
        Context v0 = this.getContext();
        Drawable v1 = null;
        Drawable v3 = arg3 != 0 ? AppCompatResources.getDrawable(v0, arg3) : v1;
        Drawable v4 = arg4 != 0 ? AppCompatResources.getDrawable(v0, arg4) : v1;
        Drawable v5 = arg5 != 0 ? AppCompatResources.getDrawable(v0, arg5) : v1;
        if(arg6 != 0) {
            v1 = AppCompatResources.getDrawable(v0, arg6);
        }

        this.setCompoundDrawablesWithIntrinsicBounds(v3, v4, v5, v1);
        AppCompatTextHelper v2 = this.mTextHelper;
        if(v2 != null) {
            v2.onSetCompoundDrawables();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable arg1, Drawable arg2, Drawable arg3, Drawable arg4) {
        super.setCompoundDrawablesWithIntrinsicBounds(arg1, arg2, arg3, arg4);
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

    public void setFilters(InputFilter[] arg2) {
        super.setFilters(this.getEmojiTextViewHelper().getFilters(arg2));
    }

    public void setFirstBaselineToTopHeight(int arg3) {
        if(Build$VERSION.SDK_INT >= 28) {
            this.getSuperCaller().setFirstBaselineToTopHeight(arg3);
            return;
        }

        TextViewCompat.setFirstBaselineToTopHeight(((TextView)this), arg3);
    }

    public void setLastBaselineToBottomHeight(int arg3) {
        if(Build$VERSION.SDK_INT >= 28) {
            this.getSuperCaller().setLastBaselineToBottomHeight(arg3);
            return;
        }

        TextViewCompat.setLastBaselineToBottomHeight(((TextView)this), arg3);
    }

    public void setLineHeight(int arg1) {
        TextViewCompat.setLineHeight(((TextView)this), arg1);
    }

    public void setPrecomputedText(PrecomputedTextCompat arg1) {
        TextViewCompat.setPrecomputedText(((TextView)this), arg1);
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

    public void setTextFuture(Future arg1) {
        this.mPrecomputedTextFuture = arg1;
        if(arg1 != null) {
            this.requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(Params arg1) {
        TextViewCompat.setTextMetricsParams(((TextView)this), arg1);
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

    public void setTypeface(Typeface arg3, int arg4) {
        if(this.mIsSetTypefaceProcessing) {
            return;
        }

        Typeface v0 = arg3 == null || arg4 <= 0 ? null : TypefaceCompat.create(this.getContext(), arg3, arg4);
        this.mIsSetTypefaceProcessing = true;
        if(v0 != null) {
            arg3 = v0;
        }

        try {
            super.setTypeface(arg3, arg4);
        }
        catch(Throwable v3) {
            this.mIsSetTypefaceProcessing = false;
            throw v3;
        }

        this.mIsSetTypefaceProcessing = false;
    }
}

