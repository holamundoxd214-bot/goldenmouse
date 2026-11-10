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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_yard", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Yard", "Landroidx/compose/material/icons/Icons$Rounded;", "getYard", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class YardKt {
    private static ImageVector _yard;

    static {
    }

    public static final ImageVector getYard(Rounded arg20) {
        ImageVector v0 = YardKt._yard;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Yard", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
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
        v12.moveTo(8f, 8.22f);
        v12.curveToRelative(0f, -0.86f, 0.7f, -1.56f, 1.56f, -1.56f);
        v12.curveToRelative(0.33f, 0f, 0.64f, 0.1f, 0.89f, 0.28f);
        v12.lineToRelative(-0.01f, -0.12f);
        v12.curveToRelative(0f, -0.86f, 0.7f, -1.56f, 1.56f, -1.56f);
        v12.reflectiveCurveToRelative(1.56f, 0.7f, 1.56f, 1.56f);
        v12.lineToRelative(-0.01f, 0.12f);
        v12.curveToRelative(0.26f, -0.18f, 0.56f, -0.28f, 0.89f, -0.28f);
        v12.curveToRelative(0.86f, 0f, 1.56f, 0.7f, 1.56f, 1.56f);
        v12.curveToRelative(0f, 0.62f, -0.37f, 1.16f, -0.89f, 1.4f);
        v12.curveTo(15.63f, 9.87f, 16f, 10.41f, 16f, 11.03f);
        v12.curveToRelative(0f, 0.86f, -0.7f, 1.56f, -1.56f, 1.56f);
        v12.curveToRelative(-0.33f, 0f, -0.64f, -0.11f, -0.89f, -0.28f);
        v12.lineToRelative(0.01f, 0.12f);
        v12.curveToRelative(0f, 0.86f, -0.7f, 1.56f, -1.56f, 1.56f);
        v12.reflectiveCurveToRelative(-1.56f, -0.7f, -1.56f, -1.56f);
        v12.lineToRelative(0.01f, -0.12f);
        v12.curveToRelative(-0.26f, 0.18f, -0.56f, 0.28f, -0.89f, 0.28f);
        v12.curveTo(8.7f, 12.59f, 8f, 11.89f, 8f, 11.03f);
        v12.curveToRelative(0f, -0.62f, 0.37f, -1.16f, 0.89f, -1.4f);
        v12.curveTo(8.37f, 9.38f, 8f, 8.84f, 8f, 8.22f);
        v12.close();
        v12.moveTo(12f, 19f);
        v12.curveToRelative(-2.83f, 0f, -5.21f, -1.97f, -5.84f, -4.61f);
        v12.curveToRelative(-0.18f, -0.74f, 0.49f, -1.4f, 1.23f, -1.23f);
        v12.curveTo(10.03f, 13.79f, 12f, 16.17f, 12f, 19f);
        v12.curveToRelative(0f, -2.83f, 1.97f, -5.21f, 4.61f, -5.84f);
        v12.curveToRelative(0.74f, -0.18f, 1.4f, 0.49f, 1.23f, 1.23f);
        v12.curveTo(17.209999f, 17.030001f, 14.83f, 19f, 12f, 19f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 9.62f);
        v12.moveToRelative(-1.56f, 0f);
        v12.arcToRelative(1.56f, 1.56f, 0f, true, true, 3.12f, 0f);
        v12.arcToRelative(1.56f, 1.56f, 0f, true, true, -3.12f, 0f);
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        YardKt._yard = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

