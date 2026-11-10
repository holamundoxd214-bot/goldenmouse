package androidx.compose.ui.text.style;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001C2\u00020\u0001:\u0004\u001C\u001D\u001E\u001FB\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\b\u0010\nJ+\u0010\u0012\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0018\u001A\u00020\u0019H\u0016J\b\u0010\u001A\u001A\u00020\u001BH\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u0010\u001A\u0004\b\u000E\u0010\u000FR\u0013\u0010\u0006\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010\u0010\u001A\u0004\b\u0011\u0010\u000F¨\u0006 "}, d2={"Landroidx/compose/ui/text/style/LineHeightStyle;", "", "alignment", "Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "trim", "Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "mode", "Landroidx/compose/ui/text/style/LineHeightStyle$Mode;", "<init>", "(FIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "(FILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignment-PIaL0Z0", "()F", "F", "getTrim-EVpEnUU", "()I", "I", "getMode-lzQqcRY", "copy", "copy-38bxuX8", "(FII)Landroidx/compose/ui/text/style/LineHeightStyle;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "Trim", "Alignment", "Mode", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LineHeightStyle {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 \u000F2\u00020\u0001:\u0001\u000FB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u000EHÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0010"}, d2={"Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "", "topRatio", "", "constructor-impl", "(F)F", "toString", "", "toString-impl", "(F)Ljava/lang/String;", "equals", "", "other", "hashCode", "", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class Alignment {
        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007¨\u0006\u000F"}, d2={"Landroidx/compose/ui/text/style/LineHeightStyle$Alignment$Companion;", "", "<init>", "()V", "Top", "Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "getTop-PIaL0Z0", "()F", "F", "Center", "getCenter-PIaL0Z0", "Proportional", "getProportional-PIaL0Z0", "Bottom", "getBottom-PIaL0Z0", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
            public Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private Companion() {
                super();
            }

            public final float getBottom-PIaL0Z0() {
                return Alignment.Bottom;
            }

            public final float getCenter-PIaL0Z0() {
                return Alignment.Center;
            }

            public final float getProportional-PIaL0Z0() {
                return Alignment.Proportional;
            }

            public final float getTop-PIaL0Z0() {
                return Alignment.Top;
            }
        }

        private static final float Bottom;
        private static final float Center;
        public static final Companion Companion;
        private static final float Proportional;
        private static final float Top;
        private final float topRatio;

        static {
            Alignment.Companion = new Companion(null);
            Alignment.Top = Alignment.constructor-impl(0f);
            Alignment.Center = Alignment.constructor-impl(0.5f);
            Alignment.Proportional = Alignment.constructor-impl(-1f);
            Alignment.Bottom = Alignment.constructor-impl(1f);
        }

        private Alignment(float arg1) {
            super();
            this.topRatio = arg1;
        }

        public static final float access$getBottom$cp() {
            return Alignment.Bottom;
        }

        public static final float access$getCenter$cp() {
            return Alignment.Center;
        }

        public static final float access$getProportional$cp() {
            return Alignment.Proportional;
        }

        public static final float access$getTop$cp() {
            return Alignment.Top;
        }

        public static final Alignment box-impl(float arg1) {
            return new Alignment(arg1);
        }

        public static float constructor-impl(float arg1) {
            int v0 = 0f <= arg1 && arg1 <= 1f || arg1 == -1f ? 1 : 0;
            if(v0 == 0) {
                InlineClassHelperKt.throwIllegalStateException("topRatio should be in [0..1] range or -1");
            }

            return arg1;
        }

        public boolean equals(Object arg1) {
            return Alignment.equals-impl(this.topRatio, arg1);
        }

        public static boolean equals-impl(float arg2, Object arg3) {
            if(!(arg3 instanceof Alignment)) {
                return 0;
            }

            if(Float.compare(arg2, ((Alignment)arg3).unbox-impl()) != 0) {
                return 0;
            }

            return 1;
        }

        public static final boolean equals-impl0(float arg0, float arg1) {
            if(Float.compare(arg0, arg1) == 0) {
                return 1;
            }

            return 0;
        }

        public int hashCode() {
            return Alignment.hashCode-impl(this.topRatio);
        }

        public static int hashCode-impl(float arg0) {
            return Float.hashCode(arg0);
        }

        public String toString() {
            return Alignment.toString-impl(this.topRatio);
        }

        public static String toString-impl(float arg2) {
            if(arg2 == Alignment.Top) {
                return "LineHeightStyle.Alignment.Top";
            }

            if(arg2 == Alignment.Center) {
                return "LineHeightStyle.Alignment.Center";
            }

            if(arg2 == Alignment.Proportional) {
                return "LineHeightStyle.Alignment.Proportional";
            }

            if(arg2 == Alignment.Bottom) {
                return "LineHeightStyle.Alignment.Bottom";
            }

            return "LineHeightStyle.Alignment(topPercentage = " + arg2 + ')';
        }

        public final float unbox-impl() {
            return this.topRatio;
        }
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/text/style/LineHeightStyle$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/text/style/LineHeightStyle;", "getDefault", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.compose.ui.text.style.LineHeightStyle$Companion {
        public androidx.compose.ui.text.style.LineHeightStyle$Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private androidx.compose.ui.text.style.LineHeightStyle$Companion() {
            super();
        }

        public final LineHeightStyle getDefault() {
            return LineHeightStyle.Default;
        }
    }

    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u0003HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000F"}, d2={"Landroidx/compose/ui/text/style/LineHeightStyle$Mode;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class Mode {
        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007¨\u0006\r"}, d2={"Landroidx/compose/ui/text/style/LineHeightStyle$Mode$Companion;", "", "<init>", "()V", "Fixed", "Landroidx/compose/ui/text/style/LineHeightStyle$Mode;", "getFixed-lzQqcRY", "()I", "I", "Minimum", "getMinimum-lzQqcRY", "Tight", "getTight-lzQqcRY", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.compose.ui.text.style.LineHeightStyle$Mode$Companion {
            public androidx.compose.ui.text.style.LineHeightStyle$Mode$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private androidx.compose.ui.text.style.LineHeightStyle$Mode$Companion() {
                super();
            }

            public final int getFixed-lzQqcRY() {
                return Mode.Fixed;
            }

            public final int getMinimum-lzQqcRY() {
                return Mode.Minimum;
            }

            public final int getTight-lzQqcRY() {
                return Mode.Tight;
            }
        }

        public static final androidx.compose.ui.text.style.LineHeightStyle$Mode$Companion Companion;
        private static final int Fixed;
        private static final int Minimum;
        private static final int Tight;
        private final int value;

        static {
            Mode.Companion = new androidx.compose.ui.text.style.LineHeightStyle$Mode$Companion(null);
            Mode.Fixed = Mode.constructor-impl(0);
            Mode.Minimum = Mode.constructor-impl(1);
            Mode.Tight = Mode.constructor-impl(2);
        }

        private Mode(int arg1) {
            super();
            this.value = arg1;
        }

        public static final int access$getFixed$cp() {
            return Mode.Fixed;
        }

        public static final int access$getMinimum$cp() {
            return Mode.Minimum;
        }

        public static final int access$getTight$cp() {
            return Mode.Tight;
        }

        public static final Mode box-impl(int arg1) {
            return new Mode(arg1);
        }

        public static int constructor-impl(int arg0) {
            return arg0;
        }

        public boolean equals(Object arg1) {
            return Mode.equals-impl(this.value, arg1);
        }

        public static boolean equals-impl(int arg2, Object arg3) {
            if(!(arg3 instanceof Mode)) {
                return 0;
            }

            if(arg2 != ((Mode)arg3).unbox-impl()) {
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
            return Mode.hashCode-impl(this.value);
        }

        public static int hashCode-impl(int arg0) {
            return Integer.hashCode(arg0);
        }

        public String toString() {
            return Mode.toString-impl(this.value);
        }

        public static String toString-impl(int arg1) {
            if(Mode.equals-impl0(arg1, Mode.Fixed)) {
                return "LineHeightStyle.Mode.Fixed";
            }

            if(Mode.equals-impl0(arg1, Mode.Minimum)) {
                return "LineHeightStyle.Mode.Minimum";
            }

            if(Mode.equals-impl0(arg1, Mode.Tight)) {
                return "LineHeightStyle.Mode.Tight";
            }

            return "Invalid";
        }

        public final int unbox-impl() {
            return this.value;
        }
    }

    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\n\u001A\u00020\u000BH\u0000¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u000BH\u0000¢\u0006\u0004\b\u000F\u0010\rJ\u0013\u0010\u0010\u001A\u00020\u000B2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0003HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0014"}, d2={"Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "isTrimFirstLineTop", "", "isTrimFirstLineTop-impl$ui_text", "(I)Z", "isTrimLastLineBottom", "isTrimLastLineBottom-impl$ui_text", "equals", "other", "hashCode", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class Trim {
        @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001A\u00020\b¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\t\u0010\nR\u0013\u0010\f\u001A\u00020\b¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\r\u0010\nR\u0013\u0010\u000E\u001A\u00020\b¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\u000F\u0010\nR\u0013\u0010\u0010\u001A\u00020\b¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\u0011\u0010\n¨\u0006\u0012"}, d2={"Landroidx/compose/ui/text/style/LineHeightStyle$Trim$Companion;", "", "<init>", "()V", "FlagTrimTop", "", "FlagTrimBottom", "FirstLineTop", "Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "getFirstLineTop-EVpEnUU", "()I", "I", "LastLineBottom", "getLastLineBottom-EVpEnUU", "Both", "getBoth-EVpEnUU", "None", "getNone-EVpEnUU", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.compose.ui.text.style.LineHeightStyle$Trim$Companion {
            public androidx.compose.ui.text.style.LineHeightStyle$Trim$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private androidx.compose.ui.text.style.LineHeightStyle$Trim$Companion() {
                super();
            }

            public final int getBoth-EVpEnUU() {
                return Trim.Both;
            }

            public final int getFirstLineTop-EVpEnUU() {
                return Trim.FirstLineTop;
            }

            public final int getLastLineBottom-EVpEnUU() {
                return Trim.LastLineBottom;
            }

            public final int getNone-EVpEnUU() {
                return Trim.None;
            }
        }

        private static final int Both = 0;
        public static final androidx.compose.ui.text.style.LineHeightStyle$Trim$Companion Companion = null;
        private static final int FirstLineTop = 0;
        private static final int FlagTrimBottom = 16;
        private static final int FlagTrimTop = 1;
        private static final int LastLineBottom;
        private static final int None;
        private final int value;

        static {
            Trim.Companion = new androidx.compose.ui.text.style.LineHeightStyle$Trim$Companion(null);
            Trim.FirstLineTop = Trim.constructor-impl(1);
            Trim.LastLineBottom = Trim.constructor-impl(16);
            Trim.Both = Trim.constructor-impl(17);
            Trim.None = Trim.constructor-impl(0);
        }

        private Trim(int arg1) {
            super();
            this.value = arg1;
        }

        public static final int access$getBoth$cp() {
            return Trim.Both;
        }

        public static final int access$getFirstLineTop$cp() {
            return Trim.FirstLineTop;
        }

        public static final int access$getLastLineBottom$cp() {
            return Trim.LastLineBottom;
        }

        public static final int access$getNone$cp() {
            return Trim.None;
        }

        public static final Trim box-impl(int arg1) {
            return new Trim(arg1);
        }

        public static int constructor-impl(int arg0) {
            return arg0;
        }

        public boolean equals(Object arg1) {
            return Trim.equals-impl(this.value, arg1);
        }

        public static boolean equals-impl(int arg2, Object arg3) {
            if(!(arg3 instanceof Trim)) {
                return 0;
            }

            if(arg2 != ((Trim)arg3).unbox-impl()) {
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
            return Trim.hashCode-impl(this.value);
        }

        public static int hashCode-impl(int arg0) {
            return Integer.hashCode(arg0);
        }

        public static final boolean isTrimFirstLineTop-impl$ui_text(int arg1) {
            if((arg1 & 1) > 0) {
                return 1;
            }

            return 0;
        }

        public static final boolean isTrimLastLineBottom-impl$ui_text(int arg0) {
            if((arg0 & 16) > 0) {
                return 1;
            }

            return 0;
        }

        public String toString() {
            return Trim.toString-impl(this.value);
        }

        public static String toString-impl(int arg1) {
            if(arg1 == Trim.FirstLineTop) {
                return "LineHeightStyle.Trim.FirstLineTop";
            }

            if(arg1 == Trim.LastLineBottom) {
                return "LineHeightStyle.Trim.LastLineBottom";
            }

            if(arg1 == Trim.Both) {
                return "LineHeightStyle.Trim.Both";
            }

            if(arg1 == Trim.None) {
                return "LineHeightStyle.Trim.None";
            }

            return "Invalid";
        }

        public final int unbox-impl() {
            return this.value;
        }
    }

    public static final int $stable;
    public static final androidx.compose.ui.text.style.LineHeightStyle$Companion Companion;
    private static final LineHeightStyle Default;
    private final float alignment;
    private final int mode;
    private final int trim;

    static {
        LineHeightStyle.Companion = new androidx.compose.ui.text.style.LineHeightStyle$Companion(null);
        LineHeightStyle.Default = new LineHeightStyle(Alignment.Companion.getProportional-PIaL0Z0(), Trim.Companion.getBoth-EVpEnUU(), Mode.Companion.getFixed-lzQqcRY(), null);
    }

    public LineHeightStyle(float arg1, int arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    public LineHeightStyle(float arg1, int arg2, int arg3, DefaultConstructorMarker arg4) {
        this(arg1, arg2, arg3);
    }

    private LineHeightStyle(float arg3, int arg4) {
        this(arg3, arg4, Mode.Companion.getFixed-lzQqcRY(), null);
    }

    private LineHeightStyle(float arg1, int arg2, int arg3) {
        super();
        this.alignment = arg1;
        this.trim = arg2;
        this.mode = arg3;
    }

    public static final LineHeightStyle access$getDefault$cp() {
        return LineHeightStyle.Default;
    }

    public final LineHeightStyle copy-38bxuX8(float arg2, int arg3, int arg4) {
        return new LineHeightStyle(arg2, arg3, arg4, null);
    }

    public static LineHeightStyle copy-38bxuX8$default(LineHeightStyle arg0, float arg1, int arg2, int arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.alignment;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.trim;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.mode;
        }

        return arg0.copy-38bxuX8(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((LineHeightStyle)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof LineHeightStyle)) {
            return 0;
        }

        if(!Alignment.equals-impl0(this.alignment, ((LineHeightStyle)arg5).alignment)) {
            return 0;
        }

        if(!Trim.equals-impl0(this.trim, ((LineHeightStyle)arg5).trim)) {
            return 0;
        }

        if(!Mode.equals-impl0(this.mode, ((LineHeightStyle)arg5).mode)) {
            return 0;
        }

        return 1;
    }

    public final float getAlignment-PIaL0Z0() {
        return this.alignment;
    }

    public final int getMode-lzQqcRY() {
        return this.mode;
    }

    public final int getTrim-EVpEnUU() {
        return this.trim;
    }

    public int hashCode() {
        return (Alignment.hashCode-impl(this.alignment) * 0x1F + Trim.hashCode-impl(this.trim)) * 0x1F + Mode.hashCode-impl(this.mode);
    }

    public String toString() {
        return "LineHeightStyle(alignment=" + Alignment.toString-impl(this.alignment) + ", trim=" + Trim.toString-impl(this.trim) + ",mode=" + Mode.toString-impl(this.mode) + ')';
    }
}

