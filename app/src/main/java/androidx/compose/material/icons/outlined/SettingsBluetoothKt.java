package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_settingsBluetooth", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SettingsBluetooth", "Landroidx/compose/material/icons/Icons$Outlined;", "getSettingsBluetooth", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SettingsBluetoothKt {
    private static ImageVector _settingsBluetooth;

    static {
    }

    public static final ImageVector getSettingsBluetooth(Outlined arg18) {
        ImageVector v0 = SettingsBluetoothKt._settingsBluetooth;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.SettingsBluetooth", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v2 = new PathBuilder();
        v2.moveTo(11f, 24f);
        v2.horizontalLineToRelative(2f);
        v2.verticalLineToRelative(-2f);
        v2.horizontalLineToRelative(-2f);
        v2.verticalLineToRelative(2f);
        v2.close();
        v2.moveTo(7f, 24f);
        v2.horizontalLineToRelative(2f);
        v2.verticalLineToRelative(-2f);
        v2.lineTo(7f, 22f);
        v2.verticalLineToRelative(2f);
        v2.close();
        v2.moveTo(15f, 24f);
        v2.horizontalLineToRelative(2f);
        v2.verticalLineToRelative(-2f);
        v2.horizontalLineToRelative(-2f);
        v2.verticalLineToRelative(2f);
        v2.close();
        v2.moveTo(17.709999f, 5.71f);
        v2.lineTo(12f, 0f);
        v2.horizontalLineToRelative(-1f);
        v2.verticalLineToRelative(7.59f);
        v2.lineTo(6.41f, 3f);
        v2.lineTo(5f, 4.41f);
        v2.lineTo(10.59f, 10f);
        v2.lineTo(5f, 15.59f);
        v2.lineTo(6.41f, 17f);
        v2.lineTo(11f, 12.41f);
        v2.lineTo(11f, 20f);
        v2.horizontalLineToRelative(1f);
        v2.lineToRelative(5.71f, -5.71f);
        v2.lineToRelative(-4.3f, -4.29f);
        v2.lineToRelative(4.3f, -4.29f);
        v2.close();
        v2.moveTo(13f, 3.83f);
        v2.lineToRelative(1.88f, 1.88f);
        v2.lineTo(13f, 7.59f);
        v2.lineTo(13f, 3.83f);
        v2.close();
        v2.moveTo(14.88f, 14.29f);
        v2.lineTo(13f, 16.17f);
        v2.verticalLineToRelative(-3.76f);
        v2.lineToRelative(1.88f, 1.88f);
        v2.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v2.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SettingsBluetoothKt._settingsBluetooth = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

