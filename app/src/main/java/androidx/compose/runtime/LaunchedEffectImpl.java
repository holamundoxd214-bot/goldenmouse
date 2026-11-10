package androidx.compose.runtime;

import androidx.compose.runtime.tooling.ComposeToolingFlags;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler$DefaultImpls;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B8\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\'\u0010\u0005\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006¢\u0006\u0002\b\u000B¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0012\u001A\u00020\tH\u0016J\b\u0010\u0013\u001A\u00020\tH\u0016J\b\u0010\u0014\u001A\u00020\tH\u0016J\u0018\u0010\u0019\u001A\u00020\t2\u0006\u0010\u001A\u001A\u00020\u00042\u0006\u0010\u001B\u001A\u00020\u001CH\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R1\u0010\u0005\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006¢\u0006\u0002\b\u000BX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000ER\u000E\u0010\u000F\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u0018\u0010\u0015\u001A\u0006\u0012\u0002\b\u00030\u00168VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018¨\u0006\u001D"}, d2={"Landroidx/compose/runtime/LaunchedEffectImpl;", "Landroidx/compose/runtime/RememberObserver;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "parentCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "task", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "scope", "job", "Lkotlinx/coroutines/Job;", "onRemembered", "onForgotten", "onAbandoned", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "handleException", "context", "exception", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class LaunchedEffectImpl implements RememberObserver, CoroutineExceptionHandler {
    public static final int $stable = 8;
    private Job job;
    private final CoroutineContext parentCoroutineContext;
    private final CoroutineScope scope;
    private final Function2 task;

    static {
    }

    public LaunchedEffectImpl(CoroutineContext arg1, Function2 arg2) {
        super();
        this.parentCoroutineContext = arg1;
        this.task = arg2;
        arg1 = arg1.plus(this);
        if(ComposeToolingFlags.isVerboseTracingEnabled) {
            arg1 = arg1.plus(LaunchedEffectTracingContext.INSTANCE);
        }

        this.scope = CoroutineScopeKt.CoroutineScope(arg1);
    }

    public Object fold(Object arg1, Function2 arg2) {
        return DefaultImpls.fold(((CoroutineExceptionHandler)this), arg1, arg2);
    }

    public Element get(Key arg1) {
        return DefaultImpls.get(((CoroutineExceptionHandler)this), arg1);
    }

    public Key getKey() {
        return CoroutineExceptionHandler.Key;
    }

    public void handleException(CoroutineContext arg2, Throwable arg3) {
        Element v0 = arg2.get(CompositionErrorContextImpl.Key);
        if(v0 != null) {
            ((CompositionErrorContextImpl)v0).attachComposeStackTrace(arg3, this);
        }

        Element v1 = this.parentCoroutineContext.get(CoroutineExceptionHandler.Key);
        if(v1 != null) {
            ((CoroutineExceptionHandler)v1).handleException(arg2, arg3);
            return;
        }

        throw arg3;
    }

    public CoroutineContext minusKey(Key arg1) {
        return DefaultImpls.minusKey(((CoroutineExceptionHandler)this), arg1);
    }

    public void onAbandoned() {
        Job v0 = this.job;
        if(v0 != null) {
            v0.cancel(new LeftCompositionCancellationException());
        }

        this.job = null;
    }

    public void onForgotten() {
        Job v0 = this.job;
        if(v0 != null) {
            v0.cancel(new LeftCompositionCancellationException());
        }

        this.job = null;
    }

    public void onRemembered() {
        Job v0 = this.job;
        if(v0 != null) {
            JobKt.cancel$default(v0, "Old job was still running!", null, 2, null);
        }

        this.job = BuildersKt.launch$default(this.scope, null, null, this.task, 3, null);
    }

    public CoroutineContext plus(CoroutineContext arg1) {
        return DefaultImpls.plus(((CoroutineExceptionHandler)this), arg1);
    }
}

