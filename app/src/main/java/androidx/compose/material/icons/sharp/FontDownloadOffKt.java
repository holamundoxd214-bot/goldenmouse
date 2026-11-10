package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_fontDownloadOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FontDownloadOff", "Landroidx/compose/material/icons/Icons$Sharp;", "getFontDownloadOff", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FontDownloadOffKt {
    private static ImageVector _fontDownloadOff;

    static {
    }

    public static final ImageVector getFontDownloadOff(Sharp arg18) {
        ImageVector v0 = FontDownloadOffKt._fontDownloadOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.FontDownloadOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(12.58f, 9.75f);
        v0_1.lineToRelative(-0.87f, -0.87f);
        v0_1.lineToRelative(0.23f, -0.66f);
        v0_1.horizontalLineToRelative(0.1f);
        v0_1.lineTo(12.58f, 9.75f);
        v0_1.close();
        v0_1.moveTo(20.49f, 23.309999f);
        v0_1.lineTo(19.17f, 22f);
        v0_1.horizontalLineTo(2f);
        v0_1.verticalLineTo(4.83f);
        v0_1.lineTo(0.69f, 3.51f);
        v0_1.lineTo(2.1f, 2.1f);
        v0_1.lineToRelative(19.799999f, 19.799999f);
        v0_1.lineTo(20.49f, 23.309999f);
        v0_1.close();
        v0_1.moveTo(12.1f, 14.93f);
        v0_1.lineToRelative(-3.3f, -3.3f);
        v0_1.lineTo(6.41f, 18f);
        v0_1.horizontalLineToRelative(2.08f);
        v0_1.lineToRelative(1.09f, -3.07f);
        v0_1.horizontalLineTo(12.1f);
        v0_1.close();
        v0_1.moveTo(10.35f, 7.52f);
        v0_1.lineTo(10.92f, 6f);
        v0_1.horizontalLineToRelative(2.14f);
        v0_1.lineToRelative(2.55f, 6.79f);
        v0_1.lineTo(22f, 19.17f);
        v0_1.verticalLineTo(2f);
        v0_1.horizontalLineTo(4.83f);
        v0_1.lineTo(10.35f, 7.52f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FontDownloadOffKt._fontDownloadOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

