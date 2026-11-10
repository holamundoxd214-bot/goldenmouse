package androidx.compose.material3.internal;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003Bg\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012H\u0010\u0006\u001AD\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000F\u0012\u0004\u0012\u00028\u00000\u000E0\u0007\u0012\u0006\u0010\u0010\u001A\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\"\u001A\u00020#H\u0016J#\u0010$\u001A\u00020%*\u00020&2\u0006\u0010\'\u001A\u00020(2\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b)\u0010*R \u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\\\u0010\u0006\u001AD\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000F\u0012\u0004\u0012\u00028\u00000\u000E0\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR\u001A\u0010\u0010\u001A\u00020\u0011X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001FR\u000E\u0010 \u001A\u00020!X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006+"}, d2={"Landroidx/compose/material3/internal/DraggableAnchorsNode;", "T", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "state", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "anchors", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", "size", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Lkotlin/Pair;", "Landroidx/compose/material3/internal/DraggableAnchors;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "<init>", "(Landroidx/compose/material3/internal/AnchoredDraggableState;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/gestures/Orientation;)V", "getState", "()Landroidx/compose/material3/internal/AnchoredDraggableState;", "setState", "(Landroidx/compose/material3/internal/AnchoredDraggableState;)V", "getAnchors", "()Lkotlin/jvm/functions/Function2;", "setAnchors", "(Lkotlin/jvm/functions/Function2;)V", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "setOrientation", "(Landroidx/compose/foundation/gestures/Orientation;)V", "didLookahead", "", "onDetach", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class DraggableAnchorsNode extends Node implements LayoutModifierNode {
    private Function2 anchors;
    private boolean didLookahead;
    private Orientation orientation;
    private AnchoredDraggableState state;

    public DraggableAnchorsNode(AnchoredDraggableState arg1, Function2 arg2, Orientation arg3) {
        super();
        this.state = arg1;
        this.anchors = arg2;
        this.orientation = arg3;
    }

    public final Function2 getAnchors() {
        return this.anchors;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final AnchoredDraggableState getState() {
        return this.state;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg8, Measurable arg9, long arg10) {
        Placeable v9 = arg9.measure-BRTryo0(arg10);
        if(!arg8.isLookingAhead() || !this.didLookahead) {
            Object v10 = this.anchors.invoke(IntSize.box-impl(IntSize.constructor-impl((((long)v9.getHeight())) & 0xFFFFFFFFL | (((long)v9.getWidth())) << 0x20)), Constraints.box-impl(arg10));
            this.state.updateAnchors(((Pair)v10).getFirst(), ((Pair)v10).getSecond());
        }

        boolean v10_1 = (arg8.isLookingAhead()) || (this.didLookahead) ? true : false;
        this.didLookahead = v10_1;
        return MeasureScope.layout$default(arg8, v9.getWidth(), v9.getHeight(), null, new DraggableAnchorsNode$$ExternalSyntheticLambda0(arg8, this, v9), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$1(MeasureScope arg3, DraggableAnchorsNode arg4, Placeable arg5, PlacementScope arg6) {
        float v3 = arg3.isLookingAhead() ? arg4.state.getAnchors().positionOf(arg4.state.getTargetValue()) : arg4.state.requireOffset();
        float v0 = arg4.orientation == Orientation.Horizontal ? v3 : 0f;
        if(arg4.orientation == Orientation.Vertical) {
        }
        else {
            v3 = 0f;
        }

        arg6.withMotionFrameOfReferencePlacement(new DraggableAnchorsNode$$ExternalSyntheticLambda1(arg5, v0, v3));
        return Unit.INSTANCE;
    }

    static final Unit measure_3p2s80s$lambda$1$lambda$0(Placeable arg7, float arg8, float arg9, PlacementScope arg10) {
        PlacementScope.place$default(arg10, arg7, MathKt.roundToInt(arg8), MathKt.roundToInt(arg9), 0f, 4, null);
        return Unit.INSTANCE;
    }

    public void onDetach() {
        this.didLookahead = false;
    }

    public final void setAnchors(Function2 arg1) {
        this.anchors = arg1;
    }

    public final void setOrientation(Orientation arg1) {
        this.orientation = arg1;
    }

    public final void setState(AnchoredDraggableState arg1) {
        this.state = arg1;
    }
}

