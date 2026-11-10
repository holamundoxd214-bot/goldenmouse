package androidx.compose.ui.scrollcapture;

import android.os.CancellationSignal$OnCancelListener;
import kotlinx.coroutines.Job;

public final class ComposeScrollCaptureCallback_androidKt$$ExternalSyntheticLambda0 implements CancellationSignal$OnCancelListener {
    public ComposeScrollCaptureCallback_androidKt$$ExternalSyntheticLambda0(Job arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onCancel() {
        ComposeScrollCaptureCallback_androidKt.launchWithCancellationSignal$lambda$0(this.f$0);
    }
}

