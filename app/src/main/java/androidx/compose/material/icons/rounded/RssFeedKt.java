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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_rssFeed", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RssFeed", "Landroidx/compose/material/icons/Icons$Rounded;", "getRssFeed", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RssFeedKt {
    private static ImageVector _rssFeed;

    static {
    }

    public static final ImageVector getRssFeed(Rounded arg20) {
        ImageVector v0 = RssFeedKt._rssFeed;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.RssFeed", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(6.18f, 17.82f);
        v12.moveToRelative(-2.18f, 0f);
        v12.arcToRelative(2.18f, 2.18f, 0f, true, true, 4.36f, 0f);
        v12.arcToRelative(2.18f, 2.18f, 0f, true, true, -4.36f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(5.59f, 10.23f);
        v12.curveToRelative(-0.84f, -0.14f, -1.59f, 0.55f, -1.59f, 1.4f);
        v12.curveToRelative(0f, 0.71f, 0.53f, 1.28f, 1.23f, 1.4f);
        v12.curveToRelative(2.92f, 0.51f, 5.22f, 2.82f, 5.74f, 5.74f);
        v12.curveToRelative(0.12f, 0.7f, 0.69f, 1.23f, 1.4f, 1.23f);
        v12.curveToRelative(0.85f, 0f, 1.54f, -0.75f, 1.41f, -1.59f);
        v12.curveToRelative(-0.68f, -4.2f, -3.99f, -7.51f, -8.19f, -8.18f);
        v12.close();
        v12.moveTo(5.56f, 4.52f);
        v12.curveTo(4.73f, 4.43f, 4f, 5.1f, 4f, 5.93f);
        v12.curveToRelative(0f, 0.73f, 0.55f, 1.33f, 1.27f, 1.4f);
        v12.curveToRelative(6.01f, 0.6f, 10.79f, 5.38f, 11.39f, 11.39f);
        v12.curveToRelative(0.07f, 0.73f, 0.67f, 1.28f, 1.4f, 1.28f);
        v12.curveToRelative(0.84f, 0f, 1.5f, -0.73f, 1.42f, -1.56f);
        v12.curveToRelative(-0.73f, -7.34f, -6.57f, -13.19f, -13.92f, -13.92f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RssFeedKt._rssFeed = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

