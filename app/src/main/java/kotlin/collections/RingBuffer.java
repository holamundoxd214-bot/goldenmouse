package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010(\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B!\bF\u0012\u000E\u0010\u0005\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BB\u0011\bV\u0012\u0006\u0010\f\u001A\u00020\t¢\u0006\u0004\b\n\u0010\rJ\u0017\u0010\u0014\u001A\u00028\u00002\u0006\u0010\u0015\u001A\u00020\tH\u0096\u0082\u0004¢\u0006\u0002\u0010\u0016J\n\u0010\u0017\u001A\u00020\u0018H\u0086\u0080\u0004J\u0010\u0010\u0019\u001A\b\u0012\u0004\u0012\u00028\u00000\u001AH\u0096\u0082\u0004J)\u0010\u001B\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\u0004\b\u0001\u0010\u00012\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0094\u0080\u0004¢\u0006\u0002\u0010\u001DJ\u0017\u0010\u001B\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0094\u0080\u0004¢\u0006\u0002\u0010\u001EJ\u0018\u0010\u001F\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010 \u001A\u00020\tH\u0086\u0080\u0004J\u0017\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00028\u0000H\u0086\u0080\u0004¢\u0006\u0002\u0010$J\u0012\u0010%\u001A\u00020\"2\u0006\u0010&\u001A\u00020\tH\u0086\u0080\u0004J\u0016\u0010\'\u001A\u00020\t*\u00020\t2\u0006\u0010&\u001A\u00020\tH\u0082\u0088\u0004R\u0019\u0010\u0005\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\u000ER\u000F\u0010\f\u001A\u00020\tX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u000F\u001A\u00020\tX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u001F\u0010\u0011\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\t@RX\u0096\u008E\b¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013¨\u0006("}, d2={"Lkotlin/collections/RingBuffer;", "T", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "buffer", "", "", "filledSize", "", "<init>", "([Ljava/lang/Object;I)V", "capacity", "(I)V", "[Ljava/lang/Object;", "startIndex", "value", "size", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "isFull", "", "iterator", "", "toArray", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "expanded", "maxCapacity", "add", "", "element", "(Ljava/lang/Object;)V", "removeFirst", "n", "forward", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class RingBuffer extends AbstractList implements RandomAccess {
    private final Object[] buffer;
    private final int capacity;
    private int size;
    private int startIndex;

    public RingBuffer(int arg2) {
        this(new Object[arg2], 0);
    }

    public RingBuffer(Object[] arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "buffer");
        super();
        this.buffer = arg2;
        if(arg3 >= 0) {
            if(arg3 <= arg2.length) {
                this.capacity = arg2.length;
                this.size = arg3;
                return;
            }

            throw new IllegalArgumentException("ring buffer filled size: " + arg3 + " cannot be larger than the buffer size: " + arg2.length.toString());
        }

        throw new IllegalArgumentException("ring buffer filled size should not be negative but it is " + arg3.toString());
    }

    public static final Object[] access$getBuffer$p(RingBuffer arg0) {
        return arg0.buffer;
    }

    public static final int access$getCapacity$p(RingBuffer arg0) {
        return arg0.capacity;
    }

    public static final int access$getStartIndex$p(RingBuffer arg0) {
        return arg0.startIndex;
    }

    public final void add(Object arg4) {
        if(!this.isFull()) {
            this.buffer[(this.startIndex + this.size()) % this.capacity] = arg4;
            this.size = this.size() + 1;
            return;
        }

        throw new IllegalStateException("ring buffer is full");
    }

    public final RingBuffer expanded(int arg3) {
        Object[] v3;
        arg3 = RangesKt.coerceAtMost(this.capacity + (this.capacity >> 1) + 1, arg3);
        if(this.startIndex == 0) {
            v3 = Arrays.copyOf(this.buffer, arg3);
            Intrinsics.checkNotNullExpressionValue(v3, "copyOf(...)");
        }
        else {
            v3 = this.toArray(new Object[arg3]);
        }

        return new RingBuffer(v3, this.size());
    }

    private final int forward(int arg1, int arg2) {
        return (arg1 + arg2) % this.capacity;
    }

    public Object get(int arg3) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(arg3, this.size());
        return this.buffer[(this.startIndex + arg3) % this.capacity];
    }

    public int getSize() {
        return this.size;
    }

    public final boolean isFull() {
        if(this.size() == this.capacity) {
            return 1;
        }

        return 0;
    }

    public Iterator iterator() {
        return new RingBuffer$iterator$1(this);
    }

    public final void removeFirst(int arg6) {
        if(arg6 >= 0) {
            if(arg6 <= this.size()) {
                if(arg6 > 0) {
                    int v0 = this.startIndex;
                    int v1 = (v0 + arg6) % this.capacity;
                    Object[] v2 = this.buffer;
                    Object v3 = null;
                    if(v0 > v1) {
                        ArraysKt.fill(v2, v3, v0, this.capacity);
                        ArraysKt.fill(this.buffer, v3, 0, v1);
                    }
                    else {
                        ArraysKt.fill(v2, v3, v0, v1);
                    }

                    this.startIndex = v1;
                    this.size = this.size() - arg6;
                }

                return;
            }

            throw new IllegalArgumentException("n shouldn\'t be greater than the buffer size: n = " + arg6 + ", size = " + this.size().toString());
        }

        throw new IllegalArgumentException("n shouldn\'t be negative but it is " + arg6.toString());
    }

    public Object[] toArray(Object[] arg6) {
        Intrinsics.checkNotNullParameter(arg6, "array");
        if(arg6.length < this.size()) {
            arg6 = Arrays.copyOf(arg6, this.size());
            Intrinsics.checkNotNullExpressionValue(arg6, "copyOf(...)");
        }

        int v0 = this.size();
        int v1 = this.startIndex;
        int v2 = 0;
        int v3 = 0;
        while(v3 < v0) {
            if(v1 >= this.capacity) {
                break;
            }

            arg6[v3] = this.buffer[v1];
            ++v3;
            ++v1;
        }

        while(v3 < v0) {
            arg6[v3] = this.buffer[v2];
            ++v3;
            ++v2;
        }

        return CollectionsKt.terminateCollectionToArray(v0, arg6);
    }

    public Object[] toArray() {
        return this.toArray(new Object[this.size()]);
    }
}

