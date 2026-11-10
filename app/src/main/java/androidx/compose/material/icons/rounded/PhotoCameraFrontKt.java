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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_photoCameraFront", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PhotoCameraFront", "Landroidx/compose/material/icons/Icons$Rounded;", "getPhotoCameraFront", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PhotoCameraFrontKt {
    private static ImageVector _photoCameraFront;

    static {
    }

    public static final ImageVector getPhotoCameraFront(Rounded arg19) {
        ImageVector v0 = PhotoCameraFrontKt._photoCameraFront;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.PhotoCameraFront", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 5f);
        v12.horizontalLineToRelative(-3.17f);
        v12.lineToRelative(-1.24f, -1.35f);
        v12.curveTo(15.22f, 3.24f, 14.68f, 3f, 14.12f, 3f);
        v12.horizontalLineTo(9.88f);
        v12.curveTo(9.32f, 3f, 8.78f, 3.24f, 8.41f, 3.65f);
        v12.lineTo(7.17f, 5f);
        v12.horizontalLineTo(4f);
        v12.curveTo(2.9f, 5f, 2f, 5.9f, 2f, 7f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(7f);
        v12.curveTo(22f, 5.9f, 21.1f, 5f, 20f, 5f);
        v12.close();
        v12.moveTo(12f, 9f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveToRelative(-2f, -0.9f, -2f, -2f);
        v12.curveTo(10f, 9.9f, 10.9f, 9f, 12f, 9f);
        v12.close();
        v12.moveTo(16f, 17f);
        v12.horizontalLineTo(8f);
        v12.verticalLineToRelative(-0.57f);
        v12.curveToRelative(0f, -0.81f, 0.48f, -1.53f, 1.22f, -1.85f);
        v12.curveTo(10.07f, 14.21f, 11.01f, 14f, 12f, 14f);
        v12.reflectiveCurveToRelative(1.93f, 0.21f, 2.78f, 0.58f);
        v12.curveTo(15.52f, 14.9f, 16f, 15.62f, 16f, 16.43f);
        v12.verticalLineTo(17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PhotoCameraFrontKt._photoCameraFront = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

