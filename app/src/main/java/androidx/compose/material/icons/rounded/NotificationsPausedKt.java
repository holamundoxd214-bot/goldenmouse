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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_notificationsPaused", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NotificationsPaused", "Landroidx/compose/material/icons/Icons$Rounded;", "getNotificationsPaused", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NotificationsPausedKt {
    private static ImageVector _notificationsPaused;

    static {
    }

    public static final ImageVector getNotificationsPaused(Rounded arg19) {
        ImageVector v0 = NotificationsPausedKt._notificationsPaused;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.NotificationsPaused", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 22f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.horizontalLineToRelative(-4f);
        v12.curveToRelative(0f, 1.1f, 0.89f, 2f, 2f, 2f);
        v12.close();
        v12.moveTo(19.290001f, 17.290001f);
        v12.lineTo(18f, 16f);
        v12.verticalLineToRelative(-5f);
        v12.curveToRelative(0f, -3.07f, -1.64f, -5.64f, -4.5f, -6.32f);
        v12.lineTo(13.5f, 4f);
        v12.curveToRelative(0f, -0.83f, -0.67f, -1.5f, -1.5f, -1.5f);
        v12.reflectiveCurveToRelative(-1.5f, 0.67f, -1.5f, 1.5f);
        v12.verticalLineToRelative(0.68f);
        v12.curveTo(7.63f, 5.36f, 6f, 7.92f, 6f, 11f);
        v12.verticalLineToRelative(5f);
        v12.lineToRelative(-1.29f, 1.29f);
        v12.curveToRelative(-0.63f, 0.63f, -0.19f, 1.71f, 0.7f, 1.71f);
        v12.horizontalLineToRelative(13.17f);
        v12.curveToRelative(0.9f, 0f, 1.34f, -1.08f, 0.71f, -1.71f);
        v12.close();
        v12.moveTo(14.5f, 9.33f);
        v12.curveToRelative(0f, 0.31f, -0.11f, 0.6f, -0.3f, 0.84f);
        v12.lineToRelative(-2.5f, 3.03f);
        v12.horizontalLineToRelative(1.9f);
        v12.curveToRelative(0.5f, 0f, 0.9f, 0.4f, 0.9f, 0.9f);
        v12.reflectiveCurveToRelative(-0.4f, 0.9f, -0.9f, 0.9f);
        v12.horizontalLineToRelative(-2.78f);
        v12.curveToRelative(-0.73f, 0f, -1.32f, -0.59f, -1.32f, -1.32f);
        v12.verticalLineToRelative(-0.01f);
        v12.curveToRelative(0f, -0.31f, 0.11f, -0.6f, 0.3f, -0.84f);
        v12.lineToRelative(2.5f, -3.03f);
        v12.horizontalLineToRelative(-1.9f);
        v12.curveToRelative(-0.5f, 0f, -0.9f, -0.4f, -0.9f, -0.9f);
        v12.reflectiveCurveToRelative(0.4f, -0.9f, 0.9f, -0.9f);
        v12.horizontalLineToRelative(2.78f);
        v12.curveToRelative(0.73f, 0f, 1.32f, 0.59f, 1.32f, 1.33f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NotificationsPausedKt._notificationsPaused = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

