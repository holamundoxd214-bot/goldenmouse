package androidx.compose.runtime.internal;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001A\u00020\u0006J\u0010\u0010\u0007\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\u0001¨\u0006\n"}, d2={"Landroidx/compose/runtime/internal/Trace;", "", "<init>", "()V", "beginSection", "name", "", "endSection", "", "token", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Trace {
    public static final int $stable;
    public static final Trace INSTANCE;

    static {
        Trace.INSTANCE = new Trace();
    }

    private Trace() {
        super();
    }

    public final Object beginSection(String arg1) {
        android.os.Trace.beginSection(arg1);
        return null;
    }

    public final void endSection(Object arg1) {
        android.os.Trace.endSection();
    }
}

