package com.TryJeanPc.goldenmouse.ui;

import android.view.ViewTreeObserver$OnPreDrawListener;

public final class AdaptiveWindowSizing$Binding$$ExternalSyntheticLambda2 implements ViewTreeObserver$OnPreDrawListener {
    public AdaptiveWindowSizing$Binding$$ExternalSyntheticLambda2(Binding arg1) {
        super();
        this.f$0 = arg1;
    }

    public final boolean onPreDraw() {
        return Binding.insetsListener$lambda$2(this.f$0);
    }
}

