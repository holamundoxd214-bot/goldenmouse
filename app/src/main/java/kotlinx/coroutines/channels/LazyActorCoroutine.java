package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BL\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012-\u0010\u0007\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b¢\u0006\u0002\b\r¢\u0006\u0004\b\u000E\u0010\u000FJ\b\u0010\u0011\u001A\u00020\u000BH\u0014J\u0016\u0010\u0012\u001A\u00020\u000B2\u0006\u0010\u0013\u001A\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0013\u001A\u00028\u0000H\u0017¢\u0006\u0002\u0010\u0017J\u001D\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u000B0\u00192\u0006\u0010\u0013\u001A\u00028\u0000H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ\u0012\u0010\u001C\u001A\u00020\u00162\b\u0010\u001D\u001A\u0004\u0018\u00010\u001EH\u0016J\u001E\u0010&\u001A\u00020\u000B2\n\u0010\'\u001A\u0006\u0012\u0002\b\u00030(2\b\u0010\u0013\u001A\u0004\u0018\u00010\fH\u0002R\u0014\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u000B0\nX\u0082\u000E¢\u0006\u0002\n\u0000R,\u0010\u001F\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000!0 8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\"\u0010#\u001A\u0004\b$\u0010%¨\u0006)"}, d2={"Lkotlinx/coroutines/channels/LazyActorCoroutine;", "E", "Lkotlinx/coroutines/channels/ActorCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "channel", "Lkotlinx/coroutines/channels/Channel;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ActorScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function2;)V", "continuation", "onStart", "send", "element", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "offer", "", "(Ljava/lang/Object;)Z", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "close", "cause", "", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "getOnSend$annotations", "()V", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSendRegFunction", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class LazyActorCoroutine extends ActorCoroutine {
    private Continuation continuation;

    public LazyActorCoroutine(CoroutineContext arg2, Channel arg3, Function2 arg4) {
        super(arg2, arg3, false);
        this.continuation = IntrinsicsKt.createCoroutineUnintercepted(arg4, this, this);
    }

    public static final void access$onSendRegFunction(LazyActorCoroutine arg0, SelectInstance arg1, Object arg2) {
        arg0.onSendRegFunction(arg1, arg2);
    }

    public boolean close(Throwable arg1) {
        boolean v1 = super.close(arg1);
        this.start();
        return v1;
    }

    public SelectClause2 getOnSend() {
        LazyActorCoroutine$onSend$1 v1 = LazyActorCoroutine$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        return new SelectClause2Impl(this, TypeIntrinsics.beforeCheckcastToFunctionOfArity(v1, 3), super.getOnSend().getProcessResFunc(), null, 8, null);
    }

    public static void getOnSend$annotations() {
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in the favour of \'trySend\' method", replaceWith="<_subannotation>") public boolean offer(Object arg1) {
        this.start();
        return super.offer(arg1);
    }

    private final void onSendRegFunction(SelectInstance arg2, Object arg3) {
        this.onStart();
        super.getOnSend().getRegFunc().invoke(this, arg2, arg3);
    }

    protected void onStart() {
        CancellableKt.startCoroutineCancellable(this.continuation, ((Continuation)this));
    }

    public Object send(Object arg1, Continuation arg2) {
        this.start();
        Object v0 = super.send(arg1, arg2);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }

    public Object trySend-JP2dKIU(Object arg1) {
        this.start();
        return super.trySend-JP2dKIU(arg1);
    }
}

