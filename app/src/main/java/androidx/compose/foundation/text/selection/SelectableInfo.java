package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0005\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fJ\u000E\u0010&\u001A\u00020\'2\u0006\u0010(\u001A\u00020\u0000J\u000E\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020\u0005J\u0016\u0010,\u001A\u00020-2\u0006\u0010.\u001A\u00020\u00052\u0006\u0010/\u001A\u00020\u0005J\b\u00100\u001A\u00020\u0017H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001A\u00020\u00178F¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001A\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u0010R\u0011\u0010\u001C\u001A\u00020\u001D8F¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001FR\u0014\u0010 \u001A\u00020!8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\"\u0010#R\u0014\u0010$\u001A\u00020!8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b%\u0010#¨\u00061"}, d2={"Landroidx/compose/foundation/text/selection/SelectableInfo;", "", "selectableId", "", "slot", "", "rawStartHandleOffset", "rawEndHandleOffset", "rawPreviousHandleOffset", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "<init>", "(JIIIILandroidx/compose/ui/text/TextLayoutResult;)V", "getSelectableId", "()J", "getSlot", "()I", "getRawStartHandleOffset", "getRawEndHandleOffset", "getRawPreviousHandleOffset", "getTextLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "inputText", "", "getInputText", "()Ljava/lang/String;", "textLength", "getTextLength", "rawCrossStatus", "Landroidx/compose/foundation/text/selection/CrossStatus;", "getRawCrossStatus", "()Landroidx/compose/foundation/text/selection/CrossStatus;", "startRunDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getStartRunDirection", "()Landroidx/compose/ui/text/style/ResolvedTextDirection;", "endRunDirection", "getEndRunDirection", "shouldRecomputeSelection", "", "other", "anchorForOffset", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "offset", "makeSingleLayoutSelection", "Landroidx/compose/foundation/text/selection/Selection;", "start", "end", "toString", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SelectableInfo {
    public static final int $stable;
    private final int rawEndHandleOffset;
    private final int rawPreviousHandleOffset;
    private final int rawStartHandleOffset;
    private final long selectableId;
    private final int slot;
    private final TextLayoutResult textLayoutResult;

    static {
        SelectableInfo.$stable = TextLayoutResult.$stable;
    }

    public SelectableInfo(long arg1, int arg3, int arg4, int arg5, int arg6, TextLayoutResult arg7) {
        super();
        this.selectableId = arg1;
        this.slot = arg3;
        this.rawStartHandleOffset = arg4;
        this.rawEndHandleOffset = arg5;
        this.rawPreviousHandleOffset = arg6;
        this.textLayoutResult = arg7;
    }

    public final AnchorInfo anchorForOffset(int arg5) {
        return new AnchorInfo(SelectionHelpersKt.getTextDirectionForOffset(this.textLayoutResult, arg5), arg5, this.selectableId);
    }

    private final ResolvedTextDirection getEndRunDirection() {
        return SelectionHelpersKt.getTextDirectionForOffset(this.textLayoutResult, this.rawEndHandleOffset);
    }

    public final String getInputText() {
        return this.textLayoutResult.getLayoutInput().getText().getText();
    }

    public final CrossStatus getRawCrossStatus() {
        int v0 = this.rawStartHandleOffset;
        int v1 = this.rawEndHandleOffset;
        if(v0 < v1) {
            return CrossStatus.NOT_CROSSED;
        }

        if(v0 > v1) {
            return CrossStatus.CROSSED;
        }

        return CrossStatus.COLLAPSED;
    }

    public final int getRawEndHandleOffset() {
        return this.rawEndHandleOffset;
    }

    public final int getRawPreviousHandleOffset() {
        return this.rawPreviousHandleOffset;
    }

    public final int getRawStartHandleOffset() {
        return this.rawStartHandleOffset;
    }

    public final long getSelectableId() {
        return this.selectableId;
    }

    public final int getSlot() {
        return this.slot;
    }

    private final ResolvedTextDirection getStartRunDirection() {
        return SelectionHelpersKt.getTextDirectionForOffset(this.textLayoutResult, this.rawStartHandleOffset);
    }

    public final TextLayoutResult getTextLayoutResult() {
        return this.textLayoutResult;
    }

    public final int getTextLength() {
        return this.getInputText().length();
    }

    public final Selection makeSingleLayoutSelection(int arg3, int arg4) {
        AnchorInfo v1 = this.anchorForOffset(arg3);
        AnchorInfo v2 = this.anchorForOffset(arg4);
        boolean v3 = arg3 > arg4 ? true : false;
        return new Selection(v1, v2, v3);
    }

    public final boolean shouldRecomputeSelection(SelectableInfo arg5) {
        if(this.selectableId == arg5.selectableId && this.rawStartHandleOffset == arg5.rawStartHandleOffset) {
            if(this.rawEndHandleOffset != arg5.rawEndHandleOffset) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public String toString() {
        return "SelectionInfo(id=" + this.selectableId + ", range=(" + this.rawStartHandleOffset + '-' + this.getStartRunDirection() + ',' + this.rawEndHandleOffset + '-' + this.getEndRunDirection() + "), prevOffset=" + this.rawPreviousHandleOffset + ')';
    }
}

