package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;

public class LinearSystem {
    interface Row {
        void addError(SolverVariable arg1);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem arg1, boolean[] arg2);

        void initFromRow(Row arg1);

        boolean isEmpty();

        void updateFromFinalVariable(LinearSystem arg1, SolverVariable arg2, boolean arg3);

        void updateFromRow(ArrayRow arg1, boolean arg2);

        void updateFromSystem(LinearSystem arg1);
    }

    class ValuesRow extends ArrayRow {
        public ValuesRow(LinearSystem arg1, Cache arg2) {
            LinearSystem.this = arg1;
            super();
            this.variables = new SolverVariableValues(((ArrayRow)this), arg2);
        }
    }

    public static long ARRAY_ROW_CREATION = 0;
    public static final boolean DEBUG = false;
    private static final boolean DEBUG_CONSTRAINTS = false;
    public static final boolean FULL_DEBUG = false;
    public static final boolean MEASURE = false;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0;
    public static boolean OPTIMIZED_ENGINE = true;
    private static int POOL_SIZE = 1000;
    static final boolean SIMPLIFY_SYNONYMS = false;
    private int TABLE_SIZE;
    private static final boolean USE_SYNONYMS = true;
    public boolean graphOptimizer;
    private boolean[] mAlreadyTestedCandidates;
    final Cache mCache;
    private Row mGoal;
    private int mMaxColumns;
    private int mMaxRows;
    int mNumColumns;
    int mNumRows;
    private SolverVariable[] mPoolVariables;
    private int mPoolVariablesCount;
    ArrayRow[] mRows;
    private Row mTempGoal;
    private HashMap mVariables;
    int mVariablesID;
    public boolean newgraphOptimizer;
    public static Metrics sMetrics;

    static {
    }

    public LinearSystem() {
        super();
        this.mVariablesID = 0;
        this.mVariables = null;
        this.TABLE_SIZE = 0x20;
        this.mMaxColumns = 0x20;
        this.mRows = null;
        this.graphOptimizer = false;
        this.newgraphOptimizer = false;
        this.mAlreadyTestedCandidates = new boolean[0x20];
        this.mNumColumns = 1;
        this.mNumRows = 0;
        this.mMaxRows = 0x20;
        this.mPoolVariables = new SolverVariable[LinearSystem.POOL_SIZE];
        this.mPoolVariablesCount = 0;
        this.mRows = new ArrayRow[0x20];
        this.releaseRows();
        Cache v0 = new Cache();
        this.mCache = v0;
        this.mGoal = new PriorityGoalRow(v0);
        if(LinearSystem.OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(this, v0);
            return;
        }

        this.mTempGoal = new ArrayRow(v0);
    }

    private SolverVariable acquireSolverVariable(Type arg3, String arg4) {
        Object v0 = this.mCache.solverVariablePool.acquire();
        if(v0 == null) {
            SolverVariable v0_1 = new SolverVariable(arg3, arg4);
            v0_1.setType(arg3, arg4);
        }
        else {
            ((SolverVariable)v0).reset();
            ((SolverVariable)v0).setType(arg3, arg4);
        }

        int v3 = this.mPoolVariablesCount;
        int v4 = LinearSystem.POOL_SIZE;
        if(v3 >= v4) {
            v4 *= 2;
            LinearSystem.POOL_SIZE = v4;
            this.mPoolVariables = Arrays.copyOf(this.mPoolVariables, v4);
        }

        SolverVariable[] v3_1 = this.mPoolVariables;
        v4 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = v4 + 1;
        v3_1[v4] = v0;
        return ((SolverVariable)v0);
    }

    public void addCenterPoint(ConstraintWidget arg17, ConstraintWidget arg18, float arg19, int arg20) {
        SolverVariable v5 = this.createObjectVariable(arg17.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type.LEFT));
        SolverVariable v7 = this.createObjectVariable(arg17.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type.TOP));
        SolverVariable v3 = this.createObjectVariable(arg17.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type.RIGHT));
        SolverVariable v8 = this.createObjectVariable(arg17.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type.BOTTOM));
        SolverVariable v1 = this.createObjectVariable(arg18.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type.LEFT));
        SolverVariable v9 = this.createObjectVariable(arg18.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type.TOP));
        SolverVariable v4 = this.createObjectVariable(arg18.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type.RIGHT));
        SolverVariable v10 = this.createObjectVariable(arg18.getAnchor(androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type.BOTTOM));
        ArrayRow v6 = this.createRow();
        double v12 = ((double)arg19);
        SolverVariable v17 = v1;
        double v1_1 = ((double)arg20);
        v6.createRowWithAngle(v7, v8, v9, v10, ((float)(Math.sin(v12) * v1_1)));
        this.addConstraint(v6);
        v8 = v4;
        ArrayRow v4_1 = this.createRow();
        v4_1.createRowWithAngle(v5, v3, v17, v8, ((float)(Math.cos(v12) * v1_1)));
        this.addConstraint(v4_1);
    }

    public void addCentering(SolverVariable arg10, SolverVariable arg11, int arg12, float arg13, SolverVariable arg14, SolverVariable arg15, int arg16, int arg17) {
        int v0 = arg17;
        ArrayRow v1 = this.createRow();
        v1.createRowCentering(arg10, arg11, arg12, arg13, arg14, arg15, arg16);
        if(v0 != 8) {
            v1.addError(this, v0);
        }

        this.addConstraint(v1);
    }

    public void addConstraint(ArrayRow arg8) {
        if(arg8 == null) {
        }
        else {
            Metrics v0 = LinearSystem.sMetrics;
            long v1 = 1;
            if(v0 != null) {
                v0.constraints += v1;
                if(arg8.isSimpleDefinition) {
                    LinearSystem.sMetrics.simpleconstraints += v1;
                }
            }

            int v3 = 1;
            if(this.mNumRows + 1 >= this.mMaxRows || this.mNumColumns + 1 >= this.mMaxColumns) {
                this.increaseTableSize();
            }

            int v4 = 0;
            if(!arg8.isSimpleDefinition) {
                arg8.updateFromSystem(this);
                if(arg8.isEmpty()) {
                    return;
                }
                else {
                    arg8.ensurePositiveConstant();
                    if(arg8.chooseSubject(this)) {
                        SolverVariable v0_1 = this.createExtraVariable();
                        arg8.variable = v0_1;
                        this.addRow(arg8);
                        this.mTempGoal.initFromRow(((Row)arg8));
                        this.optimize(this.mTempGoal, true);
                        if(v0_1.definitionId == -1) {
                            if(arg8.variable == v0_1) {
                                v0_1 = arg8.pickPivot(v0_1);
                                if(v0_1 != null) {
                                    Metrics v4_1 = LinearSystem.sMetrics;
                                    if(v4_1 != null) {
                                        v4_1.pivots += v1;
                                    }

                                    arg8.pivot(v0_1);
                                }
                            }

                            if(!arg8.isSimpleDefinition) {
                                arg8.variable.updateReferencesWithNewDefinition(arg8);
                            }

                            --this.mNumRows;
                        }
                    }
                    else {
                        v3 = 0;
                    }

                    if(!arg8.hasKeyVariable()) {
                        return;
                    }

                    v4 = v3;
                }
            }

            if(v4 != 0) {
                return;
            }

            this.addRow(arg8);
        }
    }

    public ArrayRow addEquality(SolverVariable arg4, SolverVariable arg5, int arg6, int arg7) {
        int v0 = 8;
        if(arg7 == v0 && (arg5.isFinalValue) && arg4.definitionId == -1) {
            arg4.setFinalValue(this, arg5.computedValue + (((float)arg6)));
            return null;
        }

        ArrayRow v1 = this.createRow();
        v1.createRowEquals(arg4, arg5, arg6);
        if(arg7 != v0) {
            v1.addError(this, arg7);
        }

        this.addConstraint(v1);
        return v1;
    }

    public void addEquality(SolverVariable arg4, int arg5) {
        ArrayRow v0_1;
        int v1 = -1;
        if(arg4.definitionId == v1) {
            arg4.setFinalValue(this, ((float)arg5));
            return;
        }

        int v0 = arg4.definitionId;
        if(arg4.definitionId != v1) {
            v0_1 = this.mRows[v0];
            if(v0_1.isSimpleDefinition) {
                v0_1.constantValue = ((float)arg5);
                return;
            }

            if(v0_1.variables.getCurrentSize() == 0) {
                v0_1.isSimpleDefinition = true;
                v0_1.constantValue = ((float)arg5);
                return;
            }

            v0_1 = this.createRow();
            v0_1.createRowEquals(arg4, arg5);
            this.addConstraint(v0_1);
            return;
        }

        v0_1 = this.createRow();
        v0_1.createRowDefinition(arg4, arg5);
        this.addConstraint(v0_1);
    }

    private void addError(ArrayRow arg2) {
        arg2.addError(this, 0);
    }

    public void addGreaterBarrier(SolverVariable arg3, SolverVariable arg4, int arg5, boolean arg6) {
        ArrayRow v6 = this.createRow();
        SolverVariable v0 = this.createSlackVariable();
        v0.strength = 0;
        v6.createRowGreaterThan(arg3, arg4, v0, arg5);
        this.addConstraint(v6);
    }

    public void addGreaterThan(SolverVariable arg4, SolverVariable arg5, int arg6, int arg7) {
        ArrayRow v0 = this.createRow();
        SolverVariable v1 = this.createSlackVariable();
        v1.strength = 0;
        v0.createRowGreaterThan(arg4, arg5, v1, arg6);
        if(arg7 != 8) {
            this.addSingleError(v0, ((int)(v0.variables.get(v1) * -1f)), arg7);
        }

        this.addConstraint(v0);
    }

    public void addLowerBarrier(SolverVariable arg3, SolverVariable arg4, int arg5, boolean arg6) {
        ArrayRow v6 = this.createRow();
        SolverVariable v0 = this.createSlackVariable();
        v0.strength = 0;
        v6.createRowLowerThan(arg3, arg4, v0, arg5);
        this.addConstraint(v6);
    }

    public void addLowerThan(SolverVariable arg4, SolverVariable arg5, int arg6, int arg7) {
        ArrayRow v0 = this.createRow();
        SolverVariable v1 = this.createSlackVariable();
        v1.strength = 0;
        v0.createRowLowerThan(arg4, arg5, v1, arg6);
        if(arg7 != 8) {
            this.addSingleError(v0, ((int)(v0.variables.get(v1) * -1f)), arg7);
        }

        this.addConstraint(v0);
    }

    public void addRatio(SolverVariable arg7, SolverVariable arg8, SolverVariable arg9, SolverVariable arg10, float arg11, int arg12) {
        ArrayRow v0 = this.createRow();
        v0.createRowDimensionRatio(arg7, arg8, arg9, arg10, arg11);
        if(arg12 != 8) {
            v0.addError(this, arg12);
        }

        this.addConstraint(v0);
    }

    private final void addRow(ArrayRow arg4) {
        boolean v0 = LinearSystem.OPTIMIZED_ENGINE;
        ArrayRow[] v1 = this.mRows;
        if(v0) {
            if(v1[this.mNumRows] != null) {
                this.mCache.optimizedArrayRowPool.release(this.mRows[this.mNumRows]);
            }
        }
        else if(v1[this.mNumRows] != null) {
            this.mCache.arrayRowPool.release(this.mRows[this.mNumRows]);
        }

        this.mRows[this.mNumRows] = arg4;
        arg4.variable.definitionId = this.mNumRows;
        ++this.mNumRows;
        arg4.variable.updateReferencesWithNewDefinition(arg4);
    }

    private void addSingleError(ArrayRow arg2, int arg3) {
        this.addSingleError(arg2, arg3, 0);
    }

    void addSingleError(ArrayRow arg2, int arg3, int arg4) {
        arg2.addSingleError(this.createErrorVariable(arg4, null), arg3);
    }

    final void cleanupRows() {
        ArrayRow[] v5;
        int v2;
        int v0;
        for(v0 = 0; v0 < this.mNumRows; ++v0) {
            ArrayRow v1 = this.mRows[v0];
            if(v1.variables.getCurrentSize() == 0) {
                v1.isSimpleDefinition = true;
            }

            if(v1.isSimpleDefinition) {
                v1.variable.computedValue = v1.constantValue;
                v1.variable.removeFromRow(v1);
                int v1_1;
                for(v1_1 = v0; true; v1_1 = v2) {
                    v2 = this.mNumRows;
                    v5 = this.mRows;
                    if(v1_1 >= v2 - 1) {
                        break;
                    }

                    v2 = v1_1 + 1;
                    v5[v1_1] = v5[v2];
                }

                v5[v2 - 1] = null;
                this.mNumRows = v2 - 1;
                --v0;
            }
        }
    }

    private void computeValues() {
        int v0;
        for(v0 = 0; v0 < this.mNumRows; ++v0) {
            this.mRows[v0].variable.computedValue = this.mRows[v0].constantValue;
        }
    }

    public SolverVariable createErrorVariable(int arg6, String arg7) {
        Metrics v0 = LinearSystem.sMetrics;
        if(v0 != null) {
            ++v0.errors;
        }

        if(this.mNumColumns + 1 >= this.mMaxColumns) {
            this.increaseTableSize();
        }

        SolverVariable v7 = this.acquireSolverVariable(Type.ERROR, arg7);
        int v0_1 = this.mVariablesID + 1;
        this.mVariablesID = v0_1;
        ++this.mNumColumns;
        v7.id = v0_1;
        v7.strength = arg6;
        this.mCache.mIndexedVariables[this.mVariablesID] = v7;
        this.mGoal.addError(v7);
        return v7;
    }

    public SolverVariable createExtraVariable() {
        Metrics v0 = LinearSystem.sMetrics;
        if(v0 != null) {
            ++v0.extravariables;
        }

        if(this.mNumColumns + 1 >= this.mMaxColumns) {
            this.increaseTableSize();
        }

        SolverVariable v0_1 = this.acquireSolverVariable(Type.SLACK, null);
        int v1 = this.mVariablesID + 1;
        this.mVariablesID = v1;
        ++this.mNumColumns;
        v0_1.id = v1;
        this.mCache.mIndexedVariables[this.mVariablesID] = v0_1;
        return v0_1;
    }

    public SolverVariable createObjectVariable(Object arg4) {
        SolverVariable v0 = null;
        if(arg4 == null) {
            return v0;
        }

        if(this.mNumColumns + 1 >= this.mMaxColumns) {
            this.increaseTableSize();
        }

        if((arg4 instanceof ConstraintAnchor)) {
            v0 = ((ConstraintAnchor)arg4).getSolverVariable();
            if(v0 == null) {
                ((ConstraintAnchor)arg4).resetSolverVariable(this.mCache);
                v0 = ((ConstraintAnchor)arg4).getSolverVariable();
            }

            int v1 = -1;
            if(v0.id != v1 && v0.id <= this.mVariablesID) {
                if(this.mCache.mIndexedVariables[v0.id] == null) {
                }
                else {
                    return v0;
                }
            }

            if(v0.id != v1) {
                v0.reset();
            }

            int v4 = this.mVariablesID + 1;
            this.mVariablesID = v4;
            ++this.mNumColumns;
            v0.id = v4;
            v0.mType = Type.UNRESTRICTED;
            this.mCache.mIndexedVariables[this.mVariablesID] = v0;
        }

        return v0;
    }

    public ArrayRow createRow() {
        Object v0_1;
        boolean v0 = LinearSystem.OPTIMIZED_ENGINE;
        Cache v1 = this.mCache;
        long v2 = 1;
        if(v0) {
            v0_1 = v1.optimizedArrayRowPool.acquire();
            if(v0_1 == null) {
                ValuesRow v0_2 = new ValuesRow(this, this.mCache);
                LinearSystem.OPTIMIZED_ARRAY_ROW_CREATION += v2;
            }
            else {
                ((ArrayRow)v0_1).reset();
            }
        }
        else {
            v0_1 = v1.arrayRowPool.acquire();
            if(v0_1 == null) {
                ArrayRow v0_3 = new ArrayRow(this.mCache);
                LinearSystem.ARRAY_ROW_CREATION += v2;
            }
            else {
                ((ArrayRow)v0_1).reset();
            }
        }

        SolverVariable.increaseErrorId();
        return ((ArrayRow)v0_1);
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem arg0, SolverVariable arg1, SolverVariable arg2, float arg3) {
        return arg0.createRow().createRowDimensionPercent(arg1, arg2, arg3);
    }

    public SolverVariable createSlackVariable() {
        Metrics v0 = LinearSystem.sMetrics;
        if(v0 != null) {
            ++v0.slackvariables;
        }

        if(this.mNumColumns + 1 >= this.mMaxColumns) {
            this.increaseTableSize();
        }

        SolverVariable v0_1 = this.acquireSolverVariable(Type.SLACK, null);
        int v1 = this.mVariablesID + 1;
        this.mVariablesID = v1;
        ++this.mNumColumns;
        v0_1.id = v1;
        this.mCache.mIndexedVariables[this.mVariablesID] = v0_1;
        return v0_1;
    }

    private SolverVariable createVariable(String arg6, Type arg7) {
        Metrics v0 = LinearSystem.sMetrics;
        if(v0 != null) {
            ++v0.variables;
        }

        if(this.mNumColumns + 1 >= this.mMaxColumns) {
            this.increaseTableSize();
        }

        SolverVariable v7 = this.acquireSolverVariable(arg7, null);
        v7.setName(arg6);
        int v0_1 = this.mVariablesID + 1;
        this.mVariablesID = v0_1;
        ++this.mNumColumns;
        v7.id = v0_1;
        HashMap v0_2 = this.mVariables;
        if(v0_2 == null) {
            v0_2 = new HashMap();
            this.mVariables = v0_2;
        }

        v0_2.put(arg6, v7);
        this.mCache.mIndexedVariables[this.mVariablesID] = v7;
        return v7;
    }

    public void displayReadableRows() {
        String v4;
        this.displaySolverVariables();
        String v0 = "";
        int v1 = 0;
        int v2;
        for(v2 = 0; true; ++v2) {
            v4 = "\n";
            if(v2 >= this.mVariablesID) {
                break;
            }

            SolverVariable v3 = this.mCache.mIndexedVariables[v2];
            if(v3 != null && (v3.isFinalValue)) {
                v0 = v0 + " $[" + v2 + "] => " + v3 + " = " + v3.computedValue + v4;
            }
        }

        v0 = v0 + "\n\n #  ";
        while(v1 < this.mNumRows) {
            v0 = v0 + this.mRows[v1].toReadableString() + "\n #  ";
            ++v1;
        }

        if(this.mGoal != null) {
            v0 = v0 + "Goal: " + this.mGoal + v4;
        }

        System.out.println(v0);
    }

    private void displayRows() {
        String v3;
        this.displaySolverVariables();
        String v0 = "";
        int v1;
        for(v1 = 0; true; ++v1) {
            v3 = "\n";
            if(v1 >= this.mNumRows) {
                break;
            }

            v0 = v0 + this.mRows[v1] + v3;
        }

        System.out.println(v0 + this.mGoal + v3);
    }

    private void displaySolverVariables() {
        System.out.println("Display Rows (" + this.mNumRows + "x" + this.mNumColumns + ")\n");
    }

    void displaySystemInformations() {
        int v1 = 0;
        int v2 = 0;
        while(v1 < this.TABLE_SIZE) {
            ArrayRow v3 = this.mRows[v1];
            if(v3 != null) {
                v2 += v3.sizeInBytes();
            }

            ++v1;
        }

        v1 = 0;
        int v3_1 = 0;
        while(v1 < this.mNumRows) {
            ArrayRow v4 = this.mRows[v1];
            if(v4 != null) {
                v3_1 += v4.sizeInBytes();
            }

            ++v1;
        }

        System.out.println("Linear System -> Table size: " + this.TABLE_SIZE + " (" + this.getDisplaySize(this.TABLE_SIZE * this.TABLE_SIZE) + ") -- row sizes: " + this.getDisplaySize(v2) + ", actual size: " + this.getDisplaySize(v3_1) + " rows: " + this.mNumRows + "/" + this.mMaxRows + " cols: " + this.mNumColumns + "/" + this.mMaxColumns + " 0 occupied cells, " + this.getDisplaySize(0));
    }

    public void displayVariablesReadableRows() {
        String v3;
        this.displaySolverVariables();
        String v0 = "";
        int v1;
        for(v1 = 0; true; ++v1) {
            v3 = "\n";
            if(v1 >= this.mNumRows) {
                break;
            }

            if(this.mRows[v1].variable.mType == Type.UNRESTRICTED) {
                v0 = v0 + this.mRows[v1].toReadableString() + v3;
            }
        }

        System.out.println(v0 + this.mGoal + v3);
    }

    private int enforceBFS(Row arg20) throws Exception {
        long v17;
        int v3;
        float v4;
        LinearSystem v0 = this;
        int v2;
        for(v2 = 0; v2 < v0.mNumRows; ++v2) {
            if(v0.mRows[v2].variable.mType == Type.UNRESTRICTED) {
            }
            else {
                v4 = 0f;
                if(v0.mRows[v2].constantValue < 0f) {
                    v2 = 0;
                    v3 = 0;
                    goto label_18;
                }
            }
        }

        return 0;
    label_18:
        while(v2 == 0) {
            Metrics v5 = LinearSystem.sMetrics;
            long v6 = 1;
            if(v5 != null) {
                v5.bfs += v6;
            }

            ++v3;
            int v5_1 = -1;
            float v8 = 3.402823E+38f;
            int v10 = v5_1;
            int v11 = v10;
            int v9 = 0;
            int v12 = 0;
            while(true) {
                int v14 = 1;
                if(v9 >= v0.mNumRows) {
                    break;
                }

                ArrayRow v13 = v0.mRows[v9];
                if(v13.variable.mType == Type.UNRESTRICTED) {
                }
                else if(v13.isSimpleDefinition) {
                }
                else {
                    if(v13.constantValue >= v4) {
                        goto label_78;
                    }

                    while(v14 < v0.mNumColumns) {
                        SolverVariable v1 = v0.mCache.mIndexedVariables[v14];
                        float v15 = v13.variables.get(v1);
                        if(v15 <= v4) {
                            v17 = v6;
                        }
                        else {
                            int v4_1 = 0;
                            v17 = v6;
                            while(v4_1 < 9) {
                                float v6_1 = v1.strengthVector[v4_1] / v15;
                                if(v6_1 < v8 && v4_1 == v12 || v4_1 > v12) {
                                    v12 = v4_1;
                                    v8 = v6_1;
                                    v10 = v9;
                                    v11 = v14;
                                }

                                ++v4_1;
                            }
                        }

                        ++v14;
                        v6 = v17;
                        v4 = 0f;
                    }
                }

            label_78:
                ++v9;
                v6 = v6;
                v4 = 0f;
            }

            v17 = v6;
            if(v10 != v5_1) {
                ArrayRow v1_1 = v0.mRows[v10];
                v1_1.variable.definitionId = v5_1;
                Metrics v4_2 = LinearSystem.sMetrics;
                if(v4_2 != null) {
                    v4_2.pivots += v17;
                }

                v1_1.pivot(v0.mCache.mIndexedVariables[v11]);
                v1_1.variable.definitionId = v10;
                v1_1.variable.updateReferencesWithNewDefinition(v1_1);
            }
            else {
                v2 = 1;
            }

            if(v3 > v0.mNumColumns / 2) {
                v2 = 1;
            }

            v4 = 0f;
        }

        return v3;
    }

    public void fillMetrics(Metrics arg1) {
        LinearSystem.sMetrics = arg1;
    }

    public Cache getCache() {
        return this.mCache;
    }

    private String getDisplaySize(int arg3) {
        arg3 *= 4;
        int v2 = arg3 / 0x400;
        int v0 = v2 / 0x400;
        String v1 = "";
        if(v0 > 0) {
            return v1 + v0 + " Mb";
        }

        if(v2 > 0) {
            return v1 + v2 + " Kb";
        }

        return v1 + arg3 + " bytes";
    }

    private String getDisplayStrength(int arg1) {
        if(arg1 == 1) {
            return "LOW";
        }

        if(arg1 == 2) {
            return "MEDIUM";
        }

        if(arg1 == 3) {
            return "HIGH";
        }

        if(arg1 == 4) {
            return "HIGHEST";
        }

        if(arg1 == 5) {
            return "EQUALITY";
        }

        if(arg1 == 8) {
            return "FIXED";
        }

        if(arg1 == 6) {
            return "BARRIER";
        }

        return "NONE";
    }

    Row getGoal() {
        return this.mGoal;
    }

    public int getMemoryUsed() {
        int v0 = 0;
        int v1 = 0;
        while(v0 < this.mNumRows) {
            ArrayRow v2 = this.mRows[v0];
            if(v2 != null) {
                v1 += v2.sizeInBytes();
            }

            ++v0;
        }

        return v1;
    }

    public static Metrics getMetrics() {
        return LinearSystem.sMetrics;
    }

    public int getNumEquations() {
        return this.mNumRows;
    }

    public int getNumVariables() {
        return this.mVariablesID;
    }

    public int getObjectVariableValue(Object arg1) {
        SolverVariable v0 = ((ConstraintAnchor)arg1).getSolverVariable();
        if(v0 != null) {
            return ((int)(v0.computedValue + 0.5f));
        }

        return 0;
    }

    ArrayRow getRow(int arg1) {
        return this.mRows[arg1];
    }

    float getValueFor(String arg2) {
        SolverVariable v1 = this.getVariable(arg2, Type.UNRESTRICTED);
        if(v1 == null) {
            return 0;
        }

        return v1.computedValue;
    }

    SolverVariable getVariable(String arg2, Type arg3) {
        HashMap v0 = this.mVariables;
        if(v0 == null) {
            v0 = new HashMap();
            this.mVariables = v0;
        }

        Object v0_1 = v0.get(arg2);
        if(v0_1 == null) {
            return this.createVariable(arg2, arg3);
        }

        return ((SolverVariable)v0_1);
    }

    private void increaseTableSize() {
        int v0 = this.TABLE_SIZE * 2;
        this.TABLE_SIZE = v0;
        this.mRows = Arrays.copyOf(this.mRows, v0);
        this.mCache.mIndexedVariables = Arrays.copyOf(this.mCache.mIndexedVariables, this.TABLE_SIZE);
        v0 = this.TABLE_SIZE;
        this.mAlreadyTestedCandidates = new boolean[v0];
        this.mMaxColumns = v0;
        this.mMaxRows = v0;
        Metrics v0_1 = LinearSystem.sMetrics;
        if(v0_1 != null) {
            ++v0_1.tableSizeIncrease;
            LinearSystem.sMetrics.maxTableSize = Math.max(LinearSystem.sMetrics.maxTableSize, ((long)this.TABLE_SIZE));
            LinearSystem.sMetrics.lastTableSize = LinearSystem.sMetrics.maxTableSize;
        }
    }

    public void minimize() throws Exception {
        Metrics v0 = LinearSystem.sMetrics;
        long v1 = 1;
        if(v0 != null) {
            v0.minimize += v1;
        }

        if(!this.graphOptimizer) {
            if(this.newgraphOptimizer) {
            }
            else {
                this.minimizeGoal(this.mGoal);
                return;
            }
        }

        v0 = LinearSystem.sMetrics;
        if(v0 != null) {
            v0.graphOptimizer += v1;
        }

        int v0_1;
        for(v0_1 = 0; v0_1 < this.mNumRows; ++v0_1) {
            if(!this.mRows[v0_1].isSimpleDefinition) {
                this.minimizeGoal(this.mGoal);
                return;
            }
        }

        v0 = LinearSystem.sMetrics;
        if(v0 != null) {
            v0.fullySolved += v1;
        }

        this.computeValues();
    }

    void minimizeGoal(Row arg6) throws Exception {
        Metrics v0 = LinearSystem.sMetrics;
        if(v0 != null) {
            ++v0.minimizeGoal;
            LinearSystem.sMetrics.maxVariables = Math.max(LinearSystem.sMetrics.maxVariables, ((long)this.mNumColumns));
            LinearSystem.sMetrics.maxRows = Math.max(LinearSystem.sMetrics.maxRows, ((long)this.mNumRows));
        }

        this.enforceBFS(arg6);
        this.optimize(arg6, false);
        this.computeValues();
    }

    private final int optimize(Row arg13, boolean arg14) {
        int v8;
        int v7;
        float v6;
        int v5;
        SolverVariable v4_1;
        Metrics v14 = LinearSystem.sMetrics;
        long v0 = 1;
        if(v14 != null) {
            v14.optimize += v0;
        }

        int v2;
        for(v2 = 0; v2 < this.mNumColumns; ++v2) {
            this.mAlreadyTestedCandidates[v2] = false;
        }

        v2 = 0;
        int v3 = 0;
    label_16:
        while(v2 == 0) {
            Metrics v4 = LinearSystem.sMetrics;
            if(v4 != null) {
                v4.iterations += v0;
            }

            ++v3;
            if(v3 >= this.mNumColumns * 2) {
            }
            else {
                if(arg13.getKey() != null) {
                    this.mAlreadyTestedCandidates[arg13.getKey().id] = true;
                }

                v4_1 = arg13.getPivotCandidate(this, this.mAlreadyTestedCandidates);
                if(v4_1 != null) {
                    if(this.mAlreadyTestedCandidates[v4_1.id]) {
                        return v3;
                    }
                    else {
                        goto label_42;
                    }
                }

                goto label_45;
            }

            return v3;
        label_42:
            this.mAlreadyTestedCandidates[v4_1.id] = true;
        label_45:
            if(v4_1 != null) {
                v5 = -1;
                v6 = 3.402823E+38f;
                v7 = 0;
                v8 = v5;
                goto label_50;
            }

            v2 = 1;
        }

        return v3;
    label_50:
        while(v7 < this.mNumRows) {
            ArrayRow v9 = this.mRows[v7];
            if(v9.variable.mType == Type.UNRESTRICTED) {
            }
            else if(v9.isSimpleDefinition) {
            }
            else if(v9.hasVariable(v4_1)) {
                float v10 = v9.variables.get(v4_1);
                if(v10 < 0f) {
                    float v9_1 = -v9.constantValue / v10;
                    if(v9_1 < v6) {
                        v8 = v7;
                        v6 = v9_1;
                    }
                }
            }

            ++v7;
        }

        if(v8 <= v5) {
            goto label_16;
        }

        ArrayRow v6_1 = this.mRows[v8];
        v6_1.variable.definitionId = v5;
        Metrics v5_1 = LinearSystem.sMetrics;
        if(v5_1 != null) {
            v5_1.pivots += v0;
        }

        v6_1.pivot(v4_1);
        v6_1.variable.definitionId = v8;
        v6_1.variable.updateReferencesWithNewDefinition(v6_1);
        goto label_16;
    }

    private void releaseRows() {
        ArrayRow v0_1;
        ArrayRow[] v0;
        ArrayRow v1 = null;
        int v2 = 0;
        if(LinearSystem.OPTIMIZED_ENGINE) {
            while(true) {
                v0 = this.mRows;
                if(v2 < v0.length) {
                    v0_1 = v0[v2];
                    if(v0_1 != null) {
                        this.mCache.optimizedArrayRowPool.release(v0_1);
                    }

                    this.mRows[v2] = v1;
                    ++v2;
                    continue;
                }

                return;
            }
        }
        else {
            while(true) {
                v0 = this.mRows;
                if(v2 >= v0.length) {
                    return;
                }

                v0_1 = v0[v2];
                if(v0_1 != null) {
                    this.mCache.arrayRowPool.release(v0_1);
                }

                this.mRows[v2] = v1;
                ++v2;
            }
        }
    }

    public void removeRow(ArrayRow arg5) {
        int v1;
        if((arg5.isSimpleDefinition) && arg5.variable != null) {
            if(arg5.variable.definitionId != -1) {
                int v0;
                for(v0 = arg5.variable.definitionId; true; v0 = v2) {
                    v1 = this.mNumRows;
                    if(v0 >= v1 - 1) {
                        break;
                    }

                    int v2 = v0 + 1;
                    this.mRows[v0] = this.mRows[v2];
                }

                this.mNumRows = v1 - 1;
            }

            arg5.variable.setFinalValue(this, arg5.constantValue);
        }
    }

    public void reset() {
        Cache v3;
        int v1;
        for(v1 = 0; true; ++v1) {
            int v2 = this.mCache.mIndexedVariables.length;
            v3 = this.mCache;
            if(v1 >= v2) {
                break;
            }

            SolverVariable v2_1 = v3.mIndexedVariables[v1];
            if(v2_1 != null) {
                v2_1.reset();
            }
        }

        v3.solverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        Arrays.fill(this.mCache.mIndexedVariables, null);
        HashMap v1_1 = this.mVariables;
        if(v1_1 != null) {
            v1_1.clear();
        }

        this.mVariablesID = 0;
        this.mGoal.clear();
        this.mNumColumns = 1;
        for(v1 = 0; v1 < this.mNumRows; ++v1) {
            this.mRows[v1].used = false;
        }

        this.releaseRows();
        this.mNumRows = 0;
        if(LinearSystem.OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(this, this.mCache);
            return;
        }

        this.mTempGoal = new ArrayRow(this.mCache);
    }
}

