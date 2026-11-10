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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_editNotifications", "Landroidx/compose/ui/graphics/vector/ImageVector;", "EditNotifications", "Landroidx/compose/material/icons/Icons$Rounded;", "getEditNotifications", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class EditNotificationsKt {
    private static ImageVector _editNotifications;

    static {
    }

    public static final ImageVector getEditNotifications(Rounded arg19) {
        ImageVector v0 = EditNotificationsKt._editNotifications;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.EditNotifications", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17.58f, 6.25f);
        v12.lineToRelative(1.77f, 1.77f);
        v12.lineToRelative(-4.84f, 4.84f);
        v12.curveTo(14.42f, 12.95f, 14.29f, 13f, 14.16f, 13f);
        v12.horizontalLineTo(13.1f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f);
        v12.verticalLineToRelative(-1.06f);
        v12.curveToRelative(0f, -0.13f, 0.05f, -0.26f, 0.15f, -0.35f);
        v12.lineTo(17.58f, 6.25f);
        v12.close();
        v12.moveTo(20.85f, 5.81f);
        v12.lineToRelative(-1.06f, -1.06f);
        v12.curveToRelative(-0.2f, -0.2f, -0.51f, -0.2f, -0.71f, 0f);
        v12.lineToRelative(-0.85f, 0.85f);
        v12.lineToRelative(1.77f, 1.77f);
        v12.lineToRelative(0.85f, -0.85f);
        v12.curveTo(21.049999f, 6.32f, 21.049999f, 6f, 20.85f, 5.81f);
        v12.close();
        v12.moveTo(20f, 18f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineTo(5f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(-7f);
        v12.curveToRelative(0f, -2.79f, 1.91f, -5.14f, 4.5f, -5.8f);
        v12.verticalLineTo(3.5f);
        v12.curveTo(10.5f, 2.67f, 11.17f, 2f, 12f, 2f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.verticalLineToRelative(0.7f);
        v12.curveToRelative(0.82f, 0.21f, 1.57f, 0.59f, 2.21f, 1.09f);
        v12.lineToRelative(-4.52f, 4.52f);
        v12.curveToRelative(-0.38f, 0.38f, -0.59f, 0.88f, -0.59f, 1.41f);
        v12.verticalLineTo(13f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(1.77f);
        v12.curveToRelative(0.53f, 0f, 1.04f, -0.21f, 1.41f, -0.59f);
        v12.lineTo(18f, 12.2f);
        v12.verticalLineTo(17f);
        v12.horizontalLineToRelative(1f);
        v12.curveTo(19.549999f, 17f, 20f, 17.450001f, 20f, 18f);
        v12.close();
        v12.moveTo(10f, 20f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveTo(10f, 21.1f, 10f, 20f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        EditNotificationsKt._editNotifications = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

