package com.google.android.material.color;

import android.app.Activity;
import android.app.Application$ActivityLifecycleCallbacks;
import android.app.Application;
import android.app.UiModeManager$ContrastChangeListener;
import android.app.UiModeManager;
import android.content.Context;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class ColorContrast {
    class ColorContrastActivityLifecycleCallbacks implements Application$ActivityLifecycleCallbacks {
        private final Set activitiesInStack;
        private final ColorContrastOptions colorContrastOptions;
        private UiModeManager$ContrastChangeListener contrastChangeListener;

        ColorContrastActivityLifecycleCallbacks(ColorContrastOptions arg2) {
            super();
            this.activitiesInStack = new LinkedHashSet();
            this.colorContrastOptions = arg2;
        }

        static Set access$000(ColorContrastActivityLifecycleCallbacks arg0) {
            return arg0.activitiesInStack;
        }

        public void onActivityCreated(Activity arg1, Bundle arg2) {
        }

        public void onActivityDestroyed(Activity arg2) {
            this.activitiesInStack.remove(arg2);
            Object v2 = arg2.getSystemService("uimode");
            if(v2 != null && this.contrastChangeListener != null && (this.activitiesInStack.isEmpty())) {
                ((UiModeManager)v2).removeContrastChangeListener(this.contrastChangeListener);
                this.contrastChangeListener = null;
            }
        }

        public void onActivityPaused(Activity arg1) {
        }

        public void onActivityPreCreated(Activity arg3, Bundle arg4) {
            Object v4 = arg3.getSystemService("uimode");
            if(v4 != null && (this.activitiesInStack.isEmpty()) && this.contrastChangeListener == null) {
                this.contrastChangeListener = new UiModeManager$ContrastChangeListener() {
                    public void onContrastChanged(float arg1) {
                        Iterator v0 = ColorContrastActivityLifecycleCallbacks.this.activitiesInStack.iterator();
                        while(v0.hasNext()) {
                            v0.next().recreate();
                        }
                    }
                };
                ((UiModeManager)v4).addContrastChangeListener(ContextCompat.getMainExecutor(arg3.getApplicationContext()), this.contrastChangeListener);
            }

            this.activitiesInStack.add(arg3);
            if(v4 != null) {
                ColorContrast.applyToActivityIfAvailable(arg3, this.colorContrastOptions);
            }
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

    private static final float HIGH_CONTRAST_THRESHOLD = 0.666667f;
    private static final float MEDIUM_CONTRAST_THRESHOLD = 0.333333f;

    private ColorContrast() {
        super();
    }

    public static void applyToActivitiesIfAvailable(Application arg1, ColorContrastOptions arg2) {
        if(!ColorContrast.isContrastAvailable()) {
            return;
        }

        arg1.registerActivityLifecycleCallbacks(new ColorContrastActivityLifecycleCallbacks(arg2));
    }

    public static void applyToActivityIfAvailable(Activity arg1, ColorContrastOptions arg2) {
        if(!ColorContrast.isContrastAvailable()) {
        }
        else {
            int v2 = ColorContrast.getContrastThemeOverlayResourceId(((Context)arg1), arg2);
            if(v2 != 0) {
                ThemeUtils.applyThemeOverlay(((Context)arg1), v2);
            }
        }
    }

    private static int getContrastThemeOverlayResourceId(Context arg3, ColorContrastOptions arg4) {
        Object v3 = arg3.getSystemService("uimode");
        if(ColorContrast.isContrastAvailable()) {
            if(v3 == null) {
            }
            else {
                float v3_1 = ((UiModeManager)v3).getContrast();
                int v0 = arg4.getMediumContrastThemeOverlay();
                int v4 = arg4.getHighContrastThemeOverlay();
                if(v3_1 >= 0.666667f) {
                    if(v4 == 0) {
                    }
                    else {
                        return v4;
                    }
                }
                else if(v3_1 < 0.333333f) {
                    return 0;
                }
                else if(v0 == 0) {
                    return v4;
                }

                return v0;
            }
        }

        return 0;
    }

    public static boolean isContrastAvailable() {
        if(Build$VERSION.SDK_INT >= 34) {
            return 1;
        }

        return 0;
    }

    public static Context wrapContextIfAvailable(Context arg1, ColorContrastOptions arg2) {
        int v2;
        if(!ColorContrast.isContrastAvailable()) {
        }
        else {
            v2 = ColorContrast.getContrastThemeOverlayResourceId(arg1, arg2);
            if(v2 == 0) {
                return arg1;
            }

            goto label_6;
        }

        return arg1;
    label_6:
        return new ContextThemeWrapper(arg1, v2);
    }
}

