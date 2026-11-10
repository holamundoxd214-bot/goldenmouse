package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector$Builder;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_adminPanelSettings", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AdminPanelSettings", "Landroidx/compose/material/icons/Icons$Outlined;", "getAdminPanelSettings", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AdminPanelSettingsKt {
    private static ImageVector _adminPanelSettings;

    static {
    }

    public static final ImageVector getAdminPanelSettings(Outlined arg20) {
        ImageVector v0 = AdminPanelSettingsKt._adminPanelSettings;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.AdminPanelSettings", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = PathFillType.Companion.getEvenOdd-Rg-k1Os();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17f, 15.5f);
        v12.moveToRelative(-1.12f, 0f);
        v12.arcToRelative(1.12f, 1.12f, 0f, true, true, 2.24f, 0f);
        v12.arcToRelative(1.12f, 1.12f, 0f, true, true, -2.24f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = PathFillType.Companion.getEvenOdd-Rg-k1Os();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(17f, 17.5f);
        v12.curveToRelative(-0.73f, 0f, -2.19f, 0.36f, -2.24f, 1.08f);
        v12.curveToRelative(0.5f, 0.71f, 1.32f, 1.17f, 2.24f, 1.17f);
        v12.reflectiveCurveToRelative(1.74f, -0.46f, 2.24f, -1.17f);
        v12.curveTo(19.190001f, 17.860001f, 17.73f, 17.5f, 17f, 17.5f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = PathFillType.Companion.getEvenOdd-Rg-k1Os();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(18f, 11.09f);
        v12.verticalLineTo(6.27f);
        v12.lineTo(10.5f, 3f);
        v12.lineTo(3f, 6.27f);
        v12.verticalLineToRelative(4.91f);
        v12.curveToRelative(0f, 4.54f, 3.2f, 8.79f, 7.5f, 9.82f);
        v12.curveToRelative(0.55f, -0.13f, 1.08f, -0.32f, 1.6f, -0.55f);
        v12.curveTo(13.18f, 21.99f, 14.97f, 23f, 17f, 23f);
        v12.curveToRelative(3.31f, 0f, 6f, -2.69f, 6f, -6f);
        v12.curveTo(23f, 14.03f, 20.84f, 11.57f, 18f, 11.09f);
        v12.close();
        v12.moveTo(11f, 17f);
        v12.curveToRelative(0f, 0.56f, 0.08f, 1.11f, 0.23f, 1.62f);
        v12.curveToRelative(-0.24f, 0.11f, -0.48f, 0.22f, -0.73f, 0.3f);
        v12.curveToRelative(-3.17f, -1f, -5.5f, -4.24f, -5.5f, -7.74f);
        v12.verticalLineToRelative(-3.6f);
        v12.lineToRelative(5.5f, -2.4f);
        v12.lineToRelative(5.5f, 2.4f);
        v12.verticalLineToRelative(3.51f);
        v12.curveTo(13.16f, 11.57f, 11f, 14.03f, 11f, 17f);
        v12.close();
        v12.moveTo(17f, 21f);
        v12.curveToRelative(-2.21f, 0f, -4f, -1.79f, -4f, -4f);
        v12.curveToRelative(0f, -2.21f, 1.79f, -4f, 4f, -4f);
        v12.reflectiveCurveToRelative(4f, 1.79f, 4f, 4f);
        v12.curveTo(21f, 19.209999f, 19.209999f, 21f, 17f, 21f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AdminPanelSettingsKt._adminPanelSettings = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

