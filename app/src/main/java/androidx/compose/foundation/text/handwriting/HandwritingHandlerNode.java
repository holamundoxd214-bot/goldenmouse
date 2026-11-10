package androidx.compose.foundation.text.handwriting;

import androidx.compose.foundation.text.input.internal.ComposeInputMethodManager;
import androidx.compose.foundation.text.input.internal.ComposeInputMethodManager_androidKt;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0005\u001A\u00020\u0006H\u0016R\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u001B\u0010\u0007\u001A\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\t\u0010\n¨\u0006\u000F"}, d2={"Landroidx/compose/foundation/text/handwriting/HandwritingHandlerNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "<init>", "()V", "focusState", "Landroidx/compose/ui/focus/FocusState;", "composeImm", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "getComposeImm", "()Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "composeImm$delegate", "Lkotlin/Lazy;", "onFocusEvent", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class HandwritingHandlerNode extends Node implements FocusEventModifierNode {
    private final Lazy composeImm$delegate;
    private FocusState focusState;

    public HandwritingHandlerNode() {
        super();
        this.composeImm$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new HandwritingHandlerNode$$ExternalSyntheticLambda0(this));
    }

    public static final ComposeInputMethodManager access$getComposeImm(HandwritingHandlerNode arg0) {
        return arg0.getComposeImm();
    }

    static final ComposeInputMethodManager composeImm_delegate$lambda$0(HandwritingHandlerNode arg0) {
        return ComposeInputMethodManager_androidKt.ComposeInputMethodManager(DelegatableNode_androidKt.requireView(((DelegatableNode)arg0)));
    }

    private final ComposeInputMethodManager getComposeImm() {
        return this.composeImm$delegate.getValue();
    }

    public void onFocusEvent(FocusState arg7) {
        if(!Intrinsics.areEqual(this.focusState, arg7)) {
            this.focusState = arg7;
            if(arg7.getHasFocus()) {
                BuildersKt.launch$default(this.getCoroutineScope(), null, null, new HandwritingHandlerNode$onFocusEvent$1(this, null), 3, null);
            }
        }
    }
}

