package androidx.core.os;

import android.os.Bundle;
import android.os.CancellationSignal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u0000*\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002B\t\b\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\t\u001A\u00028\u00002\u0006\u0010\n\u001A\u00020\u0006¢\u0006\u0002\u0010\u000BJ\u0013\u0010\f\u001A\u00028\u00002\u0006\u0010\r\u001A\u00020\b¢\u0006\u0002\u0010\u000EJ\u0006\u0010\u000F\u001A\u00020\u0010J\b\u0010\u0011\u001A\u00020\u0012H%J\r\u0010\u0013\u001A\u00028\u0000H%¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001A\u00020\u0016H%R\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Landroidx/core/os/ProfilingRequestBuilder;", "T", "", "<init>", "()V", "mTag", "", "mCancellationSignal", "Landroid/os/CancellationSignal;", "setTag", "tag", "(Ljava/lang/String;)Landroidx/core/os/ProfilingRequestBuilder;", "setCancellationSignal", "cancellationSignal", "(Landroid/os/CancellationSignal;)Landroidx/core/os/ProfilingRequestBuilder;", "build", "Landroidx/core/os/ProfilingRequest;", "getProfilingType", "", "getThis", "()Landroidx/core/os/ProfilingRequestBuilder;", "getParams", "Landroid/os/Bundle;", "core"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class ProfilingRequestBuilder {
    private CancellationSignal mCancellationSignal;
    private String mTag;

    public ProfilingRequestBuilder() {
        super();
    }

    public final ProfilingRequest build() {
        return new ProfilingRequest(this.getProfilingType(), this.getParams(), this.mTag, this.mCancellationSignal);
    }

    protected abstract Bundle getParams();

    protected abstract int getProfilingType();

    protected abstract ProfilingRequestBuilder getThis();

    public final ProfilingRequestBuilder setCancellationSignal(CancellationSignal arg2) {
        Intrinsics.checkNotNullParameter(arg2, "cancellationSignal");
        this.mCancellationSignal = arg2;
        return this.getThis();
    }

    public final ProfilingRequestBuilder setTag(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "tag");
        this.mTag = arg2;
        return this.getThis();
    }
}

