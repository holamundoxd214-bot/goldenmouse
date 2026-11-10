package androidx.compose.material3;

import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001A\u00020\u0005*\u00020\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000E"}, d2={"Landroidx/compose/material3/EqualWeightContentMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "<init>", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class EqualWeightContentMeasurePolicy implements MeasurePolicy {
    public EqualWeightContentMeasurePolicy() {
        super();
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg10, List arg11, long arg12) {
        int v10;
        ArrayList v9_1;
        int v1 = Constraints.getMaxWidth-impl(arg12);
        int v2 = Constraints.getMinHeight-impl(arg12);
        int v9 = arg11.size();
        if(v9 < 1) {
            return MeasureScope.layout$default(arg10, v1, v2, null, new EqualWeightContentMeasurePolicy$$ExternalSyntheticLambda0(), 4, null);
        }

        MeasureScope v0 = arg10;
        int v3 = 0;
        if(!Constraints.getHasBoundedWidth-impl(arg12)) {
            v9_1 = new ArrayList(arg11.size());
            v10 = arg11.size();
            while(v3 < v10) {
                v9_1.add(arg11.get(v3).measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(arg12, Constraints.Companion.fixedHeight-OenEA2s(v2))));
                ++v3;
            }
        }
        else {
            v9 = v1 / v9;
            List v10_1 = arg11;
            int v4 = ((Collection)v10_1).size();
            int v5;
            for(v5 = 0; v5 < v4; ++v5) {
                int v6 = arg11.get(v5).maxIntrinsicHeight(v9);
                if(v2 < v6) {
                    v2 = RangesKt.coerceAtMost(v6, Constraints.getMaxHeight-impl(arg12));
                }
            }

            ArrayList v4_1 = new ArrayList(arg11.size());
            v10 = ((Collection)v10_1).size();
            while(v3 < v10) {
                v4_1.add(arg11.get(v3).measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(arg12, Constraints.Companion.fixed-JhjzzOo(v9, v2))));
                ++v3;
            }

            v9_1 = v4_1;
        }

        return MeasureScope.layout$default(v0, v1, v2, null, new EqualWeightContentMeasurePolicy$$ExternalSyntheticLambda1(((List)v9_1)), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$0(PlacementScope arg0) {
        return Unit.INSTANCE;
    }

    static final Unit measure_3p2s80s$lambda$5(List arg9, PlacementScope arg10) {
        int v0 = arg9.size();
        int v1 = 0;
        int v4 = 0;
        while(v1 < v0) {
            Object v3 = arg9.get(v1);
            PlacementScope.placeRelative$default(arg10, ((Placeable)v3), v4, 0, 0f, 4, null);
            v4 += ((Placeable)v3).getWidth();
            ++v1;
            arg10 = arg10;
        }

        return Unit.INSTANCE;
    }
}

