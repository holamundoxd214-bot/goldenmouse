package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B-\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\"\u001A\u00020#2\u0006\u0010$\u001A\u00020%H\u0016¢\u0006\u0004\b&\u0010\u0019J\'\u0010\'\u001A\u00020#2\u0006\u0010(\u001A\u00020)2\u0006\u0010*\u001A\u00020+2\u0006\u0010,\u001A\u00020%H\u0016¢\u0006\u0004\b-\u0010.J\b\u0010/\u001A\u00020#H\u0016J3\u00100\u001A\u00020#2\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b1\u00102R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u00020\nX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0010R\u0014\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R+\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0013\u001A\u00020\u00148B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001C\u001A\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001ER\u000E\u0010\u001F\u001A\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2={"Landroidx/compose/material3/ClockDialNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "state", "Landroidx/compose/material3/AnalogTimePickerState;", "autoSwitchToMinute", "", "selection", "Landroidx/compose/material3/TimePickerSelectionMode;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "<init>", "(Landroidx/compose/material3/AnalogTimePickerState;ZILandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "offsetX", "offsetY", "<set-?>", "Landroidx/compose/ui/unit/IntOffset;", "center", "getCenter-nOcc-ac", "()J", "setCenter--gyyYBs", "(J)V", "center$delegate", "Landroidx/compose/runtime/MutableState;", "maxDist", "getMaxDist", "()F", "pointerInputTapNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "pointerInputDragNode", "onRemeasured", "", "size", "Landroidx/compose/ui/unit/IntSize;", "onRemeasured-ozmzZPI", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "updateNode", "updateNode-JwYzU44", "(Landroidx/compose/material3/AnalogTimePickerState;ZILandroidx/compose/animation/core/AnimationSpec;)V", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ClockDialNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, LayoutAwareModifierNode, PointerInputModifierNode {
    public static final int $stable = 8;
    private AnimationSpec animationSpec;
    private boolean autoSwitchToMinute;
    private final MutableState center$delegate;
    private float offsetX;
    private float offsetY;
    private final SuspendingPointerInputModifierNode pointerInputDragNode;
    private final SuspendingPointerInputModifierNode pointerInputTapNode;
    private int selection;
    private AnalogTimePickerState state;

    static {
    }

    public ClockDialNode(AnalogTimePickerState arg1, boolean arg2, int arg3, AnimationSpec arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    private ClockDialNode(AnalogTimePickerState arg1, boolean arg2, int arg3, AnimationSpec arg4) {
        super();
        this.state = arg1;
        this.autoSwitchToMinute = arg2;
        this.selection = arg3;
        this.animationSpec = arg4;
        this.center$delegate = SnapshotStateKt.mutableStateOf$default(IntOffset.box-impl(IntOffset.Companion.getZero-nOcc-ac()), null, 2, null);
        this.pointerInputTapNode = this.delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new ClockDialNode$pointerInputTapNode$1(this)));
        this.pointerInputDragNode = this.delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new ClockDialNode$pointerInputDragNode$1(this)));
    }

    public static final AnimationSpec access$getAnimationSpec$p(ClockDialNode arg0) {
        return arg0.animationSpec;
    }

    public static final boolean access$getAutoSwitchToMinute$p(ClockDialNode arg0) {
        return arg0.autoSwitchToMinute;
    }

    public static final long access$getCenter-nOcc-ac(ClockDialNode arg2) {
        return arg2.getCenter-nOcc-ac();
    }

    public static final float access$getMaxDist(ClockDialNode arg0) {
        return arg0.getMaxDist();
    }

    public static final float access$getOffsetX$p(ClockDialNode arg0) {
        return arg0.offsetX;
    }

    public static final float access$getOffsetY$p(ClockDialNode arg0) {
        return arg0.offsetY;
    }

    public static final AnalogTimePickerState access$getState$p(ClockDialNode arg0) {
        return arg0.state;
    }

    public static final void access$setOffsetX$p(ClockDialNode arg0, float arg1) {
        arg0.offsetX = arg1;
    }

    public static final void access$setOffsetY$p(ClockDialNode arg0, float arg1) {
        arg0.offsetY = arg1;
    }

    private final long getCenter-nOcc-ac() {
        return this.center$delegate.getValue().unbox-impl();
    }

    private final float getMaxDist() {
        Density v0 = DelegatableNodeKt.requireDensity(this);
        return v0.toPx-0680j_4(TimePickerKt.access$getMaxDistance$p()) * (((float)v0.roundToPx-0680j_4(this.state.getCurrentDiameter-D9Ej5fM()))) / (((float)v0.roundToPx-0680j_4(TimePickerTokens.INSTANCE.getClockDialContainerSize-D9Ej5fM())));
    }

    public void onCancelPointerInput() {
        this.pointerInputTapNode.onCancelPointerInput();
        this.pointerInputDragNode.onCancelPointerInput();
    }

    public void onPointerEvent-H0pRuoY(PointerEvent arg2, PointerEventPass arg3, long arg4) {
        this.pointerInputTapNode.onPointerEvent-H0pRuoY(arg2, arg3, arg4);
        this.pointerInputDragNode.onPointerEvent-H0pRuoY(arg2, arg3, arg4);
    }

    public void onRemeasured-ozmzZPI(long arg3) {
        this.setCenter--gyyYBs(IntSizeKt.getCenter-ozmzZPI(arg3));
        this.state.setCurrentDiameter-0680j_4(DelegatableNodeKt.requireDensity(((DelegatableNode)this)).toDp-u2uoSUM(((int)(arg3 >> 0x20))));
    }

    private final void setCenter--gyyYBs(long arg1) {
        this.center$delegate.setValue(IntOffset.box-impl(arg1));
    }

    public final void updateNode-JwYzU44(AnalogTimePickerState arg7, boolean arg8, int arg9, AnimationSpec arg10) {
        this.state = arg7;
        this.autoSwitchToMinute = arg8;
        this.animationSpec = arg10;
        if(!TimePickerSelectionMode.equals-impl0(this.selection, arg9)) {
            this.selection = arg9;
            BuildersKt.launch$default(this.getCoroutineScope(), null, null, new ClockDialNode$updateNode$1(arg7, arg10, null), 3, null);
        }
    }
}

