package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0010\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0087@\u0018\u0000 \'2\u00020\u0001:\u0001\'B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0018\u001A\u00020\u00112\u0006\u0010\u0019\u001A\u00020\u0000¢\u0006\u0004\b\u001A\u0010\u001BJ\u0018\u0010\u001C\u001A\u00020\u00112\u0006\u0010\u0019\u001A\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u001D\u0010\u001BJ\u0018\u0010\u001C\u001A\u00020\u00112\u0006\u0010\u001E\u001A\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\u001F\u0010 J\u000F\u0010!\u001A\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u0013\u0010%\u001A\u00020\u00112\b\u0010\u0019\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001A\u00020\u0007HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0011\u0010\n\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\u000B\u0010\tR\u0011\u0010\f\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\r\u0010\tR\u0011\u0010\u000E\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\u000F\u0010\tR\u0011\u0010\u0010\u001A\u00020\u00118F¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001A\u00020\u00118F¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\u0017\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006("}, d2={"Landroidx/compose/ui/text/TextRange;", "", "packedValue", "", "constructor-impl", "(J)J", "start", "", "getStart-impl", "(J)I", "end", "getEnd-impl", "min", "getMin-impl", "max", "getMax-impl", "collapsed", "", "getCollapsed-impl", "(J)Z", "reversed", "getReversed-impl", "length", "getLength-impl", "intersects", "other", "intersects-5zc-tL8", "(JJ)Z", "contains", "contains-5zc-tL8", "offset", "contains-impl", "(JI)Z", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "hashCode", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class TextRange {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2={"Landroidx/compose/ui/text/TextRange$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/text/TextRange;", "getZero-d9O1mEE", "()J", "J", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final long getZero-d9O1mEE() {
            return TextRange.Zero;
        }
    }

    public static final Companion Companion;
    private static final long Zero;
    private final long packedValue;

    static {
        TextRange.Companion = new Companion(null);
        TextRange.Zero = TextRangeKt.TextRange(0);
    }

    private TextRange(long arg1) {
        super();
        this.packedValue = arg1;
    }

    public static final long access$getZero$cp() {
        return TextRange.Zero;
    }

    public static final TextRange box-impl(long arg1) {
        return new TextRange(arg1);
    }

    public static long constructor-impl(long arg0) {
        return arg0;
    }

    public static final boolean contains-5zc-tL8(long arg4, long arg6) {
        int v2 = 1;
        int v0 = TextRange.getMin-impl(arg4) <= TextRange.getMin-impl(arg6) ? 1 : 0;
        if(TextRange.getMax-impl(arg6) <= TextRange.getMax-impl(arg4)) {
        }
        else {
            v2 = 0;
        }

        return v0 & v2;
    }

    public static final boolean contains-impl(long arg1, int arg3) {
        int v0 = TextRange.getMin-impl(arg1);
        if(arg3 < TextRange.getMax-impl(arg1) && v0 <= arg3) {
            return 1;
        }

        return 0;
    }

    public boolean equals(Object arg3) {
        return TextRange.equals-impl(this.packedValue, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof TextRange)) {
            return 0;
        }

        if(arg4 != ((TextRange)arg6).unbox-impl()) {
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

    public static final boolean getCollapsed-impl(long arg1) {
        if(TextRange.getStart-impl(arg1) == TextRange.getEnd-impl(arg1)) {
            return 1;
        }

        return 0;
    }

    public static final int getEnd-impl(long arg2) {
        return ((int)(arg2 & 0xFFFFFFFFL));
    }

    public static final int getLength-impl(long arg1) {
        return TextRange.getMax-impl(arg1) - TextRange.getMin-impl(arg1);
    }

    public static final int getMax-impl(long arg1) {
        return Math.max(TextRange.getStart-impl(arg1), TextRange.getEnd-impl(arg1));
    }

    public static final int getMin-impl(long arg1) {
        return Math.min(TextRange.getStart-impl(arg1), TextRange.getEnd-impl(arg1));
    }

    public static final boolean getReversed-impl(long arg1) {
        if(TextRange.getStart-impl(arg1) > TextRange.getEnd-impl(arg1)) {
            return 1;
        }

        return 0;
    }

    public static final int getStart-impl(long arg1) {
        return ((int)(arg1 >> 0x20));
    }

    public int hashCode() {
        return TextRange.hashCode-impl(this.packedValue);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public static final boolean intersects-5zc-tL8(long arg4, long arg6) {
        int v2 = 1;
        int v0 = TextRange.getMin-impl(arg4) < TextRange.getMax-impl(arg6) ? 1 : 0;
        if(TextRange.getMin-impl(arg6) < TextRange.getMax-impl(arg4)) {
        }
        else {
            v2 = 0;
        }

        return v0 & v2;
    }

    public String toString() {
        return TextRange.toString-impl(this.packedValue);
    }

    public static String toString-impl(long arg2) {
        return "TextRange(" + TextRange.getStart-impl(arg2) + ", " + TextRange.getEnd-impl(arg2) + ')';
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}

