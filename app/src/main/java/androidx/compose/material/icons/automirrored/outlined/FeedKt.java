package androidx.compose.material.icons.automirrored.outlined;

import androidx.compose.material.icons.Icons$AutoMirrored$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_feed", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Feed", "Landroidx/compose/material/icons/Icons$AutoMirrored$Outlined;", "getFeed", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FeedKt {
    private static ImageVector _feed;

    static {
    }

    public static final ImageVector getFeed(Outlined arg19) {
        ImageVector v0 = FeedKt._feed;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Outlined.Feed", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16f, 3f);
        v12.horizontalLineTo(5f);
        v12.curveTo(3.9f, 3f, 3f, 3.9f, 3f, 5f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(8f);
        v12.lineTo(16f, 3f);
        v12.close();
        v12.moveTo(19f, 19f);
        v12.horizontalLineTo(5f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineTo(19f);
        v12.close();
        v12.moveTo(7f, 17f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineTo(7f);
        v12.verticalLineTo(17f);
        v12.close();
        v12.moveTo(12f, 7f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineTo(7f);
        v12.close();
        v12.moveTo(7f, 13f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineTo(7f);
        v12.verticalLineTo(13f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FeedKt._feed = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

