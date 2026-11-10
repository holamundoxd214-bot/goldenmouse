package androidx.compose.foundation.lazy.layout;

import androidx.collection.IntList;
import androidx.compose.ui.unit.IntOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000F\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001A\u0017\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0082\b\u001Ax\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u000E0\r\"\b\b\u0000\u0010\u000E*\u00020\t*\u0004\u0018\u00010\u000F2\u0006\u0010\u0010\u001A\u00020\b2\u0006\u0010\u0011\u001A\u00020\b2\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u000E0\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\b2\u0006\u0010\u0017\u001A\u00020\b2\u0006\u0010\u0018\u001A\u00020\b2\u0006\u0010\u0019\u001A\u00020\b2\u0012\u0010\u001A\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u000E0\u001BH\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0007\u001A\u00020\b*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B¨\u0006\u001C"}, d2={"Debug", "", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "mainAxisOffset", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "getMainAxisOffset", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)I", "applyStickyItems", "", "T", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "firstVisibleItemIndex", "lastVisibleItemIndex", "positionedItems", "", "stickyItems", "Landroidx/collection/IntList;", "beforeContentPadding", "afterContentPadding", "layoutWidth", "layoutHeight", "getAndMeasure", "Lkotlin/Function1;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyLayoutStickyItemsKt {
    private static final boolean Debug = false;

    public static final int access$getMainAxisOffset(LazyLayoutMeasuredItem arg0) {
        return LazyLayoutStickyItemsKt.getMainAxisOffset(arg0);
    }

    public static final List applyStickyItems(StickyItemsPlacement arg16, int arg17, int arg18, List arg19, IntList arg20, int arg21, int arg22, int arg23, int arg24, Function1 arg25) {
        int v6_1;
        StickyItemsPlacement v0 = arg16;
        List v9 = arg19;
        IntList v1 = arg20;
        if(v0 != null) {
            List v2 = v9;
            if(!((Collection)v2).isEmpty() && v1._size != 0) {
                IntList v3 = v0.getStickingIndices(arg17, arg18, v1);
                ArrayList v10 = new ArrayList();
                ArrayList v4 = new ArrayList(v9.size());
                int v2_1 = ((Collection)v2).size();
                int v5;
                for(v5 = 0; v5 < v2_1; ++v5) {
                    Object v6 = v9.get(v5);
                    if(v1.contains(v6.getIndex())) {
                        v4.add(v6);
                    }
                }

                ArrayList v1_1 = v4;
                int[] v12 = v3.content;
                int v13 = v3._size;
                int v14 = 0;
                while(v14 < v13) {
                    v2_1 = v12[v14];
                    Iterator v3_1 = v9.iterator();
                    int v4_1 = 0;
                    while(true) {
                        v6_1 = -1;
                        if(!v3_1.hasNext()) {
                            break;
                        }
                        else if(v3_1.next().getIndex() == v2_1) {
                        }
                        else {
                            ++v4_1;
                            continue;
                        }

                        goto label_48;
                    }

                    v4_1 = v6_1;
                label_48:
                    Object v3_2 = v4_1 == v6_1 ? arg25.invoke(Integer.valueOf(v2_1)) : v9.remove(v4_1);
                    v5 = ((LazyLayoutMeasuredItem)v3_2).getMainAxisSizeWithSpacings();
                    v4_1 = v4_1 == v6_1 ? 0x80000000 : LazyLayoutStickyItemsKt.getMainAxisOffset(((LazyLayoutMeasuredItem)v3_2));
                    v2_1 = v0.calculateStickingItemOffset(((List)v1_1), v2_1, v5, v4_1, arg21, arg22, arg23, arg24);
                    v3_2.setNonScrollableItem(true);
                    v3_2.position(v2_1, 0, arg23, arg24);
                    ((List)v10).add(v3_2);
                    ++v14;
                    v0 = arg16;
                }

                return ((List)v10);
            }
        }

        return CollectionsKt.emptyList();
    }

    private static final void debugLog(Function0 arg0) {
    }

    private static final int getMainAxisOffset(LazyLayoutMeasuredItem arg2) {
        long v0 = arg2.getOffset-Bjo55l4(0);
        if(arg2.isVertical()) {
            return IntOffset.getY-impl(v0);
        }

        return IntOffset.getX-impl(v0);
    }
}

