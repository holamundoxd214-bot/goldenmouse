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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_micExternalOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MicExternalOff", "Landroidx/compose/material/icons/Icons$Outlined;", "getMicExternalOff", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MicExternalOffKt {
    private static ImageVector _micExternalOff;

    static {
    }

    public static final ImageVector getMicExternalOff(Outlined arg19) {
        ImageVector v0 = MicExternalOffKt._micExternalOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.MicExternalOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10f, 5f);
        v12.curveToRelative(0f, -1.66f, -1.34f, -3f, -3f, -3f);
        v12.curveTo(6.38f, 2f, 5.81f, 2.19f, 5.33f, 2.5f);
        v12.lineToRelative(4.15f, 4.15f);
        v12.curveTo(9.8f, 6.18f, 10f, 5.61f, 10f, 5f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(14f, 6f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.9f, 2f, 2f);
        v12.verticalLineToRelative(9.17f);
        v12.lineToRelative(2f, 2f);
        v12.verticalLineTo(6f);
        v12.curveToRelative(0f, -2.21f, -1.79f, -4f, -4f, -4f);
        v12.reflectiveCurveToRelative(-4f, 1.79f, -4f, 4f);
        v12.verticalLineToRelative(3.17f);
        v12.lineToRelative(2f, 2f);
        v12.verticalLineTo(6f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(2.1f, 2.1f);
        v12.lineTo(0.69f, 3.51f);
        v12.lineTo(5.17f, 8f);
        v12.horizontalLineTo(4f);
        v12.lineToRelative(1f, 10f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(0f, 2.21f, 1.79f, 4f, 4f, 4f);
        v12.reflectiveCurveToRelative(4f, -1.79f, 4f, -4f);
        v12.verticalLineToRelative(-1.17f);
        v12.lineToRelative(6.49f, 6.49f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(2.1f, 2.1f);
        v12.close();
        v12.moveTo(7.19f, 16f);
        v12.horizontalLineTo(6.81f);
        v12.lineToRelative(-0.6f, -6f);
        v12.horizontalLineToRelative(0.96f);
        v12.lineToRelative(0.56f, 0.56f);
        v12.lineTo(7.19f, 16f);
        v12.close();
        v12.moveTo(12f, 18f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveToRelative(-2f, -0.9f, -2f, -2f);
        v12.horizontalLineToRelative(1f);
        v12.lineToRelative(0.56f, -5.61f);
        v12.lineTo(12f, 14.83f);
        v12.verticalLineTo(18f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MicExternalOffKt._micExternalOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

