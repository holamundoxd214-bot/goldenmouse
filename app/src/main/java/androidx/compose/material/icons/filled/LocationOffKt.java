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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_locationOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LocationOff", "Landroidx/compose/material/icons/Icons$Filled;", "getLocationOff", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LocationOffKt {
    private static ImageVector _locationOff;

    static {
    }

    public static final ImageVector getLocationOff(Filled arg19) {
        ImageVector v0 = LocationOffKt._locationOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.LocationOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 6.5f);
        v12.curveToRelative(1.38f, 0f, 2.5f, 1.12f, 2.5f, 2.5f);
        v12.curveToRelative(0f, 0.74f, -0.33f, 1.39f, -0.83f, 1.85f);
        v12.lineToRelative(3.63f, 3.63f);
        v12.curveToRelative(0.98f, -1.86f, 1.7f, -3.8f, 1.7f, -5.48f);
        v12.curveToRelative(0f, -3.87f, -3.13f, -7f, -7f, -7f);
        v12.curveToRelative(-1.98f, 0f, -3.76f, 0.83f, -5.04f, 2.15f);
        v12.lineToRelative(3.19f, 3.19f);
        v12.curveToRelative(0.46f, -0.52f, 1.11f, -0.84f, 1.85f, -0.84f);
        v12.close();
        v12.moveTo(16.370001f, 16.1f);
        v12.lineToRelative(-4.63f, -4.63f);
        v12.lineToRelative(-0.11f, -0.11f);
        v12.lineTo(3.27f, 3f);
        v12.lineTo(2f, 4.27f);
        v12.lineToRelative(3.18f, 3.18f);
        v12.curveTo(5.07f, 7.95f, 5f, 8.47f, 5f, 9f);
        v12.curveToRelative(0f, 5.25f, 7f, 13f, 7f, 13f);
        v12.reflectiveCurveToRelative(1.67f, -1.85f, 3.38f, -4.35f);
        v12.lineTo(18.73f, 21f);
        v12.lineTo(20f, 19.73f);
        v12.lineToRelative(-3.63f, -3.63f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LocationOffKt._locationOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

