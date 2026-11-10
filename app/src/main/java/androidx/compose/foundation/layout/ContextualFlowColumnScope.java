package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import kotlin.Deprecated;
import kotlin.Metadata;

@LayoutScopeMarker @Deprecated(message="ContextualFlowLayouts are no longer maintained") @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001A\u00020\u0003*\u00020\u00032\b\b\u0003\u0010\u0004\u001A\u00020\u0005H\'R\u0012\u0010\u0006\u001A\u00020\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0012\u0010\n\u001A\u00020\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\tR\u0012\u0010\f\u001A\u00020\rX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0012\u0010\u0010\u001A\u00020\rX¦\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u000Fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2={"Landroidx/compose/foundation/layout/ContextualFlowColumnScope;", "Landroidx/compose/foundation/layout/ColumnScope;", "fillMaxColumnWidth", "Landroidx/compose/ui/Modifier;", "fraction", "", "lineIndex", "", "getLineIndex", "()I", "indexInLine", "getIndexInLine", "maxWidth", "Landroidx/compose/ui/unit/Dp;", "getMaxWidth-D9Ej5fM", "()F", "maxHeightInLine", "getMaxHeightInLine-D9Ej5fM", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public interface ContextualFlowColumnScope extends ColumnScope {
    Modifier fillMaxColumnWidth(Modifier arg1, float arg2);

    static Modifier fillMaxColumnWidth$default(ContextualFlowColumnScope arg0, Modifier arg1, float arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 1) != 0) {
                arg2 = 1f;
            }

            return arg0.fillMaxColumnWidth(arg1, arg2);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fillMaxColumnWidth");
    }

    int getIndexInLine();

    int getLineIndex();

    float getMaxHeightInLine-D9Ej5fM();

    float getMaxWidth-D9Ej5fM();
}

