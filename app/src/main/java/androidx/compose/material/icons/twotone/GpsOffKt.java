package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_gpsOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "GpsOff", "Landroidx/compose/material/icons/Icons$TwoTone;", "getGpsOff", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class GpsOffKt {
    private static ImageVector _gpsOff;

    static {
    }

    public static final ImageVector getGpsOff(TwoTone arg19) {
        ImageVector v0 = GpsOffKt._gpsOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.GpsOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.940001f, 11f);
        v12.curveToRelative(-0.46f, -4.17f, -3.77f, -7.48f, -7.94f, -7.94f);
        v12.lineTo(13f, 1f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2.06f);
        v12.curveToRelative(-0.98f, 0.11f, -1.91f, 0.38f, -2.77f, 0.78f);
        v12.lineToRelative(1.53f, 1.53f);
        v12.curveTo(10.46f, 5.13f, 11.22f, 5f, 12f, 5f);
        v12.curveToRelative(3.87f, 0f, 7f, 3.13f, 7f, 7f);
        v12.curveToRelative(0f, 0.79f, -0.13f, 1.54f, -0.37f, 2.24f);
        v12.lineToRelative(1.53f, 1.53f);
        v12.curveToRelative(0.4f, -0.86f, 0.67f, -1.79f, 0.78f, -2.77f);
        v12.lineTo(23f, 13f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-2.06f);
        v12.close();
        v12.moveTo(3f, 4.27f);
        v12.lineToRelative(2.04f, 2.04f);
        v12.curveTo(3.97f, 7.62f, 3.26f, 9.23f, 3.06f, 11f);
        v12.lineTo(1f, 11f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2.06f);
        v12.curveToRelative(0.46f, 4.17f, 3.77f, 7.48f, 7.94f, 7.94f);
        v12.lineTo(11f, 23f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-2.06f);
        v12.curveToRelative(1.77f, -0.2f, 3.38f, -0.91f, 4.69f, -1.98f);
        v12.lineTo(19.73f, 21f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(4.41f, 2.86f);
        v12.lineTo(3f, 4.27f);
        v12.close();
        v12.moveTo(16.27f, 17.540001f);
        v12.curveTo(15.09f, 18.450001f, 13.61f, 19f, 12f, 19f);
        v12.curveToRelative(-3.87f, 0f, -7f, -3.13f, -7f, -7f);
        v12.curveToRelative(0f, -1.61f, 0.55f, -3.09f, 1.46f, -4.27f);
        v12.lineToRelative(9.81f, 9.81f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        GpsOffKt._gpsOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

