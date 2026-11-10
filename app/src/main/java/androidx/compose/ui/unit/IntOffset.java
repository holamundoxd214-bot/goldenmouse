package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0087@\u0018\u0000 12\u00020\u0001:\u00011B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001A\u00020\tH\u0087\n¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0013\u001A\u00020\tH\u0087\n¢\u0006\u0004\b\u0014\u0010\rJ!\u0010\u0015\u001A\u00020\u00002\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\u000E\u001A\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001A\u00020\u00002\u0006\u0010\u0019\u001A\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u001A\u0010\u001BJ\u0018\u0010\u001C\u001A\u00020\u00002\u0006\u0010\u0019\u001A\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u001D\u0010\u001BJ\u0010\u0010\u001E\u001A\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u001F\u0010\u0005J\u0018\u0010 \u001A\u00020\u00002\u0006\u0010!\u001A\u00020\"H\u0087\u0002¢\u0006\u0004\b#\u0010$J\u0018\u0010%\u001A\u00020\u00002\u0006\u0010!\u001A\u00020\"H\u0087\u0002¢\u0006\u0004\b&\u0010$J\u0018\u0010\'\u001A\u00020\u00002\u0006\u0010!\u001A\u00020\tH\u0087\u0002¢\u0006\u0004\b(\u0010)J\u000F\u0010*\u001A\u00020+H\u0017¢\u0006\u0004\b,\u0010-J\u0013\u0010.\u001A\u00020/2\b\u0010\u0019\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001A\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u001A\u0010\b\u001A\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000B\u001A\u0004\b\f\u0010\rR\u001A\u0010\u000E\u001A\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000F\u0010\u000B\u001A\u0004\b\u0010\u0010\r\u0088\u0001\u0002¨\u00062"}, d2={"Landroidx/compose/ui/unit/IntOffset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "x", "", "getX$annotations", "()V", "getX-impl", "(J)I", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-iSbpLlY", "(JII)J", "minus", "other", "minus-qkQi6aY", "(JJ)J", "plus", "plus-qkQi6aY", "unaryMinus", "unaryMinus-nOcc-ac", "times", "operand", "", "times-Bjo55l4", "(JF)J", "div", "div-Bjo55l4", "rem", "rem-Bjo55l4", "(JI)J", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "hashCode", "Companion", "ui-unit"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class IntOffset {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007¨\u0006\u000B"}, d2={"Landroidx/compose/ui/unit/IntOffset$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/unit/IntOffset;", "getZero-nOcc-ac", "()J", "J", "Max", "getMax-nOcc-ac", "ui-unit"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final long getMax-nOcc-ac() {
            return IntOffset.Max;
        }

        public final long getZero-nOcc-ac() {
            return IntOffset.Zero;
        }
    }

    public static final Companion Companion;
    private static final long Max;
    private static final long Zero;
    private final long packedValue;

    static {
        IntOffset.Companion = new Companion(null);
        IntOffset.Zero = IntOffset.constructor-impl(0);
        IntOffset.Max = IntOffset.constructor-impl(0x7FFFFFFF7FFFFFFFL);
    }

    private IntOffset(long arg1) {
        super();
        this.packedValue = arg1;
    }

    public static final long access$getMax$cp() {
        return IntOffset.Max;
    }

    public static final long access$getZero$cp() {
        return IntOffset.Zero;
    }

    public static final IntOffset box-impl(long arg1) {
        return new IntOffset(arg1);
    }

    public static final int component1-impl(long arg0) {
        return IntOffset.getX-impl(arg0);
    }

    public static final int component2-impl(long arg0) {
        return IntOffset.getY-impl(arg0);
    }

    public static long constructor-impl(long arg0) {
        return arg0;
    }

    public static final long copy-iSbpLlY(long arg2, int arg4, int arg5) {
        return IntOffset.constructor-impl((((long)arg4)) << 0x20 | (((long)arg5)) & 0xFFFFFFFFL);
    }

    public static long copy-iSbpLlY$default(long arg2, int arg4, int arg5, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg4 = ((int)(arg2 >> 0x20));
        }

        if((arg6 & 2) != 0) {
            arg5 = ((int)(0xFFFFFFFFL & arg2));
        }

        return IntOffset.copy-iSbpLlY(arg2, arg4, arg5);
    }

    public static final long div-Bjo55l4(long arg4, float arg6) {
        return IntOffset.constructor-impl((((long)Math.round((((float)(((int)(arg4 >> 0x20))))) / arg6))) << 0x20 | (((long)Math.round((((float)(((int)(arg4 & 0xFFFFFFFFL))))) / arg6))) & 0xFFFFFFFFL);
    }

    public boolean equals(Object arg3) {
        return IntOffset.equals-impl(this.packedValue, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof IntOffset)) {
            return 0;
        }

        if(arg4 != ((IntOffset)arg6).unbox-impl()) {
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

    public final long getPackedValue() {
        return this.packedValue;
    }

    public static void getX$annotations() {
    }

    public static final int getX-impl(long arg1) {
        return ((int)(arg1 >> 0x20));
    }

    public static void getY$annotations() {
    }

    public static final int getY-impl(long arg2) {
        return ((int)(arg2 & 0xFFFFFFFFL));
    }

    public int hashCode() {
        return IntOffset.hashCode-impl(this.packedValue);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public static final long minus-qkQi6aY(long arg4, long arg6) {
        return IntOffset.constructor-impl((((long)((((int)(arg4 >> 0x20))) - (((int)(arg6 >> 0x20)))))) << 0x20 | (((long)((((int)(arg4 & 0xFFFFFFFFL))) - (((int)(arg6 & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL);
    }

    public static final long plus-qkQi6aY(long arg4, long arg6) {
        return IntOffset.constructor-impl((((long)((((int)(arg4 >> 0x20))) + (((int)(arg6 >> 0x20)))))) << 0x20 | (((long)((((int)(arg4 & 0xFFFFFFFFL))) + (((int)(arg6 & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL);
    }

    public static final long rem-Bjo55l4(long arg4, int arg6) {
        return IntOffset.constructor-impl((((long)((((int)(arg4 >> 0x20))) % arg6))) << 0x20 | (((long)((((int)(arg4 & 0xFFFFFFFFL))) % arg6))) & 0xFFFFFFFFL);
    }

    public static final long times-Bjo55l4(long arg4, float arg6) {
        return IntOffset.constructor-impl((((long)Math.round((((float)(((int)(arg4 >> 0x20))))) * arg6))) << 0x20 | (((long)Math.round((((float)(((int)(arg4 & 0xFFFFFFFFL))))) * arg6))) & 0xFFFFFFFFL);
    }

    public String toString() {
        return IntOffset.toString-impl(this.packedValue);
    }

    public static String toString-impl(long arg2) {
        return "(" + IntOffset.getX-impl(arg2) + ", " + IntOffset.getY-impl(arg2) + ')';
    }

    public static final long unaryMinus-nOcc-ac(long arg6) {
        return IntOffset.constructor-impl((((long)(-(((int)(arg6 & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL | (((long)(-(((int)(arg6 >> 0x20)))))) << 0x20);
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}

