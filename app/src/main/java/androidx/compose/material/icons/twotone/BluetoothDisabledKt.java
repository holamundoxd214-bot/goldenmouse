package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_bluetoothDisabled", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BluetoothDisabled", "Landroidx/compose/material/icons/Icons$TwoTone;", "getBluetoothDisabled", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BluetoothDisabledKt {
    private static ImageVector _bluetoothDisabled;

    static {
    }

    public static final ImageVector getBluetoothDisabled(TwoTone arg18) {
        ImageVector v0 = BluetoothDisabledKt._bluetoothDisabled;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.BluetoothDisabled", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(13f, 5.83f);
        v0_1.lineToRelative(1.88f, 1.88f);
        v0_1.lineToRelative(-1.6f, 1.6f);
        v0_1.lineToRelative(1.41f, 1.41f);
        v0_1.lineToRelative(3.02f, -3.02f);
        v0_1.lineTo(12f, 2f);
        v0_1.horizontalLineToRelative(-1f);
        v0_1.verticalLineToRelative(5.03f);
        v0_1.lineToRelative(2f, 2f);
        v0_1.verticalLineToRelative(-3.2f);
        v0_1.close();
        v0_1.moveTo(5.41f, 4f);
        v0_1.lineTo(4f, 5.41f);
        v0_1.lineTo(10.59f, 12f);
        v0_1.lineTo(5f, 17.59f);
        v0_1.lineTo(6.41f, 19f);
        v0_1.lineTo(11f, 14.41f);
        v0_1.verticalLineTo(22f);
        v0_1.horizontalLineToRelative(1f);
        v0_1.lineToRelative(4.29f, -4.29f);
        v0_1.lineToRelative(2.3f, 2.29f);
        v0_1.lineTo(20f, 18.59f);
        v0_1.lineTo(5.41f, 4f);
        v0_1.close();
        v0_1.moveTo(13f, 18.17f);
        v0_1.verticalLineToRelative(-3.76f);
        v0_1.lineToRelative(1.88f, 1.88f);
        v0_1.lineTo(13f, 18.17f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BluetoothDisabledKt._bluetoothDisabled = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

