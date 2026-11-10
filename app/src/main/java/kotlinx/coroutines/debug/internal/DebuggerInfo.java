package kotlinx.coroutines.debug.internal;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineId;
import kotlinx.coroutines.CoroutineName;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0015\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\r\u001A\u0004\u0018\u00010\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0013\u0010\u0011\u001A\u0004\u0018\u00010\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0010R\u0013\u0010\u0015\u001A\u0004\u0018\u00010\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0010R\u0013\u0010\u0017\u001A\u0004\u0018\u00010\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0010R\u0017\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u001B0\u001A¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001DR\u0011\u0010\u001E\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010 ¨\u0006!"}, d2={"Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "Ljava/io/Serializable;", "source", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "context", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lkotlin/coroutines/CoroutineContext;)V", "coroutineId", "", "getCoroutineId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "dispatcher", "", "getDispatcher", "()Ljava/lang/String;", "name", "getName", "state", "getState", "lastObservedThreadState", "getLastObservedThreadState", "lastObservedThreadName", "getLastObservedThreadName", "lastObservedStackTrace", "", "Ljava/lang/StackTraceElement;", "getLastObservedStackTrace", "()Ljava/util/List;", "sequenceNumber", "getSequenceNumber", "()J", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class DebuggerInfo implements Serializable {
    private final Long coroutineId;
    private final String dispatcher;
    private final List lastObservedStackTrace;
    private final String lastObservedThreadName;
    private final String lastObservedThreadState;
    private final String name;
    private final long sequenceNumber;
    private final String state;

    public DebuggerInfo(DebugCoroutineInfoImpl arg5, CoroutineContext arg6) {
        super();
        Element v0 = arg6.get(CoroutineId.Key);
        String v1 = null;
        Long v0_1 = v0 != null ? Long.valueOf(((CoroutineId)v0).getId()) : ((Long)v1);
        this.coroutineId = v0_1;
        v0 = arg6.get(ContinuationInterceptor.Key);
        String v0_2 = v0 != null ? v0.toString() : v1;
        this.dispatcher = v0_2;
        Element v6 = arg6.get(CoroutineName.Key);
        String v6_1 = v6 != null ? ((CoroutineName)v6).getName() : v1;
        this.name = v6_1;
        this.state = arg5.getState$kotlinx_coroutines_core();
        Thread v6_2 = arg5.lastObservedThread;
        if(v6_2 != null) {
            Thread$State v6_3 = v6_2.getState();
            if(v6_3 != null) {
                v6_1 = v6_3.toString();
            }
            else {
                goto label_32;
            }
        }
        else {
        label_32:
            v6_1 = v1;
        }

        this.lastObservedThreadState = v6_1;
        v6_2 = arg5.lastObservedThread;
        if(v6_2 != null) {
            v1 = v6_2.getName();
        }

        this.lastObservedThreadName = v1;
        this.lastObservedStackTrace = arg5.lastObservedStackTrace$kotlinx_coroutines_core();
        this.sequenceNumber = arg5.sequenceNumber;
    }

    public final Long getCoroutineId() {
        return this.coroutineId;
    }

    public final String getDispatcher() {
        return this.dispatcher;
    }

    public final List getLastObservedStackTrace() {
        return this.lastObservedStackTrace;
    }

    public final String getLastObservedThreadName() {
        return this.lastObservedThreadName;
    }

    public final String getLastObservedThreadState() {
        return this.lastObservedThreadState;
    }

    public final String getName() {
        return this.name;
    }

    public final long getSequenceNumber() {
        return this.sequenceNumber;
    }

    public final String getState() {
        return this.state;
    }
}

