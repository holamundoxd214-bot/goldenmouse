package com.google.android.material.motion;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import androidx.core.graphics.PathParser;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.google.android.material.resources.MaterialAttributes;

public class MotionUtils {
    private static final String EASING_TYPE_CUBIC_BEZIER = "cubic-bezier";
    private static final String EASING_TYPE_FORMAT_END = ")";
    private static final String EASING_TYPE_FORMAT_START = "(";
    private static final String EASING_TYPE_PATH = "path";

    private MotionUtils() {
        super();
    }

    private static float getLegacyControlPoint(String[] arg2, int arg3) {
        float v2 = Float.parseFloat(arg2[arg3]);
        if(v2 >= 0f && v2 <= 1f) {
            return v2;
        }

        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + v2);
    }

    private static String getLegacyEasingContent(String arg2, String arg3) {
        return arg2.substring(arg3.length() + "(".length(), arg2.length() - ")".length());
    }

    private static TimeInterpolator getLegacyThemeInterpolator(String arg4) {
        String v0 = "cubic-bezier";
        if(MotionUtils.isLegacyEasingType(arg4, v0)) {
            String[] v4 = MotionUtils.getLegacyEasingContent(arg4, v0).split(",");
            if(v4.length == 4) {
                return PathInterpolatorCompat.create(MotionUtils.getLegacyControlPoint(v4, 0), MotionUtils.getLegacyControlPoint(v4, 1), MotionUtils.getLegacyControlPoint(v4, 2), MotionUtils.getLegacyControlPoint(v4, 3));
            }

            throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + v4.length);
        }

        v0 = "path";
        if(MotionUtils.isLegacyEasingType(arg4, v0)) {
            return PathInterpolatorCompat.create(PathParser.createPathFromPathData(MotionUtils.getLegacyEasingContent(arg4, v0)));
        }

        throw new IllegalArgumentException("Invalid motion easing type: " + arg4);
    }

    private static boolean isLegacyEasingAttribute(String arg1) {
        if(!MotionUtils.isLegacyEasingType(arg1, "cubic-bezier")) {
            if(MotionUtils.isLegacyEasingType(arg1, "path")) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private static boolean isLegacyEasingType(String arg1, String arg2) {
        if((arg1.startsWith(arg2 + "(")) && (arg1.endsWith(")"))) {
            return 1;
        }

        return 0;
    }

    public static int resolveThemeDuration(Context arg0, int arg1, int arg2) {
        return MaterialAttributes.resolveInteger(arg0, arg1, arg2);
    }

    public static TimeInterpolator resolveThemeInterpolator(Context arg3, int arg4, TimeInterpolator arg5) {
        TypedValue v0 = new TypedValue();
        if(!arg3.getTheme().resolveAttribute(arg4, v0, true)) {
            return arg5;
        }

        if(v0.type == 3) {
            String v4 = String.valueOf(v0.string);
            if(MotionUtils.isLegacyEasingAttribute(v4)) {
                return MotionUtils.getLegacyThemeInterpolator(v4);
            }

            return AnimationUtils.loadInterpolator(arg3, v0.resourceId);
        }

        throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
    }
}

