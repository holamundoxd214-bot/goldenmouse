package androidx.compose.material3;

import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u0004\u001A\u00020\u0005*\u00020\u00062\u0012\u0010\u0007\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\b2\u0006\u0010\n\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\f\u0010\rJ(\u0010\u000E\u001A\u00020\u000F*\u00020\u00102\u0012\u0010\u0007\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\b2\u0006\u0010\u0012\u001A\u00020\u000FH\u0016J(\u0010\u0013\u001A\u00020\u000F*\u00020\u00102\u0012\u0010\u0007\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\b2\u0006\u0010\u0014\u001A\u00020\u000FH\u0016J(\u0010\u0015\u001A\u00020\u000F*\u00020\u00102\u0012\u0010\u0007\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\b2\u0006\u0010\u0012\u001A\u00020\u000FH\u0016J(\u0010\u0016\u001A\u00020\u000F*\u00020\u00102\u0012\u0010\u0007\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\b2\u0006\u0010\u0014\u001A\u00020\u000FH\u0016JV\u0010\u0017\u001A\u00020\u000F*\u00020\u00102\u0012\u0010\u0007\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\b2\u0006\u0010\u0014\u001A\u00020\u000F2,\u0010\u0018\u001A(\u0012\u0004\u0012\u00020\u0011\u0012\u0013\u0012\u00110\u000F¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000F0\u0019¢\u0006\u0002\b\u001CH\u0002JV\u0010\u001D\u001A\u00020\u000F*\u00020\u00102\u0012\u0010\u0007\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\b2\u0006\u0010\u0012\u001A\u00020\u000F2,\u0010\u0018\u001A(\u0012\u0004\u0012\u00020\u0011\u0012\u0013\u0012\u00110\u000F¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000F0\u0019¢\u0006\u0002\b\u001CH\u0002¨\u0006\u001E"}, d2={"Landroidx/compose/material3/ListItemMeasurePolicy;", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "<init>", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "minIntrinsicHeight", "minIntrinsicWidth", "calculateIntrinsicWidth", "intrinsicMeasure", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lkotlin/ExtensionFunctionType;", "calculateIntrinsicHeight", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class ListItemMeasurePolicy implements MultiContentMeasurePolicy {
    public ListItemMeasurePolicy() {
        super();
    }

    private final int calculateIntrinsicHeight(IntrinsicMeasureScope arg19, List arg20, int arg21, Function2 arg22) {
        int v8_1;
        int v11;
        IntrinsicMeasureScope v0 = arg19;
        Function2 v2 = arg22;
        boolean v3 = false;
        Object v4 = arg20.get(0);
        Object v6 = arg20.get(1);
        Object v7 = arg20.get(2);
        Object v8 = arg20.get(3);
        Object v1 = arg20.get(4);
        int v9 = LayoutUtilKt.subtractConstraintSafely(arg21, v0.roundToPx-0680j_4(Dp.constructor-impl(ListItemKt.getListItemStartPadding() + ListItemKt.getListItemEndPadding())));
        v8 = CollectionsKt.firstOrNull(((List)v8));
        int v10 = 0x7FFFFFFF;
        if(v8 != null) {
            v11 = v2.invoke(v8, Integer.valueOf(v9)).intValue();
            v9 = LayoutUtilKt.subtractConstraintSafely(v9, ((IntrinsicMeasurable)v8).maxIntrinsicWidth(v10));
        }
        else {
            v11 = 0;
        }

        v1 = CollectionsKt.firstOrNull(((List)v1));
        if(v1 != null) {
            v8_1 = v2.invoke(v1, Integer.valueOf(v9)).intValue();
            v9 = LayoutUtilKt.subtractConstraintSafely(v9, ((IntrinsicMeasurable)v1).maxIntrinsicWidth(v10));
        }
        else {
            v8_1 = 0;
        }

        v1 = CollectionsKt.firstOrNull(((List)v6));
        int v1_1 = v1 != null ? v2.invoke(v1, Integer.valueOf(v9)).intValue() : 0;
        v4 = CollectionsKt.firstOrNull(((List)v4));
        int v4_1 = v4 != null ? v2.invoke(v4, Integer.valueOf(v9)).intValue() : 0;
        v6 = CollectionsKt.firstOrNull(((List)v7));
        int v2_1 = v6 != null ? v2.invoke(v6, Integer.valueOf(v9)).intValue() : 0;
        boolean v6_1 = ListItemKt.isSupportingMultilineHeuristic(v0, v2_1);
        Companion v7_1 = ListItemType.Companion;
        boolean v9_1 = v1_1 > 0 ? true : false;
        if(v2_1 > 0) {
            v3 = true;
        }

        int v6_2 = v7_1.invoke-Z-LSjz4$material3(v9_1, v3, v6_1);
        return ListItemKt.calculateHeight-N4Jib3Y(v0, v11, v8_1, v4_1, v1_1, v2_1, v6_2, v0.roundToPx-0680j_4(Dp.constructor-impl(ListItemKt.verticalPadding-yh95HIg(v6_2) * 2f)), ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null));
    }

    private final int calculateIntrinsicWidth(IntrinsicMeasureScope arg17, List arg18, int arg19, Function2 arg20) {
        Function2 v1 = arg20;
        int v2 = 0;
        Object v3 = arg18.get(0);
        Object v4 = arg18.get(1);
        Object v5 = arg18.get(2);
        Object v6 = arg18.get(3);
        Object v0 = arg18.get(4);
        v6 = CollectionsKt.firstOrNull(((List)v6));
        int v8 = v6 != null ? v1.invoke(v6, Integer.valueOf(arg19)).intValue() : 0;
        v0 = CollectionsKt.firstOrNull(((List)v0));
        int v9 = v0 != null ? v1.invoke(v0, Integer.valueOf(arg19)).intValue() : 0;
        v0 = CollectionsKt.firstOrNull(((List)v3));
        int v10 = v0 != null ? v1.invoke(v0, Integer.valueOf(arg19)).intValue() : 0;
        v0 = CollectionsKt.firstOrNull(((List)v4));
        int v11 = v0 != null ? v1.invoke(v0, Integer.valueOf(arg19)).intValue() : 0;
        v0 = CollectionsKt.firstOrNull(((List)v5));
        if(v0 != null) {
            v2 = v1.invoke(v0, Integer.valueOf(arg19)).intValue();
        }

        return ListItemKt.calculateWidth-yeHjK3Y(arg17, v8, v9, v10, v11, v2, arg17.roundToPx-0680j_4(Dp.constructor-impl(ListItemKt.getListItemStartPadding() + ListItemKt.getListItemEndPadding())), ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null));
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg2, List arg3, int arg4) {
        return this.calculateIntrinsicHeight(arg2, arg3, arg4, ListItemMeasurePolicy$maxIntrinsicHeight$1.INSTANCE);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope arg2, List arg3, int arg4) {
        return this.calculateIntrinsicWidth(arg2, arg3, arg4, ListItemMeasurePolicy$maxIntrinsicWidth$1.INSTANCE);
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg24, List arg25, long arg26) {
        Placeable v7_1;
        float v25;
        Placeable v3_1;
        long v4;
        Object v18;
        Placeable v1_1;
        long v15_1;
        MeasureScope v0 = arg24;
        boolean v2 = false;
        Object v3 = arg25.get(0);
        Object v5 = arg25.get(1);
        Object v6 = arg25.get(2);
        Object v7 = arg25.get(3);
        Object v1 = arg25.get(4);
        long v10 = Constraints.copy-Zbe2FdA$default(arg26, 0, 0, 0, 0, 10, null);
        float v8 = ListItemKt.getListItemStartPadding();
        float v9 = ListItemKt.getListItemEndPadding();
        int v12 = v0.roundToPx-0680j_4(Dp.constructor-impl(v8 + v9));
        Object v13 = CollectionsKt.firstOrNull(((List)v7));
        int v13_1 = v13 != null ? ((Measurable)v13).minIntrinsicWidth(Constraints.getMaxHeight-impl(arg26)) : 0;
        Object v14 = CollectionsKt.firstOrNull(((List)v1));
        int v14_1 = v14 != null ? ((Measurable)v14).minIntrinsicWidth(Constraints.getMaxHeight-impl(arg26)) : 0;
        v13_1 = LayoutUtilKt.subtractConstraintSafely(Constraints.getMaxWidth-impl(v10), v13_1 + v14_1 + v12);
        v14 = CollectionsKt.firstOrNull(((List)v6));
        v13_1 = v14 != null ? ((Measurable)v14).minIntrinsicHeight(v13_1) : 0;
        boolean v13_2 = ListItemKt.isSupportingMultilineHeuristic(v0, v13_1);
        Companion v14_2 = ListItemType.Companion;
        boolean v15 = CollectionsKt.firstOrNull(((List)v5)) != null ? true : false;
        if(CollectionsKt.firstOrNull(((List)v6)) != null) {
            v2 = true;
        }

        float v2_1 = ListItemKt.verticalPadding-yh95HIg(v14_2.invoke-Z-LSjz4$material3(v15, v2, v13_2));
        float v13_3 = 2f;
        v10 = ConstraintsKt.offset-NN6Ew-U(v10, -v12, -v0.roundToPx-0680j_4(Dp.constructor-impl(v2_1 * v13_3)));
        Object v2_2 = CollectionsKt.firstOrNull(((List)v7));
        Placeable v2_3 = v2_2 != null ? ((Measurable)v2_2).measure-BRTryo0(v10) : null;
        v14_1 = LayoutUtilKt.getWidthOrZero(v2_3);
        v1 = CollectionsKt.firstOrNull(((List)v1));
        if(v1 != null) {
            v15_1 = v10;
            v1_1 = ((Measurable)v1).measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(v15_1, -v14_1, 0, 2, null));
        }
        else {
            v15_1 = v10;
            v1_1 = null;
        }

        v14_1 += LayoutUtilKt.getWidthOrZero(v1_1);
        v3 = CollectionsKt.firstOrNull(((List)v3));
        if(v3 != null) {
            v18 = v5;
            v4 = v15_1;
            v3_1 = ((Measurable)v3).measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(v15_1, -v14_1, 0, 2, null));
        }
        else {
            v18 = v5;
            v4 = v15_1;
            v3_1 = null;
        }

        int v10_1 = LayoutUtilKt.getHeightOrZero(v3_1);
        v6 = CollectionsKt.firstOrNull(((List)v6));
        if(v6 != null) {
            v25 = v8;
            v7_1 = ((Measurable)v6).measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(v4, -v14_1, -v10_1));
        }
        else {
            v25 = v8;
            v7_1 = null;
        }

        v10_1 += LayoutUtilKt.getHeightOrZero(v7_1);
        boolean v6_1 = v7_1 == null || v7_1.get(AlignmentLineKt.getFirstBaseline()) == v7_1.get(AlignmentLineKt.getLastBaseline()) ? false : true;
        Object v8_1 = CollectionsKt.firstOrNull(((List)v18));
        Placeable v4_1 = v8_1 != null ? ((Measurable)v8_1).measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(v4, -v14_1, -v10_1)) : null;
        Companion v5_1 = ListItemType.Companion;
        boolean v8_2 = v4_1 != null ? true : false;
        boolean v10_2 = v7_1 != null ? true : false;
        int v5_2 = v5_1.invoke-Z-LSjz4$material3(v8_2, v10_2, v6_1);
        float v6_2 = ListItemKt.verticalPadding-yh95HIg(v5_2);
        return ListItemKt.place(v0, ListItemKt.calculateWidth-yeHjK3Y(v0, LayoutUtilKt.getWidthOrZero(v2_3), LayoutUtilKt.getWidthOrZero(v1_1), LayoutUtilKt.getWidthOrZero(v3_1), LayoutUtilKt.getWidthOrZero(v4_1), LayoutUtilKt.getWidthOrZero(v7_1), v12, arg26), ListItemKt.calculateHeight-N4Jib3Y(v0, LayoutUtilKt.getHeightOrZero(v2_3), LayoutUtilKt.getHeightOrZero(v1_1), LayoutUtilKt.getHeightOrZero(v3_1), LayoutUtilKt.getHeightOrZero(v4_1), LayoutUtilKt.getHeightOrZero(v7_1), v5_2, v0.roundToPx-0680j_4(Dp.constructor-impl(v13_3 * v6_2)), arg26), v2_3, v1_1, v3_1, v4_1, v7_1, ListItemType.equals-impl0(v5_2, ListItemType.Companion.getThreeLine-AlXitO8()), v0.roundToPx-0680j_4(v25), v0.roundToPx-0680j_4(v9), v0.roundToPx-0680j_4(v6_2));
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope arg2, List arg3, int arg4) {
        return this.calculateIntrinsicHeight(arg2, arg3, arg4, ListItemMeasurePolicy$minIntrinsicHeight$1.INSTANCE);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope arg2, List arg3, int arg4) {
        return this.calculateIntrinsicWidth(arg2, arg3, arg4, ListItemMeasurePolicy$minIntrinsicWidth$1.INSTANCE);
    }
}

