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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_youtubeSearchedFor", "Landroidx/compose/ui/graphics/vector/ImageVector;", "YoutubeSearchedFor", "Landroidx/compose/material/icons/Icons$TwoTone;", "getYoutubeSearchedFor", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class YoutubeSearchedForKt {
    private static ImageVector _youtubeSearchedFor;

    static {
    }

    public static final ImageVector getYoutubeSearchedFor(TwoTone arg19) {
        ImageVector v0 = YoutubeSearchedForKt._youtubeSearchedFor;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.YoutubeSearchedFor", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17.01f, 14f);
        v12.horizontalLineToRelative(-0.8f);
        v12.lineToRelative(-0.27f, -0.27f);
        v12.curveToRelative(0.98f, -1.14f, 1.57f, -2.61f, 1.57f, -4.23f);
        v12.curveToRelative(0f, -3.59f, -2.91f, -6.5f, -6.5f, -6.5f);
        v12.reflectiveCurveToRelative(-6.5f, 3f, -6.5f, 6.5f);
        v12.horizontalLineTo(2f);
        v12.lineToRelative(3.84f, 4f);
        v12.lineToRelative(4.16f, -4f);
        v12.horizontalLineTo(6.51f);
        v12.curveTo(6.51f, 7f, 8.53f, 5f, 11.01f, 5f);
        v12.reflectiveCurveToRelative(4.5f, 2.01f, 4.5f, 4.5f);
        v12.curveToRelative(0f, 2.48f, -2.02f, 4.5f, -4.5f, 4.5f);
        v12.curveToRelative(-0.65f, 0f, -1.26f, -0.14f, -1.82f, -0.38f);
        v12.lineTo(7.71f, 15.1f);
        v12.curveToRelative(0.97f, 0.57f, 2.09f, 0.9f, 3.3f, 0.9f);
        v12.curveToRelative(1.61f, 0f, 3.08f, -0.59f, 4.22f, -1.57f);
        v12.lineToRelative(0.27f, 0.27f);
        v12.verticalLineToRelative(0.79f);
        v12.lineToRelative(5.01f, 4.99f);
        v12.lineTo(22f, 19f);
        v12.lineToRelative(-4.99f, -5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        YoutubeSearchedForKt._youtubeSearchedFor = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

