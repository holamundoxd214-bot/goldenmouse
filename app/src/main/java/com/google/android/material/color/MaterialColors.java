package com.google.android.material.color;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R$attr;
import com.google.android.material.color.utilities.Blend;
import com.google.android.material.color.utilities.Hct;
import com.google.android.material.resources.MaterialAttributes;

public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;
    private static final int CHROMA_NEUTRAL = 6;
    private static final int TONE_ACCENT_CONTAINER_DARK = 30;
    private static final int TONE_ACCENT_CONTAINER_LIGHT = 90;
    private static final int TONE_ACCENT_DARK = 80;
    private static final int TONE_ACCENT_LIGHT = 40;
    private static final int TONE_ON_ACCENT_CONTAINER_DARK = 90;
    private static final int TONE_ON_ACCENT_CONTAINER_LIGHT = 10;
    private static final int TONE_ON_ACCENT_DARK = 20;
    private static final int TONE_ON_ACCENT_LIGHT = 100;
    private static final int TONE_SURFACE_CONTAINER_DARK = 12;
    private static final int TONE_SURFACE_CONTAINER_HIGH_DARK = 17;
    private static final int TONE_SURFACE_CONTAINER_HIGH_LIGHT = 92;
    private static final int TONE_SURFACE_CONTAINER_LIGHT = 94;

    private MaterialColors() {
        super();
    }

    public static int compositeARGBWithAlpha(int arg1, int arg2) {
        return ColorUtils.setAlphaComponent(arg1, Color.alpha(arg1) * arg2 / 0xFF);
    }

    public static int getColor(Context arg0, int arg1, String arg2) {
        return MaterialColors.resolveColor(arg0, MaterialAttributes.resolveTypedValueOrThrow(arg0, arg1, arg2));
    }

    public static int getColor(View arg1, int arg2) {
        return MaterialColors.resolveColor(arg1.getContext(), MaterialAttributes.resolveTypedValueOrThrow(arg1, arg2));
    }

    public static int getColor(Context arg0, int arg1, int arg2) {
        Integer v0 = MaterialColors.getColorOrNull(arg0, arg1);
        if(v0 != null) {
            return v0.intValue();
        }

        return arg2;
    }

    public static int getColor(View arg0, int arg1, int arg2) {
        return MaterialColors.getColor(arg0.getContext(), arg1, arg2);
    }

    public static Integer getColorOrNull(Context arg0, int arg1) {
        TypedValue v1 = MaterialAttributes.resolve(arg0, arg1);
        if(v1 != null) {
            return Integer.valueOf(MaterialColors.resolveColor(arg0, v1));
        }

        return null;
    }

    private static int getColorRole(int arg2, int arg3) {
        Hct v2 = Hct.fromInt(arg2);
        v2.setTone(((double)arg3));
        return v2.toInt();
    }

    private static int getColorRole(int arg0, int arg1, int arg2) {
        Hct v0 = Hct.fromInt(MaterialColors.getColorRole(arg0, arg1));
        v0.setChroma(((double)arg2));
        return v0.toInt();
    }

    public static ColorRoles getColorRoles(int arg4, boolean arg5) {
        int v0 = 90;
        if(arg5) {
            return new ColorRoles(MaterialColors.getColorRole(arg4, 40), MaterialColors.getColorRole(arg4, 100), MaterialColors.getColorRole(arg4, v0), MaterialColors.getColorRole(arg4, 10));
        }

        return new ColorRoles(MaterialColors.getColorRole(arg4, 80), MaterialColors.getColorRole(arg4, 20), MaterialColors.getColorRole(arg4, 30), MaterialColors.getColorRole(arg4, v0));
    }

    public static ColorRoles getColorRoles(Context arg0, int arg1) {
        return MaterialColors.getColorRoles(arg1, MaterialColors.isLightTheme(arg0));
    }

    public static ColorStateList getColorStateList(Context arg0, int arg1, ColorStateList arg2) {
        TypedValue v1 = MaterialAttributes.resolve(arg0, arg1);
        ColorStateList v0 = v1 != null ? MaterialColors.resolveColorStateList(arg0, v1) : null;
        if(v0 == null) {
            return arg2;
        }

        return v0;
    }

    public static ColorStateList getColorStateListOrNull(Context arg2, int arg3) {
        TypedValue v3 = MaterialAttributes.resolve(arg2, arg3);
        ColorStateList v0 = null;
        if(v3 == null) {
            return v0;
        }

        if(v3.resourceId != 0) {
            return ContextCompat.getColorStateList(arg2, v3.resourceId);
        }

        if(v3.data != 0) {
            return ColorStateList.valueOf(v3.data);
        }

        return v0;
    }

    public static int getSurfaceContainerFromSeed(Context arg1, int arg2) {
        int v1 = MaterialColors.isLightTheme(arg1) ? 94 : 12;
        return MaterialColors.getColorRole(arg2, v1, 6);
    }

    public static int getSurfaceContainerHighFromSeed(Context arg1, int arg2) {
        int v1 = MaterialColors.isLightTheme(arg1) ? 92 : 17;
        return MaterialColors.getColorRole(arg2, v1, 6);
    }

    public static int harmonize(int arg0, int arg1) {
        return Blend.harmonize(arg0, arg1);
    }

    public static int harmonizeWithPrimary(Context arg2, int arg3) {
        return MaterialColors.harmonize(arg3, MaterialColors.getColor(arg2, attr.colorPrimary, MaterialColors.class.getCanonicalName()));
    }

    public static boolean isColorLight(int arg4) {
        if(arg4 != 0 && ColorUtils.calculateLuminance(arg4) > 0.5) {
            return 1;
        }

        return 0;
    }

    static boolean isLightTheme(Context arg2) {
        return MaterialAttributes.resolveBoolean(arg2, attr.isLightTheme, true);
    }

    public static int layer(int arg1, int arg2, float arg3) {
        return MaterialColors.layer(arg1, ColorUtils.setAlphaComponent(arg2, Math.round((((float)Color.alpha(arg2))) * arg3)));
    }

    public static int layer(int arg0, int arg1) {
        return ColorUtils.compositeColors(arg1, arg0);
    }

    public static int layer(View arg1, int arg2, int arg3) {
        return MaterialColors.layer(arg1, arg2, arg3, 1f);
    }

    public static int layer(View arg0, int arg1, int arg2, float arg3) {
        return MaterialColors.layer(MaterialColors.getColor(arg0, arg1), MaterialColors.getColor(arg0, arg2), arg3);
    }

    private static int resolveColor(Context arg1, TypedValue arg2) {
        if(arg2.resourceId != 0) {
            return ContextCompat.getColor(arg1, arg2.resourceId);
        }

        return arg2.data;
    }

    private static ColorStateList resolveColorStateList(Context arg1, TypedValue arg2) {
        if(arg2.resourceId != 0) {
            return ContextCompat.getColorStateList(arg1, arg2.resourceId);
        }

        return ColorStateList.valueOf(arg2.data);
    }
}

