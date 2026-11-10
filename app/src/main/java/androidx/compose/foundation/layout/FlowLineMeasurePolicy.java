package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\f\u0010\u0011\u001A\u00020\u0012*\u00020\u0013H\u0016J\f\u0010\u0014\u001A\u00020\u0012*\u00020\u0013H\u0016J7\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00122\u0006\u0010\u0018\u001A\u00020\u00122\u0006\u0010\u0019\u001A\u00020\u00122\u0006\u0010\u001A\u001A\u00020\u00122\u0006\u0010\u001B\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u001C\u0010\u001DJg\u0010\u001E\u001A\u00020\u001F2\u000E\u0010 \u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130!2\u0006\u0010\"\u001A\u00020#2\u0006\u0010$\u001A\u00020\u00122\u0006\u0010%\u001A\u00020&2\u0006\u0010\'\u001A\u00020\u00122\u0006\u0010(\u001A\u00020\u00122\b\u0010)\u001A\u0004\u0018\u00010&2\u0006\u0010*\u001A\u00020\u00122\u0006\u0010+\u001A\u00020\u00122\u0006\u0010,\u001A\u00020\u0012H\u0016¢\u0006\u0002\u0010-J(\u0010.\u001A\u00020\u00122\u0006\u0010/\u001A\u00020\u00132\u0006\u0010(\u001A\u00020\u00122\u0006\u00100\u001A\u0002012\u0006\u0010$\u001A\u00020\u0012H\u0016J(\u00102\u001A\u0002032\u0006\u0010\'\u001A\u00020\u00122\u0006\u00104\u001A\u00020&2\u0006\u0010%\u001A\u00020&2\u0006\u0010\"\u001A\u00020#H\u0016R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001A\u00020\u0006X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001A\u00020\nX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0012\u0010\r\u001A\u00020\u000EX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00065À\u0006\u0001"}, d2={"Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "isHorizontal", "", "()Z", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getHorizontalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getVerticalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "mainAxisSize", "", "Landroidx/compose/ui/layout/Placeable;", "crossAxisSize", "createConstraints", "Landroidx/compose/ui/unit/Constraints;", "mainAxisMin", "crossAxisMin", "mainAxisMax", "crossAxisMax", "isPrioritizing", "createConstraints-xF2OJ5Q", "(IIIIZ)J", "placeHelper", "Landroidx/compose/ui/layout/MeasureResult;", "placeables", "", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "beforeCrossAxisAlignmentLine", "mainAxisPositions", "", "mainAxisLayoutSize", "crossAxisLayoutSize", "crossAxisOffset", "currentLineIndex", "startIndex", "endIndex", "([Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/MeasureScope;I[III[IIII)Landroidx/compose/ui/layout/MeasureResult;", "getCrossAxisPosition", "placeable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "populateMainAxisPositions", "", "childrenMainAxisSize", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public interface FlowLineMeasurePolicy extends RowColumnMeasurePolicy {
    static Unit $r8$lambda$jQQS5XqDfV8-oYILr-1ooEpM3Z0(int[] arg0, int arg1, int arg2, int arg3, Placeable[] arg4, FlowLineMeasurePolicy arg5, int arg6, LayoutDirection arg7, int arg8, int[] arg9, PlacementScope arg10) {
        return FlowLineMeasurePolicy.placeHelper$lambda$0$0(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    default long createConstraints-xF2OJ5Q(int arg1, int arg2, int arg3, int arg4, boolean arg5) {
        if(this.isHorizontal()) {
            return RowKt.createRowConstraints(arg5, arg1, arg2, arg3, arg4);
        }

        return ColumnKt.createColumnConstraints(arg5, arg1, arg2, arg3, arg4);
    }

    default int crossAxisSize(Placeable arg1) {
        if(this.isHorizontal()) {
            return arg1.getMeasuredHeight();
        }

        return arg1.getMeasuredWidth();
    }

    CrossAxisAlignment getCrossAxisAlignment();

    default int getCrossAxisPosition(Placeable arg8, int arg9, LayoutDirection arg10, int arg11) {
        CrossAxisAlignment v0_1;
        RowColumnParentData v0 = RowColumnImplKt.getRowColumnParentData(arg8);
        if(v0 != null) {
            v0_1 = v0.getCrossAxisAlignment();
            if(v0_1 == null) {
                goto label_4;
            }
        }
        else {
        label_4:
            v0_1 = this.getCrossAxisAlignment();
        }

        return v0_1.align$foundation_layout(arg9, this.crossAxisSize(arg8), arg10, arg8, arg11);
    }

    Horizontal getHorizontalArrangement();

    Vertical getVerticalArrangement();

    boolean isHorizontal();

    default int mainAxisSize(Placeable arg1) {
        if(this.isHorizontal()) {
            return arg1.getMeasuredWidth();
        }

        return arg1.getMeasuredHeight();
    }

    default MeasureResult placeHelper(Placeable[] arg15, MeasureScope arg16, int arg17, int[] arg18, int arg19, int arg20, int[] arg21, int arg22, int arg23, int arg24) {
        int v1;
        int v0;
        if(this.isHorizontal()) {
            v0 = arg19;
            v1 = arg20;
        }
        else {
            v1 = arg19;
            v0 = arg20;
        }

        LayoutDirection v2 = this.isHorizontal() ? LayoutDirection.Ltr : arg16.getLayoutDirection();
        return MeasureScope.layout$default(arg16, v0, v1, null, new FlowLineMeasurePolicy$$ExternalSyntheticLambda0(arg21, arg22, arg23, arg24, arg15, this, arg20, v2, arg17, arg18), 4, null);
    }

    private static Unit placeHelper$lambda$0$0(int[] arg12, int arg13, int arg14, int arg15, Placeable[] arg16, FlowLineMeasurePolicy arg17, int arg18, LayoutDirection arg19, int arg20, int[] arg21, PlacementScope arg22) {
        int v12 = arg12 != null ? arg12[arg13] : 0;
        int v0;
        for(v0 = arg14; v0 < arg15; ++v0) {
            Placeable v2 = arg16[v0];
            Intrinsics.checkNotNull(v2);
            int v3 = arg17.getCrossAxisPosition(v2, arg18, arg19, arg20) + v12;
            if(arg17.isHorizontal()) {
                PlacementScope.place$default(arg22, v2, arg21[v0 - arg14], v3, 0f, 4, null);
            }
            else {
                PlacementScope.place$default(arg22, v2, v3, arg21[v0 - arg14], 0f, 4, null);
            }
        }

        return Unit.INSTANCE;
    }

    default void populateMainAxisPositions(int arg8, int[] arg9, int[] arg10, MeasureScope arg11) {
        if(this.isHorizontal()) {
            this.getHorizontalArrangement().arrange(arg11, arg8, arg9, arg11.getLayoutDirection(), arg10);
            return;
        }

        this.getVerticalArrangement().arrange(((Density)arg11), arg8, arg9, arg10);
    }
}

