package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;

public final class CircularProgressIndicatorSpec extends BaseProgressIndicatorSpec {
    public int indicatorDirection;
    public int indicatorInset;
    public int indicatorSize;

    public CircularProgressIndicatorSpec(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.circularProgressIndicatorStyle);
    }

    public CircularProgressIndicatorSpec(Context arg2, AttributeSet arg3, int arg4) {
        this(arg2, arg3, arg4, CircularProgressIndicator.DEF_STYLE_RES);
    }

    public CircularProgressIndicatorSpec(Context arg10, AttributeSet arg11, int arg12, int arg13) {
        super(arg10, arg11, arg12, arg13);
        int v0 = arg10.getResources().getDimensionPixelSize(dimen.mtrl_progress_circular_size_medium);
        int v1 = arg10.getResources().getDimensionPixelSize(dimen.mtrl_progress_circular_inset_medium);
        Context v2 = arg10;
        TypedArray v10 = ThemeEnforcement.obtainStyledAttributes(v2, arg11, styleable.CircularProgressIndicator, arg12, arg13, new int[0]);
        this.indicatorSize = Math.max(MaterialResources.getDimensionPixelSize(v2, v10, styleable.CircularProgressIndicator_indicatorSize, v0), this.trackThickness * 2);
        this.indicatorInset = MaterialResources.getDimensionPixelSize(v2, v10, styleable.CircularProgressIndicator_indicatorInset, v1);
        this.indicatorDirection = v10.getInt(styleable.CircularProgressIndicator_indicatorDirectionCircular, 0);
        v10.recycle();
        this.validateSpec();
    }

    void validateSpec() {
    }
}

