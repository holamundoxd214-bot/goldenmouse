package androidx.core.view;

import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final class MenuHostHelper$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public MenuHostHelper$$ExternalSyntheticLambda0(MenuHostHelper arg1, State arg2, MenuProvider arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final void onStateChanged(LifecycleOwner arg3, Event arg4) {
        this.f$0.lambda$addMenuProvider$1$androidx-core-view-MenuHostHelper(this.f$1, this.f$2, arg3, arg4);
    }
}

