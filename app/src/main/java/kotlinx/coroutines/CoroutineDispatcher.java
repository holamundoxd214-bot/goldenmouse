package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.AbstractCoroutineContextKey;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor$DefaultImpls;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.LimitedDispatcher;
import kotlinx.coroutines.internal.LimitedDispatcherKt;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \u001D2\u00020\u00012\u00020\u0002:\u0001\u001DB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0016J\u001C\u0010\t\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\rH\u0016J\u0010\u0010\t\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u000BH\u0017J!\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0007\u001A\u00020\b2\n\u0010\u0010\u001A\u00060\u0011j\u0002`\u0012H&¢\u0006\u0002\u0010\u0013J!\u0010\u0014\u001A\u00020\u000F2\u0006\u0010\u0007\u001A\u00020\b2\n\u0010\u0010\u001A\u00060\u0011j\u0002`\u0012H\u0017¢\u0006\u0002\u0010\u0013J \u0010\u0015\u001A\b\u0012\u0004\u0012\u0002H\u00170\u0016\"\u0004\b\u0000\u0010\u00172\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u0002H\u00170\u0016J\u0012\u0010\u0019\u001A\u00020\u000F2\n\u0010\u0018\u001A\u0006\u0012\u0002\b\u00030\u0016J\u0011\u0010\u001A\u001A\u00020\u00002\u0006\u0010\u001B\u001A\u00020\u0000H\u0087\u0002J\b\u0010\u001C\u001A\u00020\rH\u0016¨\u0006\u001E"}, d2={"Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/ContinuationInterceptor;", "<init>", "()V", "isDispatchNeeded", "", "context", "Lkotlin/coroutines/CoroutineContext;", "limitedParallelism", "parallelism", "", "name", "", "dispatch", "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "dispatchYield", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "releaseInterceptedContinuation", "plus", "other", "toString", "Key", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class CoroutineDispatcher extends AbstractCoroutineContextElement implements ContinuationInterceptor {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"Lkotlinx/coroutines/CoroutineDispatcher$Key;", "Lkotlin/coroutines/AbstractCoroutineContextKey;", "Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "()V", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Key extends AbstractCoroutineContextKey {
        public Key(DefaultConstructorMarker arg1) {
            this();
        }

        private Key() {
            super(ContinuationInterceptor.Key, new CoroutineDispatcher$Key$$ExternalSyntheticLambda0());
        }

        static final CoroutineDispatcher _init_$lambda$0(Element arg1) {
            if((arg1 instanceof CoroutineDispatcher)) {
                return arg1;
            }

            return null;
        }
    }

    public static final Key Key;

    static {
        CoroutineDispatcher.Key = new Key(null);
    }

    public CoroutineDispatcher() {
        super(ContinuationInterceptor.Key);
    }

    public abstract void dispatch(CoroutineContext arg1, Runnable arg2);

    public void dispatchYield(CoroutineContext arg1, Runnable arg2) {
        DispatchedContinuationKt.safeDispatch(this, arg1, arg2);
    }

    public Element get(kotlin.coroutines.CoroutineContext$Key arg1) {
        return DefaultImpls.get(((ContinuationInterceptor)this), arg1);
    }

    public final Continuation interceptContinuation(Continuation arg2) {
        return new DispatchedContinuation(this, arg2);
    }

    public boolean isDispatchNeeded(CoroutineContext arg1) {
        return 1;
    }

    public CoroutineDispatcher limitedParallelism(int arg2, String arg3) {
        LimitedDispatcherKt.checkParallelism(arg2);
        return new LimitedDispatcher(this, arg2, arg3);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Deprecated for good. Override \'limitedParallelism(parallelism: Int, name: String?)\' instead", replaceWith="<_subannotation>") public CoroutineDispatcher limitedParallelism(int arg2) {
        return this.limitedParallelism(arg2, null);
    }

    public static CoroutineDispatcher limitedParallelism$default(CoroutineDispatcher arg0, int arg1, String arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 2) != 0) {
                arg2 = null;
            }

            return arg0.limitedParallelism(arg1, arg2);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: limitedParallelism");
    }

    public CoroutineContext minusKey(kotlin.coroutines.CoroutineContext$Key arg1) {
        return DefaultImpls.minusKey(((ContinuationInterceptor)this), arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Operator \'+\' on two CoroutineDispatcher objects is meaningless. CoroutineDispatcher is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The dispatcher to the right of `+` just replaces the dispatcher to the left.") public final CoroutineDispatcher plus(CoroutineDispatcher arg1) {
        return arg1;
    }

    public final void releaseInterceptedContinuation(Continuation arg1) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((DispatchedContinuation)arg1).release$kotlinx_coroutines_core();
    }

    public String toString() {
        return DebugStringsKt.getClassSimpleName(this) + '@' + DebugStringsKt.getHexAddress(this);
    }
}

