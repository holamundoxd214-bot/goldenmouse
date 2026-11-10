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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_bugReport", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BugReport", "Landroidx/compose/material/icons/Icons$Sharp;", "getBugReport", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BugReportKt {
    private static ImageVector _bugReport;

    static {
    }

    public static final ImageVector getBugReport(Sharp arg19) {
        ImageVector v0 = BugReportKt._bugReport;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.BugReport", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 8f);
        v12.horizontalLineToRelative(-2.81f);
        v12.curveToRelative(-0.45f, -0.78f, -1.07f, -1.45f, -1.82f, -1.96f);
        v12.lineTo(17f, 4.41f);
        v12.lineTo(15.59f, 3f);
        v12.lineToRelative(-2.17f, 2.17f);
        v12.curveTo(12.96f, 5.06f, 12.49f, 5f, 12f, 5f);
        v12.reflectiveCurveToRelative(-0.96f, 0.06f, -1.41f, 0.17f);
        v12.lineTo(8.41f, 3f);
        v12.lineTo(7f, 4.41f);
        v12.lineToRelative(1.62f, 1.63f);
        v12.curveTo(7.88f, 6.55f, 7.26f, 7.22f, 6.81f, 8f);
        v12.lineTo(4f, 8f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2.09f);
        v12.curveToRelative(-0.05f, 0.33f, -0.09f, 0.66f, -0.09f, 1f);
        v12.verticalLineToRelative(1f);
        v12.lineTo(4f, 12f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(0f, 0.34f, 0.04f, 0.67f, 0.09f, 1f);
        v12.lineTo(4f, 16f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2.81f);
        v12.curveToRelative(1.04f, 1.79f, 2.97f, 3f, 5.19f, 3f);
        v12.reflectiveCurveToRelative(4.15f, -1.21f, 5.19f, -3f);
        v12.lineTo(20f, 18f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-2.09f);
        v12.curveToRelative(0.05f, -0.33f, 0.09f, -0.66f, 0.09f, -1f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-1f);
        v12.curveToRelative(0f, -0.34f, -0.04f, -0.67f, -0.09f, -1f);
        v12.lineTo(20f, 10f);
        v12.lineTo(20f, 8f);
        v12.close();
        v12.moveTo(14f, 16f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(2f);
        v12.close();
        v12.moveTo(14f, 12f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(2f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BugReportKt._bugReport = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

