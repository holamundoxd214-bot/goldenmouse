package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\u0010\u0005\u001A\u0012\u0012\u000E\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00060\u0003¢\u0006\u0004\b\b\u0010\tJ)\u0010\n\u001A\u00020\u000B*\u00020\f2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000E0\u00062\u0006\u0010\u000F\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\u0005\u001A\u0012\u0012\u000E\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Landroidx/compose/foundation/text/TextMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "shouldMeasureLinks", "Lkotlin/Function0;", "", "placements", "", "Landroidx/compose/ui/geometry/Rect;", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class TextMeasurePolicy implements MeasurePolicy {
    private final Function0 placements;
    private final Function0 shouldMeasureLinks;

    public TextMeasurePolicy(Function0 arg1, Function0 arg2) {
        super();
        this.shouldMeasureLinks = arg1;
        this.placements = arg2;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg21, List arg22, long arg23) {
        List v6_1;
        int v9;
        ArrayList v7_1;
        TextMeasurePolicy v0 = this;
        List v1 = arg22;
        ArrayList v2 = new ArrayList(v1.size());
        List v3 = v1;
        int v4 = ((Collection)v3).size();
        int v6;
        for(v6 = 0; v6 < v4; ++v6) {
            Object v7 = v1.get(v6);
            if(!(v7.getParentData() instanceof TextRangeLayoutModifier)) {
                v2.add(v7);
            }
        }

        Object v4_1 = v0.placements.invoke();
        if(v4_1 != null) {
            v7_1 = new ArrayList(((List)v4_1).size());
            int v8 = v4_1.size();
            v9 = 0;
            goto label_27;
        }
        else {
            v6_1 = null;
            goto label_77;
        label_27:
            while(v9 < v8) {
                Object v10 = ((List)v4_1).get(v9);
                Pair v11 = v10 != null ? new Pair(((List)v2).get(v9).measure-BRTryo0(ConstraintsKt.Constraints$default(0, ((int)(((float)Math.floor(((double)(((Rect)v10).getRight() - ((Rect)v10).getLeft())))))), 0, ((int)(((float)Math.floor(((double)(((Rect)v10).getBottom() - ((Rect)v10).getTop())))))), 5, null)), IntOffset.box-impl(IntOffset.constructor-impl((((long)Math.round(((Rect)v10).getTop()))) & 0xFFFFFFFFL | (((long)Math.round(((Rect)v10).getLeft()))) << 0x20))) : null;
                if(v11 != null) {
                    v7_1.add(v11);
                }

                ++v9;
            }

            ArrayList v6_2 = v7_1;
        }

    label_77:
        v2 = new ArrayList(v1.size());
        int v3_1 = ((Collection)v3).size();
        int v5;
        for(v5 = 0; v5 < v3_1; ++v5) {
            v4_1 = v1.get(v5);
            if((v4_1.getParentData() instanceof TextRangeLayoutModifier)) {
                v2.add(v4_1);
            }
        }

        return MeasureScope.layout$default(arg21, Constraints.getMaxWidth-impl(arg23), Constraints.getMaxHeight-impl(arg23), null, new TextMeasurePolicy$$ExternalSyntheticLambda0(v6_1, BasicTextKt.measureWithTextRangeMeasureConstraints(((List)v2), v0.shouldMeasureLinks)), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$3(List arg21, List arg22, PlacementScope arg23) {
        List v0 = arg21;
        List v1 = arg22;
        int v2 = 0;
        if(v0 != null) {
            int v3 = v0.size();
            int v4;
            for(v4 = 0; v4 < v3; ++v4) {
                Object v5 = v0.get(v4);
                PlacementScope.place-70tqf50$default(arg23, ((Pair)v5).component1(), ((Pair)v5).component2().unbox-impl(), 0f, 2, null);
            }
        }

        if(v1 != null) {
            int v0_1 = v1.size();
            while(v2 < v0_1) {
                Object v3_1 = v1.get(v2);
                Object v15 = ((Pair)v3_1).component1();
                v3_1 = ((Pair)v3_1).component2();
                long v3_2 = v3_1 != null ? ((Function0)v3_1).invoke().unbox-impl() : IntOffset.Companion.getZero-nOcc-ac();
                PlacementScope.place-70tqf50$default(arg23, ((Placeable)v15), v3_2, 0f, 2, null);
                ++v2;
            }
        }

        return Unit.INSTANCE;
    }
}

