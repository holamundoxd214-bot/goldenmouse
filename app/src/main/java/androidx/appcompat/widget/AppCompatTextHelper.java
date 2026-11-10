package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources$NotFoundException;
import android.graphics.PorterDuff$Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.core.content.res.ResourcesCompat$FontCallback;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.widget.TextViewCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

class AppCompatTextHelper {
    class Api17Impl {
        private Api17Impl() {
            super();
        }

        static Drawable[] getCompoundDrawablesRelative(TextView arg0) {
            return arg0.getCompoundDrawablesRelative();
        }

        static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView arg0, Drawable arg1, Drawable arg2, Drawable arg3, Drawable arg4) {
            arg0.setCompoundDrawablesRelativeWithIntrinsicBounds(arg1, arg2, arg3, arg4);
        }

        static void setTextLocale(TextView arg0, Locale arg1) {
            arg0.setTextLocale(arg1);
        }
    }

    class Api21Impl {
        private Api21Impl() {
            super();
        }

        static Locale forLanguageTag(String arg0) {
            return Locale.forLanguageTag(arg0);
        }
    }

    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static LocaleList forLanguageTags(String arg0) {
            return LocaleList.forLanguageTags(arg0);
        }

        static void setTextLocales(TextView arg0, LocaleList arg1) {
            arg0.setTextLocales(arg1);
        }
    }

    class Api26Impl {
        private Api26Impl() {
            super();
        }

        static int getAutoSizeStepGranularity(TextView arg0) {
            return arg0.getAutoSizeStepGranularity();
        }

        static void setAutoSizeTextTypeUniformWithConfiguration(TextView arg0, int arg1, int arg2, int arg3, int arg4) {
            arg0.setAutoSizeTextTypeUniformWithConfiguration(arg1, arg2, arg3, arg4);
        }

        static void setAutoSizeTextTypeUniformWithPresetSizes(TextView arg0, int[] arg1, int arg2) {
            arg0.setAutoSizeTextTypeUniformWithPresetSizes(arg1, arg2);
        }

        static boolean setFontVariationSettings(TextView arg0, String arg1) {
            return arg0.setFontVariationSettings(arg1);
        }
    }

    class Api28Impl {
        private Api28Impl() {
            super();
        }

        static Typeface create(Typeface arg0, int arg1, boolean arg2) {
            return Typeface.create(arg0, arg1, arg2);
        }
    }

    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int TEXT_FONT_WEIGHT_UNSPECIFIED = -1;
    private boolean mAsyncFontPending;
    private final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
    private TintInfo mDrawableBottomTint;
    private TintInfo mDrawableEndTint;
    private TintInfo mDrawableLeftTint;
    private TintInfo mDrawableRightTint;
    private TintInfo mDrawableStartTint;
    private TintInfo mDrawableTint;
    private TintInfo mDrawableTopTint;
    private Typeface mFontTypeface;
    private int mFontWeight;
    private int mStyle;
    private final TextView mView;

    AppCompatTextHelper(TextView arg2) {
        super();
        this.mStyle = 0;
        this.mFontWeight = -1;
        this.mView = arg2;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(arg2);
    }

    private void applyCompoundDrawableTint(Drawable arg1, TintInfo arg2) {
        if(arg1 != null && arg2 != null) {
            AppCompatDrawableManager.tintDrawable(arg1, arg2, this.mView.getDrawableState());
        }
    }

    void applyCompoundDrawablesTints() {
        Drawable[] v0;
        int v1 = 2;
        if(this.mDrawableLeftTint != null || this.mDrawableTopTint != null || this.mDrawableRightTint != null || this.mDrawableBottomTint != null) {
            v0 = this.mView.getCompoundDrawables();
            this.applyCompoundDrawableTint(v0[0], this.mDrawableLeftTint);
            this.applyCompoundDrawableTint(v0[1], this.mDrawableTopTint);
            this.applyCompoundDrawableTint(v0[v1], this.mDrawableRightTint);
            this.applyCompoundDrawableTint(v0[3], this.mDrawableBottomTint);
        }

        if(this.mDrawableStartTint == null) {
            if(this.mDrawableEndTint != null) {
            }
            else {
                return;
            }
        }

        v0 = Api17Impl.getCompoundDrawablesRelative(this.mView);
        this.applyCompoundDrawableTint(v0[0], this.mDrawableStartTint);
        this.applyCompoundDrawableTint(v0[v1], this.mDrawableEndTint);
    }

    void autoSizeText() {
        this.mAutoSizeTextHelper.autoSizeText();
    }

    private static TintInfo createTintInfo(Context arg0, AppCompatDrawableManager arg1, int arg2) {
        ColorStateList v0 = arg1.getTintList(arg0, arg2);
        if(v0 != null) {
            TintInfo v1 = new TintInfo();
            v1.mHasTintList = true;
            v1.mTintList = v0;
            return v1;
        }

        return null;
    }

    int getAutoSizeMaxTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
    }

    int getAutoSizeMinTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
    }

    int getAutoSizeStepGranularity() {
        return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
    }

    int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
    }

    int getAutoSizeTextType() {
        return this.mAutoSizeTextHelper.getAutoSizeTextType();
    }

    ColorStateList getCompoundDrawableTintList() {
        TintInfo v0 = this.mDrawableTint;
        if(v0 != null) {
            return v0.mTintList;
        }

        return null;
    }

    PorterDuff$Mode getCompoundDrawableTintMode() {
        TintInfo v0 = this.mDrawableTint;
        if(v0 != null) {
            return v0.mTintMode;
        }

        return null;
    }

    boolean isAutoSizeEnabled() {
        return this.mAutoSizeTextHelper.isAutoSizeEnabled();
    }

    void loadFromAttributes(AttributeSet arg14, int arg15) {
        TextView v4_1;
        int v2_2;
        String v11;
        String v10;
        int v8;
        boolean v6;
        TintTypedArray v14_1;
        Context v0 = this.mView.getContext();
        AppCompatDrawableManager v1 = AppCompatDrawableManager.get();
        TintTypedArray v2 = TintTypedArray.obtainStyledAttributes(v0, arg14, styleable.AppCompatTextHelper, arg15, 0);
        AttributeSet v7 = arg14;
        int v9 = arg15;
        ViewCompat.saveAttributeDataForStyleable(this.mView, this.mView.getContext(), styleable.AppCompatTextHelper, v7, v2.getWrappedTypeArray(), v9, 0);
        arg15 = -1;
        int v14 = v2.getResourceId(styleable.AppCompatTextHelper_android_textAppearance, arg15);
        if(v2.hasValue(styleable.AppCompatTextHelper_android_drawableLeft)) {
            this.mDrawableLeftTint = AppCompatTextHelper.createTintInfo(v0, v1, v2.getResourceId(styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }

        if(v2.hasValue(styleable.AppCompatTextHelper_android_drawableTop)) {
            this.mDrawableTopTint = AppCompatTextHelper.createTintInfo(v0, v1, v2.getResourceId(styleable.AppCompatTextHelper_android_drawableTop, 0));
        }

        if(v2.hasValue(styleable.AppCompatTextHelper_android_drawableRight)) {
            this.mDrawableRightTint = AppCompatTextHelper.createTintInfo(v0, v1, v2.getResourceId(styleable.AppCompatTextHelper_android_drawableRight, 0));
        }

        if(v2.hasValue(styleable.AppCompatTextHelper_android_drawableBottom)) {
            this.mDrawableBottomTint = AppCompatTextHelper.createTintInfo(v0, v1, v2.getResourceId(styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }

        if(v2.hasValue(styleable.AppCompatTextHelper_android_drawableStart)) {
            this.mDrawableStartTint = AppCompatTextHelper.createTintInfo(v0, v1, v2.getResourceId(styleable.AppCompatTextHelper_android_drawableStart, 0));
        }

        if(v2.hasValue(styleable.AppCompatTextHelper_android_drawableEnd)) {
            this.mDrawableEndTint = AppCompatTextHelper.createTintInfo(v0, v1, v2.getResourceId(styleable.AppCompatTextHelper_android_drawableEnd, 0));
        }

        v2.recycle();
        boolean v2_1 = this.mView.getTransformationMethod() instanceof PasswordTransformationMethod;
        int v4 = 1;
        PorterDuff$Mode v5 = null;
        if(v14 != arg15) {
            v14_1 = TintTypedArray.obtainStyledAttributes(v0, v14, styleable.TextAppearance);
            if((v2_1) || !v14_1.hasValue(styleable.TextAppearance_textAllCaps)) {
                v6 = false;
                v8 = 0;
            }
            else {
                v6 = v14_1.getBoolean(styleable.TextAppearance_textAllCaps, false);
                v8 = 1;
            }

            this.updateTypefaceAndStyle(v0, v14_1);
            v10 = v14_1.hasValue(styleable.TextAppearance_textLocale) ? v14_1.getString(styleable.TextAppearance_textLocale) : ((String)v5);
            v11 = v14_1.hasValue(styleable.TextAppearance_fontVariationSettings) ? v14_1.getString(styleable.TextAppearance_fontVariationSettings) : ((String)v5);
            v14_1.recycle();
        }
        else {
            v6 = false;
            v8 = 0;
            v10 = ((String)v5);
            v11 = v10;
        }

        v14_1 = TintTypedArray.obtainStyledAttributes(v0, v7, styleable.TextAppearance, v9, 0);
        if((v2_1) || !v14_1.hasValue(styleable.TextAppearance_textAllCaps)) {
            v4 = v8;
        }
        else {
            v6 = v14_1.getBoolean(styleable.TextAppearance_textAllCaps, false);
        }

        if(v14_1.hasValue(styleable.TextAppearance_textLocale)) {
            v10 = v14_1.getString(styleable.TextAppearance_textLocale);
        }

        if(v14_1.hasValue(styleable.TextAppearance_fontVariationSettings)) {
            v11 = v14_1.getString(styleable.TextAppearance_fontVariationSettings);
        }

        if(Build$VERSION.SDK_INT >= 28 && (v14_1.hasValue(styleable.TextAppearance_android_textSize)) && v14_1.getDimensionPixelSize(styleable.TextAppearance_android_textSize, arg15) == 0) {
            this.mView.setTextSize(0, 0f);
        }

        this.updateTypefaceAndStyle(v0, v14_1);
        v14_1.recycle();
        if(!v2_1 && v4 != 0) {
            this.setAllCaps(v6);
        }

        Typeface v14_2 = this.mFontTypeface;
        if(v14_2 != null) {
            v2_2 = this.mFontWeight;
            v4_1 = this.mView;
            if(v2_2 == arg15) {
                v4_1.setTypeface(v14_2, this.mStyle);
            }
            else {
                v4_1.setTypeface(v14_2);
            }
        }

        if(v11 != null) {
            Api26Impl.setFontVariationSettings(this.mView, v11);
        }

        if(v10 != null) {
            Api24Impl.setTextLocales(this.mView, Api24Impl.forLanguageTags(v10));
        }

        this.mAutoSizeTextHelper.loadFromAttributes(v7, v9);
        if((ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) && this.mAutoSizeTextHelper.getAutoSizeTextType() != 0) {
            int[] v14_3 = this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
            if(v14_3.length > 0) {
                v2_2 = Float.compare(((float)Api26Impl.getAutoSizeStepGranularity(this.mView)), -1f);
                v4_1 = this.mView;
                if(v2_2 != 0) {
                    Api26Impl.setAutoSizeTextTypeUniformWithConfiguration(v4_1, this.mAutoSizeTextHelper.getAutoSizeMinTextSize(), this.mAutoSizeTextHelper.getAutoSizeMaxTextSize(), this.mAutoSizeTextHelper.getAutoSizeStepGranularity(), 0);
                }
                else {
                    Api26Impl.setAutoSizeTextTypeUniformWithPresetSizes(v4_1, v14_3, 0);
                }
            }
        }

        v14_1 = TintTypedArray.obtainStyledAttributes(v0, v7, styleable.AppCompatTextView);
        v2_2 = v14_1.getResourceId(styleable.AppCompatTextView_drawableLeftCompat, arg15);
        Drawable v7_1 = v2_2 != arg15 ? v1.getDrawable(v0, v2_2) : ((Drawable)v5);
        v2_2 = v14_1.getResourceId(styleable.AppCompatTextView_drawableTopCompat, arg15);
        Drawable v8_1 = v2_2 != arg15 ? v1.getDrawable(v0, v2_2) : ((Drawable)v5);
        v2_2 = v14_1.getResourceId(styleable.AppCompatTextView_drawableRightCompat, arg15);
        Drawable v9_1 = v2_2 != arg15 ? v1.getDrawable(v0, v2_2) : ((Drawable)v5);
        v2_2 = v14_1.getResourceId(styleable.AppCompatTextView_drawableBottomCompat, arg15);
        Drawable v10_1 = v2_2 != arg15 ? v1.getDrawable(v0, v2_2) : ((Drawable)v5);
        v2_2 = v14_1.getResourceId(styleable.AppCompatTextView_drawableStartCompat, arg15);
        Drawable v11_1 = v2_2 != arg15 ? v1.getDrawable(v0, v2_2) : ((Drawable)v5);
        v2_2 = v14_1.getResourceId(styleable.AppCompatTextView_drawableEndCompat, arg15);
        Drawable v12 = v2_2 != arg15 ? v1.getDrawable(v0, v2_2) : ((Drawable)v5);
        AppCompatTextHelper v6_1 = this;
        v6_1.setCompoundDrawables(v7_1, v8_1, v9_1, v10_1, v11_1, v12);
        if(v14_1.hasValue(styleable.AppCompatTextView_drawableTint)) {
            TextViewCompat.setCompoundDrawableTintList(v6_1.mView, v14_1.getColorStateList(styleable.AppCompatTextView_drawableTint));
        }

        if(v14_1.hasValue(styleable.AppCompatTextView_drawableTintMode)) {
            TextViewCompat.setCompoundDrawableTintMode(v6_1.mView, DrawableUtils.parseTintMode(v14_1.getInt(styleable.AppCompatTextView_drawableTintMode, arg15), v5));
        }

        int v13 = v14_1.getDimensionPixelSize(styleable.AppCompatTextView_firstBaselineToTopHeight, arg15);
        int v0_1 = v14_1.getDimensionPixelSize(styleable.AppCompatTextView_lastBaselineToBottomHeight, arg15);
        int v1_1 = v14_1.getDimensionPixelSize(styleable.AppCompatTextView_lineHeight, arg15);
        v14_1.recycle();
        if(v13 != arg15) {
            TextViewCompat.setFirstBaselineToTopHeight(v6_1.mView, v13);
        }

        if(v0_1 != arg15) {
            TextViewCompat.setLastBaselineToBottomHeight(v6_1.mView, v0_1);
        }

        if(v1_1 != arg15) {
            TextViewCompat.setLineHeight(v6_1.mView, v1_1);
        }
    }

    void onAsyncTypefaceReceived(WeakReference arg3, Typeface arg4) {
        if(this.mAsyncFontPending) {
            this.mFontTypeface = arg4;
            Object v3 = arg3.get();
            if(v3 != null) {
                boolean v0 = ViewCompat.isAttachedToWindow(((View)v3));
                int v1 = this.mStyle;
                if(v0) {
                    ((TextView)v3).post(new Runnable(((TextView)v3), arg4, v1) {
                        public void run() {
                            this.val$textView.setTypeface(this.val$typeface, this.val$style);
                        }
                    });
                    return;
                }
                else {
                    ((TextView)v3).setTypeface(arg4, v1);
                }
            }
        }
    }

    void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
        if(!ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            this.autoSizeText();
        }
    }

    void onSetCompoundDrawables() {
        this.applyCompoundDrawablesTints();
    }

    void onSetTextAppearance(Context arg4, int arg5) {
        TintTypedArray v5 = TintTypedArray.obtainStyledAttributes(arg4, arg5, styleable.TextAppearance);
        if(v5.hasValue(styleable.TextAppearance_textAllCaps)) {
            this.setAllCaps(v5.getBoolean(styleable.TextAppearance_textAllCaps, false));
        }

        if((v5.hasValue(styleable.TextAppearance_android_textSize)) && v5.getDimensionPixelSize(styleable.TextAppearance_android_textSize, -1) == 0) {
            this.mView.setTextSize(0, 0f);
        }

        this.updateTypefaceAndStyle(arg4, v5);
        if(v5.hasValue(styleable.TextAppearance_fontVariationSettings)) {
            String v4 = v5.getString(styleable.TextAppearance_fontVariationSettings);
            if(v4 != null) {
                Api26Impl.setFontVariationSettings(this.mView, v4);
            }
        }

        v5.recycle();
        Typeface v4_1 = this.mFontTypeface;
        if(v4_1 != null) {
            this.mView.setTypeface(v4_1, this.mStyle);
        }
    }

    void populateSurroundingTextIfNeeded(TextView arg2, InputConnection arg3, EditorInfo arg4) {
        if(Build$VERSION.SDK_INT < 30 && arg3 != null) {
            EditorInfoCompat.setInitialSurroundingText(arg4, arg2.getText());
        }
    }

    void setAllCaps(boolean arg1) {
        this.mView.setAllCaps(arg1);
    }

    void setAutoSizeTextTypeUniformWithConfiguration(int arg1, int arg2, int arg3, int arg4) throws IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(arg1, arg2, arg3, arg4);
    }

    void setAutoSizeTextTypeUniformWithPresetSizes(int[] arg1, int arg2) throws IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(arg1, arg2);
    }

    void setAutoSizeTextTypeWithDefaults(int arg1) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(arg1);
    }

    void setCompoundDrawableTintList(ColorStateList arg2) {
        TintInfo v0 = this.mDrawableTint;
        if(v0 == null) {
            v0 = new TintInfo();
            this.mDrawableTint = v0;
        }

        v0.mTintList = arg2;
        v0 = this.mDrawableTint;
        boolean v2 = arg2 != null ? true : false;
        v0.mHasTintList = v2;
        this.setCompoundTints();
    }

    void setCompoundDrawableTintMode(PorterDuff$Mode arg2) {
        TintInfo v0 = this.mDrawableTint;
        if(v0 == null) {
            v0 = new TintInfo();
            this.mDrawableTint = v0;
        }

        v0.mTintMode = arg2;
        v0 = this.mDrawableTint;
        boolean v2 = arg2 != null ? true : false;
        v0.mHasTintMode = v2;
        this.setCompoundTints();
    }

    private void setCompoundDrawables(Drawable arg6, Drawable arg7, Drawable arg8, Drawable arg9, Drawable arg10, Drawable arg11) {
        TextView v5;
        int v0 = 3;
        int v3 = 2;
        if(arg10 == null) {
            if(arg11 != null) {
            }
            else {
                if(arg6 == null && arg7 == null && arg8 == null) {
                    if(arg9 != null) {
                    }
                    else {
                        return;
                    }
                }

                Drawable[] v10 = Api17Impl.getCompoundDrawablesRelative(this.mView);
                arg11 = v10[0];
                if(arg11 == null) {
                    if(v10[v3] != null) {
                    }
                    else {
                        v10 = this.mView.getCompoundDrawables();
                        v5 = this.mView;
                        if(arg6 != null) {
                        }
                        else {
                            arg6 = v10[0];
                        }

                        if(arg7 != null) {
                        }
                        else {
                            arg7 = v10[1];
                        }

                        if(arg8 != null) {
                        }
                        else {
                            arg8 = v10[v3];
                        }

                        if(arg9 != null) {
                        }
                        else {
                            arg9 = v10[v0];
                        }

                        v5.setCompoundDrawablesWithIntrinsicBounds(arg6, arg7, arg8, arg9);
                        return;
                    }
                }

                v5 = this.mView;
                if(arg7 != null) {
                }
                else {
                    arg7 = v10[1];
                }

                arg6 = v10[v3];
                if(arg9 != null) {
                }
                else {
                    arg9 = v10[v0];
                }

                Api17Impl.setCompoundDrawablesRelativeWithIntrinsicBounds(v5, arg11, arg7, arg6, arg9);
                return;
            }
        }

        Drawable[] v6 = Api17Impl.getCompoundDrawablesRelative(this.mView);
        v5 = this.mView;
        if(arg10 != null) {
        }
        else {
            arg10 = v6[0];
        }

        if(arg7 != null) {
        }
        else {
            arg7 = v6[1];
        }

        if(arg11 != null) {
        }
        else {
            arg11 = v6[v3];
        }

        if(arg9 != null) {
        }
        else {
            arg9 = v6[v0];
        }

        Api17Impl.setCompoundDrawablesRelativeWithIntrinsicBounds(v5, arg10, arg7, arg11, arg9);
    }

    private void setCompoundTints() {
        TintInfo v0 = this.mDrawableTint;
        this.mDrawableLeftTint = v0;
        this.mDrawableTopTint = v0;
        this.mDrawableRightTint = v0;
        this.mDrawableBottomTint = v0;
        this.mDrawableStartTint = v0;
        this.mDrawableEndTint = v0;
    }

    void setTextSize(int arg2, float arg3) {
        if(!ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE && !this.isAutoSizeEnabled()) {
            this.setTextSizeInternal(arg2, arg3);
        }
    }

    private void setTextSizeInternal(int arg1, float arg2) {
        this.mAutoSizeTextHelper.setTextSizeInternal(arg1, arg2);
    }

    private void updateTypefaceAndStyle(Context arg10, TintTypedArray arg11) {
        boolean v10_2;
        Typeface v10_1;
        int v0;
        this.mStyle = arg11.getInt(styleable.TextAppearance_android_textStyle, this.mStyle);
        int v1 = 2;
        int v2 = -1;
        int v3 = 28;
        if(Build$VERSION.SDK_INT >= v3) {
            v0 = arg11.getInt(styleable.TextAppearance_android_textFontWeight, v2);
            this.mFontWeight = v0;
            if(v0 != v2) {
                this.mStyle &= v1;
            }
        }

        boolean v4 = true;
        if((arg11.hasValue(styleable.TextAppearance_android_fontFamily)) || (arg11.hasValue(styleable.TextAppearance_fontFamily))) {
            this.mFontTypeface = null;
            v0 = arg11.hasValue(styleable.TextAppearance_fontFamily) ? styleable.TextAppearance_fontFamily : styleable.TextAppearance_android_fontFamily;
            int v6 = this.mFontWeight;
            int v7 = this.mStyle;
            if(!arg10.isRestricted()) {
                androidx.appcompat.widget.AppCompatTextHelper$1 v8 = new FontCallback(v6, v7, new WeakReference(this.mView)) {
                    public void onFontRetrievalFailed(int arg1) {
                    }

                    public void onFontRetrieved(Typeface arg3) {
                        if(Build$VERSION.SDK_INT >= 28) {
                            int v0 = this.val$fontWeight;
                            if(v0 != -1) {
                                boolean v1 = (this.val$style & 2) != 0 ? true : false;
                                arg3 = Api28Impl.create(arg3, v0, v1);
                            }
                        }

                        AppCompatTextHelper.this.onAsyncTypefaceReceived(this.val$textViewWeak, arg3);
                    }
                };
                try {
                    v10_1 = arg11.getFont(v0, this.mStyle, ((FontCallback)v8));
                    if(v10_1 != null) {
                        if(Build$VERSION.SDK_INT >= v3 && this.mFontWeight != v2) {
                            v10_1 = Typeface.create(v10_1, 0);
                            v6 = this.mFontWeight;
                            boolean v7_1 = (this.mStyle & v1) != 0 ? true : false;
                            this.mFontTypeface = Api28Impl.create(v10_1, v6, v7_1);
                            goto label_81;
                        }

                        this.mFontTypeface = v10_1;
                    }

                label_81:
                    if(this.mFontTypeface == null) {
                        v10_2 = true;
                    }
                    else {
                        goto label_85;
                    }

                label_86:
                    this.mAsyncFontPending = v10_2;
                    goto label_87;
                label_85:
                    v10_2 = false;
                    goto label_86;
                }
                catch(Resources$NotFoundException ) {
                label_87:
                    if(this.mFontTypeface != null) {
                        return;
                    }

                    String v10_3 = arg11.getString(v0);
                    if(v10_3 == null) {
                        return;
                    }

                    if(Build$VERSION.SDK_INT >= v3 && this.mFontWeight != v2) {
                        v10_1 = Typeface.create(v10_3, 0);
                        int v11 = this.mFontWeight;
                        if((this.mStyle & v1) != 0) {
                        }
                        else {
                            v4 = false;
                        }

                        this.mFontTypeface = Api28Impl.create(v10_1, v11, v4);
                        return;
                    }

                    this.mFontTypeface = Typeface.create(v10_3, this.mStyle);
                    return;
                }
            }

            goto label_87;
        }
        else if(arg11.hasValue(styleable.TextAppearance_android_typeface)) {
            this.mAsyncFontPending = false;
            int v10 = arg11.getInt(styleable.TextAppearance_android_typeface, 1);
            if(v10 == 1) {
                this.mFontTypeface = Typeface.SANS_SERIF;
                return;
            }
            else if(v10 == v1) {
                this.mFontTypeface = Typeface.SERIF;
                return;
            }
            else if(v10 != 3) {
            }
            else {
                this.mFontTypeface = Typeface.MONOSPACE;
                return;
            }
        }
    }
}

