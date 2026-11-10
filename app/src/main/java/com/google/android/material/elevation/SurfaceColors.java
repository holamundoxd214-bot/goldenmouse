package com.google.android.material.elevation;

import android.content.Context;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.color.MaterialColors;

public enum SurfaceColors {
    public static final enum SurfaceColors SURFACE_0;
    public static final enum SurfaceColors SURFACE_1;
    public static final enum SurfaceColors SURFACE_2;
    public static final enum SurfaceColors SURFACE_3;
    public static final enum SurfaceColors SURFACE_4;
    public static final enum SurfaceColors SURFACE_5;
    private final int elevationResId;

    static {
        SurfaceColors v0 = new SurfaceColors("SURFACE_0", 0, dimen.m3_sys_elevation_level0);
        SurfaceColors.SURFACE_0 = v0;
        SurfaceColors v1 = new SurfaceColors("SURFACE_1", 1, dimen.m3_sys_elevation_level1);
        SurfaceColors.SURFACE_1 = v1;
        SurfaceColors v2 = new SurfaceColors("SURFACE_2", 2, dimen.m3_sys_elevation_level2);
        SurfaceColors.SURFACE_2 = v2;
        SurfaceColors v3 = new SurfaceColors("SURFACE_3", 3, dimen.m3_sys_elevation_level3);
        SurfaceColors.SURFACE_3 = v3;
        SurfaceColors v4 = new SurfaceColors("SURFACE_4", 4, dimen.m3_sys_elevation_level4);
        SurfaceColors.SURFACE_4 = v4;
        SurfaceColors v5 = new SurfaceColors("SURFACE_5", 5, dimen.m3_sys_elevation_level5);
        SurfaceColors.SURFACE_5 = v5;
        SurfaceColors.$VALUES = new SurfaceColors[]{v0, v1, v2, v3, v4, v5};
    }

    private SurfaceColors(String arg1, int arg2, int arg3) {
        super(arg1, arg2);
        this.elevationResId = arg3;
    }

    public int getColor(Context arg2) {
        return SurfaceColors.getColorForElevation(arg2, arg2.getResources().getDimension(this.elevationResId));
    }

    public static int getColorForElevation(Context arg3, float arg4) {
        return new ElevationOverlayProvider(arg3).compositeOverlay(MaterialColors.getColor(arg3, attr.colorSurface, 0), arg4);
    }

    public static SurfaceColors valueOf(String arg1) {
        return Enum.valueOf(SurfaceColors.class, arg1);
    }

    public static SurfaceColors[] values() {
        return SurfaceColors.$VALUES.clone();
    }
}

