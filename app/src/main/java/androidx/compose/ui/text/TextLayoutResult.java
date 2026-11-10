package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000E\u0010(\u001A\u00020%2\u0006\u0010)\u001A\u00020%J\u0018\u0010*\u001A\u00020%2\u0006\u0010)\u001A\u00020%2\b\b\u0002\u0010+\u001A\u00020\u0018J\u000E\u0010,\u001A\u00020\u00182\u0006\u0010)\u001A\u00020%J\u000E\u0010-\u001A\u00020\u00122\u0006\u0010)\u001A\u00020%J\u000E\u0010.\u001A\u00020\u00122\u0006\u0010)\u001A\u00020%J\u000E\u0010/\u001A\u00020\u00122\u0006\u0010)\u001A\u00020%J\u000E\u00100\u001A\u00020\u00122\u0006\u0010)\u001A\u00020%J\u000E\u00101\u001A\u00020\u00122\u0006\u0010)\u001A\u00020%J\u000E\u00102\u001A\u00020%2\u0006\u00103\u001A\u00020%J\u000E\u00104\u001A\u00020%2\u0006\u00105\u001A\u00020\u0012J\u0016\u00106\u001A\u00020\u00122\u0006\u00103\u001A\u00020%2\u0006\u00107\u001A\u00020\u0018J\u000E\u00108\u001A\u0002092\u0006\u00103\u001A\u00020%J\u000E\u0010:\u001A\u0002092\u0006\u00103\u001A\u00020%J\u0015\u0010;\u001A\u00020%2\u0006\u0010<\u001A\u00020=¢\u0006\u0004\b>\u0010?J\u000E\u0010@\u001A\u00020!2\u0006\u00103\u001A\u00020%J\u0015\u0010A\u001A\u00020B2\u0006\u00103\u001A\u00020%¢\u0006\u0004\bC\u0010DJ\u000E\u0010E\u001A\u00020!2\u0006\u00103\u001A\u00020%J\u0016\u0010F\u001A\u00020G2\u0006\u0010H\u001A\u00020%2\u0006\u0010I\u001A\u00020%J!\u0010J\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\bK\u0010LJ\u0013\u0010M\u001A\u00020\u00182\b\u0010N\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010O\u001A\u00020%H\u0016J\b\u0010P\u001A\u00020QH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010\u0010\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0011\u001A\u00020\u0012¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001A\u00020\u0012¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0017\u001A\u00020\u00188F¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001AR\u0011\u0010\u001B\u001A\u00020\u00188F¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001AR\u0011\u0010\u001D\u001A\u00020\u00188F¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001AR\u0019\u0010\u001F\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010!0 ¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010#R\u0011\u0010$\u001A\u00020%8F¢\u0006\u0006\u001A\u0004\b&\u0010\'¨\u0006R"}, d2={"Landroidx/compose/ui/text/TextLayoutResult;", "", "layoutInput", "Landroidx/compose/ui/text/TextLayoutInput;", "multiParagraph", "Landroidx/compose/ui/text/MultiParagraph;", "size", "Landroidx/compose/ui/unit/IntSize;", "<init>", "(Landroidx/compose/ui/text/TextLayoutInput;Landroidx/compose/ui/text/MultiParagraph;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLayoutInput", "()Landroidx/compose/ui/text/TextLayoutInput;", "getMultiParagraph", "()Landroidx/compose/ui/text/MultiParagraph;", "getSize-YbymL2g", "()J", "J", "firstBaseline", "", "getFirstBaseline", "()F", "lastBaseline", "getLastBaseline", "didOverflowHeight", "", "getDidOverflowHeight", "()Z", "didOverflowWidth", "getDidOverflowWidth", "hasVisualOverflow", "getHasVisualOverflow", "placeholderRects", "", "Landroidx/compose/ui/geometry/Rect;", "getPlaceholderRects", "()Ljava/util/List;", "lineCount", "", "getLineCount", "()I", "getLineStart", "lineIndex", "getLineEnd", "visibleEnd", "isLineEllipsized", "getLineTop", "getLineBaseline", "getLineBottom", "getLineLeft", "getLineRight", "getLineForOffset", "offset", "getLineForVerticalPosition", "vertical", "getHorizontalPosition", "usePrimaryDirection", "getParagraphDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getBidiRunDirection", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-k-4lQ0M", "(J)I", "getBoundingBox", "getWordBoundary", "Landroidx/compose/ui/text/TextRange;", "getWordBoundary--jx7JFs", "(I)J", "getCursorRect", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "end", "copy", "copy-O0kMr_c", "(Landroidx/compose/ui/text/TextLayoutInput;J)Landroidx/compose/ui/text/TextLayoutResult;", "equals", "other", "hashCode", "toString", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextLayoutResult {
    public static final int $stable = 8;
    private final float firstBaseline;
    private final float lastBaseline;
    private final TextLayoutInput layoutInput;
    private final MultiParagraph multiParagraph;
    private final List placeholderRects;
    private final long size;

    static {
    }

    public TextLayoutResult(TextLayoutInput arg1, MultiParagraph arg2, long arg3, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3);
    }

    private TextLayoutResult(TextLayoutInput arg1, MultiParagraph arg2, long arg3) {
        super();
        this.layoutInput = arg1;
        this.multiParagraph = arg2;
        this.size = arg3;
        this.firstBaseline = arg2.getFirstBaseline();
        this.lastBaseline = arg2.getLastBaseline();
        this.placeholderRects = arg2.getPlaceholderRects();
    }

    public final TextLayoutResult copy-O0kMr_c(TextLayoutInput arg7, long arg8) {
        return new TextLayoutResult(arg7, this.multiParagraph, arg8, null);
    }

    public static TextLayoutResult copy-O0kMr_c$default(TextLayoutResult arg0, TextLayoutInput arg1, long arg2, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.layoutInput;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.size;
        }

        return arg0.copy-O0kMr_c(arg1, arg2);
    }

    public boolean equals(Object arg8) {
        if(this == (((TextLayoutResult)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof TextLayoutResult)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.layoutInput, ((TextLayoutResult)arg8).layoutInput)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.multiParagraph, ((TextLayoutResult)arg8).multiParagraph)) {
            return 0;
        }

        if(!IntSize.equals-impl0(this.size, ((TextLayoutResult)arg8).size)) {
            return 0;
        }

        if(this.firstBaseline == ((TextLayoutResult)arg8).firstBaseline && this.lastBaseline == ((TextLayoutResult)arg8).lastBaseline) {
            if(!Intrinsics.areEqual(this.placeholderRects, ((TextLayoutResult)arg8).placeholderRects)) {
                return 0;
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public final ResolvedTextDirection getBidiRunDirection(int arg1) {
        return this.multiParagraph.getBidiRunDirection(arg1);
    }

    public final Rect getBoundingBox(int arg1) {
        return this.multiParagraph.getBoundingBox(arg1);
    }

    public final Rect getCursorRect(int arg1) {
        return this.multiParagraph.getCursorRect(arg1);
    }

    public final boolean getDidOverflowHeight() {
        if(!this.multiParagraph.getDidExceedMaxLines()) {
            if((((float)(((int)(this.size & 0xFFFFFFFFL))))) < this.multiParagraph.getHeight()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final boolean getDidOverflowWidth() {
        if((((float)(((int)(this.size >> 0x20))))) < this.multiParagraph.getWidth()) {
            return 1;
        }

        return 0;
    }

    public final float getFirstBaseline() {
        return this.firstBaseline;
    }

    public final boolean getHasVisualOverflow() {
        if(!this.getDidOverflowWidth()) {
            if(this.getDidOverflowHeight()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final float getHorizontalPosition(int arg1, boolean arg2) {
        return this.multiParagraph.getHorizontalPosition(arg1, arg2);
    }

    public final float getLastBaseline() {
        return this.lastBaseline;
    }

    public final TextLayoutInput getLayoutInput() {
        return this.layoutInput;
    }

    public final float getLineBaseline(int arg1) {
        return this.multiParagraph.getLineBaseline(arg1);
    }

    public final float getLineBottom(int arg1) {
        return this.multiParagraph.getLineBottom(arg1);
    }

    public final int getLineCount() {
        return this.multiParagraph.getLineCount();
    }

    public final int getLineEnd(int arg1, boolean arg2) {
        return this.multiParagraph.getLineEnd(arg1, arg2);
    }

    public static int getLineEnd$default(TextLayoutResult arg0, int arg1, boolean arg2, int arg3, Object arg4) {
        return arg0.getLineEnd(arg1, false);
    }

    public final int getLineForOffset(int arg1) {
        return this.multiParagraph.getLineForOffset(arg1);
    }

    public final int getLineForVerticalPosition(float arg1) {
        return this.multiParagraph.getLineForVerticalPosition(arg1);
    }

    public final float getLineLeft(int arg1) {
        return this.multiParagraph.getLineLeft(arg1);
    }

    public final float getLineRight(int arg1) {
        return this.multiParagraph.getLineRight(arg1);
    }

    public final int getLineStart(int arg1) {
        return this.multiParagraph.getLineStart(arg1);
    }

    public final float getLineTop(int arg1) {
        return this.multiParagraph.getLineTop(arg1);
    }

    public final MultiParagraph getMultiParagraph() {
        return this.multiParagraph;
    }

    public final int getOffsetForPosition-k-4lQ0M(long arg1) {
        return this.multiParagraph.getOffsetForPosition-k-4lQ0M(arg1);
    }

    public final ResolvedTextDirection getParagraphDirection(int arg1) {
        return this.multiParagraph.getParagraphDirection(arg1);
    }

    public final Path getPathForRange(int arg1, int arg2) {
        return this.multiParagraph.getPathForRange(arg1, arg2);
    }

    public final List getPlaceholderRects() {
        return this.placeholderRects;
    }

    public final long getSize-YbymL2g() {
        return this.size;
    }

    public final long getWordBoundary--jx7JFs(int arg1) {
        return this.multiParagraph.getWordBoundary--jx7JFs(arg1);
    }

    public int hashCode() {
        return ((((this.layoutInput.hashCode() * 0x1F + this.multiParagraph.hashCode()) * 0x1F + IntSize.hashCode-impl(this.size)) * 0x1F + Float.hashCode(this.firstBaseline)) * 0x1F + Float.hashCode(this.lastBaseline)) * 0x1F + this.placeholderRects.hashCode();
    }

    public final boolean isLineEllipsized(int arg1) {
        return this.multiParagraph.isLineEllipsized(arg1);
    }

    public String toString() {
        return "TextLayoutResult(layoutInput=" + this.layoutInput + ", multiParagraph=" + this.multiParagraph + ", size=" + IntSize.toString-impl(this.size) + ", firstBaseline=" + this.firstBaseline + ", lastBaseline=" + this.lastBaseline + ", placeholderRects=" + this.placeholderRects + ')';
    }
}

