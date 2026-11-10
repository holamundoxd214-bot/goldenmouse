package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal$OnCancelListener;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;

public final class HandwritingGestureApi34$$ExternalSyntheticLambda3 implements CancellationSignal$OnCancelListener {
    public HandwritingGestureApi34$$ExternalSyntheticLambda3(TextFieldSelectionManager arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onCancel() {
        HandwritingGestureApi34.previewHandwritingGesture$lambda$1(this.f$0);
    }
}

