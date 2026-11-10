package com.TryJeanPc.goldenmouse.stretch.backend;

import com.flyfishxu.kadb.shell.AdbShellPacket$Exit;
import com.flyfishxu.kadb.shell.AdbShellPacket$StdError;
import com.flyfishxu.kadb.shell.AdbShellPacket$StdOut;
import com.flyfishxu.kadb.shell.AdbShellPacket;
import com.flyfishxu.kadb.shell.AdbShellStream;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001A\u00020\tH\u0016J\b\u0010\n\u001A\u00020\u000BH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/KadbQueryChannel;", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryChannel;", "stream", "Lcom/flyfishxu/kadb/shell/AdbShellStream;", "<init>", "(Lcom/flyfishxu/kadb/shell/AdbShellStream;)V", "closed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "collect", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchRawResponse;", "close", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class KadbQueryChannel implements StretchQueryChannel {
    private final AtomicBoolean closed;
    private final AdbShellStream stream;

    public KadbQueryChannel(AdbShellStream arg2) {
        Intrinsics.checkNotNullParameter(arg2, "stream");
        super();
        this.stream = arg2;
        this.closed = new AtomicBoolean(false);
    }

    public void close() {
        if(this.closed.compareAndSet(false, true)) {
            this.stream.close();
        }
    }

    public StretchRawResponse collect() {
        StretchTransportError v0_2;
        Exception v3_1;
        LimitedQueryOutput v1 = new LimitedQueryOutput();
        LimitedQueryOutput v2 = new LimitedQueryOutput();
        while(true) {
            Object v3 = null;
            try {
                AdbShellPacket v0_1 = this.stream.read();
                int v5 = 2;
                if((v0_1 instanceof StdOut)) {
                    LimitedQueryOutput.append$default(v1, ((StdOut)v0_1).getPayload(), 0, v5, v3);
                    continue;
                }

                if((v0_1 instanceof StdError)) {
                    LimitedQueryOutput.append$default(v2, ((StdError)v0_1).getPayload(), 0, v5, v3);
                    continue;
                }

                if((v0_1 instanceof Exit)) {
                    if(v0_1.getPayload().length == 1) {
                        return new StretchRawResponse(v1.text(), v2.text(), Integer.valueOf(((Exit)v0_1).getPayload()[0] & 0xFF), false, null, 24, null);
                    }

                    throw new StretchTransportException(StretchTransportError.MALFORMED_RESPONSE);
                }

                throw new NoWhenBranchMatchedException();
            }
            catch(Exception v0) {
                Exception v15 = v0;
                String v5_1 = v1.text();
                String v6 = v2.text();
                if((v15 instanceof StretchTransportException)) {
                    v3_1 = v15;
                }

                if(v3_1 != null) {
                    v0_2 = ((StretchTransportException)v3_1).getReason();
                    if(v0_2 == null) {
                        goto label_60;
                    }
                }
                else {
                label_60:
                    v0_2 = (v15 instanceof IllegalStateException) ? StretchTransportError.MALFORMED_RESPONSE : StretchTransportError.TRANSPORT_FAILURE;
                }

                StretchTransportError v9 = v0_2;
                return new StretchRawResponse(v5_1, v6, null, false, v9);
            }
        }
    }
}

