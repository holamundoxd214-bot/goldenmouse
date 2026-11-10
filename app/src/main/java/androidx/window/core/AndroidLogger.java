package androidx.window.core;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0007H\u0016¨\u0006\t"}, d2={"Landroidx/window/core/AndroidLogger;", "Landroidx/window/core/Logger;", "<init>", "()V", "debug", "", "tag", "", "message", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidLogger implements Logger {
    public static final AndroidLogger INSTANCE;

    static {
        AndroidLogger.INSTANCE = new AndroidLogger();
    }

    private AndroidLogger() {
        super();
    }

    public void debug(String arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg1, "tag");
        Intrinsics.checkNotNullParameter(arg2, "message");
        Log.d(arg1, arg2);
    }
}

