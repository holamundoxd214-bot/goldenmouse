package androidx.activity.contextaware;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1={"\u0000\u001A\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A=\u0010\u0000\u001A\u0007H\u0001¢\u0006\u0002\b\u0002\"\u0004\b\u0000\u0010\u0001*\u00020\u00032\u001E\b\u0004\u0010\u0004\u001A\u0018\u0012\t\u0012\u00070\u0006¢\u0006\u0002\b\u0002\u0012\t\u0012\u0007H\u0001¢\u0006\u0002\b\u00020\u0005H\u0086H¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2={"withContextAvailable", "R", "Lkotlin/jvm/JvmSuppressWildcards;", "Landroidx/activity/contextaware/ContextAware;", "onContextAvailable", "Lkotlin/Function1;", "Landroid/content/Context;", "(Landroidx/activity/contextaware/ContextAware;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ContextAwareKt {
    public static final Object withContextAvailable(ContextAware arg3, Function1 arg4, Continuation arg5) {
        Context v0 = arg3.peekAvailableContext();
        if(v0 != null) {
            return arg4.invoke(v0);
        }

        CancellableContinuationImpl v0_1 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg5), 1);
        v0_1.initCancellability();
        ContextAwareKt$withContextAvailable$2$listener$1 v2 = new ContextAwareKt$withContextAvailable$2$listener$1(v0_1, arg4);
        arg3.addOnContextAvailableListener(v2);
        v0_1.invokeOnCancellation(new ContextAwareKt$withContextAvailable$2$1(arg3, v2));
        Object v3 = v0_1.getResult();
        if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg5);
        }

        return v3;
    }

    private static final Object withContextAvailable$$forInline(ContextAware arg3, Function1 arg4, Continuation arg5) {
        Context v0 = arg3.peekAvailableContext();
        if(v0 != null) {
            return arg4.invoke(v0);
        }

        CancellableContinuationImpl v0_1 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg5), 1);
        v0_1.initCancellability();
        ContextAwareKt$withContextAvailable$2$listener$1 v2 = new ContextAwareKt$withContextAvailable$2$listener$1(v0_1, arg4);
        arg3.addOnContextAvailableListener(v2);
        v0_1.invokeOnCancellation(new ContextAwareKt$withContextAvailable$2$1(arg3, v2));
        Object v3 = v0_1.getResult();
        if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg5);
        }

        return v3;
    }
}

