package androidx.compose.runtime.internal;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u000E\u001A\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u000FJ\u0015\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0013R \u0010\u0005\u001A\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001A\u00060\u0002j\u0002`\u000BX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0012\u0010\r\u001A\u0004\u0018\u00018\u0000X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0014"}, d2={"Landroidx/compose/runtime/internal/SnapshotThreadLocal;", "T", "", "<init>", "()V", "map", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/internal/ThreadMap;", "Landroidx/compose/runtime/internal/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "writeMutex", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "mainThreadValue", "get", "()Ljava/lang/Object;", "set", "", "value", "(Ljava/lang/Object;)V", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SnapshotThreadLocal {
    public static final int $stable = 8;
    private Object mainThreadValue;
    private final AtomicReference map;
    private final Object writeMutex;

    static {
    }

    public SnapshotThreadLocal() {
        super();
        this.map = new AtomicReference(SnapshotThreadLocalKt.access$getEmptyThreadMap$p());
        this.writeMutex = new Object();
    }

    public final Object get() {
        long v0 = Thread_jvmKt.currentThreadId();
        if(v0 == Thread_androidKt.getMainThreadId()) {
            return this.mainThreadValue;
        }

        return this.map.get().get(v0);
    }

    public final void set(Object arg6) {
        Object v3;
        long v0 = Thread_jvmKt.currentThreadId();
        if(v0 == Thread_androidKt.getMainThreadId()) {
            this.mainThreadValue = arg6;
            return;
        }

        Object v2 = this.writeMutex;
        __monitor_enter(v2);
        try {
            v3 = this.map.get();
            if(!((ThreadMap)v3).trySet(v0, arg6)) {
                goto label_13;
            }
        }
        catch(Throwable v5) {
            goto label_20;
        }

        __monitor_exit(v2);
        return;
        try {
        label_13:
            this.map.set(((ThreadMap)v3).newWith(v0, arg6));
        }
        catch(Throwable v5) {
        label_20:
            __monitor_exit(v2);
            throw v5;
        }

        __monitor_exit(v2);
    }
}

