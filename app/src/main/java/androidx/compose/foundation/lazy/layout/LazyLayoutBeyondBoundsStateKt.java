package androidx.compose.foundation.lazy.layout;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.IntRange;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\"\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0000¨\u0006\b"}, d2={"calculateLazyLayoutPinnedIndices", "", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "pinnedItemList", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyLayoutBeyondBoundsStateKt {
    public static final List calculateLazyLayoutPinnedIndices(LazyLayoutItemProvider arg6, LazyLayoutPinnedItemList arg7, LazyLayoutBeyondBoundsInfo arg8) {
        if(!arg8.hasIntervals() && (arg7.isEmpty())) {
            return CollectionsKt.emptyList();
        }

        ArrayList v0 = new ArrayList();
        IntRange v1 = arg8.hasIntervals() ? new IntRange(arg8.getStart(), Math.min(arg8.getEnd(), arg6.getItemCount() - 1)) : IntRange.Companion.getEMPTY();
        int v8 = arg7.size();
        int v2;
        for(v2 = 0; v2 < v8; ++v2) {
            Object v3 = ((List)arg7).get(v2);
            int v3_1 = LazyLayoutItemProviderKt.findIndexByKey(arg6, ((PinnedItem)v3).getKey(), ((PinnedItem)v3).getIndex());
            int v4 = v1.getFirst();
            if(v3_1 <= v1.getLast() && v4 <= v3_1) {
            }
            else if(v3_1 >= 0 && v3_1 < arg6.getItemCount()) {
                ((List)v0).add(Integer.valueOf(v3_1));
            }
        }

        int v6 = v1.getFirst();
        int v7 = v1.getLast();
        if(v6 <= v7) {
            while(true) {
                ((List)v0).add(Integer.valueOf(v6));
                if(v6 != v7) {
                    ++v6;
                    continue;
                }

                break;
            }
        }

        return ((List)v0);
    }
}

