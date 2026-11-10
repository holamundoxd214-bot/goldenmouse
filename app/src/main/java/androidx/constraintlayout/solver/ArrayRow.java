package androidx.constraintlayout.solver;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayRow implements Row {
    public interface ArrayRowVariables {
        void add(SolverVariable arg1, float arg2, boolean arg3);

        void clear();

        boolean contains(SolverVariable arg1);

        void display();

        void divideByAmount(float arg1);

        float get(SolverVariable arg1);

        int getCurrentSize();

        SolverVariable getVariable(int arg1);

        float getVariableValue(int arg1);

        int indexOf(SolverVariable arg1);

        void invert();

        void put(SolverVariable arg1, float arg2);

        float remove(SolverVariable arg1, boolean arg2);

        int sizeInBytes();

        float use(ArrayRow arg1, boolean arg2);
    }

    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    float constantValue;
    boolean isSimpleDefinition;
    boolean used;
    SolverVariable variable;
    public ArrayRowVariables variables;
    ArrayList variablesToUpdate;

    public ArrayRow() {
        super();
        this.variable = null;
        this.constantValue = 0f;
        this.used = false;
        this.variablesToUpdate = new ArrayList();
        this.isSimpleDefinition = false;
    }

    public ArrayRow(Cache arg3) {
        super();
        this.variable = null;
        this.constantValue = 0f;
        this.used = false;
        this.variablesToUpdate = new ArrayList();
        this.isSimpleDefinition = false;
        this.variables = new ArrayLinkedVariables(this, arg3);
    }

    public ArrayRow addError(LinearSystem arg4, int arg5) {
        this.variables.put(arg4.createErrorVariable(arg5, "ep"), 1f);
        this.variables.put(arg4.createErrorVariable(arg5, "em"), -1f);
        return this;
    }

    public void addError(SolverVariable arg4) {
        float v2 = 1f;
        if(arg4.strength == 1) {
        }
        else if(arg4.strength == 2) {
            v2 = 1000f;
        }
        else if(arg4.strength == 3) {
            v2 = 1000000f;
        }
        else if(arg4.strength == 4) {
            v2 = 1000000000f;
        }
        else if(arg4.strength == 5) {
            v2 = 999999995904f;
        }

        this.variables.put(arg4, v2);
    }

    ArrayRow addSingleError(SolverVariable arg2, int arg3) {
        this.variables.put(arg2, ((float)arg3));
        return this;
    }

    boolean chooseSubject(LinearSystem arg3) {
        boolean v3_1;
        SolverVariable v3 = this.chooseSubjectInVariables(arg3);
        if(v3 == null) {
            v3_1 = true;
        }
        else {
            this.pivot(v3);
            v3_1 = false;
        }

        if(this.variables.getCurrentSize() == 0) {
            this.isSimpleDefinition = true;
        }

        return v3_1;
    }

    SolverVariable chooseSubjectInVariables(LinearSystem arg15) {
        boolean v3_1;
        boolean v1_1;
        int v0 = this.variables.getCurrentSize();
        SolverVariable v1 = null;
        float v7 = 0f;
        float v8 = 0f;
        int v4 = 0;
        boolean v5 = false;
        boolean v6 = false;
        SolverVariable v3 = v1;
        while(v4 < v0) {
            float v9 = this.variables.getVariableValue(v4);
            SolverVariable v10 = this.variables.getVariable(v4);
            if(v10.mType == Type.UNRESTRICTED) {
                if(v1 == null) {
                    v1_1 = this.isNew(v10, arg15);
                }
                else if(v7 > v9) {
                    v1_1 = this.isNew(v10, arg15);
                }
                else {
                    goto label_29;
                }

                v5 = v1_1;
                v7 = v9;
                v1 = v10;
                goto label_53;
            label_29:
                if(v5) {
                    goto label_53;
                }

                if(!this.isNew(v10, arg15)) {
                    goto label_53;
                }

                v7 = v9;
                v1 = v10;
                v5 = true;
            }
            else {
                if(v1 != null) {
                    goto label_53;
                }

                if(v9 >= 0f) {
                    goto label_53;
                }

                if(v3 == null) {
                    v3_1 = this.isNew(v10, arg15);
                }
                else if(v8 > v9) {
                    v3_1 = this.isNew(v10, arg15);
                }
                else {
                    goto label_47;
                }

                v6 = v3_1;
                v8 = v9;
                v3 = v10;
                goto label_53;
            label_47:
                if(v6) {
                    goto label_53;
                }

                if(!this.isNew(v10, arg15)) {
                    goto label_53;
                }

                v8 = v9;
                v3 = v10;
                v6 = true;
            }

        label_53:
            ++v4;
        }

        if(v1 != null) {
            return v1;
        }

        return v3;
    }

    public void clear() {
        this.variables.clear();
        this.variable = null;
        this.constantValue = 0f;
    }

    ArrayRow createRowCentering(SolverVariable arg6, SolverVariable arg7, int arg8, float arg9, SolverVariable arg10, SolverVariable arg11, int arg12) {
        float v1_1;
        float v0 = 1f;
        if(arg7 == arg10) {
            this.variables.put(arg6, v0);
            this.variables.put(arg11, v0);
            this.variables.put(arg7, -2f);
            return this;
        }

        float v2 = -1f;
        if(Float.compare(arg9, 0.5f) == 0) {
            this.variables.put(arg6, v0);
            this.variables.put(arg7, v2);
            this.variables.put(arg10, v2);
            this.variables.put(arg11, v0);
            if(arg8 <= 0 && arg12 <= 0) {
                return this;
            }

            this.constantValue = ((float)(-arg8 + arg12));
            return this;
        }
        else {
            if(arg9 <= 0f) {
                this.variables.put(arg6, v2);
                this.variables.put(arg7, v0);
                this.constantValue = ((float)arg8);
                return this;
            }

            int v1 = Float.compare(arg9, v0);
            ArrayRowVariables v3 = this.variables;
            if(v1 >= 0) {
                v3.put(arg11, v2);
                this.variables.put(arg10, v0);
                this.constantValue = ((float)(-arg12));
                return this;
            }

            v1_1 = v0 - arg9;
            v3.put(arg6, v1_1 * v0);
            this.variables.put(arg7, v1_1 * v2);
            this.variables.put(arg10, v2 * arg9);
            this.variables.put(arg11, v0 * arg9);
            if(arg8 <= 0) {
                if(arg12 > 0) {
                }
                else {
                    return this;
                }
            }

            goto label_64;
        }

        return this;
    label_64:
        this.constantValue = (((float)(-arg8))) * v1_1 + (((float)arg12)) * arg9;
        return this;
    }

    ArrayRow createRowDefinition(SolverVariable arg1, int arg2) {
        this.variable = arg1;
        float v2 = ((float)arg2);
        arg1.computedValue = v2;
        this.constantValue = v2;
        this.isSimpleDefinition = true;
        return this;
    }

    ArrayRow createRowDimensionPercent(SolverVariable arg3, SolverVariable arg4, float arg5) {
        this.variables.put(arg3, -1f);
        this.variables.put(arg4, arg5);
        return this;
    }

    public ArrayRow createRowDimensionRatio(SolverVariable arg3, SolverVariable arg4, SolverVariable arg5, SolverVariable arg6, float arg7) {
        this.variables.put(arg3, -1f);
        this.variables.put(arg4, 1f);
        this.variables.put(arg5, arg7);
        this.variables.put(arg6, -arg7);
        return this;
    }

    public ArrayRow createRowEqualDimension(float arg4, float arg5, float arg6, SolverVariable arg7, int arg8, SolverVariable arg9, int arg10, SolverVariable arg11, int arg12, SolverVariable arg13, int arg14) {
        float v1 = -1f;
        float v2 = 1f;
        if(Float.compare(arg5, 0f) != 0) {
            if(arg4 == arg6) {
            }
            else {
                arg4 = arg4 / arg5 / (arg6 / arg5);
                this.constantValue = (((float)(-arg8 - arg10))) + (((float)arg12)) * arg4 + (((float)arg14)) * arg4;
                this.variables.put(arg7, v2);
                this.variables.put(arg9, v1);
                this.variables.put(arg13, arg4);
                this.variables.put(arg11, -arg4);
                return this;
            }
        }

        this.constantValue = ((float)(-arg8 - arg10 + arg12 + arg14));
        this.variables.put(arg7, v2);
        this.variables.put(arg9, v1);
        this.variables.put(arg13, v2);
        this.variables.put(arg11, v1);
        return this;
    }

    public ArrayRow createRowEqualMatchDimensions(float arg5, float arg6, float arg7, SolverVariable arg8, SolverVariable arg9, SolverVariable arg10, SolverVariable arg11) {
        this.constantValue = 0f;
        float v2 = -1f;
        float v3 = 1f;
        if(Float.compare(arg6, 0f) != 0) {
            if(arg5 == arg7) {
            }
            else if(arg5 == 0f) {
                this.variables.put(arg8, v3);
                this.variables.put(arg9, v2);
                return this;
            }
            else {
                int v0 = Float.compare(arg7, 0f);
                ArrayRowVariables v1 = this.variables;
                if(v0 == 0) {
                    v1.put(arg10, v3);
                    this.variables.put(arg11, v2);
                    return this;
                }
                else {
                    arg5 = arg5 / arg6 / (arg7 / arg6);
                    v1.put(arg8, v3);
                    this.variables.put(arg9, v2);
                    this.variables.put(arg11, arg5);
                    this.variables.put(arg10, -arg5);
                    return this;
                }
            }
        }

        this.variables.put(arg8, v3);
        this.variables.put(arg9, v2);
        this.variables.put(arg11, v3);
        this.variables.put(arg10, v2);
        return this;
    }

    public ArrayRow createRowEquals(SolverVariable arg2, int arg3) {
        if(arg3 < 0) {
            this.constantValue = ((float)(arg3 * -1));
            this.variables.put(arg2, 1f);
            return this;
        }

        this.constantValue = ((float)arg3);
        this.variables.put(arg2, -1f);
        return this;
    }

    public ArrayRow createRowEquals(SolverVariable arg4, SolverVariable arg5, int arg6) {
        int v0 = 0;
        if(arg6 != 0) {
            if(arg6 < 0) {
                arg6 *= -1;
                v0 = 1;
            }

            this.constantValue = ((float)arg6);
        }

        ArrayRowVariables v6 = this.variables;
        float v1 = -1f;
        float v2 = 1f;
        if(v0 == 0) {
            v6.put(arg4, v1);
            this.variables.put(arg5, v2);
            return this;
        }

        v6.put(arg4, v2);
        this.variables.put(arg5, v1);
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable arg1, int arg2, SolverVariable arg3) {
        this.constantValue = ((float)arg2);
        this.variables.put(arg1, -1f);
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable arg4, SolverVariable arg5, SolverVariable arg6, int arg7) {
        int v0 = 0;
        if(arg7 != 0) {
            if(arg7 < 0) {
                arg7 *= -1;
                v0 = 1;
            }

            this.constantValue = ((float)arg7);
        }

        ArrayRowVariables v7 = this.variables;
        float v1 = -1f;
        float v2 = 1f;
        if(v0 == 0) {
            v7.put(arg4, v1);
            this.variables.put(arg5, v2);
            this.variables.put(arg6, v2);
            return this;
        }

        v7.put(arg4, v2);
        this.variables.put(arg5, v1);
        this.variables.put(arg6, v1);
        return this;
    }

    public ArrayRow createRowLowerThan(SolverVariable arg4, SolverVariable arg5, SolverVariable arg6, int arg7) {
        int v0 = 0;
        if(arg7 != 0) {
            if(arg7 < 0) {
                arg7 *= -1;
                v0 = 1;
            }

            this.constantValue = ((float)arg7);
        }

        ArrayRowVariables v7 = this.variables;
        float v1 = -1f;
        float v2 = 1f;
        if(v0 == 0) {
            v7.put(arg4, v1);
            this.variables.put(arg5, v2);
            this.variables.put(arg6, v1);
            return this;
        }

        v7.put(arg4, v2);
        this.variables.put(arg5, v1);
        this.variables.put(arg6, v2);
        return this;
    }

    public ArrayRow createRowWithAngle(SolverVariable arg3, SolverVariable arg4, SolverVariable arg5, SolverVariable arg6, float arg7) {
        this.variables.put(arg5, 0.5f);
        this.variables.put(arg6, 0.5f);
        this.variables.put(arg3, -0.5f);
        this.variables.put(arg4, -0.5f);
        this.constantValue = -arg7;
        return this;
    }

    void ensurePositiveConstant() {
        float v0 = this.constantValue;
        if(v0 < 0f) {
            this.constantValue = v0 * -1f;
            this.variables.invert();
        }
    }

    public SolverVariable getKey() {
        return this.variable;
    }

    public SolverVariable getPivotCandidate(LinearSystem arg1, boolean[] arg2) {
        return this.pickPivotInVariables(arg2, null);
    }

    boolean hasKeyVariable() {
        SolverVariable v0 = this.variable;
        if(v0 != null && (v0.mType == Type.UNRESTRICTED || this.constantValue >= 0f)) {
            return 1;
        }

        return 0;
    }

    boolean hasVariable(SolverVariable arg1) {
        return this.variables.contains(arg1);
    }

    public void initFromRow(Row arg6) {
        if((arg6 instanceof ArrayRow)) {
            this.variable = null;
            this.variables.clear();
            int v0;
            for(v0 = 0; v0 < ((ArrayRow)arg6).variables.getCurrentSize(); ++v0) {
                this.variables.add(((ArrayRow)arg6).variables.getVariable(v0), ((ArrayRow)arg6).variables.getVariableValue(v0), true);
            }
        }
    }

    public boolean isEmpty() {
        if(this.variable == null && this.constantValue == 0f && this.variables.getCurrentSize() == 0) {
            return 1;
        }

        return 0;
    }

    private boolean isNew(SolverVariable arg1, LinearSystem arg2) {
        if(arg1.usageInRowCount <= 1) {
            return 1;
        }

        return 0;
    }

    public SolverVariable pickPivot(SolverVariable arg2) {
        return this.pickPivotInVariables(null, arg2);
    }

    private SolverVariable pickPivotInVariables(boolean[] arg10, SolverVariable arg11) {
        int v0 = this.variables.getCurrentSize();
        SolverVariable v2 = null;
        int v3 = 0;
        float v4 = 0f;
        while(v3 < v0) {
            float v5 = this.variables.getVariableValue(v3);
            if(v5 < 0f) {
                SolverVariable v6 = this.variables.getVariable(v3);
                if(arg10 != null && (arg10[v6.id])) {
                    goto label_26;
                }

                if(v6 == arg11) {
                    goto label_26;
                }

                if(v6.mType != Type.SLACK && v6.mType != Type.ERROR) {
                    goto label_26;
                }

                if(v5 >= v4) {
                    goto label_26;
                }

                v4 = v5;
                v2 = v6;
            }

        label_26:
            ++v3;
        }

        return v2;
    }

    void pivot(SolverVariable arg4) {
        SolverVariable v0 = this.variable;
        float v1 = -1f;
        if(v0 != null) {
            this.variables.put(v0, v1);
            this.variable = null;
        }

        float v0_1 = this.variables.remove(arg4, true) * v1;
        this.variable = arg4;
        if(v0_1 == 1f) {
            return;
        }

        this.constantValue /= v0_1;
        this.variables.divideByAmount(v0_1);
    }

    public void reset() {
        this.variable = null;
        this.variables.clear();
        this.constantValue = 0f;
        this.isSimpleDefinition = false;
    }

    int sizeInBytes() {
        int v0 = this.variable != null ? 4 : 0;
        return v0 + 8 + this.variables.sizeInBytes();
    }

    String toReadableString() {
        int v1;
        String v0 = this.variable == null ? "0" : "" + this.variable;
        v0 = v0 + " = ";
        int v3 = 0;
        if(Float.compare(this.constantValue, 0f) != 0) {
            v0 = v0 + this.constantValue;
            v1 = 1;
        }
        else {
            v1 = 0;
        }

        int v5 = this.variables.getCurrentSize();
        while(v3 < v5) {
            SolverVariable v6 = this.variables.getVariable(v3);
            if(v6 == null) {
            }
            else {
                float v7 = this.variables.getVariableValue(v3);
                int v8 = Float.compare(v7, 0f);
                if(v8 == 0) {
                }
                else {
                    String v6_1 = v6.toString();
                    float v9 = -1f;
                    if(v1 == 0) {
                        if(v7 < 0f) {
                            v0 = v0 + "- ";
                            goto label_68;
                        }
                    }
                    else if(v8 > 0) {
                        v0 = v0 + " + ";
                    }
                    else {
                        v0 = v0 + " - ";
                    label_68:
                        v7 *= v9;
                    }

                    v0 = v7 == 1f ? v0 + v6_1 : v0 + v7 + " " + v6_1;
                    v1 = 1;
                }
            }

            ++v3;
        }

        if(v1 == 0) {
            return v0 + "0.0";
        }

        return v0;
    }

    public String toString() {
        return this.toReadableString();
    }

    public void updateFromFinalVariable(LinearSystem arg3, SolverVariable arg4, boolean arg5) {
        if(!arg4.isFinalValue) {
        }
        else {
            this.constantValue += arg4.computedValue * this.variables.get(arg4);
            this.variables.remove(arg4, arg5);
            if(arg5) {
                arg4.removeFromRow(this);
            }
        }
    }

    public void updateFromRow(ArrayRow arg4, boolean arg5) {
        this.constantValue += arg4.constantValue * this.variables.use(arg4, arg5);
        if(arg5) {
            arg4.variable.removeFromRow(this);
        }
    }

    public void updateFromSystem(LinearSystem arg8) {
        Iterator v2_1;
        if(arg8.mRows.length == 0) {
        }
        else {
            int v1 = 0;
            while(v1 == 0) {
                int v2 = this.variables.getCurrentSize();
                int v3;
                for(v3 = 0; v3 < v2; ++v3) {
                    SolverVariable v4 = this.variables.getVariable(v3);
                    if(v4.definitionId != -1 || (v4.isFinalValue)) {
                        this.variablesToUpdate.add(v4);
                    }
                }

                if(this.variablesToUpdate.size() > 0) {
                    v2_1 = this.variablesToUpdate.iterator();
                }
                else {
                    v1 = 1;
                    continue;
                }

                while(v2_1.hasNext()) {
                    Object v4_1 = v2_1.next();
                    if(((SolverVariable)v4_1).isFinalValue) {
                        this.updateFromFinalVariable(arg8, ((SolverVariable)v4_1), true);
                        continue;
                    }

                    this.updateFromRow(arg8.mRows[((SolverVariable)v4_1).definitionId], true);
                }

                this.variablesToUpdate.clear();
            }
        }
    }
}

