package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 \u000F2\u00020\u0001:\u0001\u000FB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u000EHÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0010"}, d2={"Landroidx/compose/ui/unit/TextUnitType;", "", "type", "", "constructor-impl", "(J)J", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "other", "hashCode", "", "Companion", "ui-unit"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class TextUnitType {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007¨\u0006\r"}, d2={"Landroidx/compose/ui/unit/TextUnitType$Companion;", "", "<init>", "()V", "Unspecified", "Landroidx/compose/ui/unit/TextUnitType;", "getUnspecified-UIouoOA", "()J", "J", "Sp", "getSp-UIouoOA", "Em", "getEm-UIouoOA", "ui-unit"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final long getEm-UIouoOA() {
            return TextUnitType.Em;
        }

        public final long getSp-UIouoOA() {
            return TextUnitType.Sp;
        }

        public final long getUnspecified-UIouoOA() {
            return TextUnitType.Unspecified;
        }
    }

    public static final Companion Companion;
    private static final long Em;
    private static final long Sp;
    private static final long Unspecified;
    private final long type;

    static {
        TextUnitType.Companion = new Companion(null);
        TextUnitType.Unspecified = TextUnitType.constructor-impl(0);
        TextUnitType.Sp = TextUnitType.constructor-impl(0x100000000L);
        TextUnitType.Em = TextUnitType.constructor-impl(0x200000000L);
    }

    private TextUnitType(long arg1) {
        super();
        this.type = arg1;
    }

    public static final long access$getEm$cp() {
        return TextUnitType.Em;
    }

    public static final long access$getSp$cp() {
        return TextUnitType.Sp;
    }

    public static final long access$getUnspecified$cp() {
        return TextUnitType.Unspecified;
    }

    public static final TextUnitType box-impl(long arg1) {
        return new TextUnitType(arg1);
    }

    public static long constructor-impl(long arg0) {
        return arg0;
    }

    public boolean equals(Object arg3) {
        return TextUnitType.equals-impl(this.type, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof TextUnitType)) {
            return 0;
        }

        if(arg4 != ((TextUnitType)arg6).unbox-impl()) {
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

    public int hashCode() {
        return TextUnitType.hashCode-impl(this.type);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public String toString() {
        return TextUnitType.toString-impl(this.type);
    }

    public static String toString-impl(long arg2) {
        if(TextUnitType.equals-impl0(arg2, TextUnitType.Unspecified)) {
            return "Unspecified";
        }

        if(TextUnitType.equals-impl0(arg2, TextUnitType.Sp)) {
            return "Sp";
        }

        if(TextUnitType.equals-impl0(arg2, TextUnitType.Em)) {
            return "Em";
        }

        return "Invalid";
    }

    public final long unbox-impl() {
        return this.type;
    }
}

