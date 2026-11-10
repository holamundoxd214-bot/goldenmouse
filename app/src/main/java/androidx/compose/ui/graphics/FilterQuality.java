package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\b\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0011"}, d2={"Landroidx/compose/ui/graphics/FilterQuality;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class FilterQuality {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007¨\u0006\u000F"}, d2={"Landroidx/compose/ui/graphics/FilterQuality$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/ui/graphics/FilterQuality;", "getNone-f-v9h1I", "()I", "I", "Low", "getLow-f-v9h1I", "Medium", "getMedium-f-v9h1I", "High", "getHigh-f-v9h1I", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getHigh-f-v9h1I() {
            return FilterQuality.High;
        }

        public final int getLow-f-v9h1I() {
            return FilterQuality.Low;
        }

        public final int getMedium-f-v9h1I() {
            return FilterQuality.Medium;
        }

        public final int getNone-f-v9h1I() {
            return FilterQuality.None;
        }
    }

    public static final Companion Companion;
    private static final int High;
    private static final int Low;
    private static final int Medium;
    private static final int None;
    private final int value;

    static {
        FilterQuality.Companion = new Companion(null);
        FilterQuality.None = FilterQuality.constructor-impl(0);
        FilterQuality.Low = FilterQuality.constructor-impl(1);
        FilterQuality.Medium = FilterQuality.constructor-impl(2);
        FilterQuality.High = FilterQuality.constructor-impl(3);
    }

    private FilterQuality(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getHigh$cp() {
        return FilterQuality.High;
    }

    public static final int access$getLow$cp() {
        return FilterQuality.Low;
    }

    public static final int access$getMedium$cp() {
        return FilterQuality.Medium;
    }

    public static final int access$getNone$cp() {
        return FilterQuality.None;
    }

    public static final FilterQuality box-impl(int arg1) {
        return new FilterQuality(arg1);
    }

    public static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return FilterQuality.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof FilterQuality)) {
            return 0;
        }

        if(arg2 != ((FilterQuality)arg3).unbox-impl()) {
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

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return FilterQuality.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return FilterQuality.toString-impl(this.value);
    }

    public static String toString-impl(int arg1) {
        if(FilterQuality.equals-impl0(arg1, FilterQuality.None)) {
            return "None";
        }

        if(FilterQuality.equals-impl0(arg1, FilterQuality.Low)) {
            return "Low";
        }

        if(FilterQuality.equals-impl0(arg1, FilterQuality.Medium)) {
            return "Medium";
        }

        if(FilterQuality.equals-impl0(arg1, FilterQuality.High)) {
            return "High";
        }

        return "Unknown";
    }

    public final int unbox-impl() {
        return this.value;
    }
}

