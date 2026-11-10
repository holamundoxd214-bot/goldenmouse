package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Guideline;

class GuidelineReference extends WidgetRun {
    public GuidelineReference(ConstraintWidget arg2) {
        super(arg2);
        arg2.horizontalRun.clear();
        arg2.verticalRun.clear();
        this.orientation = ((Guideline)arg2).getOrientation();
    }

    private void addDependency(DependencyNode arg2) {
        this.start.dependencies.add(arg2);
        arg2.targets.add(this.start);
    }

    void apply() {
        ConstraintWidget v0 = this.widget;
        int v1 = ((Guideline)v0).getRelativeBegin();
        int v2 = ((Guideline)v0).getRelativeEnd();
        ((Guideline)v0).getRelativePercent();
        int v3 = -1;
        if(((Guideline)v0).getOrientation() == 1) {
            if(v1 != v3) {
                this.start.targets.add(this.widget.mParent.horizontalRun.start);
                this.widget.mParent.horizontalRun.start.dependencies.add(this.start);
                this.start.margin = v1;
            }
            else if(v2 != v3) {
                this.start.targets.add(this.widget.mParent.horizontalRun.end);
                this.widget.mParent.horizontalRun.end.dependencies.add(this.start);
                this.start.margin = -v2;
            }
            else {
                this.start.delegateToWidgetRun = true;
                this.start.targets.add(this.widget.mParent.horizontalRun.end);
                this.widget.mParent.horizontalRun.end.dependencies.add(this.start);
            }

            this.addDependency(this.widget.horizontalRun.start);
            this.addDependency(this.widget.horizontalRun.end);
            return;
        }

        if(v1 != v3) {
            this.start.targets.add(this.widget.mParent.verticalRun.start);
            this.widget.mParent.verticalRun.start.dependencies.add(this.start);
            this.start.margin = v1;
        }
        else if(v2 != v3) {
            this.start.targets.add(this.widget.mParent.verticalRun.end);
            this.widget.mParent.verticalRun.end.dependencies.add(this.start);
            this.start.margin = -v2;
        }
        else {
            this.start.delegateToWidgetRun = true;
            this.start.targets.add(this.widget.mParent.verticalRun.end);
            this.widget.mParent.verticalRun.end.dependencies.add(this.start);
        }

        this.addDependency(this.widget.verticalRun.start);
        this.addDependency(this.widget.verticalRun.end);
    }

    public void applyToWidget() {
        if(this.widget.getOrientation() == 1) {
            this.widget.setX(this.start.value);
            return;
        }

        this.widget.setY(this.start.value);
    }

    void clear() {
        this.start.clear();
    }

    void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    boolean supportsWrapComputation() {
        return 0;
    }

    public void update(Dependency arg2) {
        if(!this.start.readyToSolve) {
        }
        else {
            if(this.start.resolved) {
                return;
            }

            goto label_8;
        }

        return;
    label_8:
        this.start.resolve(((int)((((float)this.start.targets.get(0).value)) * this.widget.getRelativePercent() + 0.5f)));
    }
}

