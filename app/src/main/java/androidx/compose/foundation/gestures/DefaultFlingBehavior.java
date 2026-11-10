package androidx.compose.foundation.gestures;

import androidx.compose.animation.SplineBasedDecayKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001F\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001A\u0010\u000F\u001A\u00020\u0004*\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0004H\u0096@¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0016H\u0016R\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\t\u001A\u00020\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000E¨\u0006\u0017"}, d2={"Landroidx/compose/foundation/gestures/DefaultFlingBehavior;", "Landroidx/compose/foundation/gestures/ScrollableDefaultFlingBehavior;", "flingDecay", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "motionDurationScale", "Landroidx/compose/ui/MotionDurationScale;", "<init>", "(Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/ui/MotionDurationScale;)V", "lastAnimationCycleCount", "", "getLastAnimationCycleCount", "()I", "setLastAnimationCycleCount", "(I)V", "performFling", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDensity", "", "density", "Landroidx/compose/ui/unit/Density;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DefaultFlingBehavior implements ScrollableDefaultFlingBehavior {
    public static final int $stable;
    private DecayAnimationSpec flingDecay;
    private int lastAnimationCycleCount;
    private final MotionDurationScale motionDurationScale;

    static {
    }

    public DefaultFlingBehavior(DecayAnimationSpec arg1, MotionDurationScale arg2) {
        super();
        this.flingDecay = arg1;
        this.motionDurationScale = arg2;
    }

    public DefaultFlingBehavior(DecayAnimationSpec arg1, MotionDurationScale arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = ScrollableKt.getDefaultScrollMotionDurationScale();
        }

        this(arg1, arg2);
    }

    public static final DecayAnimationSpec access$getFlingDecay$p(DefaultFlingBehavior arg0) {
        return arg0.flingDecay;
    }

    public final int getLastAnimationCycleCount() {
        return this.lastAnimationCycleCount;
    }

    public Object performFling(ScrollScope arg4, float arg5, Continuation arg6) {
        this.lastAnimationCycleCount = 0;
        return BuildersKt.withContext(this.motionDurationScale, new DefaultFlingBehavior$performFling$2(arg5, this, arg4, null), arg6);
    }

    public final void setLastAnimationCycleCount(int arg1) {
        this.lastAnimationCycleCount = arg1;
    }

    public void updateDensity(Density arg1) {
        this.flingDecay = SplineBasedDecayKt.splineBasedDecay(arg1);
    }
}

