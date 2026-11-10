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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_flightLand", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FlightLand", "Landroidx/compose/material/icons/Icons$Rounded;", "getFlightLand", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FlightLandKt {
    private static ImageVector _flightLand;

    static {
    }

    public static final ImageVector getFlightLand(Rounded arg19) {
        ImageVector v0 = FlightLandKt._flightLand;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.FlightLand", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.5f, 19f);
        v12.horizontalLineToRelative(-17f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(17f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.close();
        v12.moveTo(3.51f, 11.61f);
        v12.lineToRelative(15.83f, 4.24f);
        v12.curveToRelative(0.8f, 0.21f, 1.62f, -0.26f, 1.84f, -1.06f);
        v12.curveToRelative(0.21f, -0.8f, -0.26f, -1.62f, -1.06f, -1.84f);
        v12.lineToRelative(-5.31f, -1.42f);
        v12.lineToRelative(-2.58f, -8.45f);
        v12.curveToRelative(-0.11f, -0.36f, -0.39f, -0.63f, -0.75f, -0.73f);
        v12.curveToRelative(-0.68f, -0.18f, -1.35f, 0.33f, -1.35f, 1.04f);
        v12.verticalLineToRelative(6.88f);
        v12.lineTo(5.15f, 8.95f);
        v12.lineTo(4.4f, 7.09f);
        v12.curveToRelative(-0.12f, -0.29f, -0.36f, -0.51f, -0.67f, -0.59f);
        v12.lineToRelative(-0.33f, -0.09f);
        v12.curveToRelative(-0.32f, -0.09f, -0.63f, 0.15f, -0.63f, 0.48f);
        v12.verticalLineToRelative(3.75f);
        v12.curveToRelative(0f, 0.46f, 0.3f, 0.85f, 0.74f, 0.97f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FlightLandKt._flightLand = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

