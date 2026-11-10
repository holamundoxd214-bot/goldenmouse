package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;

public class Optimizer {
    static final int FLAG_CHAIN_DANGLING = 1;
    static final int FLAG_RECOMPUTE_BOUNDS = 2;
    static final int FLAG_USE_OPTIMIZE = 0;
    public static final int OPTIMIZATION_BARRIER = 2;
    public static final int OPTIMIZATION_CHAIN = 4;
    public static final int OPTIMIZATION_DIMENSIONS = 8;
    public static final int OPTIMIZATION_DIRECT = 1;
    public static final int OPTIMIZATION_ENGINE = 0x100;
    public static final int OPTIMIZATION_GRAPH = 0x40;
    public static final int OPTIMIZATION_GRAPH_WRAP = 0x80;
    public static final int OPTIMIZATION_GROUPS = 0x20;
    public static final int OPTIMIZATION_NONE = 0;
    public static final int OPTIMIZATION_RATIO = 16;
    public static final int OPTIMIZATION_STANDARD = 0x107;
    static boolean[] flags;

    static {
        Optimizer.flags = new boolean[3];
    }

    public Optimizer() {
        super();
    }

    static void checkMatchParent(ConstraintWidgetContainer arg5, LinearSystem arg6, ConstraintWidget arg7) {
        int v0;
        arg7.mHorizontalResolution = -1;
        arg7.mVerticalResolution = -1;
        int v3 = 2;
        if(arg5.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT && arg7.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_PARENT) {
            v0 = arg7.mLeft.mMargin;
            int v1 = arg5.getWidth() - arg7.mRight.mMargin;
            arg7.mLeft.mSolverVariable = arg6.createObjectVariable(arg7.mLeft);
            arg7.mRight.mSolverVariable = arg6.createObjectVariable(arg7.mRight);
            arg6.addEquality(arg7.mLeft.mSolverVariable, v0);
            arg6.addEquality(arg7.mRight.mSolverVariable, v1);
            arg7.mHorizontalResolution = v3;
            arg7.setHorizontalDimension(v0, v1);
        }

        if(arg5.mListDimensionBehaviors[1] != DimensionBehaviour.WRAP_CONTENT && arg7.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_PARENT) {
            v0 = arg7.mTop.mMargin;
            int v5 = arg5.getHeight() - arg7.mBottom.mMargin;
            arg7.mTop.mSolverVariable = arg6.createObjectVariable(arg7.mTop);
            arg7.mBottom.mSolverVariable = arg6.createObjectVariable(arg7.mBottom);
            arg6.addEquality(arg7.mTop.mSolverVariable, v0);
            arg6.addEquality(arg7.mBottom.mSolverVariable, v5);
            if(arg7.mBaselineDistance > 0 || arg7.getVisibility() == 8) {
                arg7.mBaseline.mSolverVariable = arg6.createObjectVariable(arg7.mBaseline);
                arg6.addEquality(arg7.mBaseline.mSolverVariable, arg7.mBaselineDistance + v0);
            }

            arg7.mVerticalResolution = v3;
            arg7.setVerticalDimension(v0, v5);
        }
    }

    public static final boolean enabled(int arg0, int arg1) {
        if((arg0 & arg1) == arg1) {
            return 1;
        }

        return 0;
    }
}

