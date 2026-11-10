package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001BI\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u000E\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u000E\u0010\u000B\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\f¢\u0006\u0004\b\r\u0010\u000EJ!\u0010\u0018\u001A\u0004\u0018\u00010\n2\u000E\u0010\u0019\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u001AH\u0094\u0080\u0004¢\u0006\u0002\u0010\u001BJ\n\u0010\u001C\u001A\u00020\u001DH\u0096\u0080\u0004R\u0015\u0010\u0002\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0015\u0010\u0004\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010R\u0015\u0010\u0005\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0010R\u0015\u0010\u0006\u001A\u00020\u0007X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u001F\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0086\u0084\b¢\u0006\n\n\u0002\u0010\u0017\u001A\u0004\b\u0015\u0010\u0016R\u0017\u0010\u000B\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\fX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u001E\u001A\u00020\u001F8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b \u0010!¨\u0006\""}, d2={"Lkotlin/coroutines/jvm/internal/TailCallBaseContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "declaringClass", "", "methodName", "fileName", "lineNumber", "", "spilledVariables", "", "", "continuation", "Lkotlin/coroutines/Continuation;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "getDeclaringClass", "()Ljava/lang/String;", "getMethodName", "getFileName", "getLineNumber", "()I", "getSpilledVariables", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class TailCallBaseContinuationImpl extends BaseContinuationImpl {
    private final Continuation continuation;
    private final String declaringClass;
    private final String fileName;
    private final int lineNumber;
    private final String methodName;
    private final Object[] spilledVariables;

    public TailCallBaseContinuationImpl(String arg2, String arg3, String arg4, int arg5, Object[] arg6, Continuation arg7) {
        Intrinsics.checkNotNullParameter(arg2, "declaringClass");
        Intrinsics.checkNotNullParameter(arg3, "methodName");
        Intrinsics.checkNotNullParameter(arg4, "fileName");
        Intrinsics.checkNotNullParameter(arg6, "spilledVariables");
        Intrinsics.checkNotNullParameter(arg7, "continuation");
        super(arg7);
        this.declaringClass = arg2;
        this.methodName = arg3;
        this.fileName = arg4;
        this.lineNumber = arg5;
        this.spilledVariables = arg6;
        this.continuation = arg7;
    }

    public CoroutineContext getContext() {
        return this.continuation.getContext();
    }

    public final String getDeclaringClass() {
        return this.declaringClass;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final int getLineNumber() {
        return this.lineNumber;
    }

    public final String getMethodName() {
        return this.methodName;
    }

    public final Object[] getSpilledVariables() {
        return this.spilledVariables;
    }

    public StackTraceElement getStackTraceElement() {
        String v0 = ModuleNameRetriever.INSTANCE.getModuleName(this);
        v0 = v0 == null ? this.declaringClass : v0 + '/' + this.declaringClass;
        return new StackTraceElement(v0, this.methodName, this.fileName, this.lineNumber);
    }

    protected Object invokeSuspend(Object arg1) {
        ResultKt.throwOnFailure(arg1);
        return arg1;
    }
}

