package kotlin;

import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0010\u000B\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\u001A\u000E\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\u0000\u001A\u00020\u0001*\u00020\u0003H\u0087\u0088\u0004\u001A\u000E\u0010\u0004\u001A\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\u0004\u001A\u00020\u0001*\u00020\u0003H\u0087\u0088\u0004\u001A\u000E\u0010\u0005\u001A\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\u0005\u001A\u00020\u0001*\u00020\u0003H\u0087\u0088\u0004\u001A\u000E\u0010\u0006\u001A\u00020\u0007*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\b\u001A\u00020\u0007*\u00020\u0002H\u0087\u0088\u0004\u001A\u0016\u0010\t\u001A\u00020\u0002*\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0007H\u0087\u0088\u0004\u001A\u000E\u0010\u0006\u001A\u00020\f*\u00020\u0003H\u0087\u0088\u0004\u001A\u000E\u0010\b\u001A\u00020\f*\u00020\u0003H\u0087\u0088\u0004\u001A\u0016\u0010\t\u001A\u00020\u0003*\u00020\r2\u0006\u0010\u000B\u001A\u00020\fH\u0087\u0088\u0004\u001A\u000E\u0010\u000E\u001A\u00020\f*\u00020\fH\u0087\u0088\u0004\u001A\u000E\u0010\u000F\u001A\u00020\f*\u00020\fH\u0087\u0088\u0004\u001A\u000E\u0010\u0010\u001A\u00020\f*\u00020\fH\u0087\u0088\u0004\u001A\u000E\u0010\u0011\u001A\u00020\f*\u00020\fH\u0087\u0088\u0004\u001A\u000E\u0010\u0012\u001A\u00020\f*\u00020\fH\u0087\u0088\u0004\u001A\u0016\u0010\u0013\u001A\u00020\f*\u00020\f2\u0006\u0010\u0014\u001A\u00020\fH\u0087\u0088\u0004\u001A\u0016\u0010\u0015\u001A\u00020\f*\u00020\f2\u0006\u0010\u0014\u001A\u00020\fH\u0087\u0088\u0004\u001A\u000E\u0010\u000E\u001A\u00020\f*\u00020\u0007H\u0087\u0088\u0004\u001A\u000E\u0010\u000F\u001A\u00020\f*\u00020\u0007H\u0087\u0088\u0004\u001A\u000E\u0010\u0010\u001A\u00020\f*\u00020\u0007H\u0087\u0088\u0004\u001A\u000E\u0010\u0011\u001A\u00020\u0007*\u00020\u0007H\u0087\u0088\u0004\u001A\u000E\u0010\u0012\u001A\u00020\u0007*\u00020\u0007H\u0087\u0088\u0004\u001A\u0016\u0010\u0013\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\u0014\u001A\u00020\fH\u0087\u0088\u0004\u001A\u0016\u0010\u0015\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\u0014\u001A\u00020\fH\u0087\u0088\u0004¨\u0006\u0016"}, d2={"isNaN", "", "", "", "isInfinite", "isFinite", "toBits", "", "toRawBits", "fromBits", "Lkotlin/Double$Companion;", "bits", "", "Lkotlin/Float$Companion;", "countOneBits", "countLeadingZeroBits", "countTrailingZeroBits", "takeHighestOneBit", "takeLowestOneBit", "rotateLeft", "bitCount", "rotateRight", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/NumbersKt") class NumbersKt__NumbersJVMKt extends NumbersKt__FloorDivModKt {
    public NumbersKt__NumbersJVMKt() {
        super();
    }

    private static final int countLeadingZeroBits(int arg0) {
        return Integer.numberOfLeadingZeros(arg0);
    }

    private static final int countLeadingZeroBits(long arg0) {
        return Long.numberOfLeadingZeros(arg0);
    }

    private static final int countOneBits(int arg0) {
        return Integer.bitCount(arg0);
    }

    private static final int countOneBits(long arg0) {
        return Long.bitCount(arg0);
    }

    private static final int countTrailingZeroBits(int arg0) {
        return Integer.numberOfTrailingZeros(arg0);
    }

    private static final int countTrailingZeroBits(long arg0) {
        return Long.numberOfTrailingZeros(arg0);
    }

    private static final double fromBits(DoubleCompanionObject arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return Double.longBitsToDouble(arg2);
    }

    private static final float fromBits(FloatCompanionObject arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return Float.intBitsToFloat(arg2);
    }

    private static final boolean isFinite(double arg2) {
        if(Math.abs(arg2) <= 1.797693E+308) {
            return 1;
        }

        return 0;
    }

    private static final boolean isFinite(float arg1) {
        if(Math.abs(arg1) <= 3.402823E+38f) {
            return 1;
        }

        return 0;
    }

    private static final boolean isInfinite(double arg0) {
        return Double.isInfinite(arg0);
    }

    private static final boolean isInfinite(float arg0) {
        return Float.isInfinite(arg0);
    }

    private static final boolean isNaN(double arg0) {
        return Double.isNaN(arg0);
    }

    private static final boolean isNaN(float arg0) {
        return Float.isNaN(arg0);
    }

    private static final int rotateLeft(int arg0, int arg1) {
        return Integer.rotateLeft(arg0, arg1);
    }

    private static final long rotateLeft(long arg0, int arg2) {
        return Long.rotateLeft(arg0, arg2);
    }

    private static final int rotateRight(int arg0, int arg1) {
        return Integer.rotateRight(arg0, arg1);
    }

    private static final long rotateRight(long arg0, int arg2) {
        return Long.rotateRight(arg0, arg2);
    }

    private static final int takeHighestOneBit(int arg0) {
        return Integer.highestOneBit(arg0);
    }

    private static final long takeHighestOneBit(long arg0) {
        return Long.highestOneBit(arg0);
    }

    private static final int takeLowestOneBit(int arg0) {
        return Integer.lowestOneBit(arg0);
    }

    private static final long takeLowestOneBit(long arg0) {
        return Long.lowestOneBit(arg0);
    }

    private static final int toBits(float arg0) {
        return Float.floatToIntBits(arg0);
    }

    private static final long toBits(double arg0) {
        return Double.doubleToLongBits(arg0);
    }

    private static final int toRawBits(float arg0) {
        return Float.floatToRawIntBits(arg0);
    }

    private static final long toRawBits(double arg0) {
        return Double.doubleToRawLongBits(arg0);
    }
}

