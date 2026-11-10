package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata(d1={"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0003\n\u0002\b\r\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u000267B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0016J\u0016\u0010\u0014\u001A\u00020\u00152\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0002J\u0016\u0010\u0017\u001A\u00020\u00152\u0006\u0010\u0018\u001A\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0019J\u001D\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00150\u001B2\u0006\u0010\u0018\u001A\u00028\u0000H\u0016¢\u0006\u0004\b\u001C\u0010\u001DJ\u001E\u0010\u001E\u001A\u00020\u00152\n\u0010\u001F\u001A\u0006\u0012\u0002\b\u00030 2\b\u0010\u0018\u001A\u0004\u0018\u00010\u0011H\u0014J\u0012\u0010$\u001A\u00020%2\b\u0010&\u001A\u0004\u0018\u00010\'H\u0016J\u0017\u0010(\u001A\u00020%2\b\u0010&\u001A\u0004\u0018\u00010\'H\u0010¢\u0006\u0002\b)J\b\u00104\u001A\u000205H\u0016R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0014\u0010\n\u001A\u00060\u000Bj\u0002`\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u001A\u0010\u000E\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R6\u0010!\u001A*\u0012\b\u0012\u0006\u0012\u0002\b\u00030 \u0012\u0006\u0012\u0004\u0018\u00010\u00110\"j\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030 \u0012\u0006\u0012\u0004\u0018\u00010\u0011`#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001A\u00020%8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b*\u0010+R\u0017\u0010,\u001A\u00028\u00008F¢\u0006\f\u0012\u0004\b-\u0010.\u001A\u0004\b/\u00100R\u0019\u00101\u001A\u0004\u0018\u00018\u00008F¢\u0006\f\u0012\u0004\b2\u0010.\u001A\u0004\b3\u00100¨\u00068"}, d2={"Lkotlinx/coroutines/channels/BroadcastChannelImpl;", "E", "Lkotlinx/coroutines/channels/BufferedChannel;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "capacity", "", "<init>", "(I)V", "getCapacity", "()I", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "subscribers", "", "lastConflatedElement", "", "openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", "removeSubscriber", "", "s", "send", "element", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "registerSelectForSend", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "onSendInternalResult", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "close", "", "cause", "", "cancelImpl", "cancelImpl$kotlinx_coroutines_core", "isClosedForSend", "()Z", "value", "getValue$annotations", "()V", "getValue", "()Ljava/lang/Object;", "valueOrNull", "getValueOrNull$annotations", "getValueOrNull", "toString", "", "SubscriberBuffered", "SubscriberConflated", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class BroadcastChannelImpl extends BufferedChannel implements BroadcastChannel {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2={"Lkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberBuffered;", "Lkotlinx/coroutines/channels/BufferedChannel;", "<init>", "(Lkotlinx/coroutines/channels/BroadcastChannelImpl;)V", "cancelImpl", "", "cause", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class SubscriberBuffered extends BufferedChannel {
        public SubscriberBuffered(BroadcastChannelImpl arg3) {
            BroadcastChannelImpl.this = arg3;
            super(arg3.getCapacity(), null, 2, null);
        }

        public boolean cancelImpl(Throwable arg4) {
            boolean v3_1;
            ReentrantLock v0 = BroadcastChannelImpl.this.lock;
            BroadcastChannelImpl v1 = BroadcastChannelImpl.this;
            ((Lock)v0).lock();
            try {
                v1.removeSubscriber(this);
                v3_1 = super.cancelImpl$kotlinx_coroutines_core(arg4);
            }
            catch(Throwable v3) {
                ((Lock)v0).unlock();
                throw v3;
            }

            ((Lock)v0).unlock();
            return v3_1;
        }

        public boolean cancelImpl$kotlinx_coroutines_core(Throwable arg1) {
            return this.cancelImpl(arg1);
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2={"Lkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberConflated;", "Lkotlinx/coroutines/channels/ConflatedBufferedChannel;", "<init>", "(Lkotlinx/coroutines/channels/BroadcastChannelImpl;)V", "cancelImpl", "", "cause", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class SubscriberConflated extends ConflatedBufferedChannel {
        public SubscriberConflated(BroadcastChannelImpl arg7) {
            BroadcastChannelImpl.this = arg7;
            super(1, BufferOverflow.DROP_OLDEST, null, 4, null);
        }

        public boolean cancelImpl(Throwable arg3) {
            BroadcastChannelImpl.this.removeSubscriber(this);
            return super.cancelImpl$kotlinx_coroutines_core(arg3);
        }

        public boolean cancelImpl$kotlinx_coroutines_core(Throwable arg1) {
            return this.cancelImpl(arg1);
        }
    }

    private final int capacity;
    private Object lastConflatedElement;
    private final ReentrantLock lock;
    private final HashMap onSendInternalResult;
    private List subscribers;

    public BroadcastChannelImpl(int arg3) {
        super(0, null);
        this.capacity = arg3;
        if(arg3 < 1) {
            if(arg3 == -1) {
            }
            else {
                throw new IllegalArgumentException("BroadcastChannel capacity must be positive or Channel.CONFLATED, but " + arg3 + " was specified".toString());
            }
        }

        this.lock = new ReentrantLock();
        this.subscribers = CollectionsKt.emptyList();
        this.lastConflatedElement = BroadcastChannelKt.access$getNO_ELEMENT$p();
        this.onSendInternalResult = new HashMap();
    }

    public static final ReentrantLock access$getLock$p(BroadcastChannelImpl arg0) {
        return arg0.lock;
    }

    public static final HashMap access$getOnSendInternalResult$p(BroadcastChannelImpl arg0) {
        return arg0.onSendInternalResult;
    }

    public static final void access$removeSubscriber(BroadcastChannelImpl arg0, ReceiveChannel arg1) {
        arg0.removeSubscriber(arg1);
    }

    public boolean cancelImpl$kotlinx_coroutines_core(Throwable arg4) {
        boolean v3_1;
        ReentrantLock v0 = this.lock;
        ((Lock)v0).lock();
        try {
            Iterator v1 = this.subscribers.iterator();
            while(v1.hasNext()) {
                v1.next().cancelImpl$kotlinx_coroutines_core(arg4);
            }

            this.lastConflatedElement = BroadcastChannelKt.access$getNO_ELEMENT$p();
            v3_1 = super.cancelImpl$kotlinx_coroutines_core(arg4);
        }
        catch(Throwable v3) {
            goto label_15;
        }

        ((Lock)v0).unlock();
        return v3_1;
    label_15:
        ((Lock)v0).unlock();
        throw v3;
    }

    public boolean close(Throwable arg6) {
        boolean v5_1;
        ReentrantLock v0 = this.lock;
        ((Lock)v0).lock();
        try {
            Iterator v1 = this.subscribers.iterator();
            while(v1.hasNext()) {
                v1.next().close(arg6);
            }

            List v1_1 = this.subscribers;
            ArrayList v2 = new ArrayList();
            v1 = ((Iterable)v1_1).iterator();
            while(v1.hasNext()) {
                Object v3 = v1.next();
                if(!v3.hasElements$kotlinx_coroutines_core()) {
                    continue;
                }

                ((Collection)v2).add(v3);
            }

            this.subscribers = ((List)v2);
            v5_1 = super.close(arg6);
        }
        catch(Throwable v5) {
            goto label_26;
        }

        ((Lock)v0).unlock();
        return v5_1;
    label_26:
        ((Lock)v0).unlock();
        throw v5;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public final Object getValue() {
        Object v3_2;
        ReentrantLock v0 = this.lock;
        ((Lock)v0).lock();
        try {
            if(this.isClosedForSend()) {
                v3 = this.getCloseCause();
                if(v3 == null) {
                    IllegalStateException v3_1 = new IllegalStateException("This broadcast channel is closed");
                }

                throw v3;
            }

            if(this.lastConflatedElement == BroadcastChannelKt.access$getNO_ELEMENT$p()) {
                goto label_16;
            }

            v3_2 = this.lastConflatedElement;
        }
        catch(Throwable v3) {
            goto label_22;
        }

        ((Lock)v0).unlock();
        return v3_2;
        try {
        label_16:
            throw new IllegalStateException("No value".toString());
        }
        catch(Throwable v3) {
        label_22:
            ((Lock)v0).unlock();
            throw v3;
        }
    }

    public static void getValue$annotations() {
    }

    public final Object getValueOrNull() {
        Object v2;
        ReentrantLock v0 = this.lock;
        ((Lock)v0).lock();
        try {
            v2 = null;
            if(this.isClosedForReceive()) {
            }
            else if(this.lastConflatedElement == BroadcastChannelKt.access$getNO_ELEMENT$p()) {
            }
            else {
                v2 = this.lastConflatedElement;
            }
        }
        catch(Throwable v4) {
            ((Lock)v0).unlock();
            throw v4;
        }

        ((Lock)v0).unlock();
        return v2;
    }

    public static void getValueOrNull$annotations() {
    }

    public boolean isClosedForSend() {
        boolean v1_1;
        ReentrantLock v0 = this.lock;
        ((Lock)v0).lock();
        try {
            v1_1 = super.isClosedForSend();
        }
        catch(Throwable v1) {
            ((Lock)v0).unlock();
            throw v1;
        }

        ((Lock)v0).unlock();
        return v1_1;
    }

    public ReceiveChannel openSubscription() {
        SubscriberConflated v1;
        ReentrantLock v0 = this.lock;
        ((Lock)v0).lock();
        try {
            if(this.capacity == -1) {
                v1 = new SubscriberConflated(this);
            }
            else {
                SubscriberBuffered v1_1 = new SubscriberBuffered(this);
            }

            if((this.isClosedForSend()) && this.lastConflatedElement == BroadcastChannelKt.access$getNO_ELEMENT$p()) {
                ((BufferedChannel)v1).close(this.getCloseCause());
                ((Lock)v0).unlock();
                return ((ReceiveChannel)v1);
            }

            if(this.lastConflatedElement != BroadcastChannelKt.access$getNO_ELEMENT$p()) {
                ((BufferedChannel)v1).trySend-JP2dKIU(this.getValue());
            }

            this.subscribers = CollectionsKt.plus(this.subscribers, v1);
        }
        catch(Throwable v4) {
            ((Lock)v0).unlock();
            throw v4;
        }

        ((Lock)v0).unlock();
        return ((ReceiveChannel)v1);
    }

    protected void registerSelectForSend(SelectInstance arg8, Object arg9) {
        ReentrantLock v1 = this.lock;
        ((Lock)v1).lock();
        try {
            Object v0_1 = this.onSendInternalResult.remove(arg8);
            if(v0_1 == null) {
                goto label_9;
            }

            arg8.selectInRegistrationPhase(v0_1);
        }
        catch(Throwable v0) {
            goto label_24;
        }

        ((Lock)v1).unlock();
        return;
    label_9:
        goto label_10;
    label_24:
        ((Lock)v1).unlock();
        throw v0;
    label_10:
        ((Lock)v1).unlock();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(arg8.getContext()), null, CoroutineStart.UNDISPATCHED, new BroadcastChannelImpl$registerSelectForSend$2(this, arg9, arg8, null), 1, null);
    }

    private final void removeSubscriber(ReceiveChannel arg6) {
        ReentrantLock v0 = this.lock;
        ((Lock)v0).lock();
        try {
            List v1 = this.subscribers;
            ArrayList v2 = new ArrayList();
            Iterator v1_1 = ((Iterable)v1).iterator();
            while(v1_1.hasNext()) {
                Object v3 = v1_1.next();
                if(v3 == arg6) {
                    continue;
                }

                ((Collection)v2).add(v3);
            }

            this.subscribers = ((List)v2);
        }
        catch(Throwable v5) {
            goto label_18;
        }

        ((Lock)v0).unlock();
        return;
    label_18:
        ((Lock)v0).unlock();
        throw v5;
    }

    public Object send(Object arg7, Continuation arg8) {
        Object v0_2;
        Continuation v5;
        Object v2_1;
        List v2_2;
        BroadcastChannelImpl$send$1 v0_1;
        int v2;
        Continuation v0;
        if((arg8 instanceof BroadcastChannelImpl$send$1)) {
            v0 = arg8;
            v2 = 0x80000000;
            if((((BroadcastChannelImpl$send$1)v0).label & v2) != 0) {
                ((BroadcastChannelImpl$send$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new BroadcastChannelImpl$send$1(this, arg8);
        }

        Object v8 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v8);
            ReentrantLock v8_1 = this.lock;
            ((Lock)v8_1).lock();
            try {
                if(!this.isClosedForSend()) {
                    if(this.capacity == -1) {
                        this.lastConflatedElement = arg7;
                    }

                    v2_2 = this.subscribers;
                }
                else {
                    goto label_74;
                }
            }
            catch(Throwable v6_1) {
                goto label_77;
            }

            ((Lock)v8_1).unlock();
            Object v5_1 = arg7;
            BroadcastChannelImpl v7 = this;
            Iterator v6_2 = ((Iterable)v2_2).iterator();
            v8 = v5_1;
            goto label_48;
            try {
            label_74:
                throw this.getSendException();
            }
            catch(Throwable v6_1) {
            label_77:
                ((Lock)v8_1).unlock();
                throw v6_1;
            }

        label_48:
            if(v6_2.hasNext()) {
                v2_1 = v6_2.next();
                v0_1.L$0 = arg7;
                v0_1.L$1 = v8;
                v0_1.L$2 = v6_2;
                v0_1.label = 1;
                v2_1 = ((BufferedChannel)v2_1).sendBroadcast$kotlinx_coroutines_core(v8, ((Continuation)v0_1));
                if(v2_1 == v1) {
                    return v1;
                }

                v5 = ((Continuation)v0_1);
                v0_2 = v8;
                v8 = v2_1;
                goto label_26;
            }

            return Unit.INSTANCE;
        }
        else if(v2 == 1) {
            Object v6 = v0_1.L$2;
            arg7 = v0_1.L$1;
            v2_1 = v0_1.L$0;
            ResultKt.throwOnFailure(v8);
            v5 = ((Continuation)v0_1);
            v0_2 = arg7;
            arg7 = v2_1;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_26:
        Continuation v2_3 = v5;
        if(!((Boolean)v8).booleanValue()) {
            if(!((BroadcastChannelImpl)arg7).isClosedForSend()) {
            }
            else {
                throw ((BroadcastChannelImpl)arg7).getSendException();
            }
        }

        v8 = v0_2;
        v0 = v2_3;
        goto label_48;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder();
        String v1 = this.lastConflatedElement != BroadcastChannelKt.access$getNO_ELEMENT$p() ? "CONFLATED_ELEMENT=" + this.lastConflatedElement + "; " : "";
        return v0.append(v1).append("BROADCAST=<").append(super.toString()).append(">; SUBSCRIBERS=").append(CollectionsKt.joinToString$default(this.subscribers, ";", "<", ">", 0, null, null, 56, null)).toString();
    }

    public Object trySend-JP2dKIU(Object arg4) {
        Object v3_1;
        ReentrantLock v0 = this.lock;
        ((Lock)v0).lock();
        try {
            if(!this.isClosedForSend()) {
                goto label_7;
            }

            v3_1 = super.trySend-JP2dKIU(arg4);
        }
        catch(Throwable v3) {
            goto label_41;
        }

        ((Lock)v0).unlock();
        return v3_1;
        try {
        label_7:
            List v1 = this.subscribers;
            if(!(v1 instanceof Collection) || !v1.isEmpty()) {
                Iterator v1_1 = ((Iterable)v1).iterator();
                do {
                    if(v1_1.hasNext()) {
                        if(!v1_1.next().shouldSendSuspend$kotlinx_coroutines_core()) {
                            continue;
                        }

                        break;
                    }

                    goto label_24;
                }
                while(true);

                v3_1 = ChannelResult.Companion.failure-PtdJZtk();
                goto label_22;
            }
            else {
            }

            goto label_24;
        }
        catch(Throwable v3) {
            goto label_41;
        }

    label_22:
        ((Lock)v0).unlock();
        return v3_1;
        try {
        label_24:
            if(this.capacity == -1) {
                this.lastConflatedElement = arg4;
            }

            Iterator v3_2 = this.subscribers.iterator();
            while(v3_2.hasNext()) {
                v3_2.next().trySend-JP2dKIU(arg4);
            }

            v3_1 = ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
        }
        catch(Throwable v3) {
            goto label_41;
        }

        ((Lock)v0).unlock();
        return v3_1;
    label_41:
        ((Lock)v0).unlock();
        throw v3;
    }
}

