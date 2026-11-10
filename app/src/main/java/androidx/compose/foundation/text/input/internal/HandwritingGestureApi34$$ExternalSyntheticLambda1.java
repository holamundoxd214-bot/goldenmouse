package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal$OnCancelListener;

public final class HandwritingGestureApi34$$ExternalSyntheticLambda1 implements CancellationSignal$OnCancelListener {
    public HandwritingGestureApi34$$ExternalSyntheticLambda1(TransformedTextFieldState arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onCancel() {
        HandwritingGestureApi34.previewHandwritingGesture$lambda$0(this.f$0);
    }
}

