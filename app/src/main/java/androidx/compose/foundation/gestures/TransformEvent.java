package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2={"Landroidx/compose/foundation/gestures/TransformEvent;", "", "<init>", "()V", "TransformStarted", "TransformStopped", "TransformDelta", "Landroidx/compose/foundation/gestures/TransformEvent$TransformDelta;", "Landroidx/compose/foundation/gestures/TransformEvent$TransformStarted;", "Landroidx/compose/foundation/gestures/TransformEvent$TransformStopped;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) abstract class TransformEvent {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\n¨\u0006\u000F"}, d2={"Landroidx/compose/foundation/gestures/TransformEvent$TransformDelta;", "Landroidx/compose/foundation/gestures/TransformEvent;", "zoomChange", "", "panChange", "Landroidx/compose/ui/geometry/Offset;", "rotationChange", "<init>", "(FJFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getZoomChange", "()F", "getPanChange-F1C5BW0", "()J", "J", "getRotationChange", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TransformDelta extends TransformEvent {
        public static final int $stable;
        private final long panChange;
        private final float rotationChange;
        private final float zoomChange;

        static {
        }

        private TransformDelta(float arg2, long arg3, float arg5) {
            super(null);
            this.zoomChange = arg2;
            this.panChange = arg3;
            this.rotationChange = arg5;
        }

        public TransformDelta(float arg1, long arg2, float arg4, DefaultConstructorMarker arg5) {
            this(arg1, arg2, arg4);
        }

        public final long getPanChange-F1C5BW0() {
            return this.panChange;
        }

        public final float getRotationChange() {
            return this.rotationChange;
        }

        public final float getZoomChange() {
            return this.zoomChange;
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Landroidx/compose/foundation/gestures/TransformEvent$TransformStarted;", "Landroidx/compose/foundation/gestures/TransformEvent;", "<init>", "()V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TransformStarted extends TransformEvent {
        public static final int $stable;
        public static final TransformStarted INSTANCE;

        static {
            TransformStarted.INSTANCE = new TransformStarted();
        }

        private TransformStarted() {
            super(null);
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Landroidx/compose/foundation/gestures/TransformEvent$TransformStopped;", "Landroidx/compose/foundation/gestures/TransformEvent;", "<init>", "()V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TransformStopped extends TransformEvent {
        public static final int $stable;
        public static final TransformStopped INSTANCE;

        static {
            TransformStopped.INSTANCE = new TransformStopped();
        }

        private TransformStopped() {
            super(null);
        }
    }

    private TransformEvent() {
        super();
    }

    public TransformEvent(DefaultConstructorMarker arg1) {
        this();
    }
}

