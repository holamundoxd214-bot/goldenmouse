package androidx.core.os;

import android.os.ProfilingResult;
import java.util.function.Consumer;
import kotlinx.coroutines.channels.ProducerScope;

public final class Profiling$registerForAllProfilingResults$1$$ExternalSyntheticLambda0 implements Consumer {
    public Profiling$registerForAllProfilingResults$1$$ExternalSyntheticLambda0(ProducerScope arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void accept(Object arg1) {
        Profiling$registerForAllProfilingResults$1.invokeSuspend$lambda$0(this.f$0, ((ProfilingResult)arg1));
    }
}

