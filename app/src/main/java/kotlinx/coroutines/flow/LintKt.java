package kotlinx.coroutines.flow;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0096\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001A\u001E\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001A&\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u0006H\u0007\u001A\u001E\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0007\u001A\u001E\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0007\u001A\'\u0010\u0010\u001A\u00020\u0011*\u0006\u0012\u0002\b\u00030\f2\u0010\b\u0002\u0010\u0012\u001A\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014H\u0007¢\u0006\u0002\u0010\u0015\u001Aj\u0010\u001A\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032D\b\b\u0010\u001B\u001A>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0013\u0012\u00110\u001D¢\u0006\f\b\u001E\u0012\b\b\u001F\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001C¢\u0006\u0002\b\"H\u0087\b¢\u0006\u0002\u0010#\u001Ac\u0010$\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010%\u001A\u00020&23\b\n\u0010\'\u001A-\b\u0001\u0012\u0013\u0012\u00110\u001D¢\u0006\f\b\u001E\u0012\b\b\u001F\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0 \u0012\u0006\u0012\u0004\u0018\u00010!0(H\u0087\b¢\u0006\u0002\u0010)\u001A\u007F\u0010*\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032Y\b\b\u0010\'\u001AS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0013\u0012\u00110\u001D¢\u0006\f\b\u001E\u0012\b\b\u001F\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110&¢\u0006\f\b\u001E\u0012\b\b\u001F\u0012\u0004\b\b(,\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0 \u0012\u0006\u0012\u0004\u0018\u00010!0+¢\u0006\u0002\b\"H\u0087\b¢\u0006\u0002\u0010-\u001A$\u0010.\u001A\b\u0012\u0004\u0012\u0002H\u00020/\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087H¢\u0006\u0002\u00100\u001A,\u0010.\u001A\u000201\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u00102\u001A\b\u0012\u0004\u0012\u0002H\u000203H\u0087H¢\u0006\u0002\u00104\u001A$\u00105\u001A\b\u0012\u0004\u0012\u0002H\u000206\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087H¢\u0006\u0002\u00100\u001A,\u00105\u001A\u000201\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u00102\u001A\b\u0012\u0004\u0012\u0002H\u000207H\u0087H¢\u0006\u0002\u00108\u001A\u001E\u00109\u001A\u00020:\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087H¢\u0006\u0002\u00100\"\"\u0010\n\u001A\u00020\u000B*\u0006\u0012\u0002\b\u00030\f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000E\u001A\u0004\b\n\u0010\u000F\"\"\u0010\u0016\u001A\u00020\u0006*\u0006\u0012\u0002\b\u00030\f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u000E\u001A\u0004\b\u0018\u0010\u0019¨\u0006;"}, d2={"cancellable", "Lkotlinx/coroutines/flow/Flow;", "T", "Lkotlinx/coroutines/flow/SharedFlow;", "flowOn", "context", "Lkotlin/coroutines/CoroutineContext;", "conflate", "Lkotlinx/coroutines/flow/StateFlow;", "distinctUntilChanged", "isActive", "", "Lkotlinx/coroutines/flow/FlowCollector;", "isActive$annotations", "(Lkotlinx/coroutines/flow/FlowCollector;)V", "(Lkotlinx/coroutines/flow/FlowCollector;)Z", "cancel", "", "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/util/concurrent/CancellationException;)V", "coroutineContext", "getCoroutineContext$annotations", "getCoroutineContext", "(Lkotlinx/coroutines/flow/FlowCollector;)Lkotlin/coroutines/CoroutineContext;", "catch", "action", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "retry", "retries", "", "predicate", "Lkotlin/Function2;", "(Lkotlinx/coroutines/flow/SharedFlow;JLkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "retryWhen", "Lkotlin/Function4;", "attempt", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "toList", "", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "destination", "", "(Lkotlinx/coroutines/flow/SharedFlow;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSet", "", "", "(Lkotlinx/coroutines/flow/SharedFlow;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "count", "", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class LintKt {
    @Deprecated(level=DeprecationLevel.ERROR, message="cancel() is resolved into the extension of outer CoroutineScope which is likely to be an error. Use currentCoroutineContext().cancel() instead or specify the receiver of cancel() explicitly", replaceWith="<_subannotation>") public static final void cancel(FlowCollector arg0, CancellationException arg1) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static void cancel$default(FlowCollector arg0, CancellationException arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        LintKt.cancel(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Applying \'cancellable\' to a SharedFlow has no effect. See the SharedFlow documentation on Operator Fusion.", replaceWith="<_subannotation>") public static final Flow cancellable(SharedFlow arg0) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="SharedFlow never completes, so this operator typically has not effect, it can only catch exceptions from \'onSubscribe\' operator", replaceWith="<_subannotation>") private static final Flow catch(SharedFlow arg1, Function3 arg2) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.catch>");
        return FlowKt.catch(((Flow)arg1), arg2);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Applying \'conflate\' to StateFlow has no effect. See the StateFlow documentation on Operator Fusion.", replaceWith="<_subannotation>") public static final Flow conflate(StateFlow arg0) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="SharedFlow never completes, so this terminal operation never completes.") private static final Object count(SharedFlow arg1, Continuation arg2) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.count>");
        return FlowKt.count(((Flow)arg1), arg2);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Applying \'distinctUntilChanged\' to StateFlow has no effect. See the StateFlow documentation on Operator Fusion.", replaceWith="<_subannotation>") public static final Flow distinctUntilChanged(StateFlow arg0) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Applying \'flowOn\' to SharedFlow has no effect. See the SharedFlow documentation on Operator Fusion.", replaceWith="<_subannotation>") public static final Flow flowOn(SharedFlow arg0, CoroutineContext arg1) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final CoroutineContext getCoroutineContext(FlowCollector arg0) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="coroutineContext is resolved into the property of outer CoroutineScope which is likely to be an error. Use currentCoroutineContext() instead or specify the receiver of coroutineContext explicitly", replaceWith="<_subannotation>") public static void getCoroutineContext$annotations(FlowCollector arg0) {
    }

    public static final boolean isActive(FlowCollector arg0) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="isActive is resolved into the extension of outer CoroutineScope which is likely to be an error. Use currentCoroutineContext().isActive or cancellable() operator instead or specify the receiver of isActive explicitly. Additionally, flow {} builder emissions are cancellable by default.", replaceWith="<_subannotation>") public static void isActive$annotations(FlowCollector arg0) {
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="SharedFlow never completes, so this operator has no effect.", replaceWith="<_subannotation>") private static final Flow retry(SharedFlow arg1, long arg2, Function2 arg4) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.retry>");
        return FlowKt.retry(((Flow)arg1), arg2, arg4);
    }

    static Flow retry$default(SharedFlow arg0, long arg1, Function2 arg3, int arg4, Object arg5) {
        LintKt$retry$1 v3;
        if((arg4 & 1) != 0) {
            arg1 = 0x7FFFFFFFFFFFFFFFL;
        }

        if((arg4 & 2) != 0) {
            v3 = new LintKt$retry$1(null);
        }

        Intrinsics.checkNotNull(arg0, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.retry>");
        return FlowKt.retry(((Flow)arg0), arg1, ((Function2)v3));
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="SharedFlow never completes, so this operator has no effect.", replaceWith="<_subannotation>") private static final Flow retryWhen(SharedFlow arg1, Function4 arg2) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.retryWhen>");
        return FlowKt.retryWhen(((Flow)arg1), arg2);
    }

    private static final Object toList(SharedFlow arg1, List arg2, Continuation arg3) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toList>");
        FlowKt.toList(((Flow)arg1), arg2, arg3);
        throw new IllegalStateException("this code is supposed to be unreachable");
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="SharedFlow never completes, so this terminal operation never completes.") private static final Object toList(SharedFlow arg2, Continuation arg3) {
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toList>");
        return FlowKt.toList$default(((Flow)arg2), null, arg3, 1, null);
    }

    private static final Object toSet(SharedFlow arg1, Set arg2, Continuation arg3) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toSet>");
        FlowKt.toSet(((Flow)arg1), arg2, arg3);
        throw new IllegalStateException("this code is supposed to be unreachable");
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="SharedFlow never completes, so this terminal operation never completes.") private static final Object toSet(SharedFlow arg2, Continuation arg3) {
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toSet>");
        return FlowKt.toSet$default(((Flow)arg2), null, arg3, 1, null);
    }
}

