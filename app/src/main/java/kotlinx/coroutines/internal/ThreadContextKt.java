package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u001A\u0010\u0010\n\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\fH\u0000\u001A\u001C\u0010\r\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u000B\u001A\u00020\f2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0004H\u0000\u001A\u001A\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u000B\u001A\u00020\f2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0004H\u0000\"\u0010\u0010\u0000\u001A\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"$\u0010\u0002\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\",\u0010\u0006\u001A \u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\b\u001A\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"NO_THREAD_ELEMENTS", "Lkotlinx/coroutines/internal/Symbol;", "countAll", "Lkotlin/Function2;", "", "Lkotlin/coroutines/CoroutineContext$Element;", "findOne", "Lkotlinx/coroutines/ThreadContextElement;", "updateState", "Lkotlinx/coroutines/internal/ThreadState;", "threadContextElements", "context", "Lkotlin/coroutines/CoroutineContext;", "updateThreadContext", "countOrElement", "restoreThreadContext", "", "oldState", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ThreadContextKt {
    public static final Symbol NO_THREAD_ELEMENTS;
    private static final Function2 countAll;
    private static final Function2 findOne;
    private static final Function2 updateState;

    static {
        ThreadContextKt.NO_THREAD_ELEMENTS = new Symbol("NO_THREAD_ELEMENTS");
        ThreadContextKt.countAll = new ThreadContextKt$$ExternalSyntheticLambda0();
        ThreadContextKt.findOne = new ThreadContextKt$$ExternalSyntheticLambda1();
        ThreadContextKt.updateState = new ThreadContextKt$$ExternalSyntheticLambda2();
    }

    static final Object countAll$lambda$0(Object arg1, Element arg2) {
        Integer v1;
        if((arg2 instanceof ThreadContextElement)) {
            if((arg1 instanceof Integer)) {
            }
            else {
                v1 = null;
            }

            int v1_1 = 0 != 0 ? v1.intValue() : 1;
            if(v1_1 == 0) {
                return arg2;
            }

            v1 = Integer.valueOf(v1_1 + 1);
        }

        return v1;
    }

    static final ThreadContextElement findOne$lambda$1(ThreadContextElement arg0, Element arg1) {
        if(arg0 != null) {
            return arg0;
        }

        if((arg1 instanceof ThreadContextElement)) {
            return arg1;
        }

        return null;
    }

    public static final void restoreThreadContext(CoroutineContext arg2, Object arg3) {
        if(arg3 == ThreadContextKt.NO_THREAD_ELEMENTS) {
            return;
        }

        if((arg3 instanceof ThreadState)) {
            ((ThreadState)arg3).restore(arg2);
            return;
        }

        Object v0 = arg2.fold(null, ThreadContextKt.findOne);
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((ThreadContextElement)v0).restoreThreadContext(arg2, arg3);
    }

    public static final Object threadContextElements(CoroutineContext arg2) {
        Object v2 = arg2.fold(Integer.valueOf(0), ThreadContextKt.countAll);
        Intrinsics.checkNotNull(v2);
        return v2;
    }

    static final ThreadState updateState$lambda$2(ThreadState arg1, Element arg2) {
        if((arg2 instanceof ThreadContextElement)) {
            arg1.append(((ThreadContextElement)arg2), ((ThreadContextElement)arg2).updateThreadContext(arg1.context));
        }

        return arg1;
    }

    public static final Object updateThreadContext(CoroutineContext arg1, Object arg2) {
        if(arg2 == null) {
            arg2 = ThreadContextKt.threadContextElements(arg1);
        }

        if(arg2 == Integer.valueOf(0)) {
            return ThreadContextKt.NO_THREAD_ELEMENTS;
        }

        if((arg2 instanceof Integer)) {
            return arg1.fold(new ThreadState(arg1, ((Number)arg2).intValue()), ThreadContextKt.updateState);
        }

        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((ThreadContextElement)arg2).updateThreadContext(arg1);
    }
}

