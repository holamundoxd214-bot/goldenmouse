package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;

public class Constraints extends ViewGroup {
    public class LayoutParams extends androidx.constraintlayout.widget.ConstraintLayout$LayoutParams {
        public float alpha;
        public boolean applyElevation;
        public float elevation;
        public float rotation;
        public float rotationX;
        public float rotationY;
        public float scaleX;
        public float scaleY;
        public float transformPivotX;
        public float transformPivotY;
        public float translationX;
        public float translationY;
        public float translationZ;

        public LayoutParams(int arg1, int arg2) {
            super(arg1, arg2);
            this.alpha = 1f;
            this.applyElevation = false;
            this.elevation = 0f;
            this.rotation = 0f;
            this.rotationX = 0f;
            this.rotationY = 0f;
            this.scaleX = 1f;
            this.scaleY = 1f;
            this.transformPivotX = 0f;
            this.transformPivotY = 0f;
            this.translationX = 0f;
            this.translationY = 0f;
            this.translationZ = 0f;
        }

        public LayoutParams(Context arg4, AttributeSet arg5) {
            super(arg4, arg5);
            this.alpha = 1f;
            int v1 = 0;
            this.applyElevation = false;
            this.elevation = 0f;
            this.rotation = 0f;
            this.rotationX = 0f;
            this.rotationY = 0f;
            this.scaleX = 1f;
            this.scaleY = 1f;
            this.transformPivotX = 0f;
            this.transformPivotY = 0f;
            this.translationX = 0f;
            this.translationY = 0f;
            this.translationZ = 0f;
            TypedArray v4 = arg4.obtainStyledAttributes(arg5, styleable.ConstraintSet);
            int v5 = v4.getIndexCount();
            while(v1 < v5) {
                int v0 = v4.getIndex(v1);
                if(v0 == styleable.ConstraintSet_android_alpha) {
                    this.alpha = v4.getFloat(v0, this.alpha);
                }
                else if(v0 == styleable.ConstraintSet_android_elevation) {
                    this.elevation = v4.getFloat(v0, this.elevation);
                    this.applyElevation = true;
                }
                else if(v0 == styleable.ConstraintSet_android_rotationX) {
                    this.rotationX = v4.getFloat(v0, this.rotationX);
                }
                else if(v0 == styleable.ConstraintSet_android_rotationY) {
                    this.rotationY = v4.getFloat(v0, this.rotationY);
                }
                else if(v0 == styleable.ConstraintSet_android_rotation) {
                    this.rotation = v4.getFloat(v0, this.rotation);
                }
                else if(v0 == styleable.ConstraintSet_android_scaleX) {
                    this.scaleX = v4.getFloat(v0, this.scaleX);
                }
                else if(v0 == styleable.ConstraintSet_android_scaleY) {
                    this.scaleY = v4.getFloat(v0, this.scaleY);
                }
                else if(v0 == styleable.ConstraintSet_android_transformPivotX) {
                    this.transformPivotX = v4.getFloat(v0, this.transformPivotX);
                }
                else if(v0 == styleable.ConstraintSet_android_transformPivotY) {
                    this.transformPivotY = v4.getFloat(v0, this.transformPivotY);
                }
                else if(v0 == styleable.ConstraintSet_android_translationX) {
                    this.translationX = v4.getFloat(v0, this.translationX);
                }
                else if(v0 == styleable.ConstraintSet_android_translationY) {
                    this.translationY = v4.getFloat(v0, this.translationY);
                }
                else if(v0 == styleable.ConstraintSet_android_translationZ) {
                    this.translationZ = v4.getFloat(v0, this.translationZ);
                }

                ++v1;
            }
        }

        public LayoutParams(LayoutParams arg2) {
            super(((androidx.constraintlayout.widget.ConstraintLayout$LayoutParams)arg2));
            this.alpha = 1f;
            this.applyElevation = false;
            this.elevation = 0f;
            this.rotation = 0f;
            this.rotationX = 0f;
            this.rotationY = 0f;
            this.scaleX = 1f;
            this.scaleY = 1f;
            this.transformPivotX = 0f;
            this.transformPivotY = 0f;
            this.translationX = 0f;
            this.translationY = 0f;
            this.translationZ = 0f;
        }
    }

    public static final String TAG = "Constraints";
    ConstraintSet myConstraintSet;

    public Constraints(Context arg1) {
        super(arg1);
        super.setVisibility(8);
    }

    public Constraints(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
        this.init(arg2);
        super.setVisibility(8);
    }

    public Constraints(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.init(arg2);
        super.setVisibility(8);
    }

    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return this.generateDefaultLayoutParams();
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public ViewGroup$LayoutParams generateLayoutParams(AttributeSet arg1) {
        return this.generateLayoutParams(arg1);
    }

    public LayoutParams generateLayoutParams(AttributeSet arg2) {
        return new LayoutParams(this.getContext(), arg2);
    }

    protected ViewGroup$LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg1) {
        return new androidx.constraintlayout.widget.ConstraintLayout$LayoutParams(arg1);
    }

    public ConstraintSet getConstraintSet() {
        ConstraintSet v0 = this.myConstraintSet;
        if(v0 == null) {
            v0 = new ConstraintSet();
            this.myConstraintSet = v0;
        }

        v0.clone(this);
        return this.myConstraintSet;
    }

    private void init(AttributeSet arg1) {
        Log.v("Constraints", " ################# init");
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
    }
}

