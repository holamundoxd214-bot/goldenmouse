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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_youtubeSearchedFor", "Landroidx/compose/ui/graphics/vector/ImageVector;", "YoutubeSearchedFor", "Landroidx/compose/material/icons/Icons$Rounded;", "getYoutubeSearchedFor", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class YoutubeSearchedForKt {
    private static ImageVector _youtubeSearchedFor;

    static {
    }

    public static final ImageVector getYoutubeSearchedFor(Rounded arg19) {
        ImageVector v0 = YoutubeSearchedForKt._youtubeSearchedFor;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.YoutubeSearchedFor", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17.01f, 14f);
        v12.horizontalLineToRelative(-0.8f);
        v12.lineToRelative(-0.27f, -0.27f);
        v12.curveToRelative(1.15f, -1.34f, 1.76f, -3.14f, 1.51f, -5.09f);
        v12.curveTo(17.110001f, 6f, 15.1f, 3.78f, 12.5f, 3.18f);
        v12.curveTo(8.26f, 2.2f, 4.51f, 5.53f, 4.51f, 9.5f);
        v12.horizontalLineToRelative(-2.1f);
        v12.curveToRelative(-0.47f, 0f, -0.68f, 0.59f, -0.31f, 0.89f);
        v12.lineToRelative(3.4f, 2.75f);
        v12.curveToRelative(0.19f, 0.2f, 0.51f, 0.21f, 0.71f, 0.01f);
        v12.lineToRelative(2.9f, -2.79f);
        v12.curveToRelative(0.32f, -0.31f, 0.1f, -0.86f, -0.35f, -0.86f);
        v12.horizontalLineTo(6.51f);
        v12.curveToRelative(0f, -2.49f, 2f, -4.48f, 4.46f, -4.5f);
        v12.curveToRelative(2.44f, -0.02f, 4.54f, 2.05f, 4.54f, 4.49f);
        v12.curveToRelative(0f, 2.48f, -2.02f, 4.51f, -4.5f, 4.51f);
        v12.curveToRelative(-0.45f, 0f, -0.89f, -0.07f, -1.3f, -0.19f);
        v12.curveToRelative(-0.34f, -0.1f, -0.71f, 0f, -0.96f, 0.26f);
        v12.curveToRelative(-0.53f, 0.53f, -0.32f, 1.45f, 0.39f, 1.66f);
        v12.curveToRelative(0.59f, 0.17f, 1.22f, 0.27f, 1.87f, 0.27f);
        v12.curveToRelative(1.61f, 0f, 3.08f, -0.59f, 4.22f, -1.57f);
        v12.lineToRelative(0.27f, 0.27f);
        v12.verticalLineToRelative(0.79f);
        v12.lineToRelative(4.27f, 4.25f);
        v12.curveToRelative(0.41f, 0.41f, 1.07f, 0.41f, 1.48f, 0f);
        v12.curveToRelative(0.41f, -0.41f, 0.41f, -1.08f, 0f, -1.49f);
        v12.lineTo(17.01f, 14f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        YoutubeSearchedForKt._youtubeSearchedFor = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

