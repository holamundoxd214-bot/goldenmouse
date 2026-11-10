package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0087@\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0011\b\u0001\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001A\u00020\tH\u0087\n¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0013\u001A\u00020\tH\u0087\n¢\u0006\u0004\b\u0014\u0010\rJ\u0018\u0010\u0015\u001A\u00020\u00002\u0006\u0010\u0016\u001A\u00020\tH\u0087\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0019\u001A\u00020\u00002\u0006\u0010\u0016\u001A\u00020\tH\u0087\u0002¢\u0006\u0004\b\u001A\u0010\u0018J\u000F\u0010\u001B\u001A\u00020\u001CH\u0017¢\u0006\u0004\b\u001D\u0010\u001EJ\u0013\u0010\u001F\u001A\u00020 2\b\u0010\u0016\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001A\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u001B\u0010\b\u001A\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000B\u001A\u0004\b\f\u0010\rR\u001B\u0010\u000E\u001A\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000F\u0010\u000B\u001A\u0004\b\u0010\u0010\r\u0088\u0001\u0002¨\u0006#"}, d2={"Landroidx/compose/ui/unit/IntSize;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "width", "", "getWidth$annotations", "()V", "getWidth-impl", "(J)I", "height", "getHeight$annotations", "getHeight-impl", "component1", "component1-impl", "component2", "component2-impl", "times", "other", "times-YEO4UFw", "(JI)J", "div", "div-YEO4UFw", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "hashCode", "Companion", "ui-unit"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class IntSize {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2={"Landroidx/compose/ui/unit/IntSize$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/unit/IntSize;", "getZero-YbymL2g", "()J", "J", "ui-unit"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final long getZero-YbymL2g() {
            return IntSize.Zero;
        }
    }

    public static final Companion Companion;
    private static final long Zero;
    private final long packedValue;

    static {
        IntSize.Companion = new Companion(null);
        IntSize.Zero = IntSize.constructor-impl(0);
    }

    private IntSize(long arg1) {
        super();
        this.packedValue = arg1;
    }

    public static final long access$getZero$cp() {
        return IntSize.Zero;
    }

    public static final IntSize box-impl(long arg1) {
        return new IntSize(arg1);
    }

    public static final int component1-impl(long arg1) {
        return ((int)(arg1 >> 0x20));
    }

    public static final int component2-impl(long arg2) {
        return ((int)(arg2 & 0xFFFFFFFFL));
    }

    public static long constructor-impl(long arg0) {
        return arg0;
    }

    public static final long div-YEO4UFw(long arg4, int arg6) {
        return IntSize.constructor-impl((((long)((((int)(arg4 >> 0x20))) / arg6))) << 0x20 | (((long)((((int)(arg4 & 0xFFFFFFFFL))) / arg6))) & 0xFFFFFFFFL);
    }

    public boolean equals(Object arg3) {
        return IntSize.equals-impl(this.packedValue, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof IntSize)) {
            return 0;
        }

        if(arg4 != ((IntSize)arg6).unbox-impl()) {
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

    public static void getHeight$annotations() {
    }

    public static final int getHeight-impl(long arg2) {
        return ((int)(arg2 & 0xFFFFFFFFL));
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    public static void getWidth$annotations() {
    }

    public static final int getWidth-impl(long arg1) {
        return ((int)(arg1 >> 0x20));
    }

    public int hashCode() {
        return IntSize.hashCode-impl(this.packedValue);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public static final long times-YEO4UFw(long arg4, int arg6) {
        return IntSize.constructor-impl((((long)((((int)(arg4 >> 0x20))) * arg6))) << 0x20 | (((long)((((int)(arg4 & 0xFFFFFFFFL))) * arg6))) & 0xFFFFFFFFL);
    }

    public String toString() {
        return IntSize.toString-impl(this.packedValue);
    }

    public static String toString-impl(long arg3) {
        return (((int)(arg3 >> 0x20))) + " x " + (((int)(arg3 & 0xFFFFFFFFL)));
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}

