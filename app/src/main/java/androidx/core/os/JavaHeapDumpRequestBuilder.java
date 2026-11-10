package androidx.core.os;

import android.os.Bundle;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001A\u00020\u0005H\u0015J\b\u0010\u0007\u001A\u00020\bH\u0015J\b\u0010\t\u001A\u00020\u0000H\u0015J\u000E\u0010\n\u001A\u00020\u00002\u0006\u0010\u000B\u001A\u00020\bR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Landroidx/core/os/JavaHeapDumpRequestBuilder;", "Landroidx/core/os/ProfilingRequestBuilder;", "<init>", "()V", "mParams", "Landroid/os/Bundle;", "getParams", "getProfilingType", "", "getThis", "setBufferSizeKb", "bufferSizeKb", "core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class JavaHeapDumpRequestBuilder extends ProfilingRequestBuilder {
    private final Bundle mParams;

    public JavaHeapDumpRequestBuilder() {
        super();
        this.mParams = new Bundle();
    }

    protected Bundle getParams() {
        return this.mParams;
    }

    protected int getProfilingType() {
        return 1;
    }

    protected JavaHeapDumpRequestBuilder getThis() {
        return this;
    }

    public ProfilingRequestBuilder getThis() {
        return this.getThis();
    }

    public final JavaHeapDumpRequestBuilder setBufferSizeKb(int arg3) {
        this.mParams.putInt("KEY_SIZE_KB", arg3);
        return this;
    }
}

