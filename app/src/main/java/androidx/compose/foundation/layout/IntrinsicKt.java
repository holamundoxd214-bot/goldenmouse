package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0007\u001A\u0014\u0010\u0004\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0007\u001A\u0014\u0010\u0005\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0007\u001A\u0014\u0010\u0006\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0007¨\u0006\u0007"}, d2={"width", "Landroidx/compose/ui/Modifier;", "intrinsicSize", "Landroidx/compose/foundation/layout/IntrinsicSize;", "height", "requiredWidth", "requiredHeight", "foundation-layout"}, k=2, mv={2, 0, 0}, xi=0x30) public final class IntrinsicKt {
    public static final Modifier height(Modifier arg3, IntrinsicSize arg4) {
        IntrinsicKt$height$$inlined$debugInspectorInfo$1 v1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v1 = new IntrinsicKt$height$$inlined$debugInspectorInfo$1(arg4);
        }
        else {
            Function1 v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg3.then(new IntrinsicHeightElement(arg4, true, ((Function1)v1)));
    }

    public static final Modifier requiredHeight(Modifier arg3, IntrinsicSize arg4) {
        Function1 v1_1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            IntrinsicKt$requiredHeight$$inlined$debugInspectorInfo$1 v1 = new IntrinsicKt$requiredHeight$$inlined$debugInspectorInfo$1(arg4);
        }
        else {
            v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg3.then(new IntrinsicHeightElement(arg4, false, v1_1));
    }

    public static final Modifier requiredWidth(Modifier arg3, IntrinsicSize arg4) {
        IntrinsicKt$requiredWidth$$inlined$debugInspectorInfo$1 v1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v1 = new IntrinsicKt$requiredWidth$$inlined$debugInspectorInfo$1(arg4);
        }
        else {
            Function1 v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg3.then(new IntrinsicWidthElement(arg4, false, ((Function1)v1)));
    }

    public static final Modifier width(Modifier arg3, IntrinsicSize arg4) {
        IntrinsicKt$width$$inlined$debugInspectorInfo$1 v1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v1 = new IntrinsicKt$width$$inlined$debugInspectorInfo$1(arg4);
        }
        else {
            Function1 v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg3.then(new IntrinsicWidthElement(arg4, true, ((Function1)v1)));
    }
}

