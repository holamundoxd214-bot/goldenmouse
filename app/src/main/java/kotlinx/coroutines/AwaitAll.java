package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u000E\u000FB\u001D\u0012\u0014\u0010\u0003\u001A\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\fH\u0086@¢\u0006\u0002\u0010\rR\u001E\u0010\u0003\u001A\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\t\u0010\t\u001A\u00020\nX\u0082\u0004¨\u0006\u0010"}, d2={"Lkotlinx/coroutines/AwaitAll;", "T", "", "deferreds", "", "Lkotlinx/coroutines/Deferred;", "<init>", "([Lkotlinx/coroutines/Deferred;)V", "[Lkotlinx/coroutines/Deferred;", "notCompletedCount", "Lkotlinx/atomicfu/AtomicInt;", "await", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "DisposeHandlersOnCancel", "AwaitAllNode", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class AwaitAll {
    @Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001B\u0012\u0012\u0010\u0002\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u001B\u001A\u00020\u001C2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001EH\u0016R\u001A\u0010\u0002\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0007\u001A\u00020\bX\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\u001B\u0010\r\u001A\u0014\u0012\u0010\u0012\u000E\u0018\u00010\u000FR\b\u0012\u0004\u0012\u00028\u00000\u00100\u000EX\u0082\u0004R<\u0010\u0012\u001A\u000E\u0018\u00010\u000FR\b\u0012\u0004\u0012\u00028\u00000\u00102\u0012\u0010\u0011\u001A\u000E\u0018\u00010\u000FR\b\u0012\u0004\u0012\u00028\u00000\u00108F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001A\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001A¨\u0006\u001F"}, d2={"Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/JobNode;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "<init>", "(Lkotlinx/coroutines/AwaitAll;Lkotlinx/coroutines/CancellableContinuation;)V", "handle", "Lkotlinx/coroutines/DisposableHandle;", "getHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "_disposer", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/AwaitAll;", "value", "disposer", "getDisposer", "()Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "setDisposer", "(Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;)V", "onCancelling", "", "getOnCancelling", "()Z", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class AwaitAllNode extends JobNode {
        private final CancellableContinuation continuation;
        public DisposableHandle handle;

        static {
            AwaitAllNode._disposer$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(AwaitAllNode.class, Object.class, "_disposer$volatile");
        }

        public AwaitAllNode(AwaitAll arg1, CancellableContinuation arg2) {
            AwaitAll.this = arg1;
            super();
            this.continuation = arg2;
        }

        public final DisposeHandlersOnCancel getDisposer() {
            return AwaitAllNode.get_disposer$volatile$FU().get(this);
        }

        public final DisposableHandle getHandle() {
            DisposableHandle v0 = this.handle;
            if(v0 != null) {
                return v0;
            }

            Intrinsics.throwUninitializedPropertyAccessException("handle");
            return null;
        }

        public boolean getOnCancelling() {
            return 0;
        }

        private final Object get_disposer$volatile() {
            return this._disposer$volatile;
        }

        private static final AtomicReferenceFieldUpdater get_disposer$volatile$FU() {
            return AwaitAllNode._disposer$volatile$FU;
        }

        public void invoke(Throwable arg5) {
            if(arg5 != null) {
                Object v5 = this.continuation.tryResumeWithException(arg5);
                if(v5 != null) {
                    this.continuation.completeResume(v5);
                    DisposeHandlersOnCancel v4 = this.getDisposer();
                    if(v4 != null) {
                        v4.disposeAll();
                        return;
                    }
                }
            }
            else if(AwaitAll.getNotCompletedCount$volatile$FU().decrementAndGet(AwaitAll.this) == 0) {
                CancellableContinuation v5_1 = this.continuation;
                Deferred[] v4_1 = AwaitAll.this.deferreds;
                ArrayList v0 = new ArrayList(v4_1.length);
                int v1 = v4_1.length;
                int v2;
                for(v2 = 0; v2 < v1; ++v2) {
                    ((Collection)v0).add(v4_1[v2].getCompleted());
                }

                ((Continuation)v5_1).resumeWith(Result.constructor-impl(v0));
            }
        }

        public final void setDisposer(DisposeHandlersOnCancel arg2) {
            AwaitAllNode.get_disposer$volatile$FU().set(this, arg2);
        }

        public final void setHandle(DisposableHandle arg1) {
            this.handle = arg1;
        }

        private final void set_disposer$volatile(Object arg1) {
            this._disposer$volatile = arg1;
        }
    }

    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001F\u0012\u0016\u0010\u0002\u001A\u0012\u0012\u000E\u0012\f0\u0004R\b\u0012\u0004\u0012\u00028\u00000\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\t\u001A\u00020\nJ\u0012\u0010\u000B\u001A\u00020\n2\b\u0010\f\u001A\u0004\u0018\u00010\rH\u0016J\b\u0010\u000E\u001A\u00020\u000FH\u0016R \u0010\u0002\u001A\u0012\u0012\u000E\u0012\f0\u0004R\b\u0012\u0004\u0012\u00028\u00000\u00050\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0010"}, d2={"Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "nodes", "", "Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/AwaitAll;", "<init>", "(Lkotlinx/coroutines/AwaitAll;[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;)V", "[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "disposeAll", "", "invoke", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class DisposeHandlersOnCancel implements CancelHandler {
        private final AwaitAllNode[] nodes;

        public DisposeHandlersOnCancel(AwaitAll arg1, AwaitAllNode[] arg2) {
            AwaitAll.this = arg1;
            super();
            this.nodes = arg2;
        }

        public final void disposeAll() {
            AwaitAllNode[] v3 = this.nodes;
            int v0 = v3.length;
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                v3[v1].getHandle().dispose();
            }
        }

        public void invoke(Throwable arg1) {
            this.disposeAll();
        }

        public String toString() {
            return "DisposeHandlersOnCancel[" + this.nodes + ']';
        }
    }

    private final Deferred[] deferreds;

    static {
        AwaitAll.notCompletedCount$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(AwaitAll.class, "notCompletedCount$volatile");
    }

    public AwaitAll(Deferred[] arg1) {
        super();
        this.deferreds = arg1;
        this.notCompletedCount$volatile = arg1.length;
    }

    public static final Deferred[] access$getDeferreds$p(AwaitAll arg0) {
        return arg0.deferreds;
    }

    public static final AtomicIntegerFieldUpdater access$getNotCompletedCount$volatile$FU() {
        return AwaitAll.getNotCompletedCount$volatile$FU();
    }

    public final Object await(Continuation arg12) {
        CancellableContinuationImpl v0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg12), 1);
        v0.initCancellability();
        CancellableContinuationImpl v1 = v0;
        int v3 = this.deferreds.length;
        AwaitAllNode[] v4 = new AwaitAllNode[v3];
        int v5 = 0;
        int v6;
        for(v6 = 0; v6 < v3; ++v6) {
            Deferred v7 = this.deferreds[v6];
            v7.start();
            AwaitAllNode v8 = new AwaitAllNode(this, ((CancellableContinuation)v1));
            v8.setHandle(JobKt.invokeOnCompletion$default(((Job)v7), false, v8, 1, null));
            v4[v6] = v8;
        }

        DisposeHandlersOnCancel v2 = new DisposeHandlersOnCancel(this, v4);
        while(v5 < v3) {
            v4[v5].setDisposer(v2);
            ++v5;
        }

        if(((CancellableContinuation)v1).isCompleted()) {
            v2.disposeAll();
        }
        else {
            CancellableContinuationKt.invokeOnCancellation(((CancellableContinuation)v1), ((CancelHandler)v2));
        }

        Object v11 = v0.getResult();
        if(v11 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg12);
        }

        return v11;
    }

    private final int getNotCompletedCount$volatile() {
        return this.notCompletedCount$volatile;
    }

    private static final AtomicIntegerFieldUpdater getNotCompletedCount$volatile$FU() {
        return AwaitAll.notCompletedCount$volatile$FU;
    }

    private final void setNotCompletedCount$volatile(int arg1) {
        this.notCompletedCount$volatile = arg1;
    }
}

