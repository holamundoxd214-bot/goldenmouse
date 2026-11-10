package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;

public class Layer extends ConstraintHelper {
    private static final String TAG = "Layer";
    private boolean mApplyElevationOnAttach;
    private boolean mApplyVisibilityOnAttach;
    protected float mComputedCenterX;
    protected float mComputedCenterY;
    protected float mComputedMaxX;
    protected float mComputedMaxY;
    protected float mComputedMinX;
    protected float mComputedMinY;
    ConstraintLayout mContainer;
    private float mGroupRotateAngle;
    boolean mNeedBounds;
    private float mRotationCenterX;
    private float mRotationCenterY;
    private float mScaleX;
    private float mScaleY;
    private float mShiftX;
    private float mShiftY;
    View[] mViews;

    public Layer(Context arg2) {
        super(arg2);
        this.mRotationCenterX = NaNf;
        this.mRotationCenterY = NaNf;
        this.mGroupRotateAngle = NaNf;
        this.mScaleX = 1f;
        this.mScaleY = 1f;
        this.mComputedCenterX = NaNf;
        this.mComputedCenterY = NaNf;
        this.mComputedMaxX = NaNf;
        this.mComputedMaxY = NaNf;
        this.mComputedMinX = NaNf;
        this.mComputedMinY = NaNf;
        this.mNeedBounds = true;
        this.mViews = null;
        this.mShiftX = 0f;
        this.mShiftY = 0f;
    }

    public Layer(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
        this.mRotationCenterX = NaNf;
        this.mRotationCenterY = NaNf;
        this.mGroupRotateAngle = NaNf;
        this.mScaleX = 1f;
        this.mScaleY = 1f;
        this.mComputedCenterX = NaNf;
        this.mComputedCenterY = NaNf;
        this.mComputedMaxX = NaNf;
        this.mComputedMaxY = NaNf;
        this.mComputedMinX = NaNf;
        this.mComputedMinY = NaNf;
        this.mNeedBounds = true;
        this.mViews = null;
        this.mShiftX = 0f;
        this.mShiftY = 0f;
    }

    public Layer(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.mRotationCenterX = NaNf;
        this.mRotationCenterY = NaNf;
        this.mGroupRotateAngle = NaNf;
        this.mScaleX = 1f;
        this.mScaleY = 1f;
        this.mComputedCenterX = NaNf;
        this.mComputedCenterY = NaNf;
        this.mComputedMaxX = NaNf;
        this.mComputedMaxY = NaNf;
        this.mComputedMinX = NaNf;
        this.mComputedMinY = NaNf;
        this.mNeedBounds = true;
        this.mViews = null;
        this.mShiftX = 0f;
        this.mShiftY = 0f;
    }

    protected void calcCenters() {
        if(this.mContainer == null) {
        }
        else {
            if(!this.mNeedBounds && !Float.isNaN(this.mComputedCenterX) && !Float.isNaN(this.mComputedCenterY)) {
                return;
            }

            goto label_12;
        }

        return;
    label_12:
        if(!Float.isNaN(this.mRotationCenterX)) {
            if(Float.isNaN(this.mRotationCenterY)) {
            }
            else {
                this.mComputedCenterY = this.mRotationCenterY;
                this.mComputedCenterX = this.mRotationCenterX;
                return;
            }
        }

        View[] v0 = this.getViews(this.mContainer);
        int v1 = 0;
        int v2 = v0[0].getLeft();
        int v3 = v0[0].getTop();
        int v4 = v0[0].getRight();
        int v5 = v0[0].getBottom();
        while(v1 < this.mCount) {
            View v6 = v0[v1];
            v2 = Math.min(v2, v6.getLeft());
            v3 = Math.min(v3, v6.getTop());
            v4 = Math.max(v4, v6.getRight());
            v5 = Math.max(v5, v6.getBottom());
            ++v1;
        }

        this.mComputedMaxX = ((float)v4);
        this.mComputedMaxY = ((float)v5);
        this.mComputedMinX = ((float)v2);
        this.mComputedMinY = ((float)v3);
        this.mComputedCenterX = Float.isNaN(this.mRotationCenterX) ? ((float)((v2 + v4) / 2)) : this.mRotationCenterX;
        if(Float.isNaN(this.mRotationCenterY)) {
            this.mComputedCenterY = ((float)((v3 + v5) / 2));
            return;
        }

        this.mComputedCenterY = this.mRotationCenterY;
    }

    protected void init(AttributeSet arg6) {
        super.init(arg6);
        int v0 = 0;
        this.mUseViewMeasure = false;
        if(arg6 != null) {
            TypedArray v6 = this.getContext().obtainStyledAttributes(arg6, styleable.ConstraintLayout_Layout);
            int v1 = v6.getIndexCount();
            while(v0 < v1) {
                int v2 = v6.getIndex(v0);
                if(v2 == styleable.ConstraintLayout_Layout_android_visibility) {
                    this.mApplyVisibilityOnAttach = true;
                }
                else if(v2 == styleable.ConstraintLayout_Layout_android_elevation) {
                    this.mApplyElevationOnAttach = true;
                }

                ++v0;
            }
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mContainer = this.getParent();
        if((this.mApplyVisibilityOnAttach) || (this.mApplyElevationOnAttach)) {
            int v0 = this.getVisibility();
            float v1 = this.getElevation();
            int v2;
            for(v2 = 0; v2 < this.mCount; ++v2) {
                View v3 = this.mContainer.getViewById(this.mIds[v2]);
                if(v3 != null) {
                    if(this.mApplyVisibilityOnAttach) {
                        v3.setVisibility(v0);
                    }

                    if(!this.mApplyElevationOnAttach) {
                        goto label_27;
                    }

                    if(v1 <= 0f) {
                        goto label_27;
                    }

                    v3.setTranslationZ(v3.getTranslationZ() + v1);
                }

            label_27:
            }
        }
    }

    private void reCacheViews() {
        if(this.mContainer == null) {
        }
        else if(this.mCount == 0) {
        }
        else {
            View[] v0 = this.mViews;
            if(v0 == null || v0.length != this.mCount) {
                this.mViews = new View[this.mCount];
            }

            int v0_1;
            for(v0_1 = 0; v0_1 < this.mCount; ++v0_1) {
                this.mViews[v0_1] = this.mContainer.getViewById(this.mIds[v0_1]);
            }
        }
    }

    public void setElevation(float arg1) {
        super.setElevation(arg1);
        this.applyLayoutFeatures();
    }

    public void setPivotX(float arg1) {
        this.mRotationCenterX = arg1;
        this.transform();
    }

    public void setPivotY(float arg1) {
        this.mRotationCenterY = arg1;
        this.transform();
    }

    public void setRotation(float arg1) {
        this.mGroupRotateAngle = arg1;
        this.transform();
    }

    public void setScaleX(float arg1) {
        this.mScaleX = arg1;
        this.transform();
    }

    public void setScaleY(float arg1) {
        this.mScaleY = arg1;
        this.transform();
    }

    public void setTranslationX(float arg1) {
        this.mShiftX = arg1;
        this.transform();
    }

    public void setTranslationY(float arg1) {
        this.mShiftY = arg1;
        this.transform();
    }

    public void setVisibility(int arg1) {
        super.setVisibility(arg1);
        this.applyLayoutFeatures();
    }

    private void transform() {
        if(this.mContainer == null) {
        }
        else {
            if(this.mViews == null) {
                this.reCacheViews();
            }

            this.calcCenters();
            double v0 = Math.toRadians(((double)this.mGroupRotateAngle));
            float v2 = ((float)Math.sin(v0));
            float v0_1 = ((float)Math.cos(v0));
            float v1 = this.mScaleX;
            float v3 = v1 * v0_1;
            float v5 = -this.mScaleY * v2;
            v1 *= v2;
            float v4 = this.mScaleY * v0_1;
            int v0_2;
            for(v0_2 = 0; v0_2 < this.mCount; ++v0_2) {
                View v2_1 = this.mViews[v0_2];
                int v6 = (v2_1.getLeft() + v2_1.getRight()) / 2;
                int v7 = (v2_1.getTop() + v2_1.getBottom()) / 2;
                float v6_1 = (((float)v6)) - this.mComputedCenterX;
                float v7_1 = (((float)v7)) - this.mComputedCenterY;
                float v8 = v3 * v6_1 + v5 * v7_1 - v6_1 + this.mShiftX;
                v6_1 = v6_1 * v1 + v4 * v7_1 - v7_1 + this.mShiftY;
                v2_1.setTranslationX(v8);
                v2_1.setTranslationY(v6_1);
                v2_1.setScaleY(this.mScaleY);
                v2_1.setScaleX(this.mScaleX);
                v2_1.setRotation(this.mGroupRotateAngle);
            }
        }
    }

    public void updatePostLayout(ConstraintLayout arg5) {
        this.reCacheViews();
        this.mComputedCenterX = NaNf;
        this.mComputedCenterY = NaNf;
        ConstraintWidget v5 = this.getLayoutParams().getConstraintWidget();
        v5.setWidth(0);
        v5.setHeight(0);
        this.calcCenters();
        this.layout((((int)this.mComputedMinX)) - this.getPaddingLeft(), (((int)this.mComputedMinY)) - this.getPaddingTop(), (((int)this.mComputedMaxX)) + this.getPaddingRight(), (((int)this.mComputedMaxY)) + this.getPaddingBottom());
        if(!Float.isNaN(this.mGroupRotateAngle)) {
            this.transform();
        }
    }

    public void updatePreDraw(ConstraintLayout arg2) {
        this.mContainer = arg2;
        float v2 = this.getRotation();
        if(v2 == 0f) {
            if(!Float.isNaN(this.mGroupRotateAngle)) {
                this.mGroupRotateAngle = v2;
            }

            return;
        }

        this.mGroupRotateAngle = v2;
    }
}

