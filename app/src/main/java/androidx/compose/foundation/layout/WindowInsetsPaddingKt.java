package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0007\u001A\u0014\u0010\u0004\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0007\u001A\u0014\u0010\u0004\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0006H\u0007\u001A/\u0010\u0007\u001A\u00020\u0001*\u00020\u00012!\u0010\b\u001A\u001D\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\tH\u0007\u001A\n\u0010\u000E\u001A\u00020\u0001*\u00020\u0001¨\u0006\u000F"}, d2={"windowInsetsPadding", "Landroidx/compose/ui/Modifier;", "insets", "Landroidx/compose/foundation/layout/WindowInsets;", "consumeWindowInsets", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "onConsumedWindowInsetsChanged", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "consumedWindowInsets", "", "recalculateWindowInsets", "foundation-layout"}, k=2, mv={2, 0, 0}, xi=0x30) public final class WindowInsetsPaddingKt {
    public static final Modifier consumeWindowInsets(Modifier arg2, PaddingValues arg3) {
        Function1 v1_1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            WindowInsetsPaddingKt$consumeWindowInsets$$inlined$debugInspectorInfo$2 v1 = new WindowInsetsPaddingKt$consumeWindowInsets$$inlined$debugInspectorInfo$2(arg3);
        }
        else {
            v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg2.then(new PaddingValuesConsumingModifierElement(arg3, v1_1));
    }

    public static final Modifier consumeWindowInsets(Modifier arg2, WindowInsets arg3) {
        WindowInsetsPaddingKt$consumeWindowInsets$$inlined$debugInspectorInfo$1 v1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v1 = new WindowInsetsPaddingKt$consumeWindowInsets$$inlined$debugInspectorInfo$1(arg3);
        }
        else {
            Function1 v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg2.then(new UnionInsetsConsumingModifierElement(arg3, ((Function1)v1)));
    }

    public static final Modifier onConsumedWindowInsetsChanged(Modifier arg2, Function1 arg3) {
        Function1 v1_1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            WindowInsetsPaddingKt$onConsumedWindowInsetsChanged$$inlined$debugInspectorInfo$1 v1 = new WindowInsetsPaddingKt$onConsumedWindowInsetsChanged$$inlined$debugInspectorInfo$1(arg3);
        }
        else {
            v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg2.then(new ConsumedInsetsModifierElement(arg3, v1_1));
    }

    public static final Modifier recalculateWindowInsets(Modifier arg1) {
        return arg1.then(RecalculateWindowInsetsModifierElement.INSTANCE);
    }

    public static final Modifier windowInsetsPadding(Modifier arg2, WindowInsets arg3) {
        WindowInsetsPaddingKt$windowInsetsPadding$$inlined$debugInspectorInfo$1 v1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v1 = new WindowInsetsPaddingKt$windowInsetsPadding$$inlined$debugInspectorInfo$1(arg3);
        }
        else {
            Function1 v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg2.then(new InsetsPaddingModifierElement(arg3, ((Function1)v1)));
    }
}

