package kotlinx.coroutines.flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1={"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\b\u0012\u0004\u0012\u0002H\u00010\u0006:\u0001iB\u001F\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\b\u0012\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ\u001C\u0010,\u001A\u00020-2\f\u0010.\u001A\b\u0012\u0004\u0012\u00028\u00000/H\u0096@¢\u0006\u0002\u00100J\u0015\u00101\u001A\u0002022\u0006\u00103\u001A\u00028\u0000H\u0016¢\u0006\u0002\u00104J\u0016\u00105\u001A\u0002062\u0006\u00103\u001A\u00028\u0000H\u0096@¢\u0006\u0002\u00107J\u0015\u00108\u001A\u0002022\u0006\u00103\u001A\u00028\u0000H\u0002¢\u0006\u0002\u00104J\u0015\u00109\u001A\u0002022\u0006\u00103\u001A\u00028\u0000H\u0002¢\u0006\u0002\u00104J\b\u0010:\u001A\u000206H\u0002J\u0010\u0010;\u001A\u0002062\u0006\u0010<\u001A\u00020\u0013H\u0002J\u0012\u0010=\u001A\u0002062\b\u0010>\u001A\u0004\u0018\u00010\u0010H\u0002J7\u0010?\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000F2\u0010\u0010@\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000F2\u0006\u0010A\u001A\u00020\b2\u0006\u0010B\u001A\u00020\bH\u0002¢\u0006\u0002\u0010CJ\u0016\u0010D\u001A\u0002062\u0006\u00103\u001A\u00028\u0000H\u0082@¢\u0006\u0002\u00107J\u0010\u0010E\u001A\u0002062\u0006\u0010F\u001A\u00020GH\u0002J\r\u0010H\u001A\u00020\u0013H\u0000¢\u0006\u0002\bIJ%\u0010J\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000206\u0018\u00010K0\u000F2\u0006\u0010L\u001A\u00020\u0013H\u0000¢\u0006\u0004\bM\u0010NJ(\u0010O\u001A\u0002062\u0006\u0010P\u001A\u00020\u00132\u0006\u0010Q\u001A\u00020\u00132\u0006\u0010R\u001A\u00020\u00132\u0006\u0010S\u001A\u00020\u0013H\u0002J\b\u0010T\u001A\u000206H\u0002J\u0012\u0010U\u001A\u0004\u0018\u00010\u00102\u0006\u0010V\u001A\u00020\u0003H\u0002J\u0010\u0010W\u001A\u00020\u00132\u0006\u0010V\u001A\u00020\u0003H\u0002J\u0012\u0010X\u001A\u0004\u0018\u00010\u00102\u0006\u0010Y\u001A\u00020\u0013H\u0002J\u0016\u0010Z\u001A\u0002062\u0006\u0010V\u001A\u00020\u0003H\u0082@¢\u0006\u0002\u0010[J1\u0010\\\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000206\u0018\u00010K0\u000F2\u0014\u0010]\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000206\u0018\u00010K0\u000FH\u0002¢\u0006\u0002\u0010^J\b\u0010_\u001A\u00020\u0003H\u0014J\u001D\u0010`\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000F2\u0006\u0010a\u001A\u00020\bH\u0014¢\u0006\u0002\u0010bJ\b\u0010c\u001A\u000206H\u0016J&\u0010d\u001A\b\u0012\u0004\u0012\u00028\u00000e2\u0006\u0010f\u001A\u00020g2\u0006\u0010h\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\u000BH\u0016R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000E\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000FX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0011R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001A\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001A\u001A\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001CR\u0014\u0010\u001D\u001A\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001CR\u0014\u0010\u001F\u001A\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b \u0010\u0019R\u0014\u0010!\u001A\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\"\u0010\u0019R\u001A\u0010#\u001A\b\u0012\u0004\u0012\u00028\u00000$8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b%\u0010&R\u001A\u0010\'\u001A\u00028\u00008DX\u0084\u0004¢\u0006\f\u0012\u0004\b(\u0010)\u001A\u0004\b*\u0010+¨\u0006j"}, d2={"Lkotlinx/coroutines/flow/SharedFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "replay", "", "bufferCapacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "<init>", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "buffer", "", "", "[Ljava/lang/Object;", "replayIndex", "", "minCollectorIndex", "bufferSize", "queueSize", "head", "getHead", "()J", "replaySize", "getReplaySize", "()I", "totalSize", "getTotalSize", "bufferEndIndex", "getBufferEndIndex", "queueEndIndex", "getQueueEndIndex", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "lastReplayedLocked", "getLastReplayedLocked$annotations", "()V", "getLastReplayedLocked", "()Ljava/lang/Object;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryEmit", "", "value", "(Ljava/lang/Object;)Z", "emit", "", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryEmitLocked", "tryEmitNoCollectorsLocked", "dropOldestLocked", "correctCollectorIndexesOnDropOldest", "newHead", "enqueueLocked", "item", "growBuffer", "curBuffer", "curSize", "newSize", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "emitSuspend", "cancelEmitter", "emitter", "Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "updateNewCollectorIndexLocked", "updateNewCollectorIndexLocked$kotlinx_coroutines_core", "updateCollectorIndexLocked", "Lkotlin/coroutines/Continuation;", "oldIndex", "updateCollectorIndexLocked$kotlinx_coroutines_core", "(J)[Lkotlin/coroutines/Continuation;", "updateBufferLocked", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "cleanupTailLocked", "tryTakeValue", "slot", "tryPeekLocked", "getPeekedValueLockedAt", "index", "awaitValue", "(Lkotlinx/coroutines/flow/SharedFlowSlot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findSlotsToResumeLocked", "resumesIn", "([Lkotlin/coroutines/Continuation;)[Lkotlin/coroutines/Continuation;", "createSlot", "createSlotArray", "size", "(I)[Lkotlinx/coroutines/flow/SharedFlowSlot;", "resetReplayCache", "fuse", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "Emitter", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public class SharedFlowImpl extends AbstractSharedFlow implements CancellableFlow, MutableSharedFlow, FusibleFlow {
    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B3\u0012\n\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000B\u0010\fJ\b\u0010\r\u001A\u00020\nH\u0016R\u0014\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001A\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "Lkotlinx/coroutines/DisposableHandle;", "flow", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "index", "", "value", "", "cont", "Lkotlin/coroutines/Continuation;", "", "<init>", "(Lkotlinx/coroutines/flow/SharedFlowImpl;JLjava/lang/Object;Lkotlin/coroutines/Continuation;)V", "dispose", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class Emitter implements DisposableHandle {
        public final Continuation cont;
        public final SharedFlowImpl flow;
        public long index;
        public final Object value;

        public Emitter(SharedFlowImpl arg1, long arg2, Object arg4, Continuation arg5) {
            super();
            this.flow = arg1;
            this.index = arg2;
            this.value = arg4;
            this.cont = arg5;
        }

        public void dispose() {
            this.flow.cancelEmitter(this);
        }
    }

    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[BufferOverflow.values().length];
            try {
                v0[BufferOverflow.SUSPEND.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[BufferOverflow.DROP_LATEST.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                    label_15:
                        WhenMappings.$EnumSwitchMapping$0 = v0;
                        return;
                    }
                }
            }
        }
    }

    private Object[] buffer;
    private final int bufferCapacity;
    private int bufferSize;
    private long minCollectorIndex;
    private final BufferOverflow onBufferOverflow;
    private int queueSize;
    private final int replay;
    private long replayIndex;

    public SharedFlowImpl(int arg1, int arg2, BufferOverflow arg3) {
        super();
        this.replay = arg1;
        this.bufferCapacity = arg2;
        this.onBufferOverflow = arg3;
    }

    public static final Object access$awaitValue(SharedFlowImpl arg0, SharedFlowSlot arg1, Continuation arg2) {
        return arg0.awaitValue(arg1, arg2);
    }

    public static final void access$cancelEmitter(SharedFlowImpl arg0, Emitter arg1) {
        arg0.cancelEmitter(arg1);
    }

    public static final Object access$emitSuspend(SharedFlowImpl arg0, Object arg1, Continuation arg2) {
        return arg0.emitSuspend(arg1, arg2);
    }

    public static final void access$enqueueLocked(SharedFlowImpl arg0, Object arg1) {
        arg0.enqueueLocked(arg1);
    }

    public static final Continuation[] access$findSlotsToResumeLocked(SharedFlowImpl arg0, Continuation[] arg1) {
        return arg0.findSlotsToResumeLocked(arg1);
    }

    public static final int access$getBufferCapacity$p(SharedFlowImpl arg0) {
        return arg0.bufferCapacity;
    }

    public static final long access$getHead(SharedFlowImpl arg2) {
        return arg2.getHead();
    }

    public static final int access$getQueueSize$p(SharedFlowImpl arg0) {
        return arg0.queueSize;
    }

    public static final int access$getTotalSize(SharedFlowImpl arg0) {
        return arg0.getTotalSize();
    }

    public static final void access$setQueueSize$p(SharedFlowImpl arg0, int arg1) {
        arg0.queueSize = arg1;
    }

    public static final boolean access$tryEmitLocked(SharedFlowImpl arg0, Object arg1) {
        return arg0.tryEmitLocked(arg1);
    }

    public static final long access$tryPeekLocked(SharedFlowImpl arg0, SharedFlowSlot arg1) {
        return arg0.tryPeekLocked(arg1);
    }

    private final Object awaitValue(SharedFlowSlot arg7, Continuation arg8) {
        CancellableContinuationImpl v0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg8), 1);
        v0.initCancellability();
        CancellableContinuationImpl v1 = v0;
        __monitor_enter(this);
        try {
            if(this.tryPeekLocked(arg7) < 0) {
                arg7.cont = v1;
                arg7.cont = ((Continuation)v1);
            }
            else {
                ((Continuation)v1).resumeWith(Result.constructor-impl(Unit.INSTANCE));
            }
        }
        catch(Throwable v7) {
            __monitor_exit(this);
            throw v7;
        }

        __monitor_exit(this);
        Object v6 = v0.getResult();
        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg8);
        }

        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v6;
        }

        return Unit.INSTANCE;
    }

    private final void cancelEmitter(Emitter arg5) {
        Object[] v0;
        __monitor_enter(this);
        try {
            if(arg5.index >= this.getHead()) {
                goto label_6;
            }
        }
        catch(Throwable v5) {
            goto label_21;
        }

        __monitor_exit(this);
        return;
        try {
        label_6:
            v0 = this.buffer;
            Intrinsics.checkNotNull(v0);
            if(SharedFlowKt.access$getBufferAt(v0, arg5.index) == arg5) {
                goto label_13;
            }
        }
        catch(Throwable v5) {
            goto label_21;
        }

        __monitor_exit(this);
        return;
        try {
        label_13:
            SharedFlowKt.access$setBufferAt(v0, arg5.index, SharedFlowKt.NO_VALUE);
            this.cleanupTailLocked();
        }
        catch(Throwable v5) {
        label_21:
            __monitor_exit(this);
            throw v5;
        }

        __monitor_exit(this);
    }

    private final void cleanupTailLocked() {
        if(this.bufferCapacity != 0 || this.queueSize > 1) {
            Object[] v0 = this.buffer;
            Intrinsics.checkNotNull(v0);
            while(this.queueSize > 0) {
                if(SharedFlowKt.access$getBufferAt(v0, this.getHead() + (((long)this.getTotalSize())) - 1) != SharedFlowKt.NO_VALUE) {
                    return;
                }

                --this.queueSize;
                SharedFlowKt.access$setBufferAt(v0, this.getHead() + (((long)this.getTotalSize())), null);
            }
        }
        else {
        }
    }

    public Object collect(FlowCollector arg1, Continuation arg2) {
        return SharedFlowImpl.collect$suspendImpl(this, arg1, arg2);
    }

    static Object collect$suspendImpl(SharedFlowImpl arg8, FlowCollector arg9, Continuation arg10) {
        Object v5;
        Object v2_1;
        Object v9;
        Object v8;
        AbstractSharedFlowSlot v9_2;
        SharedFlowImpl v5_1;
        int v2;
        Continuation v0;
        if((arg10 instanceof SharedFlowImpl$collect$1)) {
            v0 = arg10;
            v2 = 0x80000000;
            if((((SharedFlowImpl$collect$1)v0).label & v2) != 0) {
                ((SharedFlowImpl$collect$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            SharedFlowImpl$collect$1 v0_1 = new SharedFlowImpl$collect$1(arg8, arg10);
        }

        Object v10 = ((SharedFlowImpl$collect$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((SharedFlowImpl$collect$1)v0).label;
        int v3 = 3;
        int v4 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v10);
            AbstractSharedFlowSlot v10_1 = arg8.allocateSlot();
            try {
                if((arg9 instanceof SubscribedFlowCollector)) {
                    ((SharedFlowImpl$collect$1)v0).L$0 = arg8;
                    ((SharedFlowImpl$collect$1)v0).L$1 = arg9;
                    ((SharedFlowImpl$collect$1)v0).L$2 = v10_1;
                    ((SharedFlowImpl$collect$1)v0).label = 1;
                    if(arg9.onSubscription(v0) != v1) {
                        goto label_66;
                    }

                    return v1;
                }

                goto label_66;
            }
            catch(Throwable v9_1) {
                v5_1 = arg8;
                v8_1 = v9_1;
                v9_2 = v10_1;
                goto label_101;
            }

            return v1;
        label_66:
            AbstractSharedFlowSlot v7 = v10_1;
            FlowCollector v10_2 = arg9;
            v9_2 = v7;
            try {
            label_69:
                Element v2_2 = v0.getContext().get(Job.Key);
                do {
                label_72:
                    v5 = ((SharedFlowImpl)v8).tryTakeValue(((SharedFlowSlot)v9));
                    if(v5 == SharedFlowKt.NO_VALUE) {
                        ((SharedFlowImpl$collect$1)v0).L$0 = v8;
                        ((SharedFlowImpl$collect$1)v0).L$1 = v10_2;
                        ((SharedFlowImpl$collect$1)v0).L$2 = v9;
                        ((SharedFlowImpl$collect$1)v0).L$3 = v2_1;
                        ((SharedFlowImpl$collect$1)v0).label = v4;
                        if(((SharedFlowImpl)v8).awaitValue(((SharedFlowSlot)v9), v0) != v1) {
                            continue;
                        }

                        return v1;
                    }

                    if(v2_1 != null) {
                        JobKt.ensureActive(((Job)v2_1));
                    }

                    ((SharedFlowImpl$collect$1)v0).L$0 = v8;
                    ((SharedFlowImpl$collect$1)v0).L$1 = v10_2;
                    ((SharedFlowImpl$collect$1)v0).L$2 = v9;
                    ((SharedFlowImpl$collect$1)v0).L$3 = v2_1;
                    ((SharedFlowImpl$collect$1)v0).label = v3;
                    if(v10_2.emit(v5, v0) != v1) {
                        continue;
                    }

                    return v1;
                }
                while(true);
            }
            catch(Throwable v10_3) {
                goto label_94;
            }
        }
        else if(v2 != 1) {
            if(v2 == v4) {
                v8 = ((SharedFlowImpl$collect$1)v0).L$3;
                v9 = ((SharedFlowImpl$collect$1)v0).L$2;
                v2_1 = ((SharedFlowImpl$collect$1)v0).L$1;
                v5 = ((SharedFlowImpl$collect$1)v0).L$0;
            }
            else if(v2 == v3) {
                v8 = ((SharedFlowImpl$collect$1)v0).L$3;
                v9 = ((SharedFlowImpl$collect$1)v0).L$2;
                v2_1 = ((SharedFlowImpl$collect$1)v0).L$1;
                v5 = ((SharedFlowImpl$collect$1)v0).L$0;
            }
            else {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }

            try {
                ResultKt.throwOnFailure(v10);
                v10 = v2_1;
                v2_1 = v8;
                v8 = v5;
                goto label_72;
            }
            catch(Throwable v8_1) {
                goto label_101;
            }
        }
        else {
            v9 = ((SharedFlowImpl$collect$1)v0).L$2;
            v8 = ((SharedFlowImpl$collect$1)v0).L$1;
            v2_1 = ((SharedFlowImpl$collect$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v10);
                v10 = v8;
                v8 = v2_1;
                goto label_69;
            }
            catch(Throwable v8_1) {
                v5 = v2_1;
                goto label_101;
            }
        }

        return v1;
    label_94:
        v5_1 = ((SharedFlowImpl)v8);
        v8_1 = v10_3;
    label_101:
        ((SharedFlowImpl)v5).freeSlot(((AbstractSharedFlowSlot)v9));
        throw v8_1;
    }

    private final void correctCollectorIndexesOnDropOldest(long arg9) {
        SharedFlowImpl v0 = this;
        if(((AbstractSharedFlow)v0).nCollectors != 0) {
            AbstractSharedFlowSlot[] v0_1 = ((AbstractSharedFlow)v0).slots;
            if(v0_1 != null) {
                int v1 = v0_1.length;
                int v2;
                for(v2 = 0; v2 < v1; ++v2) {
                    AbstractSharedFlowSlot v3 = v0_1[v2];
                    if(v3 != null && ((SharedFlowSlot)v3).index >= 0 && ((SharedFlowSlot)v3).index < arg9) {
                        ((SharedFlowSlot)v3).index = arg9;
                    }
                }
            }
        }

        this.minCollectorIndex = arg9;
    }

    protected SharedFlowSlot createSlot() {
        return new SharedFlowSlot();
    }

    public AbstractSharedFlowSlot createSlot() {
        return this.createSlot();
    }

    protected SharedFlowSlot[] createSlotArray(int arg1) {
        return new SharedFlowSlot[arg1];
    }

    public AbstractSharedFlowSlot[] createSlotArray(int arg1) {
        return this.createSlotArray(arg1);
    }

    private final void dropOldestLocked() {
        Object[] v0 = this.buffer;
        Intrinsics.checkNotNull(v0);
        SharedFlowKt.access$setBufferAt(v0, this.getHead(), null);
        --this.bufferSize;
        long v0_1 = this.getHead() + 1;
        if(this.replayIndex < v0_1) {
            this.replayIndex = v0_1;
        }

        if(this.minCollectorIndex < v0_1) {
            this.correctCollectorIndexesOnDropOldest(v0_1);
        }

        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(this.getHead() == v0_1) {
                return;
            }

            throw new AssertionError();
        }
    }

    public Object emit(Object arg1, Continuation arg2) {
        return SharedFlowImpl.emit$suspendImpl(this, arg1, arg2);
    }

    static Object emit$suspendImpl(SharedFlowImpl arg1, Object arg2, Continuation arg3) {
        if(arg1.tryEmit(arg2)) {
            return Unit.INSTANCE;
        }

        Object v1 = arg1.emitSuspend(arg2, arg3);
        if(v1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v1;
        }

        return Unit.INSTANCE;
    }

    private final Object emitSuspend(Object arg11, Continuation arg12) {
        Emitter v4;
        Object v8;
        CancellableContinuationImpl v9;
        long v6;
        Throwable v11_1;
        SharedFlowImpl v5;
        Emitter v2;
        Continuation[] v11;
        CancellableContinuationImpl v0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg12), 1);
        v0.initCancellability();
        CancellableContinuationImpl v1 = v0;
        Continuation[] v3 = AbstractSharedFlowKt.EMPTY_RESUMES;
        __monitor_enter(this);
        try {
            if(this.tryEmitLocked(arg11)) {
            }
            else {
                goto label_23;
            }
        }
        catch(Throwable v0_1) {
            goto label_67;
        }

        try {
            v1.resumeWith(Result.constructor-impl(Unit.INSTANCE));
            v11 = this.findSlotsToResumeLocked(v3);
            v2 = null;
            v5 = this;
            goto label_41;
        }
        catch(Throwable v0_1) {
            v11_1 = v0_1;
            v5 = this;
            goto label_69;
        }

        try {
        label_23:
            v6 = this.getHead() + (((long)this.getTotalSize()));
            v9 = v1;
            v5 = this;
            v8 = arg11;
        }
        catch(Throwable v0_1) {
        label_67:
            v5 = this;
            goto label_68;
        }

        try {
            v4 = new Emitter(v5, v6, v8, ((Continuation)v9));
            v5.enqueueLocked(v4);
            ++v5.queueSize;
            if(v5.bufferCapacity == 0) {
                v3 = v5.findSlotsToResumeLocked(v3);
            }

            goto label_39;
        }
        catch(Throwable v0_1) {
        }

    label_68:
        v11_1 = v0_1;
    label_69:
        __monitor_exit(v5);
        throw v11_1;
    label_39:
        v11 = v3;
        v2 = v4;
    label_41:
        __monitor_exit(v5);
        if(v2 != null) {
            CancellableContinuationKt.disposeOnCancellation(((CancellableContinuation)v1), ((DisposableHandle)v2));
        }

        int v10 = v11.length;
        int v1_1;
        for(v1_1 = 0; v1_1 < v10; ++v1_1) {
            Continuation v2_1 = v11[v1_1];
            if(v2_1 != null) {
                v2_1.resumeWith(Result.constructor-impl(Unit.INSTANCE));
            }
        }

        Object v10_1 = v0.getResult();
        if(v10_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg12);
        }

        if(v10_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v10_1;
        }

        return Unit.INSTANCE;
    }

    private final void enqueueLocked(Object arg7) {
        int v0 = this.getTotalSize();
        Object[] v1 = this.buffer;
        int v2 = 2;
        if(v1 == null) {
            v1 = this.growBuffer(null, 0, v2);
        }
        else if(v0 >= v1.length) {
            v1 = this.growBuffer(v1, v0, v1.length * v2);
        }

        SharedFlowKt.access$setBufferAt(v1, this.getHead() + (((long)v0)), arg7);
    }

    private final Continuation[] findSlotsToResumeLocked(Continuation[] arg11) {
        Object[] v11;
        int v0 = arg11.length;
        SharedFlowImpl v1 = this;
        if(((AbstractSharedFlow)v1).nCollectors != 0) {
            AbstractSharedFlowSlot[] v1_1 = ((AbstractSharedFlow)v1).slots;
            if(v1_1 != null) {
                int v2 = v1_1.length;
                int v3;
                for(v3 = 0; v3 < v2; ++v3) {
                    AbstractSharedFlowSlot v4 = v1_1[v3];
                    if(v4 != null) {
                        Continuation v5 = ((SharedFlowSlot)v4).cont;
                        if(v5 == null) {
                        }
                        else if(this.tryPeekLocked(((SharedFlowSlot)v4)) >= 0) {
                            if(v0 >= arg11.length) {
                                v11 = Arrays.copyOf(v11, Math.max(2, ((Continuation[])v11).length * 2));
                                Intrinsics.checkNotNullExpressionValue(v11, "copyOf(...)");
                            }

                            ((Continuation[])v11)[v0] = v5;
                            ((SharedFlowSlot)v4).cont = null;
                            ++v0;
                        }
                    }
                }
            }
        }

        return ((Continuation[])v11);
    }

    public Flow fuse(CoroutineContext arg1, int arg2, BufferOverflow arg3) {
        return SharedFlowKt.fuseSharedFlow(((SharedFlow)this), arg1, arg2, arg3);
    }

    private final long getBufferEndIndex() {
        return this.getHead() + (((long)this.bufferSize));
    }

    private final long getHead() {
        return Math.min(this.minCollectorIndex, this.replayIndex);
    }

    protected final Object getLastReplayedLocked() {
        Object[] v0 = this.buffer;
        Intrinsics.checkNotNull(v0);
        return SharedFlowKt.access$getBufferAt(v0, this.replayIndex + (((long)this.getReplaySize())) - 1);
    }

    protected static void getLastReplayedLocked$annotations() {
    }

    private final Object getPeekedValueLockedAt(long arg1) {
        Object[] v0 = this.buffer;
        Intrinsics.checkNotNull(v0);
        Object v0_1 = SharedFlowKt.access$getBufferAt(v0, arg1);
        if((v0_1 instanceof Emitter)) {
            v0_1 = ((Emitter)v0_1).value;
        }

        return v0_1;
    }

    private final long getQueueEndIndex() {
        return this.getHead() + (((long)this.bufferSize)) + (((long)this.queueSize));
    }

    public List getReplayCache() {
        ArrayList v1;
        List v0_2;
        int v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.getReplaySize();
            if(v0_1 != 0) {
                goto label_6;
            }

            v0_2 = CollectionsKt.emptyList();
        }
        catch(Throwable v0) {
            goto label_23;
        }

        __monitor_exit(this);
        return v0_2;
        try {
        label_6:
            v1 = new ArrayList(v0_1);
            Object[] v2 = this.buffer;
            Intrinsics.checkNotNull(v2);
            int v3;
            for(v3 = 0; v3 < v0_1; ++v3) {
                v1.add(SharedFlowKt.access$getBufferAt(v2, this.replayIndex + (((long)v3))));
            }
        }
        catch(Throwable v0) {
            goto label_23;
        }

        __monitor_exit(this);
        return ((List)v1);
    label_23:
        __monitor_exit(this);
        throw v0;
    }

    private final int getReplaySize() {
        return ((int)(this.getHead() + (((long)this.bufferSize)) - this.replayIndex));
    }

    private final int getTotalSize() {
        return this.bufferSize + this.queueSize;
    }

    private final Object[] growBuffer(Object[] arg6, int arg7, int arg8) {
        if(arg8 > 0) {
            Object[] v8 = new Object[arg8];
            this.buffer = v8;
            if(arg6 == null) {
            }
            else {
                long v0 = this.getHead();
                int v5;
                for(v5 = 0; v5 < arg7; ++v5) {
                    long v2 = (((long)v5)) + v0;
                    SharedFlowKt.access$setBufferAt(v8, v2, SharedFlowKt.access$getBufferAt(arg6, v2));
                }
            }

            return v8;
        }

        throw new IllegalStateException("Buffer size overflow".toString());
    }

    public void resetReplayCache() {
        SharedFlowImpl v1;
        long v8;
        long v6;
        long v4;
        long v2;
        __monitor_enter(this);
        try {
            v2 = this.getBufferEndIndex();
            v4 = this.minCollectorIndex;
            v6 = this.getBufferEndIndex();
            v8 = this.getQueueEndIndex();
            v1 = this;
        }
        catch(Throwable v0) {
            v1 = this;
            goto label_14;
        }

        try {
            v1.updateBufferLocked(v2, v4, v6, v8);
            goto label_8;
        }
        catch(Throwable v0) {
        }

    label_14:
        __monitor_exit(v1);
        throw v0;
    label_8:
        __monitor_exit(v1);
    }

    public boolean tryEmit(Object arg5) {
        boolean v5_1;
        int v1;
        Continuation[] v0 = AbstractSharedFlowKt.EMPTY_RESUMES;
        __monitor_enter(this);
        try {
            v1 = 0;
            if(this.tryEmitLocked(arg5)) {
                v0 = this.findSlotsToResumeLocked(v0);
                v5_1 = true;
            }
            else {
                goto label_8;
            }

            goto label_9;
        }
        catch(Throwable v5) {
            __monitor_exit(this);
            throw v5;
        }

    label_8:
        v5_1 = false;
    label_9:
        __monitor_exit(this);
        int v4 = v0.length;
        while(v1 < v4) {
            Continuation v2 = v0[v1];
            if(v2 != null) {
                v2.resumeWith(Result.constructor-impl(Unit.INSTANCE));
            }

            ++v1;
        }

        return v5_1;
    }

    private final boolean tryEmitLocked(Object arg15) {
        if(this.getNCollectors() == 0) {
            return this.tryEmitNoCollectorsLocked(arg15);
        }

        if(this.bufferSize >= this.bufferCapacity && this.minCollectorIndex <= this.replayIndex) {
            int v0 = WhenMappings.$EnumSwitchMapping$0[this.onBufferOverflow.ordinal()];
            if(v0 == 1) {
                return 0;
            }
            else if(v0 == 2) {
                return 1;
            }
            else if(v0 == 3) {
            }
            else {
                throw new NoWhenBranchMatchedException();
            }
        }

        this.enqueueLocked(arg15);
        int v15 = this.bufferSize + 1;
        this.bufferSize = v15;
        if(v15 > this.bufferCapacity) {
            this.dropOldestLocked();
        }

        if(this.getReplaySize() > this.replay) {
            this.updateBufferLocked(this.replayIndex + 1, this.minCollectorIndex, this.getBufferEndIndex(), this.getQueueEndIndex());
        }

        return 1;
    }

    private final boolean tryEmitNoCollectorsLocked(Object arg7) {
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(this.getNCollectors() == 0) {
            }
            else {
                throw new AssertionError();
            }
        }

        if(this.replay == 0) {
            return 1;
        }

        this.enqueueLocked(arg7);
        int v7 = this.bufferSize + 1;
        this.bufferSize = v7;
        if(v7 > this.replay) {
            this.dropOldestLocked();
        }

        this.minCollectorIndex = this.getHead() + (((long)this.bufferSize));
        return 1;
    }

    private final long tryPeekLocked(SharedFlowSlot arg7) {
        long v0 = arg7.index;
        if(v0 < this.getBufferEndIndex()) {
        }
        else {
            long v2 = -1;
            if(this.bufferCapacity > 0) {
                return v2;
            }
            else if(v0 > this.getHead()) {
                return v2;
            }
            else if(this.queueSize == 0) {
                return v2;
            }
        }

        return v0;
    }

    private final Object tryTakeValue(SharedFlowSlot arg9) {
        Object v9_2;
        Continuation[] v0 = AbstractSharedFlowKt.EMPTY_RESUMES;
        __monitor_enter(this);
        try {
            long v1 = this.tryPeekLocked(arg9);
            if(v1 < 0) {
                Symbol v9_1 = SharedFlowKt.NO_VALUE;
            }
            else {
                long v3 = arg9.index;
                Object v0_1 = this.getPeekedValueLockedAt(v1);
                arg9.index = v1 + 1;
                Object v7 = v0_1;
                v0 = this.updateCollectorIndexLocked$kotlinx_coroutines_core(v3);
                v9_2 = v7;
            }
        }
        catch(Throwable v9) {
            __monitor_exit(this);
            throw v9;
        }

        __monitor_exit(this);
        int v8 = v0.length;
        int v1_1;
        for(v1_1 = 0; v1_1 < v8; ++v1_1) {
            Continuation v2 = v0[v1_1];
            if(v2 != null) {
                v2.resumeWith(Result.constructor-impl(Unit.INSTANCE));
            }
        }

        return v9_2;
    }

    private final void updateBufferLocked(long arg7, long arg9, long arg11, long arg13) {
        long v0 = Math.min(arg9, arg7);
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(v0 >= this.getHead()) {
            }
            else {
                throw new AssertionError();
            }
        }

        long v2;
        for(v2 = this.getHead(); v2 < v0; ++v2) {
            Object[] v4 = this.buffer;
            Intrinsics.checkNotNull(v4);
            SharedFlowKt.access$setBufferAt(v4, v2, null);
        }

        this.replayIndex = arg7;
        this.minCollectorIndex = arg9;
        this.bufferSize = ((int)(arg11 - v0));
        this.queueSize = ((int)(arg13 - arg11));
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(this.bufferSize >= 0) {
            }
            else {
                throw new AssertionError();
            }
        }

        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(this.queueSize >= 0) {
            }
            else {
                throw new AssertionError();
            }
        }

        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(this.replayIndex <= this.getHead() + (((long)this.bufferSize))) {
                return;
            }

            throw new AssertionError();
        }
    }

    public final Continuation[] updateCollectorIndexLocked$kotlinx_coroutines_core(long arg20) {
        Continuation[] v9_1;
        int v1_1;
        long v17;
        int v8;
        SharedFlowImpl v0 = this;
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(arg20 >= v0.minCollectorIndex) {
            }
            else {
                throw new AssertionError();
            }
        }

        if(arg20 > v0.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }

        long v1 = v0.getHead();
        long v3 = (((long)v0.bufferSize)) + v1;
        long v6 = 1;
        if(v0.bufferCapacity == 0 && v0.queueSize > 0) {
            v3 += v6;
        }

        SharedFlowImpl v5 = v0;
        if(((AbstractSharedFlow)v5).nCollectors != 0) {
            AbstractSharedFlowSlot[] v5_1 = ((AbstractSharedFlow)v5).slots;
            if(v5_1 != null) {
                v8 = v5_1.length;
                int v10;
                for(v10 = 0; v10 < v8; ++v10) {
                    AbstractSharedFlowSlot v11 = v5_1[v10];
                    if(v11 != null && ((SharedFlowSlot)v11).index >= 0 && ((SharedFlowSlot)v11).index < v3) {
                        v3 = ((SharedFlowSlot)v11).index;
                    }
                }
            }
        }

        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(v3 >= v0.minCollectorIndex) {
            }
            else {
                throw new AssertionError();
            }
        }

        if(v3 <= v0.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }

        long v10_1 = v0.getBufferEndIndex();
        int v5_2 = v0.getNCollectors();
        v8 = v0.queueSize;
        if(v5_2 > 0) {
            v8 = Math.min(v8, v0.bufferCapacity - (((int)(v10_1 - v3))));
        }

        Continuation[] v5_3 = AbstractSharedFlowKt.EMPTY_RESUMES;
        long v12 = (((long)v0.queueSize)) + v10_1;
        if(v8 > 0) {
            v5_3 = new Continuation[v8];
            Object[] v14 = v0.buffer;
            Intrinsics.checkNotNull(v14);
            arg20 = v6;
            v6 = v10_1;
            int v15 = 0;
            while(v10_1 < v12) {
                Object v9 = SharedFlowKt.access$getBufferAt(v14, v10_1);
                v17 = v1;
                if(v9 != SharedFlowKt.NO_VALUE) {
                    Intrinsics.checkNotNull(v9, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    v1_1 = v15 + 1;
                    v5_3[v15] = ((Emitter)v9).cont;
                    SharedFlowKt.access$setBufferAt(v14, v10_1, SharedFlowKt.NO_VALUE);
                    SharedFlowKt.access$setBufferAt(v14, v6, ((Emitter)v9).value);
                    v6 += arg20;
                    if(v1_1 < v8) {
                        v15 = v1_1;
                    }
                    else {
                        goto label_94;
                    }
                }

                v10_1 += arg20;
                v1 = v17;
            }

            v17 = v1;
        label_94:
            v9_1 = v5_3;
            v10_1 = v6;
        }
        else {
            v17 = v1;
            arg20 = v6;
            v9_1 = v5_3;
        }

        v1_1 = ((int)(v10_1 - v17));
        if(v0.getNCollectors() == 0) {
            v3 = v10_1;
        }

        v1 = Math.max(v0.replayIndex, v10_1 - (((long)Math.min(v0.replay, v1_1))));
        if(v0.bufferCapacity == 0 && v1 < v12) {
            Object[] v5_4 = v0.buffer;
            Intrinsics.checkNotNull(v5_4);
            if(Intrinsics.areEqual(SharedFlowKt.access$getBufferAt(v5_4, v1), SharedFlowKt.NO_VALUE)) {
                v10_1 += arg20;
                v1 += arg20;
            }
        }

        v0.updateBufferLocked(v1, v3, v10_1, v12);
        v0.cleanupTailLocked();
        int v16 = v9_1.length == 0 ? 1 : 0;
        if(v16 == 0) {
            return v0.findSlotsToResumeLocked(v9_1);
        }

        return v9_1;
    }

    public final long updateNewCollectorIndexLocked$kotlinx_coroutines_core() {
        long v0 = this.replayIndex;
        if(v0 < this.minCollectorIndex) {
            this.minCollectorIndex = v0;
        }

        return v0;
    }
}

