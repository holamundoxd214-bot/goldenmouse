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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_thumbDownOffAlt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ThumbDownOffAlt", "Landroidx/compose/material/icons/Icons$Rounded;", "getThumbDownOffAlt", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ThumbDownOffAltKt {
    private static ImageVector _thumbDownOffAlt;

    static {
    }

    public static final ImageVector getThumbDownOffAlt(Rounded arg19) {
        ImageVector v0 = ThumbDownOffAltKt._thumbDownOffAlt;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.ThumbDownOffAlt", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14.99f, 3f);
        v12.horizontalLineTo(6f);
        v12.curveTo(5.2f, 3f, 4.48f, 3.48f, 4.17f, 4.21f);
        v12.lineToRelative(-3.26f, 7.61f);
        v12.curveTo(0.06f, 13.8f, 1.51f, 16f, 3.66f, 16f);
        v12.horizontalLineToRelative(5.65f);
        v12.lineToRelative(-0.95f, 4.58f);
        v12.curveToRelative(-0.1f, 0.5f, 0.05f, 1.01f, 0.41f, 1.37f);
        v12.curveToRelative(0.29f, 0.29f, 0.67f, 0.43f, 1.05f, 0.43f);
        v12.curveToRelative(0.38f, 0f, 0.77f, -0.15f, 1.06f, -0.44f);
        v12.lineToRelative(5.53f, -5.54f);
        v12.curveToRelative(0.37f, -0.37f, 0.58f, -0.88f, 0.58f, -1.41f);
        v12.verticalLineTo(5f);
        v12.curveTo(16.99f, 3.9f, 16.09f, 3f, 14.99f, 3f);
        v12.close();
        v12.moveTo(10.66f, 19.33f);
        v12.lineToRelative(0.61f, -2.92f);
        v12.lineToRelative(0.5f, -2.41f);
        v12.horizontalLineTo(9.31f);
        v12.horizontalLineTo(3.66f);
        v12.curveToRelative(-0.47f, 0f, -0.72f, -0.28f, -0.83f, -0.45f);
        v12.curveToRelative(-0.11f, -0.17f, -0.27f, -0.51f, -0.08f, -0.95f);
        v12.lineTo(6f, 5f);
        v12.horizontalLineToRelative(8.99f);
        v12.lineToRelative(0f, 9.99f);
        v12.lineTo(10.66f, 19.33f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(21f, 3f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(8f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.reflectiveCurveToRelative(2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(5f);
        v12.curveTo(23f, 3.9f, 22.1f, 3f, 21f, 3f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ThumbDownOffAltKt._thumbDownOffAlt = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

