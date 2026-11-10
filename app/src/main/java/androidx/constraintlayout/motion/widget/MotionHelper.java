package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.R$styleable;

public class MotionHelper extends ConstraintHelper implements Animatable, TransitionListener {
    private float mProgress;
    private boolean mUseOnHide;
    private boolean mUseOnShow;
    protected View[] views;

    public MotionHelper(Context arg1) {
        super(arg1);
        this.mUseOnShow = false;
        this.mUseOnHide = false;
    }

    public MotionHelper(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
        this.mUseOnShow = false;
        this.mUseOnHide = false;
        this.init(arg2);
    }

    public MotionHelper(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.mUseOnShow = false;
        this.mUseOnHide = false;
        this.init(arg2);
    }

    public float getProgress() {
        return this.mProgress;
    }

    protected void init(AttributeSet arg5) {
        super.init(arg5);
        if(arg5 != null) {
            TypedArray v5 = this.getContext().obtainStyledAttributes(arg5, styleable.MotionHelper);
            int v0 = v5.getIndexCount();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                int v2 = v5.getIndex(v1);
                if(v2 == styleable.MotionHelper_onShow) {
                    this.mUseOnShow = v5.getBoolean(v2, this.mUseOnShow);
                }
                else if(v2 == styleable.MotionHelper_onHide) {
                    this.mUseOnHide = v5.getBoolean(v2, this.mUseOnHide);
                }
            }
        }
    }

    public boolean isUseOnHide() {
        return this.mUseOnHide;
    }

    public boolean isUsedOnShow() {
        return this.mUseOnShow;
    }

    public void onTransitionChange(MotionLayout arg1, int arg2, int arg3, float arg4) {
    }

    public void onTransitionCompleted(MotionLayout arg1, int arg2) {
    }

    public void onTransitionStarted(MotionLayout arg1, int arg2, int arg3) {
    }

    public void onTransitionTrigger(MotionLayout arg1, int arg2, boolean arg3, float arg4) {
    }

    public void setProgress(float arg6) {
        this.mProgress = arg6;
        int v1 = 0;
        if(this.mCount > 0) {
            this.views = this.getViews(this.getParent());
            while(v1 < this.mCount) {
                this.setProgress(this.views[v1], arg6);
                ++v1;
            }
        }
        else {
            ViewParent v0 = this.getParent();
            int v2 = ((ViewGroup)v0).getChildCount();
            while(v1 < v2) {
                View v3 = ((ViewGroup)v0).getChildAt(v1);
                if((v3 instanceof MotionHelper)) {
                }
                else {
                    this.setProgress(v3, arg6);
                }

                ++v1;
            }
        }
    }

    public void setProgress(View arg1, float arg2) {
    }
}

