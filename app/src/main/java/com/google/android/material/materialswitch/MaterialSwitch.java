package com.google.android.material.materialswitch;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialSwitch extends SwitchCompat {
    private static final int DEF_STYLE_RES;
    private static final int[] STATE_SET_WITH_ICON;
    private int[] currentStateChecked;
    private int[] currentStateUnchecked;
    private Drawable thumbDrawable;
    private Drawable thumbIconDrawable;
    private int thumbIconSize;
    private ColorStateList thumbIconTintList;
    private PorterDuff$Mode thumbIconTintMode;
    private ColorStateList thumbTintList;
    private Drawable trackDecorationDrawable;
    private ColorStateList trackDecorationTintList;
    private PorterDuff$Mode trackDecorationTintMode;
    private Drawable trackDrawable;
    private ColorStateList trackTintList;

    static {
        MaterialSwitch.DEF_STYLE_RES = style.Widget_Material3_CompoundButton_MaterialSwitch;
        MaterialSwitch.STATE_SET_WITH_ICON = new int[]{attr.state_with_icon};
    }

    public MaterialSwitch(Context arg2) {
        this(arg2, null);
    }

    public MaterialSwitch(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.materialSwitchStyle);
    }

    public MaterialSwitch(Context arg8, AttributeSet arg9, int arg10) {
        int v4 = MaterialSwitch.DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(arg8, arg9, arg10, v4), arg9, arg10);
        this.thumbIconSize = -1;
        Context v0 = this.getContext();
        this.thumbDrawable = super.getThumbDrawable();
        this.thumbTintList = super.getThumbTintList();
        super.setThumbTintList(null);
        this.trackDrawable = super.getTrackDrawable();
        this.trackTintList = super.getTrackTintList();
        super.setTrackTintList(null);
        TintTypedArray v9 = ThemeEnforcement.obtainTintedStyledAttributes(v0, arg9, styleable.MaterialSwitch, arg10, v4, new int[0]);
        this.thumbIconDrawable = v9.getDrawable(styleable.MaterialSwitch_thumbIcon);
        this.thumbIconSize = v9.getDimensionPixelSize(styleable.MaterialSwitch_thumbIconSize, -1);
        this.thumbIconTintList = v9.getColorStateList(styleable.MaterialSwitch_thumbIconTint);
        this.thumbIconTintMode = ViewUtils.parseTintMode(v9.getInt(styleable.MaterialSwitch_thumbIconTintMode, -1), PorterDuff$Mode.SRC_IN);
        this.trackDecorationDrawable = v9.getDrawable(styleable.MaterialSwitch_trackDecoration);
        this.trackDecorationTintList = v9.getColorStateList(styleable.MaterialSwitch_trackDecorationTint);
        this.trackDecorationTintMode = ViewUtils.parseTintMode(v9.getInt(styleable.MaterialSwitch_trackDecorationTintMode, -1), PorterDuff$Mode.SRC_IN);
        v9.recycle();
        this.setEnforceSwitchWidth(false);
        this.refreshThumbDrawable();
        this.refreshTrackDrawable();
    }

    public Drawable getThumbDrawable() {
        return this.thumbDrawable;
    }

    public Drawable getThumbIconDrawable() {
        return this.thumbIconDrawable;
    }

    public int getThumbIconSize() {
        return this.thumbIconSize;
    }

    public ColorStateList getThumbIconTintList() {
        return this.thumbIconTintList;
    }

    public PorterDuff$Mode getThumbIconTintMode() {
        return this.thumbIconTintMode;
    }

    public ColorStateList getThumbTintList() {
        return this.thumbTintList;
    }

    public Drawable getTrackDecorationDrawable() {
        return this.trackDecorationDrawable;
    }

    public ColorStateList getTrackDecorationTintList() {
        return this.trackDecorationTintList;
    }

    public PorterDuff$Mode getTrackDecorationTintMode() {
        return this.trackDecorationTintMode;
    }

    public Drawable getTrackDrawable() {
        return this.trackDrawable;
    }

    public ColorStateList getTrackTintList() {
        return this.trackTintList;
    }

    public void invalidate() {
        this.updateDrawableTints();
        super.invalidate();
    }

    protected int[] onCreateDrawableState(int arg2) {
        int[] v2 = super.onCreateDrawableState(arg2 + 1);
        if(this.thumbIconDrawable != null) {
            MaterialSwitch.mergeDrawableStates(v2, MaterialSwitch.STATE_SET_WITH_ICON);
        }

        this.currentStateUnchecked = DrawableUtils.getUncheckedState(v2);
        this.currentStateChecked = DrawableUtils.getCheckedState(v2);
        return v2;
    }

    private void refreshThumbDrawable() {
        this.thumbDrawable = DrawableUtils.createTintableDrawableIfNeeded(this.thumbDrawable, this.thumbTintList, this.getThumbTintMode());
        this.thumbIconDrawable = DrawableUtils.createTintableDrawableIfNeeded(this.thumbIconDrawable, this.thumbIconTintList, this.thumbIconTintMode);
        this.updateDrawableTints();
        super.setThumbDrawable(DrawableUtils.compositeTwoLayeredDrawable(this.thumbDrawable, this.thumbIconDrawable, this.thumbIconSize, this.thumbIconSize));
        this.refreshDrawableState();
    }

    private void refreshTrackDrawable() {
        this.trackDrawable = DrawableUtils.createTintableDrawableIfNeeded(this.trackDrawable, this.trackTintList, this.getTrackTintMode());
        this.trackDecorationDrawable = DrawableUtils.createTintableDrawableIfNeeded(this.trackDecorationDrawable, this.trackDecorationTintList, this.trackDecorationTintMode);
        this.updateDrawableTints();
        Drawable v0 = this.trackDrawable;
        if(v0 != null && this.trackDecorationDrawable != null) {
            LayerDrawable v0_1 = new LayerDrawable(new Drawable[]{this.trackDrawable, this.trackDecorationDrawable});
        }
        else if(v0 != null) {
        }
        else {
            v0 = this.trackDecorationDrawable;
        }

        if(v0 != null) {
            this.setSwitchMinWidth(v0.getIntrinsicWidth());
        }

        super.setTrackDrawable(v0);
    }

    private static void setInterpolatedDrawableTintIfPossible(Drawable arg1, ColorStateList arg2, int[] arg3, int[] arg4, float arg5) {
        if(arg1 != null) {
            if(arg2 == null) {
            }
            else {
                DrawableCompat.setTint(arg1, ColorUtils.blendARGB(arg2.getColorForState(arg3, 0), arg2.getColorForState(arg4, 0), arg5));
            }
        }
    }

    public void setThumbDrawable(Drawable arg1) {
        this.thumbDrawable = arg1;
        this.refreshThumbDrawable();
    }

    public void setThumbIconDrawable(Drawable arg1) {
        this.thumbIconDrawable = arg1;
        this.refreshThumbDrawable();
    }

    public void setThumbIconResource(int arg2) {
        this.setThumbIconDrawable(AppCompatResources.getDrawable(this.getContext(), arg2));
    }

    public void setThumbIconSize(int arg2) {
        if(this.thumbIconSize != arg2) {
            this.thumbIconSize = arg2;
            this.refreshThumbDrawable();
        }
    }

    public void setThumbIconTintList(ColorStateList arg1) {
        this.thumbIconTintList = arg1;
        this.refreshThumbDrawable();
    }

    public void setThumbIconTintMode(PorterDuff$Mode arg1) {
        this.thumbIconTintMode = arg1;
        this.refreshThumbDrawable();
    }

    public void setThumbTintList(ColorStateList arg1) {
        this.thumbTintList = arg1;
        this.refreshThumbDrawable();
    }

    public void setThumbTintMode(PorterDuff$Mode arg1) {
        super.setThumbTintMode(arg1);
        this.refreshThumbDrawable();
    }

    public void setTrackDecorationDrawable(Drawable arg1) {
        this.trackDecorationDrawable = arg1;
        this.refreshTrackDrawable();
    }

    public void setTrackDecorationResource(int arg2) {
        this.setTrackDecorationDrawable(AppCompatResources.getDrawable(this.getContext(), arg2));
    }

    public void setTrackDecorationTintList(ColorStateList arg1) {
        this.trackDecorationTintList = arg1;
        this.refreshTrackDrawable();
    }

    public void setTrackDecorationTintMode(PorterDuff$Mode arg1) {
        this.trackDecorationTintMode = arg1;
        this.refreshTrackDrawable();
    }

    public void setTrackDrawable(Drawable arg1) {
        this.trackDrawable = arg1;
        this.refreshTrackDrawable();
    }

    public void setTrackTintList(ColorStateList arg1) {
        this.trackTintList = arg1;
        this.refreshTrackDrawable();
    }

    public void setTrackTintMode(PorterDuff$Mode arg1) {
        super.setTrackTintMode(arg1);
        this.refreshTrackDrawable();
    }

    private void updateDrawableTints() {
        if(this.thumbTintList != null || this.thumbIconTintList != null || this.trackTintList != null || this.trackDecorationTintList != null) {
            float v0 = this.getThumbPosition();
            ColorStateList v1 = this.thumbTintList;
            if(v1 != null) {
                MaterialSwitch.setInterpolatedDrawableTintIfPossible(this.thumbDrawable, v1, this.currentStateUnchecked, this.currentStateChecked, v0);
            }

            v1 = this.thumbIconTintList;
            if(v1 != null) {
                MaterialSwitch.setInterpolatedDrawableTintIfPossible(this.thumbIconDrawable, v1, this.currentStateUnchecked, this.currentStateChecked, v0);
            }

            v1 = this.trackTintList;
            if(v1 != null) {
                MaterialSwitch.setInterpolatedDrawableTintIfPossible(this.trackDrawable, v1, this.currentStateUnchecked, this.currentStateChecked, v0);
            }

            v1 = this.trackDecorationTintList;
            if(v1 == null) {
                return;
            }

            MaterialSwitch.setInterpolatedDrawableTintIfPossible(this.trackDecorationDrawable, v1, this.currentStateUnchecked, this.currentStateChecked, v0);
        }
        else {
        }
    }
}

