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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"__6FtApart", "Landroidx/compose/ui/graphics/vector/ImageVector;", "_6FtApart", "Landroidx/compose/material/icons/Icons$Rounded;", "get_6FtApart", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class _6FtApartKt {
    private static ImageVector __6FtApart;

    static {
    }

    public static final ImageVector get_6FtApart(Rounded arg19) {
        ImageVector v0 = _6FtApartKt.__6FtApart;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded._6FtApart", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(6f, 6f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveTo(7.1f, 2f, 6f, 2f);
        v12.reflectiveCurveTo(4f, 2.9f, 4f, 4f);
        v12.reflectiveCurveTo(4.9f, 6f, 6f, 6f);
        v12.close();
        v12.moveTo(10f, 9.43f);
        v12.curveToRelative(0f, -0.81f, -0.48f, -1.53f, -1.22f, -1.85f);
        v12.curveTo(7.93f, 7.21f, 6.99f, 7f, 6f, 7f);
        v12.curveTo(5.01f, 7f, 4.07f, 7.21f, 3.22f, 7.58f);
        v12.curveTo(2.48f, 7.9f, 2f, 8.62f, 2f, 9.43f);
        v12.verticalLineTo(10f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineTo(9.43f);
        v12.close();
        v12.moveTo(18f, 6f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveToRelative(-0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveTo(16.9f, 6f, 18f, 6f);
        v12.close();
        v12.moveTo(22f, 9.43f);
        v12.curveToRelative(0f, -0.81f, -0.48f, -1.53f, -1.22f, -1.85f);
        v12.curveTo(19.93f, 7.21f, 18.99f, 7f, 18f, 7f);
        v12.curveToRelative(-0.99f, 0f, -1.93f, 0.21f, -2.78f, 0.58f);
        v12.curveTo(14.48f, 7.9f, 14f, 8.62f, 14f, 9.43f);
        v12.verticalLineTo(10f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineTo(9.43f);
        v12.close();
        v12.moveTo(21.65f, 14.35f);
        v12.lineToRelative(-1.79f, 1.79f);
        v12.curveTo(19.540001f, 16.459999f, 19f, 16.24f, 19f, 15.79f);
        v12.verticalLineToRelative(-0.8f);
        v12.lineTo(5f, 15f);
        v12.verticalLineToRelative(0.79f);
        v12.curveToRelative(0f, 0.45f, -0.54f, 0.67f, -0.85f, 0.35f);
        v12.lineToRelative(-1.79f, -1.79f);
        v12.curveToRelative(-0.2f, -0.2f, -0.2f, -0.51f, 0f, -0.71f);
        v12.lineToRelative(1.79f, -1.79f);
        v12.curveTo(4.46f, 11.54f, 5f, 11.76f, 5f, 12.21f);
        v12.verticalLineToRelative(0.8f);
        v12.lineTo(19f, 13f);
        v12.verticalLineToRelative(-0.79f);
        v12.curveToRelative(0f, -0.45f, 0.54f, -0.67f, 0.85f, -0.35f);
        v12.lineToRelative(1.79f, 1.79f);
        v12.curveTo(21.84f, 13.84f, 21.84f, 14.16f, 21.65f, 14.35f);
        v12.close();
        v12.moveTo(10f, 18.5f);
        v12.lineTo(10f, 18.5f);
        v12.curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f);
        v12.horizontalLineToRelative(-2f);
        v12.curveTo(7.22f, 18f, 7f, 18.219999f, 7f, 18.5f);
        v12.verticalLineToRelative(3f);
        v12.curveTo(7f, 21.780001f, 7.22f, 22f, 7.5f, 22f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f);
        v12.verticalLineTo(20f);
        v12.curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f);
        v12.horizontalLineTo(8f);
        v12.verticalLineTo(19f);
        v12.horizontalLineToRelative(1.5f);
        v12.curveTo(9.78f, 19f, 10f, 18.780001f, 10f, 18.5f);
        v12.close();
        v12.moveTo(9f, 20.5f);
        v12.verticalLineTo(21f);
        v12.horizontalLineTo(8f);
        v12.verticalLineToRelative(-0.5f);
        v12.horizontalLineTo(9f);
        v12.close();
        v12.moveTo(17f, 19f);
        v12.horizontalLineToRelative(-0.5f);
        v12.verticalLineToRelative(2.5f);
        v12.curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f);
        v12.verticalLineTo(19f);
        v12.horizontalLineTo(15f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(17.5f, 18.780001f, 17.280001f, 19f, 17f, 19f);
        v12.close();
        v12.moveTo(14f, 18.5f);
        v12.curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineToRelative(0.5f);
        v12.horizontalLineTo(13f);
        v12.curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f);
        v12.curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f);
        v12.horizontalLineToRelative(-0.5f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f);
        v12.verticalLineToRelative(-3f);
        v12.curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f);
        v12.horizontalLineToRelative(1.5f);
        v12.curveTo(13.78f, 18f, 14f, 18.219999f, 14f, 18.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        _6FtApartKt.__6FtApart = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

