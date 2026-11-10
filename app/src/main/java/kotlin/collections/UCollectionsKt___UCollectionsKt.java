package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001C\n\u0002\b\u0007\u001A\u0019\u0010\u0000\u001A\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0004\u001A\u0019\u0010\u0005\u001A\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\b\u001A\u0019\u0010\t\u001A\u00020\n*\b\u0012\u0004\u0012\u00020\u000B0\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\f\u001A\u0019\u0010\r\u001A\u00020\u000E*\b\u0012\u0004\u0012\u00020\u000F0\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0010\u001A\u001B\u0010\u0011\u001A\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0012H\u0087\u0080\u0004¢\u0006\u0004\b\u0013\u0010\u0014\u001A\u001B\u0010\u0011\u001A\u00020\u000B*\b\u0012\u0004\u0012\u00020\u000B0\u0012H\u0087\u0080\u0004¢\u0006\u0004\b\u0015\u0010\u0016\u001A\u001B\u0010\u0011\u001A\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00030\u0012H\u0087\u0080\u0004¢\u0006\u0004\b\u0017\u0010\u0014\u001A\u001B\u0010\u0011\u001A\u00020\u0007*\b\u0012\u0004\u0012\u00020\u000F0\u0012H\u0087\u0080\u0004¢\u0006\u0004\b\u0018\u0010\u0014¨\u0006\u0019"}, d2={"toUByteArray", "Lkotlin/UByteArray;", "", "Lkotlin/UByte;", "(Ljava/util/Collection;)[B", "toUIntArray", "Lkotlin/UIntArray;", "Lkotlin/UInt;", "(Ljava/util/Collection;)[I", "toULongArray", "Lkotlin/ULongArray;", "Lkotlin/ULong;", "(Ljava/util/Collection;)[J", "toUShortArray", "Lkotlin/UShortArray;", "Lkotlin/UShort;", "(Ljava/util/Collection;)[S", "sum", "", "sumOfUInt", "(Ljava/lang/Iterable;)I", "sumOfULong", "(Ljava/lang/Iterable;)J", "sumOfUByte", "sumOfUShort", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/collections/UCollectionsKt") class UCollectionsKt___UCollectionsKt {
    public UCollectionsKt___UCollectionsKt() {
        super();
    }

    public static final int sumOfUByte(Iterable arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Iterator v2 = arg2.iterator();
        int v0;
        for(v0 = 0; v2.hasNext(); v0 = UInt.constructor-impl(v0 + UInt.constructor-impl(v2.next().unbox-impl() & 0xFF))) {
        }

        return v0;
    }

    public static final int sumOfUInt(Iterable arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Iterator v2 = arg2.iterator();
        int v0;
        for(v0 = 0; v2.hasNext(); v0 = UInt.constructor-impl(v0 + v2.next().unbox-impl())) {
        }

        return v0;
    }

    public static final long sumOfULong(Iterable arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Iterator v4 = arg4.iterator();
        long v0;
        for(v0 = 0; v4.hasNext(); v0 = ULong.constructor-impl(v0 + v4.next().unbox-impl())) {
        }

        return v0;
    }

    public static final int sumOfUShort(Iterable arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Iterator v3 = arg3.iterator();
        int v0;
        for(v0 = 0; v3.hasNext(); v0 = UInt.constructor-impl(v0 + UInt.constructor-impl(v3.next().unbox-impl() & 0xFFFF))) {
        }

        return v0;
    }

    public static final byte[] toUByteArray(Collection arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        byte[] v0 = UByteArray.constructor-impl(arg4.size());
        Iterator v4 = arg4.iterator();
        int v1;
        for(v1 = 0; v4.hasNext(); ++v1) {
            UByteArray.set-VurrAj0(v0, v1, v4.next().unbox-impl());
        }

        return v0;
    }

    public static final int[] toUIntArray(Collection arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        int[] v0 = UIntArray.constructor-impl(arg4.size());
        Iterator v4 = arg4.iterator();
        int v1;
        for(v1 = 0; v4.hasNext(); ++v1) {
            UIntArray.set-VXSXFK8(v0, v1, v4.next().unbox-impl());
        }

        return v0;
    }

    public static final long[] toULongArray(Collection arg5) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        long[] v0 = ULongArray.constructor-impl(arg5.size());
        Iterator v5 = arg5.iterator();
        int v1;
        for(v1 = 0; v5.hasNext(); ++v1) {
            ULongArray.set-k8EXiF4(v0, v1, v5.next().unbox-impl());
        }

        return v0;
    }

    public static final short[] toUShortArray(Collection arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        short[] v0 = UShortArray.constructor-impl(arg4.size());
        Iterator v4 = arg4.iterator();
        int v1;
        for(v1 = 0; v4.hasNext(); ++v1) {
            UShortArray.set-01HTLdE(v0, v1, v4.next().unbox-impl());
        }

        return v0;
    }
}

