package androidx.compose.ui.text.style;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\b\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0011"}, d2={"Landroidx/compose/ui/text/style/TextDirection;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class TextDirection {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0013\u001A\u00020\u00052\u0006\u0010\u0014\u001A\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007R\u0013\u0010\u000F\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0012\u0010\u0007¨\u0006\u0018"}, d2={"Landroidx/compose/ui/text/style/TextDirection$Companion;", "", "<init>", "()V", "Ltr", "Landroidx/compose/ui/text/style/TextDirection;", "getLtr-s_7X-co", "()I", "I", "Rtl", "getRtl-s_7X-co", "Content", "getContent-s_7X-co", "ContentOrLtr", "getContentOrLtr-s_7X-co", "ContentOrRtl", "getContentOrRtl-s_7X-co", "Unspecified", "getUnspecified-s_7X-co", "valueOf", "value", "", "valueOf-E8nx0Ws", "(I)I", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getContent-s_7X-co() {
            return TextDirection.Content;
        }

        public final int getContentOrLtr-s_7X-co() {
            return TextDirection.ContentOrLtr;
        }

        public final int getContentOrRtl-s_7X-co() {
            return TextDirection.ContentOrRtl;
        }

        public final int getLtr-s_7X-co() {
            return TextDirection.Ltr;
        }

        public final int getRtl-s_7X-co() {
            return TextDirection.Rtl;
        }

        public final int getUnspecified-s_7X-co() {
            return TextDirection.Unspecified;
        }

        public final int valueOf-E8nx0Ws(int arg2) {
            int v1 = 0;
            if(arg2 >= 0 && arg2 < 6) {
                v1 = 1;
            }

            if(v1 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("The given value=" + arg2 + " is not recognized by TextDirection.");
            }

            return TextDirection.constructor-impl(arg2);
        }
    }

    public static final Companion Companion;
    private static final int Content;
    private static final int ContentOrLtr;
    private static final int ContentOrRtl;
    private static final int Ltr;
    private static final int Rtl;
    private static final int Unspecified;
    private final int value;

    static {
        TextDirection.Companion = new Companion(null);
        TextDirection.Ltr = TextDirection.constructor-impl(1);
        TextDirection.Rtl = TextDirection.constructor-impl(2);
        TextDirection.Content = TextDirection.constructor-impl(3);
        TextDirection.ContentOrLtr = TextDirection.constructor-impl(4);
        TextDirection.ContentOrRtl = TextDirection.constructor-impl(5);
        TextDirection.Unspecified = TextDirection.constructor-impl(0);
    }

    private TextDirection(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getContent$cp() {
        return TextDirection.Content;
    }

    public static final int access$getContentOrLtr$cp() {
        return TextDirection.ContentOrLtr;
    }

    public static final int access$getContentOrRtl$cp() {
        return TextDirection.ContentOrRtl;
    }

    public static final int access$getLtr$cp() {
        return TextDirection.Ltr;
    }

    public static final int access$getRtl$cp() {
        return TextDirection.Rtl;
    }

    public static final int access$getUnspecified$cp() {
        return TextDirection.Unspecified;
    }

    public static final TextDirection box-impl(int arg1) {
        return new TextDirection(arg1);
    }

    public static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return TextDirection.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof TextDirection)) {
            return 0;
        }

        if(arg2 != ((TextDirection)arg3).unbox-impl()) {
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
        return TextDirection.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return TextDirection.toString-impl(this.value);
    }

    public static String toString-impl(int arg1) {
        if(TextDirection.equals-impl0(arg1, TextDirection.Ltr)) {
            return "Ltr";
        }

        if(TextDirection.equals-impl0(arg1, TextDirection.Rtl)) {
            return "Rtl";
        }

        if(TextDirection.equals-impl0(arg1, TextDirection.Content)) {
            return "Content";
        }

        if(TextDirection.equals-impl0(arg1, TextDirection.ContentOrLtr)) {
            return "ContentOrLtr";
        }

        if(TextDirection.equals-impl0(arg1, TextDirection.ContentOrRtl)) {
            return "ContentOrRtl";
        }

        if(TextDirection.equals-impl0(arg1, TextDirection.Unspecified)) {
            return "Unspecified";
        }

        return "Invalid";
    }

    public final int unbox-impl() {
        return this.value;
    }
}

