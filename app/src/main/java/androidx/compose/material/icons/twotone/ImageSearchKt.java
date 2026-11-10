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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_imageSearch", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ImageSearch", "Landroidx/compose/material/icons/Icons$TwoTone;", "getImageSearch", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ImageSearchKt {
    private static ImageVector _imageSearch;

    static {
    }

    public static final ImageVector getImageSearch(TwoTone arg19) {
        ImageVector v0 = ImageSearchKt._imageSearch;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.ImageSearch", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17.700001f, 11.53f);
        v12.curveToRelative(-0.7f, 0.31f, -1.45f, 0.47f, -2.21f, 0.47f);
        v12.curveTo(12.46f, 12f, 10f, 9.53f, 10f, 6.5f);
        v12.curveToRelative(0f, -0.17f, 0.01f, -0.34f, 0.03f, -0.5f);
        v12.horizontalLineTo(4f);
        v12.verticalLineToRelative(14f);
        v12.horizontalLineToRelative(14f);
        v12.verticalLineToRelative(-8.17f);
        v12.lineToRelative(-0.3f, -0.3f);
        v12.close();
        v12.moveTo(5.5f, 18f);
        v12.lineToRelative(2.75f, -3.53f);
        v12.lineToRelative(1.96f, 2.36f);
        v12.lineToRelative(2.75f, -3.54f);
        v12.lineTo(16.5f, 18f);
        v12.horizontalLineToRelative(-11f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(10.21f, 16.83f);
        v12.lineToRelative(-1.96f, -2.36f);
        v12.lineTo(5.5f, 18f);
        v12.horizontalLineToRelative(11f);
        v12.lineToRelative(-3.54f, -4.71f);
        v12.close();
        v12.moveTo(20f, 6.5f);
        v12.curveTo(20f, 4.01f, 17.99f, 2f, 15.5f, 2f);
        v12.reflectiveCurveTo(11f, 4.01f, 11f, 6.5f);
        v12.reflectiveCurveToRelative(2.01f, 4.5f, 4.49f, 4.5f);
        v12.curveToRelative(0.88f, 0f, 1.7f, -0.26f, 2.39f, -0.7f);
        v12.lineTo(21f, 13.42f);
        v12.lineTo(22.42f, 12f);
        v12.lineTo(19.299999f, 8.89f);
        v12.curveToRelative(0.44f, -0.7f, 0.7f, -1.51f, 0.7f, -2.39f);
        v12.close();
        v12.moveTo(15.5f, 9f);
        v12.curveTo(14.12f, 9f, 13f, 7.88f, 13f, 6.5f);
        v12.reflectiveCurveTo(14.12f, 4f, 15.5f, 4f);
        v12.reflectiveCurveTo(18f, 5.12f, 18f, 6.5f);
        v12.reflectiveCurveTo(16.879999f, 9f, 15.5f, 9f);
        v12.close();
        v12.moveTo(18f, 20f);
        v12.horizontalLineTo(4f);
        v12.verticalLineTo(6f);
        v12.horizontalLineToRelative(6.03f);
        v12.curveToRelative(0.06f, -0.72f, 0.27f, -1.39f, 0.58f, -2f);
        v12.horizontalLineTo(4f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(-6.17f);
        v12.lineToRelative(-2f, -2f);
        v12.verticalLineTo(20f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ImageSearchKt._imageSearch = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

