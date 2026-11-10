package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.widgets.HelperWidget;
import java.util.ArrayList;

public class HelperReference {
    private HelperWidget mHelperWidget;
    protected ArrayList mReferences;
    protected final State mState;
    final Helper mType;

    public HelperReference(State arg2, Helper arg3) {
        super();
        this.mReferences = new ArrayList();
        this.mState = arg2;
        this.mType = arg3;
    }

    public HelperReference add(Object[] arg5) {
        int v0 = arg5.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.mReferences.add(arg5[v1]);
        }

        return this;
    }

    public void apply() {
    }

    public HelperWidget getHelperWidget() {
        return this.mHelperWidget;
    }

    public Helper getType() {
        return this.mType;
    }

    public void setHelperWidget(HelperWidget arg1) {
        this.mHelperWidget = arg1;
    }
}

