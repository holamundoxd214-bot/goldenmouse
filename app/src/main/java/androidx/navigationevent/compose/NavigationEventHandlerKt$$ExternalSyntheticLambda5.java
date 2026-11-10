package androidx.navigationevent.compose;

import androidx.compose.runtime.DisposableEffectScope;
import androidx.navigationevent.NavigationEventDispatcher;
import kotlin.jvm.functions.Function1;

public final class NavigationEventHandlerKt$$ExternalSyntheticLambda5 implements Function1 {
    public NavigationEventHandlerKt$$ExternalSyntheticLambda5(NavigationEventState arg1, ComposeNavigationEventHandler arg2, NavigationEventDispatcher arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke(Object arg3) {
        return NavigationEventHandlerKt.NavigationEventHandler$lambda$16$lambda$15(this.f$0, this.f$1, this.f$2, ((DisposableEffectScope)arg3));
    }
}

