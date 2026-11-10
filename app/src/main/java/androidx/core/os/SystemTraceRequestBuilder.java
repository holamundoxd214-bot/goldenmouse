package androidx.core.os;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001A\u00020\u0005H\u0015J\b\u0010\u0007\u001A\u00020\bH\u0015J\b\u0010\t\u001A\u00020\u0000H\u0015J\u000E\u0010\n\u001A\u00020\u00002\u0006\u0010\u000B\u001A\u00020\bJ\u000E\u0010\f\u001A\u00020\u00002\u0006\u0010\r\u001A\u00020\bJ\u000E\u0010\u000E\u001A\u00020\u00002\u0006\u0010\u000F\u001A\u00020\u0010R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"Landroidx/core/os/SystemTraceRequestBuilder;", "Landroidx/core/os/ProfilingRequestBuilder;", "<init>", "()V", "mParams", "Landroid/os/Bundle;", "getParams", "getProfilingType", "", "getThis", "setBufferSizeKb", "bufferSizeKb", "setDurationMs", "durationMs", "setBufferFillPolicy", "bufferFillPolicy", "Landroidx/core/os/BufferFillPolicy;", "core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SystemTraceRequestBuilder extends ProfilingRequestBuilder {
    private final Bundle mParams;

    public SystemTraceRequestBuilder() {
        super();
        this.mParams = new Bundle();
    }

    protected Bundle getParams() {
        return this.mParams;
    }

    protected int getProfilingType() {
        return 4;
    }

    public ProfilingRequestBuilder getThis() {
        return this.getThis();
    }

    protected SystemTraceRequestBuilder getThis() {
        return this;
    }

    public final SystemTraceRequestBuilder setBufferFillPolicy(BufferFillPolicy arg3) {
        Intrinsics.checkNotNullParameter(arg3, "bufferFillPolicy");
        this.mParams.putInt("KEY_BUFFER_FILL_POLICY", arg3.getValue$core());
        return this;
    }

    public final SystemTraceRequestBuilder setBufferSizeKb(int arg3) {
        this.mParams.putInt("KEY_SIZE_KB", arg3);
        return this;
    }

    public final SystemTraceRequestBuilder setDurationMs(int arg3) {
        this.mParams.putInt("KEY_DURATION_MS", arg3);
        return this;
    }
}

