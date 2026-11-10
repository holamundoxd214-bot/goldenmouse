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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sendTimeExtension", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SendTimeExtension", "Landroidx/compose/material/icons/Icons$Outlined;", "getSendTimeExtension", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SendTimeExtensionKt {
    private static ImageVector _sendTimeExtension;

    static {
    }

    public static final ImageVector getSendTimeExtension(Outlined arg19) {
        ImageVector v0 = SendTimeExtensionKt._sendTimeExtension;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.SendTimeExtension", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 6f);
        v12.verticalLineToRelative(6.26f);
        v12.lineToRelative(2f, 1f);
        v12.verticalLineTo(6f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineToRelative(-4f);
        v12.curveToRelative(0f, -1.38f, -1.12f, -2.5f, -2.5f, -2.5f);
        v12.reflectiveCurveTo(9f, 2.62f, 9f, 4f);
        v12.horizontalLineTo(5.01f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(3.8f);
        v12.curveTo(5.7f, 9.8f, 6f, 11.96f, 6f, 12.5f);
        v12.curveToRelative(0f, 0.54f, -0.29f, 2.7f, -3f, 2.7f);
        v12.verticalLineTo(19f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(3.8f);
        v12.curveToRelative(0f, -2.16f, 1.37f, -2.78f, 2.2f, -2.94f);
        v12.verticalLineToRelative(-2.03f);
        v12.curveTo(9.57f, 16.200001f, 7.85f, 17.07f, 7.13f, 19f);
        v12.horizontalLineTo(5f);
        v12.verticalLineToRelative(-2.13f);
        v12.curveToRelative(2.17f, -0.8f, 3f, -2.87f, 3f, -4.37f);
        v12.curveToRelative(0f, -1.49f, -0.83f, -3.56f, -2.99f, -4.37f);
        v12.verticalLineTo(6f);
        v12.horizontalLineTo(11f);
        v12.verticalLineTo(4f);
        v12.curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f);
        v12.reflectiveCurveTo(12f, 3.72f, 12f, 4f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(18f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(13f, 12f);
        v0_1.lineToRelative(0f, 4f);
        v0_1.lineToRelative(4f, 1f);
        v0_1.lineToRelative(-4f, 1f);
        v0_1.lineToRelative(0f, 4f);
        v0_1.lineToRelative(10f, -5f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SendTimeExtensionKt._sendTimeExtension = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

