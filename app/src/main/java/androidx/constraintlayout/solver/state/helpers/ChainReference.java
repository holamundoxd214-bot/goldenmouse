package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State$Chain;
import androidx.constraintlayout.solver.state.State$Helper;
import androidx.constraintlayout.solver.state.State;

public class ChainReference extends HelperReference {
    protected float mBias;
    protected Chain mStyle;

    public ChainReference(State arg1, Helper arg2) {
        super(arg1, arg2);
        this.mBias = 0.5f;
        this.mStyle = Chain.SPREAD;
    }

    public void bias(float arg1) {
        this.mBias = arg1;
    }

    public float getBias() {
        return this.mBias;
    }

    public Chain getStyle() {
        return Chain.SPREAD;
    }

    public void style(Chain arg1) {
        this.mStyle = arg1;
    }
}

