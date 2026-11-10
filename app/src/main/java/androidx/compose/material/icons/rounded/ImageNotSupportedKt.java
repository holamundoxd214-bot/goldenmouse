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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_imageNotSupported", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ImageNotSupported", "Landroidx/compose/material/icons/Icons$Rounded;", "getImageNotSupported", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ImageNotSupportedKt {
    private static ImageVector _imageNotSupported;

    static {
    }

    public static final ImageVector getImageNotSupported(Rounded arg19) {
        ImageVector v0 = ImageNotSupportedKt._imageNotSupported;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.ImageNotSupported", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.190001f, 21.190001f);
        v12.lineToRelative(-0.78f, -0.78f);
        v12.lineTo(18f, 18f);
        v12.lineToRelative(-4.59f, -4.59f);
        v12.lineTo(3.59f, 3.59f);
        v12.verticalLineToRelative(0f);
        v12.lineTo(2.81f, 2.81f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.curveTo(1f, 3.2f, 1f, 3.83f, 1.39f, 4.22f);
        v12.lineTo(3f, 5.83f);
        v12.verticalLineTo(19f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(13.17f);
        v12.lineToRelative(1.61f, 1.61f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.curveTo(21.58f, 22.219999f, 21.58f, 21.58f, 21.190001f, 21.190001f);
        v12.close();
        v12.moveTo(6.02f, 18f);
        v12.curveToRelative(-0.42f, 0f, -0.65f, -0.48f, -0.39f, -0.81f);
        v12.lineToRelative(2.49f, -3.2f);
        v12.curveToRelative(0.2f, -0.25f, 0.58f, -0.26f, 0.78f, -0.01f);
        v12.lineToRelative(2.1f, 2.53f);
        v12.lineTo(12.17f, 15f);
        v12.lineToRelative(3f, 3f);
        v12.horizontalLineTo(6.02f);
        v12.close();
        v12.moveTo(21f, 18.17f);
        v12.lineTo(5.83f, 3f);
        v12.horizontalLineTo(19f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.verticalLineTo(18.17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ImageNotSupportedKt._imageNotSupported = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

