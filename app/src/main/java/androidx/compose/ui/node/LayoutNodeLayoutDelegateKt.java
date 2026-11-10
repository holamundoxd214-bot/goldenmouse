package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\u001A9\u0010\u0004\u001A\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u00020\u00022\f\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00060\t2\u0012\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00060\u000BH\u0080\b\"\u0018\u0010\u0000\u001A\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0000\u0010\u0003\"\u000E\u0010\f\u001A\u00020\rX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"isOutMostLookaheadRoot", "", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)Z", "updateChildMeasurables", "", "T", "Landroidx/compose/ui/layout/Measurable;", "destination", "Landroidx/compose/runtime/collection/MutableVector;", "transform", "Lkotlin/Function1;", "MeasuredTwiceErrorMessage", "", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LayoutNodeLayoutDelegateKt {
    public static final String MeasuredTwiceErrorMessage = "measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()";

    public static final boolean isOutMostLookaheadRoot(LayoutNode arg1) {
        if(arg1.getLookaheadRoot$ui() != null) {
            LayoutNode v0 = arg1.getParent$ui();
            v0 = v0 != null ? v0.getLookaheadRoot$ui() : null;
            if(v0 != null && !arg1.getLayoutDelegate$ui().getDetachedFromParentLookaheadPass$ui()) {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    public static final void updateChildMeasurables(LayoutNode arg5, MutableVector arg6, Function1 arg7) {
        MutableVector v0 = arg5.get_children$ui();
        Object[] v1 = v0.content;
        int v0_1 = v0.getSize();
        int v2;
        for(v2 = 0; v2 < v0_1; ++v2) {
            Object v3 = v1[v2];
            if(arg6.getSize() <= v2) {
                arg6.add(arg7.invoke(v3));
            }
            else {
                arg6.set(v2, arg7.invoke(v3));
            }
        }

        arg6.removeRange(arg5.getChildren$ui().size(), arg6.getSize());
    }
}

