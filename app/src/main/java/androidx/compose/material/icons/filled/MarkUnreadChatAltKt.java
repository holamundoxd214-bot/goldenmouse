package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_markUnreadChatAlt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MarkUnreadChatAlt", "Landroidx/compose/material/icons/Icons$Filled;", "getMarkUnreadChatAlt", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MarkUnreadChatAltKt {
    private static ImageVector _markUnreadChatAlt;

    static {
    }

    public static final ImageVector getMarkUnreadChatAlt(Filled arg20) {
        ImageVector v0 = MarkUnreadChatAltKt._markUnreadChatAlt;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.MarkUnreadChatAlt", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19f, 3f);
        v12.moveToRelative(-3f, 0f);
        v12.arcToRelative(3f, 3f, 0f, true, true, 6f, 0f);
        v12.arcToRelative(3f, 3f, 0f, true, true, -6f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(6f, 8f);
        v12.verticalLineTo(6f);
        v12.horizontalLineToRelative(9.03f);
        v12.curveToRelative(-1.21f, -1.6f, -1.08f, -3.21f, -0.92f, -4f);
        v12.horizontalLineTo(4.01f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.89f, -2f, 2f);
        v12.lineTo(2f, 22f);
        v12.lineToRelative(4f, -4f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(6.97f);
        v12.curveTo(21.16f, 7.61f, 20.129999f, 8f, 19f, 8f);
        v12.horizontalLineTo(6f);
        v12.close();
        v12.moveTo(14f, 14f);
        v12.horizontalLineTo(6f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineTo(14f);
        v12.close();
        v12.moveTo(18f, 11f);
        v12.horizontalLineTo(6f);
        v12.verticalLineTo(9f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineTo(11f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MarkUnreadChatAltKt._markUnreadChatAlt = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

