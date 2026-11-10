package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measurer;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyGraph;
import java.util.ArrayList;
import java.util.Arrays;

public class ConstraintWidgetContainer extends WidgetContainer {
    private static final boolean DEBUG = false;
    static final boolean DEBUG_GRAPH = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final int MAX_ITERATIONS = 8;
    BasicMeasure mBasicMeasureSolver;
    int mDebugSolverPassCount;
    public DependencyGraph mDependencyGraph;
    public boolean mGroupsWrapOptimized;
    private boolean mHeightMeasuredTooSmall;
    ChainHead[] mHorizontalChainsArray;
    int mHorizontalChainsSize;
    public boolean mHorizontalWrapOptimized;
    private boolean mIsRtl;
    protected Measurer mMeasurer;
    public Metrics mMetrics;
    private int mOptimizationLevel;
    int mPaddingBottom;
    int mPaddingLeft;
    int mPaddingRight;
    int mPaddingTop;
    public boolean mSkipSolver;
    protected LinearSystem mSystem;
    ChainHead[] mVerticalChainsArray;
    int mVerticalChainsSize;
    public boolean mVerticalWrapOptimized;
    private boolean mWidthMeasuredTooSmall;
    public int mWrapFixedHeight;
    public int mWrapFixedWidth;

    public ConstraintWidgetContainer() {
        super();
        this.mBasicMeasureSolver = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 0x107;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
    }

    public ConstraintWidgetContainer(int arg2, int arg3) {
        super(arg2, arg3);
        this.mBasicMeasureSolver = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 0x107;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
    }

    public ConstraintWidgetContainer(int arg1, int arg2, int arg3, int arg4) {
        super(arg1, arg2, arg3, arg4);
        this.mBasicMeasureSolver = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 0x107;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
    }

    void addChain(ConstraintWidget arg2, int arg3) {
        if(arg3 == 0) {
            this.addHorizontalChain(arg2);
            return;
        }

        if(arg3 == 1) {
            this.addVerticalChain(arg2);
        }
    }

    public boolean addChildrenToSolver(LinearSystem arg9) {
        Object v3_1;
        this.addToSolver(arg9);
        int v0 = this.mChildren.size();
        int v2 = 0;
        int v3 = 0;
        while(v2 < v0) {
            Object v5 = this.mChildren.get(v2);
            ((ConstraintWidget)v5).setInBarrier(0, false);
            ((ConstraintWidget)v5).setInBarrier(1, false);
            if((v5 instanceof Barrier)) {
                v3 = 1;
            }

            ++v2;
        }

        if(v3 != 0) {
            for(v2 = 0; v2 < v0; ++v2) {
                v3_1 = this.mChildren.get(v2);
                if((v3_1 instanceof Barrier)) {
                    ((Barrier)v3_1).markWidgets();
                }
            }
        }

        for(v2 = 0; v2 < v0; ++v2) {
            v3_1 = this.mChildren.get(v2);
            if(((ConstraintWidget)v3_1).addFirst()) {
                ((ConstraintWidget)v3_1).addToSolver(arg9);
            }
        }

        for(v2 = 0; v2 < v0; ++v2) {
            v3_1 = this.mChildren.get(v2);
            if((v3_1 instanceof ConstraintWidgetContainer)) {
                DimensionBehaviour v5_1 = ((ConstraintWidget)v3_1).mListDimensionBehaviors[0];
                DimensionBehaviour v6 = ((ConstraintWidget)v3_1).mListDimensionBehaviors[1];
                if(v5_1 == DimensionBehaviour.WRAP_CONTENT) {
                    ((ConstraintWidget)v3_1).setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
                }

                if(v6 == DimensionBehaviour.WRAP_CONTENT) {
                    ((ConstraintWidget)v3_1).setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
                }

                ((ConstraintWidget)v3_1).addToSolver(arg9);
                if(v5_1 == DimensionBehaviour.WRAP_CONTENT) {
                    ((ConstraintWidget)v3_1).setHorizontalDimensionBehaviour(v5_1);
                }

                if(v6 != DimensionBehaviour.WRAP_CONTENT) {
                    goto label_66;
                }

                ((ConstraintWidget)v3_1).setVerticalDimensionBehaviour(v6);
            }
            else {
                Optimizer.checkMatchParent(this, arg9, ((ConstraintWidget)v3_1));
                if(((ConstraintWidget)v3_1).addFirst()) {
                    goto label_66;
                }

                ((ConstraintWidget)v3_1).addToSolver(arg9);
            }

        label_66:
        }

        if(this.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(this, arg9, 0);
        }

        if(this.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(this, arg9, 1);
        }

        return 1;
    }

    private void addHorizontalChain(ConstraintWidget arg6) {
        Object[] v1_1;
        int v0 = this.mHorizontalChainsSize + 1;
        ChainHead[] v1 = this.mHorizontalChainsArray;
        if(v0 >= v1.length) {
            v1_1 = Arrays.copyOf(((Object[])v1), v1.length * 2);
            this.mHorizontalChainsArray = ((ChainHead[])v1_1);
        }

        ((ChainHead[])v1_1)[this.mHorizontalChainsSize] = new ChainHead(arg6, 0, this.isRtl());
        ++this.mHorizontalChainsSize;
    }

    private void addVerticalChain(ConstraintWidget arg6) {
        Object[] v2_1;
        int v0 = this.mVerticalChainsSize + 1;
        ChainHead[] v2 = this.mVerticalChainsArray;
        if(v0 >= v2.length) {
            v2_1 = Arrays.copyOf(((Object[])v2), v2.length * 2);
            this.mVerticalChainsArray = ((ChainHead[])v2_1);
        }

        ((ChainHead[])v2_1)[this.mVerticalChainsSize] = new ChainHead(arg6, 1, this.isRtl());
        ++this.mVerticalChainsSize;
    }

    public void defineTerminalWidgets() {
        this.mDependencyGraph.defineTerminalWidgets(this.getHorizontalDimensionBehaviour(), this.getVerticalDimensionBehaviour());
    }

    public boolean directMeasure(boolean arg1) {
        return this.mDependencyGraph.directMeasure(arg1);
    }

    public boolean directMeasureSetup(boolean arg1) {
        return this.mDependencyGraph.directMeasureSetup(arg1);
    }

    public boolean directMeasureWithOrientation(boolean arg1, int arg2) {
        return this.mDependencyGraph.directMeasureWithOrientation(arg1, arg2);
    }

    public void fillMetrics(Metrics arg1) {
        this.mMetrics = arg1;
        this.mSystem.fillMetrics(arg1);
    }

    public ArrayList getHorizontalGuidelines() {
        ArrayList v0 = new ArrayList();
        int v1 = this.mChildren.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            Object v3 = this.mChildren.get(v2);
            if(((v3 instanceof Guideline)) && ((Guideline)v3).getOrientation() == 0) {
                v0.add(v3);
            }
        }

        return v0;
    }

    public Measurer getMeasurer() {
        return this.mMeasurer;
    }

    public int getOptimizationLevel() {
        return this.mOptimizationLevel;
    }

    public LinearSystem getSystem() {
        return this.mSystem;
    }

    public String getType() {
        return "ConstraintLayout";
    }

    public ArrayList getVerticalGuidelines() {
        ArrayList v0 = new ArrayList();
        int v1 = this.mChildren.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            Object v3 = this.mChildren.get(v2);
            if(((v3 instanceof Guideline)) && ((Guideline)v3).getOrientation() == 1) {
                v0.add(v3);
            }
        }

        return v0;
    }

    public boolean handlesInternalConstraints() {
        return 0;
    }

    public void invalidateGraph() {
        this.mDependencyGraph.invalidateGraph();
    }

    public void invalidateMeasures() {
        this.mDependencyGraph.invalidateMeasures();
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.mHeightMeasuredTooSmall;
    }

    public boolean isRtl() {
        return this.mIsRtl;
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.mWidthMeasuredTooSmall;
    }

    public void layout() {
        boolean v0_3;
        int v16;
        ConstraintWidgetContainer v1 = this;
        int v2 = 0;
        v1.mX = 0;
        v1.mY = 0;
        int v3 = Math.max(0, v1.getWidth());
        int v4 = Math.max(0, v1.getHeight());
        v1.mWidthMeasuredTooSmall = false;
        v1.mHeightMeasuredTooSmall = false;
        int v0 = (v1.optimizeFor(0x40)) || (v1.optimizeFor(0x80)) ? 1 : 0;
        v1.mSystem.graphOptimizer = false;
        v1.mSystem.newgraphOptimizer = false;
        if(v1.mOptimizationLevel != 0 && v0 != 0) {
            v1.mSystem.newgraphOptimizer = true;
        }

        DimensionBehaviour v6 = v1.mListDimensionBehaviors[1];
        DimensionBehaviour v7 = v1.mListDimensionBehaviors[0];
        ArrayList v8 = v1.mChildren;
        int v9 = v1.getHorizontalDimensionBehaviour() == DimensionBehaviour.WRAP_CONTENT || v1.getVerticalDimensionBehaviour() == DimensionBehaviour.WRAP_CONTENT ? 1 : 0;
        v1.resetChains();
        int v10 = v1.mChildren.size();
        for(v0 = 0; v0 < v10; ++v0) {
            Object v11 = v1.mChildren.get(v0);
            if((v11 instanceof WidgetContainer)) {
                ((WidgetContainer)v11).layout();
            }
        }

        v0 = 0;
        int v12 = 0;
        boolean v11_1 = true;
        while(v11_1) {
            int v13 = v0 + 1;
            try {
                v1.mSystem.reset();
                v1.resetChains();
                v1.createObjectVariables(v1.mSystem);
                for(v0 = v2; v0 < v10; ++v0) {
                    v1.mChildren.get(v0).createObjectVariables(v1.mSystem);
                }

                v11_1 = v1.addChildrenToSolver(v1.mSystem);
                if(v11_1) {
                    v1.mSystem.minimize();
                }
            }
            catch(Exception v0_1) {
                goto label_83;
            }

            v16 = v2;
            goto label_92;
        label_83:
            v0_1.printStackTrace();
            v16 = v2;
            System.out.println("EXCEPTION : " + v0_1);
        label_92:
            LinearSystem v0_2 = v1.mSystem;
            if(v11_1) {
                v1.updateChildrenFromSolver(v0_2, Optimizer.flags);
            }
            else {
                v1.updateFromSolver(v0_2);
                for(v0 = v16; v0 < v10; ++v0) {
                    v1.mChildren.get(v0).updateFromSolver(v1.mSystem);
                }
            }

            if(v9 == 0 || v13 >= 8 || !Optimizer.flags[2]) {
                v0_3 = ((boolean)v16);
            }
            else {
                v0 = v16;
                v2 = v0;
                int v11_2 = v2;
                while(v0 < v10) {
                    Object v14 = v1.mChildren.get(v0);
                    v2 = Math.max(v2, ((ConstraintWidget)v14).mX + ((ConstraintWidget)v14).getWidth());
                    v11_2 = Math.max(v11_2, ((ConstraintWidget)v14).mY + ((ConstraintWidget)v14).getHeight());
                    ++v0;
                }

                v0 = Math.max(v1.mMinWidth, v2);
                v2 = Math.max(v1.mMinHeight, v11_2);
                if(v7 != DimensionBehaviour.WRAP_CONTENT || v1.getWidth() >= v0) {
                    v0_3 = ((boolean)v16);
                }
                else {
                    v1.setWidth(v0);
                    v1.mListDimensionBehaviors[v16] = DimensionBehaviour.WRAP_CONTENT;
                    v0_3 = true;
                    v12 = 1;
                }

                if(v6 != DimensionBehaviour.WRAP_CONTENT) {
                    goto label_157;
                }

                if(v1.getHeight() >= v2) {
                    goto label_157;
                }

                v1.setHeight(v2);
                v1.mListDimensionBehaviors[1] = DimensionBehaviour.WRAP_CONTENT;
                v0_3 = true;
                v12 = 1;
            }

        label_157:
            v2 = Math.max(v1.mMinWidth, v1.getWidth());
            if(v2 > v1.getWidth()) {
                v1.setWidth(v2);
                v1.mListDimensionBehaviors[v16] = DimensionBehaviour.FIXED;
                v0_3 = true;
                v12 = 1;
            }

            v2 = Math.max(v1.mMinHeight, v1.getHeight());
            if(v2 > v1.getHeight()) {
                v1.setHeight(v2);
                v1.mListDimensionBehaviors[1] = DimensionBehaviour.FIXED;
                v0_3 = true;
                v12 = 1;
            }

            if(v12 == 0) {
                if(v1.mListDimensionBehaviors[v16] == DimensionBehaviour.WRAP_CONTENT && v3 > 0 && v1.getWidth() > v3) {
                    v1.mWidthMeasuredTooSmall = true;
                    v1.mListDimensionBehaviors[v16] = DimensionBehaviour.FIXED;
                    v1.setWidth(v3);
                    v0_3 = true;
                    v12 = 1;
                }

                if(v1.mListDimensionBehaviors[1] != DimensionBehaviour.WRAP_CONTENT) {
                    goto label_209;
                }

                if(v4 <= 0) {
                    goto label_209;
                }

                if(v1.getHeight() <= v4) {
                    goto label_209;
                }

                v1.mHeightMeasuredTooSmall = true;
                v1.mListDimensionBehaviors[1] = DimensionBehaviour.FIXED;
                v1.setHeight(v4);
                v11_1 = true;
                v12 = 1;
            }
            else {
            label_209:
                v11_1 = v0_3;
            }

            v0 = v13;
            v2 = v16;
        }

        v16 = v2;
        v1.mChildren = v8;
        if(v12 != 0) {
            v1.mListDimensionBehaviors[v16] = v7;
            v1.mListDimensionBehaviors[1] = v6;
        }

        v1.resetSolverVariables(v1.mSystem.getCache());
    }

    public long measure(int arg12, int arg13, int arg14, int arg15, int arg16, int arg17, int arg18, int arg19, int arg20) {
        this.mPaddingLeft = arg19;
        this.mPaddingTop = arg20;
        return this.mBasicMeasureSolver.solverMeasure(this, arg12, arg19, arg20, arg13, arg14, arg15, arg16, arg17, arg18);
    }

    public boolean optimizeFor(int arg1) {
        if((this.mOptimizationLevel & arg1) == arg1) {
            return 1;
        }

        return 0;
    }

    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mSkipSolver = false;
        super.reset();
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    public void setMeasurer(Measurer arg1) {
        this.mMeasurer = arg1;
        this.mDependencyGraph.setMeasurer(arg1);
    }

    public void setOptimizationLevel(int arg1) {
        this.mOptimizationLevel = arg1;
        LinearSystem.OPTIMIZED_ENGINE = Optimizer.enabled(arg1, 0x100);
    }

    public void setPadding(int arg1, int arg2, int arg3, int arg4) {
        this.mPaddingLeft = arg1;
        this.mPaddingTop = arg2;
        this.mPaddingRight = arg3;
        this.mPaddingBottom = arg4;
    }

    public void setRtl(boolean arg1) {
        this.mIsRtl = arg1;
    }

    public void updateChildrenFromSolver(LinearSystem arg3, boolean[] arg4) {
        int v1 = 0;
        arg4[2] = false;
        this.updateFromSolver(arg3);
        int v4 = this.mChildren.size();
        while(v1 < v4) {
            this.mChildren.get(v1).updateFromSolver(arg3);
            ++v1;
        }
    }

    public void updateFromRuns(boolean arg4, boolean arg5) {
        super.updateFromRuns(arg4, arg5);
        int v0 = this.mChildren.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.mChildren.get(v1).updateFromRuns(arg4, arg5);
        }
    }

    public void updateHierarchy() {
        this.mBasicMeasureSolver.updateHierarchy(this);
    }
}

