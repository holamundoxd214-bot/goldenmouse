package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\t\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u0003H\u0086\u0002J\u0010\u0010\u000E\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u0007H\u0002J&\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00032\u0006\u0010\u0012\u001A\u00020\u00032\u0006\u0010\u0013\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\u0003J\u001E\u0010\u0015\u001A\u00020\u00102\u0006\u0010\u0016\u001A\u00020\u00032\u0006\u0010\u0017\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\u0003J\u0006\u0010\u0018\u001A\u00020\u0003J\u0006\u0010\u0019\u001A\u00020\u001AJ\u0006\u0010\u001B\u001A\u00020\u0010J \u0010\u001C\u001A\u00020\u00102\u0006\u0010\u001D\u001A\u00020\u00032\u0006\u0010\u001E\u001A\u00020\u00032\u0006\u0010\u001F\u001A\u00020\u0003H\u0002J \u0010 \u001A\u00020\u00032\u0006\u0010\u001D\u001A\u00020\u00032\u0006\u0010\u001E\u001A\u00020\u00032\u0006\u0010\u001F\u001A\u00020\u0003H\u0002J\u0018\u0010!\u001A\u00020\u00102\u0006\u0010\"\u001A\u00020\u00032\u0006\u0010#\u001A\u00020\u0003H\u0002J\u0018\u0010$\u001A\u00020\u001A2\u0006\u0010%\u001A\u00020\u00032\u0006\u0010&\u001A\u00020\u0003H\u0002R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u000B\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\f\u0010\r¨\u0006\'"}, d2={"Landroidx/compose/ui/node/IntStack;", "", "initialCapacity", "", "<init>", "(I)V", "stack", "", "lastIndex", "get", "index", "size", "getSize", "()I", "resizeStack", "pushRange", "", "oldStart", "oldEnd", "newStart", "newEnd", "pushDiagonal", "x", "y", "pop", "isNotEmpty", "", "sortDiagonals", "quickSort", "start", "end", "elSize", "partition", "swapDiagonal", "i", "j", "compareDiagonal", "a", "b", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class IntStack {
    private int lastIndex;
    private int[] stack;

    public IntStack(int arg1) {
        super();
        this.stack = new int[arg1];
    }

    private final boolean compareDiagonal(int arg4, int arg5) {
        int[] v3 = this.stack;
        int v0 = v3[arg4];
        int v1 = v3[arg5];
        if(v0 >= v1 && (v0 != v1 || v3[arg4 + 1] > v3[arg5 + 1])) {
            return 0;
        }

        return 1;
    }

    public final int get(int arg1) {
        return this.stack[arg1];
    }

    public final int getSize() {
        return this.lastIndex;
    }

    public final boolean isNotEmpty() {
        if(this.lastIndex != 0) {
            return 1;
        }

        return 0;
    }

    private final int partition(int arg3, int arg4, int arg5) {
        int v0 = arg3 - arg5;
        while(arg3 < arg4) {
            if(this.compareDiagonal(arg3, arg4)) {
                v0 += arg5;
                this.swapDiagonal(v0, arg3);
            }

            arg3 += arg5;
        }

        v0 += arg5;
        this.swapDiagonal(v0, arg4);
        return v0;
    }

    public final int pop() {
        int[] v0 = this.stack;
        int v1 = this.lastIndex - 1;
        this.lastIndex = v1;
        return v0[v1];
    }

    public final void pushDiagonal(int arg5, int arg6, int arg7) {
        int v0 = this.lastIndex;
        int[] v1 = this.stack;
        int v2 = v0 + 3;
        if(v2 >= v1.length) {
            v1 = this.resizeStack(v1);
        }

        v1[v0] = arg5 + arg7;
        v1[v0 + 1] = arg6 + arg7;
        v1[v0 + 2] = arg7;
        this.lastIndex = v2;
    }

    public final void pushRange(int arg5, int arg6, int arg7, int arg8) {
        int v0 = this.lastIndex;
        int[] v1 = this.stack;
        int v2 = v0 + 4;
        if(v2 >= v1.length) {
            v1 = this.resizeStack(v1);
        }

        v1[v0] = arg5;
        v1[v0 + 1] = arg6;
        v1[v0 + 2] = arg7;
        v1[v0 + 3] = arg8;
        this.lastIndex = v2;
    }

    private final void quickSort(int arg3, int arg4, int arg5) {
        if(arg3 < arg4) {
            int v0 = this.partition(arg3, arg4, arg5);
            this.quickSort(arg3, v0 - arg5, arg5);
            this.quickSort(v0 + arg5, arg4, arg5);
        }
    }

    private final int[] resizeStack(int[] arg2) {
        arg2 = Arrays.copyOf(arg2, arg2.length * 2);
        Intrinsics.checkNotNullExpressionValue(arg2, "copyOf(...)");
        this.stack = arg2;
        return arg2;
    }

    public final void sortDiagonals() {
        int v0 = this.lastIndex;
        int v1 = v0 % 3 == 0 ? 1 : 0;
        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalStateException("Array size not a multiple of 3");
        }

        v1 = 3;
        if(v0 > v1) {
            this.quickSort(0, v0 - v1, v1);
        }
    }

    private final void swapDiagonal(int arg3, int arg4) {
        int[] v2 = this.stack;
        MyersDiffKt.access$swap(v2, arg3, arg4);
        MyersDiffKt.access$swap(v2, arg3 + 1, arg4 + 1);
        MyersDiffKt.access$swap(v2, arg3 + 2, arg4 + 2);
    }
}

