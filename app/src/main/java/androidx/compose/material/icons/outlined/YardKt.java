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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_yard", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Yard", "Landroidx/compose/material/icons/Icons$Outlined;", "getYard", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class YardKt {
    private static ImageVector _yard;

    static {
    }

    public static final ImageVector getYard(Outlined arg19) {
        ImageVector v0 = YardKt._yard;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Yard", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 13f);
        v12.curveToRelative(-3.31f, 0f, -6f, 2.69f, -6f, 6f);
        v12.curveTo(15.31f, 19f, 18f, 16.309999f, 18f, 13f);
        v12.close();
        v12.moveTo(6f, 13f);
        v12.curveToRelative(0f, 3.31f, 2.69f, 6f, 6f, 6f);
        v12.curveTo(12f, 15.69f, 9.31f, 13f, 6f, 13f);
        v12.close();
        v12.moveTo(8f, 11.03f);
        v12.curveToRelative(0f, 0.86f, 0.7f, 1.56f, 1.56f, 1.56f);
        v12.curveToRelative(0.33f, 0f, 0.63f, -0.1f, 0.89f, -0.28f);
        v12.lineToRelative(-0.01f, 0.12f);
        v12.curveToRelative(0f, 0.86f, 0.7f, 1.56f, 1.56f, 1.56f);
        v12.reflectiveCurveToRelative(1.56f, -0.7f, 1.56f, -1.56f);
        v12.lineToRelative(-0.01f, -0.12f);
        v12.curveToRelative(0.25f, 0.17f, 0.56f, 0.28f, 0.89f, 0.28f);
        v12.curveToRelative(0.86f, 0f, 1.56f, -0.7f, 1.56f, -1.56f);
        v12.curveToRelative(0f, -0.62f, -0.37f, -1.16f, -0.89f, -1.41f);
        v12.curveTo(15.63f, 9.38f, 16f, 8.84f, 16f, 8.22f);
        v12.curveToRelative(0f, -0.86f, -0.7f, -1.56f, -1.56f, -1.56f);
        v12.curveToRelative(-0.33f, 0f, -0.63f, 0.1f, -0.89f, 0.28f);
        v12.lineToRelative(0.01f, -0.12f);
        v12.curveToRelative(0f, -0.86f, -0.7f, -1.56f, -1.56f, -1.56f);
        v12.reflectiveCurveToRelative(-1.56f, 0.7f, -1.56f, 1.56f);
        v12.lineToRelative(0.01f, 0.12f);
        v12.curveTo(10.2f, 6.76f, 9.89f, 6.66f, 9.56f, 6.66f);
        v12.curveTo(8.7f, 6.66f, 8f, 7.36f, 8f, 8.22f);
        v12.curveToRelative(0f, 0.62f, 0.37f, 1.16f, 0.89f, 1.41f);
        v12.curveTo(8.37f, 9.87f, 8f, 10.41f, 8f, 11.03f);
        v12.close();
        v12.moveTo(12f, 8.06f);
        v12.curveToRelative(0.86f, 0f, 1.56f, 0.7f, 1.56f, 1.56f);
        v12.reflectiveCurveToRelative(-0.7f, 1.56f, -1.56f, 1.56f);
        v12.reflectiveCurveToRelative(-1.56f, -0.7f, -1.56f, -1.56f);
        v12.reflectiveCurveTo(11.14f, 8.06f, 12f, 8.06f);
        v12.close();
        v12.moveTo(20f, 4f);
        v12.verticalLineToRelative(16f);
        v12.horizontalLineTo(4f);
        v12.verticalLineTo(4f);
        v12.horizontalLineTo(20f);
        v12.moveTo(20f, 2f);
        v12.horizontalLineTo(4f);
        v12.curveTo(2.9f, 2f, 2f, 2.9f, 2f, 4f);
        v12.verticalLineToRelative(16f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(4f);
        v12.curveTo(22f, 2.9f, 21.1f, 2f, 20f, 2f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        YardKt._yard = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

