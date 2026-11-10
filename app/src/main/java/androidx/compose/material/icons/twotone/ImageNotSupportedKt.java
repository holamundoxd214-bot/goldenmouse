package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_imageNotSupported", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ImageNotSupported", "Landroidx/compose/material/icons/Icons$TwoTone;", "getImageNotSupported", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ImageNotSupportedKt {
    private static ImageVector _imageNotSupported;

    static {
    }

    public static final ImageVector getImageNotSupported(TwoTone arg19) {
        ImageVector v0 = ImageNotSupportedKt._imageNotSupported;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.ImageNotSupported", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(7.83f, 5f);
        v0_1.horizontalLineTo(19f);
        v0_1.verticalLineToRelative(11.17f);
        v0_1.lineTo(7.83f, 5f);
        v0_1.close();
        v0_1.moveTo(16.17f, 19f);
        v0_1.lineToRelative(-2f, -2f);
        v0_1.horizontalLineTo(6f);
        v0_1.lineToRelative(3f, -4f);
        v0_1.lineToRelative(2f, 2.72f);
        v0_1.lineToRelative(0.84f, -1.05f);
        v0_1.lineTo(5f, 7.83f);
        v0_1.verticalLineTo(19f);
        v0_1.horizontalLineTo(16.17f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(5.83f, 3f);
        v12.horizontalLineTo(19f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.verticalLineToRelative(13.17f);
        v12.lineToRelative(-2f, -2f);
        v12.verticalLineTo(5f);
        v12.horizontalLineTo(7.83f);
        v12.lineTo(5.83f, 3f);
        v12.close();
        v12.moveTo(20.49f, 23.309999f);
        v12.lineTo(18.17f, 21f);
        v12.horizontalLineTo(5f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.verticalLineTo(5.83f);
        v12.lineTo(0.69f, 3.51f);
        v12.lineTo(2.1f, 2.1f);
        v12.lineToRelative(1.49f, 1.49f);
        v12.lineTo(5f, 5f);
        v12.lineToRelative(8.11f, 8.11f);
        v12.lineToRelative(2.69f, 2.69f);
        v12.lineTo(19f, 19f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineToRelative(1.49f, 1.49f);
        v12.lineTo(20.49f, 23.309999f);
        v12.close();
        v12.moveTo(16.17f, 19f);
        v12.lineToRelative(-2f, -2f);
        v12.horizontalLineTo(6f);
        v12.lineToRelative(3f, -4f);
        v12.lineToRelative(2f, 2.72f);
        v12.lineToRelative(0.84f, -1.05f);
        v12.lineTo(5f, 7.83f);
        v12.verticalLineTo(19f);
        v12.horizontalLineTo(16.17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ImageNotSupportedKt._imageNotSupported = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

