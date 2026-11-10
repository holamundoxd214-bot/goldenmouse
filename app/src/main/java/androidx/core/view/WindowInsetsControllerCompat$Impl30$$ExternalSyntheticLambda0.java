package androidx.core.view;

import android.view.WindowInsetsController$OnControllableInsetsChangedListener;
import android.view.WindowInsetsController;

public final class WindowInsetsControllerCompat$Impl30$$ExternalSyntheticLambda0 implements WindowInsetsController$OnControllableInsetsChangedListener {
    public WindowInsetsControllerCompat$Impl30$$ExternalSyntheticLambda0(Impl30 arg1, OnControllableInsetsChangedListener arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void onControllableInsetsChanged(WindowInsetsController arg2, int arg3) {
        this.f$0.lambda$addOnControllableInsetsChangedListener$0$androidx-core-view-WindowInsetsControllerCompat$Impl30(this.f$1, arg2, arg3);
    }
}

