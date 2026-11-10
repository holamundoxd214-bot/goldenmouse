package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2={"Landroidx/compose/foundation/gestures/LongPressResult;", "", "<init>", "()V", "Success", "Released", "Canceled", "Landroidx/compose/foundation/gestures/LongPressResult$Canceled;", "Landroidx/compose/foundation/gestures/LongPressResult$Released;", "Landroidx/compose/foundation/gestures/LongPressResult$Success;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class LongPressResult {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Landroidx/compose/foundation/gestures/LongPressResult$Canceled;", "Landroidx/compose/foundation/gestures/LongPressResult;", "<init>", "()V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Canceled extends LongPressResult {
        public static final int $stable;
        public static final Canceled INSTANCE;

        static {
            Canceled.INSTANCE = new Canceled();
        }

        private Canceled() {
            super(null);
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/foundation/gestures/LongPressResult$Released;", "Landroidx/compose/foundation/gestures/LongPressResult;", "finalUpChange", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "<init>", "(Landroidx/compose/ui/input/pointer/PointerInputChange;)V", "getFinalUpChange", "()Landroidx/compose/ui/input/pointer/PointerInputChange;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Released extends LongPressResult {
        public static final int $stable;
        private final PointerInputChange finalUpChange;

        static {
        }

        public Released(PointerInputChange arg2) {
            super(null);
            this.finalUpChange = arg2;
        }

        public final PointerInputChange getFinalUpChange() {
            return this.finalUpChange;
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Landroidx/compose/foundation/gestures/LongPressResult$Success;", "Landroidx/compose/foundation/gestures/LongPressResult;", "<init>", "()V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Success extends LongPressResult {
        public static final int $stable;
        public static final Success INSTANCE;

        static {
            Success.INSTANCE = new Success();
        }

        private Success() {
            super(null);
        }
    }

    public static final int $stable;

    static {
    }

    private LongPressResult() {
        super();
    }

    public LongPressResult(DefaultConstructorMarker arg1) {
        this();
    }
}

