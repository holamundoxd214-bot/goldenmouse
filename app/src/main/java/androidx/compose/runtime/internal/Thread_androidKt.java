package androidx.compose.runtime.internal;

import android.os.Looper;
import kotlin.Metadata;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\"\u0014\u0010\u0000\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"MainThreadId", "", "getMainThreadId", "()J", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class Thread_androidKt {
    private static final long MainThreadId;

    static {
        long v0;
        try {
            v0 = Looper.getMainLooper().getThread().getId();
        }
        catch(Exception ) {
            v0 = -1;
        }

        Thread_androidKt.MainThreadId = v0;
    }

    public static final long getMainThreadId() {
        return Thread_androidKt.MainThreadId;
    }
}

