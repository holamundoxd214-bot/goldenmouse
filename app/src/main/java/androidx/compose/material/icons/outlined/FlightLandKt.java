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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_flightLand", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FlightLand", "Landroidx/compose/material/icons/Icons$Outlined;", "getFlightLand", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FlightLandKt {
    private static ImageVector _flightLand;

    static {
    }

    public static final ImageVector getFlightLand(Outlined arg19) {
        ImageVector v0 = FlightLandKt._flightLand;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.FlightLand", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(2.5f, 19f);
        v12.horizontalLineToRelative(19f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-19f);
        v12.verticalLineToRelative(-2f);
        v12.close();
        v12.moveTo(19.34f, 15.85f);
        v12.curveToRelative(0.8f, 0.21f, 1.62f, -0.26f, 1.84f, -1.06f);
        v12.curveToRelative(0.21f, -0.8f, -0.26f, -1.62f, -1.06f, -1.84f);
        v12.lineToRelative(-5.31f, -1.42f);
        v12.lineToRelative(-2.76f, -9.02f);
        v12.lineTo(10.12f, 2f);
        v12.verticalLineToRelative(8.28f);
        v12.lineTo(5.15f, 8.95f);
        v12.lineToRelative(-0.93f, -2.32f);
        v12.lineToRelative(-1.45f, -0.39f);
        v12.verticalLineToRelative(5.17f);
        v12.lineToRelative(16.57f, 4.44f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FlightLandKt._flightLand = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

