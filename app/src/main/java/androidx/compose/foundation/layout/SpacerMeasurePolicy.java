package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001A\u00020\u0005*\u00020\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000E"}, d2={"Landroidx/compose/foundation/layout/SpacerMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "<init>", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class SpacerMeasurePolicy implements MeasurePolicy {
    public static final SpacerMeasurePolicy INSTANCE;

    public static Unit $r8$lambda$ywg-eqa5EIt9FI3EVBH1DBJX5yY(PlacementScope arg0) {
        return SpacerMeasurePolicy.measure_3p2s80s$lambda$0$0(arg0);
    }

    static {
        SpacerMeasurePolicy.INSTANCE = new SpacerMeasurePolicy();
    }

    private SpacerMeasurePolicy() {
        super();
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg8, List arg9, long arg10) {
        int v9 = 0;
        int v1 = Constraints.getHasFixedWidth-impl(arg10) ? Constraints.getMaxWidth-impl(arg10) : 0;
        if(Constraints.getHasFixedHeight-impl(arg10)) {
            v9 = Constraints.getMaxHeight-impl(arg10);
        }

        return MeasureScope.layout$default(arg8, v1, v9, null, new SpacerMeasurePolicy$$ExternalSyntheticLambda0(), 4, null);
    }

    private static final Unit measure_3p2s80s$lambda$0$0(PlacementScope arg0) {
        return Unit.INSTANCE;
    }
}

