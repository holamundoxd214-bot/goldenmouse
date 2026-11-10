package kotlinx.coroutines.sync;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectInstanceInternal;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002:\u0002,-B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0018\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\tH\u0016J\u0012\u0010\u0019\u001A\u00020\u001A2\b\u0010\u0007\u001A\u0004\u0018\u00010\tH\u0002J\u0018\u0010\u001B\u001A\u00020\u00142\b\u0010\u0007\u001A\u0004\u0018\u00010\tH\u0096@¢\u0006\u0002\u0010\u001CJ\u0018\u0010\u001D\u001A\u00020\u00142\b\u0010\u0007\u001A\u0004\u0018\u00010\tH\u0082@¢\u0006\u0002\u0010\u001CJ\u0012\u0010\u001E\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u001F\u001A\u00020\u001A2\b\u0010\u0007\u001A\u0004\u0018\u00010\tH\u0002J\u0012\u0010 \u001A\u00020\u00142\b\u0010\u0007\u001A\u0004\u0018\u00010\tH\u0016J\u001E\u0010\'\u001A\u00020\u00142\n\u0010\u000F\u001A\u0006\u0012\u0002\b\u00030\f2\b\u0010\u0007\u001A\u0004\u0018\u00010\tH\u0014J\u001E\u0010(\u001A\u0004\u0018\u00010\t2\b\u0010\u0007\u001A\u0004\u0018\u00010\t2\b\u0010)\u001A\u0004\u0018\u00010\tH\u0014J\b\u0010*\u001A\u00020+H\u0016R\u0011\u0010\u0007\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004Ry\u0010\n\u001Am\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\f¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u000F\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u0011\u0012\u001E\u0012\u001C\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u000B0\u000Bj\u0002`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R(\u0010!\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00020\"8VX\u0096\u0004¢\u0006\f\u0012\u0004\b#\u0010$\u001A\u0004\b%\u0010&¨\u0006."}, d2={"Lkotlinx/coroutines/sync/MutexImpl;", "Lkotlinx/coroutines/sync/SemaphoreAndMutexImpl;", "Lkotlinx/coroutines/sync/Mutex;", "locked", "", "<init>", "(Z)V", "owner", "Lkotlinx/atomicfu/AtomicRef;", "", "onSelectCancellationUnlockConstructor", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/ParameterName;", "name", "select", "param", "internalResult", "", "Lkotlin/coroutines/CoroutineContext;", "", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "isLocked", "()Z", "holdsLock", "holdsLockImpl", "", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lockSuspend", "tryLock", "tryLockImpl", "unlock", "onLock", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnLock$annotations", "()V", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "onLockRegFunction", "onLockProcessResult", "result", "toString", "", "CancellableContinuationWithOwner", "SelectInstanceWithOwner", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public class MutexImpl extends SemaphoreAndMutexImpl implements Mutex {
    @Metadata(d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001F\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJz\u0010\n\u001A\u0004\u0018\u00010\u0007\"\b\b\u0000\u0010\u000B*\u00020\u00022\u0006\u0010\f\u001A\u0002H\u000B2\b\u0010\r\u001A\u0004\u0018\u00010\u00072M\u0010\u000E\u001AI\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u0011H\u000B¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000FH\u0016¢\u0006\u0002\u0010\u0016Jn\u0010\u0017\u001A\u00020\u0002\"\b\b\u0000\u0010\u000B*\u00020\u00022\u0006\u0010\f\u001A\u0002H\u000B2M\u0010\u000E\u001AI\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u0011H\u000B¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000FH\u0016¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001A\u00020\u001A2\b\u0010\u0013\u001A\u0004\u0018\u00010\u0010H\u0096\u0001J\u0011\u0010\u001B\u001A\u00020\u00022\u0006\u0010\u001C\u001A\u00020\u0007H\u0097\u0001J\t\u0010\u001D\u001A\u00020\u0002H\u0097\u0001J2\u0010\u001E\u001A\u00020\u00022\'\u0010\u001F\u001A#\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00020 j\u0002`!H\u0096\u0001J\u001D\u0010\u001E\u001A\u00020\u00022\n\u0010\"\u001A\u0006\u0012\u0002\b\u00030#2\u0006\u0010$\u001A\u00020%H\u0096\u0001J;\u0010\u0017\u001A\u00020\u00022\u0006\u0010\f\u001A\u00020\u00022#\u0010\u000E\u001A\u001F\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0002\u0018\u00010 H\u0097\u0001¢\u0006\u0002\u0010&J\u001A\u0010\'\u001A\u00020\u0002*\u00020(2\u0006\u0010\f\u001A\u00020\u0002H\u0097\u0001¢\u0006\u0002\u0010)J\u0015\u0010*\u001A\u00020\u0002*\u00020(2\u0006\u0010+\u001A\u00020\u0010H\u0097\u0001J\u001C\u0010,\u001A\u00020\u00022\f\u0010-\u001A\b\u0012\u0004\u0012\u00020\u00020.H\u0096\u0001¢\u0006\u0002\u0010/J\"\u0010\n\u001A\u0004\u0018\u00010\u00072\u0006\u0010\f\u001A\u00020\u00022\b\u0010\r\u001A\u0004\u0018\u00010\u0007H\u0097\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001A\u0004\u0018\u00010\u00072\u0006\u0010+\u001A\u00020\u0010H\u0097\u0001R\u0016\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001A\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001A\u00020\u0014X\u0096\u0005¢\u0006\u0006\u001A\u0004\b2\u00103R\u0012\u00104\u001A\u00020\u001AX\u0096\u0005¢\u0006\u0006\u001A\u0004\b4\u00105R\u0012\u00106\u001A\u00020\u001AX\u0096\u0005¢\u0006\u0006\u001A\u0004\b6\u00105R\u0012\u00107\u001A\u00020\u001AX\u0096\u0005¢\u0006\u0006\u001A\u0004\b7\u00105¨\u00068"}, d2={"Lkotlinx/coroutines/sync/MutexImpl$CancellableContinuationWithOwner;", "Lkotlinx/coroutines/CancellableContinuation;", "", "Lkotlinx/coroutines/Waiter;", "cont", "Lkotlinx/coroutines/CancellableContinuationImpl;", "owner", "", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Lkotlinx/coroutines/CancellableContinuationImpl;Ljava/lang/Object;)V", "tryResume", "R", "value", "idempotent", "onCancellation", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/coroutines/CoroutineContext;", "context", "(Lkotlin/Unit;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "resume", "(Lkotlin/Unit;Lkotlin/jvm/functions/Function3;)V", "cancel", "", "completeResume", "token", "initCancellability", "invokeOnCancellation", "handler", "Lkotlin/Function1;", "Lkotlinx/coroutines/CompletionHandler;", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "", "(Lkotlin/Unit;Lkotlin/jvm/functions/Function1;)V", "resumeUndispatched", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/Unit;)V", "resumeUndispatchedWithException", "exception", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "(Lkotlin/Unit;Ljava/lang/Object;)Ljava/lang/Object;", "tryResumeWithException", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "isActive", "()Z", "isCancelled", "isCompleted", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class CancellableContinuationWithOwner implements CancellableContinuation, Waiter {
        public final CancellableContinuationImpl cont;
        public final Object owner;

        public CancellableContinuationWithOwner(MutexImpl arg1, CancellableContinuationImpl arg2, Object arg3) {
            MutexImpl.this = arg1;
            super();
            this.cont = arg2;
            this.owner = arg3;
        }

        public boolean cancel(Throwable arg1) {
            return this.cont.cancel(arg1);
        }

        public void completeResume(Object arg1) {
            this.cont.completeResume(arg1);
        }

        public CoroutineContext getContext() {
            return this.cont.getContext();
        }

        public void initCancellability() {
            this.cont.initCancellability();
        }

        public void invokeOnCancellation(Function1 arg1) {
            this.cont.invokeOnCancellation(arg1);
        }

        public void invokeOnCancellation(Segment arg1, int arg2) {
            this.cont.invokeOnCancellation(arg1, arg2);
        }

        public boolean isActive() {
            return this.cont.isActive();
        }

        public boolean isCancelled() {
            return this.cont.isCancelled();
        }

        public boolean isCompleted() {
            return this.cont.isCompleted();
        }

        public void resume(Object arg1, Function1 arg2) {
            this.resume(((Unit)arg1), arg2);
        }

        @Deprecated(level=DeprecationLevel.WARNING, message="Use the overload that also accepts the `value` and the coroutine context in lambda", replaceWith="<_subannotation>") public void resume(Unit arg1, Function1 arg2) {
            this.cont.resume(arg1, arg2);
        }

        public void resume(Object arg1, Function3 arg2) {
            this.resume(((Unit)arg1), arg2);
        }

        public void resume(Unit arg3, Function3 arg4) {
            MutexImpl v4 = MutexImpl.this;
            if(DebugKt.getASSERTIONS_ENABLED()) {
                if(MutexImpl.getOwner$volatile$FU().get(v4) == MutexKt.access$getNO_OWNER$p()) {
                }
                else {
                    throw new AssertionError();
                }
            }

            MutexImpl.getOwner$volatile$FU().set(MutexImpl.this, this.owner);
            this.cont.resume(arg3, new MutexImpl$CancellableContinuationWithOwner$$ExternalSyntheticLambda1(MutexImpl.this, this));
        }

        static final Unit resume$lambda$6(MutexImpl arg0, CancellableContinuationWithOwner arg1, Throwable arg2) {
            arg0.unlock(arg1.owner);
            return Unit.INSTANCE;
        }

        public void resumeUndispatched(CoroutineDispatcher arg1, Object arg2) {
            this.resumeUndispatched(arg1, ((Unit)arg2));
        }

        public void resumeUndispatched(CoroutineDispatcher arg1, Unit arg2) {
            this.cont.resumeUndispatched(arg1, arg2);
        }

        public void resumeUndispatchedWithException(CoroutineDispatcher arg1, Throwable arg2) {
            this.cont.resumeUndispatchedWithException(arg1, arg2);
        }

        public void resumeWith(Object arg1) {
            this.cont.resumeWith(arg1);
        }

        public Object tryResume(Object arg1, Object arg2) {
            return this.tryResume(((Unit)arg1), arg2);
        }

        public Object tryResume(Unit arg1, Object arg2) {
            return this.cont.tryResume(arg1, arg2);
        }

        public Object tryResume(Object arg1, Object arg2, Function3 arg3) {
            return this.tryResume(((Unit)arg1), arg2, arg3);
        }

        public Object tryResume(Unit arg3, Object arg4, Function3 arg5) {
            MutexImpl v5 = MutexImpl.this;
            if(DebugKt.getASSERTIONS_ENABLED()) {
                if(MutexImpl.getOwner$volatile$FU().get(v5) == MutexKt.access$getNO_OWNER$p()) {
                }
                else {
                    throw new AssertionError();
                }
            }

            Object v3 = this.cont.tryResume(arg3, arg4, new MutexImpl$CancellableContinuationWithOwner$$ExternalSyntheticLambda0(MutexImpl.this, this));
            if(v3 != null) {
                MutexImpl v4 = MutexImpl.this;
                if(DebugKt.getASSERTIONS_ENABLED()) {
                    if(MutexImpl.getOwner$volatile$FU().get(v4) == MutexKt.access$getNO_OWNER$p()) {
                    }
                    else {
                        throw new AssertionError();
                    }
                }

                MutexImpl.getOwner$volatile$FU().set(MutexImpl.this, this.owner);
            }

            return v3;
        }

        static final Unit tryResume$lambda$3(MutexImpl arg0, CancellableContinuationWithOwner arg1, Throwable arg2, Unit arg3, CoroutineContext arg4) {
            if(DebugKt.getASSERTIONS_ENABLED()) {
                Object v2 = MutexImpl.getOwner$volatile$FU().get(arg0);
                if(v2 != MutexKt.access$getNO_OWNER$p()) {
                    if(v2 == arg1.owner) {
                    }
                    else {
                        throw new AssertionError();
                    }
                }
            }

            MutexImpl.getOwner$volatile$FU().set(arg0, arg1.owner);
            arg0.unlock(arg1.owner);
            return Unit.INSTANCE;
        }

        public Object tryResumeWithException(Throwable arg1) {
            return this.cont.tryResumeWithException(arg1);
        }
    }

    @Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001F\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u00052\b\u0010\u000B\u001A\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0005H\u0016J\u0011\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u0011H\u0096\u0001J\u001D\u0010\u0012\u001A\u00020\r2\n\u0010\u0013\u001A\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010\u0015\u001A\u00020\u0016H\u0096\u0001R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u00028\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001A\u00020\u0018X\u0096\u0005¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2={"Lkotlinx/coroutines/sync/MutexImpl$SelectInstanceWithOwner;", "Q", "Lkotlinx/coroutines/selects/SelectInstanceInternal;", "select", "owner", "", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Lkotlinx/coroutines/selects/SelectInstanceInternal;Ljava/lang/Object;)V", "trySelect", "", "clauseObject", "result", "selectInRegistrationPhase", "", "internalResult", "disposeOnCompletion", "disposableHandle", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCancellation", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class SelectInstanceWithOwner implements SelectInstanceInternal {
        public final Object owner;
        public final SelectInstanceInternal select;

        public SelectInstanceWithOwner(MutexImpl arg1, SelectInstanceInternal arg2, Object arg3) {
            MutexImpl.this = arg1;
            super();
            this.select = arg2;
            this.owner = arg3;
        }

        public void disposeOnCompletion(DisposableHandle arg1) {
            this.select.disposeOnCompletion(arg1);
        }

        public CoroutineContext getContext() {
            return this.select.getContext();
        }

        public void invokeOnCancellation(Segment arg1, int arg2) {
            this.select.invokeOnCancellation(arg1, arg2);
        }

        public void selectInRegistrationPhase(Object arg4) {
            MutexImpl v0 = MutexImpl.this;
            if(DebugKt.getASSERTIONS_ENABLED()) {
                if(MutexImpl.getOwner$volatile$FU().get(v0) == MutexKt.access$getNO_OWNER$p()) {
                }
                else {
                    throw new AssertionError();
                }
            }

            MutexImpl.getOwner$volatile$FU().set(MutexImpl.this, this.owner);
            this.select.selectInRegistrationPhase(arg4);
        }

        public boolean trySelect(Object arg3, Object arg4) {
            MutexImpl v0 = MutexImpl.this;
            if(DebugKt.getASSERTIONS_ENABLED()) {
                if(MutexImpl.getOwner$volatile$FU().get(v0) == MutexKt.access$getNO_OWNER$p()) {
                }
                else {
                    throw new AssertionError();
                }
            }

            boolean v3 = this.select.trySelect(arg3, arg4);
            MutexImpl v4 = MutexImpl.this;
            if(v3) {
                MutexImpl.getOwner$volatile$FU().set(v4, this.owner);
            }

            return v3;
        }
    }

    private final Function3 onSelectCancellationUnlockConstructor;

    static {
        MutexImpl.owner$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner$volatile");
    }

    public MutexImpl(boolean arg2) {
        Symbol v2_1;
        super(1, ((int)arg2));
        if(arg2) {
            Object v2 = null;
        }
        else {
            v2_1 = MutexKt.access$getNO_OWNER$p();
        }

        this.owner$volatile = v2_1;
        this.onSelectCancellationUnlockConstructor = new MutexImpl$$ExternalSyntheticLambda1(this);
    }

    public static final AtomicReferenceFieldUpdater access$getOwner$volatile$FU() {
        return MutexImpl.getOwner$volatile$FU();
    }

    public static final Object access$lockSuspend(MutexImpl arg0, Object arg1, Continuation arg2) {
        return arg0.lockSuspend(arg1, arg2);
    }

    public SelectClause2 getOnLock() {
        MutexImpl$onLock$1 v1 = MutexImpl$onLock$1.INSTANCE;
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Object v1_1 = TypeIntrinsics.beforeCheckcastToFunctionOfArity(v1, 3);
        MutexImpl$onLock$2 v3 = MutexImpl$onLock$2.INSTANCE;
        Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause2Impl(this, ((Function3)v1_1), TypeIntrinsics.beforeCheckcastToFunctionOfArity(v3, 3), this.onSelectCancellationUnlockConstructor);
    }

    public static void getOnLock$annotations() {
    }

    private final Object getOwner$volatile() {
        return this.owner$volatile;
    }

    private static final AtomicReferenceFieldUpdater getOwner$volatile$FU() {
        return MutexImpl.owner$volatile$FU;
    }

    public boolean holdsLock(Object arg1) {
        if(this.holdsLockImpl(arg1) == 1) {
            return 1;
        }

        return 0;
    }

    private final int holdsLockImpl(Object arg3) {
        do {
            if(!this.isLocked()) {
                return 0;
            }

            Object v0 = MutexImpl.getOwner$volatile$FU().get(this);
        }
        while(v0 == MutexKt.access$getNO_OWNER$p());

        if(v0 == arg3) {
            return 1;
        }

        return 2;
    }

    public boolean isLocked() {
        if(this.getAvailablePermits() == 0) {
            return 1;
        }

        return 0;
    }

    public Object lock(Object arg1, Continuation arg2) {
        return MutexImpl.lock$suspendImpl(this, arg1, arg2);
    }

    static Object lock$suspendImpl(MutexImpl arg1, Object arg2, Continuation arg3) {
        if(arg1.tryLock(arg2)) {
            return Unit.INSTANCE;
        }

        Object v1 = arg1.lockSuspend(arg2, arg3);
        if(v1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v1;
        }

        return Unit.INSTANCE;
    }

    private final Object lockSuspend(Object arg3, Continuation arg4) {
        CancellableContinuationImpl v0 = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(arg4));
        try {
            this.acquire(new CancellableContinuationWithOwner(this, v0, arg3));
        }
        catch(Throwable v2) {
            v0.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw v2;
        }

        Object v2_1 = v0.getResult();
        if(v2_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg4);
        }

        if(v2_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2_1;
        }

        return Unit.INSTANCE;
    }

    protected Object onLockProcessResult(Object arg2, Object arg3) {
        if(!Intrinsics.areEqual(arg3, MutexKt.access$getON_LOCK_ALREADY_LOCKED_BY_OWNER$p())) {
            return this;
        }

        throw new IllegalStateException("This mutex is already locked by the specified owner: " + arg2.toString());
    }

    protected void onLockRegFunction(SelectInstance arg3, Object arg4) {
        if(arg4 != null && (this.holdsLock(arg4))) {
            arg3.selectInRegistrationPhase(MutexKt.access$getON_LOCK_ALREADY_LOCKED_BY_OWNER$p());
            return;
        }

        Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectInstanceInternal<*>");
        this.onAcquireRegFunction(new SelectInstanceWithOwner(this, ((SelectInstanceInternal)arg3), arg4), arg4);
    }

    static final Function3 onSelectCancellationUnlockConstructor$lambda$1(MutexImpl arg0, SelectInstance arg1, Object arg2, Object arg3) {
        return new MutexImpl$$ExternalSyntheticLambda0(arg0, arg2);
    }

    static final Unit onSelectCancellationUnlockConstructor$lambda$1$lambda$0(MutexImpl arg0, Object arg1, Throwable arg2, Object arg3, CoroutineContext arg4) {
        arg0.unlock(arg1);
        return Unit.INSTANCE;
    }

    private final void setOwner$volatile(Object arg1) {
        this.owner$volatile = arg1;
    }

    public String toString() {
        return "Mutex@" + DebugStringsKt.getHexAddress(this) + "[isLocked=" + this.isLocked() + ",owner=" + MutexImpl.getOwner$volatile$FU().get(this) + ']';
    }

    public boolean tryLock(Object arg3) {
        int v2 = this.tryLockImpl(arg3);
        if(v2 != 0) {
            if(v2 != 1) {
                if(v2 != 2) {
                    throw new IllegalStateException("unexpected".toString());
                }

                throw new IllegalStateException("This mutex is already locked by the specified owner: " + arg3.toString());
            }

            return 0;
        }

        return 1;
    }

    private final int tryLockImpl(Object arg4) {
        while(true) {
            if(this.tryAcquire()) {
                goto label_2;
            }

            if(arg4 == null) {
                return 1;
            }

            int v1 = this.holdsLockImpl(arg4);
            int v2 = 2;
            if(v1 == 1) {
                return v2;
            }

            if(v1 == v2) {
                return 1;
            }
        }

        return 1;
    label_2:
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(MutexImpl.getOwner$volatile$FU().get(this) == MutexKt.access$getNO_OWNER$p()) {
            }
            else {
                throw new AssertionError();
            }
        }

        MutexImpl.getOwner$volatile$FU().set(this, arg4);
        return 0;
    }

    public void unlock(Object arg4) {
        do {
        label_0:
            if(!this.isLocked()) {
                goto label_29;
            }

            Object v0 = MutexImpl.getOwner$volatile$FU().get(this);
            if(v0 == MutexKt.access$getNO_OWNER$p()) {
                goto label_0;
            }

            if(v0 != arg4) {
                if(arg4 == null) {
                }
                else {
                    throw new IllegalStateException("This mutex is locked by " + v0 + ", but " + arg4 + " is expected".toString());
                }
            }
        }
        while(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(MutexImpl.getOwner$volatile$FU(), this, v0, MutexKt.access$getNO_OWNER$p()));

        this.release();
        return;
    label_29:
        throw new IllegalStateException("This mutex is not locked".toString());
    }
}

