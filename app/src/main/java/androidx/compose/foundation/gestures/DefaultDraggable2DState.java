package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001B\u0012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J?\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u00102\'\u0010\u0011\u001A#\b\u0001\u0012\u0004\u0012\u00020\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012¢\u0006\u0002\b\u0015H\u0096@¢\u0006\u0002\u0010\u0016J\u0017\u0010\u0017\u001A\u00020\u00052\u0006\u0010\u0018\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u001AR\u001D\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2={"Landroidx/compose/foundation/gestures/DefaultDraggable2DState;", "Landroidx/compose/foundation/gestures/Draggable2DState;", "onDelta", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnDelta", "()Lkotlin/jvm/functions/Function1;", "drag2DScope", "Landroidx/compose/foundation/gestures/Drag2DScope;", "drag2DMutex", "Landroidx/compose/foundation/MutatorMutex;", "drag", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "delta", "dispatchRawDelta-k-4lQ0M", "(J)V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class DefaultDraggable2DState implements Draggable2DState {
    private final MutatorMutex drag2DMutex;
    private final Drag2DScope drag2DScope;
    private final Function1 onDelta;

    public DefaultDraggable2DState(Function1 arg1) {
        super();
        this.onDelta = arg1;
        this.drag2DScope = new DefaultDraggable2DState$drag2DScope$1(this);
        this.drag2DMutex = new MutatorMutex();
    }

    public static final MutatorMutex access$getDrag2DMutex$p(DefaultDraggable2DState arg0) {
        return arg0.drag2DMutex;
    }

    public static final Drag2DScope access$getDrag2DScope$p(DefaultDraggable2DState arg0) {
        return arg0.drag2DScope;
    }

    public void dispatchRawDelta-k-4lQ0M(long arg1) {
        this.onDelta.invoke(Offset.box-impl(arg1));
    }

    public Object drag(MutatePriority arg3, Function2 arg4, Continuation arg5) {
        Object v2 = CoroutineScopeKt.coroutineScope(new DefaultDraggable2DState$drag$2(this, arg3, arg4, null), arg5);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    public final Function1 getOnDelta() {
        return this.onDelta;
    }
}

