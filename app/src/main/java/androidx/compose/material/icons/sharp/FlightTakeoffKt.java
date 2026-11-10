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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_flightTakeoff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FlightTakeoff", "Landroidx/compose/material/icons/Icons$Sharp;", "getFlightTakeoff", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FlightTakeoffKt {
    private static ImageVector _flightTakeoff;

    static {
    }

    public static final ImageVector getFlightTakeoff(Sharp arg19) {
        ImageVector v0 = FlightTakeoffKt._flightTakeoff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.FlightTakeoff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.moveTo(22.07f, 9.64f);
        v12.curveToRelative(-0.21f, -0.8f, -1.04f, -1.28f, -1.84f, -1.06f);
        v12.lineTo(14.92f, 10f);
        v12.lineToRelative(-6.9f, -6.43f);
        v12.lineToRelative(-1.93f, 0.51f);
        v12.lineToRelative(4.14f, 7.17f);
        v12.lineToRelative(-4.97f, 1.33f);
        v12.lineToRelative(-1.97f, -1.54f);
        v12.lineToRelative(-1.45f, 0.39f);
        v12.lineToRelative(1.82f, 3.16f);
        v12.lineToRelative(0.77f, 1.33f);
        v12.lineTo(21f, 11.49f);
        v12.curveToRelative(0.81f, -0.23f, 1.28f, -1.05f, 1.07f, -1.85f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FlightTakeoffKt._flightTakeoff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

