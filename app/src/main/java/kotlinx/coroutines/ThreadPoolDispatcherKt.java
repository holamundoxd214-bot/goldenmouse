package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata(d1={"kotlinx/coroutines/ThreadPoolDispatcherKt__MultithreadedDispatchers_commonKt", "kotlinx/coroutines/ThreadPoolDispatcherKt__ThreadPoolDispatcherKt"}, k=4, mv={2, 1, 0}, xi=0x30) public final class ThreadPoolDispatcherKt {
    public static final ExecutorCoroutineDispatcher newFixedThreadPoolContext(int arg0, String arg1) {
        return ThreadPoolDispatcherKt__ThreadPoolDispatcherKt.newFixedThreadPoolContext(arg0, arg1);
    }

    public static final ExecutorCoroutineDispatcher newSingleThreadContext(String arg0) {
        return ThreadPoolDispatcherKt__MultithreadedDispatchers_commonKt.newSingleThreadContext(arg0);
    }
}

