package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001A\u001C\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0001H\u0002\u001A\u001C\u0010\u0006\u001A\u00020\u0007*\u00020\u00042\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0007H\u0002\u001A4\u0010\u000B\u001A\u00020\u0001*\u00020\u00042\u0006\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\t2\u0006\u0010\u000E\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u0007H\u0002\u001A\u0018\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00022\u0006\u0010\u0013\u001A\u00020\u0014H\u0002\u001A,\u0010\u0015\u001A\u00020\u0001*\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u00072\u0006\u0010\u0016\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\u0014H\u0002\u001A\u0014\u0010\u0017\u001A\u00020\u0011*\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0002H\u0000\u001A\u0014\u0010\u0018\u001A\u00020\u0011*\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0002H\u0002\u001A\u001C\u0010\u0019\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u001A\u001A\u00020\tH\u0002¨\u0006\u001B²\u0006\n\u0010\u001C\u001A\u00020\tX\u008A\u0084\u0002²\u0006\n\u0010\u001D\u001A\u00020\u0001X\u008A\u0084\u0002"}, d2={"updateSelectionBoundary", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "info", "Landroidx/compose/foundation/text/selection/SelectableInfo;", "previousSelectionAnchor", "isExpanding", "", "currentRawOffset", "", "isStart", "snapToWordBoundary", "currentLine", "currentOffset", "otherOffset", "crossed", "adjustToBoundaries", "Landroidx/compose/foundation/text/selection/Selection;", "layout", "boundaryFunction", "Landroidx/compose/foundation/text/selection/BoundaryFunction;", "anchorOnBoundary", "slot", "ensureAtLeastOneChar", "expandOneChar", "changeOffset", "newOffset", "foundation", "currentRawLine", "anchorSnappedToWordBoundary"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SelectionAdjustmentKt {
    public static final Selection access$adjustToBoundaries(SelectionLayout arg0, BoundaryFunction arg1) {
        return SelectionAdjustmentKt.adjustToBoundaries(arg0, arg1);
    }

    public static final AnchorInfo access$updateSelectionBoundary(SelectionLayout arg0, SelectableInfo arg1, AnchorInfo arg2) {
        return SelectionAdjustmentKt.updateSelectionBoundary(arg0, arg1, arg2);
    }

    private static final Selection adjustToBoundaries(SelectionLayout arg6, BoundaryFunction arg7) {
        boolean v0 = arg6.getCrossStatus() == CrossStatus.CROSSED ? true : false;
        return new Selection(SelectionAdjustmentKt.anchorOnBoundary(arg6.getStartInfo(), v0, true, arg6.getStartSlot(), arg7), SelectionAdjustmentKt.anchorOnBoundary(arg6.getEndInfo(), v0, false, arg6.getEndSlot(), arg7), v0);
    }

    private static final AnchorInfo anchorOnBoundary(SelectableInfo arg2, boolean arg3, boolean arg4, int arg5, BoundaryFunction arg6) {
        int v0 = arg4 ? arg2.getRawStartHandleOffset() : arg2.getRawEndHandleOffset();
        if(arg5 != arg2.getSlot()) {
            return arg2.anchorForOffset(v0);
        }

        long v5 = arg6.getBoundary-fzxv0v0(arg2, v0);
        int v3 = ((((int)arg3)) ^ (((int)arg4))) != 0 ? TextRange.getStart-impl(v5) : TextRange.getEnd-impl(v5);
        return arg2.anchorForOffset(v3);
    }

    private static final AnchorInfo changeOffset(AnchorInfo arg7, SelectableInfo arg8, int arg9) {
        return AnchorInfo.copy$default(arg7, arg8.getTextLayoutResult().getBidiRunDirection(arg9), arg9, 0, 4, null);
    }

    public static final Selection ensureAtLeastOneChar(Selection arg3, SelectionLayout arg4) {
        if(!SelectionLayoutKt.isCollapsed(arg3, arg4)) {
        }
        else {
            String v0 = arg4.getCurrentInfo().getInputText();
            if(arg4.getSize() <= 1 && arg4.getPreviousSelection() != null) {
                if(((CharSequence)v0).length() == 0) {
                    return arg3;
                }
                else {
                    arg3 = SelectionAdjustmentKt.expandOneChar(arg3, arg4);
                }
            }
        }

        return arg3;
    }

    private static final Selection expandOneChar(Selection arg9, SelectionLayout arg10) {
        int v1_1;
        SelectableInfo v0 = arg10.getCurrentInfo();
        String v1 = v0.getInputText();
        int v2 = v0.getRawStartHandleOffset();
        int v3 = v1.length();
        if(v2 == 0) {
            v1_1 = StringHelpers_androidKt.findFollowingBreak(v1, 0);
            if(arg10.isStartHandle()) {
                return Selection.copy$default(arg9, SelectionAdjustmentKt.changeOffset(arg9.getStart(), v0, v1_1), null, true, 2, null);
            }

            return Selection.copy$default(arg9, null, SelectionAdjustmentKt.changeOffset(arg9.getEnd(), v0, v1_1), false, 1, null);
        }

        SelectableInfo v8 = v0;
        Selection v0_1 = arg9;
        SelectableInfo v9 = v8;
        if(v2 == v3) {
            v1_1 = StringHelpers_androidKt.findPrecedingBreak(v1, v3);
            if(arg10.isStartHandle()) {
                return Selection.copy$default(v0_1, SelectionAdjustmentKt.changeOffset(v0_1.getStart(), v9, v1_1), null, false, 2, null);
            }

            return Selection.copy$default(v0_1, null, SelectionAdjustmentKt.changeOffset(v0_1.getEnd(), v9, v1_1), true, 1, null);
        }

        Selection v3_1 = arg10.getPreviousSelection();
        v3 = v3_1 == null || !v3_1.getHandlesCrossed() ? 0 : 1;
        v1_1 = (arg10.isStartHandle() ^ v3) != 0 ? StringHelpers_androidKt.findPrecedingBreak(v1, v2) : StringHelpers_androidKt.findFollowingBreak(v1, v2);
        if(arg10.isStartHandle()) {
            return Selection.copy$default(v0_1, SelectionAdjustmentKt.changeOffset(v0_1.getStart(), v9, v1_1), null, ((boolean)v3), 2, null);
        }

        return Selection.copy$default(v0_1, null, SelectionAdjustmentKt.changeOffset(v0_1.getEnd(), v9, v1_1), ((boolean)v3), 1, null);
    }

    private static final boolean isExpanding(SelectableInfo arg4, int arg5, boolean arg6) {
        if(arg4.getRawPreviousHandleOffset() == -1) {
            return 1;
        }

        if(arg5 == arg4.getRawPreviousHandleOffset()) {
            return 0;
        }

        int v0 = arg4.getRawCrossStatus() == CrossStatus.CROSSED ? 1 : 0;
        if(((((int)arg6)) ^ v0) != 0) {
            if(arg5 < arg4.getRawPreviousHandleOffset()) {
                return 1;
            }

            return 0;
        }

        if(arg5 > arg4.getRawPreviousHandleOffset()) {
            return 1;
        }

        return 0;
    }

    private static final AnchorInfo snapToWordBoundary(SelectableInfo arg5, int arg6, int arg7, int arg8, boolean arg9, boolean arg10) {
        int v2;
        long v0 = arg5.getTextLayoutResult().getWordBoundary--jx7JFs(arg7);
        if(arg5.getTextLayoutResult().getLineForOffset(TextRange.getStart-impl(v0)) == arg6) {
            v2 = TextRange.getStart-impl(v0);
        }
        else if(arg6 >= arg5.getTextLayoutResult().getLineCount()) {
            v2 = arg5.getTextLayoutResult().getLineStart(arg5.getTextLayoutResult().getLineCount() - 1);
        }
        else {
            v2 = arg5.getTextLayoutResult().getLineStart(arg6);
        }

        if(arg5.getTextLayoutResult().getLineForOffset(TextRange.getEnd-impl(v0)) == arg6) {
            arg6 = TextRange.getEnd-impl(v0);
        }
        else {
            Object v1 = null;
            int v3 = 2;
            arg6 = arg6 >= arg5.getTextLayoutResult().getLineCount() ? TextLayoutResult.getLineEnd$default(arg5.getTextLayoutResult(), arg5.getTextLayoutResult().getLineCount() - 1, false, v3, v1) : TextLayoutResult.getLineEnd$default(arg5.getTextLayoutResult(), arg6, false, v3, v1);
        }

        if(v2 == arg8) {
            return arg5.anchorForOffset(arg6);
        }

        if(arg6 == arg8) {
            return arg5.anchorForOffset(v2);
        }

        if(((((int)arg9)) ^ (((int)arg10))) != 0) {
            if(arg7 <= arg6) {
            }
            else {
                goto label_50;
            }
        }
        else if(arg7 >= v2) {
        label_50:
            v2 = arg6;
        }

        return arg5.anchorForOffset(v2);
    }

    private static final AnchorInfo updateSelectionBoundary(SelectionLayout arg9, SelectableInfo arg10, AnchorInfo arg11) {
        int v0 = arg9.isStartHandle() ? arg10.getRawStartHandleOffset() : arg10.getRawEndHandleOffset();
        int v3 = v0;
        v0 = arg9.isStartHandle() ? arg9.getStartSlot() : arg9.getEndSlot();
        if(v0 != arg10.getSlot()) {
            return arg10.anchorForOffset(v3);
        }

        Lazy v6 = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SelectionAdjustmentKt$$ExternalSyntheticLambda0(arg10, v3));
        v0 = arg9.isStartHandle() ? arg10.getRawEndHandleOffset() : arg10.getRawStartHandleOffset();
        SelectionLayout v5 = arg9;
        SelectableInfo v2 = arg10;
        Lazy v9 = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SelectionAdjustmentKt$$ExternalSyntheticLambda1(v2, v3, v0, v5, v6));
        if(v2.getSelectableId() != arg11.getSelectableId()) {
            return SelectionAdjustmentKt.updateSelectionBoundary$lambda$3(v9);
        }

        int v10 = v2.getRawPreviousHandleOffset();
        if(v3 == v10) {
            return arg11;
        }

        if(SelectionAdjustmentKt.updateSelectionBoundary$lambda$1(v6) != v2.getTextLayoutResult().getLineForOffset(v10)) {
            return SelectionAdjustmentKt.updateSelectionBoundary$lambda$3(v9);
        }

        v10 = arg11.getOffset();
        long v0_1 = v2.getTextLayoutResult().getWordBoundary--jx7JFs(v10);
        if(!SelectionAdjustmentKt.isExpanding(v2, v3, v5.isStartHandle())) {
            return v2.anchorForOffset(v3);
        }

        if(v10 != TextRange.getStart-impl(v0_1)) {
            if(v10 == TextRange.getEnd-impl(v0_1)) {
            }
            else {
                return v2.anchorForOffset(v3);
            }
        }

        return SelectionAdjustmentKt.updateSelectionBoundary$lambda$3(v9);
    }

    static final int updateSelectionBoundary$lambda$0(SelectableInfo arg0, int arg1) {
        return arg0.getTextLayoutResult().getLineForOffset(arg1);
    }

    private static final int updateSelectionBoundary$lambda$1(Lazy arg0) {
        return arg0.getValue().intValue();
    }

    static final AnchorInfo updateSelectionBoundary$lambda$2(SelectableInfo arg6, int arg7, int arg8, SelectionLayout arg9, Lazy arg10) {
        int v1 = SelectionAdjustmentKt.updateSelectionBoundary$lambda$1(arg10);
        boolean v4 = arg9.isStartHandle();
        boolean v9 = arg9.getCrossStatus() == CrossStatus.CROSSED ? true : false;
        return SelectionAdjustmentKt.snapToWordBoundary(arg6, v1, arg7, arg8, v4, v9);
    }

    private static final AnchorInfo updateSelectionBoundary$lambda$3(Lazy arg0) {
        return arg0.getValue();
    }
}

