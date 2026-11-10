package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u001C\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000E\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0005\u0012\b\b\u0002\u0010\b\u001A\u00020\u0005\u0012\b\b\u0002\u0010\t\u001A\u00020\n\u0012\b\b\u0002\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\f\u0010\rJ\n\u0010 \u001A\u00020\u0005*\u00020\u0005J\n\u0010!\u001A\u00020\u0005*\u00020\u0005J\n\u0010\"\u001A\u00020\u0005*\u00020\u0005J\n\u0010#\u001A\u00020\u0005*\u00020\u0005J\n\u0010$\u001A\u00020\n*\u00020\nJ\n\u0010%\u001A\u00020\n*\u00020\nJ\u0011\u0010&\u001A\u00020\'*\u00020\'¢\u0006\u0004\b(\u0010)J\n\u0010*\u001A\u00020+*\u00020+J\n\u0010&\u001A\u00020+*\u00020+J\n\u0010*\u001A\u00020,*\u00020,J\u001B\u0010*\u001A\u00020-*\u00020-2\b\b\u0002\u0010.\u001A\u00020/¢\u0006\u0004\b0\u00101J\t\u00102\u001A\u00020\u0003HÆ\u0003J\t\u00103\u001A\u00020\u0005HÆ\u0003J\t\u00104\u001A\u00020\u0005HÆ\u0003J\t\u00105\u001A\u00020\u0005HÆ\u0003J\t\u00106\u001A\u00020\u0005HÆ\u0003J\t\u00107\u001A\u00020\nHÆ\u0003J\t\u00108\u001A\u00020\nHÆ\u0003JO\u00109\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\u00052\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\nHÆ\u0001J\u0013\u0010:\u001A\u00020/2\b\u0010;\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001A\u00020\u0005HÖ\u0001J\t\u0010=\u001A\u00020>HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0011R\u001A\u0010\u0007\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0011\"\u0004\b\u0014\u0010\u0015R\u001A\u0010\b\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0015R\u001A\u0010\t\u001A\u00020\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR\u001A\u0010\u000B\u001A\u00020\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u0019\"\u0004\b\u001D\u0010\u001BR\u0011\u0010\u001E\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u001F\u0010\u0011¨\u0006?"}, d2={"Landroidx/compose/ui/text/ParagraphInfo;", "", "paragraph", "Landroidx/compose/ui/text/Paragraph;", "startIndex", "", "endIndex", "startLineIndex", "endLineIndex", "top", "", "bottom", "<init>", "(Landroidx/compose/ui/text/Paragraph;IIIIFF)V", "getParagraph", "()Landroidx/compose/ui/text/Paragraph;", "getStartIndex", "()I", "getEndIndex", "getStartLineIndex", "setStartLineIndex", "(I)V", "getEndLineIndex", "setEndLineIndex", "getTop", "()F", "setTop", "(F)V", "getBottom", "setBottom", "length", "getLength", "toLocalIndex", "toGlobalIndex", "toLocalLineIndex", "toGlobalLineIndex", "toGlobalYPosition", "toLocalYPosition", "toLocal", "Landroidx/compose/ui/geometry/Offset;", "toLocal-MK-Hz9U", "(J)J", "toGlobal", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/graphics/Path;", "Landroidx/compose/ui/text/TextRange;", "treatZeroAsNull", "", "toGlobal-xdX6-G0", "(JZ)J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ParagraphInfo {
    public static final int $stable = 8;
    private float bottom;
    private final int endIndex;
    private int endLineIndex;
    private final Paragraph paragraph;
    private final int startIndex;
    private int startLineIndex;
    private float top;

    static {
    }

    public ParagraphInfo(Paragraph arg1, int arg2, int arg3, int arg4, int arg5, float arg6, float arg7) {
        super();
        this.paragraph = arg1;
        this.startIndex = arg2;
        this.endIndex = arg3;
        this.startLineIndex = arg4;
        this.endLineIndex = arg5;
        this.top = arg6;
        this.bottom = arg7;
    }

    public ParagraphInfo(Paragraph arg2, int arg3, int arg4, int arg5, int arg6, float arg7, float arg8, int arg9, DefaultConstructorMarker arg10) {
        int v0 = -1;
        if((arg9 & 8) != 0) {
            arg5 = v0;
        }

        if((arg9 & 16) != 0) {
            arg6 = v0;
        }

        float v0_1 = -1f;
        if((arg9 & 0x20) != 0) {
            arg7 = v0_1;
        }

        if((arg9 & 0x40) != 0) {
            arg8 = v0_1;
        }

        this(arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public final Paragraph component1() {
        return this.paragraph;
    }

    public final int component2() {
        return this.startIndex;
    }

    public final int component3() {
        return this.endIndex;
    }

    public final int component4() {
        return this.startLineIndex;
    }

    public final int component5() {
        return this.endLineIndex;
    }

    public final float component6() {
        return this.top;
    }

    public final float component7() {
        return this.bottom;
    }

    public final ParagraphInfo copy(Paragraph arg1, int arg2, int arg3, int arg4, int arg5, float arg6, float arg7) {
        return new ParagraphInfo(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static ParagraphInfo copy$default(ParagraphInfo arg0, Paragraph arg1, int arg2, int arg3, int arg4, int arg5, float arg6, float arg7, int arg8, Object arg9) {
        if((arg8 & 1) != 0) {
            arg1 = arg0.paragraph;
        }

        if((arg8 & 2) != 0) {
            arg2 = arg0.startIndex;
        }

        if((arg8 & 4) != 0) {
            arg3 = arg0.endIndex;
        }

        if((arg8 & 8) != 0) {
            arg4 = arg0.startLineIndex;
        }

        if((arg8 & 16) != 0) {
            arg5 = arg0.endLineIndex;
        }

        if((arg8 & 0x20) != 0) {
            arg6 = arg0.top;
        }

        if((arg8 & 0x40) != 0) {
            arg7 = arg0.bottom;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public boolean equals(Object arg5) {
        if(this == (((ParagraphInfo)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ParagraphInfo)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.paragraph, ((ParagraphInfo)arg5).paragraph)) {
            return 0;
        }

        if(this.startIndex != ((ParagraphInfo)arg5).startIndex) {
            return 0;
        }

        if(this.endIndex != ((ParagraphInfo)arg5).endIndex) {
            return 0;
        }

        if(this.startLineIndex != ((ParagraphInfo)arg5).startLineIndex) {
            return 0;
        }

        if(this.endLineIndex != ((ParagraphInfo)arg5).endLineIndex) {
            return 0;
        }

        if(Float.compare(this.top, ((ParagraphInfo)arg5).top) != 0) {
            return 0;
        }

        if(Float.compare(this.bottom, ((ParagraphInfo)arg5).bottom) != 0) {
            return 0;
        }

        return 1;
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final int getEndIndex() {
        return this.endIndex;
    }

    public final int getEndLineIndex() {
        return this.endLineIndex;
    }

    public final int getLength() {
        return this.endIndex - this.startIndex;
    }

    public final Paragraph getParagraph() {
        return this.paragraph;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final int getStartLineIndex() {
        return this.startLineIndex;
    }

    public final float getTop() {
        return this.top;
    }

    public int hashCode() {
        return (((((this.paragraph.hashCode() * 0x1F + Integer.hashCode(this.startIndex)) * 0x1F + Integer.hashCode(this.endIndex)) * 0x1F + Integer.hashCode(this.startLineIndex)) * 0x1F + Integer.hashCode(this.endLineIndex)) * 0x1F + Float.hashCode(this.top)) * 0x1F + Float.hashCode(this.bottom);
    }

    public final void setBottom(float arg1) {
        this.bottom = arg1;
    }

    public final void setEndLineIndex(int arg1) {
        this.endLineIndex = arg1;
    }

    public final void setStartLineIndex(int arg1) {
        this.startLineIndex = arg1;
    }

    public final void setTop(float arg1) {
        this.top = arg1;
    }

    public final Rect toGlobal(Rect arg7) {
        return arg7.translate-k-4lQ0M(Offset.constructor-impl((((long)Float.floatToRawIntBits(0f))) << 0x20 | (((long)Float.floatToRawIntBits(this.top))) & 0xFFFFFFFFL));
    }

    public final Path toGlobal(Path arg7) {
        arg7.translate-k-4lQ0M(Offset.constructor-impl((((long)Float.floatToRawIntBits(0f))) << 0x20 | (((long)Float.floatToRawIntBits(this.top))) & 0xFFFFFFFFL));
        return arg7;
    }

    public final long toGlobal-xdX6-G0(long arg3, boolean arg5) {
        if((arg5) && (TextRange.equals-impl0(arg3, TextRange.Companion.getZero-d9O1mEE()))) {
            return TextRange.Companion.getZero-d9O1mEE();
        }

        return TextRangeKt.TextRange(this.toGlobalIndex(TextRange.getStart-impl(arg3)), this.toGlobalIndex(TextRange.getEnd-impl(arg3)));
    }

    public static long toGlobal-xdX6-G0$default(ParagraphInfo arg0, long arg1, boolean arg3, int arg4, Object arg5) {
        return arg0.toGlobal-xdX6-G0(arg1, true);
    }

    public final int toGlobalIndex(int arg1) {
        return arg1 + this.startIndex;
    }

    public final int toGlobalLineIndex(int arg1) {
        return arg1 + this.startLineIndex;
    }

    public final float toGlobalYPosition(float arg1) {
        return arg1 + this.top;
    }

    public final Rect toLocal(Rect arg7) {
        return arg7.translate-k-4lQ0M(Offset.constructor-impl((((long)Float.floatToRawIntBits(0f))) << 0x20 | (((long)Float.floatToRawIntBits(-this.top))) & 0xFFFFFFFFL));
    }

    public final long toLocal-MK-Hz9U(long arg7) {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg7 & 0xFFFFFFFFL))) - this.top))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg7 >> 0x20)))))) << 0x20);
    }

    public final int toLocalIndex(int arg3) {
        return RangesKt.coerceIn(arg3, this.startIndex, this.endIndex) - this.startIndex;
    }

    public final int toLocalLineIndex(int arg1) {
        return arg1 - this.startLineIndex;
    }

    public final float toLocalYPosition(float arg1) {
        return arg1 - this.top;
    }

    public String toString() {
        return "ParagraphInfo(paragraph=" + this.paragraph + ", startIndex=" + this.startIndex + ", endIndex=" + this.endIndex + ", startLineIndex=" + this.startLineIndex + ", endLineIndex=" + this.endLineIndex + ", top=" + this.top + ", bottom=" + this.bottom + ')';
    }
}

