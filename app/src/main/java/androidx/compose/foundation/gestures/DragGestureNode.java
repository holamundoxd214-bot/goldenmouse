package androidx.compose.foundation.gestures;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.interaction.DragInteraction$Cancel;
import androidx.compose.foundation.interaction.DragInteraction$Start;
import androidx.compose.foundation.interaction.DragInteraction$Stop;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.indirect.IndirectPointerEvent;
import androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

@Metadata(d1={"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001E\b!\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B7\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0006\u0010\t\u001A\u00020\b\u0012\b\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\b\u0010\f\u001A\u0004\u0018\u00010\r¢\u0006\u0004\b\u000E\u0010\u000FJM\u0010H\u001A\u00020I2=\u0010J\u001A9\b\u0001\u0012\u001F\u0012\u001D\u0012\u0013\u0012\u00110L¢\u0006\f\bM\u0012\b\bN\u0012\u0004\b\b(O\u0012\u0004\u0012\u00020I0\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0P\u0012\u0006\u0012\u0004\u0018\u00010Q0KH¦@¢\u0006\u0002\u0010RJ\u0017\u0010S\u001A\u00020I2\u0006\u0010T\u001A\u00020AH&¢\u0006\u0004\bU\u0010VJ\u0010\u0010W\u001A\u00020I2\u0006\u0010X\u001A\u00020YH&J\b\u0010Z\u001A\u00020\bH&J\b\u0010[\u001A\u00020?H\u0002J\u000E\u0010\\\u001A\b\u0012\u0004\u0012\u00020\u001E0\u001DH\u0002J\b\u0010]\u001A\u00020DH\u0002J\b\u0010^\u001A\u00020IH\u0002J\b\u0010a\u001A\u00020IH\u0016J\'\u0010b\u001A\u00020I2\u0006\u0010c\u001A\u00020d2\u0006\u0010e\u001A\u00020f2\u0006\u0010g\u001A\u00020hH\u0016¢\u0006\u0004\bi\u0010jJ\u0018\u0010k\u001A\u00020I2\u0006\u0010X\u001A\u00020l2\u0006\u0010e\u001A\u00020fH\u0016J\b\u0010m\u001A\u00020IH\u0016J\b\u0010n\u001A\u00020`H\u0002J\b\u0010o\u001A\u00020IH\u0016J\u0016\u0010p\u001A\u00020I2\u0006\u0010X\u001A\u00020qH\u0082@¢\u0006\u0002\u0010rJ\u0016\u0010s\u001A\u00020I2\u0006\u0010X\u001A\u00020YH\u0082@¢\u0006\u0002\u0010tJ\u000E\u0010u\u001A\u00020IH\u0082@¢\u0006\u0002\u0010vJ\u0006\u0010w\u001A\u00020IJH\u0010x\u001A\u00020I2\u0014\b\u0002\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\b\b\u0002\u0010\t\u001A\u00020\b2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\b\b\u0002\u0010y\u001A\u00020\bJ\u0018\u0010z\u001A\u00020I2\u0006\u0010c\u001A\u00020d2\u0006\u0010e\u001A\u00020fH\u0002J\b\u0010{\u001A\u00020IH\u0002J8\u0010|\u001A\u00020I2\u0006\u0010}\u001A\u00020~2\u0007\u0010\u007F\u001A\u00030\u0080\u00012\t\b\u0002\u0010\u0081\u0001\u001A\u00020A2\t\b\u0002\u0010\u0082\u0001\u001A\u00020\bH\u0002¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u001A\u0010\u0085\u0001\u001A\u00020I2\u0007\u0010\u007F\u001A\u00030\u0080\u0001H\u0002¢\u0006\u0005\b\u0086\u0001\u0010VJ\t\u0010\u0087\u0001\u001A\u00020IH\u0002J+\u0010\u0088\u0001\u001A\u00020I2\u0006\u0010}\u001A\u00020~2\u0007\u0010\u007F\u001A\u00030\u0080\u00012\u0006\u0010C\u001A\u00020DH\u0002¢\u0006\u0006\b\u0089\u0001\u0010\u008A\u0001J\"\u0010\u008B\u0001\u001A\u00020I2\u0006\u0010c\u001A\u00020d2\u0006\u0010e\u001A\u00020f2\u0007\u0010\u008C\u0001\u001A\u00020)H\u0002J\"\u0010\u008D\u0001\u001A\u00020I2\u0006\u0010c\u001A\u00020d2\u0006\u0010e\u001A\u00020f2\u0007\u0010\u008C\u0001\u001A\u000203H\u0002J\"\u0010\u008E\u0001\u001A\u00020I2\u0006\u0010c\u001A\u00020d2\u0006\u0010e\u001A\u00020f2\u0007\u0010\u008C\u0001\u001A\u000208H\u0002J\"\u0010\u008F\u0001\u001A\u00020I2\u0006\u0010c\u001A\u00020d2\u0006\u0010e\u001A\u00020f2\u0007\u0010\u008C\u0001\u001A\u00020.H\u0002J-\u0010\u0090\u0001\u001A\u00020I2\u0007\u0010\u0091\u0001\u001A\u00020~2\u0007\u0010\u0092\u0001\u001A\u00020~2\u0007\u0010\u0093\u0001\u001A\u00020AH\u0002¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J$\u0010\u0096\u0001\u001A\u00020I2\u0007\u0010\u0097\u0001\u001A\u00020~2\u0007\u0010\u0098\u0001\u001A\u00020AH\u0002¢\u0006\u0006\b\u0099\u0001\u0010\u009A\u0001J\u0012\u0010\u009B\u0001\u001A\u00020I2\u0007\u0010\u0097\u0001\u001A\u00020~H\u0002J\t\u0010\u009C\u0001\u001A\u00020IH\u0002J\u000F\u0010\u009D\u0001\u001A\u00020I2\u0006\u0010X\u001A\u00020\u001ER\u001C\u0010\f\u001A\u0004\u0018\u00010\rX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R6\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0012\u0010\u0014\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u001E\u0010\t\u001A\u00020\b2\u0006\u0010\u0014\u001A\u00020\b@BX\u0084\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\"\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0014\u001A\u0004\u0018\u00010\u000B@BX\u0084\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u001A\u0010\u001B\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001C\u001A\n\u0012\u0004\u0012\u00020\u001E\u0018\u00010\u001DX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001F\u001A\u0004\u0018\u00010 X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010!\u001A\u00020\bX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\"\u0010\u0018\"\u0004\b#\u0010$R\u001A\u0010%\u001A\u00020\bX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\u0018\"\u0004\b\'\u0010$R\u0010\u0010(\u001A\u0004\u0018\u00010)X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010*\u001A\u00020)8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b+\u0010,R\u0010\u0010-\u001A\u0004\u0018\u00010.X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010/\u001A\u00020.8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b0\u00101R\u0010\u00102\u001A\u0004\u0018\u000103X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u00104\u001A\u0002038BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b5\u00106R\u0010\u00107\u001A\u0004\u0018\u000108X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u00109\u001A\u0002088BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b:\u0010;R\u0010\u0010<\u001A\u0004\u0018\u00010=X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010>\u001A\u0004\u0018\u00010?X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010@\u001A\u00020AX\u0082\u000E¢\u0006\u0004\n\u0002\u0010BR\u0010\u0010C\u001A\u0004\u0018\u00010DX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010E\u001A\u0004\u0018\u00010FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010G\u001A\u00020AX\u0082\u000E¢\u0006\u0004\n\u0002\u0010BR\u0010\u0010_\u001A\u0004\u0018\u00010`X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u009E\u0001"}, d2={"Landroidx/compose/foundation/gestures/DragGestureNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/input/indirect/IndirectPointerInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "canDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerType;", "", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "orientationLock", "Landroidx/compose/foundation/gestures/Orientation;", "<init>", "(Lkotlin/jvm/functions/Function1;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/Orientation;)V", "getOrientationLock", "()Landroidx/compose/foundation/gestures/Orientation;", "setOrientationLock", "(Landroidx/compose/foundation/gestures/Orientation;)V", "value", "getCanDrag", "()Lkotlin/jvm/functions/Function1;", "getEnabled", "()Z", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "_canDrag", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/DragEvent;", "dragInteraction", "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "isListeningForEvents", "isListeningForEvents$foundation", "setListeningForEvents$foundation", "(Z)V", "isListeningForPointerInputEvents", "isListeningForPointerInputEvents$foundation", "setListeningForPointerInputEvents$foundation", "_awaitDownState", "Landroidx/compose/foundation/gestures/DragDetectionState$AwaitDown;", "awaitDownState", "getAwaitDownState", "()Landroidx/compose/foundation/gestures/DragDetectionState$AwaitDown;", "_draggingState", "Landroidx/compose/foundation/gestures/DragDetectionState$Dragging;", "draggingState", "getDraggingState", "()Landroidx/compose/foundation/gestures/DragDetectionState$Dragging;", "_awaitTouchSlopState", "Landroidx/compose/foundation/gestures/DragDetectionState$AwaitTouchSlop;", "awaitTouchSlopState", "getAwaitTouchSlopState", "()Landroidx/compose/foundation/gestures/DragDetectionState$AwaitTouchSlop;", "_awaitGesturePickupState", "Landroidx/compose/foundation/gestures/DragDetectionState$AwaitGesturePickup;", "awaitGesturePickupState", "getAwaitGesturePickupState", "()Landroidx/compose/foundation/gestures/DragDetectionState$AwaitGesturePickup;", "currentDragState", "Landroidx/compose/foundation/gestures/DragDetectionState;", "velocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "previousPositionOnScreen", "Landroidx/compose/ui/geometry/Offset;", "J", "touchSlopDetector", "Landroidx/compose/foundation/gestures/TouchSlopDetector;", "indirectPointerInputDragCycleDetector", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector;", "nodeOffset", "drag", "", "forEachDelta", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", "name", "dragDelta", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStarted", "startedPosition", "onDragStarted-k-4lQ0M", "(J)V", "onDragStopped", "event", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "startDragImmediately", "requireVelocityTracker", "requireChannel", "requireTouchSlopDetector", "startListeningForEvents", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "onDetach", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onIndirectPointerEvent", "Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "onCancelIndirectPointerInput", "initializePointerInputNode", "onCancelPointerInput", "processDragStart", "Landroidx/compose/foundation/gestures/DragEvent$DragStarted;", "(Landroidx/compose/foundation/gestures/DragEvent$DragStarted;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStop", "(Landroidx/compose/foundation/gestures/DragEvent$DragStopped;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragCancel", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disposeInteractionSource", "update", "shouldResetPointerInputHandling", "processRawPointerEvent", "resetDragDetectionState", "moveToAwaitTouchSlopState", "initialDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "initialTouchSlopPositionChange", "verifyConsumptionInFinalPass", "moveToAwaitTouchSlopState-aWI9W7U", "(Landroidx/compose/ui/input/pointer/PointerInputChange;JJZ)V", "moveToDraggingState", "moveToDraggingState-0FcD4WY", "moveToAwaitDownState", "moveToAwaitGesturePickupState", "moveToAwaitGesturePickupState-rnUCldI", "(Landroidx/compose/ui/input/pointer/PointerInputChange;JLandroidx/compose/foundation/gestures/TouchSlopDetector;)V", "processInitialDownState", "state", "processAwaitTouchSlop", "processAwaitGesturePickup", "processDraggingState", "sendDragStart", "down", "slopTriggerChange", "overSlopOffset", "sendDragStart-0AR0LA0", "(Landroidx/compose/ui/input/pointer/PointerInputChange;Landroidx/compose/ui/input/pointer/PointerInputChange;J)V", "sendDragEvent", "change", "dragAmount", "sendDragEvent-Uv8p0NA", "(Landroidx/compose/ui/input/pointer/PointerInputChange;J)V", "sendDragStopped", "sendDragCancelled", "onDragEvent", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class DragGestureNode extends DelegatingNode implements IndirectPointerInputModifierNode, CompositionLocalConsumerModifierNode, PointerInputModifierNode {
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
    private androidx.compose.foundation.gestures.DragDetectionState$AwaitTouchSlop _awaitTouchSlopState;
    private final Function1 _canDrag;
    private Dragging _draggingState;
    private Function1 canDrag;
    private Channel channel;
    private DragDetectionState currentDragState;
    private Start dragInteraction;
    private boolean enabled;
    private IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector;
    private MutableInteractionSource interactionSource;
    private boolean isListeningForEvents;
    private boolean isListeningForPointerInputEvents;
    private long nodeOffset;
    private Orientation orientationLock;
    private SuspendingPointerInputModifierNode pointerInputNode;
    private long previousPositionOnScreen;
    private TouchSlopDetector touchSlopDetector;
    private VelocityTracker velocityTracker;

    static {
    }

    public DragGestureNode(Function1 arg1, boolean arg2, MutableInteractionSource arg3, Orientation arg4) {
        super();
        this.orientationLock = arg4;
        this.canDrag = arg1;
        this.enabled = arg2;
        this.interactionSource = arg3;
        this._canDrag = new DragGestureNode$$ExternalSyntheticLambda0(this);
        this.previousPositionOnScreen = Offset.Companion.getUnspecified-F1C5BW0();
        this.nodeOffset = Offset.Companion.getZero-F1C5BW0();
    }

    static final boolean _canDrag$lambda$0(DragGestureNode arg0, PointerType arg1) {
        return arg0.canDrag.invoke(arg1).booleanValue();
    }

    public static final Channel access$getChannel$p(DragGestureNode arg0) {
        return arg0.channel;
    }

    public static final long access$getNodeOffset$p(DragGestureNode arg2) {
        return arg2.nodeOffset;
    }

    public static final Object access$processDragCancel(DragGestureNode arg0, Continuation arg1) {
        return arg0.processDragCancel(arg1);
    }

    public static final Object access$processDragStart(DragGestureNode arg0, DragStarted arg1, Continuation arg2) {
        return arg0.processDragStart(arg1, arg2);
    }

    public static final Object access$processDragStop(DragGestureNode arg0, DragStopped arg1, Continuation arg2) {
        return arg0.processDragStop(arg1, arg2);
    }

    public static final void access$setNodeOffset$p(DragGestureNode arg0, long arg1) {
        arg0.nodeOffset = arg1;
    }

    public static final void access$startListeningForEvents(DragGestureNode arg0) {
        arg0.startListeningForEvents();
    }

    public final void disposeInteractionSource() {
        Start v0 = this.dragInteraction;
        if(v0 != null) {
            MutableInteractionSource v1 = this.interactionSource;
            if(v1 != null) {
                v1.tryEmit(new Cancel(v0));
            }

            this.dragInteraction = null;
        }
    }

    public abstract Object drag(Function2 arg1, Continuation arg2);

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

    private final androidx.compose.foundation.gestures.DragDetectionState$AwaitTouchSlop getAwaitTouchSlopState() {
        androidx.compose.foundation.gestures.DragDetectionState$AwaitTouchSlop v0 = this._awaitTouchSlopState;
        if(v0 == null) {
            androidx.compose.foundation.gestures.DragDetectionState$AwaitTouchSlop v1 = new androidx.compose.foundation.gestures.DragDetectionState$AwaitTouchSlop(null, 0, false, 7, null);
            this._awaitTouchSlopState = v1;
            return v1;
        }

        return v0;
    }

    public final Function1 getCanDrag() {
        return this.canDrag;
    }

    private final Dragging getDraggingState() {
        Dragging v0 = this._draggingState;
        if(v0 == null) {
            v0 = new Dragging(0, 1, null);
            this._draggingState = v0;
        }

        return v0;
    }

    protected final boolean getEnabled() {
        return this.enabled;
    }

    protected final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    public final Orientation getOrientationLock() {
        return this.orientationLock;
    }

    private final SuspendingPointerInputModifierNode initializePointerInputNode() {
        return SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new DragGestureNode$initializePointerInputNode$1(this));
    }

    public final boolean isListeningForEvents$foundation() {
        return this.isListeningForEvents;
    }

    public final boolean isListeningForPointerInputEvents$foundation() {
        return this.isListeningForPointerInputEvents;
    }

    private final void moveToAwaitDownState() {
        AwaitDown v0 = this.getAwaitDownState();
        v0.setAwaitTouchSlop(AwaitTouchSlop.NotInitialized);
        v0.setConsumedOnInitial(false);
        this.currentDragState = ((DragDetectionState)v0);
    }

    private final void moveToAwaitGesturePickupState-rnUCldI(PointerInputChange arg4, long arg5, TouchSlopDetector arg7) {
        AwaitGesturePickup v0 = this.getAwaitGesturePickupState();
        v0.setInitialDown(arg4);
        v0.setPointerId-0FcD4WY(arg5);
        TouchSlopDetector.reset-k-4lQ0M$default(arg7, 0, 1, null);
        v0.setTouchSlopDetector(arg7);
        this.currentDragState = ((DragDetectionState)v0);
    }

    private final void moveToAwaitTouchSlopState-aWI9W7U(PointerInputChange arg8, long arg9, long arg11, boolean arg13) {
        androidx.compose.foundation.gestures.DragDetectionState$AwaitTouchSlop v0 = this.getAwaitTouchSlopState();
        v0.setInitialDown(arg8);
        v0.setPointerId-0FcD4WY(arg9);
        TouchSlopDetector v8 = this.touchSlopDetector;
        if(v8 == null) {
            this.touchSlopDetector = new TouchSlopDetector(this.orientationLock, 0, 2, null);
        }
        else {
            if(v8 != null) {
                v8.setOrientation(this.orientationLock);
            }

            v8 = this.touchSlopDetector;
            if(v8 == null) {
                goto label_19;
            }

            v8.reset-k-4lQ0M(arg11);
        }

    label_19:
        v0.setVerifyConsumptionInFinalPass(arg13);
        this.currentDragState = ((DragDetectionState)v0);
    }

    static void moveToAwaitTouchSlopState-aWI9W7U$default(DragGestureNode arg7, PointerInputChange arg8, long arg9, long arg11, boolean arg13, int arg14, Object arg15) {
        if(arg15 == null) {
            if((arg14 & 4) != 0) {
                arg11 = Offset.Companion.getZero-F1C5BW0();
            }

            arg7.moveToAwaitTouchSlopState-aWI9W7U(arg8, arg9, arg11, false);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: moveToAwaitTouchSlopState-aWI9W7U");
    }

    private final void moveToDraggingState-0FcD4WY(long arg2) {
        Dragging v0 = this.getDraggingState();
        v0.setPointerId-0FcD4WY(arg2);
        this.currentDragState = ((DragDetectionState)v0);
    }

    public void onCancelIndirectPointerInput() {
        IndirectPointerInputDragCycleDetector v0 = this.indirectPointerInputDragCycleDetector;
        if(v0 != null) {
            v0.resetDragDetectionState();
        }
    }

    public void onCancelPointerInput() {
        SuspendingPointerInputModifierNode v0 = this.pointerInputNode;
        if(v0 != null) {
            v0.onCancelPointerInput();
        }

        if((ComposeFoundationFlags.isNonSuspendingPointerInputInDraggableEnabled) && (this.isListeningForPointerInputEvents)) {
            this.resetDragDetectionState();
        }

        this.isListeningForPointerInputEvents = false;
    }

    public void onDetach() {
        this.isListeningForEvents = false;
        this.disposeInteractionSource();
        this.nodeOffset = Offset.Companion.getZero-F1C5BW0();
    }

    public final void onDragEvent(DragEvent arg2) {
        if(((arg2 instanceof DragStarted)) && !this.isListeningForEvents) {
            this.isListeningForEvents = true;
            this.startListeningForEvents();
        }

        this.requireChannel().trySend-JP2dKIU(arg2);
    }

    public abstract void onDragStarted-k-4lQ0M(long arg1);

    public abstract void onDragStopped(DragStopped arg1);

    public void onIndirectPointerEvent(IndirectPointerEvent arg2, PointerEventPass arg3) {
        if(this.enabled) {
            IndirectPointerInputDragCycleDetector v0 = this.indirectPointerInputDragCycleDetector;
            if(v0 == null) {
                v0 = new IndirectPointerInputDragCycleDetector(this);
                this.indirectPointerInputDragCycleDetector = v0;
            }

            if(v0 == null) {
                return;
            }

            v0.processIndirectPointerInputEvent(arg2, arg3);
        }
    }

    public void onPointerEvent-H0pRuoY(PointerEvent arg3, PointerEventPass arg4, long arg5) {
        this.isListeningForPointerInputEvents = true;
        boolean v0 = ComposeFoundationFlags.isNonSuspendingPointerInputInDraggableEnabled;
        boolean v1 = this.enabled;
        if(!v0) {
            if((v1) && this.pointerInputNode == null) {
                this.pointerInputNode = this.delegate(this.initializePointerInputNode());
            }

            SuspendingPointerInputModifierNode v2 = this.pointerInputNode;
            if(v2 == null) {
                return;
            }

            v2.onPointerEvent-H0pRuoY(arg3, arg4, arg5);
        }
        else if(v1) {
            if(this.currentDragState == null) {
                this.currentDragState = this.getAwaitDownState();
            }

            this.processRawPointerEvent(arg3, arg4);
            return;
        }
    }

    private final void processAwaitGesturePickup(PointerEvent arg12, PointerEventPass arg13, AwaitGesturePickup arg14) {
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
                    long v12 = CollectionsKt.first(arg12.getChanges()).getPosition-F1C5BW0();
                    PointerInputChange v0_2 = arg14.getInitialDown();
                    Intrinsics.checkNotNull(v0_2);
                    long v6 = Offset.minus-MK-Hz9U(v12, v0_2.getPosition-F1C5BW0());
                    PointerInputChange v3 = arg14.getInitialDown();
                    if(v3 != null) {
                        DragGestureNode.moveToAwaitTouchSlopState-aWI9W7U$default(this, v3, arg14.getPointerId-J3iCeTQ(), v6, false, 8, null);
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

    private final void processAwaitTouchSlop(PointerEvent arg13, PointerEventPass arg14, androidx.compose.foundation.gestures.DragDetectionState$AwaitTouchSlop arg15) {
        PointerInputChange v13_1;
        long v6_1;
        TouchSlopDetector v0_2;
        Object v5;
        Object v4;
        if(arg14 == PointerEventPass.Initial) {
        }
        else {
            List v0 = arg13.getChanges();
            int v1 = v0.size();
            int v3 = 0;
            while(true) {
                v4 = null;
                if(v3 < v1) {
                    v5 = v0.get(v3);
                    if(PointerId.equals-impl0(v5.getId-J3iCeTQ(), arg15.getPointerId-J3iCeTQ())) {
                    }
                    else {
                        ++v3;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_20;
            }

            v5 = v4;
        label_20:
            if(v5 == null) {
                v0 = arg13.getChanges();
                v1 = v0.size();
                v3 = 0;
                while(true) {
                    if(v3 < v1) {
                        v5 = v0.get(v3);
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

                    goto label_34;
                }

                v5 = v4;
            label_34:
                if(v5 == null) {
                    this.moveToAwaitDownState();
                    return;
                }

                arg15.setPointerId-0FcD4WY(((PointerInputChange)v5).getId-J3iCeTQ());
            }

            String v1_1 = "AwaitTouchSlop.touchSlopDetector was not initialized";
            String v3_1 = "AwaitTouchSlop.initialDown was not initialized";
            if(arg14 == PointerEventPass.Main) {
                if(((PointerInputChange)v5).isConsumed()) {
                    v13_1 = arg15.getInitialDown();
                    if(v13_1 != null) {
                        v6_1 = arg15.getPointerId-J3iCeTQ();
                        v0_2 = this.touchSlopDetector;
                        if(v0_2 != null) {
                            this.moveToAwaitGesturePickupState-rnUCldI(v13_1, v6_1, v0_2);
                            goto label_105;
                        }

                        throw new IllegalArgumentException(v1_1.toString());
                    }

                    throw new IllegalArgumentException(v3_1.toString());
                }
                else if(PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v5))) {
                    List v13 = arg13.getChanges();
                    int v0_1 = v13.size();
                    int v6 = 0;
                    while(v6 < v0_1) {
                        Object v7 = v13.get(v6);
                        if(v7.getPressed()) {
                            v4 = v7;
                        }
                        else {
                            ++v6;
                            continue;
                        }

                        break;
                    }

                    if(v4 == null) {
                        this.moveToAwaitDownState();
                        goto label_105;
                    }

                    arg15.setPointerId-0FcD4WY(((PointerInputChange)v4).getId-J3iCeTQ());
                }
                else {
                    v6_1 = this.requireTouchSlopDetector().addPositions-akrDWew(((PointerInputChange)v5).getPosition-F1C5BW0(), ((PointerInputChange)v5).getPreviousPosition-F1C5BW0(), DragGestureDetectorKt.pointerSlop-E8SPZFQ(CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalViewConfiguration()), ((PointerInputChange)v5).getType-T8wyACA()));
                    if((0x7FFFFFFF7FFFFFFFL & v6_1) != 0x7FC000007FC00000L) {
                        ((PointerInputChange)v5).consume();
                        v13_1 = arg15.getInitialDown();
                        Intrinsics.checkNotNull(v13_1);
                        this.sendDragStart-0AR0LA0(v13_1, ((PointerInputChange)v5), v6_1);
                        this.sendDragEvent-Uv8p0NA(((PointerInputChange)v5), v6_1);
                        this.moveToDraggingState-0FcD4WY(((PointerInputChange)v5).getId-J3iCeTQ());
                        goto label_105;
                    }

                    arg15.setVerifyConsumptionInFinalPass(true);
                }
            }

        label_105:
            if(arg14 != PointerEventPass.Final) {
                return;
            }

            if(!arg15.getVerifyConsumptionInFinalPass()) {
                return;
            }

            if(((PointerInputChange)v5).isConsumed()) {
                v13_1 = arg15.getInitialDown();
                if(v13_1 != null) {
                    long v14 = arg15.getPointerId-J3iCeTQ();
                    v0_2 = this.touchSlopDetector;
                    if(v0_2 != null) {
                        this.moveToAwaitGesturePickupState-rnUCldI(v13_1, v14, v0_2);
                        return;
                    }

                    throw new IllegalArgumentException(v1_1.toString());
                }

                throw new IllegalArgumentException(v3_1.toString());
            }

            arg15.setVerifyConsumptionInFinalPass(false);
        }
    }

    private final Object processDragCancel(Continuation arg7) {
        DragGestureNode$processDragCancel$1 v0_1;
        int v2;
        if((arg7 instanceof DragGestureNode$processDragCancel$1)) {
            Continuation v0 = arg7;
            v2 = 0x80000000;
            if((((DragGestureNode$processDragCancel$1)v0).label & v2) != 0) {
                ((DragGestureNode$processDragCancel$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new DragGestureNode$processDragCancel$1(this, arg7);
        }

        Object v7 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        Start v3 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v7);
            Start v7_1 = this.dragInteraction;
            if(v7_1 != null) {
                MutableInteractionSource v2_1 = this.interactionSource;
                if(v2_1 != null) {
                    Cancel v5 = new Cancel(v7_1);
                    v0_1.label = 1;
                    if(v2_1.emit(((Interaction)v5), ((Continuation)v0_1)) == v1) {
                        return v1;
                    }
                    else {
                        goto label_37;
                    }
                }
                else {
                label_37:
                    this.dragInteraction = v3;
                }
            }
        }
        else if(v2 == 1) {
            ResultKt.throwOnFailure(v7);
            goto label_37;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        this.onDragStopped(new DragStopped(Velocity.Companion.getZero-9UxMQ8M(), false, ((DefaultConstructorMarker)v3)));
        return Unit.INSTANCE;
    }

    private final Object processDragStart(DragStarted arg7, Continuation arg8) {
        Object v0_2;
        Object v7;
        MutableInteractionSource v2_1;
        Start v8_1;
        int v2;
        Continuation v0;
        if((arg8 instanceof DragGestureNode$processDragStart$1)) {
            v0 = arg8;
            v2 = 0x80000000;
            if((((DragGestureNode$processDragStart$1)v0).label & v2) != 0) {
                ((DragGestureNode$processDragStart$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            DragGestureNode$processDragStart$1 v0_1 = new DragGestureNode$processDragStart$1(this, arg8);
        }

        Object v8 = ((DragGestureNode$processDragStart$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((DragGestureNode$processDragStart$1)v0).label;
        int v3 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v8);
            v8_1 = this.dragInteraction;
            if(v8_1 != null) {
                v2_1 = this.interactionSource;
                if(v2_1 != null) {
                    Cancel v5 = new Cancel(v8_1);
                    ((DragGestureNode$processDragStart$1)v0).L$0 = arg7;
                    ((DragGestureNode$processDragStart$1)v0).label = 1;
                    if(v2_1.emit(((Interaction)v5), v0) == v1) {
                        return v1;
                    }
                    else {
                        goto label_44;
                    }
                }
                else {
                    goto label_44;
                }
            }
            else {
            label_44:
                v8_1 = new Start();
                v2_1 = this.interactionSource;
                if(v2_1 != null) {
                    ((DragGestureNode$processDragStart$1)v0).L$0 = v7;
                    ((DragGestureNode$processDragStart$1)v0).L$1 = v8_1;
                    ((DragGestureNode$processDragStart$1)v0).label = v3;
                    if(v2_1.emit(v8_1, v0) == v1) {
                        return v1;
                    }
                    else {
                        DragStarted v0_3 = ((DragStarted)v7);
                        Start v7_1 = v8_1;
                    label_57:
                        v8 = v7;
                        v7 = v0_2;
                    }
                }
            }
        }
        else if(v2 == 1) {
            v7 = ((DragGestureNode$processDragStart$1)v0).L$0;
            ResultKt.throwOnFailure(v8);
            goto label_44;
        }
        else if(v2 == v3) {
            v7 = ((DragGestureNode$processDragStart$1)v0).L$1;
            v0_2 = ((DragGestureNode$processDragStart$1)v0).L$0;
            ResultKt.throwOnFailure(v8);
            goto label_57;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        this.dragInteraction = v8_1;
        this.onDragStarted-k-4lQ0M(((DragStarted)v7).getStartPoint-F1C5BW0());
        return Unit.INSTANCE;
    }

    private final Object processDragStop(DragStopped arg6, Continuation arg7) {
        Object v6;
        int v2;
        Continuation v0;
        if((arg7 instanceof DragGestureNode$processDragStop$1)) {
            v0 = arg7;
            v2 = 0x80000000;
            if((((DragGestureNode$processDragStop$1)v0).label & v2) != 0) {
                ((DragGestureNode$processDragStop$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            DragGestureNode$processDragStop$1 v0_1 = new DragGestureNode$processDragStop$1(this, arg7);
        }

        Object v7 = ((DragGestureNode$processDragStop$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((DragGestureNode$processDragStop$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v7);
            Start v7_1 = this.dragInteraction;
            if(v7_1 != null) {
                MutableInteractionSource v2_1 = this.interactionSource;
                if(v2_1 != null) {
                    Stop v4 = new Stop(v7_1);
                    ((DragGestureNode$processDragStop$1)v0).L$0 = arg6;
                    ((DragGestureNode$processDragStop$1)v0).label = 1;
                    if(v2_1.emit(((Interaction)v4), v0) == v1) {
                        return v1;
                    }
                    else {
                        goto label_38;
                    }
                }
                else {
                label_38:
                    this.dragInteraction = null;
                }
            }
        }
        else if(v2 == 1) {
            v6 = ((DragGestureNode$processDragStop$1)v0).L$0;
            ResultKt.throwOnFailure(v7);
            goto label_38;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        this.onDragStopped(((DragStopped)v6));
        return Unit.INSTANCE;
    }

    private final void processDraggingState(PointerEvent arg10, PointerEventPass arg11, Dragging arg12) {
        List v10;
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

            if(PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v6))) {
                v10 = arg10.getChanges();
                int v11_1 = v10.size();
                goto label_27;
            }

            if(((PointerInputChange)v6).isConsumed()) {
                this.sendDragCancelled();
                return;
            }

            if(Offset.getDistance-impl(PointerEventKt.positionChangeIgnoreConsumed(((PointerInputChange)v6))) == 0f) {
                return;
            }

            this.sendDragEvent-Uv8p0NA(((PointerInputChange)v6), PointerEventKt.positionChange(((PointerInputChange)v6)));
            ((PointerInputChange)v6).consume();
            return;
        label_27:
            while(v3 < v11_1) {
                Object v0_1 = v10.get(v3);
                if(v0_1.getPressed()) {
                    v5 = v0_1;
                }
                else {
                    ++v3;
                    continue;
                }

                break;
            }

            if(v5 == null) {
                if((((PointerInputChange)v6).isConsumed()) || !PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v6))) {
                    this.sendDragCancelled();
                }
                else {
                    this.sendDragStopped(((PointerInputChange)v6));
                }

                this.moveToAwaitDownState();
                return;
            }

            arg12.setPointerId-0FcD4WY(((PointerInputChange)v5).getId-J3iCeTQ());
            return;
        }
    }

    private final void processInitialDownState(PointerEvent arg10, PointerEventPass arg11, AwaitDown arg12) {
        AwaitTouchSlop v10;
        if(arg10.getChanges().isEmpty()) {
        }
        else if(!TapGestureDetectorKt.isChangedToDown$default(arg10, false, false, 2, null)) {
        }
        else {
            Object v1 = CollectionsKt.first(arg10.getChanges());
            if(WhenMappings.$EnumSwitchMapping$0[arg12.getAwaitTouchSlop().ordinal()] != 1) {
                v10 = arg12.getAwaitTouchSlop();
            }
            else if(!this.startDragImmediately()) {
                v10 = AwaitTouchSlop.Yes;
            }
            else {
                v10 = AwaitTouchSlop.No;
            }

            arg12.setAwaitTouchSlop(v10);
            if(arg11 == PointerEventPass.Initial && v10 == AwaitTouchSlop.No) {
                ((PointerInputChange)v1).consume();
                arg12.setConsumedOnInitial(true);
            }

            if(arg11 != PointerEventPass.Main) {
                return;
            }

            if(v10 == AwaitTouchSlop.Yes) {
                DragGestureNode.moveToAwaitTouchSlopState-aWI9W7U$default(this, ((PointerInputChange)v1), ((PointerInputChange)v1).getId-J3iCeTQ(), 0, false, 12, null);
                return;
            }

            DragGestureNode v0 = this;
            if(!arg12.getConsumedOnInitial()) {
                return;
            }

            v0.sendDragStart-0AR0LA0(((PointerInputChange)v1), ((PointerInputChange)v1), Offset.Companion.getZero-F1C5BW0());
            v0.sendDragEvent-Uv8p0NA(((PointerInputChange)v1), Offset.Companion.getZero-F1C5BW0());
            v0.moveToDraggingState-0FcD4WY(((PointerInputChange)v1).getId-J3iCeTQ());
        }
    }

    private final void processRawPointerEvent(PointerEvent arg3, PointerEventPass arg4) {
        DragDetectionState v0 = this.currentDragState;
        if(v0 != null) {
            if((v0 instanceof AwaitDown)) {
                this.processInitialDownState(arg3, arg4, ((AwaitDown)v0));
                return;
            }

            if((v0 instanceof androidx.compose.foundation.gestures.DragDetectionState$AwaitTouchSlop)) {
                this.processAwaitTouchSlop(arg3, arg4, ((androidx.compose.foundation.gestures.DragDetectionState$AwaitTouchSlop)v0));
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

    private final Channel requireChannel() {
        Channel v1 = this.channel;
        if(v1 != null) {
            return v1;
        }

        throw new IllegalArgumentException("Events channel not initialized.".toString());
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

    private final void resetDragDetectionState() {
        this.moveToAwaitDownState();
        if(this.isListeningForEvents) {
            this.sendDragCancelled();
        }

        this.velocityTracker = null;
    }

    private final void sendDragCancelled() {
        this.requireChannel().trySend-JP2dKIU(DragCancelled.INSTANCE);
    }

    private final void sendDragEvent-Uv8p0NA(PointerInputChange arg7, long arg8) {
        long v0 = LayoutCoordinatesKt.positionOnScreen(DelegatableNodeKt.requireLayoutCoordinates(this.getNode()));
        if(!Offset.equals-impl0(this.previousPositionOnScreen, Offset.Companion.getUnspecified-F1C5BW0()) && !Offset.equals-impl0(v0, this.previousPositionOnScreen)) {
            this.nodeOffset = Offset.plus-MK-Hz9U(this.nodeOffset, Offset.minus-MK-Hz9U(v0, this.previousPositionOnScreen));
        }

        this.previousPositionOnScreen = v0;
        VelocityTrackerKt.addPointerInputChange-0AR0LA0(this.requireVelocityTracker(), arg7, this.nodeOffset);
        this.requireChannel().trySend-JP2dKIU(new DragDelta(arg8, false, null));
    }

    private final void sendDragStart-0AR0LA0(PointerInputChange arg3, PointerInputChange arg4, long arg5) {
        if(this.velocityTracker == null) {
            this.velocityTracker = new VelocityTracker();
        }

        VelocityTrackerKt.addPointerInputChange(this.requireVelocityTracker(), arg3);
        long v4 = Offset.minus-MK-Hz9U(arg4.getPosition-F1C5BW0(), arg5);
        this.nodeOffset = Offset.Companion.getZero-F1C5BW0();
        if(this.canDrag.invoke(PointerType.box-impl(arg3.getType-T8wyACA())).booleanValue()) {
            BufferOverflow v6 = null;
            if(!this.isListeningForEvents) {
                if(this.channel == null) {
                    this.channel = ChannelKt.Channel$default(0x7FFFFFFF, v6, ((Function1)v6), 6, v6);
                }

                this.startListeningForEvents();
            }

            this.previousPositionOnScreen = LayoutCoordinatesKt.positionOnScreen(DelegatableNodeKt.requireLayoutCoordinates(this));
            this.requireChannel().trySend-JP2dKIU(new DragStarted(v4, ((DefaultConstructorMarker)v6)));
        }
    }

    private final void sendDragStopped(PointerInputChange arg6) {
        VelocityTrackerKt.addPointerInputChange(this.requireVelocityTracker(), arg6);
        float v6 = CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalViewConfiguration()).getMaximumFlingVelocity();
        long v0 = this.requireVelocityTracker().calculateVelocity-AH228Gc(VelocityKt.Velocity(v6, v6));
        this.requireVelocityTracker().resetTracking();
        this.requireChannel().trySend-JP2dKIU(new DragStopped(DraggableKt.toValidVelocity-TH1AsA0(v0), false, null));
        this.isListeningForPointerInputEvents = false;
    }

    public final void setListeningForEvents$foundation(boolean arg1) {
        this.isListeningForEvents = arg1;
    }

    public final void setListeningForPointerInputEvents$foundation(boolean arg1) {
        this.isListeningForPointerInputEvents = arg1;
    }

    public final void setOrientationLock(Orientation arg1) {
        this.orientationLock = arg1;
    }

    public abstract boolean startDragImmediately();

    private final void startListeningForEvents() {
        this.isListeningForEvents = true;
        BufferOverflow v1 = null;
        if(this.channel == null) {
            this.channel = ChannelKt.Channel$default(0x7FFFFFFF, v1, ((Function1)v1), 6, v1);
        }

        BuildersKt.launch$default(this.getCoroutineScope(), null, null, new DragGestureNode$startListeningForEvents$1(this, ((Continuation)v1)), 3, null);
    }

    public final void update(Function1 arg2, boolean arg3, MutableInteractionSource arg4, Orientation arg5, boolean arg6) {
        this.canDrag = arg2;
        int v0 = 1;
        if(this.enabled != arg3) {
            this.enabled = arg3;
            if(!arg3) {
                this.disposeInteractionSource();
                SuspendingPointerInputModifierNode v2 = this.pointerInputNode;
                if(v2 != null) {
                    this.undelegate(((DelegatableNode)v2));
                }

                this.pointerInputNode = null;
                this.indirectPointerInputDragCycleDetector = null;
            }
        }

        if(!Intrinsics.areEqual(this.interactionSource, arg4)) {
            this.disposeInteractionSource();
            this.interactionSource = arg4;
        }

        if(this.orientationLock != arg5) {
            this.orientationLock = arg5;
        }
        else {
            v0 = 1;
        }

        if(v0 != 0) {
            if((ComposeFoundationFlags.isNonSuspendingPointerInputInDraggableEnabled) && (this.isListeningForPointerInputEvents)) {
                this.resetDragDetectionState();
            }

            IndirectPointerInputDragCycleDetector v2_1 = this.indirectPointerInputDragCycleDetector;
            if(v2_1 != null) {
                v2_1.resetDragDetectionState();
            }

            SuspendingPointerInputModifierNode v1 = this.pointerInputNode;
            if(v1 == null) {
                return;
            }

            v1.resetPointerInputHandler();
        }
    }

    public static void update$default(DragGestureNode arg0, Function1 arg1, boolean arg2, MutableInteractionSource arg3, Orientation arg4, boolean arg5, int arg6, Object arg7) {
        if(arg7 == null) {
            if((arg6 & 1) != 0) {
                arg1 = arg0.canDrag;
            }

            if((arg6 & 2) != 0) {
                arg2 = arg0.enabled;
            }

            if((arg6 & 4) != 0) {
                arg3 = arg0.interactionSource;
            }

            if((arg6 & 8) != 0) {
                arg4 = arg0.orientationLock;
            }

            arg0.update(arg1, arg2, arg3, arg4, false);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update");
    }
}

