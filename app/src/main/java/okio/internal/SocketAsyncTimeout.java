package okio.internal;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.AsyncTimeout;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0014J\b\u0010\t\u001A\u00020\nH\u0014R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Lokio/internal/SocketAsyncTimeout;", "Lokio/AsyncTimeout;", "socket", "Ljava/net/Socket;", "<init>", "(Ljava/net/Socket;)V", "newTimeoutException", "Ljava/io/IOException;", "cause", "timedOut", "", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SocketAsyncTimeout extends AsyncTimeout {
    private final Socket socket;

    public SocketAsyncTimeout(Socket arg2) {
        Intrinsics.checkNotNullParameter(arg2, "socket");
        super();
        this.socket = arg2;
    }

    protected IOException newTimeoutException(IOException arg2) {
        SocketTimeoutException v1 = new SocketTimeoutException("timeout");
        if(arg2 != null) {
            v1.initCause(((Throwable)arg2));
        }

        return ((IOException)v1);
    }

    protected void timedOut() {
        String v0 = "Failed to close timed out socket ";
        try {
            this.socket.close();
            return;
        }
        catch(AssertionError v1) {
            if(!_JavaIoKt.isAndroidGetsocknameError(v1)) {
                goto label_16;
            }

            _JavaIoKt.access$getLogger$p().log(Level.WARNING, v0 + this.socket, ((Throwable)v1));
        }
        catch(Exception v1_1) {
            _JavaIoKt.access$getLogger$p().log(Level.WARNING, v0 + this.socket, ((Throwable)v1_1));
        }

        return;
    label_16:
        throw v1;
    }
}

