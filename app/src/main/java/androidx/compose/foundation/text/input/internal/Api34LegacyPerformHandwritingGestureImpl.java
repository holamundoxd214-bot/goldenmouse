package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.platform.ViewConfiguration;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JT\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\b\u0010\b\u001A\u0004\u0018\u00010\t2\u0006\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u00112\u0012\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00050\u0013J,\u0010\u0015\u001A\u00020\u00162\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\b\u0010\b\u001A\u0004\u0018\u00010\t2\u0006\u0010\n\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0019¨\u0006\u001A"}, d2={"Landroidx/compose/foundation/text/input/internal/Api34LegacyPerformHandwritingGestureImpl;", "", "<init>", "()V", "performHandwritingGesture", "", "legacyTextFieldState", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "textFieldSelectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "gesture", "Landroid/view/inputmethod/HandwritingGesture;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "executor", "Ljava/util/concurrent/Executor;", "consumer", "Ljava/util/function/IntConsumer;", "editCommandConsumer", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/EditCommand;", "previewHandwritingGesture", "", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class Api34LegacyPerformHandwritingGestureImpl {
    public static final Api34LegacyPerformHandwritingGestureImpl INSTANCE;

    static {
        Api34LegacyPerformHandwritingGestureImpl.INSTANCE = new Api34LegacyPerformHandwritingGestureImpl();
    }

    private Api34LegacyPerformHandwritingGestureImpl() {
        super();
    }

    public final void performHandwritingGesture(LegacyTextFieldState arg7, TextFieldSelectionManager arg8, HandwritingGesture arg9, ViewConfiguration arg10, Executor arg11, IntConsumer arg12, Function1 arg13) {
        int v6 = arg7 != null ? HandwritingGestureApi34.INSTANCE.performHandwritingGesture$foundation(arg7, arg9, arg8, arg10, arg13) : 3;
        if(arg12 == null) {
            return;
        }

        if(arg11 != null) {
            arg11.execute(new Api34LegacyPerformHandwritingGestureImpl$$ExternalSyntheticLambda0(arg12, v6));
            return;
        }

        arg12.accept(v6);
    }

    static final void performHandwritingGesture$lambda$0(IntConsumer arg0, int arg1) {
        arg0.accept(arg1);
    }

    public final boolean previewHandwritingGesture(LegacyTextFieldState arg1, TextFieldSelectionManager arg2, PreviewableHandwritingGesture arg3, CancellationSignal arg4) {
        if(arg1 != null) {
            return HandwritingGestureApi34.INSTANCE.previewHandwritingGesture$foundation(arg1, arg3, arg2, arg4);
        }

        return 0;
    }
}

