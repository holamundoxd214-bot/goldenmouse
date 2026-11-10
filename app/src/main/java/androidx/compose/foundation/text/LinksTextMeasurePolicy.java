package androidx.compose.foundation.text;

import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\u0007\u001A\u00020\b*\u00020\t2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000B2\u0006\u0010\r\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"Landroidx/compose/foundation/text/LinksTextMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "shouldMeasureLinks", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class LinksTextMeasurePolicy implements MeasurePolicy {
    private final Function0 shouldMeasureLinks;

    public LinksTextMeasurePolicy(Function0 arg1) {
        super();
        this.shouldMeasureLinks = arg1;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg8, List arg9, long arg10) {
        return MeasureScope.layout$default(arg8, Constraints.getMaxWidth-impl(arg10), Constraints.getMaxHeight-impl(arg10), null, new LinksTextMeasurePolicy$$ExternalSyntheticLambda0(arg9, this), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$0(List arg10, LinksTextMeasurePolicy arg11, PlacementScope arg12) {
        arg10 = BasicTextKt.measureWithTextRangeMeasureConstraints(arg10, arg11.shouldMeasureLinks);
        if(arg10 != null) {
            int v11 = arg10.size();
            int v0;
            for(v0 = 0; v0 < v11; ++v0) {
                Object v1 = arg10.get(v0);
                Object v4 = ((Pair)v1).component1();
                v1 = ((Pair)v1).component2();
                long v1_1 = v1 != null ? ((Function0)v1).invoke().unbox-impl() : IntOffset.Companion.getZero-nOcc-ac();
                PlacementScope.place-70tqf50$default(arg12, ((Placeable)v4), v1_1, 0f, 2, null);
            }
        }

        return Unit.INSTANCE;
    }
}

