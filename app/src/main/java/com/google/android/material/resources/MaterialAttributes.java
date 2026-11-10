package com.google.android.material.resources;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;

public class MaterialAttributes {
    public MaterialAttributes() {
        super();
    }

    public static TypedValue resolve(Context arg2, int arg3) {
        TypedValue v0 = new TypedValue();
        if(arg2.getTheme().resolveAttribute(arg3, v0, true)) {
            return v0;
        }

        return null;
    }

    public static boolean resolveBoolean(Context arg1, int arg2, boolean arg3) {
        TypedValue v1 = MaterialAttributes.resolve(arg1, arg2);
        if(v1 != null && v1.type == 18) {
            if(v1.data != 0) {
                return 1;
            }
            else {
                return 0;
            }
        }

        return arg3;
    }

    public static boolean resolveBooleanOrThrow(Context arg0, int arg1, String arg2) {
        if(MaterialAttributes.resolveOrThrow(arg0, arg1, arg2) != 0) {
            return 1;
        }

        return 0;
    }

    public static int resolveDimension(Context arg2, int arg3, int arg4) {
        TypedValue v3 = MaterialAttributes.resolve(arg2, arg3);
        float v2 = v3 == null || v3.type != 5 ? arg2.getResources().getDimension(arg4) : v3.getDimension(arg2.getResources().getDisplayMetrics());
        return ((int)v2);
    }

    public static int resolveInteger(Context arg1, int arg2, int arg3) {
        TypedValue v1 = MaterialAttributes.resolve(arg1, arg2);
        if(v1 != null && v1.type == 16) {
            return v1.data;
        }

        return arg3;
    }

    public static int resolveMinimumAccessibleTouchTarget(Context arg2) {
        return MaterialAttributes.resolveDimension(arg2, attr.minTouchTargetSize, dimen.mtrl_min_touch_target_size);
    }

    public static int resolveOrThrow(Context arg0, int arg1, String arg2) {
        return MaterialAttributes.resolveTypedValueOrThrow(arg0, arg1, arg2).data;
    }

    public static int resolveOrThrow(View arg0, int arg1) {
        return MaterialAttributes.resolveTypedValueOrThrow(arg0, arg1).data;
    }

    public static TypedValue resolveTypedValueOrThrow(Context arg1, int arg2, String arg3) {
        TypedValue v0 = MaterialAttributes.resolve(arg1, arg2);
        if(v0 != null) {
            return v0;
        }

        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", arg3, arg1.getResources().getResourceName(arg2)));
    }

    public static TypedValue resolveTypedValueOrThrow(View arg1, int arg2) {
        return MaterialAttributes.resolveTypedValueOrThrow(arg1.getContext(), arg2, arg1.getClass().getCanonicalName());
    }
}

