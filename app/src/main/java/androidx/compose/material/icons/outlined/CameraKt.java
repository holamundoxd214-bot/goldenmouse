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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_camera", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Camera", "Landroidx/compose/material/icons/Icons$Outlined;", "getCamera", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CameraKt {
    private static ImageVector _camera;

    static {
    }

    public static final ImageVector getCamera(Outlined arg19) {
        ImageVector v0 = CameraKt._camera;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Camera", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14.25f, 2.26f);
        v12.lineToRelative(-0.08f, -0.04f);
        v12.lineToRelative(-0.01f, 0.02f);
        v12.curveTo(13.46f, 2.09f, 12.74f, 2f, 12f, 2f);
        v12.curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f);
        v12.reflectiveCurveToRelative(4.48f, 10f, 10f, 10f);
        v12.reflectiveCurveToRelative(10f, -4.48f, 10f, -10f);
        v12.curveToRelative(0f, -4.75f, -3.31f, -8.72f, -7.75f, -9.74f);
        v12.close();
        v12.moveTo(19.41f, 9f);
        v12.horizontalLineToRelative(-7.99f);
        v12.lineToRelative(2.71f, -4.7f);
        v12.curveToRelative(2.4f, 0.66f, 4.35f, 2.42f, 5.28f, 4.7f);
        v12.close();
        v12.moveTo(13.1f, 4.08f);
        v12.lineTo(10.27f, 9f);
        v12.lineToRelative(-1.15f, 2f);
        v12.lineTo(6.4f, 6.3f);
        v12.curveTo(7.84f, 4.88f, 9.82f, 4f, 12f, 4f);
        v12.curveToRelative(0.37f, 0f, 0.74f, 0.03f, 1.1f, 0.08f);
        v12.close();
        v12.moveTo(5.7f, 7.09f);
        v12.lineTo(8.54f, 12f);
        v12.lineToRelative(1.15f, 2f);
        v12.lineTo(4.26f, 14f);
        v12.curveTo(4.1f, 13.36f, 4f, 12.69f, 4f, 12f);
        v12.curveToRelative(0f, -1.85f, 0.64f, -3.55f, 1.7f, -4.91f);
        v12.close();
        v12.moveTo(4.59f, 15f);
        v12.horizontalLineToRelative(7.98f);
        v12.lineToRelative(-2.71f, 4.7f);
        v12.curveToRelative(-2.4f, -0.67f, -4.34f, -2.42f, -5.27f, -4.7f);
        v12.close();
        v12.moveTo(10.9f, 19.91f);
        v12.lineTo(14.89f, 13f);
        v12.lineToRelative(2.72f, 4.7f);
        v12.curveTo(16.16f, 19.120001f, 14.18f, 20f, 12f, 20f);
        v12.curveToRelative(-0.38f, 0f, -0.74f, -0.04f, -1.1f, -0.09f);
        v12.close();
        v12.moveTo(18.299999f, 16.91f);
        v12.lineToRelative(-4f, -6.91f);
        v12.horizontalLineToRelative(5.43f);
        v12.curveToRelative(0.17f, 0.64f, 0.27f, 1.31f, 0.27f, 2f);
        v12.curveToRelative(0f, 1.85f, -0.64f, 3.55f, -1.7f, 4.91f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CameraKt._camera = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

