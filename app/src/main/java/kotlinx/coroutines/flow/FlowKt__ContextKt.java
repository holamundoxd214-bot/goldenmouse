package kotlinx.coroutines.flow;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.flow.internal.FusibleFlow$DefaultImpls;
import kotlinx.coroutines.flow.internal.FusibleFlow;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001A0\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u001A(\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0007\u001A\u001C\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001A$\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\t\u001A\u00020\n\u001A\u001C\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001A\u0015\u0010\f\u001A\u00020\r2\u0006\u0010\t\u001A\u00020\nH\u0002¢\u0006\u0002\b\u000E¨\u0006\u000F"}, d2={"buffer", "Lkotlinx/coroutines/flow/Flow;", "T", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "conflate", "flowOn", "context", "Lkotlin/coroutines/CoroutineContext;", "cancellable", "checkFlowContext", "", "checkFlowContext$FlowKt__ContextKt", "kotlinx-coroutines-core"}, k=5, mv={2, 1, 0}, xi=0x30, xs="kotlinx/coroutines/flow/FlowKt") final class FlowKt__ContextKt {
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.4.0, binary compatibility with earlier versions") public static final Flow buffer(Flow arg2, int arg3) {
        return FlowKt.buffer$default(arg2, arg3, null, 2, null);
    }

    public static final Flow buffer(Flow arg7, int arg8, BufferOverflow arg9) {
        int v0 = -1;
        if(arg8 < 0 && arg8 != -2) {
            if(arg8 == v0) {
            }
            else {
                throw new IllegalArgumentException("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + arg8.toString());
            }
        }

        if(arg8 == v0) {
            if(arg9 == BufferOverflow.SUSPEND) {
            }
            else {
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
            }
        }

        if(arg8 == v0) {
            arg9 = BufferOverflow.DROP_OLDEST;
        }

        BufferOverflow v3 = arg9;
        if((arg7 instanceof FusibleFlow)) {
            return DefaultImpls.fuse$default(arg7, null, 0, v3, 1, null);
        }

        return new ChannelFlowOperatorImpl(arg7, null, 0, v3, 2, null);
    }

    public static Flow buffer$default(Flow arg0, int arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = -2;
        }

        return FlowKt.buffer(arg0, arg1);
    }

    public static Flow buffer$default(Flow arg0, int arg1, BufferOverflow arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = -2;
        }

        if((arg3 & 2) != 0) {
            arg2 = BufferOverflow.SUSPEND;
        }

        return FlowKt.buffer(arg0, arg1, arg2);
    }

    public static final Flow cancellable(Flow arg1) {
        if((arg1 instanceof CancellableFlow)) {
            return arg1;
        }

        return new CancellableFlowImpl(arg1);
    }

    private static final void checkFlowContext$FlowKt__ContextKt(CoroutineContext arg2) {
        if(arg2.get(Job.Key) == null) {
            return;
        }

        throw new IllegalArgumentException("Flow context cannot contain job in it. Had " + arg2.toString());
    }

    public static final Flow conflate(Flow arg3) {
        return FlowKt.buffer$default(arg3, -1, null, 2, null);
    }

    public static final Flow flowOn(Flow arg7, CoroutineContext arg8) {
        FlowKt__ContextKt.checkFlowContext$FlowKt__ContextKt(arg8);
        if(Intrinsics.areEqual(arg8, EmptyCoroutineContext.INSTANCE)) {
            return arg7;
        }

        if((arg7 instanceof FusibleFlow)) {
            return DefaultImpls.fuse$default(arg7, arg8, 0, null, 6, null);
        }

        return new ChannelFlowOperatorImpl(arg7, arg8, 0, null, 12, null);
    }
}

