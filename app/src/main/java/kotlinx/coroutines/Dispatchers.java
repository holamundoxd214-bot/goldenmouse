package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001A\u00020\u0015H\u0007R\u001C\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\bR\u001A\u0010\t\u001A\u00020\n8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000B\u0010\u0003\u001A\u0004\b\f\u0010\rR\u001C\u0010\u000E\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u000F\u0010\u0003\u001A\u0004\b\u0010\u0010\bR\u001A\u0010\u0011\u001A\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0003\u001A\u0004\b\u0013\u0010\b¨\u0006\u0016"}, d2={"Lkotlinx/coroutines/Dispatchers;", "", "<init>", "()V", "Default", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDefault$annotations", "getDefault", "()Lkotlinx/coroutines/CoroutineDispatcher;", "Main", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "getMain$annotations", "getMain", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "Unconfined", "getUnconfined$annotations", "getUnconfined", "IO", "getIO$annotations", "getIO", "shutdown", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Dispatchers {
    private static final CoroutineDispatcher Default;
    public static final Dispatchers INSTANCE;
    private static final CoroutineDispatcher Unconfined;

    static {
        Dispatchers.INSTANCE = new Dispatchers();
        Dispatchers.Default = DefaultScheduler.INSTANCE;
        Dispatchers.Unconfined = Unconfined.INSTANCE;
    }

    private Dispatchers() {
        super();
    }

    public static final CoroutineDispatcher getDefault() {
        return Dispatchers.Default;
    }

    @JvmStatic public static void getDefault$annotations() {
    }

    public static final CoroutineDispatcher getIO() {
        return DefaultIoScheduler.INSTANCE;
    }

    @JvmStatic public static void getIO$annotations() {
    }

    public static final MainCoroutineDispatcher getMain() {
        return MainDispatcherLoader.dispatcher;
    }

    @JvmStatic public static void getMain$annotations() {
    }

    public static final CoroutineDispatcher getUnconfined() {
        return Dispatchers.Unconfined;
    }

    @JvmStatic public static void getUnconfined$annotations() {
    }

    public final void shutdown() {
        DefaultExecutor.INSTANCE.shutdown();
        DefaultScheduler.INSTANCE.shutdown$kotlinx_coroutines_core();
    }
}

