package androidx.compose.foundation.text.handwriting;

import androidx.compose.foundation.text.input.internal.ComposeInputMethodManager;
import androidx.compose.foundation.text.input.internal.ComposeInputMethodManager_androidKt;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\'\u0010\u0011\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001A\u001A\u00020\u0005H\u0016R \u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007R\u001B\u0010\u000B\u001A\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u001B\u001A\u00020\u001C¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001ER\u0014\u0010\u001F\u001A\u00020 8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\"¨\u0006#"}, d2={"Landroidx/compose/foundation/text/handwriting/HandwritingDetectorNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "callback", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "getCallback", "()Lkotlin/jvm/functions/Function0;", "setCallback", "composeImm", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "getComposeImm", "()Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "composeImm$delegate", "Lkotlin/Lazy;", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "pointerInputNode", "Landroidx/compose/foundation/text/handwriting/StylusHandwritingNode;", "getPointerInputNode", "()Landroidx/compose/foundation/text/handwriting/StylusHandwritingNode;", "touchBoundsExpansion", "Landroidx/compose/ui/node/TouchBoundsExpansion;", "getTouchBoundsExpansion-RZrCHBk", "()J", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class HandwritingDetectorNode extends DelegatingNode implements PointerInputModifierNode {
    private Function0 callback;
    private final Lazy composeImm$delegate;
    private final StylusHandwritingNode pointerInputNode;

    public HandwritingDetectorNode(Function0 arg2) {
        super();
        this.callback = arg2;
        this.composeImm$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new HandwritingDetectorNode$$ExternalSyntheticLambda0(this));
        this.pointerInputNode = this.delegate(new StylusHandwritingNode(new HandwritingDetectorNode$$ExternalSyntheticLambda1(this)));
    }

    static final ComposeInputMethodManager composeImm_delegate$lambda$0(HandwritingDetectorNode arg0) {
        return ComposeInputMethodManager_androidKt.ComposeInputMethodManager(DelegatableNode_androidKt.requireView(((DelegatableNode)arg0)));
    }

    public final Function0 getCallback() {
        return this.callback;
    }

    private final ComposeInputMethodManager getComposeImm() {
        return this.composeImm$delegate.getValue();
    }

    public final StylusHandwritingNode getPointerInputNode() {
        return this.pointerInputNode;
    }

    public long getTouchBoundsExpansion-RZrCHBk() {
        return this.pointerInputNode.getTouchBoundsExpansion-RZrCHBk();
    }

    public void onCancelPointerInput() {
        this.pointerInputNode.onCancelPointerInput();
    }

    public void onPointerEvent-H0pRuoY(PointerEvent arg1, PointerEventPass arg2, long arg3) {
        this.pointerInputNode.onPointerEvent-H0pRuoY(arg1, arg2, arg3);
    }

    static final Unit pointerInputNode$lambda$0(HandwritingDetectorNode arg1) {
        arg1.callback.invoke();
        arg1.getComposeImm().prepareStylusHandwritingDelegation();
        return Unit.INSTANCE;
    }

    public final void setCallback(Function0 arg1) {
        this.callback = arg1;
    }
}

