package androidx.compose.foundation.gestures.snapping;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\bg\u0018\u00002\u00020\u0001:\u0003\n\u000B\fJ8\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2={"Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "", "position", "", "layoutSize", "itemSize", "beforeContentPadding", "afterContentPadding", "itemIndex", "itemCount", "Center", "Start", "End", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface SnapPosition {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\u0005H\u0016J\b\u0010\f\u001A\u00020\rH\u0016¨\u0006\u000E"}, d2={"Landroidx/compose/foundation/gestures/snapping/SnapPosition$Center;", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "<init>", "()V", "position", "", "layoutSize", "itemSize", "beforeContentPadding", "afterContentPadding", "itemIndex", "itemCount", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Center implements SnapPosition {
        public static final int $stable;
        public static final Center INSTANCE;

        static {
            Center.INSTANCE = new Center();
        }

        private Center() {
            super();
        }

        public int position(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
            return (arg1 - arg3 - arg4) / 2 - arg2 / 2;
        }

        public String toString() {
            return "Center";
        }
    }

    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\u0005H\u0016J\b\u0010\f\u001A\u00020\rH\u0016¨\u0006\u000E"}, d2={"Landroidx/compose/foundation/gestures/snapping/SnapPosition$End;", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "<init>", "()V", "position", "", "layoutSize", "itemSize", "beforeContentPadding", "afterContentPadding", "itemIndex", "itemCount", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class End implements SnapPosition {
        public static final int $stable;
        public static final End INSTANCE;

        static {
            End.INSTANCE = new End();
        }

        private End() {
            super();
        }

        public int position(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
            return arg1 - arg3 - arg4 - arg2;
        }

        public String toString() {
            return "End";
        }
    }

    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\u0005H\u0016J\b\u0010\f\u001A\u00020\rH\u0016¨\u0006\u000E"}, d2={"Landroidx/compose/foundation/gestures/snapping/SnapPosition$Start;", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "<init>", "()V", "position", "", "layoutSize", "itemSize", "beforeContentPadding", "afterContentPadding", "itemIndex", "itemCount", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Start implements SnapPosition {
        public static final int $stable;
        public static final Start INSTANCE;

        static {
            Start.INSTANCE = new Start();
        }

        private Start() {
            super();
        }

        public int position(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
            return 0;
        }

        public String toString() {
            return "Start";
        }
    }

    int position(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6);
}

