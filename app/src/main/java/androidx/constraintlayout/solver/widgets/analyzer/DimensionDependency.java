package androidx.constraintlayout.solver.widgets.analyzer;

import java.util.Iterator;

class DimensionDependency extends DependencyNode {
    public int wrapValue;

    public DimensionDependency(WidgetRun arg1) {
        super(arg1);
        if((arg1 instanceof HorizontalWidgetRun)) {
            this.type = Type.HORIZONTAL_DIMENSION;
            return;
        }

        this.type = Type.VERTICAL_DIMENSION;
    }

    public void resolve(int arg2) {
        if(this.resolved) {
        }
        else {
            this.resolved = true;
            this.value = arg2;
            Iterator v1 = this.dependencies.iterator();
            while(v1.hasNext()) {
                Object v2 = v1.next();
                ((Dependency)v2).update(((Dependency)v2));
            }
        }
    }
}

