package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u0003HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000F"}, d2={"Landroidx/compose/ui/text/style/TextOverflow;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class TextOverflow {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\bR\u001E\u0010\n\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000B\u0010\u0003\u001A\u0004\b\f\u0010\bR\u001E\u0010\r\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000E\u0010\u0003\u001A\u0004\b\u000F\u0010\bR\u001E\u0010\u0010\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0011\u0010\u0003\u001A\u0004\b\u0012\u0010\bR\u001E\u0010\u0013\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0014\u0010\u0003\u001A\u0004\b\u0015\u0010\b¨\u0006\u0016"}, d2={"Landroidx/compose/ui/text/style/TextOverflow$Companion;", "", "<init>", "()V", "Clip", "Landroidx/compose/ui/text/style/TextOverflow;", "getClip-gIe3tQ8$annotations", "getClip-gIe3tQ8", "()I", "I", "Ellipsis", "getEllipsis-gIe3tQ8$annotations", "getEllipsis-gIe3tQ8", "Visible", "getVisible-gIe3tQ8$annotations", "getVisible-gIe3tQ8", "StartEllipsis", "getStartEllipsis-gIe3tQ8$annotations", "getStartEllipsis-gIe3tQ8", "MiddleEllipsis", "getMiddleEllipsis-gIe3tQ8$annotations", "getMiddleEllipsis-gIe3tQ8", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getClip-gIe3tQ8() {
            return TextOverflow.Clip;
        }

        public static void getClip-gIe3tQ8$annotations() {
        }

        public final int getEllipsis-gIe3tQ8() {
            return TextOverflow.Ellipsis;
        }

        public static void getEllipsis-gIe3tQ8$annotations() {
        }

        public final int getMiddleEllipsis-gIe3tQ8() {
            return TextOverflow.MiddleEllipsis;
        }

        public static void getMiddleEllipsis-gIe3tQ8$annotations() {
        }

        public final int getStartEllipsis-gIe3tQ8() {
            return TextOverflow.StartEllipsis;
        }

        public static void getStartEllipsis-gIe3tQ8$annotations() {
        }

        public final int getVisible-gIe3tQ8() {
            return TextOverflow.Visible;
        }

        public static void getVisible-gIe3tQ8$annotations() {
        }
    }

    private static final int Clip;
    public static final Companion Companion;
    private static final int Ellipsis;
    private static final int MiddleEllipsis;
    private static final int StartEllipsis;
    private static final int Visible;
    private final int value;

    static {
        TextOverflow.Companion = new Companion(null);
        TextOverflow.Clip = TextOverflow.constructor-impl(1);
        TextOverflow.Ellipsis = TextOverflow.constructor-impl(2);
        TextOverflow.Visible = TextOverflow.constructor-impl(3);
        TextOverflow.StartEllipsis = TextOverflow.constructor-impl(4);
        TextOverflow.MiddleEllipsis = TextOverflow.constructor-impl(5);
    }

    private TextOverflow(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getClip$cp() {
        return TextOverflow.Clip;
    }

    public static final int access$getEllipsis$cp() {
        return TextOverflow.Ellipsis;
    }

    public static final int access$getMiddleEllipsis$cp() {
        return TextOverflow.MiddleEllipsis;
    }

    public static final int access$getStartEllipsis$cp() {
        return TextOverflow.StartEllipsis;
    }

    public static final int access$getVisible$cp() {
        return TextOverflow.Visible;
    }

    public static final TextOverflow box-impl(int arg1) {
        return new TextOverflow(arg1);
    }

    public static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return TextOverflow.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof TextOverflow)) {
            return 0;
        }

        if(arg2 != ((TextOverflow)arg3).unbox-impl()) {
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
        return TextOverflow.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return TextOverflow.toString-impl(this.value);
    }

    public static String toString-impl(int arg1) {
        if(TextOverflow.equals-impl0(arg1, TextOverflow.Clip)) {
            return "Clip";
        }

        if(TextOverflow.equals-impl0(arg1, TextOverflow.Ellipsis)) {
            return "Ellipsis";
        }

        if(TextOverflow.equals-impl0(arg1, TextOverflow.MiddleEllipsis)) {
            return "MiddleEllipsis";
        }

        if(TextOverflow.equals-impl0(arg1, TextOverflow.Visible)) {
            return "Visible";
        }

        if(TextOverflow.equals-impl0(arg1, TextOverflow.StartEllipsis)) {
            return "StartEllipsis";
        }

        return "Invalid";
    }

    public final int unbox-impl() {
        return this.value;
    }
}

