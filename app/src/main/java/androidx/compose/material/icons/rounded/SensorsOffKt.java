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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sensorsOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SensorsOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getSensorsOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SensorsOffKt {
    private static ImageVector _sensorsOff;

    static {
    }

    public static final ImageVector getSensorsOff(Rounded arg19) {
        ImageVector v0 = SensorsOffKt._sensorsOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SensorsOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(5.68f, 18.32f);
        v12.curveToRelative(-0.42f, 0.42f, -1.12f, 0.39f, -1.5f, -0.08f);
        v12.curveTo(2.82f, 16.530001f, 2f, 14.36f, 2f, 12f);
        v12.curveToRelative(0f, -2.04f, 0.61f, -3.93f, 1.66f, -5.51f);
        v12.lineTo(2.1f, 4.93f);
        v12.curveToRelative(-0.39f, -0.39f, -0.39f, -1.02f, 0f, -1.41f);
        v12.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0f);
        v12.lineToRelative(16.969999f, 16.969999f);
        v12.curveToRelative(0.39f, 0.39f, 0.39f, 1.02f, 0f, 1.41f);
        v12.reflectiveCurveToRelative(-1.02f, 0.39f, -1.41f, 0f);
        v12.lineTo(8.14f, 10.96f);
        v12.curveTo(8.05f, 11.29f, 8f, 11.64f, 8f, 12f);
        v12.curveToRelative(0f, 0.8f, 0.24f, 1.55f, 0.64f, 2.17f);
        v12.curveToRelative(0.27f, 0.41f, 0.24f, 0.94f, -0.1f, 1.29f);
        v12.curveToRelative(-0.43f, 0.43f, -1.17f, 0.4f, -1.51f, -0.11f);
        v12.curveTo(6.38f, 14.4f, 6f, 13.24f, 6f, 12f);
        v12.curveToRelative(0f, -0.93f, 0.21f, -1.8f, 0.58f, -2.59f);
        v12.lineTo(5.11f, 7.94f);
        v12.curveTo(4.4f, 9.13f, 4f, 10.52f, 4f, 12f);
        v12.curveToRelative(0f, 1.89f, 0.66f, 3.63f, 1.76f, 5f);
        v12.curveTo(6.08f, 17.389999f, 6.04f, 17.959999f, 5.68f, 18.32f);
        v12.close();
        v12.moveTo(15.46f, 8.54f);
        v12.curveToRelative(-0.35f, 0.35f, -0.37f, 0.88f, -0.11f, 1.29f);
        v12.curveTo(15.76f, 10.45f, 16f, 11.2f, 16f, 12f);
        v12.curveToRelative(0f, 0.36f, -0.05f, 0.71f, -0.14f, 1.04f);
        v12.lineToRelative(1.55f, 1.55f);
        v12.curveTo(17.790001f, 13.8f, 18f, 12.93f, 18f, 12f);
        v12.curveToRelative(0f, -1.24f, -0.38f, -2.4f, -1.03f, -3.36f);
        v12.curveTo(16.629999f, 8.14f, 15.9f, 8.1f, 15.46f, 8.54f);
        v12.close();
        v12.moveTo(18.32f, 5.68f);
        v12.curveToRelative(-0.36f, 0.36f, -0.4f, 0.92f, -0.08f, 1.32f);
        v12.curveToRelative(1.1f, 1.37f, 1.76f, 3.11f, 1.76f, 5f);
        v12.curveToRelative(0f, 1.48f, -0.4f, 2.87f, -1.11f, 4.06f);
        v12.lineToRelative(1.45f, 1.45f);
        v12.curveTo(21.389999f, 15.93f, 22f, 14.04f, 22f, 12f);
        v12.curveToRelative(0f, -2.36f, -0.82f, -4.53f, -2.18f, -6.24f);
        v12.curveTo(19.440001f, 5.29f, 18.74f, 5.26f, 18.32f, 5.68f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SensorsOffKt._sensorsOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

