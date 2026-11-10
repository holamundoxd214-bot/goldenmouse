package androidx.compose.foundation.pager;

import androidx.collection.MutableIntObjectMap;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.gestures.snapping.SnapPositionKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement$Absolute;
import androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000®\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\u001A\u008A\u0002\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u00042\u0006\u0010\u001A\u001A\u00020\u00042\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00040\u001C2\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00020$2/\u0010%\u001A+\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0\'¢\u0006\u0002\b*\u0012\u0004\u0012\u00020+0&2\u0012\u0010,\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u001C0-H\u0000¢\u0006\u0004\b/\u00100\u001AH\u00101\u001A\b\u0012\u0004\u0012\u0002020\u001C2\u0006\u00103\u001A\u00020\u00042\u0006\u00104\u001A\u00020\u00042\u0006\u0010\u001A\u001A\u00020\u00042\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00040\u001C2\u0012\u00105\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002020\'H\u0002\u001A@\u00106\u001A\b\u0012\u0004\u0012\u0002020\u001C2\u0006\u00107\u001A\u00020\u00042\u0006\u0010\u001A\u001A\u00020\u00042\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00040\u001C2\u0012\u00105\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002020\'H\u0002\u001AH\u00108\u001A\u0004\u0018\u0001022\u0006\u00109\u001A\u00020\u00042\f\u0010:\u001A\b\u0012\u0004\u0012\u0002020\u001C2\u0006\u0010\b\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\u00042\u0006\u0010;\u001A\u00020\u00042\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u0003\u001A\u00020\u0004H\u0002\u001A{\u00105\u001A\u000202*\u00020\u00022\u0006\u0010<\u001A\u00020\u00042\u0006\u0010=\u001A\u00020\u000E2\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u000F\u001A\u00020\u00102\b\u0010\u0013\u001A\u0004\u0018\u00010\u00142\b\u0010\u0011\u001A\u0004\u0018\u00010\u00122\u0006\u0010>\u001A\u00020?2\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u00042\u0012\u0010,\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u001C0-H\u0002¢\u0006\u0004\b@\u0010A\u001A\u008C\u0001\u0010B\u001A\b\u0012\u0004\u0012\u0002020C*\u00020\u00022\f\u0010D\u001A\b\u0012\u0004\u0012\u0002020\u001C2\f\u0010E\u001A\b\u0012\u0004\u0012\u0002020\u001C2\f\u0010F\u001A\b\u0012\u0004\u0012\u0002020\u001C2\u0006\u0010G\u001A\u00020\u00042\u0006\u0010H\u001A\u00020\u00042\u0006\u0010I\u001A\u00020\u00042\u0006\u0010J\u001A\u00020\u00042\u0006\u0010K\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010#\u001A\u00020$2\u0006\u0010\n\u001A\u00020\u00042\u0006\u0010\u0019\u001A\u00020\u0004H\u0002\u001A\u0017\u0010O\u001A\u00020)2\f\u0010P\u001A\b\u0012\u0004\u0012\u00020R0QH\u0082\b\"\u000E\u0010L\u001A\u00020MX\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010N\u001A\u00020MX\u0080T¢\u0006\u0002\n\u0000¨\u0006S"}, d2={"measurePager", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "pageCount", "", "pagerItemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenPages", "currentPage", "currentPageOffset", "constraints", "Landroidx/compose/ui/unit/Constraints;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "reverseLayout", "", "visualPageOffset", "Landroidx/compose/ui/unit/IntOffset;", "pageAvailableSize", "beyondViewportPageCount", "pinnedPages", "", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "density", "Landroidx/compose/ui/unit/Density;", "layout", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "placeablesCache", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/ui/layout/Placeable;", "measurePager-7L1iB3k", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;ILandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;IIIIIIJLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Alignment$Horizontal;ZJIILjava/util/List;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/runtime/MutableState;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function3;Landroidx/collection/MutableIntObjectMap;)Landroidx/compose/foundation/pager/PagerMeasureResult;", "createPagesAfterList", "Landroidx/compose/foundation/pager/MeasuredPage;", "currentLastPage", "pagesCount", "getAndMeasure", "createPagesBeforeList", "currentFirstPage", "calculateNewCurrentPage", "viewportSize", "visiblePagesInfo", "itemSize", "index", "childConstraints", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getAndMeasure-G5IdpRk", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;IJLandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;JLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZILandroidx/collection/MutableIntObjectMap;)Landroidx/compose/foundation/pager/MeasuredPage;", "calculatePagesOffsets", "", "pages", "extraPagesBefore", "extraPagesAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "pagesScrollOffset", "MinPageOffset", "", "MaxPageOffset", "debugLog", "generateMsg", "Lkotlin/Function0;", "", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PagerMeasureKt {
    public static final float MaxPageOffset = 0.5f;
    public static final float MinPageOffset = -0.5f;

    public static Unit $r8$lambda$m3KsSl9MwnWbzOK9G6LUi6sW_gM(List arg0, PlacementScope arg1) {
        return PagerMeasureKt.measurePager_7L1iB3k$lambda$18$0(arg0, arg1);
    }

    private static final MeasuredPage calculateNewCurrentPage(int arg13, List arg14, int arg15, int arg16, int arg17, SnapPosition arg18, int arg19) {
        MeasuredPage v13;
        if(arg14.isEmpty()) {
            v13 = null;
        }
        else {
            Object v0 = arg14.get(0);
            float v1 = -Math.abs(SnapPositionKt.calculateDistanceToDesiredSnapPosition(arg13, arg15, arg16, arg17, v0.getOffset(), v0.getIndex(), arg18, arg19));
            int v10 = CollectionsKt.getLastIndex(arg14);
            if(1 <= v10) {
                int v11;
                for(v11 = 1; true; ++v11) {
                    Object v12 = arg14.get(v11);
                    float v2 = -Math.abs(SnapPositionKt.calculateDistanceToDesiredSnapPosition(arg13, arg15, arg16, arg17, v12.getOffset(), v12.getIndex(), arg18, arg19));
                    if(Float.compare(v1, v2) < 0) {
                        v1 = v2;
                        v0 = v12;
                    }

                    if(v11 == v10) {
                        break;
                    }
                }
            }

            Object v13_1 = v0;
        }

        return v13;
    }

    private static final List calculatePagesOffsets(LazyLayoutMeasureScope arg17, List arg18, List arg19, List arg20, int arg21, int arg22, int arg23, int arg24, int arg25, Orientation arg26, boolean arg27, Density arg28, int arg29, int arg30) {
        IntProgression v2_2;
        ArrayList v6_1;
        int v1_1;
        List v0 = arg18;
        List v1 = arg19;
        List v2 = arg20;
        int v3 = arg21;
        int v4 = arg22;
        int v5 = arg25;
        Orientation v6 = arg26;
        boolean v7 = arg27;
        int v8 = arg29;
        int v9 = arg30 + v8;
        int v12 = v6 == Orientation.Vertical ? v4 : v3;
        int v11 = 1;
        int v10 = arg23 < Math.min(v12, arg24) ? 1 : 0;
        if(v10 != 0) {
            int v14 = v5 == 0 ? 1 : 0;
            if(v14 != 0) {
                goto label_36;
            }

            InlineClassHelperKt.throwIllegalStateException("non-zero pagesScrollOffset=" + v5);
        }

    label_36:
        ArrayList v14_1 = new ArrayList(v0.size() + v1.size() + v2.size());
        if(v10 != 0) {
            if(!v1.isEmpty() || !v2.isEmpty()) {
                v11 = 0;
            }
            else {
            }

            if(v11 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("No extra pages");
            }

            v1_1 = v0.size();
            v10 = 0;
            int[] v13 = new int[v1_1];
            while(v10 < v1_1) {
                v13[v10] = arg30;
                ++v10;
            }

            int[] v15 = new int[v1_1];
            HorizontalOrVertical v10_1 = Absolute.INSTANCE.spacedBy-0680j_4(arg17.toDp-u2uoSUM(v8));
            if(v6 == Orientation.Vertical) {
                v10_1.arrange(arg28, v12, v13, v15);
                v6_1 = v14_1;
            }
            else {
                v6_1 = v14_1;
                v10_1.arrange(arg28, v12, v13, LayoutDirection.Ltr, v15);
            }

            IntRange v2_1 = ArraysKt.getIndices(v15);
            if(!v7) {
            }
            else {
                v2_2 = RangesKt.reversed(((IntProgression)v2_1));
            }

            v5 = v2_2.getFirst();
            v8 = v2_2.getLast();
            int v2_3 = v2_2.getStep();
            if(v2_3 <= 0 || v5 > v8) {
                if(v2_3 >= 0) {
                }
                else if(v8 <= v5) {
                    goto label_87;
                }

                return v6_1;
            }

            while(true) {
            label_87:
                v9 = v15[v5];
                Object v10_2 = v0.get(PagerMeasureKt.calculatePagesOffsets$reverseAware(v5, v7, v1_1));
                if(v7) {
                    v9 = v12 - v9 - ((MeasuredPage)v10_2).getSize();
                }

                ((MeasuredPage)v10_2).position(v9, v3, v4);
                v6_1.add(v10_2);
                if(v5 == v8) {
                    return v6_1;
                }

                v5 += v2_3;
            }
        }
        else {
            v6_1 = v14_1;
            int v7_1 = v1.size();
            v11 = v5;
            for(v8 = 0; v8 < v7_1; ++v8) {
                Object v12_1 = v1.get(v8);
                v11 -= v9;
                ((MeasuredPage)v12_1).position(v11, v3, v4);
                v6_1.add(v12_1);
            }

            v1_1 = v0.size();
            for(v7_1 = 0; v7_1 < v1_1; ++v7_1) {
                Object v8_1 = v0.get(v7_1);
                ((MeasuredPage)v8_1).position(v5, v3, v4);
                v6_1.add(v8_1);
                v5 += v9;
            }

            int v0_1 = v2.size();
            int v13_1;
            for(v13_1 = 0; v13_1 < v0_1; ++v13_1) {
                Object v1_2 = v2.get(v13_1);
                ((MeasuredPage)v1_2).position(v5, v3, v4);
                v6_1.add(v1_2);
                v5 += v9;
            }
        }

        return v6_1;
    }

    private static final int calculatePagesOffsets$reverseAware(int arg0, boolean arg1, int arg2) {
        if(!arg1) {
            return arg0;
        }

        return arg2 - arg0 - 1;
    }

    private static final List createPagesAfterList(int arg4, int arg5, int arg6, List arg7, Function1 arg8) {
        arg6 = Math.min(arg6, arg5 - arg4 - 1) + arg4;
        ++arg4;
        ArrayList v0 = null;
        if(arg4 <= arg6) {
            while(true) {
                if(v0 == null) {
                    v0 = new ArrayList();
                }

                ((List)v0).add(arg8.invoke(Integer.valueOf(arg4)));
                if(arg4 == arg6) {
                    break;
                }

                ++arg4;
            }
        }

        arg4 = arg7.size();
        int v1;
        for(v1 = 0; v1 < arg4; ++v1) {
            int v2 = arg7.get(v1).intValue();
            if(arg6 + 1 <= v2 && v2 < arg5) {
                if(v0 == null) {
                    v0 = new ArrayList();
                }

                ((List)v0).add(arg8.invoke(Integer.valueOf(v2)));
            }
        }

        if(v0 == null) {
            return CollectionsKt.emptyList();
        }

        return ((List)v0);
    }

    private static final List createPagesBeforeList(int arg3, int arg4, List arg5, Function1 arg6) {
        int v0 = 0;
        arg4 = Math.max(0, arg3 - arg4);
        --arg3;
        ArrayList v1 = null;
        if(arg4 <= arg3) {
            while(true) {
                if(v1 == null) {
                    v1 = new ArrayList();
                }

                ((List)v1).add(arg6.invoke(Integer.valueOf(arg3)));
                if(arg3 == arg4) {
                    break;
                }

                --arg3;
            }
        }

        arg3 = arg5.size();
        while(v0 < arg3) {
            int v2 = arg5.get(v0).intValue();
            if(v2 < arg4) {
                if(v1 == null) {
                    v1 = new ArrayList();
                }

                ((List)v1).add(arg6.invoke(Integer.valueOf(v2)));
            }

            ++v0;
        }

        if(v1 == null) {
            return CollectionsKt.emptyList();
        }

        return ((List)v1);
    }

    private static final void debugLog(Function0 arg0) {
    }

    private static final MeasuredPage getAndMeasure-G5IdpRk(LazyLayoutMeasureScope arg13, int arg14, long arg15, PagerLazyLayoutItemProvider arg17, long arg18, Orientation arg20, Horizontal arg21, Vertical arg22, LayoutDirection arg23, boolean arg24, int arg25, MutableIntObjectMap arg26) {
        MutableIntObjectMap v1 = arg26;
        Object v6 = arg17.getKey(arg14);
        Object v0 = v1.get(arg14);
        if(v0 == null) {
            List v13 = arg13.compose(arg14);
            int v0_1 = v13.size();
            ArrayList v2 = new ArrayList(v0_1);
            int v3;
            for(v3 = 0; v3 < v0_1; ++v3) {
                v2.add(v13.get(v3).measure-BRTryo0(arg15));
            }

            ArrayList v0_2 = v2;
            v1.set(arg14, v0_2);
        }

        Object v3_1 = v0;
        return new MeasuredPage(arg14, arg25, ((List)v3_1), arg18, v6, arg20, arg21, arg22, arg23, arg24, null);
    }

    public static final PagerMeasureResult measurePager-7L1iB3k(LazyLayoutMeasureScope arg33, int arg34, PagerLazyLayoutItemProvider arg35, int arg36, int arg37, int arg38, int arg39, int arg40, int arg41, long arg42, Orientation arg44, Vertical arg45, Horizontal arg46, boolean arg47, long arg48, int arg50, int arg51, List arg52, SnapPosition arg53, MutableState arg54, CoroutineScope arg55, Density arg56, Function3 arg57, MutableIntObjectMap arg58) {
        List v0_2;
        ArrayList v1_4;
        ArrayList v33;
        ArrayList v0_1;
        Object v18_1;
        int v28;
        MeasuredPage v4_1;
        int v6 = arg34;
        int v14 = arg36;
        int v2 = arg37;
        Orientation v5 = arg44;
        List v3 = arg52;
        Function3 v4 = arg57;
        int v8 = v2 >= 0 ? 1 : 0;
        if(v8 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("negative beforeContentPadding");
        }

        v8 = arg38 >= 0 ? 1 : 0;
        if(v8 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("negative afterContentPadding");
        }

        v8 = RangesKt.coerceAtLeast(arg50 + arg39, 0);
        int v9 = RangesKt.coerceAtMost(arg51, v6);
        int v16 = v5 == Orientation.Vertical ? Constraints.getMaxWidth-impl(arg42) : arg50;
        int v18 = v5 != Orientation.Vertical ? Constraints.getMaxHeight-impl(arg42) : arg50;
        long v17 = ConstraintsKt.Constraints$default(0, v16, 0, v18, 5, null);
        if(v6 <= 0) {
            return new PagerMeasureResult(CollectionsKt.emptyList(), arg50, arg39, arg38, v5, -v2, v14 + arg38, false, v9, null, null, 0f, 0, false, arg53, v4.invoke(Integer.valueOf(Constraints.getMinWidth-impl(arg42)), Integer.valueOf(Constraints.getMinHeight-impl(arg42)), new PagerMeasureKt$$ExternalSyntheticLambda0()), false, null, null, arg55, arg56, v17, 0x60000, null);
        }

        long v10 = arg42;
        int v0 = v9;
        int v1 = arg40;
        int v5_1;
        for(v5_1 = arg41; v1 > 0; v5_1 -= v8) {
            if(v5_1 <= 0) {
                break;
            }

            --v1;
        }

        v5_1 *= -1;
        if(v1 >= v6) {
            v1 = v6 - 1;
            v5_1 = 0;
        }

        ArrayDeque v9_1 = new ArrayDeque();
        int v12 = -v2;
        int v13 = arg39 < 0 ? arg39 : 0;
        v13 += v12;
        v5_1 += v13;
        int v15 = 0;
        while(v5_1 < 0) {
            if(v1 <= 0) {
                break;
            }

            v16 = v1 - 1;
            v4_1 = PagerMeasureKt.getAndMeasure-G5IdpRk(arg33, v16, v17, arg35, arg48, arg44, arg46, arg45, arg33.getLayoutDirection(), arg47, arg50, arg58);
            v9_1.add(0, v4_1);
            v15 = Math.max(v15, v4_1.getCrossAxisSize());
            v5_1 += v8;
            v1 = v16;
        }

        if(v5_1 < v13) {
            v5_1 = v13;
        }

        v5_1 -= v13;
        int v4_2 = v14 + arg38;
        arg40 = v1;
        v1 = RangesKt.coerceAtLeast(v4_2, 0);
        int v7 = -v5_1;
        v16 = arg40;
        arg41 = v4_2;
        arg51 = v5_1;
        v4_2 = 0;
        boolean v19 = false;
        while(v4_2 < v9_1.size()) {
            if(v7 >= v1) {
                v9_1.remove(v4_2);
                v19 = true;
                continue;
            }

            ++v16;
            v7 += v8;
            Integer.valueOf(v4_2);
            ++v4_2;
        }

        v5_1 = arg51;
        v4_2 = v16;
        boolean v31 = v19;
        while(v4_2 < v6) {
            if(v7 >= v1 && v7 > 0 && !v9_1.isEmpty()) {
                break;
            }

            arg51 = v1;
            v16 = v4_2;
            v4_2 = v15;
            MeasuredPage v1_1 = PagerMeasureKt.getAndMeasure-G5IdpRk(arg33, v16, v17, arg35, arg48, arg44, arg46, arg45, arg33.getLayoutDirection(), arg47, arg50, arg58);
            v15 = v16;
            v16 = v5_1;
            v5_1 = v6 - 1;
            int v19_1 = v15 == v5_1 ? arg50 : v8;
            v7 += v19_1;
            if(v7 > v13 || v15 == v5_1) {
                v4_2 = Math.max(v4_2, v1_1.getCrossAxisSize());
                Boolean.valueOf(v9_1.add(v1_1));
                v1 = arg40;
                v5_1 = v16;
            }
            else {
                v1 = v15 + 1;
                v5_1 = v16 - v8;
                v31 = true;
            }

            arg40 = v15 + 1;
            v15 = v4_2;
            v4_2 = arg40;
            arg40 = v1;
            v1 = arg51;
        }

        v16 = v15;
        v15 = v4_2;
        v4_2 = v16;
        v16 = v5_1;
        if(v7 < v14) {
            v1 = v14 - v7;
            v5_1 = v16 - v1;
            v7 += v1;
            v1 = v4_2;
            v4_2 = arg40;
            goto label_207;
        }
        else {
            v13 = v15;
            v15 = 0;
            v1 = v4_2;
            v5_1 = v16;
            v4_2 = arg40;
            goto label_241;
        label_207:
            while(v5_1 < v2) {
                if(v4_2 <= 0) {
                    break;
                }

                v16 = v4_2 - 1;
                v4_1 = PagerMeasureKt.getAndMeasure-G5IdpRk(arg33, v16, v17, arg35, arg48, arg44, arg46, arg45, arg33.getLayoutDirection(), arg47, arg50, arg58);
                v9_1.add(0, v4_1);
                v1 = Math.max(v1, v4_1.getCrossAxisSize());
                v5_1 += v8;
                v15 = v15;
                v4_2 = v16;
            }

            v13 = v15;
            v15 = 0;
            if(v5_1 >= 0) {
                goto label_241;
            }

            v7 += v5_1;
            v5_1 = 0;
        }

    label_241:
        v16 = v5_1 >= 0 ? 1 : v15;
        if(v16 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid currentFirstPageScrollOffset");
        }

        arg40 = v1;
        v1 = -v5_1;
        Object v16_1 = v9_1.first();
        if(v2 > 0 || arg39 < 0) {
            v15 = v9_1.size();
            v28 = v1;
            v1 = 0;
            while(v1 < v15) {
                if(v5_1 == 0) {
                    break;
                }

                if(v8 > v5_1) {
                    break;
                }

                if(v1 == CollectionsKt.getLastIndex(v9_1)) {
                    break;
                }

                v5_1 -= v8;
                ++v1;
                v16_1 = v9_1.get(v1);
            }
        }
        else {
            v28 = v1;
        }

        int v32 = v5_1;
        Object v1_2 = v16_1;
        List v2_1 = PagerMeasureKt.createPagesBeforeList(v4_2, v0, v3, new PagerMeasureKt$$ExternalSyntheticLambda1(arg33, v17, arg35, arg48, arg44, arg46, arg45, arg47, arg50, arg58));
        v4_2 = v2_1.size();
        v5_1 = arg40;
        v15 = 0;
        while(v15 < v4_2) {
            v5_1 = Math.max(v5_1, v2_1.get(v15).getCrossAxisSize());
            ++v15;
            v2_1 = v2_1;
        }

        List v40 = v2_1;
        Orientation v4_3 = arg44;
        long v22 = v17;
        v2_1 = PagerMeasureKt.createPagesAfterList(v9_1.last().getIndex(), v6, v0, v3, new PagerMeasureKt$$ExternalSyntheticLambda2(arg33, v17, arg35, arg48, arg44, arg46, arg45, arg47, arg50, arg58));
        int v3_1 = v2_1.size();
        v15 = 0;
        while(v15 < v3_1) {
            v5_1 = Math.max(v5_1, v2_1.get(v15).getCrossAxisSize());
            ++v15;
            v0 = v0;
        }

        int v21 = v0;
        v0 = !Intrinsics.areEqual(v1_2, v9_1.first()) || !v40.isEmpty() || !v2_1.isEmpty() ? 0 : 1;
        v3_1 = v4_3 == Orientation.Vertical ? v5_1 : v7;
        v3_1 = ConstraintsKt.constrainWidth-K40F9xA(v10, v3_1);
        if(v4_3 == Orientation.Vertical) {
            v5_1 = v7;
        }

        v5_1 = ConstraintsKt.constrainHeight-K40F9xA(v10, v5_1);
        int v10_1 = v8;
        ArrayDeque v8_1 = v9_1;
        int v11 = v10_1;
        List v10_2 = v2_1;
        v2 = v11;
        v11 = v3_1;
        Orientation v16_2 = v4_3;
        ArrayDeque v3_2 = v9_1;
        int v24 = v12;
        v4_2 = v13;
        List v9_2 = v40;
        v12 = v5_1;
        v13 = v7;
        List v7_1 = PagerMeasureKt.calculatePagesOffsets(arg33, ((List)v8_1), v9_2, v10_2, v11, v12, v13, v14, v28, v16_2, arg47, arg33, arg39, arg50);
        if(v0 != 0) {
            v18_1 = v1_2;
            List v1_3 = v7_1;
        }
        else {
            v0_1 = new ArrayList(v7_1.size());
            v5_1 = v7_1.size();
            v8 = 0;
            while(v8 < v5_1) {
                Object v15_1 = v7_1.get(v8);
                v16_1 = v15_1;
                v33 = v0_1;
                v18_1 = v1_2;
                if(((MeasuredPage)v16_1).getIndex() >= v3_2.first().getIndex() && ((MeasuredPage)v16_1).getIndex() <= v3_2.last().getIndex()) {
                    v33.add(v15_1);
                }

                ++v8;
                v0_1 = v33;
                v1_2 = v18_1;
            }

            v18_1 = v1_2;
            v1_4 = v0_1;
        }

        if(v9_2.isEmpty()) {
            v0_2 = CollectionsKt.emptyList();
        }
        else {
            v0_1 = new ArrayList(v7_1.size());
            v5_1 = v7_1.size();
            v8 = 0;
            while(v8 < v5_1) {
                Object v9_3 = v7_1.get(v8);
                v33 = v0_1;
                if(v9_3.getIndex() < v3_2.first().getIndex()) {
                    v33.add(v9_3);
                }

                ++v8;
                v0_1 = v33;
            }

            v0_1 = v0_1;
        }

        List v8_2 = ((List)v0_1);
        if(v10_2.isEmpty()) {
            v0_2 = CollectionsKt.emptyList();
        }
        else {
            v0_1 = new ArrayList(v7_1.size());
            v5_1 = v7_1.size();
            v9 = 0;
            while(v9 < v5_1) {
                Object v10_3 = v7_1.get(v9);
                v33 = v0_1;
                if(v10_3.getIndex() > v3_2.last().getIndex()) {
                    v33.add(v10_3);
                }

                ++v9;
                v0_1 = v33;
            }

            v0_1 = v0_1;
        }

        List v19_2 = v0_2;
        v0 = v14 + arg37 + arg38;
        v15 = arg41;
        Function3 v9_4 = arg57;
        v10_1 = v2;
        int v17_1 = v11;
        v16_1 = v18_1;
        List v18_2 = v8_2;
        v8 = v4_2;
        MeasuredPage v11_1 = PagerMeasureKt.calculateNewCurrentPage(v0, ((List)v1_4), arg37, arg38, arg50, arg53, v6);
        List v20 = ((List)v1_4);
        v5_1 = v11_1 != null ? v11_1.getIndex() : 0;
        v6 = arg34;
        v1 = arg53.position(v0, arg50, arg37, arg38, v5_1, v6);
        v0 = v11_1 != null ? v11_1.getOffset() : 0;
        float v0_3 = v10_1 == 0 ? 0f : RangesKt.coerceIn((((float)(v1 - v0))) / (((float)v10_1)), -0.5f, 0.5f);
        v1_2 = v9_4.invoke(Integer.valueOf(v17_1), Integer.valueOf(v12), new PagerMeasureKt$$ExternalSyntheticLambda3(arg54, v7_1));
        boolean v14_1 = v8 < v6 || v13 > v14 ? true : false;
        return new PagerMeasureResult(v20, arg50, arg39, arg38, arg44, v24, v15, arg47, v21, v16_1, v11_1, v0_3, v32, v14_1, arg53, v1_2, v31, v18_2, v19_2, arg55, arg56, v22, null);
    }

    static final MeasuredPage measurePager_7L1iB3k$lambda$10(LazyLayoutMeasureScope arg14, long arg15, PagerLazyLayoutItemProvider arg17, long arg18, Orientation arg20, Horizontal arg21, Vertical arg22, boolean arg23, int arg24, MutableIntObjectMap arg25, int arg26) {
        return PagerMeasureKt.getAndMeasure-G5IdpRk(arg14, arg26, arg15, arg17, arg18, arg20, arg21, arg22, arg14.getLayoutDirection(), arg23, arg24, arg25);
    }

    static final MeasuredPage measurePager_7L1iB3k$lambda$12(LazyLayoutMeasureScope arg14, long arg15, PagerLazyLayoutItemProvider arg17, long arg18, Orientation arg20, Horizontal arg21, Vertical arg22, boolean arg23, int arg24, MutableIntObjectMap arg25, int arg26) {
        return PagerMeasureKt.getAndMeasure-G5IdpRk(arg14, arg26, arg15, arg17, arg18, arg20, arg21, arg22, arg14.getLayoutDirection(), arg23, arg24, arg25);
    }

    static final Unit measurePager_7L1iB3k$lambda$18(MutableState arg1, List arg2, PlacementScope arg3) {
        arg3.withMotionFrameOfReferencePlacement(new PagerMeasureKt$$ExternalSyntheticLambda4(arg2));
        ObservableScopeInvalidator.attachToScope-impl(arg1);
        return Unit.INSTANCE;
    }

    private static final Unit measurePager_7L1iB3k$lambda$18$0(List arg3, PlacementScope arg4) {
        int v0 = arg3.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg3.get(v1).place(arg4);
        }

        return Unit.INSTANCE;
    }

    static final Unit measurePager_7L1iB3k$lambda$3(PlacementScope arg0) {
        return Unit.INSTANCE;
    }
}

