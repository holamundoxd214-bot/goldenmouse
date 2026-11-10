package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint$FontMetricsInt;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build$VERSION;
import android.text.Editable;
import android.text.PrecomputedText$Params;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.TypedValue;
import android.view.ActionMode$Callback;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.ReplaceWith;
import androidx.core.text.PrecomputedTextCompat$Params$Builder;
import androidx.core.text.PrecomputedTextCompat$Params;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class TextViewCompat {
    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static DecimalFormatSymbols getInstance(Locale arg0) {
            return DecimalFormatSymbols.getInstance(arg0);
        }
    }

    class Api26Impl {
        private Api26Impl() {
            super();
        }

        static int getAutoSizeMaxTextSize(TextView arg0) {
            return arg0.getAutoSizeMaxTextSize();
        }

        static int getAutoSizeMinTextSize(TextView arg0) {
            return arg0.getAutoSizeMinTextSize();
        }

        static int getAutoSizeStepGranularity(TextView arg0) {
            return arg0.getAutoSizeStepGranularity();
        }

        static int[] getAutoSizeTextAvailableSizes(TextView arg0) {
            return arg0.getAutoSizeTextAvailableSizes();
        }

        static int getAutoSizeTextType(TextView arg0) {
            return arg0.getAutoSizeTextType();
        }

        static void setAutoSizeTextTypeUniformWithConfiguration(TextView arg0, int arg1, int arg2, int arg3, int arg4) {
            arg0.setAutoSizeTextTypeUniformWithConfiguration(arg1, arg2, arg3, arg4);
        }

        static void setAutoSizeTextTypeUniformWithPresetSizes(TextView arg0, int[] arg1, int arg2) {
            arg0.setAutoSizeTextTypeUniformWithPresetSizes(arg1, arg2);
        }

        static void setAutoSizeTextTypeWithDefaults(TextView arg0, int arg1) {
            arg0.setAutoSizeTextTypeWithDefaults(arg1);
        }
    }

    class Api28Impl {
        private Api28Impl() {
            super();
        }

        static CharSequence castToCharSequence(PrecomputedText arg0) {
            return arg0;
        }

        static String[] getDigitStrings(DecimalFormatSymbols arg0) {
            return arg0.getDigitStrings();
        }

        static PrecomputedText$Params getTextMetricsParams(TextView arg0) {
            return arg0.getTextMetricsParams();
        }

        static void setFirstBaselineToTopHeight(TextView arg0, int arg1) {
            arg0.setFirstBaselineToTopHeight(arg1);
        }
    }

    class Api34Impl {
        private Api34Impl() {
            super();
        }

        public static void setLineHeight(TextView arg0, int arg1, float arg2) {
            arg0.setLineHeight(arg1, arg2);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface AutoSizeTextType {
    }

    class OreoCallback implements ActionMode$Callback {
        private static final int MENU_ITEM_ORDER_PROCESS_TEXT_INTENT_ACTIONS_START = 100;
        private final ActionMode$Callback mCallback;
        private boolean mCanUseMenuBuilderReferences;
        private boolean mInitializedMenuBuilderReferences;
        private Class mMenuBuilderClass;
        private Method mMenuBuilderRemoveItemAtMethod;
        private final TextView mTextView;

        OreoCallback(ActionMode$Callback arg1, TextView arg2) {
            super();
            this.mCallback = arg1;
            this.mTextView = arg2;
            this.mInitializedMenuBuilderReferences = false;
        }

        private Intent createProcessTextIntent() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        private Intent createProcessTextIntentForResolveInfo(ResolveInfo arg2, TextView arg3) {
            return this.createProcessTextIntent().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", this.isEditable(arg3) ^ 1).setClassName(arg2.activityInfo.packageName, arg2.activityInfo.name);
        }

        private List getSupportedActivities(Context arg4, PackageManager arg5) {
            ArrayList v0 = new ArrayList();
            if(!(arg4 instanceof Activity)) {
            }
            else {
                Iterator v5 = arg5.queryIntentActivities(this.createProcessTextIntent(), 0).iterator();
                while(v5.hasNext()) {
                    Object v1 = v5.next();
                    if(!this.isSupportedActivity(((ResolveInfo)v1), arg4)) {
                        continue;
                    }

                    ((List)v0).add(v1);
                }
            }

            return ((List)v0);
        }

        ActionMode$Callback getWrappedCallback() {
            return this.mCallback;
        }

        private boolean isEditable(TextView arg1) {
            if(((arg1 instanceof Editable)) && (arg1.onCheckIsTextEditor()) && (arg1.isEnabled())) {
                return 1;
            }

            return 0;
        }

        private boolean isSupportedActivity(ResolveInfo arg3, Context arg4) {
            if(arg4.getPackageName().equals(arg3.activityInfo.packageName)) {
                return 1;
            }

            if(!arg3.activityInfo.exported) {
                return 0;
            }

            if(arg3.activityInfo.permission != null) {
                if(arg4.checkSelfPermission(arg3.activityInfo.permission) == 0) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        public boolean onActionItemClicked(ActionMode arg1, MenuItem arg2) {
            return this.mCallback.onActionItemClicked(arg1, arg2);
        }

        public boolean onCreateActionMode(ActionMode arg1, Menu arg2) {
            return this.mCallback.onCreateActionMode(arg1, arg2);
        }

        public void onDestroyActionMode(ActionMode arg1) {
            this.mCallback.onDestroyActionMode(arg1);
        }

        public boolean onPrepareActionMode(ActionMode arg1, Menu arg2) {
            this.recomputeProcessTextMenuItems(arg2);
            return this.mCallback.onPrepareActionMode(arg1, arg2);
        }

        private void recomputeProcessTextMenuItems(Menu arg9) {
            int v3_1;
            Context v0 = this.mTextView.getContext();
            PackageManager v1 = v0.getPackageManager();
            String v3 = "removeItemAt";
            if(this.mInitializedMenuBuilderReferences) {
                goto label_23;
            }

            this.mInitializedMenuBuilderReferences = true;
            try {
                Class v2 = Class.forName("com.android.internal.view.menu.MenuBuilder");
                this.mMenuBuilderClass = v2;
                this.mMenuBuilderRemoveItemAtMethod = v2.getDeclaredMethod(v3, Integer.TYPE);
                this.mCanUseMenuBuilderReferences = true;
            }
            catch(NoSuchMethodException ) {
                this.mMenuBuilderClass = null;
                this.mMenuBuilderRemoveItemAtMethod = null;
                this.mCanUseMenuBuilderReferences = false;
            }

            try {
            label_23:
                Method v2_1 = !this.mCanUseMenuBuilderReferences || !this.mMenuBuilderClass.isInstance(arg9) ? arg9.getClass().getDeclaredMethod(v3, Integer.TYPE) : this.mMenuBuilderRemoveItemAtMethod;
                v3_1 = arg9.size() - 1;
                while(true) {
                label_37:
                    if(v3_1 < 0) {
                        goto label_51;
                    }

                    MenuItem v6 = arg9.getItem(v3_1);
                    if(v6.getIntent() != null && ("android.intent.action.PROCESS_TEXT".equals(v6.getIntent().getAction()))) {
                        v2_1.invoke(arg9, Integer.valueOf(v3_1));
                    }

                    break;
                }
            }
            catch(InvocationTargetException ) {
                return;
            }

            --v3_1;
            goto label_37;
        label_51:
            List v0_1 = this.getSupportedActivities(v0, v1);
            int v2_2;
            for(v2_2 = 0; v2_2 < v0_1.size(); ++v2_2) {
                Object v3_2 = v0_1.get(v2_2);
                arg9.add(0, 0, v2_2 + 100, ((ResolveInfo)v3_2).loadLabel(v1)).setIntent(this.createProcessTextIntentForResolveInfo(((ResolveInfo)v3_2), this.mTextView)).setShowAsAction(1);
            }
        }
    }

    public static final int AUTO_SIZE_TEXT_TYPE_NONE = 0;
    public static final int AUTO_SIZE_TEXT_TYPE_UNIFORM = 1;

    private TextViewCompat() {
        super();
    }

    public static int getAutoSizeMaxTextSize(TextView arg2) {
        if(Build$VERSION.SDK_INT >= 27) {
            return Api26Impl.getAutoSizeMaxTextSize(arg2);
        }

        if((arg2 instanceof AutoSizeableTextView)) {
            return ((AutoSizeableTextView)arg2).getAutoSizeMaxTextSize();
        }

        return -1;
    }

    public static int getAutoSizeMinTextSize(TextView arg2) {
        if(Build$VERSION.SDK_INT >= 27) {
            return Api26Impl.getAutoSizeMinTextSize(arg2);
        }

        if((arg2 instanceof AutoSizeableTextView)) {
            return ((AutoSizeableTextView)arg2).getAutoSizeMinTextSize();
        }

        return -1;
    }

    public static int getAutoSizeStepGranularity(TextView arg2) {
        if(Build$VERSION.SDK_INT >= 27) {
            return Api26Impl.getAutoSizeStepGranularity(arg2);
        }

        if((arg2 instanceof AutoSizeableTextView)) {
            return ((AutoSizeableTextView)arg2).getAutoSizeStepGranularity();
        }

        return -1;
    }

    public static int[] getAutoSizeTextAvailableSizes(TextView arg2) {
        if(Build$VERSION.SDK_INT >= 27) {
            return Api26Impl.getAutoSizeTextAvailableSizes(arg2);
        }

        if((arg2 instanceof AutoSizeableTextView)) {
            return ((AutoSizeableTextView)arg2).getAutoSizeTextAvailableSizes();
        }

        return new int[0];
    }

    public static int getAutoSizeTextType(TextView arg2) {
        if(Build$VERSION.SDK_INT >= 27) {
            return Api26Impl.getAutoSizeTextType(arg2);
        }

        if((arg2 instanceof AutoSizeableTextView)) {
            return ((AutoSizeableTextView)arg2).getAutoSizeTextType();
        }

        return 0;
    }

    public static ColorStateList getCompoundDrawableTintList(TextView arg0) {
        Preconditions.checkNotNull(arg0);
        return arg0.getCompoundDrawableTintList();
    }

    public static PorterDuff$Mode getCompoundDrawableTintMode(TextView arg0) {
        Preconditions.checkNotNull(arg0);
        return arg0.getCompoundDrawableTintMode();
    }

    @ReplaceWith(expression="textView.getCompoundDrawablesRelative()") @Deprecated public static Drawable[] getCompoundDrawablesRelative(TextView arg0) {
        return arg0.getCompoundDrawablesRelative();
    }

    public static int getFirstBaselineToTopHeight(TextView arg1) {
        return arg1.getPaddingTop() - arg1.getPaint().getFontMetricsInt().top;
    }

    public static int getLastBaselineToBottomHeight(TextView arg1) {
        return arg1.getPaddingBottom() + arg1.getPaint().getFontMetricsInt().bottom;
    }

    @ReplaceWith(expression="textView.getMaxLines()") @Deprecated public static int getMaxLines(TextView arg0) {
        return arg0.getMaxLines();
    }

    @ReplaceWith(expression="textView.getMinLines()") @Deprecated public static int getMinLines(TextView arg0) {
        return arg0.getMinLines();
    }

    private static int getTextDirection(TextDirectionHeuristic arg2) {
        if(arg2 == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
            return 1;
        }

        if(arg2 == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }

        if(arg2 == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }

        if(arg2 == TextDirectionHeuristics.LTR) {
            return 3;
        }

        if(arg2 == TextDirectionHeuristics.RTL) {
            return 4;
        }

        if(arg2 == TextDirectionHeuristics.LOCALE) {
            return 5;
        }

        if(arg2 == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }

        if(arg2 == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
            return 7;
        }

        return 1;
    }

    private static TextDirectionHeuristic getTextDirectionHeuristic(TextView arg4) {
        if((arg4.getTransformationMethod() instanceof PasswordTransformationMethod)) {
            return TextDirectionHeuristics.LTR;
        }

        int v2 = 0;
        if(Build$VERSION.SDK_INT >= 28 && (arg4.getInputType() & 15) == 3) {
            int v4 = Character.getDirectionality(Api28Impl.getDigitStrings(Api24Impl.getInstance(arg4.getTextLocale()))[0].codePointAt(0));
            if(v4 != 1) {
                if(v4 == 2) {
                }
                else {
                    return TextDirectionHeuristics.LTR;
                }
            }

            return TextDirectionHeuristics.RTL;
        }

        if(arg4.getLayoutDirection() == 1) {
            v2 = 1;
        }

        switch(arg4.getTextDirection()) {
            case 2: {
                goto label_46;
            }
            case 3: {
                goto label_44;
            }
            case 4: {
                goto label_42;
            }
            case 5: {
                goto label_40;
            }
            case 6: {
                goto label_38;
            }
            case 7: {
                goto label_36;
            }
        }

        if(v2 != 0) {
            return TextDirectionHeuristics.FIRSTSTRONG_RTL;
        }

        return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    label_36:
        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
    label_38:
        return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    label_40:
        return TextDirectionHeuristics.LOCALE;
    label_42:
        return TextDirectionHeuristics.RTL;
    label_44:
        return TextDirectionHeuristics.LTR;
    label_46:
        return TextDirectionHeuristics.ANYRTL_LTR;
    }

    public static Params getTextMetricsParams(TextView arg3) {
        if(Build$VERSION.SDK_INT >= 28) {
            return new Params(Api28Impl.getTextMetricsParams(arg3));
        }

        Builder v0 = new Builder(new TextPaint(arg3.getPaint()));
        v0.setBreakStrategy(arg3.getBreakStrategy());
        v0.setHyphenationFrequency(arg3.getHyphenationFrequency());
        v0.setTextDirection(TextViewCompat.getTextDirectionHeuristic(arg3));
        return v0.build();
    }

    public static void setAutoSizeTextTypeUniformWithConfiguration(TextView arg2, int arg3, int arg4, int arg5, int arg6) throws IllegalArgumentException {
        if(Build$VERSION.SDK_INT >= 27) {
            Api26Impl.setAutoSizeTextTypeUniformWithConfiguration(arg2, arg3, arg4, arg5, arg6);
            return;
        }

        if((arg2 instanceof AutoSizeableTextView)) {
            ((AutoSizeableTextView)arg2).setAutoSizeTextTypeUniformWithConfiguration(arg3, arg4, arg5, arg6);
        }
    }

    public static void setAutoSizeTextTypeUniformWithPresetSizes(TextView arg2, int[] arg3, int arg4) throws IllegalArgumentException {
        if(Build$VERSION.SDK_INT >= 27) {
            Api26Impl.setAutoSizeTextTypeUniformWithPresetSizes(arg2, arg3, arg4);
            return;
        }

        if((arg2 instanceof AutoSizeableTextView)) {
            ((AutoSizeableTextView)arg2).setAutoSizeTextTypeUniformWithPresetSizes(arg3, arg4);
        }
    }

    public static void setAutoSizeTextTypeWithDefaults(TextView arg2, int arg3) {
        if(Build$VERSION.SDK_INT >= 27) {
            Api26Impl.setAutoSizeTextTypeWithDefaults(arg2, arg3);
            return;
        }

        if((arg2 instanceof AutoSizeableTextView)) {
            ((AutoSizeableTextView)arg2).setAutoSizeTextTypeWithDefaults(arg3);
        }
    }

    public static void setCompoundDrawableTintList(TextView arg0, ColorStateList arg1) {
        Preconditions.checkNotNull(arg0);
        arg0.setCompoundDrawableTintList(arg1);
    }

    public static void setCompoundDrawableTintMode(TextView arg0, PorterDuff$Mode arg1) {
        Preconditions.checkNotNull(arg0);
        arg0.setCompoundDrawableTintMode(arg1);
    }

    @ReplaceWith(expression="textView.setCompoundDrawablesRelative(start, top, end, bottom)") @Deprecated public static void setCompoundDrawablesRelative(TextView arg0, Drawable arg1, Drawable arg2, Drawable arg3, Drawable arg4) {
        arg0.setCompoundDrawablesRelative(arg1, arg2, arg3, arg4);
    }

    @ReplaceWith(expression="textView.setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom)") @Deprecated public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView arg0, int arg1, int arg2, int arg3, int arg4) {
        arg0.setCompoundDrawablesRelativeWithIntrinsicBounds(arg1, arg2, arg3, arg4);
    }

    @ReplaceWith(expression="textView.setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom)") @Deprecated public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView arg0, Drawable arg1, Drawable arg2, Drawable arg3, Drawable arg4) {
        arg0.setCompoundDrawablesRelativeWithIntrinsicBounds(arg1, arg2, arg3, arg4);
    }

    @ReplaceWith(expression="textView.setCustomSelectionActionModeCallback(callback)") @Deprecated public static void setCustomSelectionActionModeCallback(TextView arg0, ActionMode$Callback arg1) {
        arg0.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(arg0, arg1));
    }

    public static void setFirstBaselineToTopHeight(TextView arg3, int arg4) {
        Preconditions.checkArgumentNonnegative(arg4);
        if(Build$VERSION.SDK_INT >= 28) {
            Api28Impl.setFirstBaselineToTopHeight(arg3, arg4);
            return;
        }

        Paint$FontMetricsInt v0 = arg3.getPaint().getFontMetricsInt();
        int v0_1 = arg3.getIncludeFontPadding() ? v0.top : v0.ascent;
        if(arg4 > Math.abs(v0_1)) {
            arg3.setPadding(arg3.getPaddingLeft(), arg4 + v0_1, arg3.getPaddingRight(), arg3.getPaddingBottom());
        }
    }

    public static void setLastBaselineToBottomHeight(TextView arg3, int arg4) {
        Preconditions.checkArgumentNonnegative(arg4);
        Paint$FontMetricsInt v0 = arg3.getPaint().getFontMetricsInt();
        int v0_1 = arg3.getIncludeFontPadding() ? v0.bottom : v0.descent;
        if(arg4 > Math.abs(v0_1)) {
            arg3.setPadding(arg3.getPaddingLeft(), arg3.getPaddingTop(), arg3.getPaddingRight(), arg4 - v0_1);
        }
    }

    public static void setLineHeight(TextView arg2, int arg3) {
        Preconditions.checkArgumentNonnegative(arg3);
        int v0 = arg2.getPaint().getFontMetricsInt(null);
        if(arg3 != v0) {
            arg2.setLineSpacing(((float)(arg3 - v0)), 1f);
        }
    }

    public static void setLineHeight(TextView arg2, int arg3, float arg4) {
        if(Build$VERSION.SDK_INT >= 34) {
            Api34Impl.setLineHeight(arg2, arg3, arg4);
            return;
        }

        TextViewCompat.setLineHeight(arg2, Math.round(TypedValue.applyDimension(arg3, arg4, arg2.getResources().getDisplayMetrics())));
    }

    public static void setPrecomputedText(TextView arg2, PrecomputedTextCompat arg3) {
        if(Build$VERSION.SDK_INT >= 29) {
            arg2.setText(Api28Impl.castToCharSequence(arg3.getPrecomputedText()));
            return;
        }

        if(TextViewCompat.getTextMetricsParams(arg2).equalsWithoutTextDirection(arg3.getParams())) {
            arg2.setText(((CharSequence)arg3));
            return;
        }

        throw new IllegalArgumentException("Given text can not be applied to TextView.");
    }

    public static void setTextAppearance(TextView arg0, int arg1) {
        arg0.setTextAppearance(arg1);
    }

    public static void setTextMetricsParams(TextView arg2, Params arg3) {
        arg2.setTextDirection(TextViewCompat.getTextDirection(arg3.getTextDirection()));
        arg2.getPaint().set(arg3.getTextPaint());
        arg2.setBreakStrategy(arg3.getBreakStrategy());
        arg2.setHyphenationFrequency(arg3.getHyphenationFrequency());
    }

    public static ActionMode$Callback unwrapCustomSelectionActionModeCallback(ActionMode$Callback arg1) {
        if((arg1 instanceof OreoCallback)) {
            arg1 = ((OreoCallback)arg1).getWrappedCallback();
        }

        return arg1;
    }

    public static ActionMode$Callback wrapCustomSelectionActionModeCallback(TextView arg2, ActionMode$Callback arg3) {
        if(Build$VERSION.SDK_INT <= 27 && !(arg3 instanceof OreoCallback)) {
            if(arg3 == null) {
            }
            else {
                return new OreoCallback(arg3, arg2);
            }
        }

        return arg3;
    }
}

