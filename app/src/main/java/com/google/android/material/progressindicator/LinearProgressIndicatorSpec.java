package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;

public final class LinearProgressIndicatorSpec extends BaseProgressIndicatorSpec {
    boolean drawHorizontallyInverse;
    public int indeterminateAnimationType;
    public int indicatorDirection;

    public LinearProgressIndicatorSpec(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.linearProgressIndicatorStyle);
    }

    public LinearProgressIndicatorSpec(Context arg2, AttributeSet arg3, int arg4) {
        this(arg2, arg3, arg4, LinearProgressIndicator.DEF_STYLE_RES);
    }

    public LinearProgressIndicatorSpec(Context arg7, AttributeSet arg8, int arg9, int arg10) {
        super(arg7, arg8, arg9, arg10);
        boolean v9 = false;
        TypedArray v7 = ThemeEnforcement.obtainStyledAttributes(arg7, arg8, styleable.LinearProgressIndicator, attr.linearProgressIndicatorStyle, LinearProgressIndicator.DEF_STYLE_RES, new int[0]);
        this.indeterminateAnimationType = v7.getInt(styleable.LinearProgressIndicator_indeterminateAnimationType, 1);
        this.indicatorDirection = v7.getInt(styleable.LinearProgressIndicator_indicatorDirectionLinear, 0);
        v7.recycle();
        this.validateSpec();
        if(this.indicatorDirection == 1) {
            v9 = true;
        }

        this.drawHorizontallyInverse = v9;
    }

    void validateSpec() {
        if(this.indeterminateAnimationType == 0) {
            if(this.trackCornerRadius > 0) {
                throw new IllegalArgumentException("Rounded corners are not supported in contiguous indeterminate animation.");
            }
            else if(this.indicatorColors.length >= 3) {
            }
            else {
                throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
            }
        }
    }
}

