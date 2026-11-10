package androidx.compose.foundation.text.input;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0087@\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÖ\u0001J\t\u0010\f\u001A\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u000F"}, d2={"Landroidx/compose/foundation/text/input/TextObfuscationMode;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "hashCode", "toString", "", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class TextObfuscationMode {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007¨\u0006\r"}, d2={"Landroidx/compose/foundation/text/input/TextObfuscationMode$Companion;", "", "<init>", "()V", "Visible", "Landroidx/compose/foundation/text/input/TextObfuscationMode;", "getVisible-vTwcZD0", "()I", "I", "RevealLastTyped", "getRevealLastTyped-vTwcZD0", "Hidden", "getHidden-vTwcZD0", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getHidden-vTwcZD0() {
            return TextObfuscationMode.Hidden;
        }

        public final int getRevealLastTyped-vTwcZD0() {
            return TextObfuscationMode.RevealLastTyped;
        }

        public final int getVisible-vTwcZD0() {
            return TextObfuscationMode.Visible;
        }
    }

    public static final Companion Companion;
    private static final int Hidden;
    private static final int RevealLastTyped;
    private static final int Visible;
    private final int value;

    static {
        TextObfuscationMode.Companion = new Companion(null);
        TextObfuscationMode.Visible = TextObfuscationMode.constructor-impl(0);
        TextObfuscationMode.RevealLastTyped = TextObfuscationMode.constructor-impl(1);
        TextObfuscationMode.Hidden = TextObfuscationMode.constructor-impl(2);
    }

    private TextObfuscationMode(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getHidden$cp() {
        return TextObfuscationMode.Hidden;
    }

    public static final int access$getRevealLastTyped$cp() {
        return TextObfuscationMode.RevealLastTyped;
    }

    public static final int access$getVisible$cp() {
        return TextObfuscationMode.Visible;
    }

    public static final TextObfuscationMode box-impl(int arg1) {
        return new TextObfuscationMode(arg1);
    }

    public static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return TextObfuscationMode.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof TextObfuscationMode)) {
            return 0;
        }

        if(arg2 != ((TextObfuscationMode)arg3).unbox-impl()) {
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
        return TextObfuscationMode.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return TextObfuscationMode.toString-impl(this.value);
    }

    public static String toString-impl(int arg2) {
        return "TextObfuscationMode(value=" + arg2 + ')';
    }

    public final int unbox-impl() {
        return this.value;
    }
}

