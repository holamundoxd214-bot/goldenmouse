package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;

@Metadata(d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0000\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0005\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000B\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 s2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001sB\u0011\bA\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0087\u008A\u0004¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0000H\u0097\u008A\u0004¢\u0006\u0004\b\u000E\u0010\u000FJ\u0019\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0010H\u0087\u008A\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0013H\u0087\u008A\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u000BH\u0087\u008A\u0004¢\u0006\u0004\b\u0017\u0010\rJ\u0019\u0010\u0016\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\b\u0018\u0010\u000FJ\u0019\u0010\u0016\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u0010H\u0087\u008A\u0004¢\u0006\u0004\b\u0019\u0010\u0012J\u0019\u0010\u0016\u001A\u00020\u00132\u0006\u0010\n\u001A\u00020\u0013H\u0087\u008A\u0004¢\u0006\u0004\b\u001A\u0010\u001BJ\u0019\u0010\u001C\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u000BH\u0087\u008A\u0004¢\u0006\u0004\b\u001D\u0010\rJ\u0019\u0010\u001C\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\b\u001E\u0010\u000FJ\u0019\u0010\u001C\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u0010H\u0087\u008A\u0004¢\u0006\u0004\b\u001F\u0010\u0012J\u0019\u0010\u001C\u001A\u00020\u00132\u0006\u0010\n\u001A\u00020\u0013H\u0087\u008A\u0004¢\u0006\u0004\b \u0010\u001BJ\u0019\u0010!\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u000BH\u0087\u008A\u0004¢\u0006\u0004\b\"\u0010\rJ\u0019\u0010!\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\b#\u0010\u000FJ\u0019\u0010!\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u0010H\u0087\u008A\u0004¢\u0006\u0004\b$\u0010\u0012J\u0019\u0010!\u001A\u00020\u00132\u0006\u0010\n\u001A\u00020\u0013H\u0087\u008A\u0004¢\u0006\u0004\b%\u0010\u001BJ\u0019\u0010&\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u000BH\u0087\u008A\u0004¢\u0006\u0004\b\'\u0010\rJ\u0019\u0010&\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\b(\u0010\u000FJ\u0019\u0010&\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u0010H\u0087\u008A\u0004¢\u0006\u0004\b)\u0010\u0012J\u0019\u0010&\u001A\u00020\u00132\u0006\u0010\n\u001A\u00020\u0013H\u0087\u008A\u0004¢\u0006\u0004\b*\u0010\u001BJ\u0019\u0010+\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u000BH\u0087\u008A\u0004¢\u0006\u0004\b,\u0010\rJ\u0019\u0010+\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\b-\u0010\u000FJ\u0019\u0010+\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u0010H\u0087\u008A\u0004¢\u0006\u0004\b.\u0010\u0012J\u0019\u0010+\u001A\u00020\u00132\u0006\u0010\n\u001A\u00020\u0013H\u0087\u008A\u0004¢\u0006\u0004\b/\u0010\u001BJ\u0019\u00100\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u000BH\u0087\u0088\u0004¢\u0006\u0004\b1\u0010\rJ\u0019\u00100\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u0000H\u0087\u0088\u0004¢\u0006\u0004\b2\u0010\u000FJ\u0019\u00100\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u0010H\u0087\u0088\u0004¢\u0006\u0004\b3\u0010\u0012J\u0019\u00100\u001A\u00020\u00132\u0006\u0010\n\u001A\u00020\u0013H\u0087\u0088\u0004¢\u0006\u0004\b4\u0010\u001BJ\u0019\u00105\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\u000BH\u0087\u0088\u0004¢\u0006\u0004\b6\u00107J\u0019\u00105\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0000H\u0087\u0088\u0004¢\u0006\u0004\b8\u00109J\u0019\u00105\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u0010H\u0087\u0088\u0004¢\u0006\u0004\b:\u0010\u0012J\u0019\u00105\u001A\u00020\u00132\u0006\u0010\n\u001A\u00020\u0013H\u0087\u0088\u0004¢\u0006\u0004\b;\u0010\u001BJ\u0011\u0010<\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\b=\u0010\u0005J\u0011\u0010>\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\b?\u0010\u0005J\u0019\u0010@\u001A\u00020A2\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\bB\u0010CJ\u0019\u0010D\u001A\u00020A2\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\bE\u0010CJ\u0019\u0010F\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008C\u0004¢\u0006\u0004\bG\u00109J\u0019\u0010H\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008C\u0004¢\u0006\u0004\bI\u00109J\u0019\u0010J\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008C\u0004¢\u0006\u0004\bK\u00109J\u0011\u0010L\u001A\u00020\u0000H\u0087\u0088\u0004¢\u0006\u0004\bM\u0010\u0005J\u0011\u0010N\u001A\u00020OH\u0087\u0088\u0004¢\u0006\u0004\bP\u0010QJ\u0011\u0010R\u001A\u00020\u0003H\u0087\u0088\u0004¢\u0006\u0004\bS\u0010\u0005J\u0011\u0010T\u001A\u00020\tH\u0087\u0088\u0004¢\u0006\u0004\bU\u0010VJ\u0011\u0010W\u001A\u00020XH\u0087\u0088\u0004¢\u0006\u0004\bY\u0010ZJ\u0011\u0010[\u001A\u00020\u000BH\u0087\u0088\u0004¢\u0006\u0004\b\\\u0010QJ\u0011\u0010]\u001A\u00020\u0000H\u0087\u0088\u0004¢\u0006\u0004\b^\u0010\u0005J\u0011\u0010_\u001A\u00020\u0010H\u0087\u0088\u0004¢\u0006\u0004\b`\u0010VJ\u0011\u0010a\u001A\u00020\u0013H\u0087\u0088\u0004¢\u0006\u0004\bb\u0010ZJ\u0011\u0010c\u001A\u00020dH\u0087\u0088\u0004¢\u0006\u0004\be\u0010fJ\u0011\u0010g\u001A\u00020hH\u0087\u0088\u0004¢\u0006\u0004\bi\u0010jJ\u0011\u0010k\u001A\u00020lH\u0097\u0080\u0004¢\u0006\u0004\bm\u0010nJ\u0014\u0010o\u001A\u00020p2\b\u0010\n\u001A\u0004\u0018\u00010qHÖ\u0083\u0004J\n\u0010r\u001A\u00020\tHÖ\u0081\u0004R\u0017\u0010\u0002\u001A\u00020\u00038\u0000X\u0081\u0084\b¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006t"}, d2={"Lkotlin/UShort;", "", "data", "", "constructor-impl", "(S)S", "getData$annotations", "()V", "compareTo", "", "other", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "compareTo-xj2QHRw", "(SS)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "plus", "plus-7apg3OU", "plus-xj2QHRw", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "(SJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", "div", "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(SB)B", "mod-xj2QHRw", "(SS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-Mh2AYeg", "dec", "dec-Mh2AYeg", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-xj2QHRw", "and", "and-xj2QHRw", "or", "or-xj2QHRw", "xor", "xor-xj2QHRw", "inv", "inv-Mh2AYeg", "toByte", "", "toByte-impl", "(S)B", "toShort", "toShort-impl", "toInt", "toInt-impl", "(S)I", "toLong", "", "toLong-impl", "(S)J", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", "", "toFloat-impl", "(S)F", "toDouble", "", "toDouble-impl", "(S)D", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) @JvmInline public final class UShort implements Comparable {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\u0007\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0004\n\u0002\u0010\u0006R\u000F\u0010\b\u001A\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\n\u001A\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Lkotlin/UShort$Companion;", "", "<init>", "()V", "MIN_VALUE", "Lkotlin/UShort;", "S", "MAX_VALUE", "SIZE_BYTES", "", "SIZE_BITS", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final Companion Companion = null;
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short data;

    static {
        UShort.Companion = new Companion(null);
    }

    private UShort(short arg1) {
        super();
        this.data = arg1;
    }

    private static final short and-xj2QHRw(short arg0, short arg1) {
        return UShort.constructor-impl(((short)(arg0 & arg1)));
    }

    public static final UShort box-impl(short arg1) {
        return new UShort(arg1);
    }

    public int compareTo(Object arg2) {
        return Intrinsics.compare(this.unbox-impl() & 0xFFFF, ((UShort)arg2).unbox-impl() & 0xFFFF);
    }

    private static final int compareTo-7apg3OU(short arg1, byte arg2) {
        return Intrinsics.compare(arg1 & 0xFFFF, arg2 & 0xFF);
    }

    private static final int compareTo-VKZWuLQ(short arg4, long arg5) {
        return Long.compareUnsigned(ULong.constructor-impl((((long)arg4)) & 0xFFFF), arg5);
    }

    private static final int compareTo-WZ4Q5Ns(short arg1, int arg2) {
        return Integer.compareUnsigned(UInt.constructor-impl(arg1 & 0xFFFF), arg2);
    }

    private int compareTo-xj2QHRw(short arg2) {
        return Intrinsics.compare(this.unbox-impl() & 0xFFFF, arg2 & 0xFFFF);
    }

    private static int compareTo-xj2QHRw(short arg1, short arg2) {
        return Intrinsics.compare(arg1 & 0xFFFF, arg2 & 0xFFFF);
    }

    public static short constructor-impl(short arg0) {
        return arg0;
    }

    private static final short dec-Mh2AYeg(short arg0) {
        return UShort.constructor-impl(((short)(arg0 - 1)));
    }

    private static final int div-7apg3OU(short arg1, byte arg2) {
        return Integer.divideUnsigned(UInt.constructor-impl(arg1 & 0xFFFF), UInt.constructor-impl(arg2 & 0xFF));
    }

    private static final long div-VKZWuLQ(short arg4, long arg5) {
        return Long.divideUnsigned(ULong.constructor-impl((((long)arg4)) & 0xFFFF), arg5);
    }

    private static final int div-WZ4Q5Ns(short arg1, int arg2) {
        return Integer.divideUnsigned(UInt.constructor-impl(arg1 & 0xFFFF), arg2);
    }

    private static final int div-xj2QHRw(short arg1, short arg2) {
        return Integer.divideUnsigned(UInt.constructor-impl(arg1 & 0xFFFF), UInt.constructor-impl(arg2 & 0xFFFF));
    }

    public boolean equals(Object arg1) {
        return UShort.equals-impl(this.data, arg1);
    }

    public static boolean equals-impl(short arg2, Object arg3) {
        if(!(arg3 instanceof UShort)) {
            return 0;
        }

        if(arg2 != ((UShort)arg3).unbox-impl()) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(short arg0, short arg1) {
        if(arg0 == arg1) {
            return 1;
        }

        return 0;
    }

    private static final int floorDiv-7apg3OU(short arg1, byte arg2) {
        return Integer.divideUnsigned(UInt.constructor-impl(arg1 & 0xFFFF), UInt.constructor-impl(arg2 & 0xFF));
    }

    private static final long floorDiv-VKZWuLQ(short arg4, long arg5) {
        return Long.divideUnsigned(ULong.constructor-impl((((long)arg4)) & 0xFFFF), arg5);
    }

    private static final int floorDiv-WZ4Q5Ns(short arg1, int arg2) {
        return Integer.divideUnsigned(UInt.constructor-impl(arg1 & 0xFFFF), arg2);
    }

    private static final int floorDiv-xj2QHRw(short arg1, short arg2) {
        return Integer.divideUnsigned(UInt.constructor-impl(arg1 & 0xFFFF), UInt.constructor-impl(arg2 & 0xFFFF));
    }

    public static void getData$annotations() {
    }

    public int hashCode() {
        return UShort.hashCode-impl(this.data);
    }

    public static int hashCode-impl(short arg0) {
        return Short.hashCode(arg0);
    }

    private static final short inc-Mh2AYeg(short arg0) {
        return UShort.constructor-impl(((short)(arg0 + 1)));
    }

    private static final short inv-Mh2AYeg(short arg0) {
        return UShort.constructor-impl(((short)(~arg0)));
    }

    private static final int minus-7apg3OU(short arg1, byte arg2) {
        return UInt.constructor-impl(UInt.constructor-impl(arg1 & 0xFFFF) - UInt.constructor-impl(arg2 & 0xFF));
    }

    private static final long minus-VKZWuLQ(short arg4, long arg5) {
        return ULong.constructor-impl(ULong.constructor-impl((((long)arg4)) & 0xFFFF) - arg5);
    }

    private static final int minus-WZ4Q5Ns(short arg1, int arg2) {
        return UInt.constructor-impl(UInt.constructor-impl(arg1 & 0xFFFF) - arg2);
    }

    private static final int minus-xj2QHRw(short arg1, short arg2) {
        return UInt.constructor-impl(UInt.constructor-impl(arg1 & 0xFFFF) - UInt.constructor-impl(arg2 & 0xFFFF));
    }

    private static final byte mod-7apg3OU(short arg1, byte arg2) {
        return UByte.constructor-impl(((byte)Integer.remainderUnsigned(UInt.constructor-impl(arg1 & 0xFFFF), UInt.constructor-impl(arg2 & 0xFF))));
    }

    private static final long mod-VKZWuLQ(short arg4, long arg5) {
        return Long.remainderUnsigned(ULong.constructor-impl((((long)arg4)) & 0xFFFF), arg5);
    }

    private static final int mod-WZ4Q5Ns(short arg1, int arg2) {
        return Integer.remainderUnsigned(UInt.constructor-impl(arg1 & 0xFFFF), arg2);
    }

    private static final short mod-xj2QHRw(short arg1, short arg2) {
        return UShort.constructor-impl(((short)Integer.remainderUnsigned(UInt.constructor-impl(arg1 & 0xFFFF), UInt.constructor-impl(arg2 & 0xFFFF))));
    }

    private static final short or-xj2QHRw(short arg0, short arg1) {
        return UShort.constructor-impl(((short)(arg0 | arg1)));
    }

    private static final int plus-7apg3OU(short arg1, byte arg2) {
        return UInt.constructor-impl(UInt.constructor-impl(arg1 & 0xFFFF) + UInt.constructor-impl(arg2 & 0xFF));
    }

    private static final long plus-VKZWuLQ(short arg4, long arg5) {
        return ULong.constructor-impl(ULong.constructor-impl((((long)arg4)) & 0xFFFF) + arg5);
    }

    private static final int plus-WZ4Q5Ns(short arg1, int arg2) {
        return UInt.constructor-impl(UInt.constructor-impl(arg1 & 0xFFFF) + arg2);
    }

    private static final int plus-xj2QHRw(short arg1, short arg2) {
        return UInt.constructor-impl(UInt.constructor-impl(arg1 & 0xFFFF) + UInt.constructor-impl(arg2 & 0xFFFF));
    }

    private static final UIntRange rangeTo-xj2QHRw(short arg2, short arg3) {
        return new UIntRange(UInt.constructor-impl(arg2 & 0xFFFF), UInt.constructor-impl(arg3 & 0xFFFF), null);
    }

    private static final UIntRange rangeUntil-xj2QHRw(short arg1, short arg2) {
        return URangesKt.until-J1ME1BU(UInt.constructor-impl(arg1 & 0xFFFF), UInt.constructor-impl(arg2 & 0xFFFF));
    }

    private static final int rem-7apg3OU(short arg1, byte arg2) {
        return Integer.remainderUnsigned(UInt.constructor-impl(arg1 & 0xFFFF), UInt.constructor-impl(arg2 & 0xFF));
    }

    private static final long rem-VKZWuLQ(short arg4, long arg5) {
        return Long.remainderUnsigned(ULong.constructor-impl((((long)arg4)) & 0xFFFF), arg5);
    }

    private static final int rem-WZ4Q5Ns(short arg1, int arg2) {
        return Integer.remainderUnsigned(UInt.constructor-impl(arg1 & 0xFFFF), arg2);
    }

    private static final int rem-xj2QHRw(short arg1, short arg2) {
        return Integer.remainderUnsigned(UInt.constructor-impl(arg1 & 0xFFFF), UInt.constructor-impl(arg2 & 0xFFFF));
    }

    private static final int times-7apg3OU(short arg1, byte arg2) {
        return UInt.constructor-impl(UInt.constructor-impl(arg1 & 0xFFFF) * UInt.constructor-impl(arg2 & 0xFF));
    }

    private static final long times-VKZWuLQ(short arg4, long arg5) {
        return ULong.constructor-impl(ULong.constructor-impl((((long)arg4)) & 0xFFFF) * arg5);
    }

    private static final int times-WZ4Q5Ns(short arg1, int arg2) {
        return UInt.constructor-impl(UInt.constructor-impl(arg1 & 0xFFFF) * arg2);
    }

    private static final int times-xj2QHRw(short arg1, short arg2) {
        return UInt.constructor-impl(UInt.constructor-impl(arg1 & 0xFFFF) * UInt.constructor-impl(arg2 & 0xFFFF));
    }

    private static final byte toByte-impl(short arg0) {
        return ((byte)arg0);
    }

    private static final double toDouble-impl(short arg2) {
        return UnsignedKt.uintToDouble(arg2 & 0xFFFF);
    }

    private static final float toFloat-impl(short arg2) {
        return ((float)UnsignedKt.uintToDouble(arg2 & 0xFFFF));
    }

    private static final int toInt-impl(short arg1) {
        return arg1 & 0xFFFF;
    }

    private static final long toLong-impl(short arg4) {
        return (((long)arg4)) & 0xFFFF;
    }

    private static final short toShort-impl(short arg0) {
        return arg0;
    }

    public String toString() {
        return UShort.toString-impl(this.data);
    }

    public static String toString-impl(short arg1) {
        return String.valueOf(arg1 & 0xFFFF);
    }

    private static final byte toUByte-w2LRezQ(short arg0) {
        return UByte.constructor-impl(((byte)arg0));
    }

    private static final int toUInt-pVg5ArA(short arg1) {
        return UInt.constructor-impl(arg1 & 0xFFFF);
    }

    private static final long toULong-s-VKNKU(short arg4) {
        return ULong.constructor-impl((((long)arg4)) & 0xFFFF);
    }

    private static final short toUShort-Mh2AYeg(short arg0) {
        return arg0;
    }

    public final short unbox-impl() {
        return this.data;
    }

    private static final short xor-xj2QHRw(short arg0, short arg1) {
        return UShort.constructor-impl(((short)(arg0 ^ arg1)));
    }
}

