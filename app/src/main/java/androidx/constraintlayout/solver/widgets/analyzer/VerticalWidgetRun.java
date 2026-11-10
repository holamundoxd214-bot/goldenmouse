package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Helper;

public class VerticalWidgetRun extends WidgetRun {
    class androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun$1 {
        static {
            int[] v0 = new int[RunType.values().length];
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun$1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType = v0;
            try {
                v0[RunType.START.ordinal()] = 1;
                goto label_8;
            }
            catch(NoSuchFieldError ) {
                try {
                label_8:
                    androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun$1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[RunType.END.ordinal()] = 2;
                    goto label_13;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_13:
                        androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun$1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[RunType.CENTER.ordinal()] = 3;
                        return;
                    }
                    catch(NoSuchFieldError ) {
                        return;
                    }
                }
            }
        }
    }

    public DependencyNode baseline;
    DimensionDependency baselineDimension;

    public VerticalWidgetRun(ConstraintWidget arg2) {
        super(arg2);
        this.baseline = new DependencyNode(((WidgetRun)this));
        this.baselineDimension = null;
        this.start.type = Type.TOP;
        this.end.type = Type.BOTTOM;
        this.baseline.type = Type.BASELINE;
        this.orientation = 1;
    }

    void apply() {
        DependencyNode v0_1;
        DimensionDependency v0_3;
        ConstraintWidget v0;
        if(this.widget.measured) {
            this.dimension.resolve(this.widget.getHeight());
        }

        if(!this.dimension.resolved) {
            ((WidgetRun)this).dimensionBehavior = this.widget.getVerticalDimensionBehaviour();
            if(this.widget.hasBaseline()) {
                this.baselineDimension = new BaselineDimensionDependency(((WidgetRun)this));
            }

            if(((WidgetRun)this).dimensionBehavior == DimensionBehaviour.MATCH_CONSTRAINT) {
                goto label_91;
            }

            if(this.dimensionBehavior == DimensionBehaviour.MATCH_PARENT) {
                v0 = this.widget.getParent();
                if(v0 != null && v0.getVerticalDimensionBehaviour() == DimensionBehaviour.FIXED) {
                    int v1 = v0.getHeight() - this.widget.mTop.getMargin() - this.widget.mBottom.getMargin();
                    this.addTarget(this.start, v0.verticalRun.start, this.widget.mTop.getMargin());
                    this.addTarget(this.end, v0.verticalRun.end, -this.widget.mBottom.getMargin());
                    this.dimension.resolve(v1);
                    return;
                }
            }

            if(this.dimensionBehavior != DimensionBehaviour.FIXED) {
                goto label_91;
            }

            this.dimension.resolve(this.widget.getHeight());
        }
        else {
            if(this.dimensionBehavior != DimensionBehaviour.MATCH_PARENT) {
                goto label_91;
            }

            v0 = this.widget.getParent();
            if(v0 == null) {
                goto label_91;
            }

            if(v0.getVerticalDimensionBehaviour() != DimensionBehaviour.FIXED) {
                goto label_91;
            }

            this.addTarget(this.start, v0.verticalRun.start, this.widget.mTop.getMargin());
            this.addTarget(this.end, v0.verticalRun.end, -this.widget.mBottom.getMargin());
            return;
        }

    label_91:
        int v2 = 4;
        int v4 = 2;
        int v5 = 3;
        if(!this.dimension.resolved || !this.widget.measured) {
            if((this.dimension.resolved) || this.dimensionBehavior != DimensionBehaviour.MATCH_CONSTRAINT) {
                this.dimension.addDependency(((Dependency)this));
            }
            else {
                int v0_2 = this.widget.mMatchConstraintDefaultHeight;
                if(v0_2 == v4) {
                    v0 = this.widget.getParent();
                    if(v0 == null) {
                    }
                    else {
                        v0_3 = v0.verticalRun.dimension;
                        this.dimension.targets.add(v0_3);
                        ((DependencyNode)v0_3).dependencies.add(this.dimension);
                        this.dimension.delegateToWidgetRun = true;
                        this.dimension.dependencies.add(this.start);
                        this.dimension.dependencies.add(this.end);
                    }
                }
                else if(v0_2 != v5) {
                }
                else if(!this.widget.isInVerticalChain()) {
                    if(this.widget.mMatchConstraintDefaultWidth == v5) {
                    }
                    else {
                        v0_3 = this.widget.horizontalRun.dimension;
                        this.dimension.targets.add(v0_3);
                        ((DependencyNode)v0_3).dependencies.add(this.dimension);
                        this.dimension.delegateToWidgetRun = true;
                        this.dimension.dependencies.add(this.start);
                        this.dimension.dependencies.add(this.end);
                    }
                }
            }

            if(this.widget.mListAnchors[v4].mTarget == null || this.widget.mListAnchors[v5].mTarget == null) {
                if(this.widget.mListAnchors[v4].mTarget != null) {
                    v0_1 = this.getTarget(this.widget.mListAnchors[v4]);
                    if(v0_1 == null) {
                        goto label_549;
                    }

                    this.addTarget(this.start, v0_1, this.widget.mListAnchors[v4].getMargin());
                    this.addTarget(this.end, this.start, 1, this.dimension);
                    if(this.widget.hasBaseline()) {
                        this.addTarget(this.baseline, this.start, 1, this.baselineDimension);
                    }

                    if(this.dimensionBehavior != DimensionBehaviour.MATCH_CONSTRAINT) {
                        goto label_549;
                    }

                    if(this.widget.getDimensionRatio() <= 0f) {
                        goto label_549;
                    }

                    if(this.widget.horizontalRun.dimensionBehavior != DimensionBehaviour.MATCH_CONSTRAINT) {
                        goto label_549;
                    }

                    this.widget.horizontalRun.dimension.dependencies.add(this.dimension);
                    this.dimension.targets.add(this.widget.horizontalRun.dimension);
                    this.dimension.updateDelegate = ((Dependency)this);
                    goto label_549;
                }

                v4 = -1;
                if(this.widget.mListAnchors[v5].mTarget != null) {
                    v0_1 = this.getTarget(this.widget.mListAnchors[v5]);
                    if(v0_1 == null) {
                        goto label_549;
                    }

                    this.addTarget(this.end, v0_1, -this.widget.mListAnchors[v5].getMargin());
                    this.addTarget(this.start, this.end, v4, this.dimension);
                    if(!this.widget.hasBaseline()) {
                        goto label_549;
                    }

                    this.addTarget(this.baseline, this.start, 1, this.baselineDimension);
                    goto label_549;
                }

                if(this.widget.mListAnchors[v2].mTarget != null) {
                    v0_1 = this.getTarget(this.widget.mListAnchors[v2]);
                    if(v0_1 == null) {
                        goto label_549;
                    }

                    this.addTarget(this.baseline, v0_1, 0);
                    this.addTarget(this.start, this.baseline, v4, this.baselineDimension);
                    this.addTarget(this.end, this.start, 1, this.dimension);
                    goto label_549;
                }

                if((this.widget instanceof Helper)) {
                    goto label_549;
                }

                if(this.widget.getParent() == null) {
                    goto label_549;
                }

                this.addTarget(this.start, this.widget.getParent().verticalRun.start, this.widget.getY());
                this.addTarget(this.end, this.start, 1, this.dimension);
                if(this.widget.hasBaseline()) {
                    this.addTarget(this.baseline, this.start, 1, this.baselineDimension);
                }

                if(this.dimensionBehavior != DimensionBehaviour.MATCH_CONSTRAINT) {
                    goto label_549;
                }

                if(this.widget.getDimensionRatio() <= 0f) {
                    goto label_549;
                }

                if(this.widget.horizontalRun.dimensionBehavior != DimensionBehaviour.MATCH_CONSTRAINT) {
                    goto label_549;
                }

                this.widget.horizontalRun.dimension.dependencies.add(this.dimension);
                this.dimension.targets.add(this.widget.horizontalRun.dimension);
                this.dimension.updateDelegate = ((Dependency)this);
            }
            else {
                if(this.widget.isInVerticalChain()) {
                    this.start.margin = this.widget.mListAnchors[v4].getMargin();
                    this.end.margin = -this.widget.mListAnchors[v5].getMargin();
                }
                else {
                    v0_1 = this.getTarget(this.widget.mListAnchors[v4]);
                    DependencyNode v1_1 = this.getTarget(this.widget.mListAnchors[v5]);
                    v0_1.addDependency(((Dependency)this));
                    v1_1.addDependency(((Dependency)this));
                    this.mRunType = RunType.CENTER;
                }

                if(!this.widget.hasBaseline()) {
                    goto label_549;
                }

                this.addTarget(this.baseline, this.start, 1, this.baselineDimension);
            }

        label_549:
            if(this.dimension.targets.size() != 0) {
                return;
            }

            this.dimension.readyToSolve = true;
        }
        else {
            if(this.widget.mListAnchors[v4].mTarget != null && this.widget.mListAnchors[v5].mTarget != null) {
                if(this.widget.isInVerticalChain()) {
                    this.start.margin = this.widget.mListAnchors[v4].getMargin();
                    this.end.margin = -this.widget.mListAnchors[v5].getMargin();
                }
                else {
                    v0_1 = this.getTarget(this.widget.mListAnchors[v4]);
                    if(v0_1 != null) {
                        this.addTarget(this.start, v0_1, this.widget.mListAnchors[v4].getMargin());
                    }

                    v0_1 = this.getTarget(this.widget.mListAnchors[v5]);
                    if(v0_1 != null) {
                        this.addTarget(this.end, v0_1, -this.widget.mListAnchors[v5].getMargin());
                    }

                    this.start.delegateToWidgetRun = true;
                    this.end.delegateToWidgetRun = true;
                }

                if(!this.widget.hasBaseline()) {
                    return;
                }

                this.addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
                return;
            }

            if(this.widget.mListAnchors[v4].mTarget != null) {
                v0_1 = this.getTarget(this.widget.mListAnchors[v4]);
                if(v0_1 == null) {
                    return;
                }

                this.addTarget(this.start, v0_1, this.widget.mListAnchors[v4].getMargin());
                this.addTarget(this.end, this.start, this.dimension.value);
                if(!this.widget.hasBaseline()) {
                    return;
                }

                this.addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
                return;
            }

            if(this.widget.mListAnchors[v5].mTarget != null) {
                v0_1 = this.getTarget(this.widget.mListAnchors[v5]);
                if(v0_1 != null) {
                    this.addTarget(this.end, v0_1, -this.widget.mListAnchors[v5].getMargin());
                    this.addTarget(this.start, this.end, -this.dimension.value);
                }

                if(!this.widget.hasBaseline()) {
                    return;
                }

                this.addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
                return;
            }

            if(this.widget.mListAnchors[v2].mTarget != null) {
                v0_1 = this.getTarget(this.widget.mListAnchors[v2]);
                if(v0_1 == null) {
                    return;
                }

                this.addTarget(this.baseline, v0_1, 0);
                this.addTarget(this.start, this.baseline, -this.widget.getBaselineDistance());
                this.addTarget(this.end, this.start, this.dimension.value);
                return;
            }

            if((this.widget instanceof Helper)) {
                return;
            }

            if(this.widget.getParent() == null) {
                return;
            }

            if(this.widget.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type.CENTER).mTarget != null) {
                return;
            }

            this.addTarget(this.start, this.widget.getParent().verticalRun.start, this.widget.getY());
            this.addTarget(this.end, this.start, this.dimension.value);
            if(!this.widget.hasBaseline()) {
                return;
            }

            this.addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
            return;
        }
    }

    public void applyToWidget() {
        if(this.start.resolved) {
            this.widget.setY(this.start.value);
        }
    }

    void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
        this.baseline.clear();
        this.dimension.clear();
        this.resolved = false;
    }

    void reset() {
        this.resolved = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.baseline.clear();
        this.baseline.resolved = false;
        this.dimension.resolved = false;
    }

    boolean supportsWrapComputation() {
        if(((WidgetRun)this).dimensionBehavior == DimensionBehaviour.MATCH_CONSTRAINT) {
            if(((WidgetRun)this).widget.mMatchConstraintDefaultHeight == 0) {
                return 1;
            }

            return 0;
        }

        return 1;
    }

    public String toString() {
        return "VerticalRun " + this.widget.getDebugName();
    }

    public void update(Dependency arg7) {
        Object v7_3;
        float v1_1;
        float v7_1;
        int v7;
        int v0 = androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun$1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
        int v1 = 3;
        int v2 = 2;
        if(v0 == 1) {
            this.updateRunStart(arg7);
        }
        else if(v0 == v2) {
            this.updateRunEnd(arg7);
        }
        else if(v0 != v1) {
        }
        else {
            this.updateRunCenter(arg7, this.widget.mTop, this.widget.mBottom, 1);
            return;
        }

        float v0_1 = 0.5f;
        if((this.dimension.readyToSolve) && !this.dimension.resolved && this.dimensionBehavior == DimensionBehaviour.MATCH_CONSTRAINT) {
            v7 = this.widget.mMatchConstraintDefaultHeight;
            if(v7 == v2) {
                ConstraintWidget v7_2 = this.widget.getParent();
                if(v7_2 == null) {
                    goto label_97;
                }

                if(!v7_2.verticalRun.dimension.resolved) {
                    goto label_97;
                }

                this.dimension.resolve(((int)((((float)v7_2.verticalRun.dimension.value)) * this.widget.mMatchConstraintPercentHeight + v0_1)));
            }
            else if(v7 != v1) {
            }
            else if(this.widget.horizontalRun.dimension.resolved) {
                v7 = this.widget.getDimensionRatioSide();
                if(v7 == -1) {
                    v7_1 = ((float)this.widget.horizontalRun.dimension.value);
                    v1_1 = this.widget.getDimensionRatio();
                label_73:
                    v7_1 /= v1_1;
                label_74:
                    v7 = ((int)(v7_1 + v0_1));
                }
                else if(v7 == 0) {
                    v7_1 = (((float)this.widget.horizontalRun.dimension.value)) * this.widget.getDimensionRatio();
                    goto label_74;
                }
                else if(v7 != 1) {
                    v7 = 0;
                }
                else {
                    v7_1 = ((float)this.widget.horizontalRun.dimension.value);
                    v1_1 = this.widget.getDimensionRatio();
                    goto label_73;
                }

                this.dimension.resolve(v7);
            }
        }

    label_97:
        if(this.start.readyToSolve) {
            if(!this.end.readyToSolve) {
            }
            else {
                if((this.start.resolved) && (this.end.resolved) && (this.dimension.resolved)) {
                    return;
                }

                if(!this.dimension.resolved && this.dimensionBehavior == DimensionBehaviour.MATCH_CONSTRAINT && this.widget.mMatchConstraintDefaultWidth == 0 && !this.widget.isInVerticalChain()) {
                    v7_3 = this.start.targets.get(0);
                    Object v0_2 = this.end.targets.get(0);
                    v7 = ((DependencyNode)v7_3).value + this.start.margin;
                    v0 = ((DependencyNode)v0_2).value + this.end.margin;
                    this.start.resolve(v7);
                    this.end.resolve(v0);
                    this.dimension.resolve(v0 - v7);
                    return;
                }

                if(!this.dimension.resolved && this.dimensionBehavior == DimensionBehaviour.MATCH_CONSTRAINT && this.matchConstraintsType == 1 && this.start.targets.size() > 0 && this.end.targets.size() > 0) {
                    v1 = this.end.targets.get(0).value + this.end.margin - (this.start.targets.get(0).value + this.start.margin);
                    if(v1 < this.dimension.wrapValue) {
                        this.dimension.resolve(v1);
                    }
                    else {
                        this.dimension.resolve(this.dimension.wrapValue);
                    }
                }

                if(!this.dimension.resolved) {
                    return;
                }

                if(this.start.targets.size() <= 0) {
                    return;
                }

                if(this.end.targets.size() <= 0) {
                    return;
                }

                v7_3 = this.start.targets.get(0);
                Object v1_2 = this.end.targets.get(0);
                v2 = ((DependencyNode)v7_3).value + this.start.margin;
                int v3 = ((DependencyNode)v1_2).value + this.end.margin;
                float v4 = this.widget.getVerticalBiasPercent();
                if(v7_3 == v1_2) {
                    v2 = ((DependencyNode)v7_3).value;
                    v3 = ((DependencyNode)v1_2).value;
                    v4 = v0_1;
                }

                this.start.resolve(((int)((((float)v2)) + v0_1 + (((float)(v3 - v2 - this.dimension.value))) * v4)));
                this.end.resolve(this.start.value + this.dimension.value);
            }
        }
    }
}

