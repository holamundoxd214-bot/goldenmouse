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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_gpsNotFixed", "Landroidx/compose/ui/graphics/vector/ImageVector;", "GpsNotFixed", "Landroidx/compose/material/icons/Icons$Filled;", "getGpsNotFixed", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class GpsNotFixedKt {
    private static ImageVector _gpsNotFixed;

    static {
    }

    public static final ImageVector getGpsNotFixed(Filled arg19) {
        ImageVector v0 = GpsNotFixedKt._gpsNotFixed;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.GpsNotFixed", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.940001f, 11f);
        v12.curveToRelative(-0.46f, -4.17f, -3.77f, -7.48f, -7.94f, -7.94f);
        v12.verticalLineTo(1f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2.06f);
        v12.curveTo(6.83f, 3.52f, 3.52f, 6.83f, 3.06f, 11f);
        v12.horizontalLineTo(1f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2.06f);
        v12.curveToRelative(0.46f, 4.17f, 3.77f, 7.48f, 7.94f, 7.94f);
        v12.verticalLineTo(23f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-2.06f);
        v12.curveToRelative(4.17f, -0.46f, 7.48f, -3.77f, 7.94f, -7.94f);
        v12.horizontalLineTo(23f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-2.06f);
        v12.close();
        v12.moveTo(12f, 19f);
        v12.curveToRelative(-3.87f, 0f, -7f, -3.13f, -7f, -7f);
        v12.reflectiveCurveToRelative(3.13f, -7f, 7f, -7f);
        v12.reflectiveCurveToRelative(7f, 3.13f, 7f, 7f);
        v12.reflectiveCurveToRelative(-3.13f, 7f, -7f, 7f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        GpsNotFixedKt._gpsNotFixed = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

