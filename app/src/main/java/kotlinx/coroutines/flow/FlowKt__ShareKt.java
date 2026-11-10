package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.internal.ChannelFlow;

@Metadata(d1={"\u0000x\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A6\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t\u001A+\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\u00020\u000B\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001A\u00020\tH\u0002¢\u0006\u0002\b\f\u001AM\u0010\r\u001A\u00020\u000E\"\u0004\b\u0000\u0010\u0002*\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u00102\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00132\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u0002H\u0002H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001A9\u0010\u0017\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0018\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u0002H\u0002¢\u0006\u0002\u0010\u0019\u001A,\u0010\u0017\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0018\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u001A\u001AG\u0010\u001B\u001A\u00020\u001C\"\u0004\b\u0000\u0010\u0002*\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u00102\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u001D\u001A\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00180\u001F0\u001EH\u0002¢\u0006\u0002\b \u001A\u001C\u0010!\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0013\u001A\u001C\u0010\"\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0018\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020#\u001AP\u0010$\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012-\u0010%\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\'\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001C0(\u0012\u0006\u0012\u0004\u0018\u00010)0&¢\u0006\u0002\b*¢\u0006\u0002\u0010+¨\u0006,"}, d2={"shareIn", "Lkotlinx/coroutines/flow/SharedFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "started", "Lkotlinx/coroutines/flow/SharingStarted;", "replay", "", "configureSharing", "Lkotlinx/coroutines/flow/SharingConfig;", "configureSharing$FlowKt__ShareKt", "launchSharing", "Lkotlinx/coroutines/Job;", "context", "Lkotlin/coroutines/CoroutineContext;", "upstream", "shared", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "initialValue", "launchSharing$FlowKt__ShareKt", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlinx/coroutines/flow/SharingStarted;Ljava/lang/Object;)Lkotlinx/coroutines/Job;", "stateIn", "Lkotlinx/coroutines/flow/StateFlow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/flow/SharingStarted;Ljava/lang/Object;)Lkotlinx/coroutines/flow/StateFlow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launchSharingDeferred", "", "result", "Lkotlinx/coroutines/CompletableDeferred;", "Lkotlin/Result;", "launchSharingDeferred$FlowKt__ShareKt", "asSharedFlow", "asStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "onSubscription", "action", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/SharedFlow;", "kotlinx-coroutines-core"}, k=5, mv={2, 1, 0}, xi=0x30, xs="kotlinx/coroutines/flow/FlowKt") final class FlowKt__ShareKt {
    public static final SharedFlow asSharedFlow(MutableSharedFlow arg2) {
        return new ReadonlySharedFlow(((SharedFlow)arg2), null);
    }

    public static final StateFlow asStateFlow(MutableStateFlow arg2) {
        return new ReadonlyStateFlow(((StateFlow)arg2), null);
    }

    private static final SharingConfig configureSharing$FlowKt__ShareKt(Flow arg6, int arg7) {
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(arg7 >= 0) {
            }
            else {
                throw new AssertionError();
            }
        }

        int v0 = RangesKt.coerceAtLeast(arg7, Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core()) - arg7;
        if((arg6 instanceof ChannelFlow)) {
            Flow v1 = arg6;
            Flow v2 = ((ChannelFlow)v1).dropChannelOperators();
            if(v2 != null) {
                int v3 = ((ChannelFlow)v1).capacity;
                if(v3 == -3 || v3 == -2 || v3 == 0) {
                    if(((ChannelFlow)v1).onBufferOverflow == BufferOverflow.SUSPEND) {
                        if(((ChannelFlow)v1).capacity == 0) {
                        }
                        else {
                            goto label_36;
                        }
                    }
                    else if(arg7 == 0) {
                        v0 = 1;
                        goto label_36;
                    }

                    v0 = 0;
                }
                else {
                    v0 = ((ChannelFlow)v1).capacity;
                }

            label_36:
                return new SharingConfig(v2, v0, ((ChannelFlow)v1).onBufferOverflow, ((ChannelFlow)v1).context);
            }
        }

        return new SharingConfig(arg6, v0, BufferOverflow.SUSPEND, EmptyCoroutineContext.INSTANCE);
    }

    private static final Job launchSharing$FlowKt__ShareKt(CoroutineScope arg7, CoroutineContext arg8, Flow arg9, MutableSharedFlow arg10, SharingStarted arg11, Object arg12) {
        CoroutineStart v0 = Intrinsics.areEqual(arg11, SharingStarted.Companion.getEagerly()) ? CoroutineStart.DEFAULT : CoroutineStart.UNDISPATCHED;
        return BuildersKt.launch(arg7, arg8, v0, new FlowKt__ShareKt$launchSharing$1(arg11, arg9, arg10, arg12, null));
    }

    private static final void launchSharingDeferred$FlowKt__ShareKt(CoroutineScope arg8, CoroutineContext arg9, Flow arg10, CompletableDeferred arg11) {
        BuildersKt.launch$default(arg8, arg9, null, new FlowKt__ShareKt$launchSharingDeferred$1(arg10, arg11, null), 2, null);
    }

    public static final SharedFlow onSubscription(SharedFlow arg1, Function2 arg2) {
        return new SubscribedSharedFlow(arg1, arg2);
    }

    public static final SharedFlow shareIn(Flow arg8, CoroutineScope arg9, SharingStarted arg10, int arg11) {
        SharingConfig v8 = FlowKt__ShareKt.configureSharing$FlowKt__ShareKt(arg8, arg11);
        MutableSharedFlow v5 = SharedFlowKt.MutableSharedFlow(arg11, v8.extraBufferCapacity, v8.onBufferOverflow);
        return new ReadonlySharedFlow(((SharedFlow)v5), FlowKt__ShareKt.launchSharing$FlowKt__ShareKt(arg9, v8.context, v8.upstream, v5, arg10, SharedFlowKt.NO_VALUE));
    }

    public static SharedFlow shareIn$default(Flow arg0, CoroutineScope arg1, SharingStarted arg2, int arg3, int arg4, Object arg5) {
        return FlowKt.shareIn(arg0, arg1, arg2, 0);
    }

    public static final Object stateIn(Flow arg4, CoroutineScope arg5, Continuation arg6) {
        FlowKt__ShareKt$stateIn$1 v0_1;
        int v2;
        if((arg6 instanceof FlowKt__ShareKt$stateIn$1)) {
            Continuation v0 = arg6;
            v2 = 0x80000000;
            if((((FlowKt__ShareKt$stateIn$1)v0).label & v2) != 0) {
                ((FlowKt__ShareKt$stateIn$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new FlowKt__ShareKt$stateIn$1(arg6);
        }

        Object v6 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v6);
            SharingConfig v4 = FlowKt__ShareKt.configureSharing$FlowKt__ShareKt(arg4, 1);
            CompletableDeferred v6_1 = CompletableDeferredKt.CompletableDeferred(arg5.getCoroutineContext().get(Job.Key));
            FlowKt__ShareKt.launchSharingDeferred$FlowKt__ShareKt(arg5, v4.context, v4.upstream, v6_1);
            v0_1.label = 1;
            v6 = v6_1.await(((Continuation)v0_1));
            if(v6 == v1) {
                return v1;
            }
        }
        else if(v2 == 1) {
            ResultKt.throwOnFailure(v6);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        Object v4_1 = ((Result)v6).unbox-impl();
        ResultKt.throwOnFailure(v4_1);
        return v4_1;
    }

    public static final StateFlow stateIn(Flow arg7, CoroutineScope arg8, SharingStarted arg9, Object arg10) {
        SharingConfig v7 = FlowKt__ShareKt.configureSharing$FlowKt__ShareKt(arg7, 1);
        MutableStateFlow v0 = StateFlowKt.MutableStateFlow(arg10);
        return new ReadonlyStateFlow(((StateFlow)v0), FlowKt__ShareKt.launchSharing$FlowKt__ShareKt(arg8, v7.context, v7.upstream, v0, arg9, arg10));
    }
}

