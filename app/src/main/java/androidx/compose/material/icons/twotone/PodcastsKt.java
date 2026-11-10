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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_podcasts", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Podcasts", "Landroidx/compose/material/icons/Icons$TwoTone;", "getPodcasts", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PodcastsKt {
    private static ImageVector _podcasts;

    static {
    }

    public static final ImageVector getPodcasts(TwoTone arg19) {
        ImageVector v0 = PodcastsKt._podcasts;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Podcasts", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14f, 12f);
        v12.curveToRelative(0f, 0.74f, -0.4f, 1.38f, -1f, 1.72f);
        v12.verticalLineTo(22f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-8.28f);
        v12.curveToRelative(-0.6f, -0.35f, -1f, -0.98f, -1f, -1.72f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveTo(14f, 10.9f, 14f, 12f);
        v12.close();
        v12.moveTo(12f, 6f);
        v12.curveToRelative(-3.31f, 0f, -6f, 2.69f, -6f, 6f);
        v12.curveToRelative(0f, 1.74f, 0.75f, 3.31f, 1.94f, 4.4f);
        v12.lineToRelative(1.42f, -1.42f);
        v12.curveTo(8.53f, 14.25f, 8f, 13.19f, 8f, 12f);
        v12.curveToRelative(0f, -2.21f, 1.79f, -4f, 4f, -4f);
        v12.reflectiveCurveToRelative(4f, 1.79f, 4f, 4f);
        v12.curveToRelative(0f, 1.19f, -0.53f, 2.25f, -1.36f, 2.98f);
        v12.lineToRelative(1.42f, 1.42f);
        v12.curveTo(17.25f, 15.31f, 18f, 13.74f, 18f, 12f);
        v12.curveTo(18f, 8.69f, 15.31f, 6f, 12f, 6f);
        v12.close();
        v12.moveTo(12f, 2f);
        v12.curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f);
        v12.curveToRelative(0f, 2.85f, 1.2f, 5.41f, 3.11f, 7.24f);
        v12.lineToRelative(1.42f, -1.42f);
        v12.curveTo(4.98f, 16.360001f, 4f, 14.29f, 4f, 12f);
        v12.curveToRelative(0f, -4.41f, 3.59f, -8f, 8f, -8f);
        v12.reflectiveCurveToRelative(8f, 3.59f, 8f, 8f);
        v12.curveToRelative(0f, 2.29f, -0.98f, 4.36f, -2.53f, 5.82f);
        v12.lineToRelative(1.42f, 1.42f);
        v12.curveTo(20.799999f, 17.41f, 22f, 14.85f, 22f, 12f);
        v12.curveTo(22f, 6.48f, 17.52f, 2f, 12f, 2f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PodcastsKt._podcasts = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

