package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement$Horizontal;
import androidx.compose.foundation.layout.Arrangement$Vertical;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutStickyItemsKt;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.StickyItemsPlacement;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000¸\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u000B\n\u0002\u0010\u0011\n\u0002\b\u0002\u001Aü\u0002\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\u00032\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001A\u00020\u00132\u0006\u0010\u0019\u001A\u00020\u001A2\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u001D0\u001C2\u0006\u0010\u001E\u001A\u00020\u00032\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u00030 2\u0006\u0010!\u001A\u00020\u00132\u0006\u0010\"\u001A\u00020\u00132\b\u0010#\u001A\u0004\u0018\u00010$2\u0006\u0010%\u001A\u00020&2\u0006\u0010\'\u001A\u00020(2\u0006\u0010)\u001A\u00020*23\u0010+\u001A/\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0011000 0,2!\u00101\u001A\u001D\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u00030,2\b\u00103\u001A\u0004\u0018\u0001042/\u00105\u001A+\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u0002080,¢\u0006\u0002\b9\u0012\u0004\u0012\u00020:06H\u0000¢\u0006\u0004\b;\u0010<\u001AA\u0010=\u001A\b\u0012\u0004\u0012\u00020\u001D0 2\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u00030 2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0004\u001A\u00020\u00052\u0012\u0010>\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130,H\u0082\b\u001AF\u0010?\u001A\b\u0012\u0004\u0012\u00020@0 2\u0006\u0010A\u001A\u00020\u00032\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\"\u001A\u00020\u00132\f\u0010B\u001A\b\u0012\u0004\u0012\u00020@0 2\b\u0010C\u001A\u0004\u0018\u00010$H\u0002\u001A\u008C\u0001\u0010D\u001A\b\u0012\u0004\u0012\u00020\u001D0E2\f\u0010F\u001A\b\u0012\u0004\u0012\u00020@0 2\f\u0010G\u001A\b\u0012\u0004\u0012\u00020\u001D0 2\f\u0010H\u001A\b\u0012\u0004\u0012\u00020\u001D0 2\u0006\u0010I\u001A\u00020\u00032\u0006\u0010J\u001A\u00020\u00032\u0006\u0010K\u001A\u00020\u00032\u0006\u0010L\u001A\u00020\u00032\u0006\u0010M\u001A\u00020\u00032\u0006\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001A\u00020\u00132\u0006\u0010\u0019\u001A\u00020\u001AH\u0002\u001A+\u0010N\u001A\u000208\"\u0004\b\u0000\u0010O*\b\u0012\u0004\u0012\u0002HO0E2\f\u0010P\u001A\b\u0012\u0004\u0012\u0002HO0QH\u0002¢\u0006\u0002\u0010R¨\u0006S"}, d2={"measureLazyGrid", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "itemsCount", "", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenLines", "firstVisibleLineIndex", "firstVisibleLineScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "slotsPerLine", "pinnedItems", "", "isInLookaheadScope", "isLookingAhead", "approachLayoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "prefetchInfoRetriever", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "line", "Lkotlin/Pair;", "lineIndexProvider", "itemIndex", "stickyItemsScrollBehavior", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "layout", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyGrid-t1x4au0", "(ILandroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;ILjava/util/List;ZZLandroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "calculateExtraItems", "filter", "linesRetainedForLookahead", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "lastVisibleItemIndex", "visibleLines", "lastApproachLayoutInfo", "calculateItemsOffsets", "", "lines", "itemsBefore", "itemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "firstLineScrollOffset", "addAllFromArray", "T", "arr", "", "(Ljava/util/List;[Ljava/lang/Object;)V", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyGridMeasureKt {
    public static Unit $r8$lambda$MYA-mBtLpdP12KFjW6wO0ZW4tVQ(List arg0, List arg1, boolean arg2, PlacementScope arg3) {
        return LazyGridMeasureKt.measureLazyGrid_t1x4au0$lambda$8$0(arg0, arg1, arg2, arg3);
    }

    private static final void addAllFromArray(List arg3, Object[] arg4) {
        int v0 = arg4.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg3.add(arg4[v1]);
        }
    }

    private static final List calculateExtraItems(List arg11, LazyGridMeasuredItemProvider arg12, LazyGridMeasuredLineProvider arg13, Function1 arg14) {
        LazyGridMeasuredItemProvider v5;
        int v0 = arg11.size();
        ArrayList v1 = null;
        int v3 = 0;
        while(v3 < v0) {
            int v6 = arg11.get(v3).intValue();
            if(arg14.invoke(Integer.valueOf(v6)).booleanValue()) {
                int v8 = arg13.spanOf(v6);
                v5 = arg12;
                LazyGridMeasuredItem v12 = v5.getAndMeasure--hBUhpc(v6, 0, v8, arg13.childConstraints-JhjzzOo$foundation(0, v8));
                if(v1 == null) {
                    v1 = new ArrayList();
                }

                ((List)v1).add(v12);
            }
            else {
                v5 = arg12;
            }

            ++v3;
            arg12 = v5;
        }

        if(v1 == null) {
            return CollectionsKt.emptyList();
        }

        return ((List)v1);
    }

    private static final List calculateItemsOffsets(List arg16, List arg17, List arg18, int arg19, int arg20, int arg21, int arg22, int arg23, boolean arg24, Vertical arg25, Horizontal arg26, boolean arg27, Density arg28) {
        IntProgression v2_2;
        int v6_1;
        int[] v10;
        int v1_1;
        List v0 = arg16;
        List v1 = arg17;
        List v2 = arg18;
        int v3 = arg19;
        int v4 = arg20;
        Vertical v5 = arg25;
        boolean v6 = arg27;
        int v9 = arg24 ? v4 : v3;
        int v8 = 1;
        int v7 = arg21 < Math.min(v9, arg22) ? 1 : 0;
        if(v7 != 0) {
            int v11 = arg23 == 0 ? 1 : 0;
            if(v11 != 0) {
                goto label_28;
            }

            InlineClassHelperKt.throwIllegalStateException("non-zero firstLineScrollOffset");
        }

    label_28:
        List v11_1 = v0;
        int v12 = ((Collection)v11_1).size();
        int v13 = 0;
        int v14 = 0;
        while(v13 < v12) {
            v14 += v0.get(v13).getItems().length;
            ++v13;
        }

        ArrayList v13_1 = new ArrayList(v14);
        if(v7 != 0) {
            if(!v1.isEmpty() || !v2.isEmpty()) {
                v8 = 0;
            }
            else {
            }

            if(v8 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("no items");
            }

            v1_1 = v0.size();
            v7 = 0;
            v10 = new int[v1_1];
            goto label_54;
        }
        else {
            int v5_1 = v1.size() - 1;
            if(v5_1 >= 0) {
                v6_1 = arg23;
                while(true) {
                    v8 = v5_1 - 1;
                    Object v5_2 = v1.get(v5_1);
                    v6_1 -= ((LazyGridMeasuredItem)v5_2).getMainAxisSizeWithSpacings();
                    ((LazyGridMeasuredItem)v5_2).position(v6_1, 0, v3, v4);
                    v13_1.add(v5_2);
                    if(v8 < 0) {
                        break;
                    }

                    v5_1 = v8;
                }
            }

            v1_1 = ((Collection)v11_1).size();
            v5_1 = arg23;
            for(v6_1 = 0; v6_1 < v1_1; ++v6_1) {
                Object v8_1 = v0.get(v6_1);
                LazyGridMeasureKt.addAllFromArray(v13_1, ((LazyGridMeasuredLine)v8_1).position(v5_1, v3, v4));
                v5_1 += ((LazyGridMeasuredLine)v8_1).getMainAxisSizeWithSpacings();
            }

            int v0_1 = v2.size();
            for(v1_1 = 0; true; ++v1_1) {
                if(v1_1 >= v0_1) {
                    goto label_144;
                }

                Object v6_2 = v2.get(v1_1);
                ((LazyGridMeasuredItem)v6_2).position(v5_1, 0, v3, v4);
                v13_1.add(v6_2);
                v5_1 += ((LazyGridMeasuredItem)v6_2).getMainAxisSizeWithSpacings();
            }

        label_54:
            while(v7 < v1_1) {
                v10[v7] = v0.get(LazyGridMeasureKt.calculateItemsOffsets$reverseAware(v7, v6, v1_1)).getMainAxisSize();
                ++v7;
            }

            int[] v12_1 = new int[v1_1];
            if(!arg24) {
                Density v8_2 = arg28;
                if(arg26 != null) {
                    arg26.arrange(v8_2, v9, v10, LayoutDirection.Ltr, v12_1);
                }
                else {
                    goto label_100;
                }
            }
            else if(v5 != null) {
                v5.arrange(arg28, v9, v10, v12_1);
            }
            else {
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement");
                throw new KotlinNothingValueException();
            }

            IntRange v2_1 = ArraysKt.getIndices(v12_1);
            if(v6) {
                v2_2 = RangesKt.reversed(((IntProgression)v2_1));
            }

            v5_1 = v2_2.getFirst();
            v7 = v2_2.getLast();
            int v2_3 = v2_2.getStep();
            if(v2_3 <= 0 || v5_1 > v7) {
                if(v2_3 < 0) {
                    if(v7 > v5_1) {
                        goto label_144;
                    }

                    goto label_87;
                label_100:
                    InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalArrangement");
                    throw new KotlinNothingValueException();
                }
                else {
                    goto label_144;
                }
            }

            while(true) {
            label_87:
                v8 = v12_1[v5_1];
                Object v10_1 = v0.get(LazyGridMeasureKt.calculateItemsOffsets$reverseAware(v5_1, v6, v1_1));
                if(v6) {
                    v8 = v9 - v8 - ((LazyGridMeasuredLine)v10_1).getMainAxisSize();
                }

                LazyGridMeasureKt.addAllFromArray(v13_1, ((LazyGridMeasuredLine)v10_1).position(v8, v3, v4));
                if(v5_1 == v7) {
                    break;
                }

                v5_1 += v2_3;
            }
        }

    label_144:
        return ((List)v13_1);
    }

    private static final int calculateItemsOffsets$reverseAware(int arg0, boolean arg1, int arg2) {
        if(!arg1) {
            return arg0;
        }

        return arg2 - arg0 - 1;
    }

    private static final List linesRetainedForLookahead(int arg6, int arg7, LazyGridMeasuredLineProvider arg8, boolean arg9, List arg10, LazyGridLayoutInfo arg11) {
        Object v6;
        ArrayList v0 = null;
        if((arg9) && arg11 != null && !arg11.getVisibleItemsInfo().isEmpty()) {
            List v9 = arg11.getVisibleItemsInfo();
            int v1;
            for(v1 = v9.size() - 1; -1 < v1; --v1) {
                if(v9.get(v1).getIndex() > arg6 && (v1 == 0 || v9.get(v1 - 1).getIndex() <= arg6)) {
                    v6 = v9.get(v1);
                    goto label_24;
                }
            }

            v6 = v0;
        label_24:
            Object v9_1 = CollectionsKt.last(arg11.getVisibleItemsInfo());
            Object v10 = CollectionsKt.lastOrNull(arg10);
            int v10_1 = v10 != null ? ((LazyGridMeasuredLine)v10).getIndex() + 1 : 0;
            if(v6 == null) {
                goto label_67;
            }

            arg6 = ((LazyGridItemInfo)v6).getIndex();
            arg7 = Math.min(((LazyGridItemInfo)v9_1).getIndex(), arg7 - 1);
            if(arg6 > arg7) {
                goto label_67;
            }

            while(true) {
                if(v0 != null) {
                    int v9_2 = v0.size();
                    v1 = 0;
                    while(true) {
                        if(v1 < v9_2) {
                            LazyGridMeasuredItem[] v2 = ((List)v0).get(v1).getItems();
                            int v3 = v2.length;
                            int v4 = 0;
                            while(true) {
                                if(v4 >= v3) {
                                    break;
                                }
                                else if(v2[v4].getIndex() == arg6) {
                                }
                                else {
                                    ++v4;
                                    continue;
                                }

                                goto label_64;
                            }

                            ++v1;
                            continue;
                        }
                        else {
                            goto label_57;
                        }
                    }
                }
                else {
                label_57:
                    if(v0 == null) {
                        v0 = new ArrayList();
                    }

                    LazyGridMeasuredLine v9_3 = arg8.getAndMeasure(v10_1);
                    ++v10_1;
                    ((List)v0).add(v9_3);
                }

            label_64:
                if(arg6 == arg7) {
                    break;
                }

                ++arg6;
            }
        }

    label_67:
        if(v0 == null) {
            return CollectionsKt.emptyList();
        }

        return ((List)v0);
    }

    public static final LazyGridMeasureResult measureLazyGrid-t1x4au0(int arg56, LazyGridMeasuredLineProvider arg57, LazyGridMeasuredItemProvider arg58, int arg59, int arg60, int arg61, int arg62, int arg63, int arg64, float arg65, long arg66, boolean arg68, Vertical arg69, Horizontal arg70, boolean arg71, Density arg72, LazyLayoutItemAnimator arg73, int arg74, List arg75, boolean arg76, boolean arg77, LazyGridLayoutInfo arg78, CoroutineScope arg79, MutableState arg80, GraphicsContext arg81, Function1 arg82, Function1 arg83, StickyItemsPlacement arg84, Function3 arg85) {
        List v0_4;
        boolean v8_3;
        ArrayList v1_7;
        int v42;
        Function3 v15;
        Density v12_1;
        Horizontal v10_1;
        LazyGridMeasuredItemProvider v14_1;
        int v16;
        int v4_2;
        int v38;
        int v37;
        ArrayDeque v0_2;
        float v13_1;
        int v25;
        int v23;
        Orientation v1_1;
        int v19;
        int v18;
        int v1 = arg56;
        LazyGridMeasuredLineProvider v2 = arg57;
        int v9 = arg59;
        int v13 = arg60;
        long v14 = arg66;
        List v10 = arg75;
        Function3 v11 = arg85;
        boolean v31 = true;
        int v0 = v13 >= 0 ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("negative beforeContentPadding");
        }

        v0 = arg61 >= 0 ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("negative afterContentPadding");
        }

        long v32 = 0xFFFFFFFFL;
        int v34 = 0x20;
        if(v1 <= 0) {
            v18 = Constraints.getMinWidth-impl(v14);
            v19 = Constraints.getMinHeight-impl(v14);
            arg73.onMeasured(0, v18, v19, new ArrayList(), arg58.getKeyIndexMap(), arg58, arg68, arg77, arg74, arg76, 0, 0, arg79, arg81);
            if(!arg77) {
                long v0_1 = arg73.getMinSizeToFitDisappearingItems-YbymL2g();
                if(!IntSize.equals-impl0(v0_1, IntSize.Companion.getZero-YbymL2g())) {
                    v18 = ConstraintsKt.constrainWidth-K40F9xA(v14, ((int)(v0_1 >> v34)));
                    v19 = ConstraintsKt.constrainHeight-K40F9xA(v14, ((int)(v0_1 & v32)));
                }
            }

            Object v40 = v11.invoke(Integer.valueOf(v18), Integer.valueOf(v19), new LazyGridMeasureKt$$ExternalSyntheticLambda1());
            List v48 = CollectionsKt.emptyList();
            v0 = -v13;
            int v50 = v9 + arg61;
            v1_1 = arg68 ? Orientation.Vertical : Orientation.Horizontal;
            return new LazyGridMeasureResult(null, 0, false, 0f, ((MeasureResult)v40), 0f, false, arg79, arg72, arg74, arg82, arg83, v48, v0, v50, 0, arg71, v1_1, arg61, arg62);
        }

        v0 = Math.round(arg65);
        int v3 = arg64 - v0;
        if(arg63 == 0 && v3 < 0) {
            v0 += v3;
            v3 = 0;
        }

        ArrayDeque v4 = new ArrayDeque();
        int v5 = -v13;
        int v6 = arg62 < 0 ? arg62 : 0;
        v6 += v5;
        int v7 = v3 + v6;
        v3 = arg63;
        while(v7 < 0) {
            if(v3 <= 0) {
                break;
            }

            --v3;
            LazyGridMeasuredLine v8 = v2.getAndMeasure(v3);
            v4.add(0, v8);
            v7 += v8.getMainAxisSizeWithSpacings();
        }

        if(v7 < v6) {
            v0 -= v6 - v7;
            v7 = v6;
        }

        v7 -= v6;
        int v8_1 = v9 + arg61;
        arg63 = v3;
        v3 = RangesKt.coerceAtLeast(v8_1, 0);
        int v12 = -v7;
        v19 = arg63;
        int v17 = v5;
        arg64 = v7;
        v5 = 0;
        boolean v18_1 = false;
        while(v5 < v4.size()) {
            if(v12 >= v3) {
                v4.remove(v5);
                v18_1 = true;
                continue;
            }

            ++v19;
            v12 += v4.get(v5).getMainAxisSizeWithSpacings();
            Integer.valueOf(v5);
            ++v5;
        }

        v7 = arg64;
        boolean v35 = v18_1;
        v5 = v19;
        while(v5 < v1) {
            if(v12 >= v3 && v12 > 0 && !v4.isEmpty()) {
                break;
            }

            LazyGridMeasuredLine v1_2 = v2.getAndMeasure(v5);
            if(v1_2.isEmpty()) {
                break;
            }

            v12 += v1_2.getMainAxisSizeWithSpacings();
            if(v12 <= v6) {
                arg64 = v3;
                v18 = v5;
                if(ArraysKt.last(v1_2.getItems()).getIndex() != arg56 - 1) {
                    v5 = v18 + 1;
                    v7 -= v1_2.getMainAxisSizeWithSpacings();
                    v35 = true;
                }
                else {
                    goto label_173;
                }
            }
            else {
                arg64 = v3;
                v18 = v5;
            label_173:
                Boolean.valueOf(v4.add(v1_2));
                v5 = arg63;
            }

            v3 = arg64;
            arg63 = v5;
            v5 = v18 + 1;
            v1 = arg56;
        }

        if(v12 < v9) {
            v1 = v9 - v12;
            v7 -= v1;
            v12 += v1;
            v5 = arg63;
            goto label_187;
        }
        else {
            v1 = v0;
            goto label_204;
        label_187:
            while(v7 < v13) {
                if(v5 <= 0) {
                    break;
                }

                --v5;
                LazyGridMeasuredLine v3_1 = v2.getAndMeasure(v5);
                v4.add(0, v3_1);
                v7 += v3_1.getMainAxisSizeWithSpacings();
            }

            v1 += v0;
            if(v7 < 0) {
                v1 += v7;
                v5 = v12 + v7;
                v12 = 0;
                goto label_206;
            }

        label_204:
            v5 = v12;
            v12 = v7;
        }

    label_206:
        float v3_2 = MathKt.getSign(Math.round(arg65)) != MathKt.getSign(v1) || Math.abs(Math.round(arg65)) < Math.abs(v1) ? arg65 : ((float)v1);
        float v6_1 = arg65 - v3_2;
        float v7_1 = 0f;
        if((arg77) && v1 > v0 && v6_1 <= 0f) {
            v7_1 = (((float)(v1 - v0))) + v6_1;
        }

        float v36 = v7_1;
        v0 = v12 >= 0 ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("negative initial offset");
        }

        v0 = -v12;
        Object v18_2 = v4.firstOrNull();
        if(v18_2 != null) {
            LazyGridMeasuredItem[] v1_3 = ((LazyGridMeasuredLine)v18_2).getItems();
            if(v1_3 != null) {
                Object v1_4 = ArraysKt.firstOrNull(((Object[])v1_3));
                if(v1_4 != null) {
                    v1 = ((LazyGridMeasuredItem)v1_4).getIndex();
                }
                else {
                    goto label_243;
                }
            }
            else {
                goto label_243;
            }
        }
        else {
        label_243:
            v1 = 0;
        }

        Object v6_2 = v4.lastOrNull();
        if(v6_2 != null) {
            LazyGridMeasuredItem[] v6_3 = ((LazyGridMeasuredLine)v6_2).getItems();
            if(v6_3 != null) {
                v6_2 = ArraysKt.lastOrNull(((Object[])v6_3));
                if(v6_2 != null) {
                    v19 = v0;
                    v0 = ((LazyGridMeasuredItem)v6_2).getIndex();
                }
                else {
                    goto label_254;
                }
            }
            else {
                goto label_254;
            }
        }
        else {
        label_254:
            v19 = v0;
            v0 = 0;
        }

        List v20 = v10;
        v6 = ((Collection)v20).size();
        ArrayList v21 = null;
        ArrayList v22 = v21;
        v7 = 0;
        while(v7 < v6) {
            arg63 = v0;
            v0 = v10.get(v7).intValue();
            if(v0 < 0 || v0 >= v1) {
                v13_1 = v3_2;
                v0_2 = v4;
                v9 = v5;
                v23 = v6;
                v25 = v7;
                v38 = v8_1;
                v37 = v17;
            }
            else {
                v23 = v6;
                v6 = v2.spanOf(v0);
                arg64 = v0;
                v25 = v7;
                v13_1 = v3_2;
                v0_2 = v4;
                v37 = v17;
                v38 = v8_1;
                v9 = v5;
                LazyGridMeasuredItem v4_1 = arg58.getAndMeasure--hBUhpc(arg64, 0, v6, v2.childConstraints-JhjzzOo$foundation(0, v6));
                ArrayList v3_3 = v22 == null ? new ArrayList() : v22;
                ((List)v3_3).add(v4_1);
                v22 = v3_3;
            }

            v7 = v25 + 1;
            v4 = v0_2;
            v5 = v9;
            v3_2 = v13_1;
            v6 = v23;
            v17 = v37;
            v8_1 = v38;
            v0 = arg63;
        }

        arg63 = v0;
        v13_1 = v3_2;
        v0_2 = v4;
        v9 = v5;
        v38 = v8_1;
        v37 = v17;
        if(v22 == null) {
            List v22_1 = CollectionsKt.emptyList();
        }

        v4 = v0_2;
        ArrayDeque v6_4 = v0_2;
        int v39 = v1;
        List v7_2 = LazyGridMeasureKt.linesRetainedForLookahead(arg63, arg56, v2, arg77, ((List)v4), arg78);
        int v40_1 = arg63;
        v0 = arg56;
        LazyGridMeasuredLineProvider v1_5 = v2;
        ArrayDeque v8_2 = v4;
        int v2_1 = ((Collection)v20).size();
        v3 = 0;
        while(v3 < v2_1) {
            v4_2 = v10.get(v3).intValue();
            if(v40_1 + 1 > v4_2 || v4_2 >= v0) {
                v16 = v2_1;
            label_385:
                v17 = v3;
            }
            else {
                if(arg77) {
                    v5 = v7_2.size();
                    v0 = 0;
                    while(v0 < v5) {
                        int v20_1 = v0;
                        LazyGridMeasuredItem[] v0_3 = v7_2.get(v0).getItems();
                        arg63 = v2_1;
                        v2_1 = v0_3.length;
                        LazyGridMeasuredItem[] v64 = v0_3;
                        v0 = 0;
                        while(true) {
                            if(v0 < v2_1) {
                                v23 = v0;
                                if(v64[v0].getIndex() == v4_2) {
                                    v16 = arg63;
                                    goto label_385;
                                }
                                else {
                                    v0 = v23 + 1;
                                    continue;
                                }
                            }
                            else {
                                break;
                            }

                            goto label_362;
                        }

                        v0 = v20_1 + 1;
                        v2_1 = arg63;
                    }
                }

            label_362:
                v0 = v3;
                v3 = v1_5.spanOf(v4_2);
                v16 = v4_2;
                long v4_3 = v1_5.childConstraints-JhjzzOo$foundation(0, v3);
                v1 = v16;
                v16 = v2_1;
                v17 = v0;
                LazyGridMeasuredItem v1_6 = arg58.getAndMeasure--hBUhpc(v1, 0, v3, v4_3);
                if(v21 == null) {
                    v21 = new ArrayList();
                }

                v21.add(v1_6);
                v21 = v21;
            }

            v3 = v17 + 1;
            v0 = arg56;
            v1_5 = arg57;
            v2_1 = v16;
        }

        if(v21 == null) {
            List v21_1 = CollectionsKt.emptyList();
        }

        ArrayList v2_2 = v21;
        if(arg60 > 0 || arg62 < 0) {
            v0 = v6_4.size();
            v1 = 0;
            while(v1 < v0) {
                v3 = v6_4.get(v1).getMainAxisSizeWithSpacings();
                if(v12 == 0) {
                    break;
                }

                if(v3 > v12) {
                    break;
                }

                if(v1 == CollectionsKt.getLastIndex(((List)v8_2))) {
                    break;
                }

                v12 -= v3;
                ++v1;
                v18_2 = v6_4.get(v1);
            }
        }

        int v27 = v12;
        Object v41 = v18_2;
        v0 = arg68 ? Constraints.getMaxWidth-impl(v14) : ConstraintsKt.constrainWidth-K40F9xA(v14, v9);
        v18 = v0;
        v0 = arg68 ? ConstraintsKt.constrainHeight-K40F9xA(v14, v9) : Constraints.getMaxHeight-impl(v14);
        v4_2 = v0;
        if(v7_2.isEmpty()) {
            v0_2 = v8_2;
            v14_1 = arg58;
            v6 = arg59;
            v10_1 = arg70;
            v12_1 = arg72;
            v5 = v9;
            v15 = v11;
            v3 = v18;
            v7 = v19;
            v42 = 0;
            v1_7 = v22;
            v8_3 = arg68;
        }
        else {
            v0_4 = CollectionsKt.plus(v6_4, ((Iterable)v7_2));
            v14_1 = arg58;
            v6 = arg59;
            v8_3 = arg68;
            v10_1 = arg70;
            v12_1 = arg72;
            v5 = v9;
            v15 = v11;
            v3 = v18;
            v7 = v19;
            v42 = 0;
            v1_7 = v22;
        }

        v20 = LazyGridMeasureKt.calculateItemsOffsets(((List)v0_2), ((List)v1_7), ((List)v2_2), v3, v4_2, v5, v6, v7, v8_3, arg69, v10_1, arg71, v12_1);
        int v10_2 = v6;
        arg73.onMeasured(((int)v13_1), v3, v4_2, v20, v14_1.getKeyIndexMap(), v14_1, arg68, arg77, arg74, arg76, v27, v5, arg79, arg81);
        v0_4 = v20;
        boolean v11_1 = arg77;
        v12 = v5;
        if(!v11_1) {
            long v1_8 = arg73.getMinSizeToFitDisappearingItems-YbymL2g();
            if(!IntSize.equals-impl0(v1_8, IntSize.Companion.getZero-YbymL2g())) {
                v5 = arg68 ? v4_2 : v3;
                v18 = ConstraintsKt.constrainWidth-K40F9xA(arg66, Math.max(v3, ((int)(v1_8 >> v34))));
                v4_2 = ConstraintsKt.constrainHeight-K40F9xA(arg66, Math.max(v4_2, ((int)(v1_8 & v32))));
                v1 = arg68 ? v4_2 : v18;
                if(v1 != v5) {
                    v2_1 = v0_4.size();
                    for(v3 = v42; v3 < v2_1; ++v3) {
                        v0_4.get(v3).updateMainAxisLayoutSize(v1);
                    }
                }

                v7 = v18;
            }
            else {
                goto label_511;
            }
        }
        else {
        label_511:
            v7 = v3;
        }

        v8_1 = v4_2;
        List v3_4 = v0_4;
        v1 = v39;
        v2_1 = v40_1;
        v0_4 = LazyLayoutStickyItemsKt.applyStickyItems(arg84, v1, v2_1, v3_4, v14_1.getHeaderIndices(), arg60, arg61, v7, v8_1, new LazyGridMeasureKt$$ExternalSyntheticLambda2(arg57, v14_1));
        if(v2_1 == arg56 - 1) {
            if(v12 > v10_2) {
            }
            else {
                v31 = ((boolean)v42);
            }
        }

        Object v5_1 = v15.invoke(Integer.valueOf(v7), Integer.valueOf(v8_1), new LazyGridMeasureKt$$ExternalSyntheticLambda3(arg80, v3_4, v0_4, v11_1));
        v0_4 = LazyLayoutMeasuredItemKt.updatedVisibleItems(v1, v2_1, v3_4, v0_4);
        v1_1 = arg68 ? Orientation.Vertical : Orientation.Horizontal;
        return new LazyGridMeasureResult(v41, v27, v31, v13_1, ((MeasureResult)v5_1), v36, v35, arg79, arg72, arg74, arg82, arg83, v0_4, v37, v38, arg56, arg71, v1_1, arg61, arg62);
    }

    static final Unit measureLazyGrid_t1x4au0$lambda$2(PlacementScope arg0) {
        return Unit.INSTANCE;
    }

    static final LazyGridMeasuredItem measureLazyGrid_t1x4au0$lambda$7(LazyGridMeasuredLineProvider arg6, LazyGridMeasuredItemProvider arg7, int arg8) {
        int v3 = arg6.spanOf(arg8);
        return arg7.getAndMeasure--hBUhpc(arg8, 0, v3, arg6.childConstraints-JhjzzOo$foundation(0, v3));
    }

    static final Unit measureLazyGrid_t1x4au0$lambda$8(MutableState arg1, List arg2, List arg3, boolean arg4, PlacementScope arg5) {
        arg5.withMotionFrameOfReferencePlacement(new LazyGridMeasureKt$$ExternalSyntheticLambda0(arg2, arg3, arg4));
        ObservableScopeInvalidator.attachToScope-impl(arg1);
        return Unit.INSTANCE;
    }

    private static final Unit measureLazyGrid_t1x4au0$lambda$8$0(List arg4, List arg5, boolean arg6, PlacementScope arg7) {
        int v0 = arg4.size();
        int v1 = 0;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            arg4.get(v2).place(arg7, arg6);
        }

        int v4 = arg5.size();
        while(v1 < v4) {
            arg5.get(v1).place(arg7, arg6);
            ++v1;
        }

        return Unit.INSTANCE;
    }
}

