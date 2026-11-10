package androidx.constraintlayout.solver;

import java.util.Arrays;
import java.util.HashSet;

public class SolverVariable {
    class androidx.constraintlayout.solver.SolverVariable$1 {
        static {
            int[] v0 = new int[Type.values().length];
            androidx.constraintlayout.solver.SolverVariable$1.$SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type = v0;
            try {
                v0[Type.UNRESTRICTED.ordinal()] = 1;
                goto label_8;
            }
            catch(NoSuchFieldError ) {
                try {
                label_8:
                    androidx.constraintlayout.solver.SolverVariable$1.$SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.CONSTANT.ordinal()] = 2;
                    goto label_13;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_13:
                        androidx.constraintlayout.solver.SolverVariable$1.$SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.SLACK.ordinal()] = 3;
                        goto label_18;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_18:
                            androidx.constraintlayout.solver.SolverVariable$1.$SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.ERROR.ordinal()] = 4;
                            goto label_23;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_23:
                                androidx.constraintlayout.solver.SolverVariable$1.$SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.UNKNOWN.ordinal()] = 5;
                                return;
                            }
                            catch(NoSuchFieldError ) {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public enum Type {
        public static final enum Type CONSTANT;
        public static final enum Type ERROR;
        public static final enum Type SLACK;
        public static final enum Type UNKNOWN;
        public static final enum Type UNRESTRICTED;

        static {
            Type v0 = new Type("UNRESTRICTED", 0);
            Type.UNRESTRICTED = v0;
            Type v1 = new Type("CONSTANT", 1);
            Type.CONSTANT = v1;
            Type v2 = new Type("SLACK", 2);
            Type.SLACK = v2;
            Type v3 = new Type("ERROR", 3);
            Type.ERROR = v3;
            Type v4 = new Type("UNKNOWN", 4);
            Type.UNKNOWN = v4;
            Type.$VALUES = new Type[]{v0, v1, v2, v3, v4};
        }

        private Type(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static Type valueOf(String arg1) {
            return Enum.valueOf(Type.class, arg1);
        }

        public static Type[] values() {
            return Type.$VALUES.clone();
        }
    }

    private static final boolean INTERNAL_DEBUG = false;
    static final int MAX_STRENGTH = 9;
    public static final int STRENGTH_BARRIER = 6;
    public static final int STRENGTH_CENTERING = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 8;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    private static final boolean VAR_USE_HASH = false;
    public float computedValue;
    int definitionId;
    float[] goalStrengthVector;
    public int id;
    public boolean inGoal;
    HashSet inRows;
    public boolean isFinalValue;
    ArrayRow[] mClientEquations;
    int mClientEquationsCount;
    private String mName;
    Type mType;
    public int strength;
    float[] strengthVector;
    private static int uniqueConstantId = 1;
    private static int uniqueErrorId = 1;
    private static int uniqueId = 1;
    private static int uniqueSlackId = 1;
    private static int uniqueUnrestrictedId = 1;
    public int usageInRowCount;

    static {
    }

    public SolverVariable(Type arg3, String arg4) {
        super();
        this.id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.strengthVector = new float[9];
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inRows = null;
        this.mType = arg3;
    }

    public SolverVariable(String arg4, Type arg5) {
        super();
        this.id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.strengthVector = new float[9];
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inRows = null;
        this.mName = arg4;
        this.mType = arg5;
    }

    public final void addToRow(ArrayRow arg4) {
        Object[] v2_1;
        ArrayRow[] v2;
        int v0;
        for(v0 = 0; true; ++v0) {
            int v1 = this.mClientEquationsCount;
            v2 = this.mClientEquations;
            if(v0 >= v1) {
                break;
            }

            if(v2[v0] == arg4) {
                return;
            }
        }

        if(v1 >= v2.length) {
            v2_1 = Arrays.copyOf(((Object[])v2), v2.length * 2);
            this.mClientEquations = ((ArrayRow[])v2_1);
        }

        v0 = this.mClientEquationsCount;
        ((ArrayRow[])v2_1)[v0] = arg4;
        this.mClientEquationsCount = v0 + 1;
    }

    void clearStrengths() {
        int v0;
        for(v0 = 0; v0 < 9; ++v0) {
            this.strengthVector[v0] = 0f;
        }
    }

    public String getName() {
        return this.mName;
    }

    private static String getUniqueName(Type arg2, String arg3) {
        StringBuilder v2;
        if(arg3 != null) {
            return arg3 + SolverVariable.uniqueErrorId;
        }

        int v3 = androidx.constraintlayout.solver.SolverVariable$1.$SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[arg2.ordinal()];
        if(v3 != 1) {
            if(v3 != 2) {
                if(v3 != 3) {
                    if(v3 != 4) {
                        if(v3 == 5) {
                            v2 = new StringBuilder("V");
                            v3 = SolverVariable.uniqueId + 1;
                            SolverVariable.uniqueId = v3;
                            return v2.append(v3).toString();
                        }

                        throw new AssertionError(arg2.name());
                    }

                    v2 = new StringBuilder("e");
                    v3 = SolverVariable.uniqueErrorId + 1;
                    SolverVariable.uniqueErrorId = v3;
                    return v2.append(v3).toString();
                }

                v2 = new StringBuilder("S");
                v3 = SolverVariable.uniqueSlackId + 1;
                SolverVariable.uniqueSlackId = v3;
                return v2.append(v3).toString();
            }

            v2 = new StringBuilder("C");
            v3 = SolverVariable.uniqueConstantId + 1;
            SolverVariable.uniqueConstantId = v3;
            return v2.append(v3).toString();
        }

        v2 = new StringBuilder("U");
        v3 = SolverVariable.uniqueUnrestrictedId + 1;
        SolverVariable.uniqueUnrestrictedId = v3;
        return v2.append(v3).toString();
    }

    static void increaseErrorId() {
        ++SolverVariable.uniqueErrorId;
    }

    public final void removeFromRow(ArrayRow arg5) {
        int v0 = this.mClientEquationsCount;
        int v1 = 0;
        while(v1 < v0) {
            if(this.mClientEquations[v1] != arg5) {
                ++v1;
                continue;
            }

            goto label_6;
        }

        return;
    label_6:
        while(v1 < v0 - 1) {
            int v2 = v1 + 1;
            this.mClientEquations[v1] = this.mClientEquations[v2];
            v1 = v2;
        }

        --this.mClientEquationsCount;
    }

    public void reset() {
        String v0 = null;
        this.mName = v0;
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.id = -1;
        this.definitionId = -1;
        this.computedValue = 0f;
        this.isFinalValue = false;
        int v3 = this.mClientEquationsCount;
        int v4;
        for(v4 = 0; v4 < v3; ++v4) {
            this.mClientEquations[v4] = ((ArrayRow)v0);
        }

        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inGoal = false;
        Arrays.fill(this.goalStrengthVector, 0f);
    }

    public void setFinalValue(LinearSystem arg4, float arg5) {
        this.computedValue = arg5;
        this.isFinalValue = true;
        int v5 = this.mClientEquationsCount;
        int v1;
        for(v1 = 0; v1 < v5; ++v1) {
            this.mClientEquations[v1].updateFromFinalVariable(arg4, this, false);
        }

        this.mClientEquationsCount = 0;
    }

    public void setName(String arg1) {
        this.mName = arg1;
    }

    public void setType(Type arg1, String arg2) {
        this.mType = arg1;
    }

    String strengthsToString() {
        String v0 = this + "[";
        int v3 = 0;
        int v4 = 0;
        int v5 = 1;
        while(v3 < this.strengthVector.length) {
            v0 = v0 + this.strengthVector[v3];
            float[] v6 = this.strengthVector;
            float v7 = v6[v3];
            if(v7 > 0f) {
                v4 = 0;
            }
            else if(v7 < 0f) {
                v4 = 1;
            }

            if(v7 != 0f) {
                v5 = 0;
            }

            v0 = v3 < v6.length - 1 ? v0 + ", " : v0 + "] ";
            ++v3;
        }

        if(v4 != 0) {
            v0 = v0 + " (-)";
        }

        if(v5 != 0) {
            return v0 + " (*)";
        }

        return v0;
    }

    public String toString() {
        String v1 = "";
        if(this.mName != null) {
            return v1 + this.mName;
        }

        return v1 + this.id;
    }

    public final void updateReferencesWithNewDefinition(ArrayRow arg5) {
        int v0 = this.mClientEquationsCount;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            this.mClientEquations[v2].updateFromRow(arg5, false);
        }

        this.mClientEquationsCount = 0;
    }
}

