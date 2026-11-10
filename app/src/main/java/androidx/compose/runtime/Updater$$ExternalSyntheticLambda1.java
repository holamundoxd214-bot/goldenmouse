package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public final class Updater$$ExternalSyntheticLambda1 implements Function2 {
    public Updater$$ExternalSyntheticLambda1(Function1 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2) {
        return Updater.reconcile_impl$lambda$0(this.f$0, arg1, ((Unit)arg2));
    }
}

