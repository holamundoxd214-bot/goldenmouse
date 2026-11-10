package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State$Helper;
import androidx.constraintlayout.solver.state.State;
import java.util.Iterator;

public class AlignHorizontallyReference extends HelperReference {
    private float mBias;
    private Object mEndToEnd;
    private Object mEndToStart;
    private Object mStartToEnd;
    private Object mStartToStart;

    public AlignHorizontallyReference(State arg2) {
        super(arg2, Helper.ALIGN_VERTICALLY);
        this.mBias = 0.5f;
    }

    public void apply() {
        Iterator v0 = this.mReferences.iterator();
        while(v0.hasNext()) {
            ConstraintReference v1 = this.mState.constraints(v0.next());
            v1.clearHorizontal();
            Object v2 = this.mStartToStart;
            if(v2 != null) {
                v1.startToStart(v2);
            }
            else {
                v2 = this.mStartToEnd;
                if(v2 != null) {
                    v1.startToEnd(v2);
                }
                else {
                    v1.startToStart(State.PARENT);
                }
            }

            v2 = this.mEndToStart;
            if(v2 != null) {
                v1.endToStart(v2);
            }
            else {
                v2 = this.mEndToEnd;
                if(v2 != null) {
                    v1.endToEnd(v2);
                }
                else {
                    v1.endToEnd(State.PARENT);
                }
            }

            float v2_1 = this.mBias;
            if(v2_1 == 0.5f) {
                continue;
            }

            v1.horizontalBias(v2_1);
        }
    }

    public void bias(float arg1) {
        this.mBias = arg1;
    }

    public void endToEnd(Object arg1) {
        this.mEndToEnd = arg1;
    }

    public void endToStart(Object arg1) {
        this.mEndToStart = arg1;
    }

    public void startToEnd(Object arg1) {
        this.mStartToEnd = arg1;
    }

    public void startToStart(Object arg1) {
        this.mStartToStart = arg1;
    }
}

