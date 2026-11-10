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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_notificationsActive", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NotificationsActive", "Landroidx/compose/material/icons/Icons$Rounded;", "getNotificationsActive", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NotificationsActiveKt {
    private static ImageVector _notificationsActive;

    static {
    }

    public static final ImageVector getNotificationsActive(Rounded arg19) {
        ImageVector v0 = NotificationsActiveKt._notificationsActive;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.NotificationsActive", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 16f);
        v12.verticalLineToRelative(-5f);
        v12.curveToRelative(0f, -3.07f, -1.64f, -5.64f, -4.5f, -6.32f);
        v12.lineTo(13.5f, 4f);
        v12.curveToRelative(0f, -0.83f, -0.68f, -1.5f, -1.51f, -1.5f);
        v12.reflectiveCurveTo(10.5f, 3.17f, 10.5f, 4f);
        v12.verticalLineToRelative(0.68f);
        v12.curveTo(7.63f, 5.36f, 6f, 7.92f, 6f, 11f);
        v12.verticalLineToRelative(5f);
        v12.lineToRelative(-1.3f, 1.29f);
        v12.curveToRelative(-0.63f, 0.63f, -0.19f, 1.71f, 0.7f, 1.71f);
        v12.horizontalLineToRelative(13.17f);
        v12.curveToRelative(0.89f, 0f, 1.34f, -1.08f, 0.71f, -1.71f);
        v12.lineTo(18f, 16f);
        v12.close();
        v12.moveTo(11.99f, 22f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.horizontalLineToRelative(-4f);
        v12.curveToRelative(0f, 1.1f, 0.89f, 2f, 2f, 2f);
        v12.close();
        v12.moveTo(6.77f, 4.73f);
        v12.curveToRelative(0.42f, -0.38f, 0.43f, -1.03f, 0.03f, -1.43f);
        v12.curveToRelative(-0.38f, -0.38f, -1f, -0.39f, -1.39f, -0.02f);
        v12.curveTo(3.7f, 4.84f, 2.52f, 6.96f, 2.14f, 9.34f);
        v12.curveToRelative(-0.09f, 0.61f, 0.38f, 1.16f, 1f, 1.16f);
        v12.curveToRelative(0.48f, 0f, 0.9f, -0.35f, 0.98f, -0.83f);
        v12.curveToRelative(0.3f, -1.94f, 1.26f, -3.67f, 2.65f, -4.94f);
        v12.close();
        v12.moveTo(18.6f, 3.28f);
        v12.curveToRelative(-0.4f, -0.37f, -1.02f, -0.36f, -1.4f, 0.02f);
        v12.curveToRelative(-0.4f, 0.4f, -0.38f, 1.04f, 0.03f, 1.42f);
        v12.curveToRelative(1.38f, 1.27f, 2.35f, 3f, 2.65f, 4.94f);
        v12.curveToRelative(0.07f, 0.48f, 0.49f, 0.83f, 0.98f, 0.83f);
        v12.curveToRelative(0.61f, 0f, 1.09f, -0.55f, 0.99f, -1.16f);
        v12.curveToRelative(-0.38f, -2.37f, -1.55f, -4.48f, -3.25f, -6.05f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NotificationsActiveKt._notificationsActive = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

