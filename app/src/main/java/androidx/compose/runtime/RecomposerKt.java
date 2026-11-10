package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001AR\u0010\u0007\u001A\u0002H\b\"\u0004\b\u0000\u0010\b2<\u0010\t\u001A8\b\u0001\u0012\u0004\u0012\u00020\u000B\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000E\u0012\u0004\b\b(\u000F\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\n¢\u0006\u0002\b\u0012H\u0086@¢\u0006\u0002\u0010\u0013\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0019\u0010\u0002\u001A\u00060\u0003j\u0002`\u00048Â\u0002X\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006\"\u000E\u0010\u0014\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0015\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"recomposerKey", "", "RecomposerCompoundHashKey", "", "Landroidx/compose/runtime/CompositeKeyHashCode;", "getRecomposerCompoundHashKey", "()J", "withRunningRecomposer", "R", "block", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/Recomposer;", "Lkotlin/ParameterName;", "name", "recomposer", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ProduceAnotherFrame", "FramePending", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class RecomposerKt {
    private static final Object FramePending = null;
    private static final Object ProduceAnotherFrame = null;
    public static final int recomposerKey = 1000;

    static {
        RecomposerKt.ProduceAnotherFrame = new Object();
        RecomposerKt.FramePending = new Object();
    }

    public static final Object access$getFramePending$p() {
        return RecomposerKt.FramePending;
    }

    public static final Object access$getProduceAnotherFrame$p() {
        return RecomposerKt.ProduceAnotherFrame;
    }

    private static final long getRecomposerCompoundHashKey() {
        return 1000;
    }

    public static final Object withRunningRecomposer(Function3 arg2, Continuation arg3) {
        return CoroutineScopeKt.coroutineScope(new RecomposerKt$withRunningRecomposer$2(arg2, null), arg3);
    }
}

