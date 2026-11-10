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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_report", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Report", "Landroidx/compose/material/icons/Icons$Sharp;", "getReport", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ReportKt {
    private static ImageVector _report;

    static {
    }

    public static final ImageVector getReport(Sharp arg19) {
        ImageVector v0 = ReportKt._report;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Report", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15.73f, 3f);
        v12.lineTo(8.27f, 3f);
        v12.lineTo(3f, 8.27f);
        v12.verticalLineToRelative(7.46f);
        v12.lineTo(8.27f, 21f);
        v12.horizontalLineToRelative(7.46f);
        v12.lineTo(21f, 15.73f);
        v12.lineTo(21f, 8.27f);
        v12.lineTo(15.73f, 3f);
        v12.close();
        v12.moveTo(12f, 17.299999f);
        v12.curveToRelative(-0.72f, 0f, -1.3f, -0.58f, -1.3f, -1.3f);
        v12.reflectiveCurveToRelative(0.58f, -1.3f, 1.3f, -1.3f);
        v12.reflectiveCurveToRelative(1.3f, 0.58f, 1.3f, 1.3f);
        v12.reflectiveCurveToRelative(-0.58f, 1.3f, -1.3f, 1.3f);
        v12.close();
        v12.moveTo(13f, 13f);
        v12.horizontalLineToRelative(-2f);
        v12.lineTo(11f, 7f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ReportKt._report = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

