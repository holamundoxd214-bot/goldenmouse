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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_directionsRailwayFilled", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DirectionsRailwayFilled", "Landroidx/compose/material/icons/Icons$Sharp;", "getDirectionsRailwayFilled", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DirectionsRailwayFilledKt {
    private static ImageVector _directionsRailwayFilled;

    static {
    }

    public static final ImageVector getDirectionsRailwayFilled(Sharp arg19) {
        ImageVector v0 = DirectionsRailwayFilledKt._directionsRailwayFilled;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.DirectionsRailwayFilled", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveTo(8f, 2f, 4f, 2.5f, 4f, 6f);
        v12.verticalLineToRelative(9.5f);
        v12.curveTo(4f, 17.43f, 5.57f, 19f, 7.5f, 19f);
        v12.lineTo(6f, 20f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineToRelative(-1f);
        v12.lineToRelative(-1.5f, -1f);
        v12.curveToRelative(1.93f, 0f, 3.5f, -1.57f, 3.5f, -3.5f);
        v12.verticalLineTo(6f);
        v12.curveTo(20f, 2.5f, 16.42f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(12f, 16f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f);
        v12.reflectiveCurveTo(11.17f, 13f, 12f, 13f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveTo(12.83f, 16f, 12f, 16f);
        v12.close();
        v12.moveTo(18f, 10f);
        v12.horizontalLineTo(6f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineTo(10f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DirectionsRailwayFilledKt._directionsRailwayFilled = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

