package androidx.compose.ui.input.indirect;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u0003HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000F"}, d2={"Landroidx/compose/ui/input/indirect/IndirectPointerEventType;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class IndirectPointerEventType {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007¨\u0006\u000F"}, d2={"Landroidx/compose/ui/input/indirect/IndirectPointerEventType$Companion;", "", "<init>", "()V", "Unknown", "Landroidx/compose/ui/input/indirect/IndirectPointerEventType;", "getUnknown-4ZHQPSE", "()I", "I", "Press", "getPress-4ZHQPSE", "Release", "getRelease-4ZHQPSE", "Move", "getMove-4ZHQPSE", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getMove-4ZHQPSE() {
            return IndirectPointerEventType.Move;
        }

        public final int getPress-4ZHQPSE() {
            return IndirectPointerEventType.Press;
        }

        public final int getRelease-4ZHQPSE() {
            return IndirectPointerEventType.Release;
        }

        public final int getUnknown-4ZHQPSE() {
            return IndirectPointerEventType.Unknown;
        }
    }

    public static final Companion Companion;
    private static final int Move;
    private static final int Press;
    private static final int Release;
    private static final int Unknown;
    private final int value;

    static {
        IndirectPointerEventType.Companion = new Companion(null);
        IndirectPointerEventType.Unknown = IndirectPointerEventType.constructor-impl(0);
        IndirectPointerEventType.Press = IndirectPointerEventType.constructor-impl(1);
        IndirectPointerEventType.Release = IndirectPointerEventType.constructor-impl(2);
        IndirectPointerEventType.Move = IndirectPointerEventType.constructor-impl(3);
    }

    private IndirectPointerEventType(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getMove$cp() {
        return IndirectPointerEventType.Move;
    }

    public static final int access$getPress$cp() {
        return IndirectPointerEventType.Press;
    }

    public static final int access$getRelease$cp() {
        return IndirectPointerEventType.Release;
    }

    public static final int access$getUnknown$cp() {
        return IndirectPointerEventType.Unknown;
    }

    public static final IndirectPointerEventType box-impl(int arg1) {
        return new IndirectPointerEventType(arg1);
    }

    private static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return IndirectPointerEventType.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof IndirectPointerEventType)) {
            return 0;
        }

        if(arg2 != ((IndirectPointerEventType)arg3).unbox-impl()) {
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
        return IndirectPointerEventType.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return IndirectPointerEventType.toString-impl(this.value);
    }

    public static String toString-impl(int arg1) {
        if(IndirectPointerEventType.equals-impl0(arg1, IndirectPointerEventType.Press)) {
            return "Press";
        }

        if(IndirectPointerEventType.equals-impl0(arg1, IndirectPointerEventType.Release)) {
            return "Release";
        }

        if(IndirectPointerEventType.equals-impl0(arg1, IndirectPointerEventType.Move)) {
            return "Move";
        }

        return "Unknown";
    }

    public final int unbox-impl() {
        return this.value;
    }
}

