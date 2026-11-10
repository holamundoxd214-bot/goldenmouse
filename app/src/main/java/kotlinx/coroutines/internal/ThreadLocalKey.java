package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\u0004HÂ\u0003J\u0017\u0010\b\u001A\u00020\u00002\f\b\u0002\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0004HÆ\u0001J\u0013\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001A\u00020\u000EHÖ\u0001J\t\u0010\u000F\u001A\u00020\u0010HÖ\u0001R\u0012\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"Lkotlinx/coroutines/internal/ThreadLocalKey;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/internal/ThreadLocalElement;", "threadLocal", "Ljava/lang/ThreadLocal;", "<init>", "(Ljava/lang/ThreadLocal;)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ThreadLocalKey implements Key {
    private final ThreadLocal threadLocal;

    public ThreadLocalKey(ThreadLocal arg1) {
        super();
        this.threadLocal = arg1;
    }

    private final ThreadLocal component1() {
        return this.threadLocal;
    }

    public final ThreadLocalKey copy(ThreadLocal arg1) {
        return new ThreadLocalKey(arg1);
    }

    public static ThreadLocalKey copy$default(ThreadLocalKey arg0, ThreadLocal arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.threadLocal;
        }

        return arg0.copy(arg1);
    }

    public boolean equals(Object arg4) {
        if(this == (((ThreadLocalKey)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof ThreadLocalKey)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.threadLocal, ((ThreadLocalKey)arg4).threadLocal)) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return this.threadLocal.hashCode();
    }

    public String toString() {
        return "ThreadLocalKey(threadLocal=" + this.threadLocal + ')';
    }
}

