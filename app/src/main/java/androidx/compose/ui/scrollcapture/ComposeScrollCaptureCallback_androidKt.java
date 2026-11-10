package androidx.compose.ui.scrollcapture;

import android.os.CancellationSignal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u00006\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001AB\u0010\u0004\u001A\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\'\u0010\t\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000B\u0012\u0006\u0012\u0004\u0018\u00010\r0\n¢\u0006\u0002\b\u000EH\u0002¢\u0006\u0002\u0010\u000F\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"DEBUG", "", "TAG", "", "launchWithCancellationSignal", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;", "signal", "Landroid/os/CancellationSignal;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Landroid/os/CancellationSignal;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ComposeScrollCaptureCallback_androidKt {
    private static final boolean DEBUG = false;
    private static final String TAG = "ScrollCapture";

    public static final Job access$launchWithCancellationSignal(CoroutineScope arg0, CancellationSignal arg1, Function2 arg2) {
        return ComposeScrollCaptureCallback_androidKt.launchWithCancellationSignal(arg0, arg1, arg2);
    }

    private static final Job launchWithCancellationSignal(CoroutineScope arg6, CancellationSignal arg7, Function2 arg8) {
        Job v6 = BuildersKt.launch$default(arg6, null, null, arg8, 3, null);
        v6.invokeOnCompletion(new ComposeScrollCaptureCallback_androidKt$launchWithCancellationSignal$1(arg7));
        arg7.setOnCancelListener(new ComposeScrollCaptureCallback_androidKt$$ExternalSyntheticLambda0(v6));
        return v6;
    }

    static final void launchWithCancellationSignal$lambda$0(Job arg2) {
        DefaultImpls.cancel$default(arg2, null, 1, null);
    }
}

