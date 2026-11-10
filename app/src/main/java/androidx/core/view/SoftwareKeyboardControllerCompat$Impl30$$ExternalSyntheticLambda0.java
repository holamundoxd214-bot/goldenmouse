package androidx.core.view;

import android.view.WindowInsetsController$OnControllableInsetsChangedListener;
import android.view.WindowInsetsController;
import java.util.concurrent.atomic.AtomicBoolean;

public final class SoftwareKeyboardControllerCompat$Impl30$$ExternalSyntheticLambda0 implements WindowInsetsController$OnControllableInsetsChangedListener {
    public SoftwareKeyboardControllerCompat$Impl30$$ExternalSyntheticLambda0(AtomicBoolean arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onControllableInsetsChanged(WindowInsetsController arg1, int arg2) {
        Impl30.lambda$hide$0(this.f$0, arg1, arg2);
    }
}

