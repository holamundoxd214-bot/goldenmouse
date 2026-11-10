package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

@Metadata(d1={"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A2\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0007\u001A\u009B\u0001\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072-\b\u0002\u0010\u000B\u001A\'\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000E\u0012\b\b\u000F\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fj\u0004\u0018\u0001`\u00122/\b\u0001\u0010\u0013\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001A"}, d2={"broadcast", "Lkotlinx/coroutines/channels/BroadcastChannel;", "E", "Lkotlinx/coroutines/channels/ReceiveChannel;", "capacity", "", "start", "Lkotlinx/coroutines/CoroutineStart;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "onCompletion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/BroadcastChannel;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class BroadcastKt {
    @Deprecated(level=DeprecationLevel.ERROR, message="BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported") public static final BroadcastChannel broadcast(CoroutineScope arg1, CoroutineContext arg2, int arg3, CoroutineStart arg4, Function1 arg5, Function2 arg6) {
        LazyBroadcastCoroutine v3;
        CoroutineContext v1 = CoroutineContextKt.newCoroutineContext(arg1, arg2);
        BroadcastChannel v2 = BroadcastChannelKt.BroadcastChannel(arg3);
        if(arg4.isLazy()) {
            v3 = new LazyBroadcastCoroutine(v1, v2, arg6);
        }
        else {
            BroadcastCoroutine v3_1 = new BroadcastCoroutine(v1, v2, true);
        }

        if(arg5 != null) {
            ((BroadcastCoroutine)v3).invokeOnCompletion(arg5);
        }

        ((BroadcastCoroutine)v3).start(arg4, v3, arg6);
        return ((BroadcastChannel)v3);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported") public static final BroadcastChannel broadcast(ReceiveChannel arg11, int arg12, CoroutineStart arg13) {
        return BroadcastKt.broadcast$default(CoroutineScopeKt.plus(CoroutineScopeKt.plus(GlobalScope.INSTANCE, Dispatchers.getUnconfined()), new BroadcastKt$broadcast$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key)), null, arg12, arg13, new BroadcastKt$$ExternalSyntheticLambda0(arg11), new BroadcastKt$broadcast$2(arg11, null), 1, null);
    }

    public static BroadcastChannel broadcast$default(CoroutineScope arg0, CoroutineContext arg1, int arg2, CoroutineStart arg3, Function1 arg4, Function2 arg5, int arg6, Object arg7) {
        EmptyCoroutineContext v1;
        if((arg6 & 1) != 0) {
            v1 = EmptyCoroutineContext.INSTANCE;
        }

        if((arg6 & 4) != 0) {
            arg3 = CoroutineStart.LAZY;
        }

        if((arg6 & 8) != 0) {
            arg4 = null;
        }

        return BroadcastKt.broadcast(arg0, ((CoroutineContext)v1), 1, arg3, arg4, arg5);
    }

    public static BroadcastChannel broadcast$default(ReceiveChannel arg0, int arg1, CoroutineStart arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = CoroutineStart.LAZY;
        }

        return BroadcastKt.broadcast(arg0, 1, arg2);
    }

    static final Unit broadcast$lambda$1(ReceiveChannel arg0, Throwable arg1) {
        ChannelsKt.cancelConsumed(arg0, arg1);
        return Unit.INSTANCE;
    }
}

