package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00028\u0000¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00028\u0000¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0016\u001A\u00020\u0012J\b\u0010\u0017\u001A\u00020\u0012H\u0002J\u0016\u0010\u0018\u001A\u00028\u00002\u0006\u0010\u0019\u001A\u00020\u0004H\u0086\u0002¢\u0006\u0002\u0010\u001AJ\u0006\u0010\u001B\u001A\u00020\u001CJ\u000B\u0010\u001D\u001A\u00028\u0000¢\u0006\u0002\u0010\fJ\u000B\u0010\u001E\u001A\u00028\u0000¢\u0006\u0002\u0010\fJ\u000E\u0010\u001F\u001A\u00020\u00122\u0006\u0010 \u001A\u00020\u0004J\u000E\u0010!\u001A\u00020\u00122\u0006\u0010 \u001A\u00020\u0004J\u0006\u0010\"\u001A\u00020\u0004R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\bX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\tR\u0011\u0010\n\u001A\u00028\u00008F¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u000E\u0010\r\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u000E\u001A\u00028\u00008F¢\u0006\u0006\u001A\u0004\b\u000F\u0010\fR\u000E\u0010\u0010\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006#"}, d2={"Landroidx/collection/CircularArray;", "E", "", "minCapacity", "", "(I)V", "capacityBitmask", "elements", "", "[Ljava/lang/Object;", "first", "getFirst", "()Ljava/lang/Object;", "head", "last", "getLast", "tail", "addFirst", "", "element", "(Ljava/lang/Object;)V", "addLast", "clear", "doubleCapacity", "get", "index", "(I)Ljava/lang/Object;", "isEmpty", "", "popFirst", "popLast", "removeFromEnd", "count", "removeFromStart", "size", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) public final class CircularArray {
    private int capacityBitmask;
    private Object[] elements;
    private int head;
    private int tail;

    public CircularArray() {
        this(0, 1, null);
    }

    public CircularArray(int arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 8;
        }

        this(arg1);
    }

    public CircularArray(int arg4) {
        super();
        int v0 = 0;
        int v2 = arg4 >= 1 ? 1 : 0;
        if(v2 == 0) {
            RuntimeHelpersKt.throwIllegalArgumentException("capacity must be >= 1");
        }

        if(arg4 <= 0x40000000) {
            v0 = 1;
        }

        if(v0 == 0) {
            RuntimeHelpersKt.throwIllegalArgumentException("capacity must be <= 2^30");
        }

        if(Integer.bitCount(arg4) != 1) {
            arg4 = Integer.highestOneBit(arg4 - 1) << 1;
        }

        this.capacityBitmask = arg4 - 1;
        this.elements = new Object[arg4];
    }

    public final void addFirst(Object arg3) {
        int v0 = this.head - 1 & this.capacityBitmask;
        this.head = v0;
        this.elements[v0] = arg3;
        if(v0 == this.tail) {
            this.doubleCapacity();
        }
    }

    public final void addLast(Object arg3) {
        Object[] v0 = this.elements;
        int v1 = this.tail;
        v0[v1] = arg3;
        int v3 = this.capacityBitmask & v1 + 1;
        this.tail = v3;
        if(v3 == this.head) {
            this.doubleCapacity();
        }
    }

    public final void clear() {
        this.removeFromStart(this.size());
    }

    private final void doubleCapacity() {
        Object[] v0 = this.elements;
        int v1 = v0.length;
        int v2 = this.head;
        int v3 = v1 - v2;
        int v4 = v1 << 1;
        if(v4 >= 0) {
            Object[] v5 = new Object[v4];
            ArraysKt.copyInto(v0, v5, 0, v2, v1);
            ArraysKt.copyInto(this.elements, v5, v3, 0, this.head);
            this.elements = v5;
            this.head = 0;
            this.tail = v1;
            this.capacityBitmask = v4 - 1;
            return;
        }

        throw new RuntimeException("Max array capacity exceeded");
    }

    public final Object get(int arg3) {
        if(arg3 >= 0 && arg3 < this.size()) {
            Object v2 = this.elements[this.capacityBitmask & this.head + arg3];
            Intrinsics.checkNotNull(v2);
            return v2;
        }

        throw new ArrayIndexOutOfBoundsException();
    }

    public final Object getFirst() {
        int v0 = this.head;
        if(v0 != this.tail) {
            Object v2 = this.elements[v0];
            Intrinsics.checkNotNull(v2);
            return v2;
        }

        throw new ArrayIndexOutOfBoundsException();
    }

    public final Object getLast() {
        int v0 = this.head;
        int v1 = this.tail;
        if(v0 != v1) {
            Object v2 = this.elements[this.capacityBitmask & v1 - 1];
            Intrinsics.checkNotNull(v2);
            return v2;
        }

        throw new ArrayIndexOutOfBoundsException();
    }

    public final boolean isEmpty() {
        if(this.head == this.tail) {
            return 1;
        }

        return 0;
    }

    public final Object popFirst() {
        int v0 = this.head;
        if(v0 != this.tail) {
            Object[] v1 = this.elements;
            Object v2 = v1[v0];
            v1[v0] = null;
            this.head = v0 + 1 & this.capacityBitmask;
            return v2;
        }

        throw new ArrayIndexOutOfBoundsException();
    }

    public final Object popLast() {
        int v0 = this.head;
        int v1 = this.tail;
        if(v0 != v1) {
            v0 = this.capacityBitmask & v1 - 1;
            Object[] v1_1 = this.elements;
            Object v2 = v1_1[v0];
            v1_1[v0] = null;
            this.tail = v0;
            return v2;
        }

        throw new ArrayIndexOutOfBoundsException();
    }

    public final void removeFromEnd(int arg6) {
        Object v3;
        if(arg6 <= 0) {
        }
        else if(arg6 <= this.size()) {
            int v0 = this.tail;
            int v1 = arg6 < v0 ? v0 - arg6 : 0;
            int v2;
            for(v2 = v1; true; ++v2) {
                v3 = null;
                if(v2 >= v0) {
                    break;
                }

                this.elements[v2] = v3;
            }

            v1 = this.tail - v1;
            arg6 -= v1;
            this.tail -= v1;
            if(arg6 <= 0) {
                return;
            }

            v0 = this.elements.length;
            this.tail = v0;
            arg6 = v0 - arg6;
            for(v1 = arg6; v1 < v0; ++v1) {
                this.elements[v1] = v3;
            }

            this.tail = arg6;
        }
        else {
            goto label_34;
        }

        return;
    label_34:
        throw new ArrayIndexOutOfBoundsException();
    }

    public final void removeFromStart(int arg5) {
        Object v2;
        if(arg5 <= 0) {
        }
        else if(arg5 <= this.size()) {
            int v0 = this.elements.length;
            int v1 = this.head;
            if(arg5 < v0 - v1) {
                v0 = v1 + arg5;
            }

            while(true) {
                v2 = null;
                if(v1 >= v0) {
                    break;
                }

                this.elements[v1] = v2;
                ++v1;
            }

            v0 -= this.head;
            arg5 -= v0;
            this.head = this.capacityBitmask & this.head + v0;
            if(arg5 <= 0) {
                return;
            }

            for(v0 = 0; v0 < arg5; ++v0) {
                this.elements[v0] = v2;
            }

            this.head = arg5;
        }
        else {
            goto label_32;
        }

        return;
    label_32:
        throw new ArrayIndexOutOfBoundsException();
    }

    public final int size() {
        return this.capacityBitmask & this.tail - this.head;
    }
}

