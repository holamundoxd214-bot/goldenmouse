package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CircularProgressIndicator extends BaseProgressIndicator {
    @Retention(value=RetentionPolicy.SOURCE) @public interface IndicatorDirection {
    }

    public static final int DEF_STYLE_RES = 0;
    public static final int INDICATOR_DIRECTION_CLOCKWISE = 0;
    public static final int INDICATOR_DIRECTION_COUNTERCLOCKWISE = 1;

    static {
        CircularProgressIndicator.DEF_STYLE_RES = style.Widget_MaterialComponents_CircularProgressIndicator;
    }

    public CircularProgressIndicator(Context arg2) {
        this(arg2, null);
    }

    public CircularProgressIndicator(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.circularProgressIndicatorStyle);
    }

    public CircularProgressIndicator(Context arg2, AttributeSet arg3, int arg4) {
        super(arg2, arg3, arg4, CircularProgressIndicator.DEF_STYLE_RES);
        this.initializeDrawables();
    }

    BaseProgressIndicatorSpec createSpec(Context arg1, AttributeSet arg2) {
        return this.createSpec(arg1, arg2);
    }

    CircularProgressIndicatorSpec createSpec(Context arg1, AttributeSet arg2) {
        return new CircularProgressIndicatorSpec(arg1, arg2);
    }

    public int getIndicatorDirection() {
        return this.spec.indicatorDirection;
    }

    public int getIndicatorInset() {
        return this.spec.indicatorInset;
    }

    public int getIndicatorSize() {
        return this.spec.indicatorSize;
    }

    private void initializeDrawables() {
        this.setIndeterminateDrawable(IndeterminateDrawable.createCircularDrawable(this.getContext(), this.spec));
        this.setProgressDrawable(DeterminateDrawable.createCircularDrawable(this.getContext(), this.spec));
    }

    public void setIndicatorDirection(int arg2) {
        this.spec.indicatorDirection = arg2;
        this.invalidate();
    }

    public void setIndicatorInset(int arg2) {
        if(this.spec.indicatorInset != arg2) {
            this.spec.indicatorInset = arg2;
            this.invalidate();
        }
    }

    public void setIndicatorSize(int arg2) {
        arg2 = Math.max(arg2, this.getTrackThickness() * 2);
        if(this.spec.indicatorSize != arg2) {
            this.spec.indicatorSize = arg2;
            this.spec.validateSpec();
            this.invalidate();
        }
    }

    public void setTrackThickness(int arg1) {
        super.setTrackThickness(arg1);
        this.spec.validateSpec();
    }
}

