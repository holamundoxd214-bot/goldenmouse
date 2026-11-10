package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;

@Metadata(d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000B\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 x2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001xB\u0011\bA\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\nH\u0087\u008A\u0004¢\u0006\u0004\b\u000B\u0010\fJ\u0019\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\rH\u0087\u008A\u0004¢\u0006\u0004\b\u000E\u0010\u000FJ\u0019\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u0000H\u0097\u008A\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u0012H\u0087\u008A\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\nH\u0087\u008A\u0004¢\u0006\u0004\b\u0016\u0010\fJ\u0019\u0010\u0015\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\rH\u0087\u008A\u0004¢\u0006\u0004\b\u0017\u0010\u000FJ\u0019\u0010\u0015\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\b\u0018\u0010\u0011J\u0019\u0010\u0015\u001A\u00020\u00122\u0006\u0010\t\u001A\u00020\u0012H\u0087\u008A\u0004¢\u0006\u0004\b\u0019\u0010\u001AJ\u0019\u0010\u001B\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\nH\u0087\u008A\u0004¢\u0006\u0004\b\u001C\u0010\fJ\u0019\u0010\u001B\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\rH\u0087\u008A\u0004¢\u0006\u0004\b\u001D\u0010\u000FJ\u0019\u0010\u001B\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\b\u001E\u0010\u0011J\u0019\u0010\u001B\u001A\u00020\u00122\u0006\u0010\t\u001A\u00020\u0012H\u0087\u008A\u0004¢\u0006\u0004\b\u001F\u0010\u001AJ\u0019\u0010 \u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\nH\u0087\u008A\u0004¢\u0006\u0004\b!\u0010\fJ\u0019\u0010 \u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\rH\u0087\u008A\u0004¢\u0006\u0004\b\"\u0010\u000FJ\u0019\u0010 \u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\b#\u0010\u0011J\u0019\u0010 \u001A\u00020\u00122\u0006\u0010\t\u001A\u00020\u0012H\u0087\u008A\u0004¢\u0006\u0004\b$\u0010\u001AJ\u0019\u0010%\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\nH\u0087\u008A\u0004¢\u0006\u0004\b&\u0010\fJ\u0019\u0010%\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\rH\u0087\u008A\u0004¢\u0006\u0004\b\'\u0010\u000FJ\u0019\u0010%\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\b(\u0010\u0011J\u0019\u0010%\u001A\u00020\u00122\u0006\u0010\t\u001A\u00020\u0012H\u0087\u008A\u0004¢\u0006\u0004\b)\u0010\u001AJ\u0019\u0010*\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\nH\u0087\u008A\u0004¢\u0006\u0004\b+\u0010\fJ\u0019\u0010*\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\rH\u0087\u008A\u0004¢\u0006\u0004\b,\u0010\u000FJ\u0019\u0010*\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\b-\u0010\u0011J\u0019\u0010*\u001A\u00020\u00122\u0006\u0010\t\u001A\u00020\u0012H\u0087\u008A\u0004¢\u0006\u0004\b.\u0010\u001AJ\u0019\u0010/\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\nH\u0087\u0088\u0004¢\u0006\u0004\b0\u0010\fJ\u0019\u0010/\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\rH\u0087\u0088\u0004¢\u0006\u0004\b1\u0010\u000FJ\u0019\u0010/\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\u0000H\u0087\u0088\u0004¢\u0006\u0004\b2\u0010\u0011J\u0019\u0010/\u001A\u00020\u00122\u0006\u0010\t\u001A\u00020\u0012H\u0087\u0088\u0004¢\u0006\u0004\b3\u0010\u001AJ\u0019\u00104\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\nH\u0087\u0088\u0004¢\u0006\u0004\b5\u00106J\u0019\u00104\u001A\u00020\r2\u0006\u0010\t\u001A\u00020\rH\u0087\u0088\u0004¢\u0006\u0004\b7\u00108J\u0019\u00104\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\u0000H\u0087\u0088\u0004¢\u0006\u0004\b9\u0010\u0011J\u0019\u00104\u001A\u00020\u00122\u0006\u0010\t\u001A\u00020\u0012H\u0087\u0088\u0004¢\u0006\u0004\b:\u0010\u001AJ\u0011\u0010;\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\b<\u0010\u0005J\u0011\u0010=\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\b>\u0010\u0005J\u0019\u0010?\u001A\u00020@2\u0006\u0010\t\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\bA\u0010BJ\u0019\u0010C\u001A\u00020@2\u0006\u0010\t\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\bD\u0010BJ\u0019\u0010E\u001A\u00020\u00002\u0006\u0010F\u001A\u00020\u0003H\u0087\u008C\u0004¢\u0006\u0004\bG\u0010\u0011J\u0019\u0010H\u001A\u00020\u00002\u0006\u0010F\u001A\u00020\u0003H\u0087\u008C\u0004¢\u0006\u0004\bI\u0010\u0011J\u0019\u0010J\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\u0000H\u0087\u008C\u0004¢\u0006\u0004\bK\u0010\u0011J\u0019\u0010L\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\u0000H\u0087\u008C\u0004¢\u0006\u0004\bM\u0010\u0011J\u0019\u0010N\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\u0000H\u0087\u008C\u0004¢\u0006\u0004\bO\u0010\u0011J\u0011\u0010P\u001A\u00020\u0000H\u0087\u0088\u0004¢\u0006\u0004\bQ\u0010\u0005J\u0011\u0010R\u001A\u00020SH\u0087\u0088\u0004¢\u0006\u0004\bT\u0010UJ\u0011\u0010V\u001A\u00020WH\u0087\u0088\u0004¢\u0006\u0004\bX\u0010YJ\u0011\u0010Z\u001A\u00020\u0003H\u0087\u0088\u0004¢\u0006\u0004\b[\u0010\u0005J\u0011\u0010\\\u001A\u00020]H\u0087\u0088\u0004¢\u0006\u0004\b^\u0010_J\u0011\u0010`\u001A\u00020\nH\u0087\u0088\u0004¢\u0006\u0004\ba\u0010UJ\u0011\u0010b\u001A\u00020\rH\u0087\u0088\u0004¢\u0006\u0004\bc\u0010YJ\u0011\u0010d\u001A\u00020\u0000H\u0087\u0088\u0004¢\u0006\u0004\be\u0010\u0005J\u0011\u0010f\u001A\u00020\u0012H\u0087\u0088\u0004¢\u0006\u0004\bg\u0010_J\u0011\u0010h\u001A\u00020iH\u0087\u0088\u0004¢\u0006\u0004\bj\u0010kJ\u0011\u0010l\u001A\u00020mH\u0087\u0088\u0004¢\u0006\u0004\bn\u0010oJ\u0011\u0010p\u001A\u00020qH\u0097\u0080\u0004¢\u0006\u0004\br\u0010sJ\u0014\u0010t\u001A\u00020u2\b\u0010\t\u001A\u0004\u0018\u00010vHÖ\u0083\u0004J\n\u0010w\u001A\u00020\u0003HÖ\u0081\u0004R\u0017\u0010\u0002\u001A\u00020\u00038\u0000X\u0081\u0084\b¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006y"}, d2={"Lkotlin/UInt;", "", "data", "", "constructor-impl", "(I)I", "getData$annotations", "()V", "compareTo", "other", "Lkotlin/UByte;", "compareTo-7apg3OU", "(IB)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "compareTo-WZ4Q5Ns", "(II)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "plus", "plus-7apg3OU", "plus-xj2QHRw", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "(IJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", "div", "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(IB)B", "mod-xj2QHRw", "(IS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-pVg5ArA", "dec", "dec-pVg5ArA", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-WZ4Q5Ns", "shl", "bitCount", "shl-pVg5ArA", "shr", "shr-pVg5ArA", "and", "and-WZ4Q5Ns", "or", "or-WZ4Q5Ns", "xor", "xor-WZ4Q5Ns", "inv", "inv-pVg5ArA", "toByte", "", "toByte-impl", "(I)B", "toShort", "", "toShort-impl", "(I)S", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(I)J", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", "", "toFloat-impl", "(I)F", "toDouble", "", "toDouble-impl", "(I)D", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) @JvmInline public final class UInt implements Comparable {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\u0007\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0004\n\u0002\u0010\u0006R\u000F\u0010\b\u001A\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\n\u001A\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Lkotlin/UInt$Companion;", "", "<init>", "()V", "MIN_VALUE", "Lkotlin/UInt;", "I", "MAX_VALUE", "SIZE_BYTES", "", "SIZE_BITS", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final Companion Companion = null;
    public static final int MAX_VALUE = -1;
    public static final int MIN_VALUE = 0;
    public static final int SIZE_BITS = 0x20;
    public static final int SIZE_BYTES = 4;
    private final int data;

    static {
        UInt.Companion = new Companion(null);
    }

    private UInt(int arg1) {
        super();
        this.data = arg1;
    }

    private static final int and-WZ4Q5Ns(int arg0, int arg1) {
        return UInt.constructor-impl(arg0 & arg1);
    }

    public static final UInt box-impl(int arg1) {
        return new UInt(arg1);
    }

    public int compareTo(Object arg1) {
        return UnsignedKt.uintCompare(this.unbox-impl(), ((UInt)arg1).unbox-impl());
    }

    private static final int compareTo-7apg3OU(int arg0, byte arg1) {
        return Integer.compareUnsigned(arg0, UInt.constructor-impl(arg1 & 0xFF));
    }

    private static final int compareTo-VKZWuLQ(int arg4, long arg5) {
        return Long.compareUnsigned(ULong.constructor-impl((((long)arg4)) & 0xFFFFFFFFL), arg5);
    }

    private int compareTo-WZ4Q5Ns(int arg1) {
        return UnsignedKt.uintCompare(this.unbox-impl(), arg1);
    }

    private static int compareTo-WZ4Q5Ns(int arg0, int arg1) {
        return UnsignedKt.uintCompare(arg0, arg1);
    }

    private static final int compareTo-xj2QHRw(int arg1, short arg2) {
        return Integer.compareUnsigned(arg1, UInt.constructor-impl(arg2 & 0xFFFF));
    }

    public static int constructor-impl(int arg0) {
        return arg0;
    }

    private static final int dec-pVg5ArA(int arg0) {
        return UInt.constructor-impl(arg0 - 1);
    }

    private static final int div-7apg3OU(int arg0, byte arg1) {
        return Integer.divideUnsigned(arg0, UInt.constructor-impl(arg1 & 0xFF));
    }

    private static final long div-VKZWuLQ(int arg4, long arg5) {
        return Long.divideUnsigned(ULong.constructor-impl((((long)arg4)) & 0xFFFFFFFFL), arg5);
    }

    private static final int div-WZ4Q5Ns(int arg0, int arg1) {
        return UnsignedKt.uintDivide-J1ME1BU(arg0, arg1);
    }

    private static final int div-xj2QHRw(int arg1, short arg2) {
        return Integer.divideUnsigned(arg1, UInt.constructor-impl(arg2 & 0xFFFF));
    }

    public boolean equals(Object arg1) {
        return UInt.equals-impl(this.data, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof UInt)) {
            return 0;
        }

        if(arg2 != ((UInt)arg3).unbox-impl()) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(int arg0, int arg1) {
        if(arg0 == arg1) {
            return 1;
        }

        return 0;
    }

    private static final int floorDiv-7apg3OU(int arg0, byte arg1) {
        return Integer.divideUnsigned(arg0, UInt.constructor-impl(arg1 & 0xFF));
    }

    private static final long floorDiv-VKZWuLQ(int arg4, long arg5) {
        return Long.divideUnsigned(ULong.constructor-impl((((long)arg4)) & 0xFFFFFFFFL), arg5);
    }

    private static final int floorDiv-WZ4Q5Ns(int arg0, int arg1) {
        return Integer.divideUnsigned(arg0, arg1);
    }

    private static final int floorDiv-xj2QHRw(int arg1, short arg2) {
        return Integer.divideUnsigned(arg1, UInt.constructor-impl(arg2 & 0xFFFF));
    }

    public static void getData$annotations() {
    }

    public int hashCode() {
        return UInt.hashCode-impl(this.data);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    private static final int inc-pVg5ArA(int arg0) {
        return UInt.constructor-impl(arg0 + 1);
    }

    private static final int inv-pVg5ArA(int arg0) {
        return UInt.constructor-impl(~arg0);
    }

    private static final int minus-7apg3OU(int arg0, byte arg1) {
        return UInt.constructor-impl(arg0 - UInt.constructor-impl(arg1 & 0xFF));
    }

    private static final long minus-VKZWuLQ(int arg4, long arg5) {
        return ULong.constructor-impl(ULong.constructor-impl((((long)arg4)) & 0xFFFFFFFFL) - arg5);
    }

    private static final int minus-WZ4Q5Ns(int arg0, int arg1) {
        return UInt.constructor-impl(arg0 - arg1);
    }

    private static final int minus-xj2QHRw(int arg1, short arg2) {
        return UInt.constructor-impl(arg1 - UInt.constructor-impl(arg2 & 0xFFFF));
    }

    private static final byte mod-7apg3OU(int arg0, byte arg1) {
        return UByte.constructor-impl(((byte)Integer.remainderUnsigned(arg0, UInt.constructor-impl(arg1 & 0xFF))));
    }

    private static final long mod-VKZWuLQ(int arg4, long arg5) {
        return Long.remainderUnsigned(ULong.constructor-impl((((long)arg4)) & 0xFFFFFFFFL), arg5);
    }

    private static final int mod-WZ4Q5Ns(int arg0, int arg1) {
        return Integer.remainderUnsigned(arg0, arg1);
    }

    private static final short mod-xj2QHRw(int arg1, short arg2) {
        return UShort.constructor-impl(((short)Integer.remainderUnsigned(arg1, UInt.constructor-impl(arg2 & 0xFFFF))));
    }

    private static final int or-WZ4Q5Ns(int arg0, int arg1) {
        return UInt.constructor-impl(arg0 | arg1);
    }

    private static final int plus-7apg3OU(int arg0, byte arg1) {
        return UInt.constructor-impl(arg0 + UInt.constructor-impl(arg1 & 0xFF));
    }

    private static final long plus-VKZWuLQ(int arg4, long arg5) {
        return ULong.constructor-impl(ULong.constructor-impl((((long)arg4)) & 0xFFFFFFFFL) + arg5);
    }

    private static final int plus-WZ4Q5Ns(int arg0, int arg1) {
        return UInt.constructor-impl(arg0 + arg1);
    }

    private static final int plus-xj2QHRw(int arg1, short arg2) {
        return UInt.constructor-impl(arg1 + UInt.constructor-impl(arg2 & 0xFFFF));
    }

    private static final UIntRange rangeTo-WZ4Q5Ns(int arg2, int arg3) {
        return new UIntRange(arg2, arg3, null);
    }

    private static final UIntRange rangeUntil-WZ4Q5Ns(int arg0, int arg1) {
        return URangesKt.until-J1ME1BU(arg0, arg1);
    }

    private static final int rem-7apg3OU(int arg0, byte arg1) {
        return Integer.remainderUnsigned(arg0, UInt.constructor-impl(arg1 & 0xFF));
    }

    private static final long rem-VKZWuLQ(int arg4, long arg5) {
        return Long.remainderUnsigned(ULong.constructor-impl((((long)arg4)) & 0xFFFFFFFFL), arg5);
    }

    private static final int rem-WZ4Q5Ns(int arg0, int arg1) {
        return UnsignedKt.uintRemainder-J1ME1BU(arg0, arg1);
    }

    private static final int rem-xj2QHRw(int arg1, short arg2) {
        return Integer.remainderUnsigned(arg1, UInt.constructor-impl(arg2 & 0xFFFF));
    }

    private static final int shl-pVg5ArA(int arg0, int arg1) {
        return UInt.constructor-impl(arg0 << arg1);
    }

    private static final int shr-pVg5ArA(int arg0, int arg1) {
        return UInt.constructor-impl(arg0 >>> arg1);
    }

    private static final int times-7apg3OU(int arg0, byte arg1) {
        return UInt.constructor-impl(arg0 * UInt.constructor-impl(arg1 & 0xFF));
    }

    private static final long times-VKZWuLQ(int arg4, long arg5) {
        return ULong.constructor-impl(ULong.constructor-impl((((long)arg4)) & 0xFFFFFFFFL) * arg5);
    }

    private static final int times-WZ4Q5Ns(int arg0, int arg1) {
        return UInt.constructor-impl(arg0 * arg1);
    }

    private static final int times-xj2QHRw(int arg1, short arg2) {
        return UInt.constructor-impl(arg1 * UInt.constructor-impl(arg2 & 0xFFFF));
    }

    private static final byte toByte-impl(int arg0) {
        return ((byte)arg0);
    }

    private static final double toDouble-impl(int arg2) {
        return UnsignedKt.uintToDouble(arg2);
    }

    private static final float toFloat-impl(int arg2) {
        return ((float)UnsignedKt.uintToDouble(arg2));
    }

    private static final int toInt-impl(int arg0) {
        return arg0;
    }

    private static final long toLong-impl(int arg4) {
        return (((long)arg4)) & 0xFFFFFFFFL;
    }

    private static final short toShort-impl(int arg0) {
        return ((short)arg0);
    }

    public String toString() {
        return UInt.toString-impl(this.data);
    }

    public static String toString-impl(int arg4) {
        return String.valueOf((((long)arg4)) & 0xFFFFFFFFL);
    }

    private static final byte toUByte-w2LRezQ(int arg0) {
        return UByte.constructor-impl(((byte)arg0));
    }

    private static final int toUInt-pVg5ArA(int arg0) {
        return arg0;
    }

    private static final long toULong-s-VKNKU(int arg4) {
        return ULong.constructor-impl((((long)arg4)) & 0xFFFFFFFFL);
    }

    private static final short toUShort-Mh2AYeg(int arg0) {
        return UShort.constructor-impl(((short)arg0));
    }

    public final int unbox-impl() {
        return this.data;
    }

    private static final int xor-WZ4Q5Ns(int arg0, int arg1) {
        return UInt.constructor-impl(arg0 ^ arg1);
    }
}

