package com.google.android.material.radiobutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialRadioButton extends AppCompatRadioButton {
    private static final int DEF_STYLE_RES;
    private static final int[][] ENABLED_CHECKED_STATES;
    private ColorStateList materialThemeColorsTintList;
    private boolean useMaterialThemeColors;

    static {
        MaterialRadioButton.DEF_STYLE_RES = style.Widget_MaterialComponents_CompoundButton_RadioButton;
        MaterialRadioButton.ENABLED_CHECKED_STATES = new int[][]{new int[]{0x101009E, 0x10100A0}, new int[]{0x101009E, 0xFEFEFF60}, new int[]{0xFEFEFF62, 0x10100A0}, new int[]{0xFEFEFF62, 0xFEFEFF60}};
    }

    public MaterialRadioButton(Context arg2) {
        this(arg2, null);
    }

    public MaterialRadioButton(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.radioButtonStyle);
    }

    public MaterialRadioButton(Context arg7, AttributeSet arg8, int arg9) {
        int v4 = MaterialRadioButton.DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(arg7, arg8, arg9, v4), arg8, arg9);
        Context v0 = this.getContext();
        TypedArray v8 = ThemeEnforcement.obtainStyledAttributes(v0, arg8, styleable.MaterialRadioButton, arg9, v4, new int[0]);
        if(v8.hasValue(styleable.MaterialRadioButton_buttonTint)) {
            CompoundButtonCompat.setButtonTintList(((CompoundButton)this), MaterialResources.getColorStateList(v0, v8, styleable.MaterialRadioButton_buttonTint));
        }

        this.useMaterialThemeColors = v8.getBoolean(styleable.MaterialRadioButton_useMaterialThemeColors, false);
        v8.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        ColorStateList v0 = this.materialThemeColorsTintList;
        if(v0 == null) {
            int v0_1 = MaterialColors.getColor(((View)this), attr.colorControlActivated);
            int v1 = MaterialColors.getColor(((View)this), attr.colorOnSurface);
            int v2 = MaterialColors.getColor(((View)this), attr.colorSurface);
            int[][] v3 = MaterialRadioButton.ENABLED_CHECKED_STATES;
            int[] v4 = new int[v3.length];
            v4[0] = MaterialColors.layer(v2, v0_1, 1f);
            v4[1] = MaterialColors.layer(v2, v1, 0.54f);
            v4[2] = MaterialColors.layer(v2, v1, 0.38f);
            v4[3] = MaterialColors.layer(v2, v1, 0.38f);
            v0 = new ColorStateList(v3, v4);
            this.materialThemeColorsTintList = v0;
        }

        return v0;
    }

    public boolean isUseMaterialThemeColors() {
        return this.useMaterialThemeColors;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if((this.useMaterialThemeColors) && CompoundButtonCompat.getButtonTintList(((CompoundButton)this)) == null) {
            this.setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean arg1) {
        this.useMaterialThemeColors = arg1;
        if(arg1) {
            CompoundButtonCompat.setButtonTintList(((CompoundButton)this), this.getMaterialThemeColorsTintList());
            return;
        }

        CompoundButtonCompat.setButtonTintList(((CompoundButton)this), null);
    }
}

