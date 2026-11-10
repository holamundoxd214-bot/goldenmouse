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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_fontDownloadOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FontDownloadOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getFontDownloadOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FontDownloadOffKt {
    private static ImageVector _fontDownloadOff;

    static {
    }

    public static final ImageVector getFontDownloadOff(Rounded arg19) {
        ImageVector v0 = FontDownloadOffKt._fontDownloadOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.FontDownloadOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12.58f, 9.75f);
        v12.lineToRelative(-0.87f, -0.87f);
        v12.lineToRelative(0.23f, -0.66f);
        v12.horizontalLineToRelative(0.1f);
        v12.lineTo(12.58f, 9.75f);
        v12.close();
        v12.moveTo(10.35f, 7.52f);
        v12.lineTo(10.55f, 7f);
        v12.curveToRelative(0.23f, -0.6f, 0.8f, -1f, 1.45f, -1f);
        v12.reflectiveCurveToRelative(1.22f, 0.4f, 1.45f, 1f);
        v12.lineToRelative(2.17f, 5.79f);
        v12.lineTo(22f, 19.17f);
        v12.verticalLineTo(4f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineTo(4.83f);
        v12.lineTo(10.35f, 7.52f);
        v12.close();
        v12.moveTo(21.190001f, 22.610001f);
        v12.lineTo(21.190001f, 22.610001f);
        v12.curveToRelative(-0.39f, 0.39f, -1.02f, 0.39f, -1.41f, 0f);
        v12.lineTo(19.17f, 22f);
        v12.horizontalLineTo(4f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.verticalLineTo(4.83f);
        v12.lineTo(1.39f, 4.22f);
        v12.curveTo(1f, 3.83f, 1f, 3.2f, 1.39f, 2.81f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0f);
        v12.lineToRelative(18.379999f, 18.379999f);
        v12.curveTo(21.58f, 21.58f, 21.58f, 22.219999f, 21.190001f, 22.610001f);
        v12.close();
        v12.moveTo(12.1f, 14.93f);
        v12.lineToRelative(-3.3f, -3.3f);
        v12.lineTo(6.9f, 16.700001f);
        v12.curveTo(6.67f, 17.33f, 7.13f, 18f, 7.8f, 18f);
        v12.horizontalLineToRelative(0.01f);
        v12.curveToRelative(0.41f, 0f, 0.77f, -0.26f, 0.9f, -0.64f);
        v12.lineToRelative(0.86f, -2.43f);
        v12.horizontalLineTo(12.1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FontDownloadOffKt._fontDownloadOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

