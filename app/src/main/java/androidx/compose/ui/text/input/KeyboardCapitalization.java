package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u0003HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000F"}, d2={"Landroidx/compose/ui/text/input/KeyboardCapitalization;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class KeyboardCapitalization {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\bR\u001E\u0010\n\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000B\u0010\u0003\u001A\u0004\b\f\u0010\bR\u001E\u0010\r\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000E\u0010\u0003\u001A\u0004\b\u000F\u0010\bR\u001E\u0010\u0010\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0011\u0010\u0003\u001A\u0004\b\u0012\u0010\bR\u001E\u0010\u0013\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0014\u0010\u0003\u001A\u0004\b\u0015\u0010\b¨\u0006\u0016"}, d2={"Landroidx/compose/ui/text/input/KeyboardCapitalization$Companion;", "", "<init>", "()V", "Unspecified", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "getUnspecified-IUNYP9k$annotations", "getUnspecified-IUNYP9k", "()I", "I", "None", "getNone-IUNYP9k$annotations", "getNone-IUNYP9k", "Characters", "getCharacters-IUNYP9k$annotations", "getCharacters-IUNYP9k", "Words", "getWords-IUNYP9k$annotations", "getWords-IUNYP9k", "Sentences", "getSentences-IUNYP9k$annotations", "getSentences-IUNYP9k", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getCharacters-IUNYP9k() {
            return KeyboardCapitalization.Characters;
        }

        public static void getCharacters-IUNYP9k$annotations() {
        }

        public final int getNone-IUNYP9k() {
            return KeyboardCapitalization.None;
        }

        public static void getNone-IUNYP9k$annotations() {
        }

        public final int getSentences-IUNYP9k() {
            return KeyboardCapitalization.Sentences;
        }

        public static void getSentences-IUNYP9k$annotations() {
        }

        public final int getUnspecified-IUNYP9k() {
            return KeyboardCapitalization.Unspecified;
        }

        public static void getUnspecified-IUNYP9k$annotations() {
        }

        public final int getWords-IUNYP9k() {
            return KeyboardCapitalization.Words;
        }

        public static void getWords-IUNYP9k$annotations() {
        }
    }

    private static final int Characters;
    public static final Companion Companion;
    private static final int None;
    private static final int Sentences;
    private static final int Unspecified;
    private static final int Words;
    private final int value;

    static {
        KeyboardCapitalization.Companion = new Companion(null);
        KeyboardCapitalization.Unspecified = KeyboardCapitalization.constructor-impl(-1);
        KeyboardCapitalization.None = KeyboardCapitalization.constructor-impl(0);
        KeyboardCapitalization.Characters = KeyboardCapitalization.constructor-impl(1);
        KeyboardCapitalization.Words = KeyboardCapitalization.constructor-impl(2);
        KeyboardCapitalization.Sentences = KeyboardCapitalization.constructor-impl(3);
    }

    private KeyboardCapitalization(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getCharacters$cp() {
        return KeyboardCapitalization.Characters;
    }

    public static final int access$getNone$cp() {
        return KeyboardCapitalization.None;
    }

    public static final int access$getSentences$cp() {
        return KeyboardCapitalization.Sentences;
    }

    public static final int access$getUnspecified$cp() {
        return KeyboardCapitalization.Unspecified;
    }

    public static final int access$getWords$cp() {
        return KeyboardCapitalization.Words;
    }

    public static final KeyboardCapitalization box-impl(int arg1) {
        return new KeyboardCapitalization(arg1);
    }

    private static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return KeyboardCapitalization.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof KeyboardCapitalization)) {
            return 0;
        }

        if(arg2 != ((KeyboardCapitalization)arg3).unbox-impl()) {
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
        return KeyboardCapitalization.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return KeyboardCapitalization.toString-impl(this.value);
    }

    public static String toString-impl(int arg1) {
        if(KeyboardCapitalization.equals-impl0(arg1, KeyboardCapitalization.Unspecified)) {
            return "Unspecified";
        }

        if(KeyboardCapitalization.equals-impl0(arg1, KeyboardCapitalization.None)) {
            return "None";
        }

        if(KeyboardCapitalization.equals-impl0(arg1, KeyboardCapitalization.Characters)) {
            return "Characters";
        }

        if(KeyboardCapitalization.equals-impl0(arg1, KeyboardCapitalization.Words)) {
            return "Words";
        }

        if(KeyboardCapitalization.equals-impl0(arg1, KeyboardCapitalization.Sentences)) {
            return "Sentences";
        }

        return "Invalid";
    }

    public final int unbox-impl() {
        return this.value;
    }
}

