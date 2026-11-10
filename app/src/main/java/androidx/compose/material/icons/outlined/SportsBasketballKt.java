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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sportsBasketball", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SportsBasketball", "Landroidx/compose/material/icons/Icons$Outlined;", "getSportsBasketball", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SportsBasketballKt {
    private static ImageVector _sportsBasketball;

    static {
    }

    public static final ImageVector getSportsBasketball(Outlined arg19) {
        ImageVector v0 = SportsBasketballKt._sportsBasketball;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.SportsBasketball", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f);
        v12.curveToRelative(0f, 5.52f, 4.48f, 10f, 10f, 10f);
        v12.reflectiveCurveToRelative(10f, -4.48f, 10f, -10f);
        v12.curveTo(22f, 6.48f, 17.52f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(5.23f, 7.75f);
        v12.curveTo(6.1f, 8.62f, 6.7f, 9.74f, 6.91f, 11f);
        v12.horizontalLineTo(4.07f);
        v12.curveTo(4.22f, 9.82f, 4.63f, 8.72f, 5.23f, 7.75f);
        v12.close();
        v12.moveTo(4.07f, 13f);
        v12.horizontalLineToRelative(2.84f);
        v12.curveToRelative(-0.21f, 1.26f, -0.81f, 2.38f, -1.68f, 3.25f);
        v12.curveTo(4.63f, 15.28f, 4.22f, 14.18f, 4.07f, 13f);
        v12.close();
        v12.moveTo(11f, 19.93f);
        v12.curveToRelative(-1.73f, -0.22f, -3.29f, -1f, -4.49f, -2.14f);
        v12.curveToRelative(1.3f, -1.24f, 2.19f, -2.91f, 2.42f, -4.79f);
        v12.horizontalLineTo(11f);
        v12.verticalLineTo(19.93f);
        v12.close();
        v12.moveTo(11f, 11f);
        v12.horizontalLineTo(8.93f);
        v12.curveTo(8.69f, 9.12f, 7.81f, 7.44f, 6.5f, 6.2f);
        v12.curveTo(7.71f, 5.06f, 9.27f, 4.29f, 11f, 4.07f);
        v12.verticalLineTo(11f);
        v12.close();
        v12.moveTo(19.93f, 11f);
        v12.horizontalLineToRelative(-2.84f);
        v12.curveToRelative(0.21f, -1.26f, 0.81f, -2.38f, 1.68f, -3.25f);
        v12.curveTo(19.370001f, 8.72f, 19.780001f, 9.82f, 19.93f, 11f);
        v12.close();
        v12.moveTo(13f, 4.07f);
        v12.curveToRelative(1.73f, 0.22f, 3.29f, 0.99f, 4.5f, 2.13f);
        v12.curveToRelative(-1.31f, 1.24f, -2.19f, 2.92f, -2.43f, 4.8f);
        v12.horizontalLineTo(13f);
        v12.verticalLineTo(4.07f);
        v12.close();
        v12.moveTo(13f, 19.93f);
        v12.verticalLineTo(13f);
        v12.horizontalLineToRelative(2.07f);
        v12.curveToRelative(0.24f, 1.88f, 1.12f, 3.55f, 2.42f, 4.79f);
        v12.curveTo(16.290001f, 18.93f, 14.73f, 19.709999f, 13f, 19.93f);
        v12.close();
        v12.moveTo(18.77f, 16.25f);
        v12.curveToRelative(-0.87f, -0.86f, -1.46f, -1.99f, -1.68f, -3.25f);
        v12.horizontalLineToRelative(2.84f);
        v12.curveTo(19.780001f, 14.18f, 19.370001f, 15.28f, 18.77f, 16.25f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SportsBasketballKt._sportsBasketball = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

