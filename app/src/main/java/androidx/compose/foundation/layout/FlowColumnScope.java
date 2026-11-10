package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;

@LayoutScopeMarker @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001A\u00020\u0003*\u00020\u00032\b\b\u0003\u0010\u0004\u001A\u00020\u0005H\'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2={"Landroidx/compose/foundation/layout/FlowColumnScope;", "Landroidx/compose/foundation/layout/ColumnScope;", "fillMaxColumnWidth", "Landroidx/compose/ui/Modifier;", "fraction", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public interface FlowColumnScope extends ColumnScope {
    Modifier fillMaxColumnWidth(Modifier arg1, float arg2);

    static Modifier fillMaxColumnWidth$default(FlowColumnScope arg0, Modifier arg1, float arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 1) != 0) {
                arg2 = 1f;
            }

            return arg0.fillMaxColumnWidth(arg1, arg2);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fillMaxColumnWidth");
    }
}

