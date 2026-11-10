package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"kotlinx/coroutines/BuildersKt__BuildersKt", "kotlinx/coroutines/BuildersKt__Builders_commonKt"}, k=4, mv={2, 1, 0}, xi=0x30) public final class BuildersKt {
    public static final Deferred async(CoroutineScope arg0, CoroutineContext arg1, CoroutineStart arg2, Function2 arg3) {
        return BuildersKt__Builders_commonKt.async(arg0, arg1, arg2, arg3);
    }

    public static Deferred async$default(CoroutineScope arg0, CoroutineContext arg1, CoroutineStart arg2, Function2 arg3, int arg4, Object arg5) {
        return BuildersKt__Builders_commonKt.async$default(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static final Object invoke(CoroutineDispatcher arg0, Function2 arg1, Continuation arg2) {
        return BuildersKt__Builders_commonKt.invoke(arg0, arg1, arg2);
    }

    public static final Job launch(CoroutineScope arg0, CoroutineContext arg1, CoroutineStart arg2, Function2 arg3) {
        return BuildersKt__Builders_commonKt.launch(arg0, arg1, arg2, arg3);
    }

    public static Job launch$default(CoroutineScope arg0, CoroutineContext arg1, CoroutineStart arg2, Function2 arg3, int arg4, Object arg5) {
        return BuildersKt__Builders_commonKt.launch$default(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static final Object runBlocking(CoroutineContext arg0, Function2 arg1) throws InterruptedException {
        return BuildersKt__BuildersKt.runBlocking(arg0, arg1);
    }

    public static Object runBlocking$default(CoroutineContext arg0, Function2 arg1, int arg2, Object arg3) throws InterruptedException {
        return BuildersKt__BuildersKt.runBlocking$default(arg0, arg1, arg2, arg3);
    }

    public static final Object withContext(CoroutineContext arg0, Function2 arg1, Continuation arg2) {
        return BuildersKt__Builders_commonKt.withContext(arg0, arg1, arg2);
    }
}

