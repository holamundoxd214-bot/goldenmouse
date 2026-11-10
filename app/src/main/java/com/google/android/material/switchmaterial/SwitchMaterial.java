package com.google.android.material.switchmaterial;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class SwitchMaterial extends SwitchCompat {
    private static final int DEF_STYLE_RES;
    private static final int[][] ENABLED_CHECKED_STATES;
    private final ElevationOverlayProvider elevationOverlayProvider;
    private ColorStateList materialThemeColorsThumbTintList;
    private ColorStateList materialThemeColorsTrackTintList;
    private boolean useMaterialThemeColors;

    static {
        SwitchMaterial.DEF_STYLE_RES = style.Widget_MaterialComponents_CompoundButton_Switch;
        SwitchMaterial.ENABLED_CHECKED_STATES = new int[][]{new int[]{0x101009E, 0x10100A0}, new int[]{0x101009E, 0xFEFEFF60}, new int[]{0xFEFEFF62, 0x10100A0}, new int[]{0xFEFEFF62, 0xFEFEFF60}};
    }

    public SwitchMaterial(Context arg2) {
        this(arg2, null);
    }

    public SwitchMaterial(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.switchStyle);
    }

    public SwitchMaterial(Context arg7, AttributeSet arg8, int arg9) {
        int v4 = SwitchMaterial.DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(arg7, arg8, arg9, v4), arg8, arg9);
        Context v0 = this.getContext();
        this.elevationOverlayProvider = new ElevationOverlayProvider(v0);
        TypedArray v8 = ThemeEnforcement.obtainStyledAttributes(v0, arg8, styleable.SwitchMaterial, arg9, v4, new int[0]);
        this.useMaterialThemeColors = v8.getBoolean(styleable.SwitchMaterial_useMaterialThemeColors, false);
        v8.recycle();
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        ColorStateList v0 = this.materialThemeColorsThumbTintList;
        if(v0 == null) {
            int v0_1 = MaterialColors.getColor(((View)this), attr.colorSurface);
            int v1 = MaterialColors.getColor(((View)this), attr.colorControlActivated);
            float v2 = this.getResources().getDimension(dimen.mtrl_switch_thumb_elevation);
            if(this.elevationOverlayProvider.isThemeElevationOverlayEnabled()) {
                v2 += ViewUtils.getParentAbsoluteElevation(((View)this));
            }

            int v2_1 = this.elevationOverlayProvider.compositeOverlayIfNeeded(v0_1, v2);
            int[][] v3 = SwitchMaterial.ENABLED_CHECKED_STATES;
            int[] v4 = new int[v3.length];
            v4[0] = MaterialColors.layer(v0_1, v1, 1f);
            v4[1] = v2_1;
            v4[2] = MaterialColors.layer(v0_1, v1, 0.38f);
            v4[3] = v2_1;
            v0 = new ColorStateList(v3, v4);
            this.materialThemeColorsThumbTintList = v0;
        }

        return v0;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        ColorStateList v0 = this.materialThemeColorsTrackTintList;
        if(v0 == null) {
            int[][] v0_1 = SwitchMaterial.ENABLED_CHECKED_STATES;
            int[] v1 = new int[v0_1.length];
            int v2 = MaterialColors.getColor(((View)this), attr.colorSurface);
            int v3 = MaterialColors.getColor(((View)this), attr.colorControlActivated);
            int v4 = MaterialColors.getColor(((View)this), attr.colorOnSurface);
            v1[0] = MaterialColors.layer(v2, v3, 0.54f);
            v1[1] = MaterialColors.layer(v2, v4, 0.32f);
            v1[2] = MaterialColors.layer(v2, v3, 0.12f);
            v1[3] = MaterialColors.layer(v2, v4, 0.12f);
            ColorStateList v2_1 = new ColorStateList(v0_1, v1);
            this.materialThemeColorsTrackTintList = v2_1;
            return v2_1;
        }

        return v0;
    }

    public boolean isUseMaterialThemeColors() {
        return this.useMaterialThemeColors;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if((this.useMaterialThemeColors) && this.getThumbTintList() == null) {
            this.setThumbTintList(this.getMaterialThemeColorsThumbTintList());
        }

        if((this.useMaterialThemeColors) && this.getTrackTintList() == null) {
            this.setTrackTintList(this.getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean arg1) {
        this.useMaterialThemeColors = arg1;
        if(arg1) {
            this.setThumbTintList(this.getMaterialThemeColorsThumbTintList());
            this.setTrackTintList(this.getMaterialThemeColorsTrackTintList());
            return;
        }

        this.setThumbTintList(null);
        this.setTrackTintList(null);
    }
}

