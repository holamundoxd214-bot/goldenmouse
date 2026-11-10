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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_browseGallery", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BrowseGallery", "Landroidx/compose/material/icons/Icons$Rounded;", "getBrowseGallery", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BrowseGalleryKt {
    private static ImageVector _browseGallery;

    static {
    }

    public static final ImageVector getBrowseGallery(Rounded arg19) {
        ImageVector v0 = BrowseGalleryKt._browseGallery;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.BrowseGallery", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9f, 3f);
        v12.curveToRelative(-4.97f, 0f, -9f, 4.03f, -9f, 9f);
        v12.reflectiveCurveToRelative(4.03f, 9f, 9f, 9f);
        v12.reflectiveCurveToRelative(9f, -4.03f, 9f, -9f);
        v12.reflectiveCurveTo(13.97f, 3f, 9f, 3f);
        v12.close();
        v12.moveTo(11.09f, 15.5f);
        v12.lineTo(8.59f, 13f);
        v12.curveTo(8.21f, 12.62f, 8f, 12.12f, 8f, 11.59f);
        v12.verticalLineTo(8f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(3.59f);
        v12.lineToRelative(2.5f, 2.5f);
        v12.curveToRelative(0.39f, 0.39f, 0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(12.11f, 15.89f, 11.48f, 15.89f, 11.09f, 15.5f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(17.99f, 5.08f);
        v12.lineTo(17.99f, 5.08f);
        v12.curveToRelative(0f, 0.37f, 0.21f, 0.69f, 0.53f, 0.88f);
        v12.curveTo(20.6f, 7.17f, 22f, 9.42f, 22f, 12f);
        v12.curveToRelative(0f, 2.58f, -1.4f, 4.83f, -3.48f, 6.04f);
        v12.curveToRelative(-0.32f, 0.19f, -0.53f, 0.51f, -0.53f, 0.88f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, 0.77f, 0.84f, 1.25f, 1.51f, 0.86f);
        v12.curveTo(22.18f, 18.219999f, 24f, 15.32f, 24f, 12f);
        v12.curveToRelative(0f, -3.32f, -1.82f, -6.22f, -4.5f, -7.78f);
        v12.curveTo(18.83f, 3.83f, 17.99f, 4.31f, 17.99f, 5.08f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BrowseGalleryKt._browseGallery = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

