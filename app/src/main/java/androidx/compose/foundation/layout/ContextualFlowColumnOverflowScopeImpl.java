package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001A\u00020\b*\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0097\u0001J\u0015\u0010\u000B\u001A\u00020\b*\u00020\b2\u0006\u0010\f\u001A\u00020\rH\u0097\u0001J!\u0010\u000B\u001A\u00020\b*\u00020\b2\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000FH\u0097\u0001J\u0017\u0010\u0012\u001A\u00020\b*\u00020\b2\b\b\u0001\u0010\u0013\u001A\u00020\u0014H\u0097\u0001J\u001F\u0010\u0015\u001A\u00020\b*\u00020\b2\b\b\u0001\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0016\u001A\u00020\u0017H\u0097\u0001R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001A\u00020\u00118\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001AR\u0014\u0010\u001B\u001A\u00020\u00118\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001A¨\u0006\u001D"}, d2={"Landroidx/compose/foundation/layout/ContextualFlowColumnOverflowScopeImpl;", "Landroidx/compose/foundation/layout/FlowColumnOverflowScope;", "Landroidx/compose/foundation/layout/ContextualFlowColumnOverflowScope;", "state", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "<init>", "(Landroidx/compose/foundation/layout/FlowLayoutOverflowState;)V", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "alignBy", "alignmentLine", "Landroidx/compose/ui/layout/VerticalAlignmentLine;", "alignmentLineBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "", "fillMaxColumnWidth", "fraction", "", "weight", "fill", "", "shownItemCount", "getShownItemCount", "()I", "totalItemCount", "getTotalItemCount", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ContextualFlowColumnOverflowScopeImpl implements ContextualFlowColumnOverflowScope, FlowColumnOverflowScope {
    public static final int $stable;
    private final FlowLayoutOverflowState state;

    static {
    }

    public ContextualFlowColumnOverflowScopeImpl(FlowLayoutOverflowState arg2) {
        super();
        this.$$delegate_0 = new FlowColumnOverflowScopeImpl(arg2);
        this.state = arg2;
    }

    public Modifier align(Modifier arg1, Horizontal arg2) {
        return this.$$delegate_0.align(arg1, arg2);
    }

    public Modifier alignBy(Modifier arg1, VerticalAlignmentLine arg2) {
        return this.$$delegate_0.alignBy(arg1, arg2);
    }

    public Modifier alignBy(Modifier arg1, Function1 arg2) {
        return this.$$delegate_0.alignBy(arg1, arg2);
    }

    public Modifier fillMaxColumnWidth(Modifier arg1, float arg2) {
        return this.$$delegate_0.fillMaxColumnWidth(arg1, arg2);
    }

    public int getShownItemCount() {
        return this.$$delegate_0.getShownItemCount();
    }

    public int getTotalItemCount() {
        return this.$$delegate_0.getTotalItemCount();
    }

    public Modifier weight(Modifier arg1, float arg2, boolean arg3) {
        return this.$$delegate_0.weight(arg1, arg2, arg3);
    }
}

