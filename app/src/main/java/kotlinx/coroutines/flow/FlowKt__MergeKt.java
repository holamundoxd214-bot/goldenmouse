package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.internal.ChannelFlowMerge;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge;
import kotlinx.coroutines.internal.SystemPropsKt;

@Metadata(d1={"\u0000T\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u001C\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001Ab\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u000B0\n\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u000B*\b\u0012\u0004\u0012\u0002H\f0\n27\u0010\r\u001A3\b\u0001\u0012\u0013\u0012\u0011H\f¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000B0\n0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000EH\u0007¢\u0006\u0002\u0010\u0014\u001Al\u0010\u0015\u001A\b\u0012\u0004\u0012\u0002H\u000B0\n\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u000B*\b\u0012\u0004\u0012\u0002H\f0\n2\b\b\u0002\u0010\u0016\u001A\u00020\u000527\u0010\r\u001A3\b\u0001\u0012\u0013\u0012\u0011H\f¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000B0\n0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000EH\u0007¢\u0006\u0002\u0010\u0017\u001A$\u0010\u0018\u001A\b\u0012\u0004\u0012\u0002H\f0\n\"\u0004\b\u0000\u0010\f*\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\n0\nH\u0007\u001A\"\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H\f0\n\"\u0004\b\u0000\u0010\f*\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\n0\u001A\u001A7\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H\f0\n\"\u0004\b\u0000\u0010\f2\u001E\u0010\u001B\u001A\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\f0\n0\u001C\"\b\u0012\u0004\u0012\u0002H\f0\n¢\u0006\u0002\u0010\u001D\u001A.\u0010\u001E\u001A\b\u0012\u0004\u0012\u0002H\f0\n\"\u0004\b\u0000\u0010\f*\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\n0\n2\b\b\u0002\u0010\u0016\u001A\u00020\u0005H\u0007\u001Ao\u0010\u001F\u001A\b\u0012\u0004\u0012\u0002H\u000B0\n\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u000B*\b\u0012\u0004\u0012\u0002H\f0\n2D\b\u0001\u0010\r\u001A>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000B0!\u0012\u0013\u0012\u0011H\f¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130 ¢\u0006\u0002\b#H\u0007¢\u0006\u0002\u0010$\u001Ae\u0010%\u001A\b\u0012\u0004\u0012\u0002H\u000B0\n\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u000B*\b\u0012\u0004\u0012\u0002H\f0\n29\b\u0005\u0010\r\u001A3\b\u0001\u0012\u0013\u0012\u0011H\f¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000B0\n0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000EH\u0087\b¢\u0006\u0002\u0010\u0014\u001A^\u0010&\u001A\b\u0012\u0004\u0012\u0002H\u000B0\n\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u000B*\b\u0012\u0004\u0012\u0002H\f0\n23\b\u0001\u0010\r\u001A-\b\u0001\u0012\u0013\u0012\u0011H\f¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000B0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000EH\u0007¢\u0006\u0002\u0010\u0014\"\u0016\u0010\u0000\u001A\u00020\u00018\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u001C\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\b¨\u0006\'"}, d2={"DEFAULT_CONCURRENCY_PROPERTY_NAME", "", "getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations", "()V", "DEFAULT_CONCURRENCY", "", "getDEFAULT_CONCURRENCY$annotations", "getDEFAULT_CONCURRENCY", "()I", "flatMapConcat", "Lkotlinx/coroutines/flow/Flow;", "R", "T", "transform", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "flatMapMerge", "concurrency", "(Lkotlinx/coroutines/flow/Flow;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "flattenConcat", "merge", "", "flows", "", "([Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "flattenMerge", "transformLatest", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "flatMapLatest", "mapLatest", "kotlinx-coroutines-core"}, k=5, mv={2, 1, 0}, xi=0x30, xs="kotlinx/coroutines/flow/FlowKt") final class FlowKt__MergeKt {
    private static final int DEFAULT_CONCURRENCY;

    static {
        FlowKt__MergeKt.DEFAULT_CONCURRENCY = SystemPropsKt.systemProp("kotlinx.coroutines.flow.defaultConcurrency", 16, 1, 0x7FFFFFFF);
    }

    public static final Flow flatMapConcat(Flow arg1, Function2 arg2) {
        return FlowKt.flattenConcat(new FlowKt__MergeKt$flatMapConcat$$inlined$map$1(arg1, arg2));
    }

    public static final Flow flatMapLatest(Flow arg2, Function2 arg3) {
        return FlowKt.transformLatest(arg2, new FlowKt__MergeKt$flatMapLatest$1(arg3, null));
    }

    public static final Flow flatMapMerge(Flow arg1, int arg2, Function2 arg3) {
        return FlowKt.flattenMerge(new FlowKt__MergeKt$flatMapMerge$$inlined$map$1(arg1, arg3), arg2);
    }

    public static Flow flatMapMerge$default(Flow arg0, int arg1, Function2 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = FlowKt__MergeKt.DEFAULT_CONCURRENCY;
        }

        return FlowKt.flatMapMerge(arg0, arg1, arg2);
    }

    public static final Flow flattenConcat(Flow arg1) {
        return new FlowKt__MergeKt$flattenConcat$$inlined$unsafeFlow$1(arg1);
    }

    public static final Flow flattenMerge(Flow arg8, int arg9) {
        if(arg9 > 0) {
            if(arg9 == 1) {
                return FlowKt.flattenConcat(arg8);
            }

            return new ChannelFlowMerge(arg8, arg9, null, 0, null, 28, null);
        }

        throw new IllegalArgumentException("Expected positive concurrency level, but had " + arg9.toString());
    }

    public static Flow flattenMerge$default(Flow arg0, int arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = FlowKt__MergeKt.DEFAULT_CONCURRENCY;
        }

        return FlowKt.flattenMerge(arg0, arg1);
    }

    public static final int getDEFAULT_CONCURRENCY() {
        return FlowKt__MergeKt.DEFAULT_CONCURRENCY;
    }

    public static void getDEFAULT_CONCURRENCY$annotations() {
    }

    public static void getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations() {
    }

    public static final Flow mapLatest(Flow arg2, Function2 arg3) {
        return FlowKt.transformLatest(arg2, new FlowKt__MergeKt$mapLatest$1(arg3, null));
    }

    public static final Flow merge(Iterable arg7) {
        return new ChannelLimitedFlowMerge(arg7, null, 0, null, 14, null);
    }

    public static final Flow merge(Flow[] arg0) {
        return FlowKt.merge(ArraysKt.asIterable(((Object[])arg0)));
    }

    public static final Flow transformLatest(Flow arg8, Function3 arg9) {
        return new ChannelFlowTransformLatest(arg9, arg8, null, 0, null, 28, null);
    }
}

