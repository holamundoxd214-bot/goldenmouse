package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.FlowCoroutineKt;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001A&\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004H\u0007\u001A2\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00040\u0005H\u0007\u001A-\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t\u001A7\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u0005H\u0007¢\u0006\u0002\b\n\u001A7\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00040\u0005H\u0002¢\u0006\u0002\b\r\u001A&\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u0004H\u0007\u001A\u001A\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00120\u0011*\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0004H\u0000\u001A-\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0015\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\u0016\u0010\t\u001A-\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\u0017\u0010\t\u001A-\u0010\u0018\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\t¨\u0006\u001A"}, d2={"debounce", "Lkotlinx/coroutines/flow/Flow;", "T", "timeoutMillis", "", "Lkotlin/Function1;", "timeout", "Lkotlin/time/Duration;", "debounce-HG0u8IE", "(Lkotlinx/coroutines/flow/Flow;J)Lkotlinx/coroutines/flow/Flow;", "debounceDuration", "debounceInternal", "timeoutMillisSelector", "debounceInternal$FlowKt__DelayKt", "sample", "periodMillis", "fixedPeriodTicker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "Lkotlinx/coroutines/CoroutineScope;", "delayMillis", "period", "sample-HG0u8IE", "timeout-HG0u8IE", "timeoutInternal", "timeoutInternal-HG0u8IE$FlowKt__DelayKt", "kotlinx-coroutines-core"}, k=5, mv={2, 1, 0}, xi=0x30, xs="kotlinx/coroutines/flow/FlowKt") final class FlowKt__DelayKt {
    public static long $r8$lambda$dHPYgGi525O8NWs4Dz-jenbjXIg(long arg0, Object arg2) {
        return FlowKt__DelayKt.debounce$lambda$1$FlowKt__DelayKt(arg0, arg2);
    }

    public static long $r8$lambda$lHgEoaIjdv0Q0nae16lyucRVvig(Function1 arg0, Object arg1) {
        return FlowKt__DelayKt.debounce$lambda$2$FlowKt__DelayKt(arg0, arg1);
    }

    public static final Flow debounce(Flow arg2, long arg3) {
        int v0 = Long.compare(arg3, 0);
        if(v0 >= 0) {
            if(v0 == 0) {
                return arg2;
            }

            return FlowKt__DelayKt.debounceInternal$FlowKt__DelayKt(arg2, new FlowKt__DelayKt$$ExternalSyntheticLambda1(arg3));
        }

        throw new IllegalArgumentException("Debounce timeout should not be negative".toString());
    }

    public static final Flow debounce(Flow arg0, Function1 arg1) {
        return FlowKt__DelayKt.debounceInternal$FlowKt__DelayKt(arg0, arg1);
    }

    private static final long debounce$lambda$1$FlowKt__DelayKt(long arg0, Object arg2) {
        return arg0;
    }

    private static final long debounce$lambda$2$FlowKt__DelayKt(Function1 arg0, Object arg1) {
        return DelayKt.toDelayMillis-LRDsOJo(arg0.invoke(arg1).unbox-impl());
    }

    public static final Flow debounce-HG0u8IE(Flow arg0, long arg1) {
        return FlowKt.debounce(arg0, DelayKt.toDelayMillis-LRDsOJo(arg1));
    }

    public static final Flow debounceDuration(Flow arg1, Function1 arg2) {
        return FlowKt__DelayKt.debounceInternal$FlowKt__DelayKt(arg1, new FlowKt__DelayKt$$ExternalSyntheticLambda0(arg2));
    }

    private static final Flow debounceInternal$FlowKt__DelayKt(Flow arg2, Function1 arg3) {
        return FlowCoroutineKt.scopedFlow(new FlowKt__DelayKt$debounceInternal$1(arg3, arg2, null));
    }

    public static final ReceiveChannel fixedPeriodTicker(CoroutineScope arg8, long arg9) {
        return ProduceKt.produce$default(arg8, null, 0, new FlowKt__DelayKt$fixedPeriodTicker$1(arg9, null), 1, null);
    }

    public static final Flow sample(Flow arg2, long arg3) {
        if(arg3 > 0) {
            return FlowCoroutineKt.scopedFlow(new FlowKt__DelayKt$sample$2(arg3, arg2, null));
        }

        throw new IllegalArgumentException("Sample period should be positive".toString());
    }

    public static final Flow sample-HG0u8IE(Flow arg0, long arg1) {
        return FlowKt.sample(arg0, DelayKt.toDelayMillis-LRDsOJo(arg1));
    }

    public static final Flow timeout-HG0u8IE(Flow arg0, long arg1) {
        return FlowKt__DelayKt.timeoutInternal-HG0u8IE$FlowKt__DelayKt(arg0, arg1);
    }

    private static final Flow timeoutInternal-HG0u8IE$FlowKt__DelayKt(Flow arg2, long arg3) {
        return FlowCoroutineKt.scopedFlow(new FlowKt__DelayKt$timeoutInternal$1(arg3, arg2, null));
    }
}

