package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.SystemPropsKt;
import kotlinx.coroutines.selects.SelectClause1;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u0004*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0004¨\u0006\u0005"}, d2={"Lkotlinx/coroutines/channels/Channel;", "E", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Factory", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public interface Channel extends ReceiveChannel, SendChannel {
    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") public static void cancel(Channel arg0) {
            kotlinx.coroutines.channels.ReceiveChannel$DefaultImpls.cancel(((ReceiveChannel)arg0));
        }

        public static SelectClause1 getOnReceiveOrNull(Channel arg0) {
            return kotlinx.coroutines.channels.ReceiveChannel$DefaultImpls.getOnReceiveOrNull(((ReceiveChannel)arg0));
        }

        @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in the favour of \'trySend\' method", replaceWith="<_subannotation>") public static boolean offer(Channel arg0, Object arg1) {
            return kotlinx.coroutines.channels.SendChannel$DefaultImpls.offer(((SendChannel)arg0), arg1);
        }

        @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in the favour of \'tryReceive\'. Please note that the provided replacement does not rethrow channel\'s close cause as \'poll\' did, for the precise replacement please refer to the \'poll\' documentation", replaceWith="<_subannotation>") public static Object poll(Channel arg0) {
            return kotlinx.coroutines.channels.ReceiveChannel$DefaultImpls.poll(((ReceiveChannel)arg0));
        }

        @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in favor of \'receiveCatching\'. Please note that the provided replacement does not rethrow channel\'s close cause as \'receiveOrNull\' did, for the detailed replacement please refer to the \'receiveOrNull\' documentation", replaceWith="<_subannotation>") public static Object receiveOrNull(Channel arg0, Continuation arg1) {
            return kotlinx.coroutines.channels.ReceiveChannel$DefaultImpls.receiveOrNull(((ReceiveChannel)arg0), arg1);
        }
    }

    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001A\u00020\u000B8\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003R\u0014\u0010\r\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2={"Lkotlinx/coroutines/channels/Channel$Factory;", "", "<init>", "()V", "UNLIMITED", "", "RENDEZVOUS", "CONFLATED", "BUFFERED", "OPTIONAL_CHANNEL", "DEFAULT_BUFFER_PROPERTY_NAME", "", "getDEFAULT_BUFFER_PROPERTY_NAME$annotations", "CHANNEL_DEFAULT_CAPACITY", "getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core", "()I", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Factory {
        public static final int BUFFERED = -2;
        private static final int CHANNEL_DEFAULT_CAPACITY = 0;
        public static final int CONFLATED = -1;
        public static final String DEFAULT_BUFFER_PROPERTY_NAME = "kotlinx.coroutines.channels.defaultBuffer";
        public static final int OPTIONAL_CHANNEL = -3;
        public static final int RENDEZVOUS = 0;
        public static final int UNLIMITED = 0x7FFFFFFF;

        static {
            Factory.$$INSTANCE = new Factory();
            Factory.CHANNEL_DEFAULT_CAPACITY = SystemPropsKt.systemProp("kotlinx.coroutines.channels.defaultBuffer", 0x40, 1, 0x7FFFFFFE);
        }

        private Factory() {
            super();
        }

        public final int getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core() {
            return Factory.CHANNEL_DEFAULT_CAPACITY;
        }

        public static void getDEFAULT_BUFFER_PROPERTY_NAME$annotations() {
        }
    }

    public static final int BUFFERED = -2;
    public static final int CONFLATED = -1;
    public static final String DEFAULT_BUFFER_PROPERTY_NAME = "kotlinx.coroutines.channels.defaultBuffer";
    public static final Factory Factory = null;
    public static final int OPTIONAL_CHANNEL = -3;
    public static final int RENDEZVOUS = 0;
    public static final int UNLIMITED = 0x7FFFFFFF;

    static {
        Channel.Factory = Factory.$$INSTANCE;
    }
}

