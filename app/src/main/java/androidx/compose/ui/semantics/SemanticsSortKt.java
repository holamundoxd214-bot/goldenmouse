package androidx.compose.ui.semantics;

import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u001AH\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000\u001A`\u0010\b\u001A\u00020\t*\u00020\u00022\u0016\u0010\n\u001A\u0012\u0012\u0004\u0012\u00020\u00020\u000Bj\b\u0012\u0004\u0012\u00020\u0002`\f2\u0012\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\r\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u000EH\u0002\u001AL\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00022\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\b\u0002\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0014\b\u0002\u0010\u0011\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0012H\u0000\u001AL\u0010\u0013\u001A\u00020\u00052:\u0010\u0014\u001A6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00170\u00150\u000Bj\u001A\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00170\u0015`\f2\u0006\u0010\u0018\u001A\u00020\u0002H\u0002\"&\u0010\u0019\u001A\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00020\u001Bj\b\u0012\u0004\u0012\u00020\u0002`\u001C0\u001AX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001D\" \u0010\u001E\u001A\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020 0\u001FX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2={"subtreeSortedByGeometryGrouping", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "isVisible", "Lkotlin/Function1;", "", "isFocusableContainer", "listToSort", "geometryDepthFirstSearch", "", "geometryList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "containerMapToChildren", "Landroidx/collection/MutableIntObjectMap;", "sortByGeometryGroupings", "parentListToSort", "containerChildrenMapping", "Landroidx/collection/IntObjectMap;", "placedEntryRowOverlaps", "rowGroupings", "Lkotlin/Pair;", "Landroidx/compose/ui/geometry/Rect;", "", "node", "semanticComparators", "", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "[Ljava/util/Comparator;", "UnmergedConfigComparator", "Lkotlin/Function2;", "", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SemanticsSortKt {
    private static final Function2 UnmergedConfigComparator;
    private static final Comparator[] semanticComparators;

    static {
        LtrBoundsComparator v3_1;
        int v0 = 2;
        Comparator[] v1 = new Comparator[v0];
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(v2 == 0) {
                RtlBoundsComparator v3 = RtlBoundsComparator.INSTANCE;
            }
            else {
                v3_1 = LtrBoundsComparator.INSTANCE;
            }

            v1[v2] = new SemanticsSortKt$special$$inlined$thenBy$2(new SemanticsSortKt$special$$inlined$thenBy$1(((Comparator)v3_1), LayoutNode.Companion.getZComparator$ui()));
        }

        SemanticsSortKt.semanticComparators = v1;
        SemanticsSortKt.UnmergedConfigComparator = SemanticsSortKt$UnmergedConfigComparator$1.INSTANCE;
    }

    private static final void geometryDepthFirstSearch(SemanticsNode arg3, ArrayList arg4, Function1 arg5, Function1 arg6, MutableIntObjectMap arg7) {
        boolean v0 = arg3.getUnmergedConfig$ui().getOrElse(SemanticsProperties.INSTANCE.getIsTraversalGroup(), SemanticsSortKt$geometryDepthFirstSearch$isTraversalGroup$1.INSTANCE).booleanValue();
        if(((v0) || (arg6.invoke(arg3).booleanValue())) && (arg5.invoke(arg3).booleanValue())) {
            arg4.add(arg3);
        }

        if(v0) {
            arg7.set(arg3.getId(), SemanticsSortKt.subtreeSortedByGeometryGrouping(arg3, arg5, arg6, arg3.getChildren()));
            return;
        }

        List v3 = arg3.getChildren();
        int v0_1 = v3.size();
        int v1;
        for(v1 = 0; v1 < v0_1; ++v1) {
            SemanticsSortKt.geometryDepthFirstSearch(v3.get(v1), arg4, arg5, arg6, arg7);
        }
    }

    private static final boolean placedEntryRowOverlaps(ArrayList arg10, SemanticsNode arg11) {
        float v0 = arg11.getBoundsInWindow().getTop();
        float v1 = arg11.getBoundsInWindow().getBottom();
        int v2 = Float.compare(v0, v1) >= 0 ? 1 : 0;
        int v5 = CollectionsKt.getLastIndex(arg10);
        if(v5 >= 0) {
            int v6;
            for(v6 = 0; true; ++v6) {
                Object v7 = arg10.get(v6).getFirst();
                int v8 = ((Rect)v7).getTop() >= ((Rect)v7).getBottom() ? 1 : 0;
                if(v2 == 0 && v8 == 0 && Math.max(v0, ((Rect)v7).getTop()) < Math.min(v1, ((Rect)v7).getBottom())) {
                    arg10.set(v6, new Pair(((Rect)v7).intersect(0f, v0, Infinityf, v1), arg10.get(v6).getSecond()));
                    arg10.get(v6).getSecond().add(arg11);
                    return 1;
                }

                if(v6 == v5) {
                    return 0;
                }
            }
        }

        return 0;
    }

    public static final List sortByGeometryGroupings(SemanticsNode arg9, List arg10, Function1 arg11, IntObjectMap arg12) {
        int v1 = 0;
        int v9 = arg9.getLayoutInfo().getLayoutDirection() == LayoutDirection.Rtl ? 1 : 0;
        ArrayList v0 = new ArrayList(arg10.size() / 2);
        int v3 = CollectionsKt.getLastIndex(arg10);
        if(v3 >= 0) {
            int v4;
            for(v4 = 0; true; ++v4) {
                Object v5 = arg10.get(v4);
                if(v4 == 0 || !SemanticsSortKt.placedEntryRowOverlaps(v0, ((SemanticsNode)v5))) {
                    v0.add(new Pair(((SemanticsNode)v5).getBoundsInWindow(), CollectionsKt.mutableListOf(new SemanticsNode[]{v5})));
                }

                if(v4 == v3) {
                    break;
                }
            }
        }

        CollectionsKt.sortWith(((List)v0), TopBottomBoundsComparator.INSTANCE);
        ArrayList v10 = new ArrayList();
        Comparator v9_1 = SemanticsSortKt.semanticComparators[v9 ^ 1];
        int v2 = v0.size();
        for(v3 = 0; v3 < v2; ++v3) {
            Object v4_1 = ((List)v0).get(v3);
            CollectionsKt.sortWith(((Pair)v4_1).getSecond(), v9_1);
            v10.addAll(((Pair)v4_1).getSecond());
        }

        ArrayList v9_2 = v10;
        CollectionsKt.sortWith(((List)v9_2), new SemanticsSortKt$$ExternalSyntheticLambda0(SemanticsSortKt.UnmergedConfigComparator));
        while(v1 <= CollectionsKt.getLastIndex(((List)v9_2))) {
            Object v0_1 = arg12.get(v10.get(v1).getId());
            if(v0_1 != null) {
                if(!arg11.invoke(v10.get(v1)).booleanValue()) {
                    v10.remove(v1);
                }
                else {
                    ++v1;
                    Integer.valueOf(v1);
                }

                v10.addAll(v1, v0_1);
                v1 += ((List)v0_1).size();
                continue;
            }

            ++v1;
        }

        return ((List)v9_2);
    }

    public static List sortByGeometryGroupings$default(SemanticsNode arg0, List arg1, Function1 arg2, IntObjectMap arg3, int arg4, Object arg5) {
        SemanticsSortKt$sortByGeometryGroupings$1 v2;
        if((arg4 & 2) != 0) {
            v2 = SemanticsSortKt$sortByGeometryGroupings$1.INSTANCE;
        }

        if((arg4 & 4) != 0) {
            arg3 = IntObjectMapKt.intObjectMapOf();
        }

        return SemanticsSortKt.sortByGeometryGroupings(arg0, arg1, ((Function1)v2), arg3);
    }

    static final int sortByGeometryGroupings$lambda$1(Function2 arg0, Object arg1, Object arg2) {
        return arg0.invoke(arg1, arg2).intValue();
    }

    public static final List subtreeSortedByGeometryGrouping(SemanticsNode arg5, Function1 arg6, Function1 arg7, List arg8) {
        MutableIntObjectMap v0 = IntObjectMapKt.mutableIntObjectMapOf();
        ArrayList v1 = new ArrayList();
        int v2 = arg8.size();
        int v3;
        for(v3 = 0; v3 < v2; ++v3) {
            SemanticsSortKt.geometryDepthFirstSearch(arg8.get(v3), v1, arg6, arg7, v0);
        }

        return SemanticsSortKt.sortByGeometryGroupings(arg5, ((List)v1), arg7, ((IntObjectMap)v0));
    }
}

