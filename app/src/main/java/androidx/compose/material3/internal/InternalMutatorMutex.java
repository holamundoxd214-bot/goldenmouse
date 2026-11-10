package androidx.compose.material3.internal;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.foundation.MutatePriority;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001:\u0001\u001FB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u0006H\u0002J<\u0010\u000E\u001A\u0002H\u000F\"\u0004\b\u0000\u0010\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\u001C\u0010\u0012\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000F0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H\u0086@¢\u0006\u0002\u0010\u0015JU\u0010\u0016\u001A\u0002H\u000F\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u000F2\u0006\u0010\u0018\u001A\u0002H\u00172\b\b\u0002\u0010\u0010\u001A\u00020\u00112\'\u0010\u0012\u001A#\b\u0001\u0012\u0004\u0012\u0002H\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000F0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019¢\u0006\u0002\b\u001AH\u0086@¢\u0006\u0002\u0010\u001BJ\u0014\u0010\u001C\u001A\u00020\u001D2\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\f0\u001ER$\u0010\u0004\u001A\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2={"Landroidx/compose/material3/internal/InternalMutatorMutex;", "", "<init>", "()V", "currentMutator", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/material3/internal/InternalMutatorMutex$Mutator;", "Landroidx/compose/material3/internal/InternalAtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "tryMutateOrCancel", "", "mutator", "mutate", "R", "priority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mutateWith", "T", "receiver", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryMutate", "", "Lkotlin/Function0;", "Mutator", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class InternalMutatorMutex {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0000J\u0006\u0010\u000F\u001A\u00020\u0010R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0011"}, d2={"Landroidx/compose/material3/internal/InternalMutatorMutex$Mutator;", "", "priority", "Landroidx/compose/foundation/MutatePriority;", "job", "Lkotlinx/coroutines/Job;", "<init>", "(Landroidx/compose/foundation/MutatePriority;Lkotlinx/coroutines/Job;)V", "getPriority", "()Landroidx/compose/foundation/MutatePriority;", "getJob", "()Lkotlinx/coroutines/Job;", "canInterrupt", "", "other", "cancel", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class Mutator {
        private final Job job;
        private final MutatePriority priority;

        public Mutator(MutatePriority arg1, Job arg2) {
            super();
            this.priority = arg1;
            this.job = arg2;
        }

        public final boolean canInterrupt(Mutator arg1) {
            if(this.priority.compareTo(arg1.priority) >= 0) {
                return 1;
            }

            return 0;
        }

        public final void cancel() {
            DefaultImpls.cancel$default(this.job, null, 1, null);
        }

        public final Job getJob() {
            return this.job;
        }

        public final MutatePriority getPriority() {
            return this.priority;
        }
    }

    public static final int $stable;
    private final AtomicReference currentMutator;
    private final Mutex mutex;

    static {
    }

    public InternalMutatorMutex() {
        super();
        this.currentMutator = new AtomicReference(null);
        this.mutex = MutexKt.Mutex$default(false, 1, null);
    }

    public static final AtomicReference access$getCurrentMutator$p(InternalMutatorMutex arg0) {
        return arg0.currentMutator;
    }

    public static final Mutex access$getMutex$p(InternalMutatorMutex arg0) {
        return arg0.mutex;
    }

    public static final void access$tryMutateOrCancel(InternalMutatorMutex arg0, Mutator arg1) {
        arg0.tryMutateOrCancel(arg1);
    }

    public final Object mutate(MutatePriority arg3, Function1 arg4, Continuation arg5) {
        return CoroutineScopeKt.coroutineScope(new InternalMutatorMutex$mutate$2(arg3, this, arg4, null), arg5);
    }

    public static Object mutate$default(InternalMutatorMutex arg0, MutatePriority arg1, Function1 arg2, Continuation arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = MutatePriority.Default;
        }

        return arg0.mutate(arg1, arg2, arg3);
    }

    public final Object mutateWith(Object arg7, MutatePriority arg8, Function2 arg9, Continuation arg10) {
        return CoroutineScopeKt.coroutineScope(new InternalMutatorMutex$mutateWith$2(arg8, this, arg9, arg7, null), arg10);
    }

    public static Object mutateWith$default(InternalMutatorMutex arg0, Object arg1, MutatePriority arg2, Function2 arg3, Continuation arg4, int arg5, Object arg6) {
        if((arg5 & 2) != 0) {
            arg2 = MutatePriority.Default;
        }

        return arg0.mutateWith(arg1, arg2, arg3, arg4);
    }

    public final boolean tryMutate(Function0 arg4) {
        Object v1 = null;
        boolean v0 = kotlinx.coroutines.sync.Mutex$DefaultImpls.tryLock$default(this.mutex, v1, 1, v1);
        if(v0) {
            try {
                arg4.invoke();
            }
            catch(Throwable v4) {
                kotlinx.coroutines.sync.Mutex$DefaultImpls.unlock$default(this.mutex, v1, 1, v1);
                throw v4;
            }

            kotlinx.coroutines.sync.Mutex$DefaultImpls.unlock$default(this.mutex, v1, 1, v1);
            return v0;
        }

        return v0;
    }

    private final void tryMutateOrCancel(Mutator arg3) {
        Object v0;
        do {
            v0 = this.currentMutator.get();
            if(v0 != null) {
                if(arg3.canInterrupt(((Mutator)v0))) {
                }
                else {
                    throw new CancellationException("Current mutation had a higher priority");
                }
            }
        }
        while(!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.currentMutator, v0, arg3));

        if(v0 != null) {
            ((Mutator)v0).cancel();
        }
    }
}

