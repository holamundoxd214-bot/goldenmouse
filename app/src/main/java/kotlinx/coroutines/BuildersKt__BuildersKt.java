package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001AQ\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\'\u0010\u0004\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\t\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\n¨\u0006\u000B"}, d2={"runBlocking", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=5, mv={2, 1, 0}, xi=0x30, xs="kotlinx/coroutines/BuildersKt") final class BuildersKt__BuildersKt {
    public static final Object runBlocking(CoroutineContext arg4, Function2 arg5) throws InterruptedException {
        EventLoop v1_1;
        Thread v0 = Thread.currentThread();
        Element v1 = arg4.get(ContinuationInterceptor.Key);
        if(v1 == null) {
            v1_1 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
            arg4 = CoroutineContextKt.newCoroutineContext(GlobalScope.INSTANCE, arg4.plus(v1_1));
        }
        else {
            Element v3 = null;
            if((v1 instanceof EventLoop)) {
            }
            else {
                v1 = v3;
            }

            if(v1 != null) {
                if(((EventLoop)v1).shouldBeProcessedFromContext()) {
                    v3 = v1;
                }

                if(v3 == null) {
                    goto label_24;
                }

                v1 = v3;
            }
            else {
            label_24:
                v1_1 = ThreadLocalEventLoop.INSTANCE.currentOrNull$kotlinx_coroutines_core();
            }

            arg4 = CoroutineContextKt.newCoroutineContext(GlobalScope.INSTANCE, arg4);
        }

        BlockingCoroutine v2 = new BlockingCoroutine(arg4, v0, v1_1);
        v2.start(CoroutineStart.DEFAULT, v2, arg5);
        return v2.joinBlocking();
    }

    public static Object runBlocking$default(CoroutineContext arg0, Function2 arg1, int arg2, Object arg3) throws InterruptedException {
        EmptyCoroutineContext v0;
        if((arg2 & 1) != 0) {
            v0 = EmptyCoroutineContext.INSTANCE;
        }

        return BuildersKt.runBlocking(((CoroutineContext)v0), arg1);
    }
}

