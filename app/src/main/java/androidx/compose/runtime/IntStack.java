package androidx.compose.runtime;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000B\u001A\u00020\u0005H\u0002J\u000E\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0007J\u0006\u0010\u000F\u001A\u00020\u0007J\u000E\u0010\u0010\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u0007J\u000E\u0010\u0012\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u0007J\u0006\u0010\u0013\u001A\u00020\u0007J\u0006\u0010\u0014\u001A\u00020\u0007J\u000E\u0010\u0013\u001A\u00020\u00072\u0006\u0010\u0015\u001A\u00020\u0007J\t\u0010\u0016\u001A\u00020\u0017H\u0086\bJ\t\u0010\u0018\u001A\u00020\u0017H\u0086\bJ\u0006\u0010\u0019\u001A\u00020\rJ\u000E\u0010\u001A\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u0007R\u0012\u0010\u0004\u001A\u00020\u00058\u0000@\u0000X\u0081\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001A\u00020\u00078\u0000@\u0000X\u0081\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001A\u00020\u00078Æ\u0002¢\u0006\u0006\u001A\u0004\b\t\u0010\n¨\u0006\u001B"}, d2={"Landroidx/compose/runtime/IntStack;", "", "<init>", "()V", "slots", "", "tos", "", "size", "getSize", "()I", "resize", "push", "", "value", "pop", "popOr", "default", "peekOr", "peek", "peek2", "index", "isEmpty", "", "isNotEmpty", "clear", "indexOf", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class IntStack {
    public static final int $stable = 8;
    public int[] slots;
    public int tos;

    static {
    }

    public IntStack() {
        super();
        this.slots = new int[10];
    }

    public final void clear() {
        this.tos = 0;
    }

    public final int getSize() {
        return this.tos;
    }

    public final int indexOf(int arg4) {
        int[] v0 = this.slots;
        int v3 = Math.min(v0.length, this.tos);
        int v1;
        for(v1 = 0; v1 < v3; ++v1) {
            if(v0[v1] == arg4) {
                return v1;
            }
        }

        return -1;
    }

    public final boolean isEmpty() {
        if(this.tos == 0) {
            return 1;
        }

        return 0;
    }

    public final boolean isNotEmpty() {
        if(this.tos != 0) {
            return 1;
        }

        return 0;
    }

    public final int peek() {
        return this.slots[this.tos - 1];
    }

    public final int peek(int arg1) {
        return this.slots[arg1];
    }

    public final int peek2() {
        return this.slots[this.tos - 2];
    }

    public final int peekOr(int arg2) {
        int v0 = this.tos - 1;
        if(v0 >= 0) {
            return this.slots[v0];
        }

        return arg2;
    }

    public final int pop() {
        int[] v0 = this.slots;
        int v1 = this.tos - 1;
        this.tos = v1;
        return v0[v1];
    }

    public final int popOr(int arg2) {
        int v0 = this.tos;
        if(v0 > 0) {
            int[] v2 = this.slots;
            --v0;
            this.tos = v0;
            return v2[v0];
        }

        return arg2;
    }

    public final void push(int arg4) {
        int[] v0 = this.slots;
        if(this.tos >= v0.length) {
            v0 = this.resize();
        }

        int v1 = this.tos;
        this.tos = v1 + 1;
        v0[v1] = arg4;
    }

    private final int[] resize() {
        int[] v0 = Arrays.copyOf(this.slots, this.slots.length * 2);
        Intrinsics.checkNotNullExpressionValue(v0, "copyOf(...)");
        this.slots = v0;
        return v0;
    }
}

