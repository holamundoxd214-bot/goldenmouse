package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;

@LazyGridScopeMarker @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001JB\u0010\u0002\u001A\u00020\u0003*\u00020\u00032\u0010\b\u0002\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\u0010\b\u0002\u0010\t\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&\u0082\u0001\u0001\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000BÀ\u0006\u0001"}, d2={"Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "", "animateItem", "Landroidx/compose/ui/Modifier;", "fadeInSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "placementSpec", "Landroidx/compose/ui/unit/IntOffset;", "fadeOutSpec", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScopeImpl;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface LazyGridItemScope {
    Modifier animateItem(Modifier arg1, FiniteAnimationSpec arg2, FiniteAnimationSpec arg3, FiniteAnimationSpec arg4);

    static Modifier animateItem$default(LazyGridItemScope arg6, Modifier arg7, FiniteAnimationSpec arg8, FiniteAnimationSpec arg9, FiniteAnimationSpec arg10, int arg11, Object arg12) {
        SpringSpec v10;
        SpringSpec v9;
        SpringSpec v8;
        if(arg12 == null) {
            int v0 = 5;
            float v1 = 400f;
            Object v3 = null;
            if((arg11 & 1) != 0) {
                v8 = AnimationSpecKt.spring$default(0f, v1, v3, v0, v3);
            }

            if((arg11 & 2) != 0) {
                v9 = AnimationSpecKt.spring$default(0f, v1, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, v3);
            }

            if((arg11 & 4) != 0) {
                v10 = AnimationSpecKt.spring$default(0f, v1, v3, v0, v3);
            }

            return arg6.animateItem(arg7, ((FiniteAnimationSpec)v8), ((FiniteAnimationSpec)v9), ((FiniteAnimationSpec)v10));
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateItem");
    }
}

