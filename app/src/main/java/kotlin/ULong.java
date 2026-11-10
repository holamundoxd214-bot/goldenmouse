package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ULongRange;
import kotlin.ranges.URangesKt;

@Metadata(d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 {2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001{B\u0011\bA\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0087\u008A\u0004¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000EH\u0087\u008A\u0004¢\u0006\u0004\b\u000F\u0010\u0010J\u0019\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0011H\u0087\u008A\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0000H\u0097\u008A\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u000BH\u0087\u008A\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0016\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u000EH\u0087\u008A\u0004¢\u0006\u0004\b\u0019\u0010\u001AJ\u0019\u0010\u0016\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0011H\u0087\u008A\u0004¢\u0006\u0004\b\u001B\u0010\u001CJ\u0019\u0010\u0016\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\b\u001D\u0010\u001EJ\u0019\u0010\u001F\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u000BH\u0087\u008A\u0004¢\u0006\u0004\b \u0010\u0018J\u0019\u0010\u001F\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u000EH\u0087\u008A\u0004¢\u0006\u0004\b!\u0010\u001AJ\u0019\u0010\u001F\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0011H\u0087\u008A\u0004¢\u0006\u0004\b\"\u0010\u001CJ\u0019\u0010\u001F\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\b#\u0010\u001EJ\u0019\u0010$\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u000BH\u0087\u008A\u0004¢\u0006\u0004\b%\u0010\u0018J\u0019\u0010$\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u000EH\u0087\u008A\u0004¢\u0006\u0004\b&\u0010\u001AJ\u0019\u0010$\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0011H\u0087\u008A\u0004¢\u0006\u0004\b\'\u0010\u001CJ\u0019\u0010$\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\b(\u0010\u001EJ\u0019\u0010)\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u000BH\u0087\u008A\u0004¢\u0006\u0004\b*\u0010\u0018J\u0019\u0010)\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u000EH\u0087\u008A\u0004¢\u0006\u0004\b+\u0010\u001AJ\u0019\u0010)\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0011H\u0087\u008A\u0004¢\u0006\u0004\b,\u0010\u001CJ\u0019\u0010)\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\b-\u0010\u001EJ\u0019\u0010.\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u000BH\u0087\u008A\u0004¢\u0006\u0004\b/\u0010\u0018J\u0019\u0010.\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u000EH\u0087\u008A\u0004¢\u0006\u0004\b0\u0010\u001AJ\u0019\u0010.\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0011H\u0087\u008A\u0004¢\u0006\u0004\b1\u0010\u001CJ\u0019\u0010.\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\b2\u0010\u001EJ\u0019\u00103\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u000BH\u0087\u0088\u0004¢\u0006\u0004\b4\u0010\u0018J\u0019\u00103\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u000EH\u0087\u0088\u0004¢\u0006\u0004\b5\u0010\u001AJ\u0019\u00103\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0011H\u0087\u0088\u0004¢\u0006\u0004\b6\u0010\u001CJ\u0019\u00103\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0000H\u0087\u0088\u0004¢\u0006\u0004\b7\u0010\u001EJ\u0019\u00108\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\u000BH\u0087\u0088\u0004¢\u0006\u0004\b9\u0010:J\u0019\u00108\u001A\u00020\u000E2\u0006\u0010\n\u001A\u00020\u000EH\u0087\u0088\u0004¢\u0006\u0004\b;\u0010<J\u0019\u00108\u001A\u00020\u00112\u0006\u0010\n\u001A\u00020\u0011H\u0087\u0088\u0004¢\u0006\u0004\b=\u0010\u0013J\u0019\u00108\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0000H\u0087\u0088\u0004¢\u0006\u0004\b>\u0010\u001EJ\u0011\u0010?\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\b@\u0010\u0005J\u0011\u0010A\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\bB\u0010\u0005J\u0019\u0010C\u001A\u00020D2\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\bE\u0010FJ\u0019\u0010G\u001A\u00020D2\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008A\u0004¢\u0006\u0004\bH\u0010FJ\u0019\u0010I\u001A\u00020\u00002\u0006\u0010J\u001A\u00020\tH\u0087\u008C\u0004¢\u0006\u0004\bK\u0010\u001CJ\u0019\u0010L\u001A\u00020\u00002\u0006\u0010J\u001A\u00020\tH\u0087\u008C\u0004¢\u0006\u0004\bM\u0010\u001CJ\u0019\u0010N\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008C\u0004¢\u0006\u0004\bO\u0010\u001EJ\u0019\u0010P\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008C\u0004¢\u0006\u0004\bQ\u0010\u001EJ\u0019\u0010R\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0000H\u0087\u008C\u0004¢\u0006\u0004\bS\u0010\u001EJ\u0011\u0010T\u001A\u00020\u0000H\u0087\u0088\u0004¢\u0006\u0004\bU\u0010\u0005J\u0011\u0010V\u001A\u00020WH\u0087\u0088\u0004¢\u0006\u0004\bX\u0010YJ\u0011\u0010Z\u001A\u00020[H\u0087\u0088\u0004¢\u0006\u0004\b\\\u0010]J\u0011\u0010^\u001A\u00020\tH\u0087\u0088\u0004¢\u0006\u0004\b_\u0010`J\u0011\u0010a\u001A\u00020\u0003H\u0087\u0088\u0004¢\u0006\u0004\bb\u0010\u0005J\u0011\u0010c\u001A\u00020\u000BH\u0087\u0088\u0004¢\u0006\u0004\bd\u0010YJ\u0011\u0010e\u001A\u00020\u000EH\u0087\u0088\u0004¢\u0006\u0004\bf\u0010]J\u0011\u0010g\u001A\u00020\u0011H\u0087\u0088\u0004¢\u0006\u0004\bh\u0010`J\u0011\u0010i\u001A\u00020\u0000H\u0087\u0088\u0004¢\u0006\u0004\bj\u0010\u0005J\u0011\u0010k\u001A\u00020lH\u0087\u0088\u0004¢\u0006\u0004\bm\u0010nJ\u0011\u0010o\u001A\u00020pH\u0087\u0088\u0004¢\u0006\u0004\bq\u0010rJ\u0011\u0010s\u001A\u00020tH\u0097\u0080\u0004¢\u0006\u0004\bu\u0010vJ\u0014\u0010w\u001A\u00020x2\b\u0010\n\u001A\u0004\u0018\u00010yHÖ\u0083\u0004J\n\u0010z\u001A\u00020\tHÖ\u0081\u0004R\u0017\u0010\u0002\u001A\u00020\u00038\u0000X\u0081\u0084\b¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006|"}, d2={"Lkotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "getData$annotations", "()V", "compareTo", "", "other", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "plus", "plus-7apg3OU", "(JB)J", "plus-xj2QHRw", "(JS)J", "plus-WZ4Q5Ns", "(JI)J", "plus-VKZWuLQ", "(JJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", "div", "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(JB)B", "mod-xj2QHRw", "(JS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-s-VKNKU", "dec", "dec-s-VKNKU", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rangeUntil", "rangeUntil-VKZWuLQ", "shl", "bitCount", "shl-s-VKNKU", "shr", "shr-s-VKNKU", "and", "and-VKZWuLQ", "or", "or-VKZWuLQ", "xor", "xor-VKZWuLQ", "inv", "inv-s-VKNKU", "toByte", "", "toByte-impl", "(J)B", "toShort", "", "toShort-impl", "(J)S", "toInt", "toInt-impl", "(J)I", "toLong", "toLong-impl", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", "", "toFloat-impl", "(J)F", "toDouble", "", "toDouble-impl", "(J)D", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) @JvmInline public final class ULong implements Comparable {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\u0007\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0004\n\u0002\u0010\u0006R\u000F\u0010\b\u001A\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\n\u001A\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Lkotlin/ULong$Companion;", "", "<init>", "()V", "MIN_VALUE", "Lkotlin/ULong;", "J", "MAX_VALUE", "SIZE_BYTES", "", "SIZE_BITS", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final Companion Companion = null;
    public static final long MAX_VALUE = -1;
    public static final long MIN_VALUE = 0;
    public static final int SIZE_BITS = 0x40;
    public static final int SIZE_BYTES = 8;
    private final long data;

    static {
        ULong.Companion = new Companion(null);
    }

    private ULong(long arg1) {
        super();
        this.data = arg1;
    }

    private static final long and-VKZWuLQ(long arg0, long arg2) {
        return ULong.constructor-impl(arg0 & arg2);
    }

    public static final ULong box-impl(long arg1) {
        return new ULong(arg1);
    }

    public int compareTo(Object arg3) {
        return UnsignedKt.ulongCompare(this.unbox-impl(), ((ULong)arg3).unbox-impl());
    }

    private static final int compareTo-7apg3OU(long arg4, byte arg6) {
        return Long.compareUnsigned(arg4, ULong.constructor-impl((((long)arg6)) & 0xFF));
    }

    private int compareTo-VKZWuLQ(long arg3) {
        return UnsignedKt.ulongCompare(this.unbox-impl(), arg3);
    }

    private static int compareTo-VKZWuLQ(long arg0, long arg2) {
        return UnsignedKt.ulongCompare(arg0, arg2);
    }

    private static final int compareTo-WZ4Q5Ns(long arg4, int arg6) {
        return Long.compareUnsigned(arg4, ULong.constructor-impl((((long)arg6)) & 0xFFFFFFFFL));
    }

    private static final int compareTo-xj2QHRw(long arg4, short arg6) {
        return Long.compareUnsigned(arg4, ULong.constructor-impl((((long)arg6)) & 0xFFFF));
    }

    public static long constructor-impl(long arg0) {
        return arg0;
    }

    private static final long dec-s-VKNKU(long arg2) {
        return ULong.constructor-impl(arg2 - 1);
    }

    private static final long div-7apg3OU(long arg4, byte arg6) {
        return Long.divideUnsigned(arg4, ULong.constructor-impl((((long)arg6)) & 0xFF));
    }

    private static final long div-VKZWuLQ(long arg0, long arg2) {
        return UnsignedKt.ulongDivide-eb3DHEI(arg0, arg2);
    }

    private static final long div-WZ4Q5Ns(long arg4, int arg6) {
        return Long.divideUnsigned(arg4, ULong.constructor-impl((((long)arg6)) & 0xFFFFFFFFL));
    }

    private static final long div-xj2QHRw(long arg4, short arg6) {
        return Long.divideUnsigned(arg4, ULong.constructor-impl((((long)arg6)) & 0xFFFF));
    }

    public boolean equals(Object arg3) {
        return ULong.equals-impl(this.data, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof ULong)) {
            return 0;
        }

        if(arg4 != ((ULong)arg6).unbox-impl()) {
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

    private static final long floorDiv-7apg3OU(long arg4, byte arg6) {
        return Long.divideUnsigned(arg4, ULong.constructor-impl((((long)arg6)) & 0xFF));
    }

    private static final long floorDiv-VKZWuLQ(long arg0, long arg2) {
        return Long.divideUnsigned(arg0, arg2);
    }

    private static final long floorDiv-WZ4Q5Ns(long arg4, int arg6) {
        return Long.divideUnsigned(arg4, ULong.constructor-impl((((long)arg6)) & 0xFFFFFFFFL));
    }

    private static final long floorDiv-xj2QHRw(long arg4, short arg6) {
        return Long.divideUnsigned(arg4, ULong.constructor-impl((((long)arg6)) & 0xFFFF));
    }

    public static void getData$annotations() {
    }

    public int hashCode() {
        return ULong.hashCode-impl(this.data);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    private static final long inc-s-VKNKU(long arg2) {
        return ULong.constructor-impl(arg2 + 1);
    }

    private static final long inv-s-VKNKU(long arg0) {
        return ULong.constructor-impl(~arg0);
    }

    private static final long minus-7apg3OU(long arg4, byte arg6) {
        return ULong.constructor-impl(arg4 - ULong.constructor-impl((((long)arg6)) & 0xFF));
    }

    private static final long minus-VKZWuLQ(long arg0, long arg2) {
        return ULong.constructor-impl(arg0 - arg2);
    }

    private static final long minus-WZ4Q5Ns(long arg4, int arg6) {
        return ULong.constructor-impl(arg4 - ULong.constructor-impl((((long)arg6)) & 0xFFFFFFFFL));
    }

    private static final long minus-xj2QHRw(long arg4, short arg6) {
        return ULong.constructor-impl(arg4 - ULong.constructor-impl((((long)arg6)) & 0xFFFF));
    }

    private static final byte mod-7apg3OU(long arg4, byte arg6) {
        return UByte.constructor-impl(((byte)(((int)Long.remainderUnsigned(arg4, ULong.constructor-impl((((long)arg6)) & 0xFF))))));
    }

    private static final long mod-VKZWuLQ(long arg0, long arg2) {
        return Long.remainderUnsigned(arg0, arg2);
    }

    private static final int mod-WZ4Q5Ns(long arg4, int arg6) {
        return UInt.constructor-impl(((int)Long.remainderUnsigned(arg4, ULong.constructor-impl((((long)arg6)) & 0xFFFFFFFFL))));
    }

    private static final short mod-xj2QHRw(long arg4, short arg6) {
        return UShort.constructor-impl(((short)(((int)Long.remainderUnsigned(arg4, ULong.constructor-impl((((long)arg6)) & 0xFFFF))))));
    }

    private static final long or-VKZWuLQ(long arg0, long arg2) {
        return ULong.constructor-impl(arg0 | arg2);
    }

    private static final long plus-7apg3OU(long arg4, byte arg6) {
        return ULong.constructor-impl(arg4 + ULong.constructor-impl((((long)arg6)) & 0xFF));
    }

    private static final long plus-VKZWuLQ(long arg0, long arg2) {
        return ULong.constructor-impl(arg0 + arg2);
    }

    private static final long plus-WZ4Q5Ns(long arg4, int arg6) {
        return ULong.constructor-impl(arg4 + ULong.constructor-impl((((long)arg6)) & 0xFFFFFFFFL));
    }

    private static final long plus-xj2QHRw(long arg4, short arg6) {
        return ULong.constructor-impl(arg4 + ULong.constructor-impl((((long)arg6)) & 0xFFFF));
    }

    private static final ULongRange rangeTo-VKZWuLQ(long arg6, long arg8) {
        return new ULongRange(arg6, arg8, null);
    }

    private static final ULongRange rangeUntil-VKZWuLQ(long arg0, long arg2) {
        return URangesKt.until-eb3DHEI(arg0, arg2);
    }

    private static final long rem-7apg3OU(long arg4, byte arg6) {
        return Long.remainderUnsigned(arg4, ULong.constructor-impl((((long)arg6)) & 0xFF));
    }

    private static final long rem-VKZWuLQ(long arg0, long arg2) {
        return UnsignedKt.ulongRemainder-eb3DHEI(arg0, arg2);
    }

    private static final long rem-WZ4Q5Ns(long arg4, int arg6) {
        return Long.remainderUnsigned(arg4, ULong.constructor-impl((((long)arg6)) & 0xFFFFFFFFL));
    }

    private static final long rem-xj2QHRw(long arg4, short arg6) {
        return Long.remainderUnsigned(arg4, ULong.constructor-impl((((long)arg6)) & 0xFFFF));
    }

    private static final long shl-s-VKNKU(long arg0, int arg2) {
        return ULong.constructor-impl(arg0 << arg2);
    }

    private static final long shr-s-VKNKU(long arg0, int arg2) {
        return ULong.constructor-impl(arg0 >>> arg2);
    }

    private static final long times-7apg3OU(long arg4, byte arg6) {
        return ULong.constructor-impl(arg4 * ULong.constructor-impl((((long)arg6)) & 0xFF));
    }

    private static final long times-VKZWuLQ(long arg0, long arg2) {
        return ULong.constructor-impl(arg0 * arg2);
    }

    private static final long times-WZ4Q5Ns(long arg4, int arg6) {
        return ULong.constructor-impl(arg4 * ULong.constructor-impl((((long)arg6)) & 0xFFFFFFFFL));
    }

    private static final long times-xj2QHRw(long arg4, short arg6) {
        return ULong.constructor-impl(arg4 * ULong.constructor-impl((((long)arg6)) & 0xFFFF));
    }

    private static final byte toByte-impl(long arg0) {
        return ((byte)(((int)arg0)));
    }

    private static final double toDouble-impl(long arg0) {
        return UnsignedKt.ulongToDouble(arg0);
    }

    private static final float toFloat-impl(long arg0) {
        return ((float)UnsignedKt.ulongToDouble(arg0));
    }

    private static final int toInt-impl(long arg0) {
        return ((int)arg0);
    }

    private static final long toLong-impl(long arg0) {
        return arg0;
    }

    private static final short toShort-impl(long arg0) {
        return ((short)(((int)arg0)));
    }

    public String toString() {
        return ULong.toString-impl(this.data);
    }

    public static String toString-impl(long arg1) {
        return UnsignedKt.ulongToString(arg1, 10);
    }

    private static final byte toUByte-w2LRezQ(long arg0) {
        return UByte.constructor-impl(((byte)(((int)arg0))));
    }

    private static final int toUInt-pVg5ArA(long arg0) {
        return UInt.constructor-impl(((int)arg0));
    }

    private static final long toULong-s-VKNKU(long arg0) {
        return arg0;
    }

    private static final short toUShort-Mh2AYeg(long arg0) {
        return UShort.constructor-impl(((short)(((int)arg0))));
    }

    public final long unbox-impl() {
        return this.data;
    }

    private static final long xor-VKZWuLQ(long arg0, long arg2) {
        return ULong.constructor-impl(arg0 ^ arg2);
    }
}

