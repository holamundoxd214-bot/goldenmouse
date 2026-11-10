package androidx.compose.foundation;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001F\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0014\u001A\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001AH\u0016¢\u0006\u0004\b\u001B\u0010\u001CJ\u001C\u0010\u001D\u001A\u00020\u001E*\u00020\u001F2\u0006\u0010\u0017\u001A\u00020 2\u0006\u0010!\u001A\u00020\u001EH\u0016J\u001C\u0010\"\u001A\u00020\u001E*\u00020\u001F2\u0006\u0010\u0017\u001A\u00020 2\u0006\u0010#\u001A\u00020\u001EH\u0016J\u001C\u0010$\u001A\u00020\u001E*\u00020\u001F2\u0006\u0010\u0017\u001A\u00020 2\u0006\u0010!\u001A\u00020\u001EH\u0016J\u001C\u0010%\u001A\u00020\u001E*\u00020\u001F2\u0006\u0010\u0017\u001A\u00020 2\u0006\u0010#\u001A\u00020\u001EH\u0016J\f\u0010&\u001A\u00020\'*\u00020(H\u0016R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u001A\u0010\u0006\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001A\u0010\b\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\u0010\"\u0004\b\u0013\u0010\u0012¨\u0006)"}, d2={"Landroidx/compose/foundation/ScrollNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "state", "Landroidx/compose/foundation/ScrollState;", "reverseScrolling", "", "isVertical", "<init>", "(Landroidx/compose/foundation/ScrollState;ZZ)V", "getState", "()Landroidx/compose/foundation/ScrollState;", "setState", "(Landroidx/compose/foundation/ScrollState;)V", "getReverseScrolling", "()Z", "setReverseScrolling", "(Z)V", "setVertical", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "applySemantics", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ScrollNode extends Node implements LayoutModifierNode, SemanticsModifierNode {
    public static final int $stable = 8;
    private boolean isVertical;
    private boolean reverseScrolling;
    private ScrollState state;

    public static Unit $r8$lambda$qfP45ywNvrYHUcu7PsfDl2M4bK8(Placeable arg0, int arg1, int arg2, PlacementScope arg3) {
        return ScrollNode.measure_3p2s80s$lambda$0$0(arg0, arg1, arg2, arg3);
    }

    static {
    }

    public ScrollNode(ScrollState arg1, boolean arg2, boolean arg3) {
        super();
        this.state = arg1;
        this.reverseScrolling = arg2;
        this.isVertical = arg3;
    }

    public void applySemantics(SemanticsPropertyReceiver arg5) {
        SemanticsPropertiesKt.setTraversalGroup(arg5, true);
        ScrollAxisRange v0 = new ScrollAxisRange(new ScrollNode$$ExternalSyntheticLambda2(this), new ScrollNode$$ExternalSyntheticLambda3(this), this.reverseScrolling);
        if(this.isVertical) {
            SemanticsPropertiesKt.setVerticalScrollAxisRange(arg5, v0);
            return;
        }

        SemanticsPropertiesKt.setHorizontalScrollAxisRange(arg5, v0);
    }

    static final float applySemantics$lambda$0(ScrollNode arg0) {
        return ((float)arg0.state.getValue());
    }

    static final float applySemantics$lambda$1(ScrollNode arg0) {
        return ((float)arg0.state.getMaxValue());
    }

    public final boolean getReverseScrolling() {
        return this.reverseScrolling;
    }

    public final ScrollState getState() {
        return this.state;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        if(this.isVertical) {
        }
        else {
            arg3 = 0x7FFFFFFF;
        }

        return arg2.maxIntrinsicHeight(arg3);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        if(this.isVertical) {
            arg3 = 0x7FFFFFFF;
        }

        return arg2.maxIntrinsicWidth(arg3);
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg11, Measurable arg12, long arg13) {
        Orientation v0 = this.isVertical ? Orientation.Vertical : Orientation.Horizontal;
        CheckScrollableContainerConstraintsKt.checkScrollableContainerConstraints-K40F9xA(arg13, v0);
        int v1 = 0x7FFFFFFF;
        int v7 = this.isVertical ? v1 : Constraints.getMaxHeight-impl(arg13);
        if(this.isVertical) {
            v1 = Constraints.getMaxWidth-impl(arg13);
        }

        Placeable v12 = arg12.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(arg13, 0, v1, 0, v7, 5, null));
        v1 = RangesKt.coerceAtMost(v12.getWidth(), Constraints.getMaxWidth-impl(arg13));
        int v2 = RangesKt.coerceAtMost(v12.getHeight(), Constraints.getMaxHeight-impl(arg13));
        int v13 = v12.getHeight() - v2;
        int v14 = v12.getWidth() - v1;
        if(this.isVertical) {
        }
        else {
            v13 = v14;
        }

        this.state.setMaxValue$foundation(v13);
        ScrollState v14_1 = this.state;
        int v0_1 = this.isVertical ? v2 : v1;
        v14_1.setViewportSize$foundation(v0_1);
        v14_1 = this.state;
        v0_1 = this.isVertical ? v12.getHeight() : v12.getWidth();
        v14_1.setContentSize$foundation(v0_1);
        return MeasureScope.layout$default(arg11, v1, v2, null, new ScrollNode$$ExternalSyntheticLambda0(this, v13, v12), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$0(ScrollNode arg3, int arg4, Placeable arg5, PlacementScope arg6) {
        int v0 = arg3.state.getValue();
        int v1 = 0;
        if(v0 < 0) {
            v0 = 0;
        }

        if(v0 > arg4) {
            v0 = arg4;
        }

        if(arg3.reverseScrolling) {
            v0 -= arg4;
        }
        else {
            v0 = -v0;
        }

        boolean v3 = arg3.isVertical;
        arg4 = v3 ? 0 : v0;
        if(v3) {
            v1 = v0;
        }

        arg6.withMotionFrameOfReferencePlacement(new ScrollNode$$ExternalSyntheticLambda1(arg5, arg4, v1));
        return Unit.INSTANCE;
    }

    private static final Unit measure_3p2s80s$lambda$0$0(Placeable arg8, int arg9, int arg10, PlacementScope arg11) {
        PlacementScope.placeRelativeWithLayer$default(arg11, arg8, arg9, arg10, 0f, null, 12, null);
        return Unit.INSTANCE;
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        if(this.isVertical) {
        }
        else {
            arg3 = 0x7FFFFFFF;
        }

        return arg2.minIntrinsicHeight(arg3);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        if(this.isVertical) {
            arg3 = 0x7FFFFFFF;
        }

        return arg2.minIntrinsicWidth(arg3);
    }

    public final void setReverseScrolling(boolean arg1) {
        this.reverseScrolling = arg1;
    }

    public final void setState(ScrollState arg1) {
        this.state = arg1;
    }

    public final void setVertical(boolean arg1) {
        this.isVertical = arg1;
    }
}

