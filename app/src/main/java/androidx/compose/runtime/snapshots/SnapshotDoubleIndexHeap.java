package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000E\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\u0011\u001A\u00060\u0012j\u0002`\u00132\f\b\u0002\u0010\u0014\u001A\u00060\u0012j\u0002`\u0013¢\u0006\u0002\u0010\u0015J\u0017\u0010\u0016\u001A\u00020\u00052\n\u0010\u0004\u001A\u00060\u0012j\u0002`\u0013¢\u0006\u0002\u0010\u0017J\u000E\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u0005J\b\u0010\u001B\u001A\u00020\u0019H\u0007J!\u0010\u001C\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u00052\n\u0010\u0004\u001A\u00060\u0012j\u0002`\u0013H\u0007¢\u0006\u0002\u0010\u001DJ\u0010\u0010\u001E\u001A\u00020\u00192\u0006\u0010\r\u001A\u00020\u0005H\u0002J\u0010\u0010\u001F\u001A\u00020\u00192\u0006\u0010\r\u001A\u00020\u0005H\u0002J\u0018\u0010 \u001A\u00020\u00192\u0006\u0010!\u001A\u00020\u00052\u0006\u0010\"\u001A\u00020\u0005H\u0002J\u0010\u0010#\u001A\u00020\u00192\u0006\u0010$\u001A\u00020\u0005H\u0002J\b\u0010%\u001A\u00020\u0005H\u0002J\u0010\u0010&\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u0005H\u0002R\u001E\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u0005@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001A\u00060\nj\u0002`\u000BX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\fR\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\'"}, d2={"Landroidx/compose/runtime/snapshots/SnapshotDoubleIndexHeap;", "", "<init>", "()V", "value", "", "size", "getSize", "()I", "values", "", "Landroidx/compose/runtime/snapshots/SnapshotIdArray;", "[J", "index", "", "handles", "firstFreeHandle", "lowestOrDefault", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "default", "(J)J", "add", "(J)I", "remove", "", "handle", "validate", "validateHandle", "(IJ)V", "shiftUp", "shiftDown", "swap", "a", "b", "ensure", "atLeast", "allocateHandle", "freeHandle", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SnapshotDoubleIndexHeap {
    public static final int $stable = 8;
    private int firstFreeHandle;
    private int[] handles;
    private int[] index;
    private int size;
    private long[] values;

    static {
    }

    public SnapshotDoubleIndexHeap() {
        super();
        int v0 = 16;
        this.values = SnapshotId_jvmKt.snapshotIdArrayWithCapacity(v0);
        this.index = new int[v0];
        int[] v1 = new int[v0];
        int v2;
        for(v2 = 0; v2 < v0; v2 = v3) {
            int v3 = v2 + 1;
            v1[v2] = v3;
        }

        this.handles = v1;
    }

    public final int add(long arg4) {
        this.ensure(this.size + 1);
        int v0 = this.size;
        this.size = v0 + 1;
        int v1 = this.allocateHandle();
        this.values[v0] = arg4;
        this.index[v0] = v1;
        this.handles[v1] = v0;
        this.shiftUp(v0);
        return v1;
    }

    private final int allocateHandle() {
        int[] v0 = this.handles;
        int v1 = v0.length;
        if(this.firstFreeHandle >= v1) {
            v1 *= 2;
            int[] v3 = new int[v1];
            int v0_1;
            for(v0_1 = 0; v0_1 < v1; v0_1 = v2) {
                int v2 = v0_1 + 1;
                v3[v0_1] = v2;
            }

            ArraysKt.copyInto$default(this.handles, v3, 0, 0, 0, 14, null);
            this.handles = v3;
            v0 = v3;
        }

        v1 = this.firstFreeHandle;
        this.firstFreeHandle = v0[v1];
        return v1;
    }

    private final void ensure(int arg11) {
        int v0 = this.values.length;
        if(arg11 <= v0) {
            return;
        }

        v0 *= 2;
        long[] v2 = SnapshotId_jvmKt.snapshotIdArrayWithCapacity(v0);
        int[] v11 = new int[v0];
        ArraysKt.copyInto$default(this.values, v2, 0, 0, 0, 12, null);
        ArraysKt.copyInto$default(this.index, v11, 0, 0, 0, 14, null);
        this.values = v2;
        this.index = v11;
    }

    private final void freeHandle(int arg3) {
        this.handles[arg3] = this.firstFreeHandle;
        this.firstFreeHandle = arg3;
    }

    public final int getSize() {
        return this.size;
    }

    public final long lowestOrDefault(long arg2) {
        if(this.size > 0) {
            arg2 = this.values[0];
        }

        return arg2;
    }

    public static long lowestOrDefault$default(SnapshotDoubleIndexHeap arg0, long arg1, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = 0;
        }

        return arg0.lowestOrDefault(arg1);
    }

    public final void remove(int arg3) {
        int v0 = this.handles[arg3];
        this.swap(v0, this.size - 1);
        --this.size;
        this.shiftUp(v0);
        this.shiftDown(v0);
        this.freeHandle(arg3);
    }

    private final void shiftDown(int arg9) {
        long[] v0 = this.values;
        int v1 = this.size >> 1;
        while(arg9 < v1) {
            int v2 = arg9 + 1 << 1;
            int v3 = v2 - 1;
            if(v2 < this.size && Intrinsics.compare(v0[v2], v0[v3]) < 0) {
                if(Intrinsics.compare(v0[v2], v0[arg9]) < 0) {
                    this.swap(v2, arg9);
                    arg9 = v2;
                    continue;
                }
                else {
                    return;
                }
            }

            if(Intrinsics.compare(v0[v3], v0[arg9]) >= 0) {
                return;
            }

            this.swap(v3, arg9);
            arg9 = v3;
        }
    }

    private final void shiftUp(int arg7) {
        long[] v0 = this.values;
        long v1 = v0[arg7];
        while(arg7 > 0) {
            int v3 = (arg7 + 1 >> 1) - 1;
            if(Intrinsics.compare(v0[v3], v1) <= 0) {
                return;
            }

            this.swap(v3, arg7);
            arg7 = v3;
        }
    }

    private final void swap(int arg7, int arg8) {
        long[] v0 = this.values;
        int[] v1 = this.index;
        int[] v6 = this.handles;
        long v2 = v0[arg7];
        v0[arg7] = v0[arg8];
        v0[arg8] = v2;
        int v0_1 = v1[arg7];
        int v2_1 = v1[arg8];
        v1[arg7] = v2_1;
        v1[arg8] = v0_1;
        v6[v2_1] = arg7;
        v6[v0_1] = arg8;
    }

    public final void validate() {
        int v0 = this.size;
        int v2;
        for(v2 = 1; true; v2 = v3) {
            if(v2 >= v0) {
                return;
            }

            int v3 = v2 + 1;
            if(Intrinsics.compare(this.values[(v3 >> 1) - 1], this.values[v2]) > 0) {
                break;
            }
        }

        throw new IllegalStateException("Index " + v2 + " is out of place".toString());
    }

    public final void validateHandle(int arg5, long arg6) {
        int v0 = this.handles[arg5];
        if(this.index[v0] == arg5) {
            if(this.values[v0] == arg6) {
                return;
            }

            throw new IllegalStateException("Value for handle " + arg5 + " was " + this.values[v0] + " but was supposed to be " + arg6.toString());
        }

        throw new IllegalStateException("Index for handle " + arg5 + " is corrupted".toString());
    }
}

