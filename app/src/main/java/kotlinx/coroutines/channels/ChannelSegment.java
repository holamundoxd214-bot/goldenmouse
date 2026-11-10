package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.concurrent.atomics.AtomicArraysKt__AtomicArrays_jvmKt$$ExternalSyntheticBackportWithForwarding0;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00000\u0002B7\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u000E\u0010\u0005\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000E\u0010\u0006\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\t2\u0006\u0010\u0018\u001A\u00028\u0000H\u0000¢\u0006\u0004\b\u0019\u0010\u001AJ\u0017\u0010\u001B\u001A\u00028\u00002\u0006\u0010\u0017\u001A\u00020\tH\u0000¢\u0006\u0004\b\u001C\u0010\u001DJ\u0017\u0010\u001E\u001A\u00028\u00002\u0006\u0010\u0017\u001A\u00020\tH\u0000¢\u0006\u0004\b\u001F\u0010\u001DJ\u0015\u0010 \u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\tH\u0000¢\u0006\u0002\b!J\u001A\u0010\"\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\t2\b\u0010#\u001A\u0004\u0018\u00010\u0011H\u0002J\u0017\u0010$\u001A\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001A\u00020\tH\u0000¢\u0006\u0002\b%J\u001F\u0010&\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\t2\b\u0010#\u001A\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0002\b\'J)\u0010(\u001A\u00020)2\u0006\u0010\u0017\u001A\u00020\t2\b\u0010*\u001A\u0004\u0018\u00010\u00112\b\u0010+\u001A\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0002\b,J!\u0010-\u001A\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001A\u00020\t2\b\u0010.\u001A\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0002\b/J\"\u00100\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\t2\b\u00101\u001A\u0004\u0018\u0001022\u0006\u00103\u001A\u000204H\u0016J\u0016\u00105\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\t2\u0006\u00106\u001A\u00020)R\u0016\u0010\f\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u00078F¢\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u000F\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010X\u0082\u0004R\u0014\u0010\u0012\u001A\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014¨\u00067"}, d2={"Lkotlinx/coroutines/channels/ChannelSegment;", "E", "Lkotlinx/coroutines/internal/Segment;", "id", "", "prev", "channel", "Lkotlinx/coroutines/channels/BufferedChannel;", "pointers", "", "<init>", "(JLkotlinx/coroutines/channels/ChannelSegment;Lkotlinx/coroutines/channels/BufferedChannel;I)V", "_channel", "getChannel", "()Lkotlinx/coroutines/channels/BufferedChannel;", "data", "Lkotlinx/atomicfu/AtomicArray;", "", "numberOfSlots", "getNumberOfSlots", "()I", "storeElement", "", "index", "element", "storeElement$kotlinx_coroutines_core", "(ILjava/lang/Object;)V", "getElement", "getElement$kotlinx_coroutines_core", "(I)Ljava/lang/Object;", "retrieveElement", "retrieveElement$kotlinx_coroutines_core", "cleanElement", "cleanElement$kotlinx_coroutines_core", "setElementLazy", "value", "getState", "getState$kotlinx_coroutines_core", "setState", "setState$kotlinx_coroutines_core", "casState", "", "from", "to", "casState$kotlinx_coroutines_core", "getAndSetState", "update", "getAndSetState$kotlinx_coroutines_core", "onCancellation", "cause", "", "context", "Lkotlin/coroutines/CoroutineContext;", "onCancelledRequest", "receiver", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ChannelSegment extends Segment {
    private final BufferedChannel _channel;

    public ChannelSegment(long arg1, ChannelSegment arg3, BufferedChannel arg4, int arg5) {
        super(arg1, ((Segment)arg3), arg5);
        this._channel = arg4;
        this.data = new AtomicReferenceArray(BufferedChannelKt.SEGMENT_SIZE * 2);
    }

    public final boolean casState$kotlinx_coroutines_core(int arg1, Object arg2, Object arg3) {
        return AtomicArraysKt__AtomicArrays_jvmKt$$ExternalSyntheticBackportWithForwarding0.m(this.getData(), arg1 * 2 + 1, arg2, arg3);
    }

    public final void cleanElement$kotlinx_coroutines_core(int arg2) {
        this.setElementLazy(arg2, null);
    }

    public final Object getAndSetState$kotlinx_coroutines_core(int arg1, Object arg2) {
        return this.getData().getAndSet(arg1 * 2 + 1, arg2);
    }

    public final BufferedChannel getChannel() {
        BufferedChannel v0 = this._channel;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    private final AtomicReferenceArray getData() {
        return this.data;
    }

    public final Object getElement$kotlinx_coroutines_core(int arg1) {
        return this.getData().get(arg1 * 2);
    }

    public int getNumberOfSlots() {
        return BufferedChannelKt.SEGMENT_SIZE;
    }

    public final Object getState$kotlinx_coroutines_core(int arg1) {
        return this.getData().get(arg1 * 2 + 1);
    }

    public void onCancellation(int arg4, Throwable arg5, CoroutineContext arg6) {
        Function1 v3;
        int v5 = arg4 >= BufferedChannelKt.SEGMENT_SIZE ? 1 : 0;
        if(v5 != 0) {
            arg4 -= BufferedChannelKt.SEGMENT_SIZE;
        }

        Object v0 = this.getElement$kotlinx_coroutines_core(arg4);
        do {
            Object v1 = this.getState$kotlinx_coroutines_core(arg4);
            if(((v1 instanceof Waiter)) || ((v1 instanceof WaiterEB))) {
                Symbol v2 = v5 != 0 ? BufferedChannelKt.INTERRUPTED_SEND : BufferedChannelKt.INTERRUPTED_RCV;
                if(!this.casState$kotlinx_coroutines_core(arg4, v1, v2)) {
                    continue;
                }

                break;
            }
            else {
                if(v1 != BufferedChannelKt.INTERRUPTED_SEND) {
                    if(v1 == BufferedChannelKt.INTERRUPTED_RCV) {
                    }
                    else {
                        if(v1 == BufferedChannelKt.RESUMING_BY_EB) {
                            continue;
                        }

                        if(v1 == BufferedChannelKt.RESUMING_BY_RCV) {
                            continue;
                        }
                        else if(v1 == BufferedChannelKt.DONE_RCV) {
                            return;
                        }
                        else if(v1 == BufferedChannelKt.BUFFERED) {
                            return;
                        }
                        else if(v1 == BufferedChannelKt.getCHANNEL_CLOSED()) {
                            return;
                        }
                        else {
                            throw new IllegalStateException("unexpected state: " + v1.toString());
                        }
                    }
                }

                this.cleanElement$kotlinx_coroutines_core(arg4);
                if(v5 == 0) {
                    return;
                }

                v3 = this.getChannel().onUndeliveredElement;
                if(v3 == null) {
                    return;
                }

                OnUndeliveredElementKt.callUndeliveredElement(v3, v0, arg6);
                return;
            }

            return;
        }
        while(true);

        this.cleanElement$kotlinx_coroutines_core(arg4);
        this.onCancelledRequest(arg4, v5 ^ 1);
        if(v5 != 0) {
            v3 = this.getChannel().onUndeliveredElement;
            if(v3 == null) {
                return;
            }

            OnUndeliveredElementKt.callUndeliveredElement(v3, v0, arg6);
        }
    }

    public final void onCancelledRequest(int arg5, boolean arg6) {
        if(arg6) {
            this.getChannel().waitExpandBufferCompletion$kotlinx_coroutines_core(this.id * (((long)BufferedChannelKt.SEGMENT_SIZE)) + (((long)arg5)));
        }

        this.onSlotCleaned();
    }

    public final Object retrieveElement$kotlinx_coroutines_core(int arg2) {
        Object v0 = this.getElement$kotlinx_coroutines_core(arg2);
        this.cleanElement$kotlinx_coroutines_core(arg2);
        return v0;
    }

    private final void setElementLazy(int arg1, Object arg2) {
        this.getData().set(arg1 * 2, arg2);
    }

    public final void setState$kotlinx_coroutines_core(int arg1, Object arg2) {
        this.getData().set(arg1 * 2 + 1, arg2);
    }

    public final void storeElement$kotlinx_coroutines_core(int arg1, Object arg2) {
        this.setElementLazy(arg1, arg2);
    }
}

