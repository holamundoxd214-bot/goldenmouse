package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\b\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0011"}, d2={"Landroidx/compose/ui/text/font/FontLoadingStrategy;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class FontLoadingStrategy {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007¨\u0006\r"}, d2={"Landroidx/compose/ui/text/font/FontLoadingStrategy$Companion;", "", "<init>", "()V", "Blocking", "Landroidx/compose/ui/text/font/FontLoadingStrategy;", "getBlocking-PKNRLFQ", "()I", "I", "OptionalLocal", "getOptionalLocal-PKNRLFQ", "Async", "getAsync-PKNRLFQ", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getAsync-PKNRLFQ() {
            return FontLoadingStrategy.Async;
        }

        public final int getBlocking-PKNRLFQ() {
            return FontLoadingStrategy.Blocking;
        }

        public final int getOptionalLocal-PKNRLFQ() {
            return FontLoadingStrategy.OptionalLocal;
        }
    }

    private static final int Async;
    private static final int Blocking;
    public static final Companion Companion;
    private static final int OptionalLocal;
    private final int value;

    static {
        FontLoadingStrategy.Companion = new Companion(null);
        FontLoadingStrategy.Blocking = FontLoadingStrategy.constructor-impl(0);
        FontLoadingStrategy.OptionalLocal = FontLoadingStrategy.constructor-impl(1);
        FontLoadingStrategy.Async = FontLoadingStrategy.constructor-impl(2);
    }

    private FontLoadingStrategy(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getAsync$cp() {
        return FontLoadingStrategy.Async;
    }

    public static final int access$getBlocking$cp() {
        return FontLoadingStrategy.Blocking;
    }

    public static final int access$getOptionalLocal$cp() {
        return FontLoadingStrategy.OptionalLocal;
    }

    public static final FontLoadingStrategy box-impl(int arg1) {
        return new FontLoadingStrategy(arg1);
    }

    private static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return FontLoadingStrategy.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof FontLoadingStrategy)) {
            return 0;
        }

        if(arg2 != ((FontLoadingStrategy)arg3).unbox-impl()) {
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
        return FontLoadingStrategy.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return FontLoadingStrategy.toString-impl(this.value);
    }

    public static String toString-impl(int arg2) {
        if(FontLoadingStrategy.equals-impl0(arg2, FontLoadingStrategy.Blocking)) {
            return "Blocking";
        }

        if(FontLoadingStrategy.equals-impl0(arg2, FontLoadingStrategy.OptionalLocal)) {
            return "Optional";
        }

        if(FontLoadingStrategy.equals-impl0(arg2, FontLoadingStrategy.Async)) {
            return "Async";
        }

        return "Invalid(value=" + arg2 + ')';
    }

    public final int unbox-impl() {
        return this.value;
    }
}

