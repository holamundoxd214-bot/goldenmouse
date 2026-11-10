package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ScrollState;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ,\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\f2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u000B\u001A\u00020\fJ*\u0010\u0016\u001A\u00020\f*\u00020\u00152\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\f2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0017"}, d2={"Landroidx/compose/material3/ScrollableTabData;", "", "scrollState", "Landroidx/compose/foundation/ScrollState;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "<init>", "(Landroidx/compose/foundation/ScrollState;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "selectedTab", "", "Ljava/lang/Integer;", "onLaidOut", "", "density", "Landroidx/compose/ui/unit/Density;", "edgeOffset", "tabPositions", "", "Landroidx/compose/material3/TabPosition;", "calculateTabOffset", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class ScrollableTabData {
    private final FiniteAnimationSpec animationSpec;
    private final CoroutineScope coroutineScope;
    private final ScrollState scrollState;
    private Integer selectedTab;

    public ScrollableTabData(ScrollState arg1, CoroutineScope arg2, FiniteAnimationSpec arg3) {
        super();
        this.scrollState = arg1;
        this.coroutineScope = arg2;
        this.animationSpec = arg3;
    }

    public static final FiniteAnimationSpec access$getAnimationSpec$p(ScrollableTabData arg0) {
        return arg0.animationSpec;
    }

    public static final ScrollState access$getScrollState$p(ScrollableTabData arg0) {
        return arg0.scrollState;
    }

    private final int calculateTabOffset(TabPosition arg2, Density arg3, int arg4, List arg5) {
        int v5 = arg3.roundToPx-0680j_4(CollectionsKt.last(arg5).getRight-D9Ej5fM()) + arg4;
        int v1 = v5 - this.scrollState.getMaxValue();
        return RangesKt.coerceIn(arg3.roundToPx-0680j_4(arg2.getLeft-D9Ej5fM()) - (v1 / 2 - arg3.roundToPx-0680j_4(arg2.getWidth-D9Ej5fM()) / 2), 0, RangesKt.coerceAtLeast(v5 - v1, 0));
    }

    public final void onLaidOut(Density arg7, int arg8, List arg9, int arg10) {
        Integer v0 = this.selectedTab;
        if(v0 == null || v0.intValue() != arg10) {
            this.selectedTab = Integer.valueOf(arg10);
            Object v10 = CollectionsKt.getOrNull(arg9, arg10);
            if(v10 != null) {
                int v7 = this.calculateTabOffset(((TabPosition)v10), arg7, arg8, arg9);
                if(this.scrollState.getValue() != v7) {
                    BuildersKt.launch$default(this.coroutineScope, null, null, new ScrollableTabData$onLaidOut$1$1(this, v7, null), 3, null);
                }
            }
        }
    }
}

