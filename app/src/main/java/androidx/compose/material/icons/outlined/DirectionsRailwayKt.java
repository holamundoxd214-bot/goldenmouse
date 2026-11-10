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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_directionsRailway", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DirectionsRailway", "Landroidx/compose/material/icons/Icons$Outlined;", "getDirectionsRailway", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DirectionsRailwayKt {
    private static ImageVector _directionsRailway;

    static {
    }

    public static final ImageVector getDirectionsRailway(Outlined arg19) {
        ImageVector v0 = DirectionsRailwayKt._directionsRailway;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.DirectionsRailway", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 1f);
        v12.curveToRelative(-4.42f, 0f, -8f, 0.5f, -8f, 4f);
        v12.verticalLineToRelative(10.5f);
        v12.curveTo(4f, 17.43f, 5.57f, 19f, 7.5f, 19f);
        v12.lineTo(6f, 20.5f);
        v12.verticalLineToRelative(0.5f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineToRelative(-0.5f);
        v12.lineTo(16.5f, 19f);
        v12.curveToRelative(1.93f, 0f, 3.5f, -1.57f, 3.5f, -3.5f);
        v12.lineTo(20f, 5f);
        v12.curveToRelative(0f, -3.5f, -3.58f, -4f, -8f, -4f);
        v12.close();
        v12.moveTo(12f, 3f);
        v12.curveToRelative(6f, 0f, 6f, 1.2f, 6f, 2f);
        v12.lineTo(6f, 5f);
        v12.curveToRelative(0f, -0.8f, 0f, -2f, 6f, -2f);
        v12.close();
        v12.moveTo(18f, 7f);
        v12.verticalLineToRelative(3f);
        v12.lineTo(6f, 10f);
        v12.lineTo(6f, 7f);
        v12.horizontalLineToRelative(12f);
        v12.close();
        v12.moveTo(16.5f, 17f);
        v12.horizontalLineToRelative(-9f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f);
        v12.lineTo(6f, 12f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineToRelative(3.5f);
        v12.curveToRelative(0f, 0.83f, -0.67f, 1.5f, -1.5f, 1.5f);
        v12.close();
        v12.moveTo(12f, 12.5f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveToRelative(0.9f, 2f, 2f, 2f);
        v12.reflectiveCurveToRelative(2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveToRelative(-0.9f, -2f, -2f, -2f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DirectionsRailwayKt._directionsRailway = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

