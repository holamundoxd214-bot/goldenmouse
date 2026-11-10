package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001A\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000B\u001A\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u0010\u0010\r\u001A\u00020\u000EHÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0010R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2={"Landroidx/compose/ui/platform/AutoClearFocusBehavior;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class AutoClearFocusBehavior {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0011\u0010\u000B\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\f\u0010\u0007¨\u0006\r"}, d2={"Landroidx/compose/ui/platform/AutoClearFocusBehavior$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/ui/platform/AutoClearFocusBehavior;", "getNone-4UtRPd4", "()I", "I", "CursorBased", "getCursorBased-4UtRPd4", "Default", "getDefault-4UtRPd4", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getCursorBased-4UtRPd4() {
            return AutoClearFocusBehavior.CursorBased;
        }

        public final int getDefault-4UtRPd4() {
            return this.getCursorBased-4UtRPd4();
        }

        public final int getNone-4UtRPd4() {
            return AutoClearFocusBehavior.None;
        }
    }

    public static final Companion Companion;
    private static final int CursorBased;
    private static final int None;
    private final int value;

    static {
        AutoClearFocusBehavior.Companion = new Companion(null);
        AutoClearFocusBehavior.None = AutoClearFocusBehavior.constructor-impl(0);
        AutoClearFocusBehavior.CursorBased = AutoClearFocusBehavior.constructor-impl(1);
    }

    private AutoClearFocusBehavior(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getCursorBased$cp() {
        return AutoClearFocusBehavior.CursorBased;
    }

    public static final int access$getNone$cp() {
        return AutoClearFocusBehavior.None;
    }

    public static final AutoClearFocusBehavior box-impl(int arg1) {
        return new AutoClearFocusBehavior(arg1);
    }

    private static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return AutoClearFocusBehavior.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof AutoClearFocusBehavior)) {
            return 0;
        }

        if(arg2 != ((AutoClearFocusBehavior)arg3).unbox-impl()) {
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
        return AutoClearFocusBehavior.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return AutoClearFocusBehavior.toString-impl(this.value);
    }

    public static String toString-impl(int arg2) {
        return "AutoClearFocusBehavior(value=" + arg2 + ')';
    }

    public final int unbox-impl() {
        return this.value;
    }
}

