package androidx.compose.material3;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Dp;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001A\u00020\u000B*\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\t2\u0006\u0010\u0016\u001A\u00020\u0017H\u0002J\u0014\u0010\u0018\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0002R\u001C\u0010\u0006\u001A\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2={"Landroidx/compose/material3/MinimumInteractiveModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "<init>", "()V", "alignmentLinesCache", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "updateAlignmentLines", "", "sizePx", "placeable", "Landroidx/compose/ui/layout/Placeable;", "getAlignmentLinesCache", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MinimumInteractiveModifierNode extends Node implements CompositionLocalConsumerModifierNode, LayoutModifierNode {
    public static final int $stable = 8;
    private Map alignmentLinesCache;

    static {
    }

    public MinimumInteractiveModifierNode() {
        super();
    }

    private final Map getAlignmentLinesCache() {
        LinkedHashMap v0_1;
        Map v0 = this.alignmentLinesCache;
        if(v0 == null) {
            v0_1 = new LinkedHashMap(2);
            this.alignmentLinesCache = ((Map)v0_1);
        }

        return ((Map)v0_1);
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg4, Measurable arg5, long arg6) {
        float v0 = Dp.constructor-impl(RangesKt.coerceAtLeast(CompositionLocalConsumerModifierNodeKt.currentValueOf(this, InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize()).unbox-impl(), Dp.constructor-impl(0f)));
        Placeable v5 = arg5.measure-BRTryo0(arg6);
        int v7 = 0;
        int v6 = !this.isAttached() || (Float.isNaN(v0)) || Dp.compareTo-0680j_4(v0, Dp.constructor-impl(0f)) <= 0 ? 0 : 1;
        if(!Float.isNaN(v0)) {
            v7 = arg4.roundToPx-0680j_4(v0);
        }

        int v0_1 = v6 != 0 ? Math.max(v5.getWidth(), v7) : v5.getWidth();
        int v1 = v6 != 0 ? Math.max(v5.getHeight(), v7) : v5.getHeight();
        if(v6 != 0) {
            this.updateAlignmentLines(v7, v5);
        }

        Map v3 = this.alignmentLinesCache;
        if(v3 == null) {
            v3 = MapsKt.emptyMap();
        }

        return arg4.layout(v0_1, v1, v3, new MinimumInteractiveModifierNode$$ExternalSyntheticLambda0(v0_1, v5, v1));
    }

    static final Unit measure_3p2s80s$lambda$0(int arg8, Placeable arg9, int arg10, PlacementScope arg11) {
        PlacementScope.place$default(arg11, arg9, MathKt.roundToInt((((float)(arg8 - arg9.getWidth()))) / 2f), MathKt.roundToInt((((float)(arg10 - arg9.getHeight()))) / 2f), 0f, 4, null);
        return Unit.INSTANCE;
    }

    private final void updateAlignmentLines(int arg5, Placeable arg6) {
        Map v4 = this.getAlignmentLinesCache();
        v4.put(InteractiveComponentSizeKt.getMinimumInteractiveLeftAlignmentLine(), Integer.valueOf(RangesKt.coerceAtLeast(Math.round((((float)(arg5 - arg6.getWidth()))) / 2f), 0)));
        v4.put(InteractiveComponentSizeKt.getMinimumInteractiveTopAlignmentLine(), Integer.valueOf(RangesKt.coerceAtLeast(Math.round((((float)(arg5 - arg6.getHeight()))) / 2f), 0)));
    }
}

