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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_settings", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Settings", "Landroidx/compose/material/icons/Icons$Filled;", "getSettings", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SettingsKt {
    private static ImageVector _settings;

    static {
    }

    public static final ImageVector getSettings(Filled arg19) {
        ImageVector v0 = SettingsKt._settings;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Settings", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.139999f, 12.94f);
        v12.curveToRelative(0.04f, -0.3f, 0.06f, -0.61f, 0.06f, -0.94f);
        v12.curveToRelative(0f, -0.32f, -0.02f, -0.64f, -0.07f, -0.94f);
        v12.lineToRelative(2.03f, -1.58f);
        v12.curveToRelative(0.18f, -0.14f, 0.23f, -0.41f, 0.12f, -0.61f);
        v12.lineToRelative(-1.92f, -3.32f);
        v12.curveToRelative(-0.12f, -0.22f, -0.37f, -0.29f, -0.59f, -0.22f);
        v12.lineToRelative(-2.39f, 0.96f);
        v12.curveToRelative(-0.5f, -0.38f, -1.03f, -0.7f, -1.62f, -0.94f);
        v12.lineTo(14.4f, 2.81f);
        v12.curveToRelative(-0.04f, -0.24f, -0.24f, -0.41f, -0.48f, -0.41f);
        v12.horizontalLineToRelative(-3.84f);
        v12.curveToRelative(-0.24f, 0f, -0.43f, 0.17f, -0.47f, 0.41f);
        v12.lineTo(9.25f, 5.35f);
        v12.curveTo(8.66f, 5.59f, 8.12f, 5.92f, 7.63f, 6.29f);
        v12.lineTo(5.24f, 5.33f);
        v12.curveToRelative(-0.22f, -0.08f, -0.47f, 0f, -0.59f, 0.22f);
        v12.lineTo(2.74f, 8.87f);
        v12.curveTo(2.62f, 9.08f, 2.66f, 9.34f, 2.86f, 9.48f);
        v12.lineToRelative(2.03f, 1.58f);
        v12.curveTo(4.84f, 11.36f, 4.8f, 11.69f, 4.8f, 12f);
        v12.reflectiveCurveToRelative(0.02f, 0.64f, 0.07f, 0.94f);
        v12.lineToRelative(-2.03f, 1.58f);
        v12.curveToRelative(-0.18f, 0.14f, -0.23f, 0.41f, -0.12f, 0.61f);
        v12.lineToRelative(1.92f, 3.32f);
        v12.curveToRelative(0.12f, 0.22f, 0.37f, 0.29f, 0.59f, 0.22f);
        v12.lineToRelative(2.39f, -0.96f);
        v12.curveToRelative(0.5f, 0.38f, 1.03f, 0.7f, 1.62f, 0.94f);
        v12.lineToRelative(0.36f, 2.54f);
        v12.curveToRelative(0.05f, 0.24f, 0.24f, 0.41f, 0.48f, 0.41f);
        v12.horizontalLineToRelative(3.84f);
        v12.curveToRelative(0.24f, 0f, 0.44f, -0.17f, 0.47f, -0.41f);
        v12.lineToRelative(0.36f, -2.54f);
        v12.curveToRelative(0.59f, -0.24f, 1.13f, -0.56f, 1.62f, -0.94f);
        v12.lineToRelative(2.39f, 0.96f);
        v12.curveToRelative(0.22f, 0.08f, 0.47f, 0f, 0.59f, -0.22f);
        v12.lineToRelative(1.92f, -3.32f);
        v12.curveToRelative(0.12f, -0.22f, 0.07f, -0.47f, -0.12f, -0.61f);
        v12.lineTo(19.139999f, 12.94f);
        v12.close();
        v12.moveTo(12f, 15.6f);
        v12.curveToRelative(-1.98f, 0f, -3.6f, -1.62f, -3.6f, -3.6f);
        v12.reflectiveCurveToRelative(1.62f, -3.6f, 3.6f, -3.6f);
        v12.reflectiveCurveToRelative(3.6f, 1.62f, 3.6f, 3.6f);
        v12.reflectiveCurveTo(13.98f, 15.6f, 12f, 15.6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SettingsKt._settings = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

