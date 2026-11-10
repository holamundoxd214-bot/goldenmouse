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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_downloading", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Downloading", "Landroidx/compose/material/icons/Icons$Sharp;", "getDownloading", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DownloadingKt {
    private static ImageVector _downloading;

    static {
    }

    public static final ImageVector getDownloading(Sharp arg19) {
        ImageVector v0 = DownloadingKt._downloading;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Downloading", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.32f, 4.26f);
        v12.curveTo(16.84f, 3.05f, 15.01f, 2.25f, 13f, 2.05f);
        v12.verticalLineToRelative(2.02f);
        v12.curveToRelative(1.46f, 0.18f, 2.79f, 0.76f, 3.9f, 1.62f);
        v12.lineTo(18.32f, 4.26f);
        v12.close();
        v12.moveTo(19.93f, 11f);
        v12.horizontalLineToRelative(2.02f);
        v12.curveToRelative(-0.2f, -2.01f, -1f, -3.84f, -2.21f, -5.32f);
        v12.lineTo(18.309999f, 7.1f);
        v12.curveTo(19.17f, 8.21f, 19.75f, 9.54f, 19.93f, 11f);
        v12.close();
        v12.moveTo(18.309999f, 16.9f);
        v12.lineToRelative(1.43f, 1.43f);
        v12.curveToRelative(1.21f, -1.48f, 2.01f, -3.32f, 2.21f, -5.32f);
        v12.horizontalLineToRelative(-2.02f);
        v12.curveTo(19.75f, 14.46f, 19.17f, 15.79f, 18.309999f, 16.9f);
        v12.close();
        v12.moveTo(13f, 19.93f);
        v12.verticalLineToRelative(2.02f);
        v12.curveToRelative(2.01f, -0.2f, 3.84f, -1f, 5.32f, -2.21f);
        v12.lineToRelative(-1.43f, -1.43f);
        v12.curveTo(15.79f, 19.17f, 14.46f, 19.75f, 13f, 19.93f);
        v12.close();
        v12.moveTo(13f, 12f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(5f);
        v12.horizontalLineTo(7f);
        v12.lineToRelative(5f, 5f);
        v12.lineToRelative(5f, -5f);
        v12.horizontalLineTo(13f);
        v12.close();
        v12.moveTo(11f, 19.93f);
        v12.verticalLineToRelative(2.02f);
        v12.curveToRelative(-5.05f, -0.5f, -9f, -4.76f, -9f, -9.95f);
        v12.reflectiveCurveToRelative(3.95f, -9.45f, 9f, -9.95f);
        v12.verticalLineToRelative(2.02f);
        v12.curveTo(7.05f, 4.56f, 4f, 7.92f, 4f, 12f);
        v12.reflectiveCurveTo(7.05f, 19.440001f, 11f, 19.93f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DownloadingKt._downloading = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

