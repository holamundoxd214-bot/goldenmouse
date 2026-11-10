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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_shutterSpeed", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ShutterSpeed", "Landroidx/compose/material/icons/Icons$Rounded;", "getShutterSpeed", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ShutterSpeedKt {
    private static ImageVector _shutterSpeed;

    static {
    }

    public static final ImageVector getShutterSpeed(Rounded arg19) {
        ImageVector v0 = ShutterSpeedKt._shutterSpeed;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.ShutterSpeed", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10f, 3f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-4f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.close();
        v12.moveTo(19.030001f, 7.39f);
        v12.lineToRelative(0.75f, -0.75f);
        v12.curveToRelative(0.38f, -0.38f, 0.39f, -1.01f, 0f, -1.4f);
        v12.lineToRelative(-0.01f, -0.01f);
        v12.curveToRelative(-0.39f, -0.39f, -1.01f, -0.38f, -1.4f, 0f);
        v12.lineToRelative(-0.75f, 0.75f);
        v12.curveTo(16.07f, 4.74f, 14.12f, 4f, 12f, 4f);
        v12.curveToRelative(-4.8f, 0f, -8.88f, 3.96f, -9f, 8.76f);
        v12.curveTo(2.87f, 17.84f, 6.94f, 22f, 12f, 22f);
        v12.curveToRelative(4.98f, 0f, 9f, -4.03f, 9f, -9f);
        v12.curveToRelative(0f, -2.12f, -0.74f, -4.07f, -1.97f, -5.61f);
        v12.close();
        v12.moveTo(12f, 20f);
        v12.curveToRelative(-3.87f, 0f, -7f, -3.13f, -7f, -7f);
        v12.reflectiveCurveToRelative(3.13f, -7f, 7f, -7f);
        v12.reflectiveCurveToRelative(7f, 3.13f, 7f, 7f);
        v12.reflectiveCurveToRelative(-3.13f, 7f, -7f, 7f);
        v12.close();
        v12.moveTo(10.81f, 15f);
        v12.horizontalLineToRelative(-3.7f);
        v12.curveToRelative(-0.38f, 0f, -0.62f, 0.4f, -0.45f, 0.74f);
        v12.curveToRelative(0.56f, 1.12f, 1.44f, 2.01f, 2.57f, 2.57f);
        v12.curveToRelative(0.23f, 0.11f, 0.52f, 0.02f, 0.65f, -0.21f);
        v12.lineToRelative(1.37f, -2.35f);
        v12.curveToRelative(0.19f, -0.33f, -0.05f, -0.75f, -0.44f, -0.75f);
        v12.close();
        v12.moveTo(14.73f, 7.65f);
        v12.curveToRelative(-0.23f, -0.12f, -0.52f, -0.02f, -0.65f, 0.2f);
        v12.lineToRelative(-1.38f, 2.39f);
        v12.curveToRelative(-0.2f, 0.34f, 0.04f, 0.76f, 0.43f, 0.76f);
        v12.horizontalLineToRelative(3.76f);
        v12.curveToRelative(0.38f, 0f, 0.62f, -0.4f, 0.45f, -0.73f);
        v12.curveToRelative(-0.58f, -1.13f, -1.49f, -2.04f, -2.61f, -2.62f);
        v12.close();
        v12.moveTo(13.88f, 14.7f);
        v12.curveToRelative(-0.19f, -0.34f, -0.68f, -0.35f, -0.87f, -0.01f);
        v12.lineToRelative(-2.04f, 3.52f);
        v12.curveToRelative(-0.18f, 0.32f, 0.02f, 0.72f, 0.39f, 0.75f);
        v12.curveToRelative(1.34f, 0.14f, 2.69f, -0.18f, 3.83f, -0.89f);
        v12.curveToRelative(0.22f, -0.14f, 0.28f, -0.43f, 0.16f, -0.66f);
        v12.lineToRelative(-1.47f, -2.71f);
        v12.close();
        v12.moveTo(10.31f, 13.23f);
        v12.lineTo(7.93f, 9.57f);
        v12.curveToRelative(-0.2f, -0.3f, -0.64f, -0.3f, -0.84f, 0f);
        v12.curveToRelative(-0.81f, 1.16f, -1.17f, 2.57f, -1.05f, 3.98f);
        v12.curveToRelative(0.02f, 0.26f, 0.24f, 0.45f, 0.5f, 0.45f);
        v12.horizontalLineToRelative(3.35f);
        v12.curveToRelative(0.39f, 0f, 0.63f, -0.44f, 0.42f, -0.77f);
        v12.close();
        v12.moveTo(13.97f, 12.74f);
        v12.lineToRelative(2.02f, 3.74f);
        v12.curveToRelative(0.18f, 0.33f, 0.64f, 0.35f, 0.86f, 0.05f);
        v12.curveToRelative(0.86f, -1.18f, 1.24f, -2.62f, 1.12f, -4.08f);
        v12.curveToRelative(-0.02f, -0.26f, -0.25f, -0.45f, -0.5f, -0.45f);
        v12.horizontalLineToRelative(-3.05f);
        v12.curveToRelative(-0.39f, 0f, -0.63f, 0.4f, -0.45f, 0.74f);
        v12.close();
        v12.moveTo(10.17f, 11.17f);
        v12.curveToRelative(0.2f, 0.31f, 0.66f, 0.3f, 0.85f, -0.02f);
        v12.lineToRelative(1.94f, -3.35f);
        v12.curveToRelative(0.19f, -0.32f, -0.03f, -0.72f, -0.4f, -0.76f);
        v12.curveToRelative(-1.36f, -0.12f, -2.73f, 0.21f, -3.88f, 0.97f);
        v12.curveToRelative(-0.22f, 0.15f, -0.27f, 0.46f, -0.13f, 0.68f);
        v12.lineToRelative(1.62f, 2.48f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ShutterSpeedKt._shutterSpeed = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

