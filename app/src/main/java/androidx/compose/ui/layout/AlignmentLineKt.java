package androidx.compose.ui.layout;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\u001C\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0001H\u0000\"\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0011\u0010\t\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\b¨\u0006\u000B"}, d2={"merge", "", "Landroidx/compose/ui/layout/AlignmentLine;", "position1", "position2", "FirstBaseline", "Landroidx/compose/ui/layout/HorizontalAlignmentLine;", "getFirstBaseline", "()Landroidx/compose/ui/layout/HorizontalAlignmentLine;", "LastBaseline", "getLastBaseline", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AlignmentLineKt {
    private static final HorizontalAlignmentLine FirstBaseline;
    private static final HorizontalAlignmentLine LastBaseline;

    static {
        AlignmentLineKt.FirstBaseline = new HorizontalAlignmentLine(AlignmentLineKt$FirstBaseline$1.INSTANCE);
        AlignmentLineKt.LastBaseline = new HorizontalAlignmentLine(AlignmentLineKt$LastBaseline$1.INSTANCE);
    }

    public static final HorizontalAlignmentLine getFirstBaseline() {
        return AlignmentLineKt.FirstBaseline;
    }

    public static final HorizontalAlignmentLine getLastBaseline() {
        return AlignmentLineKt.LastBaseline;
    }

    public static final int merge(AlignmentLine arg0, int arg1, int arg2) {
        return arg0.getMerger$ui().invoke(Integer.valueOf(arg1), Integer.valueOf(arg2)).intValue();
    }
}

