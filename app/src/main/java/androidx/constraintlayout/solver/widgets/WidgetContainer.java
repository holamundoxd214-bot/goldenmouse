package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import java.util.ArrayList;

public class WidgetContainer extends ConstraintWidget {
    public ArrayList mChildren;

    public WidgetContainer() {
        super();
        this.mChildren = new ArrayList();
    }

    public WidgetContainer(int arg1, int arg2) {
        super(arg1, arg2);
        this.mChildren = new ArrayList();
    }

    public WidgetContainer(int arg1, int arg2, int arg3, int arg4) {
        super(arg1, arg2, arg3, arg4);
        this.mChildren = new ArrayList();
    }

    public void add(ConstraintWidget arg2) {
        this.mChildren.add(arg2);
        if(arg2.getParent() != null) {
            arg2.getParent().remove(arg2);
        }

        arg2.setParent(((ConstraintWidget)this));
    }

    public void add(ConstraintWidget[] arg4) {
        int v0 = arg4.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.add(arg4[v1]);
        }
    }

    public ArrayList getChildren() {
        return this.mChildren;
    }

    public ConstraintWidgetContainer getRootConstraintContainer() {
        ConstraintWidget v3;
        ConstraintWidget v0 = ((ConstraintWidget)this).getParent();
        if((this instanceof ConstraintWidgetContainer)) {
        }
        else {
            this = null;
        }

        while(v0 != null) {
            ConstraintWidget v1 = v0.getParent();
            if((v0 instanceof ConstraintWidgetContainer)) {
                v3 = v0;
            }

            v0 = v1;
        }

        return ((WidgetContainer)v3);
    }

    public void layout() {
        ArrayList v0 = this.mChildren;
        if(v0 == null) {
        }
        else {
            int v0_1 = v0.size();
            int v1;
            for(v1 = 0; v1 < v0_1; ++v1) {
                Object v2 = this.mChildren.get(v1);
                if((v2 instanceof WidgetContainer)) {
                    ((WidgetContainer)v2).layout();
                }
            }
        }
    }

    public void remove(ConstraintWidget arg1) {
        this.mChildren.remove(arg1);
        arg1.setParent(null);
    }

    public void removeAllChildren() {
        this.mChildren.clear();
    }

    public void reset() {
        this.mChildren.clear();
        super.reset();
    }

    public void resetSolverVariables(Cache arg4) {
        super.resetSolverVariables(arg4);
        int v0 = this.mChildren.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.mChildren.get(v1).resetSolverVariables(arg4);
        }
    }

    public void setOffset(int arg4, int arg5) {
        super.setOffset(arg4, arg5);
        arg4 = this.mChildren.size();
        for(arg5 = 0; arg5 < arg4; ++arg5) {
            this.mChildren.get(arg5).setOffset(this.getRootX(), this.getRootY());
        }
    }
}

