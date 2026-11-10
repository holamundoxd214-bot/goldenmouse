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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_radar", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Radar", "Landroidx/compose/material/icons/Icons$Rounded;", "getRadar", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RadarKt {
    private static ImageVector _radar;

    static {
    }

    public static final ImageVector getRadar(Rounded arg19) {
        ImageVector v0 = RadarKt._radar;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Radar", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.74f, 18.33f);
        v12.curveTo(21.15f, 16.6f, 22f, 14.4f, 22f, 12f);
        v12.curveToRelative(0f, -5.52f, -4.48f, -10f, -10f, -10f);
        v12.reflectiveCurveTo(2f, 6.48f, 2f, 12f);
        v12.reflectiveCurveToRelative(4.48f, 10f, 10f, 10f);
        v12.curveToRelative(2.4f, 0f, 4.6f, -0.85f, 6.33f, -2.26f);
        v12.curveToRelative(0.27f, -0.22f, 0.53f, -0.46f, 0.78f, -0.71f);
        v12.curveToRelative(0.03f, -0.03f, 0.05f, -0.06f, 0.07f, -0.08f);
        v12.curveTo(19.379999f, 18.75f, 19.57f, 18.540001f, 19.74f, 18.33f);
        v12.close();
        v12.moveTo(12f, 20f);
        v12.curveToRelative(-4.41f, 0f, -8f, -3.59f, -8f, -8f);
        v12.reflectiveCurveToRelative(3.59f, -8f, 8f, -8f);
        v12.reflectiveCurveToRelative(8f, 3.59f, 8f, 8f);
        v12.curveToRelative(0f, 1.85f, -0.63f, 3.54f, -1.69f, 4.9f);
        v12.lineToRelative(-1.43f, -1.43f);
        v12.curveToRelative(0.69f, -0.98f, 1.1f, -2.17f, 1.1f, -3.46f);
        v12.curveToRelative(0f, -3.31f, -2.69f, -6f, -6f, -6f);
        v12.reflectiveCurveToRelative(-6f, 2.69f, -6f, 6f);
        v12.reflectiveCurveToRelative(2.69f, 6f, 6f, 6f);
        v12.curveToRelative(1.3f, 0f, 2.51f, -0.42f, 3.49f, -1.13f);
        v12.lineToRelative(1.42f, 1.42f);
        v12.curveTo(15.54f, 19.370001f, 13.85f, 20f, 12f, 20f);
        v12.close();
        v12.moveTo(13.92f, 12.51f);
        v12.curveToRelative(0.17f, -0.66f, 0.02f, -1.38f, -0.49f, -1.9f);
        v12.lineToRelative(-0.02f, -0.02f);
        v12.curveToRelative(-0.77f, -0.77f, -2f, -0.78f, -2.78f, -0.04f);
        v12.curveToRelative(-0.01f, 0.01f, -0.03f, 0.02f, -0.05f, 0.04f);
        v12.curveToRelative(-0.78f, 0.78f, -0.78f, 2.05f, 0f, 2.83f);
        v12.lineToRelative(0.02f, 0.02f);
        v12.curveToRelative(0.52f, 0.51f, 1.25f, 0.67f, 1.91f, 0.49f);
        v12.lineToRelative(1.51f, 1.51f);
        v12.curveToRelative(-0.6f, 0.36f, -1.29f, 0.58f, -2.04f, 0.58f);
        v12.curveToRelative(-2.21f, 0f, -4f, -1.79f, -4f, -4f);
        v12.reflectiveCurveToRelative(1.79f, -4f, 4f, -4f);
        v12.reflectiveCurveToRelative(4f, 1.79f, 4f, 4f);
        v12.curveToRelative(0f, 0.73f, -0.21f, 1.41f, -0.56f, 2f);
        v12.lineTo(13.92f, 12.51f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RadarKt._radar = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

