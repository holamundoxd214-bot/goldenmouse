package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemElement;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\nJ\u0014\u0010\f\u001A\u00020\r*\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016J\u0014\u0010\u0010\u001A\u00020\r*\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016J\u0014\u0010\u0011\u001A\u00020\r*\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016J<\u0010\u0012\u001A\u00020\r*\u00020\r2\u000E\u0010\u0013\u001A\n\u0012\u0004\u0012\u00020\u000F\u0018\u00010\u00142\u000E\u0010\u0015\u001A\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00142\u000E\u0010\u0017\u001A\n\u0012\u0004\u0012\u00020\u000F\u0018\u00010\u0014H\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"Landroidx/compose/foundation/lazy/LazyItemScopeImpl;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "<init>", "()V", "maxWidthState", "Landroidx/compose/runtime/MutableIntState;", "maxHeightState", "setMaxSize", "", "width", "", "height", "fillParentMaxSize", "Landroidx/compose/ui/Modifier;", "fraction", "", "fillParentMaxWidth", "fillParentMaxHeight", "animateItem", "fadeInSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "placementSpec", "Landroidx/compose/ui/unit/IntOffset;", "fadeOutSpec", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyItemScopeImpl implements LazyItemScope {
    public static final int $stable;
    private MutableIntState maxHeightState;
    private MutableIntState maxWidthState;

    static {
    }

    public LazyItemScopeImpl() {
        super();
        this.maxWidthState = SnapshotIntStateKt.mutableIntStateOf(0x7FFFFFFF);
        this.maxHeightState = SnapshotIntStateKt.mutableIntStateOf(0x7FFFFFFF);
    }

    public Modifier animateItem(Modifier arg1, FiniteAnimationSpec arg2, FiniteAnimationSpec arg3, FiniteAnimationSpec arg4) {
        if(arg2 == null && arg3 == null && arg4 == null) {
            return arg1;
        }

        return arg1.then(new LazyLayoutAnimateItemElement(arg2, arg3, arg4));
    }

    public Modifier fillParentMaxHeight(Modifier arg8, float arg9) {
        return arg8.then(new ParentSizeElement(arg9, null, this.maxHeightState, "fillParentMaxHeight", 2, null));
    }

    public Modifier fillParentMaxSize(Modifier arg4, float arg5) {
        return arg4.then(new ParentSizeElement(arg5, this.maxWidthState, this.maxHeightState, "fillParentMaxSize"));
    }

    public Modifier fillParentMaxWidth(Modifier arg8, float arg9) {
        return arg8.then(new ParentSizeElement(arg9, this.maxWidthState, null, "fillParentMaxWidth", 4, null));
    }

    public final void setMaxSize(int arg2, int arg3) {
        this.maxWidthState.setIntValue(arg2);
        this.maxHeightState.setIntValue(arg3);
    }
}

