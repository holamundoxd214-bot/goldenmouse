package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.Comparator;
import kotlin.Metadata;

@Metadata(d1={"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0006\u001A3\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000B\u001A4\u0010\f\u001A\u00020\r*\u00020\u000E2\u0016\u0010\u000F\u001A\u0012\u0012\u0004\u0012\u00020\t0\u0010j\b\u0012\u0004\u0012\u00020\t`\u00112\u0006\u0010\u0012\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\rH\u0002\u001A\u001F\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00062\u0006\u0010\u0017\u001A\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001A\u001A\u001F\u0010\u001B\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00062\u0006\u0010\u0017\u001A\u00020\u0018H\u0002¢\u0006\u0004\b\u001C\u0010\u001A\u001A\u001C\u0010\u001D\u001A\u00020\u0015*\u00020\u00022\u0006\u0010\u001E\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\tH\u0002\u001A\u0018\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020\u00152\u0006\u0010\"\u001A\u00020\u0015H\u0002\u001A\u001F\u0010#\u001A\u00020\r2\u0006\u0010\u0016\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u0004H\u0002¢\u0006\u0004\b$\u0010%¨\u0006&"}, d2={"appendSelectableInfo", "", "Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "localPosition", "Landroidx/compose/ui/geometry/Offset;", "previousHandlePosition", "selectableId", "", "appendSelectableInfo-Parwq6A", "(Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;Landroidx/compose/ui/text/TextLayoutResult;JJJ)V", "getPreviousAdjustedOffset", "", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "selectableIdOrderingComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "currentSelectableId", "currentTextLength", "getXDirection", "Landroidx/compose/foundation/text/selection/Direction;", "position", "bounds", "Landroidx/compose/ui/geometry/Rect;", "getXDirection-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)Landroidx/compose/foundation/text/selection/Direction;", "getYDirection", "getYDirection-3MmeM6k", "getDirectionById", "anchorSelectableId", "isSelected", "", "currentDirection", "otherDirection", "getOffsetForPosition", "getOffsetForPosition-3MmeM6k", "(JLandroidx/compose/ui/text/TextLayoutResult;)I", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class MultiWidgetSelectionDelegateKt {
    public static final void appendSelectableInfo-Parwq6A(SelectionLayoutBuilder arg16, TextLayoutResult arg17, long arg18, long arg20, long arg22) {
        int v1_2;
        int v0_1;
        Direction v9_1;
        Direction v13;
        Direction v12;
        Direction v11;
        long v7_1;
        AnchorInfo v9;
        Direction v6_1;
        Selection v6;
        TextLayoutResult v10 = arg17;
        long v0 = arg18;
        long v2 = arg20;
        Rect v4 = new Rect(0f, 0f, ((float)(((int)(v10.getSize-YbymL2g() >> 0x20)))), ((float)(((int)(v10.getSize-YbymL2g() & 0xFFFFFFFFL)))));
        Direction v5 = MultiWidgetSelectionDelegateKt.getXDirection-3MmeM6k(v0, v4);
        Direction v4_1 = MultiWidgetSelectionDelegateKt.getYDirection-3MmeM6k(v0, v4);
        AnchorInfo v7 = null;
        if(arg16.isStartHandle()) {
            v6 = arg16.getPreviousSelection();
            if(v6 != null) {
                v7 = v6.getEnd();
            }

            v6_1 = v5;
            v5 = v4_1;
            v4_1 = v6_1;
            v9 = v7;
            v7_1 = arg22;
            v11 = v4_1;
            v6_1 = MultiWidgetSelectionDelegateKt.appendSelectableInfo_Parwq6A$otherDirection(v4_1, v5, arg16, arg22, v9);
            v12 = v6_1;
            v13 = v12;
            v9_1 = v5;
        }
        else {
            Direction v15 = v5;
            v5 = v4_1;
            v4_1 = v15;
            v6 = arg16.getPreviousSelection();
            if(v6 != null) {
                v7 = v6.getStart();
            }

            v9 = v7;
            v7_1 = arg22;
            v9_1 = MultiWidgetSelectionDelegateKt.appendSelectableInfo_Parwq6A$otherDirection(v4_1, v5, arg16, v7_1, v9);
            v12 = v4_1;
            v6_1 = v5;
            v11 = v9_1;
            v13 = v11;
        }

        if(!MultiWidgetSelectionDelegateKt.isSelected(SelectionLayoutKt.resolve2dDirection(v4_1, v5), v13)) {
            return;
        }

        int v4_2 = v10.getLayoutInput().getText().length();
        if(arg16.isStartHandle()) {
            v0_1 = MultiWidgetSelectionDelegateKt.getOffsetForPosition-3MmeM6k(v0, v10);
            Selection v1 = arg16.getPreviousSelection();
            if(v1 != null) {
                AnchorInfo v1_1 = v1.getEnd();
                if(v1_1 != null) {
                    v1_2 = MultiWidgetSelectionDelegateKt.getPreviousAdjustedOffset(v1_1, arg16.getSelectableIdOrderingComparator(), v7_1, v4_2);
                    goto label_80;
                }
            }

            v1_2 = v0_1;
        }
        else {
            v1_2 = MultiWidgetSelectionDelegateKt.getOffsetForPosition-3MmeM6k(v0, v10);
            Selection v0_2 = arg16.getPreviousSelection();
            if(v0_2 != null) {
                AnchorInfo v0_3 = v0_2.getStart();
                if(v0_3 != null) {
                    v0_1 = MultiWidgetSelectionDelegateKt.getPreviousAdjustedOffset(v0_3, arg16.getSelectableIdOrderingComparator(), v7_1, v4_2);
                    goto label_80;
                }
            }

            v0_1 = v1_2;
        }

    label_80:
        int v2_1 = (0x7FFFFFFF7FFFFFFFL & v2) == 0x7FC000007FC00000L ? -1 : MultiWidgetSelectionDelegateKt.getOffsetForPosition-3MmeM6k(v2, v10);
        arg16.appendInfo(v7_1, v0_1, v11, v9_1, v1_2, v12, v6_1, v2_1, v10);
    }

    private static final Direction appendSelectableInfo_Parwq6A$otherDirection(Direction arg2, Direction arg3, SelectionLayoutBuilder arg4, long arg5, AnchorInfo arg7) {
        if(arg7 != null) {
            Direction v4 = MultiWidgetSelectionDelegateKt.getDirectionById(arg4, arg7.getSelectableId(), arg5);
            if(v4 == null) {
            }
            else {
                return v4;
            }
        }

        return SelectionLayoutKt.resolve2dDirection(arg2, arg3);
    }

    private static final Direction getDirectionById(SelectionLayoutBuilder arg0, long arg1, long arg3) {
        int v0 = arg0.getSelectableIdOrderingComparator().compare(Long.valueOf(arg1), Long.valueOf(arg3));
        if(v0 < 0) {
            return Direction.BEFORE;
        }

        if(v0 > 0) {
            return Direction.AFTER;
        }

        return Direction.ON;
    }

    private static final int getOffsetForPosition-3MmeM6k(long arg3, TextLayoutResult arg5) {
        int v0 = ((int)(0xFFFFFFFFL & arg3));
        if(Float.intBitsToFloat(v0) <= 0f) {
            return 0;
        }

        if(Float.intBitsToFloat(v0) >= arg5.getMultiParagraph().getHeight()) {
            return arg5.getLayoutInput().getText().length();
        }

        return arg5.getOffsetForPosition-k-4lQ0M(arg3);
    }

    private static final int getPreviousAdjustedOffset(AnchorInfo arg2, Comparator arg3, long arg4, int arg6) {
        int v3 = arg3.compare(Long.valueOf(arg2.getSelectableId()), Long.valueOf(arg4));
        if(v3 < 0) {
            return 0;
        }

        if(v3 > 0) {
            return arg6;
        }

        return arg2.getOffset();
    }

    private static final Direction getXDirection-3MmeM6k(long arg1, Rect arg3) {
        int v1 = ((int)(arg1 >> 0x20));
        if(Float.intBitsToFloat(v1) < arg3.getLeft()) {
            return Direction.BEFORE;
        }

        if(Float.intBitsToFloat(v1) > arg3.getRight()) {
            return Direction.AFTER;
        }

        return Direction.ON;
    }

    private static final Direction getYDirection-3MmeM6k(long arg2, Rect arg4) {
        int v2 = ((int)(arg2 & 0xFFFFFFFFL));
        if(Float.intBitsToFloat(v2) < arg4.getTop()) {
            return Direction.BEFORE;
        }

        if(Float.intBitsToFloat(v2) > arg4.getBottom()) {
            return Direction.AFTER;
        }

        return Direction.ON;
    }

    private static final boolean isSelected(Direction arg1, Direction arg2) {
        if(arg1 != Direction.ON) {
            if(arg1 != arg2) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }
}

