package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode$NoIntrinsicsMeasurePolicy;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001A\u00020\u0005*\u00020\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000E"}, d2={"Landroidx/compose/ui/layout/RootMeasurePolicy;", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "<init>", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RootMeasurePolicy extends NoIntrinsicsMeasurePolicy {
    public static final int $stable;
    public static final RootMeasurePolicy INSTANCE;

    static {
        RootMeasurePolicy.INSTANCE = new RootMeasurePolicy();
    }

    private RootMeasurePolicy() {
        super("Undefined intrinsics block and it is required");
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg12, List arg13, long arg14) {
        int v11 = arg13.size();
        if(v11 != 0) {
            int v1 = 0;
            if(v11 != 1) {
                ArrayList v11_1 = new ArrayList(arg13.size());
                int v0 = arg13.size();
                int v2 = 0;
                int v3 = 0;
                while(v1 < v0) {
                    Placeable v4 = arg13.get(v1).measure-BRTryo0(arg14);
                    v2 = Math.max(v4.getWidth(), v2);
                    v3 = Math.max(v4.getHeight(), v3);
                    v11_1.add(v4);
                    ++v1;
                }

                return MeasureScope.layout$default(arg12, ConstraintsKt.constrainWidth-K40F9xA(arg14, v2), ConstraintsKt.constrainHeight-K40F9xA(arg14, v3), null, new RootMeasurePolicy$measure$3(((List)v11_1)), 4, null);
            }

            Placeable v11_2 = arg13.get(0).measure-BRTryo0(arg14);
            return MeasureScope.layout$default(arg12, ConstraintsKt.constrainWidth-K40F9xA(arg14, v11_2.getWidth()), ConstraintsKt.constrainHeight-K40F9xA(arg14, v11_2.getHeight()), null, new RootMeasurePolicy$measure$2(v11_2), 4, null);
        }

        return MeasureScope.layout$default(arg12, Constraints.getMinWidth-impl(arg14), Constraints.getMinHeight-impl(arg14), null, RootMeasurePolicy$measure$1.INSTANCE, 4, null);
    }
}

