package kotlin.comparisons;

import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u001A!\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0001H\u0087\u0080\u0004¢\u0006\u0004\b\u0004\u0010\u0005\u001A!\u0010\u0000\u001A\u00020\u00062\u0006\u0010\u0002\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u0006H\u0087\u0080\u0004¢\u0006\u0004\b\u0007\u0010\b\u001A!\u0010\u0000\u001A\u00020\t2\u0006\u0010\u0002\u001A\u00020\t2\u0006\u0010\u0003\u001A\u00020\tH\u0087\u0080\u0004¢\u0006\u0004\b\n\u0010\u000B\u001A!\u0010\u0000\u001A\u00020\f2\u0006\u0010\u0002\u001A\u00020\f2\u0006\u0010\u0003\u001A\u00020\fH\u0087\u0080\u0004¢\u0006\u0004\b\r\u0010\u000E\u001A)\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u0001H\u0087\u0088\u0004¢\u0006\u0004\b\u0010\u0010\u0011\u001A)\u0010\u0000\u001A\u00020\u00062\u0006\u0010\u0002\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u0006H\u0087\u0088\u0004¢\u0006\u0004\b\u0012\u0010\u0013\u001A)\u0010\u0000\u001A\u00020\t2\u0006\u0010\u0002\u001A\u00020\t2\u0006\u0010\u0003\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\tH\u0087\u0088\u0004¢\u0006\u0004\b\u0014\u0010\u0015\u001A)\u0010\u0000\u001A\u00020\f2\u0006\u0010\u0002\u001A\u00020\f2\u0006\u0010\u0003\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\fH\u0087\u0088\u0004¢\u0006\u0004\b\u0016\u0010\u0017\u001A%\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\n\u0010\u0018\u001A\u00020\u0019\"\u00020\u0001H\u0087\u0080\u0004¢\u0006\u0004\b\u001A\u0010\u001B\u001A%\u0010\u0000\u001A\u00020\u00062\u0006\u0010\u0002\u001A\u00020\u00062\n\u0010\u0018\u001A\u00020\u001C\"\u00020\u0006H\u0087\u0080\u0004¢\u0006\u0004\b\u001D\u0010\u001E\u001A%\u0010\u0000\u001A\u00020\t2\u0006\u0010\u0002\u001A\u00020\t2\n\u0010\u0018\u001A\u00020\u001F\"\u00020\tH\u0087\u0080\u0004¢\u0006\u0004\b \u0010!\u001A%\u0010\u0000\u001A\u00020\f2\u0006\u0010\u0002\u001A\u00020\f2\n\u0010\u0018\u001A\u00020\"\"\u00020\fH\u0087\u0080\u0004¢\u0006\u0004\b#\u0010$\u001A!\u0010%\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0001H\u0087\u0080\u0004¢\u0006\u0004\b&\u0010\u0005\u001A!\u0010%\u001A\u00020\u00062\u0006\u0010\u0002\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u0006H\u0087\u0080\u0004¢\u0006\u0004\b\'\u0010\b\u001A!\u0010%\u001A\u00020\t2\u0006\u0010\u0002\u001A\u00020\t2\u0006\u0010\u0003\u001A\u00020\tH\u0087\u0080\u0004¢\u0006\u0004\b(\u0010\u000B\u001A!\u0010%\u001A\u00020\f2\u0006\u0010\u0002\u001A\u00020\f2\u0006\u0010\u0003\u001A\u00020\fH\u0087\u0080\u0004¢\u0006\u0004\b)\u0010\u000E\u001A)\u0010%\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u0001H\u0087\u0088\u0004¢\u0006\u0004\b*\u0010\u0011\u001A)\u0010%\u001A\u00020\u00062\u0006\u0010\u0002\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u0006H\u0087\u0088\u0004¢\u0006\u0004\b+\u0010\u0013\u001A)\u0010%\u001A\u00020\t2\u0006\u0010\u0002\u001A\u00020\t2\u0006\u0010\u0003\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\tH\u0087\u0088\u0004¢\u0006\u0004\b,\u0010\u0015\u001A)\u0010%\u001A\u00020\f2\u0006\u0010\u0002\u001A\u00020\f2\u0006\u0010\u0003\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\fH\u0087\u0088\u0004¢\u0006\u0004\b-\u0010\u0017\u001A%\u0010%\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\n\u0010\u0018\u001A\u00020\u0019\"\u00020\u0001H\u0087\u0080\u0004¢\u0006\u0004\b.\u0010\u001B\u001A%\u0010%\u001A\u00020\u00062\u0006\u0010\u0002\u001A\u00020\u00062\n\u0010\u0018\u001A\u00020\u001C\"\u00020\u0006H\u0087\u0080\u0004¢\u0006\u0004\b/\u0010\u001E\u001A%\u0010%\u001A\u00020\t2\u0006\u0010\u0002\u001A\u00020\t2\n\u0010\u0018\u001A\u00020\u001F\"\u00020\tH\u0087\u0080\u0004¢\u0006\u0004\b0\u0010!\u001A%\u0010%\u001A\u00020\f2\u0006\u0010\u0002\u001A\u00020\f2\n\u0010\u0018\u001A\u00020\"\"\u00020\fH\u0087\u0080\u0004¢\u0006\u0004\b1\u0010$¨\u00062"}, d2={"maxOf", "Lkotlin/UInt;", "a", "b", "maxOf-J1ME1BU", "(II)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "Lkotlin/UByte;", "maxOf-Kr8caGY", "(BB)B", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "c", "maxOf-WZ9TVnA", "(III)I", "maxOf-sambcqE", "(JJJ)J", "maxOf-b33U2AM", "(BBB)B", "maxOf-VKSA0NQ", "(SSS)S", "other", "Lkotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "Lkotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lkotlin/UByteArray;", "maxOf-Wr6uiD8", "(B[B)B", "Lkotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf", "minOf-J1ME1BU", "minOf-eb3DHEI", "minOf-Kr8caGY", "minOf-5PvTz6A", "minOf-WZ9TVnA", "minOf-sambcqE", "minOf-b33U2AM", "minOf-VKSA0NQ", "minOf-Md2H83M", "minOf-R03FKyM", "minOf-Wr6uiD8", "minOf-t1qELG4", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/comparisons/UComparisonsKt") class UComparisonsKt___UComparisonsKt {
    public UComparisonsKt___UComparisonsKt() {
        super();
    }

    public static final short maxOf-5PvTz6A(short arg2, short arg3) {
        if(Intrinsics.compare(arg2 & 0xFFFF, 0xFFFF & arg3) >= 0) {
            return arg2;
        }

        return arg3;
    }

    public static final int maxOf-J1ME1BU(int arg1, int arg2) {
        if(Integer.compareUnsigned(arg1, arg2) >= 0) {
            return arg1;
        }

        return arg2;
    }

    public static final byte maxOf-Kr8caGY(byte arg2, byte arg3) {
        if(Intrinsics.compare(arg2 & 0xFF, arg3 & 0xFF) >= 0) {
            return arg2;
        }

        return arg3;
    }

    public static final int maxOf-Md2H83M(int arg3, int[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "other");
        int v0 = UIntArray.getSize-impl(arg4);
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg3 = UComparisonsKt.maxOf-J1ME1BU(arg3, UIntArray.get-pVg5ArA(arg4, v1));
        }

        return arg3;
    }

    public static final long maxOf-R03FKyM(long arg4, long[] arg6) {
        Intrinsics.checkNotNullParameter(arg6, "other");
        int v0 = ULongArray.getSize-impl(arg6);
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg4 = UComparisonsKt.maxOf-eb3DHEI(arg4, ULongArray.get-s-VKNKU(arg6, v1));
        }

        return arg4;
    }

    private static final short maxOf-VKSA0NQ(short arg0, short arg1, short arg2) {
        return UComparisonsKt.maxOf-5PvTz6A(arg0, UComparisonsKt.maxOf-5PvTz6A(arg1, arg2));
    }

    private static final int maxOf-WZ9TVnA(int arg0, int arg1, int arg2) {
        return UComparisonsKt.maxOf-J1ME1BU(arg0, UComparisonsKt.maxOf-J1ME1BU(arg1, arg2));
    }

    public static final byte maxOf-Wr6uiD8(byte arg3, byte[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "other");
        int v0 = UByteArray.getSize-impl(arg4);
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg3 = UComparisonsKt.maxOf-Kr8caGY(arg3, UByteArray.get-w2LRezQ(arg4, v1));
        }

        return arg3;
    }

    private static final byte maxOf-b33U2AM(byte arg0, byte arg1, byte arg2) {
        return UComparisonsKt.maxOf-Kr8caGY(arg0, UComparisonsKt.maxOf-Kr8caGY(arg1, arg2));
    }

    public static final long maxOf-eb3DHEI(long arg1, long arg3) {
        if(Long.compareUnsigned(arg1, arg3) >= 0) {
            return arg1;
        }

        return arg3;
    }

    private static final long maxOf-sambcqE(long arg0, long arg2, long arg4) {
        return UComparisonsKt.maxOf-eb3DHEI(arg0, UComparisonsKt.maxOf-eb3DHEI(arg2, arg4));
    }

    public static final short maxOf-t1qELG4(short arg3, short[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "other");
        int v0 = UShortArray.getSize-impl(arg4);
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg3 = UComparisonsKt.maxOf-5PvTz6A(arg3, UShortArray.get-Mh2AYeg(arg4, v1));
        }

        return arg3;
    }

    public static final short minOf-5PvTz6A(short arg2, short arg3) {
        if(Intrinsics.compare(arg2 & 0xFFFF, 0xFFFF & arg3) <= 0) {
            return arg2;
        }

        return arg3;
    }

    public static final int minOf-J1ME1BU(int arg1, int arg2) {
        if(Integer.compareUnsigned(arg1, arg2) <= 0) {
            return arg1;
        }

        return arg2;
    }

    public static final byte minOf-Kr8caGY(byte arg2, byte arg3) {
        if(Intrinsics.compare(arg2 & 0xFF, arg3 & 0xFF) <= 0) {
            return arg2;
        }

        return arg3;
    }

    public static final int minOf-Md2H83M(int arg3, int[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "other");
        int v0 = UIntArray.getSize-impl(arg4);
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg3 = UComparisonsKt.minOf-J1ME1BU(arg3, UIntArray.get-pVg5ArA(arg4, v1));
        }

        return arg3;
    }

    public static final long minOf-R03FKyM(long arg4, long[] arg6) {
        Intrinsics.checkNotNullParameter(arg6, "other");
        int v0 = ULongArray.getSize-impl(arg6);
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg4 = UComparisonsKt.minOf-eb3DHEI(arg4, ULongArray.get-s-VKNKU(arg6, v1));
        }

        return arg4;
    }

    private static final short minOf-VKSA0NQ(short arg0, short arg1, short arg2) {
        return UComparisonsKt.minOf-5PvTz6A(arg0, UComparisonsKt.minOf-5PvTz6A(arg1, arg2));
    }

    private static final int minOf-WZ9TVnA(int arg0, int arg1, int arg2) {
        return UComparisonsKt.minOf-J1ME1BU(arg0, UComparisonsKt.minOf-J1ME1BU(arg1, arg2));
    }

    public static final byte minOf-Wr6uiD8(byte arg3, byte[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "other");
        int v0 = UByteArray.getSize-impl(arg4);
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg3 = UComparisonsKt.minOf-Kr8caGY(arg3, UByteArray.get-w2LRezQ(arg4, v1));
        }

        return arg3;
    }

    private static final byte minOf-b33U2AM(byte arg0, byte arg1, byte arg2) {
        return UComparisonsKt.minOf-Kr8caGY(arg0, UComparisonsKt.minOf-Kr8caGY(arg1, arg2));
    }

    public static final long minOf-eb3DHEI(long arg1, long arg3) {
        if(Long.compareUnsigned(arg1, arg3) <= 0) {
            return arg1;
        }

        return arg3;
    }

    private static final long minOf-sambcqE(long arg0, long arg2, long arg4) {
        return UComparisonsKt.minOf-eb3DHEI(arg0, UComparisonsKt.minOf-eb3DHEI(arg2, arg4));
    }

    public static final short minOf-t1qELG4(short arg3, short[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "other");
        int v0 = UShortArray.getSize-impl(arg4);
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg3 = UComparisonsKt.minOf-5PvTz6A(arg3, UShortArray.get-Mh2AYeg(arg4, v1));
        }

        return arg3;
    }
}

