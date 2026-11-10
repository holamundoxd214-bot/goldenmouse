package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\n\b\u0087@\u0018\u0000 \u001E2\u00020\u0001:\u0004\u001E\u001F !B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B!\b\u0016\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\u0004\u0010\fJ+\u0010\u0010\u001A\u00020\u00002\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001A\u0010\u0017\u001A\u00020\u00182\b\u0010\u0019\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001A\u0010\u001BJ\u0010\u0010\u001C\u001A\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001D\u0010\u0005R\u000E\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\r\u0010\u0005R\u0011\u0010\b\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u0005R\u0011\u0010\n\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\""}, d2={"Landroidx/compose/ui/text/style/LineBreak;", "", "mask", "", "constructor-impl", "(I)I", "strategy", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "strictness", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "wordBreak", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "(III)I", "getStrategy-fcGXIks", "getStrictness-usljTpc", "getWordBreak-jp8hJ3c", "copy", "copy-gijOMQM", "(IIII)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "Companion", "Strategy", "Strictness", "WordBreak", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class LineBreak {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\bR\u001E\u0010\n\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000B\u0010\u0003\u001A\u0004\b\f\u0010\bR\u001E\u0010\r\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000E\u0010\u0003\u001A\u0004\b\u000F\u0010\bR\u001E\u0010\u0010\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0011\u0010\u0003\u001A\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2={"Landroidx/compose/ui/text/style/LineBreak$Companion;", "", "<init>", "()V", "Simple", "Landroidx/compose/ui/text/style/LineBreak;", "getSimple-rAG3T2k$annotations", "getSimple-rAG3T2k", "()I", "I", "Heading", "getHeading-rAG3T2k$annotations", "getHeading-rAG3T2k", "Paragraph", "getParagraph-rAG3T2k$annotations", "getParagraph-rAG3T2k", "Unspecified", "getUnspecified-rAG3T2k$annotations", "getUnspecified-rAG3T2k", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getHeading-rAG3T2k() {
            return LineBreak.Heading;
        }

        public static void getHeading-rAG3T2k$annotations() {
        }

        public final int getParagraph-rAG3T2k() {
            return LineBreak.Paragraph;
        }

        public static void getParagraph-rAG3T2k$annotations() {
        }

        public final int getSimple-rAG3T2k() {
            return LineBreak.Simple;
        }

        public static void getSimple-rAG3T2k$annotations() {
        }

        public final int getUnspecified-rAG3T2k() {
            return LineBreak.Unspecified;
        }

        public static void getUnspecified-rAG3T2k$annotations() {
        }
    }

    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001A\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000EJ\u0010\u0010\u000F\u001A\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005R\u000E\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2={"Landroidx/compose/ui/text/style/LineBreak$Strategy;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class Strategy {
        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007¨\u0006\u000F"}, d2={"Landroidx/compose/ui/text/style/LineBreak$Strategy$Companion;", "", "<init>", "()V", "Simple", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "getSimple-fcGXIks", "()I", "I", "HighQuality", "getHighQuality-fcGXIks", "Balanced", "getBalanced-fcGXIks", "Unspecified", "getUnspecified-fcGXIks", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.compose.ui.text.style.LineBreak$Strategy$Companion {
            public androidx.compose.ui.text.style.LineBreak$Strategy$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private androidx.compose.ui.text.style.LineBreak$Strategy$Companion() {
                super();
            }

            public final int getBalanced-fcGXIks() {
                return Strategy.Balanced;
            }

            public final int getHighQuality-fcGXIks() {
                return Strategy.HighQuality;
            }

            public final int getSimple-fcGXIks() {
                return Strategy.Simple;
            }

            public final int getUnspecified-fcGXIks() {
                return Strategy.Unspecified;
            }
        }

        private static final int Balanced;
        public static final androidx.compose.ui.text.style.LineBreak$Strategy$Companion Companion;
        private static final int HighQuality;
        private static final int Simple;
        private static final int Unspecified;
        private final int value;

        static {
            Strategy.Companion = new androidx.compose.ui.text.style.LineBreak$Strategy$Companion(null);
            Strategy.Simple = Strategy.constructor-impl(1);
            Strategy.HighQuality = Strategy.constructor-impl(2);
            Strategy.Balanced = Strategy.constructor-impl(3);
            Strategy.Unspecified = Strategy.constructor-impl(0);
        }

        private Strategy(int arg1) {
            super();
            this.value = arg1;
        }

        public static final int access$getBalanced$cp() {
            return Strategy.Balanced;
        }

        public static final int access$getHighQuality$cp() {
            return Strategy.HighQuality;
        }

        public static final int access$getSimple$cp() {
            return Strategy.Simple;
        }

        public static final int access$getUnspecified$cp() {
            return Strategy.Unspecified;
        }

        public static final Strategy box-impl(int arg1) {
            return new Strategy(arg1);
        }

        public static int constructor-impl(int arg0) {
            return arg0;
        }

        public boolean equals(Object arg1) {
            return Strategy.equals-impl(this.value, arg1);
        }

        public static boolean equals-impl(int arg2, Object arg3) {
            if(!(arg3 instanceof Strategy)) {
                return 0;
            }

            if(arg2 != ((Strategy)arg3).unbox-impl()) {
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
            return Strategy.hashCode-impl(this.value);
        }

        public static int hashCode-impl(int arg0) {
            return Integer.hashCode(arg0);
        }

        public String toString() {
            return Strategy.toString-impl(this.value);
        }

        public static String toString-impl(int arg1) {
            if(Strategy.equals-impl0(arg1, Strategy.Simple)) {
                return "Strategy.Simple";
            }

            if(Strategy.equals-impl0(arg1, Strategy.HighQuality)) {
                return "Strategy.HighQuality";
            }

            if(Strategy.equals-impl0(arg1, Strategy.Balanced)) {
                return "Strategy.Balanced";
            }

            if(Strategy.equals-impl0(arg1, Strategy.Unspecified)) {
                return "Strategy.Unspecified";
            }

            return "Invalid";
        }

        public final int unbox-impl() {
            return this.value;
        }
    }

    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001A\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000EJ\u0010\u0010\u000F\u001A\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005R\u000E\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2={"Landroidx/compose/ui/text/style/LineBreak$Strictness;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class Strictness {
        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007R\u0013\u0010\u000F\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2={"Landroidx/compose/ui/text/style/LineBreak$Strictness$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "getDefault-usljTpc", "()I", "I", "Loose", "getLoose-usljTpc", "Normal", "getNormal-usljTpc", "Strict", "getStrict-usljTpc", "Unspecified", "getUnspecified-usljTpc", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.compose.ui.text.style.LineBreak$Strictness$Companion {
            public androidx.compose.ui.text.style.LineBreak$Strictness$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private androidx.compose.ui.text.style.LineBreak$Strictness$Companion() {
                super();
            }

            public final int getDefault-usljTpc() {
                return Strictness.Default;
            }

            public final int getLoose-usljTpc() {
                return Strictness.Loose;
            }

            public final int getNormal-usljTpc() {
                return Strictness.Normal;
            }

            public final int getStrict-usljTpc() {
                return Strictness.Strict;
            }

            public final int getUnspecified-usljTpc() {
                return Strictness.Unspecified;
            }
        }

        public static final androidx.compose.ui.text.style.LineBreak$Strictness$Companion Companion;
        private static final int Default;
        private static final int Loose;
        private static final int Normal;
        private static final int Strict;
        private static final int Unspecified;
        private final int value;

        static {
            Strictness.Companion = new androidx.compose.ui.text.style.LineBreak$Strictness$Companion(null);
            Strictness.Default = Strictness.constructor-impl(1);
            Strictness.Loose = Strictness.constructor-impl(2);
            Strictness.Normal = Strictness.constructor-impl(3);
            Strictness.Strict = Strictness.constructor-impl(4);
            Strictness.Unspecified = Strictness.constructor-impl(0);
        }

        private Strictness(int arg1) {
            super();
            this.value = arg1;
        }

        public static final int access$getDefault$cp() {
            return Strictness.Default;
        }

        public static final int access$getLoose$cp() {
            return Strictness.Loose;
        }

        public static final int access$getNormal$cp() {
            return Strictness.Normal;
        }

        public static final int access$getStrict$cp() {
            return Strictness.Strict;
        }

        public static final int access$getUnspecified$cp() {
            return Strictness.Unspecified;
        }

        public static final Strictness box-impl(int arg1) {
            return new Strictness(arg1);
        }

        public static int constructor-impl(int arg0) {
            return arg0;
        }

        public boolean equals(Object arg1) {
            return Strictness.equals-impl(this.value, arg1);
        }

        public static boolean equals-impl(int arg2, Object arg3) {
            if(!(arg3 instanceof Strictness)) {
                return 0;
            }

            if(arg2 != ((Strictness)arg3).unbox-impl()) {
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
            return Strictness.hashCode-impl(this.value);
        }

        public static int hashCode-impl(int arg0) {
            return Integer.hashCode(arg0);
        }

        public String toString() {
            return Strictness.toString-impl(this.value);
        }

        public static String toString-impl(int arg1) {
            if(Strictness.equals-impl0(arg1, Strictness.Default)) {
                return "Strictness.None";
            }

            if(Strictness.equals-impl0(arg1, Strictness.Loose)) {
                return "Strictness.Loose";
            }

            if(Strictness.equals-impl0(arg1, Strictness.Normal)) {
                return "Strictness.Normal";
            }

            if(Strictness.equals-impl0(arg1, Strictness.Strict)) {
                return "Strictness.Strict";
            }

            if(Strictness.equals-impl0(arg1, Strictness.Unspecified)) {
                return "Strictness.Unspecified";
            }

            return "Invalid";
        }

        public final int unbox-impl() {
            return this.value;
        }
    }

    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001A\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000EJ\u0010\u0010\u000F\u001A\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005R\u000E\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2={"Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class WordBreak {
        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007¨\u0006\r"}, d2={"Landroidx/compose/ui/text/style/LineBreak$WordBreak$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "getDefault-jp8hJ3c", "()I", "I", "Phrase", "getPhrase-jp8hJ3c", "Unspecified", "getUnspecified-jp8hJ3c", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.compose.ui.text.style.LineBreak$WordBreak$Companion {
            public androidx.compose.ui.text.style.LineBreak$WordBreak$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private androidx.compose.ui.text.style.LineBreak$WordBreak$Companion() {
                super();
            }

            public final int getDefault-jp8hJ3c() {
                return WordBreak.Default;
            }

            public final int getPhrase-jp8hJ3c() {
                return WordBreak.Phrase;
            }

            public final int getUnspecified-jp8hJ3c() {
                return WordBreak.Unspecified;
            }
        }

        public static final androidx.compose.ui.text.style.LineBreak$WordBreak$Companion Companion;
        private static final int Default;
        private static final int Phrase;
        private static final int Unspecified;
        private final int value;

        static {
            WordBreak.Companion = new androidx.compose.ui.text.style.LineBreak$WordBreak$Companion(null);
            WordBreak.Default = WordBreak.constructor-impl(1);
            WordBreak.Phrase = WordBreak.constructor-impl(2);
            WordBreak.Unspecified = WordBreak.constructor-impl(0);
        }

        private WordBreak(int arg1) {
            super();
            this.value = arg1;
        }

        public static final int access$getDefault$cp() {
            return WordBreak.Default;
        }

        public static final int access$getPhrase$cp() {
            return WordBreak.Phrase;
        }

        public static final int access$getUnspecified$cp() {
            return WordBreak.Unspecified;
        }

        public static final WordBreak box-impl(int arg1) {
            return new WordBreak(arg1);
        }

        public static int constructor-impl(int arg0) {
            return arg0;
        }

        public boolean equals(Object arg1) {
            return WordBreak.equals-impl(this.value, arg1);
        }

        public static boolean equals-impl(int arg2, Object arg3) {
            if(!(arg3 instanceof WordBreak)) {
                return 0;
            }

            if(arg2 != ((WordBreak)arg3).unbox-impl()) {
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
            return WordBreak.hashCode-impl(this.value);
        }

        public static int hashCode-impl(int arg0) {
            return Integer.hashCode(arg0);
        }

        public String toString() {
            return WordBreak.toString-impl(this.value);
        }

        public static String toString-impl(int arg1) {
            if(WordBreak.equals-impl0(arg1, WordBreak.Default)) {
                return "WordBreak.None";
            }

            if(WordBreak.equals-impl0(arg1, WordBreak.Phrase)) {
                return "WordBreak.Phrase";
            }

            if(WordBreak.equals-impl0(arg1, WordBreak.Unspecified)) {
                return "WordBreak.Unspecified";
            }

            return "Invalid";
        }

        public final int unbox-impl() {
            return this.value;
        }
    }

    public static final Companion Companion;
    private static final int Heading;
    private static final int Paragraph;
    private static final int Simple;
    private static final int Unspecified;
    private final int mask;

    static {
        LineBreak.Companion = new Companion(null);
        LineBreak.Simple = LineBreak.constructor-impl(LineBreak_androidKt.access$packBytes(Strategy.Companion.getSimple-fcGXIks(), Strictness.Companion.getNormal-usljTpc(), WordBreak.Companion.getDefault-jp8hJ3c()));
        LineBreak.Heading = LineBreak.constructor-impl(LineBreak_androidKt.access$packBytes(Strategy.Companion.getBalanced-fcGXIks(), Strictness.Companion.getLoose-usljTpc(), WordBreak.Companion.getPhrase-jp8hJ3c()));
        LineBreak.Paragraph = LineBreak.constructor-impl(LineBreak_androidKt.access$packBytes(Strategy.Companion.getHighQuality-fcGXIks(), Strictness.Companion.getStrict-usljTpc(), WordBreak.Companion.getDefault-jp8hJ3c()));
        LineBreak.Unspecified = LineBreak.constructor-impl(0);
    }

    private LineBreak(int arg1) {
        super();
        this.mask = arg1;
    }

    public static final int access$getHeading$cp() {
        return LineBreak.Heading;
    }

    public static final int access$getParagraph$cp() {
        return LineBreak.Paragraph;
    }

    public static final int access$getSimple$cp() {
        return LineBreak.Simple;
    }

    public static final int access$getUnspecified$cp() {
        return LineBreak.Unspecified;
    }

    public static final LineBreak box-impl(int arg1) {
        return new LineBreak(arg1);
    }

    public static int constructor-impl(int arg0) {
        return arg0;
    }

    public static int constructor-impl(int arg0, int arg1, int arg2) {
        return LineBreak.constructor-impl(LineBreak_androidKt.access$packBytes(arg0, arg1, arg2));
    }

    public static final int copy-gijOMQM(int arg0, int arg1, int arg2, int arg3) {
        return LineBreak.constructor-impl(arg1, arg2, arg3);
    }

    public static int copy-gijOMQM$default(int arg0, int arg1, int arg2, int arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = LineBreak.getStrategy-fcGXIks(arg0);
        }

        if((arg4 & 2) != 0) {
            arg2 = LineBreak.getStrictness-usljTpc(arg0);
        }

        if((arg4 & 4) != 0) {
            arg3 = LineBreak.getWordBreak-jp8hJ3c(arg0);
        }

        return LineBreak.copy-gijOMQM(arg0, arg1, arg2, arg3);
    }

    public boolean equals(Object arg1) {
        return LineBreak.equals-impl(this.mask, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof LineBreak)) {
            return 0;
        }

        if(arg2 != ((LineBreak)arg3).unbox-impl()) {
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

    public static final int getStrategy-fcGXIks(int arg0) {
        return Strategy.constructor-impl(LineBreak_androidKt.access$unpackByte1(arg0));
    }

    public static final int getStrictness-usljTpc(int arg0) {
        return Strictness.constructor-impl(LineBreak_androidKt.access$unpackByte2(arg0));
    }

    public static final int getWordBreak-jp8hJ3c(int arg0) {
        return WordBreak.constructor-impl(LineBreak_androidKt.access$unpackByte3(arg0));
    }

    public int hashCode() {
        return LineBreak.hashCode-impl(this.mask);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return LineBreak.toString-impl(this.mask);
    }

    public static String toString-impl(int arg2) {
        return "LineBreak(strategy=" + Strategy.toString-impl(LineBreak.getStrategy-fcGXIks(arg2)) + ", strictness=" + Strictness.toString-impl(LineBreak.getStrictness-usljTpc(arg2)) + ", wordBreak=" + WordBreak.toString-impl(LineBreak.getWordBreak-jp8hJ3c(arg2)) + ')';
    }

    public final int unbox-impl() {
        return this.mask;
    }
}

