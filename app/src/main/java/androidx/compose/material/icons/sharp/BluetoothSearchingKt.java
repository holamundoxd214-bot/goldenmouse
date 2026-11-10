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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_bluetoothSearching", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BluetoothSearching", "Landroidx/compose/material/icons/Icons$Sharp;", "getBluetoothSearching$annotations", "(Landroidx/compose/material/icons/Icons$Sharp;)V", "getBluetoothSearching", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BluetoothSearchingKt {
    private static ImageVector _bluetoothSearching;

    static {
    }

    public static final ImageVector getBluetoothSearching(Sharp arg19) {
        ImageVector v0 = BluetoothSearchingKt._bluetoothSearching;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.BluetoothSearching", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14.24f, 12.01f);
        v12.lineToRelative(2.32f, 2.32f);
        v12.curveToRelative(0.28f, -0.72f, 0.44f, -1.51f, 0.44f, -2.33f);
        v12.reflectiveCurveToRelative(-0.16f, -1.59f, -0.43f, -2.31f);
        v12.lineToRelative(-2.33f, 2.32f);
        v12.close();
        v12.moveTo(19.530001f, 6.71f);
        v12.lineToRelative(-1.26f, 1.26f);
        v12.curveToRelative(0.63f, 1.21f, 0.98f, 2.57f, 0.98f, 4.02f);
        v12.reflectiveCurveToRelative(-0.36f, 2.82f, -0.98f, 4.02f);
        v12.lineToRelative(1.2f, 1.2f);
        v12.curveToRelative(0.97f, -1.54f, 1.54f, -3.36f, 1.54f, -5.31f);
        v12.curveToRelative(-0.01f, -1.89f, -0.55f, -3.67f, -1.48f, -5.19f);
        v12.close();
        v12.moveTo(15.71f, 7.71f);
        v12.lineTo(10f, 2f);
        v12.lineTo(9f, 2f);
        v12.verticalLineToRelative(7.59f);
        v12.lineTo(4.41f, 5f);
        v12.lineTo(3f, 6.41f);
        v12.lineTo(8.59f, 12f);
        v12.lineTo(3f, 17.59f);
        v12.lineTo(4.41f, 19f);
        v12.lineTo(9f, 14.41f);
        v12.lineTo(9f, 22f);
        v12.horizontalLineToRelative(1f);
        v12.lineToRelative(5.71f, -5.71f);
        v12.lineToRelative(-4.3f, -4.29f);
        v12.lineToRelative(4.3f, -4.29f);
        v12.close();
        v12.moveTo(11f, 5.83f);
        v12.lineToRelative(1.88f, 1.88f);
        v12.lineTo(11f, 9.59f);
        v12.lineTo(11f, 5.83f);
        v12.close();
        v12.moveTo(12.88f, 16.290001f);
        v12.lineTo(11f, 18.17f);
        v12.verticalLineToRelative(-3.76f);
        v12.lineToRelative(1.88f, 1.88f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BluetoothSearchingKt._bluetoothSearching = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Sharp.BluetoothSearching", replaceWith="<_subannotation>") public static void getBluetoothSearching$annotations(Sharp arg0) {
    }
}

