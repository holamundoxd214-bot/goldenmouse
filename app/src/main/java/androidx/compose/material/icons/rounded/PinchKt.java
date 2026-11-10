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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_pinch", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Pinch", "Landroidx/compose/material/icons/Icons$Rounded;", "getPinch", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PinchKt {
    private static ImageVector _pinch;

    static {
    }

    public static final ImageVector getPinch(Rounded arg19) {
        ImageVector v0 = PinchKt._pinch;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Pinch", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8.2f, 17.43f);
        v12.curveToRelative(0f, -0.65f, 0.6f, -1.13f, 1.24f, -0.99f);
        v12.lineTo(13f, 17.24f);
        v12.verticalLineTo(6.5f);
        v12.curveTo(13f, 5.67f, 13.67f, 5f, 14.5f, 5f);
        v12.reflectiveCurveTo(16f, 5.67f, 16f, 6.5f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(0.91f);
        v12.curveToRelative(0.31f, 0f, 0.62f, 0.07f, 0.89f, 0.21f);
        v12.lineToRelative(4.09f, 2.04f);
        v12.curveToRelative(0.77f, 0.38f, 1.21f, 1.22f, 1.09f, 2.07f);
        v12.lineToRelative(-0.63f, 4.46f);
        v12.curveTo(22.209999f, 22.27f, 21.360001f, 23f, 20.370001f, 23f);
        v12.horizontalLineToRelative(-6.16f);
        v12.curveToRelative(-0.53f, 0f, -1.29f, -0.21f, -1.66f, -0.59f);
        v12.lineToRelative(-4.07f, -4.29f);
        v12.curveTo(8.3f, 17.940001f, 8.2f, 17.690001f, 8.2f, 17.43f);
        v12.close();
        v12.moveTo(9.5f, 5.25f);
        v12.curveTo(9.5f, 5.66f, 9.84f, 6f, 10.25f, 6f);
        v12.reflectiveCurveTo(11f, 5.66f, 11f, 5.25f);
        v12.verticalLineTo(2f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(6.75f);
        v12.curveTo(6.34f, 1f, 6f, 1.34f, 6f, 1.75f);
        v12.reflectiveCurveTo(6.34f, 2.5f, 6.75f, 2.5f);
        v12.horizontalLineToRelative(1.69f);
        v12.lineTo(2.5f, 8.44f);
        v12.verticalLineTo(6.75f);
        v12.curveTo(2.5f, 6.34f, 2.16f, 6f, 1.75f, 6f);
        v12.reflectiveCurveTo(1f, 6.34f, 1f, 6.75f);
        v12.verticalLineTo(10f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(3.25f);
        v12.curveTo(5.66f, 11f, 6f, 10.66f, 6f, 10.25f);
        v12.reflectiveCurveTo(5.66f, 9.5f, 5.25f, 9.5f);
        v12.horizontalLineTo(3.56f);
        v12.lineTo(9.5f, 3.56f);
        v12.verticalLineTo(5.25f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PinchKt._pinch = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

