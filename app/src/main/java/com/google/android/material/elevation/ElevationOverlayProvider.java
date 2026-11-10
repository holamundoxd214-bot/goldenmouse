package com.google.android.material.elevation;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R$attr;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;

public class ElevationOverlayProvider {
    private static final float FORMULA_MULTIPLIER = 4.5f;
    private static final float FORMULA_OFFSET = 2f;
    private static final int OVERLAY_ACCENT_COLOR_ALPHA;
    private final int colorSurface;
    private final float displayDensity;
    private final int elevationOverlayAccentColor;
    private final int elevationOverlayColor;
    private final boolean elevationOverlayEnabled;

    static {
        ElevationOverlayProvider.OVERLAY_ACCENT_COLOR_ALPHA = ((int)Math.round(5.1));
    }

    public ElevationOverlayProvider(Context arg9) {
        this(MaterialAttributes.resolveBoolean(arg9, attr.elevationOverlayEnabled, false), MaterialColors.getColor(arg9, attr.elevationOverlayColor, 0), MaterialColors.getColor(arg9, attr.elevationOverlayAccentColor, 0), MaterialColors.getColor(arg9, attr.colorSurface, 0), arg9.getResources().getDisplayMetrics().density);
    }

    public ElevationOverlayProvider(boolean arg1, int arg2, int arg3, int arg4, float arg5) {
        super();
        this.elevationOverlayEnabled = arg1;
        this.elevationOverlayColor = arg2;
        this.elevationOverlayAccentColor = arg3;
        this.colorSurface = arg4;
        this.displayDensity = arg5;
    }

    public int calculateOverlayAlpha(float arg1) {
        return Math.round(this.calculateOverlayAlphaFraction(arg1) * 255f);
    }

    public float calculateOverlayAlphaFraction(float arg3) {
        float v2 = this.displayDensity;
        if(v2 > 0f) {
            if(arg3 <= 0f) {
            }
            else {
                return Math.min(((((float)Math.log1p(((double)(arg3 / v2))))) * 4.5f + 2f) / 100f, 1f);
            }
        }

        return 0;
    }

    public int compositeOverlay(int arg3, float arg4) {
        arg4 = this.calculateOverlayAlphaFraction(arg4);
        int v0 = Color.alpha(arg3);
        arg3 = MaterialColors.layer(ColorUtils.setAlphaComponent(arg3, 0xFF), this.elevationOverlayColor, arg4);
        if(arg4 > 0f) {
            int v2 = this.elevationOverlayAccentColor;
            if(v2 != 0) {
                arg3 = MaterialColors.layer(arg3, ColorUtils.setAlphaComponent(v2, ElevationOverlayProvider.OVERLAY_ACCENT_COLOR_ALPHA));
            }
        }

        return ColorUtils.setAlphaComponent(arg3, v0);
    }

    public int compositeOverlay(int arg1, float arg2, View arg3) {
        return this.compositeOverlay(arg1, arg2 + this.getParentAbsoluteElevation(arg3));
    }

    public int compositeOverlayIfNeeded(int arg2, float arg3) {
        if((this.elevationOverlayEnabled) && (this.isThemeSurfaceColor(arg2))) {
            return this.compositeOverlay(arg2, arg3);
        }

        return arg2;
    }

    public int compositeOverlayIfNeeded(int arg1, float arg2, View arg3) {
        return this.compositeOverlayIfNeeded(arg1, arg2 + this.getParentAbsoluteElevation(arg3));
    }

    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float arg2) {
        return this.compositeOverlayIfNeeded(this.colorSurface, arg2);
    }

    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float arg1, View arg2) {
        return this.compositeOverlayWithThemeSurfaceColorIfNeeded(arg1 + this.getParentAbsoluteElevation(arg2));
    }

    public float getParentAbsoluteElevation(View arg1) {
        return ViewUtils.getParentAbsoluteElevation(arg1);
    }

    public int getThemeElevationOverlayColor() {
        return this.elevationOverlayColor;
    }

    public int getThemeSurfaceColor() {
        return this.colorSurface;
    }

    public boolean isThemeElevationOverlayEnabled() {
        return this.elevationOverlayEnabled;
    }

    private boolean isThemeSurfaceColor(int arg2) {
        if(ColorUtils.setAlphaComponent(arg2, 0xFF) == this.colorSurface) {
            return 1;
        }

        return 0;
    }
}

