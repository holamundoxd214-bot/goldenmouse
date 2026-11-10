package androidx.compose.animation;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.node.LayoutModifierNode;
import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b!\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001C\u0010\u0005\u001A\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0006H\u0016J\u001C\u0010\u000B\u001A\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u0006H\u0016J\u001C\u0010\r\u001A\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0006H\u0016J\u001C\u0010\u000E\u001A\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u0006H\u0016¨\u0006\u000F"}, d2={"Landroidx/compose/animation/LayoutModifierNodeWithPassThroughIntrinsics;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "<init>", "()V", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class LayoutModifierNodeWithPassThroughIntrinsics extends Node implements LayoutModifierNode {
    public static final int $stable;

    static {
        LayoutModifierNodeWithPassThroughIntrinsics.$stable = Node.$stable;
    }

    public LayoutModifierNodeWithPassThroughIntrinsics() {
        super();
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return arg2.maxIntrinsicHeight(arg3);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return arg2.maxIntrinsicWidth(arg3);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return arg2.minIntrinsicHeight(arg3);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return arg2.minIntrinsicWidth(arg3);
    }
}

