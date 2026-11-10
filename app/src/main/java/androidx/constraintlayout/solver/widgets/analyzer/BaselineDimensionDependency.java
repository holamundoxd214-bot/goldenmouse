package androidx.constraintlayout.solver.widgets.analyzer;

class BaselineDimensionDependency extends DimensionDependency {
    public BaselineDimensionDependency(WidgetRun arg1) {
        super(arg1);
    }

    public void update(DependencyNode arg2) {
        this.run.baseline.margin = this.run.widget.getBaselineDistance();
        this.resolved = true;
    }
}

