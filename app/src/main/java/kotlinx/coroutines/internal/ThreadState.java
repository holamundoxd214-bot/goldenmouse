package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001C\u0010\u000F\u001A\u00020\u00102\n\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\f2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001J\u000E\u0010\u0013\u001A\u00020\u00102\u0006\u0010\u0002\u001A\u00020\u0003R\u0010\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR \u0010\u000B\u001A\u0012\u0012\u000E\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\f0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000E\u0010\u000E\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"Lkotlinx/coroutines/internal/ThreadState;", "", "context", "Lkotlin/coroutines/CoroutineContext;", "n", "", "<init>", "(Lkotlin/coroutines/CoroutineContext;I)V", "values", "", "[Ljava/lang/Object;", "elements", "Lkotlinx/coroutines/ThreadContextElement;", "[Lkotlinx/coroutines/ThreadContextElement;", "i", "append", "", "element", "value", "restore", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class ThreadState {
    public final CoroutineContext context;
    private final ThreadContextElement[] elements;
    private int i;
    private final Object[] values;

    public ThreadState(CoroutineContext arg1, int arg2) {
        super();
        this.context = arg1;
        this.values = new Object[arg2];
        this.elements = new ThreadContextElement[arg2];
    }

    public final void append(ThreadContextElement arg3, Object arg4) {
        Object[] v0 = this.values;
        int v1 = this.i;
        v0[v1] = arg4;
        ThreadContextElement[] v4 = this.elements;
        this.i = v1 + 1;
        Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        v4[v1] = arg3;
    }

    public final void restore(CoroutineContext arg5) {
        int v0 = this.elements.length - 1;
        if(v0 >= 0) {
            while(true) {
                int v1 = v0 - 1;
                ThreadContextElement v2 = this.elements[v0];
                Intrinsics.checkNotNull(v2);
                v2.restoreThreadContext(arg5, this.values[v0]);
                if(v1 < 0) {
                    break;
                }

                v0 = v1;
            }
        }
    }
}

