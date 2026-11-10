package com.google.android.material.color;

import com.google.android.material.R$attr;
import com.google.android.material.R$style;

public final class HarmonizedColorAttributes {
    private static final int[] HARMONIZED_MATERIAL_ATTRIBUTES;
    private final int[] attributes;
    private final int themeOverlay;

    static {
        HarmonizedColorAttributes.HARMONIZED_MATERIAL_ATTRIBUTES = new int[]{attr.colorError, attr.colorOnError, attr.colorErrorContainer, attr.colorOnErrorContainer};
    }

    private HarmonizedColorAttributes(int[] arg2, int arg3) {
        super();
        if(arg3 != 0) {
            if(arg2.length != 0) {
            }
            else {
                throw new IllegalArgumentException("Theme overlay should be used with the accompanying int[] attributes.");
            }
        }

        this.attributes = arg2;
        this.themeOverlay = arg3;
    }

    public static HarmonizedColorAttributes create(int[] arg2) {
        return new HarmonizedColorAttributes(arg2, 0);
    }

    public static HarmonizedColorAttributes create(int[] arg1, int arg2) {
        return new HarmonizedColorAttributes(arg1, arg2);
    }

    public static HarmonizedColorAttributes createMaterialDefaults() {
        return HarmonizedColorAttributes.create(HarmonizedColorAttributes.HARMONIZED_MATERIAL_ATTRIBUTES, style.ThemeOverlay_Material3_HarmonizedColors);
    }

    public int[] getAttributes() {
        return this.attributes;
    }

    public int getThemeOverlay() {
        return this.themeOverlay;
    }
}

