package androidx.compose.ui.text.input;

import android.os.CancellationSignal;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.PreviewableHandwritingGesture;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0013\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\"\u0010\n\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010J\u0018\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u000B\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015¨\u0006\u0016"}, d2={"Landroidx/compose/ui/text/input/NullableInputConnectionWrapperApi34;", "Landroidx/compose/ui/text/input/NullableInputConnectionWrapperApi25;", "delegate", "Landroid/view/inputmethod/InputConnection;", "onConnectionClosed", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/NullableInputConnectionWrapper;", "", "<init>", "(Landroid/view/inputmethod/InputConnection;Lkotlin/jvm/functions/Function1;)V", "performHandwritingGesture", "gesture", "Landroid/view/inputmethod/HandwritingGesture;", "executor", "Ljava/util/concurrent/Executor;", "consumer", "Ljava/util/function/IntConsumer;", "previewHandwritingGesture", "", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) class NullableInputConnectionWrapperApi34 extends NullableInputConnectionWrapperApi25 {
    public NullableInputConnectionWrapperApi34(InputConnection arg1, Function1 arg2) {
        super(arg1, arg2);
    }

    public final void performHandwritingGesture(HandwritingGesture arg1, Executor arg2, IntConsumer arg3) {
        InputConnection v0 = this.getDelegate();
        if(v0 != null) {
            v0.performHandwritingGesture(arg1, arg2, arg3);
        }
    }

    public final boolean previewHandwritingGesture(PreviewableHandwritingGesture arg1, CancellationSignal arg2) {
        InputConnection v0 = this.getDelegate();
        if(v0 != null) {
            return v0.previewHandwritingGesture(arg1, arg2);
        }

        return 0;
    }
}

