package androidx.compose.material3.pulltorefresh;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001D\b\u0002\u0012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bJ\u000E\u0010\u000F\u001A\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u000E\u0010\u0012\u001A\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0013\u001A\u00020\u00102\u0006\u0010\u0014\u001A\u00020\u0004H\u0096@¢\u0006\u0002\u0010\u0015R\u001A\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\u000E¨\u0006\u0017"}, d2={"Landroidx/compose/material3/pulltorefresh/PullToRefreshStateImpl;", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "anim", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "<init>", "(Landroidx/compose/animation/core/Animatable;)V", "()V", "distanceFraction", "getDistanceFraction", "()F", "isAnimating", "", "()Z", "animateToThreshold", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToHidden", "snapTo", "targetValue", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PullToRefreshStateImpl implements PullToRefreshState {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001D\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2={"Landroidx/compose/material3/pulltorefresh/PullToRefreshStateImpl$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/pulltorefresh/PullToRefreshStateImpl;", "", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver getSaver() {
            return PullToRefreshStateImpl.Saver;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final Saver Saver;
    private final Animatable anim;

    static {
        PullToRefreshStateImpl.Companion = new Companion(null);
        PullToRefreshStateImpl.Saver = SaverKt.Saver(new PullToRefreshStateImpl$$ExternalSyntheticLambda0(), new PullToRefreshStateImpl$$ExternalSyntheticLambda1());
    }

    public PullToRefreshStateImpl() {
        this(new Animatable(Float.valueOf(0f), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), null, null, 12, null));
    }

    private PullToRefreshStateImpl(Animatable arg1) {
        super();
        this.anim = arg1;
    }

    static final Float Saver$lambda$0(SaverScope arg0, PullToRefreshStateImpl arg1) {
        return arg1.anim.getValue();
    }

    static final PullToRefreshStateImpl Saver$lambda$1(float arg8) {
        return new PullToRefreshStateImpl(new Animatable(Float.valueOf(arg8), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), null, null, 12, null));
    }

    public static final Saver access$getSaver$cp() {
        return PullToRefreshStateImpl.Saver;
    }

    public Object animateToHidden(Continuation arg9) {
        Object v8 = Animatable.animateTo$default(this.anim, Boxing.boxFloat(0f), null, null, null, arg9, 14, null);
        if(v8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v8;
        }

        return Unit.INSTANCE;
    }

    public Object animateToThreshold(Continuation arg9) {
        Object v8 = Animatable.animateTo$default(this.anim, Boxing.boxFloat(1f), null, null, null, arg9, 14, null);
        if(v8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v8;
        }

        return Unit.INSTANCE;
    }

    public float getDistanceFraction() {
        return this.anim.getValue().floatValue();
    }

    public boolean isAnimating() {
        return this.anim.isRunning();
    }

    public Object snapTo(float arg1, Continuation arg2) {
        Object v0 = this.anim.snapTo(Boxing.boxFloat(arg1), arg2);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }
}

