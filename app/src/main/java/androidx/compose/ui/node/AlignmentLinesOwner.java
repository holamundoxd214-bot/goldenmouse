package androidx.compose.ui.node;

import androidx.compose.ui.layout.Measurable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u000E\u001A\u00020\u000FH&J\u0014\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00030\u0011H&J\u001C\u0010\u0016\u001A\u00020\u000F2\u0012\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000F0\u0018H&J\b\u0010\u0019\u001A\u00020\u000FH&J\b\u0010\u001A\u001A\u00020\u000FH&R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0012\u0010\n\u001A\u00020\u000BX¦\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0014\u0010\u0013\u001A\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001BÀ\u0006\u0001"}, d2={"Landroidx/compose/ui/node/AlignmentLinesOwner;", "Landroidx/compose/ui/layout/Measurable;", "placeOrder", "", "getPlaceOrder", "()I", "innerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getInnerCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "alignmentLines", "Landroidx/compose/ui/node/AlignmentLines;", "getAlignmentLines", "()Landroidx/compose/ui/node/AlignmentLines;", "layoutChildren", "", "calculateAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "parentAlignmentLinesOwner", "getParentAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "forEachChildAlignmentLinesOwner", "block", "Lkotlin/Function1;", "requestLayout", "requestMeasure", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface AlignmentLinesOwner extends Measurable {
    Map calculateAlignmentLines();

    void forEachChildAlignmentLinesOwner(Function1 arg1);

    AlignmentLines getAlignmentLines();

    NodeCoordinator getInnerCoordinator();

    AlignmentLinesOwner getParentAlignmentLinesOwner();

    int getPlaceOrder();

    void layoutChildren();

    void requestLayout();

    void requestMeasure();
}

