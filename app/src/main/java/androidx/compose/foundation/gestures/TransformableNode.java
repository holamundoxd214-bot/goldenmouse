package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B3\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0006\u0010\n\u001A\u00020\t\u0012\u0006\u0010\u000B\u001A\u00020\t¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0014\u001A\u00020\u0015H\u0016J2\u0010\u0019\u001A\u00020\u00152\u0006\u0010\u0004\u001A\u00020\u00052\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\tJ\'\u0010\u001A\u001A\u00020\u00152\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\b\u0010#\u001A\u00020\u0015H\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001A\u0004\u0018\u00010\u0002X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006$"}, d2={"Landroidx/compose/foundation/gestures/TransformableNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "state", "Landroidx/compose/foundation/gestures/TransformableState;", "canPan", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "", "lockRotationOnZoomPan", "enabled", "<init>", "(Landroidx/compose/foundation/gestures/TransformableState;Lkotlin/jvm/functions/Function1;ZZ)V", "updatedCanPan", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/TransformEvent;", "scrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "onAttach", "", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "pointerInputModifierMouse", "update", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class TransformableNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, PointerInputModifierNode {
    private Function1 canPan;
    private final Channel channel;
    private boolean enabled;
    private boolean lockRotationOnZoomPan;
    private PointerInputModifierNode pointerInputModifierMouse;
    private final SuspendingPointerInputModifierNode pointerInputNode;
    private ScrollConfig scrollConfig;
    private TransformableState state;
    private final Function1 updatedCanPan;

    public TransformableNode(TransformableState arg1, Function1 arg2, boolean arg3, boolean arg4) {
        super();
        this.state = arg1;
        this.canPan = arg2;
        this.lockRotationOnZoomPan = arg3;
        this.enabled = arg4;
        this.updatedCanPan = new TransformableNode$$ExternalSyntheticLambda0(this);
        this.channel = ChannelKt.Channel$default(0x7FFFFFFF, null, null, 6, null);
        this.pointerInputNode = this.delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new TransformableNode$pointerInputNode$1(this)));
    }

    public static final Channel access$getChannel$p(TransformableNode arg0) {
        return arg0.channel;
    }

    public static final boolean access$getEnabled$p(TransformableNode arg0) {
        return arg0.enabled;
    }

    public static final boolean access$getLockRotationOnZoomPan$p(TransformableNode arg0) {
        return arg0.lockRotationOnZoomPan;
    }

    public static final TransformableState access$getState$p(TransformableNode arg0) {
        return arg0.state;
    }

    public static final Function1 access$getUpdatedCanPan$p(TransformableNode arg0) {
        return arg0.updatedCanPan;
    }

    public void onAttach() {
        super.onAttach();
        this.scrollConfig = AndroidScrollable_androidKt.platformScrollConfig(this);
    }

    public void onCancelPointerInput() {
        this.pointerInputNode.onCancelPointerInput();
        PointerInputModifierNode v1 = this.pointerInputModifierMouse;
        if(v1 != null) {
            v1.onCancelPointerInput();
        }
    }

    public void onPointerEvent-H0pRuoY(PointerEvent arg7, PointerEventPass arg8, long arg9) {
        ScrollConfig v0 = this.scrollConfig;
        if(this.enabled) {
            List v1 = arg7.getChanges();
            int v2 = v1.size();
            int v3 = 0;
            while(v3 < v2) {
                if(!PointerType.equals-impl0(v1.get(v3).getType-T8wyACA(), PointerType.Companion.getMouse-T8wyACA())) {
                    ++v3;
                    continue;
                }
                else if(v0 != null && this.pointerInputModifierMouse == null) {
                    this.pointerInputModifierMouse = this.delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new TransformableNode$onPointerEvent$2(this, v0)));
                }

                break;
            }
        }

        this.pointerInputNode.onPointerEvent-H0pRuoY(arg7, arg8, arg9);
        PointerInputModifierNode v6 = this.pointerInputModifierMouse;
        if(v6 != null) {
            v6.onPointerEvent-H0pRuoY(arg7, arg8, arg9);
        }
    }

    public final void update(TransformableState arg1, Function1 arg2, boolean arg3, boolean arg4) {
        this.canPan = arg2;
        if((Intrinsics.areEqual(this.state, arg1)) && this.enabled == arg4) {
            if(this.lockRotationOnZoomPan != arg3) {
            }
            else {
                return;
            }
        }

        this.state = arg1;
        this.enabled = arg4;
        this.lockRotationOnZoomPan = arg3;
        this.pointerInputNode.resetPointerInputHandler();
    }

    static final boolean updatedCanPan$lambda$0(TransformableNode arg0, Offset arg1) {
        return arg0.canPan.invoke(arg1).booleanValue();
    }
}

