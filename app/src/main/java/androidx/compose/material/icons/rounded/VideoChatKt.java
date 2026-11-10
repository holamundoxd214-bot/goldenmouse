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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_videoChat", "Landroidx/compose/ui/graphics/vector/ImageVector;", "VideoChat", "Landroidx/compose/material/icons/Icons$Rounded;", "getVideoChat", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class VideoChatKt {
    private static ImageVector _videoChat;

    static {
    }

    public static final ImageVector getVideoChat(Rounded arg19) {
        ImageVector v0 = VideoChatKt._videoChat;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.VideoChat", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 2f);
        v12.horizontalLineTo(4f);
        v12.curveTo(2.9f, 2f, 2.01f, 2.9f, 2.01f, 4f);
        v12.lineTo(2f, 19.58f);
        v12.curveToRelative(0f, 0.89f, 1.08f, 1.34f, 1.71f, 0.71f);
        v12.lineTo(6f, 18f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(4f);
        v12.curveTo(22f, 2.9f, 21.1f, 2f, 20f, 2f);
        v12.close();
        v12.moveTo(16.15f, 12.15f);
        v12.lineTo(15f, 11.01f);
        v12.verticalLineTo(13f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineTo(8f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineTo(7f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(6f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(1.99f);
        v12.lineToRelative(1.15f, -1.14f);
        v12.curveTo(16.459999f, 7.53f, 17f, 7.76f, 17f, 8.2f);
        v12.verticalLineToRelative(3.59f);
        v12.curveTo(17f, 12.24f, 16.459999f, 12.47f, 16.15f, 12.15f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        VideoChatKt._videoChat = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

