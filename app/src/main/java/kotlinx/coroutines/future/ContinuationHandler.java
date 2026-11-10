package kotlinx.coroutines.future;

import java.util.concurrent.CompletionException;
import java.util.function.BiFunction;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0018\u0012\u0006\u0012\u0004\u0018\u0001H\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0017\u0012\u000E\u0010\u0005\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\t\u001A\u00020\u00042\b\u0010\n\u001A\u0004\u0018\u00018\u00002\b\u0010\u000B\u001A\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\fR\u001A\u0010\u0005\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00068\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Lkotlinx/coroutines/future/ContinuationHandler;", "T", "Ljava/util/function/BiFunction;", "", "", "cont", "Lkotlin/coroutines/Continuation;", "<init>", "(Lkotlin/coroutines/Continuation;)V", "apply", "result", "exception", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class ContinuationHandler implements BiFunction {
    public volatile Continuation cont;

    public ContinuationHandler(Continuation arg1) {
        super();
        this.cont = arg1;
    }

    public Object apply(Object arg1, Object arg2) {
        this.apply(arg1, ((Throwable)arg2));
        return Unit.INSTANCE;
    }

    public void apply(Object arg1, Throwable arg2) {
        Continuation v0 = this.cont;
        if(v0 == null) {
            return;
        }

        if(arg2 == null) {
            v0.resumeWith(Result.constructor-impl(arg1));
            return;
        }

        Throwable v1 = (arg2 instanceof CompletionException) ? arg2 : null;
        if(v1 != null) {
            v1 = ((CompletionException)v1).getCause();
            if(v1 == null) {
            }
            else {
                arg2 = v1;
            }
        }

        v0.resumeWith(Result.constructor-impl(ResultKt.createFailure(arg2)));
    }
}

