package kotlinx.coroutines.debug.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0016\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u000E\u001A\u00020\u000F¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001A\u00020\u0018¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u0013\u0010\u001B\u001A\u0004\u0018\u00010\u001C¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001ER\u0013\u0010\u001F\u001A\u0004\u0018\u00010\u000B¢\u0006\b\n\u0000\u001A\u0004\b \u0010\rR\u0019\u0010!\u001A\b\u0012\u0004\u0012\u00020\u00140\u00138G¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\u0016¨\u0006\""}, d2={"Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "", "source", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "context", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lkotlin/coroutines/CoroutineContext;)V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "creationStackBottom", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCreationStackBottom$kotlinx_coroutines_core", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "sequenceNumber", "", "getSequenceNumber", "()J", "creationStackTrace", "", "Ljava/lang/StackTraceElement;", "getCreationStackTrace", "()Ljava/util/List;", "state", "", "getState", "()Ljava/lang/String;", "lastObservedThread", "Ljava/lang/Thread;", "getLastObservedThread", "()Ljava/lang/Thread;", "lastObservedFrame", "getLastObservedFrame", "lastObservedStackTrace", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class DebugCoroutineInfo {
    private final CoroutineContext context;
    private final CoroutineStackFrame creationStackBottom;
    private final List creationStackTrace;
    private final CoroutineStackFrame lastObservedFrame;
    private final List lastObservedStackTrace;
    private final Thread lastObservedThread;
    private final long sequenceNumber;
    private final String state;

    public DebugCoroutineInfo(DebugCoroutineInfoImpl arg3, CoroutineContext arg4) {
        super();
        this.context = arg4;
        this.creationStackBottom = arg3.getCreationStackBottom$kotlinx_coroutines_core();
        this.sequenceNumber = arg3.sequenceNumber;
        this.creationStackTrace = arg3.getCreationStackTrace();
        this.state = arg3.getState$kotlinx_coroutines_core();
        this.lastObservedThread = arg3.lastObservedThread;
        this.lastObservedFrame = arg3.getLastObservedFrame$kotlinx_coroutines_core();
        this.lastObservedStackTrace = arg3.lastObservedStackTrace$kotlinx_coroutines_core();
    }

    public final CoroutineContext getContext() {
        return this.context;
    }

    public final CoroutineStackFrame getCreationStackBottom$kotlinx_coroutines_core() {
        return this.creationStackBottom;
    }

    public final List getCreationStackTrace() {
        return this.creationStackTrace;
    }

    public final CoroutineStackFrame getLastObservedFrame() {
        return this.lastObservedFrame;
    }

    public final Thread getLastObservedThread() {
        return this.lastObservedThread;
    }

    public final long getSequenceNumber() {
        return this.sequenceNumber;
    }

    public final String getState() {
        return this.state;
    }

    public final List lastObservedStackTrace() {
        return this.lastObservedStackTrace;
    }
}

