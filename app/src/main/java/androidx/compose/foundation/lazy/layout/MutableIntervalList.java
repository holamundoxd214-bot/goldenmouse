package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001B\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00028\u0000¢\u0006\u0002\u0010\u0010J2\u0010\u0011\u001A\u00020\u000F2\u0006\u0010\u0012\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\t2\u0018\u0010\u0014\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\u000F0\u0015H\u0016J\u0017\u0010\u0016\u001A\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0017\u001A\u00020\tH\u0096\u0002J\u0016\u0010\u0018\u001A\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0019\u001A\u00020\tH\u0002J\u0011\u0010\u001A\u001A\u00020\u000F2\u0006\u0010\u0017\u001A\u00020\tH\u0082\bJ\u001A\u0010\u001B\u001A\u00020\u001C*\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0017\u001A\u00020\tH\u0002R\u001A\u0010\u0005\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\t@RX\u0096\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0016\u0010\r\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "T", "Landroidx/compose/foundation/lazy/layout/IntervalList;", "<init>", "()V", "intervals", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/IntervalList$Interval;", "value", "", "size", "getSize", "()I", "lastInterval", "addInterval", "", "(ILjava/lang/Object;)V", "forEach", "fromIndex", "toIndex", "block", "Lkotlin/Function1;", "get", "index", "getIntervalForIndex", "itemIndex", "checkIndexBounds", "contains", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MutableIntervalList implements IntervalList {
    public static final int $stable = 8;
    private final MutableVector intervals;
    private Interval lastInterval;
    private int size;

    static {
    }

    public MutableIntervalList() {
        super();
        this.intervals = new MutableVector(new Interval[16], 0);
    }

    public final void addInterval(int arg3, Object arg4) {
        int v0 = arg3 >= 0 ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("size should be >=0");
        }

        if(arg3 == 0) {
            return;
        }

        Interval v0_1 = new Interval(this.getSize(), arg3, arg4);
        this.size = this.getSize() + arg3;
        this.intervals.add(v0_1);
    }

    private final void checkIndexBounds(int arg3) {
        if(arg3 >= 0 && arg3 < this.getSize()) {
            return;
        }

        InlineClassHelperKt.throwIndexOutOfBoundsException("Index " + arg3 + ", size " + this.getSize());
    }

    private final boolean contains(Interval arg2, int arg3) {
        int v1 = arg2.getStartIndex();
        if(arg3 < arg2.getStartIndex() + arg2.getSize() && v1 <= arg3) {
            return 1;
        }

        return 0;
    }

    public void forEach(int arg5, int arg6, Function1 arg7) {
        String v0 = ", size ";
        String v1 = "Index ";
        if(arg5 < 0 || arg5 >= this.getSize()) {
            InlineClassHelperKt.throwIndexOutOfBoundsException(v1 + arg5 + v0 + this.getSize());
        }
        else {
        }

        if(arg6 < 0 || arg6 >= this.getSize()) {
            InlineClassHelperKt.throwIndexOutOfBoundsException(v1 + arg6 + v0 + this.getSize());
        }
        else {
        }

        int v1_1 = arg6 >= arg5 ? 1 : 0;
        if(v1_1 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("toIndex (" + arg6 + ") should be not smaller than fromIndex (" + arg5 + ')');
        }

        arg5 = IntervalListKt.binarySearch(this.intervals, arg5);
        v1_1 = this.intervals.content[arg5].getStartIndex();
        while(v1_1 <= arg6) {
            Object v2 = this.intervals.content[arg5];
            arg7.invoke(v2);
            v1_1 += ((Interval)v2).getSize();
            ++arg5;
        }
    }

    public Interval get(int arg3) {
        if(arg3 < 0 || arg3 >= this.getSize()) {
            InlineClassHelperKt.throwIndexOutOfBoundsException("Index " + arg3 + ", size " + this.getSize());
        }
        else {
        }

        return this.getIntervalForIndex(arg3);
    }

    private final Interval getIntervalForIndex(int arg3) {
        Interval v0 = this.lastInterval;
        if(v0 != null && (this.contains(v0, arg3))) {
            return v0;
        }

        Object v3 = this.intervals.content[IntervalListKt.binarySearch(this.intervals, arg3)];
        this.lastInterval = ((Interval)v3);
        return ((Interval)v3);
    }

    public int getSize() {
        return this.size;
    }
}

