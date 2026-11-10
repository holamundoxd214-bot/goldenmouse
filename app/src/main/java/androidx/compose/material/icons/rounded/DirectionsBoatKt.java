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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_directionsBoat", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DirectionsBoat", "Landroidx/compose/material/icons/Icons$Rounded;", "getDirectionsBoat", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DirectionsBoatKt {
    private static ImageVector _directionsBoat;

    static {
    }

    public static final ImageVector getDirectionsBoat(Rounded arg19) {
        ImageVector v0 = DirectionsBoatKt._directionsBoat;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.DirectionsBoat", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 21f);
        v12.curveToRelative(-1.19f, 0f, -2.38f, -0.35f, -3.47f, -0.98f);
        v12.curveToRelative(-0.33f, -0.19f, -0.73f, -0.19f, -1.07f, 0f);
        v12.curveToRelative(-2.17f, 1.26f, -4.76f, 1.26f, -6.93f, 0f);
        v12.curveToRelative(-0.33f, -0.19f, -0.73f, -0.19f, -1.07f, 0f);
        v12.curveTo(6.38f, 20.65f, 5.19f, 21f, 4f, 21f);
        v12.horizontalLineTo(3f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(1.38f, 0f, 2.74f, -0.35f, 4f, -0.99f);
        v12.curveToRelative(2.52f, 1.29f, 5.48f, 1.29f, 8f, 0f);
        v12.curveToRelative(1.26f, 0.65f, 2.62f, 0.99f, 4f, 0.99f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(20f);
        v12.close();
        v12.moveTo(3.95f, 19f);
        v12.horizontalLineTo(4f);
        v12.curveToRelative(1.27f, 0f, 2.42f, -0.55f, 3.33f, -1.33f);
        v12.curveToRelative(0.39f, -0.34f, 0.95f, -0.34f, 1.34f, 0f);
        v12.curveTo(9.58f, 18.450001f, 10.73f, 19f, 12f, 19f);
        v12.reflectiveCurveToRelative(2.42f, -0.55f, 3.33f, -1.33f);
        v12.curveToRelative(0.39f, -0.34f, 0.95f, -0.34f, 1.34f, 0f);
        v12.curveTo(17.58f, 18.450001f, 18.73f, 19f, 20f, 19f);
        v12.horizontalLineToRelative(0.05f);
        v12.lineToRelative(1.9f, -6.68f);
        v12.curveToRelative(0.11f, -0.37f, 0.04f, -1.06f, -0.66f, -1.28f);
        v12.lineTo(20f, 10.62f);
        v12.verticalLineTo(6f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineTo(2f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-4f);
        v12.curveTo(9.45f, 1f, 9f, 1.45f, 9f, 2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(6f);
        v12.curveTo(4.9f, 4f, 4f, 4.9f, 4f, 6f);
        v12.verticalLineToRelative(4.62f);
        v12.lineToRelative(-1.29f, 0.42f);
        v12.curveToRelative(-0.63f, 0.19f, -0.81f, 0.84f, -0.66f, 1.28f);
        v12.lineTo(3.95f, 19f);
        v12.close();
        v12.moveTo(6f, 6f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineToRelative(3.97f);
        v12.lineTo(12.62f, 8.2f);
        v12.curveToRelative(-0.41f, -0.13f, -0.84f, -0.13f, -1.25f, 0f);
        v12.lineTo(6f, 9.97f);
        v12.verticalLineTo(6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DirectionsBoatKt._directionsBoat = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

