package androidx.compose.foundation.text.handwriting;

import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusRequesterModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0011\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0015\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000F\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u0011H\u0016J\'\u0010\u0018\u001A\u00020\u00072\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001EH\u0016¢\u0006\u0004\b\u001F\u0010 J\b\u0010!\u001A\u00020\u0007H\u0016J\u0006\u0010\"\u001A\u00020\u0007R \u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\tR\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001A\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015R\u000E\u0010\u0016\u001A\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2={"Landroidx/compose/foundation/text/handwriting/StylusHandwritingNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "onHandwritingSlopExceeded", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "getOnHandwritingSlopExceeded", "()Lkotlin/jvm/functions/Function0;", "setOnHandwritingSlopExceeded", "focused", "", "onFocusEvent", "focusState", "Landroidx/compose/ui/focus/FocusState;", "touchBoundsExpansion", "Landroidx/compose/ui/node/TouchBoundsExpansion;", "getTouchBoundsExpansion-RZrCHBk", "()J", "suspendingPointerInputModifierNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "resetPointerInputHandler", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public class StylusHandwritingNode extends DelegatingNode implements FocusEventModifierNode, FocusRequesterModifierNode, PointerInputModifierNode {
    public static final int $stable = 8;
    private boolean focused;
    private Function0 onHandwritingSlopExceeded;
    private final SuspendingPointerInputModifierNode suspendingPointerInputModifierNode;

    static {
    }

    public StylusHandwritingNode(Function0 arg1) {
        super();
        this.onHandwritingSlopExceeded = arg1;
        this.suspendingPointerInputModifierNode = this.delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new StylusHandwritingNode$suspendingPointerInputModifierNode$1(this)));
    }

    public static final boolean access$getFocused$p(StylusHandwritingNode arg0) {
        return arg0.focused;
    }

    public final Function0 getOnHandwritingSlopExceeded() {
        return this.onHandwritingSlopExceeded;
    }

    public long getTouchBoundsExpansion-RZrCHBk() {
        return StylusHandwritingKt.getHandwritingBoundsExpansion().roundToTouchBoundsExpansion-TW6G1oQ(DelegatableNodeKt.requireDensity(((DelegatableNode)this)));
    }

    public void onCancelPointerInput() {
        this.suspendingPointerInputModifierNode.onCancelPointerInput();
    }

    public void onFocusEvent(FocusState arg1) {
        this.focused = arg1.isFocused();
    }

    public void onPointerEvent-H0pRuoY(PointerEvent arg1, PointerEventPass arg2, long arg3) {
        this.suspendingPointerInputModifierNode.onPointerEvent-H0pRuoY(arg1, arg2, arg3);
    }

    public final void resetPointerInputHandler() {
        this.suspendingPointerInputModifierNode.resetPointerInputHandler();
    }

    public final void setOnHandwritingSlopExceeded(Function0 arg1) {
        this.onHandwritingSlopExceeded = arg1;
    }
}

