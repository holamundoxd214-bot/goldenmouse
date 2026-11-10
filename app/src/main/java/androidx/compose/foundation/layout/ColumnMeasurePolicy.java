package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u008E\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\f\u0010\t\u001A\u00020\n*\u00020\u000BH\u0016J\f\u0010\f\u001A\u00020\n*\u00020\u000BH\u0016J(\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\n2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u0014H\u0016Jg\u0010\u0015\u001A\u00020\u00162\u000E\u0010\u0017\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\u00182\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0019\u001A\u00020\n2\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u000F\u001A\u00020\n2\u0006\u0010\u001A\u001A\u00020\n2\b\u0010\u001B\u001A\u0004\u0018\u00010\u00112\u0006\u0010\u001C\u001A\u00020\n2\u0006\u0010\u001D\u001A\u00020\n2\u0006\u0010\u001E\u001A\u00020\nH\u0016¢\u0006\u0002\u0010\u001FJ2\u0010 \u001A\u00020\n2\u0006\u0010!\u001A\u00020\u000B2\b\u0010\"\u001A\u0004\u0018\u00010#2\u0006\u0010\u001A\u001A\u00020\n2\u0006\u0010\u0019\u001A\u00020\n2\u0006\u0010$\u001A\u00020%H\u0002J7\u0010&\u001A\u00020\'2\u0006\u0010(\u001A\u00020\n2\u0006\u0010)\u001A\u00020\n2\u0006\u0010*\u001A\u00020\n2\u0006\u0010+\u001A\u00020\n2\u0006\u0010,\u001A\u00020-H\u0016¢\u0006\u0004\b.\u0010/J)\u00100\u001A\u00020\u0016*\u00020\u00142\f\u00101\u001A\b\u0012\u0004\u0012\u000203022\u0006\u00104\u001A\u00020\'H\u0016¢\u0006\u0004\b5\u00106J\"\u00107\u001A\u00020\n*\u0002082\f\u00101\u001A\b\u0012\u0004\u0012\u000209022\u0006\u0010:\u001A\u00020\nH\u0016J\"\u0010;\u001A\u00020\n*\u0002082\f\u00101\u001A\b\u0012\u0004\u0012\u000209022\u0006\u0010<\u001A\u00020\nH\u0016J\"\u0010=\u001A\u00020\n*\u0002082\f\u00101\u001A\b\u0012\u0004\u0012\u000209022\u0006\u0010:\u001A\u00020\nH\u0016J\"\u0010>\u001A\u00020\n*\u0002082\f\u00101\u001A\b\u0012\u0004\u0012\u000209022\u0006\u0010<\u001A\u00020\nH\u0016J\t\u0010?\u001A\u00020\u0004HÂ\u0003J\t\u0010@\u001A\u00020\u0006HÂ\u0003J\u001D\u0010A\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001J\u0013\u0010B\u001A\u00020-2\b\u0010C\u001A\u0004\u0018\u00010DHÖ\u0003J\t\u0010E\u001A\u00020\nHÖ\u0001J\t\u0010F\u001A\u00020GHÖ\u0001R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2={"Landroidx/compose/foundation/layout/ColumnMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "<init>", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;)V", "mainAxisSize", "", "Landroidx/compose/ui/layout/Placeable;", "crossAxisSize", "populateMainAxisPositions", "", "mainAxisLayoutSize", "childrenMainAxisSize", "", "mainAxisPositions", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "placeHelper", "Landroidx/compose/ui/layout/MeasureResult;", "placeables", "", "beforeCrossAxisAlignmentLine", "crossAxisLayoutSize", "crossAxisOffset", "currentLineIndex", "startIndex", "endIndex", "([Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/MeasureScope;I[III[IIII)Landroidx/compose/ui/layout/MeasureResult;", "getCrossAxisPosition", "placeable", "parentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "createConstraints", "Landroidx/compose/ui/unit/Constraints;", "mainAxisMin", "crossAxisMin", "mainAxisMax", "crossAxisMax", "isPrioritizing", "", "createConstraints-xF2OJ5Q", "(IIIIZ)J", "measure", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ColumnMeasurePolicy implements RowColumnMeasurePolicy, MeasurePolicy {
    public static final int $stable;
    private final Horizontal horizontalAlignment;
    private final Vertical verticalArrangement;

    public static Unit $r8$lambda$8BmlrFZP1tURuruJV2jL4tfrBpY(Placeable[] arg0, ColumnMeasurePolicy arg1, int arg2, int arg3, MeasureScope arg4, int[] arg5, PlacementScope arg6) {
        return ColumnMeasurePolicy.placeHelper$lambda$0$0(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    static {
    }

    public ColumnMeasurePolicy(Vertical arg1, Horizontal arg2) {
        super();
        this.verticalArrangement = arg1;
        this.horizontalAlignment = arg2;
    }

    private final Vertical component1() {
        return this.verticalArrangement;
    }

    private final Horizontal component2() {
        return this.horizontalAlignment;
    }

    public final ColumnMeasurePolicy copy(Vertical arg1, Horizontal arg2) {
        return new ColumnMeasurePolicy(arg1, arg2);
    }

    public static ColumnMeasurePolicy copy$default(ColumnMeasurePolicy arg0, Vertical arg1, Horizontal arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.verticalArrangement;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.horizontalAlignment;
        }

        return arg0.copy(arg1, arg2);
    }

    public long createConstraints-xF2OJ5Q(int arg1, int arg2, int arg3, int arg4, boolean arg5) {
        return ColumnKt.createColumnConstraints(arg5, arg1, arg2, arg3, arg4);
    }

    public int crossAxisSize(Placeable arg1) {
        return arg1.getWidth();
    }

    public boolean equals(Object arg5) {
        if(this == (((ColumnMeasurePolicy)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ColumnMeasurePolicy)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.verticalArrangement, ((ColumnMeasurePolicy)arg5).verticalArrangement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.horizontalAlignment, ((ColumnMeasurePolicy)arg5).horizontalAlignment)) {
            return 0;
        }

        return 1;
    }

    private final int getCrossAxisPosition(Placeable arg7, RowColumnParentData arg8, int arg9, int arg10, LayoutDirection arg11) {
        CrossAxisAlignment v8 = arg8 != null ? arg8.getCrossAxisAlignment() : null;
        CrossAxisAlignment v0 = v8;
        if(v0 != null) {
            return v0.align$foundation_layout(arg9, this.crossAxisSize(arg7), arg11, arg7, arg10);
        }

        return this.horizontalAlignment.align(this.crossAxisSize(arg7), arg9, arg11);
    }

    public int hashCode() {
        return this.verticalArrangement.hashCode() * 0x1F + this.horizontalAlignment.hashCode();
    }

    public int mainAxisSize(Placeable arg1) {
        return arg1.getHeight();
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg2, List arg3, int arg4) {
        return IntrinsicMeasureBlocks.INSTANCE.VerticalMaxHeight(arg3, arg4, arg2.roundToPx-0680j_4(this.verticalArrangement.getSpacing-D9Ej5fM()));
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope arg2, List arg3, int arg4) {
        return IntrinsicMeasureBlocks.INSTANCE.VerticalMaxWidth(arg3, arg4, arg2.roundToPx-0680j_4(this.verticalArrangement.getSpacing-D9Ej5fM()));
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg16, List arg17, long arg18) {
        return RowColumnMeasurePolicyKt.measure$default(this, Constraints.getMinHeight-impl(arg18), Constraints.getMinWidth-impl(arg18), Constraints.getMaxHeight-impl(arg18), Constraints.getMaxWidth-impl(arg18), arg16.roundToPx-0680j_4(this.verticalArrangement.getSpacing-D9Ej5fM()), arg16, arg17, new Placeable[arg17.size()], 0, arg17.size(), null, 0, 0xC00, null);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope arg2, List arg3, int arg4) {
        return IntrinsicMeasureBlocks.INSTANCE.VerticalMinHeight(arg3, arg4, arg2.roundToPx-0680j_4(this.verticalArrangement.getSpacing-D9Ej5fM()));
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope arg2, List arg3, int arg4) {
        return IntrinsicMeasureBlocks.INSTANCE.VerticalMinWidth(arg3, arg4, arg2.roundToPx-0680j_4(this.verticalArrangement.getSpacing-D9Ej5fM()));
    }

    public MeasureResult placeHelper(Placeable[] arg8, MeasureScope arg9, int arg10, int[] arg11, int arg12, int arg13, int[] arg14, int arg15, int arg16, int arg17) {
        return MeasureScope.layout$default(arg9, arg13, arg12, null, new ColumnMeasurePolicy$$ExternalSyntheticLambda0(arg8, this, arg13, arg10, arg9, arg11), 4, null);
    }

    private static final Unit placeHelper$lambda$0$0(Placeable[] arg11, ColumnMeasurePolicy arg12, int arg13, int arg14, MeasureScope arg15, int[] arg16, PlacementScope arg17) {
        int v0 = arg11.length;
        int v1 = 0;
        int v2;
        for(v2 = 0; v1 < v0; ++v2) {
            Placeable v4 = arg11[v1];
            Intrinsics.checkNotNull(v4);
            PlacementScope.place$default(arg17, v4, arg12.getCrossAxisPosition(v4, RowColumnImplKt.getRowColumnParentData(v4), arg13, arg14, arg15.getLayoutDirection()), arg16[v2], 0f, 4, null);
            ++v1;
        }

        return Unit.INSTANCE;
    }

    public void populateMainAxisPositions(int arg1, int[] arg2, int[] arg3, MeasureScope arg4) {
        this.verticalArrangement.arrange(((Density)arg4), arg1, arg2, arg3);
    }

    public String toString() {
        return "ColumnMeasurePolicy(verticalArrangement=" + this.verticalArrangement + ", horizontalAlignment=" + this.horizontalAlignment + ')';
    }
}

