package com.flyfishxu.kadb.transport;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0086@¢\u0006\u0002\u0010\f¨\u0006\r"}, d2={"Lcom/flyfishxu/kadb/transport/TransportFactory;", "", "<init>", "()V", "connect", "Lcom/flyfishxu/kadb/transport/TransportChannel;", "host", "", "port", "", "connectTimeoutMs", "", "(Ljava/lang/String;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class TransportFactory {
    public static final TransportFactory INSTANCE;

    static {
        TransportFactory.INSTANCE = new TransportFactory();
    }

    private TransportFactory() {
        super();
    }

    public final Object connect(String arg1, int arg2, long arg3, Continuation arg5) {
        return PlainBlockingChannel.Companion.connect(arg1, arg2, arg3);
    }
}

