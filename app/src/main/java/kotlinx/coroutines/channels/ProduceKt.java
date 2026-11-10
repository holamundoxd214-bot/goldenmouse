package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A&\u0010\u0000\u001A\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u000E\b\u0002\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0086@¢\u0006\u0002\u0010\u0005\u001Ab\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2/\b\u0001\u0010\u0003\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000F\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000E¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001A\u009B\u0001\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u0013\u001A\u00020\u00142-\b\u0002\u0010\u0015\u001A\'\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001A\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016j\u0004\u0018\u0001`\u001B2/\b\u0001\u0010\u0003\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000F\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000E¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u001C\u001A¥\u0001\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u001D\u001A\u00020\u001E2\b\b\u0002\u0010\u0013\u001A\u00020\u00142-\b\u0002\u0010\u0015\u001A\'\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001A\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016j\u0004\u0018\u0001`\u001B2/\b\u0001\u0010\u0003\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000F\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000E¢\u0006\u0002\b\u0011H\u0000¢\u0006\u0002\u0010\u001F¨\u0006 "}, d2={"awaitClose", "", "Lkotlinx/coroutines/channels/ProducerScope;", "block", "Lkotlin/Function0;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produce", "Lkotlinx/coroutines/channels/ReceiveChannel;", "E", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "start", "Lkotlinx/coroutines/CoroutineStart;", "onCompletion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ProduceKt {
    public static final Object awaitClose(ProducerScope arg4, Function0 arg5, Continuation arg6) {
        Object v5;
        ProduceKt$awaitClose$1 v0_1;
        int v2;
        if((arg6 instanceof ProduceKt$awaitClose$1)) {
            Continuation v0 = arg6;
            v2 = 0x80000000;
            if((((ProduceKt$awaitClose$1)v0).label & v2) != 0) {
                ((ProduceKt$awaitClose$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new ProduceKt$awaitClose$1(arg6);
        }

        Object v6 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v6);
            if(((Continuation)v0_1).getContext().get(Job.Key) == arg4) {
                try {
                    v0_1.L$0 = arg4;
                    v0_1.L$1 = arg5;
                    v0_1.label = 1;
                    CancellableContinuationImpl v2_1 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(((Continuation)v0_1)), 1);
                    v2_1.initCancellability();
                    arg4.invokeOnClose(new ProduceKt$awaitClose$4$1(v2_1));
                    Object v4_1 = v2_1.getResult();
                    if(v4_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(((Continuation)v0_1));
                    }
                }
                catch(Throwable v4) {
                label_56:
                    ((Function0)v5).invoke();
                    throw v4;
                }

                if(v4_1 != v1) {
                    goto label_53;
                }

                return v1;
            }
            else {
                goto label_58;
            }
        }
        else if(v2 == 1) {
            v5 = v0_1.L$1;
            try {
                ResultKt.throwOnFailure(v6);
            }
            catch(Throwable v4) {
                goto label_56;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_53:
        ((Function0)v5).invoke();
        return Unit.INSTANCE;
    label_58:
        throw new IllegalStateException("awaitClose() can only be invoked from the producer context".toString());
    }

    public static Object awaitClose$default(ProducerScope arg0, Function0 arg1, Continuation arg2, int arg3, Object arg4) {
        ProduceKt$$ExternalSyntheticLambda0 v1;
        if((arg3 & 1) != 0) {
            v1 = new ProduceKt$$ExternalSyntheticLambda0();
        }

        return ProduceKt.awaitClose(arg0, ((Function0)v1), arg2);
    }

    static final Unit awaitClose$lambda$0() {
        return Unit.INSTANCE;
    }

    public static final ReceiveChannel produce(CoroutineScope arg7, CoroutineContext arg8, int arg9, Function2 arg10) {
        return ProduceKt.produce(arg7, arg8, arg9, BufferOverflow.SUSPEND, CoroutineStart.DEFAULT, null, arg10);
    }

    public static final ReceiveChannel produce(CoroutineScope arg2, CoroutineContext arg3, int arg4, BufferOverflow arg5, CoroutineStart arg6, Function1 arg7, Function2 arg8) {
        ProducerCoroutine v3 = new ProducerCoroutine(CoroutineContextKt.newCoroutineContext(arg2, arg3), ChannelKt.Channel$default(arg4, arg5, null, 4, null));
        if(arg7 != null) {
            v3.invokeOnCompletion(arg7);
        }

        v3.start(arg6, v3, arg8);
        return ((ReceiveChannel)v3);
    }

    public static final ReceiveChannel produce(CoroutineScope arg7, CoroutineContext arg8, int arg9, CoroutineStart arg10, Function1 arg11, Function2 arg12) {
        return ProduceKt.produce(arg7, arg8, arg9, BufferOverflow.SUSPEND, arg10, arg11, arg12);
    }

    public static ReceiveChannel produce$default(CoroutineScope arg0, CoroutineContext arg1, int arg2, CoroutineStart arg3, Function1 arg4, Function2 arg5, int arg6, Object arg7) {
        EmptyCoroutineContext v1;
        if((arg6 & 1) != 0) {
            v1 = EmptyCoroutineContext.INSTANCE;
        }

        if((arg6 & 4) != 0) {
            arg3 = CoroutineStart.DEFAULT;
        }

        if((arg6 & 8) != 0) {
            arg4 = null;
        }

        return ProduceKt.produce(arg0, ((CoroutineContext)v1), 0, arg3, arg4, arg5);
    }

    public static ReceiveChannel produce$default(CoroutineScope arg0, CoroutineContext arg1, int arg2, Function2 arg3, int arg4, Object arg5) {
        EmptyCoroutineContext v1;
        if((arg4 & 1) != 0) {
            v1 = EmptyCoroutineContext.INSTANCE;
        }

        return ProduceKt.produce(arg0, ((CoroutineContext)v1), 0, arg3);
    }

    public static ReceiveChannel produce$default(CoroutineScope arg0, CoroutineContext arg1, int arg2, BufferOverflow arg3, CoroutineStart arg4, Function1 arg5, Function2 arg6, int arg7, Object arg8) {
        EmptyCoroutineContext v1;
        if((arg7 & 1) != 0) {
            v1 = EmptyCoroutineContext.INSTANCE;
        }

        if((arg7 & 4) != 0) {
            arg3 = BufferOverflow.SUSPEND;
        }

        if((arg7 & 8) != 0) {
            arg4 = CoroutineStart.DEFAULT;
        }

        if((arg7 & 16) != 0) {
            arg5 = null;
        }

        return ProduceKt.produce(arg0, ((CoroutineContext)v1), 0, arg3, arg4, arg5, arg6);
    }
}

