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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_airlineSeatLegroomExtra", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AirlineSeatLegroomExtra", "Landroidx/compose/material/icons/Icons$Rounded;", "getAirlineSeatLegroomExtra", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AirlineSeatLegroomExtraKt {
    private static ImageVector _airlineSeatLegroomExtra;

    static {
    }

    public static final ImageVector getAirlineSeatLegroomExtra(Rounded arg19) {
        ImageVector v0 = AirlineSeatLegroomExtraKt._airlineSeatLegroomExtra;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.AirlineSeatLegroomExtra", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4f, 12f);
        v12.lineTo(4f, 4f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(8f);
        v12.curveToRelative(0f, 2.76f, 2.24f, 5f, 5f, 5f);
        v12.horizontalLineToRelative(5f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.lineTo(7f, 15f);
        v12.curveToRelative(-1.66f, 0f, -3f, -1.34f, -3f, -3f);
        v12.close();
        v12.moveTo(22.83f, 17.24f);
        v12.curveToRelative(-0.38f, -0.72f, -1.29f, -0.97f, -2.03f, -0.63f);
        v12.lineToRelative(-1.09f, 0.5f);
        v12.lineToRelative(-3.41f, -6.98f);
        v12.curveTo(15.96f, 9.45f, 15.27f, 9f, 14.51f, 9f);
        v12.lineTo(11f, 9f);
        v12.lineTo(11f, 3f);
        v12.lineTo(5f, 3f);
        v12.verticalLineToRelative(8f);
        v12.curveToRelative(0f, 1.66f, 1.34f, 3f, 3f, 3f);
        v12.horizontalLineToRelative(7f);
        v12.lineToRelative(2.56f, 5.25f);
        v12.curveToRelative(0.48f, 0.98f, 1.64f, 1.39f, 2.63f, 0.94f);
        v12.lineToRelative(1.95f, -0.89f);
        v12.curveToRelative(0.76f, -0.36f, 1.09f, -1.3f, 0.69f, -2.06f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AirlineSeatLegroomExtraKt._airlineSeatLegroomExtra = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

