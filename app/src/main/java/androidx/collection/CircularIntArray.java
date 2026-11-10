package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000E\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0003J\u000E\u0010\u0012\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0003J\u0006\u0010\u0013\u001A\u00020\u0010J\b\u0010\u0014\u001A\u00020\u0010H\u0002J\u0011\u0010\u0015\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u0003H\u0086\u0002J\u0006\u0010\u0017\u001A\u00020\u0018J\u0006\u0010\u0019\u001A\u00020\u0003J\u0006\u0010\u001A\u001A\u00020\u0003J\u000E\u0010\u001B\u001A\u00020\u00102\u0006\u0010\u001C\u001A\u00020\u0003J\u000E\u0010\u001D\u001A\u00020\u00102\u0006\u0010\u001C\u001A\u00020\u0003J\u0006\u0010\u001E\u001A\u00020\u0003R\u000E\u0010\u0005\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u000E\u0010\u000B\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\r\u0010\nR\u000E\u0010\u000E\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2={"Landroidx/collection/CircularIntArray;", "", "minCapacity", "", "(I)V", "capacityBitmask", "elements", "", "first", "getFirst", "()I", "head", "last", "getLast", "tail", "addFirst", "", "element", "addLast", "clear", "doubleCapacity", "get", "index", "isEmpty", "", "popFirst", "popLast", "removeFromEnd", "count", "removeFromStart", "size", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) public final class CircularIntArray {
    private int capacityBitmask;
    private int[] elements;
    private int head;
    private int tail;

    public CircularIntArray() {
        this(0, 1, null);
    }

    public CircularIntArray(int arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 8;
        }

        this(arg1);
    }

    public CircularIntArray(int arg4) {
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
        this.elements = new int[arg4];
    }

    public final void addFirst(int arg3) {
        int v0 = this.head - 1 & this.capacityBitmask;
        this.head = v0;
        this.elements[v0] = arg3;
        if(v0 == this.tail) {
            this.doubleCapacity();
        }
    }

    public final void addLast(int arg3) {
        int[] v0 = this.elements;
        int v1 = this.tail;
        v0[v1] = arg3;
        arg3 = this.capacityBitmask & v1 + 1;
        this.tail = arg3;
        if(arg3 == this.head) {
            this.doubleCapacity();
        }
    }

    public final void clear() {
        this.tail = this.head;
    }

    private final void doubleCapacity() {
        int[] v0 = this.elements;
        int v1 = v0.length;
        int v2 = this.head;
        int v3 = v1 - v2;
        int v4 = v1 << 1;
        if(v4 >= 0) {
            int[] v5 = new int[v4];
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

    public final int get(int arg3) {
        if(arg3 >= 0 && arg3 < this.size()) {
            return this.elements[this.capacityBitmask & this.head + arg3];
        }

        throw new ArrayIndexOutOfBoundsException();
    }

    public final int getFirst() {
        int v0 = this.head;
        if(v0 != this.tail) {
            return this.elements[v0];
        }

        throw new ArrayIndexOutOfBoundsException();
    }

    public final int getLast() {
        int v0 = this.head;
        int v1 = this.tail;
        if(v0 != v1) {
            return this.elements[this.capacityBitmask & v1 - 1];
        }

        throw new ArrayIndexOutOfBoundsException();
    }

    public final boolean isEmpty() {
        if(this.head == this.tail) {
            return 1;
        }

        return 0;
    }

    public final int popFirst() {
        int v0 = this.head;
        if(v0 != this.tail) {
            int v1 = this.elements[v0];
            this.head = v0 + 1 & this.capacityBitmask;
            return v1;
        }

        throw new ArrayIndexOutOfBoundsException();
    }

    public final int popLast() {
        int v0 = this.head;
        int v1 = this.tail;
        if(v0 != v1) {
            v0 = this.capacityBitmask & v1 - 1;
            v1 = this.elements[v0];
            this.tail = v0;
            return v1;
        }

        throw new ArrayIndexOutOfBoundsException();
    }

    public final void removeFromEnd(int arg2) {
        if(arg2 <= 0) {
            return;
        }

        if(arg2 <= this.size()) {
            this.tail = this.capacityBitmask & this.tail - arg2;
            return;
        }

        throw new ArrayIndexOutOfBoundsException();
    }

    public final void removeFromStart(int arg2) {
        if(arg2 <= 0) {
            return;
        }

        if(arg2 <= this.size()) {
            this.head = this.capacityBitmask & this.head + arg2;
            return;
        }

        throw new ArrayIndexOutOfBoundsException();
    }

    public final int size() {
        return this.capacityBitmask & this.tail - this.head;
    }
}

