package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001AJ\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\'\u0010\u0006\u001A#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\u0007¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\r\u001AV\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00100\u000F\"\u0004\b\u0000\u0010\u00102\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\'\u0010\u0006\u001A#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\t\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\u0007¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2={"launch", "Lkotlinx/coroutines/Job;", "context", "Lkotlin/coroutines/CoroutineContext;", "start", "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "async", "Lkotlinx/coroutines/Deferred;", "T", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Deferred;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class GuidanceKt {
    @Deprecated(level=DeprecationLevel.ERROR, message="\'async\' can not be called without the corresponding coroutine scope. Consider wrapping \'async\' in \'coroutineScope { }\', using \'runBlocking { }\', or using some other \'CoroutineScope\'") public static final Deferred async(CoroutineContext arg0, CoroutineStart arg1, Function2 arg2) {
        throw new UnsupportedOperationException("Should never be called, was introduced to help with incomplete code");
    }

    public static Deferred async$default(CoroutineContext arg0, CoroutineStart arg1, Function2 arg2, int arg3, Object arg4) {
        EmptyCoroutineContext v0;
        if((arg3 & 1) != 0) {
            v0 = EmptyCoroutineContext.INSTANCE;
        }

        if((arg3 & 2) != 0) {
            arg1 = CoroutineStart.DEFAULT;
        }

        return GuidanceKt.async(((CoroutineContext)v0), arg1, arg2);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="\'launch\' can not be called without the corresponding coroutine scope. Consider wrapping \'launch\' in \'coroutineScope { }\', using \'runBlocking { }\', or using some other \'CoroutineScope\'") public static final Job launch(CoroutineContext arg0, CoroutineStart arg1, Function2 arg2) {
        throw new UnsupportedOperationException("Should never be called, was introduced to help with incomplete code");
    }

    public static Job launch$default(CoroutineContext arg0, CoroutineStart arg1, Function2 arg2, int arg3, Object arg4) {
        EmptyCoroutineContext v0;
        if((arg3 & 1) != 0) {
            v0 = EmptyCoroutineContext.INSTANCE;
        }

        if((arg3 & 2) != 0) {
            arg1 = CoroutineStart.DEFAULT;
        }

        return GuidanceKt.launch(((CoroutineContext)v0), arg1, arg2);
    }
}

