package kotlinx.coroutines.flow;

import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1={"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\b\u0012\u0004\u0012\u0002H\u00010\u0006B\u000F\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001D\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00028\u00002\u0006\u0010\u0016\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\u001A\u0010\u0018\u001A\u00020\u00142\b\u0010\u0019\u001A\u0004\u0018\u00010\b2\u0006\u0010\u001A\u001A\u00020\bH\u0002J\u0015\u0010\u001F\u001A\u00020\u00142\u0006\u0010\u000F\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u0016\u0010!\u001A\u00020\"2\u0006\u0010\u000F\u001A\u00028\u0000H\u0096@¢\u0006\u0002\u0010#J\b\u0010$\u001A\u00020\"H\u0016J\u001C\u0010%\u001A\u00020&2\f\u0010\'\u001A\b\u0012\u0004\u0012\u00028\u00000(H\u0096@¢\u0006\u0002\u0010)J\b\u0010*\u001A\u00020\u0003H\u0014J\u001D\u0010+\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030,2\u0006\u0010-\u001A\u00020\u000EH\u0014¢\u0006\u0002\u0010.J&\u0010/\u001A\b\u0012\u0004\u0012\u00028\u0000002\u0006\u00101\u001A\u0002022\u0006\u00103\u001A\u00020\u000E2\u0006\u00104\u001A\u000205H\u0016R\u000F\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010\u000F\u001A\u00028\u00002\u0006\u0010\u000F\u001A\u00028\u00008V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\nR\u001A\u0010\u001B\u001A\b\u0012\u0004\u0012\u00028\u00000\u001C8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001E¨\u00066"}, d2={"Lkotlinx/coroutines/flow/StateFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "initialState", "", "<init>", "(Ljava/lang/Object;)V", "_state", "Lkotlinx/atomicfu/AtomicRef;", "sequence", "", "value", "getValue", "()Ljava/lang/Object;", "setValue", "compareAndSet", "", "expect", "update", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "updateState", "expectedState", "newState", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "tryEmit", "(Ljava/lang/Object;)Z", "emit", "", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetReplayCache", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSlot", "createSlotArray", "", "size", "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "fuse", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class StateFlowImpl extends AbstractSharedFlow implements CancellableFlow, MutableStateFlow, FusibleFlow {
    private int sequence;

    static {
        StateFlowImpl._state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state$volatile");
    }

    public StateFlowImpl(Object arg1) {
        super();
        this._state$volatile = arg1;
    }

    public Object collect(FlowCollector arg11, Continuation arg12) {
        Object v7;
        Object v6;
        Object v2_1;
        Object v11;
        Object v10;
        Element v11_2;
        int v2;
        Continuation v0;
        if((arg12 instanceof StateFlowImpl$collect$1)) {
            v0 = arg12;
            v2 = 0x80000000;
            if((((StateFlowImpl$collect$1)v0).label & v2) != 0) {
                ((StateFlowImpl$collect$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            StateFlowImpl$collect$1 v0_1 = new StateFlowImpl$collect$1(this, arg12);
        }

        Object v12 = ((StateFlowImpl$collect$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((StateFlowImpl$collect$1)v0).label;
        Object v3 = null;
        int v4 = 3;
        int v5 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v12);
            AbstractSharedFlowSlot v2_2 = this.allocateSlot();
            try {
                if((arg11 instanceof SubscribedFlowCollector)) {
                    ((StateFlowImpl$collect$1)v0).L$0 = this;
                    ((StateFlowImpl$collect$1)v0).L$1 = arg11;
                    ((StateFlowImpl$collect$1)v0).L$2 = v2_2;
                    ((StateFlowImpl$collect$1)v0).label = 1;
                    if(arg11.onSubscription(v0) == v1) {
                        return v1;
                    }
                    else {
                        goto label_66;
                    }
                }
                else {
                label_66:
                    FlowCollector v6_1 = ((FlowCollector)v11);
                    v11_2 = v0.getContext().get(Job.Key);
                    v12 = v3;
                }

                goto label_72;
            }
            catch(Throwable v11_1) {
                goto label_110;
            }

        label_112:
            ((StateFlowImpl)v7).freeSlot(((AbstractSharedFlowSlot)v2_1));
            throw v10_1;
        label_110:
            StateFlowImpl v7_1 = ((StateFlowImpl)v10);
            v10_1 = v11_1;
            goto label_112;
            return v1;
            try {
            label_96:
                v12 = v10;
                v10 = v7;
            label_98:
                if(!((StateFlowSlot)v2_1).takePending()) {
                    ((StateFlowImpl$collect$1)v0).L$0 = v10;
                    ((StateFlowImpl$collect$1)v0).L$1 = v6;
                    ((StateFlowImpl$collect$1)v0).L$2 = v2_1;
                    ((StateFlowImpl$collect$1)v0).L$3 = v11_2;
                    ((StateFlowImpl$collect$1)v0).L$4 = v12;
                    ((StateFlowImpl$collect$1)v0).label = v4;
                    if(((StateFlowSlot)v2_1).awaitPending(v0) != v1) {
                        goto label_72;
                    }

                    return v1;
                }

            label_72:
                v7 = StateFlowImpl.get_state$volatile$FU().get(v10);
                if(v11_2 != null) {
                    JobKt.ensureActive(((Job)v11_2));
                }

                if(v12 != null && (Intrinsics.areEqual(v12, v7))) {
                    goto label_98;
                }

                v12 = v7 == NullSurrogateKt.NULL ? v3 : v7;
                ((StateFlowImpl$collect$1)v0).L$0 = v10;
                ((StateFlowImpl$collect$1)v0).L$1 = v6;
                ((StateFlowImpl$collect$1)v0).L$2 = v2_1;
                ((StateFlowImpl$collect$1)v0).L$3 = v11_2;
                ((StateFlowImpl$collect$1)v0).L$4 = v7;
                ((StateFlowImpl$collect$1)v0).label = v5;
                if(((FlowCollector)v6).emit(v12, v0) == v1) {
                    return v1;
                }

                Object v9 = v7;
                v7_1 = ((StateFlowImpl)v10);
                v10 = v9;
                goto label_96;
            }
            catch(Throwable v11_1) {
                goto label_110;
            }
        }
        else if(v2 == 1) {
            v2_1 = ((StateFlowImpl$collect$1)v0).L$2;
            v11 = ((StateFlowImpl$collect$1)v0).L$1;
            v10 = ((StateFlowImpl$collect$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v12);
                goto label_66;
            }
            catch(Throwable v11_1) {
                goto label_110;
            }
        }
        else if(v2 == v5) {
            v10 = ((StateFlowImpl$collect$1)v0).L$4;
            v11 = ((StateFlowImpl$collect$1)v0).L$3;
            v2_1 = ((StateFlowImpl$collect$1)v0).L$2;
            v6 = ((StateFlowImpl$collect$1)v0).L$1;
            v7 = ((StateFlowImpl$collect$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v12);
                goto label_96;
            }
            catch(Throwable v10_1) {
            label_45:
                goto label_112;
            }
        }
        else if(v2 == v4) {
            v10 = ((StateFlowImpl$collect$1)v0).L$4;
            v11 = ((StateFlowImpl$collect$1)v0).L$3;
            v2_1 = ((StateFlowImpl$collect$1)v0).L$2;
            v6 = ((StateFlowImpl$collect$1)v0).L$1;
            v7 = ((StateFlowImpl$collect$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v12);
                v12 = v10;
                v10 = v7;
                goto label_72;
            }
            catch(Throwable v10_1) {
                goto label_45;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        goto label_72;
    }

    public boolean compareAndSet(Object arg1, Object arg2) {
        Symbol v2;
        Symbol v1;
        if(arg1 == null) {
            v1 = NullSurrogateKt.NULL;
        }

        if(arg2 == null) {
            v2 = NullSurrogateKt.NULL;
        }

        return this.updateState(v1, v2);
    }

    protected StateFlowSlot createSlot() {
        return new StateFlowSlot();
    }

    public AbstractSharedFlowSlot createSlot() {
        return this.createSlot();
    }

    protected StateFlowSlot[] createSlotArray(int arg1) {
        return new StateFlowSlot[arg1];
    }

    public AbstractSharedFlowSlot[] createSlotArray(int arg1) {
        return this.createSlotArray(arg1);
    }

    public Object emit(Object arg1, Continuation arg2) {
        this.setValue(arg1);
        return Unit.INSTANCE;
    }

    public Flow fuse(CoroutineContext arg1, int arg2, BufferOverflow arg3) {
        return StateFlowKt.fuseStateFlow(((StateFlow)this), arg1, arg2, arg3);
    }

    public List getReplayCache() {
        return CollectionsKt.listOf(this.getValue());
    }

    public Object getValue() {
        Symbol v0 = NullSurrogateKt.NULL;
        Object v2 = StateFlowImpl.get_state$volatile$FU().get(this);
        if((((Symbol)v2)) == v0) {
            v2 = null;
        }

        return v2;
    }

    private final Object get_state$volatile() {
        return this._state$volatile;
    }

    private static final AtomicReferenceFieldUpdater get_state$volatile$FU() {
        return StateFlowImpl._state$volatile$FU;
    }

    public void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    public void setValue(Object arg2) {
        Symbol v2;
        if(arg2 == null) {
            v2 = NullSurrogateKt.NULL;
        }

        this.updateState(null, v2);
    }

    private final void set_state$volatile(Object arg1) {
        this._state$volatile = arg1;
    }

    public boolean tryEmit(Object arg1) {
        this.setValue(arg1);
        return 1;
    }

    private final boolean updateState(Object arg7, Object arg8) {
        AbstractSharedFlowSlot[] v7_2;
        int v8_1;
        AbstractSharedFlowSlot[] v8;
        int v7_1;
        __monitor_enter(this);
        try {
            Object v0 = StateFlowImpl.get_state$volatile$FU().get(this);
            if(arg7 != null && !Intrinsics.areEqual(v0, arg7)) {
                goto label_7;
            }

            goto label_9;
        }
        catch(Throwable v7) {
            goto label_55;
        }

    label_7:
        __monitor_exit(this);
        return 0;
        try {
        label_9:
            if(!Intrinsics.areEqual(v0, arg8)) {
                goto label_14;
            }
        }
        catch(Throwable v7) {
            goto label_55;
        }

        __monitor_exit(this);
        return 1;
        try {
        label_14:
            StateFlowImpl.get_state$volatile$FU().set(this, arg8);
            v7_1 = this.sequence;
            if((v7_1 & 1) != 0) {
                goto label_50;
            }

            ++v7_1;
            this.sequence = v7_1;
            v8 = this.getSlots();
        }
        catch(Throwable v7) {
            goto label_55;
        }

        __monitor_exit(this);
        while(true) {
            if(v8 != null) {
                int v2 = v8.length;
                int v3;
                for(v3 = 0; v3 < v2; ++v3) {
                    AbstractSharedFlowSlot v4 = v8[v3];
                    if(v4 != null) {
                        ((StateFlowSlot)v4).makePending();
                    }
                }
            }

            __monitor_enter(this);
            try {
                v8_1 = this.sequence;
                if(v8_1 != v7_1) {
                    goto label_40;
                }

                this.sequence = v7_1 + 1;
            }
            catch(Throwable v7) {
                goto label_48;
            }

            __monitor_exit(this);
            return 1;
            try {
            label_40:
                v7_2 = this.getSlots();
            }
            catch(Throwable v7) {
            label_48:
                __monitor_exit(this);
                throw v7;
            }

            __monitor_exit(this);
            int v5 = v8_1;
            v8 = v7_2;
            v7_1 = v5;
        }

    label_50:
        v7_1 += 2;
        try {
            this.sequence = v7_1;
        }
        catch(Throwable v7) {
        label_55:
            __monitor_exit(this);
            throw v7;
        }

        __monitor_exit(this);
        return 1;
    }
}

