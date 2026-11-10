package androidx.compose.foundation.text.input.internal;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0012\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManagerImplApi21;", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManagerImpl;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "baseInputConnection", "Landroid/view/inputmethod/BaseInputConnection;", "sendKeyEvent", "", "event", "Landroid/view/KeyEvent;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) class ComposeInputMethodManagerImplApi21 extends ComposeInputMethodManagerImpl {
    private BaseInputConnection baseInputConnection;

    public ComposeInputMethodManagerImplApi21(View arg1) {
        super(arg1);
    }

    public void sendKeyEvent(KeyEvent arg4) {
        BaseInputConnection v0 = this.baseInputConnection;
        if(v0 == null) {
            v0 = new BaseInputConnection(this.getView(), false);
            this.baseInputConnection = v0;
        }

        v0.sendKeyEvent(arg4);
    }
}

