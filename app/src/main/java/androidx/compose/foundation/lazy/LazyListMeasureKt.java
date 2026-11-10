package androidx.compose.foundation.lazy;

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
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000\u008C\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\f\u001A\u0092\u0002\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001A\u00020\u00112\u0006\u0010\u0017\u001A\u00020\u00182\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u001B0\u001A2\u0006\u0010\u001C\u001A\u00020\u00032\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u00030\u001E2\u0006\u0010\u001F\u001A\u00020\u00112\u0006\u0010 \u001A\u00020\u00112\u0006\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00020$2\u0006\u0010%\u001A\u00020&2\b\u0010\'\u001A\u0004\u0018\u00010(2/\u0010)\u001A+\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+¢\u0006\u0002\b.\u0012\u0004\u0012\u00020/0*H\u0000¢\u0006\u0004\b0\u00101\u001AB\u00102\u001A\b\u0012\u0004\u0012\u00020\u001B0\u001E2\f\u00103\u001A\b\u0012\u0004\u0012\u00020\u001B042\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u001C\u001A\u00020\u00032\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u00030\u001EH\u0002\u001A4\u00105\u001A\b\u0012\u0004\u0012\u00020\u001B0\u001E2\u0006\u00106\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u001C\u001A\u00020\u00032\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u00030\u001EH\u0002\u001A\u008C\u0001\u00107\u001A\b\u0012\u0004\u0012\u00020\u001B042\f\u00108\u001A\b\u0012\u0004\u0012\u00020\u001B0\u001E2\f\u00109\u001A\b\u0012\u0004\u0012\u00020\u001B0\u001E2\f\u0010:\u001A\b\u0012\u0004\u0012\u00020\u001B0\u001E2\u0006\u0010;\u001A\u00020\u00032\u0006\u0010<\u001A\u00020\u00032\u0006\u0010=\u001A\u00020\u00032\u0006\u0010>\u001A\u00020\u00032\u0006\u0010?\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001A\u00020\u00112\u0006\u0010\u0017\u001A\u00020\u0018H\u0002¨\u0006@"}, d2={"measureLazyList", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "itemsCount", "", "measuredItemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenItems", "firstVisibleItemIndex", "firstVisibleItemScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "beyondBoundsItemCount", "pinnedItems", "", "hasLookaheadOccurred", "isLookingAhead", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "stickyItemsPlacement", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "layout", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyList-_s_dbAc", "(ILandroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;ILjava/util/List;ZZLkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "createItemsAfterList", "visibleItems", "", "createItemsBeforeList", "currentFirstItemIndex", "calculateItemsOffsets", "items", "extraItemsBefore", "extraItemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "itemsScrollOffset", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyListMeasureKt {
    public static Unit $r8$lambda$dLkBv7cEgU65-uGpB68MEAxzMfs(List arg0, List arg1, boolean arg2, PlacementScope arg3) {
        return LazyListMeasureKt.measureLazyList__s_dbAc$lambda$8$0(arg0, arg1, arg2, arg3);
    }

    private static final List calculateItemsOffsets(List arg11, List arg12, List arg13, int arg14, int arg15, int arg16, int arg17, int arg18, boolean arg19, Vertical arg20, Horizontal arg21, boolean arg22, Density arg23) {
        int v2_1;
        int v12;
        int v1 = arg15;
        Vertical v2 = arg20;
        boolean v3 = arg22;
        int v6 = arg19 ? v1 : arg14;
        int v5 = 1;
        int v4 = arg16 < Math.min(v6, arg17) ? 1 : 0;
        if(v4 != 0) {
            int v8 = arg18 == 0 ? 1 : 0;
            if(v8 != 0) {
                goto label_24;
            }

            InlineClassHelperKt.throwIllegalStateException("non-zero itemsScrollOffset");
        }

    label_24:
        ArrayList v10 = new ArrayList(arg11.size() + arg12.size() + arg13.size());
        if(v4 != 0) {
            if(!arg12.isEmpty() || !arg13.isEmpty()) {
                v5 = 0;
            }
            else {
            }

            if(v5 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("no extra items");
            }

            v12 = arg11.size();
            v4 = 0;
            int[] v7 = new int[v12];
            while(v4 < v12) {
                v7[v4] = arg11.get(LazyListMeasureKt.calculateItemsOffsets$reverseAware(v4, v3, v12)).getSize();
                ++v4;
            }

            int[] v9 = new int[v12];
            if(!arg19) {
                Density v5_1 = arg23;
                if(arg21 != null) {
                    arg21.arrange(v5_1, v6, v7, LayoutDirection.Ltr, v9);
                }
                else {
                    goto label_90;
                }
            }
            else if(v2 != null) {
                v2.arrange(arg23, v6, v7, v9);
            }
            else {
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement when isVertical == true");
                throw new KotlinNothingValueException();
            }

            IntRange v0 = ArraysKt.getIndices(v9);
            if(!v3) {
            }
            else {
                IntProgression v0_1 = RangesKt.reversed(((IntProgression)v0));
            }

            v2_1 = ((IntProgression)v0).getFirst();
            v4 = ((IntProgression)v0).getLast();
            int v0_2 = ((IntProgression)v0).getStep();
            if(v0_2 <= 0 || v2_1 > v4) {
                if(v0_2 < 0) {
                    if(v4 > v2_1) {
                        goto label_131;
                    }

                    goto label_78;
                label_90:
                    InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalArrangement when isVertical == false");
                    throw new KotlinNothingValueException();
                }
                else {
                    goto label_131;
                }
            }

            while(true) {
            label_78:
                v5 = v9[v2_1];
                Object v7_1 = arg11.get(LazyListMeasureKt.calculateItemsOffsets$reverseAware(v2_1, v3, v12));
                if(v3) {
                    v5 = v6 - v5 - ((LazyListMeasuredItem)v7_1).getSize();
                }

                ((LazyListMeasuredItem)v7_1).position(v5, arg14, arg15);
                v10.add(v7_1);
                if(v2_1 == v4) {
                    break;
                }

                v2_1 += v0_2;
            }
        }
        else {
            v2_1 = arg12.size();
            v5 = arg18;
            int v3_1;
            for(v3_1 = 0; v3_1 < v2_1; ++v3_1) {
                Object v6_1 = arg12.get(v3_1);
                v5 -= ((LazyListMeasuredItem)v6_1).getMainAxisSizeWithSpacings();
                ((LazyListMeasuredItem)v6_1).position(v5, arg14, arg15);
                v10.add(v6_1);
            }

            v12 = arg11.size();
            v2_1 = arg18;
            for(v3_1 = 0; v3_1 < v12; ++v3_1) {
                Object v5_2 = arg11.get(v3_1);
                ((LazyListMeasuredItem)v5_2).position(v2_1, arg14, arg15);
                v10.add(v5_2);
                v2_1 += ((LazyListMeasuredItem)v5_2).getMainAxisSizeWithSpacings();
            }

            int v11 = arg13.size();
            int v7_2;
            for(v7_2 = 0; v7_2 < v11; ++v7_2) {
                Object v12_1 = arg13.get(v7_2);
                ((LazyListMeasuredItem)v12_1).position(v2_1, arg14, arg15);
                v10.add(v12_1);
                v2_1 += ((LazyListMeasuredItem)v12_1).getMainAxisSizeWithSpacings();
            }
        }

    label_131:
        return ((List)v10);
    }

    private static final int calculateItemsOffsets$reverseAware(int arg0, boolean arg1, int arg2) {
        if(!arg1) {
            return arg0;
        }

        return arg2 - arg0 - 1;
    }

    private static final List createItemsAfterList(List arg8, LazyListMeasuredItemProvider arg9, int arg10, int arg11, List arg12) {
        LazyListMeasuredItemProvider v2;
        LazyListMeasuredItemProvider v0;
        arg10 = Math.min(CollectionsKt.last(arg8).getIndex() + arg11, arg10 - 1);
        int v8 = CollectionsKt.last(arg8).getIndex() + 1;
        ArrayList v11 = null;
        if(v8 <= arg10) {
            int v1 = v8;
            while(true) {
                if(v11 == null) {
                    v11 = new ArrayList();
                }

                v0 = arg9;
                ((List)v11).add(LazyListMeasuredItemProvider.getAndMeasure-0kLqBqw$default(v0, v1, 0, 2, null));
                if(v1 == arg10) {
                    break;
                }

                ++v1;
                arg9 = v0;
            }
        }
        else {
            v0 = arg9;
        }

        if(v11 != null && CollectionsKt.last(((List)v11)).getIndex() > arg10) {
            arg10 = CollectionsKt.last(((List)v11)).getIndex();
        }

        v8 = arg12.size();
        int v9 = 0;
        while(v9 < v8) {
            int v3 = arg12.get(v9).intValue();
            if(v3 > arg10) {
                if(v11 == null) {
                    v11 = new ArrayList();
                }

                v2 = v0;
                ((List)v11).add(LazyListMeasuredItemProvider.getAndMeasure-0kLqBqw$default(v2, v3, 0, 2, null));
            }
            else {
                v2 = v0;
            }

            ++v9;
            v0 = v2;
        }

        if(v11 == null) {
            return CollectionsKt.emptyList();
        }

        return ((List)v11);
    }

    private static final List createItemsBeforeList(int arg9, LazyListMeasuredItemProvider arg10, int arg11, List arg12) {
        LazyListMeasuredItemProvider v1;
        arg11 = Math.max(0, arg9 - arg11);
        --arg9;
        ArrayList v0 = null;
        if(arg11 <= arg9) {
            int v2 = arg9;
            while(true) {
                if(v0 == null) {
                    v0 = new ArrayList();
                }

                v1 = arg10;
                ((List)v0).add(LazyListMeasuredItemProvider.getAndMeasure-0kLqBqw$default(v1, v2, 0, 2, null));
                if(v2 == arg11) {
                    break;
                }

                --v2;
                arg10 = v1;
            }
        }
        else {
            v1 = arg10;
        }

        arg9 = arg12.size() - 1;
        if(arg9 >= 0) {
            while(true) {
                int v10 = arg9 - 1;
                int v4 = arg12.get(arg9).intValue();
                if(v4 < arg11) {
                    if(v0 == null) {
                        v0 = new ArrayList();
                    }

                    ((List)v0).add(LazyListMeasuredItemProvider.getAndMeasure-0kLqBqw$default(v1, v4, 0, 2, null));
                }

                if(v10 < 0) {
                    break;
                }

                arg9 = v10;
            }
        }

        if(v0 == null) {
            return CollectionsKt.emptyList();
        }

        return ((List)v0);
    }

    public static final LazyListMeasureResult measureLazyList-_s_dbAc(int arg55, LazyListMeasuredItemProvider arg56, int arg57, int arg58, int arg59, int arg60, int arg61, int arg62, float arg63, long arg64, boolean arg66, Vertical arg67, Horizontal arg68, boolean arg69, Density arg70, LazyLayoutItemAnimator arg71, int arg72, List arg73, boolean arg74, boolean arg75, CoroutineScope arg76, MutableState arg77, GraphicsContext arg78, StickyItemsPlacement arg79, Function3 arg80) {
        Object v4_2;
        Integer v2_6;
        int v27;
        int v28;
        LazyListMeasuredItemProvider v0_2;
        int v37;
        LazyListMeasuredItem v2_2;
        int v8;
        int v1_1;
        int v17;
        int v16;
        int v15 = arg55;
        int v6 = arg57;
        int v13 = arg58;
        long v7 = arg64;
        int v9 = arg72;
        List v10 = arg73;
        Function3 v11 = arg80;
        int v0 = v13 >= 0 ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid beforeContentPadding");
        }

        v0 = arg59 >= 0 ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid afterContentPadding");
        }

        long v31 = 0xFFFFFFFFL;
        int v33 = 0x20;
        if(v15 <= 0) {
            v16 = Constraints.getMinWidth-impl(v7);
            v17 = Constraints.getMinHeight-impl(v7);
            arg71.onMeasured(0, v16, v17, new ArrayList(), arg56.getKeyIndexMap(), arg56, arg66, arg75, 1, arg74, 0, 0, arg76, arg78);
            if(!arg75) {
                long v0_1 = arg71.getMinSizeToFitDisappearingItems-YbymL2g();
                if(!IntSize.equals-impl0(v0_1, IntSize.Companion.getZero-YbymL2g())) {
                    v16 = ConstraintsKt.constrainWidth-K40F9xA(v7, ((int)(v0_1 >> v33)));
                    v17 = ConstraintsKt.constrainHeight-K40F9xA(v7, ((int)(v0_1 & v31)));
                }
            }

            Object v39 = v11.invoke(Integer.valueOf(v16), Integer.valueOf(v17), new LazyListMeasureKt$$ExternalSyntheticLambda1());
            List v46 = CollectionsKt.emptyList();
            v0 = -v13;
            int v48 = v6 + arg59;
            Orientation v1 = arg66 ? Orientation.Vertical : Orientation.Horizontal;
            return new LazyListMeasureResult(null, 0, false, 0f, ((MeasureResult)v39), 0f, false, arg76, arg70, arg56.getChildConstraints-msEJaDk(), v46, v0, v48, 0, arg69, v1, arg59, arg60, null);
        }

        v0 = arg61;
        if(v0 >= v15) {
            v0 = v15 - 1;
            v1_1 = 0;
        }
        else {
            v1_1 = arg62;
        }

        int v2 = Math.round(arg63);
        v1_1 -= v2;
        if(v0 == 0 && v1_1 < 0) {
            v2 += v1_1;
            v1_1 = 0;
        }

        v16 = v2;
        ArrayDeque v2_1 = new ArrayDeque();
        int v3 = -v13;
        int v4 = arg60 < 0 ? arg60 : 0;
        v4 += v3;
        v1_1 += v4;
        int v5 = 0;
        while(v1_1 < 0) {
            if(v0 <= 0) {
                break;
            }

            ArrayDeque v19 = v2_1;
            v8 = v1_1;
            v1_1 = v0 - 1;
            v2_2 = LazyListMeasuredItemProvider.getAndMeasure-0kLqBqw$default(arg56, v1_1, 0, 2, null);
            v19.add(0, v2_2);
            v5 = Math.max(v5, v2_2.getCrossAxisSize());
            v0 = v2_2.getMainAxisSizeWithSpacings() + v8;
            v2 = v1_1;
            v1_1 = v0;
            v0 = v2;
            v2_1 = v19;
            v4 = v4;
            v3 = v3;
        }

        v8 = v1_1;
        ArrayDeque v7_1 = v2_1;
        int v35 = v3;
        int v14 = v4;
        int v11_1 = v5;
        if(v8 < v14) {
            v16 -= v14 - v8;
            v4 = v14;
        }
        else {
            v4 = v8;
        }

        v8 = v16;
        v4 -= v14;
        v1_1 = v6 + arg59;
        v2 = RangesKt.coerceAtLeast(v1_1, 0);
        v3 = -v4;
        v16 = v0;
        v5 = 0;
        boolean v17_1 = false;
        while(v5 < v7_1.size()) {
            if(v3 >= v2) {
                v7_1.remove(v5);
                v17_1 = true;
                continue;
            }

            ++v16;
            v3 += v7_1.get(v5).getMainAxisSizeWithSpacings();
            Integer.valueOf(v5);
            ++v5;
        }

        int v12 = v3;
        v5 = v11_1;
        boolean v36 = v17_1;
        v11_1 = v0;
        v0 = v1_1;
        v1_1 = v16;
        v16 = v4;
        while(v1_1 < v15) {
            if(v12 >= v2 && v12 > 0 && !v7_1.isEmpty()) {
                break;
            }

            v17 = v2;
            v37 = v0;
            arg61 = v11_1;
            v11_1 = v5;
            v2_2 = LazyListMeasuredItemProvider.getAndMeasure-0kLqBqw$default(arg56, v1_1, 0, 2, null);
            v0 = v1_1;
            v12 += v2_2.getMainAxisSizeWithSpacings();
            if(v12 > v14 || v0 == v15 - 1) {
                v1_1 = Math.max(v11_1, v2_2.getCrossAxisSize());
                Boolean.valueOf(v7_1.add(v2_2));
                v11_1 = arg61;
                v5 = v1_1;
            }
            else {
                v16 -= v2_2.getMainAxisSizeWithSpacings();
                v5 = v11_1;
                v36 = true;
                v11_1 = v0 + 1;
            }

            v1_1 = v0 + 1;
            v2 = v17;
            v0 = v37;
        }

        v37 = v0;
        v0 = v1_1;
        arg61 = v11_1;
        v11_1 = v5;
        if(v12 < v6) {
            v14 = v6 - v12;
            v12 += v14;
            v1_1 = arg61;
            v2 = v16 - v14;
            goto label_233;
        }
        else {
            v13 = v0;
            v3 = 0;
            v0_2 = arg56;
            v14 = v8;
            v5 = v11_1;
            v28 = v12;
            v1_1 = v16;
            v11_1 = arg61;
            goto label_278;
        label_233:
            while(v2 < v13) {
                if(v1_1 <= 0) {
                    break;
                }

                --v1_1;
                v16 = v2;
                v2_2 = LazyListMeasuredItemProvider.getAndMeasure-0kLqBqw$default(arg56, v1_1, 0, 2, null);
                v7_1.add(0, v2_2);
                v11_1 = Math.max(v11_1, v2_2.getCrossAxisSize());
                v2 = v16 + v2_2.getMainAxisSizeWithSpacings();
                v0 = v0;
                v13 = arg58;
            }

            v13 = v0;
            v16 = v2;
            v3 = 0;
            v0_2 = arg56;
            v14 += v8;
            if(v16 < 0) {
                v14 += v16;
                v5 = v11_1;
                v28 = v12 + v16;
                v11_1 = v1_1;
                v1_1 = 0;
                goto label_278;
            }

            v5 = v11_1;
            v28 = v12;
            v11_1 = v1_1;
            v1_1 = v16;
        }

    label_278:
        float v4_1 = MathKt.getSign(Math.round(arg63)) != MathKt.getSign(v14) || Math.abs(Math.round(arg63)) < Math.abs(v14) ? arg63 : ((float)v14);
        float v2_3 = arg63 - v4_1;
        float v12_1 = 0f;
        if((arg75) && v14 > v8 && v2_3 <= 0f) {
            v12_1 = (((float)(v14 - v8))) + v2_3;
        }

        float v14_1 = v12_1;
        v2 = v1_1 >= 0 ? 1 : v3;
        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("negative currentFirstItemScrollOffset");
        }

        v2 = -v1_1;
        Object v8_1 = v7_1.first();
        if(arg58 > 0 || arg60 < 0) {
            v12 = v7_1.size();
            while(true) {
                if(v3 < v12) {
                    v17 = v2;
                    v2 = v7_1.get(v3).getMainAxisSizeWithSpacings();
                    if(v1_1 != 0 && v2 <= v1_1) {
                        arg61 = v1_1;
                        if(v3 != CollectionsKt.getLastIndex(v7_1)) {
                            v1_1 = arg61 - v2;
                            ++v3;
                            v8_1 = v7_1.get(v3);
                            v2 = v17;
                            continue;
                        }
                        else {
                            goto label_337;
                        }
                    }

                    break;
                }
                else {
                    goto label_335;
                }
            }

            arg61 = v1_1;
            goto label_337;
        label_335:
            arg61 = v1_1;
            v17 = v2;
        label_337:
            v27 = arg61;
        }
        else {
            v27 = v1_1;
            v17 = v2;
        }

        Object v1_2 = v8_1;
        List v2_4 = LazyListMeasureKt.createItemsBeforeList(v11_1, v0_2, v9, v10);
        v3 = v2_4.size();
        for(v8 = 0; v8 < v3; ++v8) {
            v5 = Math.max(v5, v2_4.get(v8).getCrossAxisSize());
        }

        ArrayDeque v3_1 = v7_1;
        List v8_2 = LazyListMeasureKt.createItemsAfterList(((List)v3_1), v0_2, v15, v9, v10);
        v9 = v8_2.size();
        int v10_1;
        for(v10_1 = 0; v10_1 < v9; ++v10_1) {
            v5 = Math.max(v5, v8_2.get(v10_1).getCrossAxisSize());
        }

        int v38 = !Intrinsics.areEqual(v1_2, v7_1.first()) || !v2_4.isEmpty() || !v8_2.isEmpty() ? 0 : 1;
        v11_1 = arg66 ? v5 : v28;
        long v9_1 = arg64;
        v11_1 = ConstraintsKt.constrainWidth-K40F9xA(v9_1, v11_1);
        if(arg66) {
            v5 = v28;
        }

        int v19_1 = ConstraintsKt.constrainHeight-K40F9xA(v9_1, v5);
        Object v42 = v1_2;
        ArrayDeque v0_3 = v3_1;
        float v15_1 = v4_1;
        ArrayDeque v41 = v7_1;
        v3 = v11_1;
        int v40 = v13;
        float v61 = v14_1;
        v4 = v19_1;
        long v13_1 = v9_1;
        List v20 = LazyListMeasureKt.calculateItemsOffsets(((List)v0_3), v2_4, v8_2, v3, v4, v28, v6, v17, arg66, arg67, arg68, arg69, arg70);
        v10_1 = v6;
        arg71.onMeasured(((int)v15_1), v3, v19_1, v20, arg56.getKeyIndexMap(), arg56, arg66, arg75, 1, arg74, v27, v28, arg76, arg78);
        List v0_4 = v20;
        boolean v11_2 = arg75;
        v12 = v28;
        if(!v11_2) {
            long v1_3 = arg71.getMinSizeToFitDisappearingItems-YbymL2g();
            if(!IntSize.equals-impl0(v1_3, IntSize.Companion.getZero-YbymL2g())) {
                v5 = arg66 ? v4 : v3;
                v3 = ConstraintsKt.constrainWidth-K40F9xA(v13_1, Math.max(v3, ((int)(v1_3 >> v33))));
                v19_1 = ConstraintsKt.constrainHeight-K40F9xA(v13_1, Math.max(v4, ((int)(v1_3 & v31))));
                v1_1 = arg66 ? v19_1 : v3;
                if(v1_1 != v5) {
                    v2 = v0_4.size();
                    v4 = 0;
                    goto label_442;
                }

                goto label_447;
            }
            else {
                goto label_449;
            }
        }
        else {
        label_449:
            v8 = v4;
            goto label_450;
        label_442:
            while(v4 < v2) {
                v0_4.get(v4).updateMainAxisLayoutSize(v1_1);
                ++v4;
            }

        label_447:
            v8 = v19_1;
        }

    label_450:
        int v7_2 = v3;
        v1_2 = v41.firstOrNull();
        v1_1 = v1_2 != null ? ((LazyListMeasuredItem)v1_2).getIndex() : 0;
        Object v2_5 = v41.lastOrNull();
        v2 = v2_5 != null ? ((LazyListMeasuredItem)v2_5).getIndex() : 0;
        LazyListMeasuredItemProvider v13_2 = arg56;
        List v3_2 = v0_4;
        v0_4 = LazyLayoutStickyItemsKt.applyStickyItems(arg79, v1_1, v2, v3_2, arg56.getHeaderIndexes(), arg58, arg59, v7_2, v8, new LazyListMeasureKt$$ExternalSyntheticLambda2(v13_2));
        Integer v1_4 = null;
        if(v38 != 0) {
            v2_5 = CollectionsKt.firstOrNull(v3_2);
            if(v2_5 != null) {
                v2_6 = Integer.valueOf(((LazyListMeasuredItem)v2_5).getIndex());
            }
            else {
                goto label_482;
            }
        }
        else {
            v2_5 = v41.firstOrNull();
            if(v2_5 != null) {
                v2_6 = Integer.valueOf(((LazyListMeasuredItem)v2_5).getIndex());
            }
            else {
            label_482:
                v2_6 = v1_4;
            }
        }

        if(v38 != 0) {
            v4_2 = CollectionsKt.lastOrNull(v3_2);
            if(v4_2 != null) {
                v1_4 = Integer.valueOf(((LazyListMeasuredItem)v4_2).getIndex());
            }
        }
        else {
            v4_2 = v41.lastOrNull();
            if(v4_2 != null) {
                v1_4 = Integer.valueOf(((LazyListMeasuredItem)v4_2).getIndex());
            }
        }

        float v5_1 = v15_1;
        v15 = arg55;
        boolean v14_2 = v40 < v15 || v12 > v10_1 ? true : false;
        v4_2 = arg80.invoke(Integer.valueOf(v7_2), Integer.valueOf(v8), new LazyListMeasureKt$$ExternalSyntheticLambda3(arg77, v3_2, v0_4, v11_2));
        v12 = v2_6 != null ? v2_6.intValue() : 0;
        v1_1 = v1_4 != null ? v1_4.intValue() : 0;
        List v12_2 = LazyLayoutMeasuredItemKt.updatedVisibleItems(v12, v1_1, v3_2, v0_4);
        Orientation v0_5 = arg66 ? Orientation.Vertical : Orientation.Horizontal;
        return new LazyListMeasureResult(v42, v27, v14_2, v5_1, v4_2, v61, v36, arg76, arg70, v13_2.getChildConstraints-msEJaDk(), v12_2, v35, v37, v15, arg69, v0_5, arg59, arg60, null);
    }

    static final Unit measureLazyList__s_dbAc$lambda$2(PlacementScope arg0) {
        return Unit.INSTANCE;
    }

    static final LazyListMeasuredItem measureLazyList__s_dbAc$lambda$7(LazyListMeasuredItemProvider arg6, int arg7) {
        return LazyListMeasuredItemProvider.getAndMeasure-0kLqBqw$default(arg6, arg7, 0, 2, null);
    }

    static final Unit measureLazyList__s_dbAc$lambda$8(MutableState arg1, List arg2, List arg3, boolean arg4, PlacementScope arg5) {
        arg5.withMotionFrameOfReferencePlacement(new LazyListMeasureKt$$ExternalSyntheticLambda0(arg2, arg3, arg4));
        ObservableScopeInvalidator.attachToScope-impl(arg1);
        return Unit.INSTANCE;
    }

    private static final Unit measureLazyList__s_dbAc$lambda$8$0(List arg4, List arg5, boolean arg6, PlacementScope arg7) {
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

