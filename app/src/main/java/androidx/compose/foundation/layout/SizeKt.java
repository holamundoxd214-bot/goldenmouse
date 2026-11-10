package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001F\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\u001B\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001A\u001B\u0010\u0005\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0004\u001A\u001B\u0010\u0007\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\u0004\u001A#\u0010\u0007\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\n\u001A\u001B\u0010\u0007\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001A\u00020\u000BH\u0007¢\u0006\u0004\b\f\u0010\r\u001A\'\u0010\u000E\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u000F\u001A\u00020\u00022\b\b\u0002\u0010\u0010\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u0011\u0010\n\u001A\'\u0010\u0012\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u000F\u001A\u00020\u00022\b\b\u0002\u0010\u0010\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u0013\u0010\n\u001A;\u0010\u0014\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0015\u001A\u00020\u00022\b\b\u0002\u0010\u0016\u001A\u00020\u00022\b\b\u0002\u0010\u0017\u001A\u00020\u00022\b\b\u0002\u0010\u0018\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u0019\u0010\u001A\u001A\u001B\u0010\u001B\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u001C\u0010\u0004\u001A\u001B\u0010\u001D\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u001E\u0010\u0004\u001A\u001B\u0010\u001F\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001A\u00020\u0002H\u0007¢\u0006\u0004\b \u0010\u0004\u001A#\u0010\u001F\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0002H\u0007¢\u0006\u0004\b!\u0010\n\u001A\u001B\u0010\u001F\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001A\u00020\u000BH\u0007¢\u0006\u0004\b\"\u0010\r\u001A\'\u0010#\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u000F\u001A\u00020\u00022\b\b\u0002\u0010\u0010\u001A\u00020\u0002H\u0007¢\u0006\u0004\b$\u0010\n\u001A\'\u0010%\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u000F\u001A\u00020\u00022\b\b\u0002\u0010\u0010\u001A\u00020\u0002H\u0007¢\u0006\u0004\b&\u0010\n\u001A;\u0010\'\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0015\u001A\u00020\u00022\b\b\u0002\u0010\u0016\u001A\u00020\u00022\b\b\u0002\u0010\u0017\u001A\u00020\u00022\b\b\u0002\u0010\u0018\u001A\u00020\u0002H\u0007¢\u0006\u0004\b(\u0010\u001A\u001A\u0016\u0010)\u001A\u00020\u0001*\u00020\u00012\b\b\u0003\u0010*\u001A\u00020+H\u0007\u001A\u0016\u0010.\u001A\u00020\u0001*\u00020\u00012\b\b\u0003\u0010*\u001A\u00020+H\u0007\u001A\u0016\u00100\u001A\u00020\u0001*\u00020\u00012\b\b\u0003\u0010*\u001A\u00020+H\u0007\u001A \u00102\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u00103\u001A\u0002042\b\b\u0002\u00105\u001A\u000206H\u0007\u001A \u0010:\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u00103\u001A\u00020;2\b\b\u0002\u00105\u001A\u000206H\u0007\u001A \u0010>\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u00103\u001A\u00020?2\b\b\u0002\u00105\u001A\u000206H\u0007\u001A\'\u0010B\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0015\u001A\u00020\u00022\b\b\u0002\u0010\u0016\u001A\u00020\u0002H\u0007¢\u0006\u0004\bC\u0010\n\"\u000E\u0010,\u001A\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010/\u001A\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u00101\u001A\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u00107\u001A\u000208X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u00109\u001A\u000208X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010<\u001A\u000208X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010=\u001A\u000208X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010@\u001A\u000208X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010A\u001A\u000208X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2={"width", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/Dp;", "width-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "height", "height-3ABfNKs", "size", "size-3ABfNKs", "size-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/DpSize;", "size-6HolHcs", "(Landroidx/compose/ui/Modifier;J)Landroidx/compose/ui/Modifier;", "widthIn", "min", "max", "widthIn-VpY3zN4", "heightIn", "heightIn-VpY3zN4", "sizeIn", "minWidth", "minHeight", "maxWidth", "maxHeight", "sizeIn-qDBjuR0", "(Landroidx/compose/ui/Modifier;FFFF)Landroidx/compose/ui/Modifier;", "requiredWidth", "requiredWidth-3ABfNKs", "requiredHeight", "requiredHeight-3ABfNKs", "requiredSize", "requiredSize-3ABfNKs", "requiredSize-VpY3zN4", "requiredSize-6HolHcs", "requiredWidthIn", "requiredWidthIn-VpY3zN4", "requiredHeightIn", "requiredHeightIn-VpY3zN4", "requiredSizeIn", "requiredSizeIn-qDBjuR0", "fillMaxWidth", "fraction", "", "FillWholeMaxWidth", "Landroidx/compose/foundation/layout/FillElement;", "fillMaxHeight", "FillWholeMaxHeight", "fillMaxSize", "FillWholeMaxSize", "wrapContentWidth", "align", "Landroidx/compose/ui/Alignment$Horizontal;", "unbounded", "", "WrapContentWidthCenter", "Landroidx/compose/foundation/layout/WrapContentElement;", "WrapContentWidthStart", "wrapContentHeight", "Landroidx/compose/ui/Alignment$Vertical;", "WrapContentHeightCenter", "WrapContentHeightTop", "wrapContentSize", "Landroidx/compose/ui/Alignment;", "WrapContentSizeCenter", "WrapContentSizeTopStart", "defaultMinSize", "defaultMinSize-VpY3zN4", "foundation-layout"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SizeKt {
    private static final FillElement FillWholeMaxHeight;
    private static final FillElement FillWholeMaxSize;
    private static final FillElement FillWholeMaxWidth;
    private static final WrapContentElement WrapContentHeightCenter;
    private static final WrapContentElement WrapContentHeightTop;
    private static final WrapContentElement WrapContentSizeCenter;
    private static final WrapContentElement WrapContentSizeTopStart;
    private static final WrapContentElement WrapContentWidthCenter;
    private static final WrapContentElement WrapContentWidthStart;

    static {
        SizeKt.FillWholeMaxWidth = FillElement.Companion.width(1f);
        SizeKt.FillWholeMaxHeight = FillElement.Companion.height(1f);
        SizeKt.FillWholeMaxSize = FillElement.Companion.size(1f);
        SizeKt.WrapContentWidthCenter = WrapContentElement.Companion.width(Alignment.Companion.getCenterHorizontally(), false);
        SizeKt.WrapContentWidthStart = WrapContentElement.Companion.width(Alignment.Companion.getStart(), false);
        SizeKt.WrapContentHeightCenter = WrapContentElement.Companion.height(Alignment.Companion.getCenterVertically(), false);
        SizeKt.WrapContentHeightTop = WrapContentElement.Companion.height(Alignment.Companion.getTop(), false);
        SizeKt.WrapContentSizeCenter = WrapContentElement.Companion.size(Alignment.Companion.getCenter(), false);
        SizeKt.WrapContentSizeTopStart = WrapContentElement.Companion.size(Alignment.Companion.getTopStart(), false);
    }

    public static final Modifier defaultMinSize-VpY3zN4(Modifier arg2, float arg3, float arg4) {
        return arg2.then(new UnspecifiedConstraintsElement(arg3, arg4, null));
    }

    public static Modifier defaultMinSize-VpY3zN4$default(Modifier arg0, float arg1, float arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        if((arg3 & 2) != 0) {
            arg2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        return SizeKt.defaultMinSize-VpY3zN4(arg0, arg1, arg2);
    }

    public static final Modifier fillMaxHeight(Modifier arg1, float arg2) {
        FillElement v2 = arg2 == 1f ? SizeKt.FillWholeMaxHeight : FillElement.Companion.height(arg2);
        return arg1.then(((Modifier)v2));
    }

    public static Modifier fillMaxHeight$default(Modifier arg0, float arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 1f;
        }

        return SizeKt.fillMaxHeight(arg0, arg1);
    }

    public static final Modifier fillMaxSize(Modifier arg1, float arg2) {
        FillElement v2 = arg2 == 1f ? SizeKt.FillWholeMaxSize : FillElement.Companion.size(arg2);
        return arg1.then(((Modifier)v2));
    }

    public static Modifier fillMaxSize$default(Modifier arg0, float arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 1f;
        }

        return SizeKt.fillMaxSize(arg0, arg1);
    }

    public static final Modifier fillMaxWidth(Modifier arg1, float arg2) {
        FillElement v2 = arg2 == 1f ? SizeKt.FillWholeMaxWidth : FillElement.Companion.width(arg2);
        return arg1.then(((Modifier)v2));
    }

    public static Modifier fillMaxWidth$default(Modifier arg0, float arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 1f;
        }

        return SizeKt.fillMaxWidth(arg0, arg1);
    }

    public static final Modifier height-3ABfNKs(Modifier arg9, float arg10) {
        SizeKt$height-3ABfNKs$$inlined$debugInspectorInfo$1 v1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v1 = new SizeKt$height-3ABfNKs$$inlined$debugInspectorInfo$1(arg10);
        }
        else {
            Function1 v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg9.then(new SizeElement(0f, arg10, 0f, arg10, true, v1, 5, null));
    }

    public static final Modifier heightIn-VpY3zN4(Modifier arg9, float arg10, float arg11) {
        Function1 v1_1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            SizeKt$heightIn-VpY3zN4$$inlined$debugInspectorInfo$1 v1 = new SizeKt$heightIn-VpY3zN4$$inlined$debugInspectorInfo$1(arg10, arg11);
        }
        else {
            v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg9.then(new SizeElement(0f, arg10, 0f, arg11, true, ((SizeKt$heightIn-VpY3zN4$$inlined$debugInspectorInfo$1)v1_1), 5, null));
    }

    public static Modifier heightIn-VpY3zN4$default(Modifier arg0, float arg1, float arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        if((arg3 & 2) != 0) {
            arg2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        return SizeKt.heightIn-VpY3zN4(arg0, arg1, arg2);
    }

    public static final Modifier requiredHeight-3ABfNKs(Modifier arg9, float arg10) {
        SizeKt$requiredHeight-3ABfNKs$$inlined$debugInspectorInfo$1 v1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v1 = new SizeKt$requiredHeight-3ABfNKs$$inlined$debugInspectorInfo$1(arg10);
        }
        else {
            Function1 v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg9.then(new SizeElement(0f, arg10, 0f, arg10, false, v1, 5, null));
    }

    public static final Modifier requiredHeightIn-VpY3zN4(Modifier arg9, float arg10, float arg11) {
        SizeKt$requiredHeightIn-VpY3zN4$$inlined$debugInspectorInfo$1 v1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v1 = new SizeKt$requiredHeightIn-VpY3zN4$$inlined$debugInspectorInfo$1(arg10, arg11);
        }
        else {
            Function1 v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg9.then(new SizeElement(0f, arg10, 0f, arg11, false, v1, 5, null));
    }

    public static Modifier requiredHeightIn-VpY3zN4$default(Modifier arg0, float arg1, float arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        if((arg3 & 2) != 0) {
            arg2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        return SizeKt.requiredHeightIn-VpY3zN4(arg0, arg1, arg2);
    }

    public static final Modifier requiredSize-3ABfNKs(Modifier arg9, float arg10) {
        Function1 v0_1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            SizeKt$requiredSize-3ABfNKs$$inlined$debugInspectorInfo$1 v0 = new SizeKt$requiredSize-3ABfNKs$$inlined$debugInspectorInfo$1(arg10);
        }
        else {
            v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg9.then(new SizeElement(arg10, arg10, arg10, arg10, false, ((SizeKt$requiredSize-3ABfNKs$$inlined$debugInspectorInfo$1)v0_1), null));
    }

    public static final Modifier requiredSize-6HolHcs(Modifier arg1, long arg2) {
        return SizeKt.requiredSize-VpY3zN4(arg1, DpSize.getWidth-D9Ej5fM(arg2), DpSize.getHeight-D9Ej5fM(arg2));
    }

    public static final Modifier requiredSize-VpY3zN4(Modifier arg9, float arg10, float arg11) {
        SizeKt$requiredSize-VpY3zN4$$inlined$debugInspectorInfo$1 v0;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v0 = new SizeKt$requiredSize-VpY3zN4$$inlined$debugInspectorInfo$1(arg10, arg11);
        }
        else {
            Function1 v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg9.then(new SizeElement(arg10, arg11, arg10, arg11, false, v0, null));
    }

    public static final Modifier requiredSizeIn-qDBjuR0(Modifier arg8, float arg9, float arg10, float arg11, float arg12) {
        Function1 v1_1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            SizeKt$requiredSizeIn-qDBjuR0$$inlined$debugInspectorInfo$1 v1 = new SizeKt$requiredSizeIn-qDBjuR0$$inlined$debugInspectorInfo$1(arg9, arg10, arg11, arg12);
        }
        else {
            v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg8.then(new SizeElement(arg9, arg10, arg11, arg12, false, ((SizeKt$requiredSizeIn-qDBjuR0$$inlined$debugInspectorInfo$1)v1_1), null));
    }

    public static Modifier requiredSizeIn-qDBjuR0$default(Modifier arg0, float arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        if((arg5 & 2) != 0) {
            arg2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        if((arg5 & 4) != 0) {
            arg3 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        if((arg5 & 8) != 0) {
            arg4 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        return SizeKt.requiredSizeIn-qDBjuR0(arg0, arg1, arg2, arg3, arg4);
    }

    public static final Modifier requiredWidth-3ABfNKs(Modifier arg9, float arg10) {
        SizeKt$requiredWidth-3ABfNKs$$inlined$debugInspectorInfo$1 v1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v1 = new SizeKt$requiredWidth-3ABfNKs$$inlined$debugInspectorInfo$1(arg10);
        }
        else {
            Function1 v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg9.then(new SizeElement(arg10, 0f, arg10, 0f, false, v1, 10, null));
    }

    public static final Modifier requiredWidthIn-VpY3zN4(Modifier arg9, float arg10, float arg11) {
        SizeKt$requiredWidthIn-VpY3zN4$$inlined$debugInspectorInfo$1 v1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v1 = new SizeKt$requiredWidthIn-VpY3zN4$$inlined$debugInspectorInfo$1(arg10, arg11);
        }
        else {
            Function1 v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg9.then(new SizeElement(arg10, 0f, arg11, 0f, false, v1, 10, null));
    }

    public static Modifier requiredWidthIn-VpY3zN4$default(Modifier arg0, float arg1, float arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        if((arg3 & 2) != 0) {
            arg2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        return SizeKt.requiredWidthIn-VpY3zN4(arg0, arg1, arg2);
    }

    public static final Modifier size-3ABfNKs(Modifier arg9, float arg10) {
        Function1 v0_1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            SizeKt$size-3ABfNKs$$inlined$debugInspectorInfo$1 v0 = new SizeKt$size-3ABfNKs$$inlined$debugInspectorInfo$1(arg10);
        }
        else {
            v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg9.then(new SizeElement(arg10, arg10, arg10, arg10, true, ((SizeKt$size-3ABfNKs$$inlined$debugInspectorInfo$1)v0_1), null));
    }

    public static final Modifier size-6HolHcs(Modifier arg1, long arg2) {
        return SizeKt.size-VpY3zN4(arg1, DpSize.getWidth-D9Ej5fM(arg2), DpSize.getHeight-D9Ej5fM(arg2));
    }

    public static final Modifier size-VpY3zN4(Modifier arg9, float arg10, float arg11) {
        SizeKt$size-VpY3zN4$$inlined$debugInspectorInfo$1 v0;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v0 = new SizeKt$size-VpY3zN4$$inlined$debugInspectorInfo$1(arg10, arg11);
        }
        else {
            Function1 v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg9.then(new SizeElement(arg10, arg11, arg10, arg11, true, v0, null));
    }

    public static final Modifier sizeIn-qDBjuR0(Modifier arg8, float arg9, float arg10, float arg11, float arg12) {
        SizeKt$sizeIn-qDBjuR0$$inlined$debugInspectorInfo$1 v1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v1 = new SizeKt$sizeIn-qDBjuR0$$inlined$debugInspectorInfo$1(arg9, arg10, arg11, arg12);
        }
        else {
            Function1 v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg8.then(new SizeElement(arg9, arg10, arg11, arg12, true, v1, null));
    }

    public static Modifier sizeIn-qDBjuR0$default(Modifier arg0, float arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        if((arg5 & 2) != 0) {
            arg2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        if((arg5 & 4) != 0) {
            arg3 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        if((arg5 & 8) != 0) {
            arg4 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        return SizeKt.sizeIn-qDBjuR0(arg0, arg1, arg2, arg3, arg4);
    }

    public static final Modifier width-3ABfNKs(Modifier arg9, float arg10) {
        Function1 v1_1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            SizeKt$width-3ABfNKs$$inlined$debugInspectorInfo$1 v1 = new SizeKt$width-3ABfNKs$$inlined$debugInspectorInfo$1(arg10);
        }
        else {
            v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg9.then(new SizeElement(arg10, 0f, arg10, 0f, true, ((SizeKt$width-3ABfNKs$$inlined$debugInspectorInfo$1)v1_1), 10, null));
    }

    public static final Modifier widthIn-VpY3zN4(Modifier arg9, float arg10, float arg11) {
        Function1 v1_1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            SizeKt$widthIn-VpY3zN4$$inlined$debugInspectorInfo$1 v1 = new SizeKt$widthIn-VpY3zN4$$inlined$debugInspectorInfo$1(arg10, arg11);
        }
        else {
            v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg9.then(new SizeElement(arg10, 0f, arg11, 0f, true, ((SizeKt$widthIn-VpY3zN4$$inlined$debugInspectorInfo$1)v1_1), 10, null));
    }

    public static Modifier widthIn-VpY3zN4$default(Modifier arg0, float arg1, float arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        if((arg3 & 2) != 0) {
            arg2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        return SizeKt.widthIn-VpY3zN4(arg0, arg1, arg2);
    }

    public static final Modifier wrapContentHeight(Modifier arg1, Vertical arg2, boolean arg3) {
        WrapContentElement v2;
        if(!Intrinsics.areEqual(arg2, Alignment.Companion.getCenterVertically()) || (arg3)) {
            if((Intrinsics.areEqual(arg2, Alignment.Companion.getTop())) && !arg3) {
                v2 = SizeKt.WrapContentHeightTop;
                goto label_16;
            }

            v2 = WrapContentElement.Companion.height(arg2, arg3);
        }
        else {
            v2 = SizeKt.WrapContentHeightCenter;
        }

    label_16:
        return arg1.then(((Modifier)v2));
    }

    public static Modifier wrapContentHeight$default(Modifier arg0, Vertical arg1, boolean arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = Alignment.Companion.getCenterVertically();
        }

        return SizeKt.wrapContentHeight(arg0, arg1, false);
    }

    public static final Modifier wrapContentSize(Modifier arg1, Alignment arg2, boolean arg3) {
        WrapContentElement v2;
        if(!Intrinsics.areEqual(arg2, Alignment.Companion.getCenter()) || (arg3)) {
            if((Intrinsics.areEqual(arg2, Alignment.Companion.getTopStart())) && !arg3) {
                v2 = SizeKt.WrapContentSizeTopStart;
                goto label_16;
            }

            v2 = WrapContentElement.Companion.size(arg2, arg3);
        }
        else {
            v2 = SizeKt.WrapContentSizeCenter;
        }

    label_16:
        return arg1.then(((Modifier)v2));
    }

    public static Modifier wrapContentSize$default(Modifier arg0, Alignment arg1, boolean arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = Alignment.Companion.getCenter();
        }

        return SizeKt.wrapContentSize(arg0, arg1, false);
    }

    public static final Modifier wrapContentWidth(Modifier arg1, Horizontal arg2, boolean arg3) {
        WrapContentElement v2;
        if(!Intrinsics.areEqual(arg2, Alignment.Companion.getCenterHorizontally()) || (arg3)) {
            if((Intrinsics.areEqual(arg2, Alignment.Companion.getStart())) && !arg3) {
                v2 = SizeKt.WrapContentWidthStart;
                goto label_16;
            }

            v2 = WrapContentElement.Companion.width(arg2, arg3);
        }
        else {
            v2 = SizeKt.WrapContentWidthCenter;
        }

    label_16:
        return arg1.then(((Modifier)v2));
    }

    public static Modifier wrapContentWidth$default(Modifier arg0, Horizontal arg1, boolean arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = Alignment.Companion.getCenterHorizontally();
        }

        return SizeKt.wrapContentWidth(arg0, arg1, false);
    }
}

