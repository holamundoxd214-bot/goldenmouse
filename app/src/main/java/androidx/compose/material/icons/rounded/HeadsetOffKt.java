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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_headsetOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "HeadsetOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getHeadsetOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HeadsetOffKt {
    private static ImageVector _headsetOff;

    static {
    }

    public static final ImageVector getHeadsetOff(Rounded arg19) {
        ImageVector v0 = HeadsetOffKt._headsetOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.HeadsetOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 4f);
        v12.curveToRelative(3.87f, 0f, 7f, 3.13f, 7f, 7f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(-2f);
        v12.curveToRelative(-0.6f, 0f, -1.13f, 0.27f, -1.49f, 0.68f);
        v12.lineTo(21f, 18.17f);
        v12.verticalLineTo(11f);
        v12.curveToRelative(0f, -4.97f, -4.03f, -9f, -9f, -9f);
        v12.curveTo(9.98f, 2f, 8.12f, 2.67f, 6.62f, 3.8f);
        v12.lineToRelative(1.43f, 1.43f);
        v12.curveTo(9.17f, 4.45f, 10.53f, 4f, 12f, 4f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(21.190001f, 21.190001f);
        v12.lineTo(2.81f, 2.81f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.curveTo(1f, 3.2f, 1f, 3.83f, 1.39f, 4.22f);
        v12.lineToRelative(2.63f, 2.63f);
        v12.curveTo(3.37f, 8.09f, 3f, 9.5f, 3f, 11f);
        v12.verticalLineToRelative(7f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(-4f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineTo(5f);
        v12.verticalLineToRelative(-1f);
        v12.curveToRelative(0f, -0.94f, 0.19f, -1.83f, 0.52f, -2.65f);
        v12.lineTo(15f, 17.83f);
        v12.verticalLineTo(18f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(0.17f);
        v12.lineToRelative(1f, 1f);
        v12.horizontalLineTo(13f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(6f);
        v12.curveToRelative(0.36f, 0f, 0.68f, -0.1f, 0.97f, -0.26f);
        v12.curveToRelative(0.38f, 0.23f, 0.89f, 0.2f, 1.22f, -0.13f);
        v12.curveTo(21.58f, 22.219999f, 21.58f, 21.58f, 21.190001f, 21.190001f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HeadsetOffKt._headsetOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

