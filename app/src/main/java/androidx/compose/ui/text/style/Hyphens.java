package androidx.compose.ui.text.style;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\b\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0011"}, d2={"Landroidx/compose/ui/text/style/Hyphens;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class Hyphens {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\r\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u000F¢\u0006\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007¨\u0006\u0012"}, d2={"Landroidx/compose/ui/text/style/Hyphens$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/ui/text/style/Hyphens;", "getNone-vmbZdU8", "()I", "I", "Auto", "getAuto-vmbZdU8", "Unspecified", "getUnspecified-vmbZdU8", "valueOf", "value", "", "valueOf-kPa1_AA", "(I)I", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getAuto-vmbZdU8() {
            return Hyphens.Auto;
        }

        public final int getNone-vmbZdU8() {
            return Hyphens.None;
        }

        public final int getUnspecified-vmbZdU8() {
            return Hyphens.Unspecified;
        }

        public final int valueOf-kPa1_AA(int arg2) {
            int v1 = 0;
            if(arg2 >= 0 && arg2 < 3) {
                v1 = 1;
            }

            if(v1 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("The given value=" + arg2 + " is not recognized by Hyphens.");
            }

            return Hyphens.constructor-impl(arg2);
        }
    }

    private static final int Auto;
    public static final Companion Companion;
    private static final int None;
    private static final int Unspecified;
    private final int value;

    static {
        Hyphens.Companion = new Companion(null);
        Hyphens.None = Hyphens.constructor-impl(1);
        Hyphens.Auto = Hyphens.constructor-impl(2);
        Hyphens.Unspecified = Hyphens.constructor-impl(0);
    }

    private Hyphens(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getAuto$cp() {
        return Hyphens.Auto;
    }

    public static final int access$getNone$cp() {
        return Hyphens.None;
    }

    public static final int access$getUnspecified$cp() {
        return Hyphens.Unspecified;
    }

    public static final Hyphens box-impl(int arg1) {
        return new Hyphens(arg1);
    }

    public static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return Hyphens.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof Hyphens)) {
            return 0;
        }

        if(arg2 != ((Hyphens)arg3).unbox-impl()) {
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
        return Hyphens.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return Hyphens.toString-impl(this.value);
    }

    public static String toString-impl(int arg1) {
        if(Hyphens.equals-impl0(arg1, Hyphens.None)) {
            return "Hyphens.None";
        }

        if(Hyphens.equals-impl0(arg1, Hyphens.Auto)) {
            return "Hyphens.Auto";
        }

        if(Hyphens.equals-impl0(arg1, Hyphens.Unspecified)) {
            return "Hyphens.Unspecified";
        }

        return "Invalid";
    }

    public final int unbox-impl() {
        return this.value;
    }
}

