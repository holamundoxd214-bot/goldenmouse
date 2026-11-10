package androidx.compose.ui.text.font;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\b\u0087@\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\b\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u0013\u0010\u0012\u001A\u00020\r2\b\u0010\u0013\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001A\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u000F\u0088\u0001\u0002¨\u0006\u0016"}, d2={"Landroidx/compose/ui/text/font/FontSynthesis;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "isWeightOn", "", "isWeightOn-impl$ui_text", "(I)Z", "isStyleOn", "isStyleOn-impl$ui_text", "equals", "other", "hashCode", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class FontSynthesis {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007¨\u0006\u0014"}, d2={"Landroidx/compose/ui/text/font/FontSynthesis$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/ui/text/font/FontSynthesis;", "getNone-GVVA2EU", "()I", "I", "Weight", "getWeight-GVVA2EU", "Style", "getStyle-GVVA2EU", "All", "getAll-GVVA2EU", "valueOf", "value", "", "valueOf-9CiegCU", "(I)I", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getAll-GVVA2EU() {
            return FontSynthesis.All;
        }

        public final int getNone-GVVA2EU() {
            return FontSynthesis.None;
        }

        public final int getStyle-GVVA2EU() {
            return FontSynthesis.Style;
        }

        public final int getWeight-GVVA2EU() {
            return FontSynthesis.Weight;
        }

        public final int valueOf-9CiegCU(int arg2) {
            int v1 = 1;
            if(arg2 != 0 && arg2 != 1 && arg2 != 2) {
                if(arg2 == 0xFFFF) {
                }
                else {
                    v1 = 0;
                }
            }

            if(v1 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("The given value=" + arg2 + " is not recognized by FontSynthesis.");
            }

            return FontSynthesis.constructor-impl(arg2);
        }
    }

    private static final int All;
    public static final Companion Companion;
    private static final int None;
    private static final int Style;
    private static final int Weight;
    private final int value;

    static {
        FontSynthesis.Companion = new Companion(null);
        FontSynthesis.None = FontSynthesis.constructor-impl(0);
        FontSynthesis.Weight = FontSynthesis.constructor-impl(1);
        FontSynthesis.Style = FontSynthesis.constructor-impl(2);
        FontSynthesis.All = FontSynthesis.constructor-impl(0xFFFF);
    }

    private FontSynthesis(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getAll$cp() {
        return FontSynthesis.All;
    }

    public static final int access$getNone$cp() {
        return FontSynthesis.None;
    }

    public static final int access$getStyle$cp() {
        return FontSynthesis.Style;
    }

    public static final int access$getWeight$cp() {
        return FontSynthesis.Weight;
    }

    public static final FontSynthesis box-impl(int arg1) {
        return new FontSynthesis(arg1);
    }

    public static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return FontSynthesis.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof FontSynthesis)) {
            return 0;
        }

        if(arg2 != ((FontSynthesis)arg3).unbox-impl()) {
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
        return FontSynthesis.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public static final boolean isStyleOn-impl$ui_text(int arg0) {
        if((arg0 & 2) != 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean isWeightOn-impl$ui_text(int arg1) {
        if((arg1 & 1) != 0) {
            return 1;
        }

        return 0;
    }

    public String toString() {
        return FontSynthesis.toString-impl(this.value);
    }

    public static String toString-impl(int arg1) {
        if(FontSynthesis.equals-impl0(arg1, FontSynthesis.None)) {
            return "None";
        }

        if(FontSynthesis.equals-impl0(arg1, FontSynthesis.Weight)) {
            return "Weight";
        }

        if(FontSynthesis.equals-impl0(arg1, FontSynthesis.Style)) {
            return "Style";
        }

        if(FontSynthesis.equals-impl0(arg1, FontSynthesis.All)) {
            return "All";
        }

        return "Invalid";
    }

    public final int unbox-impl() {
        return this.value;
    }
}

