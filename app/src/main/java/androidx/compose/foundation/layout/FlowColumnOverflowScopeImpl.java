package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0010\u001A\u00020\u0011*\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013H\u0097\u0001J\u0015\u0010\u0014\u001A\u00020\u0011*\u00020\u00112\u0006\u0010\u0015\u001A\u00020\u0016H\u0097\u0001J!\u0010\u0014\u001A\u00020\u0011*\u00020\u00112\u0012\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\b0\u0018H\u0097\u0001J\u0017\u0010\u001A\u001A\u00020\u0011*\u00020\u00112\b\b\u0001\u0010\u001B\u001A\u00020\u001CH\u0097\u0001J\u001F\u0010\u001D\u001A\u00020\u0011*\u00020\u00112\b\b\u0001\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001E\u001A\u00020\u001FH\u0097\u0001R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001B\u0010\u0007\u001A\u00020\b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\t\u0010\nR\u001B\u0010\r\u001A\u00020\b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000F\u0010\f\u001A\u0004\b\u000E\u0010\n¨\u0006 "}, d2={"Landroidx/compose/foundation/layout/FlowColumnOverflowScopeImpl;", "Landroidx/compose/foundation/layout/FlowColumnScope;", "Landroidx/compose/foundation/layout/FlowColumnOverflowScope;", "state", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "<init>", "(Landroidx/compose/foundation/layout/FlowLayoutOverflowState;)V", "totalItemCount", "", "getTotalItemCount", "()I", "totalItemCount$delegate", "Lkotlin/Lazy;", "shownItemCount", "getShownItemCount", "shownItemCount$delegate", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "alignBy", "alignmentLine", "Landroidx/compose/ui/layout/VerticalAlignmentLine;", "alignmentLineBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "fillMaxColumnWidth", "fraction", "", "weight", "fill", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FlowColumnOverflowScopeImpl implements FlowColumnOverflowScope, FlowColumnScope {
    public static final int $stable;
    private final Lazy shownItemCount$delegate;
    private final FlowLayoutOverflowState state;
    private final Lazy totalItemCount$delegate;

    static {
    }

    public FlowColumnOverflowScopeImpl(FlowLayoutOverflowState arg4) {
        super();
        this.$$delegate_0 = FlowColumnScopeInstance.INSTANCE;
        this.state = arg4;
        this.totalItemCount$delegate = FlowLayoutOverflowKt.lazyInt$default(null, new FlowColumnOverflowScopeImpl$$ExternalSyntheticLambda0(this), 1, null);
        this.shownItemCount$delegate = FlowLayoutOverflowKt.lazyInt(arg4.getShownItemLazyErrorMessage$foundation_layout(), new FlowColumnOverflowScopeImpl$$ExternalSyntheticLambda1(this));
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
        return this.shownItemCount$delegate.getValue().intValue();
    }

    public int getTotalItemCount() {
        return this.totalItemCount$delegate.getValue().intValue();
    }

    static final int shownItemCount_delegate$lambda$0(FlowColumnOverflowScopeImpl arg0) {
        return arg0.state.getItemShown$foundation_layout();
    }

    static final int totalItemCount_delegate$lambda$0(FlowColumnOverflowScopeImpl arg0) {
        return arg0.state.getItemCount$foundation_layout();
    }

    public Modifier weight(Modifier arg1, float arg2, boolean arg3) {
        return this.$$delegate_0.weight(arg1, arg2, arg3);
    }
}

