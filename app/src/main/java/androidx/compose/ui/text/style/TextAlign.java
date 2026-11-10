package androidx.compose.ui.text.style;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\b\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0011"}, d2={"Landroidx/compose/ui/text/style/TextAlign;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class TextAlign {
    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00050\u0016J\u0015\u0010\u0017\u001A\u00020\u00052\u0006\u0010\u0018\u001A\u00020\u0019¢\u0006\u0004\b\u001A\u0010\u001BR\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007R\u0013\u0010\u000F\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0014\u0010\u0007¨\u0006\u001C"}, d2={"Landroidx/compose/ui/text/style/TextAlign$Companion;", "", "<init>", "()V", "Left", "Landroidx/compose/ui/text/style/TextAlign;", "getLeft-e0LSkKk", "()I", "I", "Right", "getRight-e0LSkKk", "Center", "getCenter-e0LSkKk", "Justify", "getJustify-e0LSkKk", "Start", "getStart-e0LSkKk", "End", "getEnd-e0LSkKk", "Unspecified", "getUnspecified-e0LSkKk", "values", "", "valueOf", "value", "", "valueOf-IgVj0fw", "(I)I", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getCenter-e0LSkKk() {
            return TextAlign.Center;
        }

        public final int getEnd-e0LSkKk() {
            return TextAlign.End;
        }

        public final int getJustify-e0LSkKk() {
            return TextAlign.Justify;
        }

        public final int getLeft-e0LSkKk() {
            return TextAlign.Left;
        }

        public final int getRight-e0LSkKk() {
            return TextAlign.Right;
        }

        public final int getStart-e0LSkKk() {
            return TextAlign.Start;
        }

        public final int getUnspecified-e0LSkKk() {
            return TextAlign.Unspecified;
        }

        public final int valueOf-IgVj0fw(int arg2) {
            int v1 = 0;
            if(arg2 >= 0 && arg2 < 7) {
                v1 = 1;
            }

            if(v1 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("The given value=" + arg2 + " is not recognized by TextAlign.");
            }

            return TextAlign.constructor-impl(arg2);
        }

        public final List values() {
            return CollectionsKt.listOf(new TextAlign[]{TextAlign.box-impl(this.getLeft-e0LSkKk()), TextAlign.box-impl(this.getRight-e0LSkKk()), TextAlign.box-impl(this.getCenter-e0LSkKk()), TextAlign.box-impl(this.getJustify-e0LSkKk()), TextAlign.box-impl(this.getStart-e0LSkKk()), TextAlign.box-impl(this.getEnd-e0LSkKk())});
        }
    }

    private static final int Center;
    public static final Companion Companion;
    private static final int End;
    private static final int Justify;
    private static final int Left;
    private static final int Right;
    private static final int Start;
    private static final int Unspecified;
    private final int value;

    static {
        TextAlign.Companion = new Companion(null);
        TextAlign.Left = TextAlign.constructor-impl(1);
        TextAlign.Right = TextAlign.constructor-impl(2);
        TextAlign.Center = TextAlign.constructor-impl(3);
        TextAlign.Justify = TextAlign.constructor-impl(4);
        TextAlign.Start = TextAlign.constructor-impl(5);
        TextAlign.End = TextAlign.constructor-impl(6);
        TextAlign.Unspecified = TextAlign.constructor-impl(0);
    }

    private TextAlign(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getCenter$cp() {
        return TextAlign.Center;
    }

    public static final int access$getEnd$cp() {
        return TextAlign.End;
    }

    public static final int access$getJustify$cp() {
        return TextAlign.Justify;
    }

    public static final int access$getLeft$cp() {
        return TextAlign.Left;
    }

    public static final int access$getRight$cp() {
        return TextAlign.Right;
    }

    public static final int access$getStart$cp() {
        return TextAlign.Start;
    }

    public static final int access$getUnspecified$cp() {
        return TextAlign.Unspecified;
    }

    public static final TextAlign box-impl(int arg1) {
        return new TextAlign(arg1);
    }

    public static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return TextAlign.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof TextAlign)) {
            return 0;
        }

        if(arg2 != ((TextAlign)arg3).unbox-impl()) {
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
        return TextAlign.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return TextAlign.toString-impl(this.value);
    }

    public static String toString-impl(int arg1) {
        if(TextAlign.equals-impl0(arg1, TextAlign.Left)) {
            return "Left";
        }

        if(TextAlign.equals-impl0(arg1, TextAlign.Right)) {
            return "Right";
        }

        if(TextAlign.equals-impl0(arg1, TextAlign.Center)) {
            return "Center";
        }

        if(TextAlign.equals-impl0(arg1, TextAlign.Justify)) {
            return "Justify";
        }

        if(TextAlign.equals-impl0(arg1, TextAlign.Start)) {
            return "Start";
        }

        if(TextAlign.equals-impl0(arg1, TextAlign.End)) {
            return "End";
        }

        if(TextAlign.equals-impl0(arg1, TextAlign.Unspecified)) {
            return "Unspecified";
        }

        return "Invalid";
    }

    public final int unbox-impl() {
        return this.value;
    }
}

