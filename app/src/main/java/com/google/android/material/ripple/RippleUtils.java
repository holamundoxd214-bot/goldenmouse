package com.google.android.material.ripple;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build$VERSION;
import android.util.Log;
import android.util.StateSet;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R$attr;
import com.google.android.material.color.MaterialColors;

public class RippleUtils {
    class RippleUtilsLollipop {
        private RippleUtilsLollipop() {
            super();
        }

        static Drawable access$000(Context arg0, int arg1) {
            return RippleUtilsLollipop.createOvalRipple(arg0, arg1);
        }

        private static Drawable createOvalRipple(Context arg6, int arg7) {
            GradientDrawable v1 = new GradientDrawable();
            v1.setColor(-1);
            v1.setShape(1);
            return new RippleDrawable(MaterialColors.getColorStateList(arg6, attr.colorControlHighlight, ColorStateList.valueOf(0)), null, new InsetDrawable(((Drawable)v1), arg7, arg7, arg7, arg7));
        }
    }

    private static final int[] ENABLED_PRESSED_STATE_SET = null;
    private static final int[] FOCUSED_STATE_SET = null;
    private static final int[] HOVERED_FOCUSED_STATE_SET = null;
    private static final int[] HOVERED_STATE_SET = null;
    static final String LOG_TAG = null;
    private static final int[] PRESSED_STATE_SET = null;
    private static final int[] SELECTED_FOCUSED_STATE_SET = null;
    private static final int[] SELECTED_HOVERED_FOCUSED_STATE_SET = null;
    private static final int[] SELECTED_HOVERED_STATE_SET = null;
    private static final int[] SELECTED_PRESSED_STATE_SET = null;
    private static final int[] SELECTED_STATE_SET = null;
    static final String TRANSPARENT_DEFAULT_COLOR_WARNING = "Use a non-transparent color for the default color as it will be used to finish ripple animations.";
    public static final boolean USE_FRAMEWORK_RIPPLE;

    static {
        RippleUtils.USE_FRAMEWORK_RIPPLE = true;
        RippleUtils.PRESSED_STATE_SET = new int[]{0x10100A7};
        RippleUtils.HOVERED_FOCUSED_STATE_SET = new int[]{0x1010367, 0x101009C};
        RippleUtils.FOCUSED_STATE_SET = new int[]{0x101009C};
        RippleUtils.HOVERED_STATE_SET = new int[]{0x1010367};
        RippleUtils.SELECTED_PRESSED_STATE_SET = new int[]{0x10100A1, 0x10100A7};
        RippleUtils.SELECTED_HOVERED_FOCUSED_STATE_SET = new int[]{0x10100A1, 0x1010367, 0x101009C};
        RippleUtils.SELECTED_FOCUSED_STATE_SET = new int[]{0x10100A1, 0x101009C};
        RippleUtils.SELECTED_HOVERED_STATE_SET = new int[]{0x10100A1, 0x1010367};
        RippleUtils.SELECTED_STATE_SET = new int[]{0x10100A1};
        RippleUtils.ENABLED_PRESSED_STATE_SET = new int[]{0x101009E, 0x10100A7};
        RippleUtils.LOG_TAG = "RippleUtils";
    }

    private RippleUtils() {
        super();
    }

    public static ColorStateList convertToRippleDrawableColor(ColorStateList arg7) {
        int[] v1_1;
        int v1 = 3;
        int v2 = 2;
        if(RippleUtils.USE_FRAMEWORK_RIPPLE) {
            int[][] v0 = new int[v1][];
            v1_1 = new int[v1];
            v0[0] = RippleUtils.SELECTED_STATE_SET;
            v1_1[0] = RippleUtils.getColorForState(arg7, RippleUtils.SELECTED_PRESSED_STATE_SET);
            int[] v4 = RippleUtils.FOCUSED_STATE_SET;
            v0[1] = v4;
            v1_1[1] = RippleUtils.getColorForState(arg7, v4);
            v0[v2] = StateSet.NOTHING;
            v1_1[v2] = RippleUtils.getColorForState(arg7, RippleUtils.PRESSED_STATE_SET);
            return new ColorStateList(v0, v1_1);
        }

        int[][] v5 = new int[10][];
        int[] v0_1 = new int[10];
        int[] v6 = RippleUtils.SELECTED_PRESSED_STATE_SET;
        v5[0] = v6;
        v0_1[0] = RippleUtils.getColorForState(arg7, v6);
        v6 = RippleUtils.SELECTED_HOVERED_FOCUSED_STATE_SET;
        v5[1] = v6;
        v0_1[1] = RippleUtils.getColorForState(arg7, v6);
        int[] v3 = RippleUtils.SELECTED_FOCUSED_STATE_SET;
        v5[v2] = v3;
        v0_1[v2] = RippleUtils.getColorForState(arg7, v3);
        int[] v2_1 = RippleUtils.SELECTED_HOVERED_STATE_SET;
        v5[v1] = v2_1;
        v0_1[v1] = RippleUtils.getColorForState(arg7, v2_1);
        v5[4] = RippleUtils.SELECTED_STATE_SET;
        v0_1[4] = 0;
        v1_1 = RippleUtils.PRESSED_STATE_SET;
        v5[5] = v1_1;
        v0_1[5] = RippleUtils.getColorForState(arg7, v1_1);
        v1_1 = RippleUtils.HOVERED_FOCUSED_STATE_SET;
        v5[6] = v1_1;
        v0_1[6] = RippleUtils.getColorForState(arg7, v1_1);
        v1_1 = RippleUtils.FOCUSED_STATE_SET;
        v5[7] = v1_1;
        v0_1[7] = RippleUtils.getColorForState(arg7, v1_1);
        v1_1 = RippleUtils.HOVERED_STATE_SET;
        v5[8] = v1_1;
        v0_1[8] = RippleUtils.getColorForState(arg7, v1_1);
        v5[9] = StateSet.NOTHING;
        v0_1[9] = 0;
        return new ColorStateList(v5, v0_1);
    }

    public static Drawable createOvalRippleLollipop(Context arg0, int arg1) {
        return RippleUtilsLollipop.access$000(arg0, arg1);
    }

    private static int doubleAlpha(int arg2) {
        return ColorUtils.setAlphaComponent(arg2, Math.min(Color.alpha(arg2) * 2, 0xFF));
    }

    private static int getColorForState(ColorStateList arg1, int[] arg2) {
        int v1 = arg1 != null ? arg1.getColorForState(arg2, arg1.getDefaultColor()) : 0;
        if(RippleUtils.USE_FRAMEWORK_RIPPLE) {
            v1 = RippleUtils.doubleAlpha(v1);
        }

        return v1;
    }

    public static ColorStateList sanitizeRippleDrawableColor(ColorStateList arg3) {
        if(arg3 != null) {
            if(Build$VERSION.SDK_INT <= 27 && Color.alpha(arg3.getDefaultColor()) == 0 && Color.alpha(arg3.getColorForState(RippleUtils.ENABLED_PRESSED_STATE_SET, 0)) != 0) {
                Log.w(RippleUtils.LOG_TAG, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
            }

            return arg3;
        }

        return ColorStateList.valueOf(0);
    }

    public static boolean shouldDrawRippleCompat(int[] arg8) {
        int v0 = arg8.length;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        while(v2 < v0) {
            int v6 = arg8[v2];
            if(v6 == 0x101009E) {
                v3 = 1;
            }
            else {
                if(v6 != 0x101009C) {
                    if(v6 == 0x10100A7) {
                    }
                    else if(v6 == 0x1010367) {
                    }
                    else {
                        goto label_22;
                    }
                }

                v4 = 1;
            }

        label_22:
            ++v2;
        }

        if(v3 != 0 && v4 != 0) {
            return 1;
        }

        return 0;
    }
}

