package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u00032\u00020\u0004B\u001D\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\n\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0016J\u001D\u0010\u0018\u001A\u00020\u00192\u000E\u0010\u001A\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001BH\u0014¢\u0006\u0002\u0010\u001CJ\b\u0010\u001D\u001A\u00020\u0014H\u0016J\u0016\u0010\u001E\u001A\u00020\u00142\u0006\u0010\u001F\u001A\u00028\u0000H\u0096@¢\u0006\u0002\u0010 J%\u0010\u001E\u001A\u0004\u0018\u00010\u00192\f\u0010!\u001A\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u001F\u001A\u00028\u0000H\u0002¢\u0006\u0002\u0010\"J\'\u0010#\u001A\u00020\u00142\u0006\u0010$\u001A\u00020\u00072\b\u0010%\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u001F\u001A\u00028\u0000H\u0002¢\u0006\u0002\u0010&J\u001A\u0010\'\u001A\u00020\u00142\u0006\u0010(\u001A\u00020)2\b\u0010\u001F\u001A\u0004\u0018\u00010\u0019H\u0002R\u0016\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001A\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0010\u0010\u000F\u001A\u00020\u00108\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001A\u0004\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001A\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017¨\u0006*"}, d2={"Lkotlinx/coroutines/flow/internal/SafeCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "collector", "collectContext", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "collectContextSize", "", "lastEmissionContext", "completion_", "Lkotlin/coroutines/Continuation;", "", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "invokeSuspend", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "emit", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uCont", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)Ljava/lang/Object;", "checkContext", "currentContext", "previousContext", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "exceptionTransparencyViolated", "exception", "Lkotlinx/coroutines/flow/internal/DownstreamExceptionContext;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SafeCollector extends ContinuationImpl implements CoroutineStackFrame, FlowCollector {
    public final CoroutineContext collectContext;
    public final int collectContextSize;
    public final FlowCollector collector;
    private Continuation completion_;
    private CoroutineContext lastEmissionContext;

    public SafeCollector(FlowCollector arg3, CoroutineContext arg4) {
        super(NoOpContinuation.INSTANCE, EmptyCoroutineContext.INSTANCE);
        this.collector = arg3;
        this.collectContext = arg4;
        this.collectContextSize = arg4.fold(Integer.valueOf(0), new SafeCollector$$ExternalSyntheticLambda0()).intValue();
    }

    private final void checkContext(CoroutineContext arg2, CoroutineContext arg3, Object arg4) {
        if((arg3 instanceof DownstreamExceptionContext)) {
            this.exceptionTransparencyViolated(((DownstreamExceptionContext)arg3), arg4);
        }

        SafeCollector_commonKt.checkContext(this, arg2);
    }

    static final int collectContextSize$lambda$0(int arg0, Element arg1) {
        return arg0 + 1;
    }

    private final Object emit(Continuation arg3, Object arg4) {
        CoroutineContext v0 = arg3.getContext();
        JobKt.ensureActive(v0);
        CoroutineContext v1 = this.lastEmissionContext;
        if(v1 != v0) {
            this.checkContext(v0, v1, arg4);
            this.lastEmissionContext = v0;
        }

        this.completion_ = arg3;
        Function3 v3 = SafeCollectorKt.access$getEmitFun$p();
        FlowCollector v0_1 = this.collector;
        Intrinsics.checkNotNull(v0_1, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object v3_1 = v3.invoke(v0_1, arg4, this);
        if(!Intrinsics.areEqual(v3_1, IntrinsicsKt.getCOROUTINE_SUSPENDED())) {
            this.completion_ = null;
        }

        return v3_1;
    }

    public Object emit(Object arg2, Continuation arg3) {
        Object v1;
        try {
            v1 = this.emit(arg3, arg2);
        }
        catch(Throwable v2) {
            ((SafeCollector)v1).lastEmissionContext = new DownstreamExceptionContext(v2, arg3.getContext());
            throw v2;
        }

        if(v1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg3);
        }

        if(v1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v1;
        }

        return Unit.INSTANCE;
    }

    private final void exceptionTransparencyViolated(DownstreamExceptionContext arg3, Object arg4) {
        throw new IllegalStateException(StringsKt.trimIndent("\n            Flow exception transparency is violated:\n                Previous \'emit\' call has thrown exception " + arg3.e + ", but then emission attempt of value \'" + arg4 + "\' has been detected.\n                Emissions from \'catch\' blocks are prohibited in order to avoid unspecified behaviour, \'Flow.catch\' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    public CoroutineStackFrame getCallerFrame() {
        Continuation v1 = this.completion_;
        if((v1 instanceof CoroutineStackFrame)) {
            return ((CoroutineStackFrame)v1);
        }

        return null;
    }

    public CoroutineContext getContext() {
        EmptyCoroutineContext v0_1;
        CoroutineContext v0 = this.lastEmissionContext;
        if(v0 == null) {
            v0_1 = EmptyCoroutineContext.INSTANCE;
        }

        return ((CoroutineContext)v0_1);
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    protected Object invokeSuspend(Object arg4) {
        Throwable v0 = Result.exceptionOrNull-impl(arg4);
        if(v0 != null) {
            this.lastEmissionContext = new DownstreamExceptionContext(v0, this.getContext());
        }

        Continuation v3 = this.completion_;
        if(v3 != null) {
            v3.resumeWith(arg4);
        }

        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}

