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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_changeCircle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ChangeCircle", "Landroidx/compose/material/icons/Icons$Outlined;", "getChangeCircle", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ChangeCircleKt {
    private static ImageVector _changeCircle;

    static {
    }

    public static final ImageVector getChangeCircle(Outlined arg19) {
        ImageVector v0 = ChangeCircleKt._changeCircle;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.ChangeCircle", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f);
        v12.reflectiveCurveToRelative(4.48f, 10f, 10f, 10f);
        v12.reflectiveCurveToRelative(10f, -4.48f, 10f, -10f);
        v12.reflectiveCurveTo(17.52f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(12f, 20f);
        v12.curveToRelative(-4.41f, 0f, -8f, -3.59f, -8f, -8f);
        v12.reflectiveCurveToRelative(3.59f, -8f, 8f, -8f);
        v12.reflectiveCurveToRelative(8f, 3.59f, 8f, 8f);
        v12.reflectiveCurveTo(16.41f, 20f, 12f, 20f);
        v12.close();
        v12.moveTo(16.17f, 14.76f);
        v12.lineToRelative(-1.1f, -1.1f);
        v12.curveToRelative(0.71f, -1.33f, 0.53f, -3.01f, -0.59f, -4.13f);
        v12.curveTo(13.79f, 8.84f, 12.9f, 8.5f, 12f, 8.5f);
        v12.curveToRelative(-0.03f, 0f, -0.06f, 0.01f, -0.09f, 0.01f);
        v12.lineTo(13f, 9.6f);
        v12.lineToRelative(-1.06f, 1.06f);
        v12.lineTo(9.11f, 7.83f);
        v12.lineTo(11.94f, 5f);
        v12.lineTo(13f, 6.06f);
        v12.lineToRelative(-0.96f, 0.96f);
        v12.curveToRelative(1.27f, 0.01f, 2.53f, 0.48f, 3.5f, 1.44f);
        v12.curveTo(17.24f, 10.17f, 17.450001f, 12.82f, 16.17f, 14.76f);
        v12.close();
        v12.moveTo(14.89f, 16.17f);
        v12.lineTo(12.06f, 19f);
        v12.lineTo(11f, 17.940001f);
        v12.lineToRelative(0.95f, -0.95f);
        v12.curveToRelative(-1.26f, -0.01f, -2.52f, -0.5f, -3.48f, -1.46f);
        v12.curveToRelative(-1.71f, -1.71f, -1.92f, -4.35f, -0.64f, -6.29f);
        v12.lineToRelative(1.1f, 1.1f);
        v12.curveToRelative(-0.71f, 1.33f, -0.53f, 3.01f, 0.59f, 4.13f);
        v12.curveToRelative(0.7f, 0.7f, 1.63f, 1.04f, 2.56f, 1.01f);
        v12.lineTo(11f, 14.4f);
        v12.lineToRelative(1.06f, -1.06f);
        v12.lineTo(14.89f, 16.17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ChangeCircleKt._changeCircle = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

