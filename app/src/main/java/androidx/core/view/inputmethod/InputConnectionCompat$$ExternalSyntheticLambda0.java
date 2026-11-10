package androidx.core.view.inputmethod;

import android.os.Bundle;
import android.view.View;

public final class InputConnectionCompat$$ExternalSyntheticLambda0 implements OnCommitContentListener {
    public InputConnectionCompat$$ExternalSyntheticLambda0(View arg1) {
        super();
        this.f$0 = arg1;
    }

    public final boolean onCommitContent(InputContentInfoCompat arg1, int arg2, Bundle arg3) {
        return InputConnectionCompat.lambda$createOnCommitContentListenerUsingPerformReceiveContent$0(this.f$0, arg1, arg2, arg3);
    }
}

