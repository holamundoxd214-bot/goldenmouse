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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_podcasts", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Podcasts", "Landroidx/compose/material/icons/Icons$Rounded;", "getPodcasts", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PodcastsKt {
    private static ImageVector _podcasts;

    static {
    }

    public static final ImageVector getPodcasts(Rounded arg19) {
        ImageVector v0 = PodcastsKt._podcasts;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Podcasts", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14f, 12f);
        v12.curveToRelative(0f, 0.74f, -0.4f, 1.38f, -1f, 1.72f);
        v12.verticalLineTo(21f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-7.28f);
        v12.curveToRelative(-0.6f, -0.35f, -1f, -0.98f, -1f, -1.72f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveTo(14f, 10.9f, 14f, 12f);
        v12.close();
        v12.moveTo(10.75f, 6.13f);
        v12.curveToRelative(-2.27f, 0.46f, -4.12f, 2.28f, -4.61f, 4.55f);
        v12.curveToRelative(-0.4f, 1.86f, 0.07f, 3.62f, 1.08f, 4.94f);
        v12.curveToRelative(0.35f, 0.45f, 1.03f, 0.47f, 1.43f, 0.07f);
        v12.lineToRelative(0.07f, -0.07f);
        v12.curveToRelative(0.34f, -0.34f, 0.34f, -0.87f, 0.06f, -1.25f);
        v12.curveToRelative(-0.68f, -0.9f, -0.98f, -2.1f, -0.66f, -3.37f);
        v12.curveToRelative(0.35f, -1.42f, 1.52f, -2.57f, 2.95f, -2.88f);
        v12.curveTo(13.69f, 7.52f, 16f, 9.49f, 16f, 12f);
        v12.curveToRelative(0f, 0.87f, -0.28f, 1.67f, -0.76f, 2.32f);
        v12.curveToRelative(-0.3f, 0.41f, -0.29f, 0.97f, 0.07f, 1.33f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.44f, 0.44f, 1.17f, 0.37f, 1.54f, -0.14f);
        v12.curveTo(17.57f, 14.53f, 18f, 13.31f, 18f, 12f);
        v12.curveTo(18f, 8.28f, 14.61f, 5.35f, 10.75f, 6.13f);
        v12.close();
        v12.moveTo(10.83f, 2.07f);
        v12.curveTo(6.3f, 2.58f, 2.61f, 6.25f, 2.07f, 10.78f);
        v12.curveToRelative(-0.35f, 2.95f, 0.59f, 5.67f, 2.32f, 7.7f);
        v12.curveToRelative(0.37f, 0.43f, 1.03f, 0.46f, 1.43f, 0.06f);
        v12.lineToRelative(0.05f, -0.05f);
        v12.curveToRelative(0.35f, -0.35f, 0.38f, -0.92f, 0.05f, -1.3f);
        v12.curveToRelative(-1.56f, -1.83f, -2.33f, -4.37f, -1.7f, -7.06f);
        v12.curveToRelative(0.7f, -3.01f, 3.18f, -5.39f, 6.22f, -5.97f);
        v12.curveTo(15.53f, 3.18f, 20f, 7.08f, 20f, 12f);
        v12.curveToRelative(0f, 1.96f, -0.72f, 3.76f, -1.9f, 5.16f);
        v12.curveToRelative(-0.34f, 0.4f, -0.31f, 0.98f, 0.05f, 1.35f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.42f, 0.42f, 1.11f, 0.39f, 1.49f, -0.07f);
        v12.curveTo(21.110001f, 16.700001f, 22f, 14.46f, 22f, 12f);
        v12.curveTo(22f, 6.09f, 16.870001f, 1.38f, 10.83f, 2.07f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PodcastsKt._podcasts = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

