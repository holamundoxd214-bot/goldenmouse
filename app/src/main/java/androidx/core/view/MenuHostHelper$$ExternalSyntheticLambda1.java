package androidx.core.view;

import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final class MenuHostHelper$$ExternalSyntheticLambda1 implements LifecycleEventObserver {
    public MenuHostHelper$$ExternalSyntheticLambda1(MenuHostHelper arg1, MenuProvider arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void onStateChanged(LifecycleOwner arg2, Event arg3) {
        this.f$0.lambda$addMenuProvider$0$androidx-core-view-MenuHostHelper(this.f$1, arg2, arg3);
    }
}

