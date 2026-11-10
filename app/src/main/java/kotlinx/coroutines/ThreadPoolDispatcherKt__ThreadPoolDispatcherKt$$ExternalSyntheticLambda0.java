package kotlinx.coroutines;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class ThreadPoolDispatcherKt__ThreadPoolDispatcherKt$$ExternalSyntheticLambda0 implements ThreadFactory {
    public ThreadPoolDispatcherKt__ThreadPoolDispatcherKt$$ExternalSyntheticLambda0(int arg1, String arg2, AtomicInteger arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Thread newThread(Runnable arg3) {
        return ThreadPoolDispatcherKt__ThreadPoolDispatcherKt.$r8$lambda$iE9_27a--PEYAk7JOqaAHpuexdA(this.f$0, this.f$1, this.f$2, arg3);
    }
}

