package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001A\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000EJ\u0010\u0010\u000F\u001A\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005R\u000E\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2={"Landroidx/compose/ui/text/EmojiSupportMatch;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class EmojiSupportMatch {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007¨\u0006\r"}, d2={"Landroidx/compose/ui/text/EmojiSupportMatch$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/text/EmojiSupportMatch;", "getDefault-_3YsG6Y", "()I", "I", "None", "getNone-_3YsG6Y", "All", "getAll-_3YsG6Y", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getAll-_3YsG6Y() {
            return EmojiSupportMatch.All;
        }

        public final int getDefault-_3YsG6Y() {
            return EmojiSupportMatch.Default;
        }

        public final int getNone-_3YsG6Y() {
            return EmojiSupportMatch.None;
        }
    }

    private static final int All;
    public static final Companion Companion;
    private static final int Default;
    private static final int None;
    private final int value;

    static {
        EmojiSupportMatch.Companion = new Companion(null);
        EmojiSupportMatch.Default = EmojiSupportMatch.constructor-impl(0);
        EmojiSupportMatch.None = EmojiSupportMatch.constructor-impl(1);
        EmojiSupportMatch.All = EmojiSupportMatch.constructor-impl(2);
    }

    private EmojiSupportMatch(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getAll$cp() {
        return EmojiSupportMatch.All;
    }

    public static final int access$getDefault$cp() {
        return EmojiSupportMatch.Default;
    }

    public static final int access$getNone$cp() {
        return EmojiSupportMatch.None;
    }

    public static final EmojiSupportMatch box-impl(int arg1) {
        return new EmojiSupportMatch(arg1);
    }

    public static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return EmojiSupportMatch.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof EmojiSupportMatch)) {
            return 0;
        }

        if(arg2 != ((EmojiSupportMatch)arg3).unbox-impl()) {
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
        return EmojiSupportMatch.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return EmojiSupportMatch.toString-impl(this.value);
    }

    public static String toString-impl(int arg2) {
        if(arg2 == EmojiSupportMatch.Default) {
            return "EmojiSupportMatch.Default";
        }

        if(arg2 == EmojiSupportMatch.None) {
            return "EmojiSupportMatch.None";
        }

        if(arg2 == EmojiSupportMatch.All) {
            return "EmojiSupportMatch.All";
        }

        return "Invalid(value=" + arg2 + ')';
    }

    public final int unbox-impl() {
        return this.value;
    }
}

