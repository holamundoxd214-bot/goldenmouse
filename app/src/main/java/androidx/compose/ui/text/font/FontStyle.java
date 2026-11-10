package androidx.compose.ui.text.font;

import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\b\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0011"}, d2={"Landroidx/compose/ui/text/font/FontStyle;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class FontStyle {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00050\u000ER\u0019\u0010\u0004\u001A\u00020\u0005¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\bR\u0019\u0010\n\u001A\u00020\u0005¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000B\u0010\u0003\u001A\u0004\b\f\u0010\b¨\u0006\u000F"}, d2={"Landroidx/compose/ui/text/font/FontStyle$Companion;", "", "<init>", "()V", "Normal", "Landroidx/compose/ui/text/font/FontStyle;", "getNormal-_-LCdwA$annotations", "getNormal-_-LCdwA", "()I", "I", "Italic", "getItalic-_-LCdwA$annotations", "getItalic-_-LCdwA", "values", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getItalic-_-LCdwA() {
            return FontStyle.Italic;
        }

        public static void getItalic-_-LCdwA$annotations() {
        }

        public final int getNormal-_-LCdwA() {
            return FontStyle.Normal;
        }

        public static void getNormal-_-LCdwA$annotations() {
        }

        public final List values() {
            return CollectionsKt.listOf(new FontStyle[]{FontStyle.box-impl(this.getNormal-_-LCdwA()), FontStyle.box-impl(this.getItalic-_-LCdwA())});
        }
    }

    public static final Companion Companion;
    private static final int Italic;
    private static final int Normal;
    private final int value;

    static {
        FontStyle.Companion = new Companion(null);
        FontStyle.Normal = FontStyle.constructor-impl(0);
        FontStyle.Italic = FontStyle.constructor-impl(1);
    }

    @Deprecated(message="Please use FontStyle.Normal or FontStyle.Italic", replaceWith="<_subannotation>") private FontStyle(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getItalic$cp() {
        return FontStyle.Italic;
    }

    public static final int access$getNormal$cp() {
        return FontStyle.Normal;
    }

    public static final FontStyle box-impl(int arg1) {
        return new FontStyle(arg1);
    }

    @Deprecated(message="Please use FontStyle.Normal or FontStyle.Italic", replaceWith="<_subannotation>") public static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return FontStyle.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof FontStyle)) {
            return 0;
        }

        if(arg2 != ((FontStyle)arg3).unbox-impl()) {
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
        return FontStyle.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return FontStyle.toString-impl(this.value);
    }

    public static String toString-impl(int arg1) {
        if(FontStyle.equals-impl0(arg1, FontStyle.Normal)) {
            return "Normal";
        }

        if(FontStyle.equals-impl0(arg1, FontStyle.Italic)) {
            return "Italic";
        }

        return "Invalid";
    }

    public final int unbox-impl() {
        return this.value;
    }
}

