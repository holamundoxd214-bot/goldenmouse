package androidx.compose.material3;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u001A/\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001A/\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\t2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\n\"\u000E\u0010\u000B\u001A\u00020\fX\u0080T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"horizontalCenterOptically", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/foundation/shape/CornerBasedShape;", "maxStartOffset", "Landroidx/compose/ui/unit/Dp;", "maxEndOffset", "horizontalCenterOptically-4j6BHR0", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/shape/CornerBasedShape;FF)Landroidx/compose/ui/Modifier;", "Landroidx/compose/material3/ShapeWithHorizontalCenterOptically;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/ShapeWithHorizontalCenterOptically;FF)Landroidx/compose/ui/Modifier;", "CenterOpticallyCoefficient", "", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class HorizontalCenterOpticallyKt {
    public static final float CenterOpticallyCoefficient = 0.11f;

    public static final Modifier horizontalCenterOptically-4j6BHR0(Modifier arg1, CornerBasedShape arg2, float arg3, float arg4) {
        return LayoutModifierKt.layout(arg1, new HorizontalCenterOpticallyKt$$ExternalSyntheticLambda2(arg3, arg4, arg2));
    }

    public static final Modifier horizontalCenterOptically-4j6BHR0(Modifier arg1, ShapeWithHorizontalCenterOptically arg2, float arg3, float arg4) {
        return LayoutModifierKt.layout(arg1, new HorizontalCenterOpticallyKt$$ExternalSyntheticLambda3(arg3, arg4, arg2));
    }

    public static Modifier horizontalCenterOptically-4j6BHR0$default(Modifier arg1, CornerBasedShape arg2, float arg3, float arg4, int arg5, Object arg6) {
        if((arg5 & 2) != 0) {
            arg3 = Dp.constructor-impl(0f);
        }

        if((arg5 & 4) != 0) {
            arg4 = Dp.constructor-impl(0f);
        }

        return HorizontalCenterOpticallyKt.horizontalCenterOptically-4j6BHR0(arg1, arg2, arg3, arg4);
    }

    public static Modifier horizontalCenterOptically-4j6BHR0$default(Modifier arg1, ShapeWithHorizontalCenterOptically arg2, float arg3, float arg4, int arg5, Object arg6) {
        if((arg5 & 2) != 0) {
            arg3 = Dp.constructor-impl(0f);
        }

        if((arg5 & 4) != 0) {
            arg4 = Dp.constructor-impl(0f);
        }

        return HorizontalCenterOpticallyKt.horizontalCenterOptically-4j6BHR0(arg1, arg2, arg3, arg4);
    }

    static final MeasureResult horizontalCenterOptically_4j6BHR0$lambda$1(float arg9, float arg10, CornerBasedShape arg11, MeasureScope arg12, Measurable arg13, Constraints arg14) {
        Placeable v13 = arg13.measure-BRTryo0(arg14.unbox-impl());
        int v1 = v13.getWidth();
        int v2 = v13.getHeight();
        long v3 = Size.constructor-impl((((long)Float.floatToRawIntBits(((float)v1)))) << 0x20 | (((long)Float.floatToRawIntBits(((float)v2)))) & 0xFFFFFFFFL);
        return MeasureScope.layout$default(arg12, v1, v2, null, new HorizontalCenterOpticallyKt$$ExternalSyntheticLambda1(((arg11.getTopStart().toPx-TmRCtEA(v3, arg12) + arg11.getBottomStart().toPx-TmRCtEA(v3, arg12)) / 2f - (arg11.getTopEnd().toPx-TmRCtEA(v3, arg12) + arg11.getBottomEnd().toPx-TmRCtEA(v3, arg12)) / 2f) * 0.11f, -arg12.toPx-0680j_4(arg9), arg12.toPx-0680j_4(arg10), v13), 4, null);
    }

    static final Unit horizontalCenterOptically_4j6BHR0$lambda$1$lambda$0(float arg7, float arg8, float arg9, Placeable arg10, PlacementScope arg11) {
        PlacementScope.place$default(arg11, arg10, MathKt.roundToInt(RangesKt.coerceIn(arg7, arg8, arg9)), 0, 0f, 4, null);
        return Unit.INSTANCE;
    }

    static final MeasureResult horizontalCenterOptically_4j6BHR0$lambda$3(float arg7, float arg8, ShapeWithHorizontalCenterOptically arg9, MeasureScope arg10, Measurable arg11, Constraints arg12) {
        Placeable v11 = arg11.measure-BRTryo0(arg12.unbox-impl());
        return MeasureScope.layout$default(arg10, v11.getWidth(), v11.getHeight(), null, new HorizontalCenterOpticallyKt$$ExternalSyntheticLambda0(arg9, -arg10.toPx-0680j_4(arg7), arg10.toPx-0680j_4(arg8), v11), 4, null);
    }

    static final Unit horizontalCenterOptically_4j6BHR0$lambda$3$lambda$2(ShapeWithHorizontalCenterOptically arg7, float arg8, float arg9, Placeable arg10, PlacementScope arg11) {
        PlacementScope.place$default(arg11, arg10, MathKt.roundToInt(RangesKt.coerceIn(arg7.offset(), arg8, arg9)), 0, 0f, 4, null);
        return Unit.INSTANCE;
    }
}

