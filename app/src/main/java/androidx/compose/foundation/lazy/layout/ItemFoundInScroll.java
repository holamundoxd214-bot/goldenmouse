package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.AnimationState;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B#\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u001D\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2={"Landroidx/compose/foundation/lazy/layout/ItemFoundInScroll;", "Ljava/util/concurrent/CancellationException;", "Lkotlin/coroutines/cancellation/CancellationException;", "itemOffset", "", "previousAnimation", "Landroidx/compose/animation/core/AnimationState;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "<init>", "(ILandroidx/compose/animation/core/AnimationState;)V", "getItemOffset", "()I", "getPreviousAnimation", "()Landroidx/compose/animation/core/AnimationState;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class ItemFoundInScroll extends CancellationException {
    private final int itemOffset;
    private final AnimationState previousAnimation;

    public ItemFoundInScroll(int arg1, AnimationState arg2) {
        super();
        this.itemOffset = arg1;
        this.previousAnimation = arg2;
    }

    public final int getItemOffset() {
        return this.itemOffset;
    }

    public final AnimationState getPreviousAnimation() {
        return this.previousAnimation;
    }
}

