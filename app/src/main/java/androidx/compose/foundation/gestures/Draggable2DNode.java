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
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u008B\u0001\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\b\u0010\t\u001A\u0004\u0018\u00010\n\u0012\u0006\u0010\u000B\u001A\u00020\u0007\u0012\u0006\u0010\f\u001A\u00020\u0007\u0012!\u0010\r\u001A\u001D\u0012\u0013\u0012\u00110\u000E¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u0005\u0012!\u0010\u0013\u001A\u001D\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00120\u0005¢\u0006\u0004\b\u0016\u0010\u0017JM\u0010\u0018\u001A\u00020\u00122=\u0010\u0019\u001A9\b\u0001\u0012\u001F\u0012\u001D\u0012\u0013\u0012\u00110\u001B¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u001C\u0012\u0004\u0012\u00020\u00120\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001D\u0012\u0006\u0012\u0004\u0018\u00010\u001E0\u001AH\u0096@¢\u0006\u0002\u0010\u001FJ\u0017\u0010\r\u001A\u00020\u00122\u0006\u0010\u0011\u001A\u00020\u000EH\u0016¢\u0006\u0004\b \u0010!J\u0010\u0010\u0013\u001A\u00020\u00122\u0006\u0010\"\u001A\u00020#H\u0016J\b\u0010\u000B\u001A\u00020\u0007H\u0016J\u008A\u0001\u0010$\u001A\u00020\u00122\u0006\u0010\u0002\u001A\u00020\u00032\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001A\u00020\u00072\b\u0010\t\u001A\u0004\u0018\u00010\n2\u0006\u0010\u000B\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u00072!\u0010\r\u001A\u001D\u0012\u0013\u0012\u00110\u000E¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u00052!\u0010\u0013\u001A\u001D\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00120\u0005J\u0014\u0010%\u001A\u00020\u000E*\u00020\u000EH\u0082\b¢\u0006\u0004\b&\u0010\'R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R)\u0010\r\u001A\u001D\u0012\u0013\u0012\u00110\u000E¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R)\u0010\u0013\u001A\u001D\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00120\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006("}, d2={"Landroidx/compose/foundation/gestures/Draggable2DNode;", "Landroidx/compose/foundation/gestures/DragGestureNode;", "state", "Landroidx/compose/foundation/gestures/Draggable2DState;", "canDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerType;", "", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "reverseDirection", "onDragStarted", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "", "onDragStopped", "Landroidx/compose/ui/unit/Velocity;", "velocity", "<init>", "(Landroidx/compose/foundation/gestures/Draggable2DState;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "drag", "forEachDelta", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "dragDelta", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStarted-k-4lQ0M", "(J)V", "event", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "update", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "(J)J", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Draggable2DNode extends DragGestureNode {
    public static final int $stable = 8;
    private Function1 onDragStarted;
    private Function1 onDragStopped;
    private boolean reverseDirection;
    private boolean startDragImmediately;
    private Draggable2DState state;

    static {
    }

    public Draggable2DNode(Draggable2DState arg2, Function1 arg3, boolean arg4, MutableInteractionSource arg5, boolean arg6, boolean arg7, Function1 arg8, Function1 arg9) {
        super(arg3, arg4, arg5, null);
        this.state = arg2;
        this.startDragImmediately = arg6;
        this.reverseDirection = arg7;
        this.onDragStarted = arg8;
        this.onDragStopped = arg9;
    }

    public static final boolean access$getReverseDirection$p(Draggable2DNode arg0) {
        return arg0.reverseDirection;
    }

    public Object drag(Function2 arg5, Continuation arg6) {
        Object v4 = this.state.drag(MutatePriority.UserInput, new Draggable2DNode$drag$2(arg5, this, null), arg6);
        if(v4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v4;
        }

        return Unit.INSTANCE;
    }

    public void onDragStarted-k-4lQ0M(long arg1) {
        this.onDragStarted.invoke(Offset.box-impl(arg1));
    }

    public void onDragStopped(DragStopped arg3) {
        this.onDragStopped.invoke(Velocity.box-impl(arg3.getVelocity-9UxMQ8M()));
    }

    private final long reverseIfNeeded-MK-Hz9U(long arg3) {
        if(this.reverseDirection) {
            return Offset.constructor-impl(arg3 ^ -9223372034707292160L);
        }

        return arg3;
    }

    public boolean startDragImmediately() {
        return this.startDragImmediately;
    }

    public final void update(Draggable2DState arg3, Function1 arg4, boolean arg5, MutableInteractionSource arg6, boolean arg7, boolean arg8, Function1 arg9, Function1 arg10) {
        boolean v3;
        boolean v1 = true;
        if(!Intrinsics.areEqual(this.state, arg3)) {
            this.state = arg3;
            v3 = true;
        }
        else {
            v3 = false;
        }

        if(this.reverseDirection != arg8) {
            this.reverseDirection = arg8;
        }
        else {
            v1 = v3;
        }

        this.onDragStarted = arg9;
        this.onDragStopped = arg10;
        this.startDragImmediately = arg7;
        this.update(arg4, arg5, arg6, null, v1);
    }
}

