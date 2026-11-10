package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_workHistory", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WorkHistory", "Landroidx/compose/material/icons/Icons$Sharp;", "getWorkHistory", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WorkHistoryKt {
    private static ImageVector _workHistory;

    static {
    }

    public static final ImageVector getWorkHistory(Sharp arg19) {
        ImageVector v0 = WorkHistoryKt._workHistory;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.WorkHistory", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16.66f, 11.13f);
        v12.curveToRelative(2f, -0.37f, 3.88f, 0.11f, 5.34f, 1.13f);
        v12.verticalLineTo(6f);
        v12.horizontalLineToRelative(-6f);
        v12.verticalLineTo(2f);
        v12.horizontalLineTo(8f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineTo(2f);
        v12.verticalLineToRelative(15f);
        v12.horizontalLineToRelative(9.68f);
        v12.curveToRelative(-0.63f, -1.33f, -0.87f, -2.88f, -0.52f, -4.51f);
        v12.curveTo(11.75f, 13.79f, 13.94f, 11.63f, 16.66f, 11.13f);
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

