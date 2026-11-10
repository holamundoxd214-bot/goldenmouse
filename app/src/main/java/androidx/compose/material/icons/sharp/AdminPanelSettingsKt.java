package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_adminPanelSettings", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AdminPanelSettings", "Landroidx/compose/material/icons/Icons$Sharp;", "getAdminPanelSettings", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AdminPanelSettingsKt {
    private static ImageVector _adminPanelSettings;

    static {
    }

    public static final ImageVector getAdminPanelSettings(Sharp arg19) {
        ImageVector v0 = AdminPanelSettingsKt._adminPanelSettings;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.AdminPanelSettings", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17f, 11f);
        v12.curveToRelative(0.34f, 0f, 0.67f, 0.04f, 1f, 0.09f);
        v12.verticalLineTo(6.27f);
        v12.lineTo(10.5f, 3f);
        v12.lineTo(3f, 6.27f);
        v12.verticalLineToRelative(4.91f);
        v12.curveToRelative(0f, 4.54f, 3.2f, 8.79f, 7.5f, 9.82f);
        v12.curveToRelative(0.55f, -0.13f, 1.08f, -0.32f, 1.6f, -0.55f);
        v12.curveTo(11.41f, 19.469999f, 11f, 18.280001f, 11f, 17f);
        v12.curveTo(11f, 13.69f, 13.69f, 11f, 17f, 11f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(17f, 13f);
        v12.curveToRelative(-2.21f, 0f, -4f, 1.79f, -4f, 4f);
        v12.curveToRelative(0f, 2.21f, 1.79f, 4f, 4f, 4f);
        v12.reflectiveCurveToRelative(4f, -1.79f, 4f, -4f);
        v12.curveTo(21f, 14.79f, 19.209999f, 13f, 17f, 13f);
        v12.close();
        v12.moveTo(17f, 14.38f);
        v12.curveToRelative(0.62f, 0f, 1.12f, 0.51f, 1.12f, 1.12f);
        v12.reflectiveCurveToRelative(-0.51f, 1.12f, -1.12f, 1.12f);
        v12.reflectiveCurveToRelative(-1.12f, -0.51f, -1.12f, -1.12f);
        v12.reflectiveCurveTo(16.379999f, 14.38f, 17f, 14.38f);
        v12.close();
        v12.moveTo(17f, 19.75f);
        v12.curveToRelative(-0.93f, 0f, -1.74f, -0.46f, -2.24f, -1.17f);
        v12.curveToRelative(0.05f, -0.72f, 1.51f, -1.08f, 2.24f, -1.08f);
        v12.reflectiveCurveToRelative(2.19f, 0.36f, 2.24f, 1.08f);
        v12.curveTo(18.74f, 19.290001f, 17.93f, 19.75f, 17f, 19.75f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AdminPanelSettingsKt._adminPanelSettings = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

