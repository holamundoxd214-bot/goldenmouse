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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_settingsRemote", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SettingsRemote", "Landroidx/compose/material/icons/Icons$Sharp;", "getSettingsRemote", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SettingsRemoteKt {
    private static ImageVector _settingsRemote;

    static {
    }

    public static final ImageVector getSettingsRemote(Sharp arg19) {
        ImageVector v0 = SettingsRemoteKt._settingsRemote;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.SettingsRemote", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16f, 9f);
        v12.lineTo(8f, 9f);
        v12.verticalLineToRelative(14f);
        v12.horizontalLineToRelative(8f);
        v12.lineTo(16f, 9f);
        v12.close();
        v12.moveTo(12f, 15f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.reflectiveCurveToRelative(0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.9f, 2f, 2f);
        v12.reflectiveCurveToRelative(-0.9f, 2f, -2f, 2f);
        v12.close();
        v12.moveTo(7.05f, 6.05f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.curveTo(9.37f, 6.56f, 10.62f, 6f, 12f, 6f);
        v12.reflectiveCurveToRelative(2.63f, 0.56f, 3.54f, 1.46f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.curveTo(15.68f, 4.78f, 13.93f, 4f, 12f, 4f);
        v12.reflectiveCurveToRelative(-3.68f, 0.78f, -4.95f, 2.05f);
        v12.close();
        v12.moveTo(12f, 0f);
        v12.curveTo(8.96f, 0f, 6.21f, 1.23f, 4.22f, 3.22f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.curveTo(7.26f, 3.01f, 9.51f, 2f, 12f, 2f);
        v12.reflectiveCurveToRelative(4.74f, 1.01f, 6.36f, 2.64f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.curveTo(17.790001f, 1.23f, 15.04f, 0f, 12f, 0f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SettingsRemoteKt._settingsRemote = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

