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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_markChatUnread", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MarkChatUnread", "Landroidx/compose/material/icons/Icons$TwoTone;", "getMarkChatUnread", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MarkChatUnreadKt {
    private static ImageVector _markChatUnread;

    static {
    }

    public static final ImageVector getMarkChatUnread(TwoTone arg19) {
        ImageVector v0 = MarkChatUnreadKt._markChatUnread;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.MarkChatUnread", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4f, 16f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineTo(7.9f);
        v12.curveTo(19.68f, 7.96f, 19.34f, 8f, 19f, 8f);
        v12.curveToRelative(-2.42f, 0f, -4.44f, -1.72f, -4.9f, -4f);
        v12.horizontalLineTo(4f);
        v12.verticalLineTo(16f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(20f, 7.9f);
        v12.curveToRelative(0.74f, -0.15f, 1.42f, -0.48f, 2f, -0.92f);
        v12.verticalLineTo(16f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.horizontalLineTo(6f);
        v12.lineToRelative(-4f, 4f);
        v12.verticalLineTo(4f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.horizontalLineToRelative(10.1f);
        v12.curveTo(14.04f, 2.32f, 14f, 2.66f, 14f, 3f);
        v12.reflectiveCurveToRelative(0.04f, 0.68f, 0.1f, 1f);
        v12.horizontalLineTo(4f);
        v12.verticalLineToRelative(12f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineTo(7.9f);
        v12.close();
        v12.moveTo(16f, 3f);
        v12.curveToRelative(0f, 1.66f, 1.34f, 3f, 3f, 3f);
        v12.reflectiveCurveToRelative(3f, -1.34f, 3f, -3f);
        v12.reflectiveCurveToRelative(-1.34f, -3f, -3f, -3f);
        v12.reflectiveCurveTo(16f, 1.34f, 16f, 3f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MarkChatUnreadKt._markChatUnread = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

