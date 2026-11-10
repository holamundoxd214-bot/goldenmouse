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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_camera", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Camera", "Landroidx/compose/material/icons/Icons$Filled;", "getCamera", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CameraKt {
    private static ImageVector _camera;

    static {
    }

    public static final ImageVector getCamera(Filled arg19) {
        ImageVector v0 = CameraKt._camera;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Camera", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9.4f, 10.5f);
        v12.lineToRelative(4.77f, -8.26f);
        v12.curveTo(13.47f, 2.09f, 12.75f, 2f, 12f, 2f);
        v12.curveToRelative(-2.4f, 0f, -4.6f, 0.85f, -6.32f, 2.25f);
        v12.lineToRelative(3.66f, 6.35f);
        v12.lineToRelative(0.06f, -0.1f);
        v12.close();
        v12.moveTo(21.540001f, 9f);
        v12.curveToRelative(-0.92f, -2.92f, -3.15f, -5.26f, -6f, -6.34f);
        v12.lineTo(11.88f, 9f);
        v12.horizontalLineToRelative(9.66f);
        v12.close();
        v12.moveTo(21.799999f, 10f);
        v12.horizontalLineToRelative(-7.49f);
        v12.lineToRelative(0.29f, 0.5f);
        v12.lineToRelative(4.76f, 8.25f);
        v12.curveTo(21f, 16.969999f, 22f, 14.61f, 22f, 12f);
        v12.curveToRelative(0f, -0.69f, -0.07f, -1.35f, -0.2f, -2f);
        v12.close();
        v12.moveTo(8.54f, 12f);
        v12.lineToRelative(-3.9f, -6.75f);
        v12.curveTo(3.01f, 7.03f, 2f, 9.39f, 2f, 12f);
        v12.curveToRelative(0f, 0.69f, 0.07f, 1.35f, 0.2f, 2f);
        v12.horizontalLineToRelative(7.49f);
        v12.lineToRelative(-1.15f, -2f);
        v12.close();
        v12.moveTo(2.46f, 15f);
        v12.curveToRelative(0.92f, 2.92f, 3.15f, 5.26f, 6f, 6.34f);
        v12.lineTo(12.12f, 15f);
        v12.lineTo(2.46f, 15f);
        v12.close();
        v12.moveTo(13.73f, 15f);
        v12.lineToRelative(-3.9f, 6.76f);
        v12.curveToRelative(0.7f, 0.15f, 1.42f, 0.24f, 2.17f, 0.24f);
        v12.curveToRelative(2.4f, 0f, 4.6f, -0.85f, 6.32f, -2.25f);
        v12.lineToRelative(-3.66f, -6.35f);
        v12.lineToRelative(-0.93f, 1.6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CameraKt._camera = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

