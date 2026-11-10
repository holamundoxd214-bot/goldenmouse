package androidx.core.view;

import android.view.View$OnApplyWindowInsetsListener;
import android.view.View;
import android.view.WindowInsets;

public final class ViewGroupCompat$$ExternalSyntheticLambda0 implements View$OnApplyWindowInsetsListener {
    public ViewGroupCompat$$ExternalSyntheticLambda0(WindowInsets[] arg1, View$OnApplyWindowInsetsListener arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final WindowInsets onApplyWindowInsets(View arg2, WindowInsets arg3) {
        return ViewGroupCompat.lambda$dispatchApplyWindowInsets$1(this.f$0, this.f$1, arg2, arg3);
    }
}

