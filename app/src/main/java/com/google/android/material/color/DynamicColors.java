package com.google.android.material.color;

import android.app.Activity;
import android.app.Application$ActivityLifecycleCallbacks;
import android.app.Application;
import android.app.UiModeManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build$VERSION;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import androidx.core.os.BuildCompat;
import com.google.android.material.R$attr;
import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.Hct;
import com.google.android.material.color.utilities.SchemeContent;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DynamicColors {
    class com.google.android.material.color.DynamicColors$1 implements DeviceSupportCondition {
        com.google.android.material.color.DynamicColors$1() {
            super();
        }

        public boolean isSupported() {
            return 1;
        }
    }

    class com.google.android.material.color.DynamicColors$2 implements DeviceSupportCondition {
        private Long version;

        com.google.android.material.color.DynamicColors$2() {
            super();
        }

        public boolean isSupported() {
            Long v0 = this.version;
            boolean v1 = false;
            if(v0 == null) {
                try {
                    Method v0_1 = Build.class.getDeclaredMethod("getLong", String.class);
                    v0_1.setAccessible(true);
                    v0 = Long.valueOf(v0_1.invoke(null, "ro.build.version.oneui").longValue());
                    this.version = v0;
                }
                catch(Exception ) {
                    v0 = Long.valueOf(-1);
                    this.version = v0;
                }
            }

            if(v0.longValue() >= 40100) {
                v1 = true;
            }

            return v1;
        }
    }

    interface DeviceSupportCondition {
        boolean isSupported();
    }

    class DynamicColorsActivityLifecycleCallbacks implements Application$ActivityLifecycleCallbacks {
        private final DynamicColorsOptions dynamicColorsOptions;

        DynamicColorsActivityLifecycleCallbacks(DynamicColorsOptions arg1) {
            super();
            this.dynamicColorsOptions = arg1;
        }

        public void onActivityCreated(Activity arg1, Bundle arg2) {
        }

        public void onActivityDestroyed(Activity arg1) {
        }

        public void onActivityPaused(Activity arg1) {
        }

        public void onActivityPreCreated(Activity arg1, Bundle arg2) {
            DynamicColors.applyToActivityIfAvailable(arg1, this.dynamicColorsOptions);
        }

        public void onActivityResumed(Activity arg1) {
        }

        public void onActivitySaveInstanceState(Activity arg1, Bundle arg2) {
        }

        public void onActivityStarted(Activity arg1) {
        }

        public void onActivityStopped(Activity arg1) {
        }
    }

    public interface OnAppliedCallback {
        void onApplied(Activity arg1);
    }

    public interface Precondition {
        boolean shouldApplyDynamicColors(Activity arg1, int arg2);
    }

    private static final DeviceSupportCondition DEFAULT_DEVICE_SUPPORT_CONDITION;
    private static final Map DYNAMIC_COLOR_SUPPORTED_BRANDS;
    private static final Map DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS;
    private static final int[] DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE;
    private static final DeviceSupportCondition SAMSUNG_DEVICE_SUPPORT_CONDITION;
    private static final String TAG;
    private static final int USE_DEFAULT_THEME_OVERLAY;

    static {
        DynamicColors.DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE = new int[]{attr.dynamicColorThemeOverlay};
        com.google.android.material.color.DynamicColors$1 v0 = new com.google.android.material.color.DynamicColors$1();
        DynamicColors.DEFAULT_DEVICE_SUPPORT_CONDITION = ((DeviceSupportCondition)v0);
        com.google.android.material.color.DynamicColors$2 v1 = new com.google.android.material.color.DynamicColors$2();
        DynamicColors.SAMSUNG_DEVICE_SUPPORT_CONDITION = ((DeviceSupportCondition)v1);
        HashMap v2 = new HashMap();
        ((Map)v2).put("fcnt", v0);
        ((Map)v2).put("google", v0);
        ((Map)v2).put("hmd global", v0);
        ((Map)v2).put("infinix", v0);
        ((Map)v2).put("infinix mobility limited", v0);
        ((Map)v2).put("itel", v0);
        ((Map)v2).put("kyocera", v0);
        ((Map)v2).put("lenovo", v0);
        ((Map)v2).put("lge", v0);
        ((Map)v2).put("meizu", v0);
        ((Map)v2).put("motorola", v0);
        ((Map)v2).put("nothing", v0);
        ((Map)v2).put("oneplus", v0);
        ((Map)v2).put("oppo", v0);
        ((Map)v2).put("realme", v0);
        ((Map)v2).put("robolectric", v0);
        ((Map)v2).put("samsung", v1);
        ((Map)v2).put("sharp", v0);
        ((Map)v2).put("shift", v0);
        ((Map)v2).put("sony", v0);
        ((Map)v2).put("tcl", v0);
        ((Map)v2).put("tecno", v0);
        ((Map)v2).put("tecno mobile limited", v0);
        ((Map)v2).put("vivo", v0);
        ((Map)v2).put("wingtech", v0);
        ((Map)v2).put("xiaomi", v0);
        DynamicColors.DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS = Collections.unmodifiableMap(((Map)v2));
        HashMap v1_1 = new HashMap();
        ((Map)v1_1).put("asus", v0);
        ((Map)v1_1).put("jio", v0);
        DynamicColors.DYNAMIC_COLOR_SUPPORTED_BRANDS = Collections.unmodifiableMap(((Map)v1_1));
        DynamicColors.TAG = "DynamicColors";
    }

    private DynamicColors() {
        super();
    }

    @Deprecated public static void applyIfAvailable(Activity arg0) {
        DynamicColors.applyToActivityIfAvailable(arg0);
    }

    @Deprecated public static void applyIfAvailable(Activity arg1, int arg2) {
        DynamicColors.applyToActivityIfAvailable(arg1, new Builder().setThemeOverlay(arg2).build());
    }

    @Deprecated public static void applyIfAvailable(Activity arg1, Precondition arg2) {
        DynamicColors.applyToActivityIfAvailable(arg1, new Builder().setPrecondition(arg2).build());
    }

    public static void applyToActivitiesIfAvailable(Application arg1) {
        DynamicColors.applyToActivitiesIfAvailable(arg1, new Builder().build());
    }

    public static void applyToActivitiesIfAvailable(Application arg1, DynamicColorsOptions arg2) {
        arg1.registerActivityLifecycleCallbacks(new DynamicColorsActivityLifecycleCallbacks(arg2));
    }

    @Deprecated public static void applyToActivitiesIfAvailable(Application arg1, int arg2) {
        DynamicColors.applyToActivitiesIfAvailable(arg1, new Builder().setThemeOverlay(arg2).build());
    }

    @Deprecated public static void applyToActivitiesIfAvailable(Application arg1, int arg2, Precondition arg3) {
        DynamicColors.applyToActivitiesIfAvailable(arg1, new Builder().setThemeOverlay(arg2).setPrecondition(arg3).build());
    }

    @Deprecated public static void applyToActivitiesIfAvailable(Application arg1, Precondition arg2) {
        DynamicColors.applyToActivitiesIfAvailable(arg1, new Builder().setPrecondition(arg2).build());
    }

    public static void applyToActivityIfAvailable(Activity arg1) {
        DynamicColors.applyToActivityIfAvailable(arg1, new Builder().build());
    }

    public static void applyToActivityIfAvailable(Activity arg5, DynamicColorsOptions arg6) {
        int v0;
        if(!DynamicColors.isDynamicColorAvailable()) {
        }
        else {
            if(arg6.getContentBasedSeedColor() != null) {
                v0 = 0;
            }
            else if(arg6.getThemeOverlay() == 0) {
                v0 = DynamicColors.getDefaultThemeOverlay(((Context)arg5), DynamicColors.DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE);
            }
            else {
                v0 = arg6.getThemeOverlay();
            }

            if(!arg6.getPrecondition().shouldApplyDynamicColors(arg5, v0)) {
                return;
            }

            if(arg6.getContentBasedSeedColor() != null) {
                SchemeContent v0_1 = new SchemeContent(Hct.fromInt(arg6.getContentBasedSeedColor().intValue()), MaterialColors.isLightTheme(((Context)arg5)) ^ 1, ((double)DynamicColors.getSystemContrast(((Context)arg5))));
                ColorResourcesOverride v1 = ColorResourcesOverride.getInstance();
                if(v1 == null) {
                    return;
                }
                else if(!v1.applyIfPossible(((Context)arg5), MaterialColorUtilitiesHelper.createColorResourcesIdsToColorValues(((DynamicScheme)v0_1)))) {
                    return;
                }
            }
            else {
                ThemeUtils.applyThemeOverlay(((Context)arg5), v0);
            }

            arg6.getOnAppliedCallback().onApplied(arg5);
        }
    }

    private static int getDefaultThemeOverlay(Context arg0, int[] arg1) {
        TypedArray v0 = arg0.obtainStyledAttributes(arg1);
        int v1 = v0.getResourceId(0, 0);
        v0.recycle();
        return v1;
    }

    private static float getSystemContrast(Context arg2) {
        Object v2 = arg2.getSystemService("uimode");
        if(v2 != null) {
            if(Build$VERSION.SDK_INT < 34) {
            }
            else {
                return ((UiModeManager)v2).getContrast();
            }
        }

        return 0;
    }

    public static boolean isDynamicColorAvailable() {
        if(Build$VERSION.SDK_INT < 0x1F) {
            return 0;
        }

        if(BuildCompat.isAtLeastT()) {
            return 1;
        }

        Object v0 = DynamicColors.DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS.get(Build.MANUFACTURER.toLowerCase(Locale.ROOT));
        if(v0 == null) {
            v0 = DynamicColors.DYNAMIC_COLOR_SUPPORTED_BRANDS.get(Build.BRAND.toLowerCase(Locale.ROOT));
        }

        if(v0 != null && (((DeviceSupportCondition)v0).isSupported())) {
            return 1;
        }

        return 0;
    }

    public static Context wrapContextIfAvailable(Context arg1) {
        return DynamicColors.wrapContextIfAvailable(arg1, 0);
    }

    public static Context wrapContextIfAvailable(Context arg1, int arg2) {
        return DynamicColors.wrapContextIfAvailable(arg1, new Builder().setThemeOverlay(arg2).build());
    }

    public static Context wrapContextIfAvailable(Context arg5, DynamicColorsOptions arg6) {
        int v0;
        if(!DynamicColors.isDynamicColorAvailable()) {
        }
        else {
            v0 = arg6.getThemeOverlay();
            if(v0 == 0) {
                v0 = DynamicColors.getDefaultThemeOverlay(arg5, DynamicColors.DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE);
            }

            if(v0 != 0) {
                goto label_9;
            }
        }

        return arg5;
    label_9:
        if(arg6.getContentBasedSeedColor() != null) {
            SchemeContent v1 = new SchemeContent(Hct.fromInt(arg6.getContentBasedSeedColor().intValue()), MaterialColors.isLightTheme(arg5) ^ 1, ((double)DynamicColors.getSystemContrast(arg5)));
            ColorResourcesOverride v6 = ColorResourcesOverride.getInstance();
            if(v6 != null) {
                return v6.wrapContextIfPossible(arg5, MaterialColorUtilitiesHelper.createColorResourcesIdsToColorValues(((DynamicScheme)v1)));
            }
        }

        return new ContextThemeWrapper(arg5, v0);
    }
}

