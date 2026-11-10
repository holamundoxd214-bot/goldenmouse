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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_settingsApplications", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SettingsApplications", "Landroidx/compose/material/icons/Icons$Rounded;", "getSettingsApplications", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SettingsApplicationsKt {
    private static ImageVector _settingsApplications;

    static {
    }

    public static final ImageVector getSettingsApplications(Rounded arg20) {
        ImageVector v0 = SettingsApplicationsKt._settingsApplications;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SettingsApplications", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 12f);
        v12.moveToRelative(-2f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, 4f, 0f);
        v12.arcToRelative(2f, 2f, 0f, true, true, -4f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(19f, 3f);
        v12.horizontalLineTo(5f);
        v12.curveTo(3.89f, 3f, 3f, 3.9f, 3f, 5f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.89f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(1.11f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(5f);
        v12.curveTo(21f, 3.9f, 20.110001f, 3f, 19f, 3f);
        v12.close();
        v12.moveTo(15.75f, 12f);
        v12.curveToRelative(0f, 0.22f, -0.03f, 0.42f, -0.06f, 0.63f);
        v12.lineToRelative(0.84f, 0.73f);
        v12.curveToRelative(0.18f, 0.16f, 0.22f, 0.42f, 0.1f, 0.63f);
        v12.lineToRelative(-0.59f, 1.02f);
        v12.curveToRelative(-0.12f, 0.21f, -0.37f, 0.3f, -0.59f, 0.22f);
        v12.lineToRelative(-1.06f, -0.36f);
        v12.curveToRelative(-0.32f, 0.27f, -0.68f, 0.48f, -1.08f, 0.63f);
        v12.lineToRelative(-0.22f, 1.09f);
        v12.curveToRelative(-0.05f, 0.23f, -0.25f, 0.4f, -0.49f, 0.4f);
        v12.horizontalLineToRelative(-1.18f);
        v12.curveToRelative(-0.24f, 0f, -0.44f, -0.17f, -0.49f, -0.4f);
        v12.lineToRelative(-0.22f, -1.09f);
        v12.curveToRelative(-0.4f, -0.15f, -0.76f, -0.36f, -1.08f, -0.63f);
        v12.lineToRelative(-1.06f, 0.36f);
        v12.curveToRelative(-0.23f, 0.08f, -0.47f, -0.02f, -0.59f, -0.22f);
        v12.lineToRelative(-0.59f, -1.02f);
        v12.curveToRelative(-0.12f, -0.21f, -0.08f, -0.47f, 0.1f, -0.63f);
        v12.lineToRelative(0.84f, -0.73f);
        v12.curveTo(8.28f, 12.42f, 8.25f, 12.22f, 8.25f, 12f);
        v12.reflectiveCurveToRelative(0.03f, -0.42f, 0.06f, -0.63f);
        v12.lineToRelative(-0.84f, -0.73f);
        v12.curveToRelative(-0.18f, -0.16f, -0.22f, -0.42f, -0.1f, -0.63f);
        v12.lineToRelative(0.59f, -1.02f);
        v12.curveToRelative(0.12f, -0.21f, 0.37f, -0.3f, 0.59f, -0.22f);
        v12.lineToRelative(1.06f, 0.36f);
        v12.curveToRelative(0.32f, -0.27f, 0.68f, -0.48f, 1.08f, -0.63f);
        v12.lineToRelative(0.22f, -1.09f);
        v12.curveTo(10.97f, 7.17f, 11.17f, 7f, 11.41f, 7f);
        v12.horizontalLineToRelative(1.18f);
        v12.curveToRelative(0.24f, 0f, 0.44f, 0.17f, 0.49f, 0.4f);
        v12.lineToRelative(0.22f, 1.09f);
        v12.curveToRelative(0.4f, 0.15f, 0.76f, 0.36f, 1.08f, 0.63f);
        v12.lineToRelative(1.06f, -0.36f);
        v12.curveToRelative(0.23f, -0.08f, 0.47f, 0.02f, 0.59f, 0.22f);
        v12.lineToRelative(0.59f, 1.02f);
        v12.curveToRelative(0.12f, 0.21f, 0.08f, 0.47f, -0.1f, 0.63f);
        v12.lineToRelative(-0.84f, 0.73f);
        v12.curveTo(15.72f, 11.58f, 15.75f, 11.78f, 15.75f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SettingsApplicationsKt._settingsApplications = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

