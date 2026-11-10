package androidx.navigationevent.compose;

import androidx.compose.runtime.DisposableEffectScope;
import androidx.navigationevent.NavigationEventDispatcher;
import kotlin.jvm.functions.Function1;

public final class RememberNavigationEventDispatcherOwnerKt$$ExternalSyntheticLambda0 implements Function1 {
    public RememberNavigationEventDispatcherOwnerKt$$ExternalSyntheticLambda0(NavigationEventDispatcher arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return RememberNavigationEventDispatcherOwnerKt.rememberNavigationEventDispatcherOwner$lambda$5$lambda$4(this.f$0, ((DisposableEffectScope)arg1));
    }
}

