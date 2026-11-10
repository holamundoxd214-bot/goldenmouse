package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import java.util.ArrayList;

public class BasicMeasure {
    public class Measure {
        public DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public boolean useCurrentDimensions;
        public DimensionBehaviour verticalBehavior;
        public int verticalDimension;

        public Measure() {
            super();
        }
    }

    public enum MeasureType {
        static {
            MeasureType.$VALUES = new MeasureType[0];
        }

        private MeasureType(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static MeasureType valueOf(String arg1) {
            return Enum.valueOf(MeasureType.class, arg1);
        }

        public static MeasureType[] values() {
            return MeasureType.$VALUES.clone();
        }
    }

    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget arg1, Measure arg2);
    }

    public static final int AT_MOST = 0x80000000;
    private static final boolean DEBUG = false;
    public static final int EXACTLY = 0x40000000;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    private static final int MODE_SHIFT = 30;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;
    private ConstraintWidgetContainer constraintWidgetContainer;
    private Measure mMeasure;
    private final ArrayList mVariableDimensionsWidgets;

    public BasicMeasure(ConstraintWidgetContainer arg2) {
        super();
        this.mVariableDimensionsWidgets = new ArrayList();
        this.mMeasure = new Measure();
        this.constraintWidgetContainer = arg2;
    }

    private boolean measure(Measurer arg6, ConstraintWidget arg7, boolean arg8) {
        this.mMeasure.horizontalBehavior = arg7.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = arg7.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = arg7.getWidth();
        this.mMeasure.verticalDimension = arg7.getHeight();
        this.mMeasure.measuredNeedsSolverPass = false;
        this.mMeasure.useCurrentDimensions = arg8;
        int v8 = this.mMeasure.horizontalBehavior == DimensionBehaviour.MATCH_CONSTRAINT ? 1 : 0;
        int v0 = this.mMeasure.verticalBehavior == DimensionBehaviour.MATCH_CONSTRAINT ? 1 : 0;
        v8 = v8 == 0 || arg7.mDimensionRatio <= 0f ? 0 : 1;
        v0 = v0 == 0 || arg7.mDimensionRatio <= 0f ? 0 : 1;
        int v3 = 4;
        if(v8 != 0 && arg7.mResolvedMatchConstraintDefault[0] == v3) {
            this.mMeasure.horizontalBehavior = DimensionBehaviour.FIXED;
        }

        if(v0 != 0 && arg7.mResolvedMatchConstraintDefault[1] == v3) {
            this.mMeasure.verticalBehavior = DimensionBehaviour.FIXED;
        }

        arg6.measure(arg7, this.mMeasure);
        arg7.setWidth(this.mMeasure.measuredWidth);
        arg7.setHeight(this.mMeasure.measuredHeight);
        arg7.setHasBaseline(this.mMeasure.measuredHasBaseline);
        arg7.setBaselineDistance(this.mMeasure.measuredBaseline);
        this.mMeasure.useCurrentDimensions = false;
        return this.mMeasure.measuredNeedsSolverPass;
    }

    private void measureChildren(ConstraintWidgetContainer arg10) {
        int v0 = arg10.mChildren.size();
        Measurer v1 = arg10.getMeasurer();
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            Object v4 = arg10.mChildren.get(v3);
            if((v4 instanceof Guideline)) {
            }
            else {
                if((((ConstraintWidget)v4).horizontalRun.dimension.resolved) && (((ConstraintWidget)v4).verticalRun.dimension.resolved)) {
                    goto label_40;
                }

                DimensionBehaviour v5 = ((ConstraintWidget)v4).getDimensionBehaviour(0);
                DimensionBehaviour v7 = ((ConstraintWidget)v4).getDimensionBehaviour(1);
                if(v5 == DimensionBehaviour.MATCH_CONSTRAINT && ((ConstraintWidget)v4).mMatchConstraintDefaultWidth != 1 && v7 == DimensionBehaviour.MATCH_CONSTRAINT && ((ConstraintWidget)v4).mMatchConstraintDefaultHeight != 1) {
                    goto label_40;
                }

                this.measure(v1, ((ConstraintWidget)v4), false);
                if(arg10.mMetrics == null) {
                    goto label_40;
                }

                ++arg10.mMetrics.measuredWidgets;
            }

        label_40:
        }

        v1.didMeasures();
    }

    private void solveLinearSystem(ConstraintWidgetContainer arg3, String arg4, int arg5, int arg6) {
        int v4 = arg3.getMinWidth();
        int v0 = arg3.getMinHeight();
        arg3.setMinWidth(0);
        arg3.setMinHeight(0);
        arg3.setWidth(arg5);
        arg3.setHeight(arg6);
        arg3.setMinWidth(v4);
        arg3.setMinHeight(v0);
        this.constraintWidgetContainer.layout();
    }

    public long solverMeasure(ConstraintWidgetContainer arg21, int arg22, int arg23, int arg24, int arg25, int arg26, int arg27, int arg28, int arg29, int arg30) {
        Measurer v18;
        int v10;
        int v17;
        long v24;
        int v9_1;
        boolean v2_1;
        boolean v11_2;
        long v29;
        int v11;
        int v14;
        int v12;
        BasicMeasure v0 = this;
        ConstraintWidgetContainer v1 = arg21;
        int v2 = arg22;
        int v3 = arg25;
        int v4 = arg27;
        Measurer v5 = v1.getMeasurer();
        int v6 = v1.mChildren.size();
        int v7 = v1.getWidth();
        int v8 = v1.getHeight();
        boolean v9 = Optimizer.enabled(v2, 0x80);
        v2 = (v9) || (Optimizer.enabled(v2, 0x40)) ? 1 : 0;
        if(v2 != 0) {
            v12 = 0;
            while(true) {
                if(v12 < v6) {
                    Object v13 = v1.mChildren.get(v12);
                    v14 = ((ConstraintWidget)v13).getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT ? 1 : 0;
                    v11 = ((ConstraintWidget)v13).getVerticalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT ? 1 : 0;
                    v11 = v14 == 0 || v11 == 0 || ((ConstraintWidget)v13).getDimensionRatio() <= 0f ? 0 : 1;
                    if(!((ConstraintWidget)v13).isInHorizontalChain() || v11 == 0) {
                        if((((ConstraintWidget)v13).isInVerticalChain()) && v11 != 0) {
                            break;
                        }

                        if((v13 instanceof VirtualLayout)) {
                            break;
                        }

                        if(((ConstraintWidget)v13).isInHorizontalChain()) {
                            break;
                        }

                        if(((ConstraintWidget)v13).isInVerticalChain()) {
                            break;
                        }

                        ++v12;
                        continue;
                    }

                    break;
                }

                goto label_65;
            }

            v2 = 0;
        }

    label_65:
        long v11_1 = 1;
        if(v2 != 0 && LinearSystem.sMetrics != null) {
            LinearSystem.sMetrics.measures += v11_1;
        }

        int v13_1 = 0x40000000;
        v14 = v3 == v13_1 && v4 == v13_1 || (v9) ? 1 : 0;
        v2 &= v14;
        v14 = 2;
        if(v2 != 0) {
            v2 = Math.min(v1.getMaxWidth(), arg26);
            v29 = v11_1;
            v11 = Math.min(v1.getMaxHeight(), arg28);
            if(v3 == v13_1 && v1.getWidth() != v2) {
                v1.setWidth(v2);
                v1.invalidateGraph();
            }

            if(v4 == v13_1 && v1.getHeight() != v11) {
                v1.setHeight(v11);
                v1.invalidateGraph();
            }

            if(v3 != v13_1 || v4 != v13_1) {
                v2_1 = v1.directMeasureSetup(v9);
                if(v3 == v13_1) {
                    v11 = (((int)v2_1)) & v1.directMeasureWithOrientation(v9, 0);
                    v2 = 1;
                }
                else {
                    v11_2 = v2_1;
                    v2 = 0;
                }

                if(v4 == v13_1) {
                    int v19 = v1.directMeasureWithOrientation(v9, 1) & (((int)v11_2));
                    v9_1 = v2 + 1;
                    v2 = v19;
                    goto label_125;
                }

                v9_1 = v2;
                v2 = ((int)v11_2);
            }
            else {
                v2_1 = v1.directMeasure(v9);
                v9_1 = v14;
            }

        label_125:
            if(!v2_1) {
                goto label_139;
            }

            boolean v3_1 = v3 == v13_1 ? true : false;
            boolean v4_1 = v4 == v13_1 ? true : false;
            v1.updateFromRuns(v3_1, v4_1);
        }
        else {
            v29 = v11_1;
            v2_1 = false;
            v9_1 = 0;
        }

    label_139:
        long v3_2 = 0;
        if(v2_1) {
            if(v9_1 != v14) {
            }
            else {
                return v3_2;
            }
        }

        if(v6 > 0) {
            this.measureChildren(arg21);
        }

        v2 = v1.getOptimizationLevel();
        v9_1 = v0.mVariableDimensionsWidgets.size();
        if(v6 > 0) {
            v0.solveLinearSystem(v1, "First pass", v7, v8);
        }

        if(v9_1 > 0) {
            v12 = v1.getHorizontalDimensionBehaviour() == DimensionBehaviour.WRAP_CONTENT ? 1 : 0;
            v6 = v1.getVerticalDimensionBehaviour() == DimensionBehaviour.WRAP_CONTENT ? 1 : 0;
            v11 = Math.max(v1.getWidth(), v0.constraintWidgetContainer.getMinWidth());
            v13_1 = Math.max(v1.getHeight(), v0.constraintWidgetContainer.getMinHeight());
            int v15 = 0;
            int v16 = 0;
            while(v15 < v9_1) {
                v24 = v3_2;
                Object v3_3 = v0.mVariableDimensionsWidgets.get(v15);
                if(!(v3_3 instanceof VirtualLayout)) {
                    arg26 = v6;
                    v17 = v15;
                }
                else {
                    v4 = ((ConstraintWidget)v3_3).getWidth();
                    v10 = ((ConstraintWidget)v3_3).getHeight();
                    v14 = v16 | v0.measure(v5, ((ConstraintWidget)v3_3), true);
                    arg26 = v6;
                    if(v1.mMetrics != null) {
                        arg27 = v14;
                        v17 = v15;
                        v1.mMetrics.measuredMatchWidgets += v29;
                    }
                    else {
                        arg27 = v14;
                        v17 = v15;
                    }

                    v6 = ((ConstraintWidget)v3_3).getWidth();
                    v14 = ((ConstraintWidget)v3_3).getHeight();
                    if(v6 != v4) {
                        ((ConstraintWidget)v3_3).setWidth(v6);
                        if(v12 != 0 && ((ConstraintWidget)v3_3).getRight() > v11) {
                            v11 = Math.max(v11, ((ConstraintWidget)v3_3).getRight() + ((ConstraintWidget)v3_3).getAnchor(Type.RIGHT).getMargin());
                        }

                        v4 = 1;
                    }
                    else {
                        v4 = arg27;
                    }

                    if(v14 != v10) {
                        ((ConstraintWidget)v3_3).setHeight(v14);
                        if(arg26 != 0 && ((ConstraintWidget)v3_3).getBottom() > v13_1) {
                            v13_1 = Math.max(v13_1, ((ConstraintWidget)v3_3).getBottom() + ((ConstraintWidget)v3_3).getAnchor(Type.BOTTOM).getMargin());
                        }

                        v4 = 1;
                    }

                    v16 = v4 | ((VirtualLayout)v3_3).needSolverPass();
                }

                v15 = v17 + 1;
                v3_2 = v24;
                v6 = arg26;
                v14 = 2;
            }

            v24 = v3_2;
            arg26 = v6;
            v4 = v14;
            v3 = 0;
            while(v3 < v4) {
                v6 = 0;
                while(v6 < v9_1) {
                    Object v10_1 = v0.mVariableDimensionsWidgets.get(v6);
                    if(((v10_1 instanceof Helper)) && !(v10_1 instanceof VirtualLayout)) {
                        goto label_270;
                    }
                    else if((v10_1 instanceof Guideline)) {
                        goto label_270;
                    }
                    else if(((ConstraintWidget)v10_1).getVisibility() == 8) {
                        goto label_270;
                    }
                    else {
                        if((((ConstraintWidget)v10_1).horizontalRun.dimension.resolved) && (((ConstraintWidget)v10_1).verticalRun.dimension.resolved)) {
                            goto label_270;
                        }

                        if((v10_1 instanceof VirtualLayout)) {
                        label_270:
                            v17 = v3;
                            v18 = v5;
                            arg27 = v6;
                            goto label_324;
                        }

                        v14 = ((ConstraintWidget)v10_1).getWidth();
                        v15 = ((ConstraintWidget)v10_1).getHeight();
                        v4 = ((ConstraintWidget)v10_1).getBaselineDistance();
                        v17 = v3;
                        v16 |= v0.measure(v5, ((ConstraintWidget)v10_1), true);
                        if(v1.mMetrics != null) {
                            v18 = v5;
                            arg27 = v6;
                            v1.mMetrics.measuredMatchWidgets += v29;
                        }
                        else {
                            v18 = v5;
                            arg27 = v6;
                        }

                        v3 = ((ConstraintWidget)v10_1).getWidth();
                        int v5_1 = ((ConstraintWidget)v10_1).getHeight();
                        if(v3 != v14) {
                            ((ConstraintWidget)v10_1).setWidth(v3);
                            if(v12 != 0 && ((ConstraintWidget)v10_1).getRight() > v11) {
                                v11 = Math.max(v11, ((ConstraintWidget)v10_1).getRight() + ((ConstraintWidget)v10_1).getAnchor(Type.RIGHT).getMargin());
                            }

                            v16 = 1;
                        }

                        if(v5_1 != v15) {
                            ((ConstraintWidget)v10_1).setHeight(v5_1);
                            if(arg26 != 0 && ((ConstraintWidget)v10_1).getBottom() > v13_1) {
                                v13_1 = Math.max(v13_1, ((ConstraintWidget)v10_1).getBottom() + ((ConstraintWidget)v10_1).getAnchor(Type.BOTTOM).getMargin());
                            }

                            v16 = 1;
                        }

                        if(!((ConstraintWidget)v10_1).hasBaseline()) {
                            goto label_324;
                        }

                        if(v4 == ((ConstraintWidget)v10_1).getBaselineDistance()) {
                            goto label_324;
                        }

                        v16 = 1;
                    }

                label_324:
                    v6 = arg27 + 1;
                    v3 = v17;
                    v5 = v18;
                }

                v17 = v3;
                v18 = v5;
                if(v16 != 0) {
                    v0.solveLinearSystem(v1, "intermediate pass", v7, v8);
                    v16 = 0;
                }

                v3 = v17 + 1;
                v5 = v18;
                v4 = 2;
            }

            if(v16 == 0) {
                goto label_359;
            }

            v0.solveLinearSystem(v1, "2nd pass", v7, v8);
            if(v1.getWidth() < v11) {
                v1.setWidth(v11);
                v10 = 1;
            }
            else {
                v10 = 0;
            }

            if(v1.getHeight() < v13_1) {
                v1.setHeight(v13_1);
                v11 = 1;
            }
            else {
                v11 = v10;
            }

            if(v11 == 0) {
                goto label_359;
            }

            v0.solveLinearSystem(v1, "3rd pass", v7, v8);
        }
        else {
            v24 = v3_2;
        }

    label_359:
        v1.setOptimizationLevel(v2);
        return v24;
    }

    public void updateHierarchy(ConstraintWidgetContainer arg6) {
        this.mVariableDimensionsWidgets.clear();
        int v0 = arg6.mChildren.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = arg6.mChildren.get(v1);
            if(((ConstraintWidget)v2).getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT || ((ConstraintWidget)v2).getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_PARENT || ((ConstraintWidget)v2).getVerticalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT || ((ConstraintWidget)v2).getVerticalDimensionBehaviour() == DimensionBehaviour.MATCH_PARENT) {
                this.mVariableDimensionsWidgets.add(v2);
            }
        }

        arg6.invalidateGraph();
    }
}

