package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build$VERSION;
import android.text.Layout$Alignment;
import android.text.StaticLayout$Builder;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class AppCompatTextViewAutoSizeHelper {
    final class Api16Impl {
        private Api16Impl() {
            super();
        }

        static StaticLayout createStaticLayoutForMeasuring(CharSequence arg8, Layout$Alignment arg9, int arg10, TextView arg11, TextPaint arg12) {
            return new StaticLayout(arg8, arg12, arg10, arg9, arg11.getLineSpacingMultiplier(), arg11.getLineSpacingExtra(), arg11.getIncludeFontPadding());
        }

        static int getMaxLines(TextView arg0) {
            return arg0.getMaxLines();
        }
    }

    final class Api18Impl {
        private Api18Impl() {
            super();
        }

        static boolean isInLayout(View arg0) {
            return arg0.isInLayout();
        }
    }

    final class Api23Impl {
        private Api23Impl() {
            super();
        }

        static StaticLayout createStaticLayoutForMeasuring(CharSequence arg2, Layout$Alignment arg3, int arg4, int arg5, TextView arg6, TextPaint arg7, Impl arg8) {
            StaticLayout$Builder v2 = StaticLayout$Builder.obtain(arg2, 0, arg2.length(), arg7, arg4);
            StaticLayout$Builder v3 = v2.setAlignment(arg3).setLineSpacing(arg6.getLineSpacingExtra(), arg6.getLineSpacingMultiplier()).setIncludePad(arg6.getIncludeFontPadding()).setBreakStrategy(arg6.getBreakStrategy()).setHyphenationFrequency(arg6.getHyphenationFrequency());
            if(arg5 == -1) {
                arg5 = 0x7FFFFFFF;
            }

            v3.setMaxLines(arg5);
            try {
                arg8.computeAndSetTextDirection(v2, arg6);
            }
            catch(ClassCastException ) {
                Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }

            return v2.build();
        }
    }

    class Impl23 extends Impl {
        Impl23() {
            super();
        }

        void computeAndSetTextDirection(StaticLayout$Builder arg2, TextView arg3) {
            arg2.setTextDirection(AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(arg3, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    class Impl29 extends Impl23 {
        Impl29() {
            super();
        }

        void computeAndSetTextDirection(StaticLayout$Builder arg1, TextView arg2) {
            arg1.setTextDirection(arg2.getTextDirectionHeuristic());
        }

        boolean isHorizontallyScrollable(TextView arg1) {
            return arg1.isHorizontallyScrollable();
        }
    }

    class Impl {
        Impl() {
            super();
        }

        void computeAndSetTextDirection(StaticLayout$Builder arg1, TextView arg2) {
        }

        boolean isHorizontallyScrollable(TextView arg2) {
            return AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(arg2, "getHorizontallyScrolling", Boolean.valueOf(false)).booleanValue();
        }
    }

    private static final int DEFAULT_AUTO_SIZE_GRANULARITY_IN_PX = 1;
    private static final int DEFAULT_AUTO_SIZE_MAX_TEXT_SIZE_IN_SP = 0x70;
    private static final int DEFAULT_AUTO_SIZE_MIN_TEXT_SIZE_IN_SP = 12;
    private static final String TAG = "ACTVAutoSizeHelper";
    private static final RectF TEMP_RECTF = null;
    static final float UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE = -1f;
    private static final int VERY_WIDE = 0x100000;
    private float mAutoSizeMaxTextSizeInPx;
    private float mAutoSizeMinTextSizeInPx;
    private float mAutoSizeStepGranularityInPx;
    private int[] mAutoSizeTextSizesInPx;
    private int mAutoSizeTextType;
    private final Context mContext;
    private boolean mHasPresetAutoSizeValues;
    private final Impl mImpl;
    private boolean mNeedsAutoSizeText;
    private TextPaint mTempTextPaint;
    private final TextView mTextView;
    private static ConcurrentHashMap sTextViewFieldByNameCache;
    private static ConcurrentHashMap sTextViewMethodByNameCache;

    static {
        AppCompatTextViewAutoSizeHelper.TEMP_RECTF = new RectF();
        AppCompatTextViewAutoSizeHelper.sTextViewMethodByNameCache = new ConcurrentHashMap();
        AppCompatTextViewAutoSizeHelper.sTextViewFieldByNameCache = new ConcurrentHashMap();
    }

    AppCompatTextViewAutoSizeHelper(TextView arg3) {
        super();
        this.mAutoSizeTextType = 0;
        this.mNeedsAutoSizeText = false;
        this.mAutoSizeStepGranularityInPx = -1f;
        this.mAutoSizeMinTextSizeInPx = -1f;
        this.mAutoSizeMaxTextSizeInPx = -1f;
        this.mAutoSizeTextSizesInPx = new int[0];
        this.mHasPresetAutoSizeValues = false;
        this.mTextView = arg3;
        this.mContext = arg3.getContext();
        if(Build$VERSION.SDK_INT >= 29) {
            this.mImpl = new Impl29();
            return;
        }

        this.mImpl = new Impl23();
    }

    private static Object accessAndReturnWithDefault(Object arg2, String arg3, Object arg4) {
        try {
            Field v0 = AppCompatTextViewAutoSizeHelper.getTextViewField(arg3);
            if(v0 == null) {
                return arg4;
            }

            return v0.get(arg2);
        }
        catch(IllegalAccessException v2) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + arg3 + " member", ((Throwable)v2));
            return arg4;
        }
    }

    void autoSizeText() {
        if(!this.isAutoSizeEnabled()) {
        }
        else {
            if(this.mNeedsAutoSizeText) {
                if(this.mTextView.getMeasuredHeight() <= 0) {
                    return;
                }
                else if(this.mTextView.getMeasuredWidth() <= 0) {
                    return;
                }
                else {
                    int v0 = this.mImpl.isHorizontallyScrollable(this.mTextView) ? 0x100000 : this.mTextView.getMeasuredWidth() - this.mTextView.getTotalPaddingLeft() - this.mTextView.getTotalPaddingRight();
                    int v1 = this.mTextView.getHeight() - this.mTextView.getCompoundPaddingBottom() - this.mTextView.getCompoundPaddingTop();
                    if(v0 <= 0) {
                        return;
                    }

                    if(v1 <= 0) {
                        return;
                    }

                    RectF v2 = AppCompatTextViewAutoSizeHelper.TEMP_RECTF;
                    __monitor_enter(v2);
                    try {
                        v2.setEmpty();
                        v2.right = ((float)v0);
                        v2.bottom = ((float)v1);
                        float v0_1 = ((float)this.findLargestTextSizeWhichFits(v2));
                        if(v0_1 != this.mTextView.getTextSize()) {
                            this.setTextSizeInternal(0, v0_1);
                        }

                        __monitor_exit(v2);
                        goto label_57;
                    label_54:
                        __monitor_exit(v2);
                    }
                    catch(Throwable v3) {
                        goto label_54;
                    }

                    throw v3;
                }
            }

            goto label_57;
        }

        return;
    label_57:
        this.mNeedsAutoSizeText = true;
    }

    private int[] cleanupAutoSizePresetSizes(int[] arg6) {
        int v5 = arg6.length;
        if(v5 == 0) {
        }
        else {
            Arrays.sort(arg6);
            ArrayList v0 = new ArrayList();
            int v1 = 0;
            int v2;
            for(v2 = 0; v2 < v5; ++v2) {
                int v3 = arg6[v2];
                if(v3 > 0 && Collections.binarySearch(((List)v0), Integer.valueOf(v3)) < 0) {
                    ((List)v0).add(Integer.valueOf(v3));
                }
            }

            if(v5 == ((List)v0).size()) {
                return arg6;
            }

            v5 = ((List)v0).size();
            arg6 = new int[v5];
            while(v1 < v5) {
                arg6[v1] = ((List)v0).get(v1).intValue();
                ++v1;
            }

            return arg6;
        }

        return arg6;
    }

    private void clearAutoSizeConfiguration() {
        this.mAutoSizeTextType = 0;
        this.mAutoSizeMinTextSizeInPx = -1f;
        this.mAutoSizeMaxTextSizeInPx = -1f;
        this.mAutoSizeStepGranularityInPx = -1f;
        this.mAutoSizeTextSizesInPx = new int[0];
        this.mNeedsAutoSizeText = false;
    }

    StaticLayout createLayout(CharSequence arg8, Layout$Alignment arg9, int arg10, int arg11) {
        return Api23Impl.createStaticLayoutForMeasuring(arg8, arg9, arg10, arg11, this.mTextView, this.mTempTextPaint, this.mImpl);
    }

    private StaticLayout createStaticLayoutForMeasuringPre16(CharSequence arg10, Layout$Alignment arg11, int arg12) {
        return new StaticLayout(arg10, this.mTempTextPaint, arg12, arg11, AppCompatTextViewAutoSizeHelper.accessAndReturnWithDefault(this.mTextView, "mSpacingMult", Float.valueOf(1f)).floatValue(), AppCompatTextViewAutoSizeHelper.accessAndReturnWithDefault(this.mTextView, "mSpacingAdd", Float.valueOf(0f)).floatValue(), AppCompatTextViewAutoSizeHelper.accessAndReturnWithDefault(this.mTextView, "mIncludePad", Boolean.valueOf(true)).booleanValue());
    }

    private int findLargestTextSizeWhichFits(RectF arg6) {
        int v0 = this.mAutoSizeTextSizesInPx.length;
        if(v0 != 0) {
            int v1 = 1;
            --v0;
            int v2 = 0;
            while(v1 <= v0) {
                v2 = (v1 + v0) / 2;
                if(this.suggestedSizeFitsInSpace(this.mAutoSizeTextSizesInPx[v2], arg6)) {
                    int v4 = v2 + 1;
                    v2 = v1;
                    v1 = v4;
                    continue;
                }

                --v2;
                v0 = v2;
            }

            return this.mAutoSizeTextSizesInPx[v2];
        }

        throw new IllegalStateException("No available text sizes to choose from.");
    }

    int getAutoSizeMaxTextSize() {
        return Math.round(this.mAutoSizeMaxTextSizeInPx);
    }

    int getAutoSizeMinTextSize() {
        return Math.round(this.mAutoSizeMinTextSizeInPx);
    }

    int getAutoSizeStepGranularity() {
        return Math.round(this.mAutoSizeStepGranularityInPx);
    }

    int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextSizesInPx;
    }

    int getAutoSizeTextType() {
        return this.mAutoSizeTextType;
    }

    private static Field getTextViewField(String arg3) {
        Field v0_2;
        try {
            Object v0_1 = AppCompatTextViewAutoSizeHelper.sTextViewFieldByNameCache.get(arg3);
            if(v0_1 == null) {
                v0_2 = TextView.class.getDeclaredField(arg3);
                if(v0_2 != null) {
                    v0_2.setAccessible(true);
                    AppCompatTextViewAutoSizeHelper.sTextViewFieldByNameCache.put(arg3, v0_2);
                }
            }
        }
        catch(NoSuchFieldException v0) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + arg3 + " member", ((Throwable)v0));
            return null;
        }

        return v0_2;
    }

    private static Method getTextViewMethod(String arg3) {
        Object v0_1;
        try {
            v0_1 = AppCompatTextViewAutoSizeHelper.sTextViewMethodByNameCache.get(arg3);
            if(v0_1 == null) {
                Method v0_2 = TextView.class.getDeclaredMethod(arg3);
                if(v0_2 != null) {
                    v0_2.setAccessible(true);
                    AppCompatTextViewAutoSizeHelper.sTextViewMethodByNameCache.put(arg3, v0_2);
                }
            }
        }
        catch(Exception v0) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + arg3 + "() method", ((Throwable)v0));
            return null;
        }

        return ((Method)v0_1);
    }

    void initTempTextPaint(int arg3) {
        TextPaint v0 = this.mTempTextPaint;
        if(v0 == null) {
            this.mTempTextPaint = new TextPaint();
        }
        else {
            v0.reset();
        }

        this.mTempTextPaint.set(this.mTextView.getPaint());
        this.mTempTextPaint.setTextSize(((float)arg3));
    }

    static Object invokeAndReturnWithDefault(Object arg3, String arg4, Object arg5) {
        String v0 = "Failed to invoke TextView#";
        try {
            return AppCompatTextViewAutoSizeHelper.getTextViewMethod(arg4).invoke(arg3);
        }
        catch(Throwable v3) {
            throw v3;
        }
        catch(Exception v3_1) {
            Log.w("ACTVAutoSizeHelper", v0 + arg4 + "() method", ((Throwable)v3_1));
            return arg5;
        }
    }

    boolean isAutoSizeEnabled() {
        if((this.supportsAutoSizeText()) && this.mAutoSizeTextType != 0) {
            return 1;
        }

        return 0;
    }

    void loadFromAttributes(AttributeSet arg11, int arg12) {
        TypedArray v7 = this.mContext.obtainStyledAttributes(arg11, styleable.AppCompatTextView, arg12, 0);
        ViewCompat.saveAttributeDataForStyleable(this.mTextView, this.mTextView.getContext(), styleable.AppCompatTextView, arg11, v7, arg12, 0);
        if(v7.hasValue(styleable.AppCompatTextView_autoSizeTextType)) {
            this.mAutoSizeTextType = v7.getInt(styleable.AppCompatTextView_autoSizeTextType, 0);
        }

        float v12 = -1f;
        float v11 = v7.hasValue(styleable.AppCompatTextView_autoSizeStepGranularity) ? v7.getDimension(styleable.AppCompatTextView_autoSizeStepGranularity, v12) : v12;
        float v0 = v7.hasValue(styleable.AppCompatTextView_autoSizeMinTextSize) ? v7.getDimension(styleable.AppCompatTextView_autoSizeMinTextSize, v12) : v12;
        float v1 = v7.hasValue(styleable.AppCompatTextView_autoSizeMaxTextSize) ? v7.getDimension(styleable.AppCompatTextView_autoSizeMaxTextSize, v12) : v12;
        if(v7.hasValue(styleable.AppCompatTextView_autoSizePresetSizes)) {
            int v3 = v7.getResourceId(styleable.AppCompatTextView_autoSizePresetSizes, 0);
            if(v3 > 0) {
                TypedArray v3_1 = v7.getResources().obtainTypedArray(v3);
                this.setupAutoSizeUniformPresetSizes(v3_1);
                v3_1.recycle();
            }
        }

        v7.recycle();
        if(this.supportsAutoSizeText()) {
            if(this.mAutoSizeTextType == 1) {
                if(!this.mHasPresetAutoSizeValues) {
                    DisplayMetrics v2 = this.mContext.getResources().getDisplayMetrics();
                    int v4 = 2;
                    if(Float.compare(v0, v12) == 0) {
                        v0 = TypedValue.applyDimension(v4, 12f, v2);
                    }

                    if(v1 == v12) {
                        v1 = TypedValue.applyDimension(v4, 112f, v2);
                    }

                    if(v11 == v12) {
                        v11 = 1f;
                    }

                    this.validateAndSetAutoSizeTextTypeUniformConfiguration(v0, v1, v11);
                }

                this.setupAutoSizeText();
            }

            return;
        }

        this.mAutoSizeTextType = 0;
    }

    void setAutoSizeTextTypeUniformWithConfiguration(int arg2, int arg3, int arg4, int arg5) throws IllegalArgumentException {
        if(this.supportsAutoSizeText()) {
            DisplayMetrics v0 = this.mContext.getResources().getDisplayMetrics();
            this.validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(arg5, ((float)arg2), v0), TypedValue.applyDimension(arg5, ((float)arg3), v0), TypedValue.applyDimension(arg5, ((float)arg4), v0));
            if(this.setupAutoSizeText()) {
                this.autoSizeText();
            }
        }
    }

    void setAutoSizeTextTypeUniformWithPresetSizes(int[] arg6, int arg7) throws IllegalArgumentException {
        if(this.supportsAutoSizeText()) {
            int v0 = arg6.length;
            int v1 = 0;
            if(v0 > 0) {
                int[] v2 = new int[v0];
                if(arg7 == 0) {
                    v2 = Arrays.copyOf(arg6, v0);
                }
                else {
                    DisplayMetrics v3 = this.mContext.getResources().getDisplayMetrics();
                    while(v1 < v0) {
                        v2[v1] = Math.round(TypedValue.applyDimension(arg7, ((float)arg6[v1]), v3));
                        ++v1;
                    }
                }

                this.mAutoSizeTextSizesInPx = this.cleanupAutoSizePresetSizes(v2);
                if(this.setupAutoSizeUniformPresetSizesConfiguration()) {
                    goto label_35;
                }

                throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(arg6));
            }
            else {
                this.mHasPresetAutoSizeValues = false;
            }

        label_35:
            if(!this.setupAutoSizeText()) {
                return;
            }

            this.autoSizeText();
        }
    }

    void setAutoSizeTextTypeWithDefaults(int arg4) {
        if(this.supportsAutoSizeText()) {
            if(arg4 == 0) {
                this.clearAutoSizeConfiguration();
            }
            else if(arg4 == 1) {
                DisplayMetrics v4 = this.mContext.getResources().getDisplayMetrics();
                this.validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(2, 12f, v4), TypedValue.applyDimension(2, 112f, v4), 1f);
                if(this.setupAutoSizeText()) {
                    this.autoSizeText();
                    return;
                }
            }
            else {
                throw new IllegalArgumentException("Unknown auto-size text type: " + arg4);
            }
        }
    }

    private void setRawTextSize(float arg4) {
        if(arg4 != this.mTextView.getPaint().getTextSize()) {
            this.mTextView.getPaint().setTextSize(arg4);
            boolean v4 = Api18Impl.isInLayout(this.mTextView);
            if(this.mTextView.getLayout() == null) {
                return;
            }

            this.mNeedsAutoSizeText = false;
            try {
                Method v1 = AppCompatTextViewAutoSizeHelper.getTextViewMethod("nullLayouts");
                if(v1 == null) {
                    goto label_25;
                }

                v1.invoke(this.mTextView);
            }
            catch(Exception v0) {
                Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", ((Throwable)v0));
            }

        label_25:
            TextView v0_1 = this.mTextView;
            if(!v4) {
                v0_1.requestLayout();
            }
            else {
                v0_1.forceLayout();
            }

            this.mTextView.invalidate();
        }
    }

    void setTextSizeInternal(int arg2, float arg3) {
        Context v0 = this.mContext;
        Resources v0_1 = v0 == null ? Resources.getSystem() : v0.getResources();
        this.setRawTextSize(TypedValue.applyDimension(arg2, arg3, v0_1.getDisplayMetrics()));
    }

    private boolean setupAutoSizeText() {
        int v1 = 0;
        if((this.supportsAutoSizeText()) && this.mAutoSizeTextType == 1) {
            if(!this.mHasPresetAutoSizeValues || this.mAutoSizeTextSizesInPx.length == 0) {
                int v0 = (((int)Math.floor(((double)((this.mAutoSizeMaxTextSizeInPx - this.mAutoSizeMinTextSizeInPx) / this.mAutoSizeStepGranularityInPx))))) + 1;
                int[] v3 = new int[v0];
                while(v1 < v0) {
                    v3[v1] = Math.round(this.mAutoSizeMinTextSizeInPx + (((float)v1)) * this.mAutoSizeStepGranularityInPx);
                    ++v1;
                }

                this.mAutoSizeTextSizesInPx = this.cleanupAutoSizePresetSizes(v3);
            }

            this.mNeedsAutoSizeText = true;
            return 1;
        }

        this.mNeedsAutoSizeText = false;
        return 0;
    }

    private void setupAutoSizeUniformPresetSizes(TypedArray arg5) {
        int v0 = arg5.length();
        int[] v1 = new int[v0];
        if(v0 > 0) {
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                v1[v2] = arg5.getDimensionPixelSize(v2, -1);
            }

            this.mAutoSizeTextSizesInPx = this.cleanupAutoSizePresetSizes(v1);
            this.setupAutoSizeUniformPresetSizesConfiguration();
        }
    }

    private boolean setupAutoSizeUniformPresetSizesConfiguration() {
        int[] v0 = this.mAutoSizeTextSizesInPx;
        int v1 = v0.length;
        boolean v4 = v1 > 0 ? true : false;
        this.mHasPresetAutoSizeValues = v4;
        if(v4) {
            this.mAutoSizeTextType = 1;
            this.mAutoSizeMinTextSizeInPx = ((float)v0[0]);
            this.mAutoSizeMaxTextSizeInPx = ((float)v0[v1 - 1]);
            this.mAutoSizeStepGranularityInPx = -1f;
        }

        return v4;
    }

    private boolean suggestedSizeFitsInSpace(int arg5, RectF arg6) {
        CharSequence v0 = this.mTextView.getText();
        TransformationMethod v1 = this.mTextView.getTransformationMethod();
        if(v1 != null) {
            CharSequence v1_1 = v1.getTransformation(v0, this.mTextView);
            if(v1_1 != null) {
                v0 = v1_1;
            }
        }

        int v1_2 = Api16Impl.getMaxLines(this.mTextView);
        this.initTempTextPaint(arg5);
        StaticLayout v4 = this.createLayout(v0, AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(this.mTextView, "getLayoutAlignment", Layout$Alignment.ALIGN_NORMAL), Math.round(arg6.right), v1_2);
        if(v1_2 != -1 && (v4.getLineCount() > v1_2 || v4.getLineEnd(v4.getLineCount() - 1) != v0.length())) {
            return 0;
        }

        if((((float)v4.getHeight())) > arg6.bottom) {
            return 0;
        }

        return 1;
    }

    private boolean supportsAutoSizeText() {
        return this.mTextView instanceof AppCompatEditText ^ 1;
    }

    private void validateAndSetAutoSizeTextTypeUniformConfiguration(float arg4, float arg5, float arg6) throws IllegalArgumentException {
        String v2 = "px) is less or equal to (0px)";
        if(Float.compare(arg4, 0f) > 0) {
            if(arg5 > arg4) {
                if(arg6 > 0f) {
                    this.mAutoSizeTextType = 1;
                    this.mAutoSizeMinTextSizeInPx = arg4;
                    this.mAutoSizeMaxTextSizeInPx = arg5;
                    this.mAutoSizeStepGranularityInPx = arg6;
                    this.mHasPresetAutoSizeValues = false;
                    return;
                }

                throw new IllegalArgumentException("The auto-size step granularity (" + arg6 + v2);
            }

            throw new IllegalArgumentException("Maximum auto-size text size (" + arg5 + "px) is less or equal to minimum auto-size text size (" + arg4 + "px)");
        }

        throw new IllegalArgumentException("Minimum auto-size text size (" + arg4 + v2);
    }
}

