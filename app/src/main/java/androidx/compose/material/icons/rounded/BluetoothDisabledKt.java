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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_bluetoothDisabled", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BluetoothDisabled", "Landroidx/compose/material/icons/Icons$Rounded;", "getBluetoothDisabled", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BluetoothDisabledKt {
    private static ImageVector _bluetoothDisabled;

    static {
    }

    public static final ImageVector getBluetoothDisabled(Rounded arg19) {
        ImageVector v0 = BluetoothDisabledKt._bluetoothDisabled;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.BluetoothDisabled", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.290001f, 17.889999f);
        v12.lineTo(6.11f, 4.7f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineTo(10.59f, 12f);
        v12.lineTo(5.7f, 16.889999f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineTo(11f, 14.41f);
        v12.verticalLineToRelative(6.18f);
        v12.curveToRelative(0f, 0.89f, 1.08f, 1.34f, 1.71f, 0.71f);
        v12.lineToRelative(3.59f, -3.59f);
        v12.lineToRelative(1.59f, 1.59f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.curveToRelative(0.38f, -0.39f, 0.38f, -1.03f, -0.01f, -1.41f);
        v12.close();
        v12.moveTo(13f, 18.17f);
        v12.verticalLineToRelative(-3.76f);
        v12.lineToRelative(1.88f, 1.88f);
        v12.lineTo(13f, 18.17f);
        v12.close();
        v12.moveTo(13f, 5.83f);
        v12.lineToRelative(1.88f, 1.88f);
        v12.lineToRelative(-1.47f, 1.47f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineTo(17f, 8.42f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.42f);
        v12.lineToRelative(-4.29f, -4.29f);
        v12.curveToRelative(-0.63f, -0.63f, -1.71f, -0.19f, -1.71f, 0.7f);
        v12.verticalLineToRelative(3.36f);
        v12.lineToRelative(2f, 2f);
        v12.lineTo(13f, 5.83f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BluetoothDisabledKt._bluetoothDisabled = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

