package kotlinx.coroutines.flow.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0016\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0017H\u0016J&\u0010\u0018\u001A\b\u0012\u0004\u0012\u00028\u00000\u00172\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0016J&\u0010\u0019\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH$J\u001C\u0010\u001A\u001A\u00020\u000F2\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00028\u00000\rH¤@¢\u0006\u0002\u0010\u001CJ\u0016\u0010\u001D\u001A\b\u0012\u0004\u0012\u00028\u00000\u001E2\u0006\u0010\u001B\u001A\u00020\u001FH\u0016J\u001C\u0010 \u001A\u00020\u000F2\f\u0010!\u001A\b\u0012\u0004\u0012\u00028\u00000\"H\u0096@¢\u0006\u0002\u0010#J\n\u0010$\u001A\u0004\u0018\u00010%H\u0014J\b\u0010&\u001A\u00020%H\u0016R\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R6\u0010\u000B\u001A$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000F0\u000E\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001A\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\'"}, d2={"Lkotlinx/coroutines/flow/internal/ChannelFlow;", "T", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "<init>", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "collectToFun", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "getCollectToFun$kotlinx_coroutines_core", "()Lkotlin/jvm/functions/Function2;", "produceCapacity", "getProduceCapacity$kotlinx_coroutines_core", "()I", "dropChannelOperators", "Lkotlinx/coroutines/flow/Flow;", "fuse", "create", "collectTo", "scope", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produceImpl", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/CoroutineScope;", "collect", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "additionalToStringProps", "", "toString", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class ChannelFlow implements FusibleFlow {
    public final int capacity;
    public final CoroutineContext context;
    public final BufferOverflow onBufferOverflow;

    public ChannelFlow(CoroutineContext arg1, int arg2, BufferOverflow arg3) {
        super();
        this.context = arg1;
        this.capacity = arg2;
        this.onBufferOverflow = arg3;
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(arg2 != -1) {
                return;
            }

            throw new AssertionError();
        }
    }

    protected String additionalToStringProps() {
        return null;
    }

    public Object collect(FlowCollector arg1, Continuation arg2) {
        return ChannelFlow.collect$suspendImpl(this, arg1, arg2);
    }

    static Object collect$suspendImpl(ChannelFlow arg2, FlowCollector arg3, Continuation arg4) {
        Object v2 = CoroutineScopeKt.coroutineScope(new ChannelFlow$collect$2(arg3, arg2, null), arg4);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    protected abstract Object collectTo(ProducerScope arg1, Continuation arg2);

    protected abstract ChannelFlow create(CoroutineContext arg1, int arg2, BufferOverflow arg3);

    public Flow dropChannelOperators() {
        return null;
    }

    public Flow fuse(CoroutineContext arg2, int arg3, BufferOverflow arg4) {
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(arg3 != -1) {
            }
            else {
                throw new AssertionError();
            }
        }

        arg2 = arg2.plus(this.context);
        if(arg4 != BufferOverflow.SUSPEND) {
        }
        else {
            int v4 = this.capacity;
            int v0 = -3;
            if(v4 == v0) {
            }
            else {
                if(arg3 != v0) {
                    v0 = -2;
                    if(v4 == v0) {
                        goto label_45;
                    }
                    else if(arg3 == v0) {
                    }
                    else {
                        if(DebugKt.getASSERTIONS_ENABLED()) {
                            if(this.capacity >= 0) {
                            }
                            else {
                                throw new AssertionError();
                            }
                        }

                        if(DebugKt.getASSERTIONS_ENABLED()) {
                            if(arg3 >= 0) {
                            }
                            else {
                                throw new AssertionError();
                            }
                        }

                        v4 = this.capacity + arg3;
                        if(v4 < 0) {
                            goto label_44;
                        }
                    }
                }

                arg3 = v4;
                goto label_45;
            label_44:
                arg3 = 0x7FFFFFFF;
            }

        label_45:
            arg4 = this.onBufferOverflow;
        }

        if((Intrinsics.areEqual(arg2, this.context)) && arg3 == this.capacity && arg4 == this.onBufferOverflow) {
            return this;
        }

        return this.create(arg2, arg3, arg4);
    }

    public final Function2 getCollectToFun$kotlinx_coroutines_core() {
        return new ChannelFlow$collectToFun$1(this, null);
    }

    public final int getProduceCapacity$kotlinx_coroutines_core() {
        int v1 = this.capacity;
        if(v1 == -3) {
            v1 = -2;
        }

        return v1;
    }

    public ReceiveChannel produceImpl(CoroutineScope arg10) {
        return ProduceKt.produce$default(arg10, this.context, this.getProduceCapacity$kotlinx_coroutines_core(), this.onBufferOverflow, CoroutineStart.ATOMIC, null, this.getCollectToFun$kotlinx_coroutines_core(), 16, null);
    }

    public String toString() {
        ArrayList v0 = new ArrayList(4);
        String v1 = this.additionalToStringProps();
        if(v1 != null) {
            v0.add(v1);
        }

        if(this.context != EmptyCoroutineContext.INSTANCE) {
            v0.add("context=" + this.context);
        }

        if(this.capacity != -3) {
            v0.add("capacity=" + this.capacity);
        }

        if(this.onBufferOverflow != BufferOverflow.SUSPEND) {
            v0.add("onBufferOverflow=" + this.onBufferOverflow);
        }

        return DebugStringsKt.getClassSimpleName(this) + '[' + CollectionsKt.joinToString$default(v0, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}

