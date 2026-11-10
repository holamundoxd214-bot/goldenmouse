package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0010\u001A\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u00110\u0013H\u0086\b¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001A\u00020\nJ\u0006\u0010\u0016\u001A\u00020\nJ\u000E\u0010\u0017\u001A\u00020\nH\u0086@¢\u0006\u0002\u0010\u0018R\u0014\u0010\u0004\u001A\u00060\u0001j\u0002`\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u001A\u0010\u0007\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\u000B\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u000E\u001A\u00020\r8F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0019"}, d2={"Landroidx/compose/runtime/Latch;", "", "<init>", "()V", "lock", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "awaiters", "", "Lkotlin/coroutines/Continuation;", "", "spareList", "_isOpen", "", "isOpen", "()Z", "withClosed", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "closeLatch", "openLatch", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Latch {
    public static final int $stable = 8;
    private boolean _isOpen;
    private List awaiters;
    private final Object lock;
    private List spareList;

    static {
    }

    public Latch() {
        super();
        this.lock = new Object();
        this.awaiters = new ArrayList();
        this.spareList = new ArrayList();
        this._isOpen = true;
    }

    public static final List access$getAwaiters$p(Latch arg0) {
        return arg0.awaiters;
    }

    public static final Object access$getLock$p(Latch arg0) {
        return arg0.lock;
    }

    public final Object await(Continuation arg5) {
        if(this.isOpen()) {
            return Unit.INSTANCE;
        }

        CancellableContinuationImpl v0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg5), 1);
        v0.initCancellability();
        CancellableContinuationImpl v1 = v0;
        Object v2 = this.lock;
        __monitor_enter(v2);
        try {
            this.awaiters.add(v1);
        }
        catch(Throwable v4) {
            __monitor_exit(v2);
            throw v4;
        }

        __monitor_exit(v2);
        ((CancellableContinuation)v1).invokeOnCancellation(new Latch$await$2$2(this, ((CancellableContinuation)v1)));
        Object v4_1 = v0.getResult();
        if(v4_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg5);
        }

        if(v4_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v4_1;
        }

        return Unit.INSTANCE;
    }

    public final void closeLatch() {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            this._isOpen = false;
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
    }

    public final boolean isOpen() {
        boolean v1_1;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            v1_1 = this._isOpen;
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
        return v1_1;
    }

    public final void openLatch() {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            if(!this.isOpen()) {
                goto label_6;
            }
        }
        catch(Throwable v5) {
            goto label_27;
        }

        __monitor_exit(v0);
        return;
        try {
        label_6:
            List v1 = this.awaiters;
            this.awaiters = this.spareList;
            this.spareList = v1;
            this._isOpen = true;
            int v5_1 = v1.size();
            int v2;
            for(v2 = 0; v2 < v5_1; ++v2) {
                v1.get(v2).resumeWith(Result.constructor-impl(Unit.INSTANCE));
            }

            v1.clear();
        }
        catch(Throwable v5) {
            goto label_27;
        }

        __monitor_exit(v0);
        return;
    label_27:
        __monitor_exit(v0);
        throw v5;
    }

    public final Object withClosed(Function0 arg1) {
        Object v1_1;
        this.closeLatch();
        try {
            v1_1 = arg1.invoke();
        }
        catch(Throwable v1) {
            this.openLatch();
            throw v1;
        }

        this.openLatch();
        return v1_1;
    }
}

