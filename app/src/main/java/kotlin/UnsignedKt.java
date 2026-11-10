package kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0003\u001A!\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0001H\u0081\u0080\u0004¢\u0006\u0004\b\u0004\u0010\u0005\u001A!\u0010\u0006\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0001H\u0081\u0080\u0004¢\u0006\u0004\b\u0007\u0010\u0005\u001A!\u0010\b\u001A\u00020\t2\u0006\u0010\u0002\u001A\u00020\t2\u0006\u0010\u0003\u001A\u00020\tH\u0081\u0080\u0004¢\u0006\u0004\b\n\u0010\u000B\u001A!\u0010\f\u001A\u00020\t2\u0006\u0010\u0002\u001A\u00020\t2\u0006\u0010\u0003\u001A\u00020\tH\u0081\u0080\u0004¢\u0006\u0004\b\r\u0010\u000B\u001A\u001A\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0002\u001A\u00020\u000F2\u0006\u0010\u0003\u001A\u00020\u000FH\u0081\u0080\u0004\u001A\u001A\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0002\u001A\u00020\u00112\u0006\u0010\u0003\u001A\u00020\u0011H\u0081\u0080\u0004\u001A\u0017\u0010\u0012\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\u000FH\u0081\u0088\u0004¢\u0006\u0002\u0010\u0014\u001A\u0012\u0010\u0015\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u000FH\u0081\u0088\u0004\u001A\u0012\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0013\u001A\u00020\u000FH\u0081\u0088\u0004\u001A\u0017\u0010\u0018\u001A\u00020\u00012\u0006\u0010\u0013\u001A\u00020\u0017H\u0081\u0088\u0004¢\u0006\u0002\u0010\u0019\u001A\u0012\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u0013\u001A\u00020\u000FH\u0081\u0080\u0004\u001A\u0017\u0010\u001C\u001A\u00020\u00012\u0006\u0010\u0013\u001A\u00020\u001BH\u0081\u0080\u0004¢\u0006\u0002\u0010\u001D\u001A\u0012\u0010\u001E\u001A\u00020\u00172\u0006\u0010\u0013\u001A\u00020\u0011H\u0081\u0088\u0004\u001A\u0017\u0010\u001F\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\u0017H\u0081\u0088\u0004¢\u0006\u0002\u0010 \u001A\u0012\u0010!\u001A\u00020\u001B2\u0006\u0010\u0013\u001A\u00020\u0011H\u0081\u0080\u0004\u001A\u0017\u0010\"\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\u001BH\u0081\u0080\u0004¢\u0006\u0002\u0010#\u001A\u0012\u0010$\u001A\u00020%2\u0006\u0010\u0013\u001A\u00020\u000FH\u0081\u0088\u0004\u001A\u001A\u0010$\u001A\u00020%2\u0006\u0010\u0013\u001A\u00020\u000F2\u0006\u0010&\u001A\u00020\u000FH\u0081\u0088\u0004\u001A\u0012\u0010\'\u001A\u00020%2\u0006\u0010\u0013\u001A\u00020\u0011H\u0081\u0088\u0004\u001A\u001A\u0010\'\u001A\u00020%2\u0006\u0010\u0013\u001A\u00020\u00112\u0006\u0010&\u001A\u00020\u000FH\u0080\u0080\u0004¨\u0006("}, d2={"uintRemainder", "Lkotlin/UInt;", "v1", "v2", "uintRemainder-J1ME1BU", "(II)I", "uintDivide", "uintDivide-J1ME1BU", "ulongDivide", "Lkotlin/ULong;", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "uintCompare", "", "ulongCompare", "", "uintToULong", "value", "(I)J", "uintToLong", "uintToFloat", "", "floatToUInt", "(F)I", "uintToDouble", "", "doubleToUInt", "(D)I", "ulongToFloat", "floatToULong", "(F)J", "ulongToDouble", "doubleToULong", "(D)J", "uintToString", "", "base", "ulongToString", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class UnsignedKt {
    public static final int doubleToUInt(double arg4) {
        if(Double.isNaN(arg4)) {
            return 0;
        }

        if(arg4 <= 0) {
            return 0;
        }

        if(arg4 >= 4294967295) {
            return -1;
        }

        double v0 = 2147483647;
        if(arg4 <= v0) {
            return UInt.constructor-impl(((int)arg4));
        }

        return UInt.constructor-impl(UInt.constructor-impl(((int)(arg4 - v0))) + 0x7FFFFFFF);
    }

    public static final long doubleToULong(double arg5) {
        long v1 = 0;
        if(Double.isNaN(arg5)) {
            return v1;
        }

        if(arg5 <= 0) {
            return v1;
        }

        if(arg5 >= 18446744073709552000) {
            return -1;
        }

        double v0 = 9223372036854776000;
        if(arg5 < v0) {
            return ULong.constructor-impl(((long)arg5));
        }

        return ULong.constructor-impl(ULong.constructor-impl(((long)(arg5 - v0))) + -9223372036854775808L);
    }

    private static final int floatToUInt(float arg2) {
        return UnsignedKt.doubleToUInt(((double)arg2));
    }

    private static final long floatToULong(float arg2) {
        return UnsignedKt.doubleToULong(((double)arg2));
    }

    public static final int uintCompare(int arg1, int arg2) {
        return Intrinsics.compare(arg1 ^ 0x80000000, arg2 ^ 0x80000000);
    }

    public static final int uintDivide-J1ME1BU(int arg4, int arg5) {
        return UInt.constructor-impl(((int)(((((long)arg4)) & 0xFFFFFFFFL) / ((((long)arg5)) & 0xFFFFFFFFL))));
    }

    public static final int uintRemainder-J1ME1BU(int arg4, int arg5) {
        return UInt.constructor-impl(((int)(((((long)arg4)) & 0xFFFFFFFFL) % ((((long)arg5)) & 0xFFFFFFFFL))));
    }

    public static final double uintToDouble(int arg6) {
        return (((double)(0x7FFFFFFF & arg6))) + (((double)(arg6 >>> 0x1F << 30))) * 2;
    }

    private static final float uintToFloat(int arg2) {
        return ((float)UnsignedKt.uintToDouble(arg2));
    }

    private static final long uintToLong(int arg4) {
        return (((long)arg4)) & 0xFFFFFFFFL;
    }

    private static final String uintToString(int arg4) {
        return String.valueOf((((long)arg4)) & 0xFFFFFFFFL);
    }

    private static final String uintToString(int arg4, int arg5) {
        return UnsignedKt.ulongToString((((long)arg4)) & 0xFFFFFFFFL, arg5);
    }

    private static final long uintToULong(int arg4) {
        return ULong.constructor-impl((((long)arg4)) & 0xFFFFFFFFL);
    }

    public static final int ulongCompare(long arg2, long arg4) {
        return Intrinsics.compare(arg2 ^ -9223372036854775808L, arg4 ^ -9223372036854775808L);
    }

    public static final long ulongDivide-eb3DHEI(long arg5, long arg7) {
        long v0 = 0;
        if(arg7 < v0) {
            if(Long.compareUnsigned(arg5, arg7) < 0) {
                return ULong.constructor-impl(v0);
            }

            return ULong.constructor-impl(1);
        }

        if(arg5 >= v0) {
            return ULong.constructor-impl(arg5 / arg7);
        }

        int v0_1 = 1;
        long v1 = (arg5 >>> 1) / arg7 << 1;
        if(Long.compareUnsigned(ULong.constructor-impl(arg5 - v1 * arg7), ULong.constructor-impl(arg7)) >= 0) {
        }
        else {
            v0_1 = 0;
        }

        return ULong.constructor-impl(v1 + (((long)v0_1)));
    }

    public static final long ulongRemainder-eb3DHEI(long arg6, long arg8) {
        long v0 = 0;
        if(arg8 < v0) {
            if(Long.compareUnsigned(arg6, arg8) < 0) {
                return arg6;
            }

            return ULong.constructor-impl(arg6 - arg8);
        }

        if(arg6 >= v0) {
            return ULong.constructor-impl(arg6 % arg8);
        }

        arg6 -= ((arg6 >>> 1) / arg8 << 1) * arg8;
        if(Long.compareUnsigned(ULong.constructor-impl(arg6), ULong.constructor-impl(arg8)) >= 0) {
        }
        else {
            arg8 = v0;
        }

        return ULong.constructor-impl(arg6 - arg8);
    }

    public static final double ulongToDouble(long arg4) {
        return (((double)(arg4 >>> 11))) * 2048 + (((double)(arg4 & 0x7FF)));
    }

    private static final float ulongToFloat(long arg0) {
        return ((float)UnsignedKt.ulongToDouble(arg0));
    }

    public static final String ulongToString(long arg8, int arg10) {
        String v8;
        String v1 = "toString(...)";
        if(Long.compare(arg8, 0) >= 0) {
            v8 = Long.toString(arg8, CharsKt.checkRadix(arg10));
            Intrinsics.checkNotNullExpressionValue(v8, v1);
            return v8;
        }

        long v4 = ((long)arg10);
        long v2 = (arg8 >>> 1) / v4 << 1;
        arg8 -= v2 * v4;
        if(arg8 >= v4) {
            arg8 -= v4;
            ++v2;
        }

        StringBuilder v0 = new StringBuilder();
        String v2_1 = Long.toString(v2, CharsKt.checkRadix(arg10));
        Intrinsics.checkNotNullExpressionValue(v2_1, v1);
        v0 = v0.append(v2_1);
        v8 = Long.toString(arg8, CharsKt.checkRadix(arg10));
        Intrinsics.checkNotNullExpressionValue(v8, v1);
        return v0.append(v8).toString();
    }

    private static final String ulongToString(long arg1) {
        return UnsignedKt.ulongToString(arg1, 10);
    }
}

