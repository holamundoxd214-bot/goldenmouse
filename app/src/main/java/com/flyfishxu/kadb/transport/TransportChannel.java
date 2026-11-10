package com.flyfishxu.kadb.transport;

import java.io.Closeable;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J&\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH¦@¢\u0006\u0002\u0010\nJ&\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH¦@¢\u0006\u0002\u0010\nJ&\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH¦@¢\u0006\u0002\u0010\nJ&\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH¦@¢\u0006\u0002\u0010\nJ\u000E\u0010\u0010\u001A\u00020\u000EH¦@¢\u0006\u0002\u0010\u0011J\u000E\u0010\u0012\u001A\u00020\u000EH¦@¢\u0006\u0002\u0010\u0011R\u0012\u0010\u0013\u001A\u00020\u0014X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001A\u00020\u0014X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0016R\u0012\u0010\u0019\u001A\u00020\u001AX¦\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001B¨\u0006\u001CÀ\u0006\u0003"}, d2={"Lcom/flyfishxu/kadb/transport/TransportChannel;", "Ljava/io/Closeable;", "read", "", "dst", "Ljava/nio/ByteBuffer;", "timeout", "", "unit", "Ljava/util/concurrent/TimeUnit;", "(Ljava/nio/ByteBuffer;JLjava/util/concurrent/TimeUnit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "write", "src", "readExactly", "", "writeExactly", "shutdownInput", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shutdownOutput", "localAddress", "Ljava/net/InetSocketAddress;", "getLocalAddress", "()Ljava/net/InetSocketAddress;", "remoteAddress", "getRemoteAddress", "isOpen", "", "()Z", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public interface TransportChannel extends Closeable {
    InetSocketAddress getLocalAddress();

    InetSocketAddress getRemoteAddress();

    boolean isOpen();

    Object read(ByteBuffer arg1, long arg2, TimeUnit arg3, Continuation arg4);

    Object readExactly(ByteBuffer arg1, long arg2, TimeUnit arg3, Continuation arg4);

    Object shutdownInput(Continuation arg1);

    Object shutdownOutput(Continuation arg1);

    Object write(ByteBuffer arg1, long arg2, TimeUnit arg3, Continuation arg4);

    Object writeExactly(ByteBuffer arg1, long arg2, TimeUnit arg3, Continuation arg4);
}

