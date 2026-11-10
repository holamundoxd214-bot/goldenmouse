package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u0003HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000F"}, d2={"Landroidx/compose/material3/ShortNavigationBarArrangement;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class ShortNavigationBarArrangement {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007¨\u0006\u000B"}, d2={"Landroidx/compose/material3/ShortNavigationBarArrangement$Companion;", "", "<init>", "()V", "EqualWeight", "Landroidx/compose/material3/ShortNavigationBarArrangement;", "getEqualWeight-LnnQw40", "()I", "I", "Centered", "getCentered-LnnQw40", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getCentered-LnnQw40() {
            return ShortNavigationBarArrangement.Centered;
        }

        public final int getEqualWeight-LnnQw40() {
            return ShortNavigationBarArrangement.EqualWeight;
        }
    }

    private static final int Centered;
    public static final Companion Companion;
    private static final int EqualWeight;
    private final int value;

    static {
        ShortNavigationBarArrangement.Companion = new Companion(null);
        ShortNavigationBarArrangement.EqualWeight = ShortNavigationBarArrangement.constructor-impl(0);
        ShortNavigationBarArrangement.Centered = ShortNavigationBarArrangement.constructor-impl(1);
    }

    private ShortNavigationBarArrangement(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getCentered$cp() {
        return ShortNavigationBarArrangement.Centered;
    }

    public static final int access$getEqualWeight$cp() {
        return ShortNavigationBarArrangement.EqualWeight;
    }

    public static final ShortNavigationBarArrangement box-impl(int arg1) {
        return new ShortNavigationBarArrangement(arg1);
    }

    private static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return ShortNavigationBarArrangement.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof ShortNavigationBarArrangement)) {
            return 0;
        }

        if(arg2 != ((ShortNavigationBarArrangement)arg3).unbox-impl()) {
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
        return ShortNavigationBarArrangement.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return ShortNavigationBarArrangement.toString-impl(this.value);
    }

    public static String toString-impl(int arg1) {
        if(ShortNavigationBarArrangement.equals-impl0(arg1, ShortNavigationBarArrangement.EqualWeight)) {
            return "EqualWeight";
        }

        if(ShortNavigationBarArrangement.equals-impl0(arg1, ShortNavigationBarArrangement.Centered)) {
            return "Centered";
        }

        return "Unknown";
    }

    public final int unbox-impl() {
        return this.value;
    }
}

