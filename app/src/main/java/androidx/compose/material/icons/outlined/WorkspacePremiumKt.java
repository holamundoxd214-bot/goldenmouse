package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_workspacePremium", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WorkspacePremium", "Landroidx/compose/material/icons/Icons$Outlined;", "getWorkspacePremium", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WorkspacePremiumKt {
    private static ImageVector _workspacePremium;

    static {
    }

    public static final ImageVector getWorkspacePremium(Outlined arg19) {
        ImageVector v0 = WorkspacePremiumKt._workspacePremium;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.WorkspacePremium", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9.68f, 13.69f);
        v12.lineTo(12f, 11.93f);
        v12.lineToRelative(2.31f, 1.76f);
        v12.lineToRelative(-0.88f, -2.85f);
        v12.lineTo(15.75f, 9f);
        v12.horizontalLineToRelative(-2.84f);
        v12.lineTo(12f, 6.19f);
        v12.lineTo(11.09f, 9f);
        v12.horizontalLineTo(8.25f);
        v12.lineToRelative(2.31f, 1.84f);
        v12.lineTo(9.68f, 13.69f);
        v12.close();
        v12.moveTo(20f, 10f);
        v12.curveToRelative(0f, -4.42f, -3.58f, -8f, -8f, -8f);
        v12.reflectiveCurveToRelative(-8f, 3.58f, -8f, 8f);
        v12.curveToRelative(0f, 2.03f, 0.76f, 3.87f, 2f, 5.28f);
        v12.verticalLineTo(23f);
        v12.lineToRelative(6f, -2f);
        v12.lineToRelative(6f, 2f);
        v12.verticalLineToRelative(-7.72f);
        v12.curveTo(19.24f, 13.87f, 20f, 12.03f, 20f, 10f);
        v12.close();
        v12.moveTo(12f, 4f);
        v12.curveToRelative(3.31f, 0f, 6f, 2.69f, 6f, 6f);
        v12.reflectiveCurveToRelative(-2.69f, 6f, -6f, 6f);
        v12.reflectiveCurveToRelative(-6f, -2.69f, -6f, -6f);
        v12.reflectiveCurveTo(8.69f, 4f, 12f, 4f);
        v12.close();
        v12.moveTo(12f, 19f);
        v12.lineToRelative(-4f, 1.02f);
        v12.verticalLineToRelative(-3.1f);
        v12.curveTo(9.18f, 17.6f, 10.54f, 18f, 12f, 18f);
        v12.reflectiveCurveToRelative(2.82f, -0.4f, 4f, -1.08f);
        v12.verticalLineToRelative(3.1f);
        v12.lineTo(12f, 19f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WorkspacePremiumKt._workspacePremium = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

