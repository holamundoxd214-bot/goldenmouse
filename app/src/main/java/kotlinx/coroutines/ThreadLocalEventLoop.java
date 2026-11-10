package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadLocalKt;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\f\u001A\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\rJ\r\u0010\u000E\u001A\u00020\u000FH\u0000¢\u0006\u0002\b\u0010J\u0015\u0010\u0011\u001A\u00020\u000F2\u0006\u0010\t\u001A\u00020\u0006H\u0000¢\u0006\u0002\b\u0012R$\u0010\u0004\u001A\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\t\u001A\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B¨\u0006\u0013"}, d2={"Lkotlinx/coroutines/ThreadLocalEventLoop;", "", "<init>", "()V", "ref", "Ljava/lang/ThreadLocal;", "Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", "Ljava/lang/ThreadLocal;", "eventLoop", "getEventLoop$kotlinx_coroutines_core", "()Lkotlinx/coroutines/EventLoop;", "currentOrNull", "currentOrNull$kotlinx_coroutines_core", "resetEventLoop", "", "resetEventLoop$kotlinx_coroutines_core", "setEventLoop", "setEventLoop$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ThreadLocalEventLoop {
    public static final ThreadLocalEventLoop INSTANCE;
    private static final ThreadLocal ref;

    static {
        ThreadLocalEventLoop.INSTANCE = new ThreadLocalEventLoop();
        ThreadLocalEventLoop.ref = ThreadLocalKt.commonThreadLocal(new Symbol("ThreadLocalEventLoop"));
    }

    private ThreadLocalEventLoop() {
        super();
    }

    public final EventLoop currentOrNull$kotlinx_coroutines_core() {
        return ThreadLocalEventLoop.ref.get();
    }

    public final EventLoop getEventLoop$kotlinx_coroutines_core() {
        ThreadLocal v1 = ThreadLocalEventLoop.ref;
        Object v0 = v1.get();
        if(v0 == null) {
            EventLoop v0_1 = EventLoopKt.createEventLoop();
            v1.set(v0_1);
        }

        return ((EventLoop)v0);
    }

    public final void resetEventLoop$kotlinx_coroutines_core() {
        ThreadLocalEventLoop.ref.set(null);
    }

    public final void setEventLoop$kotlinx_coroutines_core(EventLoop arg1) {
        ThreadLocalEventLoop.ref.set(arg1);
    }
}

