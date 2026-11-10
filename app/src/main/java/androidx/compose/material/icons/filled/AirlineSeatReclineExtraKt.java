package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_airlineSeatReclineExtra", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AirlineSeatReclineExtra", "Landroidx/compose/material/icons/Icons$Filled;", "getAirlineSeatReclineExtra", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AirlineSeatReclineExtraKt {
    private static ImageVector _airlineSeatReclineExtra;

    static {
    }

    public static final ImageVector getAirlineSeatReclineExtra(Filled arg19) {
        ImageVector v0 = AirlineSeatReclineExtraKt._airlineSeatReclineExtra;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.AirlineSeatReclineExtra", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(5.35f, 5.64f);
        v12.curveToRelative(-0.9f, -0.64f, -1.12f, -1.88f, -0.49f, -2.79f);
        v12.curveToRelative(0.63f, -0.9f, 1.88f, -1.12f, 2.79f, -0.49f);
        v12.curveToRelative(0.9f, 0.64f, 1.12f, 1.88f, 0.49f, 2.79f);
        v12.curveToRelative(-0.64f, 0.9f, -1.88f, 1.12f, -2.79f, 0.49f);
        v12.close();
        v12.moveTo(16f, 19f);
        v12.lineTo(8.93f, 19f);
        v12.curveToRelative(-1.48f, 0f, -2.74f, -1.08f, -2.96f, -2.54f);
        v12.lineTo(4f, 7f);
        v12.lineTo(2f, 7f);
        v12.lineToRelative(1.99f, 9.76f);
        v12.curveTo(4.37f, 19.200001f, 6.47f, 21f, 8.94f, 21f);
        v12.lineTo(16f, 21f);
        v12.verticalLineToRelative(-2f);
        v12.close();
        v12.moveTo(16.23f, 15f);
        v12.horizontalLineToRelative(-4.88f);
        v12.lineToRelative(-1.03f, -4.1f);
        v12.curveToRelative(1.58f, 0.89f, 3.28f, 1.54f, 5.15f, 1.22f);
        v12.lineTo(15.47f, 9.99f);
        v12.curveToRelative(-1.63f, 0.31f, -3.44f, -0.27f, -4.69f, -1.25f);
        v12.lineTo(9.14f, 7.47f);
        v12.curveToRelative(-0.23f, -0.18f, -0.49f, -0.3f, -0.76f, -0.38f);
        v12.curveToRelative(-0.32f, -0.09f, -0.66f, -0.12f, -0.99f, -0.06f);
        v12.horizontalLineToRelative(-0.02f);
        v12.curveToRelative(-1.23f, 0.22f, -2.05f, 1.39f, -1.84f, 2.61f);
        v12.lineToRelative(1.35f, 5.92f);
        v12.curveTo(7.16f, 16.98f, 8.39f, 18f, 9.83f, 18f);
        v12.horizontalLineToRelative(6.85f);
        v12.lineToRelative(3.82f, 3f);
        v12.lineToRelative(1.5f, -1.5f);
        v12.lineToRelative(-5.77f, -4.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AirlineSeatReclineExtraKt._airlineSeatReclineExtra = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

