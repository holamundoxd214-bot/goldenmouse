package androidx.compose.runtime.tooling;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0087@\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\t\u001A\u00020\u0003HÖ\u0081\u0004J\n\u0010\n\u001A\u00020\u000BHÖ\u0081\u0004R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\r"}, d2={"Landroidx/compose/runtime/tooling/ComposeStackTraceMode;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "hashCode", "toString", "", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) @JvmInline public final class ComposeStackTraceMode {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0011\u0010\r\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u0007R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"Landroidx/compose/runtime/tooling/ComposeStackTraceMode$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/runtime/tooling/ComposeStackTraceMode;", "getNone-MD5MrJc", "()I", "I", "GroupKeys", "getGroupKeys-MD5MrJc", "SourceInformation", "getSourceInformation-MD5MrJc", "Auto", "getAuto-MD5MrJc", "isMinified", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getAuto-MD5MrJc() {
            if(ComposeStackTraceMode.isMinified) {
                return this.getGroupKeys-MD5MrJc();
            }

            return this.getNone-MD5MrJc();
        }

        public final int getGroupKeys-MD5MrJc() {
            return ComposeStackTraceMode.GroupKeys;
        }

        public final int getNone-MD5MrJc() {
            return ComposeStackTraceMode.None;
        }

        public final int getSourceInformation-MD5MrJc() {
            return ComposeStackTraceMode.SourceInformation;
        }
    }

    public static final Companion Companion;
    private static final int GroupKeys;
    private static final int None;
    private static final int SourceInformation;
    private static boolean isMinified;
    private final int value;

    static {
        ComposeStackTraceMode.Companion = new Companion(null);
        ComposeStackTraceMode.None = ComposeStackTraceMode.constructor-impl(0);
        ComposeStackTraceMode.GroupKeys = ComposeStackTraceMode.constructor-impl(1);
        ComposeStackTraceMode.SourceInformation = ComposeStackTraceMode.constructor-impl(2);
    }

    private ComposeStackTraceMode(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getGroupKeys$cp() {
        return ComposeStackTraceMode.GroupKeys;
    }

    public static final int access$getNone$cp() {
        return ComposeStackTraceMode.None;
    }

    public static final int access$getSourceInformation$cp() {
        return ComposeStackTraceMode.SourceInformation;
    }

    public static final boolean access$isMinified$cp() {
        return ComposeStackTraceMode.isMinified;
    }

    public static final ComposeStackTraceMode box-impl(int arg1) {
        return new ComposeStackTraceMode(arg1);
    }

    private static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return ComposeStackTraceMode.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof ComposeStackTraceMode)) {
            return 0;
        }

        if(arg2 != ((ComposeStackTraceMode)arg3).unbox-impl()) {
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

    public int hashCode() {
        return ComposeStackTraceMode.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return ComposeStackTraceMode.toString-impl(this.value);
    }

    public static String toString-impl(int arg2) {
        return "ComposeStackTraceMode(value=" + arg2 + ')';
    }

    public final int unbox-impl() {
        return this.value;
    }
}

