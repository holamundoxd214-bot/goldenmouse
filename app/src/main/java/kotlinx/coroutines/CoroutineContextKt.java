package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(d1={"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0001H\u0007\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0001H\u0007\u001A\f\u0010\u0005\u001A\u00020\u0006*\u00020\u0001H\u0002\u001A \u0010\u0007\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020\u00012\u0006\u0010\n\u001A\u00020\u0006H\u0002\u001A4\u0010\u000B\u001A\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0003\u001A\u00020\u00012\b\u0010\r\u001A\u0004\u0018\u00010\u000E2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\f0\u0010H\u0080\b¢\u0006\u0002\u0010\u0011\u001A8\u0010\u0012\u001A\u0002H\f\"\u0004\b\u0000\u0010\f2\n\u0010\u0013\u001A\u0006\u0012\u0002\b\u00030\u00142\b\u0010\r\u001A\u0004\u0018\u00010\u000E2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\f0\u0010H\u0080\b¢\u0006\u0002\u0010\u0015\u001A(\u0010\u0016\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0017*\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010\u0003\u001A\u00020\u00012\b\u0010\u0018\u001A\u0004\u0018\u00010\u000EH\u0000\u001A\u0013\u0010\u0019\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0017*\u00020\u001AH\u0080\u0010\"\u001A\u0010\u001B\u001A\u0004\u0018\u00010\u001C*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001E\"\u000E\u0010\u001F\u001A\u00020\u001CX\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2={"newCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/CoroutineScope;", "context", "addedContext", "hasCopyableElements", "", "foldCopies", "originalContext", "appendContext", "isNewCoroutine", "withCoroutineContext", "T", "countOrElement", "", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withContinuationContext", "continuation", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "updateUndispatchedCompletion", "Lkotlinx/coroutines/UndispatchedCoroutine;", "oldValue", "undispatchedCompletion", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "coroutineName", "", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "DEBUG_THREAD_NAME_SEPARATOR", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class CoroutineContextKt {
    private static final String DEBUG_THREAD_NAME_SEPARATOR = " @";

    private static final CoroutineContext foldCopies(CoroutineContext arg3, CoroutineContext arg4, boolean arg5) {
        boolean v0 = CoroutineContextKt.hasCopyableElements(arg3);
        boolean v1 = CoroutineContextKt.hasCopyableElements(arg4);
        if(!v0 && !v1) {
            return arg3.plus(arg4);
        }

        ObjectRef v0_1 = new ObjectRef();
        v0_1.element = arg4;
        Object v3 = arg3.fold(EmptyCoroutineContext.INSTANCE, new CoroutineContextKt$$ExternalSyntheticLambda1(v0_1, arg5));
        if(v1) {
            v0_1.element = v0_1.element.fold(EmptyCoroutineContext.INSTANCE, new CoroutineContextKt$$ExternalSyntheticLambda2());
        }

        return ((CoroutineContext)v3).plus(v0_1.element);
    }

    static final CoroutineContext foldCopies$lambda$1(ObjectRef arg2, boolean arg3, CoroutineContext arg4, Element arg5) {
        CopyableThreadContextElement v2;
        if(!(arg5 instanceof CopyableThreadContextElement)) {
            return arg4.plus(((CoroutineContext)arg5));
        }

        Element v0 = arg2.element.get(arg5.getKey());
        if(v0 == null) {
            if(arg3) {
                v2 = ((CopyableThreadContextElement)arg5).copyForChild();
            }
            else {
                Element v2_1 = arg5;
            }

            return arg4.plus(((CoroutineContext)v2));
        }

        arg2.element = arg2.element.minusKey(arg5.getKey());
        return arg4.plus(((CopyableThreadContextElement)arg5).mergeForChild(v0));
    }

    static final CoroutineContext foldCopies$lambda$2(CoroutineContext arg1, Element arg2) {
        if((arg2 instanceof CopyableThreadContextElement)) {
            return arg1.plus(((CopyableThreadContextElement)arg2).copyForChild());
        }

        return arg1.plus(((CoroutineContext)arg2));
    }

    public static final String getCoroutineName(CoroutineContext arg2) {
        String v2_1;
        String v1 = null;
        if(!DebugKt.getDEBUG()) {
            return v1;
        }

        Element v0 = arg2.get(CoroutineId.Key);
        if(v0 == null) {
            return v1;
        }

        Element v2 = arg2.get(CoroutineName.Key);
        if(v2 != null) {
            v2_1 = ((CoroutineName)v2).getName();
            if(v2_1 == null) {
                goto label_13;
            }
        }
        else {
        label_13:
            v2_1 = "coroutine";
        }

        return v2_1 + '#' + ((CoroutineId)v0).getId();
    }

    private static final boolean hasCopyableElements(CoroutineContext arg2) {
        return arg2.fold(Boolean.valueOf(false), new CoroutineContextKt$$ExternalSyntheticLambda0()).booleanValue();
    }

    static final boolean hasCopyableElements$lambda$0(boolean arg0, Element arg1) {
        if(!arg0) {
            if((arg1 instanceof CopyableThreadContextElement)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public static final CoroutineContext newCoroutineContext(CoroutineScope arg2, CoroutineContext arg3) {
        CoroutineContext v2 = CoroutineContextKt.foldCopies(arg2.getCoroutineContext(), arg3, true);
        arg3 = DebugKt.getDEBUG() ? v2.plus(new CoroutineId(DebugKt.getCOROUTINE_ID().incrementAndGet())) : v2;
        if(v2 != Dispatchers.getDefault() && v2.get(ContinuationInterceptor.Key) == null) {
            return arg3.plus(Dispatchers.getDefault());
        }

        return arg3;
    }

    public static final CoroutineContext newCoroutineContext(CoroutineContext arg1, CoroutineContext arg2) {
        if(!CoroutineContextKt.hasCopyableElements(arg2)) {
            return arg1.plus(arg2);
        }

        return CoroutineContextKt.foldCopies(arg1, arg2, false);
    }

    public static final UndispatchedCoroutine undispatchedCompletion(CoroutineStackFrame arg2) {
        do {
            UndispatchedCoroutine v1 = null;
            if((arg2 instanceof DispatchedCoroutine)) {
                return v1;
            }

            arg2 = arg2.getCallerFrame();
            if(arg2 == null) {
                return v1;
            }
        }
        while(!(arg2 instanceof UndispatchedCoroutine));

        return ((UndispatchedCoroutine)arg2);
    }

    public static final UndispatchedCoroutine updateUndispatchedCompletion(Continuation arg2, CoroutineContext arg3, Object arg4) {
        UndispatchedCoroutine v1 = null;
        if(!(arg2 instanceof CoroutineStackFrame)) {
            return v1;
        }

        if(arg3.get(UndispatchedMarker.INSTANCE) != null) {
            UndispatchedCoroutine v2 = CoroutineContextKt.undispatchedCompletion(((CoroutineStackFrame)arg2));
            if(v2 != null) {
                v2.saveThreadContext(arg3, arg4);
            }

            return v2;
        }

        return v1;
    }

    public static final Object withContinuationContext(Continuation arg2, Object arg3, Function0 arg4) {
        Object v4_1;
        CoroutineContext v0 = arg2.getContext();
        arg3 = ThreadContextKt.updateThreadContext(v0, arg3);
        UndispatchedCoroutine v2 = arg3 != ThreadContextKt.NO_THREAD_ELEMENTS ? CoroutineContextKt.updateUndispatchedCompletion(arg2, v0, arg3) : null;
        try {
            v4_1 = arg4.invoke();
            if(v2 == null) {
                goto label_11;
            }
        }
        catch(Throwable v4) {
            if(v2 == null || (v2.clearThreadContext())) {
                ThreadContextKt.restoreThreadContext(v0, arg3);
            }

            throw v4;
        }

        if(v2.clearThreadContext()) {
        label_11:
            ThreadContextKt.restoreThreadContext(v0, arg3);
        }

        return v4_1;
    }

    public static final Object withCoroutineContext(CoroutineContext arg0, Object arg1, Function0 arg2) {
        Object v2_1;
        arg1 = ThreadContextKt.updateThreadContext(arg0, arg1);
        try {
            v2_1 = arg2.invoke();
        }
        catch(Throwable v2) {
            ThreadContextKt.restoreThreadContext(arg0, arg1);
            throw v2;
        }

        ThreadContextKt.restoreThreadContext(arg0, arg1);
        return v2_1;
    }
}

