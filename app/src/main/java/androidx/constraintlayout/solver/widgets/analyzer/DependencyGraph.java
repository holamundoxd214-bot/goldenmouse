package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class DependencyGraph {
    private static final boolean USE_GROUPS = true;
    private ConstraintWidgetContainer container;
    private ConstraintWidgetContainer mContainer;
    ArrayList mGroups;
    private Measure mMeasure;
    private Measurer mMeasurer;
    private boolean mNeedBuildGraph;
    private boolean mNeedRedoMeasures;
    private ArrayList mRuns;
    private ArrayList runGroups;

    public DependencyGraph(ConstraintWidgetContainer arg2) {
        super();
        this.mNeedBuildGraph = true;
        this.mNeedRedoMeasures = true;
        this.mRuns = new ArrayList();
        this.runGroups = new ArrayList();
        this.mMeasurer = null;
        this.mMeasure = new Measure();
        this.mGroups = new ArrayList();
        this.container = arg2;
        this.mContainer = arg2;
    }

    private void applyGroup(DependencyNode arg8, int arg9, int arg10, DependencyNode arg11, ArrayList arg12, RunGroup arg13) {
        Object v1;
        Iterator v9_1;
        ArrayList v5;
        DependencyNode v4;
        int v2;
        DependencyGraph v0;
        WidgetRun v8 = arg8.run;
        if(v8.runGroup == null && v8 != this.container.horizontalRun) {
            if(v8 == this.container.verticalRun) {
            }
            else {
                if(arg13 == null) {
                    arg13 = new RunGroup(v8, arg10);
                    arg12.add(arg13);
                }

                RunGroup v6 = arg13;
                v8.runGroup = v6;
                v6.add(v8);
                Iterator v10 = v8.start.dependencies.iterator();
                while(v10.hasNext()) {
                    Object v13 = v10.next();
                    if((v13 instanceof DependencyNode)) {
                        v0 = this;
                        v2 = arg9;
                        v4 = arg11;
                        v5 = arg12;
                        v0.applyGroup(v13, v2, 0, v4, v5, v6);
                    }
                    else {
                        v0 = this;
                        v2 = arg9;
                        v4 = arg11;
                        v5 = arg12;
                    }

                    this = v0;
                    arg9 = v2;
                    arg11 = v4;
                    arg12 = v5;
                }

                v0 = this;
                v2 = arg9;
                v4 = arg11;
                v5 = arg12;
                Iterator v7 = v8.end.dependencies.iterator();
                while(v7.hasNext()) {
                    Object v9 = v7.next();
                    if(!(v9 instanceof DependencyNode)) {
                        continue;
                    }

                    v0.applyGroup(v9, v2, 1, v4, v5, v6);
                }

                if(v2 == 1 && ((v8 instanceof VerticalWidgetRun))) {
                    v9_1 = v8.baseline.dependencies.iterator();
                    while(v9_1.hasNext()) {
                        Object v10_1 = v9_1.next();
                        if(!(v10_1 instanceof DependencyNode)) {
                            continue;
                        }

                        v0.applyGroup(v10_1, v2, 2, v4, v5, v6);
                    }
                }

                v9_1 = v8.start.targets.iterator();
                while(v9_1.hasNext()) {
                    v1 = v9_1.next();
                    if((((DependencyNode)v1)) == v4) {
                        v6.dual = true;
                    }

                    v0.applyGroup(((DependencyNode)v1), v2, 0, v4, v5, v6);
                }

                v9_1 = v8.end.targets.iterator();
                while(v9_1.hasNext()) {
                    v1 = v9_1.next();
                    if((((DependencyNode)v1)) == v4) {
                        v6.dual = true;
                    }

                    v0.applyGroup(((DependencyNode)v1), v2, 1, v4, v5, v6);
                }

                if(v2 != 1) {
                    return;
                }

                if(!(v8 instanceof VerticalWidgetRun)) {
                    return;
                }

                v7 = ((VerticalWidgetRun)v8).baseline.targets.iterator();
                while(v7.hasNext()) {
                    v0.applyGroup(v7.next(), v2, 2, v4, v5, v6);
                }
            }
        }
    }

    private boolean basicMeasureWidgets(ConstraintWidgetContainer arg14) {
        int v13;
        DimensionBehaviour v12;
        DimensionBehaviour v7_1;
        DependencyGraph v3_1;
        Iterator v0 = arg14.mChildren.iterator();
        while(v0.hasNext()) {
            Object v4 = v0.next();
            DimensionBehaviour v1 = ((ConstraintWidget)v4).mListDimensionBehaviors[0];
            DimensionBehaviour v3 = ((ConstraintWidget)v4).mListDimensionBehaviors[1];
            if(((ConstraintWidget)v4).getVisibility() == 8) {
                ((ConstraintWidget)v4).measured = true;
                continue;
            }

            float v10 = 1f;
            int v6 = 2;
            if(Float.compare(((ConstraintWidget)v4).mMatchConstraintPercentWidth, v10) < 0 && v1 == DimensionBehaviour.MATCH_CONSTRAINT) {
                ((ConstraintWidget)v4).mMatchConstraintDefaultWidth = v6;
            }

            if(((ConstraintWidget)v4).mMatchConstraintPercentHeight < v10 && v3 == DimensionBehaviour.MATCH_CONSTRAINT) {
                ((ConstraintWidget)v4).mMatchConstraintDefaultHeight = v6;
            }

            int v7 = 3;
            if(Float.compare(((ConstraintWidget)v4).getDimensionRatio(), 0f) > 0) {
                if(v1 == DimensionBehaviour.MATCH_CONSTRAINT && (v3 == DimensionBehaviour.WRAP_CONTENT || v3 == DimensionBehaviour.FIXED)) {
                    ((ConstraintWidget)v4).mMatchConstraintDefaultWidth = v7;
                    goto label_61;
                }

                if(v3 == DimensionBehaviour.MATCH_CONSTRAINT && (v1 == DimensionBehaviour.WRAP_CONTENT || v1 == DimensionBehaviour.FIXED)) {
                    ((ConstraintWidget)v4).mMatchConstraintDefaultHeight = v7;
                    goto label_61;
                }

                if(v1 != DimensionBehaviour.MATCH_CONSTRAINT) {
                    goto label_61;
                }

                if(v3 != DimensionBehaviour.MATCH_CONSTRAINT) {
                    goto label_61;
                }

                if(((ConstraintWidget)v4).mMatchConstraintDefaultWidth == 0) {
                    ((ConstraintWidget)v4).mMatchConstraintDefaultWidth = v7;
                }

                if(((ConstraintWidget)v4).mMatchConstraintDefaultHeight != 0) {
                    goto label_61;
                }

                ((ConstraintWidget)v4).mMatchConstraintDefaultHeight = v7;
            }

        label_61:
            if(v1 == DimensionBehaviour.MATCH_CONSTRAINT && ((ConstraintWidget)v4).mMatchConstraintDefaultWidth == 1 && (((ConstraintWidget)v4).mLeft.mTarget == null || ((ConstraintWidget)v4).mRight.mTarget == null)) {
                v1 = DimensionBehaviour.WRAP_CONTENT;
            }

            DimensionBehaviour v5 = v1;
            if(v3 == DimensionBehaviour.MATCH_CONSTRAINT && ((ConstraintWidget)v4).mMatchConstraintDefaultHeight == 1 && (((ConstraintWidget)v4).mTop.mTarget == null || ((ConstraintWidget)v4).mBottom.mTarget == null)) {
                v3 = DimensionBehaviour.WRAP_CONTENT;
            }

            ((ConstraintWidget)v4).horizontalRun.dimensionBehavior = v5;
            ((ConstraintWidget)v4).horizontalRun.matchConstraintsType = ((ConstraintWidget)v4).mMatchConstraintDefaultWidth;
            ((ConstraintWidget)v4).verticalRun.dimensionBehavior = v3;
            ((ConstraintWidget)v4).verticalRun.matchConstraintsType = ((ConstraintWidget)v4).mMatchConstraintDefaultHeight;
            if(v5 == DimensionBehaviour.MATCH_PARENT || v5 == DimensionBehaviour.FIXED || v5 == DimensionBehaviour.WRAP_CONTENT) {
                if(v3 != DimensionBehaviour.MATCH_PARENT && v3 != DimensionBehaviour.FIXED) {
                    if(v3 == DimensionBehaviour.WRAP_CONTENT) {
                    }
                    else {
                    label_107:
                        float v11 = 0.5f;
                        if(v5 == DimensionBehaviour.MATCH_CONSTRAINT) {
                            if(v3 != DimensionBehaviour.WRAP_CONTENT && v3 != DimensionBehaviour.FIXED) {
                                goto label_214;
                            }

                            if(((ConstraintWidget)v4).mMatchConstraintDefaultWidth == v7) {
                                if(v3 == DimensionBehaviour.WRAP_CONTENT) {
                                    v3_1 = this;
                                    v3_1.measure(((ConstraintWidget)v4), DimensionBehaviour.WRAP_CONTENT, 0, DimensionBehaviour.WRAP_CONTENT, 0);
                                }
                                else {
                                    v3_1 = this;
                                }

                                int v8 = ((ConstraintWidget)v4).getHeight();
                                v3_1.measure(((ConstraintWidget)v4), DimensionBehaviour.FIXED, ((int)((((float)v8)) * ((ConstraintWidget)v4).mDimensionRatio + v11)), DimensionBehaviour.FIXED, v8);
                                this = v3_1;
                                ((ConstraintWidget)v4).horizontalRun.dimension.resolve(((ConstraintWidget)v4).getWidth());
                                ((ConstraintWidget)v4).verticalRun.dimension.resolve(((ConstraintWidget)v4).getHeight());
                                ((ConstraintWidget)v4).measured = true;
                                continue;
                            }

                            if(((ConstraintWidget)v4).mMatchConstraintDefaultWidth == 1) {
                                v7_1 = v3;
                                v3_1 = this;
                                v3_1.measure(((ConstraintWidget)v4), DimensionBehaviour.WRAP_CONTENT, 0, v7_1, 0);
                                ((ConstraintWidget)v4).horizontalRun.dimension.wrapValue = ((ConstraintWidget)v4).getWidth();
                                goto label_423;
                            }

                            v12 = v3;
                            v3_1 = this;
                            v13 = v7;
                            v7_1 = v12;
                            if(((ConstraintWidget)v4).mMatchConstraintDefaultWidth == v6) {
                                if(arg14.mListDimensionBehaviors[0] != DimensionBehaviour.FIXED && arg14.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_PARENT) {
                                    goto label_218;
                                }

                                v3_1.measure(((ConstraintWidget)v4), DimensionBehaviour.FIXED, ((int)(((ConstraintWidget)v4).mMatchConstraintPercentWidth * (((float)arg14.getWidth())) + v11)), v7_1, ((ConstraintWidget)v4).getHeight());
                                ((ConstraintWidget)v4).horizontalRun.dimension.resolve(((ConstraintWidget)v4).getWidth());
                                ((ConstraintWidget)v4).verticalRun.dimension.resolve(((ConstraintWidget)v4).getHeight());
                                ((ConstraintWidget)v4).measured = true;
                                goto label_423;
                            }

                            if(((ConstraintWidget)v4).mListAnchors[0].mTarget != null && ((ConstraintWidget)v4).mListAnchors[1].mTarget != null) {
                                goto label_218;
                            }

                            v3_1.measure(((ConstraintWidget)v4), DimensionBehaviour.WRAP_CONTENT, 0, v7_1, 0);
                            ((ConstraintWidget)v4).horizontalRun.dimension.resolve(((ConstraintWidget)v4).getWidth());
                            ((ConstraintWidget)v4).verticalRun.dimension.resolve(((ConstraintWidget)v4).getHeight());
                            ((ConstraintWidget)v4).measured = true;
                            goto label_423;
                        }
                        else {
                        label_214:
                            v12 = v3;
                            v3_1 = this;
                            v13 = v7;
                            v7_1 = v12;
                        }

                    label_218:
                        if(v7_1 == DimensionBehaviour.MATCH_CONSTRAINT && (v5 == DimensionBehaviour.WRAP_CONTENT || v5 == DimensionBehaviour.FIXED)) {
                            if(((ConstraintWidget)v4).mMatchConstraintDefaultHeight == v13) {
                                if(v5 == DimensionBehaviour.WRAP_CONTENT) {
                                    v3_1.measure(((ConstraintWidget)v4), DimensionBehaviour.WRAP_CONTENT, 0, DimensionBehaviour.WRAP_CONTENT, 0);
                                }

                                v6 = ((ConstraintWidget)v4).getWidth();
                                float v13_1 = ((ConstraintWidget)v4).mDimensionRatio;
                                if(((ConstraintWidget)v4).getDimensionRatioSide() == -1) {
                                    v13_1 = v10 / v13_1;
                                }

                                v3_1.measure(((ConstraintWidget)v4), DimensionBehaviour.FIXED, v6, DimensionBehaviour.FIXED, ((int)((((float)v6)) * v13_1 + v11)));
                                ((ConstraintWidget)v4).horizontalRun.dimension.resolve(((ConstraintWidget)v4).getWidth());
                                ((ConstraintWidget)v4).verticalRun.dimension.resolve(((ConstraintWidget)v4).getHeight());
                                ((ConstraintWidget)v4).measured = true;
                                goto label_423;
                            }

                            if(((ConstraintWidget)v4).mMatchConstraintDefaultHeight == 1) {
                                v3_1.measure(((ConstraintWidget)v4), v5, 0, DimensionBehaviour.WRAP_CONTENT, 0);
                                ((ConstraintWidget)v4).verticalRun.dimension.wrapValue = ((ConstraintWidget)v4).getHeight();
                                goto label_423;
                            }

                            if(((ConstraintWidget)v4).mMatchConstraintDefaultHeight == v6) {
                                if(arg14.mListDimensionBehaviors[1] != DimensionBehaviour.FIXED && arg14.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_PARENT) {
                                    goto label_318;
                                }

                                v3_1.measure(((ConstraintWidget)v4), v5, ((ConstraintWidget)v4).getWidth(), DimensionBehaviour.FIXED, ((int)(((ConstraintWidget)v4).mMatchConstraintPercentHeight * (((float)arg14.getHeight())) + v11)));
                                ((ConstraintWidget)v4).horizontalRun.dimension.resolve(((ConstraintWidget)v4).getWidth());
                                ((ConstraintWidget)v4).verticalRun.dimension.resolve(((ConstraintWidget)v4).getHeight());
                                ((ConstraintWidget)v4).measured = true;
                                goto label_423;
                            }

                            if(((ConstraintWidget)v4).mListAnchors[v6].mTarget != null && ((ConstraintWidget)v4).mListAnchors[v13].mTarget != null) {
                                goto label_318;
                            }

                            v3_1.measure(((ConstraintWidget)v4), DimensionBehaviour.WRAP_CONTENT, 0, v7_1, 0);
                            ((ConstraintWidget)v4).horizontalRun.dimension.resolve(((ConstraintWidget)v4).getWidth());
                            ((ConstraintWidget)v4).verticalRun.dimension.resolve(((ConstraintWidget)v4).getHeight());
                            ((ConstraintWidget)v4).measured = true;
                            goto label_423;
                        }

                    label_318:
                        if(v5 != DimensionBehaviour.MATCH_CONSTRAINT) {
                            goto label_423;
                        }

                        if(v7_1 != DimensionBehaviour.MATCH_CONSTRAINT) {
                            goto label_423;
                        }

                        if(((ConstraintWidget)v4).mMatchConstraintDefaultWidth != 1) {
                            if(((ConstraintWidget)v4).mMatchConstraintDefaultHeight == 1) {
                            }
                            else {
                                if(((ConstraintWidget)v4).mMatchConstraintDefaultHeight != v6) {
                                }
                                else if(((ConstraintWidget)v4).mMatchConstraintDefaultWidth == v6) {
                                    if(arg14.mListDimensionBehaviors[0] != DimensionBehaviour.FIXED && arg14.mListDimensionBehaviors[0] != DimensionBehaviour.FIXED) {
                                        goto label_423;
                                    }

                                    if(arg14.mListDimensionBehaviors[1] != DimensionBehaviour.FIXED && arg14.mListDimensionBehaviors[1] != DimensionBehaviour.FIXED) {
                                        goto label_423;
                                    }

                                    v3_1.measure(((ConstraintWidget)v4), DimensionBehaviour.FIXED, ((int)(((ConstraintWidget)v4).mMatchConstraintPercentWidth * (((float)arg14.getWidth())) + v11)), DimensionBehaviour.FIXED, ((int)(((ConstraintWidget)v4).mMatchConstraintPercentHeight * (((float)arg14.getHeight())) + v11)));
                                    ((ConstraintWidget)v4).horizontalRun.dimension.resolve(((ConstraintWidget)v4).getWidth());
                                    ((ConstraintWidget)v4).verticalRun.dimension.resolve(((ConstraintWidget)v4).getHeight());
                                    ((ConstraintWidget)v4).measured = true;
                                }
                                else {
                                }

                                goto label_423;
                            }
                        }

                        v3_1.measure(((ConstraintWidget)v4), DimensionBehaviour.WRAP_CONTENT, 0, DimensionBehaviour.WRAP_CONTENT, 0);
                        ((ConstraintWidget)v4).horizontalRun.dimension.wrapValue = ((ConstraintWidget)v4).getWidth();
                        ((ConstraintWidget)v4).verticalRun.dimension.wrapValue = ((ConstraintWidget)v4).getHeight();
                        goto label_423;
                    }
                }

                v7_1 = v3;
                v3_1 = this;
                v13 = ((ConstraintWidget)v4).getWidth();
                if(v5 == DimensionBehaviour.MATCH_PARENT) {
                    v13 = arg14.getWidth() - ((ConstraintWidget)v4).mLeft.mMargin - ((ConstraintWidget)v4).mRight.mMargin;
                    v5 = DimensionBehaviour.FIXED;
                }

                v6 = v13;
                v13 = ((ConstraintWidget)v4).getHeight();
                if(v7_1 == DimensionBehaviour.MATCH_PARENT) {
                    v13 = arg14.getHeight() - ((ConstraintWidget)v4).mTop.mMargin - ((ConstraintWidget)v4).mBottom.mMargin;
                    v7_1 = DimensionBehaviour.FIXED;
                }

                v3_1.measure(((ConstraintWidget)v4), v5, v6, v7_1, v13);
                ((ConstraintWidget)v4).horizontalRun.dimension.resolve(((ConstraintWidget)v4).getWidth());
                ((ConstraintWidget)v4).verticalRun.dimension.resolve(((ConstraintWidget)v4).getHeight());
                ((ConstraintWidget)v4).measured = true;
            }
            else {
                goto label_107;
            }

        label_423:
            this = v3_1;
        }

        return 0;
    }

    public void buildGraph() {
        this.buildGraph(this.mRuns);
        this.mGroups.clear();
        RunGroup.index = 0;
        this.findGroup(this.container.horizontalRun, 0, this.mGroups);
        this.findGroup(this.container.verticalRun, 1, this.mGroups);
        this.mNeedBuildGraph = false;
    }

    public void buildGraph(ArrayList arg6) {
        arg6.clear();
        this.mContainer.horizontalRun.clear();
        this.mContainer.verticalRun.clear();
        arg6.add(this.mContainer.horizontalRun);
        arg6.add(this.mContainer.verticalRun);
        Iterator v0 = this.mContainer.mChildren.iterator();
        HashSet v1 = null;
        while(v0.hasNext()) {
            Object v2 = v0.next();
            if((v2 instanceof Guideline)) {
                arg6.add(new GuidelineReference(((ConstraintWidget)v2)));
                continue;
            }

            if(((ConstraintWidget)v2).isInHorizontalChain()) {
                if(((ConstraintWidget)v2).horizontalChainRun == null) {
                    ((ConstraintWidget)v2).horizontalChainRun = new ChainRun(((ConstraintWidget)v2), 0);
                }

                if(v1 == null) {
                    v1 = new HashSet();
                }

                v1.add(((ConstraintWidget)v2).horizontalChainRun);
            }
            else {
                arg6.add(((ConstraintWidget)v2).horizontalRun);
            }

            if(((ConstraintWidget)v2).isInVerticalChain()) {
                if(((ConstraintWidget)v2).verticalChainRun == null) {
                    ((ConstraintWidget)v2).verticalChainRun = new ChainRun(((ConstraintWidget)v2), 1);
                }

                if(v1 == null) {
                    v1 = new HashSet();
                }

                v1.add(((ConstraintWidget)v2).verticalChainRun);
            }
            else {
                arg6.add(((ConstraintWidget)v2).verticalRun);
            }

            if(!(v2 instanceof HelperWidget)) {
                continue;
            }

            arg6.add(new HelperReferences(((ConstraintWidget)v2)));
        }

        if(v1 != null) {
            arg6.addAll(((Collection)v1));
        }

        v0 = arg6.iterator();
        while(v0.hasNext()) {
            v0.next().clear();
        }

        Iterator v6 = arg6.iterator();
        while(v6.hasNext()) {
            Object v0_1 = v6.next();
            if(((WidgetRun)v0_1).widget == this.mContainer) {
                continue;
            }

            ((WidgetRun)v0_1).apply();
        }
    }

    private int computeWrap(ConstraintWidgetContainer arg7, int arg8) {
        int v0 = this.mGroups.size();
        long v1 = 0;
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            v1 = Math.max(v1, this.mGroups.get(v3).computeWrapSize(arg7, arg8));
        }

        return ((int)v1);
    }

    public void defineTerminalWidgets(DimensionBehaviour arg7, DimensionBehaviour arg8) {
        if(this.mNeedBuildGraph) {
            this.buildGraph();
            Iterator v0 = this.container.mChildren.iterator();
            int v2;
            for(v2 = 0; v0.hasNext(); v2 = 1) {
                Object v3 = v0.next();
                ((ConstraintWidget)v3).isTerminalWidget[0] = true;
                ((ConstraintWidget)v3).isTerminalWidget[1] = true;
                if(!(v3 instanceof Barrier)) {
                    continue;
                }
            }

            if(v2 == 0) {
                Iterator v6 = this.mGroups.iterator();
                while(v6.hasNext()) {
                    Object v0_1 = v6.next();
                    boolean v2_1 = arg7 == DimensionBehaviour.WRAP_CONTENT ? true : false;
                    boolean v3_1 = arg8 == DimensionBehaviour.WRAP_CONTENT ? true : false;
                    ((RunGroup)v0_1).defineTerminalWidgets(v2_1, v3_1);
                }
            }
        }
    }

    public boolean directMeasure(boolean arg9) {
        Object v5_1;
        int v9;
        boolean v1 = false;
        if((this.mNeedBuildGraph) || (this.mNeedRedoMeasures)) {
            Iterator v0 = this.container.mChildren.iterator();
            while(v0.hasNext()) {
                Object v2 = v0.next();
                ((ConstraintWidget)v2).measured = false;
                ((ConstraintWidget)v2).horizontalRun.reset();
                ((ConstraintWidget)v2).verticalRun.reset();
            }

            this.container.measured = false;
            this.container.horizontalRun.reset();
            this.container.verticalRun.reset();
            this.mNeedRedoMeasures = false;
        }

        if(this.basicMeasureWidgets(this.mContainer)) {
            return 0;
        }

        this.container.setX(0);
        this.container.setY(0);
        DimensionBehaviour v0_1 = this.container.getDimensionBehaviour(0);
        DimensionBehaviour v2_1 = this.container.getDimensionBehaviour(1);
        if(this.mNeedBuildGraph) {
            this.buildGraph();
        }

        int v4 = this.container.getX();
        int v5 = this.container.getY();
        this.container.horizontalRun.start.resolve(v4);
        this.container.verticalRun.start.resolve(v5);
        this.measureWidgets();
        if(v0_1 == DimensionBehaviour.WRAP_CONTENT || v2_1 == DimensionBehaviour.WRAP_CONTENT) {
            if(arg9) {
                Iterator v6 = this.mRuns.iterator();
                do {
                    if(v6.hasNext()) {
                        if(v6.next().supportsWrapComputation()) {
                            continue;
                        }

                        break;
                    }

                    break;
                }
                while(true);
            }

            if(0 != 0 && v0_1 == DimensionBehaviour.WRAP_CONTENT) {
                this.container.setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
                this.container.setWidth(this.computeWrap(this.container, 0));
                this.container.horizontalRun.dimension.resolve(this.container.getWidth());
            }

            if(0 == 0) {
                goto label_98;
            }

            if(v2_1 != DimensionBehaviour.WRAP_CONTENT) {
                goto label_98;
            }

            this.container.setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
            this.container.setHeight(this.computeWrap(this.container, 1));
            this.container.verticalRun.dimension.resolve(this.container.getHeight());
        }

    label_98:
        if(this.container.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED || this.container.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_PARENT) {
            v9 = this.container.getWidth() + v4;
            this.container.horizontalRun.end.resolve(v9);
            this.container.horizontalRun.dimension.resolve(v9 - v4);
            this.measureWidgets();
            if(this.container.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED || this.container.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_PARENT) {
                v9 = this.container.getHeight() + v5;
                this.container.verticalRun.end.resolve(v9);
                this.container.verticalRun.dimension.resolve(v9 - v5);
            }

            this.measureWidgets();
            v9 = 1;
        }
        else {
            v9 = 0;
        }

        Iterator v4_1 = this.mRuns.iterator();
        while(v4_1.hasNext()) {
            v5_1 = v4_1.next();
            if(((WidgetRun)v5_1).widget == this.container && !((WidgetRun)v5_1).resolved) {
                continue;
            }

            ((WidgetRun)v5_1).applyToWidget();
        }

        v4_1 = this.mRuns.iterator();
        do {
            if(v4_1.hasNext()) {
                v5_1 = v4_1.next();
                if(v9 == 0 && ((WidgetRun)v5_1).widget == this.container) {
                    continue;
                }

                if(!((WidgetRun)v5_1).start.resolved) {
                    goto label_190;
                }

                if(!((WidgetRun)v5_1).end.resolved && !(v5_1 instanceof GuidelineReference)) {
                    goto label_190;
                }

                if(((WidgetRun)v5_1).dimension.resolved) {
                    continue;
                }

                if((v5_1 instanceof ChainRun)) {
                    continue;
                }

                if((v5_1 instanceof GuidelineReference)) {
                    continue;
                }

                break;
            }
            else {
                goto label_189;
            }
        }
        while(true);

        goto label_190;
    label_189:
        v1 = true;
    label_190:
        this.container.setHorizontalDimensionBehaviour(v0_1);
        this.container.setVerticalDimensionBehaviour(v2_1);
        return v1;
    }

    public boolean directMeasureSetup(boolean arg4) {
        if(this.mNeedBuildGraph) {
            Iterator v4 = this.container.mChildren.iterator();
            while(v4.hasNext()) {
                Object v1 = v4.next();
                ((ConstraintWidget)v1).measured = false;
                ((ConstraintWidget)v1).horizontalRun.dimension.resolved = false;
                ((ConstraintWidget)v1).horizontalRun.resolved = false;
                ((ConstraintWidget)v1).horizontalRun.reset();
                ((ConstraintWidget)v1).verticalRun.dimension.resolved = false;
                ((ConstraintWidget)v1).verticalRun.resolved = false;
                ((ConstraintWidget)v1).verticalRun.reset();
            }

            this.container.measured = false;
            this.container.horizontalRun.dimension.resolved = false;
            this.container.horizontalRun.resolved = false;
            this.container.horizontalRun.reset();
            this.container.verticalRun.dimension.resolved = false;
            this.container.verticalRun.resolved = false;
            this.container.verticalRun.reset();
            this.buildGraph();
        }

        if(this.basicMeasureWidgets(this.mContainer)) {
            return 0;
        }

        this.container.setX(0);
        this.container.setY(0);
        this.container.horizontalRun.start.resolve(0);
        this.container.verticalRun.start.resolve(0);
        return 1;
    }

    public boolean directMeasureWithOrientation(boolean arg10, int arg11) {
        Object v5_1;
        int v10_1;
        boolean v1 = false;
        DimensionBehaviour v0 = this.container.getDimensionBehaviour(0);
        DimensionBehaviour v2 = this.container.getDimensionBehaviour(1);
        int v4 = this.container.getX();
        int v5 = this.container.getY();
        if((arg10) && (v0 == DimensionBehaviour.WRAP_CONTENT || v2 == DimensionBehaviour.WRAP_CONTENT)) {
            Iterator v6 = this.mRuns.iterator();
            do {
            label_17:
                if(!v6.hasNext()) {
                    break;
                }

                Object v7 = v6.next();
                if(((WidgetRun)v7).orientation != arg11) {
                    goto label_17;
                }
            }
            while(((WidgetRun)v7).supportsWrapComputation());

            if(arg11 == 0) {
                if(0 == 0) {
                    goto label_57;
                }

                if(v0 != DimensionBehaviour.WRAP_CONTENT) {
                    goto label_57;
                }

                this.container.setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
                this.container.setWidth(this.computeWrap(this.container, 0));
                this.container.horizontalRun.dimension.resolve(this.container.getWidth());
                goto label_57;
            }

            if(0 == 0) {
                goto label_57;
            }

            if(v2 != DimensionBehaviour.WRAP_CONTENT) {
                goto label_57;
            }

            this.container.setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
            this.container.setHeight(this.computeWrap(this.container, 1));
            this.container.verticalRun.dimension.resolve(this.container.getHeight());
        }

    label_57:
        ConstraintWidgetContainer v10 = this.container;
        if(arg11 == 0) {
            if(v10.mListDimensionBehaviors[0] != DimensionBehaviour.FIXED && this.container.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_PARENT) {
                goto label_91;
            }

            v10_1 = this.container.getWidth() + v4;
            this.container.horizontalRun.end.resolve(v10_1);
            this.container.horizontalRun.dimension.resolve(v10_1 - v4);
            goto label_105;
        }
        else {
            if(v10.mListDimensionBehaviors[1] != DimensionBehaviour.FIXED) {
                if(this.container.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_PARENT) {
                }
                else {
                label_91:
                    v10_1 = 0;
                    goto label_106;
                }
            }

            v10_1 = this.container.getHeight() + v5;
            this.container.verticalRun.end.resolve(v10_1);
            this.container.verticalRun.dimension.resolve(v10_1 - v5);
        label_105:
            v10_1 = 1;
        }

    label_106:
        this.measureWidgets();
        Iterator v4_1 = this.mRuns.iterator();
        while(v4_1.hasNext()) {
            v5_1 = v4_1.next();
            if(((WidgetRun)v5_1).orientation != arg11) {
                continue;
            }

            if(((WidgetRun)v5_1).widget == this.container && !((WidgetRun)v5_1).resolved) {
                continue;
            }

            ((WidgetRun)v5_1).applyToWidget();
        }

        v4_1 = this.mRuns.iterator();
        do {
            if(v4_1.hasNext()) {
                v5_1 = v4_1.next();
                if(((WidgetRun)v5_1).orientation != arg11) {
                    continue;
                }
                else {
                    if(v10_1 == 0 && ((WidgetRun)v5_1).widget == this.container) {
                        continue;
                    }

                    if(!((WidgetRun)v5_1).start.resolved) {
                        goto label_151;
                    }

                    if(!((WidgetRun)v5_1).end.resolved) {
                        goto label_151;
                    }

                    if((v5_1 instanceof ChainRun)) {
                        continue;
                    }

                    if(((WidgetRun)v5_1).dimension.resolved) {
                        continue;
                    }

                    break;
                }
            }
            else {
                goto label_150;
            }

            goto label_151;
        }
        while(true);

        goto label_151;
    label_150:
        v1 = true;
    label_151:
        this.container.setHorizontalDimensionBehaviour(v0);
        this.container.setVerticalDimensionBehaviour(v2);
        return v1;
    }

    private void displayGraph() {
        Iterator v0 = this.mRuns.iterator();
        String v1;
        for(v1 = "digraph {\n"; v0.hasNext(); v1 = this.generateDisplayGraph(v0.next(), v1)) {
        }

        System.out.println("content:<<\n" + (v1 + "\n}\n") + "\n>>");
    }

    private void findGroup(WidgetRun arg19, int arg20, ArrayList arg21) {
        Object v2;
        WidgetRun v0 = arg19;
        Iterator v1 = v0.start.dependencies.iterator();
        while(v1.hasNext()) {
            v2 = v1.next();
            if((v2 instanceof DependencyNode)) {
                this.applyGroup(v2, arg20, 0, v0.end, arg21, null);
                continue;
            }

            if(!(v2 instanceof WidgetRun)) {
                continue;
            }

            this.applyGroup(((WidgetRun)v2).start, arg20, 0, v0.end, arg21, null);
        }

        v1 = v0.end.dependencies.iterator();
        while(v1.hasNext()) {
            v2 = v1.next();
            if((v2 instanceof DependencyNode)) {
                this.applyGroup(v2, arg20, 1, v0.start, arg21, null);
                continue;
            }

            if(!(v2 instanceof WidgetRun)) {
                continue;
            }

            this.applyGroup(((WidgetRun)v2).end, arg20, 1, v0.start, arg21, null);
        }

        int v13 = arg20;
        if(v13 == 1) {
            Iterator v0_1 = ((VerticalWidgetRun)v0).baseline.dependencies.iterator();
            while(v0_1.hasNext()) {
                Object v1_1 = v0_1.next();
                if((v1_1 instanceof DependencyNode)) {
                    this.applyGroup(v1_1, v13, 2, null, arg21, null);
                }

                v13 = arg20;
            }
        }
    }

    private String generateChainDisplayGraph(ChainRun arg7, String arg8) {
        int v0 = arg7.orientation;
        String v1 = "cluster_" + arg7.widget.getDebugName();
        v1 = v0 == 0 ? v1 + "_h" : v1 + "_v";
        v1 = "subgraph " + v1 + " {\n";
        Iterator v7 = arg7.widgets.iterator();
        String v2;
        for(v2 = ""; v7.hasNext(); v2 = this.generateDisplayGraph(((WidgetRun)v3), v2)) {
            Object v3 = v7.next();
            String v4 = ((WidgetRun)v3).widget.getDebugName();
            v4 = v0 == 0 ? v4 + "_HORIZONTAL" : v4 + "_VERTICAL";
            v1 = v1 + v4 + ";\n";
        }

        return arg8 + v2 + (v1 + "}\n");
    }

    private String generateDisplayGraph(WidgetRun arg9, String arg10) {
        String v0_1;
        DimensionBehaviour v2_1;
        DependencyNode v0 = arg9.start;
        DependencyNode v1 = arg9.end;
        if(!(arg9 instanceof HelperReferences) && (v0.dependencies.isEmpty()) && (v1.dependencies.isEmpty() & v0.targets.isEmpty()) != 0 && (v1.targets.isEmpty())) {
            return arg10;
        }

        arg10 = arg10 + this.nodeDefinition(arg9);
        boolean v2 = this.isCenteredConnection(v0, v1);
        arg10 = this.generateDisplayNode(v1, v2, this.generateDisplayNode(v0, v2, arg10));
        boolean v3 = arg9 instanceof VerticalWidgetRun;
        if(v3) {
            arg10 = this.generateDisplayNode(arg9.baseline, v2, arg10);
        }

        String v5 = " -> ";
        String v6 = "\n";
        if(!(arg9 instanceof HorizontalWidgetRun)) {
            v2 = arg9 instanceof ChainRun;
            if((v2) && arg9.orientation == 0) {
                goto label_114;
            }

            if(!v3) {
                if(!v2) {
                }
                else if(arg9.orientation == 1) {
                    goto label_48;
                }

                goto label_179;
            }

        label_48:
            v2_1 = arg9.widget.getVerticalDimensionBehaviour();
            if(v2_1 != DimensionBehaviour.FIXED) {
                if(v2_1 == DimensionBehaviour.WRAP_CONTENT) {
                }
                else {
                    if(v2_1 != DimensionBehaviour.MATCH_CONSTRAINT) {
                    }
                    else if(arg9.widget.getDimensionRatio() > 0f) {
                        v0_1 = arg9.widget.getDebugName();
                        new StringBuilder(v6).append(v0_1).append("_VERTICAL -> ").append(v0_1).append("_HORIZONTAL;\n").toString();
                    }
                    else {
                    }

                    goto label_179;
                }
            }

            if(!v0.targets.isEmpty() && (v1.targets.isEmpty())) {
                arg10 = arg10 + (v6 + v1.name() + v5 + v0.name() + v6);
                goto label_179;
            }

            if(!v0.targets.isEmpty()) {
                goto label_179;
            }

            if(v1.targets.isEmpty()) {
                goto label_179;
            }

            arg10 = arg10 + (v6 + v0.name() + v5 + v1.name() + v6);
        }
        else {
        label_114:
            v2_1 = arg9.widget.getHorizontalDimensionBehaviour();
            if(v2_1 != DimensionBehaviour.FIXED) {
                if(v2_1 == DimensionBehaviour.WRAP_CONTENT) {
                }
                else {
                    if(v2_1 != DimensionBehaviour.MATCH_CONSTRAINT) {
                    }
                    else if(arg9.widget.getDimensionRatio() > 0f) {
                        v0_1 = arg9.widget.getDebugName();
                        new StringBuilder(v6).append(v0_1).append("_HORIZONTAL -> ").append(v0_1).append("_VERTICAL;\n").toString();
                    }
                    else {
                    }

                    goto label_179;
                }
            }

            if(!v0.targets.isEmpty() && (v1.targets.isEmpty())) {
                arg10 = arg10 + (v6 + v1.name() + v5 + v0.name() + v6);
                goto label_179;
            }

            if(!v0.targets.isEmpty()) {
                goto label_179;
            }

            if(v1.targets.isEmpty()) {
                goto label_179;
            }

            arg10 = arg10 + (v6 + v0.name() + v5 + v1.name() + v6);
        }

    label_179:
        if((arg9 instanceof ChainRun)) {
            return this.generateChainDisplayGraph(((ChainRun)arg9), arg10);
        }

        return arg10;
    }

    private String generateDisplayNode(DependencyNode arg5, boolean arg6, String arg7) {
        Iterator v4 = arg5.targets.iterator();
        while(v4.hasNext()) {
            String v2 = "\n";
            String v0 = v2 + arg5.name() + " -> " + v4.next().name();
            if(arg5.margin > 0 || (arg6) || ((arg5.run instanceof HelperReferences))) {
                v0 = v0 + "[";
                if(arg5.margin > 0) {
                    v0 = v0 + "label=\"" + arg5.margin + "\"";
                    if(arg6) {
                        v0 = v0 + ",";
                    }
                }

                if(arg6) {
                    v0 = v0 + " style=dashed ";
                }

                if((arg5.run instanceof HelperReferences)) {
                    v0 = v0 + " style=bold,color=gray ";
                }

                v0 = v0 + "]";
            }

            arg7 = arg7 + (v0 + v2);
        }

        return arg7;
    }

    public void invalidateGraph() {
        this.mNeedBuildGraph = true;
    }

    public void invalidateMeasures() {
        this.mNeedRedoMeasures = true;
    }

    private boolean isCenteredConnection(DependencyNode arg4, DependencyNode arg5) {
        Iterator v3 = arg4.targets.iterator();
        int v1;
        for(v1 = 0; v3.hasNext(); ++v1) {
            if(v3.next() == arg5) {
                continue;
            }
        }

        v3 = arg5.targets.iterator();
        int v5;
        for(v5 = 0; v3.hasNext(); ++v5) {
            if(v3.next() == arg4) {
                continue;
            }
        }

        if(v1 > 0 && v5 > 0) {
            return 1;
        }

        return 0;
    }

    private void measure(ConstraintWidget arg2, DimensionBehaviour arg3, int arg4, DimensionBehaviour arg5, int arg6) {
        this.mMeasure.horizontalBehavior = arg3;
        this.mMeasure.verticalBehavior = arg5;
        this.mMeasure.horizontalDimension = arg4;
        this.mMeasure.verticalDimension = arg6;
        this.mMeasurer.measure(arg2, this.mMeasure);
        arg2.setWidth(this.mMeasure.measuredWidth);
        arg2.setHeight(this.mMeasure.measuredHeight);
        arg2.setHasBaseline(this.mMeasure.measuredHasBaseline);
        arg2.setBaselineDistance(this.mMeasure.measuredBaseline);
    }

    public void measureWidgets() {
        DependencyGraph v2_1;
        Iterator v0 = this.container.mChildren.iterator();
        while(v0.hasNext()) {
            Object v3 = v0.next();
            if(((ConstraintWidget)v3).measured) {
                continue;
            }

            int v2 = 0;
            DimensionBehaviour v1 = ((ConstraintWidget)v3).mListDimensionBehaviors[0];
            DimensionBehaviour v9 = ((ConstraintWidget)v3).mListDimensionBehaviors[1];
            int v4 = ((ConstraintWidget)v3).mMatchConstraintDefaultWidth;
            int v5 = ((ConstraintWidget)v3).mMatchConstraintDefaultHeight;
            if(v1 != DimensionBehaviour.WRAP_CONTENT) {
                if(v1 == DimensionBehaviour.MATCH_CONSTRAINT && v4 == 1) {
                    goto label_26;
                }

                v4 = 0;
            }
            else {
            label_26:
                v4 = 1;
            }

            if(v9 == DimensionBehaviour.WRAP_CONTENT || v9 == DimensionBehaviour.MATCH_CONSTRAINT && v5 == 1) {
                v2 = 1;
            }

            boolean v5_1 = ((ConstraintWidget)v3).horizontalRun.dimension.resolved;
            boolean v6 = ((ConstraintWidget)v3).verticalRun.dimension.resolved;
            if(!v5_1 || !v6) {
                if((v5_1) && v2 != 0) {
                    v2_1 = this;
                    v2_1.measure(((ConstraintWidget)v3), DimensionBehaviour.FIXED, ((ConstraintWidget)v3).horizontalRun.dimension.value, DimensionBehaviour.WRAP_CONTENT, ((ConstraintWidget)v3).verticalRun.dimension.value);
                    if(v9 == DimensionBehaviour.MATCH_CONSTRAINT) {
                        ((ConstraintWidget)v3).verticalRun.dimension.wrapValue = ((ConstraintWidget)v3).getHeight();
                    }
                    else {
                        ((ConstraintWidget)v3).verticalRun.dimension.resolve(((ConstraintWidget)v3).getHeight());
                        ((ConstraintWidget)v3).measured = true;
                    }

                    goto label_102;
                }

                v2_1 = this;
                if(!v6) {
                    goto label_102;
                }

                if(v4 == 0) {
                    goto label_102;
                }

                v2_1.measure(((ConstraintWidget)v3), DimensionBehaviour.WRAP_CONTENT, ((ConstraintWidget)v3).horizontalRun.dimension.value, DimensionBehaviour.FIXED, ((ConstraintWidget)v3).verticalRun.dimension.value);
                if(v1 == DimensionBehaviour.MATCH_CONSTRAINT) {
                    ((ConstraintWidget)v3).horizontalRun.dimension.wrapValue = ((ConstraintWidget)v3).getWidth();
                    goto label_102;
                }

                ((ConstraintWidget)v3).horizontalRun.dimension.resolve(((ConstraintWidget)v3).getWidth());
                ((ConstraintWidget)v3).measured = true;
            }
            else {
                v2_1 = this;
                v2_1.measure(((ConstraintWidget)v3), DimensionBehaviour.FIXED, ((ConstraintWidget)v3).horizontalRun.dimension.value, DimensionBehaviour.FIXED, ((ConstraintWidget)v3).verticalRun.dimension.value);
                ((ConstraintWidget)v3).measured = true;
            }

        label_102:
            if((((ConstraintWidget)v3).measured) && ((ConstraintWidget)v3).verticalRun.baselineDimension != null) {
                ((ConstraintWidget)v3).verticalRun.baselineDimension.resolve(((ConstraintWidget)v3).getBaselineDistance());
            }

            this = v2_1;
        }
    }

    private String nodeDefinition(WidgetRun arg8) {
        String v7_1;
        boolean v7 = arg8 instanceof VerticalWidgetRun;
        String v0 = arg8.widget.getDebugName();
        ConstraintWidget v1 = arg8.widget;
        DimensionBehaviour v1_1 = !v7 ? v1.getHorizontalDimensionBehaviour() : v1.getVerticalDimensionBehaviour();
        RunGroup v2 = arg8.runGroup;
        String v3 = !v7 ? v0 + "_HORIZONTAL" : v0 + "_VERTICAL";
        v3 = v3 + " [shape=none, label=<" + "<TABLE BORDER=\"0\" CELLSPACING=\"0\" CELLPADDING=\"2\">" + "  <TR>";
        String v4 = " BGCOLOR=\"green\"";
        String v5 = "    <TD ";
        if(!v7) {
            v3 = v3 + v5;
            if(arg8.start.resolved) {
                v3 = v3 + v4;
            }

            v3 = v3 + " PORT=\"LEFT\" BORDER=\"1\">L</TD>";
        }
        else {
            v3 = v3 + v5;
            if(arg8.start.resolved) {
                v3 = v3 + v4;
            }

            v3 = v3 + " PORT=\"TOP\" BORDER=\"1\">T</TD>";
        }

        v3 = v3 + "    <TD BORDER=\"1\" ";
        if(!arg8.dimension.resolved || (arg8.widget.measured)) {
            if((arg8.dimension.resolved) && (arg8.widget.measured)) {
                v3 = v3 + " BGCOLOR=\"lightgray\" ";
                goto label_127;
            }

            if(arg8.dimension.resolved) {
                goto label_127;
            }

            if(!arg8.widget.measured) {
                goto label_127;
            }

            v3 = v3 + " BGCOLOR=\"yellow\" ";
        }
        else {
            v3 = v3 + " BGCOLOR=\"green\" ";
        }

    label_127:
        if(v1_1 == DimensionBehaviour.MATCH_CONSTRAINT) {
            v3 = v3 + "style=\"dashed\"";
        }

        String v1_2 = v2 != null ? " [" + (v2.groupIndex + 1) + "/" + RunGroup.index + "]" : "";
        v0 = v3 + ">" + v0 + v1_2 + " </TD>";
        if(!v7) {
            v7_1 = v0 + v5;
            if(arg8.end.resolved) {
                v7_1 = v7_1 + v4;
            }

            v7_1 = v7_1 + " PORT=\"RIGHT\" BORDER=\"1\">R</TD>";
        }
        else {
            v0 = v0 + v5;
            if((v7) && (arg8.baseline.resolved)) {
                v0 = v0 + v4;
            }

            v7_1 = v0 + " PORT=\"BASELINE\" BORDER=\"1\">b</TD>" + v5;
            if(arg8.end.resolved) {
                v7_1 = v7_1 + v4;
            }

            v7_1 = v7_1 + " PORT=\"BOTTOM\" BORDER=\"1\">B</TD>";
        }

        return v7_1 + "  </TR></TABLE>" + ">];\n";
    }

    public void setMeasurer(Measurer arg1) {
        this.mMeasurer = arg1;
    }
}

