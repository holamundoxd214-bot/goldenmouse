package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00060\u0003j\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0018\u001A\u00028\u0000H$¢\u0006\u0002\u0010\u0019J\u001D\u0010\u001A\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\b2\u0006\u0010\u001B\u001A\u00020\rH$¢\u0006\u0002\u0010\u001CJ\r\u0010\u001D\u001A\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001E\u001A\u00020\u001F2\u0006\u0010 \u001A\u00028\u0000H\u0004¢\u0006\u0002\u0010!J\u001D\u0010\"\u001A\u00020\u001F2\u0012\u0010#\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001F0$H\u0084\bR4\u0010\t\u001A\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\b2\u0010\u0010\u0007\u001A\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\b@BX\u0084\u000E¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u001E\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0007\u001A\u00020\r@BX\u0084\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u000E\u0010\u0011\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\r0\u00158F¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2={"Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "S", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "<init>", "()V", "value", "", "slots", "getSlots", "()[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "", "nCollectors", "getNCollectors", "()I", "nextIndex", "_subscriptionCount", "Lkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "getSubscriptionCount", "()Lkotlinx/coroutines/flow/StateFlow;", "createSlot", "()Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "createSlotArray", "size", "(I)[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "allocateSlot", "freeSlot", "", "slot", "(Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;)V", "forEachSlotLocked", "block", "Lkotlin/Function1;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class AbstractSharedFlow {
    private SubscriptionCountStateFlow _subscriptionCount;
    private int nCollectors;
    private int nextIndex;
    private AbstractSharedFlowSlot[] slots;

    public AbstractSharedFlow() {
        super();
    }

    public static final int access$getNCollectors(AbstractSharedFlow arg0) {
        return arg0.nCollectors;
    }

    public static final AbstractSharedFlowSlot[] access$getSlots(AbstractSharedFlow arg0) {
        return arg0.slots;
    }

    protected final AbstractSharedFlowSlot allocateSlot() {
        SubscriptionCountStateFlow v0_3;
        AbstractSharedFlowSlot v2;
        __monitor_enter(this);
        try {
            AbstractSharedFlowSlot[] v0_1 = this.slots;
            int v1 = 2;
            if(v0_1 == null) {
                v0_1 = this.createSlotArray(v1);
                this.slots = v0_1;
            }
            else if(this.nCollectors >= v0_1.length) {
                Object[] v0_2 = Arrays.copyOf(((Object[])v0_1), v0_1.length * v1);
                Intrinsics.checkNotNullExpressionValue(v0_2, "copyOf(...)");
                this.slots = v0_2;
            }

            v1 = this.nextIndex;
            do {
                v2 = v0_1[v1];
                if(v2 == null) {
                    v2 = this.createSlot();
                    v0_1[v1] = v2;
                }

                ++v1;
                if(v1 >= v0_1.length) {
                    v1 = 0;
                }

                Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            }
            while(!v2.allocateLocked(this));

            this.nextIndex = v1;
            ++this.nCollectors;
            v0_3 = this._subscriptionCount;
        }
        catch(Throwable v0) {
            goto label_41;
        }

        __monitor_exit(this);
        if(v0_3 != null) {
            v0_3.increment(1);
        }

        return v2;
    label_41:
        __monitor_exit(this);
        throw v0;
    }

    protected abstract AbstractSharedFlowSlot createSlot();

    protected abstract AbstractSharedFlowSlot[] createSlotArray(int arg1);

    protected final void forEachSlotLocked(Function1 arg4) {
        if(this.nCollectors == 0) {
        }
        else {
            AbstractSharedFlowSlot[] v3 = this.slots;
            if(v3 != null) {
                int v0 = v3.length;
                int v1;
                for(v1 = 0; v1 < v0; ++v1) {
                    AbstractSharedFlowSlot v2 = v3[v1];
                    if(v2 != null) {
                        arg4.invoke(v2);
                    }
                }
            }
        }
    }

    protected final void freeSlot(AbstractSharedFlowSlot arg6) {
        Continuation[] v6_1;
        int v3;
        SubscriptionCountStateFlow v2;
        int v1;
        __monitor_enter(this);
        try {
            v1 = -1;
            int v0 = this.nCollectors + v1;
            this.nCollectors = v0;
            v2 = this._subscriptionCount;
            v3 = 0;
            if(v0 == 0) {
                this.nextIndex = 0;
            }

            Intrinsics.checkNotNull(arg6, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            v6_1 = arg6.freeLocked(this);
        }
        catch(Throwable v6) {
            __monitor_exit(this);
            throw v6;
        }

        __monitor_exit(this);
        int v5 = v6_1.length;
        while(v3 < v5) {
            Continuation v0_1 = v6_1[v3];
            if(v0_1 != null) {
                v0_1.resumeWith(Result.constructor-impl(Unit.INSTANCE));
            }

            ++v3;
        }

        if(v2 != null) {
            v2.increment(v1);
        }
    }

    protected final int getNCollectors() {
        return this.nCollectors;
    }

    protected final AbstractSharedFlowSlot[] getSlots() {
        return this.slots;
    }

    public final StateFlow getSubscriptionCount() {
        SubscriptionCountStateFlow v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this._subscriptionCount;
            if(v0_1 == null) {
                v0_1 = new SubscriptionCountStateFlow(this.nCollectors);
                this._subscriptionCount = v0_1;
            }
        }
        catch(Throwable v0) {
            __monitor_exit(this);
            throw v0;
        }

        __monitor_exit(this);
        return ((StateFlow)v0_1);
    }
}

