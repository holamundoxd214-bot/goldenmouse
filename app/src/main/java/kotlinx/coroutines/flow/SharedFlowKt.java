package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1={"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A0\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u001A#\u0010\n\u001A\u0004\u0018\u00010\u000B*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\f2\u0006\u0010\r\u001A\u00020\u000EH\u0002¢\u0006\u0002\u0010\u000F\u001A+\u0010\u0010\u001A\u00020\u0011*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\f2\u0006\u0010\r\u001A\u00020\u000E2\b\u0010\u0012\u001A\u0004\u0018\u00010\u000BH\u0002¢\u0006\u0002\u0010\u0013\u001A6\u0010\u0014\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0007H\u0000\"\u0010\u0010\b\u001A\u00020\t8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2={"MutableSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "T", "replay", "", "extraBufferCapacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "NO_VALUE", "Lkotlinx/coroutines/internal/Symbol;", "getBufferAt", "", "", "index", "", "([Ljava/lang/Object;J)Ljava/lang/Object;", "setBufferAt", "", "item", "([Ljava/lang/Object;JLjava/lang/Object;)V", "fuseSharedFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharedFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SharedFlowKt {
    public static final Symbol NO_VALUE;

    static {
        SharedFlowKt.NO_VALUE = new Symbol("NO_VALUE");
    }

    public static final MutableSharedFlow MutableSharedFlow(int arg1, int arg2, BufferOverflow arg3) {
        if(arg1 >= 0) {
            if(arg2 >= 0) {
                if(arg1 <= 0 && arg2 <= 0) {
                    if(arg3 == BufferOverflow.SUSPEND) {
                    }
                    else {
                        throw new IllegalArgumentException("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + arg3.toString());
                    }
                }

                arg2 += arg1;
                if(arg2 < 0) {
                    arg2 = 0x7FFFFFFF;
                }

                return new SharedFlowImpl(arg1, arg2, arg3);
            }

            throw new IllegalArgumentException("extraBufferCapacity cannot be negative, but was " + arg2.toString());
        }

        throw new IllegalArgumentException("replay cannot be negative, but was " + arg1.toString());
    }

    public static MutableSharedFlow MutableSharedFlow$default(int arg1, int arg2, BufferOverflow arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = BufferOverflow.SUSPEND;
        }

        return SharedFlowKt.MutableSharedFlow(0, 0, arg3);
    }

    public static final Object access$getBufferAt(Object[] arg0, long arg1) {
        return SharedFlowKt.getBufferAt(arg0, arg1);
    }

    public static final void access$setBufferAt(Object[] arg0, long arg1, Object arg3) {
        SharedFlowKt.setBufferAt(arg0, arg1, arg3);
    }

    public static final Flow fuseSharedFlow(SharedFlow arg1, CoroutineContext arg2, int arg3, BufferOverflow arg4) {
        if((arg3 == 0 || arg3 == -3) && arg4 == BufferOverflow.SUSPEND) {
            return arg1;
        }

        return new ChannelFlowOperatorImpl(((Flow)arg1), arg2, arg3, arg4);
    }

    private static final Object getBufferAt(Object[] arg0, long arg1) {
        return arg0[(((int)arg1)) & arg0.length - 1];
    }

    private static final void setBufferAt(Object[] arg0, long arg1, Object arg3) {
        arg0[(((int)arg1)) & arg0.length - 1] = arg3;
    }
}

