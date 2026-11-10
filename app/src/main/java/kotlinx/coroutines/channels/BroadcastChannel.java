package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Deprecated(level=DeprecationLevel.ERROR, message="BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported") @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\u0010\u0003\n\u0000\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u000E\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004H&J\u001F\u0010\u0005\u001A\u00020\u00062\u0010\b\u0002\u0010\u0007\u001A\n\u0018\u00010\bj\u0004\u0018\u0001`\tH&¢\u0006\u0002\u0010\nJ\u0014\u0010\u0005\u001A\u00020\u000B2\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\fH\'¨\u0006\r"}, d2={"Lkotlinx/coroutines/channels/BroadcastChannel;", "E", "Lkotlinx/coroutines/channels/SendChannel;", "openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", "cancel", "", "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public interface BroadcastChannel extends SendChannel {
    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class DefaultImpls {
        public static void cancel$default(BroadcastChannel arg0, CancellationException arg1, int arg2, Object arg3) {
            if(arg3 == null) {
                if((arg2 & 1) != 0) {
                    arg1 = null;
                }

                arg0.cancel(arg1);
                return;
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static boolean cancel$default(BroadcastChannel arg0, Throwable arg1, int arg2, Object arg3) {
            if(arg3 == null) {
                if((arg2 & 1) != 0) {
                    arg1 = null;
                }

                return arg0.cancel(arg1);
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in the favour of \'trySend\' method", replaceWith="<_subannotation>") public static boolean offer(BroadcastChannel arg0, Object arg1) {
            return kotlinx.coroutines.channels.SendChannel$DefaultImpls.offer(((SendChannel)arg0), arg1);
        }
    }

    void cancel(CancellationException arg1);

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility only") boolean cancel(Throwable arg1);

    ReceiveChannel openSubscription();
}

