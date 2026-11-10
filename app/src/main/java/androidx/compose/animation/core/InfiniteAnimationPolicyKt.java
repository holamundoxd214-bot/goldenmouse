package androidx.compose.animation.core;

import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.platform.InfiniteAnimationPolicy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A7\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012!\u0010\u0002\u001A\u001D\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u0002H\u00010\u0003H\u0086@¢\u0006\u0002\u0010\b\u001A9\u0010\t\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012#\b\u0004\u0010\u0002\u001A\u001D\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u0002H\u00010\u0003H\u0086H¢\u0006\u0002\u0010\b¨\u0006\u000B"}, d2={"withInfiniteAnimationFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "frameTimeNanos", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withInfiniteAnimationFrameMillis", "frameTimeMillis", "animation-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class InfiniteAnimationPolicyKt {
    public static final Object withInfiniteAnimationFrameMillis(Function1 arg1, Continuation arg2) {
        return InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(new InfiniteAnimationPolicyKt$withInfiniteAnimationFrameMillis$2(arg1), arg2);
    }

    private static final Object withInfiniteAnimationFrameMillis$$forInline(Function1 arg1, Continuation arg2) {
        return InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(new InfiniteAnimationPolicyKt$withInfiniteAnimationFrameMillis$2(arg1), arg2);
    }

    public static final Object withInfiniteAnimationFrameNanos(Function1 arg3, Continuation arg4) {
        Element v0 = arg4.getContext().get(InfiniteAnimationPolicy.Key);
        if(v0 == null) {
            return MonotonicFrameClockKt.withFrameNanos(arg3, arg4);
        }

        return ((InfiniteAnimationPolicy)v0).onInfiniteOperation(new InfiniteAnimationPolicyKt$withInfiniteAnimationFrameNanos$2(arg3, null), arg4);
    }
}

