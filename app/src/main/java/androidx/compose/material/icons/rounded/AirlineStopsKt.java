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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_airlineStops", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AirlineStops", "Landroidx/compose/material/icons/Icons$Rounded;", "getAirlineStops", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AirlineStopsKt {
    private static ImageVector _airlineStops;

    static {
    }

    public static final ImageVector getAirlineStops(Rounded arg19) {
        ImageVector v0 = AirlineStopsKt._airlineStops;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.AirlineStops", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15f, 18f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineToRelative(-4f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(-0.47f, -4.21f, -3.89f, -7.55f, -8.12f, -7.96f);
        v12.curveTo(2.37f, 8.99f, 2f, 8.56f, 2f, 8.05f);
        v12.curveToRelative(0f, -0.59f, 0.52f, -1.06f, 1.11f, -1f);
        v12.curveTo(7.03f, 7.44f, 10.37f, 9.87f, 12f, 13.3f);
        v12.curveToRelative(1.13f, -2.43f, 2.99f, -4.25f, 4.78f, -5.52f);
        v12.lineToRelative(-1.92f, -1.92f);
        v12.curveTo(14.54f, 5.54f, 14.76f, 5f, 15.21f, 5f);
        v12.horizontalLineToRelative(5.29f);
        v12.curveTo(20.780001f, 5f, 21f, 5.22f, 21f, 5.5f);
        v12.verticalLineToRelative(5.29f);
        v12.curveToRelative(0f, 0.45f, -0.54f, 0.67f, -0.85f, 0.35f);
        v12.lineToRelative(-1.94f, -1.94f);
        v12.curveTo(15.93f, 10.78f, 13.45f, 13.3f, 13f, 17f);
        v12.horizontalLineToRelative(1f);
        v12.curveTo(14.55f, 17f, 15f, 17.450001f, 15f, 18f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AirlineStopsKt._airlineStops = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

