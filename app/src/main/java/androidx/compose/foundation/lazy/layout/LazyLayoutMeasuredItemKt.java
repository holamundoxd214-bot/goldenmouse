package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.unit.IntOffset;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001AD\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0000\"\u0018\u0010\t\u001A\u00020\u0005*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B\"\u001E\u0010\f\u001A\u0012\u0012\u0004\u0012\u00020\u00030\rj\b\u0012\u0004\u0012\u00020\u0003`\u000EX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"updatedVisibleItems", "", "T", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "firstVisibleIndex", "", "lastVisibleIndex", "positionedItems", "stickingItems", "mainAxisOffset", "getMainAxisOffset", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)I", "LazyLayoutMeasuredItemIndexComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyLayoutMeasuredItemKt {
    private static final Comparator LazyLayoutMeasuredItemIndexComparator;

    static {
        LazyLayoutMeasuredItemKt.LazyLayoutMeasuredItemIndexComparator = new LazyLayoutMeasuredItemKt$$ExternalSyntheticLambda0();
    }

    static final int LazyLayoutMeasuredItemIndexComparator$lambda$0(LazyLayoutMeasuredItem arg0, LazyLayoutMeasuredItem arg1) {
        return Intrinsics.compare(arg0.getIndex(), arg1.getIndex());
    }

    private static final int getMainAxisOffset(LazyLayoutMeasuredItem arg2) {
        long v0 = arg2.getOffset-Bjo55l4(0);
        if(arg2.isVertical()) {
            return IntOffset.getY-impl(v0);
        }

        return IntOffset.getX-impl(v0);
    }

    public static final List updatedVisibleItems(int arg4, int arg5, List arg6, List arg7) {
        if(arg6.isEmpty()) {
            return CollectionsKt.emptyList();
        }

        arg7 = CollectionsKt.toMutableList(((Collection)arg7));
        int v0 = arg6.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = arg6.get(v1);
            int v3 = ((LazyLayoutMeasuredItem)v2).getIndex();
            if(arg4 <= v3 && v3 <= arg5) {
                arg7.add(v2);
            }
        }

        CollectionsKt.sortWith(arg7, LazyLayoutMeasuredItemKt.LazyLayoutMeasuredItemIndexComparator);
        return arg7;
    }
}

