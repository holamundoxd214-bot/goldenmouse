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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_settingsBackupRestore", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SettingsBackupRestore", "Landroidx/compose/material/icons/Icons$Rounded;", "getSettingsBackupRestore", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SettingsBackupRestoreKt {
    private static ImageVector _settingsBackupRestore;

    static {
    }

    public static final ImageVector getSettingsBackupRestore(Rounded arg19) {
        ImageVector v0 = SettingsBackupRestoreKt._settingsBackupRestore;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SettingsBackupRestore", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11.77f, 3f);
        v12.curveToRelative(-2.65f, 0.07f, -5f, 1.28f, -6.6f, 3.16f);
        v12.lineTo(3.85f, 4.85f);
        v12.curveTo(3.54f, 4.54f, 3f, 4.76f, 3f, 5.21f);
        v12.verticalLineTo(9.5f);
        v12.curveTo(3f, 9.78f, 3.22f, 10f, 3.5f, 10f);
        v12.horizontalLineToRelative(4.29f);
        v12.curveToRelative(0.45f, 0f, 0.67f, -0.54f, 0.35f, -0.85f);
        v12.lineTo(6.59f, 7.59f);
        v12.curveTo(7.88f, 6.02f, 9.82f, 5f, 12f, 5f);
        v12.curveToRelative(4.32f, 0f, 7.74f, 3.94f, 6.86f, 8.41f);
        v12.curveToRelative(-0.54f, 2.77f, -2.81f, 4.98f, -5.58f, 5.47f);
        v12.curveToRelative(-3.8f, 0.68f, -7.18f, -1.74f, -8.05f, -5.16f);
        v12.curveTo(5.11f, 13.3f, 4.71f, 13f, 4.27f, 13f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.65f, 0f, -1.14f, 0.61f, -0.98f, 1.23f);
        v12.curveTo(4.28f, 18.120001f, 7.8f, 21f, 12f, 21f);
        v12.curveToRelative(5.06f, 0f, 9.14f, -4.17f, 9f, -9.26f);
        v12.curveTo(20.860001f, 6.86f, 16.65f, 2.88f, 11.77f, 3f);
        v12.close();
        v12.moveTo(14f, 12f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveToRelative(0.9f, 2f, 2f, 2f);
        v12.reflectiveCurveTo(14f, 13.1f, 14f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SettingsBackupRestoreKt._settingsBackupRestore = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

