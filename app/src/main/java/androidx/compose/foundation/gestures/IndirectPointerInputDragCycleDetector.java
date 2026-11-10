package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.indirect.IndirectPointerEvent;
import androidx.compose.ui.input.indirect.IndirectPointerEventPrimaryDirectionalMotionAxis;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.VelocityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u008C\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u0001:\u0001YB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010*\u001A\u00020$H\u0002J\b\u0010+\u001A\u00020\u001FH\u0002J\u0016\u0010,\u001A\u00020-2\u0006\u0010.\u001A\u00020/2\u0006\u00100\u001A\u000201J\u0006\u00102\u001A\u00020-J3\u00103\u001A\u00020-2\u0006\u00104\u001A\u0002052\u0006\u00106\u001A\u0002072\b\b\u0002\u00108\u001A\u00020!2\b\b\u0002\u00109\u001A\u00020:H\u0002¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001A\u00020-2\u0006\u00106\u001A\u000207H\u0002¢\u0006\u0004\b>\u0010?J\b\u0010@\u001A\u00020-H\u0002J\'\u0010A\u001A\u00020-2\u0006\u00104\u001A\u0002052\u0006\u00106\u001A\u0002072\u0006\u0010#\u001A\u00020$H\u0002¢\u0006\u0004\bB\u0010CJ \u0010D\u001A\u00020-2\u0006\u0010.\u001A\u00020/2\u0006\u00100\u001A\u0002012\u0006\u0010E\u001A\u00020\tH\u0002J \u0010F\u001A\u00020-2\u0006\u0010.\u001A\u00020/2\u0006\u00100\u001A\u0002012\u0006\u0010E\u001A\u00020\u0013H\u0002J \u0010G\u001A\u00020-2\u0006\u0010.\u001A\u00020/2\u0006\u00100\u001A\u0002012\u0006\u0010E\u001A\u00020\u0018H\u0002J \u0010H\u001A\u00020-2\u0006\u0010.\u001A\u00020/2\u0006\u00100\u001A\u0002012\u0006\u0010E\u001A\u00020\u000EH\u0002J1\u0010I\u001A\u00020-2\u0006\u0010J\u001A\u0002052\u0006\u0010K\u001A\u0002052\b\u0010L\u001A\u0004\u0018\u00010M2\u0006\u0010N\u001A\u00020!H\u0002¢\u0006\u0004\bO\u0010PJ)\u0010Q\u001A\u00020-2\u0006\u0010R\u001A\u0002052\b\u0010L\u001A\u0004\u0018\u00010M2\u0006\u0010S\u001A\u00020!H\u0002¢\u0006\u0004\bT\u0010UJ\u001F\u0010V\u001A\u00020-2\u0006\u0010R\u001A\u0002052\b\u0010L\u001A\u0004\u0018\u00010MH\u0002¢\u0006\u0002\bWJ\b\u0010X\u001A\u00020-H\u0002R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0010\u0010\r\u001A\u0004\u0018\u00010\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u000F\u001A\u00020\u000E8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001A\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001A\u0004\u0018\u00010\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001A\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001BR\u0010\u0010\u001C\u001A\u0004\u0018\u00010\u001DX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001E\u001A\u0004\u0018\u00010\u001FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010 \u001A\u00020!X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\"R\u0010\u0010#\u001A\u0004\u0018\u00010$X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\'\u001A\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001A\u00020!X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\"¨\u0006Z"}, d2={"Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector;", "", "node", "Landroidx/compose/foundation/gestures/DragGestureNode;", "<init>", "(Landroidx/compose/foundation/gestures/DragGestureNode;)V", "getNode", "()Landroidx/compose/foundation/gestures/DragGestureNode;", "_awaitDownState", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown;", "awaitDownState", "getAwaitDownState", "()Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown;", "_draggingState", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging;", "draggingState", "getDraggingState", "()Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging;", "_awaitTouchSlopState", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop;", "awaitTouchSlopState", "getAwaitTouchSlopState", "()Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop;", "_awaitGesturePickupState", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup;", "awaitGesturePickupState", "getAwaitGesturePickupState", "()Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup;", "currentDragState", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState;", "velocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "previousPositionOnScreen", "Landroidx/compose/ui/geometry/Offset;", "J", "touchSlopDetector", "Landroidx/compose/foundation/gestures/TouchSlopDetector;", "touchSmooth", "Landroidx/compose/foundation/gestures/IndirectPointerInputEventSmoother;", "offsetSmoother", "Landroidx/compose/foundation/gestures/OffsetSmoother;", "nodeOffset", "requireTouchSlopDetector", "requireVelocityTracker", "processIndirectPointerInputEvent", "", "indirectPointerInputEvent", "Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "resetDragDetectionState", "moveToAwaitTouchSlopState", "initialDown", "Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "initialTouchSlopPositionChange", "verifyConsumptionInFinalPass", "", "moveToAwaitTouchSlopState-aWI9W7U", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;JJZ)V", "moveToDraggingState", "moveToDraggingState-0FcD4WY", "(J)V", "moveToAwaitDownState", "moveToAwaitGesturePickupState", "moveToAwaitGesturePickupState-rnUCldI", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;JLandroidx/compose/foundation/gestures/TouchSlopDetector;)V", "processInitialDownState", "state", "processAwaitTouchSlop", "processAwaitGesturePickup", "processDraggingState", "sendDragStart", "down", "slopTriggerChange", "primaryDirectionalMotionAxis", "Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;", "overSlopOffset", "sendDragStart-3f7A7Is", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;J)V", "sendDragEvent", "change", "dragAmount", "sendDragEvent-Eu1f8Dk", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;J)V", "sendDragStopped", "sendDragStopped-k92h6UU", "sendDragCancelled", "DragDetectionState", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class IndirectPointerInputDragCycleDetector {
    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000B¨\u0006\f"}, d2={"Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState;", "", "<init>", "()V", "AwaitDown", "AwaitTouchSlop", "AwaitGesturePickup", "Dragging", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown;", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup;", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop;", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class DragDetectionState {
        @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B\u001B\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000F¨\u0006\u0011"}, d2={"Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown;", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState;", "awaitTouchSlop", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown$AwaitTouchSlop;", "consumedOnInitial", "", "<init>", "(Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown$AwaitTouchSlop;Z)V", "getAwaitTouchSlop", "()Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown$AwaitTouchSlop;", "setAwaitTouchSlop", "(Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown$AwaitTouchSlop;)V", "getConsumedOnInitial", "()Z", "setConsumedOnInitial", "(Z)V", "AwaitTouchSlop", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AwaitDown extends DragDetectionState {
            @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown$AwaitTouchSlop;", "", "<init>", "(Ljava/lang/String;I)V", "Yes", "No", "NotInitialized", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public enum AwaitTouchSlop {
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

        @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u001C\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u001C\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0012\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u001C\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2={"Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup;", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState;", "initialDown", "Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "touchSlopDetector", "Landroidx/compose/foundation/gestures/TouchSlopDetector;", "<init>", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;JLandroidx/compose/foundation/gestures/TouchSlopDetector;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getInitialDown", "()Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "setInitialDown", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;)V", "getPointerId-J3iCeTQ", "()J", "setPointerId-0FcD4WY", "(J)V", "J", "getTouchSlopDetector", "()Landroidx/compose/foundation/gestures/TouchSlopDetector;", "setTouchSlopDetector", "(Landroidx/compose/foundation/gestures/TouchSlopDetector;)V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AwaitGesturePickup extends DragDetectionState {
            public static final int $stable = 8;
            private IndirectPointerInputChange initialDown;
            private long pointerId;
            private TouchSlopDetector touchSlopDetector;

            static {
            }

            public AwaitGesturePickup(IndirectPointerInputChange arg2, long arg3, TouchSlopDetector arg5, int arg6, DefaultConstructorMarker arg7) {
                IndirectPointerInputChange v0 = null;
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

            private AwaitGesturePickup(IndirectPointerInputChange arg2, long arg3, TouchSlopDetector arg5) {
                super(null);
                this.initialDown = arg2;
                this.pointerId = arg3;
                this.touchSlopDetector = arg5;
            }

            public AwaitGesturePickup(IndirectPointerInputChange arg1, long arg2, TouchSlopDetector arg4, DefaultConstructorMarker arg5) {
                this(arg1, arg2, arg4);
            }

            public final IndirectPointerInputChange getInitialDown() {
                return this.initialDown;
            }

            public final long getPointerId-J3iCeTQ() {
                return this.pointerId;
            }

            public final TouchSlopDetector getTouchSlopDetector() {
                return this.touchSlopDetector;
            }

            public final void setInitialDown(IndirectPointerInputChange arg1) {
                this.initialDown = arg1;
            }

            public final void setPointerId-0FcD4WY(long arg1) {
                this.pointerId = arg1;
            }

            public final void setTouchSlopDetector(TouchSlopDetector arg1) {
                this.touchSlopDetector = arg1;
            }
        }

        @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\'\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u001C\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u001C\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0012\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u001A\u0010\u0006\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2={"Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop;", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState;", "initialDown", "Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "verifyConsumptionInFinalPass", "", "<init>", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;JZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getInitialDown", "()Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "setInitialDown", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;)V", "getPointerId-J3iCeTQ", "()J", "setPointerId-0FcD4WY", "(J)V", "J", "getVerifyConsumptionInFinalPass", "()Z", "setVerifyConsumptionInFinalPass", "(Z)V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.compose.foundation.gestures.IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop extends DragDetectionState {
            public static final int $stable = 8;
            private IndirectPointerInputChange initialDown;
            private long pointerId;
            private boolean verifyConsumptionInFinalPass;

            static {
            }

            public androidx.compose.foundation.gestures.IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop(IndirectPointerInputChange arg7, long arg8, boolean arg10, int arg11, DefaultConstructorMarker arg12) {
                if((arg11 & 1) != 0) {
                    arg7 = null;
                }

                IndirectPointerInputChange v1 = arg7;
                if((arg11 & 2) != 0) {
                    arg8 = PointerId.constructor-impl(0x7FFFFFFFFFFFFFFFL);
                }

                this(v1, arg8, false, null);
            }

            private androidx.compose.foundation.gestures.IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop(IndirectPointerInputChange arg2, long arg3, boolean arg5) {
                super(null);
                this.initialDown = arg2;
                this.pointerId = arg3;
                this.verifyConsumptionInFinalPass = arg5;
            }

            public androidx.compose.foundation.gestures.IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop(IndirectPointerInputChange arg1, long arg2, boolean arg4, DefaultConstructorMarker arg5) {
                this(arg1, arg2, arg4);
            }

            public final IndirectPointerInputChange getInitialDown() {
                return this.initialDown;
            }

            public final long getPointerId-J3iCeTQ() {
                return this.pointerId;
            }

            public final boolean getVerifyConsumptionInFinalPass() {
                return this.verifyConsumptionInFinalPass;
            }

            public final void setInitialDown(IndirectPointerInputChange arg1) {
                this.initialDown = arg1;
            }

            public final void setPointerId-0FcD4WY(long arg1) {
                this.pointerId = arg1;
            }

            public final void setVerifyConsumptionInFinalPass(boolean arg1) {
                this.verifyConsumptionInFinalPass = arg1;
            }
        }

        @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001C\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\n\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000B"}, d2={"Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging;", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPointerId-J3iCeTQ", "()J", "setPointerId-0FcD4WY", "(J)V", "J", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Dragging extends DragDetectionState {
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

        public static final int $stable;

        static {
        }

        private DragDetectionState() {
            super();
        }

        public DragDetectionState(DefaultConstructorMarker arg1) {
            this();
        }
    }

    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[AwaitTouchSlop.values().length];
            try {
                v0[AwaitTouchSlop.NotInitialized.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
            label_7:
                WhenMappings.$EnumSwitchMapping$0 = v0;
                return;
            }
        }
    }

    public static final int $stable = 8;
    private AwaitDown _awaitDownState;
    private AwaitGesturePickup _awaitGesturePickupState;
    private androidx.compose.foundation.gestures.IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop _awaitTouchSlopState;
    private Dragging _draggingState;
    private DragDetectionState currentDragState;
    private final DragGestureNode node;
    private long nodeOffset;
    private final OffsetSmoother offsetSmoother;
    private long previousPositionOnScreen;
    private TouchSlopDetector touchSlopDetector;
    private final IndirectPointerInputEventSmoother touchSmooth;
    private VelocityTracker velocityTracker;

    static {
    }

    public IndirectPointerInputDragCycleDetector(DragGestureNode arg3) {
        super();
        this.node = arg3;
        this.previousPositionOnScreen = Offset.Companion.getUnspecified-F1C5BW0();
        this.touchSmooth = new IndirectPointerInputEventSmoother();
        this.offsetSmoother = new OffsetSmoother();
        this.nodeOffset = Offset.Companion.getZero-F1C5BW0();
    }

    private final AwaitDown getAwaitDownState() {
        AwaitDown v0 = this._awaitDownState;
        if(v0 == null) {
            v0 = new AwaitDown(null, false, 3, null);
            this._awaitDownState = v0;
        }

        return v0;
    }

    private final AwaitGesturePickup getAwaitGesturePickupState() {
        AwaitGesturePickup v0 = this._awaitGesturePickupState;
        if(v0 == null) {
            AwaitGesturePickup v1 = new AwaitGesturePickup(null, 0, null, 7, null);
            this._awaitGesturePickupState = v1;
            return v1;
        }

        return v0;
    }

    private final androidx.compose.foundation.gestures.IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop getAwaitTouchSlopState() {
        androidx.compose.foundation.gestures.IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop v0 = this._awaitTouchSlopState;
        if(v0 == null) {
            androidx.compose.foundation.gestures.IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop v1 = new androidx.compose.foundation.gestures.IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop(null, 0, false, 7, null);
            this._awaitTouchSlopState = v1;
            return v1;
        }

        return v0;
    }

    private final Dragging getDraggingState() {
        Dragging v0 = this._draggingState;
        if(v0 == null) {
            v0 = new Dragging(0, 1, null);
            this._draggingState = v0;
        }

        return v0;
    }

    public final DragGestureNode getNode() {
        return this.node;
    }

    private final void moveToAwaitDownState() {
        AwaitDown v0 = this.getAwaitDownState();
        v0.setAwaitTouchSlop(AwaitTouchSlop.NotInitialized);
        v0.setConsumedOnInitial(false);
        this.currentDragState = ((DragDetectionState)v0);
    }

    private final void moveToAwaitGesturePickupState-rnUCldI(IndirectPointerInputChange arg4, long arg5, TouchSlopDetector arg7) {
        AwaitGesturePickup v0 = this.getAwaitGesturePickupState();
        v0.setInitialDown(arg4);
        v0.setPointerId-0FcD4WY(arg5);
        TouchSlopDetector.reset-k-4lQ0M$default(arg7, 0, 1, null);
        v0.setTouchSlopDetector(arg7);
        this.currentDragState = ((DragDetectionState)v0);
    }

    private final void moveToAwaitTouchSlopState-aWI9W7U(IndirectPointerInputChange arg8, long arg9, long arg11, boolean arg13) {
        androidx.compose.foundation.gestures.IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop v0 = this.getAwaitTouchSlopState();
        v0.setInitialDown(arg8);
        v0.setPointerId-0FcD4WY(arg9);
        TouchSlopDetector v8 = this.touchSlopDetector;
        if(v8 == null) {
            this.touchSlopDetector = new TouchSlopDetector(this.node.getOrientationLock(), 0, 2, null);
        }
        else {
            if(v8 != null) {
                v8.setOrientation(this.node.getOrientationLock());
            }

            v8 = this.touchSlopDetector;
            if(v8 == null) {
                goto label_21;
            }

            v8.reset-k-4lQ0M(arg11);
        }

    label_21:
        v0.setVerifyConsumptionInFinalPass(arg13);
        this.currentDragState = ((DragDetectionState)v0);
    }

    static void moveToAwaitTouchSlopState-aWI9W7U$default(IndirectPointerInputDragCycleDetector arg7, IndirectPointerInputChange arg8, long arg9, long arg11, boolean arg13, int arg14, Object arg15) {
        if((arg14 & 4) != 0) {
            arg11 = Offset.Companion.getZero-F1C5BW0();
        }

        arg7.moveToAwaitTouchSlopState-aWI9W7U(arg8, arg9, arg11, false);
    }

    private final void moveToDraggingState-0FcD4WY(long arg2) {
        Dragging v0 = this.getDraggingState();
        v0.setPointerId-0FcD4WY(arg2);
        this.currentDragState = ((DragDetectionState)v0);
    }

    private final void processAwaitGesturePickup(IndirectPointerEvent arg12, PointerEventPass arg13, AwaitGesturePickup arg14) {
        int v13_1;
        if(arg13 != PointerEventPass.Final) {
        }
        else {
            List v13 = arg12.getChanges();
            int v0 = v13.size();
            int v1 = 0;
            int v2 = 0;
            while(true) {
                if(v2 >= v0) {
                    break;
                }
                else if(v13.get(v2).isConsumed()) {
                    v13_1 = 0;
                }
                else {
                    ++v2;
                    continue;
                }

                goto label_17;
            }

            v13_1 = 1;
        label_17:
            List v0_1 = arg12.getChanges();
            v2 = v0_1.size();
            while(v1 < v2) {
                if(!v0_1.get(v1).getPressed()) {
                    ++v1;
                    continue;
                }
                else if(arg12.getChanges().isEmpty()) {
                }
                else if(v13_1 != 0) {
                    long v0_2 = IndirectPointerInputDragCycleDetectorKt.access$primaryAxisPosition-_bfSUIo(CollectionsKt.first(arg12.getChanges()), this.node.getOrientationLock(), IndirectPointerEventPrimaryDirectionalMotionAxis.box-impl(arg12.getPrimaryDirectionalMotionAxis-nZO2Niw()));
                    IndirectPointerInputChange v13_2 = arg14.getInitialDown();
                    Intrinsics.checkNotNull(v13_2);
                    long v6 = Offset.minus-MK-Hz9U(v0_2, IndirectPointerInputDragCycleDetectorKt.access$primaryAxisPosition-_bfSUIo(v13_2, this.node.getOrientationLock(), IndirectPointerEventPrimaryDirectionalMotionAxis.box-impl(arg12.getPrimaryDirectionalMotionAxis-nZO2Niw())));
                    IndirectPointerInputChange v3 = arg14.getInitialDown();
                    if(v3 != null) {
                        IndirectPointerInputDragCycleDetector.moveToAwaitTouchSlopState-aWI9W7U$default(this, v3, arg14.getPointerId-J3iCeTQ(), v6, false, 8, null);
                        return;
                    }
                    else {
                        throw new IllegalArgumentException("AwaitGesturePickup.initialDown was not initialized.".toString());
                    }
                }
                else {
                    return;
                }

                break;
            }

            this.moveToAwaitDownState();
            return;
        }
    }

    private final void processAwaitTouchSlop(IndirectPointerEvent arg18, PointerEventPass arg19, androidx.compose.foundation.gestures.IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop arg20) {
        IndirectPointerInputChange v1_1;
        Object v5;
        Object v4;
        IndirectPointerInputDragCycleDetector v0 = this;
        PointerEventPass v6 = arg19;
        androidx.compose.foundation.gestures.IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop v7 = arg20;
        if(v6 == PointerEventPass.Initial) {
        }
        else {
            List v1 = arg18.getChanges();
            int v2 = v1.size();
            int v3 = 0;
            while(true) {
                v4 = null;
                if(v3 < v2) {
                    v5 = v1.get(v3);
                    if(PointerId.equals-impl0(v5.getId-J3iCeTQ(), v7.getPointerId-J3iCeTQ())) {
                    }
                    else {
                        ++v3;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_23;
            }

            v5 = v4;
        label_23:
            if(v5 == null) {
                v1 = arg18.getChanges();
                v2 = v1.size();
                v3 = 0;
                while(true) {
                    if(v3 < v2) {
                        v5 = v1.get(v3);
                        if(v5.getPressed()) {
                        }
                        else {
                            ++v3;
                            continue;
                        }
                    }
                    else {
                        break;
                    }

                    goto label_37;
                }

                v5 = v4;
            label_37:
                if(v5 == null) {
                    v0.moveToAwaitDownState();
                    return;
                }

                v7.setPointerId-0FcD4WY(((IndirectPointerInputChange)v5).getId-J3iCeTQ());
            }

            Object v2_1 = v5;
            String v9 = "AwaitTouchSlop.touchSlopDetector was not initialized";
            String v10 = "AwaitTouchSlop.initialDown was not initialized";
            if(v6 == PointerEventPass.Main) {
                if(((IndirectPointerInputChange)v2_1).isConsumed()) {
                    v1_1 = v7.getInitialDown();
                    if(v1_1 != null) {
                        long v3_1 = v7.getPointerId-J3iCeTQ();
                        TouchSlopDetector v5_2 = v0.touchSlopDetector;
                        if(v5_2 != null) {
                            v0.moveToAwaitGesturePickupState-rnUCldI(v1_1, v3_1, v5_2);
                            goto label_122;
                        }

                        throw new IllegalArgumentException(v9.toString());
                    }

                    throw new IllegalArgumentException(v10.toString());
                }
                else if(IndirectPointerInputDragCycleDetectorKt.access$changedToUpIgnoreConsumed(((IndirectPointerInputChange)v2_1))) {
                    v1 = arg18.getChanges();
                    v3 = v1.size();
                    int v5_1 = 0;
                    while(v5_1 < v3) {
                        Object v11 = v1.get(v5_1);
                        if(v11.getPressed()) {
                            v4 = v11;
                        }
                        else {
                            ++v5_1;
                            continue;
                        }

                        break;
                    }

                    if(v4 == null) {
                        v0.moveToAwaitDownState();
                        goto label_122;
                    }

                    v7.setPointerId-0FcD4WY(((IndirectPointerInputChange)v4).getId-J3iCeTQ());
                }
                else {
                    long v4_1 = v0.requireTouchSlopDetector().addPositions-akrDWew(IndirectPointerInputDragCycleDetectorKt.access$primaryAxisPosition-_bfSUIo(((IndirectPointerInputChange)v2_1), v0.node.getOrientationLock(), IndirectPointerEventPrimaryDirectionalMotionAxis.box-impl(arg18.getPrimaryDirectionalMotionAxis-nZO2Niw())), IndirectPointerInputDragCycleDetectorKt.access$primaryAxisPreviousPosition-_bfSUIo(((IndirectPointerInputChange)v2_1), v0.node.getOrientationLock(), IndirectPointerEventPrimaryDirectionalMotionAxis.box-impl(arg18.getPrimaryDirectionalMotionAxis-nZO2Niw())), DragGestureDetectorKt.pointerSlop-E8SPZFQ(CompositionLocalConsumerModifierNodeKt.currentValueOf(v0.node, CompositionLocalsKt.getLocalViewConfiguration()), PointerType.Companion.getTouch-T8wyACA()));
                    if((0x7FFFFFFF7FFFFFFFL & v4_1) != 0x7FC000007FC00000L) {
                        ((IndirectPointerInputChange)v2_1).consume();
                        v1_1 = v7.getInitialDown();
                        Intrinsics.checkNotNull(v1_1);
                        v0.sendDragStart-3f7A7Is(v1_1, ((IndirectPointerInputChange)v2_1), IndirectPointerEventPrimaryDirectionalMotionAxis.box-impl(arg18.getPrimaryDirectionalMotionAxis-nZO2Niw()), v4_1);
                        v0.sendDragEvent-Eu1f8Dk(((IndirectPointerInputChange)v2_1), IndirectPointerEventPrimaryDirectionalMotionAxis.box-impl(arg18.getPrimaryDirectionalMotionAxis-nZO2Niw()), v4_1);
                        v0.moveToDraggingState-0FcD4WY(((IndirectPointerInputChange)v2_1).getId-J3iCeTQ());
                        goto label_122;
                    }

                    v7.setVerifyConsumptionInFinalPass(true);
                }
            }

        label_122:
            if(v6 != PointerEventPass.Final) {
                return;
            }

            if(!v7.getVerifyConsumptionInFinalPass()) {
                return;
            }

            if(((IndirectPointerInputChange)v2_1).isConsumed()) {
                v1_1 = v7.getInitialDown();
                if(v1_1 != null) {
                    long v2_2 = v7.getPointerId-J3iCeTQ();
                    TouchSlopDetector v4_2 = v0.touchSlopDetector;
                    if(v4_2 != null) {
                        v0.moveToAwaitGesturePickupState-rnUCldI(v1_1, v2_2, v4_2);
                        return;
                    }

                    throw new IllegalArgumentException(v9.toString());
                }

                throw new IllegalArgumentException(v10.toString());
            }

            v7.setVerifyConsumptionInFinalPass(false);
        }
    }

    private final void processDraggingState(IndirectPointerEvent arg10, PointerEventPass arg11, Dragging arg12) {
        Object v6;
        Object v5;
        if(arg11 != PointerEventPass.Main) {
        }
        else {
            long v0 = arg12.getPointerId-J3iCeTQ();
            List v11 = arg10.getChanges();
            int v2 = v11.size();
            int v3 = 0;
            int v4 = 0;
            while(true) {
                v5 = null;
                if(v4 < v2) {
                    v6 = v11.get(v4);
                    if(PointerId.equals-impl0(v6.getId-J3iCeTQ(), v0)) {
                    }
                    else {
                        ++v4;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_20;
            }

            v6 = v5;
        label_20:
            if(v6 == null) {
                return;
            }

            if(IndirectPointerInputDragCycleDetectorKt.access$changedToUpIgnoreConsumed(((IndirectPointerInputChange)v6))) {
                v11 = arg10.getChanges();
                int v0_1 = v11.size();
                goto label_27;
            }

            if(((IndirectPointerInputChange)v6).isConsumed()) {
                this.sendDragCancelled();
                return;
            }

            if(Offset.getDistance-impl(IndirectPointerInputDragCycleDetectorKt.access$positionChangeIgnoreConsumed-_bfSUIo(((IndirectPointerInputChange)v6), this.node.getOrientationLock(), IndirectPointerEventPrimaryDirectionalMotionAxis.box-impl(arg10.getPrimaryDirectionalMotionAxis-nZO2Niw()))) == 0f) {
                return;
            }

            this.sendDragEvent-Eu1f8Dk(((IndirectPointerInputChange)v6), IndirectPointerEventPrimaryDirectionalMotionAxis.box-impl(arg10.getPrimaryDirectionalMotionAxis-nZO2Niw()), IndirectPointerInputDragCycleDetectorKt.access$positionChange-_bfSUIo(((IndirectPointerInputChange)v6), this.node.getOrientationLock(), IndirectPointerEventPrimaryDirectionalMotionAxis.box-impl(arg10.getPrimaryDirectionalMotionAxis-nZO2Niw())));
            ((IndirectPointerInputChange)v6).consume();
            return;
        label_27:
            while(v3 < v0_1) {
                Object v1 = v11.get(v3);
                if(v1.getPressed()) {
                    v5 = v1;
                }
                else {
                    ++v3;
                    continue;
                }

                break;
            }

            if(v5 == null) {
                if((((IndirectPointerInputChange)v6).isConsumed()) || !IndirectPointerInputDragCycleDetectorKt.access$changedToUpIgnoreConsumed(((IndirectPointerInputChange)v6))) {
                    this.sendDragCancelled();
                }
                else {
                    this.sendDragStopped-k92h6UU(((IndirectPointerInputChange)v6), IndirectPointerEventPrimaryDirectionalMotionAxis.box-impl(arg10.getPrimaryDirectionalMotionAxis-nZO2Niw()));
                }

                this.moveToAwaitDownState();
                return;
            }

            arg12.setPointerId-0FcD4WY(((IndirectPointerInputChange)v5).getId-J3iCeTQ());
            return;
        }
    }

    public final void processIndirectPointerInputEvent(IndirectPointerEvent arg3, PointerEventPass arg4) {
        DragDetectionState v0 = this.currentDragState;
        if(v0 == null) {
            AwaitDown v0_1 = this.getAwaitDownState();
            this.currentDragState = ((DragDetectionState)v0_1);
        }

        if(v0 != null) {
            if((v0 instanceof AwaitDown)) {
                this.processInitialDownState(arg3, arg4, ((AwaitDown)v0));
                return;
            }

            if((v0 instanceof androidx.compose.foundation.gestures.IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop)) {
                this.processAwaitTouchSlop(arg3, arg4, ((androidx.compose.foundation.gestures.IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop)v0));
                return;
            }

            if((v0 instanceof AwaitGesturePickup)) {
                this.processAwaitGesturePickup(arg3, arg4, ((AwaitGesturePickup)v0));
                return;
            }

            if((v0 instanceof Dragging)) {
                this.processDraggingState(arg3, arg4, ((Dragging)v0));
                return;
            }

            throw new NoWhenBranchMatchedException();
        }

        throw new IllegalArgumentException("currentDragState should not be null".toString());
    }

    private final void processInitialDownState(IndirectPointerEvent arg11, PointerEventPass arg12, AwaitDown arg13) {
        AwaitTouchSlop v0_1;
        if(arg11.getChanges().isEmpty()) {
        }
        else {
            List v0 = arg11.getChanges();
            int v1 = v0.size();
            int v2 = 0;
            while(true) {
                if(v2 >= v1) {
                    break;
                }
                else if(!IndirectPointerInputDragCycleDetectorKt.access$changedToDownIgnoreConsumed(v0.get(v2))) {
                    return;
                }
                else {
                    ++v2;
                    continue;
                }

                return;
            }

            Object v2_1 = CollectionsKt.first(arg11.getChanges());
            if(WhenMappings.$EnumSwitchMapping$0[arg13.getAwaitTouchSlop().ordinal()] != 1) {
                v0_1 = arg13.getAwaitTouchSlop();
            }
            else if(!this.node.startDragImmediately()) {
                v0_1 = AwaitTouchSlop.Yes;
            }
            else {
                v0_1 = AwaitTouchSlop.No;
            }

            arg13.setAwaitTouchSlop(v0_1);
            if(arg12 == PointerEventPass.Initial && v0_1 == AwaitTouchSlop.No) {
                ((IndirectPointerInputChange)v2_1).consume();
                arg13.setConsumedOnInitial(true);
            }

            if(arg12 != PointerEventPass.Main) {
                return;
            }

            if(v0_1 == AwaitTouchSlop.Yes) {
                IndirectPointerInputDragCycleDetector.moveToAwaitTouchSlopState-aWI9W7U$default(this, ((IndirectPointerInputChange)v2_1), ((IndirectPointerInputChange)v2_1).getId-J3iCeTQ(), 0, false, 12, null);
                return;
            }

            IndirectPointerInputDragCycleDetector v1_1 = this;
            if(!arg13.getConsumedOnInitial()) {
                return;
            }

            v1_1.sendDragStart-3f7A7Is(((IndirectPointerInputChange)v2_1), v2_1, IndirectPointerEventPrimaryDirectionalMotionAxis.box-impl(arg11.getPrimaryDirectionalMotionAxis-nZO2Niw()), Offset.Companion.getZero-F1C5BW0());
            v1_1.sendDragEvent-Eu1f8Dk(((IndirectPointerInputChange)v2_1), IndirectPointerEventPrimaryDirectionalMotionAxis.box-impl(arg11.getPrimaryDirectionalMotionAxis-nZO2Niw()), Offset.Companion.getZero-F1C5BW0());
            v1_1.moveToDraggingState-0FcD4WY(((IndirectPointerInputChange)v2_1).getId-J3iCeTQ());
        }
    }

    private final TouchSlopDetector requireTouchSlopDetector() {
        TouchSlopDetector v1 = this.touchSlopDetector;
        if(v1 != null) {
            return v1;
        }

        throw new IllegalArgumentException("Touch slop detector not initialized.".toString());
    }

    private final VelocityTracker requireVelocityTracker() {
        VelocityTracker v1 = this.velocityTracker;
        if(v1 != null) {
            return v1;
        }

        throw new IllegalArgumentException("Velocity Tracker not initialized.".toString());
    }

    public final void resetDragDetectionState() {
        this.moveToAwaitDownState();
        if(this.node.isListeningForEvents$foundation()) {
            this.sendDragCancelled();
        }

        this.velocityTracker = null;
        this.offsetSmoother.reset();
    }

    private final void sendDragCancelled() {
        this.node.onDragEvent(DragCancelled.INSTANCE);
    }

    private final void sendDragEvent-Eu1f8Dk(IndirectPointerInputChange arg9, IndirectPointerEventPrimaryDirectionalMotionAxis arg10, long arg11) {
        long v0 = LayoutCoordinatesKt.positionOnScreen(DelegatableNodeKt.requireLayoutCoordinates(this.node));
        if(!Offset.equals-impl0(this.previousPositionOnScreen, Offset.Companion.getUnspecified-F1C5BW0()) && !Offset.equals-impl0(v0, this.previousPositionOnScreen)) {
            this.nodeOffset = Offset.plus-MK-Hz9U(this.nodeOffset, Offset.minus-MK-Hz9U(v0, this.previousPositionOnScreen));
        }

        this.previousPositionOnScreen = v0;
        Orientation v0_1 = this.node.getOrientationLock();
        Intrinsics.checkNotNull(v0_1);
        if(Math.abs(DraggableKt.toFloat-3MmeM6k(arg11, v0_1)) > 2f) {
            IndirectPointerInputDragCycleDetectorKt.access$addIndirectPointerInputChange-Qf4Zb88(this.requireVelocityTracker(), arg9, this.node.getOrientationLock(), arg10, this.touchSmooth, this.nodeOffset);
            this.node.onDragEvent(new DragDelta(this.offsetSmoother.smoothEventPosition-MK-Hz9U(arg11), true, null));
        }
    }

    private final void sendDragStart-3f7A7Is(IndirectPointerInputChange arg10, IndirectPointerInputChange arg11, IndirectPointerEventPrimaryDirectionalMotionAxis arg12, long arg13) {
        if(this.velocityTracker == null) {
            this.velocityTracker = new VelocityTracker();
        }

        this.nodeOffset = Offset.Companion.getZero-F1C5BW0();
        IndirectPointerInputDragCycleDetectorKt.access$addIndirectPointerInputChange-Qf4Zb88(this.requireVelocityTracker(), arg10, this.node.getOrientationLock(), arg12, this.touchSmooth, this.nodeOffset);
        long v10 = Offset.minus-MK-Hz9U(IndirectPointerInputDragCycleDetectorKt.access$primaryAxisPosition-_bfSUIo(arg11, this.node.getOrientationLock(), arg12), arg13);
        if(this.node.getCanDrag().invoke(PointerType.box-impl(PointerType.Companion.getTouch-T8wyACA())).booleanValue()) {
            this.previousPositionOnScreen = LayoutCoordinatesKt.positionOnScreen(DelegatableNodeKt.requireLayoutCoordinates(this.node));
            this.node.onDragEvent(new DragStarted(v10, null));
        }

        this.offsetSmoother.reset();
    }

    private final void sendDragStopped-k92h6UU(IndirectPointerInputChange arg8, IndirectPointerEventPrimaryDirectionalMotionAxis arg9) {
        IndirectPointerInputDragCycleDetectorKt.access$addIndirectPointerInputChange-Qf4Zb88(this.requireVelocityTracker(), arg8, this.node.getOrientationLock(), arg9, this.touchSmooth, this.nodeOffset);
        float v8 = CompositionLocalConsumerModifierNodeKt.currentValueOf(this.node, CompositionLocalsKt.getLocalViewConfiguration()).getMaximumFlingVelocity();
        long v8_1 = this.requireVelocityTracker().calculateVelocity-AH228Gc(VelocityKt.Velocity(v8, v8));
        this.requireVelocityTracker().resetTracking();
        this.node.onDragEvent(new DragStopped(DraggableKt.toValidVelocity-TH1AsA0(v8_1), true, null));
    }
}

