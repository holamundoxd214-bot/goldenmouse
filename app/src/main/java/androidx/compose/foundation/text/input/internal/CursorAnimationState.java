package androidx.compose.foundation.text.input.internal;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010\u0016\u001A\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001A\u00020\u0017R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R$\u0010\b\u001A\u0016\u0012\u0006\u0012\u0004\u0018\u00010\n0\tj\n\u0012\u0006\u0012\u0004\u0018\u00010\n`\u000BX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\fR+\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\u000E8F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001A"}, d2={"Landroidx/compose/foundation/text/input/internal/CursorAnimationState;", "", "animate", "", "<init>", "(Z)V", "getAnimate", "()Z", "animationJob", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlinx/coroutines/Job;", "Landroidx/compose/foundation/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "<set-?>", "", "cursorAlpha", "getCursorAlpha", "()F", "setCursorAlpha", "(F)V", "cursorAlpha$delegate", "Landroidx/compose/runtime/MutableFloatState;", "snapToVisibleAndAnimate", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelAndHide", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CursorAnimationState {
    public static final int $stable = 8;
    private final boolean animate;
    private AtomicReference animationJob;
    private final MutableFloatState cursorAlpha$delegate;

    static {
    }

    public CursorAnimationState(boolean arg2) {
        super();
        this.animate = arg2;
        this.animationJob = new AtomicReference(null);
        this.cursorAlpha$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0f);
    }

    public static final AtomicReference access$getAnimationJob$p(CursorAnimationState arg0) {
        return arg0.animationJob;
    }

    public static final void access$setCursorAlpha(CursorAnimationState arg0, float arg1) {
        arg0.setCursorAlpha(arg1);
    }

    public final void cancelAndHide() {
        Object v0 = null;
        Object v2 = this.animationJob.getAndSet(v0);
        if(v2 != null) {
            DefaultImpls.cancel$default(((Job)v2), ((CancellationException)v0), 1, v0);
        }
    }

    public final boolean getAnimate() {
        return this.animate;
    }

    public final float getCursorAlpha() {
        return this.cursorAlpha$delegate.getFloatValue();
    }

    private final void setCursorAlpha(float arg1) {
        this.cursorAlpha$delegate.setFloatValue(arg1);
    }

    public final Object snapToVisibleAndAnimate(Continuation arg3) {
        Object v2 = CoroutineScopeKt.coroutineScope(new CursorAnimationState$snapToVisibleAndAnimate$2(this, null), arg3);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }
}

