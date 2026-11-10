package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\f\u0010\t\u001A\u00020\n*\u00020\u000BH\u0016J\f\u0010\f\u001A\u00020\n*\u00020\u000BH\u0016J)\u0010\r\u001A\u00020\u000E*\u00020\u000F2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001A\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J(\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\n2\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001D\u001A\u00020\u000FH\u0016Jg\u0010\u001E\u001A\u00020\u000E2\u000E\u0010\u001F\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0 2\u0006\u0010\u001D\u001A\u00020\u000F2\u0006\u0010!\u001A\u00020\n2\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u0019\u001A\u00020\n2\u0006\u0010\"\u001A\u00020\n2\b\u0010#\u001A\u0004\u0018\u00010\u001B2\u0006\u0010$\u001A\u00020\n2\u0006\u0010%\u001A\u00020\n2\u0006\u0010&\u001A\u00020\nH\u0016¢\u0006\u0002\u0010\'J7\u0010(\u001A\u00020\u00142\u0006\u0010)\u001A\u00020\n2\u0006\u0010*\u001A\u00020\n2\u0006\u0010+\u001A\u00020\n2\u0006\u0010,\u001A\u00020\n2\u0006\u0010-\u001A\u00020.H\u0016¢\u0006\u0004\b/\u00100J*\u00101\u001A\u00020\n2\u0006\u00102\u001A\u00020\u000B2\b\u00103\u001A\u0004\u0018\u0001042\u0006\u0010\"\u001A\u00020\n2\u0006\u0010!\u001A\u00020\nH\u0002J\"\u00105\u001A\u00020\n*\u0002062\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002070\u00112\u0006\u00108\u001A\u00020\nH\u0016J\"\u00109\u001A\u00020\n*\u0002062\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002070\u00112\u0006\u0010:\u001A\u00020\nH\u0016J\"\u0010;\u001A\u00020\n*\u0002062\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002070\u00112\u0006\u00108\u001A\u00020\nH\u0016J\"\u0010<\u001A\u00020\n*\u0002062\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002070\u00112\u0006\u0010:\u001A\u00020\nH\u0016J\t\u0010=\u001A\u00020\u0004HÂ\u0003J\t\u0010>\u001A\u00020\u0006HÂ\u0003J\u001D\u0010?\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001J\u0013\u0010@\u001A\u00020.2\b\u0010A\u001A\u0004\u0018\u00010BHÖ\u0003J\t\u0010C\u001A\u00020\nHÖ\u0001J\t\u0010D\u001A\u00020EHÖ\u0001R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2={"Landroidx/compose/foundation/layout/RowMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "<init>", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;)V", "mainAxisSize", "", "Landroidx/compose/ui/layout/Placeable;", "crossAxisSize", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "populateMainAxisPositions", "", "mainAxisLayoutSize", "childrenMainAxisSize", "", "mainAxisPositions", "measureScope", "placeHelper", "placeables", "", "beforeCrossAxisAlignmentLine", "crossAxisLayoutSize", "crossAxisOffset", "currentLineIndex", "startIndex", "endIndex", "([Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/MeasureScope;I[III[IIII)Landroidx/compose/ui/layout/MeasureResult;", "createConstraints", "mainAxisMin", "crossAxisMin", "mainAxisMax", "crossAxisMax", "isPrioritizing", "", "createConstraints-xF2OJ5Q", "(IIIIZ)J", "getCrossAxisPosition", "placeable", "parentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "minIntrinsicWidth", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RowMeasurePolicy implements RowColumnMeasurePolicy, MeasurePolicy {
    public static final int $stable;
    private final Horizontal horizontalArrangement;
    private final Vertical verticalAlignment;

    public static Unit $r8$lambda$5cIeHBkIiyb_urmhYnHkpCYtFPs(Placeable[] arg0, RowMeasurePolicy arg1, int arg2, int arg3, int[] arg4, PlacementScope arg5) {
        return RowMeasurePolicy.placeHelper$lambda$0$0(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    static {
    }

    public RowMeasurePolicy(Horizontal arg1, Vertical arg2) {
        super();
        this.horizontalArrangement = arg1;
        this.verticalAlignment = arg2;
    }

    private final Horizontal component1() {
        return this.horizontalArrangement;
    }

    private final Vertical component2() {
        return this.verticalAlignment;
    }

    public final RowMeasurePolicy copy(Horizontal arg1, Vertical arg2) {
        return new RowMeasurePolicy(arg1, arg2);
    }

    public static RowMeasurePolicy copy$default(RowMeasurePolicy arg0, Horizontal arg1, Vertical arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.horizontalArrangement;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.verticalAlignment;
        }

        return arg0.copy(arg1, arg2);
    }

    public long createConstraints-xF2OJ5Q(int arg1, int arg2, int arg3, int arg4, boolean arg5) {
        return RowKt.createRowConstraints(arg5, arg1, arg2, arg3, arg4);
    }

    public int crossAxisSize(Placeable arg1) {
        return arg1.getHeight();
    }

    public boolean equals(Object arg5) {
        if(this == (((RowMeasurePolicy)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof RowMeasurePolicy)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.horizontalArrangement, ((RowMeasurePolicy)arg5).horizontalArrangement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.verticalAlignment, ((RowMeasurePolicy)arg5).verticalAlignment)) {
            return 0;
        }

        return 1;
    }

    private final int getCrossAxisPosition(Placeable arg7, RowColumnParentData arg8, int arg9, int arg10) {
        CrossAxisAlignment v8 = arg8 != null ? arg8.getCrossAxisAlignment() : null;
        CrossAxisAlignment v0 = v8;
        if(v0 != null) {
            return v0.align$foundation_layout(arg9, this.crossAxisSize(arg7), LayoutDirection.Ltr, arg7, arg10);
        }

        return this.verticalAlignment.align(this.crossAxisSize(arg7), arg9);
    }

    public int hashCode() {
        return this.horizontalArrangement.hashCode() * 0x1F + this.verticalAlignment.hashCode();
    }

    public int mainAxisSize(Placeable arg1) {
        return arg1.getWidth();
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg2, List arg3, int arg4) {
        return IntrinsicMeasureBlocks.INSTANCE.HorizontalMaxHeight(arg3, arg4, arg2.roundToPx-0680j_4(this.horizontalArrangement.getSpacing-D9Ej5fM()));
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope arg2, List arg3, int arg4) {
        return IntrinsicMeasureBlocks.INSTANCE.HorizontalMaxWidth(arg3, arg4, arg2.roundToPx-0680j_4(this.horizontalArrangement.getSpacing-D9Ej5fM()));
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg16, List arg17, long arg18) {
        return RowColumnMeasurePolicyKt.measure$default(this, Constraints.getMinWidth-impl(arg18), Constraints.getMinHeight-impl(arg18), Constraints.getMaxWidth-impl(arg18), Constraints.getMaxHeight-impl(arg18), arg16.roundToPx-0680j_4(this.horizontalArrangement.getSpacing-D9Ej5fM()), arg16, arg17, new Placeable[arg17.size()], 0, arg17.size(), null, 0, 0xC00, null);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope arg2, List arg3, int arg4) {
        return IntrinsicMeasureBlocks.INSTANCE.HorizontalMinHeight(arg3, arg4, arg2.roundToPx-0680j_4(this.horizontalArrangement.getSpacing-D9Ej5fM()));
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope arg2, List arg3, int arg4) {
        return IntrinsicMeasureBlocks.INSTANCE.HorizontalMinWidth(arg3, arg4, arg2.roundToPx-0680j_4(this.horizontalArrangement.getSpacing-D9Ej5fM()));
    }

    public MeasureResult placeHelper(Placeable[] arg8, MeasureScope arg9, int arg10, int[] arg11, int arg12, int arg13, int[] arg14, int arg15, int arg16, int arg17) {
        return MeasureScope.layout$default(arg9, arg12, arg13, null, new RowMeasurePolicy$$ExternalSyntheticLambda0(arg8, this, arg13, arg10, arg11), 4, null);
    }

    private static final Unit placeHelper$lambda$0$0(Placeable[] arg13, RowMeasurePolicy arg14, int arg15, int arg16, int[] arg17, PlacementScope arg18) {
        int v0 = arg13.length;
        int v1 = 0;
        int v2;
        for(v2 = 0; v1 < v0; ++v2) {
            Placeable v4 = arg13[v1];
            Intrinsics.checkNotNull(v4);
            PlacementScope.place$default(arg18, v4, arg17[v2], arg14.getCrossAxisPosition(v4, RowColumnImplKt.getRowColumnParentData(v4), arg15, arg16), 0f, 4, null);
            ++v1;
        }

        return Unit.INSTANCE;
    }

    public void populateMainAxisPositions(int arg7, int[] arg8, int[] arg9, MeasureScope arg10) {
        this.horizontalArrangement.arrange(arg10, arg7, arg8, arg10.getLayoutDirection(), arg9);
    }

    public String toString() {
        return "RowMeasurePolicy(horizontalArrangement=" + this.horizontalArrangement + ", verticalAlignment=" + this.verticalAlignment + ')';
    }
}

