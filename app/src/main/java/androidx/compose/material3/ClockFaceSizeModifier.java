package androidx.compose.material3;

import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0004\u001A\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2={"Landroidx/compose/material3/ClockFaceSizeModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "<init>", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ClockFaceSizeModifier implements LayoutModifier {
    public static final int $stable;

    static {
    }

    public ClockFaceSizeModifier() {
        super();
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg8, Measurable arg9, long arg10) {
        float v7 = arg8.toDp-u2uoSUM(Constraints.getMaxHeight-impl(arg10));
        if(Dp.compareTo-0680j_4(v7, TimePickerKt.access$getTimePickerMaxHeight$p()) >= 0) {
            v7 = TimePickerTokens.INSTANCE.getClockDialContainerSize-D9Ej5fM();
        }
        else if(Dp.compareTo-0680j_4(v7, TimePickerKt.access$getTimePickerMidHeight$p()) >= 0) {
            v7 = TimePickerKt.access$getClockDialMidContainerSize$p();
        }
        else {
            v7 = TimePickerKt.getClockDialMinContainerSize();
        }

        int v7_1 = arg8.roundToPx-0680j_4(v7);
        Placeable v7_2 = arg9.measure-BRTryo0(Constraints.Companion.fixed-JhjzzOo(v7_1, v7_1));
        return MeasureScope.layout$default(arg8, v7_2.getWidth(), v7_2.getHeight(), null, new ClockFaceSizeModifier$$ExternalSyntheticLambda0(v7_2), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$0(Placeable arg7, PlacementScope arg8) {
        PlacementScope.place$default(arg8, arg7, 0, 0, 0f, 4, null);
        return Unit.INSTANCE;
    }
}

