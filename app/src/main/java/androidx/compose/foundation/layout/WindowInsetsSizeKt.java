package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0007\u001A\u0014\u0010\n\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0007\u001A\u0014\u0010\f\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0007\u001A\u0014\u0010\u000F\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0007\"+\u0010\u0004\u001A\u001F\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tX\u0082\u0004¢\u0006\u0002\n\u0000\"+\u0010\u000B\u001A\u001F\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tX\u0082\u0004¢\u0006\u0002\n\u0000\"%\u0010\r\u001A\u0019\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u000E¢\u0006\u0002\b\tX\u0082\u0004¢\u0006\u0002\n\u0000\"%\u0010\u0010\u001A\u0019\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u000E¢\u0006\u0002\b\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"windowInsetsStartWidth", "Landroidx/compose/ui/Modifier;", "insets", "Landroidx/compose/foundation/layout/WindowInsets;", "startCalc", "Lkotlin/Function3;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "", "Lkotlin/ExtensionFunctionType;", "windowInsetsEndWidth", "endCalc", "windowInsetsTopHeight", "topCalc", "Lkotlin/Function2;", "windowInsetsBottomHeight", "bottomCalc", "foundation-layout"}, k=2, mv={2, 0, 0}, xi=0x30) public final class WindowInsetsSizeKt {
    private static final Function2 bottomCalc;
    private static final Function3 endCalc;
    private static final Function3 startCalc;
    private static final Function2 topCalc;

    static {
        WindowInsetsSizeKt.startCalc = new WindowInsetsSizeKt$$ExternalSyntheticLambda0();
        WindowInsetsSizeKt.endCalc = new WindowInsetsSizeKt$$ExternalSyntheticLambda1();
        WindowInsetsSizeKt.topCalc = new WindowInsetsSizeKt$$ExternalSyntheticLambda2();
        WindowInsetsSizeKt.bottomCalc = new WindowInsetsSizeKt$$ExternalSyntheticLambda3();
    }

    static final int bottomCalc$lambda$0(WindowInsets arg0, Density arg1) {
        return arg0.getBottom(arg1);
    }

    static final int endCalc$lambda$0(WindowInsets arg1, LayoutDirection arg2, Density arg3) {
        if(arg2 == LayoutDirection.Rtl) {
            return arg1.getLeft(arg3, arg2);
        }

        return arg1.getRight(arg3, arg2);
    }

    static final int startCalc$lambda$0(WindowInsets arg1, LayoutDirection arg2, Density arg3) {
        if(arg2 == LayoutDirection.Ltr) {
            return arg1.getLeft(arg3, arg2);
        }

        return arg1.getRight(arg3, arg2);
    }

    static final int topCalc$lambda$0(WindowInsets arg0, Density arg1) {
        return arg0.getTop(arg1);
    }

    public static final Modifier windowInsetsBottomHeight(Modifier arg3, WindowInsets arg4) {
        WindowInsetsSizeKt$windowInsetsBottomHeight$$inlined$debugInspectorInfo$1 v1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v1 = new WindowInsetsSizeKt$windowInsetsBottomHeight$$inlined$debugInspectorInfo$1(arg4);
        }
        else {
            Function1 v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg3.then(new DerivedHeightModifierElement(arg4, ((Function1)v1), WindowInsetsSizeKt.bottomCalc));
    }

    public static final Modifier windowInsetsEndWidth(Modifier arg3, WindowInsets arg4) {
        Function1 v1_1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            WindowInsetsSizeKt$windowInsetsEndWidth$$inlined$debugInspectorInfo$1 v1 = new WindowInsetsSizeKt$windowInsetsEndWidth$$inlined$debugInspectorInfo$1(arg4);
        }
        else {
            v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg3.then(new DerivedWidthModifierElement(arg4, v1_1, WindowInsetsSizeKt.endCalc));
    }

    public static final Modifier windowInsetsStartWidth(Modifier arg3, WindowInsets arg4) {
        Function1 v1_1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            WindowInsetsSizeKt$windowInsetsStartWidth$$inlined$debugInspectorInfo$1 v1 = new WindowInsetsSizeKt$windowInsetsStartWidth$$inlined$debugInspectorInfo$1(arg4);
        }
        else {
            v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg3.then(new DerivedWidthModifierElement(arg4, v1_1, WindowInsetsSizeKt.startCalc));
    }

    public static final Modifier windowInsetsTopHeight(Modifier arg3, WindowInsets arg4) {
        WindowInsetsSizeKt$windowInsetsTopHeight$$inlined$debugInspectorInfo$1 v1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v1 = new WindowInsetsSizeKt$windowInsetsTopHeight$$inlined$debugInspectorInfo$1(arg4);
        }
        else {
            Function1 v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg3.then(new DerivedHeightModifierElement(arg4, ((Function1)v1), WindowInsetsSizeKt.topCalc));
    }
}

