package com.google.android.material.internal;

import android.content.Context;
import android.os.Build$VERSION;
import android.view.Window;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.WindowCompat;
import com.google.android.material.color.MaterialColors;

public class EdgeToEdgeUtils {
    private static final int EDGE_TO_EDGE_BAR_ALPHA = 0x80;

    private EdgeToEdgeUtils() {
        super();
    }

    public static void applyEdgeToEdge(Window arg5, boolean arg6, Integer arg7, Integer arg8) {
        int v0 = 0;
        int v2 = arg7 == null || arg7.intValue() == 0 ? 1 : 0;
        if(arg8 == null || arg8.intValue() == 0) {
            v0 = 1;
        }

        if(v2 != 0 || v0 != 0) {
            int v1 = MaterialColors.getColor(arg5.getContext(), 0x1010031, 0xFF000000);
            if(v2 != 0) {
                arg7 = Integer.valueOf(v1);
            }

            if(v0 == 0) {
                goto label_23;
            }

            arg8 = Integer.valueOf(v1);
        }

    label_23:
        WindowCompat.setDecorFitsSystemWindows(arg5, (((int)arg6)) ^ 1);
        v0 = EdgeToEdgeUtils.getStatusBarColor(arg5.getContext(), arg6);
        int v6 = EdgeToEdgeUtils.getNavigationBarColor(arg5.getContext(), arg6);
        arg5.setStatusBarColor(v0);
        arg5.setNavigationBarColor(v6);
        EdgeToEdgeUtils.setLightStatusBar(arg5, EdgeToEdgeUtils.isUsingLightSystemBar(v0, MaterialColors.isColorLight(arg7.intValue())));
        EdgeToEdgeUtils.setLightNavigationBar(arg5, EdgeToEdgeUtils.isUsingLightSystemBar(v6, MaterialColors.isColorLight(arg8.intValue())));
    }

    public static void applyEdgeToEdge(Window arg1, boolean arg2) {
        EdgeToEdgeUtils.applyEdgeToEdge(arg1, arg2, null, null);
    }

    private static int getNavigationBarColor(Context arg4, boolean arg5) {
        int v0 = 0xFF000000;
        int v1 = 0x1010452;
        if((arg5) && Build$VERSION.SDK_INT < 27) {
            return ColorUtils.setAlphaComponent(MaterialColors.getColor(arg4, v1, v0), 0x80);
        }

        if(arg5) {
            return 0;
        }

        return MaterialColors.getColor(arg4, v1, v0);
    }

    private static int getStatusBarColor(Context arg1, boolean arg2) {
        if(arg2) {
            return 0;
        }

        return MaterialColors.getColor(arg1, 0x1010451, 0xFF000000);
    }

    private static boolean isUsingLightSystemBar(int arg1, boolean arg2) {
        if(!MaterialColors.isColorLight(arg1) && (arg1 != 0 || !arg2)) {
            return 0;
        }

        return 1;
    }

    public static void setLightNavigationBar(Window arg1, boolean arg2) {
        WindowCompat.getInsetsController(arg1, arg1.getDecorView()).setAppearanceLightNavigationBars(arg2);
    }

    public static void setLightStatusBar(Window arg1, boolean arg2) {
        WindowCompat.getInsetsController(arg1, arg1.getDecorView()).setAppearanceLightStatusBars(arg2);
    }
}

