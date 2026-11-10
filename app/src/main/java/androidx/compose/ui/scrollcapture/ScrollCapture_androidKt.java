package androidx.compose.ui.scrollcapture;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsOwnerKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\u001A.\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0002\u001A!\u0010\u0017\u001A\u00020\u0001*\u00020\u00032\u0012\u0010\u0018\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00140\u0007H\u0082\b\u001A\u0012\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00030\u001A*\u00020\u0003H\u0002\"E\u0010\t\u001A/\b\u0001\u0012\u0013\u0012\u00110\u000B¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\u000F\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\n*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012\"\u0018\u0010\u0013\u001A\u00020\u0014*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016¨\u0006\u001B"}, d2={"visitScrollCaptureCandidates", "", "fromNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "depth", "", "onCandidate", "Lkotlin/Function1;", "Landroidx/compose/ui/scrollcapture/ScrollCaptureCandidate;", "scrollCaptureScrollByAction", "Lkotlin/Function2;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "offset", "Lkotlin/coroutines/Continuation;", "", "getScrollCaptureScrollByAction", "(Landroidx/compose/ui/semantics/SemanticsNode;)Lkotlin/jvm/functions/Function2;", "canScrollVertically", "", "getCanScrollVertically", "(Landroidx/compose/ui/semantics/SemanticsNode;)Z", "visitDescendants", "onNode", "getChildrenForSearch", "", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ScrollCapture_androidKt {
    private static final boolean getCanScrollVertically(SemanticsNode arg2) {
        Function2 v0 = ScrollCapture_androidKt.getScrollCaptureScrollByAction(arg2);
        Object v2 = SemanticsConfigurationKt.getOrNull(arg2.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
        if(v0 != null && v2 != null && ((ScrollAxisRange)v2).getMaxValue().invoke().floatValue() > 0f) {
            return 1;
        }

        return 0;
    }

    private static final List getChildrenForSearch(SemanticsNode arg1) {
        return arg1.getChildren$ui(false, false, false);
    }

    public static final Function2 getScrollCaptureScrollByAction(SemanticsNode arg1) {
        return SemanticsConfigurationKt.getOrNull(arg1.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getScrollByOffset());
    }

    private static final void visitDescendants(SemanticsNode arg3, Function1 arg4) {
        MutableVector v0 = new MutableVector(new SemanticsNode[16], 0);
        v0.addAll(v0.getSize(), ScrollCapture_androidKt.getChildrenForSearch(arg3));
        while(v0.getSize() != 0) {
            Object v3 = v0.removeAt(v0.getSize() - 1);
            if(!arg4.invoke(v3).booleanValue()) {
                continue;
            }

            v0.addAll(v0.getSize(), ScrollCapture_androidKt.getChildrenForSearch(((SemanticsNode)v3)));
        }
    }

    private static final void visitScrollCaptureCandidates(SemanticsNode arg6, int arg7, Function1 arg8) {
        IntRect v4;
        LayoutCoordinates v3_1;
        Object v6_1;
        MutableVector v0 = new MutableVector(new SemanticsNode[16], 0);
        List v6 = ScrollCapture_androidKt.getChildrenForSearch(arg6);
        while(true) {
        label_6:
            v0.addAll(v0.getSize(), v6);
            while(true) {
            label_8:
                if(v0.getSize() == 0) {
                    return;
                }

                v6_1 = v0.removeAt(v0.getSize() - 1);
                if(SemanticsOwnerKt.isHidden(((SemanticsNode)v6_1))) {
                    continue;
                }

                if(((SemanticsNode)v6_1).getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getDisabled())) {
                    continue;
                }

                NodeCoordinator v3 = ((SemanticsNode)v6_1).findCoordinatorToGetBounds$ui();
                if(v3 == null) {
                    goto label_41;
                }

                v3_1 = v3.getCoordinates();
                v4 = IntRectKt.roundToIntRect(LayoutCoordinatesKt.boundsInWindow$default(v3_1, false, 1, null));
                if(v4.isEmpty()) {
                    continue;
                }

                if(ScrollCapture_androidKt.getCanScrollVertically(((SemanticsNode)v6_1))) {
                    break;
                }

                v6 = ScrollCapture_androidKt.getChildrenForSearch(((SemanticsNode)v6_1));
                goto label_6;
            }
        }

        int v1 = 1 + arg7;
        arg8.invoke(new ScrollCaptureCandidate(((SemanticsNode)v6_1), v1, v4, v3_1));
        ScrollCapture_androidKt.visitScrollCaptureCandidates(((SemanticsNode)v6_1), v1, arg8);
        goto label_8;
    label_41:
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Expected semantics node to have a coordinator.");
        throw new KotlinNothingValueException();
    }

    static void visitScrollCaptureCandidates$default(SemanticsNode arg0, int arg1, Function1 arg2, int arg3, Object arg4) {
        ScrollCapture_androidKt.visitScrollCaptureCandidates(arg0, 0, arg2);
    }
}

