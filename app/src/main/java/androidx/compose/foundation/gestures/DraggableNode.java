package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1={"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001BÉ\u0001\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u0007\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001A\u00020\u0007\u0012<\u0010\u000E\u001A8\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000F¢\u0006\u0002\b\u0018\u0012<\u0010\u0019\u001A8\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u001A¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001B\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000F¢\u0006\u0002\b\u0018\u0012\u0006\u0010\u001C\u001A\u00020\u0007¢\u0006\u0004\b\u001D\u0010\u001EJM\u0010 \u001A\u00020\u00162=\u0010!\u001A9\b\u0001\u0012\u001F\u0012\u001D\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00160\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\"H\u0096@¢\u0006\u0002\u0010%J\u0017\u0010\u000E\u001A\u00020\u00162\u0006\u0010\u0014\u001A\u00020\u0011H\u0016¢\u0006\u0004\b&\u0010\'J\u0010\u0010\u0019\u001A\u00020\u00162\u0006\u0010(\u001A\u00020)H\u0016J\b\u0010\r\u001A\u00020\u0007H\u0016JÍ\u0001\u0010*\u001A\u00020\u00162\u0006\u0010\u0002\u001A\u00020\u00032\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u00072\b\u0010\u000B\u001A\u0004\u0018\u00010\f2\u0006\u0010\r\u001A\u00020\u00072<\u0010\u000E\u001A8\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000F¢\u0006\u0002\b\u00182<\u0010\u0019\u001A8\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u001A¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001B\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000F¢\u0006\u0002\b\u00182\u0006\u0010\u001C\u001A\u00020\u0007¢\u0006\u0002\u0010\u001EJ\u0013\u0010+\u001A\u00020,*\u00020,H\u0002¢\u0006\u0004\b-\u0010.J\u0013\u0010+\u001A\u00020\u0011*\u00020\u0011H\u0002¢\u0006\u0004\b/\u0010.R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000RF\u0010\u000E\u001A8\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000F¢\u0006\u0002\b\u0018X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u001FRF\u0010\u0019\u001A8\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u001A¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001B\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000F¢\u0006\u0002\b\u0018X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u001FR\u000E\u0010\u001C\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000¨\u00060"}, d2={"Landroidx/compose/foundation/gestures/DraggableNode;", "Landroidx/compose/foundation/gestures/DragGestureNode;", "state", "Landroidx/compose/foundation/gestures/DraggableState;", "canDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerType;", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "", "velocity", "reverseDirection", "<init>", "(Landroidx/compose/foundation/gestures/DraggableState;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)V", "Lkotlin/jvm/functions/Function3;", "drag", "forEachDelta", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "dragDelta", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStarted-k-4lQ0M", "(J)V", "event", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "update", "reverseIfNeeded", "Landroidx/compose/ui/unit/Velocity;", "reverseIfNeeded-AH228Gc", "(J)J", "reverseIfNeeded-MK-Hz9U", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DraggableNode extends DragGestureNode {
    public static final int $stable = 8;
    private Function3 onDragStarted;
    private Function3 onDragStopped;
    private Orientation orientation;
    private boolean reverseDirection;
    private boolean startDragImmediately;
    private DraggableState state;

    static {
    }

    public DraggableNode(DraggableState arg1, Function1 arg2, Orientation arg3, boolean arg4, MutableInteractionSource arg5, boolean arg6, Function3 arg7, Function3 arg8, boolean arg9) {
        super(arg2, arg4, arg5, arg3);
        this.state = arg1;
        this.orientation = arg3;
        this.startDragImmediately = arg6;
        this.onDragStarted = arg7;
        this.onDragStopped = arg8;
        this.reverseDirection = arg9;
    }

    public static final Function3 access$getOnDragStarted$p(DraggableNode arg0) {
        return arg0.onDragStarted;
    }

    public static final Function3 access$getOnDragStopped$p(DraggableNode arg0) {
        return arg0.onDragStopped;
    }

    public static final Orientation access$getOrientation$p(DraggableNode arg0) {
        return arg0.orientation;
    }

    public static final long access$reverseIfNeeded-AH228Gc(DraggableNode arg0, long arg1) {
        return arg0.reverseIfNeeded-AH228Gc(arg1);
    }

    public static final long access$reverseIfNeeded-MK-Hz9U(DraggableNode arg0, long arg1) {
        return arg0.reverseIfNeeded-MK-Hz9U(arg1);
    }

    public Object drag(Function2 arg5, Continuation arg6) {
        Object v4 = this.state.drag(MutatePriority.UserInput, new DraggableNode$drag$2(arg5, this, null), arg6);
        if(v4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v4;
        }

        return Unit.INSTANCE;
    }

    public void onDragStarted-k-4lQ0M(long arg8) {
        if(this.isAttached()) {
            if(Intrinsics.areEqual(this.onDragStarted, DraggableKt.NoOpOnDragStarted)) {
            }
            else {
                BuildersKt.launch$default(this.getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new DraggableNode$onDragStarted$1(this, arg8, null), 1, null);
            }
        }
    }

    public void onDragStopped(DragStopped arg8) {
        if(this.isAttached()) {
            if(Intrinsics.areEqual(this.onDragStopped, DraggableKt.NoOpOnDragStopped)) {
            }
            else {
                BuildersKt.launch$default(this.getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new DraggableNode$onDragStopped$1(this, arg8, null), 1, null);
            }
        }
    }

    private final long reverseIfNeeded-AH228Gc(long arg1) {
        float v0 = this.reverseDirection ? -1f : 1f;
        return Velocity.times-adjELrA(arg1, v0);
    }

    private final long reverseIfNeeded-MK-Hz9U(long arg1) {
        float v0 = this.reverseDirection ? -1f : 1f;
        return Offset.times-tuRUvjQ(arg1, v0);
    }

    public boolean startDragImmediately() {
        return this.startDragImmediately;
    }

    public final void update(DraggableState arg3, Function1 arg4, Orientation arg5, boolean arg6, MutableInteractionSource arg7, boolean arg8, Function3 arg9, Function3 arg10, boolean arg11) {
        boolean v3;
        boolean v1 = true;
        if(!Intrinsics.areEqual(this.state, arg3)) {
            this.state = arg3;
            v3 = true;
        }
        else {
            v3 = false;
        }

        if(this.orientation != arg5) {
            this.orientation = arg5;
            v3 = true;
        }

        if(this.reverseDirection != arg11) {
            this.reverseDirection = arg11;
        }
        else {
            v1 = v3;
        }

        this.onDragStarted = arg9;
        this.onDragStopped = arg10;
        this.startDragImmediately = arg8;
        this.update(arg4, arg6, arg7, arg5, v1);
    }
}

