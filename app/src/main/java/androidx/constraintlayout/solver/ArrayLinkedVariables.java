package androidx.constraintlayout.solver;

import java.util.Arrays;

public class ArrayLinkedVariables implements ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    static final int NONE = -1;
    private int ROW_SIZE;
    private SolverVariable candidate;
    int currentSize;
    private static float epsilon = 0.001f;
    private int[] mArrayIndices;
    private int[] mArrayNextIndices;
    private float[] mArrayValues;
    protected final Cache mCache;
    private boolean mDidFillOnce;
    private int mHead;
    private int mLast;
    private final ArrayRow mRow;

    static {
    }

    ArrayLinkedVariables(ArrayRow arg4, Cache arg5) {
        super();
        this.currentSize = 0;
        this.ROW_SIZE = 8;
        this.candidate = null;
        this.mArrayIndices = new int[8];
        this.mArrayNextIndices = new int[8];
        this.mArrayValues = new float[8];
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.mRow = arg4;
        this.mCache = arg5;
    }

    public void add(SolverVariable arg9, float arg10, boolean arg11) {
        int[] v4_1;
        int[] v0_2;
        int[] v10;
        int v9;
        float v0 = ArrayLinkedVariables.epsilon;
        if(arg10 <= -v0 || arg10 >= v0) {
            int v0_1 = this.mHead;
            int v2 = -1;
            if(v0_1 == v2) {
                this.mHead = 0;
                this.mArrayValues[0] = arg10;
                this.mArrayIndices[0] = arg9.id;
                this.mArrayNextIndices[this.mHead] = v2;
                ++arg9.usageInRowCount;
                arg9.addToRow(this.mRow);
                ++this.currentSize;
                if(!this.mDidFillOnce) {
                    v9 = this.mLast + 1;
                    this.mLast = v9;
                    v10 = this.mArrayIndices;
                    if(v9 >= v10.length) {
                        this.mDidFillOnce = true;
                        this.mLast = v10.length - 1;
                        return;
                    }
                }
            }
            else {
                int v4 = 0;
                int v5 = v2;
                while(v0_1 != v2) {
                    if(v4 >= this.currentSize) {
                        break;
                    }

                    if(this.mArrayIndices[v0_1] == arg9.id) {
                        float[] v1 = this.mArrayValues;
                        float v2_1 = v1[v0_1] + arg10;
                        arg10 = ArrayLinkedVariables.epsilon;
                        if(Float.compare(v2_1, -arg10) > 0 && v2_1 < arg10) {
                            v2_1 = 0f;
                        }

                        v1[v0_1] = v2_1;
                        if(v2_1 != 0f) {
                            return;
                        }

                        int v10_1 = this.mHead;
                        int[] v1_1 = this.mArrayNextIndices;
                        if(v0_1 == v10_1) {
                            this.mHead = v1_1[v0_1];
                        }
                        else {
                            v1_1[v5] = v1_1[v0_1];
                        }

                        if(arg11) {
                            arg9.removeFromRow(this.mRow);
                        }

                        if(this.mDidFillOnce) {
                            this.mLast = v0_1;
                        }

                        --arg9.usageInRowCount;
                        --this.currentSize;
                        return;
                    }
                    else {
                        if(this.mArrayIndices[v0_1] < arg9.id) {
                            v5 = v0_1;
                        }

                        v0_1 = this.mArrayNextIndices[v0_1];
                        ++v4;
                        continue;
                    }

                    break;
                }

                int v11 = this.mLast;
                v0_1 = v11 + 1;
                if(this.mDidFillOnce) {
                    v0_2 = this.mArrayIndices;
                    if(v0_2[v11] == v2) {
                    }
                    else {
                        v11 = v0_2.length;
                    }
                }
                else {
                    v11 = v0_1;
                }

                v0_2 = this.mArrayIndices;
                if(v11 >= v0_2.length) {
                    if(this.currentSize < v0_2.length) {
                        v0_1 = 0;
                        while(true) {
                            v4_1 = this.mArrayIndices;
                            if(v0_1 >= v4_1.length) {
                                break;
                            }
                            else if(v4_1[v0_1] == v2) {
                                v11 = v0_1;
                            }
                            else {
                                ++v0_1;
                                continue;
                            }

                            goto label_120;
                        }

                        v0_2 = v4_1;
                    }
                    else {
                    }

                    goto label_119;
                }
                else {
                label_119:
                    v4_1 = v0_2;
                }

            label_120:
                if(v11 >= v4_1.length) {
                    v11 = v4_1.length;
                    v0_1 = this.ROW_SIZE * 2;
                    this.ROW_SIZE = v0_1;
                    this.mDidFillOnce = false;
                    this.mLast = v11 - 1;
                    this.mArrayValues = Arrays.copyOf(this.mArrayValues, v0_1);
                    this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
                    this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
                }

                this.mArrayIndices[v11] = arg9.id;
                this.mArrayValues[v11] = arg10;
                v10 = this.mArrayNextIndices;
                if(v5 != v2) {
                    v10[v11] = v10[v5];
                    v10[v5] = v11;
                }
                else {
                    v10[v11] = this.mHead;
                    this.mHead = v11;
                }

                ++arg9.usageInRowCount;
                arg9.addToRow(this.mRow);
                ++this.currentSize;
                if(!this.mDidFillOnce) {
                    ++this.mLast;
                }

                v9 = this.mLast;
                v10 = this.mArrayIndices;
                if(v9 < v10.length) {
                    return;
                }

                this.mDidFillOnce = true;
                this.mLast = v10.length - 1;
            }
        }
        else {
        }
    }

    public final void clear() {
        int v3;
        int v0 = this.mHead;
        int v2 = 0;
        while(true) {
            v3 = -1;
            if(v0 != v3 && v2 < this.currentSize) {
                SolverVariable v3_1 = this.mCache.mIndexedVariables[this.mArrayIndices[v0]];
                if(v3_1 != null) {
                    v3_1.removeFromRow(this.mRow);
                }

                v0 = this.mArrayNextIndices[v0];
                ++v2;
                continue;
            }

            break;
        }

        this.mHead = v3;
        this.mLast = v3;
        this.mDidFillOnce = false;
        this.currentSize = 0;
    }

    public boolean contains(SolverVariable arg7) {
        int v0 = this.mHead;
        int v2 = -1;
        if(v0 == v2) {
            return 0;
        }

        int v3 = 0;
        while(v0 != v2) {
            if(v3 >= this.currentSize) {
                return 0;
            }

            if(this.mArrayIndices[v0] == arg7.id) {
                return 1;
            }
            else {
                v0 = this.mArrayNextIndices[v0];
                ++v3;
                continue;
            }

            return 0;
        }

        return 0;
    }

    public void display() {
        int v0 = this.currentSize;
        System.out.print("{ ");
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            SolverVariable v2 = this.getVariable(v1);
            if(v2 == null) {
            }
            else {
                System.out.print(v2 + " = " + this.getVariableValue(v1) + " ");
            }
        }

        System.out.println(" }");
    }

    public void divideByAmount(float arg5) {
        int v0 = this.mHead;
        int v1;
        for(v1 = 0; v0 != -1; ++v1) {
            if(v1 >= this.currentSize) {
                return;
            }

            this.mArrayValues[v0] /= arg5;
            v0 = this.mArrayNextIndices[v0];
        }
    }

    public final float get(SolverVariable arg5) {
        int v0 = this.mHead;
        int v1 = 0;
        while(v0 != -1) {
            if(v1 >= this.currentSize) {
                return 0;
            }

            if(this.mArrayIndices[v0] == arg5.id) {
                return this.mArrayValues[v0];
            }
            else {
                v0 = this.mArrayNextIndices[v0];
                ++v1;
                continue;
            }

            return 0;
        }

        return 0;
    }

    public int getCurrentSize() {
        return this.currentSize;
    }

    public int getHead() {
        return this.mHead;
    }

    public final int getId(int arg1) {
        return this.mArrayIndices[arg1];
    }

    public final int getNextIndice(int arg1) {
        return this.mArrayNextIndices[arg1];
    }

    SolverVariable getPivotCandidate() {
        SolverVariable v0 = this.candidate;
        if(v0 == null) {
            int v0_1 = this.mHead;
            int v1 = 0;
            SolverVariable v2 = null;
            while(v0_1 != -1) {
                if(v1 >= this.currentSize) {
                    return v2;
                }

                if(this.mArrayValues[v0_1] < 0f) {
                    SolverVariable v3 = this.mCache.mIndexedVariables[this.mArrayIndices[v0_1]];
                    if(v2 != null && v2.strength >= v3.strength) {
                        goto label_23;
                    }

                    v2 = v3;
                }

            label_23:
                v0_1 = this.mArrayNextIndices[v0_1];
                ++v1;
            }

            return v2;
        }

        return v0;
    }

    public final float getValue(int arg1) {
        return this.mArrayValues[arg1];
    }

    public SolverVariable getVariable(int arg4) {
        int v0 = this.mHead;
        int v1 = 0;
        while(v0 != -1) {
            if(v1 >= this.currentSize) {
                return null;
            }

            if(v1 == arg4) {
                return this.mCache.mIndexedVariables[this.mArrayIndices[v0]];
            }
            else {
                v0 = this.mArrayNextIndices[v0];
                ++v1;
                continue;
            }

            return null;
        }

        return null;
    }

    public float getVariableValue(int arg4) {
        int v0 = this.mHead;
        int v1 = 0;
        while(v0 != -1) {
            if(v1 >= this.currentSize) {
                return 0;
            }

            if(v1 == arg4) {
                return this.mArrayValues[v0];
            }
            else {
                v0 = this.mArrayNextIndices[v0];
                ++v1;
                continue;
            }

            return 0;
        }

        return 0;
    }

    boolean hasAtLeastOnePositiveVariable() {
        int v0 = this.mHead;
        int v2 = 0;
        while(v0 != -1) {
            if(v2 >= this.currentSize) {
                return 0;
            }

            if(this.mArrayValues[v0] > 0f) {
                return 1;
            }
            else {
                v0 = this.mArrayNextIndices[v0];
                ++v2;
                continue;
            }

            return 0;
        }

        return 0;
    }

    public int indexOf(SolverVariable arg6) {
        int v0 = this.mHead;
        int v1 = -1;
        if(v0 == v1) {
            return v1;
        }

        int v2 = 0;
        while(v0 != v1) {
            if(v2 >= this.currentSize) {
                return v1;
            }

            if(this.mArrayIndices[v0] == arg6.id) {
                return v0;
            }
            else {
                v0 = this.mArrayNextIndices[v0];
                ++v2;
                continue;
            }

            return v1;
        }

        return v1;
    }

    public void invert() {
        int v0 = this.mHead;
        int v1;
        for(v1 = 0; v0 != -1; ++v1) {
            if(v1 >= this.currentSize) {
                return;
            }

            this.mArrayValues[v0] *= -1f;
            v0 = this.mArrayNextIndices[v0];
        }
    }

    public final void put(SolverVariable arg9, float arg10) {
        int[] v6;
        int[] v4_1;
        int[] v10;
        int v9;
        if(Float.compare(arg10, 0f) == 0) {
            this.remove(arg9, true);
            return;
        }

        int v0 = this.mHead;
        int v3 = -1;
        if(v0 == v3) {
            this.mHead = 0;
            this.mArrayValues[0] = arg10;
            this.mArrayIndices[0] = arg9.id;
            this.mArrayNextIndices[this.mHead] = v3;
            ++arg9.usageInRowCount;
            arg9.addToRow(this.mRow);
            ++this.currentSize;
            if(!this.mDidFillOnce) {
                v9 = this.mLast + 1;
                this.mLast = v9;
                v10 = this.mArrayIndices;
                if(v9 >= v10.length) {
                    this.mDidFillOnce = true;
                    this.mLast = v10.length - 1;
                    return;
                }
            }
        }
        else {
            int v4 = 0;
            int v5 = v3;
            while(v0 != v3) {
                if(v4 >= this.currentSize) {
                    break;
                }

                if(this.mArrayIndices[v0] == arg9.id) {
                    this.mArrayValues[v0] = arg10;
                    return;
                }
                else {
                    if(this.mArrayIndices[v0] < arg9.id) {
                        v5 = v0;
                    }

                    v0 = this.mArrayNextIndices[v0];
                    ++v4;
                    continue;
                }

                break;
            }

            v0 = this.mLast;
            v4 = v0 + 1;
            if(this.mDidFillOnce) {
                v4_1 = this.mArrayIndices;
                if(v4_1[v0] == v3) {
                }
                else {
                    v0 = v4_1.length;
                }
            }
            else {
                v0 = v4;
            }

            v4_1 = this.mArrayIndices;
            if(v0 >= v4_1.length) {
                if(this.currentSize < v4_1.length) {
                    v4 = 0;
                    while(true) {
                        v6 = this.mArrayIndices;
                        if(v4 >= v6.length) {
                            break;
                        }
                        else if(v6[v4] == v3) {
                            v0 = v4;
                        }
                        else {
                            ++v4;
                            continue;
                        }

                        goto label_90;
                    }

                    v4_1 = v6;
                }
                else {
                }

                goto label_89;
            }
            else {
            label_89:
                v6 = v4_1;
            }

        label_90:
            if(v0 >= v6.length) {
                v0 = v6.length;
                v4 = this.ROW_SIZE * 2;
                this.ROW_SIZE = v4;
                this.mDidFillOnce = false;
                this.mLast = v0 - 1;
                this.mArrayValues = Arrays.copyOf(this.mArrayValues, v4);
                this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
                this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
            }

            this.mArrayIndices[v0] = arg9.id;
            this.mArrayValues[v0] = arg10;
            v10 = this.mArrayNextIndices;
            if(v5 != v3) {
                v10[v0] = v10[v5];
                v10[v5] = v0;
            }
            else {
                v10[v0] = this.mHead;
                this.mHead = v0;
            }

            ++arg9.usageInRowCount;
            arg9.addToRow(this.mRow);
            v9 = this.currentSize + 1;
            this.currentSize = v9;
            if(!this.mDidFillOnce) {
                ++this.mLast;
            }

            v10 = this.mArrayIndices;
            if(v9 >= v10.length) {
                this.mDidFillOnce = true;
            }

            if(this.mLast < v10.length) {
                return;
            }

            this.mDidFillOnce = true;
            this.mLast = v10.length - 1;
        }
    }

    public final float remove(SolverVariable arg9, boolean arg10) {
        if(this.candidate == arg9) {
            this.candidate = null;
        }

        int v0 = this.mHead;
        int v2 = -1;
        if(v0 == v2) {
            return 0;
        }

        int v3 = 0;
        int v4 = v2;
        while(v0 != v2) {
            if(v3 >= this.currentSize) {
                return 0;
            }

            if(this.mArrayIndices[v0] == arg9.id) {
                int v1 = this.mHead;
                int[] v3_1 = this.mArrayNextIndices;
                if(v0 == v1) {
                    this.mHead = v3_1[v0];
                }
                else {
                    v3_1[v4] = v3_1[v0];
                }

                if(arg10) {
                    arg9.removeFromRow(this.mRow);
                }

                --arg9.usageInRowCount;
                --this.currentSize;
                this.mArrayIndices[v0] = v2;
                if(this.mDidFillOnce) {
                    this.mLast = v0;
                }

                return this.mArrayValues[v0];
            }
            else {
                ++v3;
                v4 = v0;
                v0 = this.mArrayNextIndices[v0];
                continue;
            }

            return 0;
        }

        return 0;
    }

    public int sizeInBytes() {
        return this.mArrayIndices.length * 12 + 36;
    }

    public String toString() {
        int v0 = this.mHead;
        String v1 = "";
        int v2;
        for(v2 = 0; v0 != -1; ++v2) {
            if(v2 >= this.currentSize) {
                return v1;
            }

            v1 = v1 + " -> " + this.mArrayValues[v0] + " : " + this.mCache.mIndexedVariables[this.mArrayIndices[v0]];
            v0 = this.mArrayNextIndices[v0];
        }

        return v1;
    }

    public float use(ArrayRow arg6, boolean arg7) {
        float v0 = this.get(arg6.variable);
        this.remove(arg6.variable, arg7);
        ArrayRowVariables v6 = arg6.variables;
        int v1 = v6.getCurrentSize();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            SolverVariable v3 = v6.getVariable(v2);
            this.add(v3, v6.get(v3) * v0, arg7);
        }

        return v0;
    }
}

