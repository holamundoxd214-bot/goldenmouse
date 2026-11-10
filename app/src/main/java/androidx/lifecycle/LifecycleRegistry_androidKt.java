package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import kotlin.Metadata;

@Metadata(d1={"\u0000\b\n\u0000\n\u0002\u0010\u000B\n\u0000\u001A\b\u0010\u0000\u001A\u00020\u0001H\u0001¨\u0006\u0002"}, d2={"isMainThread", "", "lifecycle-runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class LifecycleRegistry_androidKt {
    public static final boolean isMainThread() {
        return ArchTaskExecutor.getInstance().isMainThread();
    }
}

