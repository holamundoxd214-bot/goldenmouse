package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000B¨\u0006\f"}, d2={"Landroidx/compose/foundation/gestures/DragEvent;", "", "<init>", "()V", "DragStarted", "DragStopped", "DragCancelled", "DragDelta", "Landroidx/compose/foundation/gestures/DragEvent$DragCancelled;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Landroidx/compose/foundation/gestures/DragEvent$DragStarted;", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class DragEvent {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Landroidx/compose/foundation/gestures/DragEvent$DragCancelled;", "Landroidx/compose/foundation/gestures/DragEvent;", "<init>", "()V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DragCancelled extends DragEvent {
        public static final int $stable;
        public static final DragCancelled INSTANCE;

        static {
            DragCancelled.INSTANCE = new DragCancelled();
        }

        private DragCancelled() {
            super(null);
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\u000B¨\u0006\f"}, d2={"Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Landroidx/compose/foundation/gestures/DragEvent;", "delta", "Landroidx/compose/ui/geometry/Offset;", "isIndirectPointerEvent", "", "<init>", "(JZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDelta-F1C5BW0", "()J", "J", "()Z", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DragDelta extends DragEvent {
        public static final int $stable;
        private final long delta;
        private final boolean isIndirectPointerEvent;

        static {
        }

        public DragDelta(long arg1, boolean arg3, DefaultConstructorMarker arg4) {
            this(arg1, arg3);
        }

        private DragDelta(long arg2, boolean arg4) {
            super(null);
            this.delta = arg2;
            this.isIndirectPointerEvent = arg4;
        }

        public final long getDelta-F1C5BW0() {
            return this.delta;
        }

        public final boolean isIndirectPointerEvent() {
            return this.isIndirectPointerEvent;
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2={"Landroidx/compose/foundation/gestures/DragEvent$DragStarted;", "Landroidx/compose/foundation/gestures/DragEvent;", "startPoint", "Landroidx/compose/ui/geometry/Offset;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStartPoint-F1C5BW0", "()J", "J", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DragStarted extends DragEvent {
        public static final int $stable;
        private final long startPoint;

        static {
        }

        public DragStarted(long arg1, DefaultConstructorMarker arg3) {
            this(arg1);
        }

        private DragStarted(long arg2) {
            super(null);
            this.startPoint = arg2;
        }

        public final long getStartPoint-F1C5BW0() {
            return this.startPoint;
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\u000B¨\u0006\f"}, d2={"Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "Landroidx/compose/foundation/gestures/DragEvent;", "velocity", "Landroidx/compose/ui/unit/Velocity;", "isIndirectPointerEvent", "", "<init>", "(JZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getVelocity-9UxMQ8M", "()J", "J", "()Z", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DragStopped extends DragEvent {
        public static final int $stable;
        private final boolean isIndirectPointerEvent;
        private final long velocity;

        static {
        }

        public DragStopped(long arg1, boolean arg3, DefaultConstructorMarker arg4) {
            this(arg1, arg3);
        }

        private DragStopped(long arg2, boolean arg4) {
            super(null);
            this.velocity = arg2;
            this.isIndirectPointerEvent = arg4;
        }

        public final long getVelocity-9UxMQ8M() {
            return this.velocity;
        }

        public final boolean isIndirectPointerEvent() {
            return this.isIndirectPointerEvent;
        }
    }

    public static final int $stable;

    static {
    }

    private DragEvent() {
        super();
    }

    public DragEvent(DefaultConstructorMarker arg1) {
        this();
    }
}

