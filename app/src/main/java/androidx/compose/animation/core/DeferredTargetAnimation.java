package androidx.compose.animation.core;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B\u001B\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u0017\u001A\u00028\u00002\u0006\u0010\u0013\u001A\u00028\u00002\u0006\u0010\u0018\u001A\u00020\u00192\u000E\b\u0002\u0010\u001A\u001A\b\u0012\u0004\u0012\u00028\u00000\u001B¢\u0006\u0002\u0010\u001CR\u001A\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\t\u001A\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR/\u0010\r\u001A\u0004\u0018\u00018\u00002\b\u0010\f\u001A\u0004\u0018\u00018\u00008B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u000E\u0010\u000B\"\u0004\b\u000F\u0010\u0010R\u0016\u0010\u0013\u001A\u0004\u0018\u00018\u00008BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u000BR\u001C\u0010\u0015\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u001D\u001A\u00020\u001E8F¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001F¨\u0006 "}, d2={"Landroidx/compose/animation/core/DeferredTargetAnimation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "vectorConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "<init>", "(Landroidx/compose/animation/core/TwoWayConverter;)V", "pendingTarget", "getPendingTarget", "()Ljava/lang/Object;", "<set-?>", "_pendingTarget", "get_pendingTarget", "set_pendingTarget", "(Ljava/lang/Object;)V", "_pendingTarget$delegate", "Landroidx/compose/runtime/MutableState;", "target", "getTarget", "animatable", "Landroidx/compose/animation/core/Animatable;", "updateTarget", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "(Ljava/lang/Object;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/animation/core/FiniteAnimationSpec;)Ljava/lang/Object;", "isIdle", "", "()Z", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DeferredTargetAnimation {
    public static final int $stable = 8;
    private final MutableState _pendingTarget$delegate;
    private Animatable animatable;
    private final TwoWayConverter vectorConverter;

    static {
    }

    public DeferredTargetAnimation(TwoWayConverter arg2) {
        super();
        this.vectorConverter = arg2;
        this._pendingTarget$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    public static final Object access$get_pendingTarget(DeferredTargetAnimation arg0) {
        return arg0.get_pendingTarget();
    }

    public final Object getPendingTarget() {
        return this.get_pendingTarget();
    }

    private final Object getTarget() {
        Animatable v0 = this.animatable;
        if(v0 != null) {
            return v0.getTargetValue();
        }

        return null;
    }

    private final Object get_pendingTarget() {
        return this._pendingTarget$delegate.getValue();
    }

    public final boolean isIdle() {
        if(Intrinsics.areEqual(this.get_pendingTarget(), this.getTarget())) {
            Animatable v2 = this.animatable;
            if(v2 != null && (v2.isRunning())) {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    private final void set_pendingTarget(Object arg1) {
        this._pendingTarget$delegate.setValue(arg1);
    }

    public final Object updateTarget(Object arg11, CoroutineScope arg12, FiniteAnimationSpec arg13) {
        Object v5;
        Animatable v3;
        this.set_pendingTarget(arg11);
        Animatable v0 = this.animatable;
        if(v0 == null) {
            Animatable v1 = new Animatable(arg11, this.vectorConverter, null, null, 12, null);
            this.animatable = v1;
            v3 = v1;
            v5 = arg11;
        }
        else {
            v5 = arg11;
            v3 = v0;
        }

        BuildersKt.launch$default(arg12, null, null, new DeferredTargetAnimation$updateTarget$1(v3, this, v5, arg13, null), 3, null);
        return v3.getValue();
    }

    public static Object updateTarget$default(DeferredTargetAnimation arg0, Object arg1, CoroutineScope arg2, FiniteAnimationSpec arg3, int arg4, Object arg5) {
        SpringSpec v3;
        if((arg4 & 4) != 0) {
            v3 = AnimationSpecKt.spring$default(0f, 0f, null, 7, null);
        }

        return arg0.updateTarget(arg1, arg2, ((FiniteAnimationSpec)v3));
    }
}

