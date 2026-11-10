package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u0003HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000F"}, d2={"Landroidx/compose/ui/text/PlaceholderVerticalAlign;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class PlaceholderVerticalAlign {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007R\u0013\u0010\u000F\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0014\u0010\u0007¨\u0006\u0015"}, d2={"Landroidx/compose/ui/text/PlaceholderVerticalAlign$Companion;", "", "<init>", "()V", "AboveBaseline", "Landroidx/compose/ui/text/PlaceholderVerticalAlign;", "getAboveBaseline-J6kI3mc", "()I", "I", "Top", "getTop-J6kI3mc", "Bottom", "getBottom-J6kI3mc", "Center", "getCenter-J6kI3mc", "TextTop", "getTextTop-J6kI3mc", "TextBottom", "getTextBottom-J6kI3mc", "TextCenter", "getTextCenter-J6kI3mc", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getAboveBaseline-J6kI3mc() {
            return PlaceholderVerticalAlign.AboveBaseline;
        }

        public final int getBottom-J6kI3mc() {
            return PlaceholderVerticalAlign.Bottom;
        }

        public final int getCenter-J6kI3mc() {
            return PlaceholderVerticalAlign.Center;
        }

        public final int getTextBottom-J6kI3mc() {
            return PlaceholderVerticalAlign.TextBottom;
        }

        public final int getTextCenter-J6kI3mc() {
            return PlaceholderVerticalAlign.TextCenter;
        }

        public final int getTextTop-J6kI3mc() {
            return PlaceholderVerticalAlign.TextTop;
        }

        public final int getTop-J6kI3mc() {
            return PlaceholderVerticalAlign.Top;
        }
    }

    private static final int AboveBaseline;
    private static final int Bottom;
    private static final int Center;
    public static final Companion Companion;
    private static final int TextBottom;
    private static final int TextCenter;
    private static final int TextTop;
    private static final int Top;
    private final int value;

    static {
        PlaceholderVerticalAlign.Companion = new Companion(null);
        PlaceholderVerticalAlign.AboveBaseline = PlaceholderVerticalAlign.constructor-impl(1);
        PlaceholderVerticalAlign.Top = PlaceholderVerticalAlign.constructor-impl(2);
        PlaceholderVerticalAlign.Bottom = PlaceholderVerticalAlign.constructor-impl(3);
        PlaceholderVerticalAlign.Center = PlaceholderVerticalAlign.constructor-impl(4);
        PlaceholderVerticalAlign.TextTop = PlaceholderVerticalAlign.constructor-impl(5);
        PlaceholderVerticalAlign.TextBottom = PlaceholderVerticalAlign.constructor-impl(6);
        PlaceholderVerticalAlign.TextCenter = PlaceholderVerticalAlign.constructor-impl(7);
    }

    private PlaceholderVerticalAlign(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getAboveBaseline$cp() {
        return PlaceholderVerticalAlign.AboveBaseline;
    }

    public static final int access$getBottom$cp() {
        return PlaceholderVerticalAlign.Bottom;
    }

    public static final int access$getCenter$cp() {
        return PlaceholderVerticalAlign.Center;
    }

    public static final int access$getTextBottom$cp() {
        return PlaceholderVerticalAlign.TextBottom;
    }

    public static final int access$getTextCenter$cp() {
        return PlaceholderVerticalAlign.TextCenter;
    }

    public static final int access$getTextTop$cp() {
        return PlaceholderVerticalAlign.TextTop;
    }

    public static final int access$getTop$cp() {
        return PlaceholderVerticalAlign.Top;
    }

    public static final PlaceholderVerticalAlign box-impl(int arg1) {
        return new PlaceholderVerticalAlign(arg1);
    }

    public static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return PlaceholderVerticalAlign.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof PlaceholderVerticalAlign)) {
            return 0;
        }

        if(arg2 != ((PlaceholderVerticalAlign)arg3).unbox-impl()) {
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
        return PlaceholderVerticalAlign.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return PlaceholderVerticalAlign.toString-impl(this.value);
    }

    public static String toString-impl(int arg1) {
        if(PlaceholderVerticalAlign.equals-impl0(arg1, PlaceholderVerticalAlign.AboveBaseline)) {
            return "AboveBaseline";
        }

        if(PlaceholderVerticalAlign.equals-impl0(arg1, PlaceholderVerticalAlign.Top)) {
            return "Top";
        }

        if(PlaceholderVerticalAlign.equals-impl0(arg1, PlaceholderVerticalAlign.Bottom)) {
            return "Bottom";
        }

        if(PlaceholderVerticalAlign.equals-impl0(arg1, PlaceholderVerticalAlign.Center)) {
            return "Center";
        }

        if(PlaceholderVerticalAlign.equals-impl0(arg1, PlaceholderVerticalAlign.TextTop)) {
            return "TextTop";
        }

        if(PlaceholderVerticalAlign.equals-impl0(arg1, PlaceholderVerticalAlign.TextBottom)) {
            return "TextBottom";
        }

        if(PlaceholderVerticalAlign.equals-impl0(arg1, PlaceholderVerticalAlign.TextCenter)) {
            return "TextCenter";
        }

        return "Invalid";
    }

    public final int unbox-impl() {
        return this.value;
    }
}

