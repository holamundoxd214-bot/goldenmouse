package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@LayoutScopeMarker @Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001A\u00020\u0003*\u00020\u00032\b\b\u0001\u0010\u0002\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u0006H\'J\u0014\u0010\u0007\u001A\u00020\u0003*\u00020\u00032\u0006\u0010\b\u001A\u00020\tH\'J\u0014\u0010\n\u001A\u00020\u0003*\u00020\u00032\u0006\u0010\u000B\u001A\u00020\fH\'J \u0010\n\u001A\u00020\u0003*\u00020\u00032\u0012\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u00100\u000EH\'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0003"}, d2={"Landroidx/compose/foundation/layout/ColumnScope;", "", "weight", "Landroidx/compose/ui/Modifier;", "", "fill", "", "align", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "alignBy", "alignmentLine", "Landroidx/compose/ui/layout/VerticalAlignmentLine;", "alignmentLineBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public interface ColumnScope {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        public static Modifier weight$default(ColumnScope arg0, Modifier arg1, float arg2, boolean arg3, int arg4, Object arg5) {
            return ColumnScope.weight$default(arg0, arg1, arg2, arg3, arg4, arg5);
        }
    }

    Modifier align(Modifier arg1, Horizontal arg2);

    Modifier alignBy(Modifier arg1, VerticalAlignmentLine arg2);

    Modifier alignBy(Modifier arg1, Function1 arg2);

    Modifier weight(Modifier arg1, float arg2, boolean arg3);

    static Modifier weight$default(ColumnScope arg0, Modifier arg1, float arg2, boolean arg3, int arg4, Object arg5) {
        if(arg5 == null) {
            return arg0.weight(arg1, arg2, true);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: weight");
    }
}

