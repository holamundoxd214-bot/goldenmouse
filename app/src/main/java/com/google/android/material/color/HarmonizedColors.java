package com.google.android.material.color;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build$VERSION;
import android.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import com.google.android.material.R$style;
import java.util.HashMap;
import java.util.Map;

public class HarmonizedColors {
    private static final String TAG = "HarmonizedColors";

    static {
    }

    private HarmonizedColors() {
        super();
    }

    private static void addHarmonizedColorAttributesToReplacementMap(Map arg4, TypedArray arg5, TypedArray arg6, int arg7) {
        if(arg6 != null) {
        }
        else {
            arg6 = arg5;
        }

        int v1;
        for(v1 = 0; v1 < arg5.getIndexCount(); ++v1) {
            int v2 = arg6.getResourceId(v1, 0);
            if(v2 != 0 && (arg5.hasValue(v1)) && (ResourcesLoaderUtils.isColorResource(arg5.getType(v1)))) {
                arg4.put(Integer.valueOf(v2), Integer.valueOf(MaterialColors.harmonize(arg5.getColor(v1, 0), arg7)));
            }
        }
    }

    public static void applyToContextIfAvailable(Context arg2, HarmonizedColorsOptions arg3) {
        if(!HarmonizedColors.isHarmonizedColorAvailable()) {
        }
        else {
            Map v0 = HarmonizedColors.createHarmonizedColorReplacementMap(arg2, arg3);
            int v3 = arg3.getThemeOverlayResourceId(0);
            if((ResourcesLoaderUtils.addResourcesLoaderToContext(arg2, v0)) && v3 != 0) {
                ThemeUtils.applyThemeOverlay(arg2, v3);
            }
        }
    }

    private static Map createHarmonizedColorReplacementMap(Context arg7, HarmonizedColorsOptions arg8) {
        HashMap v0 = new HashMap();
        int v1 = MaterialColors.getColor(arg7, arg8.getColorAttributeToHarmonizeWith(), HarmonizedColors.TAG);
        int[] v2 = arg8.getColorResourceIds();
        int v3 = v2.length;
        int v4;
        for(v4 = 0; v4 < v3; ++v4) {
            ((Map)v0).put(Integer.valueOf(v2[v4]), Integer.valueOf(MaterialColors.harmonize(ContextCompat.getColor(arg7, v2[v4]), v1)));
        }

        HarmonizedColorAttributes v8 = arg8.getColorAttributes();
        if(v8 != null) {
            v2 = v8.getAttributes();
            if(v2.length > 0) {
                int v8_1 = v8.getThemeOverlay();
                TypedArray v3_1 = arg7.obtainStyledAttributes(v2);
                TypedArray v7 = v8_1 != 0 ? new ContextThemeWrapper(arg7, v8_1).obtainStyledAttributes(v2) : null;
                HarmonizedColors.addHarmonizedColorAttributesToReplacementMap(((Map)v0), v3_1, v7, v1);
                v3_1.recycle();
                if(v7 == null) {
                    goto label_34;
                }

                v7.recycle();
            }
        }

    label_34:
        return ((Map)v0);
    }

    public static boolean isHarmonizedColorAvailable() {
        if(Build$VERSION.SDK_INT >= 30) {
            return 1;
        }

        return 0;
    }

    public static Context wrapContextIfAvailable(Context arg2, HarmonizedColorsOptions arg3) {
        if(!HarmonizedColors.isHarmonizedColorAvailable()) {
        }
        else {
            Map v0 = HarmonizedColors.createHarmonizedColorReplacementMap(arg2, arg3);
            ContextThemeWrapper v1 = new ContextThemeWrapper(arg2, arg3.getThemeOverlayResourceId(style.ThemeOverlay_Material3_HarmonizedColors_Empty));
            v1.applyOverrideConfiguration(new Configuration());
            if(ResourcesLoaderUtils.addResourcesLoaderToContext(((Context)v1), v0)) {
                return ((Context)v1);
            }
        }

        return arg2;
    }
}

