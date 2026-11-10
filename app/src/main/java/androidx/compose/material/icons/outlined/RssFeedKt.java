package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_rssFeed", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RssFeed", "Landroidx/compose/material/icons/Icons$Outlined;", "getRssFeed", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RssFeedKt {
    private static ImageVector _rssFeed;

    static {
    }

    public static final ImageVector getRssFeed(Outlined arg20) {
        ImageVector v0 = RssFeedKt._rssFeed;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.RssFeed", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.moveTo(4f, 4.44f);
        v12.verticalLineToRelative(2.83f);
        v12.curveToRelative(7.03f, 0f, 12.73f, 5.7f, 12.73f, 12.73f);
        v12.horizontalLineToRelative(2.83f);
        v12.curveToRelative(0f, -8.59f, -6.97f, -15.56f, -15.56f, -15.56f);
        v12.close();
        v12.moveTo(4f, 10.1f);
        v12.verticalLineToRelative(2.83f);
        v12.curveToRelative(3.9f, 0f, 7.07f, 3.17f, 7.07f, 7.07f);
        v12.horizontalLineToRelative(2.83f);
        v12.curveToRelative(0f, -5.47f, -4.43f, -9.9f, -9.9f, -9.9f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RssFeedKt._rssFeed = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

