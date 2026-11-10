package kotlinx.coroutines.channels;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B;\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\"\b\u0002\u0010\u0007\u001A\u001C\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n¢\u0006\u0004\b\u000B\u0010\fJ\u0016\u0010\u0010\u001A\u00020\t2\u0006\u0010\u0011\u001A\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00028\u0000H\u0090@¢\u0006\u0004\b\u0014\u0010\u0012J\u001D\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\t0\u00162\u0006\u0010\u0011\u001A\u00028\u0000H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\t0\u00162\u0006\u0010\u0011\u001A\u00028\u00002\u0006\u0010\u001A\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\u001B\u0010\u001CJ%\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\t0\u00162\u0006\u0010\u0011\u001A\u00028\u00002\u0006\u0010\u001A\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\u001E\u0010\u001CJ\u001E\u0010\u001F\u001A\u00020\t2\n\u0010 \u001A\u0006\u0012\u0002\b\u00030!2\b\u0010\u0011\u001A\u0004\u0018\u00010\"H\u0014J\r\u0010#\u001A\u00020\u000EH\u0010¢\u0006\u0002\b$R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\u00020\u000E8TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000F¨\u0006%"}, d2={"Lkotlinx/coroutines/channels/ConflatedBufferedChannel;", "E", "Lkotlinx/coroutines/channels/BufferedChannel;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)V", "isConflatedDropOldest", "", "()Z", "send", "element", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendBroadcast", "sendBroadcast$kotlinx_coroutines_core", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySendImpl", "isSendOp", "trySendImpl-Mj0NB7M", "(Ljava/lang/Object;Z)Ljava/lang/Object;", "trySendDropLatest", "trySendDropLatest-Mj0NB7M", "registerSelectForSend", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "", "shouldSendSuspend", "shouldSendSuspend$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public class ConflatedBufferedChannel extends BufferedChannel {
    private final int capacity;
    private final BufferOverflow onBufferOverflow;

    public ConflatedBufferedChannel(int arg1, BufferOverflow arg2, Function1 arg3) {
        super(arg1, arg3);
        this.capacity = arg1;
        this.onBufferOverflow = arg2;
        if(arg2 != BufferOverflow.SUSPEND) {
            if(arg1 >= 1) {
                return;
            }

            throw new IllegalArgumentException("Buffered channel capacity must be at least 1, but " + arg1 + " was specified".toString());
        }

        throw new IllegalArgumentException("This implementation does not support suspension for senders, use " + Reflection.getOrCreateKotlinClass(BufferedChannel.class).getSimpleName() + " instead".toString());
    }

    public ConflatedBufferedChannel(int arg1, BufferOverflow arg2, Function1 arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        this(arg1, arg2, arg3);
    }

    protected boolean isConflatedDropOldest() {
        if(this.onBufferOverflow == BufferOverflow.DROP_OLDEST) {
            return 1;
        }

        return 0;
    }

    protected void registerSelectForSend(SelectInstance arg1, Object arg2) {
        Object v0 = this.trySend-JP2dKIU(arg2);
        if(!(v0 instanceof Failed)) {
            arg1.selectInRegistrationPhase(Unit.INSTANCE);
            return;
        }

        if((v0 instanceof Closed)) {
            ChannelResult.exceptionOrNull-impl(v0);
            arg1.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
            return;
        }

        throw new IllegalStateException("unreachable".toString());
    }

    public Object send(Object arg1, Continuation arg2) {
        return ConflatedBufferedChannel.send$suspendImpl(this, arg1, arg2);
    }

    static Object send$suspendImpl(ConflatedBufferedChannel arg2, Object arg3, Continuation arg4) {
        Object v4 = arg2.trySendImpl-Mj0NB7M(arg3, true);
        if((v4 instanceof Closed)) {
            ChannelResult.exceptionOrNull-impl(v4);
            Function1 v4_1 = arg2.onUndeliveredElement;
            if(v4_1 != null) {
                UndeliveredElementException v3 = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(v4_1, arg3, null, 2, null);
                if(v3 != null) {
                    ExceptionsKt.addSuppressed(v3, arg2.getSendException());
                    throw v3;
                }
            }

            throw arg2.getSendException();
        }

        return Unit.INSTANCE;
    }

    public Object sendBroadcast$kotlinx_coroutines_core(Object arg1, Continuation arg2) {
        return ConflatedBufferedChannel.sendBroadcast$suspendImpl(this, arg1, arg2);
    }

    static Object sendBroadcast$suspendImpl(ConflatedBufferedChannel arg0, Object arg1, Continuation arg2) {
        if(!(arg0.trySendImpl-Mj0NB7M(arg1, true) instanceof Failed)) {
            return Boxing.boxBoolean(true);
        }

        return Boxing.boxBoolean(false);
    }

    public boolean shouldSendSuspend$kotlinx_coroutines_core() {
        return 0;
    }

    public Object trySend-JP2dKIU(Object arg2) {
        return this.trySendImpl-Mj0NB7M(arg2, false);
    }

    private final Object trySendDropLatest-Mj0NB7M(Object arg3, boolean arg4) {
        Object v0 = super.trySend-JP2dKIU(arg3);
        if(!ChannelResult.isSuccess-impl(v0)) {
            if(ChannelResult.isClosed-impl(v0)) {
            }
            else {
                if(arg4) {
                    Function1 v2 = this.onUndeliveredElement;
                    if(v2 != null) {
                        UndeliveredElementException v2_1 = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(v2, arg3, null, 2, null);
                        if(v2_1 == null) {
                        }
                        else {
                            throw v2_1;
                        }
                    }
                }

                return ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
            }
        }

        return v0;
    }

    private final Object trySendImpl-Mj0NB7M(Object arg3, boolean arg4) {
        if(this.onBufferOverflow == BufferOverflow.DROP_LATEST) {
            return this.trySendDropLatest-Mj0NB7M(arg3, arg4);
        }

        return this.trySendDropOldest-JP2dKIU(arg3);
    }
}

