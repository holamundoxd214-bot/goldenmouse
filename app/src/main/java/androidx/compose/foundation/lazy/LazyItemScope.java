package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;

@LazyScopeMarker @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001A\u00020\u0003*\u00020\u00032\b\b\u0003\u0010\u0004\u001A\u00020\u0005H&J\u0016\u0010\u0006\u001A\u00020\u0003*\u00020\u00032\b\b\u0003\u0010\u0004\u001A\u00020\u0005H&J\u0016\u0010\u0007\u001A\u00020\u0003*\u00020\u00032\b\b\u0003\u0010\u0004\u001A\u00020\u0005H&JB\u0010\b\u001A\u00020\u0003*\u00020\u00032\u0010\b\u0002\u0010\t\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u0010\b\u0002\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\n2\u0010\b\u0002\u0010\r\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000EÀ\u0006\u0003"}, d2={"Landroidx/compose/foundation/lazy/LazyItemScope;", "", "fillParentMaxSize", "Landroidx/compose/ui/Modifier;", "fraction", "", "fillParentMaxWidth", "fillParentMaxHeight", "animateItem", "fadeInSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "placementSpec", "Landroidx/compose/ui/unit/IntOffset;", "fadeOutSpec", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface LazyItemScope {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static Modifier animateItem(LazyItemScope arg0, Modifier arg1, FiniteAnimationSpec arg2, FiniteAnimationSpec arg3, FiniteAnimationSpec arg4) {
            return arg0.animateItem(arg1, arg2, arg3, arg4);
        }

        public static Modifier animateItem$default(LazyItemScope arg0, Modifier arg1, FiniteAnimationSpec arg2, FiniteAnimationSpec arg3, FiniteAnimationSpec arg4, int arg5, Object arg6) {
            return LazyItemScope.animateItem$default(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
        }

        public static Modifier fillParentMaxHeight$default(LazyItemScope arg0, Modifier arg1, float arg2, int arg3, Object arg4) {
            return LazyItemScope.fillParentMaxHeight$default(arg0, arg1, arg2, arg3, arg4);
        }

        public static Modifier fillParentMaxSize$default(LazyItemScope arg0, Modifier arg1, float arg2, int arg3, Object arg4) {
            return LazyItemScope.fillParentMaxSize$default(arg0, arg1, arg2, arg3, arg4);
        }

        public static Modifier fillParentMaxWidth$default(LazyItemScope arg0, Modifier arg1, float arg2, int arg3, Object arg4) {
            return LazyItemScope.fillParentMaxWidth$default(arg0, arg1, arg2, arg3, arg4);
        }
    }

    static Modifier access$animateItem$jd(LazyItemScope arg0, Modifier arg1, FiniteAnimationSpec arg2, FiniteAnimationSpec arg3, FiniteAnimationSpec arg4) {
        return super.animateItem(arg1, arg2, arg3, arg4);
    }

    default Modifier animateItem(Modifier arg1, FiniteAnimationSpec arg2, FiniteAnimationSpec arg3, FiniteAnimationSpec arg4) {
        return arg1;
    }

    static Modifier animateItem$default(LazyItemScope arg6, Modifier arg7, FiniteAnimationSpec arg8, FiniteAnimationSpec arg9, FiniteAnimationSpec arg10, int arg11, Object arg12) {
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

    Modifier fillParentMaxHeight(Modifier arg1, float arg2);

    static Modifier fillParentMaxHeight$default(LazyItemScope arg0, Modifier arg1, float arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 1) != 0) {
                arg2 = 1f;
            }

            return arg0.fillParentMaxHeight(arg1, arg2);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fillParentMaxHeight");
    }

    Modifier fillParentMaxSize(Modifier arg1, float arg2);

    static Modifier fillParentMaxSize$default(LazyItemScope arg0, Modifier arg1, float arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 1) != 0) {
                arg2 = 1f;
            }

            return arg0.fillParentMaxSize(arg1, arg2);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fillParentMaxSize");
    }

    Modifier fillParentMaxWidth(Modifier arg1, float arg2);

    static Modifier fillParentMaxWidth$default(LazyItemScope arg0, Modifier arg1, float arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 1) != 0) {
                arg2 = 1f;
            }

            return arg0.fillParentMaxWidth(arg1, arg2);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fillParentMaxWidth");
    }
}

