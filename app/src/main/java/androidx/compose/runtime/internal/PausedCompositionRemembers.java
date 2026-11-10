package androidx.compose.runtime.internal;

import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.collection.MutableVector;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000B\u001A\u00020\fH\u0016J\b\u0010\r\u001A\u00020\fH\u0016J\b\u0010\u000E\u001A\u00020\fH\u0016R\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u000F"}, d2={"Landroidx/compose/runtime/internal/PausedCompositionRemembers;", "Landroidx/compose/runtime/RememberObserver;", "abandoning", "", "<init>", "(Ljava/util/Set;)V", "pausedRemembers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/runtime/RememberObserverHolder;", "getPausedRemembers", "()Landroidx/compose/runtime/collection/MutableVector;", "onRemembered", "", "onForgotten", "onAbandoned", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PausedCompositionRemembers implements RememberObserver {
    public static final int $stable = 8;
    private final Set abandoning;
    private final MutableVector pausedRemembers;

    static {
    }

    public PausedCompositionRemembers(Set arg3) {
        super();
        this.abandoning = arg3;
        this.pausedRemembers = new MutableVector(new RememberObserverHolder[16], 0);
    }

    public final MutableVector getPausedRemembers() {
        return this.pausedRemembers;
    }

    public void onAbandoned() {
    }

    public void onForgotten() {
    }

    public void onRemembered() {
        MutableVector v0 = this.pausedRemembers;
        Object[] v1 = v0.content;
        int v0_1 = v0.getSize();
        int v2;
        for(v2 = 0; v2 < v0_1; ++v2) {
            RememberObserver v3 = v1[v2].getWrapped();
            this.abandoning.remove(v3);
            v3.onRemembered();
        }
    }
}

