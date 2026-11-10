package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0013\b\u0016\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001D\b\u0016\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\bB\u0013\b\u0016\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\u0004\u0010\tB\t\b\u0016¢\u0006\u0004\b\u0004\u0010\nJ\u0013\u0010\u0011\u001A\u00020\u00032\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001A\u00020\u0014H\u0016J\b\u0010\u0015\u001A\u00020\u0016H\u0016J\u0010\u0010\u0017\u001A\u00020\u00002\b\u0010\u0012\u001A\u0004\u0018\u00010\u0000R\u0017\u0010\u0002\u001A\u00020\u0003¢\u0006\u000E\n\u0000\u0012\u0004\b\u000B\u0010\n\u001A\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010\u0010\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0019"}, d2={"Landroidx/compose/ui/text/PlatformParagraphStyle;", "", "includeFontPadding", "", "<init>", "(Z)V", "emojiSupportMatch", "Landroidx/compose/ui/text/EmojiSupportMatch;", "(IZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "()V", "getIncludeFontPadding$annotations", "getIncludeFontPadding", "()Z", "getEmojiSupportMatch-_3YsG6Y", "()I", "I", "equals", "other", "hashCode", "", "toString", "", "merge", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PlatformParagraphStyle {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/text/PlatformParagraphStyle$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "getDefault", "()Landroidx/compose/ui/text/PlatformParagraphStyle;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final PlatformParagraphStyle getDefault() {
            return PlatformParagraphStyle.Default;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final PlatformParagraphStyle Default;
    private final int emojiSupportMatch;
    private final boolean includeFontPadding;

    static {
        PlatformParagraphStyle.Companion = new Companion(null);
        PlatformParagraphStyle.Default = new PlatformParagraphStyle();
    }

    public PlatformParagraphStyle(int arg1, boolean arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    public PlatformParagraphStyle() {
        this(EmojiSupportMatch.Companion.getDefault-_3YsG6Y(), false, null);
    }

    private PlatformParagraphStyle(int arg2) {
        super();
        this.includeFontPadding = false;
        this.emojiSupportMatch = arg2;
    }

    public PlatformParagraphStyle(int arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = EmojiSupportMatch.Companion.getDefault-_3YsG6Y();
        }

        this(arg1, null);
    }

    public PlatformParagraphStyle(int arg1, DefaultConstructorMarker arg2) {
        this(arg1);
    }

    private PlatformParagraphStyle(int arg1, boolean arg2) {
        super();
        this.includeFontPadding = arg2;
        this.emojiSupportMatch = arg1;
    }

    public PlatformParagraphStyle(int arg1, boolean arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 1) != 0) {
            arg1 = EmojiSupportMatch.Companion.getDefault-_3YsG6Y();
        }

        this(arg1, false, null);
    }

    public PlatformParagraphStyle(boolean arg1) {
        super();
        this.includeFontPadding = arg1;
        this.emojiSupportMatch = EmojiSupportMatch.Companion.getDefault-_3YsG6Y();
    }

    public PlatformParagraphStyle(boolean arg1, int arg2, DefaultConstructorMarker arg3) {
        this(false);
    }

    public static final PlatformParagraphStyle access$getDefault$cp() {
        return PlatformParagraphStyle.Default;
    }

    public boolean equals(Object arg5) {
        if(this == (((PlatformParagraphStyle)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof PlatformParagraphStyle)) {
            return 0;
        }

        if(this.includeFontPadding != ((PlatformParagraphStyle)arg5).includeFontPadding) {
            return 0;
        }

        if(!EmojiSupportMatch.equals-impl0(this.emojiSupportMatch, ((PlatformParagraphStyle)arg5).emojiSupportMatch)) {
            return 0;
        }

        return 1;
    }

    public final int getEmojiSupportMatch-_3YsG6Y() {
        return this.emojiSupportMatch;
    }

    public final boolean getIncludeFontPadding() {
        return this.includeFontPadding;
    }

    public static void getIncludeFontPadding$annotations() {
    }

    public int hashCode() {
        return Boolean.hashCode(this.includeFontPadding) * 0x1F + EmojiSupportMatch.hashCode-impl(this.emojiSupportMatch);
    }

    public final PlatformParagraphStyle merge(PlatformParagraphStyle arg1) {
        if(arg1 == null) {
            return this;
        }

        return arg1;
    }

    public String toString() {
        return "PlatformParagraphStyle(includeFontPadding=" + this.includeFontPadding + ", emojiSupportMatch=" + EmojiSupportMatch.toString-impl(this.emojiSupportMatch) + ')';
    }
}

