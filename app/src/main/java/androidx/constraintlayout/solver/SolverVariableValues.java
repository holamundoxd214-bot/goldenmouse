package androidx.constraintlayout.solver;

import java.util.Arrays;

public class SolverVariableValues implements ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean HASH = true;
    private int HASH_SIZE;
    private final int NONE;
    private int SIZE;
    private static float epsilon = 0.001f;
    int head;
    int[] keys;
    protected final Cache mCache;
    int mCount;
    private final ArrayRow mRow;
    int[] next;
    int[] nextKeys;
    int[] previous;
    float[] values;
    int[] variables;

    static {
    }

    SolverVariableValues(ArrayRow arg4, Cache arg5) {
        super();
        this.NONE = -1;
        this.SIZE = 16;
        this.HASH_SIZE = 16;
        this.keys = new int[16];
        this.nextKeys = new int[16];
        this.variables = new int[16];
        this.values = new float[16];
        this.previous = new int[16];
        this.next = new int[16];
        this.mCount = 0;
        this.head = -1;
        this.mRow = arg4;
        this.mCache = arg5;
        this.clear();
    }

    public void add(SolverVariable arg5, float arg6, boolean arg7) {
        float v0 = SolverVariableValues.epsilon;
        if(arg6 <= -v0 || arg6 >= v0) {
            int v0_1 = this.indexOf(arg5);
            if(v0_1 == -1) {
                this.put(arg5, arg6);
                return;
            }
            else {
                float[] v1 = this.values;
                float v2 = v1[v0_1] + arg6;
                v1[v0_1] = v2;
                arg6 = SolverVariableValues.epsilon;
                if(v2 > -arg6 && v2 < arg6) {
                    v1[v0_1] = 0f;
                    this.remove(arg5, arg7);
                }
            }
        }
        else {
        }
    }

    private void addToHashMap(SolverVariable arg4, int arg5) {
        int[] v4_1;
        int v4 = arg4.id % this.HASH_SIZE;
        int[] v0 = this.keys;
        int v1 = v0[v4];
        int v2 = -1;
        if(v1 == v2) {
            v0[v4] = arg5;
        }
        else {
            while(true) {
                v4_1 = this.nextKeys;
                int v0_1 = v4_1[v1];
                if(v0_1 == v2) {
                    break;
                }

                v1 = v0_1;
            }

            v4_1[v1] = arg5;
        }

        this.nextKeys[arg5] = v2;
    }

    private void addVariable(int arg3, SolverVariable arg4, float arg5) {
        this.variables[arg3] = arg4.id;
        this.values[arg3] = arg5;
        this.previous[arg3] = -1;
        this.next[arg3] = -1;
        arg4.addToRow(this.mRow);
        ++arg4.usageInRowCount;
        ++this.mCount;
    }

    public void clear() {
        int v3_1;
        int v0 = this.mCount;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            SolverVariable v3 = this.getVariable(v2);
            if(v3 != null) {
                v3.removeFromRow(this.mRow);
            }
        }

        for(v0 = 0; true; ++v0) {
            v3_1 = -1;
            if(v0 >= this.SIZE) {
                break;
            }

            this.variables[v0] = v3_1;
            this.nextKeys[v0] = v3_1;
        }

        for(v0 = 0; v0 < this.HASH_SIZE; ++v0) {
            this.keys[v0] = v3_1;
        }

        this.mCount = 0;
        this.head = v3_1;
    }

    public boolean contains(SolverVariable arg1) {
        if(this.indexOf(arg1) != -1) {
            return 1;
        }

        return 0;
    }

    public void display() {
        int v0 = this.mCount;
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

    private void displayHash() {
        int v1;
        for(v1 = 0; v1 < this.HASH_SIZE; ++v1) {
            int v3 = -1;
            if(this.keys[v1] != v3) {
                String v2 = this.hashCode() + " hash [" + v1 + "] => ";
                int v4 = this.keys[v1];
                int v5 = 0;
                while(v5 == 0) {
                    v2 = v2 + " " + this.variables[v4];
                    int v6 = this.nextKeys[v4];
                    if(v6 != v3) {
                        v4 = v6;
                    }
                    else {
                        v5 = 1;
                    }
                }

                System.out.println(v2);
            }
        }
    }

    public void divideByAmount(float arg6) {
        int v0 = this.mCount;
        int v1 = this.head;
        int v2 = 0;
        while(v2 < v0) {
            this.values[v1] /= arg6;
            v1 = this.next[v1];
            if(v1 == -1) {
            }
            else {
                ++v2;
                continue;
            }

            return;
        }
    }

    private int findEmptySlot() {
        int v2;
        int v0;
        for(v0 = 0; true; ++v0) {
            v2 = -1;
            if(v0 >= this.SIZE) {
                return v2;
            }

            if(this.variables[v0] == v2) {
                return v0;
            }
        }

        return v2;
    }

    public float get(SolverVariable arg2) {
        int v2 = this.indexOf(arg2);
        if(v2 != -1) {
            return this.values[v2];
        }

        return 0;
    }

    public int getCurrentSize() {
        return this.mCount;
    }

    public SolverVariable getVariable(int arg7) {
        int v0 = this.mCount;
        SolverVariable v1 = null;
        if(v0 == 0) {
            return v1;
        }

        int v2 = this.head;
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            int v4 = -1;
            if(v3 == arg7 && v2 != v4) {
                return this.mCache.mIndexedVariables[this.variables[v2]];
            }

            v2 = this.next[v2];
            if(v2 == v4) {
                return v1;
            }
        }

        return v1;
    }

    public float getVariableValue(int arg5) {
        int v0 = this.mCount;
        int v1 = this.head;
        int v2 = 0;
        while(v2 < v0) {
            if(v2 == arg5) {
                return this.values[v1];
            }
            else {
                v1 = this.next[v1];
                if(v1 == -1) {
                }
                else {
                    ++v2;
                    continue;
                }
            }

            return 0;
        }

        return 0;
    }

    private void increaseSize() {
        int v0 = this.SIZE * 2;
        this.variables = Arrays.copyOf(this.variables, v0);
        this.values = Arrays.copyOf(this.values, v0);
        this.previous = Arrays.copyOf(this.previous, v0);
        this.next = Arrays.copyOf(this.next, v0);
        this.nextKeys = Arrays.copyOf(this.nextKeys, v0);
        int v1;
        for(v1 = this.SIZE; v1 < v0; ++v1) {
            this.variables[v1] = -1;
            this.nextKeys[v1] = -1;
        }

        this.SIZE = v0;
    }

    public int indexOf(SolverVariable arg4) {
        int v1 = -1;
        if(this.mCount == 0) {
            return v1;
        }

        int v4 = arg4.id;
        int v0 = this.keys[v4 % this.HASH_SIZE];
        if(v0 == v1) {
            return v1;
        }

        if(this.variables[v0] == v4) {
            return v0;
        }

        while(true) {
            v0 = this.nextKeys[v0];
            if(v0 != v1 && this.variables[v0] != v4) {
                continue;
            }

            break;
        }

        if(v0 == v1) {
            return v1;
        }

        if(this.variables[v0] == v4) {
            return v0;
        }

        return v1;
    }

    private void insertVariable(int arg5, SolverVariable arg6, float arg7) {
        int[] v2;
        int v0 = this.findEmptySlot();
        this.addVariable(v0, arg6, arg7);
        int[] v7 = this.previous;
        int v1 = -1;
        if(arg5 != v1) {
            v7[v0] = arg5;
            v2 = this.next;
            v2[v0] = v2[arg5];
            v2[arg5] = v0;
        }
        else {
            v7[v0] = v1;
            arg5 = this.mCount;
            v2 = this.next;
            if(arg5 > 0) {
                v2[v0] = this.head;
                this.head = v0;
            }
            else {
                v2[v0] = v1;
            }
        }

        arg5 = v2[v0];
        if(arg5 != v1) {
            v7[arg5] = v0;
        }

        this.addToHashMap(arg6, v0);
    }

    public void invert() {
        int v0 = this.mCount;
        int v1 = this.head;
        int v2 = 0;
        while(v2 < v0) {
            this.values[v1] *= -1f;
            v1 = this.next[v1];
            if(v1 == -1) {
            }
            else {
                ++v2;
                continue;
            }

            return;
        }
    }

    public void put(SolverVariable arg8, float arg9) {
        float v0 = SolverVariableValues.epsilon;
        if(Float.compare(arg9, -v0) > 0 && arg9 < v0) {
            this.remove(arg8, true);
            return;
        }

        int v1 = 0;
        if(this.mCount == 0) {
            this.addVariable(0, arg8, arg9);
            this.addToHashMap(arg8, 0);
            this.head = 0;
            return;
        }

        int v0_1 = this.indexOf(arg8);
        int v3 = -1;
        if(v0_1 != v3) {
            this.values[v0_1] = arg9;
            return;
        }

        if(this.mCount + 1 >= this.SIZE) {
            this.increaseSize();
        }

        v0_1 = this.mCount;
        int v2 = this.head;
        int v4 = v3;
        while(v1 < v0_1) {
            if(this.variables[v2] == arg8.id) {
                this.values[v2] = arg9;
                return;
            }
            else {
                if(this.variables[v2] < arg8.id) {
                    v4 = v2;
                }

                v2 = this.next[v2];
                if(v2 == v3) {
                    break;
                }

                ++v1;
                continue;
            }

            break;
        }

        this.insertVariable(v4, arg8, arg9);
    }

    public float remove(SolverVariable arg8, boolean arg9) {
        int v0 = this.indexOf(arg8);
        int v1 = -1;
        if(v0 == v1) {
            return 0;
        }

        this.removeFromHashMap(arg8);
        float v2 = this.values[v0];
        if(this.head == v0) {
            this.head = this.next[v0];
        }

        this.variables[v0] = v1;
        int[] v3 = this.previous;
        int v4 = v3[v0];
        if(v4 != v1) {
            this.next[v4] = this.next[v0];
        }

        v4 = this.next[v0];
        if(v4 != v1) {
            v3[v4] = v3[v0];
        }

        --this.mCount;
        --arg8.usageInRowCount;
        if(arg9) {
            arg8.removeFromRow(this.mRow);
        }

        return v2;
    }

    private void removeFromHashMap(SolverVariable arg6) {
        int v3;
        int[] v0_1;
        int v0 = arg6.id % this.HASH_SIZE;
        int v1 = this.keys[v0];
        int v2 = -1;
        if(v1 == v2) {
        }
        else {
            int v6 = arg6.id;
            if(this.variables[v1] == v6) {
                int[] v6_1 = this.keys;
                int[] v5 = this.nextKeys;
                v6_1[v0] = v5[v1];
                v5[v1] = v2;
                return;
            }

            while(true) {
                v0_1 = this.nextKeys;
                v3 = v0_1[v1];
                if(v3 != v2 && this.variables[v3] != v6) {
                    v1 = v3;
                    continue;
                }

                break;
            }

            if(v3 == v2) {
                return;
            }

            if(this.variables[v3] != v6) {
                return;
            }

            v0_1[v1] = v0_1[v3];
            v0_1[v3] = v2;
        }
    }

    public int sizeInBytes() {
        return 0;
    }

    public String toString() {
        String v0 = this.hashCode() + " { ";
        int v1 = this.mCount;
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            SolverVariable v3 = this.getVariable(v2);
            if(v3 == null) {
            }
            else {
                v0 = v0 + v3 + " = " + this.getVariableValue(v2) + " ";
                int v3_1 = this.indexOf(v3);
                v0 = v0 + "[p: ";
                String v5 = "none";
                int v6 = -1;
                v0 = this.previous[v3_1] != v6 ? v0 + this.mCache.mIndexedVariables[this.variables[this.previous[v3_1]]] : v0 + v5;
                v0 = v0 + ", n: ";
                v0 = this.next[v3_1] != v6 ? v0 + this.mCache.mIndexedVariables[this.variables[this.next[v3_1]]] : v0 + v5;
                v0 = v0 + "]";
            }
        }

        return v0 + " }";
    }

    public float use(ArrayRow arg8, boolean arg9) {
        float v0 = this.get(arg8.variable);
        this.remove(arg8.variable, arg9);
        ArrayRowVariables v8 = arg8.variables;
        int v1 = ((SolverVariableValues)v8).getCurrentSize();
        int v2 = 0;
        int v3;
        for(v3 = 0; v2 < v1; ++v3) {
            if(((SolverVariableValues)v8).variables[v3] != -1) {
                this.add(this.mCache.mIndexedVariables[((SolverVariableValues)v8).variables[v3]], ((SolverVariableValues)v8).values[v3] * v0, arg9);
                ++v2;
            }
        }

        return v0;
    }
}

