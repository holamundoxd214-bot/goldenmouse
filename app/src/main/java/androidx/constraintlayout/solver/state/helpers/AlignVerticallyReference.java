package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State$Helper;
import androidx.constraintlayout.solver.state.State;
import java.util.Iterator;

public class AlignVerticallyReference extends HelperReference {
    private float mBias;
    private Object mBottomToBottom;
    private Object mBottomToTop;
    private Object mTopToBottom;
    private Object mTopToTop;

    public AlignVerticallyReference(State arg2) {
        super(arg2, Helper.ALIGN_VERTICALLY);
        this.mBias = 0.5f;
    }

    public void apply() {
        Iterator v0 = this.mReferences.iterator();
        while(v0.hasNext()) {
            ConstraintReference v1 = this.mState.constraints(v0.next());
            v1.clearVertical();
            Object v2 = this.mTopToTop;
            if(v2 != null) {
                v1.topToTop(v2);
            }
            else {
                v2 = this.mTopToBottom;
                if(v2 != null) {
                    v1.topToBottom(v2);
                }
                else {
                    v1.topToTop(State.PARENT);
                }
            }

            v2 = this.mBottomToTop;
            if(v2 != null) {
                v1.bottomToTop(v2);
            }
            else {
                v2 = this.mBottomToBottom;
                if(v2 != null) {
                    v1.bottomToBottom(v2);
                }
                else {
                    v1.bottomToBottom(State.PARENT);
                }
            }

            float v2_1 = this.mBias;
            if(v2_1 == 0.5f) {
                continue;
            }

            v1.verticalBias(v2_1);
        }
    }

    public void bias(float arg1) {
        this.mBias = arg1;
    }

    public void bottomToBottom(Object arg1) {
        this.mBottomToBottom = arg1;
    }

    public void bottomToTop(Object arg1) {
        this.mBottomToTop = arg1;
    }

    public void topToBottom(Object arg1) {
        this.mTopToBottom = arg1;
    }

    public void topToTop(Object arg1) {
        this.mTopToTop = arg1;
    }
}

