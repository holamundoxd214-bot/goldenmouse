package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import com.google.android.material.resources.MaterialAttributes;

public final class ThemeEnforcement {
    private static final int[] APPCOMPAT_CHECK_ATTRS = null;
    private static final String APPCOMPAT_THEME_NAME = "Theme.AppCompat";
    private static final int[] MATERIAL_CHECK_ATTRS = null;
    private static final String MATERIAL_THEME_NAME = "Theme.MaterialComponents";

    static {
        ThemeEnforcement.APPCOMPAT_CHECK_ATTRS = new int[]{attr.colorPrimary};
        ThemeEnforcement.MATERIAL_CHECK_ATTRS = new int[]{attr.colorPrimaryVariant};
    }

    private ThemeEnforcement() {
        super();
    }

    public static void checkAppCompatTheme(Context arg2) {
        ThemeEnforcement.checkTheme(arg2, ThemeEnforcement.APPCOMPAT_CHECK_ATTRS, "Theme.AppCompat");
    }

    private static void checkCompatibleTheme(Context arg1, AttributeSet arg2, int arg3, int arg4) {
        TypedArray v2 = arg1.obtainStyledAttributes(arg2, styleable.ThemeEnforcement, arg3, arg4);
        boolean v3 = v2.getBoolean(styleable.ThemeEnforcement_enforceMaterialTheme, false);
        v2.recycle();
        if(v3) {
            TypedValue v2_1 = new TypedValue();
            if(arg1.getTheme().resolveAttribute(attr.isMaterialTheme, v2_1, true)) {
                if(v2_1.type != 18) {
                }
                else if(v2_1.data == 0) {
                    goto label_19;
                }

                goto label_20;
            }

        label_19:
            ThemeEnforcement.checkMaterialTheme(arg1);
        }

    label_20:
        ThemeEnforcement.checkAppCompatTheme(arg1);
    }

    public static void checkMaterialTheme(Context arg2) {
        ThemeEnforcement.checkTheme(arg2, ThemeEnforcement.MATERIAL_CHECK_ATTRS, "Theme.MaterialComponents");
    }

    private static void checkTextAppearance(Context arg3, AttributeSet arg4, int[] arg5, int arg6, int arg7, int[] arg8) {
        boolean v3;
        TypedArray v0 = arg3.obtainStyledAttributes(arg4, styleable.ThemeEnforcement, arg6, arg7);
        boolean v2 = false;
        if(!v0.getBoolean(styleable.ThemeEnforcement_enforceTextAppearance, false)) {
            v0.recycle();
            return;
        }

        if(arg8 == null || arg8.length == 0) {
            if(v0.getResourceId(styleable.ThemeEnforcement_android_textAppearance, -1) != -1) {
                v2 = true;
            }

            v3 = v2;
        }
        else {
            v3 = ThemeEnforcement.isCustomTextAppearanceValid(arg3, arg4, arg5, arg6, arg7, arg8);
        }

        v0.recycle();
        if(v3) {
            return;
        }

        throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
    }

    private static void checkTheme(Context arg1, int[] arg2, String arg3) {
        if(ThemeEnforcement.isTheme(arg1, arg2)) {
            return;
        }

        throw new IllegalArgumentException("The style on this component requires your app theme to be " + arg3 + " (or a descendant).");
    }

    public static boolean isAppCompatTheme(Context arg1) {
        return ThemeEnforcement.isTheme(arg1, ThemeEnforcement.APPCOMPAT_CHECK_ATTRS);
    }

    private static boolean isCustomTextAppearanceValid(Context arg1, AttributeSet arg2, int[] arg3, int arg4, int arg5, int[] arg6) {
        TypedArray v1 = arg1.obtainStyledAttributes(arg2, arg3, arg4, arg5);
        int v2 = arg6.length;
        for(arg4 = 0; arg4 < v2; ++arg4) {
            if(v1.getResourceId(arg6[arg4], -1) == -1) {
                v1.recycle();
                return 0;
            }
        }

        v1.recycle();
        return 1;
    }

    public static boolean isMaterial3Theme(Context arg2) {
        return MaterialAttributes.resolveBoolean(arg2, attr.isMaterial3Theme, false);
    }

    public static boolean isMaterialTheme(Context arg1) {
        return ThemeEnforcement.isTheme(arg1, ThemeEnforcement.MATERIAL_CHECK_ATTRS);
    }

    private static boolean isTheme(Context arg3, int[] arg4) {
        TypedArray v3 = arg3.obtainStyledAttributes(arg4);
        int v1;
        for(v1 = 0; v1 < arg4.length; ++v1) {
            if(!v3.hasValue(v1)) {
                v3.recycle();
                return 0;
            }
        }

        v3.recycle();
        return 1;
    }

    public static TypedArray obtainStyledAttributes(Context arg0, AttributeSet arg1, int[] arg2, int arg3, int arg4, int[] arg5) {
        ThemeEnforcement.checkCompatibleTheme(arg0, arg1, arg3, arg4);
        ThemeEnforcement.checkTextAppearance(arg0, arg1, arg2, arg3, arg4, arg5);
        return arg0.obtainStyledAttributes(arg1, arg2, arg3, arg4);
    }

    public static TintTypedArray obtainTintedStyledAttributes(Context arg0, AttributeSet arg1, int[] arg2, int arg3, int arg4, int[] arg5) {
        ThemeEnforcement.checkCompatibleTheme(arg0, arg1, arg3, arg4);
        ThemeEnforcement.checkTextAppearance(arg0, arg1, arg2, arg3, arg4, arg5);
        return TintTypedArray.obtainStyledAttributes(arg0, arg1, arg2, arg3, arg4);
    }
}

