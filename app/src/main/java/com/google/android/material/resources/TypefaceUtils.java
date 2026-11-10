package com.google.android.material.resources;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build$VERSION;
import androidx.core.math.MathUtils;

public class TypefaceUtils {
    private TypefaceUtils() {
        super();
    }

    public static Typeface maybeCopyWithFontWeightAdjustment(Configuration arg2, Typeface arg3) {
        if(Build$VERSION.SDK_INT >= 0x1F && arg2.fontWeightAdjustment != 0x7FFFFFFF && arg2.fontWeightAdjustment != 0 && arg3 != null) {
            return Typeface.create(arg3, MathUtils.clamp(arg3.getWeight() + arg2.fontWeightAdjustment, 1, 1000), arg3.isItalic());
        }

        return null;
    }

    public static Typeface maybeCopyWithFontWeightAdjustment(Context arg0, Typeface arg1) {
        return TypefaceUtils.maybeCopyWithFontWeightAdjustment(arg0.getResources().getConfiguration(), arg1);
    }
}

