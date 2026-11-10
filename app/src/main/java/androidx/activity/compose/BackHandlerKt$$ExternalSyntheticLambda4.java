package androidx.activity.compose;

import androidx.activity.compose.internal.BackHandlerDispatcherCompat;
import androidx.lifecycle.compose.LifecycleStartStopEffectScope;
import kotlin.jvm.functions.Function1;

public final class BackHandlerKt$$ExternalSyntheticLambda4 implements Function1 {
    public BackHandlerKt$$ExternalSyntheticLambda4(BackHandlerDispatcherCompat arg1, ComposeBackHandler arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return BackHandlerKt.$r8$lambda$lj-_TT9Ycs622xDrDAPZnwcLqwA(this.f$0, this.f$1, ((LifecycleStartStopEffectScope)arg2));
    }
}

