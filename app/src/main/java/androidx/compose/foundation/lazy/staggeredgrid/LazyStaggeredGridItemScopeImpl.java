package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemElement;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u0004\u001A\u00020\u0005*\u00020\u00052\u000E\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u000E\u0010\t\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\u000E\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016¨\u0006\f"}, d2={"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScopeImpl;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "<init>", "()V", "animateItem", "Landroidx/compose/ui/Modifier;", "fadeInSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "placementSpec", "Landroidx/compose/ui/unit/IntOffset;", "fadeOutSpec", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyStaggeredGridItemScopeImpl implements LazyStaggeredGridItemScope {
    public static final int $stable;
    public static final LazyStaggeredGridItemScopeImpl INSTANCE;

    static {
        LazyStaggeredGridItemScopeImpl.INSTANCE = new LazyStaggeredGridItemScopeImpl();
    }

    private LazyStaggeredGridItemScopeImpl() {
        super();
    }

    public Modifier animateItem(Modifier arg1, FiniteAnimationSpec arg2, FiniteAnimationSpec arg3, FiniteAnimationSpec arg4) {
        if(arg2 == null && arg3 == null && arg4 == null) {
            return arg1;
        }

        return arg1.then(new LazyLayoutAnimateItemElement(arg2, arg3, arg4));
    }
}

