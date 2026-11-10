package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u001B\u0012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J?\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\'\u0010\u0016\u001A#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017¢\u0006\u0002\b\u001AH\u0096@¢\u0006\u0002\u0010\u001BJ\u0010\u0010\u001C\u001A\u00020\u00042\u0006\u0010\u001D\u001A\u00020\u0004H\u0016R\u001D\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001E\u001A\u00020\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001FR\u0014\u0010 \u001A\u00020\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\u001FR\u0014\u0010\"\u001A\u00020\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b#\u0010\u001F¨\u0006$"}, d2={"Landroidx/compose/foundation/gestures/DefaultScrollableState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "onDelta", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnDelta", "()Lkotlin/jvm/functions/Function1;", "scrollScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "scrollMutex", "Landroidx/compose/foundation/MutatorMutex;", "isScrollingState", "Landroidx/compose/runtime/MutableState;", "", "isLastScrollForwardState", "isLastScrollBackwardState", "scroll", "", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "delta", "isScrollInProgress", "()Z", "lastScrolledForward", "getLastScrolledForward", "lastScrolledBackward", "getLastScrolledBackward", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class DefaultScrollableState implements ScrollableState {
    private final MutableState isLastScrollBackwardState;
    private final MutableState isLastScrollForwardState;
    private final MutableState isScrollingState;
    private final Function1 onDelta;
    private final MutatorMutex scrollMutex;
    private final ScrollScope scrollScope;

    public DefaultScrollableState(Function1 arg4) {
        super();
        this.onDelta = arg4;
        this.scrollScope = new DefaultScrollableState$scrollScope$1(this);
        this.scrollMutex = new MutatorMutex();
        Boolean v4 = Boolean.valueOf(false);
        this.isScrollingState = SnapshotStateKt.mutableStateOf$default(v4, null, 2, null);
        this.isLastScrollForwardState = SnapshotStateKt.mutableStateOf$default(v4, null, 2, null);
        this.isLastScrollBackwardState = SnapshotStateKt.mutableStateOf$default(v4, null, 2, null);
    }

    public static final MutatorMutex access$getScrollMutex$p(DefaultScrollableState arg0) {
        return arg0.scrollMutex;
    }

    public static final ScrollScope access$getScrollScope$p(DefaultScrollableState arg0) {
        return arg0.scrollScope;
    }

    public static final MutableState access$isLastScrollBackwardState$p(DefaultScrollableState arg0) {
        return arg0.isLastScrollBackwardState;
    }

    public static final MutableState access$isLastScrollForwardState$p(DefaultScrollableState arg0) {
        return arg0.isLastScrollForwardState;
    }

    public static final MutableState access$isScrollingState$p(DefaultScrollableState arg0) {
        return arg0.isScrollingState;
    }

    public float dispatchRawDelta(float arg1) {
        return this.onDelta.invoke(Float.valueOf(arg1)).floatValue();
    }

    public boolean getLastScrolledBackward() {
        return this.isLastScrollBackwardState.getValue().booleanValue();
    }

    public boolean getLastScrolledForward() {
        return this.isLastScrollForwardState.getValue().booleanValue();
    }

    public final Function1 getOnDelta() {
        return this.onDelta;
    }

    public boolean isScrollInProgress() {
        return this.isScrollingState.getValue().booleanValue();
    }

    public Object scroll(MutatePriority arg3, Function2 arg4, Continuation arg5) {
        Object v2 = CoroutineScopeKt.coroutineScope(new DefaultScrollableState$scroll$2(this, arg3, arg4, null), arg5);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }
}

