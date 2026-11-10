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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_settings", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Settings", "Landroidx/compose/material/icons/Icons$Sharp;", "getSettings", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SettingsKt {
    private static ImageVector _settings;

    static {
    }

    public static final ImageVector getSettings(Sharp arg19) {
        ImageVector v0 = SettingsKt._settings;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Settings", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.440001f, 12.99f);
        v12.lineToRelative(-0.01f, 0.02f);
        v12.curveToRelative(0.04f, -0.33f, 0.08f, -0.67f, 0.08f, -1.01f);
        v12.curveToRelative(0f, -0.34f, -0.03f, -0.66f, -0.07f, -0.99f);
        v12.lineToRelative(0.01f, 0.02f);
        v12.lineToRelative(2.44f, -1.92f);
        v12.lineToRelative(-2.43f, -4.22f);
        v12.lineToRelative(-2.87f, 1.16f);
        v12.lineToRelative(0.01f, 0.01f);
        v12.curveToRelative(-0.52f, -0.4f, -1.09f, -0.74f, -1.71f, -1f);
        v12.horizontalLineToRelative(0.01f);
        v12.lineTo(14.44f, 2f);
        v12.horizontalLineTo(9.57f);
        v12.lineToRelative(-0.44f, 3.07f);
        v12.horizontalLineToRelative(0.01f);
        v12.curveToRelative(-0.62f, 0.26f, -1.19f, 0.6f, -1.71f, 1f);
        v12.lineToRelative(0.01f, -0.01f);
        v12.lineToRelative(-2.88f, -1.17f);
        v12.lineToRelative(-2.44f, 4.22f);
        v12.lineToRelative(2.44f, 1.92f);
        v12.lineToRelative(0.01f, -0.02f);
        v12.curveToRelative(-0.04f, 0.33f, -0.07f, 0.65f, -0.07f, 0.99f);
        v12.curveToRelative(0f, 0.34f, 0.03f, 0.68f, 0.08f, 1.01f);
        v12.lineToRelative(-0.01f, -0.02f);
        v12.lineToRelative(-2.1f, 1.65f);
        v12.lineToRelative(-0.33f, 0.26f);
        v12.lineToRelative(2.43f, 4.2f);
        v12.lineToRelative(2.88f, -1.15f);
        v12.lineToRelative(-0.02f, -0.04f);
        v12.curveToRelative(0.53f, 0.41f, 1.1f, 0.75f, 1.73f, 1.01f);
        v12.horizontalLineToRelative(-0.03f);
        v12.lineTo(9.58f, 22f);
        v12.horizontalLineToRelative(4.85f);
        v12.reflectiveCurveToRelative(0.03f, -0.18f, 0.06f, -0.42f);
        v12.lineToRelative(0.38f, -2.65f);
        v12.horizontalLineToRelative(-0.01f);
        v12.curveToRelative(0.62f, -0.26f, 1.2f, -0.6f, 1.73f, -1.01f);
        v12.lineToRelative(-0.02f, 0.04f);
        v12.lineToRelative(2.88f, 1.15f);
        v12.lineToRelative(2.43f, -4.2f);
        v12.reflectiveCurveToRelative(-0.14f, -0.12f, -0.33f, -0.26f);
        v12.lineToRelative(-2.11f, -1.66f);
        v12.close();
        v12.moveTo(12f, 15.5f);
        v12.curveToRelative(-1.93f, 0f, -3.5f, -1.57f, -3.5f, -3.5f);
        v12.reflectiveCurveToRelative(1.57f, -3.5f, 3.5f, -3.5f);
        v12.reflectiveCurveToRelative(3.5f, 1.57f, 3.5f, 3.5f);
        v12.reflectiveCurveToRelative(-1.57f, 3.5f, -3.5f, 3.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SettingsKt._settings = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

