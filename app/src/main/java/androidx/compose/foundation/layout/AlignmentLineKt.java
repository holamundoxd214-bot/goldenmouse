package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\u001A/\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001A/\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\t2\b\b\u0002\u0010\u0006\u001A\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000B\u001A\'\u0010\f\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\r\u001A\u00020\u00052\b\b\u0002\u0010\u000E\u001A\u00020\u0005H\u0007¢\u0006\u0004\b\u000F\u0010\u0010\u001A\'\u0010\f\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\r\u001A\u00020\t2\b\b\u0002\u0010\u000E\u001A\u00020\tH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001A;\u0010\u0013\u001A\u00020\u0014*\u00020\u00152\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0019H\u0002¢\u0006\u0004\b\u001A\u0010\u001B\"\u0018\u0010\u001C\u001A\u00020\u001D*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001F¨\u0006 "}, d2={"paddingFrom", "Landroidx/compose/ui/Modifier;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "before", "Landroidx/compose/ui/unit/Dp;", "after", "paddingFrom-4j6BHR0", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;FF)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/TextUnit;", "paddingFrom-Y_r0B1c", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;JJ)Landroidx/compose/ui/Modifier;", "paddingFromBaseline", "top", "bottom", "paddingFromBaseline-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "paddingFromBaseline-wCyjxdI", "(Landroidx/compose/ui/Modifier;JJ)Landroidx/compose/ui/Modifier;", "alignmentLineOffsetMeasure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "alignmentLineOffsetMeasure-tjqqzMA", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/AlignmentLine;FFLandroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "horizontal", "", "getHorizontal", "(Landroidx/compose/ui/layout/AlignmentLine;)Z", "foundation-layout"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AlignmentLineKt {
    public static final MeasureResult access$alignmentLineOffsetMeasure-tjqqzMA(MeasureScope arg0, AlignmentLine arg1, float arg2, float arg3, Measurable arg4, long arg5) {
        return AlignmentLineKt.alignmentLineOffsetMeasure-tjqqzMA(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    private static final MeasureResult alignmentLineOffsetMeasure-tjqqzMA(MeasureScope arg13, AlignmentLine arg14, float arg15, float arg16, Measurable arg17, long arg18) {
        long v3 = AlignmentLineKt.getHorizontal(arg14) ? Constraints.copy-Zbe2FdA$default(arg18, 0, 0, 0, 0, 11, null) : Constraints.copy-Zbe2FdA$default(arg18, 0, 0, 0, 0, 14, null);
        Placeable v11 = arg17.measure-BRTryo0(v3);
        int v0 = v11.get(arg14);
        if(v0 != 0x80000000) {
        }
        else {
            v0 = 0;
        }

        int v1 = AlignmentLineKt.getHorizontal(arg14) ? v11.getHeight() : v11.getWidth();
        int v3_1 = AlignmentLineKt.getHorizontal(arg14) ? Constraints.getMaxHeight-impl(arg18) : Constraints.getMaxWidth-impl(arg18);
        int v4 = !Float.isNaN(arg15) ? arg13.roundToPx-0680j_4(arg15) : 0;
        v3_1 -= v1;
        int v8 = RangesKt.coerceIn(v4 - v0, 0, v3_1);
        v4 = !Float.isNaN(arg16) ? arg13.roundToPx-0680j_4(arg16) : 0;
        int v10 = RangesKt.coerceIn(v4 - v1 + v0, 0, v3_1 - v8);
        v0 = AlignmentLineKt.getHorizontal(arg14) ? v11.getWidth() : Math.max(v11.getWidth() + v8 + v10, Constraints.getMinWidth-impl(arg18));
        int v9 = v0;
        v0 = AlignmentLineKt.getHorizontal(arg14) ? Math.max(v11.getHeight() + v8 + v10, Constraints.getMinHeight-impl(arg18)) : v11.getHeight();
        return MeasureScope.layout$default(arg13, v9, v0, null, new AlignmentLineKt$$ExternalSyntheticLambda0(arg14, arg15, v8, v9, v10, v11, v0), 4, null);
    }

    static final Unit alignmentLineOffsetMeasure_tjqqzMA$lambda$1(AlignmentLine arg9, float arg10, int arg11, int arg12, int arg13, Placeable arg14, int arg15, PlacementScope arg16) {
        int v5;
        int v4;
        if(AlignmentLineKt.getHorizontal(arg9)) {
            v4 = 0;
        }
        else if(!Dp.equals-impl0(arg10, Dp.Companion.getUnspecified-D9Ej5fM())) {
            v4 = arg11;
        }
        else {
            v4 = arg12 - arg13 - arg14.getWidth();
        }

        if(!AlignmentLineKt.getHorizontal(arg9)) {
            v5 = 0;
        }
        else {
            if(!Dp.equals-impl0(arg10, Dp.Companion.getUnspecified-D9Ej5fM())) {
            }
            else {
                arg11 = arg15 - arg13 - arg14.getHeight();
            }

            v5 = arg11;
        }

        PlacementScope.placeRelative$default(arg16, arg14, v4, v5, 0f, 4, null);
        return Unit.INSTANCE;
    }

    private static final boolean getHorizontal(AlignmentLine arg0) {
        return arg0 instanceof HorizontalAlignmentLine;
    }

    public static final Modifier paddingFrom-4j6BHR0(Modifier arg6, AlignmentLine arg7, float arg8, float arg9) {
        AlignmentLineKt$paddingFrom-4j6BHR0$$inlined$debugInspectorInfo$1 v1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v1 = new AlignmentLineKt$paddingFrom-4j6BHR0$$inlined$debugInspectorInfo$1(arg7, arg8, arg9);
        }
        else {
            Function1 v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg6.then(new AlignmentLineOffsetDpElement(arg7, arg8, arg9, v1, null));
    }

    public static Modifier paddingFrom-4j6BHR0$default(Modifier arg0, AlignmentLine arg1, float arg2, float arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        if((arg4 & 4) != 0) {
            arg3 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        return AlignmentLineKt.paddingFrom-4j6BHR0(arg0, arg1, arg2, arg3);
    }

    public static final Modifier paddingFrom-Y_r0B1c(Modifier arg8, AlignmentLine arg9, long arg10, long arg12) {
        Function1 v9_1;
        long v4;
        long v2;
        AlignmentLine v1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            AlignmentLine v3 = arg9;
            AlignmentLineKt$paddingFrom-Y_r0B1c$$inlined$debugInspectorInfo$1 v9 = new AlignmentLineKt$paddingFrom-Y_r0B1c$$inlined$debugInspectorInfo$1(v3, arg10, arg12);
            v1 = v3;
            v2 = arg10;
            v4 = arg12;
        }
        else {
            v1 = arg9;
            v2 = arg10;
            v4 = arg12;
            v9_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg8.then(new AlignmentLineOffsetTextUnitElement(v1, v2, v4, ((AlignmentLineKt$paddingFrom-Y_r0B1c$$inlined$debugInspectorInfo$1)v9_1), null));
    }

    public static Modifier paddingFrom-Y_r0B1c$default(Modifier arg6, AlignmentLine arg7, long arg8, long arg10, int arg12, Object arg13) {
        if((arg12 & 2) != 0) {
            arg8 = TextUnit.Companion.getUnspecified-XSAIIZE();
        }

        long v2 = arg8;
        if((arg12 & 4) != 0) {
            arg10 = TextUnit.Companion.getUnspecified-XSAIIZE();
        }

        return AlignmentLineKt.paddingFrom-Y_r0B1c(arg6, arg7, v2, arg10);
    }

    public static final Modifier paddingFromBaseline-VpY3zN4(Modifier arg7, float arg8, float arg9) {
        Companion v8_1;
        Modifier v8;
        if(!Float.isNaN(arg8)) {
            v8 = AlignmentLineKt.paddingFrom-4j6BHR0$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), arg8, 0f, 4, null);
        }
        else {
            v8_1 = Modifier.Companion;
        }

        arg7 = arg7.then(v8);
        if(!Float.isNaN(arg9)) {
            v8 = AlignmentLineKt.paddingFrom-4j6BHR0$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0f, arg9, 2, null);
        }
        else {
            v8_1 = Modifier.Companion;
        }

        return arg7.then(v8);
    }

    public static Modifier paddingFromBaseline-VpY3zN4$default(Modifier arg0, float arg1, float arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        if((arg3 & 2) != 0) {
            arg2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        return AlignmentLineKt.paddingFromBaseline-VpY3zN4(arg0, arg1, arg2);
    }

    public static final Modifier paddingFromBaseline-wCyjxdI(Modifier arg12, long arg13, long arg15) {
        Modifier v13_1;
        Companion v13;
        long v2 = 0;
        if(TextUnit.getRawType-impl(arg13) == v2) {
            v13 = Modifier.Companion;
        }
        else {
            v13_1 = AlignmentLineKt.paddingFrom-Y_r0B1c$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), arg13, 0, 4, null);
        }

        arg12 = arg12.then(v13_1);
        if(TextUnit.getRawType-impl(arg15) == v2) {
            v13 = Modifier.Companion;
        }
        else {
            v13_1 = AlignmentLineKt.paddingFrom-Y_r0B1c$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0, arg15, 2, null);
        }

        return arg12.then(v13_1);
    }

    public static Modifier paddingFromBaseline-wCyjxdI$default(Modifier arg0, long arg1, long arg3, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = TextUnit.Companion.getUnspecified-XSAIIZE();
        }

        if((arg5 & 2) != 0) {
            arg3 = TextUnit.Companion.getUnspecified-XSAIIZE();
        }

        return AlignmentLineKt.paddingFromBaseline-wCyjxdI(arg0, arg1, arg3);
    }
}

