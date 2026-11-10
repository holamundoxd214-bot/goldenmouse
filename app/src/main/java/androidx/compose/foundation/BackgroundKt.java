package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001A%\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001A(\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0003\u0010\n\u001A\u00020\u000BH\u0007¨\u0006\f"}, d2={"background", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "shape", "Landroidx/compose/ui/graphics/Shape;", "background-bw27NRU", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BackgroundKt {
    public static final Modifier background(Modifier arg9, Brush arg10, Shape arg11, float arg12) {
        BackgroundKt$background$$inlined$debugInspectorInfo$1 v1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v1 = new BackgroundKt$background$$inlined$debugInspectorInfo$1(arg12, arg10, arg11);
        }
        else {
            Function1 v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg9.then(new BackgroundElement(0, arg10, arg12, arg11, v1, 1, null));
    }

    public static Modifier background$default(Modifier arg0, Brush arg1, Shape arg2, float arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = RectangleShapeKt.getRectangleShape();
        }

        if((arg4 & 4) != 0) {
            arg3 = 1f;
        }

        return BackgroundKt.background(arg0, arg1, arg2, arg3);
    }

    public static final Modifier background-bw27NRU(Modifier arg10, long arg11, Shape arg13) {
        Function1 v0_1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            BackgroundKt$background-bw27NRU$$inlined$debugInspectorInfo$1 v0 = new BackgroundKt$background-bw27NRU$$inlined$debugInspectorInfo$1(arg11, arg13);
        }
        else {
            v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg10.then(new BackgroundElement(arg11, null, 1f, arg13, ((BackgroundKt$background-bw27NRU$$inlined$debugInspectorInfo$1)v0_1), 2, null));
    }

    public static Modifier background-bw27NRU$default(Modifier arg0, long arg1, Shape arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg3 = RectangleShapeKt.getRectangleShape();
        }

        return BackgroundKt.background-bw27NRU(arg0, arg1, arg3);
    }
}

