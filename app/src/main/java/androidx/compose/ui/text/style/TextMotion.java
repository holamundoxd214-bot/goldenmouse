package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\r\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005H\u0000¢\u0006\u0004\b\u000E\u0010\u000FJ\u0013\u0010\u0010\u001A\u00020\u00052\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001A\u00020\u0013H\u0016J\b\u0010\u0014\u001A\u00020\u0015H\u0016R\u0016\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u0018"}, d2={"Landroidx/compose/ui/text/style/TextMotion;", "", "linearity", "Landroidx/compose/ui/text/style/TextMotion$Linearity;", "subpixelTextPositioning", "", "<init>", "(IZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLinearity-4e0Vf04$ui_text", "()I", "I", "getSubpixelTextPositioning$ui_text", "()Z", "copy", "copy-JdDtMQo$ui_text", "(IZ)Landroidx/compose/ui/text/style/TextMotion;", "equals", "other", "hashCode", "", "toString", "", "Companion", "Linearity", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextMotion {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007¨\u0006\n"}, d2={"Landroidx/compose/ui/text/style/TextMotion$Companion;", "", "<init>", "()V", "Static", "Landroidx/compose/ui/text/style/TextMotion;", "getStatic", "()Landroidx/compose/ui/text/style/TextMotion;", "Animated", "getAnimated", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final TextMotion getAnimated() {
            return TextMotion.Animated;
        }

        public final TextMotion getStatic() {
            return TextMotion.Static;
        }
    }

    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0081@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001A\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000EJ\u0010\u0010\u000F\u001A\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005R\u000E\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2={"Landroidx/compose/ui/text/style/TextMotion$Linearity;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class Linearity {
        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007¨\u0006\r"}, d2={"Landroidx/compose/ui/text/style/TextMotion$Linearity$Companion;", "", "<init>", "()V", "Linear", "Landroidx/compose/ui/text/style/TextMotion$Linearity;", "getLinear-4e0Vf04", "()I", "I", "FontHinting", "getFontHinting-4e0Vf04", "None", "getNone-4e0Vf04", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.compose.ui.text.style.TextMotion$Linearity$Companion {
            public androidx.compose.ui.text.style.TextMotion$Linearity$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private androidx.compose.ui.text.style.TextMotion$Linearity$Companion() {
                super();
            }

            public final int getFontHinting-4e0Vf04() {
                return Linearity.FontHinting;
            }

            public final int getLinear-4e0Vf04() {
                return Linearity.Linear;
            }

            public final int getNone-4e0Vf04() {
                return Linearity.None;
            }
        }

        public static final androidx.compose.ui.text.style.TextMotion$Linearity$Companion Companion;
        private static final int FontHinting;
        private static final int Linear;
        private static final int None;
        private final int value;

        static {
            Linearity.Companion = new androidx.compose.ui.text.style.TextMotion$Linearity$Companion(null);
            Linearity.Linear = Linearity.constructor-impl(1);
            Linearity.FontHinting = Linearity.constructor-impl(2);
            Linearity.None = Linearity.constructor-impl(3);
        }

        private Linearity(int arg1) {
            super();
            this.value = arg1;
        }

        public static final int access$getFontHinting$cp() {
            return Linearity.FontHinting;
        }

        public static final int access$getLinear$cp() {
            return Linearity.Linear;
        }

        public static final int access$getNone$cp() {
            return Linearity.None;
        }

        public static final Linearity box-impl(int arg1) {
            return new Linearity(arg1);
        }

        public static int constructor-impl(int arg0) {
            return arg0;
        }

        public boolean equals(Object arg1) {
            return Linearity.equals-impl(this.value, arg1);
        }

        public static boolean equals-impl(int arg2, Object arg3) {
            if(!(arg3 instanceof Linearity)) {
                return 0;
            }

            if(arg2 != ((Linearity)arg3).unbox-impl()) {
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
            return Linearity.hashCode-impl(this.value);
        }

        public static int hashCode-impl(int arg0) {
            return Integer.hashCode(arg0);
        }

        public String toString() {
            return Linearity.toString-impl(this.value);
        }

        public static String toString-impl(int arg1) {
            if(Linearity.equals-impl0(arg1, Linearity.Linear)) {
                return "Linearity.Linear";
            }

            if(Linearity.equals-impl0(arg1, Linearity.FontHinting)) {
                return "Linearity.FontHinting";
            }

            if(Linearity.equals-impl0(arg1, Linearity.None)) {
                return "Linearity.None";
            }

            return "Invalid";
        }

        public final int unbox-impl() {
            return this.value;
        }
    }

    public static final int $stable;
    private static final TextMotion Animated;
    public static final Companion Companion;
    private static final TextMotion Static;
    private final int linearity;
    private final boolean subpixelTextPositioning;

    static {
        TextMotion.Companion = new Companion(null);
        TextMotion.Static = new TextMotion(Linearity.Companion.getFontHinting-4e0Vf04(), false, null);
        TextMotion.Animated = new TextMotion(Linearity.Companion.getLinear-4e0Vf04(), true, null);
    }

    public TextMotion(int arg1, boolean arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    private TextMotion(int arg1, boolean arg2) {
        super();
        this.linearity = arg1;
        this.subpixelTextPositioning = arg2;
    }

    public static final TextMotion access$getAnimated$cp() {
        return TextMotion.Animated;
    }

    public static final TextMotion access$getStatic$cp() {
        return TextMotion.Static;
    }

    public final TextMotion copy-JdDtMQo$ui_text(int arg2, boolean arg3) {
        return new TextMotion(arg2, arg3, null);
    }

    public static TextMotion copy-JdDtMQo$ui_text$default(TextMotion arg0, int arg1, boolean arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.linearity;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.subpixelTextPositioning;
        }

        return arg0.copy-JdDtMQo$ui_text(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((TextMotion)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof TextMotion)) {
            return 0;
        }

        if(!Linearity.equals-impl0(this.linearity, ((TextMotion)arg5).linearity)) {
            return 0;
        }

        if(this.subpixelTextPositioning != ((TextMotion)arg5).subpixelTextPositioning) {
            return 0;
        }

        return 1;
    }

    public final int getLinearity-4e0Vf04$ui_text() {
        return this.linearity;
    }

    public final boolean getSubpixelTextPositioning$ui_text() {
        return this.subpixelTextPositioning;
    }

    public int hashCode() {
        return Linearity.hashCode-impl(this.linearity) * 0x1F + Boolean.hashCode(this.subpixelTextPositioning);
    }

    public String toString() {
        if(Intrinsics.areEqual(this, TextMotion.Static)) {
            return "TextMotion.Static";
        }

        if(Intrinsics.areEqual(this, TextMotion.Animated)) {
            return "TextMotion.Animated";
        }

        return "Invalid";
    }
}

