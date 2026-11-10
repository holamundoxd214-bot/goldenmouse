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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_markAsUnread", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MarkAsUnread", "Landroidx/compose/material/icons/Icons$Rounded;", "getMarkAsUnread", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MarkAsUnreadKt {
    private static ImageVector _markAsUnread;

    static {
    }

    public static final ImageVector getMarkAsUnread(Rounded arg19) {
        ImageVector v0 = MarkAsUnreadKt._markAsUnread;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.MarkAsUnread", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16.23f, 7f);
        v12.horizontalLineToRelative(2.6f);
        v12.curveToRelative(-0.06f, -0.47f, -0.36f, -0.94f, -0.79f, -1.17f);
        v12.lineTo(11.4f, 2.45f);
        v12.curveToRelative(-0.56f, -0.29f, -1.23f, -0.29f, -1.8f, -0.01f);
        v12.lineTo(2.8f, 5.83f);
        v12.curveTo(2.32f, 6.09f, 2f, 6.64f, 2f, 7.17f);
        v12.verticalLineTo(15f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.verticalLineTo(7.4f);
        v12.lineTo(10.5f, 4f);
        v12.lineTo(16.23f, 7f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(20f, 8f);
        v12.horizontalLineTo(7f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(9f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(13f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineToRelative(-9f);
        v12.curveTo(22f, 8.9f, 21.1f, 8f, 20f, 8f);
        v12.close();
        v12.moveTo(20f, 11.46f);
        v12.curveToRelative(0f, 0.33f, -0.19f, 0.64f, -0.48f, 0.79f);
        v12.lineToRelative(-5.61f, 2.88f);
        v12.curveToRelative(-0.25f, 0.13f, -0.56f, 0.13f, -0.81f, 0f);
        v12.lineToRelative(-5.61f, -2.88f);
        v12.curveTo(7.19f, 12.1f, 7f, 11.79f, 7f, 11.46f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.67f, 0.7f, -1.1f, 1.3f, -0.79f);
        v12.lineToRelative(5.2f, 2.67f);
        v12.lineToRelative(5.2f, -2.67f);
        v12.curveTo(19.299999f, 10.36f, 20f, 10.79f, 20f, 11.46f);
        v12.lineTo(20f, 11.46f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MarkAsUnreadKt._markAsUnread = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

