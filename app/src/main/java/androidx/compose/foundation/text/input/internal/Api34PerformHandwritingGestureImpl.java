package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;
import kotlin.Metadata;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rJ \u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012¨\u0006\u0013"}, d2={"Landroidx/compose/foundation/text/input/internal/Api34PerformHandwritingGestureImpl;", "", "<init>", "()V", "performHandwritingGesture", "", "session", "Landroidx/compose/foundation/text/input/internal/TextInputSession;", "gesture", "Landroid/view/inputmethod/HandwritingGesture;", "executor", "Ljava/util/concurrent/Executor;", "intConsumer", "Ljava/util/function/IntConsumer;", "previewHandwritingGesture", "", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class Api34PerformHandwritingGestureImpl {
    public static final Api34PerformHandwritingGestureImpl INSTANCE;

    static {
        Api34PerformHandwritingGestureImpl.INSTANCE = new Api34PerformHandwritingGestureImpl();
    }

    private Api34PerformHandwritingGestureImpl() {
        super();
    }

    public final void performHandwritingGesture(TextInputSession arg1, HandwritingGesture arg2, Executor arg3, IntConsumer arg4) {
        int v0 = arg1.performHandwritingGesture(arg2);
        if(arg4 == null) {
            return;
        }

        if(arg3 != null) {
            arg3.execute(new Api34PerformHandwritingGestureImpl$$ExternalSyntheticLambda0(arg4, v0));
            return;
        }

        arg4.accept(v0);
    }

    static final void performHandwritingGesture$lambda$0(IntConsumer arg0, int arg1) {
        arg0.accept(arg1);
    }

    public final boolean previewHandwritingGesture(TextInputSession arg1, PreviewableHandwritingGesture arg2, CancellationSignal arg3) {
        return arg1.previewHandwritingGesture(arg2, arg3);
    }
}

