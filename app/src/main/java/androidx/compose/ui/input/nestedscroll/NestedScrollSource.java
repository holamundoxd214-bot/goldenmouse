package androidx.compose.ui.input.nestedscroll;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u0003HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000F"}, d2={"Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class NestedScrollSource {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u001E\u0010\u000B\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\f\u0010\u0003\u001A\u0004\b\r\u0010\u0007R\u001E\u0010\u000E\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u000F\u0010\u0003\u001A\u0004\b\u0010\u0010\u0007R\u001E\u0010\u0011\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0012\u0010\u0003\u001A\u0004\b\u0013\u0010\u0007R\u001E\u0010\u0014\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0015\u0010\u0003\u001A\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2={"Landroidx/compose/ui/input/nestedscroll/NestedScrollSource$Companion;", "", "<init>", "()V", "UserInput", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "getUserInput-WNlRxjI", "()I", "I", "SideEffect", "getSideEffect-WNlRxjI", "Drag", "getDrag-WNlRxjI$annotations", "getDrag-WNlRxjI", "Fling", "getFling-WNlRxjI$annotations", "getFling-WNlRxjI", "Relocate", "getRelocate-WNlRxjI$annotations", "getRelocate-WNlRxjI", "Wheel", "getWheel-WNlRxjI$annotations", "getWheel-WNlRxjI", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getDrag-WNlRxjI() {
            return NestedScrollSource.Drag;
        }

        @Deprecated(message="This has been replaced by UserInput.", replaceWith="<_subannotation>") public static void getDrag-WNlRxjI$annotations() {
        }

        public final int getFling-WNlRxjI() {
            return NestedScrollSource.Fling;
        }

        @Deprecated(message="This has been replaced by SideEffect.", replaceWith="<_subannotation>") public static void getFling-WNlRxjI$annotations() {
        }

        public final int getRelocate-WNlRxjI() {
            return NestedScrollSource.Relocate;
        }

        @Deprecated(message="Do not use. Will be removed in the future.") public static void getRelocate-WNlRxjI$annotations() {
        }

        public final int getSideEffect-WNlRxjI() {
            return NestedScrollSource.SideEffect;
        }

        public final int getUserInput-WNlRxjI() {
            return NestedScrollSource.UserInput;
        }

        public final int getWheel-WNlRxjI() {
            return NestedScrollSource.Wheel;
        }

        @Deprecated(message="This has been replaced by UserInput.", replaceWith="<_subannotation>") public static void getWheel-WNlRxjI$annotations() {
        }
    }

    public static final Companion Companion;
    private static final int Drag;
    private static final int Fling;
    private static final int Relocate;
    private static final int SideEffect;
    private static final int UserInput;
    private static final int Wheel;
    private final int value;

    static {
        NestedScrollSource.Companion = new Companion(null);
        int v0 = NestedScrollSource.constructor-impl(1);
        NestedScrollSource.UserInput = v0;
        int v1 = NestedScrollSource.constructor-impl(2);
        NestedScrollSource.SideEffect = v1;
        NestedScrollSource.Drag = v0;
        NestedScrollSource.Fling = v1;
        NestedScrollSource.Relocate = NestedScrollSource.constructor-impl(3);
        NestedScrollSource.Wheel = v0;
    }

    private NestedScrollSource(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getDrag$cp() {
        return NestedScrollSource.Drag;
    }

    public static final int access$getFling$cp() {
        return NestedScrollSource.Fling;
    }

    public static final int access$getRelocate$cp() {
        return NestedScrollSource.Relocate;
    }

    public static final int access$getSideEffect$cp() {
        return NestedScrollSource.SideEffect;
    }

    public static final int access$getUserInput$cp() {
        return NestedScrollSource.UserInput;
    }

    public static final int access$getWheel$cp() {
        return NestedScrollSource.Wheel;
    }

    public static final NestedScrollSource box-impl(int arg1) {
        return new NestedScrollSource(arg1);
    }

    public static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return NestedScrollSource.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof NestedScrollSource)) {
            return 0;
        }

        if(arg2 != ((NestedScrollSource)arg3).unbox-impl()) {
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
        return NestedScrollSource.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return NestedScrollSource.toString-impl(this.value);
    }

    public static String toString-impl(int arg1) {
        if(NestedScrollSource.equals-impl0(arg1, NestedScrollSource.UserInput)) {
            return "UserInput";
        }

        if(NestedScrollSource.equals-impl0(arg1, NestedScrollSource.SideEffect)) {
            return "SideEffect";
        }

        if(NestedScrollSource.equals-impl0(arg1, NestedScrollSource.Relocate)) {
            return "Relocate";
        }

        return "Invalid";
    }

    public final int unbox-impl() {
        return this.value;
    }
}

