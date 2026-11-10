package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Helper;

public class HorizontalWidgetRun extends WidgetRun {
    class androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun$1 {
        static {
            int[] v0 = new int[RunType.values().length];
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun$1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType = v0;
            try {
                v0[RunType.START.ordinal()] = 1;
                goto label_8;
            }
            catch(NoSuchFieldError ) {
                try {
                label_8:
                    androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun$1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[RunType.END.ordinal()] = 2;
                    goto label_13;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_13:
                        androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun$1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[RunType.CENTER.ordinal()] = 3;
                        return;
                    }
                    catch(NoSuchFieldError ) {
                        return;
                    }
                }
            }
        }
    }

    private static int[] tempDimensions;

    static {
        HorizontalWidgetRun.tempDimensions = new int[2];
    }

    public HorizontalWidgetRun(ConstraintWidget arg2) {
        super(arg2);
        this.start.type = Type.LEFT;
        this.end.type = Type.RIGHT;
        this.orientation = 0;
    }

    void apply() {
        DependencyNode v0_1;
        DimensionDependency v0_3;
        ConstraintWidget v0;
        if(this.widget.measured) {
            this.dimension.resolve(this.widget.getWidth());
        }

        if(!this.dimension.resolved) {
            ((WidgetRun)this).dimensionBehavior = this.widget.getHorizontalDimensionBehaviour();
            if(((WidgetRun)this).dimensionBehavior != DimensionBehaviour.MATCH_CONSTRAINT) {
                if(this.dimensionBehavior == DimensionBehaviour.MATCH_PARENT) {
                    v0 = this.widget.getParent();
                    if((v0 == null || v0.getHorizontalDimensionBehaviour() != DimensionBehaviour.FIXED) && v0.getHorizontalDimensionBehaviour() != DimensionBehaviour.MATCH_PARENT) {
                        goto label_55;
                    }

                    int v1 = v0.getWidth() - this.widget.mLeft.getMargin() - this.widget.mRight.getMargin();
                    this.addTarget(this.start, v0.horizontalRun.start, this.widget.mLeft.getMargin());
                    this.addTarget(this.end, v0.horizontalRun.end, -this.widget.mRight.getMargin());
                    this.dimension.resolve(v1);
                    return;
                }

            label_55:
                if(this.dimensionBehavior != DimensionBehaviour.FIXED) {
                    goto label_91;
                }

                this.dimension.resolve(this.widget.getWidth());
            }
        }
        else {
            if(this.dimensionBehavior != DimensionBehaviour.MATCH_PARENT) {
                goto label_91;
            }

            v0 = this.widget.getParent();
            if((v0 == null || v0.getHorizontalDimensionBehaviour() != DimensionBehaviour.FIXED) && v0.getHorizontalDimensionBehaviour() != DimensionBehaviour.MATCH_PARENT) {
                goto label_91;
            }

            this.addTarget(this.start, v0.horizontalRun.start, this.widget.mLeft.getMargin());
            this.addTarget(this.end, v0.horizontalRun.end, -this.widget.mRight.getMargin());
            return;
        }

    label_91:
        if(!this.dimension.resolved || !this.widget.measured) {
            if(this.dimensionBehavior == DimensionBehaviour.MATCH_CONSTRAINT) {
                int v0_2 = this.widget.mMatchConstraintDefaultWidth;
                if(v0_2 != 2) {
                    int v3 = 3;
                    if(v0_2 != v3) {
                    }
                    else if(this.widget.mMatchConstraintDefaultHeight == v3) {
                        this.start.updateDelegate = ((Dependency)this);
                        this.end.updateDelegate = ((Dependency)this);
                        this.widget.verticalRun.start.updateDelegate = ((Dependency)this);
                        this.widget.verticalRun.end.updateDelegate = ((Dependency)this);
                        this.dimension.updateDelegate = ((Dependency)this);
                        if(this.widget.isInVerticalChain()) {
                            this.dimension.targets.add(this.widget.verticalRun.dimension);
                            this.widget.verticalRun.dimension.dependencies.add(this.dimension);
                            this.widget.verticalRun.dimension.updateDelegate = ((Dependency)this);
                            this.dimension.targets.add(this.widget.verticalRun.start);
                            this.dimension.targets.add(this.widget.verticalRun.end);
                            this.widget.verticalRun.start.dependencies.add(this.dimension);
                            this.widget.verticalRun.end.dependencies.add(this.dimension);
                        }
                        else if(this.widget.isInHorizontalChain()) {
                            this.widget.verticalRun.dimension.targets.add(this.dimension);
                            this.dimension.dependencies.add(this.widget.verticalRun.dimension);
                        }
                        else {
                            this.widget.verticalRun.dimension.targets.add(this.dimension);
                        }
                    }
                    else {
                        v0_3 = this.widget.verticalRun.dimension;
                        this.dimension.targets.add(v0_3);
                        ((DependencyNode)v0_3).dependencies.add(this.dimension);
                        this.widget.verticalRun.start.dependencies.add(this.dimension);
                        this.widget.verticalRun.end.dependencies.add(this.dimension);
                        this.dimension.delegateToWidgetRun = true;
                        this.dimension.dependencies.add(this.start);
                        this.dimension.dependencies.add(this.end);
                        this.start.targets.add(this.dimension);
                        this.end.targets.add(this.dimension);
                    }
                }
                else {
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
            }

            if(this.widget.mListAnchors[0].mTarget != null && this.widget.mListAnchors[1].mTarget != null) {
                if(this.widget.isInHorizontalChain()) {
                    this.start.margin = this.widget.mListAnchors[0].getMargin();
                    this.end.margin = -this.widget.mListAnchors[1].getMargin();
                    return;
                }
                else {
                    v0_1 = this.getTarget(this.widget.mListAnchors[0]);
                    DependencyNode v1_1 = this.getTarget(this.widget.mListAnchors[1]);
                    v0_1.addDependency(((Dependency)this));
                    v1_1.addDependency(((Dependency)this));
                    this.mRunType = RunType.CENTER;
                    return;
                }
            }

            if(this.widget.mListAnchors[0].mTarget != null) {
                v0_1 = this.getTarget(this.widget.mListAnchors[0]);
                if(v0_1 == null) {
                    return;
                }

                this.addTarget(this.start, v0_1, this.widget.mListAnchors[0].getMargin());
                this.addTarget(this.end, this.start, 1, this.dimension);
                return;
            }

            if(this.widget.mListAnchors[1].mTarget != null) {
                v0_1 = this.getTarget(this.widget.mListAnchors[1]);
                if(v0_1 == null) {
                    return;
                }

                this.addTarget(this.end, v0_1, -this.widget.mListAnchors[1].getMargin());
                this.addTarget(this.start, this.end, -1, this.dimension);
                return;
            }

            if((this.widget instanceof Helper)) {
                return;
            }

            if(this.widget.getParent() == null) {
                return;
            }

            this.addTarget(this.start, this.widget.getParent().horizontalRun.start, this.widget.getX());
            this.addTarget(this.end, this.start, 1, this.dimension);
        }
        else {
            if(this.widget.mListAnchors[0].mTarget != null && this.widget.mListAnchors[1].mTarget != null) {
                if(this.widget.isInHorizontalChain()) {
                    this.start.margin = this.widget.mListAnchors[0].getMargin();
                    this.end.margin = -this.widget.mListAnchors[1].getMargin();
                    return;
                }
                else {
                    v0_1 = this.getTarget(this.widget.mListAnchors[0]);
                    if(v0_1 != null) {
                        this.addTarget(this.start, v0_1, this.widget.mListAnchors[0].getMargin());
                    }

                    v0_1 = this.getTarget(this.widget.mListAnchors[1]);
                    if(v0_1 != null) {
                        this.addTarget(this.end, v0_1, -this.widget.mListAnchors[1].getMargin());
                    }

                    this.start.delegateToWidgetRun = true;
                    this.end.delegateToWidgetRun = true;
                    return;
                }
            }

            if(this.widget.mListAnchors[0].mTarget != null) {
                v0_1 = this.getTarget(this.widget.mListAnchors[0]);
                if(v0_1 == null) {
                    return;
                }

                this.addTarget(this.start, v0_1, this.widget.mListAnchors[0].getMargin());
                this.addTarget(this.end, this.start, this.dimension.value);
                return;
            }

            if(this.widget.mListAnchors[1].mTarget != null) {
                v0_1 = this.getTarget(this.widget.mListAnchors[1]);
                if(v0_1 == null) {
                    return;
                }

                this.addTarget(this.end, v0_1, -this.widget.mListAnchors[1].getMargin());
                this.addTarget(this.start, this.end, -this.dimension.value);
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

            this.addTarget(this.start, this.widget.getParent().horizontalRun.start, this.widget.getX());
            this.addTarget(this.end, this.start, this.dimension.value);
            return;
        }
    }

    public void applyToWidget() {
        if(this.start.resolved) {
            this.widget.setX(this.start.value);
        }
    }

    void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
        this.dimension.clear();
        this.resolved = false;
    }

    private void computeInsetRatio(int[] arg2, int arg3, int arg4, int arg5, int arg6, float arg7, int arg8) {
        arg4 -= arg3;
        arg6 -= arg5;
        float v5 = 0.5f;
        if(arg8 == -1) {
            int v1 = ((int)((((float)arg6)) * arg7 + v5));
            arg5 = ((int)((((float)arg4)) / arg7 + v5));
            if(v1 <= arg4) {
                arg2[0] = v1;
                arg2[1] = arg6;
                return;
            }
            else if(arg5 <= arg6) {
                arg2[0] = arg4;
                arg2[1] = arg5;
            }
        }
        else if(arg8 == 0) {
            arg2[0] = ((int)((((float)arg6)) * arg7 + v5));
            arg2[1] = arg6;
            return;
        }
        else if(arg8 != 1) {
        }
        else {
            arg2[0] = arg4;
            arg2[1] = ((int)((((float)arg4)) * arg7 + v5));
            return;
        }
    }

    void reset() {
        this.resolved = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.dimension.resolved = false;
    }

    boolean supportsWrapComputation() {
        if(((WidgetRun)this).dimensionBehavior == DimensionBehaviour.MATCH_CONSTRAINT) {
            if(((WidgetRun)this).widget.mMatchConstraintDefaultWidth == 0) {
                return 1;
            }

            return 0;
        }

        return 1;
    }

    public String toString() {
        return "HorizontalRun " + this.widget.getDebugName();
    }

    public void update(Dependency arg14) {
        int v4;
        float v2_1;
        float v1_1;
        Object v2_2;
        Object v1_3;
        int v1 = androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun$1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
        int v2 = 2;
        int v3 = 3;
        if(v1 == 1) {
            this.updateRunStart(arg14);
        }
        else if(v1 == v2) {
            this.updateRunEnd(arg14);
        }
        else if(v1 != v3) {
        }
        else {
            this.updateRunCenter(arg14, this.widget.mLeft, this.widget.mRight, 0);
            return;
        }

        float v10 = 0.5f;
        if((this.dimension.resolved) || this.dimensionBehavior != DimensionBehaviour.MATCH_CONSTRAINT) {
        label_404:
            if(!this.start.readyToSolve) {
                return;
            }

            if(!this.end.readyToSolve) {
                return;
            }

            if((this.start.resolved) && (this.end.resolved) && (this.dimension.resolved)) {
                return;
            }

            if(!this.dimension.resolved && this.dimensionBehavior == DimensionBehaviour.MATCH_CONSTRAINT && this.widget.mMatchConstraintDefaultWidth == 0 && !this.widget.isInHorizontalChain()) {
                v1_3 = this.start.targets.get(0);
                v2_2 = this.end.targets.get(0);
                v1 = ((DependencyNode)v1_3).value + this.start.margin;
                v2 = ((DependencyNode)v2_2).value + this.end.margin;
                this.start.resolve(v1);
                this.end.resolve(v2);
                this.dimension.resolve(v2 - v1);
                return;
            }

            if(!this.dimension.resolved && this.dimensionBehavior == DimensionBehaviour.MATCH_CONSTRAINT && this.matchConstraintsType == 1 && this.start.targets.size() > 0 && this.end.targets.size() > 0) {
                v1 = Math.min(this.end.targets.get(0).value + this.end.margin - (this.start.targets.get(0).value + this.start.margin), this.dimension.wrapValue);
                v2 = this.widget.mMatchConstraintMaxWidth;
                v1 = Math.max(this.widget.mMatchConstraintMinWidth, v1);
                if(v2 > 0) {
                    v1 = Math.min(v2, v1);
                }

                this.dimension.resolve(v1);
            }

            if(!this.dimension.resolved) {
                return;
            }

            v1_3 = this.start.targets.get(0);
            v2_2 = this.end.targets.get(0);
            v3 = ((DependencyNode)v1_3).value + this.start.margin;
            v4 = ((DependencyNode)v2_2).value + this.end.margin;
            float v5_1 = this.widget.getHorizontalBiasPercent();
            if(v1_3 == v2_2) {
                v3 = ((DependencyNode)v1_3).value;
                v4 = ((DependencyNode)v2_2).value;
                v5_1 = v10;
            }

            this.start.resolve(((int)((((float)v3)) + v10 + (((float)(v4 - v3 - this.dimension.value))) * v5_1)));
            this.end.resolve(this.start.value + this.dimension.value);
        }
        else {
            v1 = this.widget.mMatchConstraintDefaultWidth;
            if(v1 == v2) {
                ConstraintWidget v1_2 = this.widget.getParent();
                if(v1_2 == null) {
                    goto label_404;
                }

                if(!v1_2.horizontalRun.dimension.resolved) {
                    goto label_404;
                }

                this.dimension.resolve(((int)((((float)v1_2.horizontalRun.dimension.value)) * this.widget.mMatchConstraintPercentWidth + v10)));
            }
            else if(v1 != v3) {
            }
            else {
                v2 = -1;
                if(this.widget.mMatchConstraintDefaultHeight != 0) {
                    if(this.widget.mMatchConstraintDefaultHeight == v3) {
                    }
                    else {
                        v1 = this.widget.getDimensionRatioSide();
                        if(v1 == v2) {
                            v1_1 = ((float)this.widget.verticalRun.dimension.value);
                            v2_1 = this.widget.getDimensionRatio();
                        label_72:
                            v1_1 *= v2_1;
                        label_73:
                            v1 = ((int)(v1_1 + v10));
                        }
                        else if(v1 == 0) {
                            v1_1 = (((float)this.widget.verticalRun.dimension.value)) / this.widget.getDimensionRatio();
                            goto label_73;
                        }
                        else if(v1 != 1) {
                            v1 = 0;
                        }
                        else {
                            v1_1 = ((float)this.widget.verticalRun.dimension.value);
                            v2_1 = this.widget.getDimensionRatio();
                            goto label_72;
                        }

                        this.dimension.resolve(v1);
                        goto label_404;
                    }
                }

                DependencyNode v11 = this.widget.verticalRun.start;
                DependencyNode v12 = this.widget.verticalRun.end;
                v1 = this.widget.mLeft.mTarget != null ? 1 : 0;
                v3 = this.widget.mTop.mTarget != null ? 1 : 0;
                v4 = this.widget.mRight.mTarget != null ? 1 : 0;
                int v5 = this.widget.mBottom.mTarget != null ? 1 : 0;
                int v7 = this.widget.getDimensionRatioSide();
                if(v1 != 0 && v3 != 0 && v4 != 0 && v5 != 0) {
                    float v6 = this.widget.getDimensionRatio();
                    if((v11.resolved) && (v12.resolved)) {
                        if(!this.start.readyToSolve) {
                            return;
                        }
                        else if(!this.end.readyToSolve) {
                            return;
                        }
                        else {
                            this.computeInsetRatio(HorizontalWidgetRun.tempDimensions, this.start.margin + this.start.targets.get(0).value, this.end.targets.get(0).value - this.end.margin, v11.margin + v11.value, v12.value - v12.margin, v6, v7);
                            this.dimension.resolve(HorizontalWidgetRun.tempDimensions[0]);
                            this.widget.verticalRun.dimension.resolve(HorizontalWidgetRun.tempDimensions[1]);
                            return;
                        }
                    }

                    if((this.start.resolved) && (this.end.resolved)) {
                        if(!v11.readyToSolve) {
                            return;
                        }
                        else if(!v12.readyToSolve) {
                            return;
                        }
                        else {
                            this.computeInsetRatio(HorizontalWidgetRun.tempDimensions, this.start.margin + this.start.value, this.end.value - this.end.margin, v11.margin + v11.targets.get(0).value, v12.targets.get(0).value - v12.margin, v6, v7);
                            this.dimension.resolve(HorizontalWidgetRun.tempDimensions[0]);
                            this.widget.verticalRun.dimension.resolve(HorizontalWidgetRun.tempDimensions[1]);
                        }
                    }

                    if(!this.start.readyToSolve) {
                        return;
                    }

                    if(!this.end.readyToSolve) {
                        return;
                    }

                    if(!v11.readyToSolve) {
                        return;
                    }

                    if(!v12.readyToSolve) {
                        return;
                    }

                    this.computeInsetRatio(HorizontalWidgetRun.tempDimensions, this.start.margin + this.start.targets.get(0).value, this.end.targets.get(0).value - this.end.margin, v11.margin + v11.targets.get(0).value, v12.targets.get(0).value - v12.margin, v6, v7);
                    this.dimension.resolve(HorizontalWidgetRun.tempDimensions[0]);
                    this.widget.verticalRun.dimension.resolve(HorizontalWidgetRun.tempDimensions[1]);
                    goto label_404;
                }

                if(v1 != 0 && v4 != 0) {
                    if(!this.start.readyToSolve) {
                        return;
                    }
                    else if(!this.end.readyToSolve) {
                        return;
                    }
                    else {
                        v1_1 = this.widget.getDimensionRatio();
                        v3 = this.start.targets.get(0).value + this.start.margin;
                        v4 = this.end.targets.get(0).value - this.end.margin;
                        if(v7 != v2 && v7 != 0) {
                            if(v7 != 1) {
                            }
                            else {
                                v2 = this.getLimitedDimension(v4 - v3, 0);
                                v3 = ((int)((((float)v2)) / v1_1 + v10));
                                v4 = this.getLimitedDimension(v3, 1);
                                if(v3 != v4) {
                                    v2 = ((int)((((float)v4)) * v1_1 + v10));
                                }

                                this.dimension.resolve(v2);
                                this.widget.verticalRun.dimension.resolve(v4);
                            }

                            goto label_404;
                        }

                        v2 = this.getLimitedDimension(v4 - v3, 0);
                        v3 = ((int)((((float)v2)) * v1_1 + v10));
                        v4 = this.getLimitedDimension(v3, 1);
                        if(v3 != v4) {
                            v2 = ((int)((((float)v4)) / v1_1 + v10));
                        }

                        this.dimension.resolve(v2);
                        this.widget.verticalRun.dimension.resolve(v4);
                        goto label_404;
                    }
                }

                if(v3 == 0) {
                    goto label_404;
                }

                if(v5 == 0) {
                    goto label_404;
                }

                if(!v11.readyToSolve) {
                    return;
                }

                if(!v12.readyToSolve) {
                    return;
                }

                v1_1 = this.widget.getDimensionRatio();
                v3 = v11.targets.get(0).value + v11.margin;
                v4 = v12.targets.get(0).value - v12.margin;
                if(v7 != v2) {
                    if(v7 == 0) {
                        v2 = this.getLimitedDimension(v4 - v3, 1);
                        v3 = ((int)((((float)v2)) * v1_1 + v10));
                        v4 = this.getLimitedDimension(v3, 0);
                        if(v3 != v4) {
                            v2 = ((int)((((float)v4)) / v1_1 + v10));
                        }

                        this.dimension.resolve(v4);
                        this.widget.verticalRun.dimension.resolve(v2);
                        goto label_404;
                    }
                    else if(v7 != 1) {
                        goto label_404;
                    }
                }

                v2 = this.getLimitedDimension(v4 - v3, 1);
                v3 = ((int)((((float)v2)) / v1_1 + v10));
                v4 = this.getLimitedDimension(v3, 0);
                if(v3 != v4) {
                    v2 = ((int)((((float)v4)) * v1_1 + v10));
                }

                this.dimension.resolve(v4);
                this.widget.verticalRun.dimension.resolve(v2);
            }

            goto label_404;
        }
    }
}

