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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_settings", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Settings", "Landroidx/compose/material/icons/Icons$Rounded;", "getSettings", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SettingsKt {
    private static ImageVector _settings;

    static {
    }

    public static final ImageVector getSettings(Rounded arg19) {
        ImageVector v0 = SettingsKt._settings;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Settings", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.5f, 12f);
        v12.curveToRelative(0f, -0.23f, -0.01f, -0.45f, -0.03f, -0.68f);
        v12.lineToRelative(1.86f, -1.41f);
        v12.curveToRelative(0.4f, -0.3f, 0.51f, -0.86f, 0.26f, -1.3f);
        v12.lineToRelative(-1.87f, -3.23f);
        v12.curveToRelative(-0.25f, -0.44f, -0.79f, -0.62f, -1.25f, -0.42f);
        v12.lineToRelative(-2.15f, 0.91f);
        v12.curveToRelative(-0.37f, -0.26f, -0.76f, -0.49f, -1.17f, -0.68f);
        v12.lineToRelative(-0.29f, -2.31f);
        v12.curveTo(14.8f, 2.38f, 14.37f, 2f, 13.87f, 2f);
        v12.horizontalLineToRelative(-3.73f);
        v12.curveTo(9.63f, 2f, 9.2f, 2.38f, 9.14f, 2.88f);
        v12.lineTo(8.85f, 5.19f);
        v12.curveToRelative(-0.41f, 0.19f, -0.8f, 0.42f, -1.17f, 0.68f);
        v12.lineTo(5.53f, 4.96f);
        v12.curveToRelative(-0.46f, -0.2f, -1f, -0.02f, -1.25f, 0.42f);
        v12.lineTo(2.41f, 8.62f);
        v12.curveToRelative(-0.25f, 0.44f, -0.14f, 0.99f, 0.26f, 1.3f);
        v12.lineToRelative(1.86f, 1.41f);
        v12.curveTo(4.51f, 11.55f, 4.5f, 11.77f, 4.5f, 12f);
        v12.reflectiveCurveToRelative(0.01f, 0.45f, 0.03f, 0.68f);
        v12.lineToRelative(-1.86f, 1.41f);
        v12.curveToRelative(-0.4f, 0.3f, -0.51f, 0.86f, -0.26f, 1.3f);
        v12.lineToRelative(1.87f, 3.23f);
        v12.curveToRelative(0.25f, 0.44f, 0.79f, 0.62f, 1.25f, 0.42f);
        v12.lineToRelative(2.15f, -0.91f);
        v12.curveToRelative(0.37f, 0.26f, 0.76f, 0.49f, 1.17f, 0.68f);
        v12.lineToRelative(0.29f, 2.31f);
        v12.curveTo(9.2f, 21.620001f, 9.63f, 22f, 10.13f, 22f);
        v12.horizontalLineToRelative(3.73f);
        v12.curveToRelative(0.5f, 0f, 0.93f, -0.38f, 0.99f, -0.88f);
        v12.lineToRelative(0.29f, -2.31f);
        v12.curveToRelative(0.41f, -0.19f, 0.8f, -0.42f, 1.17f, -0.68f);
        v12.lineToRelative(2.15f, 0.91f);
        v12.curveToRelative(0.46f, 0.2f, 1f, 0.02f, 1.25f, -0.42f);
        v12.lineToRelative(1.87f, -3.23f);
        v12.curveToRelative(0.25f, -0.44f, 0.14f, -0.99f, -0.26f, -1.3f);
        v12.lineToRelative(-1.86f, -1.41f);
        v12.curveTo(19.49f, 12.45f, 19.5f, 12.23f, 19.5f, 12f);
        v12.close();
        v12.moveTo(12.04f, 15.5f);
        v12.curveToRelative(-1.93f, 0f, -3.5f, -1.57f, -3.5f, -3.5f);
        v12.reflectiveCurveToRelative(1.57f, -3.5f, 3.5f, -3.5f);
        v12.reflectiveCurveToRelative(3.5f, 1.57f, 3.5f, 3.5f);
        v12.reflectiveCurveTo(13.97f, 15.5f, 12.04f, 15.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SettingsKt._settings = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

