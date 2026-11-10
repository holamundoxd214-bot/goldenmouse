package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R$styleable;

public class MaterialResources {
    private static final float FONT_SCALE_1_3 = 1.3f;
    private static final float FONT_SCALE_2_0 = 2f;

    private MaterialResources() {
        super();
    }

    public static ColorStateList getColorStateList(Context arg1, TypedArray arg2, int arg3) {
        if(arg2.hasValue(arg3)) {
            int v0 = arg2.getResourceId(arg3, 0);
            if(v0 != 0) {
                ColorStateList v1 = AppCompatResources.getColorStateList(arg1, v0);
                if(v1 != null) {
                    return v1;
                }
            }
        }

        return arg2.getColorStateList(arg3);
    }

    public static ColorStateList getColorStateList(Context arg1, TintTypedArray arg2, int arg3) {
        if(arg2.hasValue(arg3)) {
            int v0 = arg2.getResourceId(arg3, 0);
            if(v0 != 0) {
                ColorStateList v1 = AppCompatResources.getColorStateList(arg1, v0);
                if(v1 != null) {
                    return v1;
                }
            }
        }

        return arg2.getColorStateList(arg3);
    }

    private static int getComplexUnit(TypedValue arg0) {
        return arg0.getComplexUnit();
    }

    public static int getDimensionPixelSize(Context arg3, TypedArray arg4, int arg5, int arg6) {
        TypedValue v0 = new TypedValue();
        if(arg4.getValue(arg5, v0)) {
            if(v0.type != 2) {
            }
            else {
                TypedArray v3 = arg3.getTheme().obtainStyledAttributes(new int[]{v0.data});
                int v4 = v3.getDimensionPixelSize(0, arg6);
                v3.recycle();
                return v4;
            }
        }

        return arg4.getDimensionPixelSize(arg5, arg6);
    }

    public static Drawable getDrawable(Context arg1, TypedArray arg2, int arg3) {
        if(arg2.hasValue(arg3)) {
            int v0 = arg2.getResourceId(arg3, 0);
            if(v0 != 0) {
                Drawable v1 = AppCompatResources.getDrawable(arg1, v0);
                if(v1 != null) {
                    return v1;
                }
            }
        }

        return arg2.getDrawable(arg3);
    }

    public static float getFontScale(Context arg0) {
        return arg0.getResources().getConfiguration().fontScale;
    }

    static int getIndexWithValue(TypedArray arg0, int arg1, int arg2) {
        if(arg0.hasValue(arg1)) {
            return arg1;
        }

        return arg2;
    }

    public static TextAppearance getTextAppearance(Context arg1, TypedArray arg2, int arg3) {
        if(arg2.hasValue(arg3)) {
            int v2 = arg2.getResourceId(arg3, 0);
            if(v2 != 0) {
                return new TextAppearance(arg1, v2);
            }
        }

        return null;
    }

    public static int getUnscaledTextSize(Context arg2, int arg3, int arg4) {
        TypedValue v0;
        if(arg3 == 0) {
        }
        else {
            TypedArray v3 = arg2.obtainStyledAttributes(arg3, styleable.TextAppearance);
            v0 = new TypedValue();
            boolean v1 = v3.getValue(styleable.TextAppearance_android_textSize, v0);
            v3.recycle();
            if(!v1) {
                return arg4;
            }

            goto label_11;
        }

        return arg4;
    label_11:
        if(MaterialResources.getComplexUnit(v0) == 2) {
            return Math.round(TypedValue.complexToFloat(v0.data) * arg2.getResources().getDisplayMetrics().density);
        }

        return TypedValue.complexToDimensionPixelSize(v0.data, arg2.getResources().getDisplayMetrics());
    }

    public static boolean isFontScaleAtLeast1_3(Context arg1) {
        if(arg1.getResources().getConfiguration().fontScale >= 1.3f) {
            return 1;
        }

        return 0;
    }

    public static boolean isFontScaleAtLeast2_0(Context arg1) {
        if(arg1.getResources().getConfiguration().fontScale >= 2f) {
            return 1;
        }

        return 0;
    }
}

