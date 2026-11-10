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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_workspacePremium", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WorkspacePremium", "Landroidx/compose/material/icons/Icons$Rounded;", "getWorkspacePremium", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WorkspacePremiumKt {
    private static ImageVector _workspacePremium;

    static {
    }

    public static final ImageVector getWorkspacePremium(Rounded arg19) {
        ImageVector v0 = WorkspacePremiumKt._workspacePremium;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.WorkspacePremium", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10.92f, 12.75f);
        v12.lineTo(12f, 11.93f);
        v12.lineToRelative(1.07f, 0.81f);
        v12.curveToRelative(0.39f, 0.29f, 0.92f, -0.08f, 0.78f, -0.55f);
        v12.lineToRelative(-0.42f, -1.36f);
        v12.lineToRelative(1.2f, -0.95f);
        v12.curveTo(15f, 9.6f, 14.79f, 9f, 14.31f, 9f);
        v12.horizontalLineToRelative(-1.4f);
        v12.lineToRelative(-0.43f, -1.34f);
        v12.curveToRelative(-0.15f, -0.46f, -0.8f, -0.46f, -0.95f, 0f);
        v12.lineTo(11.09f, 9f);
        v12.horizontalLineTo(9.68f);
        v12.curveTo(9.21f, 9f, 9f, 9.6f, 9.37f, 9.89f);
        v12.lineToRelative(1.19f, 0.95f);
        v12.lineToRelative(-0.42f, 1.36f);
        v12.curveTo(10f, 12.67f, 10.53f, 13.04f, 10.92f, 12.75f);
        v12.close();
        v12.moveTo(6f, 21.610001f);
        v12.curveToRelative(0f, 0.68f, 0.67f, 1.16f, 1.32f, 0.95f);
        v12.lineTo(12f, 21f);
        v12.lineToRelative(4.68f, 1.56f);
        v12.curveTo(17.33f, 22.780001f, 18f, 22.299999f, 18f, 21.610001f);
        v12.verticalLineToRelative(-6.33f);
        v12.curveToRelative(1.24f, -1.41f, 2f, -3.25f, 2f, -5.28f);
        v12.curveToRelative(0f, -4.42f, -3.58f, -8f, -8f, -8f);
        v12.reflectiveCurveToRelative(-8f, 3.58f, -8f, 8f);
        v12.curveToRelative(0f, 2.03f, 0.76f, 3.87f, 2f, 5.28f);
        v12.verticalLineTo(21.610001f);
        v12.close();
        v12.moveTo(12f, 4f);
        v12.curveToRelative(3.31f, 0f, 6f, 2.69f, 6f, 6f);
        v12.reflectiveCurveToRelative(-2.69f, 6f, -6f, 6f);
        v12.reflectiveCurveToRelative(-6f, -2.69f, -6f, -6f);
        v12.reflectiveCurveTo(8.69f, 4f, 12f, 4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WorkspacePremiumKt._workspacePremium = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

