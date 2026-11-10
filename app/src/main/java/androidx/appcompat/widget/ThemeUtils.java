package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.core.graphics.ColorUtils;

public class ThemeUtils {
    static final int[] ACTIVATED_STATE_SET = null;
    static final int[] CHECKED_STATE_SET = null;
    static final int[] DISABLED_STATE_SET = null;
    static final int[] EMPTY_STATE_SET = null;
    static final int[] FOCUSED_STATE_SET = null;
    static final int[] NOT_PRESSED_OR_FOCUSED_STATE_SET = null;
    static final int[] PRESSED_STATE_SET = null;
    static final int[] SELECTED_STATE_SET = null;
    private static final String TAG = "ThemeUtils";
    private static final int[] TEMP_ARRAY;
    private static final ThreadLocal TL_TYPED_VALUE;

    static {
        ThemeUtils.TL_TYPED_VALUE = new ThreadLocal();
        ThemeUtils.DISABLED_STATE_SET = new int[]{0xFEFEFF62};
        ThemeUtils.FOCUSED_STATE_SET = new int[]{0x101009C};
        ThemeUtils.ACTIVATED_STATE_SET = new int[]{0x10102FE};
        ThemeUtils.PRESSED_STATE_SET = new int[]{0x10100A7};
        ThemeUtils.CHECKED_STATE_SET = new int[]{0x10100A0};
        ThemeUtils.SELECTED_STATE_SET = new int[]{0x10100A1};
        ThemeUtils.NOT_PRESSED_OR_FOCUSED_STATE_SET = new int[]{0xFEFEFF59, 0xFEFEFF64};
        ThemeUtils.EMPTY_STATE_SET = new int[0];
        ThemeUtils.TEMP_ARRAY = new int[1];
    }

    private ThemeUtils() {
        super();
    }

    public static void checkAppCompatTheme(View arg3, Context arg4) {
        String v0 = "View ";
        TypedArray v4 = arg4.obtainStyledAttributes(styleable.AppCompatTheme);
        try {
            if(!v4.hasValue(styleable.AppCompatTheme_windowActionBar)) {
                Log.e("ThemeUtils", v0 + arg3.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        }
        catch(Throwable v3) {
            v4.recycle();
            throw v3;
        }

        v4.recycle();
    }

    public static ColorStateList createDisabledStateList(int arg4, int arg5) {
        int[][] v1 = new int[2][];
        int[] v0 = new int[2];
        v1[0] = ThemeUtils.DISABLED_STATE_SET;
        v0[0] = arg5;
        v1[1] = ThemeUtils.EMPTY_STATE_SET;
        v0[1] = arg4;
        return new ColorStateList(v1, v0);
    }

    public static int getDisabledThemeAttrColor(Context arg4, int arg5) {
        ColorStateList v0 = ThemeUtils.getThemeAttrColorStateList(arg4, arg5);
        if(v0 != null && (v0.isStateful())) {
            return v0.getColorForState(ThemeUtils.DISABLED_STATE_SET, v0.getDefaultColor());
        }

        TypedValue v0_1 = ThemeUtils.getTypedValue();
        arg4.getTheme().resolveAttribute(0x1010033, v0_1, true);
        return ThemeUtils.getThemeAttrColor(arg4, arg5, v0_1.getFloat());
    }

    public static int getThemeAttrColor(Context arg2, int arg3) {
        int[] v0 = ThemeUtils.TEMP_ARRAY;
        v0[0] = arg3;
        TintTypedArray v2 = TintTypedArray.obtainStyledAttributes(arg2, null, v0);
        try {
            arg3 = v2.getColor(0, 0);
        }
        catch(Throwable v3) {
            v2.recycle();
            throw v3;
        }

        v2.recycle();
        return arg3;
    }

    static int getThemeAttrColor(Context arg0, int arg1, float arg2) {
        int v0 = ThemeUtils.getThemeAttrColor(arg0, arg1);
        return ColorUtils.setAlphaComponent(v0, Math.round((((float)Color.alpha(v0))) * arg2));
    }

    public static ColorStateList getThemeAttrColorStateList(Context arg2, int arg3) {
        ColorStateList v3_1;
        int[] v0 = ThemeUtils.TEMP_ARRAY;
        v0[0] = arg3;
        TintTypedArray v2 = TintTypedArray.obtainStyledAttributes(arg2, null, v0);
        try {
            v3_1 = v2.getColorStateList(0);
        }
        catch(Throwable v3) {
            v2.recycle();
            throw v3;
        }

        v2.recycle();
        return v3_1;
    }

    private static TypedValue getTypedValue() {
        ThreadLocal v0 = ThemeUtils.TL_TYPED_VALUE;
        Object v1 = v0.get();
        if(v1 == null) {
            TypedValue v1_1 = new TypedValue();
            v0.set(v1_1);
        }

        return ((TypedValue)v1);
    }
}

