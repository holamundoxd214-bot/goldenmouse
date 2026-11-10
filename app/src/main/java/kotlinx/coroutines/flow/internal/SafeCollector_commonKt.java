package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.internal.ScopeCoroutine;

@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0018\u0010\u0000\u001A\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0001\u001A\u001B\u0010\u0005\u001A\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0080\u0010\u001AK\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2/\b\u0005\u0010\u000B\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000E\u0012\u0006\u0012\u0004\u0018\u00010\u000F0\f¢\u0006\u0002\b\u0010H\u0081\b¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2={"checkContext", "", "Lkotlinx/coroutines/flow/internal/SafeCollector;", "currentContext", "Lkotlin/coroutines/CoroutineContext;", "transitiveCoroutineParent", "Lkotlinx/coroutines/Job;", "collectJob", "unsafeFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SafeCollector_commonKt {
    public static final void checkContext(SafeCollector arg3, CoroutineContext arg4) {
        if(arg4.fold(Integer.valueOf(0), new SafeCollector_commonKt$$ExternalSyntheticLambda0(arg3)).intValue() == arg3.collectContextSize) {
            return;
        }

        throw new IllegalStateException("Flow invariant is violated:\n\t\tFlow was collected in " + arg3.collectContext + ",\n\t\tbut emission happened in " + arg4 + ".\n\t\tPlease refer to \'flow\' documentation or use \'flowOn\' instead".toString());
    }

    static final int checkContext$lambda$0(SafeCollector arg2, int arg3, Element arg4) {
        Key v0 = arg4.getKey();
        Element v2 = arg2.collectContext.get(v0);
        if(v0 != Job.Key) {
            if(arg4 != v2) {
                return 0x80000000;
            }

            return arg3 + 1;
        }

        Intrinsics.checkNotNull(arg4, "null cannot be cast to non-null type kotlinx.coroutines.Job");
        Job v4 = SafeCollector_commonKt.transitiveCoroutineParent(((Job)arg4), ((Job)v2));
        if((((Element)v4)) == v2) {
            if(v2 == null) {
                return arg3;
            }

            return arg3 + 1;
        }

        throw new IllegalStateException("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + v4 + ", expected child of " + v2 + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use \'channelFlow\' builder instead of \'flow\'".toString());
    }

    public static final Job transitiveCoroutineParent(Job arg1, Job arg2) {
        while(arg1 != null) {
            if(arg1 == arg2) {
            }
            else {
                if(!(arg1 instanceof ScopeCoroutine)) {
                    return arg1;
                }

                goto label_8;
            }

            return arg1;
        label_8:
            arg1 = ((ScopeCoroutine)arg1).getParent();
        }

        return null;
    }

    public static final Flow unsafeFlow(Function2 arg1) {
        return new SafeCollector_commonKt$unsafeFlow$1(arg1);
    }
}

