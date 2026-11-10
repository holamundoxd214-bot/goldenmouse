package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001D\b\u0016\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0013\b\u0016\u0012\b\b\u0002\u0010\b\u001A\u00020\t¢\u0006\u0004\b\u0006\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\u0006\u0010\rJ\b\u0010\u0012\u001A\u00020\u0013H\u0016J\u0013\u0010\u0014\u001A\u00020\t2\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0016\u001A\u00020\u0017H\u0016R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2={"Landroidx/compose/ui/text/PlatformTextStyle;", "", "spanStyle", "Landroidx/compose/ui/text/PlatformSpanStyle;", "paragraphStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "<init>", "(Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/text/PlatformParagraphStyle;)V", "includeFontPadding", "", "(Z)V", "emojiSupportMatch", "Landroidx/compose/ui/text/EmojiSupportMatch;", "(ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSpanStyle", "()Landroidx/compose/ui/text/PlatformSpanStyle;", "getParagraphStyle", "()Landroidx/compose/ui/text/PlatformParagraphStyle;", "hashCode", "", "equals", "other", "toString", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PlatformTextStyle {
    public static final int $stable;
    private final PlatformParagraphStyle paragraphStyle;
    private final PlatformSpanStyle spanStyle;

    static {
    }

    public PlatformTextStyle(boolean arg2) {
        this(null, new PlatformParagraphStyle(arg2));
    }

    public PlatformTextStyle(PlatformSpanStyle arg1, PlatformParagraphStyle arg2) {
        super();
        this.spanStyle = arg1;
        this.paragraphStyle = arg2;
    }

    private PlatformTextStyle(int arg3) {
        this(null, new PlatformParagraphStyle(arg3, null));
    }

    public PlatformTextStyle(int arg1, DefaultConstructorMarker arg2) {
        this(arg1);
    }

    public PlatformTextStyle(boolean arg1, int arg2, DefaultConstructorMarker arg3) {
        this(false);
    }

    public boolean equals(Object arg5) {
        if(this == (((PlatformTextStyle)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof PlatformTextStyle)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.paragraphStyle, ((PlatformTextStyle)arg5).paragraphStyle)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.spanStyle, ((PlatformTextStyle)arg5).spanStyle)) {
            return 0;
        }

        return 1;
    }

    public final PlatformParagraphStyle getParagraphStyle() {
        return this.paragraphStyle;
    }

    public final PlatformSpanStyle getSpanStyle() {
        return this.spanStyle;
    }

    public int hashCode() {
        PlatformSpanStyle v0 = this.spanStyle;
        int v1 = 0;
        int v0_1 = v0 != null ? v0.hashCode() : 0;
        v0_1 *= 0x1F;
        PlatformParagraphStyle v2 = this.paragraphStyle;
        if(v2 != null) {
            v1 = v2.hashCode();
        }

        return v0_1 + v1;
    }

    public String toString() {
        return "PlatformTextStyle(spanStyle=" + this.spanStyle + ", paragraphSyle=" + this.paragraphStyle + ')';
    }
}

