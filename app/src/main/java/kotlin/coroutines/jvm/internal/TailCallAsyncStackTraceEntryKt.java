package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\u001A]\u0010\u0000\u001A\u0002H\u0001\"\u0014\b\u0000\u0010\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002*\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\n2\u000E\u0010\u000B\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\f2\u0006\u0010\r\u001A\u0002H\u0001H\u0081\u0080\u0004¢\u0006\u0002\u0010\u000E\u001A]\u0010\u000F\u001A\u0002H\u0001\"\u0014\b\u0000\u0010\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002*\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\n2\u000E\u0010\u000B\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\f2\u0006\u0010\r\u001A\u0002H\u0001H\u0080\u0080\u0004¢\u0006\u0002\u0010\u000E¨\u0006\u0010"}, d2={"wrapContinuation", "T", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "declaringClass", "", "methodName", "fileName", "lineNumber", "", "spilledVariables", "", "continuation", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "wrapContinuationReal", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class TailCallAsyncStackTraceEntryKt {
    public static final Continuation wrapContinuation(String arg0, String arg1, String arg2, int arg3, Object[] arg4, Continuation arg5) {
        Intrinsics.checkNotNullParameter(arg0, "declaringClass");
        Intrinsics.checkNotNullParameter(arg1, "methodName");
        Intrinsics.checkNotNullParameter(arg2, "fileName");
        Intrinsics.checkNotNullParameter(arg4, "spilledVariables");
        Intrinsics.checkNotNullParameter(arg5, "continuation");
        return arg5;
    }

    public static final Continuation wrapContinuationReal(String arg8, String arg9, String arg10, int arg11, Object[] arg12, Continuation arg13) {
        Intrinsics.checkNotNullParameter(arg8, "declaringClass");
        Intrinsics.checkNotNullParameter(arg9, "methodName");
        Intrinsics.checkNotNullParameter(arg10, "fileName");
        Intrinsics.checkNotNullParameter(arg12, "spilledVariables");
        Intrinsics.checkNotNullParameter(arg13, "continuation");
        return new TailCallBaseContinuationImpl(arg8, arg9, arg10, arg11, arg12, arg13);
    }
}

