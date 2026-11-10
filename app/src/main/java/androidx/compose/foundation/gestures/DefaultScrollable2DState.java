package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u001B\u0012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J?\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\'\u0010\u0014\u001A#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015¢\u0006\u0002\b\u0018H\u0096@¢\u0006\u0002\u0010\u0019J\u0017\u0010\u001A\u001A\u00020\u00042\u0006\u0010\u001B\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u001C\u0010\u001DJ\u0017\u0010 \u001A\u00020\u000F2\u0006\u0010!\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010#R\u001D\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001E\u001A\u00020\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001F¨\u0006$"}, d2={"Landroidx/compose/foundation/gestures/DefaultScrollable2DState;", "Landroidx/compose/foundation/gestures/Scrollable2DState;", "onDelta", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnDelta", "()Lkotlin/jvm/functions/Function1;", "scrollScope", "Landroidx/compose/foundation/gestures/Scroll2DScope;", "scrollMutex", "Landroidx/compose/foundation/MutatorMutex;", "isScrollingState", "Landroidx/compose/runtime/MutableState;", "", "scroll", "", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "delta", "dispatchRawDelta-MK-Hz9U", "(J)J", "isScrollInProgress", "()Z", "canScroll", "offset", "canScroll-k-4lQ0M", "(J)Z", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class DefaultScrollable2DState implements Scrollable2DState {
    private final MutableState isScrollingState;
    private final Function1 onDelta;
    private final MutatorMutex scrollMutex;
    private final Scroll2DScope scrollScope;

    public DefaultScrollable2DState(Function1 arg3) {
        super();
        this.onDelta = arg3;
        this.scrollScope = new DefaultScrollable2DState$scrollScope$1(this);
        this.scrollMutex = new MutatorMutex();
        this.isScrollingState = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), null, 2, null);
    }

    public static final MutatorMutex access$getScrollMutex$p(DefaultScrollable2DState arg0) {
        return arg0.scrollMutex;
    }

    public static final Scroll2DScope access$getScrollScope$p(DefaultScrollable2DState arg0) {
        return arg0.scrollScope;
    }

    public static final MutableState access$isScrollingState$p(DefaultScrollable2DState arg0) {
        return arg0.isScrollingState;
    }

    public boolean canScroll-k-4lQ0M(long arg1) {
        return 1;
    }

    public long dispatchRawDelta-MK-Hz9U(long arg1) {
        return this.onDelta.invoke(Offset.box-impl(arg1)).unbox-impl();
    }

    public final Function1 getOnDelta() {
        return this.onDelta;
    }

    public boolean isScrollInProgress() {
        return this.isScrollingState.getValue().booleanValue();
    }

    public Object scroll(MutatePriority arg3, Function2 arg4, Continuation arg5) {
        Object v2 = CoroutineScopeKt.coroutineScope(new DefaultScrollable2DState$scroll$2(this, arg3, arg4, null), arg5);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }
}

