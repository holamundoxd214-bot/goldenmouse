package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u0003HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000F"}, d2={"Landroidx/compose/ui/focus/FocusDirection;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class FocusDirection {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007R\u0013\u0010\u000F\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2={"Landroidx/compose/ui/focus/FocusDirection$Companion;", "", "<init>", "()V", "Next", "Landroidx/compose/ui/focus/FocusDirection;", "getNext-dhqQ-8s", "()I", "I", "Previous", "getPrevious-dhqQ-8s", "Left", "getLeft-dhqQ-8s", "Right", "getRight-dhqQ-8s", "Up", "getUp-dhqQ-8s", "Down", "getDown-dhqQ-8s", "Enter", "getEnter-dhqQ-8s", "Exit", "getExit-dhqQ-8s", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getDown-dhqQ-8s() {
            return FocusDirection.Down;
        }

        public final int getEnter-dhqQ-8s() {
            return FocusDirection.Enter;
        }

        public final int getExit-dhqQ-8s() {
            return FocusDirection.Exit;
        }

        public final int getLeft-dhqQ-8s() {
            return FocusDirection.Left;
        }

        public final int getNext-dhqQ-8s() {
            return FocusDirection.Next;
        }

        public final int getPrevious-dhqQ-8s() {
            return FocusDirection.Previous;
        }

        public final int getRight-dhqQ-8s() {
            return FocusDirection.Right;
        }

        public final int getUp-dhqQ-8s() {
            return FocusDirection.Up;
        }
    }

    public static final Companion Companion;
    private static final int Down;
    private static final int Enter;
    private static final int Exit;
    private static final int Left;
    private static final int Next;
    private static final int Previous;
    private static final int Right;
    private static final int Up;
    private final int value;

    static {
        FocusDirection.Companion = new Companion(null);
        FocusDirection.Next = FocusDirection.constructor-impl(1);
        FocusDirection.Previous = FocusDirection.constructor-impl(2);
        FocusDirection.Left = FocusDirection.constructor-impl(3);
        FocusDirection.Right = FocusDirection.constructor-impl(4);
        FocusDirection.Up = FocusDirection.constructor-impl(5);
        FocusDirection.Down = FocusDirection.constructor-impl(6);
        FocusDirection.Enter = FocusDirection.constructor-impl(7);
        FocusDirection.Exit = FocusDirection.constructor-impl(8);
    }

    private FocusDirection(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getDown$cp() {
        return FocusDirection.Down;
    }

    public static final int access$getEnter$cp() {
        return FocusDirection.Enter;
    }

    public static final int access$getExit$cp() {
        return FocusDirection.Exit;
    }

    public static final int access$getLeft$cp() {
        return FocusDirection.Left;
    }

    public static final int access$getNext$cp() {
        return FocusDirection.Next;
    }

    public static final int access$getPrevious$cp() {
        return FocusDirection.Previous;
    }

    public static final int access$getRight$cp() {
        return FocusDirection.Right;
    }

    public static final int access$getUp$cp() {
        return FocusDirection.Up;
    }

    public static final FocusDirection box-impl(int arg1) {
        return new FocusDirection(arg1);
    }

    public static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return FocusDirection.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof FocusDirection)) {
            return 0;
        }

        if(arg2 != ((FocusDirection)arg3).unbox-impl()) {
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
        return FocusDirection.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return FocusDirection.toString-impl(this.value);
    }

    public static String toString-impl(int arg1) {
        if(FocusDirection.equals-impl0(arg1, FocusDirection.Next)) {
            return "Next";
        }

        if(FocusDirection.equals-impl0(arg1, FocusDirection.Previous)) {
            return "Previous";
        }

        if(FocusDirection.equals-impl0(arg1, FocusDirection.Left)) {
            return "Left";
        }

        if(FocusDirection.equals-impl0(arg1, FocusDirection.Right)) {
            return "Right";
        }

        if(FocusDirection.equals-impl0(arg1, FocusDirection.Up)) {
            return "Up";
        }

        if(FocusDirection.equals-impl0(arg1, FocusDirection.Down)) {
            return "Down";
        }

        if(FocusDirection.equals-impl0(arg1, FocusDirection.Enter)) {
            return "Enter";
        }

        if(FocusDirection.equals-impl0(arg1, FocusDirection.Exit)) {
            return "Exit";
        }

        return "Invalid FocusDirection";
    }

    public final int unbox-impl() {
        return this.value;
    }
}

