package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u0003HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000F"}, d2={"Landroidx/compose/ui/input/pointer/PointerType;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class PointerType {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007R\u0013\u0010\u000F\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2={"Landroidx/compose/ui/input/pointer/PointerType$Companion;", "", "<init>", "()V", "Unknown", "Landroidx/compose/ui/input/pointer/PointerType;", "getUnknown-T8wyACA", "()I", "I", "Touch", "getTouch-T8wyACA", "Mouse", "getMouse-T8wyACA", "Stylus", "getStylus-T8wyACA", "Eraser", "getEraser-T8wyACA", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getEraser-T8wyACA() {
            return PointerType.Eraser;
        }

        public final int getMouse-T8wyACA() {
            return PointerType.Mouse;
        }

        public final int getStylus-T8wyACA() {
            return PointerType.Stylus;
        }

        public final int getTouch-T8wyACA() {
            return PointerType.Touch;
        }

        public final int getUnknown-T8wyACA() {
            return PointerType.Unknown;
        }
    }

    public static final Companion Companion;
    private static final int Eraser;
    private static final int Mouse;
    private static final int Stylus;
    private static final int Touch;
    private static final int Unknown;
    private final int value;

    static {
        PointerType.Companion = new Companion(null);
        PointerType.Unknown = PointerType.constructor-impl(0);
        PointerType.Touch = PointerType.constructor-impl(1);
        PointerType.Mouse = PointerType.constructor-impl(2);
        PointerType.Stylus = PointerType.constructor-impl(3);
        PointerType.Eraser = PointerType.constructor-impl(4);
    }

    private PointerType(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getEraser$cp() {
        return PointerType.Eraser;
    }

    public static final int access$getMouse$cp() {
        return PointerType.Mouse;
    }

    public static final int access$getStylus$cp() {
        return PointerType.Stylus;
    }

    public static final int access$getTouch$cp() {
        return PointerType.Touch;
    }

    public static final int access$getUnknown$cp() {
        return PointerType.Unknown;
    }

    public static final PointerType box-impl(int arg1) {
        return new PointerType(arg1);
    }

    private static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return PointerType.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof PointerType)) {
            return 0;
        }

        if(arg2 != ((PointerType)arg3).unbox-impl()) {
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
        return PointerType.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return PointerType.toString-impl(this.value);
    }

    public static String toString-impl(int arg1) {
        if(arg1 != 1) {
            if(arg1 != 2) {
                if(arg1 != 3) {
                    if(arg1 != 4) {
                        return "Unknown";
                    }

                    return "Eraser";
                }

                return "Stylus";
            }

            return "Mouse";
        }

        return "Touch";
    }

    public final int unbox-impl() {
        return this.value;
    }
}

