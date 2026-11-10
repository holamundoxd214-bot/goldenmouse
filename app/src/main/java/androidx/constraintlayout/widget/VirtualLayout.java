package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;

public abstract class VirtualLayout extends ConstraintHelper {
    private boolean mApplyElevationOnAttach;
    private boolean mApplyVisibilityOnAttach;

    public VirtualLayout(Context arg1) {
        super(arg1);
    }

    public VirtualLayout(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
    }

    public VirtualLayout(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
    }

    protected void init(AttributeSet arg6) {
        super.init(arg6);
        if(arg6 != null) {
            TypedArray v6 = this.getContext().obtainStyledAttributes(arg6, styleable.ConstraintLayout_Layout);
            int v0 = v6.getIndexCount();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                int v2 = v6.getIndex(v1);
                if(v2 == styleable.ConstraintLayout_Layout_android_visibility) {
                    this.mApplyVisibilityOnAttach = true;
                }
                else if(v2 == styleable.ConstraintLayout_Layout_android_elevation) {
                    this.mApplyElevationOnAttach = true;
                }
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if((this.mApplyVisibilityOnAttach) || (this.mApplyElevationOnAttach)) {
            ViewParent v0 = this.getParent();
            if(v0 != null && ((v0 instanceof ConstraintLayout))) {
                int v1 = this.getVisibility();
                float v2 = this.getElevation();
                int v3;
                for(v3 = 0; v3 < this.mCount; ++v3) {
                    View v4 = ((ConstraintLayout)v0).getViewById(this.mIds[v3]);
                    if(v4 != null) {
                        if(this.mApplyVisibilityOnAttach) {
                            v4.setVisibility(v1);
                        }

                        if(!this.mApplyElevationOnAttach) {
                            goto label_28;
                        }

                        if(v2 <= 0f) {
                            goto label_28;
                        }

                        v4.setTranslationZ(v4.getTranslationZ() + v2);
                    }

                label_28:
                }
            }
        }
    }

    public void onMeasure(androidx.constraintlayout.solver.widgets.VirtualLayout arg1, int arg2, int arg3) {
    }

    public void setElevation(float arg1) {
        super.setElevation(arg1);
        this.applyLayoutFeatures();
    }

    public void setVisibility(int arg1) {
        super.setVisibility(arg1);
        this.applyLayoutFeatures();
    }
}

