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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_screenRotationAlt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ScreenRotationAlt", "Landroidx/compose/material/icons/Icons$Rounded;", "getScreenRotationAlt", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ScreenRotationAltKt {
    private static ImageVector _screenRotationAlt;

    static {
    }

    public static final ImageVector getScreenRotationAlt(Rounded arg19) {
        ImageVector v0 = ScreenRotationAltKt._screenRotationAlt;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.ScreenRotationAlt", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.530001f, 9.29f);
        v12.curveTo(19.16f, 9.92f, 18.709999f, 11f, 17.82f, 11f);
        v12.curveToRelative(-0.27f, 0f, -0.52f, -0.11f, -0.71f, -0.29f);
        v12.lineTo(10.4f, 4f);
        v12.lineTo(5.41f, 9f);
        v12.horizontalLineTo(7f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f);
        v12.horizontalLineTo(3f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineTo(6f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(1.59f);
        v12.lineToRelative(5f, -5f);
        v12.curveToRelative(0.78f, -0.78f, 2.05f, -0.78f, 2.83f, 0f);
        v12.lineTo(18.530001f, 9.29f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(5.47f, 14.71f);
        v12.curveTo(4.84f, 14.08f, 5.29f, 13f, 6.18f, 13f);
        v12.curveToRelative(0.27f, 0f, 0.52f, 0.11f, 0.71f, 0.29f);
        v12.lineTo(13.6f, 20f);
        v12.lineToRelative(4.99f, -5f);
        v12.horizontalLineTo(17f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-1.59f);
        v12.lineToRelative(-5f, 5f);
        v12.curveToRelative(-0.78f, 0.78f, -2.05f, 0.78f, -2.83f, 0f);
        v12.lineTo(5.47f, 14.71f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ScreenRotationAltKt._screenRotationAlt = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

