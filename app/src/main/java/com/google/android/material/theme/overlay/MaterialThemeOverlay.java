package com.google.android.material.theme.overlay;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.view.ContextThemeWrapper;
import com.google.android.material.R$attr;

public class MaterialThemeOverlay {
    private static final int[] ANDROID_THEME_OVERLAY_ATTRS;
    private static final int[] MATERIAL_THEME_OVERLAY_ATTR;

    static {
        MaterialThemeOverlay.ANDROID_THEME_OVERLAY_ATTRS = new int[]{0x1010000, attr.theme};
        MaterialThemeOverlay.MATERIAL_THEME_OVERLAY_ATTR = new int[]{attr.materialThemeOverlay};
    }

    private MaterialThemeOverlay() {
        super();
    }

    private static int obtainAndroidThemeOverlayId(Context arg2, AttributeSet arg3) {
        TypedArray v2 = arg2.obtainStyledAttributes(arg3, MaterialThemeOverlay.ANDROID_THEME_OVERLAY_ATTRS);
        int v0 = v2.getResourceId(0, 0);
        int v3 = v2.getResourceId(1, 0);
        v2.recycle();
        if(v0 != 0) {
            return v0;
        }

        return v3;
    }

    private static int obtainMaterialThemeOverlayId(Context arg1, AttributeSet arg2, int arg3, int arg4) {
        TypedArray v1 = arg1.obtainStyledAttributes(arg2, MaterialThemeOverlay.MATERIAL_THEME_OVERLAY_ATTR, arg3, arg4);
        int v2 = v1.getResourceId(0, 0);
        v1.recycle();
        return v2;
    }

    public static Context wrap(Context arg1, AttributeSet arg2, int arg3, int arg4) {
        arg3 = MaterialThemeOverlay.obtainMaterialThemeOverlayId(arg1, arg2, arg3, arg4);
        arg4 = !(arg1 instanceof ContextThemeWrapper) || arg1.getThemeResId() != arg3 ? 0 : 1;
        if(arg3 != 0) {
            if(arg4 != 0) {
            }
            else {
                ContextThemeWrapper v4 = new ContextThemeWrapper(arg1, arg3);
                int v1 = MaterialThemeOverlay.obtainAndroidThemeOverlayId(arg1, arg2);
                if(v1 != 0) {
                    ((Context)v4).getTheme().applyStyle(v1, true);
                }

                return ((Context)v4);
            }
        }

        return arg1;
    }
}

