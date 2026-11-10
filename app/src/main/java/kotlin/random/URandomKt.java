package kotlin.random;

import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongRange;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\u001A\u0013\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0003\u001A\u001D\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0001H\u0087\u0080\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001A%\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0001H\u0087\u0080\u0004¢\u0006\u0004\b\b\u0010\t\u001A\u001B\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001A\u00020\u000BH\u0087\u0080\u0004¢\u0006\u0002\u0010\f\u001A\u0013\u0010\r\u001A\u00020\u000E*\u00020\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\u000F\u001A\u001D\u0010\r\u001A\u00020\u000E*\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u000EH\u0087\u0080\u0004¢\u0006\u0004\b\u0010\u0010\u0011\u001A%\u0010\r\u001A\u00020\u000E*\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u000E2\u0006\u0010\u0004\u001A\u00020\u000EH\u0087\u0080\u0004¢\u0006\u0004\b\u0012\u0010\u0013\u001A\u001B\u0010\r\u001A\u00020\u000E*\u00020\u00022\u0006\u0010\n\u001A\u00020\u0014H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0015\u001A\u001D\u0010\u0016\u001A\u00020\u0017*\u00020\u00022\u0006\u0010\u0018\u001A\u00020\u0017H\u0087\u0080\b¢\u0006\u0004\b\u0019\u0010\u001A\u001A\u001B\u0010\u0016\u001A\u00020\u0017*\u00020\u00022\u0006\u0010\u001B\u001A\u00020\u001CH\u0087\u0080\u0004¢\u0006\u0002\u0010\u001D\u001A1\u0010\u0016\u001A\u00020\u0017*\u00020\u00022\u0006\u0010\u0018\u001A\u00020\u00172\b\b\u0002\u0010\u001E\u001A\u00020\u001C2\b\b\u0002\u0010\u001F\u001A\u00020\u001CH\u0087\u0080\b¢\u0006\u0004\b \u0010!\u001A!\u0010\"\u001A\u00020#2\u0006\u0010\u0007\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0001H\u0080\u0080\u0004¢\u0006\u0004\b$\u0010%\u001A!\u0010&\u001A\u00020#2\u0006\u0010\u0007\u001A\u00020\u000E2\u0006\u0010\u0004\u001A\u00020\u000EH\u0080\u0080\u0004¢\u0006\u0004\b\'\u0010(¨\u0006)"}, d2={"nextUInt", "Lkotlin/UInt;", "Lkotlin/random/Random;", "(Lkotlin/random/Random;)I", "until", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "from", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", "range", "Lkotlin/ranges/UIntRange;", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "nextULong", "Lkotlin/ULong;", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "nextUBytes", "Lkotlin/UByteArray;", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "size", "", "(Lkotlin/random/Random;I)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "checkUIntRangeBounds", "", "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkULongRangeBounds", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class URandomKt {
    public static final void checkUIntRangeBounds-J1ME1BU(int arg1, int arg2) {
        if(Integer.compareUnsigned(arg2, arg1) > 0) {
            return;
        }

        throw new IllegalArgumentException(RandomKt.boundsErrorMessage(UInt.box-impl(arg1), UInt.box-impl(arg2)).toString());
    }

    public static final void checkULongRangeBounds-eb3DHEI(long arg1, long arg3) {
        if(Long.compareUnsigned(arg3, arg1) > 0) {
            return;
        }

        throw new IllegalArgumentException(RandomKt.boundsErrorMessage(ULong.box-impl(arg1), ULong.box-impl(arg3)).toString());
    }

    public static final byte[] nextUBytes(Random arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return UByteArray.constructor-impl(arg1.nextBytes(arg2));
    }

    @IgnorableReturnValue public static final byte[] nextUBytes-EVgfTAA(Random arg1, byte[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(arg2, "array");
        arg1.nextBytes(arg2);
        return arg2;
    }

    @IgnorableReturnValue public static final byte[] nextUBytes-Wvrt4B4(Random arg1, byte[] arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg1, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(arg2, "array");
        arg1.nextBytes(arg2, arg3, arg4);
        return arg2;
    }

    public static byte[] nextUBytes-Wvrt4B4$default(Random arg0, byte[] arg1, int arg2, int arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = UByteArray.getSize-impl(arg1);
        }

        return URandomKt.nextUBytes-Wvrt4B4(arg0, arg1, 0, arg3);
    }

    public static final int nextUInt(Random arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return UInt.constructor-impl(arg1.nextInt());
    }

    public static final int nextUInt(Random arg2, UIntRange arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "range");
        if(!arg3.isEmpty()) {
            if(Integer.compareUnsigned(arg3.getLast-pVg5ArA(), -1) < 0) {
                return URandomKt.nextUInt-a8DCA5k(arg2, arg3.getFirst-pVg5ArA(), UInt.constructor-impl(arg3.getLast-pVg5ArA() + 1));
            }

            if(Integer.compareUnsigned(arg3.getFirst-pVg5ArA(), 0) > 0) {
                return UInt.constructor-impl(URandomKt.nextUInt-a8DCA5k(arg2, UInt.constructor-impl(arg3.getFirst-pVg5ArA() - 1), arg3.getLast-pVg5ArA()) + 1);
            }

            return URandomKt.nextUInt(arg2);
        }

        throw new IllegalArgumentException("Cannot get random in empty range: " + arg3);
    }

    public static final int nextUInt-a8DCA5k(Random arg1, int arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "$this$nextUInt");
        URandomKt.checkUIntRangeBounds-J1ME1BU(arg2, arg3);
        return UInt.constructor-impl(arg1.nextInt(arg2 ^ 0x80000000, arg3 ^ 0x80000000) ^ 0x80000000);
    }

    public static final int nextUInt-qCasIEU(Random arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$nextUInt");
        return URandomKt.nextUInt-a8DCA5k(arg1, 0, arg2);
    }

    public static final long nextULong(Random arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return ULong.constructor-impl(arg2.nextLong());
    }

    public static final long nextULong(Random arg7, ULongRange arg8) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "range");
        if(!arg8.isEmpty()) {
            long v1 = 1;
            if(Long.compareUnsigned(arg8.getLast-s-VKNKU(), -1) < 0) {
                return URandomKt.nextULong-jmpaW-c(arg7, arg8.getFirst-s-VKNKU(), ULong.constructor-impl(arg8.getLast-s-VKNKU() + ULong.constructor-impl(v1)));
            }

            if(Long.compareUnsigned(arg8.getFirst-s-VKNKU(), 0) > 0) {
                return ULong.constructor-impl(URandomKt.nextULong-jmpaW-c(arg7, ULong.constructor-impl(arg8.getFirst-s-VKNKU() - ULong.constructor-impl(v1)), arg8.getLast-s-VKNKU()) + ULong.constructor-impl(v1));
            }

            return URandomKt.nextULong(arg7);
        }

        throw new IllegalArgumentException("Cannot get random in empty range: " + arg8);
    }

    public static final long nextULong-V1Xi4fY(Random arg2, long arg3) {
        Intrinsics.checkNotNullParameter(arg2, "$this$nextULong");
        return URandomKt.nextULong-jmpaW-c(arg2, 0, arg3);
    }

    public static final long nextULong-jmpaW-c(Random arg2, long arg3, long arg5) {
        Intrinsics.checkNotNullParameter(arg2, "$this$nextULong");
        URandomKt.checkULongRangeBounds-eb3DHEI(arg3, arg5);
        return ULong.constructor-impl(arg2.nextLong(arg3 ^ -9223372036854775808L, arg5 ^ -9223372036854775808L) ^ -9223372036854775808L);
    }
}

