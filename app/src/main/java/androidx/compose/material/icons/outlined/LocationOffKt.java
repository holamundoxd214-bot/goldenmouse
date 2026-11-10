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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_locationOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LocationOff", "Landroidx/compose/material/icons/Icons$Outlined;", "getLocationOff", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LocationOffKt {
    private static ImageVector _locationOff;

    static {
    }

    public static final ImageVector getLocationOff(Outlined arg19) {
        ImageVector v0 = LocationOffKt._locationOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.LocationOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 4f);
        v12.curveToRelative(2.76f, 0f, 5f, 2.24f, 5f, 5f);
        v12.curveToRelative(0f, 1.06f, -0.39f, 2.32f, -1f, 3.62f);
        v12.lineToRelative(1.49f, 1.49f);
        v12.curveTo(18.370001f, 12.36f, 19f, 10.57f, 19f, 9f);
        v12.curveToRelative(0f, -3.87f, -3.13f, -7f, -7f, -7f);
        v12.curveToRelative(-1.84f, 0f, -3.5f, 0.71f, -4.75f, 1.86f);
        v12.lineToRelative(1.43f, 1.43f);
        v12.curveTo(9.56f, 4.5f, 10.72f, 4f, 12f, 4f);
        v12.close();
        v12.moveTo(12f, 6.5f);
        v12.curveToRelative(-0.59f, 0f, -1.13f, 0.21f, -1.56f, 0.56f);
        v12.lineToRelative(3.5f, 3.5f);
        v12.curveToRelative(0.35f, -0.43f, 0.56f, -0.97f, 0.56f, -1.56f);
        v12.curveToRelative(0f, -1.38f, -1.12f, -2.5f, -2.5f, -2.5f);
        v12.close();
        v12.moveTo(3.41f, 2.86f);
        v12.lineTo(2f, 4.27f);
        v12.lineToRelative(3.18f, 3.18f);
        v12.curveTo(5.07f, 7.95f, 5f, 8.47f, 5f, 9f);
        v12.curveToRelative(0f, 5.25f, 7f, 13f, 7f, 13f);
        v12.reflectiveCurveToRelative(1.67f, -1.85f, 3.38f, -4.35f);
        v12.lineTo(18.73f, 21f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(3.41f, 2.86f);
        v12.close();
        v12.moveTo(12f, 18.879999f);
        v12.curveToRelative(-2.01f, -2.58f, -4.8f, -6.74f, -4.98f, -9.59f);
        v12.lineToRelative(6.92f, 6.92f);
        v12.curveToRelative(-0.65f, 0.98f, -1.33f, 1.89f, -1.94f, 2.67f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LocationOffKt._locationOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

