package androidx.core.os;

import android.content.Context;
import android.os.ProfilingManager;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001A\u0016\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000B2\u0006\u0010\r\u001A\u00020\u000EH\u0007\u001A&\u0010\n\u001A\u00020\u000F2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\u00112\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\f0\u0013H\u0007\u001A\u001E\u0010\u0014\u001A\u00020\u000F2\u0006\u0010\r\u001A\u00020\u000E2\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\f0\u0013H\u0007\u001A2\u0010\u0015\u001A\u00020\u000F2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0016\u001A\u00020\u00172\b\u0010\u0010\u001A\u0004\u0018\u00010\u00112\u000E\u0010\u0012\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0013H\u0007\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0003\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0004\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0005\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0006\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0007\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\t\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"KEY_DURATION_MS", "", "KEY_SAMPLING_INTERVAL_BYTES", "KEY_TRACK_JAVA_ALLOCATIONS", "KEY_FREQUENCY_HZ", "KEY_SIZE_KB", "KEY_BUFFER_FILL_POLICY", "VALUE_BUFFER_FILL_POLICY_DISCARD", "", "VALUE_BUFFER_FILL_POLICY_RING_BUFFER", "registerForAllProfilingResults", "Lkotlinx/coroutines/flow/Flow;", "Landroid/os/ProfilingResult;", "context", "Landroid/content/Context;", "", "executor", "Ljava/util/concurrent/Executor;", "listener", "Ljava/util/function/Consumer;", "unregisterForAllProfilingResults", "requestProfiling", "profilingRequest", "Landroidx/core/os/ProfilingRequest;", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class Profiling {
    private static final String KEY_BUFFER_FILL_POLICY = "KEY_BUFFER_FILL_POLICY";
    private static final String KEY_DURATION_MS = "KEY_DURATION_MS";
    private static final String KEY_FREQUENCY_HZ = "KEY_FREQUENCY_HZ";
    private static final String KEY_SAMPLING_INTERVAL_BYTES = "KEY_SAMPLING_INTERVAL_BYTES";
    private static final String KEY_SIZE_KB = "KEY_SIZE_KB";
    private static final String KEY_TRACK_JAVA_ALLOCATIONS = "KEY_TRACK_JAVA_ALLOCATIONS";
    private static final int VALUE_BUFFER_FILL_POLICY_DISCARD = 1;
    private static final int VALUE_BUFFER_FILL_POLICY_RING_BUFFER = 2;

    public static final Flow registerForAllProfilingResults(Context arg2) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        return FlowKt.callbackFlow(new Profiling$registerForAllProfilingResults$1(arg2, null));
    }

    public static final void registerForAllProfilingResults(Context arg1, Executor arg2, Consumer arg3) {
        Intrinsics.checkNotNullParameter(arg1, "context");
        Intrinsics.checkNotNullParameter(arg2, "executor");
        Intrinsics.checkNotNullParameter(arg3, "listener");
        arg1.getSystemService(ProfilingManager.class).registerForAllProfilingResults(arg2, arg3);
    }

    public static final void requestProfiling(Context arg7, ProfilingRequest arg8, Executor arg9, Consumer arg10) {
        Intrinsics.checkNotNullParameter(arg7, "context");
        Intrinsics.checkNotNullParameter(arg8, "profilingRequest");
        arg7.getSystemService(ProfilingManager.class).requestProfiling(arg8.getProfilingType(), arg8.getParams(), arg8.getTag(), arg8.getCancellationSignal(), arg9, arg10);
    }

    public static final void unregisterForAllProfilingResults(Context arg1, Consumer arg2) {
        Intrinsics.checkNotNullParameter(arg1, "context");
        Intrinsics.checkNotNullParameter(arg2, "listener");
        arg1.getSystemService(ProfilingManager.class).unregisterForAllProfilingResults(arg2);
    }
}

