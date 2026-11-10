package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001A,\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001A6\u0010\u0007\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\b\u001A\u00020\tH\u0082@¢\u0006\u0004\b\n\u0010\u000B\u001A\u001C\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u00020\r\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001A\u001C\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00020\r\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001A$\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\u0006\u0010\u0010\u001A\u00020\u0011¨\u0006\u0012"}, d2={"emitAll", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "channel", "Lkotlinx/coroutines/channels/ReceiveChannel;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitAllImpl", "consume", "", "emitAllImpl$FlowKt__ChannelsKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveAsFlow", "Lkotlinx/coroutines/flow/Flow;", "consumeAsFlow", "produceIn", "scope", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"}, k=5, mv={2, 1, 0}, xi=0x30, xs="kotlinx/coroutines/flow/FlowKt") final class FlowKt__ChannelsKt {
    public static final Object access$emitAllImpl$FlowKt__ChannelsKt(FlowCollector arg0, ReceiveChannel arg1, boolean arg2, Continuation arg3) {
        return FlowKt__ChannelsKt.emitAllImpl$FlowKt__ChannelsKt(arg0, arg1, arg2, arg3);
    }

    public static final Flow consumeAsFlow(ReceiveChannel arg8) {
        return new ChannelAsFlow(arg8, true, null, 0, null, 28, null);
    }

    public static final Object emitAll(FlowCollector arg1, ReceiveChannel arg2, Continuation arg3) {
        Object v1 = FlowKt__ChannelsKt.emitAllImpl$FlowKt__ChannelsKt(arg1, arg2, true, arg3);
        if(v1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v1;
        }

        return Unit.INSTANCE;
    }

    private static final Object emitAllImpl$FlowKt__ChannelsKt(FlowCollector arg7, ReceiveChannel arg8, boolean arg9, Continuation arg10) {
        Object v2_1;
        Object v8;
        Object v7;
        ChannelIterator v10_1;
        int v2;
        Continuation v0;
        if((arg10 instanceof FlowKt__ChannelsKt$emitAllImpl$1)) {
            v0 = arg10;
            v2 = 0x80000000;
            if((((FlowKt__ChannelsKt$emitAllImpl$1)v0).label & v2) != 0) {
                ((FlowKt__ChannelsKt$emitAllImpl$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            FlowKt__ChannelsKt$emitAllImpl$1 v0_1 = new FlowKt__ChannelsKt$emitAllImpl$1(arg10);
        }

        Object v10 = ((FlowKt__ChannelsKt$emitAllImpl$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((FlowKt__ChannelsKt$emitAllImpl$1)v0).label;
        int v3 = 2;
        Throwable v5 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v10);
            FlowKt.ensureActive(arg7);
            try {
                v10_1 = arg8.iterator();
                goto label_43;
            }
            catch(Throwable v7_1) {
                try {
                label_71:
                    throw v7_1;
                }
                catch(Throwable v10_2) {
                    if(arg9) {
                        ChannelsKt.cancelConsumed(((ReceiveChannel)v8), v7_1);
                    }

                    throw v10_2;
                }
            }

            try {
            label_55:
                if(!((Boolean)v10).booleanValue()) {
                    goto label_66;
                }

                v10 = ((ChannelIterator)v7).next();
                ((FlowKt__ChannelsKt$emitAllImpl$1)v0).L$0 = v2_1;
                ((FlowKt__ChannelsKt$emitAllImpl$1)v0).L$1 = v8;
                ((FlowKt__ChannelsKt$emitAllImpl$1)v0).L$2 = v7;
                ((FlowKt__ChannelsKt$emitAllImpl$1)v0).Z$0 = arg9;
                ((FlowKt__ChannelsKt$emitAllImpl$1)v0).label = v3;
                if(((FlowCollector)v2_1).emit(v10, v0) != v1) {
                    goto label_27;
                }

                return v1;
            }
            catch(Throwable v7_1) {
                goto label_71;
            }

        label_66:
            if(arg9) {
                ChannelsKt.cancelConsumed(((ReceiveChannel)v8), v5);
            }

            return Unit.INSTANCE;
            try {
            label_43:
                ((FlowKt__ChannelsKt$emitAllImpl$1)v0).L$0 = arg7;
                ((FlowKt__ChannelsKt$emitAllImpl$1)v0).L$1 = v8;
                ((FlowKt__ChannelsKt$emitAllImpl$1)v0).L$2 = v10_1;
                ((FlowKt__ChannelsKt$emitAllImpl$1)v0).Z$0 = arg9;
                ((FlowKt__ChannelsKt$emitAllImpl$1)v0).label = 1;
                v2_1 = v10_1.hasNext(v0);
                if(v2_1 == v1) {
                    return v1;
                }

                Object v6 = v2_1;
                FlowCollector v2_2 = arg7;
                v7 = v10_1;
                v10 = v6;
                goto label_55;
            }
            catch(Throwable v7_1) {
                goto label_71;
            }
        }
        else if(v2 == 1) {
            arg9 = ((FlowKt__ChannelsKt$emitAllImpl$1)v0).Z$0;
            v7 = ((FlowKt__ChannelsKt$emitAllImpl$1)v0).L$2;
            v8 = ((FlowKt__ChannelsKt$emitAllImpl$1)v0).L$1;
            v2_1 = ((FlowKt__ChannelsKt$emitAllImpl$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v10);
                goto label_55;
            }
            catch(Throwable v7_1) {
                goto label_71;
            }
        }
        else if(v2 == v3) {
            arg9 = ((FlowKt__ChannelsKt$emitAllImpl$1)v0).Z$0;
            v7 = ((FlowKt__ChannelsKt$emitAllImpl$1)v0).L$2;
            v8 = ((FlowKt__ChannelsKt$emitAllImpl$1)v0).L$1;
            v2_1 = ((FlowKt__ChannelsKt$emitAllImpl$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v10);
            }
            catch(Throwable v7_1) {
                goto label_71;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_27:
        v10 = v7;
        v7 = v2_1;
        goto label_43;
    }

    public static final ReceiveChannel produceIn(Flow arg0, CoroutineScope arg1) {
        return ChannelFlowKt.asChannelFlow(arg0).produceImpl(arg1);
    }

    public static final Flow receiveAsFlow(ReceiveChannel arg8) {
        return new ChannelAsFlow(arg8, false, null, 0, null, 28, null);
    }
}

