package androidx.compose.foundation;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u001D\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"checkScrollableContainerConstraints", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "checkScrollableContainerConstraints-K40F9xA", "(JLandroidx/compose/foundation/gestures/Orientation;)V", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class CheckScrollableContainerConstraintsKt {
    public static final void checkScrollableContainerConstraints-K40F9xA(long arg4, Orientation arg6) {
        int v1 = 1;
        int v3 = 0x7FFFFFFF;
        if(arg6 == Orientation.Vertical) {
            if(Constraints.getMaxHeight-impl(arg4) != v3) {
            }
            else {
                v1 = 0;
            }

            if(v1 != 0) {
                return;
            }

            InlineClassHelperKt.throwIllegalStateException("Vertically scrollable component was measured with an infinity maximum height constraints, which is disallowed. One of the common reasons is nesting layouts like LazyColumn and Column(Modifier.verticalScroll()). If you want to add a header before the list of items please add a header as a separate item() before the main items() inside the LazyColumn scope. There could be other reasons for this to happen: your ComposeView was added into a LinearLayout with some weight, you applied Modifier.wrapContentSize(unbounded = true) or wrote a custom layout. Please try to remove the source of infinite constraints in the hierarchy above the scrolling container.");
            return;
        }
        else {
            if(Constraints.getMaxWidth-impl(arg4) != v3) {
            }
            else {
                v1 = 0;
            }

            if(v1 != 0) {
                return;
            }

            InlineClassHelperKt.throwIllegalStateException("Horizontally scrollable component was measured with an infinity maximum width constraints, which is disallowed. One of the common reasons is nesting layouts like LazyRow and Row(Modifier.horizontalScroll()). If you want to add a header before the list of items please add a header as a separate item() before the main items() inside the LazyRow scope. There could be other reasons for this to happen: your ComposeView was added into a LinearLayout with some weight, you applied Modifier.wrapContentSize(unbounded = true) or wrote a custom layout. Please try to remove the source of infinite constraints in the hierarchy above the scrolling container.");
        }
    }
}

