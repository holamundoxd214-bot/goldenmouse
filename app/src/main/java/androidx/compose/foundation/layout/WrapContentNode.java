package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0018\u0010\u0007\u001A\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\b¢\u0006\u0004\b\f\u0010\rJ#\u0010\u001A\u001A\u00020\u001B*\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020 H\u0016¢\u0006\u0004\b!\u0010\"R\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u001A\u0010\u0005\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R,\u0010\u0007\u001A\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006#"}, d2={"Landroidx/compose/foundation/layout/WrapContentNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "direction", "Landroidx/compose/foundation/layout/Direction;", "unbounded", "", "alignmentCallback", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/IntOffset;", "<init>", "(Landroidx/compose/foundation/layout/Direction;ZLkotlin/jvm/functions/Function2;)V", "getDirection", "()Landroidx/compose/foundation/layout/Direction;", "setDirection", "(Landroidx/compose/foundation/layout/Direction;)V", "getUnbounded", "()Z", "setUnbounded", "(Z)V", "getAlignmentCallback", "()Lkotlin/jvm/functions/Function2;", "setAlignmentCallback", "(Lkotlin/jvm/functions/Function2;)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class WrapContentNode extends Node implements LayoutModifierNode {
    private Function2 alignmentCallback;
    private Direction direction;
    private boolean unbounded;

    public WrapContentNode(Direction arg1, boolean arg2, Function2 arg3) {
        super();
        this.direction = arg1;
        this.unbounded = arg2;
        this.alignmentCallback = arg3;
    }

    public final Function2 getAlignmentCallback() {
        return this.alignmentCallback;
    }

    public final Direction getDirection() {
        return this.direction;
    }

    public final boolean getUnbounded() {
        return this.unbounded;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg13, Measurable arg14, long arg15) {
        int v3 = 0;
        int v0 = this.direction != Direction.Vertical ? 0 : Constraints.getMinWidth-impl(arg15);
        if(this.direction != Direction.Horizontal) {
        }
        else {
            v3 = Constraints.getMinHeight-impl(arg15);
        }

        int v5 = 0x7FFFFFFF;
        int v2 = this.direction == Direction.Vertical || !this.unbounded ? Constraints.getMaxWidth-impl(arg15) : v5;
        if(this.direction == Direction.Horizontal || !this.unbounded) {
            v5 = Constraints.getMaxHeight-impl(arg15);
        }
        else {
        }

        Placeable v3_1 = arg14.measure-BRTryo0(ConstraintsKt.Constraints(v0, v2, v3, v5));
        v2 = RangesKt.coerceIn(v3_1.getWidth(), Constraints.getMinWidth-impl(arg15), Constraints.getMaxWidth-impl(arg15));
        int v4 = RangesKt.coerceIn(v3_1.getHeight(), Constraints.getMinHeight-impl(arg15), Constraints.getMaxHeight-impl(arg15));
        return MeasureScope.layout$default(arg13, v2, v4, null, new WrapContentNode$$ExternalSyntheticLambda0(this, v2, v3_1, v4, arg13), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$0(WrapContentNode arg7, int arg8, Placeable arg9, int arg10, MeasureScope arg11, PlacementScope arg12) {
        PlacementScope.place-70tqf50$default(arg12, arg9, arg7.alignmentCallback.invoke(IntSize.box-impl(IntSize.constructor-impl((((long)(arg8 - arg9.getWidth()))) << 0x20 | (((long)(arg10 - arg9.getHeight()))) & 0xFFFFFFFFL)), arg11.getLayoutDirection()).unbox-impl(), 0f, 2, null);
        return Unit.INSTANCE;
    }

    public final void setAlignmentCallback(Function2 arg1) {
        this.alignmentCallback = arg1;
    }

    public final void setDirection(Direction arg1) {
        this.direction = arg1;
    }

    public final void setUnbounded(boolean arg1) {
        this.unbounded = arg1;
    }
}

