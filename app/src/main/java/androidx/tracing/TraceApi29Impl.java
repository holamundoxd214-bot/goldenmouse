package androidx.tracing;

import android.os.Trace;

final class TraceApi29Impl {
    private TraceApi29Impl() {
        super();
    }

    public static void beginAsyncSection(String arg0, int arg1) {
        Trace.beginAsyncSection(arg0, arg1);
    }

    public static void endAsyncSection(String arg0, int arg1) {
        Trace.endAsyncSection(arg0, arg1);
    }

    public static boolean isEnabled() {
        return Trace.isEnabled();
    }

    public static void setCounter(String arg2, int arg3) {
        Trace.setCounter(arg2, ((long)arg3));
    }
}

