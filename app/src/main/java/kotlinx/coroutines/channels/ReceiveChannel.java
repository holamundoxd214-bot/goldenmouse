package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.selects.SelectClause1;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u000E\u0010\n\u001A\u00028\u0000H¦@¢\u0006\u0002\u0010\u000BJ\u0016\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00000\u0011H¦@¢\u0006\u0004\b\u0012\u0010\u000BJ\u0015\u0010\u0015\u001A\b\u0012\u0004\u0012\u00028\u00000\u0011H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0018\u001A\b\u0012\u0004\u0012\u00028\u00000\u0019H¦\u0002J\u001F\u0010\u001A\u001A\u00020\u001B2\u0010\b\u0002\u0010\u001C\u001A\n\u0018\u00010\u001Dj\u0004\u0018\u0001`\u001EH&¢\u0006\u0002\u0010\u001FJ\b\u0010\u001A\u001A\u00020\u001BH\u0017J\u0014\u0010\u001A\u001A\u00020\u00042\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010 H\'J\u000F\u0010!\u001A\u0004\u0018\u00018\u0000H\u0017¢\u0006\u0002\u0010\u0017J\u0010\u0010\"\u001A\u0004\u0018\u00018\u0000H\u0097@¢\u0006\u0002\u0010\u000BR\u001A\u0010\u0003\u001A\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001A\u0004\b\u0003\u0010\u0007R\u001A\u0010\b\u001A\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001A\u0004\b\b\u0010\u0007R\u0018\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\rX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u001E\u0010\u0013\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\rX¦\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u000FR\"\u0010#\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\r8VX\u0097\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0006\u001A\u0004\b%\u0010\u000F¨\u0006&"}, d2={"Lkotlinx/coroutines/channels/ReceiveChannel;", "E", "", "isClosedForReceive", "", "isClosedForReceive$annotations", "()V", "()Z", "isEmpty", "isEmpty$annotations", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "receiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "receiveCatching-JP2dKIU", "onReceiveCatching", "getOnReceiveCatching", "tryReceive", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "cancel", "", "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "", "poll", "receiveOrNull", "onReceiveOrNull", "getOnReceiveOrNull$annotations", "getOnReceiveOrNull", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public interface ReceiveChannel {
    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") public static void cancel(ReceiveChannel arg1) {
            arg1.cancel(null);
        }

        public static void cancel$default(ReceiveChannel arg0, CancellationException arg1, int arg2, Object arg3) {
            if(arg3 == null) {
                if((arg2 & 1) != 0) {
                    arg1 = null;
                }

                arg0.cancel(arg1);
                return;
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static boolean cancel$default(ReceiveChannel arg0, Throwable arg1, int arg2, Object arg3) {
            if(arg3 == null) {
                if((arg2 & 1) != 0) {
                    arg1 = null;
                }

                return arg0.cancel(arg1);
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static SelectClause1 getOnReceiveOrNull(ReceiveChannel arg1) {
            Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel<E of kotlinx.coroutines.channels.ReceiveChannel>");
            return ((BufferedChannel)arg1).getOnReceiveOrNull();
        }

        @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in favor of onReceiveCatching extension", replaceWith="<_subannotation>") public static void getOnReceiveOrNull$annotations() {
        }

        public static void isClosedForReceive$annotations() {
        }

        public static void isEmpty$annotations() {
        }

        @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in the favour of \'tryReceive\'. Please note that the provided replacement does not rethrow channel\'s close cause as \'poll\' did, for the precise replacement please refer to the \'poll\' documentation", replaceWith="<_subannotation>") public static Object poll(ReceiveChannel arg1) {
            Object v1 = arg1.tryReceive-PtdJZtk();
            if(ChannelResult.isSuccess-impl(v1)) {
                return ChannelResult.getOrThrow-impl(v1);
            }

            Throwable v1_1 = ChannelResult.exceptionOrNull-impl(v1);
            if(v1_1 == null) {
                return null;
            }

            throw StackTraceRecoveryKt.recoverStackTrace(v1_1);
        }

        @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in favor of \'receiveCatching\'. Please note that the provided replacement does not rethrow channel\'s close cause as \'receiveOrNull\' did, for the detailed replacement please refer to the \'receiveOrNull\' documentation", replaceWith="<_subannotation>") public static Object receiveOrNull(ReceiveChannel arg4, Continuation arg5) {
            Object v4;
            int v2;
            Continuation v0;
            if((arg5 instanceof ReceiveChannel$receiveOrNull$1)) {
                v0 = arg5;
                v2 = 0x80000000;
                if((((ReceiveChannel$receiveOrNull$1)v0).label & v2) != 0) {
                    ((ReceiveChannel$receiveOrNull$1)v0).label -= v2;
                }
                else {
                    goto label_11;
                }
            }
            else {
            label_11:
                ReceiveChannel$receiveOrNull$1 v0_1 = new ReceiveChannel$receiveOrNull$1(arg5);
            }

            Object v5 = ((ReceiveChannel$receiveOrNull$1)v0).result;
            Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            v2 = ((ReceiveChannel$receiveOrNull$1)v0).label;
            if(v2 == 0) {
                ResultKt.throwOnFailure(v5);
                ((ReceiveChannel$receiveOrNull$1)v0).label = 1;
                v4 = arg4.receiveCatching-JP2dKIU(v0);
                if(v4 == v1) {
                    return v1;
                }
            }
            else if(v2 == 1) {
                ResultKt.throwOnFailure(v5);
                v4 = ((ChannelResult)v5).unbox-impl();
            }
            else {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }

            return ChannelResult.getOrNull-impl(v4);
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") void cancel();

    void cancel(CancellationException arg1);

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") boolean cancel(Throwable arg1);

    SelectClause1 getOnReceive();

    SelectClause1 getOnReceiveCatching();

    SelectClause1 getOnReceiveOrNull();

    boolean isClosedForReceive();

    boolean isEmpty();

    ChannelIterator iterator();

    @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in the favour of \'tryReceive\'. Please note that the provided replacement does not rethrow channel\'s close cause as \'poll\' did, for the precise replacement please refer to the \'poll\' documentation", replaceWith="<_subannotation>") Object poll();

    Object receive(Continuation arg1);

    Object receiveCatching-JP2dKIU(Continuation arg1);

    @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in favor of \'receiveCatching\'. Please note that the provided replacement does not rethrow channel\'s close cause as \'receiveOrNull\' did, for the detailed replacement please refer to the \'receiveOrNull\' documentation", replaceWith="<_subannotation>") Object receiveOrNull(Continuation arg1);

    Object tryReceive-PtdJZtk();
}

