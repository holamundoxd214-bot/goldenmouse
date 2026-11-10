package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0001\u001A\n\u0010\u0002\u001A\u00020\u0001*\u00020\u0001\u001A\n\u0010\u0003\u001A\u00020\u0001*\u00020\u0001\u001A\n\u0010\u0004\u001A\u00020\u0001*\u00020\u0001\u001A\n\u0010\u0005\u001A\u00020\u0001*\u00020\u0001\u001A\n\u0010\u0006\u001A\u00020\u0001*\u00020\u0001\u001A\n\u0010\u0007\u001A\u00020\u0001*\u00020\u0001\u001A\n\u0010\b\u001A\u00020\u0001*\u00020\u0001\u001A\n\u0010\t\u001A\u00020\u0001*\u00020\u0001\u001A\n\u0010\n\u001A\u00020\u0001*\u00020\u0001\u001A\n\u0010\u000B\u001A\u00020\u0001*\u00020\u0001\u001A\n\u0010\f\u001A\u00020\u0001*\u00020\u0001\u001A>\u0010\r\u001A\u00020\u0001*\u00020\u00012\u0017\u0010\u000E\u001A\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000F¢\u0006\u0002\b\u00122\u0017\u0010\u0013\u001A\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u000F¢\u0006\u0002\b\u0012H\u0003¨\u0006\u0016"}, d2={"safeDrawingPadding", "Landroidx/compose/ui/Modifier;", "safeGesturesPadding", "safeContentPadding", "systemBarsPadding", "displayCutoutPadding", "statusBarsPadding", "imePadding", "navigationBarsPadding", "captionBarPadding", "waterfallPadding", "systemGesturesPadding", "mandatorySystemGesturesPadding", "windowInsetsPadding", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "insetsCalculation", "Landroidx/compose/foundation/layout/WindowInsetsHolder;", "Landroidx/compose/foundation/layout/WindowInsets;", "foundation-layout"}, k=2, mv={2, 0, 0}, xi=0x30) public final class WindowInsetsPadding_androidKt {
    public static final Modifier captionBarPadding(Modifier arg2) {
        Function1 v0_1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            WindowInsetsPadding_androidKt$captionBarPadding$$inlined$debugInspectorInfo$1 v0 = new WindowInsetsPadding_androidKt$captionBarPadding$$inlined$debugInspectorInfo$1();
        }
        else {
            v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return WindowInsetsPadding_androidKt.windowInsetsPadding(arg2, v0_1, new WindowInsetsPadding_androidKt$$ExternalSyntheticLambda9());
    }

    static final WindowInsets captionBarPadding$lambda$1(WindowInsetsHolder arg0) {
        return arg0.getCaptionBar();
    }

    public static final Modifier displayCutoutPadding(Modifier arg2) {
        Function1 v0_1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            WindowInsetsPadding_androidKt$displayCutoutPadding$$inlined$debugInspectorInfo$1 v0 = new WindowInsetsPadding_androidKt$displayCutoutPadding$$inlined$debugInspectorInfo$1();
        }
        else {
            v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return WindowInsetsPadding_androidKt.windowInsetsPadding(arg2, v0_1, new WindowInsetsPadding_androidKt$$ExternalSyntheticLambda2());
    }

    static final WindowInsets displayCutoutPadding$lambda$1(WindowInsetsHolder arg0) {
        return arg0.getDisplayCutout();
    }

    public static final Modifier imePadding(Modifier arg2) {
        WindowInsetsPadding_androidKt$imePadding$$inlined$debugInspectorInfo$1 v0;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v0 = new WindowInsetsPadding_androidKt$imePadding$$inlined$debugInspectorInfo$1();
        }
        else {
            Function1 v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return WindowInsetsPadding_androidKt.windowInsetsPadding(arg2, ((Function1)v0), new WindowInsetsPadding_androidKt$$ExternalSyntheticLambda5());
    }

    static final WindowInsets imePadding$lambda$1(WindowInsetsHolder arg0) {
        return arg0.getIme();
    }

    public static final Modifier mandatorySystemGesturesPadding(Modifier arg2) {
        Function1 v0_1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            WindowInsetsPadding_androidKt$mandatorySystemGesturesPadding$$inlined$debugInspectorInfo$1 v0 = new WindowInsetsPadding_androidKt$mandatorySystemGesturesPadding$$inlined$debugInspectorInfo$1();
        }
        else {
            v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return WindowInsetsPadding_androidKt.windowInsetsPadding(arg2, v0_1, new WindowInsetsPadding_androidKt$$ExternalSyntheticLambda4());
    }

    static final WindowInsets mandatorySystemGesturesPadding$lambda$1(WindowInsetsHolder arg0) {
        return arg0.getMandatorySystemGestures();
    }

    public static final Modifier navigationBarsPadding(Modifier arg2) {
        Function1 v0_1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            WindowInsetsPadding_androidKt$navigationBarsPadding$$inlined$debugInspectorInfo$1 v0 = new WindowInsetsPadding_androidKt$navigationBarsPadding$$inlined$debugInspectorInfo$1();
        }
        else {
            v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return WindowInsetsPadding_androidKt.windowInsetsPadding(arg2, v0_1, new WindowInsetsPadding_androidKt$$ExternalSyntheticLambda7());
    }

    static final WindowInsets navigationBarsPadding$lambda$1(WindowInsetsHolder arg0) {
        return arg0.getNavigationBars();
    }

    public static final Modifier safeContentPadding(Modifier arg2) {
        WindowInsetsPadding_androidKt$safeContentPadding$$inlined$debugInspectorInfo$1 v0;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v0 = new WindowInsetsPadding_androidKt$safeContentPadding$$inlined$debugInspectorInfo$1();
        }
        else {
            Function1 v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return WindowInsetsPadding_androidKt.windowInsetsPadding(arg2, ((Function1)v0), new WindowInsetsPadding_androidKt$$ExternalSyntheticLambda3());
    }

    static final WindowInsets safeContentPadding$lambda$1(WindowInsetsHolder arg0) {
        return arg0.getSafeContent();
    }

    public static final Modifier safeDrawingPadding(Modifier arg2) {
        WindowInsetsPadding_androidKt$safeDrawingPadding$$inlined$debugInspectorInfo$1 v0;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v0 = new WindowInsetsPadding_androidKt$safeDrawingPadding$$inlined$debugInspectorInfo$1();
        }
        else {
            Function1 v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return WindowInsetsPadding_androidKt.windowInsetsPadding(arg2, ((Function1)v0), new WindowInsetsPadding_androidKt$$ExternalSyntheticLambda8());
    }

    static final WindowInsets safeDrawingPadding$lambda$1(WindowInsetsHolder arg0) {
        return arg0.getSafeDrawing();
    }

    public static final Modifier safeGesturesPadding(Modifier arg2) {
        Function1 v0_1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            WindowInsetsPadding_androidKt$safeGesturesPadding$$inlined$debugInspectorInfo$1 v0 = new WindowInsetsPadding_androidKt$safeGesturesPadding$$inlined$debugInspectorInfo$1();
        }
        else {
            v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return WindowInsetsPadding_androidKt.windowInsetsPadding(arg2, v0_1, new WindowInsetsPadding_androidKt$$ExternalSyntheticLambda0());
    }

    static final WindowInsets safeGesturesPadding$lambda$1(WindowInsetsHolder arg0) {
        return arg0.getSafeGestures();
    }

    public static final Modifier statusBarsPadding(Modifier arg2) {
        Function1 v0_1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            WindowInsetsPadding_androidKt$statusBarsPadding$$inlined$debugInspectorInfo$1 v0 = new WindowInsetsPadding_androidKt$statusBarsPadding$$inlined$debugInspectorInfo$1();
        }
        else {
            v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return WindowInsetsPadding_androidKt.windowInsetsPadding(arg2, v0_1, new WindowInsetsPadding_androidKt$$ExternalSyntheticLambda11());
    }

    static final WindowInsets statusBarsPadding$lambda$1(WindowInsetsHolder arg0) {
        return arg0.getStatusBars();
    }

    public static final Modifier systemBarsPadding(Modifier arg2) {
        Function1 v0_1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            WindowInsetsPadding_androidKt$systemBarsPadding$$inlined$debugInspectorInfo$1 v0 = new WindowInsetsPadding_androidKt$systemBarsPadding$$inlined$debugInspectorInfo$1();
        }
        else {
            v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return WindowInsetsPadding_androidKt.windowInsetsPadding(arg2, v0_1, new WindowInsetsPadding_androidKt$$ExternalSyntheticLambda6());
    }

    static final WindowInsets systemBarsPadding$lambda$1(WindowInsetsHolder arg0) {
        return arg0.getSystemBars();
    }

    public static final Modifier systemGesturesPadding(Modifier arg2) {
        Function1 v0_1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            WindowInsetsPadding_androidKt$systemGesturesPadding$$inlined$debugInspectorInfo$1 v0 = new WindowInsetsPadding_androidKt$systemGesturesPadding$$inlined$debugInspectorInfo$1();
        }
        else {
            v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return WindowInsetsPadding_androidKt.windowInsetsPadding(arg2, v0_1, new WindowInsetsPadding_androidKt$$ExternalSyntheticLambda1());
    }

    static final WindowInsets systemGesturesPadding$lambda$1(WindowInsetsHolder arg0) {
        return arg0.getSystemGestures();
    }

    public static final Modifier waterfallPadding(Modifier arg2) {
        WindowInsetsPadding_androidKt$waterfallPadding$$inlined$debugInspectorInfo$1 v0;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v0 = new WindowInsetsPadding_androidKt$waterfallPadding$$inlined$debugInspectorInfo$1();
        }
        else {
            Function1 v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return WindowInsetsPadding_androidKt.windowInsetsPadding(arg2, ((Function1)v0), new WindowInsetsPadding_androidKt$$ExternalSyntheticLambda10());
    }

    static final WindowInsets waterfallPadding$lambda$1(WindowInsetsHolder arg0) {
        return arg0.getWaterfall();
    }

    private static final Modifier windowInsetsPadding(Modifier arg1, Function1 arg2, Function1 arg3) {
        return arg1.then(new SystemInsetsPaddingModifierElement(arg2, arg3));
    }
}

