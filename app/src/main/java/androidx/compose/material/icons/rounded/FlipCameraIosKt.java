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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_flipCameraIos", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FlipCameraIos", "Landroidx/compose/material/icons/Icons$Rounded;", "getFlipCameraIos", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FlipCameraIosKt {
    private static ImageVector _flipCameraIos;

    static {
    }

    public static final ImageVector getFlipCameraIos(Rounded arg19) {
        ImageVector v0 = FlipCameraIosKt._flipCameraIos;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.FlipCameraIos", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.curveToRelative(-0.56f, 0f, -1.1f, 0.24f, -1.48f, 0.65f);
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
        v12.moveTo(13.67f, 17.700001f);
        v12.curveTo(13.15f, 17.889999f, 12.59f, 18f, 12f, 18f);
        v12.curveToRelative(-2.76f, 0f, -5f, -2.24f, -5f, -5f);
        v12.horizontalLineTo(5f);
        v12.lineToRelative(2.5f, -2.5f);
        v12.lineTo(10f, 13f);
        v12.horizontalLineTo(8f);
        v12.curveToRelative(0f, 2.21f, 1.79f, 4f, 4f, 4f);
        v12.curveToRelative(0.46f, 0f, 0.91f, -0.08f, 1.32f, -0.23f);
        v12.curveToRelative(0.19f, -0.07f, 0.39f, -0.03f, 0.53f, 0.11f);
        v12.curveTo(14.11f, 17.139999f, 14.01f, 17.57f, 13.67f, 17.700001f);
        v12.close();
        v12.moveTo(16.5f, 15.5f);
        v12.lineTo(14f, 13f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0f, -2.21f, -1.79f, -4f, -4f, -4f);
        v12.curveToRelative(-0.46f, 0f, -0.91f, 0.08f, -1.32f, 0.23f);
        v12.curveToRelative(-0.19f, 0.07f, -0.39f, 0.03f, -0.53f, -0.11f);
        v12.curveTo(9.89f, 8.86f, 9.99f, 8.43f, 10.33f, 8.3f);
        v12.curveTo(10.85f, 8.11f, 11.41f, 8f, 12f, 8f);
        v12.curveToRelative(2.76f, 0f, 5f, 2.24f, 5f, 5f);
        v12.horizontalLineToRelative(2f);
        v12.lineTo(16.5f, 15.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FlipCameraIosKt._flipCameraIos = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

