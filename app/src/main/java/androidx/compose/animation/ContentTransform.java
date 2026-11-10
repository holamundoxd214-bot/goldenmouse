package androidx.compose.animation;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000BR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR+\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u00078F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\b\u001A\u0004\u0018\u00010\t2\b\u0010\u0017\u001A\u0004\u0018\u00010\t@@X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001B¨\u0006\u001C"}, d2={"Landroidx/compose/animation/ContentTransform;", "", "targetContentEnter", "Landroidx/compose/animation/EnterTransition;", "initialContentExit", "Landroidx/compose/animation/ExitTransition;", "targetContentZIndex", "", "sizeTransform", "Landroidx/compose/animation/SizeTransform;", "<init>", "(Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;FLandroidx/compose/animation/SizeTransform;)V", "getTargetContentEnter", "()Landroidx/compose/animation/EnterTransition;", "getInitialContentExit", "()Landroidx/compose/animation/ExitTransition;", "<set-?>", "getTargetContentZIndex", "()F", "setTargetContentZIndex", "(F)V", "targetContentZIndex$delegate", "Landroidx/compose/runtime/MutableFloatState;", "value", "getSizeTransform", "()Landroidx/compose/animation/SizeTransform;", "setSizeTransform$animation", "(Landroidx/compose/animation/SizeTransform;)V", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ContentTransform {
    public static final int $stable = 8;
    private final ExitTransition initialContentExit;
    private SizeTransform sizeTransform;
    private final EnterTransition targetContentEnter;
    private final MutableFloatState targetContentZIndex$delegate;

    static {
    }

    public ContentTransform(EnterTransition arg1, ExitTransition arg2, float arg3, SizeTransform arg4, int arg5, DefaultConstructorMarker arg6) {
        if((arg5 & 8) != 0) {
            arg4 = AnimatedContentKt.SizeTransform$default(false, null, 3, null);
        }

        this(arg1, arg2, 0f, arg4);
    }

    public ContentTransform(EnterTransition arg1, ExitTransition arg2, float arg3, SizeTransform arg4) {
        super();
        this.targetContentEnter = arg1;
        this.initialContentExit = arg2;
        this.targetContentZIndex$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(arg3);
        this.sizeTransform = arg4;
    }

    public final ExitTransition getInitialContentExit() {
        return this.initialContentExit;
    }

    public final SizeTransform getSizeTransform() {
        return this.sizeTransform;
    }

    public final EnterTransition getTargetContentEnter() {
        return this.targetContentEnter;
    }

    public final float getTargetContentZIndex() {
        return this.targetContentZIndex$delegate.getFloatValue();
    }

    public final void setSizeTransform$animation(SizeTransform arg1) {
        this.sizeTransform = arg1;
    }

    public final void setTargetContentZIndex(float arg1) {
        this.targetContentZIndex$delegate.setFloatValue(arg1);
    }
}

