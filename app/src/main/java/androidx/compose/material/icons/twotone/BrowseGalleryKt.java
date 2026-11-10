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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_browseGallery", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BrowseGallery", "Landroidx/compose/material/icons/Icons$TwoTone;", "getBrowseGallery", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BrowseGalleryKt {
    private static ImageVector _browseGallery;

    static {
    }

    public static final ImageVector getBrowseGallery(TwoTone arg19) {
        ImageVector v0 = BrowseGalleryKt._browseGallery;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.BrowseGallery", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9f, 5f);
        v12.curveToRelative(-3.86f, 0f, -7f, 3.14f, -7f, 7f);
        v12.reflectiveCurveToRelative(3.14f, 7f, 7f, 7f);
        v12.reflectiveCurveToRelative(7f, -3.14f, 7f, -7f);
        v12.reflectiveCurveTo(12.86f, 5f, 9f, 5f);
        v12.close();
        v12.moveTo(11.79f, 16.209999f);
        v12.lineTo(8f, 12.41f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(4.59f);
        v12.lineToRelative(3.21f, 3.21f);
        v12.lineTo(11.79f, 16.209999f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(9f, 3f);
        v12.curveToRelative(-4.97f, 0f, -9f, 4.03f, -9f, 9f);
        v12.reflectiveCurveToRelative(4.03f, 9f, 9f, 9f);
        v12.reflectiveCurveToRelative(9f, -4.03f, 9f, -9f);
        v12.reflectiveCurveTo(13.97f, 3f, 9f, 3f);
        v12.close();
        v12.moveTo(9f, 19f);
        v12.curveToRelative(-3.86f, 0f, -7f, -3.14f, -7f, -7f);
        v12.reflectiveCurveToRelative(3.14f, -7f, 7f, -7f);
        v12.reflectiveCurveToRelative(7f, 3.14f, 7f, 7f);
        v12.reflectiveCurveTo(12.86f, 19f, 9f, 19f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(10f, 7f);
        v0_1.lineToRelative(-2f, 0f);
        v0_1.lineToRelative(0f, 5.41f);
        v0_1.lineToRelative(3.79f, 3.8f);
        v0_1.lineToRelative(1.42f, -1.42f);
        v0_1.lineToRelative(-3.21f, -3.2f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(17.99f, 3.52f);
        v12.verticalLineToRelative(2.16f);
        v12.curveTo(20.360001f, 6.8f, 22f, 9.21f, 22f, 12f);
        v12.curveToRelative(0f, 2.79f, -1.64f, 5.2f, -4.01f, 6.32f);
        v12.verticalLineToRelative(2.16f);
        v12.curveTo(21.48f, 19.24f, 24f, 15.91f, 24f, 12f);
        v12.curveTo(24f, 8.09f, 21.48f, 4.76f, 17.99f, 3.52f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BrowseGalleryKt._browseGallery = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

