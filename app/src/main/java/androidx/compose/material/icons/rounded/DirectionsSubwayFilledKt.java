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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_directionsSubwayFilled", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DirectionsSubwayFilled", "Landroidx/compose/material/icons/Icons$Rounded;", "getDirectionsSubwayFilled", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DirectionsSubwayFilledKt {
    private static ImageVector _directionsSubwayFilled;

    static {
    }

    public static final ImageVector getDirectionsSubwayFilled(Rounded arg19) {
        ImageVector v0 = DirectionsSubwayFilledKt._directionsSubwayFilled;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.DirectionsSubwayFilled", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveTo(8f, 2f, 4f, 2.5f, 4f, 6f);
        v12.verticalLineToRelative(9.5f);
        v12.curveTo(4f, 17.43f, 5.57f, 19f, 7.5f, 19f);
        v12.lineToRelative(-1.21f, 0.81f);
        v12.curveTo(6.11f, 19.93f, 6f, 20.129999f, 6f, 20.35f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(6f, 20.709999f, 6.29f, 21f, 6.65f, 21f);
        v12.horizontalLineToRelative(10.7f);
        v12.curveToRelative(0.36f, 0f, 0.65f, -0.29f, 0.65f, -0.65f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.22f, -0.11f, -0.42f, -0.29f, -0.54f);
        v12.lineTo(16.5f, 19f);
        v12.curveToRelative(1.93f, 0f, 3.5f, -1.57f, 3.5f, -3.5f);
        v12.verticalLineTo(6f);
        v12.curveTo(20f, 2.5f, 16.42f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(8.5f, 16f);
        v12.curveTo(7.67f, 16f, 7f, 15.33f, 7f, 14.5f);
        v12.reflectiveCurveTo(7.67f, 13f, 8.5f, 13f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveTo(9.33f, 16f, 8.5f, 16f);
        v12.close();
        v12.moveTo(11f, 10f);
        v12.horizontalLineTo(6f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineTo(10f);
        v12.close();
        v12.moveTo(15.5f, 16f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f);
        v12.reflectiveCurveToRelative(0.67f, -1.5f, 1.5f, -1.5f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveTo(16.33f, 16f, 15.5f, 16f);
        v12.close();
        v12.moveTo(18f, 10f);
        v12.horizontalLineToRelative(-5f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineTo(10f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DirectionsSubwayFilledKt._directionsSubwayFilled = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

