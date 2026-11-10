package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.Iterator;

class HelperReferences extends WidgetRun {
    public HelperReferences(ConstraintWidget arg1) {
        super(arg1);
    }

    private void addDependency(DependencyNode arg2) {
        this.start.dependencies.add(arg2);
        arg2.targets.add(this.start);
    }

    void apply() {
        DependencyNode v1_1;
        ConstraintWidget v1;
        if((this.widget instanceof Barrier)) {
            this.start.delegateToWidgetRun = true;
            ConstraintWidget v0 = this.widget;
            int v2 = ((Barrier)v0).getBarrierType();
            boolean v3 = ((Barrier)v0).allowsGoneWidget();
            int v4 = 8;
            int v5 = 0;
            if(v2 == 0) {
                this.start.type = Type.LEFT;
                while(v5 < ((Barrier)v0).mWidgetsCount) {
                    v1 = ((Barrier)v0).mWidgets[v5];
                    if((v3) || v1.getVisibility() != v4) {
                        v1_1 = v1.horizontalRun.start;
                        v1_1.dependencies.add(this.start);
                        this.start.targets.add(v1_1);
                    }
                    else {
                    }

                    ++v5;
                }

                this.addDependency(this.widget.horizontalRun.start);
                this.addDependency(this.widget.horizontalRun.end);
            }
            else if(v2 == 1) {
                this.start.type = Type.RIGHT;
                while(v5 < ((Barrier)v0).mWidgetsCount) {
                    v1 = ((Barrier)v0).mWidgets[v5];
                    if((v3) || v1.getVisibility() != v4) {
                        v1_1 = v1.horizontalRun.end;
                        v1_1.dependencies.add(this.start);
                        this.start.targets.add(v1_1);
                    }
                    else {
                    }

                    ++v5;
                }

                this.addDependency(this.widget.horizontalRun.start);
                this.addDependency(this.widget.horizontalRun.end);
                return;
            }
            else if(v2 == 2) {
                this.start.type = Type.TOP;
                while(v5 < ((Barrier)v0).mWidgetsCount) {
                    v1 = ((Barrier)v0).mWidgets[v5];
                    if((v3) || v1.getVisibility() != v4) {
                        v1_1 = v1.verticalRun.start;
                        v1_1.dependencies.add(this.start);
                        this.start.targets.add(v1_1);
                    }
                    else {
                    }

                    ++v5;
                }

                this.addDependency(this.widget.verticalRun.start);
                this.addDependency(this.widget.verticalRun.end);
                return;
            }
            else if(v2 != 3) {
            }
            else {
                this.start.type = Type.BOTTOM;
                while(v5 < ((Barrier)v0).mWidgetsCount) {
                    v1 = ((Barrier)v0).mWidgets[v5];
                    if((v3) || v1.getVisibility() != v4) {
                        v1_1 = v1.verticalRun.end;
                        v1_1.dependencies.add(this.start);
                        this.start.targets.add(v1_1);
                    }
                    else {
                    }

                    ++v5;
                }

                this.addDependency(this.widget.verticalRun.start);
                this.addDependency(this.widget.verticalRun.end);
                return;
            }
        }
    }

    public void applyToWidget() {
        if((this.widget instanceof Barrier)) {
            int v0 = this.widget.getBarrierType();
            if(v0 != 0) {
                if(v0 == 1) {
                }
                else {
                    this.widget.setY(this.start.value);
                    return;
                }
            }

            this.widget.setX(this.start.value);
        }
    }

    void clear() {
        this.runGroup = null;
        this.start.clear();
    }

    void reset() {
        this.start.resolved = false;
    }

    boolean supportsWrapComputation() {
        return 0;
    }

    public void update(Dependency arg7) {
        ConstraintWidget v7 = this.widget;
        int v0 = ((Barrier)v7).getBarrierType();
        Iterator v1 = this.start.targets.iterator();
        int v2 = -1;
        int v3 = 0;
        int v4 = v2;
        while(v1.hasNext()) {
            int v5 = v1.next().value;
            if(v4 == v2 || v5 < v4) {
                v4 = v5;
            }

            if(v3 >= v5) {
                continue;
            }

            v3 = v5;
        }

        if(v0 != 0) {
            if(v0 == 2) {
            }
            else {
                this.start.resolve(v3 + ((Barrier)v7).getMargin());
                return;
            }
        }

        this.start.resolve(v4 + ((Barrier)v7).getMargin());
    }
}

