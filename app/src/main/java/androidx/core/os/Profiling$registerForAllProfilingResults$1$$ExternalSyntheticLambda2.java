package androidx.core.os;

import android.os.ProfilingManager;
import java.util.function.Consumer;
import kotlin.jvm.functions.Function0;

public final class Profiling$registerForAllProfilingResults$1$$ExternalSyntheticLambda2 implements Function0 {
    public Profiling$registerForAllProfilingResults$1$$ExternalSyntheticLambda2(ProfilingManager arg1, Consumer arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke() {
        return Profiling$registerForAllProfilingResults$1.invokeSuspend$lambda$2(this.f$0, this.f$1);
    }
}

