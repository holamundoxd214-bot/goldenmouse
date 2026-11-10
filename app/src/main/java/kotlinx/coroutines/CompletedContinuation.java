package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0084\u0001\u0012\u0006\u0010\u0003\u001A\u00028\u0000\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012O\b\u0002\u0010\u0006\u001AI\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000E\u0012\u0004\u0012\u00020\u000F\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\u0012\u0010\u0013J\u001A\u0010\u0019\u001A\u00020\u000F2\n\u0010\u001A\u001A\u0006\u0012\u0002\b\u00030\u001B2\u0006\u0010\u000B\u001A\u00020\bJ\u000E\u0010\u001C\u001A\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u001DJ\u000B\u0010\u001E\u001A\u0004\u0018\u00010\u0005HÆ\u0003JP\u0010\u001F\u001AI\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000E\u0012\u0004\u0012\u00020\u000F\u0018\u00010\u0007HÆ\u0003J\u000B\u0010 \u001A\u0004\u0018\u00010\u0002HÆ\u0003J\u000B\u0010!\u001A\u0004\u0018\u00010\bHÆ\u0003J\u0093\u0001\u0010\"\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001A\u00028\u00002\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052O\b\u0002\u0010\u0006\u001AI\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000E\u0012\u0004\u0012\u00020\u000F\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001A\u00020\u00162\b\u0010%\u001A\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010&\u001A\u00020\'HÖ\u0001J\t\u0010(\u001A\u00020)HÖ\u0001R\u0012\u0010\u0003\u001A\u00028\u00008\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0012\u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000RW\u0010\u0006\u001AI\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000E\u0012\u0004\u0012\u00020\u000F\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001A\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001A\u00020\u00168F¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018¨\u0006*"}, d2={"Lkotlinx/coroutines/CompletedContinuation;", "R", "", "result", "cancelHandler", "Lkotlinx/coroutines/CancelHandler;", "onCancellation", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "cause", "value", "Lkotlin/coroutines/CoroutineContext;", "context", "", "idempotentResume", "cancelCause", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/CancelHandler;Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Throwable;)V", "Ljava/lang/Object;", "cancelled", "", "getCancelled", "()Z", "invokeHandlers", "cont", "Lkotlinx/coroutines/CancellableContinuationImpl;", "component1", "()Ljava/lang/Object;", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Object;Lkotlinx/coroutines/CancelHandler;Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Throwable;)Lkotlinx/coroutines/CompletedContinuation;", "equals", "other", "hashCode", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class CompletedContinuation {
    public final Throwable cancelCause;
    public final CancelHandler cancelHandler;
    public final Object idempotentResume;
    public final Function3 onCancellation;
    public final Object result;

    public CompletedContinuation(Object arg2, CancelHandler arg3, Function3 arg4, Object arg5, Throwable arg6, int arg7, DefaultConstructorMarker arg8) {
        CancelHandler v0 = null;
        if((arg7 & 2) != 0) {
            arg3 = v0;
        }

        if((arg7 & 4) != 0) {
            arg4 = ((Function3)v0);
        }

        if((arg7 & 8) != 0) {
            arg5 = v0;
        }

        if((arg7 & 16) != 0) {
            arg6 = ((Throwable)v0);
        }

        this(arg2, arg3, arg4, arg5, arg6);
    }

    public CompletedContinuation(Object arg1, CancelHandler arg2, Function3 arg3, Object arg4, Throwable arg5) {
        super();
        this.result = arg1;
        this.cancelHandler = arg2;
        this.onCancellation = arg3;
        this.idempotentResume = arg4;
        this.cancelCause = arg5;
    }

    public final Object component1() {
        return this.result;
    }

    public final CancelHandler component2() {
        return this.cancelHandler;
    }

    public final Function3 component3() {
        return this.onCancellation;
    }

    public final Object component4() {
        return this.idempotentResume;
    }

    public final Throwable component5() {
        return this.cancelCause;
    }

    public final CompletedContinuation copy(Object arg1, CancelHandler arg2, Function3 arg3, Object arg4, Throwable arg5) {
        return new CompletedContinuation(arg1, arg2, arg3, arg4, arg5);
    }

    public static CompletedContinuation copy$default(CompletedContinuation arg0, Object arg1, CancelHandler arg2, Function3 arg3, Object arg4, Throwable arg5, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg1 = arg0.result;
        }

        if((arg6 & 2) != 0) {
            arg2 = arg0.cancelHandler;
        }

        if((arg6 & 4) != 0) {
            arg3 = arg0.onCancellation;
        }

        if((arg6 & 8) != 0) {
            arg4 = arg0.idempotentResume;
        }

        if((arg6 & 16) != 0) {
            arg5 = arg0.cancelCause;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5);
    }

    public boolean equals(Object arg5) {
        if(this == (((CompletedContinuation)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof CompletedContinuation)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.result, ((CompletedContinuation)arg5).result)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.cancelHandler, ((CompletedContinuation)arg5).cancelHandler)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.onCancellation, ((CompletedContinuation)arg5).onCancellation)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.idempotentResume, ((CompletedContinuation)arg5).idempotentResume)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.cancelCause, ((CompletedContinuation)arg5).cancelCause)) {
            return 0;
        }

        return 1;
    }

    public final boolean getCancelled() {
        if(this.cancelCause != null) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        Object v0 = this.result;
        int v1 = 0;
        int v0_1 = v0 == null ? 0 : v0.hashCode();
        v0_1 *= 0x1F;
        CancelHandler v2 = this.cancelHandler;
        int v2_1 = v2 == null ? 0 : v2.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        Function3 v2_2 = this.onCancellation;
        v2_1 = v2_2 == null ? 0 : v2_2.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        Object v2_3 = this.idempotentResume;
        v2_1 = v2_3 == null ? 0 : v2_3.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        Throwable v3 = this.cancelCause;
        if(v3 == null) {
        }
        else {
            v1 = v3.hashCode();
        }

        return v0_1 + v1;
    }

    public final void invokeHandlers(CancellableContinuationImpl arg2, Throwable arg3) {
        CancelHandler v0 = this.cancelHandler;
        if(v0 != null) {
            arg2.callCancelHandler(v0, arg3);
        }

        Function3 v0_1 = this.onCancellation;
        if(v0_1 != null) {
            arg2.callOnCancellation(v0_1, arg3, this.result);
        }
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.result + ", cancelHandler=" + this.cancelHandler + ", onCancellation=" + this.onCancellation + ", idempotentResume=" + this.idempotentResume + ", cancelCause=" + this.cancelCause + ')';
    }
}

