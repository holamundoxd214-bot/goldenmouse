package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013J\u0006\u0010\u0014\u001A\u00020\u0011J\u0012\u0010\u0015\u001A\u00020\u00112\b\u0010\u0016\u001A\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u001BH\u0002R\t\u0010\u0004\u001A\u00020\u0005X\u0082\u0004R\u0018\u0010\u0006\u001A\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001C"}, d2={"Lkotlinx/coroutines/ThreadState;", "Lkotlinx/coroutines/JobNode;", "<init>", "()V", "_state", "Lkotlinx/atomicfu/AtomicInt;", "targetThread", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "Ljava/lang/Thread;", "cancelHandle", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "", "getOnCancelling", "()Z", "setup", "", "job", "Lkotlinx/coroutines/Job;", "clearInterrupt", "invoke", "cause", "", "invalidState", "", "state", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class ThreadState extends JobNode {
    private DisposableHandle cancelHandle;
    private final Thread targetThread;

    static {
        ThreadState._state$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(ThreadState.class, "_state$volatile");
    }

    public ThreadState() {
        super();
        this.targetThread = Thread.currentThread();
    }

    public final void clearInterrupt() {
        AtomicIntegerFieldUpdater v0 = ThreadState.get_state$volatile$FU();
        do {
        label_1:
            int v1 = v0.get(this);
            if(v1 != 0) {
                if(v1 == 2) {
                    goto label_1;
                }

                if(v1 == 3) {
                    Thread.interrupted();
                    return;
                }

                this.invalidState(v1);
                throw new KotlinNothingValueException();
            }
        }
        while(!ThreadState.get_state$volatile$FU().compareAndSet(this, v1, 1));

        DisposableHandle v4 = this.cancelHandle;
        if(v4 != null) {
            v4.dispose();
        }
    }

    public boolean getOnCancelling() {
        return 1;
    }

    private final int get_state$volatile() {
        return this._state$volatile;
    }

    private static final AtomicIntegerFieldUpdater get_state$volatile$FU() {
        return ThreadState._state$volatile$FU;
    }

    private final Void invalidState(int arg3) {
        throw new IllegalStateException("Illegal state " + arg3.toString());
    }

    public void invoke(Throwable arg5) {
        int v1;
        int v0;
        AtomicIntegerFieldUpdater v5 = ThreadState.get_state$volatile$FU();
        do {
            v0 = v5.get(this);
            v1 = 3;
            int v2 = 2;
            if(v0 != 0) {
                goto label_5;
            }
        }
        while(!ThreadState.get_state$volatile$FU().compareAndSet(this, v0, v2));

        this.targetThread.interrupt();
        ThreadState.get_state$volatile$FU().set(this, v1);
        return;
    label_5:
        if(v0 != 1 && v0 != v2) {
            if(v0 == v1) {
            }
            else {
                this.invalidState(v0);
                throw new KotlinNothingValueException();
            }
        }
    }

    private final void loop$atomicfu$ATOMIC_FIELD_UPDATER$Int(AtomicIntegerFieldUpdater arg1, Object arg2, Function1 arg3) {
        while(true) {
            arg3.invoke(Integer.valueOf(arg1.get(arg2)));
        }
    }

    private final void set_state$volatile(int arg1) {
        this._state$volatile = arg1;
    }

    public final void setup(Job arg5) {
        int v0;
        this.cancelHandle = JobKt.invokeOnCompletion$default(arg5, false, this, 1, null);
        AtomicIntegerFieldUpdater v5 = ThreadState.get_state$volatile$FU();
        do {
            v0 = v5.get(this);
            if(v0 != 0) {
                break;
            }
            else if(!ThreadState.get_state$volatile$FU().compareAndSet(this, v0, 0)) {
                continue;
            }

            return;
        }
        while(true);

        if(v0 != 2) {
            if(v0 == 3) {
            }
            else {
                this.invalidState(v0);
                throw new KotlinNothingValueException();
            }
        }
    }
}

