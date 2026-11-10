package androidx.constraintlayout.solver;

import java.util.Arrays;
import java.util.Comparator;

public class PriorityGoalRow extends ArrayRow {
    class GoalVariableAccessor implements Comparable {
        PriorityGoalRow row;
        SolverVariable variable;

        public GoalVariableAccessor(PriorityGoalRow arg1, PriorityGoalRow arg2) {
            PriorityGoalRow.this = arg1;
            super();
            this.row = arg2;
        }

        public void add(SolverVariable arg5) {
            int v0;
            for(v0 = 0; v0 < 9; ++v0) {
                this.variable.goalStrengthVector[v0] += arg5.goalStrengthVector[v0];
                if(Math.abs(this.variable.goalStrengthVector[v0]) < 0.0001f) {
                    this.variable.goalStrengthVector[v0] = 0f;
                }
            }
        }

        public boolean addToGoal(SolverVariable arg10, float arg11) {
            float v1 = 0.0001f;
            int v2 = 9;
            int v4 = 1;
            int v5 = 0;
            if(this.variable.inGoal) {
                int v0;
                for(v0 = 0; v0 < v2; ++v0) {
                    this.variable.goalStrengthVector[v0] += arg10.goalStrengthVector[v0] * arg11;
                    if(Math.abs(this.variable.goalStrengthVector[v0]) < v1) {
                        this.variable.goalStrengthVector[v0] = 0f;
                    }
                    else {
                        v4 = 0;
                    }
                }

                if(v4 != 0) {
                    PriorityGoalRow.this.removeGoal(this.variable);
                }

                return 0;
            }

            while(v5 < v2) {
                float v0_1 = arg10.goalStrengthVector[v5];
                if(v0_1 != 0f) {
                    v0_1 *= arg11;
                    if(Math.abs(v0_1) < v1) {
                        v0_1 = 0f;
                    }

                    this.variable.goalStrengthVector[v5] = v0_1;
                }
                else {
                    this.variable.goalStrengthVector[v5] = 0f;
                }

                ++v5;
            }

            return 1;
        }

        public int compareTo(Object arg1) {
            return this.variable.id - ((SolverVariable)arg1).id;
        }

        public void init(SolverVariable arg1) {
            this.variable = arg1;
        }

        public final boolean isNegative() {
            int v0;
            for(v0 = 8; v0 >= 0; --v0) {
                float v2 = this.variable.goalStrengthVector[v0];
                if(v2 > 0f) {
                    return 0;
                }

                if(v2 < 0f) {
                    return 1;
                }
            }

            return 0;
        }

        public final boolean isNull() {
            int v1;
            for(v1 = 0; v1 < 9; ++v1) {
                if(this.variable.goalStrengthVector[v1] != 0f) {
                    return 0;
                }
            }

            return 1;
        }

        public final boolean isSmallerThan(SolverVariable arg6) {
            int v0 = 8;
            while(true) {
                if(v0 >= 0) {
                    float v2 = arg6.goalStrengthVector[v0];
                    float v3 = this.variable.goalStrengthVector[v0];
                    if(v3 == v2) {
                        --v0;
                        continue;
                    }
                    else {
                        break;
                    }
                }

                return 0;
            }

            if(v3 < v2) {
                return 1;
            }

            return 0;
        }

        public void reset() {
            Arrays.fill(this.variable.goalStrengthVector, 0f);
        }

        public String toString() {
            String v1 = "[ ";
            if(this.variable != null) {
                int v0;
                for(v0 = 0; v0 < 9; ++v0) {
                    v1 = v1 + this.variable.goalStrengthVector[v0] + " ";
                }
            }

            return v1 + "] " + this.variable;
        }
    }

    private static final boolean DEBUG = false;
    static final int NOT_FOUND = -1;
    private int TABLE_SIZE;
    GoalVariableAccessor accessor;
    private SolverVariable[] arrayGoals;
    private static final float epsilon = 0.0001f;
    Cache mCache;
    private int numGoals;
    private SolverVariable[] sortArray;

    public PriorityGoalRow(Cache arg3) {
        super(arg3);
        this.TABLE_SIZE = 0x80;
        this.arrayGoals = new SolverVariable[0x80];
        this.sortArray = new SolverVariable[0x80];
        this.numGoals = 0;
        this.accessor = new GoalVariableAccessor(this, this);
        this.mCache = arg3;
    }

    static void access$000(PriorityGoalRow arg0, SolverVariable arg1) {
        arg0.removeGoal(arg1);
    }

    public void addError(SolverVariable arg4) {
        this.accessor.init(arg4);
        this.accessor.reset();
        arg4.goalStrengthVector[arg4.strength] = 1f;
        this.addToGoal(arg4);
    }

    private final void addToGoal(SolverVariable arg6) {
        SolverVariable[] v4;
        int v0 = this.numGoals + 1;
        SolverVariable[] v2 = this.arrayGoals;
        if(v0 > v2.length) {
            Object[] v0_1 = Arrays.copyOf(((Object[])v2), v2.length * 2);
            this.arrayGoals = ((SolverVariable[])v0_1);
            this.sortArray = Arrays.copyOf(v0_1, v0_1.length * 2);
        }

        SolverVariable[] v0_2 = this.arrayGoals;
        int v2_1 = this.numGoals;
        v0_2[v2_1] = arg6;
        int v3 = v2_1 + 1;
        this.numGoals = v3;
        if(v3 > 1 && v0_2[v2_1].id > arg6.id) {
            v0 = 0;
            for(v2_1 = 0; true; ++v2_1) {
                v3 = this.numGoals;
                v4 = this.sortArray;
                if(v2_1 >= v3) {
                    break;
                }

                v4[v2_1] = this.arrayGoals[v2_1];
            }

            Arrays.sort(((Object[])v4), 0, v3, new Comparator() {
                public int compare(SolverVariable arg1, SolverVariable arg2) {
                    return arg1.id - arg2.id;
                }

                public int compare(Object arg1, Object arg2) {
                    return this.compare(((SolverVariable)arg1), ((SolverVariable)arg2));
                }
            });
            while(v0 < this.numGoals) {
                this.arrayGoals[v0] = this.sortArray[v0];
                ++v0;
            }
        }

        arg6.inGoal = true;
        arg6.addToRow(((ArrayRow)this));
    }

    public void clear() {
        this.numGoals = 0;
        this.constantValue = 0f;
    }

    public SolverVariable getPivotCandidate(LinearSystem arg5, boolean[] arg6) {
        int v5 = -1;
        int v0 = 0;
        int v1 = v5;
        while(v0 < this.numGoals) {
            SolverVariable v2 = this.arrayGoals[v0];
            if(arg6[v2.id]) {
            }
            else {
                this.accessor.init(v2);
                GoalVariableAccessor v2_1 = this.accessor;
                if(v1 != v5) {
                    if(v2_1.isSmallerThan(this.arrayGoals[v1])) {
                        goto label_22;
                    }

                    goto label_23;
                }
                else if(v2_1.isNegative()) {
                }
                else {
                    goto label_23;
                }

            label_22:
                v1 = v0;
            }

        label_23:
            ++v0;
        }

        if(v1 == v5) {
            return null;
        }

        return this.arrayGoals[v1];
    }

    private final void removeGoal(SolverVariable arg6) {
        int v2;
        int v1 = 0;
        while(v1 < this.numGoals) {
            if(this.arrayGoals[v1] != arg6) {
                ++v1;
                continue;
            }

            goto label_7;
        }

        return;
        while(true) {
        label_7:
            v2 = this.numGoals;
            if(v1 >= v2 - 1) {
                break;
            }

            int v3 = v1 + 1;
            this.arrayGoals[v1] = this.arrayGoals[v3];
            v1 = v3;
        }

        this.numGoals = v2 - 1;
        arg6.inGoal = false;
    }

    public String toString() {
        String v0 = " goal -> (" + this.constantValue + ") : ";
        int v1;
        for(v1 = 0; v1 < this.numGoals; ++v1) {
            this.accessor.init(this.arrayGoals[v1]);
            v0 = v0 + this.accessor + " ";
        }

        return v0;
    }

    public void updateFromRow(ArrayRow arg7, boolean arg8) {
        SolverVariable v8 = arg7.variable;
        if(v8 == null) {
            return;
        }

        ArrayRowVariables v0 = arg7.variables;
        int v1 = v0.getCurrentSize();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            SolverVariable v3 = v0.getVariable(v2);
            float v4 = v0.getVariableValue(v2);
            this.accessor.init(v3);
            if(this.accessor.addToGoal(v8, v4)) {
                this.addToGoal(v3);
            }

            this.constantValue += arg7.constantValue * v4;
        }

        this.removeGoal(v8);
    }
}

