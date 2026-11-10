package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001C\u0010\u0004\u001A\u00020\u0005*\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0017J\u0014\u0010\t\u001A\u00020\u0005*\u00020\u00052\u0006\u0010\n\u001A\u00020\u000BH\u0017J\u0014\u0010\f\u001A\u00020\u0005*\u00020\u00052\u0006\u0010\r\u001A\u00020\u000EH\u0017J \u0010\f\u001A\u00020\u0005*\u00020\u00052\u0012\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010H\u0017¨\u0006\u0013"}, d2={"Landroidx/compose/foundation/layout/ColumnScopeInstance;", "Landroidx/compose/foundation/layout/ColumnScope;", "<init>", "()V", "weight", "Landroidx/compose/ui/Modifier;", "", "fill", "", "align", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "alignBy", "alignmentLine", "Landroidx/compose/ui/layout/VerticalAlignmentLine;", "alignmentLineBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ColumnScopeInstance implements ColumnScope {
    public static final int $stable;
    public static final ColumnScopeInstance INSTANCE;

    static {
        ColumnScopeInstance.INSTANCE = new ColumnScopeInstance();
    }

    private ColumnScopeInstance() {
        super();
    }

    public Modifier align(Modifier arg1, Horizontal arg2) {
        return arg1.then(new HorizontalAlignElement(arg2));
    }

    public Modifier alignBy(Modifier arg1, VerticalAlignmentLine arg2) {
        return arg1.then(new WithAlignmentLineElement(((AlignmentLine)arg2)));
    }

    public Modifier alignBy(Modifier arg1, Function1 arg2) {
        return arg1.then(new WithAlignmentLineBlockElement(arg2));
    }

    public Modifier weight(Modifier arg5, float arg6, boolean arg7) {
        int v4 = (((double)arg6)) > 0 ? 1 : 0;
        if(v4 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
        }

        return arg5.then(new LayoutWeightElement(RangesKt.coerceAtMost(arg6, 3.402823E+38f), arg7));
    }
}

