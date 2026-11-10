package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1={"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\u001AJ\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012$\b\u0004\u0010\u0003\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086\b¢\u0006\u0002\u0010\b\u001AJ\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012$\b\u0004\u0010\u0003\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086\b¢\u0006\u0002\u0010\b\u001A\u001F\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\u000B0\u0001\"\u0006\b\u0000\u0010\u000B\u0018\u0001*\u0006\u0012\u0002\b\u00030\u0001H\u0086\b\u001A,\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\u000B0\u0001\"\b\b\u0000\u0010\u000B*\u00020\u0007*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u000B0\r\u001A\"\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0007*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\u001A_\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\u000B0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000B*\b\u0012\u0004\u0012\u0002H\u00020\u000123\b\u0004\u0010\u0010\u001A-\b\u0001\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000B0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086\b¢\u0006\u0002\u0010\b\u001Ae\u0010\u0014\u001A\b\u0012\u0004\u0012\u0002H\u000B0\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u000B*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00020\u000125\b\u0004\u0010\u0010\u001A/\b\u0001\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000B0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086\b¢\u0006\u0002\u0010\b\u001A\"\u0010\u0015\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00160\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001AE\u0010\u0017\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\"\u0010\u0018\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\u0002\u0010\b\u001Ay\u0010\u001A\u001A\b\u0012\u0004\u0012\u0002H\u000B0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000B*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u001B\u001A\u0002H\u000B2H\b\u0001\u0010\u001C\u001AB\b\u0001\u0012\u0013\u0012\u0011H\u000B¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001E\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000B0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001D¢\u0006\u0002\u0010\u001F\u001Ay\u0010 \u001A\b\u0012\u0004\u0012\u0002H\u000B0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000B*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u001B\u001A\u0002H\u000B2H\b\u0001\u0010\u001C\u001AB\b\u0001\u0012\u0013\u0012\u0011H\u000B¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001E\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000B0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001D¢\u0006\u0002\u0010\u001F\u001Ai\u0010!\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012F\u0010\u001C\u001AB\b\u0001\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001E\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001D¢\u0006\u0002\u0010\"\u001A,\u0010#\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020$0\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010%\u001A\u00020&H\u0007¨\u0006\'"}, d2={"filter", "Lkotlinx/coroutines/flow/Flow;", "T", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "filterNot", "filterIsInstance", "R", "klass", "Lkotlin/reflect/KClass;", "filterNotNull", "map", "transform", "Lkotlin/ParameterName;", "name", "value", "mapNotNull", "withIndex", "Lkotlin/collections/IndexedValue;", "onEach", "action", "", "scan", "initial", "operation", "Lkotlin/Function3;", "accumulator", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "runningFold", "runningReduce", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "chunked", "", "size", "", "kotlinx-coroutines-core"}, k=5, mv={2, 1, 0}, xi=0x30, xs="kotlinx/coroutines/flow/FlowKt") final class FlowKt__TransformKt {
    public static final Flow chunked(Flow arg1, int arg2) {
        if(arg2 >= 1) {
            return new FlowKt__TransformKt$chunked$$inlined$unsafeFlow$1(arg1, arg2);
        }

        throw new IllegalArgumentException("Expected positive chunk size, but got " + arg2.toString());
    }

    public static final Flow filter(Flow arg1, Function2 arg2) {
        return new FlowKt__TransformKt$filter$$inlined$unsafeTransform$1(arg1, arg2);
    }

    public static final Flow filterIsInstance(Flow arg1) {
        Intrinsics.needClassReification();
        return new FlowKt__TransformKt$filterIsInstance$$inlined$filter$1(arg1);
    }

    public static final Flow filterIsInstance(Flow arg1, KClass arg2) {
        return new FlowKt__TransformKt$filterIsInstance$$inlined$filter$2(arg1, arg2);
    }

    public static final Flow filterNot(Flow arg1, Function2 arg2) {
        return new FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1(arg1, arg2);
    }

    public static final Flow filterNotNull(Flow arg1) {
        return new FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1(arg1);
    }

    public static final Flow map(Flow arg1, Function2 arg2) {
        return new FlowKt__TransformKt$map$$inlined$unsafeTransform$1(arg1, arg2);
    }

    public static final Flow mapNotNull(Flow arg1, Function2 arg2) {
        return new FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1(arg1, arg2);
    }

    public static final Flow onEach(Flow arg1, Function2 arg2) {
        return new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(arg1, arg2);
    }

    public static final Flow runningFold(Flow arg1, Object arg2, Function3 arg3) {
        return new FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1(arg2, arg1, arg3);
    }

    public static final Flow runningReduce(Flow arg1, Function3 arg2) {
        return new FlowKt__TransformKt$runningReduce$$inlined$unsafeFlow$1(arg1, arg2);
    }

    public static final Flow scan(Flow arg0, Object arg1, Function3 arg2) {
        return FlowKt.runningFold(arg0, arg1, arg2);
    }

    public static final Flow withIndex(Flow arg1) {
        return new FlowKt__TransformKt$withIndex$$inlined$unsafeFlow$1(arg1);
    }
}

