package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.DispatchedContinuation;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0010\u000E\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0010\u0010\u0005\u001A\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0006H\u0000\"\u0018\u0010\u0000\u001A\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0007\u001A\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\u0004¨\u0006\t"}, d2={"hexAddress", "", "", "getHexAddress", "(Ljava/lang/Object;)Ljava/lang/String;", "toDebugString", "Lkotlin/coroutines/Continuation;", "classSimpleName", "getClassSimpleName", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class DebugStringsKt {
    public static final String getClassSimpleName(Object arg0) {
        return arg0.getClass().getSimpleName();
    }

    public static final String getHexAddress(Object arg0) {
        return Integer.toHexString(System.identityHashCode(arg0));
    }

    public static final String toDebugString(Continuation arg3) {
        String v1_2;
        Object v1_1;
        if((arg3 instanceof DispatchedContinuation)) {
            return ((DispatchedContinuation)arg3).toString();
        }

        char v0 = '@';
        try {
            v1_1 = Result.constructor-impl(arg3 + v0 + DebugStringsKt.getHexAddress(arg3));
        }
        catch(Throwable v1) {
            v1_1 = Result.constructor-impl(ResultKt.createFailure(v1));
        }

        if(Result.exceptionOrNull-impl(v1_1) == null) {
        }
        else {
            v1_2 = arg3.getClass().getName() + v0 + DebugStringsKt.getHexAddress(arg3);
        }

        return v1_2;
    }
}

