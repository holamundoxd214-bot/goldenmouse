package androidx.compose.foundation.text.input.internal;

import android.view.View;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0013\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001A\u00020\u0007H\u0016J\b\u0010\b\u001A\u00020\u0007H\u0016J\b\u0010\t\u001A\u00020\u0007H\u0016¨\u0006\n"}, d2={"Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManagerImplApi34;", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManagerImplApi24;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "startStylusHandwriting", "", "prepareStylusHandwritingDelegation", "acceptStylusHandwritingDelegation", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) class ComposeInputMethodManagerImplApi34 extends ComposeInputMethodManagerImplApi24 {
    public ComposeInputMethodManagerImplApi34(View arg1) {
        super(arg1);
    }

    public void acceptStylusHandwritingDelegation() {
        this.requireImm().acceptStylusHandwritingDelegation(this.getView());
    }

    public void prepareStylusHandwritingDelegation() {
        this.requireImm().prepareStylusHandwritingDelegation(this.getView());
    }

    public void startStylusHandwriting() {
        this.requireImm().startStylusHandwriting(this.getView());
    }
}

