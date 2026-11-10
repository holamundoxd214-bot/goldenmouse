package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;

public abstract class BaseProgressIndicatorSpec {
    public int hideAnimationBehavior;
    public int[] indicatorColors;
    public int showAnimationBehavior;
    public int trackColor;
    public int trackCornerRadius;
    public int trackThickness;

    protected BaseProgressIndicatorSpec(Context arg9, AttributeSet arg10, int arg11, int arg12) {
        super();
        this.indicatorColors = new int[0];
        int v1 = arg9.getResources().getDimensionPixelSize(dimen.mtrl_progress_track_thickness);
        Context v2 = arg9;
        TypedArray v9 = ThemeEnforcement.obtainStyledAttributes(v2, arg10, styleable.BaseProgressIndicator, arg11, arg12, new int[0]);
        this.trackThickness = MaterialResources.getDimensionPixelSize(v2, v9, styleable.BaseProgressIndicator_trackThickness, v1);
        this.trackCornerRadius = Math.min(MaterialResources.getDimensionPixelSize(v2, v9, styleable.BaseProgressIndicator_trackCornerRadius, 0), this.trackThickness / 2);
        this.showAnimationBehavior = v9.getInt(styleable.BaseProgressIndicator_showAnimationBehavior, 0);
        this.hideAnimationBehavior = v9.getInt(styleable.BaseProgressIndicator_hideAnimationBehavior, 0);
        this.loadIndicatorColors(v2, v9);
        this.loadTrackColor(v2, v9);
        v9.recycle();
    }

    public boolean isHideAnimationEnabled() {
        if(this.hideAnimationBehavior != 0) {
            return 1;
        }

        return 0;
    }

    public boolean isShowAnimationEnabled() {
        if(this.showAnimationBehavior != 0) {
            return 1;
        }

        return 0;
    }

    private void loadIndicatorColors(Context arg4, TypedArray arg5) {
        int v1 = -1;
        if(!arg5.hasValue(styleable.BaseProgressIndicator_indicatorColor)) {
            this.indicatorColors = new int[]{MaterialColors.getColor(arg4, attr.colorPrimary, v1)};
            return;
        }

        if(arg5.peekValue(styleable.BaseProgressIndicator_indicatorColor).type != 1) {
            this.indicatorColors = new int[]{arg5.getColor(styleable.BaseProgressIndicator_indicatorColor, v1)};
            return;
        }

        int[] v4 = arg4.getResources().getIntArray(arg5.getResourceId(styleable.BaseProgressIndicator_indicatorColor, v1));
        this.indicatorColors = v4;
        if(v4.length != 0) {
            return;
        }

        throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
    }

    private void loadTrackColor(Context arg2, TypedArray arg3) {
        if(arg3.hasValue(styleable.BaseProgressIndicator_trackColor)) {
            this.trackColor = arg3.getColor(styleable.BaseProgressIndicator_trackColor, -1);
            return;
        }

        this.trackColor = this.indicatorColors[0];
        TypedArray v2 = arg2.getTheme().obtainStyledAttributes(new int[]{0x1010033});
        float v3 = v2.getFloat(0, 0.2f);
        v2.recycle();
        this.trackColor = MaterialColors.compositeARGBWithAlpha(this.trackColor, ((int)(v3 * 255f)));
    }

    abstract void validateSpec();
}

