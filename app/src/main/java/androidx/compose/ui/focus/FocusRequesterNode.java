package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier$Node;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001A\u00020\u000BH\u0016J\b\u0010\f\u001A\u00020\u000BH\u0016R\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\r"}, d2={"Landroidx/compose/ui/focus/FocusRequesterNode;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "<init>", "(Landroidx/compose/ui/focus/FocusRequester;)V", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "onAttach", "", "onDetach", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class FocusRequesterNode extends Node implements FocusRequesterModifierNode {
    private FocusRequester focusRequester;

    public FocusRequesterNode(FocusRequester arg1) {
        super();
        this.focusRequester = arg1;
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public void onAttach() {
        super.onAttach();
        this.focusRequester.getFocusRequesterNodes$ui().add(this);
    }

    public void onDetach() {
        this.focusRequester.getFocusRequesterNodes$ui().remove(this);
        super.onDetach();
    }

    public final void setFocusRequester(FocusRequester arg1) {
        this.focusRequester = arg1;
    }
}

