package kotlinx.coroutines.stream;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001C\u0010\t\u001A\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\fH\u0096@¢\u0006\u0002\u0010\rR\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\t\u0010\u0007\u001A\u00020\bX\u0082\u0004¨\u0006\u000E"}, d2={"Lkotlinx/coroutines/stream/StreamFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "stream", "Ljava/util/stream/Stream;", "<init>", "(Ljava/util/stream/Stream;)V", "consumed", "Lkotlinx/atomicfu/AtomicBoolean;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class StreamFlow implements Flow {
    private final Stream stream;

    static {
        StreamFlow.consumed$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(StreamFlow.class, "consumed$volatile");
    }

    public StreamFlow(Stream arg1) {
        super();
        this.stream = arg1;
    }

    public Object collect(FlowCollector arg6, Continuation arg7) {
        Object v2_1;
        Object v6;
        Iterator v6_3;
        FlowCollector v7_1;
        Iterator v5_2;
        int v2;
        Continuation v0;
        if((arg7 instanceof StreamFlow$collect$1)) {
            v0 = arg7;
            v2 = 0x80000000;
            if((((StreamFlow$collect$1)v0).label & v2) != 0) {
                ((StreamFlow$collect$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            StreamFlow$collect$1 v0_1 = new StreamFlow$collect$1(this, arg7);
        }

        Object v7 = ((StreamFlow$collect$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((StreamFlow$collect$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v7);
            if(StreamFlow.getConsumed$volatile$FU().compareAndSet(this, 0, 1)) {
                try {
                    FlowCollector v4 = arg6;
                    StreamFlow v6_2 = this;
                    v5_2 = this.stream.iterator();
                    v7_1 = v4;
                }
                catch(Throwable v6_1) {
                    Throwable v4_1 = v6_1;
                    v6_3 = v5_2;
                    v5_1 = v4_1;
                    goto label_64;
                }
            }
            else {
                goto label_67;
            }
        }
        else if(v2 == 1) {
            Object v5 = ((StreamFlow$collect$1)v0).L$2;
            v6 = ((StreamFlow$collect$1)v0).L$1;
            v2_1 = ((StreamFlow$collect$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v7);
                v7 = v6;
                v6 = v2_1;
            }
            catch(Throwable v5_1) {
                v6 = v2_1;
                goto label_64;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        try {
            do {
                if(!v5_2.hasNext()) {
                    goto label_54;
                }

                v2_1 = v5_2.next();
                ((StreamFlow$collect$1)v0).L$0 = v6;
                ((StreamFlow$collect$1)v0).L$1 = v7_1;
                ((StreamFlow$collect$1)v0).L$2 = v5_2;
                ((StreamFlow$collect$1)v0).label = 1;
                if(v7_1.emit(v2_1, v0) != v1) {
                    continue;
                }

                return v1;
            }
            while(true);
        }
        catch(Throwable v5_1) {
            goto label_64;
        }

        return v1;
    label_54:
        ((StreamFlow)v6).stream.close();
        return Unit.INSTANCE;
    label_64:
        ((StreamFlow)v6_3).stream.close();
        throw v5_1;
    label_67:
        throw new IllegalStateException("Stream.consumeAsFlow can be collected only once".toString());
    }

    private final int getConsumed$volatile() {
        return this.consumed$volatile;
    }

    private static final AtomicIntegerFieldUpdater getConsumed$volatile$FU() {
        return StreamFlow.consumed$volatile$FU;
    }

    private final void setConsumed$volatile(int arg1) {
        this.consumed$volatile = arg1;
    }
}

