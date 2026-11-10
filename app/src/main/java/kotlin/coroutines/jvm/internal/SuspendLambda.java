package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0000\b!\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u00020\u0004B#\bF\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0010\u0010\u0007\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB\u0011\bV\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\t\u0010\u000BJ\n\u0010\u000E\u001A\u00020\u000FH\u0096\u0080\u0004R\u0015\u0010\u0005\u001A\u00020\u0006X\u0096\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u0010"}, d2={"Lkotlin/coroutines/jvm/internal/SuspendLambda;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/jvm/internal/FunctionBase;", "", "Lkotlin/coroutines/jvm/internal/SuspendFunction;", "arity", "", "completion", "Lkotlin/coroutines/Continuation;", "<init>", "(ILkotlin/coroutines/Continuation;)V", "(I)V", "getArity", "()I", "toString", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public abstract class SuspendLambda extends ContinuationImpl implements SuspendFunction, FunctionBase {
    private final int arity;

    public SuspendLambda(int arg1, Continuation arg2) {
        super(arg2);
        this.arity = arg1;
    }

    public SuspendLambda(int arg2) {
        this(arg2, null);
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        if(this.getCompletion() == null) {
            String v1 = Reflection.renderLambdaToString(((FunctionBase)this));
            Intrinsics.checkNotNullExpressionValue(v1, "renderLambdaToString(...)");
            return v1;
        }

        return super.toString();
    }
}

