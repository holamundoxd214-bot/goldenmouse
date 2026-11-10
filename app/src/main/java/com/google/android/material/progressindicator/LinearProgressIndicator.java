package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LinearProgressIndicator extends BaseProgressIndicator {
    @Retention(value=RetentionPolicy.SOURCE) @public interface IndeterminateAnimationType {
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface IndicatorDirection {
    }

    public static final int DEF_STYLE_RES = 0;
    public static final int INDETERMINATE_ANIMATION_TYPE_CONTIGUOUS = 0;
    public static final int INDETERMINATE_ANIMATION_TYPE_DISJOINT = 1;
    public static final int INDICATOR_DIRECTION_END_TO_START = 3;
    public static final int INDICATOR_DIRECTION_LEFT_TO_RIGHT = 0;
    public static final int INDICATOR_DIRECTION_RIGHT_TO_LEFT = 1;
    public static final int INDICATOR_DIRECTION_START_TO_END = 2;

    static {
        LinearProgressIndicator.DEF_STYLE_RES = style.Widget_MaterialComponents_LinearProgressIndicator;
    }

    public LinearProgressIndicator(Context arg2) {
        this(arg2, null);
    }

    public LinearProgressIndicator(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.linearProgressIndicatorStyle);
    }

    public LinearProgressIndicator(Context arg2, AttributeSet arg3, int arg4) {
        super(arg2, arg3, arg4, LinearProgressIndicator.DEF_STYLE_RES);
        this.initializeDrawables();
    }

    BaseProgressIndicatorSpec createSpec(Context arg1, AttributeSet arg2) {
        return this.createSpec(arg1, arg2);
    }

    LinearProgressIndicatorSpec createSpec(Context arg1, AttributeSet arg2) {
        return new LinearProgressIndicatorSpec(arg1, arg2);
    }

    public int getIndeterminateAnimationType() {
        return this.spec.indeterminateAnimationType;
    }

    public int getIndicatorDirection() {
        return this.spec.indicatorDirection;
    }

    private void initializeDrawables() {
        this.setIndeterminateDrawable(IndeterminateDrawable.createLinearDrawable(this.getContext(), this.spec));
        this.setProgressDrawable(DeterminateDrawable.createLinearDrawable(this.getContext(), this.spec));
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
        super.onLayout(arg1, arg2, arg3, arg4, arg5);
        BaseProgressIndicatorSpec v1 = this.spec;
        boolean v3 = true;
        if(this.spec.indicatorDirection != 1 && (ViewCompat.getLayoutDirection(((View)this)) != 1 || this.spec.indicatorDirection != 2) && (ViewCompat.getLayoutDirection(((View)this)) != 0 || this.spec.indicatorDirection != 3)) {
            v3 = false;
        }

        ((LinearProgressIndicatorSpec)v1).drawHorizontallyInverse = v3;
    }

    protected void onSizeChanged(int arg1, int arg2, int arg3, int arg4) {
        arg1 -= this.getPaddingLeft() + this.getPaddingRight();
        arg2 -= this.getPaddingTop() + this.getPaddingBottom();
        IndeterminateDrawable v3 = this.getIndeterminateDrawable();
        if(v3 != null) {
            ((Drawable)v3).setBounds(0, 0, arg1, arg2);
        }

        DeterminateDrawable v0 = this.getProgressDrawable();
        if(v0 != null) {
            ((Drawable)v0).setBounds(0, 0, arg1, arg2);
        }
    }

    public void setIndeterminateAnimationType(int arg4) {
        if(this.spec.indeterminateAnimationType == arg4) {
            return;
        }

        if(this.visibleToUser()) {
            if(!this.isIndeterminate()) {
            }
            else {
                throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
            }
        }

        this.spec.indeterminateAnimationType = arg4;
        this.spec.validateSpec();
        if(arg4 == 0) {
            this.getIndeterminateDrawable().setAnimatorDelegate(new LinearIndeterminateContiguousAnimatorDelegate(this.spec));
        }
        else {
            this.getIndeterminateDrawable().setAnimatorDelegate(new LinearIndeterminateDisjointAnimatorDelegate(this.getContext(), this.spec));
        }

        this.invalidate();
    }

    public void setIndicatorColor(int[] arg1) {
        super.setIndicatorColor(arg1);
        this.spec.validateSpec();
    }

    public void setIndicatorDirection(int arg5) {
        this.spec.indicatorDirection = arg5;
        BaseProgressIndicatorSpec v0 = this.spec;
        boolean v1 = true;
        if(arg5 != 1 && (ViewCompat.getLayoutDirection(((View)this)) != 1 || this.spec.indicatorDirection != 2) && (ViewCompat.getLayoutDirection(((View)this)) != 0 || arg5 != 3)) {
            v1 = false;
        }

        ((LinearProgressIndicatorSpec)v0).drawHorizontallyInverse = v1;
        this.invalidate();
    }

    public void setProgressCompat(int arg2, boolean arg3) {
        if(this.spec != null && this.spec.indeterminateAnimationType == 0 && (this.isIndeterminate())) {
            return;
        }

        super.setProgressCompat(arg2, arg3);
    }

    public void setTrackCornerRadius(int arg1) {
        super.setTrackCornerRadius(arg1);
        this.spec.validateSpec();
        this.invalidate();
    }
}

