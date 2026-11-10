package kotlinx.coroutines.flow;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.sequences.Sequence;

@Metadata(d1={"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001C\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001AH\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022/\b\u0001\u0010\u0003\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\t¢\u0006\u0002\u0010\n\u001A\u001C\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f\u001A1\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\r¢\u0006\u0002\u0010\u000E\u001A\u001C\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000F\u001A\u001C\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0010\u001A\u001C\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0011\u001A+\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0013\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0014\"\u0002H\u0002¢\u0006\u0002\u0010\u0015\u001A\u001F\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0016\u001A\u0002H\u0002¢\u0006\u0002\u0010\u0017\u001A\u0012\u0010\u0018\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001A!\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0014¢\u0006\u0002\u0010\u0015\u001A\u0010\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00190\u0001*\u00020\u001A\u001A\u0010\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u001B0\u0001*\u00020\u001C\u001A\u0010\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00190\u0001*\u00020\u001D\u001A\u0010\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u001B0\u0001*\u00020\u001E\u001AH\u0010\u001F\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022/\b\u0001\u0010\u0003\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\t¢\u0006\u0002\u0010\n\u001AH\u0010!\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022/\b\u0001\u0010\u0003\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\t¢\u0006\u0002\u0010\n¨\u0006\""}, d2={"flow", "Lkotlinx/coroutines/flow/Flow;", "T", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "asFlow", "Lkotlin/Function0;", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "", "", "Lkotlin/sequences/Sequence;", "flowOf", "elements", "", "([Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "value", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "emptyFlow", "", "", "", "", "Lkotlin/ranges/IntRange;", "Lkotlin/ranges/LongRange;", "channelFlow", "Lkotlinx/coroutines/channels/ProducerScope;", "callbackFlow", "kotlinx-coroutines-core"}, k=5, mv={2, 1, 0}, xi=0x30, xs="kotlinx/coroutines/flow/FlowKt") final class FlowKt__BuildersKt {
    public static final Flow asFlow(Iterable arg1) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3(arg1);
    }

    public static final Flow asFlow(Iterator arg1) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4(arg1);
    }

    public static final Flow asFlow(Function0 arg1) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$1(arg1);
    }

    public static final Flow asFlow(Function1 arg1) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2(arg1);
    }

    public static final Flow asFlow(IntRange arg1) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9(arg1);
    }

    public static final Flow asFlow(LongRange arg1) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10(arg1);
    }

    public static final Flow asFlow(Sequence arg1) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5(arg1);
    }

    public static final Flow asFlow(int[] arg1) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7(arg1);
    }

    public static final Flow asFlow(long[] arg1) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8(arg1);
    }

    public static final Flow asFlow(Object[] arg1) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6(arg1);
    }

    public static final Flow callbackFlow(Function2 arg7) {
        return new CallbackFlowBuilder(arg7, null, 0, null, 14, null);
    }

    public static final Flow channelFlow(Function2 arg7) {
        return new ChannelFlowBuilder(arg7, null, 0, null, 14, null);
    }

    public static final Flow emptyFlow() {
        return EmptyFlow.INSTANCE;
    }

    public static final Flow flow(Function2 arg1) {
        return new SafeFlow(arg1);
    }

    public static final Flow flowOf(Object arg1) {
        return new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(arg1);
    }

    public static final Flow flowOf(Object[] arg1) {
        return new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1(arg1);
    }
}

