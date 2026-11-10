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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_notificationsActive", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NotificationsActive", "Landroidx/compose/material/icons/Icons$Outlined;", "getNotificationsActive", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NotificationsActiveKt {
    private static ImageVector _notificationsActive;

    static {
    }

    public static final ImageVector getNotificationsActive(Outlined arg19) {
        ImageVector v0 = NotificationsActiveKt._notificationsActive;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.NotificationsActive", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 22f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.horizontalLineToRelative(-4f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.close();
        v12.moveTo(18f, 16f);
        v12.verticalLineToRelative(-5f);
        v12.curveToRelative(0f, -3.07f, -1.63f, -5.64f, -4.5f, -6.32f);
        v12.lineTo(13.5f, 4f);
        v12.curveToRelative(0f, -0.83f, -0.67f, -1.5f, -1.5f, -1.5f);
        v12.reflectiveCurveToRelative(-1.5f, 0.67f, -1.5f, 1.5f);
        v12.verticalLineToRelative(0.68f);
        v12.curveTo(7.64f, 5.36f, 6f, 7.92f, 6f, 11f);
        v12.verticalLineToRelative(5f);
        v12.lineToRelative(-2f, 2f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineToRelative(-1f);
        v12.lineToRelative(-2f, -2f);
        v12.close();
        v12.moveTo(16f, 17f);
        v12.lineTo(8f, 17f);
        v12.verticalLineToRelative(-6f);
        v12.curveToRelative(0f, -2.48f, 1.51f, -4.5f, 4f, -4.5f);
        v12.reflectiveCurveToRelative(4f, 2.02f, 4f, 4.5f);
        v12.verticalLineToRelative(6f);
        v12.close();
        v12.moveTo(7.58f, 4.08f);
        v12.lineTo(6.15f, 2.65f);
        v12.curveTo(3.75f, 4.48f, 2.17f, 7.3f, 2.03f, 10.5f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.15f, -2.65f, 1.51f, -4.97f, 3.55f, -6.42f);
        v12.close();
        v12.moveTo(19.969999f, 10.5f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(-0.15f, -3.2f, -1.73f, -6.02f, -4.12f, -7.85f);
        v12.lineToRelative(-1.42f, 1.43f);
        v12.curveToRelative(2.02f, 1.45f, 3.39f, 3.77f, 3.54f, 6.42f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NotificationsActiveKt._notificationsActive = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

