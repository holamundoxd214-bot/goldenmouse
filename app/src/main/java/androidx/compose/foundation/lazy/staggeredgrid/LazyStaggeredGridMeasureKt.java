package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000¬\u0001\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\u001A5\u0010\u0002\u001A\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0017\u0010\u0006\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00030\u0007¢\u0006\u0002\b\bH\u0082\b¢\u0006\u0002\u0010\t\u001A\u001D\u0010\n\u001A\u00020\u000B*\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000E0\r0\fH\u0002¢\u0006\u0002\u0010\u000F\u001A\u0017\u0010\u0010\u001A\u00020\u00112\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0013H\u0082\b\u001A£\u0001\u0010\u0014\u001A\u00020\u0015*\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u00172\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u001A0\u00192\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020\u00012\u0006\u0010\"\u001A\u00020\u00012\u0006\u0010#\u001A\u00020$2\u0006\u0010%\u001A\u00020\u001A2\u0006\u0010&\u001A\u00020\u001A2\u0006\u0010\'\u001A\u00020\u001A2\u0006\u0010(\u001A\u00020\u001A2\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020\u00012\u0006\u0010,\u001A\u00020\u00012\b\u0010-\u001A\u0004\u0018\u00010.2\u0006\u0010/\u001A\u000200H\u0000¢\u0006\u0004\b1\u00102\u001A,\u00103\u001A\u00020\u0015*\u0002042\u0006\u00105\u001A\u00020\u001A2\u0006\u00106\u001A\u0002072\u0006\u00108\u001A\u0002072\u0006\u00109\u001A\u00020\u0001H\u0002\u001AK\u0010:\u001A\b\u0012\u0004\u0012\u00020\u000E0\u0019*\u0002042\u0012\u0010;\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000E0\r0\f2\u0006\u0010<\u001A\u0002072\u0006\u0010=\u001A\u00020\u001A2\u0006\u0010>\u001A\u00020\u001A2\u0006\u0010?\u001A\u00020\u001AH\u0002¢\u0006\u0002\u0010@\u001AG\u0010A\u001A\n\u0012\u0004\u0012\u00020\u000E\u0018\u00010\u0019*\u0002042\u0006\u0010B\u001A\u00020\u001A2\u0006\u0010C\u001A\u00020\u001A2\u0006\u0010,\u001A\u00020\u00012\u0018\u0010D\u001A\u0014\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u001A\u0012\u0004\u0012\u00020\u00110EH\u0082\b\u001AR\u0010F\u001A\b\u0012\u0004\u0012\u00020\u000E0\u0019*\u0002042\u0012\u0010D\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00110\u00072!\u0010G\u001A\u001D\u0012\u0013\u0012\u00110\u001A¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010K\u001A\u00020\u0001H\u0082\b\u001A7\u0010L\u001A\u00020\u0011\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00192\b\b\u0002\u0010M\u001A\u00020\u00012\u0012\u0010N\u001A\u000E\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00110\u0007H\u0082\b\u001A(\u0010O\u001A\u00020\u0011*\u00020P2\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u001A\u0012\u0004\u0012\u00020\u00110\u0007H\u0082\b¢\u0006\u0004\bQ\u0010R\u001A\u0014\u0010S\u001A\u00020\u0011*\u0002072\u0006\u0010T\u001A\u00020\u001AH\u0002\u001A\u001B\u0010U\u001A\u00020\u001A*\u0002072\u0006\u0010V\u001A\u00020PH\u0002¢\u0006\u0004\bW\u0010X\u001A\u0016\u0010Y\u001A\u00020\u001A*\u0002072\b\b\u0002\u0010Z\u001A\u00020\u001AH\u0000\u001A2\u0010[\u001A\u00020\u001A\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\f2\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u001A0\u0007H\u0082\b¢\u0006\u0002\u0010\\\u001A\f\u0010]\u001A\u00020\u001A*\u000207H\u0002\u001A!\u0010^\u001A\u000207*\u0002072\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u001A\u0012\u0004\u0012\u00020\u001A0\u0007H\u0082\b\u001A\u001C\u0010_\u001A\u00020\u0011*\u0002042\u0006\u0010`\u001A\u0002072\u0006\u0010a\u001A\u00020\u001AH\u0002\u001A\u001C\u0010b\u001A\u00020\u001A*\u0002042\u0006\u0010c\u001A\u00020\u001A2\u0006\u0010d\u001A\u00020\u001AH\u0002\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010e\u001A\u00020\u001AX\u0082T¢\u0006\u0002\n\u0000¨\u0006f"}, d2={"DebugLoggingEnabled", "", "withDebugLogging", "T", "scope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "debugRender", "", "", "Lkotlin/collections/ArrayDeque;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "([Lkotlin/collections/ArrayDeque;)Ljava/lang/String;", "debugLog", "", "message", "Lkotlin/Function0;", "measureStaggeredGrid", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "pinnedItems", "", "", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "reverseLayout", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "mainAxisAvailableSize", "mainAxisSpacing", "beforeContentPadding", "afterContentPadding", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "isInLookaheadScope", "isLookingAhead", "approachLayoutInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "measureStaggeredGrid-C6celF4", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Ljava/util/List;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;JZZJIIIILkotlinx/coroutines/CoroutineScope;ZZLandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;Landroidx/compose/ui/graphics/GraphicsContext;)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "measure", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "initialScrollDelta", "initialItemIndices", "", "initialItemOffsets", "canRestartMeasure", "calculateVisibleItems", "measuredItems", "itemScrollOffsets", "mainAxisLayoutSize", "minOffset", "maxOffset", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;[Lkotlin/collections/ArrayDeque;[IIII)Ljava/util/List;", "itemsRetainedForLookahead", "lastVisibleItemIndex", "itemsCount", "position", "Lkotlin/Function2;", "calculateExtraItems", "filter", "Lkotlin/ParameterName;", "name", "itemIndex", "beforeVisibleBounds", "fastForEach", "reverse", "action", "forEach", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "forEach-nIS5qE8", "(JLkotlin/jvm/functions/Function1;)V", "offsetBy", "delta", "maxInRange", "indexRange", "maxInRange-jy6DScQ", "([IJ)I", "indexOfMinValue", "minBound", "indexOfMinBy", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "indexOfMaxValue", "transform", "ensureIndicesInRange", "indices", "itemCount", "findPreviousItemIndex", "item", "lane", "Unset", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyStaggeredGridMeasureKt {
    private static final boolean DebugLoggingEnabled = false;
    private static final int Unset = 0x80000000;

    public static Unit $r8$lambda$hbWz3INNMKvGC4t5aU6jkP44tW8(List arg0, LazyStaggeredGridMeasureContext arg1, LazyLayoutMeasureScope arg2, PlacementScope arg3) {
        return LazyStaggeredGridMeasureKt.measure$lambda$0$37$0(arg0, arg1, arg2, arg3);
    }

    public static Unit $r8$lambda$s7N-T6PJZYkQOJLn6Na3h5dJmmI(PlacementScope arg0) {
        return LazyStaggeredGridMeasureKt.measure$lambda$0$0(arg0);
    }

    public static Unit $r8$lambda$yhVl7qAsM0rYoH54GEVmz7bswlw(LazyStaggeredGridMeasureContext arg0, List arg1, LazyLayoutMeasureScope arg2, PlacementScope arg3) {
        return LazyStaggeredGridMeasureKt.measure$lambda$0$37(arg0, arg1, arg2, arg3);
    }

    private static final List calculateExtraItems(LazyStaggeredGridMeasureContext arg8, Function1 arg9, Function1 arg10, boolean arg11) {
        int v3;
        int v11;
        List v0 = arg8.getPinnedItems();
        ArrayList v2 = null;
        if(arg11) {
            v11 = v0.size() - 1;
            if(v11 < 0) {
                goto label_49;
            }

            while(true) {
                v3 = v11 - 1;
                v11 = v0.get(v11).intValue();
                if(arg10.invoke(Integer.valueOf(v11)).booleanValue()) {
                    long v4 = arg8.getSpanRange-lOCCd4c(arg8.getItemProvider(), v11, 0);
                    if(v2 == null) {
                        v2 = new ArrayList();
                    }

                    LazyStaggeredGridMeasuredItem v11_1 = arg8.getMeasuredItemProvider().getAndMeasure-jy6DScQ(v11, v4);
                    arg9.invoke(v11_1);
                    ((List)v2).add(v11_1);
                }

                if(v3 < 0) {
                    break;
                }

                v11 = v3;
            }
        }
        else {
            v11 = v0.size();
            for(v3 = 0; v3 < v11; ++v3) {
                int v4_1 = v0.get(v3).intValue();
                if(arg10.invoke(Integer.valueOf(v4_1)).booleanValue()) {
                    long v5 = arg8.getSpanRange-lOCCd4c(arg8.getItemProvider(), v4_1, 0);
                    if(v2 == null) {
                        v2 = new ArrayList();
                    }

                    LazyStaggeredGridMeasuredItem v4_2 = arg8.getMeasuredItemProvider().getAndMeasure-jy6DScQ(v4_1, v5);
                    arg9.invoke(v4_2);
                    ((List)v2).add(v4_2);
                }
            }
        }

    label_49:
        if(v2 == null) {
            return CollectionsKt.emptyList();
        }

        return ((List)v2);
    }

    private static final List calculateVisibleItems(LazyStaggeredGridMeasureContext arg9, ArrayDeque[] arg10, int[] arg11, int arg12, int arg13, int arg14) {
        int v6;
        int v5;
        int v4;
        int v0 = arg10.length;
        int v2 = 0;
        int v3 = 0;
        while(v2 < v0) {
            v3 += arg10[v2].size();
            ++v2;
        }

        ArrayList v0_1 = new ArrayList(v3);
    label_12:
        v2 = arg10.length;
        for(v3 = 0; v3 < v2; ++v3) {
            if(!arg10[v3].isEmpty()) {
                v2 = arg10.length;
                v3 = 0x7FFFFFFF;
                v4 = -1;
                v5 = 0;
                v6 = v3;
                goto label_23;
            }
        }

        return ((List)v0_1);
    label_23:
        while(v5 < v2) {
            Object v7 = arg10[v5].firstOrNull();
            int v7_1 = v7 != null ? ((LazyStaggeredGridMeasuredItem)v7).getIndex() : v3;
            if(v6 > v7_1) {
                v4 = v5;
                v6 = v7_1;
            }

            ++v5;
        }

        Object v2_1 = arg10[v4].removeFirst();
        if(((LazyStaggeredGridMeasuredItem)v2_1).getLane() != v4) {
            goto label_12;
        }

        long v5_1 = SpanRange.constructor-impl(((LazyStaggeredGridMeasuredItem)v2_1).getLane(), ((LazyStaggeredGridMeasuredItem)v2_1).getSpan());
        v3 = LazyStaggeredGridMeasureKt.maxInRange-jy6DScQ(arg11, v5_1);
        v4 = arg9.getResolvedSlots().getPositions()[v4];
        if(((LazyStaggeredGridMeasuredItem)v2_1).getMainAxisSize() + v3 >= arg13 && v3 <= arg14) {
            ((LazyStaggeredGridMeasuredItem)v2_1).position(v3, v4, arg12);
            v0_1.add(v2_1);
        }

        v4 = ((int)(v5_1 >> 0x20));
        v5 = ((int)(v5_1 & 0xFFFFFFFFL));
        while(true) {
            if(v4 >= v5) {
                goto label_12;
            }

            arg11[v4] = ((LazyStaggeredGridMeasuredItem)v2_1).getMainAxisSizeWithSpacings() + v3;
            ++v4;
        }
    }

    private static final void debugLog(Function0 arg0) {
    }

    private static final String debugRender(ArrayDeque[] arg0) {
        return "";
    }

    private static final void ensureIndicesInRange(LazyStaggeredGridMeasureContext arg7, int[] arg8, int arg9) {
        int v5;
        int v4;
        int v3;
        int v1 = -1;
        int v0 = arg8.length + v1;
        if(v0 >= 0) {
            while(true) {
                int v2 = v0 - 1;
                while(true) {
                    if(arg8[v0] < arg9) {
                        if(!arg7.getLaneInfo().assignedToLane(arg8[v0], v0)) {
                        }
                        else {
                            v3 = arg8[v0];
                            if(v3 >= 0 && !arg7.isFullSpan(arg7.getItemProvider(), v3)) {
                                if(arg7.getLaneInfo().getLane(v3) == -2) {
                                    v4 = arg8.length;
                                    v5 = 0;
                                    break;
                                }

                                goto label_40;
                            }

                            goto label_42;
                        }
                    }

                    arg8[v0] = LazyStaggeredGridMeasureKt.findPreviousItemIndex(arg7, arg8[v0], v0);
                }

                while(true) {
                    if(v5 >= v4) {
                        break;
                    }
                    else if(arg8[v5] == v3) {
                    }
                    else {
                        ++v5;
                        continue;
                    }

                    goto label_30;
                }

                v5 = v1;
            label_30:
                v4 = v5 + 1;
                if(v4 <= v0) {
                    while(true) {
                        if(arg8[v4] == v3) {
                            arg8[v4] = LazyStaggeredGridMeasureKt.findPreviousItemIndex(arg7, v3, v4);
                        }

                        if(v4 == v0) {
                            break;
                        }

                        ++v4;
                    }
                }

                v0 = v5;
            label_40:
                arg7.getLaneInfo().setLane(v3, v0);
            label_42:
                if(v2 < 0) {
                    return;
                }

                v0 = v2;
            }
        }
    }

    private static final void fastForEach(List arg2, boolean arg3, Function1 arg4) {
        int v0;
        int v3;
        if(arg3) {
            v3 = arg2.size() - 1;
            if(v3 < 0) {
                return;
            }

            while(true) {
                v0 = v3 - 1;
                arg4.invoke(arg2.get(v3));
                if(v0 < 0) {
                    break;
                }

                v3 = v0;
            }
        }
        else {
            v3 = arg2.size();
            for(v0 = 0; v0 < v3; ++v0) {
                arg4.invoke(arg2.get(v0));
            }
        }
    }

    static void fastForEach$default(List arg0, boolean arg1, Function1 arg2, int arg3, Object arg4) {
        int v1;
        int v4 = 0;
        if(0 != 0) {
            v1 = arg0.size() - 1;
            if(v1 < 0) {
                return;
            }

            while(true) {
                arg3 = v1 - 1;
                arg2.invoke(arg0.get(v1));
                if(arg3 < 0) {
                    break;
                }

                v1 = arg3;
            }
        }
        else {
            v1 = arg0.size();
            while(v4 < v1) {
                arg2.invoke(arg0.get(v4));
                ++v4;
            }
        }
    }

    private static final int findPreviousItemIndex(LazyStaggeredGridMeasureContext arg0, int arg1, int arg2) {
        return arg0.getLaneInfo().findPreviousItemIndex(arg1, arg2);
    }

    private static final void forEach-nIS5qE8(long arg3, Function1 arg5) {
        int v0 = ((int)(arg3 >> 0x20));
        int v3 = ((int)(arg3 & 0xFFFFFFFFL));
        while(v0 < v3) {
            arg5.invoke(Integer.valueOf(v0));
            ++v0;
        }
    }

    private static final int indexOfMaxValue(int[] arg5) {
        int v0 = arg5.length;
        int v1 = -1;
        int v2 = 0x80000000;
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            int v4 = arg5[v3];
            if(v2 < v4) {
                v1 = v3;
                v2 = v4;
            }
        }

        return v1;
    }

    private static final int indexOfMinBy(Object[] arg5, Function1 arg6) {
        int v0 = arg5.length;
        int v1 = -1;
        int v2 = 0x7FFFFFFF;
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            int v4 = arg6.invoke(arg5[v3]).intValue();
            if(v2 > v4) {
                v1 = v3;
                v2 = v4;
            }
        }

        return v1;
    }

    public static final int indexOfMinValue(int[] arg6, int arg7) {
        int v0 = arg6.length;
        int v1 = -1;
        int v2 = 0x7FFFFFFF;
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            int v5 = arg6[v3];
            if(arg7 + 1 <= v5 && v5 < v2) {
                v1 = v3;
                v2 = v5;
            }
        }

        return v1;
    }

    public static int indexOfMinValue$default(int[] arg0, int arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 0x80000000;
        }

        return LazyStaggeredGridMeasureKt.indexOfMinValue(arg0, arg1);
    }

    private static final List itemsRetainedForLookahead(LazyStaggeredGridMeasureContext arg7, int arg8, int arg9, boolean arg10, Function2 arg11) {
        Object v5;
        int v3;
        int v2;
        Object v8;
        List v0 = null;
        if((arg10) && arg7.getApproachLayoutInfo() != null && !arg7.getApproachLayoutInfo().getVisibleItemsInfo().isEmpty()) {
            List v10 = arg7.getApproachLayoutInfo().getVisibleItemsInfo();
            int v1;
            for(v1 = v10.size() - 1; -1 < v1; --v1) {
                if(v10.get(v1).getIndex() > arg8 && (v1 == 0 || v10.get(v1 - 1).getIndex() <= arg8)) {
                    v8 = v10.get(v1);
                    goto label_27;
                }
            }

            v8 = v0;
        label_27:
            Object v10_1 = CollectionsKt.last(arg7.getApproachLayoutInfo().getVisibleItemsInfo());
            if(v8 == null) {
                return v0;
            }

            arg8 = ((LazyStaggeredGridItemInfo)v8).getIndex();
            arg9 = Math.min(((LazyStaggeredGridItemInfo)v10_1).getIndex(), arg9 - 1);
            if(arg8 > arg9) {
                return v0;
            }

            ArrayList v10_2 = ((ArrayList)v0);
            while(true) {
                v1 = 0;
                if(v10_2 != null) {
                    v2 = v10_2.size();
                    v3 = 0;
                    while(true) {
                        if(v3 >= v2) {
                            goto label_49;
                        }
                        else if(((List)v10_2).get(v3).getIndex() == arg8) {
                        }
                        else {
                            ++v3;
                            continue;
                        }

                        break;
                    }
                }
                else {
                label_49:
                    if(v10_2 == null) {
                        v10_2 = new ArrayList();
                    }

                    List v2_1 = arg7.getApproachLayoutInfo().getVisibleItemsInfo();
                    v3 = v2_1.size();
                    int v4 = 0;
                    while(true) {
                        if(v4 < v3) {
                            v5 = v2_1.get(v4);
                            if(v5.getIndex() == arg8) {
                            }
                            else {
                                ++v4;
                                continue;
                            }
                        }
                        else {
                            break;
                        }

                        goto label_66;
                    }

                    v5 = v0;
                label_66:
                    v2 = v5 != null ? ((LazyStaggeredGridItemInfo)v5).getLane() : 0;
                    LazyStaggeredGridMeasuredItem v3_1 = arg7.getMeasuredItemProvider().getAndMeasure-jy6DScQ(arg8, arg7.getSpanRange-lOCCd4c(arg7.getItemProvider(), arg8, v2));
                    ((List)v10_2).add(v3_1);
                    int[] v4_1 = arg7.getResolvedSlots().getPositions();
                    if(v4_1.length > v2) {
                        v1 = v4_1[v2];
                    }

                    arg11.invoke(v3_1, Integer.valueOf(v1));
                }

                if(arg8 == arg9) {
                    break;
                }

                ++arg8;
            }

            return ((List)v10_2);
        }

        return v0;
    }

    private static final int maxInRange-jy6DScQ(int[] arg3, long arg4) {
        int v0 = ((int)(arg4 >> 0x20));
        int v4 = ((int)(arg4 & 0xFFFFFFFFL));
        int v5 = 0x80000000;
        while(v0 < v4) {
            v5 = Math.max(v5, arg3[v0]);
            ++v0;
        }

        return v5;
    }

    private static final LazyStaggeredGridMeasureResult measure(LazyStaggeredGridMeasureContext arg46, int arg47, int[] arg48, int[] arg49, boolean arg50) {
        int v37;
        int v36;
        long v4_5;
        List v24_2;
        ArrayList v30_1;
        float v15_3;
        int[] v50_1;
        List v47_1;
        List v1_8;
        ArrayList v1_7;
        int[] v25_1;
        ArrayList v12_3;
        int v34;
        int v33;
        Object v13_3;
        float v10_3;
        LazyStaggeredGridMeasuredItem v6_6;
        int v4_2;
        long v1_5;
        int[] v7_1;
        int[] v6_4;
        LazyStaggeredGridLaneInfo v6_3;
        LazyLayoutMeasureScope v12_1;
        String v13_2;
        Object v1_4;
        boolean v1_3;
        int v6_2;
        LazyStaggeredGridLaneInfo v11_2;
        int v31;
        int v11_1;
        int v30;
        int[] v29;
        int[] v28;
        LazyStaggeredGridMeasuredItem v1_2;
        int v27;
        LazyLayoutMeasureScope v26;
        int v25;
        int v24;
        boolean v48;
        ArrayDeque[] v9_1;
        int v8;
        int v21;
        int v13;
        int v7;
        int v9;
        int v18;
        int v3_1;
        long v16;
        LazyStaggeredGridMeasureContext v0 = arg46;
        int v1 = arg47;
        int[] v2 = arg48;
        int[] v3 = arg49;
        LazyLayoutMeasureScope v6 = v0.getMeasureScope();
        int v12 = v0.getItemProvider().getItemCount();
        if(v12 > 0) {
            if(v0.getLaneCount() == 0) {
            }
            else {
                int[] v10 = Arrays.copyOf(v2, v2.length);
                String v4 = "copyOf(...)";
                Intrinsics.checkNotNullExpressionValue(v10, v4);
                int[] v11 = Arrays.copyOf(v3, v3.length);
                Intrinsics.checkNotNullExpressionValue(v11, v4);
                LazyStaggeredGridMeasureKt.ensureIndicesInRange(v0, v10, v12);
                LazyStaggeredGridMeasureKt.offsetBy(v11, -v1);
                int v5 = v0.getLaneCount();
                ArrayDeque[] v1_1 = new ArrayDeque[v5];
                int v2_1;
                for(v2_1 = 0; v2_1 < v5; ++v2_1) {
                    v1_1[v2_1] = new ArrayDeque(16);
                }

                LazyStaggeredGridMeasureKt.offsetBy(v11, -v0.getBeforeContentPadding());
                boolean v2_2;
                for(v2_2 = false; true; v2_2 = v14_1) {
                    v16 = 0xFFFFFFFFL;
                    if(!LazyStaggeredGridMeasureKt.measure$lambda$0$hasSpaceBeforeFirst(v10, v11, v0)) {
                        break;
                    }

                    v3_1 = LazyStaggeredGridMeasureKt.indexOfMaxValue(v10);
                    v18 = 0x20;
                    v9 = v10[v3_1];
                    int v14 = v11.length;
                    int v15;
                    for(v15 = 0; v15 < v14; ++v15) {
                        if(v10[v15] != v10[v3_1]) {
                            v7 = v11[v15];
                            v13 = v11[v3_1];
                            if(v7 < v13) {
                                v11[v15] = v13;
                            }
                        }
                    }

                    v21 = 0;
                    v7 = LazyStaggeredGridMeasureKt.findPreviousItemIndex(v0, v9, v3_1);
                    if(v7 < 0) {
                        goto label_106;
                    }

                    long v13_1 = v0.getSpanRange-lOCCd4c(v0.getItemProvider(), v7, v3_1);
                    LazyStaggeredGridLaneInfo v3_2 = v0.getLaneInfo();
                    v8 = ((int)(v13_1 & v16));
                    v9_1 = v1_1;
                    v48 = v2_2;
                    v1 = ((int)(v13_1 >> v18));
                    v2_1 = v8 - v1;
                    v15 = v2_1 != 1 ? -2 : v1;
                    v3_2.setLane(v7, v15);
                    LazyStaggeredGridMeasuredItem v3_3 = v0.getMeasuredItemProvider().getAndMeasure-jy6DScQ(v7, v13_1);
                    v13 = LazyStaggeredGridMeasureKt.maxInRange-jy6DScQ(v11, v13_1);
                    v2 = v2_1 != 1 ? v0.getLaneInfo().getGaps(v7) : null;
                    boolean v14_1 = v48;
                    while(v1 < v8) {
                        v10[v1] = v7;
                        int v19 = v2 == null ? 0 : v2[v1];
                        int v20 = v13 + v3_3.getMainAxisSizeWithSpacings() + v19;
                        v11[v1] = v20;
                        if(v0.getMainAxisAvailableSize() + v20 <= 0) {
                            v14_1 = true;
                        }

                        ++v1;
                    }

                    v1_1 = v9_1;
                }

                v18 = 0x20;
                v21 = 0;
                v3_1 = -1;
            label_106:
                v9_1 = v1_1;
                v48 = v2_2;
                v1 = -v0.getBeforeContentPadding();
                v2_1 = v11[v21];
                if(v2_1 < v1) {
                    LazyStaggeredGridMeasureKt.offsetBy(v11, v1 - v2_1);
                    v7 = arg47 - (v1 - v2_1);
                }
                else {
                    v7 = arg47;
                }

                LazyStaggeredGridMeasureKt.offsetBy(v11, v0.getBeforeContentPadding());
                v2_1 = -1;
                if(v3_1 == v2_1) {
                    v3_1 = ArraysKt.indexOf(v10, v21);
                }

                if(v3_1 != v2_1 && (LazyStaggeredGridMeasureKt.measure$lambda$0$misalignedStart(v10, v0, v11, v3_1)) && (arg50)) {
                    v0.getLaneInfo().reset();
                    v1 = v10.length;
                    int[] v4_1 = new int[v1];
                    v5 = 0;
                    while(v5 < v1) {
                        v4_1[v5] = v2_1;
                        ++v5;
                        v2_1 = -1;
                    }

                    v1 = v11.length;
                    v2 = new int[v1];
                    for(v5 = 0; v5 < v1; ++v5) {
                        v2[v5] = v11[v3_1];
                    }

                    return LazyStaggeredGridMeasureKt.measure(v0, v7, v4_1, v2, false);
                }

                int[] v8_1 = Arrays.copyOf(v10, v10.length);
                Intrinsics.checkNotNullExpressionValue(v8_1, v4);
                v13 = v11.length;
                int[] v14_2 = new int[v13];
                for(v2_1 = 0; v2_1 < v13; ++v2_1) {
                    v14_2[v2_1] = -v11[v2_1];
                }

                v2_1 = v0.getMainAxisSpacing() + v1;
                v3_1 = RangesKt.coerceAtLeast(v0.getMainAxisAvailableSize() + v0.getAfterContentPadding(), 0);
                int v23 = v1;
                ArrayDeque[] v49 = v9_1;
                v15 = LazyStaggeredGridMeasureKt.indexOfMinValue$default(v8_1, 0, 1, null);
                v1 = 0;
            label_176:
                while(v15 != -1) {
                    if(v1 >= v0.getLaneCount()) {
                        break;
                    }

                    v9 = v8_1[v15];
                    v24 = LazyStaggeredGridMeasureKt.indexOfMinValue(v8_1, v9);
                    ++v1;
                    v25 = v1;
                    if(v9 >= 0) {
                        v26 = v6;
                        v27 = v7;
                        long v6_1 = v0.getSpanRange-lOCCd4c(v0.getItemProvider(), v9, v15);
                        v1_2 = v0.getMeasuredItemProvider().getAndMeasure-jy6DScQ(v9, v6_1);
                        LazyStaggeredGridLaneInfo v15_1 = v0.getLaneInfo();
                        v28 = v10;
                        v29 = v11;
                        int v10_1 = ((int)(v6_1 & v16));
                        v30 = v12;
                        v11_1 = ((int)(v6_1 >> v18));
                        v12 = v10_1 - v11_1;
                        v31 = v11_1;
                        if(v12 != 1) {
                            v11_2 = v15_1;
                            v15 = -2;
                        }
                        else {
                            v11_2 = v15_1;
                            v15 = v31;
                        }

                        v11_2.setLane(v9, v15);
                        v6_2 = LazyStaggeredGridMeasureKt.maxInRange-jy6DScQ(v14_2, v6_1);
                        v7 = v31;
                        goto label_211;
                    }
                    else {
                        v15 = v24;
                        continue;
                    }
                }

                v26 = v6;
                v27 = v7;
                v28 = v10;
                v29 = v11;
                v30 = v12;
                goto label_251;
            label_211:
                while(v7 < v10_1) {
                    v14_2[v7] = v1_2.getMainAxisSizeWithSpacings() + v6_2;
                    v8_1[v7] = v9;
                    v49[v7].addLast(v1_2);
                    ++v7;
                }

                if(v6_2 >= v2_1 || v14_2[v31] > v2_1) {
                    v1_3 = v48;
                }
                else {
                    v1_2.setVisible(false);
                    v1_3 = true;
                }

                if(v12 != 1) {
                    v48 = v1_3;
                    v1 = v0.getLaneCount();
                    v15 = v24;
                }
                else {
                    v48 = v1_3;
                    v15 = v24;
                    v1 = v25;
                }

                v6 = v26;
                v7 = v27;
                v10 = v28;
                v11 = v29;
                v12 = v30;
                goto label_176;
                while(true) {
                label_251:
                    v1 = 0;
                    while(true) {
                        if(v1 < v13) {
                            v6_2 = v14_2[v1];
                            if(v6_2 < v3_1) {
                                goto label_259;
                            }
                            else if(v6_2 <= 0) {
                                goto label_259;
                            }
                            else {
                                ++v1;
                                continue;
                            }
                        }
                        else {
                            break;
                        }

                        goto label_278;
                    }

                    v1 = 0;
                    while(true) {
                        if(v1 >= v5) {
                            break;
                        }
                        else if(!v49[v1].isEmpty()) {
                            v12 = v30;
                            v11_1 = 1;
                        }
                        else {
                            ++v1;
                            continue;
                        }

                        goto label_278;
                    }

                label_259:
                    v1_4 = null;
                    v11_1 = 1;
                    v6_2 = LazyStaggeredGridMeasureKt.indexOfMinValue$default(v14_2, 0, 1, v1_4);
                    v1 = ArraysKt.maxOrThrow(v8_1) + 1;
                    v12 = v30;
                    if(v1 >= v12) {
                    label_278:
                        v1 = 0;
                        break;
                    }

                    v7 = v13;
                    v13_2 = v4;
                    boolean v15_2 = v48;
                    v24 = v3_1;
                    v30 = v12;
                    v12_1 = v26;
                    v11_1 = v27;
                    v27 = v7;
                    long v3_4 = v0.getSpanRange-lOCCd4c(v0.getItemProvider(), v1, v6_2);
                    v6_3 = v0.getLaneInfo();
                    ArrayDeque[] v10_2 = v49;
                    int[] v47 = v8_1;
                    v7 = ((int)(v3_4 & v16));
                    v8 = ((int)(v3_4 >> v18));
                    v9 = v7 - v8;
                    int v0_1 = v9 != 1 ? -2 : v8;
                    v6_3.setLane(v1, v0_1);
                    LazyStaggeredGridMeasuredItem v0_2 = arg46.getMeasuredItemProvider().getAndMeasure-jy6DScQ(v1, v3_4);
                    v3_1 = LazyStaggeredGridMeasureKt.maxInRange-jy6DScQ(v14_2, v3_4);
                    if(v9 != 1) {
                        v6_4 = arg46.getLaneInfo().getGaps(v1);
                        if(v6_4 == null) {
                            v6_4 = new int[arg46.getLaneCount()];
                        }
                    }
                    else {
                        v6_4 = null;
                    }

                    for(v9 = v8; v9 < v7; ++v9) {
                        if(v6_4 != null) {
                            v6_4[v9] = v3_1 - v14_2[v9];
                        }

                        v47[v9] = v1;
                        v14_2[v9] = v3_1 + v0_2.getMainAxisSizeWithSpacings();
                        v10_2[v9].addLast(v0_2);
                    }

                    arg46.getLaneInfo().setGaps(v1, v6_4);
                    if(v3_1 < v2_1 && v14_2[v8] <= v2_1) {
                        v0_2.setVisible(false);
                    }

                    v0 = arg46;
                    v8_1 = v47;
                    v49 = v10_2;
                    v26 = v12_1;
                    v4 = v13_2;
                    v48 = v15_2;
                    v3_1 = v24;
                    v13 = v27;
                    v27 = v11_1;
                }

                while(v1 < v5) {
                    ArrayDeque v2_3 = v49[v1];
                    while(v2_3.size() > v11_1) {
                        if(v2_3.first().isVisible()) {
                            break;
                        }

                        Object v6_5 = v2_3.removeFirst();
                        v7_1 = ((LazyStaggeredGridMeasuredItem)v6_5).getSpan() != v11_1 ? v0.getLaneInfo().getGaps(((LazyStaggeredGridMeasuredItem)v6_5).getIndex()) : null;
                        v9 = v29[v1];
                        v6_2 = ((LazyStaggeredGridMeasuredItem)v6_5).getMainAxisSizeWithSpacings();
                        v7 = v7_1 == null ? 0 : v7_1[v1];
                        v29[v1] = v9 - (v6_2 + v7);
                        v11_1 = 1;
                    }

                    Object v2_4 = v2_3.firstOrNull();
                    v2_1 = v2_4 != null ? ((LazyStaggeredGridMeasuredItem)v2_4).getIndex() : -1;
                    v28[v1] = v2_1;
                    ++v1;
                    v11_1 = 1;
                }

                v1 = v8_1.length;
                v2_1 = 0;
                while(v2_1 < v1) {
                    if(v8_1[v2_1] == v12 - 1) {
                        LazyStaggeredGridMeasureKt.offsetBy(v14_2, -v0.getMainAxisSpacing());
                    }
                    else {
                        ++v2_1;
                        continue;
                    }

                    break;
                }

                v1 = 0;
                while(true) {
                    if(v1 >= v13) {
                        goto label_343;
                    }
                    else if(v14_2[v1] < v0.getMainAxisAvailableSize()) {
                        ++v1;
                        continue;
                    }
                    else {
                        break;
                    }
                }

                v30 = v12;
                v7 = v27;
                v11_1 = v7;
                v10 = v28;
                int[] v9_2 = v29;
                int v28_1 = v3_1;
                v27 = v13;
                v13_2 = v4;
                goto label_502;
            label_343:
                v2_1 = v0.getMainAxisAvailableSize() - v14_2[LazyStaggeredGridMeasureKt.indexOfMaxValue(v14_2)];
                v9_2 = v29;
                LazyStaggeredGridMeasureKt.offsetBy(v9_2, -v2_1);
                LazyStaggeredGridMeasureKt.offsetBy(v14_2, v2_1);
                v1 = 0;
                while(true) {
                    v6_2 = v9_2.length;
                    v7 = 0;
                    while(true) {
                        if(v7 >= v6_2) {
                            break;
                        }
                        else if(v9_2[v7] < v0.getBeforeContentPadding()) {
                            v6_2 = LazyStaggeredGridMeasureKt.indexOfMinValue$default(v9_2, 0, 1, null);
                            v7 = LazyStaggeredGridMeasureKt.indexOfMaxValue(v28);
                            if(v6_2 != v7) {
                                if(v9_2[v6_2] == v9_2[v7]) {
                                    v6_2 = v7;
                                }
                                else {
                                    v1 = 1;
                                }
                            }

                            v7 = v28[v6_2];
                            if(v7 == -1) {
                                v7 = v12;
                            }

                            v7 = LazyStaggeredGridMeasureKt.findPreviousItemIndex(v0, v7, v6_2);
                            if(v7 < 0) {
                                v10 = v28;
                                if((v1 != 0 || (LazyStaggeredGridMeasureKt.measure$lambda$0$misalignedStart(v10, v0, v9_2, v6_2))) && (arg50)) {
                                    v0.getLaneInfo().reset();
                                    v1 = v10.length;
                                    v2 = new int[v1];
                                    v3_1 = 0;
                                    goto label_386;
                                }

                                v11_1 = v27;
                                v24 = v2_1;
                                v28_1 = v3_1;
                                v30 = v12;
                                goto label_482;
                            }

                            v11_1 = v27;
                            v10 = v28;
                            v25 = v1;
                            v24 = v2_1;
                            v1_5 = v0.getSpanRange-lOCCd4c(v0.getItemProvider(), v7, v6_2);
                            v6_3 = v0.getLaneInfo();
                            v30 = v12;
                            v27 = v13;
                            v12 = ((int)(v1_5 & v16));
                            v28_1 = v3_1;
                            v13_2 = v4;
                            v3_1 = ((int)(v1_5 >> v18));
                            v4_2 = v12 - v3_1;
                            v15 = v4_2 != 1 ? -2 : v3_1;
                            v6_3.setLane(v7, v15);
                            v6_6 = v0.getMeasuredItemProvider().getAndMeasure-jy6DScQ(v7, v1_5);
                            v1 = LazyStaggeredGridMeasureKt.maxInRange-jy6DScQ(v9_2, v1_5);
                            v2 = v4_2 != 1 ? v0.getLaneInfo().getGaps(v7) : null;
                            goto label_439;
                        }
                        else {
                            ++v7;
                            v13 = v13;
                            v28 = v28;
                            v27 = v27;
                            continue;
                        }
                    }

                    v11_1 = v27;
                    v10 = v28;
                    v24 = v2_1;
                    v30 = v12;
                    v28_1 = v3_1;
                label_482:
                    v27 = v13;
                    v13_2 = v4;
                    if(v1 != 0 && (arg50)) {
                        v0.getLaneInfo().reset();
                        return LazyStaggeredGridMeasureKt.measure(v0, v11_1, v10, v9_2, false);
                    }

                    v7 = v11_1 + v24;
                    v1 = v9_2[LazyStaggeredGridMeasureKt.indexOfMinValue$default(v9_2, 0, 1, null)];
                    if(v1 >= 0) {
                        goto label_502;
                    }

                    v7 += v1;
                    LazyStaggeredGridMeasureKt.offsetBy(v14_2, v1);
                    LazyStaggeredGridMeasureKt.offsetBy(v9_2, -v1);
                    goto label_502;
                label_439:
                    while(v3_1 < v12) {
                        if(v9_2[v3_1] != v1) {
                            v25 = 1;
                        }

                        v49[v3_1].addFirst(v6_6);
                        v10[v3_1] = v7;
                        v4_2 = v2 == null ? 0 : v2[v3_1];
                        v9_2[v3_1] = v1 + v6_6.getMainAxisSizeWithSpacings() + v4_2;
                        ++v3_1;
                    }

                    v4 = v13_2;
                    v2_1 = v24;
                    v1 = v25;
                    v13 = v27;
                    v3_1 = v28_1;
                    v12 = v30;
                    v28 = v10;
                    v27 = v11_1;
                }

            label_386:
                while(v3_1 < v1) {
                    v2[v3_1] = -1;
                    ++v3_1;
                }

                v1 = v9_2.length;
                v3 = new int[v1];
                for(v4_2 = 0; v4_2 < v1; ++v4_2) {
                    v3[v4_2] = v9_2[v6_2];
                }

                return LazyStaggeredGridMeasureKt.measure(v0, v27, v2, v3, false);
            label_502:
                float v1_6 = v0.getState().scrollToBeConsumed$foundation(v26.isLookingAhead());
                if(MathKt.getSign(Math.round(v1_6)) != MathKt.getSign(v7) || Math.abs(Math.round(v1_6)) < Math.abs(v7)) {
                    v6_4 = v10;
                    v10_3 = v1_6;
                }
                else {
                    v6_4 = v10;
                    v10_3 = ((float)v7);
                }

                v1_6 -= v10_3;
                float v3_5 = 0f;
                if((v26.isLookingAhead()) && v7 > v11_1 && v1_6 <= 0f) {
                    v3_5 = (((float)(v7 - v11_1))) + v1_6;
                }

                float v7_2 = v3_5;
                v2 = Arrays.copyOf(v9_2, v9_2.length);
                Intrinsics.checkNotNullExpressionValue(v2, v13_2);
                v1 = v2.length;
                for(v3_1 = 0; v3_1 < v1; ++v3_1) {
                    v2[v3_1] = -v2[v3_1];
                }

                if(v0.getBeforeContentPadding() > v0.getMainAxisSpacing()) {
                    for(v1 = 0; v1 < v5; ++v1) {
                        ArrayDeque v3_6 = v49[v1];
                        v4_2 = v3_6.size();
                        v11_1 = 0;
                        while(v11_1 < v4_2) {
                            v13_3 = v3_6.get(v11_1);
                            int[] v12_2 = v0.getLaneInfo().getGaps(((LazyStaggeredGridMeasuredItem)v13_3).getIndex());
                            v13 = ((LazyStaggeredGridMeasuredItem)v13_3).getMainAxisSizeWithSpacings();
                            v12 = v12_2 == null ? 0 : v12_2[v1];
                            v13 += v12;
                            if(v11_1 == CollectionsKt.getLastIndex(v3_6)) {
                                break;
                            }

                            v12 = v9_2[v1];
                            if(v12 == 0) {
                                break;
                            }

                            if(v12 < v13) {
                                break;
                            }

                            v9_2[v1] = v12 - v13;
                            ++v11_1;
                            v6_4[v1] = v3_6.get(v11_1).getIndex();
                        }
                    }
                }

                v11_1 = v0.getBeforeContentPadding() + v0.getAfterContentPadding();
                v1 = v0.isVertical() ? Constraints.getMaxWidth-impl(v0.getConstraints-msEJaDk()) : ConstraintsKt.constrainWidth-K40F9xA(v0.getConstraints-msEJaDk(), ArraysKt.maxOrThrow(v14_2) + v11_1);
                v33 = v1;
                v1 = v0.isVertical() ? ConstraintsKt.constrainHeight-K40F9xA(v0.getConstraints-msEJaDk(), ArraysKt.maxOrThrow(v14_2) + v11_1) : Constraints.getMaxHeight-impl(v0.getConstraints-msEJaDk());
                v34 = v1;
                v1 = v0.isVertical() ? v34 : v33;
                v3_1 = v0.getAfterContentPadding() + (Math.min(v1, v0.getMainAxisAvailableSize()) - v0.getBeforeContentPadding());
                v1 = v2[0];
                List v4_3 = v0.getPinnedItems();
                v12 = v4_3.size() - 1;
                if(v12 >= 0) {
                    v15 = v12;
                    v12_3 = null;
                    while(true) {
                        v24 = v15 - 1;
                        v15 = v4_3.get(v15).intValue();
                        v13 = v0.getLaneInfo().getLane(v15);
                        int v50 = v1;
                        if(v13 == -2 || v13 == -1) {
                            for(v1 = 0; true; ++v1) {
                                if(v1 >= v5) {
                                    goto label_653;
                                }

                                v13_3 = v49[v1].firstOrNull();
                                v13 = v13_3 != null ? ((LazyStaggeredGridMeasuredItem)v13_3).getIndex() : -1;
                                if(v13 <= v15) {
                                    break;
                                }
                            }

                        label_650:
                            v1 = v50;
                            v25_1 = v2;
                            goto label_668;
                        label_653:
                            v25_1 = v2;
                            v1_5 = v0.getSpanRange-lOCCd4c(v0.getItemProvider(), v15, 0);
                            if(v12_3 == null) {
                                v12_3 = new ArrayList();
                            }

                            v1_2 = v0.getMeasuredItemProvider().getAndMeasure-jy6DScQ(v15, v1_5);
                            v2_1 = v50 - v1_2.getMainAxisSizeWithSpacings();
                            v1_2.position(v2_1, 0, v3_1);
                            ((List)v12_3).add(v1_2);
                            v1 = v2_1;
                        }
                        else {
                            v1_4 = v49[v13].firstOrNull();
                            v1 = v1_4 != null ? ((LazyStaggeredGridMeasuredItem)v1_4).getIndex() : -1;
                            if(v1 <= v15) {
                                goto label_650;
                            }

                            goto label_653;
                        }

                    label_668:
                        if(v24 < 0) {
                            v1_7 = v12_3;
                            break;
                        }

                        v15 = v24;
                        v2 = v25_1;
                    }
                }
                else {
                    v25_1 = v2;
                    v1_7 = null;
                }

                if(v1_7 == null) {
                    v1_8 = CollectionsKt.emptyList();
                }

                v12_3 = v1_7;
                v1_8 = LazyStaggeredGridMeasureKt.calculateVisibleItems(v0, v49, v25_1, v3_1, v23, v28_1);
                v23 = v23;
                v28_1 = v28_1;
                v2_1 = v25_1[0];
                Object v4_4 = CollectionsKt.lastOrNull(v1_8);
                v4_2 = v4_4 != null ? ((LazyStaggeredGridMeasuredItem)v4_4).getIndex() : -1;
                if(!v26.isLookingAhead() || v0.getApproachLayoutInfo() == null || (v0.getApproachLayoutInfo().getVisibleItemsInfo().isEmpty())) {
                label_804:
                    v47_1 = v1_8;
                    v50_1 = v6_4;
                    v15_3 = v7_2;
                    v29 = v9_2;
                    v1_7 = null;
                }
                else {
                    List v5_1 = v0.getApproachLayoutInfo().getVisibleItemsInfo();
                    for(v13 = v5_1.size() - 1; -1 < v13; --v13) {
                        if(v5_1.get(v13).getIndex() > v4_2 && (v13 == 0 || v5_1.get(v13 - 1).getIndex() <= v4_2)) {
                            v4_4 = v5_1.get(v13);
                            goto label_722;
                        }
                    }

                    v4_4 = null;
                label_722:
                    Object v5_2 = CollectionsKt.last(v0.getApproachLayoutInfo().getVisibleItemsInfo());
                    if(v4_4 == null) {
                        goto label_804;
                    }

                    v4_2 = ((LazyStaggeredGridItemInfo)v4_4).getIndex();
                    v5 = Math.min(((LazyStaggeredGridItemInfo)v5_2).getIndex(), v30 - 1);
                    if(v4_2 > v5) {
                        goto label_804;
                    }

                    v13 = v4_2;
                    v4_2 = v2_1;
                    ArrayList v2_5 = null;
                    while(true) {
                        if(v2_5 != null) {
                            v15 = v2_5.size();
                            v47_1 = v1_8;
                            v1 = 0;
                            while(true) {
                                if(v1 < v15) {
                                    v25 = v1;
                                    if(((List)v2_5).get(v1).getIndex() == v13) {
                                        v50_1 = v6_4;
                                        v15_3 = v7_2;
                                        v29 = v9_2;
                                    }
                                    else {
                                        v1 = v25 + 1;
                                        continue;
                                    }
                                }
                                else {
                                    goto label_751;
                                }

                                break;
                            }
                        }
                        else {
                            v47_1 = v1_8;
                        label_751:
                            if(v2_5 == null) {
                                v2_5 = new ArrayList();
                            }

                            v1_8 = v0.getApproachLayoutInfo().getVisibleItemsInfo();
                            v15 = v1_8.size();
                            v50_1 = v6_4;
                            v6_2 = 0;
                            while(true) {
                                if(v6_2 < v15) {
                                    Object v24_1 = v1_8.get(v6_2);
                                    List v29_1 = v1_8;
                                    if(v24_1.getIndex() == v13) {
                                        v1_4 = v24_1;
                                    }
                                    else {
                                        ++v6_2;
                                        v1_8 = v29_1;
                                        continue;
                                    }
                                }
                                else {
                                    break;
                                }

                                goto label_773;
                            }

                            v1_4 = null;
                        label_773:
                            v1 = v1_4 != null ? ((LazyStaggeredGridItemInfo)v1_4).getLane() : 0;
                            v15_3 = v7_2;
                            v29 = v9_2;
                            v6_6 = v0.getMeasuredItemProvider().getAndMeasure-jy6DScQ(v13, v0.getSpanRange-lOCCd4c(v0.getItemProvider(), v13, v1));
                            ((List)v2_5).add(v6_6);
                            v7_1 = v0.getResolvedSlots().getPositions();
                            v1 = v7_1.length > v1 ? v7_1[v1] : 0;
                            v6_6.position(v4_2, v1, v3_1);
                            v4_2 += v6_6.getMainAxisSizeWithSpacings();
                        }

                        if(v13 == v5) {
                            break;
                        }

                        ++v13;
                        v1_8 = v47_1;
                        v6_4 = v50_1;
                        v7_2 = v15_3;
                        v9_2 = v29;
                    }

                    v1_7 = v2_5;
                    v2_1 = v4_2;
                }

                v4_3 = v0.getPinnedItems();
                v5 = v4_3.size();
                v6_2 = 0;
                ArrayList v20_1 = null;
                while(v6_2 < v5) {
                    v7 = v4_3.get(v6_2).intValue();
                    v9 = v30;
                    if(v7 >= v9) {
                        v30_1 = v1_7;
                        v24_2 = v4_3;
                        goto label_855;
                    }
                    else {
                        if(v1_7 != null) {
                            v13 = v1_7.size();
                            v24_2 = v4_3;
                            v4_2 = 0;
                            while(v4_2 < v13) {
                                v30_1 = v1_7;
                                if(((List)v1_7).get(v4_2).getIndex() == v7) {
                                    goto label_855;
                                }
                                else {
                                    ++v4_2;
                                    v1_7 = v30_1;
                                    continue;
                                }
                            }
                        }
                        else {
                            v24_2 = v4_3;
                        }

                        v30_1 = v1_7;
                        v1 = v0.getLaneInfo().getLane(v7);
                        v13 = -1;
                        if(v1 == -2 || v1 == v13) {
                            v1 = v8_1.length;
                            v4_2 = 0;
                            while(true) {
                                if(v4_2 < v1) {
                                    if(v8_1[v4_2] < v7) {
                                        ++v4_2;
                                        continue;
                                    }
                                    else {
                                        break;
                                    }
                                }

                                goto label_858;
                            }

                        label_855:
                            v25 = v5;
                            v31 = v6_2;
                            goto label_875;
                        }
                        else if(v8_1[v1] < v7) {
                        }
                        else {
                            goto label_855;
                        }

                    label_858:
                        v25 = v5;
                        v4_5 = v0.getSpanRange-lOCCd4c(v0.getItemProvider(), v7, 0);
                        if(v20_1 == null) {
                            v20_1 = new ArrayList();
                        }

                        v31 = v6_2;
                        LazyStaggeredGridMeasuredItem v4_6 = v0.getMeasuredItemProvider().getAndMeasure-jy6DScQ(v7, v4_5);
                        v4_6.position(v2_1, 0, v3_1);
                        v2_1 += v4_6.getMainAxisSizeWithSpacings();
                        v20_1.add(v4_6);
                        v20_1 = v20_1;
                    }

                label_875:
                    v6_2 = v31 + 1;
                    v4_3 = v24_2;
                    v5 = v25;
                    v1_7 = v30_1;
                    v30 = v9;
                }

                v9 = v30;
                v30_1 = v1_7;
                if(v20_1 == null) {
                    List v20_2 = CollectionsKt.emptyList();
                }

                v1_7 = new ArrayList();
                ((List)v1_7).addAll(((Collection)v12_3));
                ((List)v1_7).addAll(v47_1);
                if(v30_1 != null) {
                    ((List)v1_7).addAll(v30_1);
                }

                ((List)v1_7).addAll(v20_1);
                ArrayList v35 = v1_7;
                v0.getState().getItemAnimator$foundation().onMeasured(((int)v10_3), v33, v34, ((List)v35), v0.getMeasuredItemProvider().getKeyIndexMap(), v0.getMeasuredItemProvider(), v0.isVertical(), v26.isLookingAhead(), v0.getLaneCount(), v0.isInLookaheadScope(), ArraysKt.minOrThrow(v29), ArraysKt.maxOrThrow(v14_2) + v11_1, v0.getCoroutineScope(), v0.getGraphicsContext());
                v1 = v33;
                v2_1 = v34;
                ArrayList v3_7 = v35;
                if(!v26.isLookingAhead()) {
                    v4_5 = v0.getState().getItemAnimator$foundation().getMinSizeToFitDisappearingItems-YbymL2g();
                    if(!IntSize.equals-impl0(v4_5, IntSize.Companion.getZero-YbymL2g())) {
                        v6_2 = v0.isVertical() ? v2_1 : v1;
                        v33 = ConstraintsKt.constrainWidth-K40F9xA(v0.getConstraints-msEJaDk(), Math.max(v1, ((int)(v4_5 >> v18))));
                        v34 = ConstraintsKt.constrainHeight-K40F9xA(v0.getConstraints-msEJaDk(), Math.max(v2_1, ((int)(v4_5 & v16))));
                        v1 = v0.isVertical() ? v34 : v33;
                        if(v1 != v6_2) {
                            v2_1 = v3_7.size();
                            for(v4_2 = 0; v4_2 < v2_1; ++v4_2) {
                                ((List)v3_7).get(v4_2).updateMainAxisLayoutSize(v1);
                            }
                        }

                        v36 = v33;
                        v37 = v34;
                    }
                    else {
                        goto label_959;
                    }
                }
                else {
                label_959:
                    v36 = v1;
                    v37 = v2_1;
                }

                v4_2 = v27;
                v1 = 0;
                while(true) {
                    if(v1 >= v4_2) {
                        break;
                    }
                    else if(v14_2[v1] > v0.getMainAxisAvailableSize()) {
                        goto label_980;
                    }
                    else {
                        ++v1;
                        continue;
                    }
                }

                v1 = v8_1.length;
                v2_1 = 0;
                while(true) {
                    if(v2_1 >= v1) {
                        goto label_980;
                    }
                    else if(v8_1[v2_1] < v9 - 1) {
                        ++v2_1;
                        continue;
                    }
                    else {
                        break;
                    }
                }

                boolean v13_4 = false;
                goto label_981;
            label_980:
                v13_4 = true;
            label_981:
                return new LazyStaggeredGridMeasureResult(v50_1, v29, v10_3, MeasureScope.layout$default(v26, v36, v37, null, new LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda2(v0, ((List)v3_7), v26), 4, null), v15_3, v13_4, v0.isVertical(), v48, v0.getResolvedSlots(), v0.getItemProvider().getSpanProvider(), v26, v9, v47_1, IntSize.constructor-impl((((long)v37)) & v16 | (((long)v36)) << v18), v23, v28_1, v0.getBeforeContentPadding(), v0.getAfterContentPadding(), v0.getMainAxisSpacing(), v0.getCoroutineScope(), null);
            }
        }

        v30 = v12;
        v16 = 0xFFFFFFFFL;
        v18 = 0x20;
        v12_1 = v6;
        v33 = Constraints.getMinWidth-impl(arg46.getConstraints-msEJaDk());
        v34 = Constraints.getMinHeight-impl(arg46.getConstraints-msEJaDk());
        arg46.getState().getItemAnimator$foundation().onMeasured(0, v33, v34, new ArrayList(), arg46.getMeasuredItemProvider().getKeyIndexMap(), arg46.getMeasuredItemProvider(), arg46.isVertical(), v12_1.isLookingAhead(), arg46.getLaneCount(), arg46.isInLookaheadScope(), 0, 0, arg46.getCoroutineScope(), arg46.getGraphicsContext());
        if(!v12_1.isLookingAhead()) {
            long v0_3 = arg46.getState().getItemAnimator$foundation().getMinSizeToFitDisappearingItems-YbymL2g();
            if(!IntSize.equals-impl0(v0_3, IntSize.Companion.getZero-YbymL2g())) {
                v33 = ConstraintsKt.constrainWidth-K40F9xA(arg46.getConstraints-msEJaDk(), ((int)(v0_3 >> v18)));
                v34 = ConstraintsKt.constrainHeight-K40F9xA(arg46.getConstraints-msEJaDk(), ((int)(v0_3 & v16)));
            }
        }

        return new LazyStaggeredGridMeasureResult(v2, arg49, 0f, MeasureScope.layout$default(v12_1, v33, v34, null, new LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda1(), 4, null), 0f, false, arg46.isVertical(), false, arg46.getResolvedSlots(), arg46.getItemProvider().getSpanProvider(), v12_1, v30, CollectionsKt.emptyList(), IntSize.constructor-impl((((long)Constraints.getMinHeight-impl(arg46.getConstraints-msEJaDk()))) & v16 | (((long)Constraints.getMinWidth-impl(arg46.getConstraints-msEJaDk()))) << v18), -arg46.getBeforeContentPadding(), arg46.getMainAxisAvailableSize() + arg46.getAfterContentPadding(), arg46.getBeforeContentPadding(), arg46.getAfterContentPadding(), arg46.getMainAxisSpacing(), arg46.getCoroutineScope(), null);
    }

    private static final Unit measure$lambda$0$0(PlacementScope arg0) {
        return Unit.INSTANCE;
    }

    private static final CharSequence measure$lambda$0$28$0(LazyStaggeredGridMeasuredItem arg0) {
        return String.valueOf(arg0.getIndex());
    }

    private static final CharSequence measure$lambda$0$32$0(LazyStaggeredGridMeasuredItem arg0) {
        return String.valueOf(arg0.getIndex());
    }

    private static final Unit measure$lambda$0$37(LazyStaggeredGridMeasureContext arg1, List arg2, LazyLayoutMeasureScope arg3, PlacementScope arg4) {
        arg4.withMotionFrameOfReferencePlacement(new LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda0(arg2, arg1, arg3));
        ObservableScopeInvalidator.attachToScope-impl(arg1.getState().getPlacementScopeInvalidator-zYiylxw$foundation());
        return Unit.INSTANCE;
    }

    private static final Unit measure$lambda$0$37$0(List arg4, LazyStaggeredGridMeasureContext arg5, LazyLayoutMeasureScope arg6, PlacementScope arg7) {
        int v0 = arg4.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg4.get(v1).place(arg7, arg5, arg6.isLookingAhead());
        }

        return Unit.INSTANCE;
    }

    private static final boolean measure$lambda$0$hasSpaceBeforeFirst(int[] arg6, int[] arg7, LazyStaggeredGridMeasureContext arg8) {
        int v0 = arg6.length;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            int v3 = arg6[v2];
            if(arg7[v2] < Math.max(-arg8.getMainAxisSpacing(), 0) && v3 > 0) {
                return 1;
            }
        }

        return 0;
    }

    private static final boolean measure$lambda$0$misalignedStart(int[] arg7, LazyStaggeredGridMeasureContext arg8, int[] arg9, int arg10) {
        int v0 = arg7.length;
        int v2;
        for(v2 = 0; true; ++v2) {
            int v3 = -1;
            if(v2 >= v0) {
                break;
            }

            if(LazyStaggeredGridMeasureKt.findPreviousItemIndex(arg8, arg7[v2], v2) == v3 && arg9[v2] != arg9[arg10]) {
                return 1;
            }
        }

        v0 = arg7.length;
        for(v2 = 0; v2 < v0; ++v2) {
            if(LazyStaggeredGridMeasureKt.findPreviousItemIndex(arg8, arg7[v2], v2) != v3 && arg9[v2] >= arg9[arg10]) {
                return 1;
            }
        }

        int v7 = arg8.getLaneInfo().getLane(0);
        if(v7 != 0 && v7 != v3 && v7 != -2) {
            return 1;
        }

        return 0;
    }

    public static final LazyStaggeredGridMeasureResult measureStaggeredGrid-C6celF4(LazyLayoutMeasureScope arg22, LazyStaggeredGridState arg23, List arg24, LazyStaggeredGridItemProvider arg25, LazyStaggeredGridSlots arg26, long arg27, boolean arg29, boolean arg30, long arg31, int arg33, int arg34, int arg35, int arg36, CoroutineScope arg37, boolean arg38, boolean arg39, LazyStaggeredGridLayoutInfo arg40, GraphicsContext arg41) {
        int v9;
        int[] v5;
        int v4;
        LazyStaggeredGridState v1 = arg23;
        LazyStaggeredGridMeasureContext v0 = new LazyStaggeredGridMeasureContext(v1, arg24, arg25, arg26, arg27, arg29, arg22, arg33, arg31, arg35, arg36, arg30, arg34, arg37, arg38, arg39, arg40, arg41, null);
        int[] v2 = v1.updateScrollPositionIfTheFirstItemWasMoved$foundation(arg25, v1.getScrollPosition$foundation().getIndices());
        int[] v3 = v1.getScrollPosition$foundation().getScrollOffsets();
        if(v2.length == v0.getLaneCount()) {
        }
        else {
            v0.getLaneInfo().reset();
            v4 = v0.getLaneCount();
            v5 = new int[v4];
            int v8;
            for(v8 = 0; v8 < v4; ++v8) {
                if(v8 < v2.length) {
                    v9 = v2[v8];
                    if(v9 != -1) {
                    }
                    else {
                        goto label_45;
                    }
                }
                else {
                label_45:
                    v9 = v8 == 0 ? 0 : LazyStaggeredGridMeasureKt.maxInRange-jy6DScQ(v5, SpanRange.constructor-impl(0, v8)) + 1;
                }

                v5[v8] = v9;
                v0.getLaneInfo().setLane(v5[v8], v8);
            }

            v2 = v5;
        }

        if(v3.length != v0.getLaneCount()) {
            v4 = v0.getLaneCount();
            v5 = new int[v4];
            for(v8 = 0; v8 < v4; ++v8) {
                if(v8 < v3.length) {
                    v9 = v3[v8];
                }
                else if(v8 == 0) {
                    v9 = 0;
                }
                else {
                    v9 = v5[v8 - 1];
                }

                v5[v8] = v9;
            }

            v3 = v5;
        }

        boolean v4_1 = arg39;
        return LazyStaggeredGridMeasureKt.measure(v0, Math.round(v1.scrollToBeConsumed$foundation(v4_1)), v2, v3, true);
    }

    private static final void offsetBy(int[] arg3, int arg4) {
        int v0 = arg3.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg3[v1] += arg4;
        }
    }

    private static final int[] transform(int[] arg3, Function1 arg4) {
        int v0 = arg3.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg3[v1] = arg4.invoke(Integer.valueOf(arg3[v1])).intValue();
        }

        return arg3;
    }

    private static final Object withDebugLogging(LazyLayoutMeasureScope arg0, Function1 arg1) {
        return arg1.invoke(arg0);
    }
}

