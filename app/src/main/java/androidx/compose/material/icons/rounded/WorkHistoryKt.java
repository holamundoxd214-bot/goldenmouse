package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons$Rounded;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector$Builder;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_workHistory", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WorkHistory", "Landroidx/compose/material/icons/Icons$Rounded;", "getWorkHistory", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WorkHistoryKt {
    private static ImageVector _workHistory;

    static {
    }

    public static final ImageVector getWorkHistory(Rounded arg19) {
        ImageVector v0 = WorkHistoryKt._workHistory;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.WorkHistory", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 11f);
        v12.curveToRelative(1.49f, 0f, 2.87f, 0.47f, 4f, 1.26f);
        v12.verticalLineTo(8f);
        v12.curveToRelative(0f, -1.11f, -0.89f, -2f, -2f, -2f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineTo(4f);
        v12.curveToRelative(0f, -1.11f, -0.89f, -2f, -2f, -2f);
        v12.horizontalLineToRelative(-4f);
        v12.curveTo(8.89f, 2f, 8f, 2.89f, 8f, 4f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(4f);
        v12.curveTo(2.89f, 6f, 2.01f, 6.89f, 2.01f, 8f);
        v12.lineTo(2f, 19f);
        v12.curveToRelative(0f, 1.11f, 0.89f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(7.68f);
        v12.curveTo(11.25f, 20.09f, 11f, 19.08f, 11f, 18f);
        v12.curveTo(11f, 14.13f, 14.13f, 11f, 18f, 11f);
        v12.close();
        v12.moveTo(10f, 4f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineTo(4f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(18f, 13f);
        v12.curveToRelative(-2.76f, 0f, -5f, 2.24f, -5f, 5f);
        v12.reflectiveCurveToRelative(2.24f, 5f, 5f, 5f);
        v12.reflectiveCurveToRelative(5f, -2.24f, 5f, -5f);
        v12.reflectiveCurveTo(20.76f, 13f, 18f, 13f);
        v12.close();
        v12.moveTo(19.65f, 20.35f);
        v12.lineToRelative(-2.15f, -2.15f);
        v12.verticalLineTo(15f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(2.79f);
        v12.lineToRelative(1.85f, 1.85f);
        v12.lineTo(19.65f, 20.35f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WorkHistoryKt._workHistory = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

