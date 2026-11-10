package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Ref$BooleanRef;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001AG\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000BH\u0000¢\u0006\u0004\b\r\u0010\u000E\u001A\u0018\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u0011H\u0000\u001A\u0018\u0010\u0014\u001A\u00020\u000B*\u0004\u0018\u00010\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0001H\u0000\"\u000E\u0010\u000F\u001A\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"getTextFieldSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "rawStartHandleOffset", "", "rawEndHandleOffset", "rawPreviousHandleOffset", "previousSelectionRange", "Landroidx/compose/ui/text/TextRange;", "isStartOfSelection", "", "isStartHandle", "getTextFieldSelectionLayout-RcvT-LA", "(Landroidx/compose/ui/text/TextLayoutResult;IIIJZZ)Landroidx/compose/foundation/text/selection/SelectionLayout;", "UNASSIGNED_SLOT", "resolve2dDirection", "Landroidx/compose/foundation/text/selection/Direction;", "x", "y", "isCollapsed", "Landroidx/compose/foundation/text/selection/Selection;", "layout", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SelectionLayoutKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[Direction.values().length];
            try {
                v0[Direction.BEFORE.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[Direction.ON.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[Direction.AFTER.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                    label_15:
                        WhenMappings.$EnumSwitchMapping$0 = v0;
                        return;
                    }
                }
            }
        }
    }

    public static final int UNASSIGNED_SLOT = -1;

    public static final SelectionLayout getTextFieldSelectionLayout-RcvT-LA(TextLayoutResult arg8, int arg9, int arg10, int arg11, long arg12, boolean arg14, boolean arg15) {
        TextLayoutResult v7 = arg8;
        Selection v12 = arg14 ? null : new Selection(new AnchorInfo(SelectionHelpersKt.getTextDirectionForOffset(v7, TextRange.getStart-impl(arg12)), TextRange.getStart-impl(arg12), 1), new AnchorInfo(SelectionHelpersKt.getTextDirectionForOffset(v7, TextRange.getEnd-impl(arg12)), TextRange.getEnd-impl(arg12), 1), TextRange.getReversed-impl(arg12));
        return new SingleSelectionLayout(arg15, 1, 1, v12, new SelectableInfo(1, 1, arg9, arg10, arg11, v7));
    }

    public static final boolean isCollapsed(Selection arg5, SelectionLayout arg6) {
        if(arg5 == null) {
            return 1;
        }

        if(arg6 == null) {
            return 1;
        }

        if(Long.compare(arg5.getStart().getSelectableId(), arg5.getEnd().getSelectableId()) == 0) {
            if(arg5.getStart().getOffset() == arg5.getEnd().getOffset()) {
                return 1;
            }

            return 0;
        }

        AnchorInfo v1 = arg5.getHandlesCrossed() ? arg5.getStart() : arg5.getEnd();
        if(v1.getOffset() != 0) {
            return 0;
        }

        AnchorInfo v5 = arg5.getHandlesCrossed() ? arg5.getEnd() : arg5.getStart();
        if(arg6.getFirstInfo().getTextLength() != v5.getOffset()) {
            return 0;
        }

        BooleanRef v5_1 = new BooleanRef();
        v5_1.element = true;
        arg6.forEachMiddleInfo(new SelectionLayoutKt$$ExternalSyntheticLambda0(v5_1));
        return v5_1.element;
    }

    static final Unit isCollapsed$lambda$0(BooleanRef arg0, SelectableInfo arg1) {
        if(arg1.getInputText().length() > 0) {
            arg0.element = false;
        }

        return Unit.INSTANCE;
    }

    public static final Direction resolve2dDirection(Direction arg3, Direction arg4) {
        int v4 = WhenMappings.$EnumSwitchMapping$0[arg4.ordinal()];
        if(v4 != 1) {
            int v1 = 3;
            int v2 = 2;
            if(v4 != v2) {
                if(v4 == v1) {
                    return Direction.AFTER;
                }

                throw new NoWhenBranchMatchedException();
            }

            int v3 = WhenMappings.$EnumSwitchMapping$0[arg3.ordinal()];
            if(v3 != 1) {
                if(v3 != v2) {
                    if(v3 == v1) {
                        return Direction.AFTER;
                    }

                    throw new NoWhenBranchMatchedException();
                }

                return Direction.ON;
            }

            return Direction.BEFORE;
        }

        return Direction.BEFORE;
    }
}

