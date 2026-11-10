package androidx.activity.compose;

import androidx.activity.compose.internal.BackHandlerDispatcherCompat;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.jvm.functions.Function1;

public final class BackHandlerKt$$ExternalSyntheticLambda2 implements Function1 {
    public BackHandlerKt$$ExternalSyntheticLambda2(BackHandlerDispatcherCompat arg1, ComposeBackHandler arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return BackHandlerKt.$r8$lambda$B1Fin5hf49c20rDAvK1Q7mhIkmo(this.f$0, this.f$1, ((DisposableEffectScope)arg2));
    }
}

