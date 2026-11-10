package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A)\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001A\u0002H\u0003¢\u0006\u0002\u0010\u0006\u001A%\u0010\u0007\u001A\u00020\u0002\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001A\u0002H\u0003H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2={"trySendBlocking", "Lkotlinx/coroutines/channels/ChannelResult;", "", "E", "Lkotlinx/coroutines/channels/SendChannel;", "element", "(Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/Object;)Ljava/lang/Object;", "sendBlocking", "(Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k=5, mv={2, 1, 0}, xi=0x30, xs="kotlinx/coroutines/channels/ChannelsKt") final class ChannelsKt__ChannelsKt {
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Deprecated in the favour of \'trySendBlocking\'. Consider handling the result of \'trySendBlocking\' explicitly and rethrow exception if necessary", replaceWith="<_subannotation>") public static final void sendBlocking(SendChannel arg2, Object arg3) {
        if(ChannelResult.isSuccess-impl(arg2.trySend-JP2dKIU(arg3))) {
            return;
        }

        BuildersKt.runBlocking$default(null, new ChannelsKt__ChannelsKt$sendBlocking$1(arg2, arg3, null), 1, null);
    }

    public static final Object trySendBlocking(SendChannel arg2, Object arg3) {
        if(!(arg2.trySend-JP2dKIU(arg3) instanceof Failed)) {
            return ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
        }

        return BuildersKt.runBlocking$default(null, new ChannelsKt__ChannelsKt$trySendBlocking$2(arg2, arg3, null), 1, null).unbox-impl();
    }
}

