package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.snapshots.Snapshot$Companion;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.unit.Density;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00052\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u001BH\u0000¢\u0006\u0002\b\u001CJ\r\u0010\u001D\u001A\u00020\u0016H\u0000¢\u0006\u0002\b\u001ER\u0014\u0010\u0004\u001A\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u001C\u0010\b\u001A\u0004\u0018\u00010\tX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u0014\u0010\u000E\u001A\u00020\u000F8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u001A\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollDeltaBetweenPasses;", "", "<init>", "()V", "scrollDeltaBetweenPasses", "", "getScrollDeltaBetweenPasses$foundation", "()F", "job", "Lkotlinx/coroutines/Job;", "getJob$foundation", "()Lkotlinx/coroutines/Job;", "setJob$foundation", "(Lkotlinx/coroutines/Job;)V", "isActive", "", "isActive$foundation", "()Z", "_scrollDeltaBetweenPasses", "Landroidx/compose/animation/core/AnimationState;", "Landroidx/compose/animation/core/AnimationVector1D;", "updateScrollDeltaForApproach", "", "delta", "density", "Landroidx/compose/ui/unit/Density;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "updateScrollDeltaForApproach$foundation", "stop", "stop$foundation", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyLayoutScrollDeltaBetweenPasses {
    public static final int $stable = 8;
    private AnimationState _scrollDeltaBetweenPasses;
    private Job job;

    static {
    }

    public LazyLayoutScrollDeltaBetweenPasses() {
        super();
        TwoWayConverter v1 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        Float v2 = Float.valueOf(0f);
        this._scrollDeltaBetweenPasses = AnimationStateKt.AnimationState$default(v1, v2, v2, 0, 0, false, 56, null);
    }

    public static final AnimationState access$get_scrollDeltaBetweenPasses$p(LazyLayoutScrollDeltaBetweenPasses arg0) {
        return arg0._scrollDeltaBetweenPasses;
    }

    public final Job getJob$foundation() {
        return this.job;
    }

    public final float getScrollDeltaBetweenPasses$foundation() {
        return this._scrollDeltaBetweenPasses.getValue().floatValue();
    }

    public final boolean isActive$foundation() {
        int v1 = Float.compare(this._scrollDeltaBetweenPasses.getValue().floatValue(), 0f) == 0 ? 1 : 0;
        return v1 ^ 1;
    }

    public final void setJob$foundation(Job arg1) {
        this.job = arg1;
    }

    public final void stop$foundation() {
        Job v0 = this.job;
        if(v0 != null) {
            DefaultImpls.cancel$default(v0, null, 1, null);
        }

        this._scrollDeltaBetweenPasses = new AnimationState(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(0f), null, 0, 0, false, 60, null);
    }

    public final void updateScrollDeltaForApproach$foundation(float arg20, Density arg21, CoroutineScope arg22) {
        LazyLayoutScrollDeltaBetweenPasses v0 = this;
        float v1 = arg20;
        if(v1 <= arg21.toPx-0680j_4(LazyLayoutScrollDeltaBetweenPassesKt.access$getDeltaThresholdForScrollAnimation$p())) {
            return;
        }

        Companion v2 = Snapshot.Companion;
        Snapshot v3 = v2.getCurrentThreadSnapshot();
        CancellationException v4 = null;
        Function1 v5 = v3 != null ? v3.getReadObserver() : ((Function1)v4);
        Snapshot v6 = v2.makeCurrentNonObservable(v3);
        try {
            float v7 = v0._scrollDeltaBetweenPasses.getValue().floatValue();
            Job v8 = v0.job;
            if(v8 != null) {
                DefaultImpls.cancel$default(v8, v4, 1, v4);
            }

            v0._scrollDeltaBetweenPasses = v0._scrollDeltaBetweenPasses.isRunning() ? AnimationStateKt.copy$default(v0._scrollDeltaBetweenPasses, v7 - v1, 0f, 0, 0, false, 30, null) : new AnimationState(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(-v1), null, 0, 0, false, 60, null);
            v0.job = BuildersKt.launch$default(arg22, null, null, new LazyLayoutScrollDeltaBetweenPasses$updateScrollDeltaForApproach$2$1(v0, ((Continuation)v4)), 3, null);
        }
        catch(Throwable v0_1) {
            v2.restoreNonObservable(v3, v6, v5);
            throw v0_1;
        }

        v2.restoreNonObservable(v3, v6, v5);
    }
}

