package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u001B\u0010\u0000\u001A\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0087\u0080\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u001A\u001B\u0010\u0000\u001A\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0087\u0080\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001A\u001B\u0010\u0000\u001A\u00020\u0001*\b\u0012\u0004\u0012\u00020\b0\u0002H\u0087\u0080\u0004¢\u0006\u0004\b\t\u0010\u0004\u001A\u001B\u0010\u0000\u001A\u00020\u0001*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0087\u0080\u0004¢\u0006\u0004\b\u000B\u0010\u0004¨\u0006\f"}, d2={"sum", "Lkotlin/UInt;", "Lkotlin/sequences/Sequence;", "sumOfUInt", "(Lkotlin/sequences/Sequence;)I", "Lkotlin/ULong;", "sumOfULong", "(Lkotlin/sequences/Sequence;)J", "Lkotlin/UByte;", "sumOfUByte", "Lkotlin/UShort;", "sumOfUShort", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/sequences/USequencesKt") class USequencesKt___USequencesKt {
    public USequencesKt___USequencesKt() {
        super();
    }

    public static final int sumOfUByte(Sequence arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Iterator v2 = arg2.iterator();
        int v0;
        for(v0 = 0; v2.hasNext(); v0 = UInt.constructor-impl(v0 + UInt.constructor-impl(v2.next().unbox-impl() & 0xFF))) {
        }

        return v0;
    }

    public static final int sumOfUInt(Sequence arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Iterator v2 = arg2.iterator();
        int v0;
        for(v0 = 0; v2.hasNext(); v0 = UInt.constructor-impl(v0 + v2.next().unbox-impl())) {
        }

        return v0;
    }

    public static final long sumOfULong(Sequence arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Iterator v4 = arg4.iterator();
        long v0;
        for(v0 = 0; v4.hasNext(); v0 = ULong.constructor-impl(v0 + v4.next().unbox-impl())) {
        }

        return v0;
    }

    public static final int sumOfUShort(Sequence arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Iterator v3 = arg3.iterator();
        int v0;
        for(v0 = 0; v3.hasNext(); v0 = UInt.constructor-impl(v0 + UInt.constructor-impl(v3.next().unbox-impl() & 0xFFFF))) {
        }

        return v0;
    }
}

