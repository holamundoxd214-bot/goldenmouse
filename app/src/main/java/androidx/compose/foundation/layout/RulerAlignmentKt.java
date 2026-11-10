package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RectRulers;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.math.MathKt;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0012\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003\u001A\u0012\u0010\u0004\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003¨\u0006\u0005"}, d2={"fitInside", "Landroidx/compose/ui/Modifier;", "rulers", "Landroidx/compose/ui/layout/RectRulers;", "fitOutside", "foundation-layout"}, k=2, mv={2, 0, 0}, xi=0x30) public final class RulerAlignmentKt {
    public static Unit $r8$lambda$6Fr_iL4LQOeMMzFMkhVN_Qe62sk(RectRulers arg0, int arg1, int arg2, Measurable arg3, PlacementScope arg4) {
        return RulerAlignmentKt.fitOutside$lambda$0$0(arg0, arg1, arg2, arg3, arg4);
    }

    public static Unit $r8$lambda$6dAWuClm5liOWZwqo7LOsuiEQw8(RectRulers arg0, int arg1, int arg2, Measurable arg3, PlacementScope arg4) {
        return RulerAlignmentKt.fitInside$lambda$0$0(arg0, arg1, arg2, arg3, arg4);
    }

    public static Unit $r8$lambda$R7m-UHxbEOBT10K5UZofhquqleA(Measurable arg0, PlacementScope arg1) {
        return RulerAlignmentKt.fitOutside$lambda$0$1(arg0, arg1);
    }

    public static Unit $r8$lambda$oHPi_HjcMZHs_8u8NEOBU7sMZaQ(RectRulers arg0, int arg1, int arg2, Placeable arg3, PlacementScope arg4) {
        return RulerAlignmentKt.fitInside$lambda$0$1(arg0, arg1, arg2, arg3, arg4);
    }

    public static final Modifier fitInside(Modifier arg1, RectRulers arg2) {
        return LayoutModifierKt.layout(arg1, new RulerAlignmentKt$$ExternalSyntheticLambda4(arg2));
    }

    static final MeasureResult fitInside$lambda$0(RectRulers arg9, MeasureScope arg10, Measurable arg11, Constraints arg12) {
        if((Constraints.getHasBoundedWidth-impl(arg12.unbox-impl())) && (Constraints.getHasBoundedHeight-impl(arg12.unbox-impl()))) {
            int v3 = Constraints.getMaxWidth-impl(arg12.unbox-impl());
            int v4 = Constraints.getMaxHeight-impl(arg12.unbox-impl());
            return MeasureScope.layout$default(arg10, v3, v4, null, new RulerAlignmentKt$$ExternalSyntheticLambda0(arg9, v3, v4, arg11), 4, null);
        }

        MeasureScope v0 = arg10;
        Placeable v10 = arg11.measure-BRTryo0(arg12.unbox-impl());
        int v1 = v10.getWidth();
        int v2 = v10.getHeight();
        return MeasureScope.layout$default(v0, v1, v2, null, new RulerAlignmentKt$$ExternalSyntheticLambda1(arg9, v1, v2, v10), 4, null);
    }

    private static final Unit fitInside$lambda$0$0(RectRulers arg10, int arg11, int arg12, Measurable arg13, PlacementScope arg14) {
        int v0 = MathKt.roundToInt(arg14.current(arg10.getLeft(), 0f));
        int v2 = 0;
        if(v0 < 0) {
            v0 = 0;
        }

        int v5 = v0 > arg11 ? arg11 : v0;
        v0 = MathKt.roundToInt(arg14.current(arg10.getTop(), 0f));
        if(v0 < 0) {
            v0 = 0;
        }

        int v6 = v0 > arg12 ? arg12 : v0;
        v0 = MathKt.roundToInt(arg14.current(arg10.getRight(), ((float)arg11)));
        if(v0 < 0) {
            v0 = 0;
        }

        if(v0 > arg11) {
        }
        else {
            arg11 = v0;
        }

        int v10 = MathKt.roundToInt(arg14.current(arg10.getBottom(), ((float)arg12)));
        if(v10 < 0) {
        }
        else {
            v2 = v10;
        }

        if(v2 > arg12) {
        }
        else {
            arg12 = v2;
        }

        PlacementScope.place$default(arg14, arg13.measure-BRTryo0(Constraints.Companion.fixed-JhjzzOo(arg11 - v5, arg12 - v6)), v5, v6, 0f, 4, null);
        return Unit.INSTANCE;
    }

    private static final Unit fitInside$lambda$0$1(RectRulers arg10, int arg11, int arg12, Placeable arg13, PlacementScope arg14) {
        int v0 = MathKt.roundToInt(arg14.current(arg10.getLeft(), 0f));
        int v2 = 0;
        if(v0 < 0) {
            v0 = 0;
        }

        if(v0 > arg11) {
            v0 = arg11;
        }

        int v1 = MathKt.roundToInt(arg14.current(arg10.getTop(), 0f));
        if(v1 < 0) {
            v1 = 0;
        }

        if(v1 > arg12) {
            v1 = arg12;
        }

        int v3 = MathKt.roundToInt(arg14.current(arg10.getRight(), ((float)arg11)));
        if(v3 < 0) {
            v3 = 0;
        }

        if(v3 > arg11) {
            v3 = arg11;
        }

        int v10 = MathKt.roundToInt(arg14.current(arg10.getBottom(), ((float)arg12)));
        if(v10 < 0) {
        }
        else {
            v2 = v10;
        }

        if(v2 > arg12) {
            v2 = arg12;
        }

        PlacementScope.place$default(arg14, arg13, (v0 + v3 - arg11) / 2, (v1 + v2 - arg12) / 2, 0f, 4, null);
        return Unit.INSTANCE;
    }

    public static final Modifier fitOutside(Modifier arg1, RectRulers arg2) {
        return LayoutModifierKt.layout(arg1, new RulerAlignmentKt$$ExternalSyntheticLambda5(arg2));
    }

    static final MeasureResult fitOutside$lambda$0(RectRulers arg9, MeasureScope arg10, Measurable arg11, Constraints arg12) {
        if((Constraints.getHasBoundedWidth-impl(arg12.unbox-impl())) && (Constraints.getHasBoundedHeight-impl(arg12.unbox-impl()))) {
            int v3 = Constraints.getMaxWidth-impl(arg12.unbox-impl());
            int v4 = Constraints.getMaxHeight-impl(arg12.unbox-impl());
            return MeasureScope.layout$default(arg10, v3, v4, null, new RulerAlignmentKt$$ExternalSyntheticLambda2(arg9, v3, v4, arg11), 4, null);
        }

        return MeasureScope.layout$default(arg10, 0, 0, null, new RulerAlignmentKt$$ExternalSyntheticLambda3(arg11), 4, null);
    }

    private static final Unit fitOutside$lambda$0$0(RectRulers arg11, int arg12, int arg13, Measurable arg14, PlacementScope arg15) {
        int v7;
        int v6;
        int v0 = MathKt.roundToInt(arg15.current(arg11.getLeft(), 0f));
        int v1 = MathKt.roundToInt(arg15.current(arg11.getTop(), 0f));
        int v2 = MathKt.roundToInt(arg15.current(arg11.getRight(), ((float)arg12)));
        int v11 = MathKt.roundToInt(arg15.current(arg11.getBottom(), ((float)arg13)));
        if(v0 > 0) {
            arg12 = v0;
            goto label_18;
        }
        else if(v1 > 0) {
            arg13 = v1;
        label_18:
            v6 = 0;
            goto label_19;
        }
        else if(v2 < arg12) {
            arg12 -= v2;
            v6 = v2;
            v7 = 0;
        }
        else if(v11 < arg13) {
            arg13 -= v11;
            v7 = v11;
            v6 = 0;
        }
        else {
            arg12 = 0;
            arg13 = 0;
            v6 = 0;
        label_19:
            v7 = v6;
        }

        PlacementScope.place$default(arg15, arg14.measure-BRTryo0(Constraints.Companion.fixed-JhjzzOo(arg12, arg13)), v6, v7, 0f, 4, null);
        return Unit.INSTANCE;
    }

    private static final Unit fitOutside$lambda$0$1(Measurable arg9, PlacementScope arg10) {
        PlacementScope.place$default(arg10, arg9.measure-BRTryo0(Constraints.Companion.fixed-JhjzzOo(0, 0)), 0, 0, 0f, 4, null);
        return Unit.INSTANCE;
    }
}

