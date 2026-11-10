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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_vapeFree", "Landroidx/compose/ui/graphics/vector/ImageVector;", "VapeFree", "Landroidx/compose/material/icons/Icons$Outlined;", "getVapeFree", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class VapeFreeKt {
    private static ImageVector _vapeFree;

    static {
    }

    public static final ImageVector getVapeFree(Outlined arg19) {
        ImageVector v0 = VapeFreeKt._vapeFree;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.VapeFree", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(2f, 16.5f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(1.33f, 0f, 2.71f, -0.18f, 4f, -0.5f);
        v12.verticalLineToRelative(3f);
        v12.curveToRelative(-1.29f, -0.32f, -2.67f, -0.5f, -4f, -0.5f);
        v12.horizontalLineTo(2f);
        v12.verticalLineTo(16.5f);
        v12.close();
        v12.moveTo(16.17f, 19f);
        v12.horizontalLineTo(8f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineToRelative(5.17f);
        v12.lineTo(1.39f, 4.22f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineToRelative(18.379999f, 18.379999f);
        v12.lineToRelative(-1.41f, 1.41f);
        v12.lineTo(16.17f, 19f);
        v12.close();
        v12.moveTo(18.83f, 16f);
        v12.horizontalLineTo(22f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(-0.17f);
        v12.lineTo(18.83f, 16f);
        v12.close();
        v12.moveTo(11f, 17.5f);
        v12.curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f);
        v12.reflectiveCurveTo(10f, 17.219999f, 10f, 17.5f);
        v12.curveToRelative(0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f);
        v12.reflectiveCurveTo(11f, 17.780001f, 11f, 17.5f);
        v12.close();
        v12.moveTo(22f, 12.76f);
        v12.verticalLineTo(15f);
        v12.horizontalLineToRelative(-1.5f);
        v12.verticalLineToRelative(-2.23f);
        v12.curveToRelative(0f, -2.24f, -1.76f, -4.07f, -4f, -4.07f);
        v12.verticalLineTo(7.2f);
        v12.curveToRelative(1.02f, 0f, 1.85f, -0.83f, 1.85f, -1.85f);
        v12.reflectiveCurveTo(17.52f, 3.5f, 16.5f, 3.5f);
        v12.verticalLineTo(2f);
        v12.curveToRelative(1.85f, 0f, 3.35f, 1.5f, 3.35f, 3.35f);
        v12.curveToRelative(0f, 0.93f, -0.38f, 1.77f, -1f, 2.38f);
        v12.curveTo(20.719999f, 8.62f, 22f, 10.54f, 22f, 12.76f);
        v12.close();
        v12.moveTo(11.15f, 8.32f);
        v12.curveToRelative(0f, -0.01f, 0f, -0.01f, 0f, -0.02f);
        v12.curveToRelative(0f, -1.85f, 1.5f, -3.35f, 3.35f, -3.35f);
        v12.verticalLineToRelative(1.5f);
        v12.curveToRelative(-1.02f, 0f, -1.85f, 0.73f, -1.85f, 1.75f);
        v12.reflectiveCurveToRelative(0.83f, 2f, 1.85f, 2f);
        v12.horizontalLineToRelative(1.53f);
        v12.curveToRelative(1.87f, 0f, 3.47f, 1.35f, 3.47f, 3.16f);
        v12.verticalLineTo(15f);
        v12.horizontalLineTo(18f);
        v12.verticalLineToRelative(-1.3f);
        v12.curveToRelative(0f, -1.31f, -0.92f, -2.05f, -1.97f, -2.05f);
        v12.horizontalLineTo(14.5f);
        v12.curveToRelative(-0.01f, 0f, -0.01f, 0f, -0.02f, 0f);
        v12.lineTo(11.15f, 8.32f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        VapeFreeKt._vapeFree = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

