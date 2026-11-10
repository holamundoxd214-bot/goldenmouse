package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;

@Metadata(d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000B\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 s2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001sB\u0011\bA\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0000H\u0097\u008A\u0004¢\u0006\u0004\b\u000B\u0010\fJ\u0019\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\rH\u0087\u008A\u0004¢\u0006\u0004\b\u000E\u0010\u000FJ\u0019\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0010H\u0087\u008A\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0013H\u0087\u008A\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\b\u0017\u0010\fJ\u0019\u0010\u0016\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\rH\u0087\u008A\u0004¢\u0006\u0004\b\u0018\u0010\u000FJ\u0019\u0010\u0016\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u0010H\u0087\u008A\u0004¢\u0006\u0004\b\u0019\u0010\u0012J\u0019\u0010\u0016\u001A\u00020\u00132\u0006\u0010\n\u001A\u00020\u0013H\u0087\u008A\u0004¢\u0006\u0004\b\u001A\u0010\u001BJ\u0019\u0010\u001C\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\b\u001D\u0010\fJ\u0019\u0010\u001C\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\rH\u0087\u008A\u0004¢\u0006\u0004\b\u001E\u0010\u000FJ\u0019\u0010\u001C\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u0010H\u0087\u008A\u0004¢\u0006\u0004\b\u001F\u0010\u0012J\u0019\u0010\u001C\u001A\u00020\u00132\u0006\u0010\n\u001A\u00020\u0013H\u0087\u008A\u0004¢\u0006\u0004\b \u0010\u001BJ\u0019\u0010!\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\b\"\u0010\fJ\u0019\u0010!\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\rH\u0087\u008A\u0004¢\u0006\u0004\b#\u0010\u000FJ\u0019\u0010!\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u0010H\u0087\u008A\u0004¢\u0006\u0004\b$\u0010\u0012J\u0019\u0010!\u001A\u00020\u00132\u0006\u0010\n\u001A\u00020\u0013H\u0087\u008A\u0004¢\u0006\u0004\b%\u0010\u001BJ\u0019\u0010&\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\b\'\u0010\fJ\u0019\u0010&\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\rH\u0087\u008A\u0004¢\u0006\u0004\b(\u0010\u000FJ\u0019\u0010&\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u0010H\u0087\u008A\u0004¢\u0006\u0004\b)\u0010\u0012J\u0019\u0010&\u001A\u00020\u00132\u0006\u0010\n\u001A\u00020\u0013H\u0087\u008A\u0004¢\u0006\u0004\b*\u0010\u001BJ\u0019\u0010+\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\b,\u0010\fJ\u0019\u0010+\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\rH\u0087\u008A\u0004¢\u0006\u0004\b-\u0010\u000FJ\u0019\u0010+\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u0010H\u0087\u008A\u0004¢\u0006\u0004\b.\u0010\u0012J\u0019\u0010+\u001A\u00020\u00132\u0006\u0010\n\u001A\u00020\u0013H\u0087\u008A\u0004¢\u0006\u0004\b/\u0010\u001BJ\u0019\u00100\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u0000H\u0087\u0088\u0004¢\u0006\u0004\b1\u0010\fJ\u0019\u00100\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\rH\u0087\u0088\u0004¢\u0006\u0004\b2\u0010\u000FJ\u0019\u00100\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u0010H\u0087\u0088\u0004¢\u0006\u0004\b3\u0010\u0012J\u0019\u00100\u001A\u00020\u00132\u0006\u0010\n\u001A\u00020\u0013H\u0087\u0088\u0004¢\u0006\u0004\b4\u0010\u001BJ\u0019\u00105\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0000H\u0087\u0088\u0004¢\u0006\u0004\b6\u00107J\u0019\u00105\u001A\u00020\r2\u0006\u0010\n\u001A\u00020\rH\u0087\u0088\u0004¢\u0006\u0004\b8\u00109J\u0019\u00105\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u0010H\u0087\u0088\u0004¢\u0006\u0004\b:\u0010\u0012J\u0019\u00105\u001A\u00020\u00132\u0006\u0010\n\u001A\u00020\u0013H\u0087\u0088\u0004¢\u0006\u0004\b;\u0010\u001BJ\u0011\u0010<\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\b=\u0010\u0005J\u0011\u0010>\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\b?\u0010\u0005J\u0019\u0010@\u001A\u00020A2\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\bB\u0010CJ\u0019\u0010D\u001A\u00020A2\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\bE\u0010CJ\u0019\u0010F\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008C\u0004¢\u0006\u0004\bG\u00107J\u0019\u0010H\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008C\u0004¢\u0006\u0004\bI\u00107J\u0019\u0010J\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008C\u0004¢\u0006\u0004\bK\u00107J\u0011\u0010L\u001A\u00020\u0000H\u0087\u0088\u0004¢\u0006\u0004\bM\u0010\u0005J\u0011\u0010N\u001A\u00020\u0003H\u0087\u0088\u0004¢\u0006\u0004\bO\u0010\u0005J\u0011\u0010P\u001A\u00020QH\u0087\u0088\u0004¢\u0006\u0004\bR\u0010SJ\u0011\u0010T\u001A\u00020\tH\u0087\u0088\u0004¢\u0006\u0004\bU\u0010VJ\u0011\u0010W\u001A\u00020XH\u0087\u0088\u0004¢\u0006\u0004\bY\u0010ZJ\u0011\u0010[\u001A\u00020\u0000H\u0087\u0088\u0004¢\u0006\u0004\b\\\u0010\u0005J\u0011\u0010]\u001A\u00020\rH\u0087\u0088\u0004¢\u0006\u0004\b^\u0010SJ\u0011\u0010_\u001A\u00020\u0010H\u0087\u0088\u0004¢\u0006\u0004\b`\u0010VJ\u0011\u0010a\u001A\u00020\u0013H\u0087\u0088\u0004¢\u0006\u0004\bb\u0010ZJ\u0011\u0010c\u001A\u00020dH\u0087\u0088\u0004¢\u0006\u0004\be\u0010fJ\u0011\u0010g\u001A\u00020hH\u0087\u0088\u0004¢\u0006\u0004\bi\u0010jJ\u0011\u0010k\u001A\u00020lH\u0097\u0080\u0004¢\u0006\u0004\bm\u0010nJ\u0014\u0010o\u001A\u00020p2\b\u0010\n\u001A\u0004\u0018\u00010qHÖ\u0083\u0004J\n\u0010r\u001A\u00020\tHÖ\u0081\u0004R\u0017\u0010\u0002\u001A\u00020\u00038\u0000X\u0081\u0084\b¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006t"}, d2={"Lkotlin/UByte;", "", "data", "", "constructor-impl", "(B)B", "getData$annotations", "()V", "compareTo", "", "other", "compareTo-7apg3OU", "(BB)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "plus", "plus-7apg3OU", "plus-xj2QHRw", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "(BJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", "div", "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(BB)B", "mod-xj2QHRw", "(BS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-w2LRezQ", "dec", "dec-w2LRezQ", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-7apg3OU", "and", "and-7apg3OU", "or", "or-7apg3OU", "xor", "xor-7apg3OU", "inv", "inv-w2LRezQ", "toByte", "toByte-impl", "toShort", "", "toShort-impl", "(B)S", "toInt", "toInt-impl", "(B)I", "toLong", "", "toLong-impl", "(B)J", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", "", "toFloat-impl", "(B)F", "toDouble", "", "toDouble-impl", "(B)D", "toString", "", "toString-impl", "(B)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) @JvmInline public final class UByte implements Comparable {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\u0007\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0004\n\u0002\u0010\u0006R\u000F\u0010\b\u001A\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\n\u001A\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Lkotlin/UByte$Companion;", "", "<init>", "()V", "MIN_VALUE", "Lkotlin/UByte;", "B", "MAX_VALUE", "SIZE_BYTES", "", "SIZE_BITS", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final Companion Companion = null;
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    private final byte data;

    static {
        UByte.Companion = new Companion(null);
    }

    private UByte(byte arg1) {
        super();
        this.data = arg1;
    }

    private static final byte and-7apg3OU(byte arg0, byte arg1) {
        return UByte.constructor-impl(((byte)(arg0 & arg1)));
    }

    public static final UByte box-impl(byte arg1) {
        return new UByte(arg1);
    }

    public int compareTo(Object arg1) {
        return Intrinsics.compare(this.unbox-impl() & 0xFF, ((UByte)arg1).unbox-impl() & 0xFF);
    }

    private int compareTo-7apg3OU(byte arg1) {
        return Intrinsics.compare(this.unbox-impl() & 0xFF, arg1 & 0xFF);
    }

    private static int compareTo-7apg3OU(byte arg0, byte arg1) {
        return Intrinsics.compare(arg0 & 0xFF, arg1 & 0xFF);
    }

    private static final int compareTo-VKZWuLQ(byte arg4, long arg5) {
        return Long.compareUnsigned(ULong.constructor-impl((((long)arg4)) & 0xFF), arg5);
    }

    private static final int compareTo-WZ4Q5Ns(byte arg0, int arg1) {
        return Integer.compareUnsigned(UInt.constructor-impl(arg0 & 0xFF), arg1);
    }

    private static final int compareTo-xj2QHRw(byte arg1, short arg2) {
        return Intrinsics.compare(arg1 & 0xFF, arg2 & 0xFFFF);
    }

    public static byte constructor-impl(byte arg0) {
        return arg0;
    }

    private static final byte dec-w2LRezQ(byte arg0) {
        return UByte.constructor-impl(((byte)(arg0 - 1)));
    }

    private static final int div-7apg3OU(byte arg0, byte arg1) {
        return Integer.divideUnsigned(UInt.constructor-impl(arg0 & 0xFF), UInt.constructor-impl(arg1 & 0xFF));
    }

    private static final long div-VKZWuLQ(byte arg4, long arg5) {
        return Long.divideUnsigned(ULong.constructor-impl((((long)arg4)) & 0xFF), arg5);
    }

    private static final int div-WZ4Q5Ns(byte arg0, int arg1) {
        return Integer.divideUnsigned(UInt.constructor-impl(arg0 & 0xFF), arg1);
    }

    private static final int div-xj2QHRw(byte arg1, short arg2) {
        return Integer.divideUnsigned(UInt.constructor-impl(arg1 & 0xFF), UInt.constructor-impl(arg2 & 0xFFFF));
    }

    public boolean equals(Object arg1) {
        return UByte.equals-impl(this.data, arg1);
    }

    public static boolean equals-impl(byte arg2, Object arg3) {
        if(!(arg3 instanceof UByte)) {
            return 0;
        }

        if(arg2 != ((UByte)arg3).unbox-impl()) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(byte arg0, byte arg1) {
        if(arg0 == arg1) {
            return 1;
        }

        return 0;
    }

    private static final int floorDiv-7apg3OU(byte arg0, byte arg1) {
        return Integer.divideUnsigned(UInt.constructor-impl(arg0 & 0xFF), UInt.constructor-impl(arg1 & 0xFF));
    }

    private static final long floorDiv-VKZWuLQ(byte arg4, long arg5) {
        return Long.divideUnsigned(ULong.constructor-impl((((long)arg4)) & 0xFF), arg5);
    }

    private static final int floorDiv-WZ4Q5Ns(byte arg0, int arg1) {
        return Integer.divideUnsigned(UInt.constructor-impl(arg0 & 0xFF), arg1);
    }

    private static final int floorDiv-xj2QHRw(byte arg1, short arg2) {
        return Integer.divideUnsigned(UInt.constructor-impl(arg1 & 0xFF), UInt.constructor-impl(arg2 & 0xFFFF));
    }

    public static void getData$annotations() {
    }

    public int hashCode() {
        return UByte.hashCode-impl(this.data);
    }

    public static int hashCode-impl(byte arg0) {
        return Byte.hashCode(arg0);
    }

    private static final byte inc-w2LRezQ(byte arg0) {
        return UByte.constructor-impl(((byte)(arg0 + 1)));
    }

    private static final byte inv-w2LRezQ(byte arg0) {
        return UByte.constructor-impl(((byte)(~arg0)));
    }

    private static final int minus-7apg3OU(byte arg0, byte arg1) {
        return UInt.constructor-impl(UInt.constructor-impl(arg0 & 0xFF) - UInt.constructor-impl(arg1 & 0xFF));
    }

    private static final long minus-VKZWuLQ(byte arg4, long arg5) {
        return ULong.constructor-impl(ULong.constructor-impl((((long)arg4)) & 0xFF) - arg5);
    }

    private static final int minus-WZ4Q5Ns(byte arg0, int arg1) {
        return UInt.constructor-impl(UInt.constructor-impl(arg0 & 0xFF) - arg1);
    }

    private static final int minus-xj2QHRw(byte arg1, short arg2) {
        return UInt.constructor-impl(UInt.constructor-impl(arg1 & 0xFF) - UInt.constructor-impl(arg2 & 0xFFFF));
    }

    private static final byte mod-7apg3OU(byte arg0, byte arg1) {
        return UByte.constructor-impl(((byte)Integer.remainderUnsigned(UInt.constructor-impl(arg0 & 0xFF), UInt.constructor-impl(arg1 & 0xFF))));
    }

    private static final long mod-VKZWuLQ(byte arg4, long arg5) {
        return Long.remainderUnsigned(ULong.constructor-impl((((long)arg4)) & 0xFF), arg5);
    }

    private static final int mod-WZ4Q5Ns(byte arg0, int arg1) {
        return Integer.remainderUnsigned(UInt.constructor-impl(arg0 & 0xFF), arg1);
    }

    private static final short mod-xj2QHRw(byte arg1, short arg2) {
        return UShort.constructor-impl(((short)Integer.remainderUnsigned(UInt.constructor-impl(arg1 & 0xFF), UInt.constructor-impl(arg2 & 0xFFFF))));
    }

    private static final byte or-7apg3OU(byte arg0, byte arg1) {
        return UByte.constructor-impl(((byte)(arg0 | arg1)));
    }

    private static final int plus-7apg3OU(byte arg0, byte arg1) {
        return UInt.constructor-impl(UInt.constructor-impl(arg0 & 0xFF) + UInt.constructor-impl(arg1 & 0xFF));
    }

    private static final long plus-VKZWuLQ(byte arg4, long arg5) {
        return ULong.constructor-impl(ULong.constructor-impl((((long)arg4)) & 0xFF) + arg5);
    }

    private static final int plus-WZ4Q5Ns(byte arg0, int arg1) {
        return UInt.constructor-impl(UInt.constructor-impl(arg0 & 0xFF) + arg1);
    }

    private static final int plus-xj2QHRw(byte arg1, short arg2) {
        return UInt.constructor-impl(UInt.constructor-impl(arg1 & 0xFF) + UInt.constructor-impl(arg2 & 0xFFFF));
    }

    private static final UIntRange rangeTo-7apg3OU(byte arg2, byte arg3) {
        return new UIntRange(UInt.constructor-impl(arg2 & 0xFF), UInt.constructor-impl(arg3 & 0xFF), null);
    }

    private static final UIntRange rangeUntil-7apg3OU(byte arg0, byte arg1) {
        return URangesKt.until-J1ME1BU(UInt.constructor-impl(arg0 & 0xFF), UInt.constructor-impl(arg1 & 0xFF));
    }

    private static final int rem-7apg3OU(byte arg0, byte arg1) {
        return Integer.remainderUnsigned(UInt.constructor-impl(arg0 & 0xFF), UInt.constructor-impl(arg1 & 0xFF));
    }

    private static final long rem-VKZWuLQ(byte arg4, long arg5) {
        return Long.remainderUnsigned(ULong.constructor-impl((((long)arg4)) & 0xFF), arg5);
    }

    private static final int rem-WZ4Q5Ns(byte arg0, int arg1) {
        return Integer.remainderUnsigned(UInt.constructor-impl(arg0 & 0xFF), arg1);
    }

    private static final int rem-xj2QHRw(byte arg1, short arg2) {
        return Integer.remainderUnsigned(UInt.constructor-impl(arg1 & 0xFF), UInt.constructor-impl(arg2 & 0xFFFF));
    }

    private static final int times-7apg3OU(byte arg0, byte arg1) {
        return UInt.constructor-impl(UInt.constructor-impl(arg0 & 0xFF) * UInt.constructor-impl(arg1 & 0xFF));
    }

    private static final long times-VKZWuLQ(byte arg4, long arg5) {
        return ULong.constructor-impl(ULong.constructor-impl((((long)arg4)) & 0xFF) * arg5);
    }

    private static final int times-WZ4Q5Ns(byte arg0, int arg1) {
        return UInt.constructor-impl(UInt.constructor-impl(arg0 & 0xFF) * arg1);
    }

    private static final int times-xj2QHRw(byte arg1, short arg2) {
        return UInt.constructor-impl(UInt.constructor-impl(arg1 & 0xFF) * UInt.constructor-impl(arg2 & 0xFFFF));
    }

    private static final byte toByte-impl(byte arg0) {
        return arg0;
    }

    private static final double toDouble-impl(byte arg2) {
        return UnsignedKt.uintToDouble(arg2 & 0xFF);
    }

    private static final float toFloat-impl(byte arg2) {
        return ((float)UnsignedKt.uintToDouble(arg2 & 0xFF));
    }

    private static final int toInt-impl(byte arg0) {
        return arg0 & 0xFF;
    }

    private static final long toLong-impl(byte arg4) {
        return (((long)arg4)) & 0xFF;
    }

    private static final short toShort-impl(byte arg0) {
        return ((short)((((short)arg0)) & 0xFF));
    }

    public String toString() {
        return UByte.toString-impl(this.data);
    }

    public static String toString-impl(byte arg0) {
        return String.valueOf(arg0 & 0xFF);
    }

    private static final byte toUByte-w2LRezQ(byte arg0) {
        return arg0;
    }

    private static final int toUInt-pVg5ArA(byte arg0) {
        return UInt.constructor-impl(arg0 & 0xFF);
    }

    private static final long toULong-s-VKNKU(byte arg4) {
        return ULong.constructor-impl((((long)arg4)) & 0xFF);
    }

    private static final short toUShort-Mh2AYeg(byte arg0) {
        return UShort.constructor-impl(((short)((((short)arg0)) & 0xFF)));
    }

    public final byte unbox-impl() {
        return this.data;
    }

    private static final byte xor-7apg3OU(byte arg0, byte arg1) {
        return UByte.constructor-impl(((byte)(arg0 ^ arg1)));
    }
}

