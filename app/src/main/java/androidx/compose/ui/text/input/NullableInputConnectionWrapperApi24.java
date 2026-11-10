package androidx.compose.ui.text.input;

import android.os.Handler;
import android.view.inputmethod.InputConnection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0013\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\rJ\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010J\u0010\u0010\u0011\u001A\u00020\u00072\u0006\u0010\u0002\u001A\u00020\u0003H\u0004¨\u0006\u0012"}, d2={"Landroidx/compose/ui/text/input/NullableInputConnectionWrapperApi24;", "Landroidx/compose/ui/text/input/NullableInputConnectionWrapperApi21;", "delegate", "Landroid/view/inputmethod/InputConnection;", "onConnectionClosed", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/NullableInputConnectionWrapper;", "", "<init>", "(Landroid/view/inputmethod/InputConnection;Lkotlin/jvm/functions/Function1;)V", "deleteSurroundingTextInCodePoints", "", "p0", "", "p1", "getHandler", "Landroid/os/Handler;", "closeDelegate", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) class NullableInputConnectionWrapperApi24 extends NullableInputConnectionWrapperApi21 {
    public NullableInputConnectionWrapperApi24(InputConnection arg1, Function1 arg2) {
        super(arg1, arg2);
    }

    protected final void closeDelegate(InputConnection arg1) {
        arg1.closeConnection();
    }

    public final boolean deleteSurroundingTextInCodePoints(int arg1, int arg2) {
        InputConnection v0 = this.getDelegate();
        if(v0 != null) {
            return v0.deleteSurroundingTextInCodePoints(arg1, arg2);
        }

        return 0;
    }

    public final Handler getHandler() {
        InputConnection v0 = this.getDelegate();
        if(v0 != null) {
            return v0.getHandler();
        }

        return null;
    }
}

