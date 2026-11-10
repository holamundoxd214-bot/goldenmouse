package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001A \u0010\u0000\u001A\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005H\u0007\u001A#\u0010\u0006\u001A\u00020\u0005*\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tH\u0001¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2={"aspectRatio", "Landroidx/compose/ui/Modifier;", "ratio", "", "matchHeightConstraintsFirst", "", "isSatisfiedBy", "Landroidx/compose/ui/unit/Constraints;", "width", "", "height", "isSatisfiedBy-NN6Ew-U", "(JII)Z", "foundation-layout"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AspectRatioKt {
    public static final Modifier aspectRatio(Modifier arg2, float arg3, boolean arg4) {
        Function1 v1_1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            AspectRatioKt$aspectRatio$$inlined$debugInspectorInfo$1 v1 = new AspectRatioKt$aspectRatio$$inlined$debugInspectorInfo$1(arg3, arg4);
        }
        else {
            v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg2.then(new AspectRatioElement(arg3, arg4, v1_1));
    }

    public static Modifier aspectRatio$default(Modifier arg0, float arg1, boolean arg2, int arg3, Object arg4) {
        return AspectRatioKt.aspectRatio(arg0, arg1, false);
    }

    public static final boolean isSatisfiedBy-NN6Ew-U(long arg2, int arg4, int arg5) {
        int v0 = Constraints.getMinWidth-impl(arg2);
        if(arg4 <= Constraints.getMaxWidth-impl(arg2) && v0 <= arg4) {
            arg4 = Constraints.getMinHeight-impl(arg2);
            if(arg5 <= Constraints.getMaxHeight-impl(arg2) && arg4 <= arg5) {
                return 1;
            }
        }

        return 0;
    }
}

