package androidx.compose.ui.window;

import android.window.OnBackInvokedCallback;
import kotlin.jvm.functions.Function0;

public final class Api33Impl$$ExternalSyntheticLambda0 implements OnBackInvokedCallback {
    public Api33Impl$$ExternalSyntheticLambda0(Function0 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onBackInvoked() {
        Api33Impl.createBackCallback$lambda$0(this.f$0);
    }
}

