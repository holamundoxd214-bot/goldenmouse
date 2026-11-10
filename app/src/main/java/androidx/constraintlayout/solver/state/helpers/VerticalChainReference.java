package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.State$Chain;
import androidx.constraintlayout.solver.state.State$Helper;
import androidx.constraintlayout.solver.state.State;
import java.util.Iterator;

public class VerticalChainReference extends ChainReference {
    class androidx.constraintlayout.solver.state.helpers.VerticalChainReference$1 {
        static {
            int[] v0 = new int[Chain.values().length];
            androidx.constraintlayout.solver.state.helpers.VerticalChainReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Chain = v0;
            try {
                v0[Chain.SPREAD.ordinal()] = 1;
                goto label_8;
            }
            catch(NoSuchFieldError ) {
                try {
                label_8:
                    androidx.constraintlayout.solver.state.helpers.VerticalChainReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Chain[Chain.SPREAD_INSIDE.ordinal()] = 2;
                    goto label_13;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_13:
                        androidx.constraintlayout.solver.state.helpers.VerticalChainReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Chain[Chain.PACKED.ordinal()] = 3;
                        return;
                    }
                    catch(NoSuchFieldError ) {
                        return;
                    }
                }
            }
        }
    }

    private Object mBottomToBottom;
    private Object mBottomToTop;
    private Object mTopToBottom;
    private Object mTopToTop;

    public VerticalChainReference(State arg2) {
        super(arg2, Helper.VERTICAL_CHAIN);
    }

    public void apply() {
        Iterator v0 = this.mReferences.iterator();
        while(v0.hasNext()) {
            this.mState.constraints(v0.next()).clearVertical();
        }

        v0 = this.mReferences.iterator();
        ConstraintReference v1 = null;
        ConstraintReference v2 = v1;
        while(v0.hasNext()) {
            ConstraintReference v3 = this.mState.constraints(v0.next());
            if(v2 == null) {
                Object v2_1 = this.mTopToTop;
                if(v2_1 != null) {
                    v3.topToTop(v2_1);
                }
                else {
                    v2_1 = this.mTopToBottom;
                    if(v2_1 != null) {
                        v3.topToBottom(v2_1);
                    }
                    else {
                        v3.topToTop(State.PARENT);
                    }
                }

                v2 = v3;
            }

            if(v1 != null) {
                v1.bottomToTop(v3.getKey());
                v3.topToBottom(v1.getKey());
            }

            v1 = v3;
        }

        if(v1 != null) {
            Object v0_1 = this.mBottomToTop;
            if(v0_1 != null) {
                v1.bottomToTop(v0_1);
            }
            else {
                v0_1 = this.mBottomToBottom;
                if(v0_1 != null) {
                    v1.bottomToBottom(v0_1);
                }
                else {
                    v1.bottomToBottom(State.PARENT);
                }
            }
        }

        if(v2 != null && this.mBias != 0.5f) {
            v2.verticalBias(this.mBias);
        }

        int v5 = androidx.constraintlayout.solver.state.helpers.VerticalChainReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Chain[this.mStyle.ordinal()];
        if(v5 != 1) {
            int v1_1 = 2;
            if(v5 != v1_1) {
                if(v5 != 3) {
                    return;
                }

                v2.setVerticalChainStyle(v1_1);
                return;
            }

            v2.setVerticalChainStyle(1);
            return;
        }

        v2.setVerticalChainStyle(0);
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

