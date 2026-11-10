package androidx.compose.runtime.internal;

import androidx.collection.MutableObjectList;
import androidx.collection.ObjectList;
import androidx.compose.runtime.CancellationHandle;
import androidx.compose.runtime.OneShotCancellationHandle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$IntRef;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001!B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00028\u00002\u000E\u0010\u0018\u001A\n\u0012\u0004\u0012\u00020\u001A\u0018\u00010\u0019¢\u0006\u0002\u0010\u001BJ\u001A\u0010\u001C\u001A\u00020\u001A2\u0012\u0010\u001D\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001A0\u001EJ\u000E\u0010\u001F\u001A\u00020\u001A2\u0006\u0010 \u001A\u00020\nR\u0014\u0010\u0006\u001A\u00060\u0003j\u0002`\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00000\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00000\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001A\u00020\u00128F¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2={"Landroidx/compose/runtime/internal/AwaiterQueue;", "A", "Landroidx/compose/runtime/internal/AwaiterQueue$Awaiter;", "", "<init>", "()V", "lock", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "failureCause", "", "pendingAwaitersCountUnlocked", "Landroidx/compose/runtime/internal/AtomicAwaitersCount;", "Landroidx/compose/runtime/internal/AtomicInt;", "awaiters", "Landroidx/collection/MutableObjectList;", "spareList", "hasAwaiters", "", "getHasAwaiters", "()Z", "addAwaiter", "Landroidx/compose/runtime/CancellationHandle;", "awaiter", "onFirstAwaiter", "Lkotlin/Function0;", "", "(Landroidx/compose/runtime/internal/AwaiterQueue$Awaiter;Lkotlin/jvm/functions/Function0;)Landroidx/compose/runtime/CancellationHandle;", "flushAndDispatchAwaiters", "resume", "Lkotlin/Function1;", "fail", "cause", "Awaiter", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class AwaiterQueue {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001A\u00020\u0005H&J\u0010\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\bH&¨\u0006\t"}, d2={"Landroidx/compose/runtime/internal/AwaiterQueue$Awaiter;", "", "<init>", "()V", "cancel", "", "resumeWithException", "exception", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class Awaiter {
        public static final int $stable;

        static {
        }

        public Awaiter() {
            super();
        }

        public abstract void cancel();

        public abstract void resumeWithException(Throwable arg1);
    }

    public static final int $stable = 8;
    private MutableObjectList awaiters;
    private Throwable failureCause;
    private final Object lock;
    private final AtomicInt pendingAwaitersCountUnlocked;
    private MutableObjectList spareList;

    static {
    }

    public AwaiterQueue() {
        super();
        this.lock = new Object();
        this.pendingAwaitersCountUnlocked = AtomicAwaitersCount.constructor-impl();
        this.awaiters = new MutableObjectList(0, 1, null);
        this.spareList = new MutableObjectList(0, 1, null);
    }

    public final CancellationHandle addAwaiter(Awaiter arg6, Function0 arg7) {
        int v4;
        int v3;
        CancellationHandle v5_1;
        IntRef v0 = new IntRef();
        v0.element = -1;
        Object v1 = this.lock;
        __monitor_enter(v1);
        try {
            Throwable v2 = this.failureCause;
            if(v2 == null) {
                goto label_13;
            }

            arg6.resumeWithException(v2);
            v5_1 = CancellationHandle.Companion.getEmpty$runtime();
        }
        catch(Throwable v5) {
            goto label_42;
        }

        __monitor_exit(v1);
        return v5_1;
        try {
        label_13:
            AtomicInt v2_1 = this.pendingAwaitersCountUnlocked;
            do {
                v3 = v2_1.get();
                v4 = v3 + 1;
            }
            while(!v2_1.compareAndSet(v3, v4));

            v3 = 1;
            if((0x7FFFFFF & v4) == 1) {
            }
            else {
                v3 = 0;
            }

            v0.element = v4 >>> 27 & 15;
            this.awaiters.add(arg6);
        }
        catch(Throwable v5) {
            goto label_42;
        }

        __monitor_exit(v1);
        if(v3 != 0 && arg7 != null) {
            try {
                arg7.invoke();
            }
            catch(Throwable v7) {
                this.fail(v7);
            }
        }

        return new OneShotCancellationHandle(new AwaiterQueue$$ExternalSyntheticLambda0(arg6, this, v0));
    label_42:
        __monitor_exit(v1);
        throw v5;
    }

    static final Unit addAwaiter$lambda$1(Awaiter arg1, AwaiterQueue arg2, IntRef arg3) {
        arg1.cancel();
        AtomicInt v1 = arg2.pendingAwaitersCountUnlocked;
        int v2 = arg3.element;
        do {
            int v3 = v1.get();
            int v0 = (v3 >>> 27 & 15) == v2 ? v3 - 1 : v3;
        }
        while(!v1.compareAndSet(v3, v0));

        return Unit.INSTANCE;
    }

    public final void fail(Throwable arg7) {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            if(this.failureCause == null) {
                goto label_6;
            }
        }
        catch(Throwable v6) {
            goto label_31;
        }

        __monitor_exit(v0);
        return;
        try {
        label_6:
            this.failureCause = arg7;
            MutableObjectList v1 = this.awaiters;
            Object[] v2 = ((ObjectList)v1).content;
            int v1_1 = ((ObjectList)v1)._size;
            int v4;
            for(v4 = 0; v4 < v1_1; ++v4) {
                v2[v4].resumeWithException(arg7);
            }

            this.awaiters.clear();
            AtomicInt v6_1 = this.pendingAwaitersCountUnlocked;
            do {
                int v7 = v6_1.get();
            }
            while(!v6_1.compareAndSet(v7, AtomicAwaitersCount.pack-impl(v6_1, (v7 >>> 27 & 15) + 1, 0)));
        }
        catch(Throwable v6) {
            goto label_31;
        }

        __monitor_exit(v0);
        return;
    label_31:
        __monitor_exit(v0);
        throw v6;
    }

    public final void flushAndDispatchAwaiters(Function1 arg6) {
        int v4;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            MutableObjectList v1 = this.awaiters;
            this.awaiters = this.spareList;
            this.spareList = v1;
            AtomicInt v5_1 = this.pendingAwaitersCountUnlocked;
            do {
                int v2 = v5_1.get();
                v4 = 0;
            }
            while(!v5_1.compareAndSet(v2, AtomicAwaitersCount.pack-impl(v5_1, (v2 >>> 27 & 15) + 1, 0)));

            int v5_2 = v1.getSize();
            while(v4 < v5_2) {
                arg6.invoke(v1.get(v4));
                ++v4;
            }

            v1.clear();
        }
        catch(Throwable v5) {
            goto label_26;
        }

        __monitor_exit(v0);
        return;
    label_26:
        __monitor_exit(v0);
        throw v5;
    }

    public final boolean getHasAwaiters() {
        if((this.pendingAwaitersCountUnlocked.get() & 0x7FFFFFF) > 0) {
            return 1;
        }

        return 0;
    }
}

