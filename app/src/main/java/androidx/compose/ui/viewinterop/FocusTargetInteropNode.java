package androidx.compose.ui.viewinterop;

import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.layout.PinnableContainer$PinnedHandle;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\rH\u0002J\b\u0010\u000F\u001A\u00020\u000BH\u0016J\n\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0002R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Landroidx/compose/ui/viewinterop/FocusTargetInteropNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "<init>", "()V", "focusTargetNode", "Landroidx/compose/ui/focus/FocusTargetNode;", "pinnedHandle", "Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", "onFocusStateChange", "", "previousState", "Landroidx/compose/ui/focus/FocusState;", "currentState", "onObservedReadsChanged", "retrievePinnableContainer", "Landroidx/compose/ui/layout/PinnableContainer;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class FocusTargetInteropNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, ObserverModifierNode {
    private final FocusTargetNode focusTargetNode;
    private PinnedHandle pinnedHandle;

    public FocusTargetInteropNode() {
        super();
        this.focusTargetNode = this.delegate(new FocusTargetNode(0, true, new FocusTargetInteropNode$focusTargetNode$1(this), null, 9, null));
    }

    public static final void access$onFocusStateChange(FocusTargetInteropNode arg0, FocusState arg1, FocusState arg2) {
        arg0.onFocusStateChange(arg1, arg2);
    }

    private final void onFocusStateChange(FocusState arg2, FocusState arg3) {
        if(!ComposeUiFlags.isPinningFocusedAndroidViewsEnabled) {
        }
        else if(!this.isAttached()) {
        }
        else {
            boolean v3 = arg3.isFocused();
            if(v3 == arg2.isFocused()) {
                return;
            }

            goto label_10;
        }

        return;
    label_10:
        PinnedHandle v2 = null;
        if(v3) {
            PinnableContainer v3_1 = this.retrievePinnableContainer();
            if(v3_1 != null) {
                v2 = v3_1.pin();
            }

            this.pinnedHandle = v2;
            return;
        }

        PinnedHandle v3_2 = this.pinnedHandle;
        if(v3_2 != null) {
            v3_2.release();
        }

        this.pinnedHandle = v2;
    }

    public void onObservedReadsChanged() {
        PinnableContainer v0 = this.retrievePinnableContainer();
        if(this.focusTargetNode.getFocusState().isFocused()) {
            PinnedHandle v1 = this.pinnedHandle;
            if(v1 != null) {
                v1.release();
            }

            PinnedHandle v0_1 = v0 != null ? v0.pin() : null;
            this.pinnedHandle = v0_1;
        }
    }

    private final PinnableContainer retrievePinnableContainer() {
        ObjectRef v0 = new ObjectRef();
        ObserverModifierNodeKt.observeReads(this, new FocusTargetInteropNode$retrievePinnableContainer$1(v0, this));
        return v0.element;
    }
}

