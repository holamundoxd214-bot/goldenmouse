package androidx.appcompat.widget;

import android.window.OnBackInvokedCallback;

public final class Toolbar$Api33Impl$$ExternalSyntheticLambda0 implements OnBackInvokedCallback {
    public Toolbar$Api33Impl$$ExternalSyntheticLambda0(Runnable arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onBackInvoked() {
        this.f$0.run();
    }
}

