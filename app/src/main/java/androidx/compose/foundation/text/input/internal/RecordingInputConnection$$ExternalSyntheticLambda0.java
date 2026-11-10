package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.text.input.EditCommand;
import kotlin.jvm.functions.Function1;

public final class RecordingInputConnection$$ExternalSyntheticLambda0 implements Function1 {
    public RecordingInputConnection$$ExternalSyntheticLambda0(RecordingInputConnection arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return RecordingInputConnection.performHandwritingGesture$lambda$0(this.f$0, ((EditCommand)arg1));
    }
}

