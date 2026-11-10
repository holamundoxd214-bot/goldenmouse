package com.TryJeanPc.goldenmouse.stretch.backend;

import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000BJ\u0006\u0010\f\u001A\u00020\rR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/LimitedQueryOutput;", "", "<init>", "()V", "bytes", "Ljava/io/ByteArrayOutputStream;", "append", "", "chunk", "", "count", "", "text", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class LimitedQueryOutput {
    private final ByteArrayOutputStream bytes;

    public LimitedQueryOutput() {
        super();
        this.bytes = new ByteArrayOutputStream();
    }

    public final void append(byte[] arg3, int arg4) {
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg3, "chunk");
            if(arg4 > 0x10000 - this.bytes.size()) {
                goto label_13;
            }

            this.bytes.write(arg3, 0, arg4);
        }
        catch(Throwable v3) {
            goto label_18;
        }

        __monitor_exit(this);
        return;
        try {
        label_13:
            throw new StretchTransportException(StretchTransportError.OUTPUT_LIMIT);
        label_18:
            __monitor_exit(this);
        }
        catch(Throwable v3) {
            goto label_18;
        }

        throw v3;
    }

    public static void append$default(LimitedQueryOutput arg0, byte[] arg1, int arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = arg1.length;
        }

        arg0.append(arg1, arg2);
    }

    public final String text() {
        String v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.bytes.toString("UTF-8");
            Intrinsics.checkNotNullExpressionValue(v0_1, "toString(...)");
        }
        catch(Throwable v0) {
            try {
            label_9:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_9;
            }

            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }
}

