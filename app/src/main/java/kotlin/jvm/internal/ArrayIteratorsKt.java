package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.collections.BooleanIterator;
import kotlin.collections.ByteIterator;
import kotlin.collections.CharIterator;
import kotlin.collections.DoubleIterator;
import kotlin.collections.FloatIterator;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.collections.ShortIterator;

@Metadata(d1={"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0002\u0018\u0002\n\u0002\u0010\u0017\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0018\n\u0000\u001A\u0012\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0086\u0080\u0004\u001A\u0012\u0010\u0000\u001A\u00020\u00042\u0006\u0010\u0002\u001A\u00020\u0005H\u0086\u0080\u0004\u001A\u0012\u0010\u0000\u001A\u00020\u00062\u0006\u0010\u0002\u001A\u00020\u0007H\u0086\u0080\u0004\u001A\u0012\u0010\u0000\u001A\u00020\b2\u0006\u0010\u0002\u001A\u00020\tH\u0086\u0080\u0004\u001A\u0012\u0010\u0000\u001A\u00020\n2\u0006\u0010\u0002\u001A\u00020\u000BH\u0086\u0080\u0004\u001A\u0012\u0010\u0000\u001A\u00020\f2\u0006\u0010\u0002\u001A\u00020\rH\u0086\u0080\u0004\u001A\u0012\u0010\u0000\u001A\u00020\u000E2\u0006\u0010\u0002\u001A\u00020\u000FH\u0086\u0080\u0004\u001A\u0012\u0010\u0000\u001A\u00020\u00102\u0006\u0010\u0002\u001A\u00020\u0011H\u0086\u0080\u0004¨\u0006\u0012"}, d2={"iterator", "Lkotlin/collections/ByteIterator;", "array", "", "Lkotlin/collections/CharIterator;", "", "Lkotlin/collections/ShortIterator;", "", "Lkotlin/collections/IntIterator;", "", "Lkotlin/collections/LongIterator;", "", "Lkotlin/collections/FloatIterator;", "", "Lkotlin/collections/DoubleIterator;", "", "Lkotlin/collections/BooleanIterator;", "", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class ArrayIteratorsKt {
    public static final ByteIterator iterator(byte[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "array");
        return new ArrayByteIterator(arg1);
    }

    public static final ShortIterator iterator(short[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "array");
        return new ArrayShortIterator(arg1);
    }

    public static final IntIterator iterator(int[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "array");
        return new ArrayIntIterator(arg1);
    }

    public static final LongIterator iterator(long[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "array");
        return new ArrayLongIterator(arg1);
    }

    public static final FloatIterator iterator(float[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "array");
        return new ArrayFloatIterator(arg1);
    }

    public static final DoubleIterator iterator(double[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "array");
        return new ArrayDoubleIterator(arg1);
    }

    public static final BooleanIterator iterator(boolean[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "array");
        return new ArrayBooleanIterator(arg1);
    }

    public static final CharIterator iterator(char[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "array");
        return new ArrayCharIterator(arg1);
    }
}

