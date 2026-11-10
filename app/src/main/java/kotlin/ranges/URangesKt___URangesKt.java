package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandomKt;

@Metadata(d1={"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\u0013\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0003\u001A\u0013\u0010\u0000\u001A\u00020\u0004*\u00020\u0005H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0006\u001A\u0010\u0010\u0007\u001A\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004\u001A\u0010\u0010\u0007\u001A\u0004\u0018\u00010\u0004*\u00020\u0005H\u0087\u0080\u0004\u001A\u0013\u0010\b\u001A\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0003\u001A\u0013\u0010\b\u001A\u00020\u0004*\u00020\u0005H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0006\u001A\u0010\u0010\t\u001A\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004\u001A\u0010\u0010\t\u001A\u0004\u0018\u00010\u0004*\u00020\u0005H\u0087\u0080\u0004\u001A\u0013\u0010\n\u001A\u00020\u0001*\u00020\u000BH\u0087\u0088\u0004¢\u0006\u0002\u0010\f\u001A\u0013\u0010\n\u001A\u00020\u0004*\u00020\rH\u0087\u0088\u0004¢\u0006\u0002\u0010\u000E\u001A\u001B\u0010\n\u001A\u00020\u0001*\u00020\u000B2\u0006\u0010\n\u001A\u00020\u000FH\u0087\u0080\u0004¢\u0006\u0002\u0010\u0010\u001A\u001B\u0010\n\u001A\u00020\u0004*\u00020\r2\u0006\u0010\n\u001A\u00020\u000FH\u0087\u0080\u0004¢\u0006\u0002\u0010\u0011\u001A\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u0001*\u00020\u000BH\u0087\u0088\u0004\u001A\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u0004*\u00020\rH\u0087\u0088\u0004\u001A\u0018\u0010\u0012\u001A\u0004\u0018\u00010\u0001*\u00020\u000B2\u0006\u0010\n\u001A\u00020\u000FH\u0087\u0080\u0004\u001A\u0018\u0010\u0012\u001A\u0004\u0018\u00010\u0004*\u00020\r2\u0006\u0010\n\u001A\u00020\u000FH\u0087\u0080\u0004\u001A\u001D\u0010\u0013\u001A\u00020\u0014*\u00020\u000B2\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001H\u0087\u008A\u0004¢\u0006\u0002\b\u0016\u001A\u001D\u0010\u0013\u001A\u00020\u0014*\u00020\r2\b\u0010\u0015\u001A\u0004\u0018\u00010\u0004H\u0087\u008A\u0004¢\u0006\u0002\b\u0017\u001A\u001D\u0010\u0013\u001A\u00020\u0014*\u00020\u000B2\u0006\u0010\u0018\u001A\u00020\u0019H\u0087\u0082\u0004¢\u0006\u0004\b\u001A\u0010\u001B\u001A\u001D\u0010\u0013\u001A\u00020\u0014*\u00020\r2\u0006\u0010\u0018\u001A\u00020\u0019H\u0087\u0082\u0004¢\u0006\u0004\b\u001C\u0010\u001D\u001A\u001D\u0010\u0013\u001A\u00020\u0014*\u00020\r2\u0006\u0010\u0018\u001A\u00020\u0001H\u0087\u0082\u0004¢\u0006\u0004\b\u001E\u0010\u001F\u001A\u001D\u0010\u0013\u001A\u00020\u0014*\u00020\u000B2\u0006\u0010\u0018\u001A\u00020\u0004H\u0087\u0082\u0004¢\u0006\u0004\b \u0010!\u001A\u001D\u0010\u0013\u001A\u00020\u0014*\u00020\u000B2\u0006\u0010\u0018\u001A\u00020\"H\u0087\u0082\u0004¢\u0006\u0004\b#\u0010$\u001A\u001D\u0010\u0013\u001A\u00020\u0014*\u00020\r2\u0006\u0010\u0018\u001A\u00020\"H\u0087\u0082\u0004¢\u0006\u0004\b%\u0010&\u001A\u001D\u0010\'\u001A\u00020\u0002*\u00020\u00192\u0006\u0010(\u001A\u00020\u0019H\u0087\u0084\u0004¢\u0006\u0004\b)\u0010*\u001A\u001D\u0010\'\u001A\u00020\u0002*\u00020\u00012\u0006\u0010(\u001A\u00020\u0001H\u0087\u0084\u0004¢\u0006\u0004\b+\u0010,\u001A\u001D\u0010\'\u001A\u00020\u0005*\u00020\u00042\u0006\u0010(\u001A\u00020\u0004H\u0087\u0084\u0004¢\u0006\u0004\b-\u0010.\u001A\u001D\u0010\'\u001A\u00020\u0002*\u00020\"2\u0006\u0010(\u001A\u00020\"H\u0087\u0084\u0004¢\u0006\u0004\b/\u00100\u001A\u000E\u00101\u001A\u00020\u0002*\u00020\u0002H\u0087\u0080\u0004\u001A\u000E\u00101\u001A\u00020\u0005*\u00020\u0005H\u0087\u0080\u0004\u001A\u0016\u00102\u001A\u00020\u0002*\u00020\u00022\u0006\u00102\u001A\u000203H\u0087\u0084\u0004\u001A\u0016\u00102\u001A\u00020\u0005*\u00020\u00052\u0006\u00102\u001A\u000204H\u0087\u0084\u0004\u001A\u001D\u00105\u001A\u00020\u000B*\u00020\u00192\u0006\u0010(\u001A\u00020\u0019H\u0087\u0084\u0004¢\u0006\u0004\b6\u00107\u001A\u001D\u00105\u001A\u00020\u000B*\u00020\u00012\u0006\u0010(\u001A\u00020\u0001H\u0087\u0084\u0004¢\u0006\u0004\b8\u00109\u001A\u001D\u00105\u001A\u00020\r*\u00020\u00042\u0006\u0010(\u001A\u00020\u0004H\u0087\u0084\u0004¢\u0006\u0004\b:\u0010;\u001A\u001D\u00105\u001A\u00020\u000B*\u00020\"2\u0006\u0010(\u001A\u00020\"H\u0087\u0084\u0004¢\u0006\u0004\b<\u0010=\u001A\u001D\u0010>\u001A\u00020\u0001*\u00020\u00012\u0006\u0010?\u001A\u00020\u0001H\u0087\u0080\u0004¢\u0006\u0004\b@\u0010A\u001A\u001D\u0010>\u001A\u00020\u0004*\u00020\u00042\u0006\u0010?\u001A\u00020\u0004H\u0087\u0080\u0004¢\u0006\u0004\bB\u0010C\u001A\u001D\u0010>\u001A\u00020\u0019*\u00020\u00192\u0006\u0010?\u001A\u00020\u0019H\u0087\u0080\u0004¢\u0006\u0004\bD\u0010E\u001A\u001D\u0010>\u001A\u00020\"*\u00020\"2\u0006\u0010?\u001A\u00020\"H\u0087\u0080\u0004¢\u0006\u0004\bF\u0010G\u001A\u001D\u0010H\u001A\u00020\u0001*\u00020\u00012\u0006\u0010I\u001A\u00020\u0001H\u0087\u0080\u0004¢\u0006\u0004\bJ\u0010A\u001A\u001D\u0010H\u001A\u00020\u0004*\u00020\u00042\u0006\u0010I\u001A\u00020\u0004H\u0087\u0080\u0004¢\u0006\u0004\bK\u0010C\u001A\u001D\u0010H\u001A\u00020\u0019*\u00020\u00192\u0006\u0010I\u001A\u00020\u0019H\u0087\u0080\u0004¢\u0006\u0004\bL\u0010E\u001A\u001D\u0010H\u001A\u00020\"*\u00020\"2\u0006\u0010I\u001A\u00020\"H\u0087\u0080\u0004¢\u0006\u0004\bM\u0010G\u001A%\u0010N\u001A\u00020\u0001*\u00020\u00012\u0006\u0010?\u001A\u00020\u00012\u0006\u0010I\u001A\u00020\u0001H\u0087\u0080\u0004¢\u0006\u0004\bO\u0010P\u001A%\u0010N\u001A\u00020\u0004*\u00020\u00042\u0006\u0010?\u001A\u00020\u00042\u0006\u0010I\u001A\u00020\u0004H\u0087\u0080\u0004¢\u0006\u0004\bQ\u0010R\u001A%\u0010N\u001A\u00020\u0019*\u00020\u00192\u0006\u0010?\u001A\u00020\u00192\u0006\u0010I\u001A\u00020\u0019H\u0087\u0080\u0004¢\u0006\u0004\bS\u0010T\u001A%\u0010N\u001A\u00020\"*\u00020\"2\u0006\u0010?\u001A\u00020\"2\u0006\u0010I\u001A\u00020\"H\u0087\u0080\u0004¢\u0006\u0004\bU\u0010V\u001A#\u0010N\u001A\u00020\u0001*\u00020\u00012\f\u0010W\u001A\b\u0012\u0004\u0012\u00020\u00010XH\u0087\u0080\u0004¢\u0006\u0004\bY\u0010Z\u001A#\u0010N\u001A\u00020\u0004*\u00020\u00042\f\u0010W\u001A\b\u0012\u0004\u0012\u00020\u00040XH\u0087\u0080\u0004¢\u0006\u0004\b[\u0010\\¨\u0006]"}, d2={"first", "Lkotlin/UInt;", "Lkotlin/ranges/UIntProgression;", "(Lkotlin/ranges/UIntProgression;)I", "Lkotlin/ULong;", "Lkotlin/ranges/ULongProgression;", "(Lkotlin/ranges/ULongProgression;)J", "firstOrNull", "last", "lastOrNull", "random", "Lkotlin/ranges/UIntRange;", "(Lkotlin/ranges/UIntRange;)I", "Lkotlin/ranges/ULongRange;", "(Lkotlin/ranges/ULongRange;)J", "Lkotlin/random/Random;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "randomOrNull", "contains", "", "element", "contains-biwQdVI", "contains-GYNo2lE", "value", "Lkotlin/UByte;", "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "Lkotlin/UShort;", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", "downTo", "to", "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", "reversed", "step", "", "", "until", "until-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "until-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "until-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "until-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;", "coerceAtLeast", "minimumValue", "coerceAtLeast-J1ME1BU", "(II)I", "coerceAtLeast-eb3DHEI", "(JJ)J", "coerceAtLeast-Kr8caGY", "(BB)B", "coerceAtLeast-5PvTz6A", "(SS)S", "coerceAtMost", "maximumValue", "coerceAtMost-J1ME1BU", "coerceAtMost-eb3DHEI", "coerceAtMost-Kr8caGY", "coerceAtMost-5PvTz6A", "coerceIn", "coerceIn-WZ9TVnA", "(III)I", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-b33U2AM", "(BBB)B", "coerceIn-VKSA0NQ", "(SSS)S", "range", "Lkotlin/ranges/ClosedRange;", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/ranges/URangesKt") class URangesKt___URangesKt {
    public URangesKt___URangesKt() {
        super();
    }

    public static final short coerceAtLeast-5PvTz6A(short arg2, short arg3) {
        if(Intrinsics.compare(arg2 & 0xFFFF, 0xFFFF & arg3) < 0) {
            return arg3;
        }

        return arg2;
    }

    public static final int coerceAtLeast-J1ME1BU(int arg1, int arg2) {
        if(Integer.compareUnsigned(arg1, arg2) < 0) {
            return arg2;
        }

        return arg1;
    }

    public static final byte coerceAtLeast-Kr8caGY(byte arg2, byte arg3) {
        if(Intrinsics.compare(arg2 & 0xFF, arg3 & 0xFF) < 0) {
            return arg3;
        }

        return arg2;
    }

    public static final long coerceAtLeast-eb3DHEI(long arg1, long arg3) {
        if(Long.compareUnsigned(arg1, arg3) < 0) {
            return arg3;
        }

        return arg1;
    }

    public static final short coerceAtMost-5PvTz6A(short arg2, short arg3) {
        if(Intrinsics.compare(arg2 & 0xFFFF, 0xFFFF & arg3) > 0) {
            return arg3;
        }

        return arg2;
    }

    public static final int coerceAtMost-J1ME1BU(int arg1, int arg2) {
        if(Integer.compareUnsigned(arg1, arg2) > 0) {
            return arg2;
        }

        return arg1;
    }

    public static final byte coerceAtMost-Kr8caGY(byte arg2, byte arg3) {
        if(Intrinsics.compare(arg2 & 0xFF, arg3 & 0xFF) > 0) {
            return arg3;
        }

        return arg2;
    }

    public static final long coerceAtMost-eb3DHEI(long arg1, long arg3) {
        if(Long.compareUnsigned(arg1, arg3) > 0) {
            return arg3;
        }

        return arg1;
    }

    public static final long coerceIn-JPwROB0(long arg2, ClosedRange arg4) {
        Intrinsics.checkNotNullParameter(arg4, "range");
        if((arg4 instanceof ClosedFloatingPointRange)) {
            return RangesKt.coerceIn(ULong.box-impl(arg2), ((ClosedFloatingPointRange)arg4)).unbox-impl();
        }

        if(!arg4.isEmpty()) {
            if(Long.compareUnsigned(arg2, arg4.getStart().unbox-impl()) < 0) {
                return arg4.getStart().unbox-impl();
            }

            if(Long.compareUnsigned(arg2, arg4.getEndInclusive().unbox-impl()) > 0) {
                arg2 = arg4.getEndInclusive().unbox-impl();
            }

            return arg2;
        }

        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + arg4 + '.');
    }

    public static final short coerceIn-VKSA0NQ(short arg4, short arg5, short arg6) {
        int v0 = 0xFFFF;
        int v1 = arg5 & v0;
        int v2 = arg6 & v0;
        if(Intrinsics.compare(v1, v2) <= 0) {
            v0 &= arg4;
            if(Intrinsics.compare(v0, v1) < 0) {
                return arg5;
            }

            if(Intrinsics.compare(v0, v2) > 0) {
                return arg6;
            }

            return arg4;
        }

        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UShort.toString-impl(arg6) + " is less than minimum " + UShort.toString-impl(arg5) + '.');
    }

    public static final int coerceIn-WZ9TVnA(int arg2, int arg3, int arg4) {
        if(Integer.compareUnsigned(arg3, arg4) <= 0) {
            if(Integer.compareUnsigned(arg2, arg3) < 0) {
                return arg3;
            }

            if(Integer.compareUnsigned(arg2, arg4) > 0) {
                return arg4;
            }

            return arg2;
        }

        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UInt.toString-impl(arg4) + " is less than minimum " + UInt.toString-impl(arg3) + '.');
    }

    public static final byte coerceIn-b33U2AM(byte arg3, byte arg4, byte arg5) {
        int v0 = arg4 & 0xFF;
        int v1 = arg5 & 0xFF;
        if(Intrinsics.compare(v0, v1) <= 0) {
            int v2 = arg3 & 0xFF;
            if(Intrinsics.compare(v2, v0) < 0) {
                return arg4;
            }

            if(Intrinsics.compare(v2, v1) > 0) {
                return arg5;
            }

            return arg3;
        }

        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UByte.toString-impl(arg5) + " is less than minimum " + UByte.toString-impl(arg4) + '.');
    }

    public static final long coerceIn-sambcqE(long arg1, long arg3, long arg5) {
        if(Long.compareUnsigned(arg3, arg5) <= 0) {
            if(Long.compareUnsigned(arg1, arg3) < 0) {
                return arg3;
            }

            if(Long.compareUnsigned(arg1, arg5) > 0) {
                return arg5;
            }

            return arg1;
        }

        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ULong.toString-impl(arg5) + " is less than minimum " + ULong.toString-impl(arg3) + '.');
    }

    public static final int coerceIn-wuiCnnA(int arg2, ClosedRange arg3) {
        Intrinsics.checkNotNullParameter(arg3, "range");
        if((arg3 instanceof ClosedFloatingPointRange)) {
            return RangesKt.coerceIn(UInt.box-impl(arg2), ((ClosedFloatingPointRange)arg3)).unbox-impl();
        }

        if(!arg3.isEmpty()) {
            if(Integer.compareUnsigned(arg2, arg3.getStart().unbox-impl()) < 0) {
                return arg3.getStart().unbox-impl();
            }

            if(Integer.compareUnsigned(arg2, arg3.getEndInclusive().unbox-impl()) > 0) {
                arg2 = arg3.getEndInclusive().unbox-impl();
            }

            return arg2;
        }

        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + arg3 + '.');
    }

    public static final boolean contains-68kG9v0(UIntRange arg1, byte arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$contains");
        return arg1.contains-WZ4Q5Ns(UInt.constructor-impl(arg2 & 0xFF));
    }

    private static final boolean contains-GYNo2lE(ULongRange arg2, ULong arg3) {
        Intrinsics.checkNotNullParameter(arg2, "$this$contains");
        if(arg3 != null && (arg2.contains-VKZWuLQ(arg3.unbox-impl()))) {
            return 1;
        }

        return 0;
    }

    public static final boolean contains-Gab390E(ULongRange arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg4, "$this$contains");
        return arg4.contains-VKZWuLQ(ULong.constructor-impl((((long)arg5)) & 0xFFFFFFFFL));
    }

    public static final boolean contains-ULb-yJY(ULongRange arg4, byte arg5) {
        Intrinsics.checkNotNullParameter(arg4, "$this$contains");
        return arg4.contains-VKZWuLQ(ULong.constructor-impl((((long)arg5)) & 0xFF));
    }

    public static final boolean contains-ZsK3CEQ(UIntRange arg1, short arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$contains");
        return arg1.contains-WZ4Q5Ns(UInt.constructor-impl(arg2 & 0xFFFF));
    }

    private static final boolean contains-biwQdVI(UIntRange arg1, UInt arg2) {
        Intrinsics.checkNotNullParameter(arg1, "$this$contains");
        if(arg2 != null && (arg1.contains-WZ4Q5Ns(arg2.unbox-impl()))) {
            return 1;
        }

        return 0;
    }

    public static final boolean contains-fz5IDCE(UIntRange arg4, long arg5) {
        Intrinsics.checkNotNullParameter(arg4, "$this$contains");
        if(ULong.constructor-impl(arg5 >>> 0x20) == 0 && (arg4.contains-WZ4Q5Ns(UInt.constructor-impl(((int)arg5))))) {
            return 1;
        }

        return 0;
    }

    public static final boolean contains-uhHAxoY(ULongRange arg4, short arg5) {
        Intrinsics.checkNotNullParameter(arg4, "$this$contains");
        return arg4.contains-VKZWuLQ(ULong.constructor-impl((((long)arg5)) & 0xFFFF));
    }

    public static final UIntProgression downTo-5PvTz6A(short arg2, short arg3) {
        return UIntProgression.Companion.fromClosedRange-Nkh28Cs(UInt.constructor-impl(arg2 & 0xFFFF), UInt.constructor-impl(arg3 & 0xFFFF), -1);
    }

    public static final UIntProgression downTo-J1ME1BU(int arg2, int arg3) {
        return UIntProgression.Companion.fromClosedRange-Nkh28Cs(arg2, arg3, -1);
    }

    public static final UIntProgression downTo-Kr8caGY(byte arg2, byte arg3) {
        return UIntProgression.Companion.fromClosedRange-Nkh28Cs(UInt.constructor-impl(arg2 & 0xFF), UInt.constructor-impl(arg3 & 0xFF), -1);
    }

    public static final ULongProgression downTo-eb3DHEI(long arg7, long arg9) {
        return ULongProgression.Companion.fromClosedRange-7ftBX0g(arg7, arg9, -1);
    }

    public static final int first(UIntProgression arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        if(!arg3.isEmpty()) {
            return arg3.getFirst-pVg5ArA();
        }

        throw new NoSuchElementException("Progression " + arg3 + " is empty.");
    }

    public static final long first(ULongProgression arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        if(!arg3.isEmpty()) {
            return arg3.getFirst-s-VKNKU();
        }

        throw new NoSuchElementException("Progression " + arg3 + " is empty.");
    }

    public static final UInt firstOrNull(UIntProgression arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.isEmpty()) {
            return null;
        }

        return UInt.box-impl(arg1.getFirst-pVg5ArA());
    }

    public static final ULong firstOrNull(ULongProgression arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        if(arg2.isEmpty()) {
            return null;
        }

        return ULong.box-impl(arg2.getFirst-s-VKNKU());
    }

    public static final int last(UIntProgression arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        if(!arg3.isEmpty()) {
            return arg3.getLast-pVg5ArA();
        }

        throw new NoSuchElementException("Progression " + arg3 + " is empty.");
    }

    public static final long last(ULongProgression arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        if(!arg3.isEmpty()) {
            return arg3.getLast-s-VKNKU();
        }

        throw new NoSuchElementException("Progression " + arg3 + " is empty.");
    }

    public static final UInt lastOrNull(UIntProgression arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.isEmpty()) {
            return null;
        }

        return UInt.box-impl(arg1.getLast-pVg5ArA());
    }

    public static final ULong lastOrNull(ULongProgression arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        if(arg2.isEmpty()) {
            return null;
        }

        return ULong.box-impl(arg2.getLast-s-VKNKU());
    }

    private static final int random(UIntRange arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return URangesKt.random(arg1, Random.Default);
    }

    public static final int random(UIntRange arg1, Random arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "random");
        try {
            return URandomKt.nextUInt(arg2, arg1);
        }
        catch(IllegalArgumentException v1) {
            throw new NoSuchElementException(v1.getMessage());
        }
    }

    private static final long random(ULongRange arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return URangesKt.random(arg2, Random.Default);
    }

    public static final long random(ULongRange arg1, Random arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "random");
        try {
            return URandomKt.nextULong(arg2, arg1);
        }
        catch(IllegalArgumentException v1) {
            throw new NoSuchElementException(v1.getMessage());
        }
    }

    private static final UInt randomOrNull(UIntRange arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return URangesKt.randomOrNull(arg1, Random.Default);
    }

    public static final UInt randomOrNull(UIntRange arg1, Random arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "random");
        if(arg1.isEmpty()) {
            return null;
        }

        return UInt.box-impl(URandomKt.nextUInt(arg2, arg1));
    }

    private static final ULong randomOrNull(ULongRange arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return URangesKt.randomOrNull(arg1, Random.Default);
    }

    public static final ULong randomOrNull(ULongRange arg1, Random arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "random");
        if(arg1.isEmpty()) {
            return null;
        }

        return ULong.box-impl(URandomKt.nextULong(arg2, arg1));
    }

    public static final UIntProgression reversed(UIntProgression arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        return UIntProgression.Companion.fromClosedRange-Nkh28Cs(arg3.getLast-pVg5ArA(), arg3.getFirst-pVg5ArA(), -arg3.getStep());
    }

    public static final ULongProgression reversed(ULongProgression arg8) {
        Intrinsics.checkNotNullParameter(arg8, "<this>");
        return ULongProgression.Companion.fromClosedRange-7ftBX0g(arg8.getLast-s-VKNKU(), arg8.getFirst-s-VKNKU(), -arg8.getStep());
    }

    public static final UIntProgression step(UIntProgression arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        boolean v0 = arg4 > 0 ? true : false;
        RangesKt.checkStepIsPositive(v0, Integer.valueOf(arg4));
        Companion v0_1 = UIntProgression.Companion;
        int v1 = arg3.getFirst-pVg5ArA();
        int v2 = arg3.getLast-pVg5ArA();
        if(arg3.getStep() > 0) {
        }
        else {
            arg4 = -arg4;
        }

        return v0_1.fromClosedRange-Nkh28Cs(v1, v2, arg4);
    }

    public static final ULongProgression step(ULongProgression arg11, long arg12) {
        Intrinsics.checkNotNullParameter(arg11, "<this>");
        long v0 = 0;
        boolean v2 = arg12 > v0 ? true : false;
        RangesKt.checkStepIsPositive(v2, Long.valueOf(arg12));
        kotlin.ranges.ULongProgression$Companion v4 = ULongProgression.Companion;
        long v5 = arg11.getFirst-s-VKNKU();
        long v7 = arg11.getLast-s-VKNKU();
        if(arg11.getStep() > v0) {
        }
        else {
            arg12 = -arg12;
        }

        return v4.fromClosedRange-7ftBX0g(v5, v7, arg12);
    }

    public static final UIntRange until-5PvTz6A(short arg2, short arg3) {
        int v0 = 0xFFFF;
        int v3 = arg3 & v0;
        if(Intrinsics.compare(v3, 0) <= 0) {
            return UIntRange.Companion.getEMPTY();
        }

        return new UIntRange(UInt.constructor-impl(arg2 & v0), UInt.constructor-impl(UInt.constructor-impl(v3) - 1), null);
    }

    public static final UIntRange until-J1ME1BU(int arg2, int arg3) {
        if(Integer.compareUnsigned(arg3, 0) <= 0) {
            return UIntRange.Companion.getEMPTY();
        }

        return new UIntRange(arg2, UInt.constructor-impl(arg3 - 1), null);
    }

    public static final UIntRange until-Kr8caGY(byte arg2, byte arg3) {
        int v3 = arg3 & 0xFF;
        if(Intrinsics.compare(v3, 0) <= 0) {
            return UIntRange.Companion.getEMPTY();
        }

        return new UIntRange(UInt.constructor-impl(arg2 & 0xFF), UInt.constructor-impl(UInt.constructor-impl(v3) - 1), null);
    }

    public static final ULongRange until-eb3DHEI(long arg6, long arg8) {
        if(Long.compareUnsigned(arg8, 0) <= 0) {
            return ULongRange.Companion.getEMPTY();
        }

        return new ULongRange(arg6, ULong.constructor-impl(arg8 - ULong.constructor-impl(1)), null);
    }
}

