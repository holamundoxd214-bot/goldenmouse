package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000B¨\u0006\f"}, d2={"Landroidx/compose/foundation/gestures/DragDetectionState;", "", "<init>", "()V", "AwaitDown", "AwaitTouchSlop", "AwaitGesturePickup", "Dragging", "Landroidx/compose/foundation/gestures/DragDetectionState$AwaitDown;", "Landroidx/compose/foundation/gestures/DragDetectionState$AwaitGesturePickup;", "Landroidx/compose/foundation/gestures/DragDetectionState$AwaitTouchSlop;", "Landroidx/compose/foundation/gestures/DragDetectionState$Dragging;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) abstract class DragDetectionState {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B\u001B\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000F¨\u0006\u0011"}, d2={"Landroidx/compose/foundation/gestures/DragDetectionState$AwaitDown;", "Landroidx/compose/foundation/gestures/DragDetectionState;", "awaitTouchSlop", "Landroidx/compose/foundation/gestures/DragDetectionState$AwaitDown$AwaitTouchSlop;", "consumedOnInitial", "", "<init>", "(Landroidx/compose/foundation/gestures/DragDetectionState$AwaitDown$AwaitTouchSlop;Z)V", "getAwaitTouchSlop", "()Landroidx/compose/foundation/gestures/DragDetectionState$AwaitDown$AwaitTouchSlop;", "setAwaitTouchSlop", "(Landroidx/compose/foundation/gestures/DragDetectionState$AwaitDown$AwaitTouchSlop;)V", "getConsumedOnInitial", "()Z", "setConsumedOnInitial", "(Z)V", "AwaitTouchSlop", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AwaitDown extends DragDetectionState {
        @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/foundation/gestures/DragDetectionState$AwaitDown$AwaitTouchSlop;", "", "<init>", "(Ljava/lang/String;I)V", "Yes", "No", "NotInitialized", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public enum AwaitTouchSlop {
            public static final enum AwaitTouchSlop No;
            public static final enum AwaitTouchSlop NotInitialized;
            public static final enum AwaitTouchSlop Yes;

            private static final AwaitTouchSlop[] $values() {
                return new AwaitTouchSlop[]{AwaitTouchSlop.Yes, AwaitTouchSlop.No, AwaitTouchSlop.NotInitialized};
            }

            static {
                AwaitTouchSlop.Yes = new AwaitTouchSlop("Yes", 0);
                AwaitTouchSlop.No = new AwaitTouchSlop("No", 1);
                AwaitTouchSlop.NotInitialized = new AwaitTouchSlop("NotInitialized", 2);
                AwaitTouchSlop[] v0 = AwaitTouchSlop.$values();
                AwaitTouchSlop.$VALUES = v0;
                AwaitTouchSlop.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
            }

            private AwaitTouchSlop(String arg1, int arg2) {
                super(arg1, arg2);
            }

            public static EnumEntries getEntries() {
                return AwaitTouchSlop.$ENTRIES;
            }

            public static AwaitTouchSlop valueOf(String arg1) {
                return Enum.valueOf(AwaitTouchSlop.class, arg1);
            }

            public static AwaitTouchSlop[] values() {
                return AwaitTouchSlop.$VALUES.clone();
            }
        }

        public static final int $stable = 8;
        private AwaitTouchSlop awaitTouchSlop;
        private boolean consumedOnInitial;

        static {
        }

        public AwaitDown(AwaitTouchSlop arg1, boolean arg2, int arg3, DefaultConstructorMarker arg4) {
            if((arg3 & 1) != 0) {
                arg1 = AwaitTouchSlop.NotInitialized;
            }

            this(arg1, false);
        }

        public AwaitDown() {
            this(null, false, 3, null);
        }

        public AwaitDown(AwaitTouchSlop arg2, boolean arg3) {
            super(null);
            this.awaitTouchSlop = arg2;
            this.consumedOnInitial = arg3;
        }

        public final AwaitTouchSlop getAwaitTouchSlop() {
            return this.awaitTouchSlop;
        }

        public final boolean getConsumedOnInitial() {
            return this.consumedOnInitial;
        }

        public final void setAwaitTouchSlop(AwaitTouchSlop arg1) {
            this.awaitTouchSlop = arg1;
        }

        public final void setConsumedOnInitial(boolean arg1) {
            this.consumedOnInitial = arg1;
        }
    }

    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u001C\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u001C\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0012\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u001C\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2={"Landroidx/compose/foundation/gestures/DragDetectionState$AwaitGesturePickup;", "Landroidx/compose/foundation/gestures/DragDetectionState;", "initialDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "touchSlopDetector", "Landroidx/compose/foundation/gestures/TouchSlopDetector;", "<init>", "(Landroidx/compose/ui/input/pointer/PointerInputChange;JLandroidx/compose/foundation/gestures/TouchSlopDetector;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getInitialDown", "()Landroidx/compose/ui/input/pointer/PointerInputChange;", "setInitialDown", "(Landroidx/compose/ui/input/pointer/PointerInputChange;)V", "getPointerId-J3iCeTQ", "()J", "setPointerId-0FcD4WY", "(J)V", "J", "getTouchSlopDetector", "()Landroidx/compose/foundation/gestures/TouchSlopDetector;", "setTouchSlopDetector", "(Landroidx/compose/foundation/gestures/TouchSlopDetector;)V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AwaitGesturePickup extends DragDetectionState {
        public static final int $stable = 8;
        private PointerInputChange initialDown;
        private long pointerId;
        private TouchSlopDetector touchSlopDetector;

        static {
        }

        public AwaitGesturePickup(PointerInputChange arg2, long arg3, TouchSlopDetector arg5, int arg6, DefaultConstructorMarker arg7) {
            PointerInputChange v0 = null;
            if((arg6 & 1) != 0) {
                arg2 = v0;
            }

            if((arg6 & 2) != 0) {
                arg3 = PointerId.constructor-impl(0x7FFFFFFFFFFFFFFFL);
            }

            if((arg6 & 4) != 0) {
                arg5 = ((TouchSlopDetector)v0);
            }

            this(arg2, arg3, arg5, null);
        }

        private AwaitGesturePickup(PointerInputChange arg2, long arg3, TouchSlopDetector arg5) {
            super(null);
            this.initialDown = arg2;
            this.pointerId = arg3;
            this.touchSlopDetector = arg5;
        }

        public AwaitGesturePickup(PointerInputChange arg1, long arg2, TouchSlopDetector arg4, DefaultConstructorMarker arg5) {
            this(arg1, arg2, arg4);
        }

        public final PointerInputChange getInitialDown() {
            return this.initialDown;
        }

        public final long getPointerId-J3iCeTQ() {
            return this.pointerId;
        }

        public final TouchSlopDetector getTouchSlopDetector() {
            return this.touchSlopDetector;
        }

        public final void setInitialDown(PointerInputChange arg1) {
            this.initialDown = arg1;
        }

        public final void setPointerId-0FcD4WY(long arg1) {
            this.pointerId = arg1;
        }

        public final void setTouchSlopDetector(TouchSlopDetector arg1) {
            this.touchSlopDetector = arg1;
        }
    }

    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\'\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u001C\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u001C\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0012\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u001A\u0010\u0006\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2={"Landroidx/compose/foundation/gestures/DragDetectionState$AwaitTouchSlop;", "Landroidx/compose/foundation/gestures/DragDetectionState;", "initialDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "verifyConsumptionInFinalPass", "", "<init>", "(Landroidx/compose/ui/input/pointer/PointerInputChange;JZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getInitialDown", "()Landroidx/compose/ui/input/pointer/PointerInputChange;", "setInitialDown", "(Landroidx/compose/ui/input/pointer/PointerInputChange;)V", "getPointerId-J3iCeTQ", "()J", "setPointerId-0FcD4WY", "(J)V", "J", "getVerifyConsumptionInFinalPass", "()Z", "setVerifyConsumptionInFinalPass", "(Z)V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.compose.foundation.gestures.DragDetectionState$AwaitTouchSlop extends DragDetectionState {
        public static final int $stable = 8;
        private PointerInputChange initialDown;
        private long pointerId;
        private boolean verifyConsumptionInFinalPass;

        static {
        }

        public androidx.compose.foundation.gestures.DragDetectionState$AwaitTouchSlop(PointerInputChange arg7, long arg8, boolean arg10, int arg11, DefaultConstructorMarker arg12) {
            if((arg11 & 1) != 0) {
                arg7 = null;
            }

            PointerInputChange v1 = arg7;
            if((arg11 & 2) != 0) {
                arg8 = PointerId.constructor-impl(0x7FFFFFFFFFFFFFFFL);
            }

            this(v1, arg8, false, null);
        }

        private androidx.compose.foundation.gestures.DragDetectionState$AwaitTouchSlop(PointerInputChange arg2, long arg3, boolean arg5) {
            super(null);
            this.initialDown = arg2;
            this.pointerId = arg3;
            this.verifyConsumptionInFinalPass = arg5;
        }

        public androidx.compose.foundation.gestures.DragDetectionState$AwaitTouchSlop(PointerInputChange arg1, long arg2, boolean arg4, DefaultConstructorMarker arg5) {
            this(arg1, arg2, arg4);
        }

        public final PointerInputChange getInitialDown() {
            return this.initialDown;
        }

        public final long getPointerId-J3iCeTQ() {
            return this.pointerId;
        }

        public final boolean getVerifyConsumptionInFinalPass() {
            return this.verifyConsumptionInFinalPass;
        }

        public final void setInitialDown(PointerInputChange arg1) {
            this.initialDown = arg1;
        }

        public final void setPointerId-0FcD4WY(long arg1) {
            this.pointerId = arg1;
        }

        public final void setVerifyConsumptionInFinalPass(boolean arg1) {
            this.verifyConsumptionInFinalPass = arg1;
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001C\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\n\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000B"}, d2={"Landroidx/compose/foundation/gestures/DragDetectionState$Dragging;", "Landroidx/compose/foundation/gestures/DragDetectionState;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPointerId-J3iCeTQ", "()J", "setPointerId-0FcD4WY", "(J)V", "J", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Dragging extends DragDetectionState {
        public static final int $stable = 8;
        private long pointerId;

        static {
        }

        public Dragging(long arg1, int arg3, DefaultConstructorMarker arg4) {
            if((arg3 & 1) != 0) {
                arg1 = PointerId.constructor-impl(0x7FFFFFFFFFFFFFFFL);
            }

            this(arg1, null);
        }

        private Dragging(long arg2) {
            super(null);
            this.pointerId = arg2;
        }

        public Dragging(long arg1, DefaultConstructorMarker arg3) {
            this(arg1);
        }

        public final long getPointerId-J3iCeTQ() {
            return this.pointerId;
        }

        public final void setPointerId-0FcD4WY(long arg1) {
            this.pointerId = arg1;
        }
    }

    private DragDetectionState() {
        super();
    }

    public DragDetectionState(DefaultConstructorMarker arg1) {
        this();
    }
}

