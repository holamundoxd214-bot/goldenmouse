package androidx.core.view;

import android.view.KeyEvent;
import android.view.View$OnUnhandledKeyEventListener;
import android.view.View;

public final class ViewCompat$Api28Impl$$ExternalSyntheticLambda0 implements View$OnUnhandledKeyEventListener {
    public ViewCompat$Api28Impl$$ExternalSyntheticLambda0(OnUnhandledKeyEventListenerCompat arg1) {
        super();
        this.f$0 = arg1;
    }

    public final boolean onUnhandledKeyEvent(View arg1, KeyEvent arg2) {
        return this.f$0.onUnhandledKeyEvent(arg1, arg2);
    }
}

