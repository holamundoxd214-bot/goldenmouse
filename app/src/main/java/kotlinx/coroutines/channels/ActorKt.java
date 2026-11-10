package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1={"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0099\u0001\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2-\b\u0002\u0010\n\u001A\'\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000Bj\u0004\u0018\u0001`\u00112-\u0010\u0012\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0013¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2={"actor", "Lkotlinx/coroutines/channels/SendChannel;", "E", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "start", "Lkotlinx/coroutines/CoroutineStart;", "onCompletion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ActorScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/SendChannel;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ActorKt {
    public static final SendChannel actor(CoroutineScope arg1, CoroutineContext arg2, int arg3, CoroutineStart arg4, Function1 arg5, Function2 arg6) {
        ActorCoroutine v3_1;
        CoroutineContext v1 = CoroutineContextKt.newCoroutineContext(arg1, arg2);
        Channel v2 = ChannelKt.Channel$default(arg3, null, null, 6, null);
        if(arg4.isLazy()) {
            LazyActorCoroutine v3 = new LazyActorCoroutine(v1, v2, arg6);
        }
        else {
            v3_1 = new ActorCoroutine(v1, v2, true);
        }

        if(arg5 != null) {
            v3_1.invokeOnCompletion(arg5);
        }

        v3_1.start(arg4, v3_1, arg6);
        return ((SendChannel)v3_1);
    }

    public static SendChannel actor$default(CoroutineScope arg0, CoroutineContext arg1, int arg2, CoroutineStart arg3, Function1 arg4, Function2 arg5, int arg6, Object arg7) {
        EmptyCoroutineContext v1;
        if((arg6 & 1) != 0) {
            v1 = EmptyCoroutineContext.INSTANCE;
        }

        if((arg6 & 4) != 0) {
            arg3 = CoroutineStart.DEFAULT;
        }

        if((arg6 & 8) != 0) {
            arg4 = null;
        }

        return ActorKt.actor(arg0, ((CoroutineContext)v1), 0, arg3, arg4, arg5);
    }
}

