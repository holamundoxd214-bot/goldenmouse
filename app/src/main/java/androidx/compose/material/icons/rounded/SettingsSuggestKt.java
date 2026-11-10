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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_settingsSuggest", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SettingsSuggest", "Landroidx/compose/material/icons/Icons$Rounded;", "getSettingsSuggest", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SettingsSuggestKt {
    private static ImageVector _settingsSuggest;

    static {
    }

    public static final ImageVector getSettingsSuggest(Rounded arg19) {
        ImageVector v0 = SettingsSuggestKt._settingsSuggest;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SettingsSuggest", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.040001f, 7.99f);
        v12.lineToRelative(-0.63f, -1.4f);
        v12.lineToRelative(-1.4f, -0.63f);
        v12.curveToRelative(-0.39f, -0.18f, -0.39f, -0.73f, 0f, -0.91f);
        v12.lineToRelative(1.4f, -0.63f);
        v12.lineToRelative(0.63f, -1.4f);
        v12.curveToRelative(0.18f, -0.39f, 0.73f, -0.39f, 0.91f, 0f);
        v12.lineToRelative(0.63f, 1.4f);
        v12.lineToRelative(1.4f, 0.63f);
        v12.curveToRelative(0.39f, 0.18f, 0.39f, 0.73f, 0f, 0.91f);
        v12.lineToRelative(-1.4f, 0.63f);
        v12.lineToRelative(-0.63f, 1.4f);
        v12.curveTo(18.780001f, 8.38f, 18.219999f, 8.38f, 18.040001f, 7.99f);
        v12.close();
        v12.moveTo(21.280001f, 12.72f);
        v12.lineTo(20.959999f, 12f);
        v12.curveToRelative(-0.18f, -0.39f, -0.73f, -0.39f, -0.91f, 0f);
        v12.lineToRelative(-0.32f, 0.72f);
        v12.lineTo(19f, 13.04f);
        v12.curveToRelative(-0.39f, 0.18f, -0.39f, 0.73f, 0f, 0.91f);
        v12.lineToRelative(0.72f, 0.32f);
        v12.lineTo(20.040001f, 15f);
        v12.curveToRelative(0.18f, 0.39f, 0.73f, 0.39f, 0.91f, 0f);
        v12.lineToRelative(0.32f, -0.72f);
        v12.lineTo(22f, 13.96f);
        v12.curveToRelative(0.39f, -0.18f, 0.39f, -0.73f, 0f, -0.91f);
        v12.lineTo(21.280001f, 12.72f);
        v12.close();
        v12.moveTo(16.24f, 14.37f);
        v12.lineToRelative(1.23f, 0.93f);
        v12.curveToRelative(0.4f, 0.3f, 0.51f, 0.86f, 0.26f, 1.3f);
        v12.lineToRelative(-1.62f, 2.8f);
        v12.curveToRelative(-0.25f, 0.44f, -0.79f, 0.62f, -1.25f, 0.42f);
        v12.lineToRelative(-1.43f, -0.6f);
        v12.curveToRelative(-0.2f, 0.13f, -0.42f, 0.26f, -0.64f, 0.37f);
        v12.lineToRelative(-0.19f, 1.54f);
        v12.curveToRelative(-0.06f, 0.5f, -0.49f, 0.88f, -0.99f, 0.88f);
        v12.horizontalLineTo(8.38f);
        v12.curveToRelative(-0.5f, 0f, -0.93f, -0.38f, -0.99f, -0.88f);
        v12.lineTo(7.2f, 19.59f);
        v12.curveToRelative(-0.22f, -0.11f, -0.43f, -0.23f, -0.64f, -0.37f);
        v12.lineToRelative(-1.43f, 0.6f);
        v12.curveToRelative(-0.46f, 0.2f, -1f, 0.02f, -1.25f, -0.42f);
        v12.lineToRelative(-1.62f, -2.8f);
        v12.curveToRelative(-0.25f, -0.44f, -0.14f, -0.99f, 0.26f, -1.3f);
        v12.lineToRelative(1.23f, -0.93f);
        v12.curveTo(3.75f, 14.25f, 3.75f, 14.12f, 3.75f, 14f);
        v12.reflectiveCurveToRelative(0f, -0.25f, 0.01f, -0.37f);
        v12.lineTo(2.53f, 12.7f);
        v12.curveToRelative(-0.4f, -0.3f, -0.51f, -0.86f, -0.26f, -1.3f);
        v12.lineToRelative(1.62f, -2.8f);
        v12.curveToRelative(0.25f, -0.44f, 0.79f, -0.62f, 1.25f, -0.42f);
        v12.lineToRelative(1.43f, 0.6f);
        v12.curveToRelative(0.2f, -0.13f, 0.42f, -0.26f, 0.64f, -0.37f);
        v12.lineToRelative(0.19f, -1.54f);
        v12.curveTo(7.45f, 6.38f, 7.88f, 6f, 8.38f, 6f);
        v12.horizontalLineToRelative(3.23f);
        v12.curveToRelative(0.5f, 0f, 0.93f, 0.38f, 0.99f, 0.88f);
        v12.lineToRelative(0.19f, 1.54f);
        v12.curveToRelative(0.22f, 0.11f, 0.43f, 0.23f, 0.64f, 0.37f);
        v12.lineToRelative(1.43f, -0.6f);
        v12.curveToRelative(0.46f, -0.2f, 1f, -0.02f, 1.25f, 0.42f);
        v12.lineToRelative(1.62f, 2.8f);
        v12.curveToRelative(0.25f, 0.44f, 0.14f, 0.99f, -0.26f, 1.3f);
        v12.lineToRelative(-1.23f, 0.93f);
        v12.curveToRelative(0.01f, 0.12f, 0.01f, 0.24f, 0.01f, 0.37f);
        v12.reflectiveCurveTo(16.25f, 14.25f, 16.24f, 14.37f);
        v12.close();
        v12.moveTo(13f, 14f);
        v12.curveToRelative(0f, -1.66f, -1.34f, -3f, -3f, -3f);
        v12.reflectiveCurveToRelative(-3f, 1.34f, -3f, 3f);
        v12.reflectiveCurveToRelative(1.34f, 3f, 3f, 3f);
        v12.reflectiveCurveTo(13f, 15.66f, 13f, 14f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SettingsSuggestKt._settingsSuggest = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

