package androidx.compose.material3;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000B\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0097\u0001J\u0015\u0010\n\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\u000B\u001A\u00020\fH\u0097\u0001J!\u0010\n\u001A\u00020\u0007*\u00020\u00072\u0012\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u00100\u000EH\u0097\u0001J\r\u0010\u0011\u001A\u00020\u0007*\u00020\u0007H\u0097\u0001J\u001F\u0010\u0012\u001A\u00020\u0007*\u00020\u00072\b\b\u0001\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0015H\u0097\u0001¨\u0006\u0016"}, d2={"Landroidx/compose/material3/MultiChoiceSegmentedButtonScopeWrapper;", "Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;", "Landroidx/compose/foundation/layout/RowScope;", "scope", "<init>", "(Landroidx/compose/foundation/layout/RowScope;)V", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment$Vertical;", "alignBy", "alignmentLine", "Landroidx/compose/ui/layout/HorizontalAlignmentLine;", "alignmentLineBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "", "alignByBaseline", "weight", "", "fill", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class MultiChoiceSegmentedButtonScopeWrapper implements RowScope, MultiChoiceSegmentedButtonRowScope {
    public MultiChoiceSegmentedButtonScopeWrapper(RowScope arg1) {
        super();
        this.$$delegate_0 = arg1;
    }

    public Modifier align(Modifier arg1, Vertical arg2) {
        return this.$$delegate_0.align(arg1, arg2);
    }

    public Modifier alignBy(Modifier arg1, HorizontalAlignmentLine arg2) {
        return this.$$delegate_0.alignBy(arg1, arg2);
    }

    public Modifier alignBy(Modifier arg1, Function1 arg2) {
        return this.$$delegate_0.alignBy(arg1, arg2);
    }

    public Modifier alignByBaseline(Modifier arg1) {
        return this.$$delegate_0.alignByBaseline(arg1);
    }

    public Modifier weight(Modifier arg1, float arg2, boolean arg3) {
        return this.$$delegate_0.weight(arg1, arg2, arg3);
    }
}

