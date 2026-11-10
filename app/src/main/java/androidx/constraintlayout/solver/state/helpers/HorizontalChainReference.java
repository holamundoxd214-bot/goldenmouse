package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.State$Chain;
import androidx.constraintlayout.solver.state.State$Helper;
import androidx.constraintlayout.solver.state.State;
import java.util.Iterator;

public class HorizontalChainReference extends ChainReference {
    class androidx.constraintlayout.solver.state.helpers.HorizontalChainReference$1 {
        static {
            int[] v0 = new int[Chain.values().length];
            androidx.constraintlayout.solver.state.helpers.HorizontalChainReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Chain = v0;
            try {
                v0[Chain.SPREAD.ordinal()] = 1;
                goto label_8;
            }
            catch(NoSuchFieldError ) {
                try {
                label_8:
                    androidx.constraintlayout.solver.state.helpers.HorizontalChainReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Chain[Chain.SPREAD_INSIDE.ordinal()] = 2;
                    goto label_13;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_13:
                        androidx.constraintlayout.solver.state.helpers.HorizontalChainReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Chain[Chain.PACKED.ordinal()] = 3;
                        return;
                    }
                    catch(NoSuchFieldError ) {
                        return;
                    }
                }
            }
        }
    }

    private Object mEndToEnd;
    private Object mEndToStart;
    private Object mStartToEnd;
    private Object mStartToStart;

    public HorizontalChainReference(State arg2) {
        super(arg2, Helper.HORIZONTAL_CHAIN);
    }

    public void apply() {
        Iterator v0 = this.mReferences.iterator();
        while(v0.hasNext()) {
            this.mState.constraints(v0.next()).clearHorizontal();
        }

        v0 = this.mReferences.iterator();
        ConstraintReference v1 = null;
        ConstraintReference v2 = v1;
        while(v0.hasNext()) {
            ConstraintReference v3 = this.mState.constraints(v0.next());
            if(v2 == null) {
                Object v2_1 = this.mStartToStart;
                if(v2_1 != null) {
                    v3.startToStart(v2_1);
                }
                else {
                    v2_1 = this.mStartToEnd;
                    if(v2_1 != null) {
                        v3.startToEnd(v2_1);
                    }
                    else {
                        v3.startToStart(State.PARENT);
                    }
                }

                v2 = v3;
            }

            if(v1 != null) {
                v1.endToStart(v3.getKey());
                v3.startToEnd(v1.getKey());
            }

            v1 = v3;
        }

        if(v1 != null) {
            Object v0_1 = this.mEndToStart;
            if(v0_1 != null) {
                v1.endToStart(v0_1);
            }
            else {
                v0_1 = this.mEndToEnd;
                if(v0_1 != null) {
                    v1.endToEnd(v0_1);
                }
                else {
                    v1.endToEnd(State.PARENT);
                }
            }
        }

        if(v2 != null && this.mBias != 0.5f) {
            v2.horizontalBias(this.mBias);
        }

        int v5 = androidx.constraintlayout.solver.state.helpers.HorizontalChainReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Chain[this.mStyle.ordinal()];
        if(v5 != 1) {
            int v1_1 = 2;
            if(v5 != v1_1) {
                if(v5 != 3) {
                    return;
                }

                v2.setHorizontalChainStyle(v1_1);
                return;
            }

            v2.setHorizontalChainStyle(1);
            return;
        }

        v2.setHorizontalChainStyle(0);
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

