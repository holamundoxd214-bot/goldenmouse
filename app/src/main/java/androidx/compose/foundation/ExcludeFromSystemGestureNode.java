package androidx.compose.foundation;

import android.graphics.Rect;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001D\u0012\u0014\u0010\u0002\u001A\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0016\u0010\u000B\u001A\u00020\f2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u000E"}, d2={"Landroidx/compose/foundation/ExcludeFromSystemGestureNode;", "Landroidx/compose/foundation/RectListNode;", "rect", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "currentRects", "Landroidx/compose/runtime/collection/MutableVector;", "Landroid/graphics/Rect;", "updateRects", "", "rects", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class ExcludeFromSystemGestureNode extends RectListNode {
    public ExcludeFromSystemGestureNode(Function1 arg1) {
        super(arg1);
    }

    public MutableVector currentRects() {
        MutableVector v0 = new MutableVector(new Rect[16], 0);
        v0.addAll(v0.getSize(), this.getView().getSystemGestureExclusionRects());
        return v0;
    }

    public void updateRects(MutableVector arg1) {
        this.getView().setSystemGestureExclusionRects(arg1.asMutableList());
    }
}

