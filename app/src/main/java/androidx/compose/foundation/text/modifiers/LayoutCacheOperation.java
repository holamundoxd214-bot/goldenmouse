package androidx.compose.foundation.text.modifiers;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0081@\u0018\u0000 \u000F2\u00020\u0001:\u0001\u000FB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000B\u001A\u00020\fHÖ\u0001J\t\u0010\r\u001A\u00020\u000EHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0010"}, d2={"Landroidx/compose/foundation/text/modifiers/LayoutCacheOperation;", "", "flag", "", "constructor-impl", "(J)J", "getFlag", "()J", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class LayoutCacheOperation {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007¨\u0006\u000F"}, d2={"Landroidx/compose/foundation/text/modifiers/LayoutCacheOperation$Companion;", "", "<init>", "()V", "MarkDirtyStyle", "Landroidx/compose/foundation/text/modifiers/LayoutCacheOperation;", "getMarkDirtyStyle-DEKiAbY", "()J", "J", "MarkDirtyDensity", "getMarkDirtyDensity-DEKiAbY", "MarkDirtyNode", "getMarkDirtyNode-DEKiAbY", "LayoutWithConstraints", "getLayoutWithConstraints-DEKiAbY", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final long getLayoutWithConstraints-DEKiAbY() {
            return LayoutCacheOperation.LayoutWithConstraints;
        }

        public final long getMarkDirtyDensity-DEKiAbY() {
            return LayoutCacheOperation.MarkDirtyDensity;
        }

        public final long getMarkDirtyNode-DEKiAbY() {
            return LayoutCacheOperation.MarkDirtyNode;
        }

        public final long getMarkDirtyStyle-DEKiAbY() {
            return LayoutCacheOperation.MarkDirtyStyle;
        }
    }

    public static final Companion Companion;
    private static final long LayoutWithConstraints;
    private static final long MarkDirtyDensity;
    private static final long MarkDirtyNode;
    private static final long MarkDirtyStyle;
    private final long flag;

    static {
        LayoutCacheOperation.Companion = new Companion(null);
        LayoutCacheOperation.MarkDirtyStyle = LayoutCacheOperation.constructor-impl(0);
        LayoutCacheOperation.MarkDirtyDensity = LayoutCacheOperation.constructor-impl(1);
        LayoutCacheOperation.MarkDirtyNode = LayoutCacheOperation.constructor-impl(2);
        LayoutCacheOperation.LayoutWithConstraints = LayoutCacheOperation.constructor-impl(3);
    }

    private LayoutCacheOperation(long arg1) {
        super();
        this.flag = arg1;
    }

    public static final long access$getLayoutWithConstraints$cp() {
        return LayoutCacheOperation.LayoutWithConstraints;
    }

    public static final long access$getMarkDirtyDensity$cp() {
        return LayoutCacheOperation.MarkDirtyDensity;
    }

    public static final long access$getMarkDirtyNode$cp() {
        return LayoutCacheOperation.MarkDirtyNode;
    }

    public static final long access$getMarkDirtyStyle$cp() {
        return LayoutCacheOperation.MarkDirtyStyle;
    }

    public static final LayoutCacheOperation box-impl(long arg1) {
        return new LayoutCacheOperation(arg1);
    }

    private static long constructor-impl(long arg0) {
        return arg0;
    }

    public boolean equals(Object arg3) {
        return LayoutCacheOperation.equals-impl(this.flag, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof LayoutCacheOperation)) {
            return 0;
        }

        if(arg4 != ((LayoutCacheOperation)arg6).unbox-impl()) {
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

    public final long getFlag() {
        return this.flag;
    }

    public int hashCode() {
        return LayoutCacheOperation.hashCode-impl(this.flag);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public String toString() {
        return LayoutCacheOperation.toString-impl(this.flag);
    }

    public static String toString-impl(long arg2) {
        return "LayoutCacheOperation(flag=" + arg2 + ')';
    }

    public final long unbox-impl() {
        return this.flag;
    }
}

