package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.selects.SelectClause2;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u0016\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00028\u0000H¦@¢\u0006\u0002\u0010\u000BJ\u001D\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\t0\u00112\u0006\u0010\n\u001A\u00028\u0000H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0014\u001A\u00020\u00042\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u0016H&J-\u0010\u0017\u001A\u00020\t2#\u0010\u0018\u001A\u001F\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\t0\u0019H&J\u0015\u0010\u001C\u001A\u00020\u00042\u0006\u0010\n\u001A\u00028\u0000H\u0017¢\u0006\u0002\u0010\u001DR\u001A\u0010\u0003\u001A\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001A\u0004\b\u0003\u0010\u0007R$\u0010\f\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\rX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001E"}, d2={"Lkotlinx/coroutines/channels/SendChannel;", "E", "", "isClosedForSend", "", "isClosedForSend$annotations", "()V", "()Z", "send", "", "element", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "close", "cause", "", "invokeOnClose", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "offer", "(Ljava/lang/Object;)Z", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public interface SendChannel {
    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class DefaultImpls {
        public static boolean close$default(SendChannel arg0, Throwable arg1, int arg2, Object arg3) {
            if(arg3 == null) {
                if((arg2 & 1) != 0) {
                    arg1 = null;
                }

                return arg0.close(arg1);
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }

        public static void isClosedForSend$annotations() {
        }

        @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in the favour of \'trySend\' method", replaceWith="<_subannotation>") public static boolean offer(SendChannel arg0, Object arg1) {
            Object v0 = arg0.trySend-JP2dKIU(arg1);
            if(ChannelResult.isSuccess-impl(v0)) {
                return 1;
            }

            Throwable v0_1 = ChannelResult.exceptionOrNull-impl(v0);
            if(v0_1 == null) {
                return 0;
            }

            throw StackTraceRecoveryKt.recoverStackTrace(v0_1);
        }
    }

    boolean close(Throwable arg1);

    SelectClause2 getOnSend();

    void invokeOnClose(Function1 arg1);

    boolean isClosedForSend();

    @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in the favour of \'trySend\' method", replaceWith="<_subannotation>") boolean offer(Object arg1);

    Object send(Object arg1, Continuation arg2);

    Object trySend-JP2dKIU(Object arg1);
}

