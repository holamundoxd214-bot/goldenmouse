package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001B\u0012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J?\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u00102\'\u0010\u0011\u001A#\b\u0001\u0012\u0004\u0012\u00020\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012¢\u0006\u0002\b\u0015H\u0096@¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001A\u00020\u00052\u0006\u0010\u0018\u001A\u00020\u0004H\u0016R\u001D\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2={"Landroidx/compose/foundation/gestures/DefaultDraggableState;", "Landroidx/compose/foundation/gestures/DraggableState;", "onDelta", "Lkotlin/Function1;", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnDelta", "()Lkotlin/jvm/functions/Function1;", "dragScope", "Landroidx/compose/foundation/gestures/DragScope;", "scrollMutex", "Landroidx/compose/foundation/MutatorMutex;", "drag", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "delta", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class DefaultDraggableState implements DraggableState {
    private final DragScope dragScope;
    private final Function1 onDelta;
    private final MutatorMutex scrollMutex;

    public DefaultDraggableState(Function1 arg1) {
        super();
        this.onDelta = arg1;
        this.dragScope = new DefaultDraggableState$dragScope$1(this);
        this.scrollMutex = new MutatorMutex();
    }

    public static final DragScope access$getDragScope$p(DefaultDraggableState arg0) {
        return arg0.dragScope;
    }

    public static final MutatorMutex access$getScrollMutex$p(DefaultDraggableState arg0) {
        return arg0.scrollMutex;
    }

    public void dispatchRawDelta(float arg1) {
        this.onDelta.invoke(Float.valueOf(arg1));
    }

    public Object drag(MutatePriority arg3, Function2 arg4, Continuation arg5) {
        Object v2 = CoroutineScopeKt.coroutineScope(new DefaultDraggableState$drag$2(this, arg3, arg4, null), arg5);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    public final Function1 getOnDelta() {
        return this.onDelta;
    }
}

