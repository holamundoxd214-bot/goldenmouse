package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A@\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\b\b\u0003\u0010\u0002\u001A\u00020\u00032\b\b\u0003\u0010\u0004\u001A\u00020\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\u0012\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\tH\u0007\u001A:\u0010\f\u001A\u00020\r2\b\b\u0003\u0010\u0002\u001A\u00020\u00032\b\b\u0003\u0010\u0004\u001A\u00020\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\u0012\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\t¨\u0006\u000E"}, d2={"onVisibilityChanged", "Landroidx/compose/ui/Modifier;", "minDurationMs", "", "minFractionVisible", "", "viewportBounds", "Landroidx/compose/ui/layout/LayoutBoundsHolder;", "callback", "Lkotlin/Function1;", "", "", "onVisibilityChangedNode", "Landroidx/compose/ui/node/DelegatableNode;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class OnVisibilityChangedModifierKt {
    public static final Modifier onVisibilityChanged(Modifier arg6, long arg7, float arg9, LayoutBoundsHolder arg10, Function1 arg11) {
        return arg6.then(new OnVisibilityChangedElement(arg7, arg9, arg10, arg11));
    }

    public static Modifier onVisibilityChanged$default(Modifier arg6, long arg7, float arg9, LayoutBoundsHolder arg10, Function1 arg11, int arg12, Object arg13) {
        if((arg12 & 1) != 0) {
            arg7 = 0;
        }

        long v1 = arg7;
        if((arg12 & 2) != 0) {
            arg9 = 1f;
        }

        float v3 = arg9;
        if((arg12 & 4) != 0) {
            arg10 = null;
        }

        return OnVisibilityChangedModifierKt.onVisibilityChanged(arg6, v1, v3, arg10, arg11);
    }

    public static final DelegatableNode onVisibilityChangedNode(long arg6, float arg8, LayoutBoundsHolder arg9, Function1 arg10) {
        return new OnVisibilityChangedNode(arg6, arg8, arg9, arg10);
    }

    public static DelegatableNode onVisibilityChangedNode$default(long arg0, float arg2, LayoutBoundsHolder arg3, Function1 arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg0 = 0;
        }

        if((arg5 & 2) != 0) {
            arg2 = 1f;
        }

        if((arg5 & 4) != 0) {
            arg3 = null;
        }

        return OnVisibilityChangedModifierKt.onVisibilityChangedNode(arg0, arg2, arg3, arg4);
    }
}

