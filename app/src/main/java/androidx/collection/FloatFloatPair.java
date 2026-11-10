package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0000\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0010\u0010\r\u001A\u00020\u0003H\u0086\n¢\u0006\u0004\b\u000E\u0010\u000BJ\u0010\u0010\u000F\u001A\u00020\u0003H\u0086\n¢\u0006\u0004\b\u0010\u0010\u000BJ\u001A\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001A\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\u001BH\u0016¢\u0006\u0004\b\u001C\u0010\u001DR\u0012\u0010\u0002\u001A\u00020\u00038Æ\u0002¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0010\u0010\u0007\u001A\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001A\u00020\u00038Æ\u0002¢\u0006\u0006\u001A\u0004\b\f\u0010\u000B\u0088\u0001\u0007¨\u0006\u001E"}, d2={"Landroidx/collection/FloatFloatPair;", "", "first", "", "second", "constructor-impl", "(FF)J", "packedValue", "", "(J)J", "getFirst-impl", "(J)F", "getSecond-impl", "component1", "component1-impl", "component2", "component2-impl", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) @JvmInline public final class FloatFloatPair {
    public final long packedValue;

    private FloatFloatPair(long arg1) {
        super();
        this.packedValue = arg1;
    }

    public static final FloatFloatPair box-impl(long arg1) {
        return new FloatFloatPair(arg1);
    }

    public static final float component1-impl(long arg1) {
        return Float.intBitsToFloat(((int)(arg1 >> 0x20)));
    }

    public static final float component2-impl(long arg2) {
        return Float.intBitsToFloat(((int)(arg2 & 0xFFFFFFFFL)));
    }

    public static long constructor-impl(float arg4, float arg5) {
        return FloatFloatPair.constructor-impl((((long)Float.floatToRawIntBits(arg5))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg4))) << 0x20);
    }

    public static long constructor-impl(long arg0) {
        return arg0;
    }

    public boolean equals(Object arg3) {
        return FloatFloatPair.equals-impl(this.packedValue, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof FloatFloatPair)) {
            return 0;
        }

        if(arg4 != ((FloatFloatPair)arg6).unbox-impl()) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(long arg0, long arg2) {
        if(arg0 == arg2) {
            return 1;
        }

        return 0;
    }

    public static final float getFirst-impl(long arg1) {
        return Float.intBitsToFloat(((int)(arg1 >> 0x20)));
    }

    public static final float getSecond-impl(long arg2) {
        return Float.intBitsToFloat(((int)(arg2 & 0xFFFFFFFFL)));
    }

    public int hashCode() {
        return FloatFloatPair.hashCode-impl(this.packedValue);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public String toString() {
        return FloatFloatPair.toString-impl(this.packedValue);
    }

    public static String toString-impl(long arg3) {
        return "(" + Float.intBitsToFloat(((int)(arg3 >> 0x20))) + ", " + Float.intBitsToFloat(((int)(arg3 & 0xFFFFFFFFL))) + ')';
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}

