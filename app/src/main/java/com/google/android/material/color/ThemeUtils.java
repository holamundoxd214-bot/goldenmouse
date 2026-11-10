package com.google.android.material.color;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources$Theme;
import android.view.View;
import android.view.Window;

public final class ThemeUtils {
    private ThemeUtils() {
        super();
    }

    public static void applyThemeOverlay(Context arg2, int arg3) {
        arg2.getTheme().applyStyle(arg3, true);
        if((arg2 instanceof Activity)) {
            Resources$Theme v2 = ThemeUtils.getWindowDecorViewTheme(((Activity)arg2));
            if(v2 != null) {
                v2.applyStyle(arg3, true);
            }
        }
    }

    private static Resources$Theme getWindowDecorViewTheme(Activity arg0) {
        Window v0 = arg0.getWindow();
        if(v0 != null) {
            View v0_1 = v0.peekDecorView();
            if(v0_1 != null) {
                Context v0_2 = v0_1.getContext();
                if(v0_2 != null) {
                    return v0_2.getTheme();
                }
            }
        }

        return null;
    }
}

