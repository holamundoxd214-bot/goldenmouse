package androidx.compose.material3;

import androidx.compose.ui.layout.Measurable;
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
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001A\u00020\u0005*\u00020\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000E"}, d2={"Landroidx/compose/material3/CenteredContentMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "<init>", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class CenteredContentMeasurePolicy implements MeasurePolicy {
    public CenteredContentMeasurePolicy() {
        super();
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg17, List arg18, long arg19) {
        int v7;
        ArrayList v1_1;
        List v0 = arg18;
        int v3 = Constraints.getMaxWidth-impl(arg19);
        long v4 = arg19;
        int v2 = Constraints.getMinHeight-impl(v4);
        int v1 = v0.size();
        if(v1 < 1) {
            return MeasureScope.layout$default(arg17, v3, v2, null, new CenteredContentMeasurePolicy$$ExternalSyntheticLambda0(), 4, null);
        }

        IntRef v6 = new IntRef();
        int v8 = 0;
        if(!Constraints.getHasBoundedWidth-impl(v4)) {
            v1_1 = new ArrayList(v0.size());
            v7 = v0.size();
            while(v8 < v7) {
                v1_1.add(v0.get(v8).measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(v4, Constraints.Companion.fixedHeight-OenEA2s(v2))));
                ++v8;
            }
        }
        else {
            v7 = v3 / v1;
            v6.element = ShortNavigationBarKt.access$calculateCenteredContentHorizontalPadding(v1, v3);
            int v9 = (v3 - v6.element * 2) / v1;
            List v1_2 = v0;
            int v10 = ((Collection)v1_2).size();
            int v11;
            for(v11 = 0; v11 < v10; ++v11) {
                int v12 = v0.get(v11).maxIntrinsicHeight(v9);
                if(v2 < v12) {
                    v2 = RangesKt.coerceAtMost(v12, Constraints.getMaxHeight-impl(v4));
                }
            }

            ArrayList v10_1 = new ArrayList(v0.size());
            v1 = ((Collection)v1_2).size();
            while(v8 < v1) {
                Object v11_1 = v0.get(v8);
                ArrayList v12_1 = v10_1;
                int v13 = ((Measurable)v11_1).maxIntrinsicWidth(Constraints.getMinHeight-impl(v4));
                if(v9 < v13) {
                    v13 = RangesKt.coerceAtMost(v13, v7);
                    v6.element -= (v13 - v9) / 2;
                }
                else {
                    v13 = v9;
                }

                ((Collection)v12_1).add(((Measurable)v11_1).measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(v4, Constraints.Companion.fixed-JhjzzOo(v13, v2))));
                ++v8;
            }

            v1_1 = v10_1;
        }

        return MeasureScope.layout$default(arg17, v3, v2, null, new CenteredContentMeasurePolicy$$ExternalSyntheticLambda1(v6, ((List)v1_1)), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$0(PlacementScope arg0) {
        return Unit.INSTANCE;
    }

    static final Unit measure_3p2s80s$lambda$5(IntRef arg9, List arg10, PlacementScope arg11) {
        int v9 = arg9.element;
        int v0 = arg10.size();
        int v1 = 0;
        int v4 = v9;
        while(v1 < v0) {
            Object v3 = arg10.get(v1);
            PlacementScope.placeRelative$default(arg11, ((Placeable)v3), v4, 0, 0f, 4, null);
            v4 += ((Placeable)v3).getWidth();
            ++v1;
        }

        return Unit.INSTANCE;
    }
}

