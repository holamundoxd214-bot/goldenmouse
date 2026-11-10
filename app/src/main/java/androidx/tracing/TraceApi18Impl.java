package androidx.tracing;

import android.os.Trace;

final class TraceApi18Impl {
    private TraceApi18Impl() {
        super();
    }

    public static void beginSection(String arg0) {
        Trace.beginSection(arg0);
    }

    public static void endSection() {
        Trace.endSection();
    }
}

