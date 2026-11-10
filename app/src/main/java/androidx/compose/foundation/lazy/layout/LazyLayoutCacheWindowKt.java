package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\u001A#\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001A\u001C\u0010\u0000\u001A\u00020\u00012\b\b\u0003\u0010\u0007\u001A\u00020\b2\b\b\u0003\u0010\t\u001A\u00020\bH\u0007¨\u0006\n"}, d2={"LazyLayoutCacheWindow", "Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "ahead", "Landroidx/compose/ui/unit/Dp;", "behind", "LazyLayoutCacheWindow-YgX7TsA", "(FF)Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "aheadFraction", "", "behindFraction", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyLayoutCacheWindowKt {
    public static final LazyLayoutCacheWindow LazyLayoutCacheWindow(float arg1, float arg2) {
        return new FractionLazyLayoutCacheWindow(arg1, arg2);
    }

    public static LazyLayoutCacheWindow LazyLayoutCacheWindow$default(float arg1, float arg2, int arg3, Object arg4) {
        return LazyLayoutCacheWindowKt.LazyLayoutCacheWindow(0f, 0f);
    }

    public static final LazyLayoutCacheWindow LazyLayoutCacheWindow-YgX7TsA(float arg2, float arg3) {
        return new DpLazyLayoutCacheWindow(arg2, arg3, null);
    }

    public static LazyLayoutCacheWindow LazyLayoutCacheWindow-YgX7TsA$default(float arg1, float arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = Dp.constructor-impl(0f);
        }

        if((arg3 & 2) != 0) {
            arg2 = Dp.constructor-impl(0f);
        }

        return LazyLayoutCacheWindowKt.LazyLayoutCacheWindow-YgX7TsA(arg1, arg2);
    }
}

