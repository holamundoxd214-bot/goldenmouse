package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\r"}, d2={"Landroidx/compose/foundation/lazy/layout/PriorityTask;", "", "priority", "", "request", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "<init>", "(ILandroidx/compose/foundation/lazy/layout/PrefetchRequest;)V", "getPriority", "()I", "getRequest", "()Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PriorityTask {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007¨\u0006\n"}, d2={"Landroidx/compose/foundation/lazy/layout/PriorityTask$Companion;", "", "<init>", "()V", "Low", "", "getLow", "()I", "High", "getHigh", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getHigh() {
            return PriorityTask.High;
        }

        public final int getLow() {
            return PriorityTask.Low;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final int High;
    private static final int Low;
    private final int priority;
    private final PrefetchRequest request;

    static {
        PriorityTask.Companion = new Companion(null);
        PriorityTask.$stable = 8;
        PriorityTask.High = 1;
    }

    public PriorityTask(int arg1, PrefetchRequest arg2) {
        super();
        this.priority = arg1;
        this.request = arg2;
    }

    public static final int access$getHigh$cp() {
        return PriorityTask.High;
    }

    public static final int access$getLow$cp() {
        return PriorityTask.Low;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final PrefetchRequest getRequest() {
        return this.request;
    }
}

