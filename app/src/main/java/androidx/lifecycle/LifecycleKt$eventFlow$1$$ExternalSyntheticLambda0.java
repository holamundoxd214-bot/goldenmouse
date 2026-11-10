package androidx.lifecycle;

import kotlin.jvm.functions.Function0;

public final class LifecycleKt$eventFlow$1$$ExternalSyntheticLambda0 implements Function0 {
    public LifecycleKt$eventFlow$1$$ExternalSyntheticLambda0(Lifecycle arg1, LifecycleObserver arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke() {
        return LifecycleKt$eventFlow$1.invokeSuspend$lambda$1(this.f$0, this.f$1);
    }
}

